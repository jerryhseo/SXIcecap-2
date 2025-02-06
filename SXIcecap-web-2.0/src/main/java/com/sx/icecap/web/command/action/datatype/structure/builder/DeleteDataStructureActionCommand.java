package com.sx.icecap.web.command.action.datatype.structure.builder;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + WebPortletKey.DATA_STRUCTURE_BUILDER,
				"mvc.command.name=" + MVCCommand.ACTION_DELETE_DATA_STRUCTURE
		},
		service = MVCActionCommand.class
)
public class DeleteDataStructureActionCommand implements MVCActionCommand {
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		long dataTypeId = ParamUtil.getLong(actionRequest, DataTypeProperty.DATATYPE_ID, 0);
		
		_dataTypeLocalService.removeDataStructure(dataTypeId);
		
		return false;
	}

}
