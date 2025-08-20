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
import com.liferay.portal.kernel.service.ServiceContext;
import com.sx.icecap.model.TypeStructureLink;
import com.sx.icecap.service.base.TypeStructureLinkLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.TypeStructureLink",
	service = AopService.class
)
public class TypeStructureLinkLocalServiceImpl
	extends TypeStructureLinkLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink addTypeDataStructureLink(
			long dataTypeId,
			long dataStructureId,
			boolean commentable,
			boolean verifiable,
			boolean freezable,
			boolean verified,
			long verifiedUserId,
			boolean freezed,
			long freezedUserId) {
		
		TypeStructureLink link = super.typeStructureLinkLocalService.createTypeStructureLink(dataTypeId);
		
		link.setDataTypeId(dataTypeId);
		link.setDataStructureId(dataStructureId);
		link.setCommentable(commentable);
		link.setVerifiable(verifiable);
		link.setFreezable(freezable);
		
		link.setVerified(verified);
		Date date = new Date();
		if(verified == true) {
			link.setVerifiedUserId(verifiedUserId);
			link.setVerifiedDate(date);
		}
		link.setFreezed(freezed);
		if(freezed == true) {
			link.setFreezedUserId(freezedUserId);
			link.setVerifiedDate(date);
		}
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink updateTypeDataStructureLink(
			long dataTypeId,
			long dataStructureId,
			boolean commentable,
			boolean verifiable,
			boolean freezable,
			boolean verified,
			long verifiedUserId,
			boolean freezed,
			long freezedUserId) throws PortalException {
		
		TypeStructureLink link = super.typeStructureLinkLocalService.getTypeStructureLink(dataTypeId);
		
		link.setDataTypeId(dataTypeId);
		link.setDataStructureId(dataStructureId);
		link.setCommentable(commentable);
		link.setVerifiable(verifiable);
		link.setFreezable(freezable);
		
		Date date = new Date();
		if(link.getVerified() != verified) {
			link.setVerified(verified);
			link.setVerifiedDate(date);
		}
		if(link.getFreezed() != freezed) {
			link.setFreezed(freezed);
			link.setFreezedDate(date);
		}
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink removeTypeStructureLink(long dataTypeId) throws PortalException {
		return super.typeStructureLinkLocalService.deleteTypeStructureLink(dataTypeId);
	}
}