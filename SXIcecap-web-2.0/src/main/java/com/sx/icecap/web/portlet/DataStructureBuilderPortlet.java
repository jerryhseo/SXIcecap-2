package com.sx.icecap.web.portlet;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.sx.icecap.constant.WebPortletKey;

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
		"javax.portlet.display-name=Data Structure Bulder",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/DSBuilder/data-structure-builder.jsp",
		"javax.portlet.name=" + WebPortletKey.DATA_STRUCTURE_BUILDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DataStructureBuilderPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		System.out.println("SxIcecapDataStructureBuilderPortlet");
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("sx-icecap-web") + " as main");

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;

}