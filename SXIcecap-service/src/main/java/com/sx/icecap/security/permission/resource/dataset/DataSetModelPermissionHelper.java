package com.sx.icecap.security.permission.resource.dataset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.sx.icecap.constant.IcecapModelNames;
import com.sx.icecap.model.DataSet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class DataSetModelPermissionHelper{
	
	@Reference(
			target = "(model.class.name="+ IcecapModelNames.DATASET+")",
			unbind = "-"
			)
	protected void setDataSetModelResourcePermission(
			ModelResourcePermission<DataSet> modelResourcePermission) {
		System.out.println("Model Resource Permission Injected: "+modelResourcePermission.getModelName());
		_dataSetModelResourcePermission = modelResourcePermission;
	}
	private static ModelResourcePermission<DataSet> _dataSetModelResourcePermission;
	
	public static boolean contains(
			PermissionChecker permissionChecker, 
			DataSet dataSet,
			String actionId) throws PortalException{

		return _dataSetModelResourcePermission.contains(
				permissionChecker, 
				dataSet, 
				actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, 
			long dataSetId, 
			String actionId) throws PortalException{
		
		return _dataSetModelResourcePermission.contains(
				permissionChecker, 
				dataSetId, 
				actionId);
	}

}
