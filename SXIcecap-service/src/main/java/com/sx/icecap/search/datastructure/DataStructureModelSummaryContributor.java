package com.sx.icecap.search.datastructure;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.DataStructureProperties;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataStructure",
		service = ModelSummaryContributor.class
)
public class DataStructureModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
//		System.out.println("DataStructureModelSummaryContributor: getSummary");
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("DataStructureModelSummaryContributor: createSummary");
		String title = document.get(locale, DataStructureProperties.DISPLAY_NAME) + " v." + 
							   document.get(DataStructureProperties.DATA_STRUCTURE_VERSION);
		String content = document.get(locale, DataStructureProperties.DESCRIPTION);
 
		return new Summary(locale, title, content);
	}
}
