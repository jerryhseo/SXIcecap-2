package com.sx.icecap.web.command.resource.datatype.editor;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.spyglass.service.ScienceAppLocalService;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
	        "mvc.command.name="+MVCCommand.RESOURCE_LOAD_AVAILABLE_VISUALIZERS
	    },
	    service = MVCResourceCommand.class
)
public class LoadAvailableVisualizersResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("LoadAvailableVisualizersResourceCommand");
		
		
		JSONArray availables = _scienceAppLocalService.getScienceAppList("visualizer");
			
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(availables.toJSONString());
		
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private ScienceAppLocalService _scienceAppLocalService;
}
