package com.sx.icecap.search.datatype;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.DataTypeProperty;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataType",
		service = ModelSummaryContributor.class
)
public class DataTypeModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
//		System.out.println("DataTypeModelSummaryContributor: getSummary");
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("DataTypeModelSummaryContributor: createSummary");
		String title = document.get(DataTypeProperty.DISPLAY_NAME, DataTypeProperty.DATATYPE_VERSION);
		String content = document.get(
				DataTypeProperty.DATATYPE_NAME +
				DataTypeProperty.DESCRIPTION
		);
 
		return new Summary(locale, title, content);
	}
}
