package com.sx.icecap.web.command.action.datatype.structure.builder;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.exception.NoSuchDataTypeException;
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
		
			try {
				_dataTypeLocalService.deleteDataStructure(dataTypeId);
			} catch (NoSuchDataStructureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

}
