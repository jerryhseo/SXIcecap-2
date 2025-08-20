package com.sx.icecap.web.command.resource.datatype.editor;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebKey;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.TypeStructureLink;
import com.sx.icecap.model.TypeVisualizerLink;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.TypeStructureLinkLocalService;
import com.sx.icecap.service.TypeVisualizerLinkLocalService;
import com.sx.spyglass.model.ScienceApp;
import com.sx.spyglass.service.ScienceAppLocalService;
import com.sx.util.SXLocalizationUtil;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATATYPE_EDITOR,
	        "mvc.command.name="+MVCCommand.RESOURCE_LOAD_DATATYPE
	    },
	    service = MVCResourceCommand.class
)
public class LoadDataTypeResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		System.out.println("LoadDataTypeResourceCommand");
		
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private TypeVisualizerLinkLocalService _typeVisualizerLinkLocalService;
	
	@Reference
	private ScienceAppLocalService _scienceAppLocalService;
	
	@Reference
	private TypeStructureLinkLocalService _typeStructureLinkLocalService;
}
