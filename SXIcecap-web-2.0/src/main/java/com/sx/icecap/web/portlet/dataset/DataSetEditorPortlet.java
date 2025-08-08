package com.sx.icecap.web.portlet.dataset;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.service.DataSetLocalService;

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
		"com.liferay.portlet.display-category=category.icecap",
		"com.liferay.portlet.header-portlet-css=/css/index.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Data Set Editor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+JSPPath.DATASET_EDITOR,
		"javax.portlet.name=" + WebPortletKey.DATASET_EDITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DataSetEditorPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		long dataSetId = ParamUtil.getLong(renderRequest, WebKey.DATASET_ID, 0);
		System.out.println("DataSetEditorPortlet - dataSetId: " + dataSetId);
		
		DataSet dataSet = null;
		if( dataSetId > 0 ) {
			try {
				dataSet = _dataSetLocalService.getDataSet(dataSetId);
				String jsonDataSet = JSONFactoryUtil.looseSerialize(dataSet);
				renderRequest.setAttribute(WebKey.DATASET, jsonDataSet);
			} catch (Exception e) {
				throw new PortletException( "Cannot find dataset: " + dataSetId );
			}
		}
		
		renderRequest.setAttribute(WebKey.DATASET_ID, dataSetId);
		
		renderRequest.setAttribute(
				"mainRequire",
				_npmResolver.resolveModuleName("sx-icecap-web") + " as main");
		
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private DataSetLocalService _dataSetLocalService;
}