package com.sx.icecap.web.command.render.datatype.explorer;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.JSPPath;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component( 
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EXPLORER,
	        "mvc.command.name="+MVCCommand.RENDER_EDIT_DATATYPE
	    },
	    service = MVCRenderCommand.class
	)
public class EditDataTypeRenderCommand implements MVCRenderCommand {
	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long dataTypeId = ParamUtil.getLong(renderRequest, WebKey.DATATYPE_ID, 0);
		String backURL = ParamUtil.getString(renderRequest, StationXWebKeys.BACK_URL, "");
		System.out.println("DataTypeEditorPortlet - dataTypeId: " + dataTypeId);
		System.out.println("DataTypeEditorPortlet - backURL: " + backURL);
		
		DataType dataType = null;
		if( dataTypeId > 0 ) {
			try {
				dataType = _dataTypeLocalService.getDataType(dataTypeId);
				String jsonDataType = JSONFactoryUtil.looseSerialize(dataType);
				renderRequest.setAttribute(WebKey.DATATYPE, jsonDataType);
			} catch (Exception e) {
				throw new PortletException( "Cannot find data type: " + dataTypeId );
			}
		}
		
		renderRequest.setAttribute(WebKey.DATATYPE_ID, dataTypeId);
		
		renderRequest.setAttribute(
				"mainRequire",
				_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		return JSPPath.EDIT_DATATYPE;
	}
	
	
}
