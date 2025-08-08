package com.sx.icecap.web.portlet.datacollection;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.security.permission.resource.datacollection.DataCollectionResourcePermissionHelper;
import com.sx.icecap.service.DataCollectionLocalService;

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
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/index.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Data Type Explorer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + JSPPath.DATA_COLLECTION_EXPLORER,
		"javax.portlet.name=" + WebPortletKey.DATA_COLLECTION_EXPLORER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class 
)
public class DataCollectionExplorerPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		System.out.println("DataCollectionExplorerPortlet....... ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		List<ResourceAction> resourceActions = _resouceActionLocalService.getResourceActions(Constant.ICECAP_RESOURCE_NAME);
		
		JSONArray permissions = JSONFactoryUtil.createJSONArray();
		for (ResourceAction resourceAction : resourceActions) {
			String actionId = resourceAction.getActionId();

			// Check if the user has the permission for the action
			boolean hasPermission = DataCollectionResourcePermissionHelper.contains(permissionChecker, themeDisplay.getScopeGroupId(), actionId);
 
			if (hasPermission) {
				permissions.put(actionId);
			}
		}
		
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		renderRequest.setAttribute("permissions", permissions);
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private DataCollectionLocalService _dataCollectionLocalService;
	
	@Reference
	private ResourceActionLocalService _resouceActionLocalService;
}