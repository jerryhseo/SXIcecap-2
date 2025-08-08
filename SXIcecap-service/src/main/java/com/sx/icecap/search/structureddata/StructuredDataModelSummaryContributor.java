package com.sx.icecap.search.structureddata;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.icecap.constant.StructuredDataProperties;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.StructuredData",
		service = ModelSummaryContributor.class
)
public class StructuredDataModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("StructuredDataModelSummaryContributor: createSummary");
		String title = document.get("structuredDataId" );
		
		String content = document.get( StructuredDataProperties.DATA);
 
		return new Summary(locale, title, content);
	}
}
