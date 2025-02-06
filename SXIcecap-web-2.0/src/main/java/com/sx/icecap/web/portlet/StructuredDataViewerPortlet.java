package com.sx.icecap.web.portlet;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXConstants;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.IOException;
import java.util.List;

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
		"javax.portlet.display-name=Structured Data Viewer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/SDViewer/structured-data-viewer.jsp",
		"javax.portlet.name=" + WebPortletKey.STRUCTURED_DATA_VIEWER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StructuredDataViewerPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = ParamUtil.getLong(renderRequest, "userId", themeDisplay.getUserId());
		long groupId = ParamUtil.getLong(renderRequest, "groupId", themeDisplay.getScopeGroupId());
		int start = ParamUtil.getInteger(renderRequest, "start", 1);
		int delta = ParamUtil.getInteger(renderRequest, "delta", 10);
		int end = start + delta - 1;
		String sortOrder = ParamUtil.getString(renderRequest, "sortOrder", StationXConstants.DSC);
		int status = ParamUtil.getInteger(renderRequest, "status", WorkflowConstants.STATUS_APPROVED);
		String keywords = ParamUtil.getString(renderRequest, "keywords", "");
		
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}