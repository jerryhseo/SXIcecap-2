create index IX_71403F87 on SX_ICECAP_DataSet (dataSetName[$COLUMN_LENGTH:75$], dataSetVersion[$COLUMN_LENGTH:75$]);
create index IX_8D1CF5D0 on SX_ICECAP_DataSet (groupId, status);
create index IX_36FAEA0A on SX_ICECAP_DataSet (groupId, userId, status);
create index IX_2C67EAA6 on SX_ICECAP_DataSet (status);
create index IX_1746A8E0 on SX_ICECAP_DataSet (userId, status);
create index IX_B4507DB4 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB84E136 on SX_ICECAP_DataSet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A10C1C84 on SX_ICECAP_DataStructure (dataTypeId, version[$COLUMN_LENGTH:75$]);

create index IX_9AC2FB79 on SX_ICECAP_DataType (dataTypeName[$COLUMN_LENGTH:75$], dataTypeVersion[$COLUMN_LENGTH:75$]);
create index IX_ABFFB328 on SX_ICECAP_DataType (groupId, status);
create index IX_D156CF62 on SX_ICECAP_DataType (groupId, userId, status);
create index IX_39F24A4E on SX_ICECAP_DataType (status);
create index IX_ACEAE088 on SX_ICECAP_DataType (userId, status);
create index IX_71C56B5C on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_512918DE on SX_ICECAP_DataType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5747BFFB on SX_ICECAP_DisverifiedData (dataSetId);
create index IX_6DFD7C75 on SX_ICECAP_DisverifiedData (dataTypeId, groupId, status);
create index IX_9A10FBAF on SX_ICECAP_DisverifiedData (dataTypeId, groupId, userId, status);
create index IX_B5676661 on SX_ICECAP_DisverifiedData (dataTypeId, status);
create index IX_6098399B on SX_ICECAP_DisverifiedData (dataTypeId, userId, status);
create index IX_C836C665 on SX_ICECAP_DisverifiedData (folderId);
create index IX_45C99108 on SX_ICECAP_DisverifiedData (groupId, status);
create index IX_61D4CD42 on SX_ICECAP_DisverifiedData (groupId, userId, status);
create index IX_2A5D506E on SX_ICECAP_DisverifiedData (status);
create index IX_257DC6A8 on SX_ICECAP_DisverifiedData (userId, status);

create index IX_C2E3C35F on SX_ICECAP_Parameter (groupId, status);
create index IX_E5DEB899 on SX_ICECAP_Parameter (groupId, userId, status);
create index IX_2BB1DF6 on SX_ICECAP_Parameter (paramName[$COLUMN_LENGTH:75$], paramVersion[$COLUMN_LENGTH:75$]);
create index IX_E5CBD037 on SX_ICECAP_Parameter (status);
create index IX_EFB86D71 on SX_ICECAP_Parameter (userId, status);
create index IX_37636205 on SX_ICECAP_Parameter (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_93F6A5C7 on SX_ICECAP_Parameter (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3C70BB2 on SX_ICECAP_StructuredData (dataSetFolderId);
create index IX_C255DF64 on SX_ICECAP_StructuredData (dataSetId);
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

create index IX_4883B4C0 on SX_ICECAP_Term (groupId, status);
create index IX_F6EBB8FA on SX_ICECAP_Term (groupId, userId, status);
create index IX_95D19DB6 on SX_ICECAP_Term (status);
create index IX_305706C1 on SX_ICECAP_Term (termName[$COLUMN_LENGTH:75$], termVersion[$COLUMN_LENGTH:75$]);
create index IX_25944BF0 on SX_ICECAP_Term (userId, status);
create index IX_65C19CC4 on SX_ICECAP_Term (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C9D28446 on SX_ICECAP_Term (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5A09A2CF on SX_ICECAP_VisualizerLink (dataTypeId);
create index IX_7EA0C129 on SX_ICECAP_VisualizerLink (visualizerId);