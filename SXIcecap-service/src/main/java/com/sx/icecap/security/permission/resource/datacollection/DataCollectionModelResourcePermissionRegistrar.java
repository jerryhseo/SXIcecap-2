package com.sx.icecap.security.permission.resource.datacollection;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.DataCollectionLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component (
		immediate=true
)
public class DataCollectionModelResourcePermissionRegistrar {

	@Reference
	private DataCollectionLocalService _dataCollectionLocalService;

	@Reference(
			target = "(resource.name=" + Constant.ICECAP_RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;
	
	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;

	@Reference
	private GroupLocalService _groupLocalService;

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", DataCollection.class.getName());
		
		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
						DataCollection.class,
						DataCollection::getDataCollectionId,
						_dataCollectionLocalService::fetchDataCollection,
						_portletResourcePermission,
						(modelResourcePermission, consumer) -> {
							consumer.accept(
									new StagedModelPermissionLogic<>(
											_stagingPermission, 
											WebPortletKey.DATA_COLLECTION_EDITOR,
											DataCollection::getDataCollectionId)
							);
							consumer.accept(
									new WorkflowedModelPermissionLogic<>(
											_workflowPermission, 
											modelResourcePermission,
											_groupLocalService, 
											DataCollection::getPrimaryKey)
							);
						}
				),
				properties);
	}
	
	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
}
