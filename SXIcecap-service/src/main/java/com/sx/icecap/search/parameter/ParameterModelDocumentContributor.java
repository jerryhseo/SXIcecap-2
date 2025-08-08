package com.sx.icecap.search.parameter;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.icecap.model.Parameter;
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
		property = "indexer.class.name=com.sx.icecap.model.Parameter",
		service = ModelDocumentContributor.class
)
public class ParameterModelDocumentContributor implements ModelDocumentContributor<Parameter> {
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public void contribute(Document document, Parameter parameter) {
		/**
		 *  Be sure there is not a single error during the document processing. 
		 *  If any kind errors happen, the indexer would come into sleep 
		 *  without any behavious or warnings and never finish this contribute function.
		 */
		
		document.addDateSortable(Field.MODIFIED_DATE, parameter.getModifiedDate());
		document.addNumber("parameterId", parameter.getParameterId());
	}
	
}
