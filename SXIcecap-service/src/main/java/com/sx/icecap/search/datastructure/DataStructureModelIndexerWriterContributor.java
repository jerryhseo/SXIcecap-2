package com.sx.icecap.search.datastructure;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataStructureLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataStructure",
        service = ModelIndexerWriterContributor.class
)
public class DataStructureModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataStructure> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		//Debug.printHeader("DataStructureModelIndexerWriterContributor");

		batchIndexingActionable.setPerformActionMethod((DataStructure dataStructure) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(dataStructure);
			
			batchIndexingActionable.addDocuments(document);
		});
		
		//Debug.printFooter("DataStructureModelIndexerWriterContributor");
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_dataStructureLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(DataStructure dataStructure) {
		return dataStructure.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected DataStructureLocalService _dataStructureLocalService;
}
