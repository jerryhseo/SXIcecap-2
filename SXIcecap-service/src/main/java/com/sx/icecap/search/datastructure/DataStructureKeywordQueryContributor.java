package com.sx.icecap.search.datastructure;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.icecap.constant.DataStructureProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataStructure",
        service = KeywordQueryContributor.class
)
public class DataStructureKeywordQueryContributor implements KeywordQueryContributor {

	@Reference
	protected QueryHelper queryHelper;
	
	@Override
	public void contribute(
			String keywords, 
			BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
//		Debug.printHeader("DataStructureKeywordQueryContributor");
		
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, DataStructureProperties.DATA_STRUCTURE_CODE, true);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, DataStructureProperties.DISPLAY_NAME, false);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, DataStructureProperties.DESCRIPTION, false);
		
//		Debug.printFooter("DataStructureKeywordQueryContributor");
		
	}

}
