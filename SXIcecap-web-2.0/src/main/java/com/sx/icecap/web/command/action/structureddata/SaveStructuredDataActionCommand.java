package com.sx.icecap.web.command.action.structureddata;

import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.StructuredDataProperties;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;

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
		
		long dataCollectionId = ParamUtil.getLong(actionRequest, WebKey.DATACOLLECTION_ID, 0);
		long dataSetId = ParamUtil.getLong(actionRequest, WebKey.DATASET_ID, 0);
		long dataTypeId = ParamUtil.getLong(actionRequest, DataTypeProperties.DATATYPE_ID, 0);
		long structuredDataId = ParamUtil.getLong(actionRequest, WebKey.STRUCTURED_DATA_ID,  0);
		boolean multiple = ParamUtil.getBoolean(actionRequest, StructuredDataProperties.MULTIPLE,  false);
		long startIndex = ParamUtil.getLong(actionRequest, StructuredDataProperties.START_INDEX,  0);
		int count = ParamUtil.getInteger(actionRequest, StructuredDataProperties.COUNT,  0);
		boolean freezed = ParamUtil.getBoolean(actionRequest, StructuredDataProperties.FREEZED,  false);
		boolean verified = ParamUtil.getBoolean(actionRequest, StructuredDataProperties.VERIFIED,  true);
		
		String dataContent = ParamUtil.getString(actionRequest, "dataContent", "");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(StructuredData.class.getName(), actionRequest);
		if( structuredDataId == 0 ) {
			StructuredData  storedData = _structuredDataLocalService.addStructuredData(
																		dataCollectionId, 
																		dataSetId, 
																		dataTypeId, 
																		multiple,
																		startIndex,
																		count,
																		freezed,
																		verified,
																		dataContent, 
																		WorkflowConstants.STATUS_APPROVED, 
																		serviceContext);
			structuredDataId = storedData.getStructuredDataId();
		}
		else {
			StructuredData  storedData = _structuredDataLocalService.updateStructuredData(
					structuredDataId,
					dataCollectionId, 
					dataSetId, 
					dataTypeId, 
					multiple,
					startIndex,
					count,
					freezed,
					verified,
					dataContent, 
					WorkflowConstants.STATUS_APPROVED, serviceContext);
		}
		
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "");
		
		PortletURL renderURL = actionResponse.createRedirectURL(Copy.ALL);
		
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, MVCCommand.RENDER_STRUCTURED_DATA_EXPLORER);
		renderURL.setParameter(StationXWebKeys.DATACOLLECTION_ID, String.valueOf(dataCollectionId) );
		renderURL.setParameter(StationXWebKeys.DATASET_ID, String.valueOf(dataSetId) );
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
		renderURL.setParameter(StationXWebKeys.STRUCTURED_DATA_ID, String.valueOf(structuredDataId) );
		renderURL.setParameter(StationXWebKeys.BACK_URL, backURL );
		
		actionResponse.sendRedirect(renderURL.toString());
		
		Debug.printFooter("SaveStructuredDataActionCommand");
	}
	
	@Reference
	private StructuredDataLocalService _structuredDataLocalService;

}
