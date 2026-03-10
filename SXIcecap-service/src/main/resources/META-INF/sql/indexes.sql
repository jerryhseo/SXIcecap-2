create index IX_3CEC2E14 on SX_ICECAP_ActionHistory (actionModel[$COLUMN_LENGTH:75$], dataId, paramCode[$COLUMN_LENGTH:75$]);

create index IX_F9328426 on SX_ICECAP_CollectionSetLink (dataCollectionId, dataSetId);
create index IX_79A40C5D on SX_ICECAP_CollectionSetLink (dataSetId);
create index IX_431ED648 on SX_ICECAP_CollectionSetLink (groupId, dataCollectionId, dataSetId);
create index IX_A89002FF on SX_ICECAP_CollectionSetLink (groupId, dataSetId);

create index IX_269113EB on SX_ICECAP_DataCollection (dataCollectionCode[$COLUMN_LENGTH:75$], dataCollectionVersion[$COLUMN_LENGTH:75$]);
create index IX_9BBEFF44 on SX_ICECAP_DataCollection (groupId, status);
create index IX_1A863F7E on SX_ICECAP_DataCollection (groupId, userId, status);
create index IX_E033AEB2 on SX_ICECAP_DataCollection (status);
create index IX_2843A0EC on SX_ICECAP_DataCollection (userId, status);
create index IX_79EFA2C0 on SX_ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CC81D942 on SX_ICECAP_DataCollection (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F19DC7F6 on SX_ICECAP_DataComment (commentModel[$COLUMN_LENGTH:75$], dataId, paramCode[$COLUMN_LENGTH:75$]);
create index IX_749B8F8B on SX_ICECAP_DataComment (groupId, commentModel[$COLUMN_LENGTH:75$]);
create index IX_530C4CB3 on SX_ICECAP_DataComment (groupId, status);
create index IX_13E2ADED on SX_ICECAP_DataComment (groupId, userId, status);
create index IX_3727B863 on SX_ICECAP_DataComment (status);
create index IX_366F699D on SX_ICECAP_DataComment (userId, status);
create index IX_AC4C0331 on SX_ICECAP_DataComment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DAADA1F3 on SX_ICECAP_DataComment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_352E1E69 on SX_ICECAP_DataSet (dataSetCode[$COLUMN_LENGTH:75$], dataSetVersion[$COLUMN_LENGTH:75$]);
create index IX_8D1CF5D0 on SX_ICECAP_DataSet (groupId, status);
create index IX_36FAEA0A on SX_ICECAP_DataSet (groupId, userId, status);
create index IX_2C67EAA6 on SX_ICECAP_DataSet (status);
create index IX_1746A8E0 on SX_ICECAP_DataSet (userId, status);
create index IX_B4507DB4 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB84E136 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CBCA3A98 on SX_ICECAP_DataStructure (dataStructureCode[$COLUMN_LENGTH:75$], dataStructureVersion[$COLUMN_LENGTH:75$]);
create index IX_6EB6531F on SX_ICECAP_DataStructure (groupId, status);
create index IX_D058859 on SX_ICECAP_DataStructure (groupId, userId, status);
create index IX_C8A48877 on SX_ICECAP_DataStructure (status);
create index IX_BB74E5B1 on SX_ICECAP_DataStructure (userId, status);
create index IX_5E2CA45 on SX_ICECAP_DataStructure (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5FB31E07 on SX_ICECAP_DataStructure (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5490F8D7 on SX_ICECAP_DataType (dataTypeCode[$COLUMN_LENGTH:75$], dataTypeVersion[$COLUMN_LENGTH:75$]);
create index IX_ABFFB328 on SX_ICECAP_DataType (groupId, status);
create index IX_D156CF62 on SX_ICECAP_DataType (groupId, userId, status);
create index IX_39F24A4E on SX_ICECAP_DataType (status);
create index IX_ACEAE088 on SX_ICECAP_DataType (userId, status);
create index IX_71C56B5C on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_512918DE on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C2E3C35F on SX_ICECAP_Parameter (groupId, status);
create index IX_E5DEB899 on SX_ICECAP_Parameter (groupId, userId, status);
create index IX_64F74D58 on SX_ICECAP_Parameter (paramCode[$COLUMN_LENGTH:75$], paramVersion[$COLUMN_LENGTH:75$]);
create index IX_E5CBD037 on SX_ICECAP_Parameter (status);
create index IX_EFB86D71 on SX_ICECAP_Parameter (userId, status);
create index IX_37636205 on SX_ICECAP_Parameter (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_93F6A5C7 on SX_ICECAP_Parameter (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_587A7195 on SX_ICECAP_SetTypeLink (dataCollectionId);
create index IX_2CA2D578 on SX_ICECAP_SetTypeLink (dataSetId, dataTypeId);
create index IX_26BAA3B1 on SX_ICECAP_SetTypeLink (dataTypeId);
create index IX_3C6A3E93 on SX_ICECAP_SetTypeLink (groupId, dataCollectionId, dataSetId, dataTypeId);
create index IX_4748BC57 on SX_ICECAP_SetTypeLink (groupId, dataSetId);
create index IX_2658619F on SX_ICECAP_SetTypeLink (groupId, dataTypeId);

create index IX_6A13153C on SX_ICECAP_StructureParamLink (dataStructureId);
create index IX_D7648EFC on SX_ICECAP_StructureParamLink (parameterId);

create index IX_90FDABC6 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, dataTypeId, status);
create index IX_BA4CC553 on SX_ICECAP_StructuredData (dataCollectionId, dataSetId, status);
create index IX_86E8D23C on SX_ICECAP_StructuredData (dataCollectionId, status);
create index IX_502EA63D on SX_ICECAP_StructuredData (dataSetId, dataTypeId, status);
create index IX_AD007A4A on SX_ICECAP_StructuredData (dataSetId, status);
create index IX_F0EB8D18 on SX_ICECAP_StructuredData (dataTypeId, status);
create index IX_E392C2AF on SX_ICECAP_StructuredData (groupId, dataCollectionId, dataSetId, dataTypeId, freezed[$COLUMN_LENGTH:75$], status);
create index IX_C3F7D3A on SX_ICECAP_StructuredData (groupId, dataCollectionId, dataSetId, dataTypeId, status);
create index IX_DB8B49C2 on SX_ICECAP_StructuredData (groupId, dataCollectionId, dataSetId, freezed[$COLUMN_LENGTH:75$], status);
create index IX_B04624C7 on SX_ICECAP_StructuredData (groupId, dataCollectionId, dataSetId, status);
create index IX_16A12B43 on SX_ICECAP_StructuredData (groupId, dataCollectionId, dataSetId, verified, status);
create index IX_CA1E9C61 on SX_ICECAP_StructuredData (groupId, dataCollectionId, freezed[$COLUMN_LENGTH:75$], status);
create index IX_9C909348 on SX_ICECAP_StructuredData (groupId, dataCollectionId, status);
create index IX_6D986B9E on SX_ICECAP_StructuredData (groupId, dataCollectionId, verified);
create index IX_16B1ACB1 on SX_ICECAP_StructuredData (groupId, dataSetId, dataTypeId, status);
create index IX_86A28EBE on SX_ICECAP_StructuredData (groupId, dataSetId, status);
create index IX_4B8C0724 on SX_ICECAP_StructuredData (groupId, dataTypeId, status);
create index IX_41F2BDB1 on SX_ICECAP_StructuredData (groupId, status);
create index IX_A1906340 on SX_ICECAP_StructuredData (groupId, userId, dataCollectionId, dataSetId, dataTypeId, status);
create index IX_FF6B63CD on SX_ICECAP_StructuredData (groupId, userId, dataCollectionId, dataSetId, status);
create index IX_317C7C02 on SX_ICECAP_StructuredData (groupId, userId, dataCollectionId, status);
create index IX_FE5C2837 on SX_ICECAP_StructuredData (groupId, userId, dataSetId, dataTypeId, status);
create index IX_5DB5A344 on SX_ICECAP_StructuredData (groupId, userId, dataSetId, status);
create index IX_56DB835E on SX_ICECAP_StructuredData (groupId, userId, dataTypeId, status);
create index IX_C93F40EB on SX_ICECAP_StructuredData (groupId, userId, status);
create index IX_FD9491A5 on SX_ICECAP_StructuredData (status);
create index IX_E9AD45CC on SX_ICECAP_StructuredData (userId, dataCollectionId, dataSetId, dataTypeId, status);
create index IX_7E3EB859 on SX_ICECAP_StructuredData (userId, dataCollectionId, dataSetId, status);
create index IX_27F086F6 on SX_ICECAP_StructuredData (userId, dataCollectionId, status);
create index IX_A13CD5C3 on SX_ICECAP_StructuredData (userId, dataSetId, dataTypeId, status);
create index IX_BE6542D0 on SX_ICECAP_StructuredData (userId, dataSetId, status);
create index IX_C1FD552 on SX_ICECAP_StructuredData (userId, dataTypeId, status);
create index IX_C97E0DF on SX_ICECAP_StructuredData (userId, status);
create index IX_9A33B1F3 on SX_ICECAP_StructuredData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B0D61935 on SX_ICECAP_StructuredData (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_570CBAB6 on SX_ICECAP_TypeVisualizerLink (dataTypeId, visualizerId);
create index IX_2BC9FC03 on SX_ICECAP_TypeVisualizerLink (visualizerId);