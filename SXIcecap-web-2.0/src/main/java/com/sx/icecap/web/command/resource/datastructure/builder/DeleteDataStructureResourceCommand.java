package com.sx.icecap.web.command.resource.datastructure.builder;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.DataStructureProperties;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataStructureLocalService;

import java.io.PrintWriter;

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
	DataStructureLocalService _dataStructureLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataStructureId = ParamUtil.getLong(resourceRequest, DataStructureProperties.DATA_STRUCTURE_ID, 0);
		
		DataStructure dataStructure = _dataStructureLocalService.deleteDataStructure(dataStructureId);
		
		JSONObject response = JSONFactoryUtil.createJSONObject();
		response.put( "dataTypeId" , dataStructure.getPrimaryKey() );
		response.put( "action", "delete");
		response.put( "result", "success" );
		
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(response.toString());
		pw.flush();
		pw.close();
		
	}

}
