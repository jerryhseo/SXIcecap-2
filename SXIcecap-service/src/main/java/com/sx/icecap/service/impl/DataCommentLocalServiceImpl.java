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
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.exception.NoSuchDataCommentException;
import com.sx.icecap.model.DataComment;
import com.sx.icecap.service.base.DataCommentLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataComment",
	service = AopService.class
)
public class DataCommentLocalServiceImpl
	extends DataCommentLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public DataComment addDataComment(
					String commentModel,
					long commentModelId,
					long parentCommentId,
					String comment,
					ServiceContext sc
			) throws PortalException {
		
		long commentId = counterLocalService.increment();
		DataComment dataComment = dataCommentPersistence.create(commentId);
		
		dataComment.setCommentModel(commentModel);
		dataComment.setCommentModelId(commentModelId);
		dataComment.setParentCommentId(parentCommentId);
		dataComment.setComment(comment);
		
		User user = userLocalService.getUser(sc.getUserId());
		Date now = new Date();
		dataComment.setCompanyId(sc.getCompanyId());
		dataComment.setGroupId(sc.getScopeGroupId());
		dataComment.setUserId(user.getUserId());;
		dataComment.setUserName(user.getFullName());
		dataComment.setCreateDate(now);
		dataComment.setModifiedDate(now);
		
		return dataComment;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataComment updateDataComment( 
					long dataCommentId,
					String commentModel,
					long commentModelId,
					long parentCommentId,
					String comment,
					ServiceContext sc) throws PortalException {
		
		DataComment dataComment = dataCommentPersistence.fetchByPrimaryKey(dataCommentId);
		
		if( Validator.isNotNull(dataComment)) {
			dataComment.setCommentModel(commentModel);
			dataComment.setCommentModelId(commentModelId);
			dataComment.setParentCommentId(parentCommentId);
			dataComment.setComment(comment);
			
			User user = userLocalService.getUser(sc.getUserId());
			Date now = new Date();
			dataComment.setCompanyId(sc.getCompanyId());
			dataComment.setGroupId(sc.getScopeGroupId());
			dataComment.setUserId(user.getUserId());;
			dataComment.setUserName(user.getFullName());
			dataComment.setModifiedDate(now);
		}
		
		return dataComment;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataComment removeDataComment(long dataCommentId) throws NoSuchDataCommentException {
		DataComment dataComment = dataCommentPersistence.remove(dataCommentId);
		
		return dataComment;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public void removeDataComment( String commentModel ) {
		dataCommentPersistence.removeByModel(commentModel);
	}
	
	@Indexable(type = IndexableType.DELETE)
	public void removeDataCommentByModelId( String commentModel, long commentModelId ) {
		//dataCommentPersistence.removeByModelId(commentModel, commentModelId);
	}
	
	public List<DataComment> getDataCommentList( String commentModel, long commentModelId ){
		List<DataComment> commentList = dataCommentPersistence.findByModelId(commentModel, commentModelId);
		
		return commentList;
	}
	public int countDataComments( String commentModel, long commentModelId ) {
		return dataCommentPersistence.countByModelId(commentModel, commentModelId);
	}

	public boolean hasComments( String commentModel, long commentModelId ) {
		return countDataComments(commentModel, commentModelId) > 0 ? true : false;
	}
}