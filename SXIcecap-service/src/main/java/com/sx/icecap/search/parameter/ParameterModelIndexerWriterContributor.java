package com.sx.icecap.search.parameter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.icecap.model.Parameter;
import com.sx.icecap.service.ParameterLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.Parameter",
        service = ModelIndexerWriterContributor.class
)
public class ParameterModelIndexerWriterContributor implements ModelIndexerWriterContributor<Parameter> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((Parameter parameter) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(parameter);

			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_parameterLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Parameter parameter) {
		return parameter.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected ParameterLocalService _parameterLocalService;
}
