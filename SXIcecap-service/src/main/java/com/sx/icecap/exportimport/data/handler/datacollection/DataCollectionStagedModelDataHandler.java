package com.sx.icecap.exportimport.data.handler.datacollection;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.DataCollectionLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class DataCollectionStagedModelDataHandler extends BaseStagedModelDataHandler<DataCollection> {
	@Reference(unbind = "-")
	protected void setDataCollectionLocalService(DataCollectionLocalService dataCollectionLocalService) {

		_dataCollectionLocalService = dataCollectionLocalService;
	}
	private DataCollectionLocalService _dataCollectionLocalService;
	
	public static final String[] CLASS_NAMES = { DataCollection.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, DataCollection dataCollection) throws Exception {

		Element dataCollectionElement = portletDataContext.getExportDataElement(dataCollection);

		portletDataContext.addClassedModel(
				dataCollectionElement, ExportImportPathUtil.getModelPath(dataCollection), dataCollection);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, DataCollection dataCollection) throws Exception {
		long userId = portletDataContext.getUserId(dataCollection.getUserUuid());

		DataCollection importedDataCollection = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(dataCollection);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			DataCollection existingDataCollection= super.fetchStagedModelByUuidAndGroupId(
					dataCollection.getUuid(), portletDataContext.getScopeGroupId());

			if (existingDataCollection == null) {
				serviceContext.setUuid(dataCollection.getUuid());

				importedDataCollection = _dataCollectionLocalService.addDataCollection(
						dataCollection.getDataCollectionName(),
						dataCollection.getDataCollectionVersion(),
						dataCollection.getDisplayNameMap(),
						dataCollection.getDescriptionMap(),
						dataCollection.getStatus(),
						serviceContext);
			}
			else {
				importedDataCollection = _dataCollectionLocalService.updateDataCollection(
						existingDataCollection.getDataCollectionId(), 
						dataCollection.getDataCollectionName(), 
						dataCollection.getDataCollectionVersion(), 
						dataCollection.getDisplayNameMap(),
						dataCollection.getDescriptionMap(),
						dataCollection.getStatus(),
						serviceContext);

			}
		}
		else {
			importedDataCollection = _dataCollectionLocalService.addDataCollection(
					dataCollection.getDataCollectionName(), 
					dataCollection.getDataCollectionVersion(), 
					dataCollection.getDisplayNameMap(),
					dataCollection.getDescriptionMap(),
					dataCollection.getStatus(),
					serviceContext);
		}

		portletDataContext.importClassedModel(dataCollection, importedDataCollection);

	}

	@Override
	public String getDisplayName(DataCollection stagedModel) {
		return stagedModel.getDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long dataCollectionId) throws Exception {
		
		DataCollection existingDataCollection = fetchMissingReference(uuid, groupId);

		if (existingDataCollection == null) {
			return;
		}

		Map<Long, Long> dataCollectionIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( DataCollection.class);

		dataCollectionIds.put(dataCollectionId, existingDataCollection.getDataCollectionId());
	}

	@Override
	public DataCollection fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _dataCollectionLocalService.fetchDataCollectionByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<DataCollection> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _dataCollectionLocalService.getDataCollectionsByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<DataCollection>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		DataCollection dataCollection = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (dataCollection != null) {
			deleteStagedModel(dataCollection);
		}
	}

	@Override
	public void deleteStagedModel(DataCollection dataCollection) throws PortalException {
		_dataCollectionLocalService.deleteDataCollection(dataCollection);
	}

}
