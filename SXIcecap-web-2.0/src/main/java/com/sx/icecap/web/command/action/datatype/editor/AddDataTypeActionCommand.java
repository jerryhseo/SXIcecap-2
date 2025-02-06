package com.sx.icecap.web.command.action.datatype.editor;

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
				"javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
				"mvc.command.name=" + MVCCommand.ACTION_ADD_DATATYPE
		},
		service = MVCActionCommand.class
)
public class AddDataTypeActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		System.out.println("AddDataTypeActionCommand");
		
		long dataTypeId = ParamUtil.getLong(actionRequest, DataTypeProperty.DATATYPE_ID, 0);
		String strDataType = ParamUtil.getString(actionRequest, "dataType", "{}");
		
		System.out.println("dataTypeId: " + dataTypeId);
		System.out.println("dataType: " + strDataType);
		/*
		String dataTypeName = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_VERSION);
		String extension = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.EXTENSION);
		Map<Locale, String> displayNameMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapDataTypeAttributes.DISPLAY_NAME);
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapDataTypeAttributes.DESCRIPTION);
		Map<Locale, String> tooltipMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapDataTypeAttributes.TOOLTIP);
		int status = ParamUtil.getInteger(actionRequest, IcecapDataTypeAttributes.STATUS, WorkflowConstants.STATUS_DRAFT);
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "");
		
		DataType savedDataType = null;
		
		ServiceContext sc = ServiceContextFactory.getInstance(DataType.class.getName(), actionRequest);
		*/
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, 
				themeDisplay.getPortletDisplay().getId(), 
				themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		
		String renderCommand = MVCCommand.RENDER_DATATYPE_EXPLORER; 
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand);
		
		/*
		if( dataTypeId == 0 ) {
			savedDataType = _dataTypeLocalService.addDataType (
					dataTypeName, 
					dataTypeVersion,
					extension,
					displayNameMap, 
					descriptionMap, 
					tooltipMap,
					status, 
					sc );
		}
		else {
			savedDataType = _dataTypeLocalService.updateDataType(
					dataTypeId, 
					dataTypeName, 
					dataTypeVersion, 
					extension, 
					displayNameMap, 
					descriptionMap, 
					tooltipMap, 
					status, 
					sc);
		}
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(savedDataType.getDataTypeId()) );
		 */
		
		actionResponse.sendRedirect(renderURL.toString());
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
