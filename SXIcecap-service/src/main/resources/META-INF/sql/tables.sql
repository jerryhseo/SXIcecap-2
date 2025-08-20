create table SX_ICECAP_ActionHistory (
	actionHistoryId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	structuredDataId LONG,
	paramName VARCHAR(75) null,
	prevValue VARCHAR(75) null,
	changedValue VARCHAR(75) null,
	action VARCHAR(75) null,
	comment_ VARCHAR(75) null
);

create table SX_ICECAP_CollectionSetLink (
	collectionSetLinkId LONG not null primary key,
	dataCollectionId LONG,
	dataSetId LONG,
	freezed BOOLEAN,
	verified BOOLEAN
);

create table SX_ICECAP_DataCollection (
	uuid_ VARCHAR(75) null,
	dataCollectionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataCollectionName VARCHAR(75) null,
	dataCollectionVersion VARCHAR(75) null,
	displayName STRING null,
	description STRING null
);

create table SX_ICECAP_DataComment (
	dataCommentId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	structuredDataId LONG,
	paramName VARCHAR(75) null,
	parentCommentId LONG,
	comment_ VARCHAR(75) null,
	closed BOOLEAN
);

create table SX_ICECAP_DataSet (
	uuid_ VARCHAR(75) null,
	dataSetId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataSetName VARCHAR(75) null,
	dataSetVersion VARCHAR(75) null,
	displayName STRING null,
	description STRING null
);

create table SX_ICECAP_DataStructure (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataStructureId LONG not null primary key,
	dataStructureName VARCHAR(75) null,
	dataStructureVersion VARCHAR(75) null,
	displayName STRING null,
	description STRING null,
	structure TEXT null
);

create table SX_ICECAP_DataType (
	uuid_ VARCHAR(75) null,
	dataTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataTypeName VARCHAR(75) null,
	dataTypeVersion VARCHAR(75) null,
	displayName STRING null,
	extension VARCHAR(75) null,
	sampleFileId LONG,
	description STRING null,
	tooltip STRING null,
	dataStructureId LONG
);

create table SX_ICECAP_Parameter (
	uuid_ VARCHAR(75) null,
	parameterId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	lastPublishDate DATE null,
	paramName VARCHAR(75) null,
	paramVersion VARCHAR(75) null,
	paramType VARCHAR(75) null,
	displayName STRING null,
	definition STRING null,
	tooltip STRING null,
	synonyms VARCHAR(75) null,
	typeProperties VARCHAR(75) null,
	standard BOOLEAN
);

create table SX_ICECAP_SetTypeLink (
	setTypeLinkId LONG not null primary key,
	dataSetId LONG,
	dataTypeId LONG,
	freezed BOOLEAN,
	verified BOOLEAN
);

create table SX_ICECAP_StructureParamLink (
	structureParamLinkId LONG not null primary key,
	dataStructureId LONG,
	parameterId LONG
);

create table SX_ICECAP_StructuredData (
	uuid_ VARCHAR(75) null,
	structuredDataId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	dataCollectionId LONG,
	dataSetId LONG,
	dataTypeId LONG,
	multiple BOOLEAN,
	startIndex LONG,
	count INTEGER,
	freezed BOOLEAN,
	verified BOOLEAN,
	data_ VARCHAR(75) null
);

create table SX_ICECAP_TypeStructureLink (
	dataTypeId LONG not null primary key,
	dataStructureId LONG,
	commentable BOOLEAN,
	verifiable BOOLEAN,
	freezable BOOLEAN,
	freezed BOOLEAN,
	freezedUserId LONG,
	freezedDate DATE null,
	verified BOOLEAN,
	verifiedUserId LONG,
	verifiedDate DATE null,
	inputStatus BOOLEAN,
	jumpTo BOOLEAN
);

create table SX_ICECAP_TypeVisualizerLink (
	typeVisualizerLinkId LONG not null primary key,
	dataTypeId LONG,
	visualizerId LONG
);