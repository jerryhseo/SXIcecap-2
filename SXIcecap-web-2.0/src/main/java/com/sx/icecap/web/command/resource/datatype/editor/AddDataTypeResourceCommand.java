package com.sx.icecap.web.command.resource.datatype.editor;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.ServiceContextUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.exception.DuplicatedDataTypeNameException;
import com.sx.icecap.exception.InvalidDataTypeNameException;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.TypeStructureLink;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.TypeStructureLinkLocalService;
import com.sx.icecap.service.TypeVisualizerLinkLocalService;
import com.sx.util.SXLocalizationUtil;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
	        "mvc.command.name="+MVCCommand.RESOURCE_ADD_DATATYPE
	    },
	    service = MVCResourceCommand.class
)
public class AddDataTypeResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("AddDataTypeResourceCommand");
		//long dataTypeId = ParamUtil.getLong(resourceRequest, IcecapWebKeys.DATATYPE_ID, 0);
		String strFormData = ParamUtil.getString(resourceRequest, "formData", "{}");
		JSONObject jsonDataType = JSONFactoryUtil.createJSONObject(strFormData);
		System.out.println("JSON DataType: " + jsonDataType.toJSONString());
		
		String name = jsonDataType.getString(DataTypeProperties.DATATYPE_NAME);
		String version = jsonDataType.getString(DataTypeProperties.DATATYPE_VERSION);
		String extension = jsonDataType.getString(DataTypeProperties.EXTENSION);
		JSONObject displayName =jsonDataType.getJSONObject((DataTypeProperties.DISPLAY_NAME));
		JSONObject description =jsonDataType.getJSONObject((DataTypeProperties.DESCRIPTION));
		JSONObject tooltip =jsonDataType.getJSONObject((DataTypeProperties.TOOLTIP));
		
		long dataStructureId =jsonDataType.getLong((DataTypeProperties.DATA_STRUCTURE_ID));
		boolean commentable = jsonDataType.getBoolean("commentable");
		boolean verifiable = jsonDataType.getBoolean("verifiable");
		boolean freezable = jsonDataType.getBoolean("freezable");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		boolean freezed = jsonDataType.getBoolean("freezed");
		long freezedUserId = 0;
		if(freezed) {
			freezedUserId = themeDisplay.getUserId();
		}
		boolean verified = jsonDataType.getBoolean("verified");
		long verifiedUserId = 0;
		if(verified) {
			verifiedUserId = themeDisplay.getUserId();
		}
		
		PrintWriter pw = resourceResponse.getWriter();
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		try {
			ServiceContext sc = ServiceContextFactory.getInstance(DataType.class.getName(), resourceRequest);
			
			DataType dataType =_dataTypeLocalService.addDataType(
					name, 
					version, 
					extension, 
					SXLocalizationUtil.jsonToLocalizedMap(displayName), 
					SXLocalizationUtil.jsonToLocalizedMap(description), 
					SXLocalizationUtil.jsonToLocalizedMap(tooltip), 
					dataStructureId,
					WorkflowConstants.STATUS_APPROVED,
					sc
			);
			
			if( dataStructureId > 0 ) {
				TypeStructureLink structureLink = _typeStructureLinkLocalService.addTypeDataStructureLink(
								dataType.getDataTypeId(), 
								dataStructureId, 
								commentable, 
								verifiable, 
								freezable, 
								verified, 
								verifiedUserId, 
								freezed, 
								freezedUserId);
			}
			
			JSONArray visualizers =jsonDataType.getJSONArray("visualizers");
			for(int i=0; i<visualizers.length(); i++) {
				JSONObject visualizer = visualizers.getJSONObject(i);
				
				_typeVisualizerLinkLocalService.addTypeVisualizerLink(dataType.getDataTypeId(), visualizer.getLong("id"));
			}
			
			result.put("dataTypeId", dataType.getDataTypeId());
			result.put("error", 0);
		} catch( DuplicatedDataTypeNameException e ) {
			result.put("error", 1);
			result.put("message", "Duplicated data type name: " + name);
		} catch( PortalException e) {
			result.put("error", 1);
			result.put("message", e.getMessage());
		} finally {
			pw.write(result.toJSONString());
			
			pw.flush();
			pw.close();
		}
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private TypeStructureLinkLocalService _typeStructureLinkLocalService;
	
	@Reference
	private TypeVisualizerLinkLocalService _typeVisualizerLinkLocalService;
}
