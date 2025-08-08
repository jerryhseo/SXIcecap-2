package com.sx.icecap.search.parameter.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.sx.icecap.model.Parameter;
import com.sx.icecap.search.parameter.ParameterBatchReindexer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = com.sx.icecap.search.parameter.ParameterBatchReindexer.class
)
public class ParameterBatchReindexerImpl implements ParameterBatchReindexer {

	@Override
	public void reindex(long parameterId, long companyId) {
		BatchIndexingActionable batchIndexingActionable = _indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property parameterIdProperty = PropertyFactoryUtil.forName("parameterId");
			dynamicQuery.add(parameterIdProperty.eq(parameterId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((Parameter parameter) -> {
			Document document = _indexerDocumentBuilder.getDocument(parameter);
			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
	}

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.Parameter)"
	)
	protected IndexerDocumentBuilder _indexerDocumentBuilder;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.Parameter)"
	)
	protected IndexerWriter<Parameter> _indexerWriter;
}
