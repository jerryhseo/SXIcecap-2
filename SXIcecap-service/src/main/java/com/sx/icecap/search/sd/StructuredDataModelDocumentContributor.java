package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.SDSearchField;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
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
		
		long dataSetId = structuredData.getDataSetId();
		long dataTypeId = structuredData.getDataTypeId();
		long structuredDataId = structuredData.getStructuredDataId();
		
		document.addDate(Field.MODIFIED_DATE, structuredData.getModifiedDate());
		document.addNumber(SDSearchField.DATASET_ID, dataSetId);
		document.addLocalizedKeyword(SDSearchField.DATASET_NAME, structuredData.getDataSetDisplayNameMap(), true);
		document.addNumber(SDSearchField.DATATYPE_ID, dataTypeId);
		document.addLocalizedKeyword(SDSearchField.DATATYPE_NAME, structuredData.getDataTypeDisplayNameMap(), true);
	}
	
}
