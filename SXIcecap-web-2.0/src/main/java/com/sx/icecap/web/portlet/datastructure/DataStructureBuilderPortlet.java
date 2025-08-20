package com.sx.icecap.web.portlet.datastructure;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.constant.ActionKey;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.security.permission.resource.datatype.DataTypeResourcePermissionHelper;

import java.io.IOException;
import java.lang.reflect.Field;

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
		"javax.portlet.display-name=Data Structure Bulder",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + JSPPath.DATA_STRUCTURE_BUILDER,
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

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		JSONArray permissions = JSONFactoryUtil.createJSONArray();
		Field[] fields = ActionKey.class.getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			Field field = fields[i];
			
			boolean hasPermission = DataTypeResourcePermissionHelper.contains(permissionChecker, themeDisplay.getScopeGroupId(), field.getName());
			if (hasPermission) {
				permissions.put(field.getName());
			}
		}
		
		renderRequest.setAttribute("permissions", permissions);
		
		System.out.println("DataStructureBuilderPortlet");
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("sx-icecap-web") + " as main");

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;

}