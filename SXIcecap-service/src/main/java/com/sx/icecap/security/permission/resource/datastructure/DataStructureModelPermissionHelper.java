package com.sx.icecap.security.permission.resource.datastructure;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.sx.icecap.constant.IcecapModelNames;
import com.sx.icecap.model.DataStructure;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class DataStructureModelPermissionHelper{
	
	@Reference(
			target = "(model.class.name="+ IcecapModelNames.DATASTRUCTURE+")",
			unbind = "-"
			)
	protected void setDataStructureModelResourcePermission(
			ModelResourcePermission<DataStructure> modelResourcePermission) {
		System.out.println("Model Resource Permission Injected: "+modelResourcePermission.getModelName());
		_dataStructureModelResourcePermission = modelResourcePermission;
	}
	private static ModelResourcePermission<DataStructure> _dataStructureModelResourcePermission;
	
	public static boolean contains(
			PermissionChecker permissionChecker, 
			DataStructure dataStructure,
			String actionId) throws PortalException{

		return _dataStructureModelResourcePermission.contains(
				permissionChecker, 
				dataStructure, 
				actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, 
			long dataStructureId, 
			String actionId) throws PortalException{
		
		return _dataStructureModelResourcePermission.contains(
				permissionChecker, 
				dataStructureId, 
				actionId);
	}

}
