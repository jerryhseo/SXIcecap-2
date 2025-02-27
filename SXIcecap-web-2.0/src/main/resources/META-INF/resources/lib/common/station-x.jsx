import ClayDropDown from "@clayui/drop-down";
import { Component } from "react";
import { Util } from "./util";

export const EditStatus = {
	UPDATE: "update",
	ADD: "add"
};

export const LiferayProperty = {
	COMPANY_ID: "companyId",
	GROUP_ID: "groupId",
	USER_ID: "userId",
	USER_NAME: "userName",
	CREATE_DATE: "createDate",
	MODIFIED_DATE: "modifiedDate",
	LAST_PUBLISHED_DATE: "lastPublishedDate",
	STATUS: "status",
	STATUS_BY_USER_ID: "statusByUserId",
	STATUS_BY_USER_NAME: "statusByUserName",
	STATUS_DATE: "statusDate"
};

export const DataTypeProperty = {
	ID: "dataTypeId",
	NAME: "dataTypeName",
	VERSION: "dataTypeVersion",
	EXTENSION: "extension",
	DISPLAY_NAME: "displayName",
	DESCRIPTION: "description",
	VISUALIZERS: "visualizers",
	TOOLTIP: "tooltip",
	HAS_STRUCTURE: "hasDataStructure"
};

export const Validator = {
	dataTypeName: (name) => {
		const regexp = /^[a-zA-Z_][a-zA-Z0-9_]*$/;
		return regexp.test(name);
	},
	version: (ver) => {
		return /^\d{1,3}\.\d{1,3}\.\d{1,3}$/.test(ver);
	},
	extension: (ext) => {
		return /^[a-zA-Z0-9]{1,12}$/.test(ext);
	},
	integer: (num, positive = 0) => {
		if (positive > 0) {
			return /^[+]?\d+$/.test(num);
		} else if (positive < 0) {
			return /^-\d+$/.test(num);
		} else {
			return /^-?\d+$/.test(num);
		}
	}
};

export const ValidationRule = {
	VARIABLE: "^[a-zA-Z_][a-zA-Z0-9_]*$",
	VERSION: "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$",
	EXTENSION: "^[a-zA-Z0-9]{1,12}$",
	INTEGER: "^-?d+$",
	INT_POSITIVE: "^[+]?d+$",
	INT_NEGATIVE: "^-d+$",
	NO_SPECIAL_CHARACTERS: "[^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+"
};

export const ValidationKeys = {
	REQUIRED: "required",
	MIN: "min",
	MAX: "max",
	PATTERN: "pattern",
	VALIDATE: "validate"
};

export const ACTION_NAME = "javax.portlet.action";

export const RenderCommandNames = {
	ROOTL: "/",

	DATATYPE_EXPLORER: "/jsp/DTExplorer/datatype-explorer",
	DATATYPE_EDITOR: "/jsp/DTExplorer/datatype-editor",
	SEARCH_DATATYPES: "/jsp/DTExplorer/search-datatypes",
	EDIT_DATATYPE: "/jsp/DTExplorer/edit-datatype",
	DATATYPE_VIEWER: "/jsp/DTViewer/datatype-viewer",
	STRUCTURED_DATA_EXPLORER: "/jsp/SDExplorer/structured-data-explorer",
	STRUCTURED_DATA_ADVANCED_SEARCH: "/jsp/SDExplorer/structured-data-advanced-search",
	SEARCH_STRUCTURED_DATA: "/jsp/SDExplorer/search-structured-data",
	STRUCTURED_DATA_EDITOR: "/jsp/SDEditor/structured-data-editor",
	STRUCTURED_DATA_VIEWER: "/jsp/SDViewer/structured-data-viewer"
};

export const PortletKeys = {
	DATA_WORKBENCH: "com_sx_icecap_web_portlet_DataWorkbenchPortlet",
	DATATYPE_EXPLORER: "com_sx_icecap_web_portlet_DataTypeExplorerPortlet",
	DATATYPE_EDITOR: "com_sx_icecap_web_portlet_DataTypeEditorPortlet",
	DATATYPE_VIEWER: "com_sx_icecap_web_portlet_DataTypeViewerPortlet",
	DATA_STRUCTURE_BUILDER: "com_sx_icecap_web_portlet_DataStructureBuilderPortlet",
	STRUCTURED_DATA_VIEWER: "com_sx_icecap_web_portlet_StructuredDataViewerPortlet",
	STRUCTURED_DATA_EDITOR: "com_sx_icecap_web_portlet_StructuredDataEditorPortlet",
	STRUCTURED_DATA_EXPLORER: "com_sx_icecap_web_portlet_StructuredDataExplorerPortlet"
};

export const ActionNames = {
	COPY_DATATYPE: "/action/DTExplorer/copy-datatype",
	DELETE_DATATYPE: "/action/DTExplorer/delete-datatype",
	ADD_DATATYPE: "/action/DTEditor/add-datatype",
	UPDATE_DATATYPE: "/action/DTEditor/update-datatype",
	DELETE_DATA_STRUCTURE: "/action/DTEditor/delete-data-structure",
	STRUCTURED_DATA_ADVANCED_SEARCH: "/action/SDExplorer/sd-advanced-search",
	DELETE_STRUCTURED_DATA: "/action/SDExplorer/delete-structured-data",
	ADD_STRUCTURED_DATA: "/action/SDEditor/add-structured-data",
	UPDATE_STRUCTURED_DATA: "/action/SDEditor/update-structured-data",
	PUBLISH_STRUCTURED_DATA: "/action/SDEditor/publish-structured-data"
};

export const ParamProperty = {
	ABSTRACT_KEY: "abstractKey",
	ACTIVE: "active",
	ALLOWED_EXTENSIONS: "allowedExtensions",
	AVAILABLE_LANGUAGE_IDS: "availableLanguageIds",
	COLUMNS: "columns",
	COLUMN_WIDTH: "columnWidth",
	COUNTRY_CODE: "countryCode",
	CSS_WIDTH: "cssWidth",
	CSS_CUSTOM: "cssCustom",
	DEFINITION: "definition",
	DEFAULT_LANGUAGE_ID: "defaultLanguageId",
	DEFAULT_LOCALE: "defaultLocale",
	DEFAULT_VALUE: "defaultValue",
	DIMENSION_X: "dimensionX",
	DIMENSION_Y: "dimensionY",
	DISABLED: "disabled",
	DISPLAY_NAME: "displayName",
	DISPLAY_STYLE: "displayStyle",
	DOWNLOADABLE: "downloadable",
	ELEMENT_TYPE: "elementType",
	ENABLE_TIME: "enableTime",
	END_YEAR: "endYear",
	EXPANDED: "expanded",
	FALSE_LABEL: "falseLabel",
	FILE_ID: "fileId",
	FORMAT: "format",
	GRID_COLUMNS: "gridColumns",
	ID: "id",
	INPUT_SIZE: "inputSize",
	ITEM_DISPLAY_NAME: "itemDisplayName",
	LABEL_POSITION: "labelPosition",
	LINE_BREAK: "lineBreak",
	LIST_ITEM: "listItem",
	LIST_ITEM_VALUE: "listItemValue",
	LIST_ITEMS: "listItems",
	LOCALIZED: "localized",
	MASTER_TERM: "masterParameter",
	MAX: "max",
	MAX_BOUNDARY: "maxBoundary",
	MAX_LENGTH: "maxLength",
	MAX_VALUE: "maxValue",
	MIN: "min",
	MIN_BOUNDARY: "minBoundary",
	MIN_LENGTH: "minLength",
	MIN_VALUE: "minValue",
	MULTIPLE: "multiple",
	MULTIPLE_LINE: "multipleLine",
	NAME: "name",
	NUMERIC_PLACE_HOLDER: "numericPlaceHolder",
	OPTION_LABEL: "optionLabel",
	OPTION_VALUE: "optionValue",
	OPTIONS: "options",
	OPTION_SELECTED: "optionSelected",
	ORDER: "order",
	PARAM_NAME: "paramName",
	PARAM_TYPE: "paramType",
	PATH: "path",
	PATH_TYPE: "pathType",
	PATTERN: "pattern",
	PLACE_HOLDER: "placeHolder",
	RANGE: "range",
	READ_ONLY: "readOnly",
	REF_DATATYPES: "refDataTypes",
	REF_DATABASES: "refDatabases",
	REQUIRED: "required",
	ROWS: "rows",
	SEARCHABLE: "searchable",
	SLAVE_TERMS: "slaveParameters",
	START_YEAR: "startYear",
	SWEEPABLE: "sweepable",
	SYNONYMS: "synonyms",
	TEXT: "text",
	TOOLTIP: "tooltip",
	TRUE_LABEL: "trueLabel",
	TYPE: "type",
	UNCERTAINTY: "uncertainty",
	UNCERTAINTY_VALUE: "uncertaintyValue",
	UNIT: "unit",
	URI: "uri",
	URI_TYPE: "uriType",
	URL: "url",
	VALIDATION: "validation",
	VALIDATION_RULE: "validationRule",
	VALUE: "value",
	VALUE_DELIMITER: "valueDelimiter",
	VERSION: "version",
	VIEW_TYPE: "viewType"
};

export const WebKeys = {
	PORTLET_NAME: "portletName"
};

export const DisplayType = {
	NORMAL: "normal",
	INLINE: "inline",
	INLINE_NO_SPACE: "inlineNonSpace",
	FLAT: "flat",
	INLINE_FLAT: "inlineFlat",
	INLINE_FLAT_NON_SPACE: "inlineFlatNonSpace",
	ROW: "row",
	COL: "column"
};

export const ResourceIds = {
	CREATE_PORTLET_INSTANCE: "/ajax/Workflow/create-portlet-instance",
	LOAD_DATATYPES: "/ajax/DTExplorer/load-datatypes",
	LOAD_DATATYPE: "/ajax/DTEditor/load-datatype",
	ADD_DATATYPE: "/ajax/DTEditor/add-datatype",
	UPDATE_DATATYPE: "/ajax/DTEditor/update-datatype",
	DELETE_DATATYPE: "/ajax/DTEditor/delete-datatype",
	DELETE_DATATYPES: "/ajax/DTExplorer/delete-datatypes",
	LOAD_AVAILABLE_VISUALIZERS: "/ajax/DTEditor/load-available-visualizers",
	LOAD_DATA_STRUCTURE: "/ajax/DSBuilder/load-data-structure",
	UPDATE_DATA_STRUCTURE: "/ajax/DSBuilder/save-data-structure",
	DELETE_DATA_STRUCTURE: "/ajax/DSBuilder/delete-data-structure",
	DELETE_TEMP_STRUCTURED_DATA: "/ajax/SDExplorer/delete-temp-file"
};

export const LoadingStatus = {
	PENDING: 1,
	COMPLETE: 0,
	FAIL: -1
};

export const ViewTypes = {
	TABLE: "table",
	LIST: "list",
	CARD: "card",
	HORIZONTAL: "horizontal",
	HORIZONTAL_TABLE: "horizontalTable",
	VERTICAL: "vertical",
	TOGGLE: "toggle",
	DROPDOWN: "dropdown",
	RADIO: "radio",
	CHECKBOX: "checkbox",
	LISTBOX: "listbox"
};

export const Constant = {
	//Purposes of rendering
	FOR_NOTHING: 0,
	FOR_PREVIEW: 1,
	FOR_EDITOR: 2,
	FOR_PDF_DATA: 3,
	FOR_PDF_FORM: 4,
	FOR_SEARCH: 5,

	STOP_EVERY: false,
	CONTINUE_EVERY: true,

	FILTER_SKIP: false,
	FILTER_ADD: true,

	FAIL: false,
	SUCCESS: true,

	SINGLE: false,
	MULTIPLE: true,
	ARRAY: true,

	ERROR: 0,
	WARNING: 1,
	CONFIRM: 2,

	Commands: {
		SX_DOWNLOAD: "SX_DOWNLOAD",
		SX_DOWNLOAD_WITH_IB: "SX_DOWNLOAD_WITH_IB",
		SX_GET_COPIED_TEMP_FILE_PATH: "SX_GET_COPIED_TEMP_FILE_PATH",
		SX_GET_FILE_INFO: "SX_GET_FILE_INFO",
		UPLOAD_TEMP_FILE: "UPLOAD_TEMP_FILE",
		UPLOAD_FILE: "UPLOAD_TEMP_FILE",
		DELETE_DATA_FILE: "DELETE_DATA_FILE",
		UPLOAD_DATA_FILE: "UPLOAD_DATA_FILE"
	},
	SearchOperators: {
		OR: "OR",
		AND: "AND",
		NOT: "NOT",
		RANGE: "RANGE",
		EXACT: "EXACT",
		LIKE: "LIKE",
		ROOT: "ROOT"
	},
	WorkbenchType: {
		SIMULATION_WITH_APP: "SIMULATION_WITH_APP",
		SIMULATION_RERUN: "SIMULATION_RERUN",
		SIMULATION_WORKFLOW: "SIMULATION_WORKFLOW",
		SIMULATION_APP_TEST: "SIMULATION_APP_TEST",
		SIMULATION_WORKFLOW_TEST: "SIMULATION_WORKFLOW_TEST",
		SIMULATION_WITH_WORKFLOW: "SIMULATION_WITH_WORKFLOW",
		ANALYSIS_RERUN_APP: "SIMULATION_APP",
		ANALYSIS_RERUN_WORKFLOW: "SIMULATION_WORKFLOW",
		MONITORING_ANALYSIS: "MONITORING_ANALYSIS",
		MONITORING_RERUN_WORKFLOW: "MONITORING_RERUN_WORKFLOW",
		ANALYSYS: "ANALYSYS",
		CURRICULUM: "CURRICULUM",
		VIRTUAL_LAB: "VIRTUAL_LAB"
	},
	ClusterKey: {
		CLUSTER: "_cluster",
		IS_DEFAULT: "_isDefault"
	},
	LayoutKey: {
		LAYOUT: "LAYOUT",
		SYSTEM: "SYSTEM",
		INPUT: "INPUT",
		LOG: "LOG",
		OUTPUT: "OUTPUT"
	},
	Action: {
		SELECT: "SELECT",
		DEFAULT: "DEFAULT"
	},
	PayloadType: {
		VISUALIZER_READY: "VISUALIZER_READY",
		DATA_STRUCTURE: "DATA_STRUCTURE",
		TERM: "TERM",
		URL: "URL",
		FILE: "FILE",
		DB_CONTENT: "DB_CONTENT",
		SDEDITOR: "SDEDITOR"
	},
	PathType: {
		FULL_PATH: "FULL_PATH",
		RELATIVE_PATH: "RELATIVE_PATH",
		DL_ENTRY: "DL_ENTRY"
	},
	FileType: {
		DL_ENTRY: "DL_ENTRY",
		FILE_NAME: "FILE_NAME",
		CONTENT: "CONTENT",
		EXTENSION: "EXTENSION"
	},
	SweepMethod: {
		BY_SLICE: "slice",
		BY_VALUE: "value"
	},
	DivSection: {
		SWEEP_SLICE_VALUE: "sweepSliceValue"
	},
	OpenStatus: {
		PUBLIC: "pb",
		RESTRICT: "rs",
		PRIVATE: "pr"
	},
	RepositoryTypes: {
		USER_HOME: "USER_HOME",
		USER_JOBS: "USER_JOBS",
		SPYGLASS: "SPYGLASS",
		ICECAP: "ICECAP",
		ICEBUG: "ICEBUG",
		MERIDIAN: "MERIDIAN",
		ICEBREAKER: "ICEBREAKER"
	},
	ProcessStatus: {
		SUCCESS: 0,
		FAIL: -1
	},
	PortType: {
		FILE: "FILE",
		FOLDER: "FOLDER",
		EXT: "EXT",
		INPUT: "input",
		LOG: "log",
		OUTPUT: "output"
	},
	PortStatus: {
		EMPTY: "empty",
		READY: "ready",
		INVALID: "invalid",
		LOG_VALID: "logValid",
		LOG_INVALID: "logInvalid",
		OUTPUT_VALID: "outputValid",
		OUTPUT_INVALID: "outputInvalid"
	},
	JobStatus: {
		PROLIFERATED: "PROLIFERATED",
		CLEAN: "CLEAN",
		DIRTY: "DIRTY",
		SAVED: "SAVED",
		INITIALIZE_FAILED: "INITIALIZE_FAILED",
		INITIALIZED: "INITIALIZED",
		SUBMISSION_FAILED: "SUBMISSION_FAILED",
		QUEUED: "QUEUED",
		SUSPEND_REQUESTED: "SUSPEND_REQUESTED",
		SUSPENDED: "SUSPENDED",
		CANCEL_REQUESTED: "CANCEL_REQUESTED",
		CANCELED: "CANCELED",
		SUCCESS: "SUCCESS",
		RUNNING: "RUNNING",
		FAILED: "FAILED"
	},
	Location: {
		AT_LOCAL: "local",
		AT_SERVER: "server",
		AT_REMOTE: "remote"
	},
	DataStatus: {
		UNCHECK: "uncheck",
		EMPTY: "empty",
		SAVED: "saved",
		INVALID: "invalid",
		VALID: "valid",
		SAVING: "saving",
		DIRTY: "dirty",
		CLEAN: "clean",
		READY: "ready"
	},
	AppType: {
		STATIC_SOLVER: "STATIC_SOLVER",
		DYNAMIC_SOLVER: "DYNAMIC_SOLVER",
		STATIC_CONVERTER: "STATIC_CONVERTER",
		DYNAMIC_CONVERTER: "DYNAMIC_CONVERTER",
		CALCULATOR: "CALCULATOR",
		VISUALIZER: "VISUALIZER"
	},
	WorkflowStatus: {
		INITIALIZE: { code: "INITIALIZE", value: 1702001 },
		CREATED: { code: "CREATED", value: 1702002 },
		UPLOAD: { code: "UPLOAD", value: 1702003 },
		QUEUED: { code: "QUEUED", value: 1702004 },
		RUNNING: { code: "RUNNING", value: 1702005 },
		TRANSFER: { code: "TRANSFER", value: 1702006 },
		PAUSED: { code: "PAUSED", value: 1702009 },
		CANCELED: { code: "CANCELED", value: 1702010 },
		SUCCESS: { code: "SUCCESS", value: 1702011 },
		FAILED: { code: "FAILED", value: 1702012 }
	}
};

export const Event = {
	SX_PREVIEW_DELETE_PARAM: "SX_PREVIEW_DELETE_PARAM",
	SX_PREVIEW_GROUPUP_PARAM: "SX_PREVIEW_GROUPUP_PARAM",
	SX_PREVIEW_COPY_PARAM: "SX_PREVIEW_COPY_PARAM",
	SX_PARAM_SELECTED: "SX_PARAM_SELECTED",
	SX_FORM_UI_SHOW_PARAMS: "SX_FORM_UI_SHOW_PARAMS",
	SX_FORM_UI_CHECKBOX_CHANGED: "SX_FORM_UI_CHECKBOX_CHANGED",
	SX_REMOVE_SLAVE_PARAMS: "SX_REMOVE_SLAVE_PARAMS",
	SX_PARAM_PROPERTY_CHANGED: "SX_PARAM_PROPERTY_CHANGED",
	SX_PARAM_ERROR_FOUND: "SX_PARAM_ERROR_FOUND",
	SX_PARAM_VALUE_CHANGED: "SX_PARAM_PROPERTY_CHANGED",
	SX_FORM_FIELD_FAILED: "SX_FORM_FIELD_FAILED",
	SX_FORM_FIELD_CHANGED: "SX_FORM_FIELD_CHANGED",
	SX_VIEW_TYPE_CHANGED: "SX_VIEW_TYPE_CHANGED",

	LIST_OPTION_PREVIEW_REMOVED: "LIST_OPTION_PREVIEW_REMOVED",
	LIST_OPTION_PREVIEW_ADDED: "LIST_OPTION_PREVIEW_ADDED",
	LIST_OPTION_PREVIEW_CHANGED: "LIST_OPTION_PREVIEW_CHANGED",
	LIST_DISPLAY_STYLE_CHANGED: "LIST_DISPLAY_STYLE_CHANGED",
	LIST_OPTION_PREVIEW_SELECTED: "LIST_OPTION_PREVIEW_SELECTED",
	CHOOSE_SLAVE_PARAMS: "CHOOSE_SLAVE_PARAMS",
	CHOOSE_GROUP_PARAMS: "CHOOSE_GROUP_PARAMS",
	SELECT_GRID_COLUMNS: "SELECT_GRID_COLUMNS",
	GRID_COLUMN_SELECTED: "GRID_COLUMN_SELECTED",

	SEARCH_FROM_DATE_CHANGED: "SEARCH_FROM_DATE_CHANGED",
	SEARCH_TO_DATE_CHANGED: "SEARCH_TO_DATE_CHANGED",
	SEARCH_FROM_NUMERIC_CHANGED: "SEARCH_FROM_NUMERIC_CHANGED",
	SEARCH_TO_NUMERIC_CHANGED: "SEARCH_TO_NUMERIC_CHANGED",
	SEARCH_KEYWORD_REMOVE_ALL: "SEARCH_KEYWORD_REMOVE_ALL",
	SEARCH_KEYWORD_ADDED: "SEARCH_KEYWORD_ADDED",
	SD_DATE_RANGE_SEARCH_STATE_CHANGED: "SD_DATE_RANGE_SEARCH_STATE_CHANGED",
	SEARCH_STATE_CHANGED: "SEARCH_STATE_CHANGED",
	SEARCH_KEYWORD_REMOVED: "SEARCH_KEYWORD_REMOVED",
	SEARCH_KEYWORD_CHANGED: "SEARCH_KEYWORD_CHANGED",
	SEARCH_HISTORY_CHANGED: "SEARCH_HISTORY_CHANGED",
	OPEN_QUERY_EDITOR: "OPEN_QUERY_EDITOR",
	QUERY_CHANGED: "QUERY_CHANGED",
	SHOW_SEARCH_RESULTS: "SHOW_SEARCH_RESULTS",
	SEARCH_QUERY_DELIVER: "SEARCH_QUERY_DELIVER",

	SX_CANCEL_CLICKED: "SX_CANCEL_CLICKED",
	SX_CANCEL_JOB: "SX_CANCEL_JOB",
	SX_CANCEL_SIMULATION: "SX_CANCEL_SIMULATION",
	SX_COPY_JOB: "SX_COPY_JOB",
	SX_REQUEST_COPY_JOB: "SX_REQUEST_COPY_JOB",
	SX_RESPONSE_COPY_JOB: "SX_REQUEST_COPY_JOB",
	SX_REFRESH_URL_CHANGE: "SX_REFRESH_URL_CHANGE",
	SX_CREATE_JOB: "SX_CREATE_JOB",
	SX_CREATE_SIMULATION: "SX_CREATE_SIMULATION",
	SX_DATA_LOADED: "SX_DATA_LOADED",
	SX_DATA_STRUCTURE_CHANGED: "SX_DATA_STRUCTURE_CHANGED",
	SX_DELETE_JOB: "SX_DELETE_JOB",
	SX_DELETE_SIMULATION: "SX_DELETE_SIMULATION",
	SX_DOWNLOAD_FILE: "SX_DOWNLOAD_FILE",
	SX_ERROR: "SX_ERROR",
	SX_EVENTS_REGISTERED: "SX_EVENTS_REGISTERED",
	SX_FILE_DESELECTED: "SX_FILE_DESELECTED",
	SX_FILE_SAVED_AS: "SX_FILE_SAVED_AS",
	SX_FILE_SELECTED: "SX_FILE_SELECTED",
	SX_HANDSHAKE: "SX_HANDSHAKE",
	SX_INITIALIZE: "SX_INITIALIZE",
	SX_JOB_CREATED: "SX_JOB_CREATED",
	SX_JOB_DELETED: "SX_JOB_DELETED",
	SX_JOB_SAVED: "SX_JOB_SAVED",
	SX_JOB_SELECTED: "SX_JOB_SELECTED",
	SX_JOB_STATUS_CHANGED: "SX_JOB_STATUS_CHANGED",
	SX_LOAD_DATA: "SX_LOAD_DATA",
	SX_DISABLE_CONTROLS: "SX_DISABLE_CONTROLS",
	SX_CHECK_MANDATORY: "SX_CHECK_MANDATORY",
	SX_LOAD_FILE: "SX_LOAD_FILE",
	SX_LOAD_HTML: "SX_LOAD_HTML",
	SX_OK_CLICKED: "SX_OK_CLICKED",
	SX_PARAM_VALUE_CHANGED: "SX_PARAM_VALUE_CHANGED",
	SX_PORT_SELECTED: "SX_PORT_SELECTED",
	SX_PORT_STATUS_CHANGED: "SX_PORT_STATUS_CHANGED",
	SX_READ_LOCAL_FILE: "SX_READ_LOCAL_FILE",
	SX_READ_SERVER_FILE: "SX_READ_SERVER_FILE",
	SX_READ_STRUCTURED_DATA_FILE: "SX_READ_STRUCTURED_DATA_FILE",
	SX_REFRESH: "SX_REFRESH",
	SX_REFRESH_SIMULATIONS: "SX_REFRESH_SIMULATIONS",
	SX_REFRESH_JOBS: "SX_REFRESH_JOBS",
	SX_REFRESH_JOB_STATUS: "SX_REFRESH_JOB_STATUS",
	SX_REFRESH_OUTPUT_VIEW: "SX_REFRESH_OUTPUT_VIEW",
	SX_REFRESH_PORTS_STATUS: "SX_REFRESH_PORTS_STATUS",
	SX_REGISTER_EVENTS: "SX_REGISTER_EVENTS",
	SX_REPLACE_PORTLET: "SX_REPLACE_PORTLET",
	SX_REPORT_NAMESPACE: "SX_REPORT_NAMESPACE",
	SX_REQUEST_APP_INFO: "SX_REQUEST_APP_INFO",
	SX_REQUEST_DATA: "SX_REQUEST_DATA",
	SX_REQUEST_DATA_STRUCTURE: "SX_REQUEST_DATA",
	SX_REQUEST_DELETE_FILE: "SX_REQUEST_DELETE_FILE",
	SX_REQUEST_DOWNLOAD: "SX_REQUEST_DOWNLOAD",
	SX_REQUEST_FILE_PATH: "SX_REQUEST_FILE_PATH",
	SX_REQUEST_FILE_URL: "SX_REQUEST_FILE_URL",
	SX_REQUEST_JOB_UUID: "SX_REQUEST_JOB_UUID",
	SX_REQUEST_MONITOR_INFO: "SX_REQUEST_MONITOR_INFO",
	SX_REQUEST_OUTPUT_PATH: "SX_REQUEST_OUTPUT_PATH",
	SX_REQUEST_PATH: "SX_REQUEST_PATH",
	SX_REQUEST_PORT_INFO: "SX_REQUEST_PORT_INFO",
	SX_REQUEST_SAMPLE_CONTENT: "SX_REQUEST_SAMPLE_CONTENT",
	SX_REQUEST_SAMPLE_URL: "SX_REQUEST_SAMPLE_URL",
	SX_REQUEST_SIMULATION_UUID: "SX_REQUEST_SIMULATION_UUID",
	SX_REQUEST_SPREAD_TO_PORT: "SX_REQUEST_SPREAD_TO_PORT",
	SX_REQUEST_UPLOAD: "SX_REQUEST_UPLOAD",
	SX_REQUEST_WORKING_JOB_INFO: "SX_REQUEST_WORKING_JOB_INFO",
	SX_RESPONSE_APP_INFO: "SX_RESPONSE_APP_INFO",
	SX_RESPONSE_DATA: "SX_RESPONSE_DATA",
	SX_RESPONSE_JOB_UUID: "SX_RESPONSE_JOB_UUID",
	SX_RESPONSE_MONITOR_INFO: "SX_RESPONSE_MONITOR_INFO",
	SX_RESPONSE_PORT_INFO: "SX_RESPONSE_PORT_INFO",
	SX_RESPONSE_SIMULATION_UUID: "SX_RESPONSE_SIMULATION_UUID",
	SX_SAMPLE_SELECTED: "SX_SAMPLE_SELECTED",
	SX_SAVEAS_FILE: "SX_SAVEAS_FILE",
	SX_SAVE_SIMULATION: "SX_SAVE_SIMULATION",
	SX_SELECT_LOCAL_FILE: "SX_SELECT_LOCAL_FILE",
	SX_SELECT_SERVER_FILE: "SX_SELECT_SERVER_FILE",
	SX_SHOW_JOB_STATUS: "SX_SHOW_JOB_STATUS",
	SX_SIMULATION_CREATED: "SX_SIMULATION_CREATED",
	SX_SIMULATION_DELETED: "SX_SIMULATION_DELETED",
	SX_SIMULATION_SAVED: "SX_SIMULATION_SAVED",
	SX_SIMULATION_SELECTED: "SX_SIMULATION_SELECTED",
	SX_SUBMIT_SIMULATION: "SX_SUBMIT_SIMULATION",
	SX_SUBMIT_JOB: "SX_SUBMIT_JOB",
	SX_STRUCTURED_DATA_CHANGED: "SX_STRUCTURED_DATA_CHANGED",
	SX_UPLOAD_FILE: "SX_UPLOAD_FILE",
	SX_UPLOAD_SELECTED: "SX_UPLOAD_SELECTED",
	SX_RESPONSE_SAVE_SIMULATION_RESULT: "SX_RESPONSE_SAVE_SIMULATION_RESULT",
	SX_RESPONSE_CREATE_SIMULATION_RESULT: "SX_RESPONSE_CREATE_SIMULATION_RESULT",
	SX_RESPONSE_DELETE_SIMULATION_RESULT: "SX_RESPONSE_DELETE_SIMULATION_RESULT",
	SX_RESPONSE_CREATE_SIMULATION_JOB_RESULT: "SX_RESPONSE_CREATE_SIMULATION_JOB_RESULT",
	SX_RESPONSE_DELETE_SIMULATION_JOB_RESULT: "SX_RESPONSE_DELETE_SIMULATION_JOB_RESULT",
	SX_RESPONSE_CANCLE_SIMULATION_JOB_RESULT: "SX_RESPONSE_CANCLE_SIMULATION_JOB_RESULT",
	SX_REQUEST_SIMULATION_MODAL: "SX_REQUEST_SIMULATION_MODAL",
	SX_RESPONSE_SIMULATION_MODAL: "SX_RESPONSE_SIMULATION_MODAL",
	SX_REQUEST_SIMULATION_EDIT_VIEW: "SX_REQUEST_SIMULATION_EDIT_VIEW",
	SX_RESPONSE_SIMULATION_EDIT_VIEW: "SX_RESPONSE_SIMULATION_EDIT_VIEW",
	SX_REQUEST_DELETE_JOB_VIEW: "SX_REQUEST_DELETE_JOB_VIEW",
	SX_REPONSE_DELETE_JOB_VIEW: "SX_REPONSE_DELETE_JOB_VIEW",
	SX_REQUEST_JOB_EDIT_VIEW: "SX_REQUEST_JOB_EDIT_VIEW",
	SX_RESPONSE_JOB_EDIT_VIEW: "SX_RESPONSE_JOB_EDIT_VIEW",
	SX_REQUEST_JOB_RESULT_VIEW: "SX_REQUEST_JOB_RESULT_VIEW",
	SX_RESPONSE_JOB_RESULT_VIEW: "SX_RESPONSE_JOB_RESULT_VIEW",
	SX_REQUEST_NEW_JOB_VIEW: "SX_REQUEST_NEW_JOB_VIEW",
	SX_RESPONSE_NEW_JOB_VIEW: "SX_RESPONSE_NEW_JOB_VIEW",
	SX_REQUEST_FLOW_LAYOUT_CODE_UPDATE: "SX_FLOW_LAYOUT_CODE_UPDATE",
	SX_RESPONSE_FLOW_LAYOUT_CODE_UPDATE: "SX_FLOW_LAYOUT_CODE_UPDATE",
	SX_RESPONSE_SUBMIT_JOB_RESULT: "SX_RESPONSE_SUBMIT_JOB_RESULT",
	SX_REQUEST_JOB_LOG_VIEW: "SX_REQUEST_JOB_LOG_VIEW",
	SX_RESPONSE_JOB_LOG_VIEW: "SX_RESPONSE_JOB_LOG_VIEW",
	SX_REQUEST_COLLECTION_VIEW: "SX_REQUEST_COLLECTION_VIEW",
	SX_RESPONSE_COLLECTION_VIEW: "SX_RESPONSE_COLLECTION_VIEW",
	SX_REQUEST_JOB_KEY: "SX_REQUEST_JOB_KEY",
	SX_RESPONSE_JOB_KEY: "SX_RESPONSE_JOB_KEY",
	SX_FROM_EDITOR_EVENT: "SX_FROM_EDITOR_EVENT",
	SX_FROM_ANALYZER_EVENT: "SX_FROM_ANALYZER_EVENT",
	SX_REQUEST_JOB_CONTROLL_RESET: "SX_REQUEST_JOB_CONTROLL_RESET",
	SX_RESPONSE_JOB_CONTROLL_RESET: "SX_RESPONSE_JOB_CONTROLL_RESET",
	SX_RESPONSE_CANCLE_JOB_RESULT: "SX_RESPONSE_CANCLE_JOB_RESULT",
	SX_REQUEST_JOB_INPUT_VALIDATION: "SX_REQUEST_JOB_INPUT_VALIDATION",
	SX_RESPONSE_JOB_INPUT_VALIDATION: "SX_RESPONSE_JOB_INPUT_VALIDATION",
	SX_VISUALIZER_READY: "SX_VISUALIZER_READY",
	SX_VISUALIZER_DATA_CHANGED: "SX_VISUALIZER_DATA_CHANGED",
	SX_VISUALIZER_DATA_LOADED: "SX_VISUALIZER_DATA_LOADED",
	SX_VISUALIZER_WAITING: "SX_VISUALIZER_WAITING",
	/*
	fire: (event, dataPacket) => {
		Liferay.fire(event, {
			dataPacket: dataPacket
		});
	},
	*/
	fire: (event, sourcePortletId, targetPortletId, payload) => {
		Liferay.fire(event, {
			dataPacket: Event.createEventDataPacket(sourcePortletId, targetPortletId, payload)
		});
	},
	uniqueOn: (event, handler) => {
		Liferay.detach(event).on(event, handler);
	},
	on: (event, handler) => {
		Liferay.on(event, handler);
	},
	createEventDataPacket: (sourcePortlet, targetPortlet, params) => {
		return {
			sourcePortlet: sourcePortlet,
			targetPortlet: targetPortlet,
			...params
		};
	},
	pickUpDataPacket: (event, namespace, formId, paramName, paramVersion) => {
		if (Util.isEmpty(event.dataPacket)) return;

		if (
			event.dataPacket.targetPortlet !== namespace ||
			event.dataPacket.formId !== formId ||
			event.dataPacket.paramName !== paramName ||
			event.dataPacket.paramVersion !== paramVersion
		) {
			return;
		}

		return event.dataPacket;
	},
	pickUpNamesapceDataPacket: (event, namespace) => {
		if (!event.dataPacket) return;

		if (event.dataPacket.targetPortlet !== namespace) {
			return;
		}

		return event.dataPacket;
	}
};

export const ParamType = {
	/*01.*/ STRING: "String",
	/*02.*/ NUMERIC: "Numeric",
	/*03.*/ BOOLEAN: "Boolean",
	/*04.*/ SELECT: "Select",
	/*05.*/ DUALLIST: "DualList",
	/*06.*/ MATRIX: "Matrix",
	/*07.*/ FILE: "File",
	/*08.*/ ADDRESS: "Address",
	/*09.*/ DATE: "Date",
	/*10.*/ PHONE: "Phone",
	/*11.*/ EMAIL: "EMail",
	/*12.*/ GROUP: "Group",
	/*13.*/ SELECT_GROUP: "SelectGroup",
	/*14.*/ GRID: "Grid",
	/*15.*/ TABLE: "Table",
	/*16.*/ CALCULATOR: "Calculator",
	/*17.*/ REFERENCE: "Reference",
	/*18.*/ LINKER: "Linker",
	/*19.*/ IMAGE: "Image",
	/*20.*/ COMMENT: "Comment"
};

export const WindowState = {
	NORMAL: "normal",
	EXCLUSIVE: "exclusive",
	POPUP: "popup"
};

export const ActionKeys = {
	VIEW_DATATYPE: "REVIEW_DATATYPE",
	ADD_DATATYPE: "ADD_DATATYPE",
	UPDATE_DATATYPE: "UPDATE_DATATYPE",
	DELETE_DATATYPE: "DELETE_DATATYPE",
	APPROVE_DATATYPE: "APPROVE_DATATYPE",
	REVIEW_DATATYPE: "REVIEW_DATATYPE"
};

export const DataStructureProperty = {
	PARAM_DELIMITER: "paramDelimiter",
	PARAM_DELIMITER_POSITION: "paramDelimiterPosition",
	PARAM_VALUE_DELIMITER: "paramValueDelimiter",
	MATRIX_BRACKET_TYPE: "matrixBracketType",
	MATRIX_ELEMENT_DELIMITER: "matrixElementDelimiter",
	COMMENT_CHAR: "commentChar",
	PARAMETERS: "parameters",
	ENABLE_INPUT_STATUS: "enableInputStatus",
	ENABLE_GOTO: "enableGoTo"
};
