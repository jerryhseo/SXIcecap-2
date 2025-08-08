package com.sx.icecap.search.dataset;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.service.DataSetLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataSet",
        service = ModelIndexerWriterContributor.class
)
public class DataSetModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataSet> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		//Debug.printHeader("DataSetModelIndexerWriterContributor");

		batchIndexingActionable.setPerformActionMethod((DataSet dataSet) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(dataSet);
			
			batchIndexingActionable.addDocuments(document);
		});
		
		//Debug.printFooter("DataSetModelIndexerWriterContributor");
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_dataSetLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(DataSet dataSet) {
		return dataSet.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected DataSetLocalService _dataSetLocalService;
}
