package com.sx.icecap.web.command.resource.datastructure.builder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
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
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataStructureLocalService;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATA_STRUCTURE_BUILDER,
	        "mvc.command.name="+MVCCommand.RESOURCE_LOAD_DATA_STRUCTURE
	    },
	    service = MVCResourceCommand.class
)
public class LoadDataStructureResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, WebKey.DATATYPE_ID, 0);
		long dataStructureId = ParamUtil.getLong(resourceRequest, WebKey.DATASTRUCTURE_ID, 0);
		
		System.out.println("LoadDataTypeResourceCommand:  " + dataTypeId + ", " + dataStructureId);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		JSONObject result = null;
		
		if( dataStructureId > 0) {
			DataStructure dataStructure = _dataStructureLocalService.getDataStructure(dataStructureId);
			result = dataStructure.toJSON();
		}
		else if( dataTypeId > 0 ) {
			DataType dataType = _dataTypeLocalService.getDataType(dataTypeId);
			
			result = JSONFactoryUtil.createJSONObject();
			result.put("dataStructureId", 0);
			result.put("paramName", dataType.getDataTypeName());
			result.put("paramVersion", "1.0.0");
			
			Map<Locale, String> displayNameMap = dataType.getDisplayNameMap();
			JSONObject displayName = JSONFactoryUtil.createJSONObject();
			for (Map.Entry<Locale, String> entry : displayNameMap.entrySet()) {
				displayName.put(entry.getKey().toLanguageTag(), entry.getValue());
	        }
			result.put("displayName", displayName);
			
			JSONObject definition = JSONFactoryUtil.createJSONObject();
			Map<Locale, String> descriptionMap = dataType.getDescriptionMap();
			for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
				definition.put(entry.getKey().toLanguageTag(), entry.getValue());
			}
			result.put("definition", definition);
		}
		else {
			result = JSONFactoryUtil.createJSONObject();
		}
		
		System.out.println("Result: " + result.toJSONString());
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(result.toJSONString());
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataStructureLocalService _dataStructureLocalService;
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
