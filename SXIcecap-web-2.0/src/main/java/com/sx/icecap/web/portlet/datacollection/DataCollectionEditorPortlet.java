package com.sx.icecap.web.portlet.datacollection;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.DataCollectionLocalService;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author jerry
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sx.icecap",
		"com.liferay.portlet.header-portlet-css=/css/index.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Data Collection Editor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+JSPPath.DATA_COLLECTION_EDITOR,
		"javax.portlet.name=" + WebPortletKey.DATA_COLLECTION_EDITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DataCollectionEditorPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		long dataCollectionId = ParamUtil.getLong(renderRequest,WebKey.DATACOLLECTION_ID, 0);
		System.out.println("DataCollectionEditorPortlet - dataCollectionId: " + dataCollectionId);
		
		DataCollection dataCollection = null;
		if( dataCollectionId > 0 ) {
			try {
				dataCollection = _dataCollectionLocalService.getDataCollection(dataCollectionId);
				String jsonDataCollection = JSONFactoryUtil.looseSerialize(dataCollection);
				renderRequest.setAttribute(WebKey.DATATYPE, jsonDataCollection);
			} catch (Exception e) {
				throw new PortletException( "Cannot find data collection: " + dataCollectionId );
			}
		}
		
		renderRequest.setAttribute(WebKey.DATACOLLECTION_ID, dataCollectionId);
		
		renderRequest.setAttribute(
				"mainRequire",
				_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private DataCollectionLocalService _dataCollectionLocalService;
}