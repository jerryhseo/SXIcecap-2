package com.sx.icecap.search.dataset.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.search.dataset.DataSetBatchReindexer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = DataSetBatchReindexer.class
)
public class DataSetBatchReindexerImpl implements DataSetBatchReindexer {

	@Override
	public void reindex(long dataSetId, long companyId) {
		BatchIndexingActionable batchIndexingActionable = _indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property dataSetIdProperty = PropertyFactoryUtil.forName("dataSetId");
			dynamicQuery.add(dataSetIdProperty.eq(dataSetId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((DataSet dataSet) -> {
			Document document = _indexerDocumentBuilder.getDocument(dataSet);
			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
	}

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataSet)"
	)
	protected IndexerDocumentBuilder _indexerDocumentBuilder;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataSet)"
	)
	protected IndexerWriter<DataSet> _indexerWriter;
}
