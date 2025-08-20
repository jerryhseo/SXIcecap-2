package com.sx.icecap.web.command.resource.datatype.explorer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.constant.MVCCommand;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.security.permission.resource.datatype.DataTypeModelPermissionHelper;
import com.sx.icecap.security.permission.resource.datatype.DataTypeResourcePermissionHelper;
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
		String orderCol = ParamUtil.getString(resourceRequest, StationXWebKeys.ORDER_BY_COL, DataTypeProperties.DATATYPE_NAME);
		String orderType = ParamUtil.getString(resourceRequest, StationXWebKeys.ORDER_BY_TYPE, StationXConstants.ASC);
		String keywords = ParamUtil.getString(resourceRequest, StationXWebKeys.KEYWORDS, "");
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		List<DataType> dataTypes = _dataTypeLocalService.getDataTypes(start, end);
		
		JSONArray jsonDataTypes = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		List<ResourceAction> resourceActions = _resouceActionLocalService.getResourceActions(Constant.ICECAP_RESOURCE_NAME);
		System.out.println("Model Actions: " + resourceActions);
		
		for(int i=0; i<dataTypes.size(); i++) {
			DataType dataType = dataTypes.get(i);
			JSONObject jsonDataType = dataType.toJSON(themeDisplay.getLocale());
			
			JSONArray permissions = JSONFactoryUtil.createJSONArray();
			for (ResourceAction resourceAction : resourceActions) {
				String actionId = resourceAction.getActionId();

				// Check if the user has the permission for the action
				boolean hasPermission = DataTypeModelPermissionHelper.contains(permissionChecker, dataType.getDataTypeId(), actionId);

				if (hasPermission) {
					permissions.put(actionId);
				}
			}
			
			jsonDataType.put("permissions", permissions);
			
			jsonDataTypes.put(jsonDataType);
		}
		result.put("dataTypes", jsonDataTypes);
		//result.put("dataTypes", JSONFactoryUtil.createJSONArray(dataTypes));
		
		
		
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(result.toJSONString());
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private ResourceActionLocalService _resouceActionLocalService;
}
