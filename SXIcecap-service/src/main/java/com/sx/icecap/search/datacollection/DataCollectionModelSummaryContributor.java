package com.sx.icecap.search.datacollection;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.DataCollectionProperties;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataCollection",
		service = ModelSummaryContributor.class
)
public class DataCollectionModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
//		System.out.println("DataCollectionModelSummaryContributor: getSummary");
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("DataCollectionModelSummaryContributor: createSummary");
		String title = document.get(locale, DataCollectionProperties.DISPLAY_NAME) + " v." + 
							   document.get(DataCollectionProperties.DATA_COLLECTION_VERSION);
		String content = document.get(locale, DataCollectionProperties.DESCRIPTION);
 
		return new Summary(locale, title, content);
	}
}
