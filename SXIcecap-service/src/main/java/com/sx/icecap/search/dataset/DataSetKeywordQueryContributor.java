package com.sx.icecap.search.dataset;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.icecap.constant.DataSetProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataSet",
        service = KeywordQueryContributor.class
)
public class DataSetKeywordQueryContributor implements KeywordQueryContributor {

	@Reference
	protected QueryHelper queryHelper;
	
	@Override
	public void contribute(
			String keywords, 
			BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
//		Debug.printHeader("DataSetKeywordQueryContributor");
		
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, DataSetProperties.DATASET_NAME, true);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, DataSetProperties.DISPLAY_NAME, false);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, DataSetProperties.DESCRIPTION, false);
		
//		Debug.printFooter("DataSetKeywordQueryContributor");
		
	}

}
