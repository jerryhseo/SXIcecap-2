package com.sx.icecap.web.command.action.sd;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.util.SXPortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + WebPortletKey.STRUCTURED_DATA_EXPLORER,
				"mvc.command.name=" + MVCCommand.ACTION_DELETE_STRUCTURED_DATA
		},
		service = MVCActionCommand.class
)
public class DeleteStructuredDataActionCommand extends BaseMVCActionCommand  {
	
	
	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long structuredDataId = ParamUtil.getLong(actionRequest, StationXWebKeys.STRUCTURED_DATA_ID, 0);
		long dataTypeId = ParamUtil.getLong(actionRequest, WebKey.DATATYPE_ID, 0);
		
		System.out.println("dataTypeId: "+dataTypeId);
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		StructuredData structuredData = null;
		try {
			DataType dataType = this._dataTypeLocalService.getDataType(dataTypeId);
			long dataFileFolderId = this._dataTypeLocalService.getDataFileFolderId(
					themeDisplay.getSiteGroupId(), 
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, 
					dataType.getDataTypeName(), 
					dataType.getDataTypeVersion(), 
					structuredDataId, 
					"", "", null, false);
					

			structuredData = _dataTypeLocalService.removeStructuredData( structuredDataId, dataFileFolderId );
		} catch (PortalException e) {
			throw new PortletException(e.getMessage());
		}
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, 
				themeDisplay.getPortletDisplay().getId(), 
				themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(structuredData.getDataTypeId()) );
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, MVCCommand.RENDER_STRUCTURED_DATA_EXPLORER);
		
		actionResponse.sendRedirect(renderURL.toString());
	}

	@Reference
	DataTypeLocalService _dataTypeLocalService;
}
