package com.sx.icecap.web.command.resource.datatype.editor;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.service.DataTypeLocalService;

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
		
		
		JSONArray availables = JSONFactoryUtil.createJSONArray();
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 123456);
		item.put( "portletName", "com_sx_visualizer_TextViewer");
		JSONObject displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Text Viewer");
		displayName.put("ko-KR", "텍스트 뷰어");
		item.put( "displayName", displayName);
		
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 234567);
		item.put( "portletName", "com_sx_visualizer_StructuredDataEditor");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Structured Data Editor");
		displayName.put("ko-KR", "구조데이터 편집기");
		item.put( "displayName", displayName);
		
		availables.put(item);
		
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 345678);
		item.put( "portletName", "com_sx_visualizer_ImageViewer");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Image Viewer");
		displayName.put("ko-KR", "이미지 뷰어");
		item.put( "displayName", displayName);
		
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 456789);
		item.put( "portletName", "com_sx_visualizer_TextEditor");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Text Editor");
		displayName.put("ko-KR", "텍스트 편집기");
		item.put( "displayName", displayName);
		
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "id", 567890);
		item.put( "portletName", "com_sx_visualizer_ImageEditor");
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Image Editor");
		displayName.put("ko-KR", "이미지 편집기");
		item.put( "displayName", displayName);
		
		availables.put(item);
		
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(availables.toJSONString());
		
		pw.flush();
		pw.close();
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
