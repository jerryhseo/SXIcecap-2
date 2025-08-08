package com.sx.icecap.search.dataset;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.DataSetProperties;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataSet",
		service = ModelSummaryContributor.class
)
public class DataSetModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
//		System.out.println("DataSetModelSummaryContributor: getSummary");
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("DataSetModelSummaryContributor: createSummary");
		String title = document.get(locale, DataSetProperties.DISPLAY_NAME) + " v." + 
							   document.get(DataSetProperties.DATASET_VERSION);
		String content = document.get(locale, DataSetProperties.DESCRIPTION);
 
		return new Summary(locale, title, content);
	}
}
