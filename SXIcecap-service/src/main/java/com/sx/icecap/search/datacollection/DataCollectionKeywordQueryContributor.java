package com.sx.icecap.search.datacollection;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.icecap.constant.DataCollectionProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataCollection",
        service = KeywordQueryContributor.class
)
public class DataCollectionKeywordQueryContributor implements KeywordQueryContributor {

	@Reference
	protected QueryHelper queryHelper;
	
	@Override
	public void contribute(
			String keywords, 
			BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
//		Debug.printHeader("DataCollectionKeywordQueryContributor");
		
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, DataCollectionProperties.DATA_COLLECTION_NAME, true);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, DataCollectionProperties.DISPLAY_NAME, false);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, DataCollectionProperties.DESCRIPTION, false);
		
//		Debug.printFooter("DataCollectionKeywordQueryContributor");
		
	}

}
