package com.sx.icecap.search.datatype;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.constant.DataStructureProperty;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.ParameterProperty;
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
	private static final Log _log = LogFactoryUtil.getLog(DataTypeModelDocumentContributor.class);
	
	@Override
	public void contribute(Document document, DataType dataType) {
			//Debug.printHeader("DataTypeModelDocumentContributor");
			
			document.addKeyword(DataTypeProperty.DATATYPE_ID, dataType.getPrimaryKey());
			document.addDate(Field.MODIFIED_DATE, dataType.getModifiedDate());
			document.addText(DataTypeProperty.DATATYPE_NAME, dataType.getDataTypeName());
			document.addLocalizedText(DataTypeProperty.DESCRIPTION, dataType.getDescriptionMap());
			document.addLocalizedKeyword(DataTypeProperty.DISPLAY_NAME, dataType.getDisplayNameMap(), true);
			
			//Debug.printFooter("DataTypeModelDocumentContributor");
	}
	
	@Reference
    private DataTypeLocalService _dataTypeLocalService;
}
