package com.sx.icecap.web.command.resource.datatype.explorer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
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
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EXPLORER,
	        "mvc.command.name="+MVCCommand.RESOURCE_LOAD_DATATYPES
	    },
	    service = MVCResourceCommand.class
)
public class LoadDataTypesResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("LoadDataTypesResourceCommand");
		int start = ParamUtil.getInteger(resourceRequest, StationXWebKeys.START, StationXConstants.DEFAULT_START);
		int delta = ParamUtil.getInteger(resourceRequest, StationXWebKeys.DELTA, StationXConstants.DEFAULT_DELTA);
		int end = start + delta - 1;
		long groupId = ParamUtil.getLong(resourceRequest, StationXWebKeys.GROUP_ID, 0);
		long userId = ParamUtil.getLong(resourceRequest, StationXWebKeys.USER_ID, 0);
		int status = ParamUtil.getInteger(resourceRequest, StationXWebKeys.STATUS, WorkflowConstants.STATUS_APPROVED);
		String navigation = ParamUtil.getString(resourceRequest, StationXWebKeys.NAVIGATION, StationXConstants.NAVIGATION_MINE);
		String orderCol = ParamUtil.getString(resourceRequest, StationXWebKeys.ORDER_BY_COL, DataTypeProperty.DATATYPE_NAME);
		String orderType = ParamUtil.getString(resourceRequest, StationXWebKeys.ORDER_BY_TYPE, StationXConstants.ASC);
		String keywords = ParamUtil.getString(resourceRequest, StationXWebKeys.KEYWORDS, "");
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		List<DataType> dataTypes = _dataTypeLocalService.getDataTypes(start, end);
		
		JSONArray jsonDataTypes = JSONFactoryUtil.createJSONArray();
		
		for(int i=0; i<dataTypes.size(); i++) {
			DataType dataType = dataTypes.get(i);
			
			String strDataType = JSONFactoryUtil.looseSerialize(dataType);
			System.out.println("strDataType: " + strDataType);
			jsonDataTypes.put(JSONFactoryUtil.createJSONObject(strDataType));
		}
		result.put("dataTypes", jsonDataTypes);
		//result.put("dataTypes", JSONFactoryUtil.createJSONArray(dataTypes));
		
		//This is only for test while developing.
		// JSONArray availableVisualizers = _AppLocalService.getAllVisualizers();
		JSONArray availableVisualizers = JSONFactoryUtil.createJSONArray();
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 345678);
		item.put( "portletName", "com_sx_visualizer_ImageViewer");
		JSONObject displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Image Viewer");
		displayName.put("ko-KR", "이미지 뷰어");
		item.put( "displayName", displayName);
		
		availableVisualizers.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 456789);
		item.put( "portletName", "com_sx_visualizer_TextEditor");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Text Editor");
		displayName.put("ko-KR", "텍스트 편집기");
		item.put( "displayName", displayName);
		
		availableVisualizers.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 567890);
		item.put( "portletName", "com_sx_visualizer_ImageEditor");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Image Editor");
		displayName.put("ko-KR", "이미지 편집기");
		item.put( "displayName", displayName);
		
		availableVisualizers.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 123456);
		item.put( "portletName", "com_sx_visualizer_TextViewer");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Text Viewer");
		displayName.put("ko-KR", "텍스트 뷰어");
		item.put( "displayName", displayName);
		
		availableVisualizers.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 234567);
		item.put( "portletName", "com_sx_visualizer_StructuredDataEditor");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Structured Data Editor");
		displayName.put("ko-KR", "구조데이터 편집기");
		item.put( "displayName", displayName);
		availableVisualizers.put(item);
		
		result.put("availableVisualizers", availableVisualizers);
		
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(result.toJSONString());
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
