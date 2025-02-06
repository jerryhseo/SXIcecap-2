package com.sx.icecap.web.command.action.sd;

import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.MimeResponse.Copy;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + WebPortletKey.STRUCTURED_DATA_EDITOR,
				"mvc.command.name=" + MVCCommand.ACTION_ADD_STRUCTURED_DATA,
				"mvc.command.name=" + MVCCommand.ACTION_UPDATE_STRUCTURED_DATA
		},
		service = MVCActionCommand.class
)
public class SaveStructuredDataActionCommand extends BaseMVCActionCommand {
	
	@Reference
	private DLFileEntryLocalService  _dlFileEntryLocalService;

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Debug.printHeader("SaveStructuredDataActionCommand");
		
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		
		long dataTypeId = ParamUtil.getLong(actionRequest, DataTypeProperty.DATATYPE_ID, 0);
		long structuredDataId = ParamUtil.getLong(actionRequest, WebKey.STRUCTURED_DATA_ID,  0);
		
		String dataContent = ParamUtil.getString(actionRequest, "dataContent", "");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(StructuredData.class.getName(), actionRequest);
		if( structuredDataId == 0 ) {
			StructuredData  storedData = _dataTypeLocalService.addStructuredData(
																		dataTypeId, 
																		dataTypeId, 
																		dataContent, 
																		WorkflowConstants.STATUS_APPROVED, 
																		serviceContext);
			structuredDataId = storedData.getStructuredDataId();
		}
		else {
			StructuredData  storedData = _dataTypeLocalService.updateStructuredData(
					structuredDataId,
					dataTypeId, 
					dataTypeId, 
					dataContent, 
					WorkflowConstants.STATUS_APPROVED, serviceContext);
		}
		
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "");
		
		PortletURL renderURL = actionResponse.createRedirectURL(Copy.ALL);
		
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, MVCCommand.RENDER_STRUCTURED_DATA_EXPLORER);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
		renderURL.setParameter(StationXWebKeys.BACK_URL, backURL );
		
		actionResponse.sendRedirect(renderURL.toString());
		
		Debug.printFooter("SaveStructuredDataActionCommand");
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
