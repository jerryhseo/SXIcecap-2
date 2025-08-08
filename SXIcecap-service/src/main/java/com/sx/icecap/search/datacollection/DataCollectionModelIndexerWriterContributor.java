package com.sx.icecap.search.datacollection;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.DataCollectionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataCollection",
        service = ModelIndexerWriterContributor.class
)
public class DataCollectionModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataCollection> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		//Debug.printHeader("DataCollectionModelIndexerWriterContributor");

		batchIndexingActionable.setPerformActionMethod((DataCollection dataCollection) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(dataCollection);
			
			batchIndexingActionable.addDocuments(document);
		});
		
		//Debug.printFooter("DataCollectionModelIndexerWriterContributor");
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_dataCollectionLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(DataCollection dataCollection) {
		return dataCollection.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected DataCollectionLocalService _dataCollectionLocalService;
}
