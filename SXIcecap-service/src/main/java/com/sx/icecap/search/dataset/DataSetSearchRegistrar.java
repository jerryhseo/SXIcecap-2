package com.sx.icecap.search.dataset;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.DataSetProperties;
import com.sx.icecap.model.DataSet;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataSetSearchRegistrar {
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		//Debug.printHeader("DataSetSearchRegistrar activator");
			_serviceRegistration = _modelSearchRegistrarHelper.register(
					DataSet.class, 
					bundleContext, 
					modelSearchDefinition -> {
//								System.out.println("DataSetSearchRegister activator: modelSearchDefinition");
								modelSearchDefinition.setDefaultSelectedFieldNames(
										Field.COMPANY_ID,
										Field.GROUP_ID, 
										Field.ENTRY_CLASS_NAME, 
										Field.ENTRY_CLASS_PK,
										Field.UID,
										Field.SCOPE_GROUP_ID,
										DataSetProperties.DATASET_NAME); 
								modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
										DataSetProperties.DESCRIPTION,
										DataSetProperties.DISPLAY_NAME);

								modelSearchDefinition.setModelIndexWriteContributor(
										_modelIndexWriterContributor);
								modelSearchDefinition.setModelSummaryContributor(
										_modelSummaryContributor);
								modelSearchDefinition.setSelectAllLocales(true);
					});

		//Debug.printFooter("TermSearchRegistrar");
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}
	
	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataSet)"
	)
	protected ModelIndexerWriterContributor<DataSet> _modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataSet)"
	)
	protected ModelSummaryContributor _modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
