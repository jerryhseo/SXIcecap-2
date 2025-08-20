package com.sx.icecap.security.permission.resource.dataworkbench;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.WebPortletKey;

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
public class DataWorkbenchPortletResourcePermissionRegistrar {
	
	private ServiceRegistration<PortletResourcePermission> _serviceRegistration;
	
	@Reference
	private StagingPermission _stagingPermission;
	
	@Activate
	public void activate(BundleContext bundleContext) {
		
		Dictionary<String, Object> properties = new HashMapDictionary<>(); 

		properties.put("resource.name", Constant.ICECAP_RESOURCE_NAME);

		_serviceRegistration = bundleContext.registerService(
				PortletResourcePermission.class,
				PortletResourcePermissionFactory.create(
						Constant.ICECAP_RESOURCE_NAME,
						new StagedPortletPermissionLogic(
								_stagingPermission, 
								WebPortletKey.SXDataWorkbenchPortlet)),
				properties);
		
	};
		
	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
}
