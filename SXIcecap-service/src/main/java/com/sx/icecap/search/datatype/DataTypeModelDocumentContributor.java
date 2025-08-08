package com.sx.icecap.search.datatype;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.model.DataType;
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
		property = "indexer.class.name=com.sx.icecap.model.DataType",
		service = ModelDocumentContributor.class
)
public class DataTypeModelDocumentContributor implements ModelDocumentContributor<DataType> {
	
	@Override
	public void contribute(Document document, DataType dataType) {
			//Debug.printHeader("DataTypeModelDocumentContributor");
			
			document.addKeyword(DataTypeProperties.DATATYPE_ID, dataType.getPrimaryKey());
			document.addDate(Field.MODIFIED_DATE, dataType.getModifiedDate());
			document.addText(DataTypeProperties.DATATYPE_NAME, dataType.getDataTypeName());
			document.addLocalizedText(DataTypeProperties.DESCRIPTION, dataType.getDescriptionMap());
			document.addLocalizedKeyword(DataTypeProperties.DISPLAY_NAME, dataType.getDisplayNameMap(), true);
			
			//Debug.printFooter("DataTypeModelDocumentContributor");
	}
	
	@Reference
    private DataTypeLocalService _dataTypeLocalService;
}
