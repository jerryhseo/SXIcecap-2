package com.sx.icecap.search.datacollection;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.DataCollectionProperties;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.DataCollectionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The contributor is a actual indexer when each DataCollection data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataCollection",
		service = ModelDocumentContributor.class
)
public class DataCollectionModelDocumentContributor implements ModelDocumentContributor<DataCollection> {
	
	@Override
	public void contribute(Document document, DataCollection dataCollection) {
			//Debug.printHeader("DataCollectionModelDocumentContributor");
			
			document.addKeyword(DataCollectionProperties.DATA_COLLECTION_ID, dataCollection.getPrimaryKey());
			document.addDate(Field.MODIFIED_DATE, dataCollection.getModifiedDate());
			document.addText(DataCollectionProperties.DATA_COLLECTION_NAME, dataCollection.getDataCollectionName());
			document.addLocalizedText(DataCollectionProperties.DESCRIPTION, dataCollection.getDescriptionMap());
			document.addLocalizedKeyword(DataCollectionProperties.DISPLAY_NAME, dataCollection.getDisplayNameMap(), true);
			
			//Debug.printFooter("DataCollectionModelDocumentContributor");
	}
	
	@Reference
    private DataCollectionLocalService _dataCollectionLocalService;
}
