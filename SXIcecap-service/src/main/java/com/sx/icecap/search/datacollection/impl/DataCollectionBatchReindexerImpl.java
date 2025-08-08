package com.sx.icecap.search.datacollection.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.search.datacollection.DataCollectionBatchReindexer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = DataCollectionBatchReindexer.class
)
public class DataCollectionBatchReindexerImpl implements DataCollectionBatchReindexer {

	@Override
	public void reindex(long dataCollectionId, long companyId) {
		BatchIndexingActionable batchIndexingActionable = _indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property dataCollectionIdProperty = PropertyFactoryUtil.forName("dataCollectionId");
			dynamicQuery.add(dataCollectionIdProperty.eq(dataCollectionId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((DataCollection dataCollection) -> {
			Document document = _indexerDocumentBuilder.getDocument(dataCollection);
			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
	}

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataCollection)"
	)
	protected IndexerDocumentBuilder _indexerDocumentBuilder;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataCollection)"
	)
	protected IndexerWriter<DataCollection> _indexerWriter;
}
