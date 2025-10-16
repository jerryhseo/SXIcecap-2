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
import com.sx.icecap.exception.NoSuchCollectionSetLinkException;
import com.sx.icecap.model.CollectionSetLink;
import com.sx.icecap.service.base.CollectionSetLinkLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.CollectionCollectionLink",
	service = AopService.class
)
public class CollectionSetLinkLocalServiceImpl
	extends CollectionSetLinkLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink addCollectionSetLink( long dataCollectionId, long dataSetId ) {
		long linkId = counterLocalService.increment();
		
		CollectionSetLink link = collectionSetLinkPersistence.create(linkId);
		
		link.setDataCollectionId(dataCollectionId);
		link.setDataSetId(dataSetId);;
		
		link.setCommentable(true);
		link.setVerifiable(true);;
		link.setFreezable(true);;
		
		link.setVerified(false);
		link.setFreezed(false);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink updateCollectionSetLink( long collectionSetLinkId, long dataCollectionId, long dataSetId ) {
		CollectionSetLink link = collectionSetLinkPersistence.fetchByPrimaryKey(collectionSetLinkId);
		
		link.setDataCollectionId(dataCollectionId);
		link.setDataSetId(dataSetId);;
		
		link.setCommentable(true);
		link.setVerifiable(true);;
		link.setFreezable(true);;
		
		link.setVerified(false);
		link.setFreezed(false);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink removeCollectionSetLink( long collectionSetLinkId ) {
		CollectionSetLink link = null;
		
		try {
			link = collectionSetLinkPersistence.remove(collectionSetLinkId);
		} catch (NoSuchCollectionSetLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public void removeCollectionSetLinkByCollection( long dataCollectionId ) {
		collectionSetLinkPersistence.removeByCollectionId(dataCollectionId);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public void removeCollectionSetLinkBySet( long dataSetId ) {
		collectionSetLinkPersistence.removeBySetId(dataSetId);
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink setVerified(long collectionSetLinkId, boolean verified, ServiceContext sc) throws PortalException {
		CollectionSetLink link = collectionSetLinkPersistence.findByPrimaryKey(collectionSetLinkId);
		
		User user = userLocalService.getUser(sc.getUserId());
		
		link.setVerified(verified);
		link.setVerifiedDate(new Date());
		link.setVerifiedUserId(user.getUserId());;
		link.setVerifiedUserName(user.getFullName());;
		
		collectionSetLinkPersistence.update(link);
		
		return link;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink setFreezed(long collectionSetLinkId, boolean freezed, ServiceContext sc) throws PortalException {
		CollectionSetLink link = collectionSetLinkPersistence.findByPrimaryKey(collectionSetLinkId);
		
		User user = userLocalService.getUser(sc.getUserId());
		
		link.setFreezed(freezed);
		link.setFreezedDate(new Date());
		link.setFreezedUserId(user.getUserId());;
		link.setFreezedUserName(user.getFullName());;
		
		collectionSetLinkPersistence.update(link);
		
		return link;
	}

	
	// search functions from here
	public List<CollectionSetLink> getAllCollectionSetLinkList(){
		return collectionSetLinkPersistence.findAll();
	}
	public List<CollectionSetLink> getAllCollectionSetLinkList(int start, int end){
		return collectionSetLinkPersistence.findAll( start, end );
	}
	public int countAllCollectionSetLinkList(){
		return collectionSetLinkPersistence.countAll();
	}
	
	public List<CollectionSetLink> getCollectionSetLinkListByCollection( long dataCollectionId ){
		return collectionSetLinkPersistence.findByCollectionId(dataCollectionId);
	}
	public List<CollectionSetLink> getCollectionSetLinkListByCollection(long dataCollectionId, int start, int end){
		return collectionSetLinkPersistence.findByCollectionId(dataCollectionId, start, end);
	}
	public int countCollectionSetLinkListByCollection( long dataCollectionId ){
		return collectionSetLinkPersistence.countByCollectionId(dataCollectionId);
	}
	
	public List<CollectionSetLink> getCollectionSetLinkListBySet( long dataSetId ){
		return collectionSetLinkPersistence.findBySetId(dataSetId);
	}
	public List<CollectionSetLink> getCollectionSetLinkListBySet(long dataSetId, int start, int end){
		return collectionSetLinkPersistence.findBySetId(dataSetId, start, end);
	}
	public int countCollectionSetLinkListBySet( long dataSetId ){
		return collectionSetLinkPersistence.countBySetId(dataSetId);
	}
	
	public CollectionSetLink getCollectionSetLink(long dataCollectionId, long dataSetId) {
		return collectionSetLinkPersistence.fetchByCollectionSet(dataCollectionId, dataSetId);
	}
}