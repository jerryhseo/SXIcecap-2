package com.sx.icecap.web.command.action.datatype.explorer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.MVCCommand;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + WebPortletKey.DATATYPE_EXPLORER,
				"javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
				"mvc.command.name=" + MVCCommand.ACTION_COPY_DATATYPE
		},
		service = MVCActionCommand.class
)
public class CopyDataTypeActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long dataTypeId = ParamUtil.getLong(actionRequest, DataTypeProperty.DATATYPE_ID, 0);
		
		DataType copiedDataType = null;
		
		ServiceContext sc = ServiceContextFactory.getInstance(DataType.class.getName(), actionRequest);
		
		copiedDataType = _dataTypeLocalService.copyDataType ( dataTypeId, sc );
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
