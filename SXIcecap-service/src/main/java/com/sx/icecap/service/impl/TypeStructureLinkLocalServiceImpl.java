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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.exception.NoSuchTypeStructureLinkException;
import com.sx.icecap.model.TypeStructureLink;
import com.sx.icecap.service.base.TypeStructureLinkLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

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
			boolean freezed,
			boolean inputStatus,
			boolean jumpTo,
			ServiceContext sc) throws PortalException {
		
		TypeStructureLink link = super.typeStructureLinkLocalService.createTypeStructureLink(dataTypeId);
		
		link.setDataTypeId(dataTypeId);
		link.setDataStructureId(dataStructureId);
		link.setCommentable(commentable);
		link.setVerifiable(verifiable);
		link.setFreezable(freezable);
		
		link.setVerified(verified);
		Date date = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		
		if(verified == true) {
			link.setVerifiedUserId(user.getUserId());
			link.setVerifiedUserName(user.getFullName());
			link.setVerifiedDate(date);
		}
		
		link.setFreezed(freezed);
		if(freezed == true) {
			link.setFreezedUserId(user.getUserId());
			link.setFreezedUserName(user.getFullName());
			link.setVerifiedDate(date);
		}
		
		link.setInputStatus(inputStatus);
		link.setJumpTo(jumpTo);
		
		link.setGroupId(sc.getScopeGroupId());
		link.setUserId(sc.getUserId());
		
		super.typeStructureLinkPersistence.update(link);
		
		return link;
	}
	
	public TypeStructureLink addTypeDataStructureLink( JSONObject jsonLink, ServiceContext sc) throws PortalException {
		if( Validator.isNull(jsonLink)) {
			return null;
		}
		
		return addTypeDataStructureLink(
				jsonLink.getLong("dataTypeId", 0),
				jsonLink.getLong("dataStructureId", 0),
				jsonLink.getBoolean("commentable", false),
				jsonLink.getBoolean("verifiable", false),
				jsonLink.getBoolean("freezable", false),
				jsonLink.getBoolean("freezed", false),
				jsonLink.getBoolean("verified", false),
				jsonLink.getBoolean("inputStatus", false),
				jsonLink.getBoolean("jumpTo", false),
				sc
				);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink updateTypeDataStructureLink(
			long dataTypeId,
			long dataStructureId,
			boolean commentable,
			boolean verifiable,
			boolean freezable,
			boolean verified,
			boolean freezed,
			boolean inputStatus,
			boolean jumpTo,
			ServiceContext sc) throws PortalException {
		
		TypeStructureLink link = super.typeStructureLinkLocalService.getTypeStructureLink(dataTypeId);
		
		link.setDataTypeId(dataTypeId);
		link.setDataStructureId(dataStructureId);
		link.setCommentable(commentable);
		link.setVerifiable(verifiable);
		link.setFreezable(freezable);
		
		Date date = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		
		if(link.getVerified() != verified) {
			link.setVerified(verified);
			link.setVerifiedUserId(user.getUserId());
			link.setVerifiedUserName(user.getFullName());
			link.setVerifiedDate(date);
		}
		
		if(link.getFreezed() != freezed) {
			link.setFreezed(freezed);
			link.setFreezedUserId(user.getUserId());
			link.setFreezedUserName(user.getFullName());
			link.setFreezedDate(date);
		}
		
		link.setInputStatus(inputStatus);
		link.setJumpTo(jumpTo);
		
		link.setGroupId(sc.getScopeGroupId());
		link.setUserId(sc.getUserId());
		
		super.typeStructureLinkPersistence.update(link, sc);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink removeTypeStructureLink(long dataTypeId) throws PortalException {
		return super.typeStructureLinkPersistence.remove(dataTypeId);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink verifyLink(long dataTypeId, long userId, boolean veryfication) throws PortalException {
		TypeStructureLink link = typeStructureLinkPersistence.findByPrimaryKey(dataTypeId);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(userId);
		
		link.setVerified(veryfication);
		link.setVerifiedUserId(userId);
		link.setVerifiedUserName(user.getFullName());
		link.setVerifiedDate(now);
		
		super.typeStructureLinkPersistence.update(link);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public TypeStructureLink freezeLink(long dataTypeId, long userId, boolean freeze) throws PortalException {
		TypeStructureLink link = typeStructureLinkPersistence.findByPrimaryKey(dataTypeId);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(userId);
		
		link.setFreezable(freeze);;
		link.setFreezedUserId(userId);
		link.setFreezedUserName(user.getFullName());
		link.setFreezedDate(now);
		
		updateTypeStructureLink(link);
		
		return link;
	}
	
	public List<TypeStructureLink> getTypeStructureLinkByGroup(long groupId){
		return typeStructureLinkPersistence.findByGroupId(groupId);
	}
	public List<TypeStructureLink> getTypeStructureLinkByGroup(long groupId, int start, int end){
		return typeStructureLinkPersistence.findByGroupId(groupId, start, end);
	}
	public int countTypeStructureLinkByGroup(long groupId){
		return typeStructureLinkPersistence.countByGroupId(groupId);
	}
	
	public List<TypeStructureLink> getTypeStructureLinkByUser(long userId){
		return typeStructureLinkPersistence.findByUserId(userId);
	}
	public List<TypeStructureLink> getTypeStructureLinkByUser(long userId, int start, int end){
		return typeStructureLinkPersistence.findByUserId(userId, start, end);
	}
	public int countTypeStructureLinkByUser(long userId){
		return typeStructureLinkPersistence.countByUserId(userId);
	}
}