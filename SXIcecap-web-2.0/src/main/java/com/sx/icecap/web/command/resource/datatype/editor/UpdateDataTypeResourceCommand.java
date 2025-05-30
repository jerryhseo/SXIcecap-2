package com.sx.icecap.web.command.resource.datatype.editor;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.exception.DuplicatedDataTypeNameException;
import com.sx.icecap.exception.InvalidDataTypeNameException;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.util.SXLocalizationUtil;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
	        "mvc.command.name="+MVCCommand.RESOURCE_UPDATE_DATATYPE
	    },
	    service = MVCResourceCommand.class
)
public class UpdateDataTypeResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("UpdateDataTypeResourceCommand");
		long dataTypeId = ParamUtil.getLong(resourceRequest, DataTypeProperty.DATATYPE_ID, 0);
		String strFormData = ParamUtil.getString(resourceRequest, "formData", "{}");
		JSONObject jsonDataType = JSONFactoryUtil.createJSONObject(strFormData);
		System.out.println("JSON DataType: " + jsonDataType.toJSONString());
		
		String name = jsonDataType.getString(DataTypeProperty.DATATYPE_NAME);
		String version = jsonDataType.getString(DataTypeProperty.DATATYPE_VERSION);
		String extension = jsonDataType.getString(DataTypeProperty.EXTENSION);
		JSONObject displayName =jsonDataType.getJSONObject((DataTypeProperty.DISPLAY_NAME));
		JSONObject description =jsonDataType.getJSONObject((DataTypeProperty.DESCRIPTION));
		JSONObject tooltip =jsonDataType.getJSONObject((DataTypeProperty.TOOLTIP));
		//JSONObject visualizers =jsonDataType.getJSONObject((DataTypeProperty.VISUALIZERS));
		String visualizers =jsonDataType.getString((DataTypeProperty.VISUALIZERS));
		
		PrintWriter pw = resourceResponse.getWriter();
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext sc = ServiceContextFactory.getInstance(DataType.class.getName(), resourceRequest);
			
			DataType dataType =_dataTypeLocalService.updateDataType(
					dataTypeId,
					name, 
					version, 
					extension, 
					SXLocalizationUtil.jsonToLocalizedMap(displayName), 
					SXLocalizationUtil.jsonToLocalizedMap(description), 
					SXLocalizationUtil.jsonToLocalizedMap(tooltip), 
					visualizers, 
					WorkflowConstants.STATUS_APPROVED,
					sc
			);
			
			result.put("dataTypeId", dataType.getDataTypeId());
			result.put("error", 0);
		} catch( DuplicatedDataTypeNameException e ) {
			result.put("error", 1);
			result.put("message", "Duplicated data type name: " + name);
		} catch( InvalidDataTypeNameException e ) {
			result.put("error", 1);
			result.put("message", "Invalid data type name: " + name);
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
}
