package com.sx.icecap.search.dataset;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.DataSetProperties;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.service.DataSetLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The contributor is a actual indexer when each DataSet data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataSet",
		service = ModelDocumentContributor.class
)
public class DataSetModelDocumentContributor implements ModelDocumentContributor<DataSet> {
	
	@Override
	public void contribute(Document document, DataSet dataSet) {
			//Debug.printHeader("DataSetModelDocumentContributor");
			
			document.addKeyword(DataSetProperties.DATASET_ID, dataSet.getPrimaryKey());
			document.addDate(Field.MODIFIED_DATE, dataSet.getModifiedDate());
			document.addText(DataSetProperties.DATASET_NAME, dataSet.getDataSetName());
			document.addLocalizedText(DataSetProperties.DESCRIPTION, dataSet.getDescriptionMap());
			document.addLocalizedKeyword(DataSetProperties.DISPLAY_NAME, dataSet.getDisplayNameMap(), true);
			
			//Debug.printFooter("DataSetModelDocumentContributor");
	}
	
	@Reference
    private DataSetLocalService _dataSetLocalService;
}
