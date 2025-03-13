package com.sx.icecap.web.command.resource.datatype.builder;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + WebPortletKey.DATA_STRUCTURE_BUILDER,
				"mvc.command.name=" + MVCCommand.RESOURCE_DELETE_DATA_STRUCTURE
		},
		service = MVCResourceCommand.class
)
public class DeleteDataStructureResourceCommand extends BaseMVCResourceCommand {
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, DataTypeProperty.DATATYPE_ID, 0);
		
		_dataTypeLocalService.deleteDataStructures(dataTypeId);
		
		JSONObject response = JSONFactoryUtil.createJSONObject();
		response.put( "DataType ID" , dataTypeId );
		response.put( "action", "delete");
		response.put( "result", "success" );
		
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(response.toString());
		pw.flush();
		pw.close();
		
	}

}
