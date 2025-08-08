package com.sx.icecap.security.permission.resource.parameter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.sx.icecap.constant.IcecapModelNames;
import com.sx.icecap.model.Parameter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class ParameterModelPermissionHelper{
	
	@Reference(
			target = "(model.class.name="+ IcecapModelNames.PARAMETER+")",
			unbind = "-"
			)
	protected void setParameterModelResourcePermission(
			ModelResourcePermission<Parameter> modelResourcePermission) {
		System.out.println("Model Resource Permission Injected: "+modelResourcePermission.getModelName());
		_parameterModelResourcePermission = modelResourcePermission;
	}
	private static ModelResourcePermission<Parameter> _parameterModelResourcePermission;
	
	public static boolean contains(
			PermissionChecker permissionChecker, 
			Parameter parameter,
			String actionId) throws PortalException{

		return _parameterModelResourcePermission.contains(
				permissionChecker, 
				parameter, 
				actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, 
			long parameterId, 
			String actionId) throws PortalException{
		
		return _parameterModelResourcePermission.contains(
				permissionChecker, 
				parameterId, 
				actionId);
	}

}
