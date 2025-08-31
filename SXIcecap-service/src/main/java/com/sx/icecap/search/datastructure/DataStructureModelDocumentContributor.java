package com.sx.icecap.search.datastructure;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.DataStructureProperties;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataStructureLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The contributor is a actual indexer when each DataStructure data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataStructure",
		service = ModelDocumentContributor.class
)
public class DataStructureModelDocumentContributor implements ModelDocumentContributor<DataStructure> {
	
	@Override
	public void contribute(Document document, DataStructure dataStructure) {
			//Debug.printHeader("DataStructureModelDocumentContributor");
			
			document.addKeyword(DataStructureProperties.DATA_STRUCTURE_ID, dataStructure.getPrimaryKey());
			document.addDate(Field.MODIFIED_DATE, dataStructure.getModifiedDate());
			document.addText(DataStructureProperties.DATA_STRUCTURE_CODE, dataStructure.getDataStructureCode());
			document.addLocalizedText(DataStructureProperties.DESCRIPTION, dataStructure.getDescriptionMap());
			document.addLocalizedKeyword(DataStructureProperties.DISPLAY_NAME, dataStructure.getDisplayNameMap(), true);
			
			//Debug.printFooter("DataStructureModelDocumentContributor");
	}
	
	@Reference
    private DataStructureLocalService _dataStructureLocalService;
}
