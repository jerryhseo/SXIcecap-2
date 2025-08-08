package com.sx.icecap.web.command.action.datatype.structure.builder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.exception.NoSuchDataTypeException;
import com.sx.icecap.service.DataStructureLocalService;

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
	DataStructureLocalService _dataStructureLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		long dataStructureId = ParamUtil.getLong(actionRequest, WebKey.DATASTRUCTURE_ID, 0);
		
		try {
		_dataStructureLocalService.deleteDataStructure(dataStructureId);
		} catch( PortalException e) {
			throw new PortletException(e.getMessage());
		}
		
		return false;
	}

}
