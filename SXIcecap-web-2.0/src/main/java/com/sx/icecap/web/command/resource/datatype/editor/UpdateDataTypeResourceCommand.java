package com.sx.icecap.web.command.resource.datatype.editor;

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
		long dataTypeId = ParamUtil.getLong(resourceRequest, WebKey.DATATYPE_ID, 0);
		String strDataType = ParamUtil.getString(resourceRequest, "dataType", "{}");
		
		System.out.println("dataTypeId: " + dataTypeId);
		System.out.println("dataType: " + strDataType);
		
		PrintWriter pw = resourceResponse.getWriter();
		//DataType dataType = _dataTypeLocalService.getDataType(dataTypeId );
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		result.put("dataTypeId", dataTypeId);
		result.put("result", "success");
		
		pw.write(result.toJSONString());
		
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
