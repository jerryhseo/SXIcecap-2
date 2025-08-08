package com.sx.icecap.web.command.resource.datatype.editor;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.TypeVisualizerLinkLocalService;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
	        "mvc.command.name="+MVCCommand.RESOURCE_LOAD_DATATYPE
	    },
	    service = MVCResourceCommand.class
)
public class LoadDataTypeResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("LoadDataTypeResourceCommand");
		long dataTypeId = ParamUtil.getLong(resourceRequest, WebKey.DATATYPE_ID, 0);
		
		
		DataType dataType = _dataTypeLocalService.getDataType(dataTypeId );
		JSONObject jsonDataType = dataType.toJSON();
		
		System.out.println("dataType: " + jsonDataType.toString());
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		
		result.put("dataType", jsonDataType);
		
		JSONArray availables = JSONFactoryUtil.createJSONArray();
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put( "value", 123456);
		JSONObject displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Text Viewer");
		displayName.put("ko-KR", "텍스트 뷰어");
		item.put( "displayName", displayName);
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "value", 234567);
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Structured Data Editor");
		displayName.put("ko-KR", "구조데이터 편집기");
		item.put( "displayName", displayName);
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "value", 345678);
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Image Viewer");
		displayName.put("ko-KR", "이미지 뷰어");
		item.put( "displayName", displayName);
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "value", 456789);
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Text Editor");
		displayName.put("ko-KR", "텍스트 편집기");
		item.put( "displayName", displayName);
		availables.put(item);
		
		item = JSONFactoryUtil.createJSONObject();
		item.put( "value", 567890);
		displayName = JSONFactoryUtil.createJSONObject();
		displayName.put("en-US", "Image Editor");
		displayName.put("ko-KR", "이미지 편집기");
		item.put( "displayName", displayName);
		availables.put(item);
		
		result.put("visualizers", availables);
		
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(result.toJSONString());
		pw.flush();
		pw.close();
	}
	
	private boolean _checkVisualizerInValue( JSONArray visualizers, long visualizerId) {
		Iterator<JSONObject> iterator = visualizers.iterator();
		boolean contained = false;
		
		while( iterator.hasNext() && contained == false) {
			JSONObject visualizer = iterator.next();
			
			if( visualizer.getLong("value") == visualizerId ) {
				contained = true;
			}
		}
		
		return contained;
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private TypeVisualizerLinkLocalService _typeVisualizerLinkLocalService;
}
