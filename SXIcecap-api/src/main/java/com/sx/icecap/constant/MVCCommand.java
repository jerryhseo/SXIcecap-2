package com.sx.icecap.constant;

public class MVCCommand {
	public static final String RENDER_ROOT = "/";

	public static final String RENDER_DATATYPE_EXPLORER = "/jsp/DTExplorer/datatype-explorer";
	public static final String RENDER_DATATYPE_EDITOR = "/jsp/DTExplorer/datatype-editor";
	public static final String RENDER_SEARCH_DATATYPES = "/jsp/DTExplorer/search-datatypes";
	public static final String RENDER_EDIT_DATATYPE = "/jsp/DTExplorer/edit-datatype";
	public static final String ACTION_COPY_DATATYPE = "/action/DTExplorer/copy-datatype";
	public static final String ACTION_DELETE_DATATYPE = "/action/DTExplorer/delete-datatype";
	public static final String RESOURCE_LOAD_DATATYPES = "/ajax/DTExplorer/load-datatypes";

	public static final String ACTION_ADD_DATATYPE = "/action/DTEditor/add-datatype";
	public static final String ACTION_UPDATE_DATATYPE = "/action/DTEditor/update-datatype";
	public static final String ACTION_DELETE_DATA_STRUCTURE = "/action/DTEditor/delete-data-structure";
	public static final String RESOURCE_LOAD_DATATYPE = "/ajax/DTEditor/load-datatype";
	public static final String RESOURCE_ADD_DATATYPE = "/ajax/DTEditor/add-datatype";
	public static final String RESOURCE_UPDATE_DATATYPE = "/ajax/DTEditor/update-datatype";
	public static final String RESOURCE_DELETE_DATATYPE = "/ajax/DTEditor/delete-datatype";
	public static final String RESOURCE_LOAD_AVAILABLE_VISUALIZERS = "/ajax/DTEditor/load-available-visualizers";

	public static final String RENDER_DATA_STRUCTURE_BUILDER = "/jsp/DSBuilder/data-structure-builder";
	public static final String RESOURCE_LOAD_DATA_STRUCTURE = "/ajax/DSBuilder/load-data-structure";
	public static final String RESOURCE_UPDATE_DATA_STRUCTURE = "/ajax/DSBuilder/save-data-structure";
	public static final String RESOURCE_DELETE_DATA_STRUCTURE = "/ajax/DSBuilder/delete-data-structure";
	
	public static final String RENDER_DATATYPE_VIEWER = "/jsp/DTViewer/datatype-viewer";
	
	public static final String RENDER_STRUCTURED_DATA_EXPLORER = "/jsp/SDExplorer/structured-data-explorer";
	public static final String RENDER_STRUCTURED_DATA_ADVANCED_SEARCH = "/jsp/SDExplorer/structured-data-advanced-search";
	public static final String RENDER_SEARCH_STRUCTURED_DATA= "/jsp/SDExplorer/search-structured-data";
	public static final String ACTION_STRUCTURED_DATA_ADVANCED_SEARCH = "/action/SDExplorer/sd-advanced-search";
	public static final String ACTION_DELETE_STRUCTURED_DATA = "/action/SDExplorer/delete-structured-data";
	public static final String RESOURCE_DELETE_TEMP_STRUCTURED_DATA = "/ajax/SDExplorer/delete-temp-file";
	
	public static final String RENDER_STRUCTURED_DATA_EDITOR = "/jsp/SDEditor/structured-data-editor";
	public static final String ACTION_ADD_STRUCTURED_DATA = "/action/SDEditor/add-structured-data";
	public static final String ACTION_UPDATE_STRUCTURED_DATA = "/action/SDEditor/update-structured-data";
	public static final String ACTION_PUBLISH_STRUCTURED_DATA = "/action/SDEditor/publish-structured-data";
	public static final String RESOURCE_ADD_STRUCTURED_DATA = "/ajax/SDEditor/add";
	public static final String RESOURCE_UPDATE_STRUCTURED_DATA = "/ajax/SDEditor/update";
	public static final String RESOURCE_DELETE_STRUCTURED_DATA_FILE = "/ajax/SDEditor/delete-file";
	public static final String RESOURCE_SAVE_STRUCTURED_DATA = "/ajax/SDEditor/save";
	public static final String RESOURCE_UPLOAD_STRUCTURED_DATA_FILE = "/ajax/SDEditor/upload-file";
	
	public static final String RENDER_STRUCTURED_DATA_VIEWER = "/jsp/SDViewer/structured-data-viewer";
	
	public static final String RESOURCE_CREATE_PORTLET_INSTANCE = "/ajax/workbench/create-portlet-instance";
	public static final String RESOURCE_VISUALIZER_COMMON = "/ajax/visualizer/common-resource";
}
