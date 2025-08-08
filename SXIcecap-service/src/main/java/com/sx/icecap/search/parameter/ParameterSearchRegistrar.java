package com.sx.icecap.search.parameter;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.constant.ParameterProperties;
import com.sx.icecap.model.Parameter;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class ParameterSearchRegistrar {
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = _modelSearchRegistrarHelper.register(
				Parameter.class, 
				bundleContext, 
				modelSearchDefinition -> {
//								System.out.println("DataTypeSearchRegister activator: modelSearchDefinition");
							modelSearchDefinition.setDefaultSelectedFieldNames(
									Field.COMPANY_ID,
									Field.GROUP_ID, 
									Field.USER_ID, 
									Field.ENTRY_CLASS_NAME, 
									Field.ENTRY_CLASS_PK,
									Field.UID,
									Field.SCOPE_GROUP_ID,
									Field.CONTENT,
									ParameterProperties.PARAM_NAME
									);
							
							modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
									ParameterProperties.DEFINITION,
									ParameterProperties.DISPLAY_NAME);

							modelSearchDefinition.setModelIndexWriteContributor(
									_modelIndexWriterContributor);
							modelSearchDefinition.setModelSummaryContributor(
									_modelSummaryContributor);
							modelSearchDefinition.setSelectAllLocales(true);
				});

	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}
	
	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.Parameter)"
	)
	protected ModelIndexerWriterContributor<Parameter> _modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.Parameter)"
	)
	protected ModelSummaryContributor _modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
