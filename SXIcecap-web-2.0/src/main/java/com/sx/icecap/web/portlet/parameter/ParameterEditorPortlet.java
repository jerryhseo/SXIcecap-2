package com.sx.icecap.web.portlet.parameter;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.Parameter;
import com.sx.icecap.service.ParameterLocalService;

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
		"com.liferay.portlet.display-category=category.icecap",
		"com.liferay.portlet.header-portlet-css=/css/index.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Parameter Editor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+JSPPath.PARAMETER_EDITOR,
		"javax.portlet.name=" + WebPortletKey.PARAMETER_EDITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ParameterEditorPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		long parameterId = ParamUtil.getLong(renderRequest, WebKey.PARAMETER_ID, 0);
		System.out.println("ParameterEditorPortlet - parameterId: " + parameterId);
		
		Parameter parameter = null;
		if( parameterId > 0 ) {
			try {
				parameter = _parameterLocalService.getParameter(parameterId);
				String jsonParameter = JSONFactoryUtil.looseSerialize(parameter);
				renderRequest.setAttribute(WebKey.PARAMETER, jsonParameter);
			} catch (Exception e) {
				throw new PortletException( "Cannot find parameter: " + parameterId );
			}
		}
		
		renderRequest.setAttribute(WebKey.PARAMETER_ID, parameterId);
		
		renderRequest.setAttribute(
				"mainRequire",
				_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private ParameterLocalService _parameterLocalService;
}