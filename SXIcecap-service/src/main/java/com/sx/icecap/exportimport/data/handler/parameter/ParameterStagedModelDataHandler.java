package com.sx.icecap.exportimport.data.handler.parameter;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.Parameter;
import com.sx.icecap.service.ParameterLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class ParameterStagedModelDataHandler extends BaseStagedModelDataHandler<Parameter> {
	@Reference(unbind = "-")
	protected void setParameterLocalService(ParameterLocalService parameterLocalService) {

		_parameterLocalService = parameterLocalService;
	}
	private ParameterLocalService _parameterLocalService;
	
	public static final String[] CLASS_NAMES = { Parameter.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, Parameter parameter) throws Exception {

		Element parameterElement = portletDataContext.getExportDataElement(parameter);

		portletDataContext.addClassedModel(
				parameterElement, ExportImportPathUtil.getModelPath(parameter), parameter);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, Parameter parameter) throws Exception {
		long userId = portletDataContext.getUserId(parameter.getUserUuid());

		Parameter importedParameter = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(parameter);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			Parameter existingParameter= super.fetchStagedModelByUuidAndGroupId(
					parameter.getUuid(), portletDataContext.getScopeGroupId());

			if (existingParameter == null) {
				serviceContext.setUuid(parameter.getUuid());

				importedParameter = _parameterLocalService.addParameter(
						parameter.getParamType(), 
						parameter.getParamName(), 
						parameter.getParamVersion(),
						parameter.getDisplayNameMap(),
						parameter.getDefinitionMap(),
						parameter.getTooltipMap(),
						parameter.getSynonyms(),
						parameter.getTypeProperties(),
						parameter.getStandard(),
						parameter.getStatus(),
						serviceContext);
			}
			else {
				importedParameter = _parameterLocalService.updateParameter(
						existingParameter.getParameterId(), 
						parameter.getParamType(), 
						parameter.getParamName(), 
						parameter.getParamVersion(),
						parameter.getDisplayNameMap(),
						parameter.getDefinitionMap(),
						parameter.getTooltipMap(),
						parameter.getSynonyms(),
						parameter.getTypeProperties(),
						parameter.getStandard(),
						parameter.getStatus(),
						serviceContext);

			}
		}
		else {
			importedParameter = _parameterLocalService.addParameter(
					parameter.getParamType(), 
					parameter.getParamName(), 
					parameter.getParamVersion(),
					parameter.getDisplayNameMap(),
					parameter.getDefinitionMap(),
					parameter.getTooltipMap(),
					parameter.getSynonyms(),
					parameter.getTypeProperties(),
					parameter.getStandard(),
					parameter.getStatus(),
					serviceContext);
		}

		portletDataContext.importClassedModel(parameter, importedParameter);

	}

	@Override
	public String getDisplayName(Parameter stagedModel) {
		return stagedModel.getDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long parameterId) throws Exception {
		
		Parameter existingParameter = fetchMissingReference(uuid, groupId);

		if (existingParameter == null) {
			return;
		}

		Map<Long, Long> parameterIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( Parameter.class);

		parameterIds.put(parameterId, existingParameter.getParameterId());
	}

	@Override
	public Parameter fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _parameterLocalService.fetchParameterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<Parameter> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _parameterLocalService.getParametersByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<Parameter>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		Parameter parameter = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (parameter != null) {
			deleteStagedModel(parameter);
		}
	}

	@Override
	public void deleteStagedModel(Parameter parameter) throws PortalException {
		_parameterLocalService.deleteParameter(parameter);
	}

}
