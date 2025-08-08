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
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.PrintWriter;
import java.util.HashMap;
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
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EXPLORER,
	        "mvc.command.name="+MVCCommand.RESOURCE_DELETE_DATATYPE
	    },
	    service = MVCResourceCommand.class
)
public class DeleteDataTypeResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("DeleteDataTypeResourceCommand");
		//long dataTypeId = ParamUtil.getLong(resourceRequest, IcecapWebKeys.DATATYPE_ID, 0);
		long dataTypeId = ParamUtil.getLong(resourceRequest, WebKey.DATATYPE_ID, 0);
		System.out.println("dataTypeId: " + dataTypeId);
		
		DataType dataType =_dataTypeLocalService.removeDataType(dataTypeId);
		
		
		PrintWriter pw = resourceResponse.getWriter();
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		result.put("dataTypeId", dataType.getDataTypeId());
		result.put("dataTypeName", dataType.getDataTypeName());
		result.put("dataTypeVersion", dataType.getDataTypeVersion());
		
		pw.write(result.toJSONString());
		
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
