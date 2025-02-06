package com.sx.icecap.constant;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author selab-ryu
 */
public class WebPortletKey {

	public static final String TERM_ADMIN = "com_sx_icecap_web_portlet_TermAdminPortlet";
	public static final String DATA_WORKBENCH = "com_sx_icecap_web_portlet_DataWorkbenchPortlet";
	public static final String DATATYPE_EXPLORER = "com_sx_icecap_web_portlet_DataTypeExplorerPortlet";
	public static final String DATATYPE_EDITOR = "com_sx_icecap_web_portlet_DataTypeEditorPortlet";
	public static final String DATATYPE_VIEWER = "com_sx_icecap_web_portlet_DataTypeViewerPortlet";
	public static final String DATA_STRUCTURE_BUILDER = "com_sx_icecap_web_portlet_DataStructureBuilderPortlet";
	public static final String STRUCTURED_DATA_VIEWER = "com_sx_icecap_web_portlet_StructuredDataViewerPortlet";
	public static final String STRUCTURED_DATA_EDITOR = "com_sx_icecap_web_portlet_StructuredDataEditorPortlet";
	public static final String STRUCTURED_DATA_EXPLORER = "com_sx_icecap_web_portlet_StructuredDataExplorerPortlet";
	public static final String QUERY_EDITOR_PORTLET = "com_sx_icecap_web_portlet_QueryEditorPortlet";
	
	
	public static final String getNamespace( String portletKey, String instanceId ) {
		if( Validator.isNotNull(instanceId) && !instanceId.isEmpty() ) {
			return "_"+portletKey+"_INSTANCE_"+instanceId+"_";
		}
		else {
			return "_"+portletKey+"_";
		}
	}
}