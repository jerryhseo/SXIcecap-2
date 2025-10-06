package com.sx.icecap.constant;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author selab-ryu
 */
public class WebPortletKey {

	public static final String SXDataWorkbenchPortlet = "SXDataWorkbenchPortlet";
	public static final String SXDataCollectionExplorerPortlet = "SXDataCollectionExplorerPortlet";
	public static final String SXDataCollectionEditorPortlet = "SXDataCollectionEditorPortlet";
	public static final String SXDataSetExplorerPortlet = "SXDataSetExplorerPortlet";
	public static final String SXDataSetEditorPortlet = "SXDataSetEditorPortlet";
	
	/*
	public static final String DATACOLLECTION_VIEWER = "SXDataCollectionViewerPortlet";
	public static final String DATASET_VIEWER = "SXDataSetViewerPortlet";
	*/
	public static final String SXDataTypeExplorerPortlet = "SXDataTypeExplorerPortlet";
	public static final String SXDataTypeEditorPortlet = "SXDataTypeEditorPortlet";
	/*
	public static final String DATATYPE_VIEWER = "SXDataTypeViewerPortlet";
	public static final String PARAMETER_EXPLORER = "SXParameterExplorerPortlet";
	public static final String PARAMETER_EDITOR = "SXParameterEditorPortlet";
	public static final String PARAMETER_VIEWER = "SXParameterViewerPortlet";
	*/
	public static final String SXDataStructureBuilderPortlet = "SXDataStructureBuilderPortlet";
	public static final String SXStructuredDataEditorPortlet = "SXStructuredDataEditorPortlet";
	public static final String SXStructuredDataExplorerPortlet = "SXStructuredDataExplorerPortlet";
	/*
	public static final String DATASTRUCTURE_EXPLORER = "SXDataStructureExplorerPortlet";
	public static final String DATASTRUCTURE_VIEWER = "SXDataStructureViewerPortlet";
	public static final String STRUCTURED_DATA_VIEWER = "SXStructuredDataViewerPortlet";
	 */
	
	public static final String getNamespace( String portletKey, String instanceId ) {
		if( Validator.isNotNull(instanceId) && !instanceId.isEmpty() ) {
			return "_"+portletKey+"_INSTANCE_"+instanceId+"_";
		}
		else {
			return "_"+portletKey+"_";
		}
	}
}