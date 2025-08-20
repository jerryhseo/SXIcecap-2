/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sx.icecap.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.sx.icecap.model.TypeVisualizerLink;
import com.sx.icecap.service.base.TypeVisualizerLinkLocalServiceBaseImpl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.TypeVisualizerLink",
	service = AopService.class
)
public class TypeVisualizerLinkLocalServiceImpl
	extends TypeVisualizerLinkLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public TypeVisualizerLink addTypeVisualizerLink(
			long dataTypeId,
			long visualizerId) {
		
		long linkId = counterLocalService.increment();
		TypeVisualizerLink link = super.typeVisualizerLinkLocalService.createTypeVisualizerLink(linkId);
		
		link.setDataTypeId(dataTypeId);
		link.setVisualizerId(visualizerId);
		
		super.typeVisualizerLinkLocalService.addTypeVisualizerLink(link);

		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeVisualizerLink updateTypeVisualizerLink(
			long linkId,
			long dataTypeId,
			long visualizerId) throws PortalException {
		
		TypeVisualizerLink link = super.typeVisualizerLinkLocalService.getTypeVisualizerLink(linkId);
		link.setDataTypeId(dataTypeId);
		link.setVisualizerId(visualizerId);
		
		super.typeVisualizerLinkLocalService.updateTypeVisualizerLink(link);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeVisualizerLink removeTypeVisualizerLink(long linkId) throws PortalException {
		return super.typeVisualizerLinkLocalService.deleteTypeVisualizerLink(linkId);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public void removeByDataTypeId(long dataTypeId) {
		super.typeVisualizerLinkPersistence.removeByDataTypeId(dataTypeId);
	}
	
	public List<TypeVisualizerLink> getTypeVisualizerLinkList(long dataTypeId){
		List<TypeVisualizerLink> links = super.typeVisualizerLinkPersistence.findByDataTypeId(dataTypeId);
		
		return links;
	}
}