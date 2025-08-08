package com.sx.icecap.constant;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author selab-ryu
 */
public class WebPortletKey {

	public static final String DATA_WORKBENCH = "com_sx_icecap_web_portlet_DataWorkbenchPortlet";
	public static final String DATA_COLLECTION_EXPLORER = "com_sx_icecap_web_portlet_DataCollectionExplorerPortlet";
	public static final String DATA_COLLECTION_EDITOR = "com_sx_icecap_web_portlet_DataCollectionEditorPortlet";
	public static final String DATA_COLLECTION_VIEWER = "com_sx_icecap_web_portlet_DataCollectionViewerPortlet";
	public static final String DATASET_EXPLORER = "com_sx_icecap_web_portlet_DataSetExplorerPortlet";
	public static final String DATASET_EDITOR = "com_sx_icecap_web_portlet_DataSetEditorPortlet";
	public static final String DATASET_VIEWER = "com_sx_icecap_web_portlet_DataSetViewerPortlet";
	public static final String DATATYPE_EXPLORER = "com_sx_icecap_web_portlet_DataTypeExplorerPortlet";
	public static final String DATATYPE_EDITOR = "com_sx_icecap_web_portlet_DataTypeEditorPortlet";
	public static final String DATATYPE_VIEWER = "com_sx_icecap_web_portlet_DataTypeViewerPortlet";
	public static final String PARAMETER_EXPLORER = "com_sx_icecap_web_portlet_ParameterExplorerPortlet";
	public static final String PARAMETER_EDITOR = "com_sx_icecap_web_portlet_ParameterEditorPortlet";
	public static final String PARAMETER_VIEWER = "com_sx_icecap_web_portlet_ParameterViewerPortlet";
	public static final String DATA_STRUCTURE_BUILDER = "com_sx_icecap_web_portlet_DataStructureBuilderPortlet";
	public static final String DATA_STRUCTURE_EXPLORER = "com_sx_icecap_web_portlet_DataStructureExplorerPortlet";
	public static final String STRUCTURED_DATA_EXPLORER = "com_sx_icecap_web_portlet_StructuredDataExplorerPortlet";
	public static final String STRUCTURED_DATA_EDITOR = "com_sx_icecap_web_portlet_StructuredDataEditorPortlet";
	public static final String STRUCTURED_DATA_VIEWER = "com_sx_icecap_web_portlet_StructuredDataViewerPortlet";
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