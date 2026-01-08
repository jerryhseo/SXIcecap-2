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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.sx.icecap.exception.NoSuchSetTypeLinkException;
import com.sx.icecap.model.SetTypeLink;
import com.sx.icecap.service.base.SetTypeLinkLocalServiceBaseImpl;
import com.sx.icecap.service.persistence.SetTypeLinkPersistence;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.SetTypeLink",
	service = AopService.class
)
public class SetTypeLinkLocalServiceImpl
	extends SetTypeLinkLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public SetTypeLink addSetTypeLink( long dataSetId, long dataTypeId, int order ) {
		long linkId = super.counterLocalService.increment();
		
		SetTypeLink link = setTypeLinkPersistence.create(linkId);
		
		link.setDataSetId(dataSetId);
		link.setDataTypeId(dataTypeId);
		link.setOrder(order);
		
		link.setCommentable(true);
		link.setVerifiable(true);;
		link.setFreezable(true);;
		
		link.setVerified(false);
		link.setFreezed(false);
		
		setTypeLinkPersistence.update(link);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public SetTypeLink updateSetTypeLink( long setTypeLinkId, long dataSetId, long dataTypeId, int order ) {
		SetTypeLink link = setTypeLinkPersistence.fetchByPrimaryKey(setTypeLinkId);
		
		link.setDataSetId(dataSetId);
		link.setDataTypeId(dataTypeId);
		link.setOrder(order);
		
		setTypeLinkPersistence.update(link);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public SetTypeLink removeSetTypeLink( long setTypeLinkId ) {
		SetTypeLink link = null;
		
		try {
			link = setTypeLinkPersistence.remove(setTypeLinkId);
		} catch (NoSuchSetTypeLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public void removeSetTypeLinkBySet( long dataSetId ) {
		setTypeLinkPersistence.removeByDataSetId(dataSetId);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public void removeSetTypeLinkByType( long dataTypeId ) {
		setTypeLinkPersistence.removeByDataTypeId(dataTypeId);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public SetTypeLink setVerified(long setTypeLinkId, boolean verified, ServiceContext sc) throws PortalException {
		SetTypeLink link = setTypeLinkPersistence.findByPrimaryKey(setTypeLinkId);
		
		User user = userLocalService.getUser(sc.getUserId());
		
		link.setVerified(verified);
		link.setVerifiedDate(new Date());
		link.setVerifiedUserId(user.getUserId());;
		link.setVerifiedUserName(user.getFullName());;
		
		setTypeLinkPersistence.update(link);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public SetTypeLink setFreezed(long setTypeLinkId, boolean freezed, ServiceContext sc) throws PortalException {
		SetTypeLink link = setTypeLinkPersistence.findByPrimaryKey(setTypeLinkId);
		
		User user = userLocalService.getUser(sc.getUserId());
		
		link.setFreezed(freezed);
		link.setFreezedDate(new Date());
		link.setFreezedUserId(user.getUserId());;
		link.setFreezedUserName(user.getFullName());;
		
		setTypeLinkPersistence.update(link);
		
		return link;
	}

	
	// search functions from here
	public List<SetTypeLink> getAllSetTypeLinkList(){
		return setTypeLinkPersistence.findAll();
	}
	public List<SetTypeLink> getAllSetTypeLinkList(int start, int end){
		return setTypeLinkPersistence.findAll( start, end );
	}
	public int countAllSetTypeLinkList(){
		return setTypeLinkPersistence.countAll();
	}
	
	public List<SetTypeLink> getSetTypeLinkListBySet( long dataSetId ){
		return setTypeLinkPersistence.findByDataSetId(dataSetId);
	}
	public List<SetTypeLink> getSetTypeLinkListBySet(long dataSetId, int start, int end){
		return setTypeLinkPersistence.findByDataSetId(dataSetId, start, end);
	}
	public int countSetTypeLinkListBySet( long dataSetId ){
		return setTypeLinkPersistence.countByDataSetId(dataSetId);
	}
	
	public List<SetTypeLink> getSetTypeLinkListByType( long dataTypeId ){
		return setTypeLinkPersistence.findByDataTypeId(dataTypeId);
	}
	public List<SetTypeLink> getSetTypeLinkListByType(long dataTypeId, int start, int end){
		return setTypeLinkPersistence.findByDataTypeId(dataTypeId, start, end);
	}
	public int countSetTypeLinkListByType( long dataTypeId ){
		return setTypeLinkPersistence.countByDataTypeId(dataTypeId);
	}
	
	public List<SetTypeLink> getSetTypeLinkListByCollectionSet_G( long groupId, long collectionId, long dataSetId ){
		return setTypeLinkPersistence.findByCollectionSet_G(groupId, collectionId, dataSetId);
	}
	public List<SetTypeLink> getSetTypeLinkListByType( long groupId, long collectionId, long dataSetId , int start, int end){
		return setTypeLinkPersistence.findByCollectionSet_G(groupId, collectionId, dataSetId, start, end);
	}
	public int countSetTypeLinkListByCollectionSet_G( long groupId, long collectionId, long dataSetId ){
		return setTypeLinkPersistence.countByCollectionSet_G(groupId, collectionId, dataSetId);
	}
	
	public SetTypeLink getSetTypeLink(long groupId, long dataCollectionId, long dataSetId, long dataTypeId) {
		return setTypeLinkPersistence.fetchByCollectionSetType_G(groupId, dataCollectionId, dataSetId, dataTypeId);
	}
}