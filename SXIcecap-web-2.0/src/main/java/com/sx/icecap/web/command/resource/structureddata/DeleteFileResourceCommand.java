package com.sx.icecap.web.command.resource.structureddata;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.WebPortletKey;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.STRUCTURED_DATA_EDITOR,
	        "mvc.command.name="+MVCCommand.RESOURCE_DELETE_STRUCTURED_DATA_FILE
	    },
	    service = MVCResourceCommand.class
)
public class DeleteFileResourceCommand extends BaseMVCResourceCommand {
	@Reference
	DLAppService _dlAppService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long fileId = ParamUtil.getLong(resourceRequest, "fileId");
		
		
		PrintWriter pw = resourceResponse.getWriter();
		try {
			_dlAppService.deleteFileEntry(fileId);
			pw.write("file deleted successfully....");
		} catch( PortalException e ) {
			pw.write("Failed to delete file:" + fileId);
		} finally {
			pw.flush();
			pw.close();
		}
		
	}
}
