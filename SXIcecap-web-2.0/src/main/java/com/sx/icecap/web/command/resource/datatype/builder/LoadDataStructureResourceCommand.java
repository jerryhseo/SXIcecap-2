package com.sx.icecap.web.command.resource.datatype.builder;

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
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.PrintWriter;
import java.util.List;

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

		System.out.println("LoadDataTypeResourceCommand");
		long dataTypeId = ParamUtil.getLong(resourceRequest, WebKey.DATATYPE_ID, 0);
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		DataType dataType = _dataTypeLocalService.getDataType(dataTypeId );
		JSONObject jsonDataType = dataType.toJSON(themeDisplay.getLocale());
		result.put("dataType", jsonDataType); 
		
		if( dataType.getHasDataStructure() ) {
			String dataStructure = _dataTypeLocalService.getDataStructure(dataTypeId);
			JSONObject jsonDataStructure = JSONFactoryUtil.createJSONObject(dataStructure);
			result.put("dataStructure", jsonDataStructure);
		}
		
		System.out.println("Result: " + result.toJSONString());
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(result.toJSONString());
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
