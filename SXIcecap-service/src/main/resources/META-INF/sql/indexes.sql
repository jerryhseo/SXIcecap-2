create index IX_A0A1A978 on SX_ICECAP_ActionHistory (structuredDataId, paramName[$COLUMN_LENGTH:75$]);

create index IX_E4B3423D on SX_ICECAP_CollectionSetLink (dataCollectionId);
create index IX_79A40C5D on SX_ICECAP_CollectionSetLink (dataSetId);

create index IX_9299BE13 on SX_ICECAP_DataCollection (dataCollectionName[$COLUMN_LENGTH:75$]);
create index IX_9BBEFF44 on SX_ICECAP_DataCollection (groupId, status);
create index IX_1A863F7E on SX_ICECAP_DataCollection (groupId, userId, status);
create index IX_E033AEB2 on SX_ICECAP_DataCollection (status);
create index IX_2843A0EC on SX_ICECAP_DataCollection (userId, status);
create index IX_79EFA2C0 on SX_ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CC81D942 on SX_ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B4FC1041 on SX_ICECAP_DataComment (structuredDataId, paramName[$COLUMN_LENGTH:75$]);

create index IX_71403F87 on SX_ICECAP_DataSet (dataSetName[$COLUMN_LENGTH:75$], dataSetVersion[$COLUMN_LENGTH:75$]);
create index IX_8D1CF5D0 on SX_ICECAP_DataSet (groupId, status);
create index IX_36FAEA0A on SX_ICECAP_DataSet (groupId, userId, status);
create index IX_2C67EAA6 on SX_ICECAP_DataSet (status);
create index IX_1746A8E0 on SX_ICECAP_DataSet (userId, status);
create index IX_B4507DB4 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB84E136 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_12FA8D36 on SX_ICECAP_DataStructure (dataStructureName[$COLUMN_LENGTH:75$], dataStructureVersion[$COLUMN_LENGTH:75$]);
create index IX_6EB6531F on SX_ICECAP_DataStructure (groupId, status);
create index IX_D058859 on SX_ICECAP_DataStructure (groupId, userId, status);
create index IX_C8A48877 on SX_ICECAP_DataStructure (status);
create index IX_BB74E5B1 on SX_ICECAP_DataStructure (userId, status);
create index IX_5E2CA45 on SX_ICECAP_DataStructure (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5FB31E07 on SX_ICECAP_DataStructure (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_758501AC on SX_ICECAP_DataType (dataStructureId);
create index IX_9AC2FB79 on SX_ICECAP_DataType (dataTypeName[$COLUMN_LENGTH:75$], dataTypeVersion[$COLUMN_LENGTH:75$]);
create index IX_ABFFB328 on SX_ICECAP_DataType (groupId, status);
create index IX_D156CF62 on SX_ICECAP_DataType (groupId, userId, status);
create index IX_39F24A4E on SX_ICECAP_DataType (status);
create index IX_ACEAE088 on SX_ICECAP_DataType (userId, status);
create index IX_71C56B5C on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_512918DE on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C2E3C35F on SX_ICECAP_Parameter (groupId, status);
create index IX_E5DEB899 on SX_ICECAP_Parameter (groupId, userId, status);
create index IX_2BB1DF6 on SX_ICECAP_Parameter (paramName[$COLUMN_LENGTH:75$], paramVersion[$COLUMN_LENGTH:75$]);
create index IX_E5CBD037 on SX_ICECAP_Parameter (status);
create index IX_EFB86D71 on SX_ICECAP_Parameter (userId, status);
create index IX_37636205 on SX_ICECAP_Parameter (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_93F6A5C7 on SX_ICECAP_Parameter (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CB6CF005 on SX_ICECAP_SetTypeLink (dataSetId);
create index IX_26BAA3B1 on SX_ICECAP_SetTypeLink (dataTypeId);

create index IX_6A13153C on SX_ICECAP_StructureParamLink (dataStructureId);
create index IX_D7648EFC on SX_ICECAP_StructureParamLink (parameterId);

create index IX_679E78B0 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, dataTypeId, groupId, status);
create index IX_7CBB8CEA on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, dataTypeId, groupId, userId, status);
create index IX_90FDABC6 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, dataTypeId, status);
create index IX_37194A00 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, dataTypeId, userId, status);
create index IX_FFAECDC3 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, groupId, status);
create index IX_BEBB1EFD on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, groupId, userId, status);
create index IX_BA4CC553 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, status);
create index IX_F9F0868D on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, userId, status);
create index IX_6AB836FA on SX_ICECAP_StructuredData (dataCollectionId, groupId, status);
create index IX_FCFF6134 on SX_ICECAP_StructuredData (dataCollectionId, groupId, userId, status);
create index IX_86E8D23C on SX_ICECAP_StructuredData (dataCollectionId, status);
create index IX_92099A76 on SX_ICECAP_StructuredData (dataCollectionId, userId, status);
create index IX_50A5419 on SX_ICECAP_StructuredData (dataSetId, dataTypeId, groupId, status);
create index IX_DA2DEF53 on SX_ICECAP_StructuredData (dataSetId, dataTypeId, groupId, userId, status);
create index IX_502EA63D on SX_ICECAP_StructuredData (dataSetId, dataTypeId, status);
create index IX_867FDD77 on SX_ICECAP_StructuredData (dataSetId, dataTypeId, userId, status);
create index IX_BCC1BEAC on SX_ICECAP_StructuredData (dataSetId, groupId, status);
create index IX_642716E6 on SX_ICECAP_StructuredData (dataSetId, groupId, userId, status);
create index IX_AD007A4A on SX_ICECAP_StructuredData (dataSetId, status);
create index IX_B5B75484 on SX_ICECAP_StructuredData (dataSetId, userId, status);
create index IX_6E43F39E on SX_ICECAP_StructuredData (dataTypeId, groupId, status);
create index IX_82E639D8 on SX_ICECAP_StructuredData (dataTypeId, groupId, userId, status);
create index IX_F0EB8D18 on SX_ICECAP_StructuredData (dataTypeId, status);
create index IX_FD81B952 on SX_ICECAP_StructuredData (dataTypeId, userId, status);
create index IX_41F2BDB1 on SX_ICECAP_StructuredData (groupId, status);
create index IX_C93F40EB on SX_ICECAP_StructuredData (groupId, userId, status);
create index IX_FD9491A5 on SX_ICECAP_StructuredData (status);
create index IX_C97E0DF on SX_ICECAP_StructuredData (userId, status);
create index IX_9A33B1F3 on SX_ICECAP_StructuredData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B0D61935 on SX_ICECAP_StructuredData (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D471D059 on SX_ICECAP_TypeStructureLink (dataStructureId);

create index IX_D217CC29 on SX_ICECAP_TypeVisualizerLink (dataTypeId);
create index IX_2BC9FC03 on SX_ICECAP_TypeVisualizerLink (visualizerId);