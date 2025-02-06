package com.sx.icecap.web.portlet;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.ResourcePermissionCheckerUtil;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.permission.UserGroupPermission;
import com.liferay.portal.kernel.service.permission.UserGroupPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.security.permission.resource.datatype.DataTypeModelPermissionHelper;
import com.sx.icecap.security.permission.resource.datatype.DataTypeResourcePermissionHelper;

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
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Data Workbench",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+JSPPath.DATA_WORKBENCH,
		"javax.portlet.name=" + WebPortletKey.DATA_WORKBENCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DataWorkbenchPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		System.out.println("Data DataWorkbenchPortlet: " +
				ParamUtil.getString(
					renderRequest, 
					StationXWebKeys.WORKING_PORTLET_NAME, 
					WebPortletKey.DATATYPE_EXPLORER
				)
		);
		
		renderRequest.setAttribute(
				"mainRequire",
				_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private ResourceActionLocalService _resouceActionLocalService;
}