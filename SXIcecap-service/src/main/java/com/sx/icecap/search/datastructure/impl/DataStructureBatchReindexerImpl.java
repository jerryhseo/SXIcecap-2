package com.sx.icecap.search.datastructure.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.search.datastructure.DataStructureBatchReindexer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = DataStructureBatchReindexer.class
)
public class DataStructureBatchReindexerImpl implements DataStructureBatchReindexer {

	@Override
	public void reindex(long dataStructureId, long companyId) {
		BatchIndexingActionable batchIndexingActionable = _indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property dataStructureIdProperty = PropertyFactoryUtil.forName("dataStructureId");
			dynamicQuery.add(dataStructureIdProperty.eq(dataStructureId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((DataStructure dataStructure) -> {
			Document document = _indexerDocumentBuilder.getDocument(dataStructure);
			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
	}

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataStructure)"
	)
	protected IndexerDocumentBuilder _indexerDocumentBuilder;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataStructure)"
	)
	protected IndexerWriter<DataStructure> _indexerWriter;
}
