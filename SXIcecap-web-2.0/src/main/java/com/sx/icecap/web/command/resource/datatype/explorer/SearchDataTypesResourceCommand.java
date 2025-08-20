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
import com.sx.icecap.constant.IcecapModelNames;
import com.sx.icecap.constant.MVCCommand;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.security.permission.resource.datatype.DataTypeModelPermissionHelper;
import com.sx.icecap.security.permission.resource.datatype.DataTypeResourcePermissionHelper;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EXPLORER,
	        "mvc.command.name="+MVCCommand.RESOURCE_SEARCH_DATATYPES
	    },
	    service = MVCResourceCommand.class
)
public class SearchDataTypesResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("SearchDataTypesResourceCommand");
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int start = ParamUtil.getInteger(resourceRequest, StationXWebKeys.START, StationXConstants.DEFAULT_START);
		int delta = ParamUtil.getInteger(resourceRequest, StationXWebKeys.DELTA, StationXConstants.DEFAULT_DELTA);
		int end = start + delta - 1;
		long groupId = ParamUtil.getLong(resourceRequest, StationXWebKeys.GROUP_ID, themeDisplay.getScopeGroupId());
		long userId = ParamUtil.getLong(resourceRequest, StationXWebKeys.USER_ID, themeDisplay.getUserId());
		
		int status = ParamUtil.getInteger(resourceRequest, StationXWebKeys.STATUS, WorkflowConstants.STATUS_ANY);
		String filterBy = ParamUtil.getString(resourceRequest, "filterBy", "groupId");
		String groupBy = ParamUtil.getString(resourceRequest, "groupBy", "groupId");
		String keywords = ParamUtil.getString(resourceRequest, StationXWebKeys.KEYWORDS, "");
		
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		List<DataType> dataTypes = null;
		
		if(keywords.isEmpty()) {
			dataTypes = _dataTypeLocalService.getDataTypesByG_S(groupId, status, start, end);
		}
		else {
			dataTypes = new ArrayList<>();
		}
		
		JSONArray jsonDataTypes = JSONFactoryUtil.createJSONArray();
		
		Iterator<DataType> iter = dataTypes.iterator();
		while(iter.hasNext()) {
			jsonDataTypes.put(iter.next().toJSON(themeDisplay.getLocale()));
		}

		PrintWriter pw = resourceResponse.getWriter();
		pw.write(jsonDataTypes.toJSONString());
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
