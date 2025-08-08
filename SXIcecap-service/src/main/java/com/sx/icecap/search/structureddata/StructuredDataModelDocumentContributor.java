package com.sx.icecap.search.structureddata;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.StructuredDataSearchField;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The contributor is a actual indexer when each DataType data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.StructuredData",
		service = ModelDocumentContributor.class
)
public class StructuredDataModelDocumentContributor implements ModelDocumentContributor<StructuredData> {
	private static final Log _log = LogFactoryUtil.getLog(StructuredDataModelDocumentContributor.class);
	
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public void contribute(Document document, StructuredData structuredData) {
		/**
		 *  Be sure there is not a single error during the document processing. 
		 *  If any kind errors happen, the indexer would come into sleep 
		 *  without any behavious or warnings and never finish this contribute function.
		 */
		
		document.addDateSortable(Field.MODIFIED_DATE, structuredData.getModifiedDate());
		document.addNumber(StructuredDataSearchField.DATACOLLECTION_ID, structuredData.getDataCollectionId());
		document.addNumber(StructuredDataSearchField.DATASET_ID, structuredData.getDataSetId());
		document.addNumber(StructuredDataSearchField.DATATYPE_ID, structuredData.getDataTypeId());
	}
	
}
