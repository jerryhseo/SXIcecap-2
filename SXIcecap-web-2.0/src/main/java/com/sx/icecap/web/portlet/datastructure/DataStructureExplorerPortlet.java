package com.sx.icecap.web.portlet.datastructure;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataStructureLocalService;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author jerry
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sx.icecap",
		"com.liferay.portlet.header-portlet-css=/css/index.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Data Structure Explorer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+JSPPath.DATA_STRUCTURE_EXPLORER,
		"javax.portlet.name=" + WebPortletKey.DATA_STRUCTURE_EXPLORER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DataStructureExplorerPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		long dataStructureId = ParamUtil.getLong(renderRequest, WebKey.DATASTRUCTURE_ID, 0);
		System.out.println("DataStructureExplorerPortlet - dataStructureId: " + dataStructureId);
		
		DataStructure dataStructure = null;
		if( dataStructureId > 0 ) {
			try {
				dataStructure = _dataStructureLocalService.getDataStructure(dataStructureId);
				String jsonDataStructure = JSONFactoryUtil.looseSerialize(dataStructure);
				renderRequest.setAttribute(WebKey.DATATYPE, jsonDataStructure);
			} catch (Exception e) {
				throw new PortletException( "Cannot find data structure: " + dataStructureId );
			}
		}
		
		renderRequest.setAttribute(WebKey.DATASTRUCTURE_ID, dataStructureId);
		
		renderRequest.setAttribute(
				"mainRequire",
				_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private DataStructureLocalService _dataStructureLocalService;
}