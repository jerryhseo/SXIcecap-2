package com.sx.icecap.web.command.action.datatype.explorer;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + WebPortletKey.DATATYPE_EXPLORER,
				"mvc.command.name=" + MVCCommand.ACTION_DELETE_DATATYPE
		},
		service = MVCActionCommand.class
)
public class DeleteDataTypeActionCommand implements MVCActionCommand {

	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		
		long dataTypeId = dataTypeId = ParamUtil.getLong(actionRequest, DataTypeProperty.DATATYPE_ID, 0);
		
		try {
			_dataTypeLocalService.removeDataType(dataTypeId);
		} catch (Exception e) {
			throw new PortletException( e.getMessage() );
		}
		
		return false;
	}

}
