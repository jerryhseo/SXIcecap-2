package com.sx.icecap.web.asset.structureddata;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.JSPPath;
import com.sx.icecap.constant.MVCCommand;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.StructuredData;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StructuredDataAssetRenderer extends BaseJSPAssetRenderer<StructuredData> {

	private final ModelResourcePermission<StructuredData> _structuredDataModelResourcePermission;
    private StructuredData _structuredData;
    
    public StructuredDataAssetRenderer( StructuredData structuredData, ModelResourcePermission<StructuredData> modelResoucePermission ) {
    	_structuredData = structuredData;
    	_structuredDataModelResourcePermission = modelResoucePermission;
    }

	@Override
	public StructuredData getAssetObject() {
		return _structuredData;
	}

	@Override
	public long getGroupId() {
		return _structuredData.getGroupId();
	}

	@Override
	public long getUserId() {
		return _structuredData.getUserId();
	}

	@Override
	public String getUserName() {
		return _structuredData.getUserName();
	}

	@Override
	public String getUuid() {
		return _structuredData.getUuid();
	}

	@Override
	public String getClassName() {
		return StructuredData.class.getName();
	}

	@Override
	public long getClassPK() {
		return _structuredData.getStructuredDataId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return String.valueOf(_structuredData.getStructuredDataId());
	}

	@Override
	public String getTitle(Locale locale) {
		return String.valueOf(_structuredData.getStructuredDataId());
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		if( template.equals(TEMPLATE_FULL_CONTENT) || 
			template.equals(TEMPLATE_ABSTRACT )) {
			
			httpServletRequest.setAttribute(StationXWebKeys.DATATYPE, _structuredData);
			
			return JSPPath.STRUCTURED_DATA_TERMPLATE_PATH + template + ".jsp";
		}
		return null;
	}

	@Override
	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String template) throws Exception {
		httpServletRequest.setAttribute(StationXWebKeys.DATATYPE, _structuredData);
		httpServletRequest.setAttribute(StationXWebKeys.HTML_UTIL, HtmlUtil.getHtml());
		httpServletRequest.setAttribute(StationXWebKeys.STRING_UTIL, new StringUtil());
		return super.include(httpServletRequest, httpServletResponse, template);
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), WebPortletKey.STRUCTURED_DATA_EDITOR,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, MVCCommand.RENDER_DATATYPE_EDITOR);
        portletURL.setParameter(StationXWebKeys.DATACOLLECTION_ID, String.valueOf(_structuredData.getDataCollectionId()));
        portletURL.setParameter(StationXWebKeys.DATASET_ID, String.valueOf(_structuredData.getDataSetId()));
        portletURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_structuredData.getStructuredDataId()));
        portletURL.setParameter(StationXWebKeys.SHOW_BACK, Boolean.FALSE.toString());
        
        return portletURL;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
		return super.getURLView(liferayPortletResponse, windowState);
	}

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
		try {
            long plid = PortalUtil.getPlidFromPortletId(
            		_structuredData.getGroupId(),
                    WebPortletKey.STRUCTURED_DATA_VIEWER);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                		getControlPanelPlid(liferayPortletRequest),
                		WebPortletKey.STRUCTURED_DATA_VIEWER, 
                		PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(
                		liferayPortletRequest,
                		WebPortletKey.STRUCTURED_DATA_VIEWER, 
                		plid, 
                		PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, MVCCommand.RENDER_DATATYPE_VIEWER);
            portletURL.setParameter(StationXWebKeys.DATACOLLECTION_ID, String.valueOf(_structuredData.getDataCollectionId()));
            portletURL.setParameter(StationXWebKeys.DATASET_ID, String.valueOf(_structuredData.getDataSetId()));
            portletURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_structuredData.getStructuredDataId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter(StationXWebKeys.REDIRECT, currentUrl);

            return portletURL.toString();

        } catch (PortalException e) {

        } catch (SystemException e) {
        }

        return noSuchEntryRedirect;
    }

	@Override
	public boolean isPrintable() {
		return true;
	}
    
    
}
