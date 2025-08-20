package com.sx.icecap.exportimport.data.handler.datastructure;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataStructureLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class DataStructureStagedModelDataHandler extends BaseStagedModelDataHandler<DataStructure> {
	@Reference(unbind = "-")
	protected void setDataStructureLocalService(DataStructureLocalService dataStructureLocalService) {

		_dataStructureLocalService = dataStructureLocalService;
	}
	private DataStructureLocalService _dataStructureLocalService;
	
	public static final String[] CLASS_NAMES = { DataStructure.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, DataStructure dataStructure) throws Exception {

		Element dataStructureElement = portletDataContext.getExportDataElement(dataStructure);

		portletDataContext.addClassedModel(
				dataStructureElement, ExportImportPathUtil.getModelPath(dataStructure), dataStructure);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, DataStructure dataStructure) throws Exception {
		long userId = portletDataContext.getUserId(dataStructure.getUserUuid());

		DataStructure importedDataStructure = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(dataStructure);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			DataStructure existingDataStructure= super.fetchStagedModelByUuidAndGroupId(
					dataStructure.getUuid(), portletDataContext.getScopeGroupId());

			if (existingDataStructure == null) {
				serviceContext.setUuid(dataStructure.getUuid());

				importedDataStructure = _dataStructureLocalService.addDataStructure(
						dataStructure.getDataStructureName(), 
						dataStructure.getDataStructureVersion(),
						dataStructure.getDisplayNameMap(),
						dataStructure.getDescriptionMap(),
						dataStructure.getStructure(),
						dataStructure.getStatus(),
						serviceContext);
			}
			else {
				importedDataStructure = _dataStructureLocalService.updateDataStructure(
						existingDataStructure.getDataStructureId(), 
						dataStructure.getDataStructureName(), 
						dataStructure.getDataStructureVersion(),
						dataStructure.getDisplayNameMap(),
						dataStructure.getDescriptionMap(),
						dataStructure.getStructure(),
						dataStructure.getStatus(),
						serviceContext);

			}
		}
		else {
			importedDataStructure = _dataStructureLocalService.addDataStructure(
					dataStructure.getDataStructureName(), 
					dataStructure.getDataStructureVersion(),
					dataStructure.getDisplayNameMap(),
					dataStructure.getDescriptionMap(),
					dataStructure.getStructure(),
					dataStructure.getStatus(),
					serviceContext);
		}

		portletDataContext.importClassedModel(dataStructure, importedDataStructure);

	}

	@Override
	public String getDisplayName(DataStructure stagedModel) {
		return stagedModel.getDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long dataStructureId) throws Exception {
		
		DataStructure existingDataStructure = fetchMissingReference(uuid, groupId);

		if (existingDataStructure == null) {
			return;
		}

		Map<Long, Long> dataStructureIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( DataStructure.class);

		dataStructureIds.put(dataStructureId, existingDataStructure.getDataStructureId());
	}

	@Override
	public DataStructure fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _dataStructureLocalService.fetchDataStructureByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<DataStructure> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _dataStructureLocalService.getDataStructuresByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<DataStructure>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		DataStructure dataStructure = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (dataStructure != null) {
			deleteStagedModel(dataStructure);
		}
	}

	@Override
	public void deleteStagedModel(DataStructure dataStructure) throws PortalException {
		_dataStructureLocalService.deleteDataStructure(dataStructure);
	}

}
