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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.icecap.model.DataComment;
import com.sx.icecap.service.base.DataCommentLocalServiceBaseImpl;

import java.util.Date;
import java.util.Iterator;
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
					long dataId,
					String paramCode,
					long parentCommentId,
					String comment,
					int status,
					ServiceContext sc
			) throws PortalException {
		
		long commentId = counterLocalService.increment();
		DataComment dataComment = dataCommentPersistence.create(commentId);
		
		dataComment.setCommentModel(commentModel);
		dataComment.setDataId(dataId);
		dataComment.setParamCode(paramCode);
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
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			dataComment.setStatus(status);
		}
		else {
			dataComment.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		dataComment.setStatusByUserId(sc.getUserId());
		dataComment.setStatusByUserName(user.getFullName());
		dataComment.setStatusDate(sc.getModifiedDate(null));
		
		dataComment.setExpandoBridgeAttributes(sc);
		
		dataComment = dataCommentPersistence.update(dataComment, sc);
		
		super.resourceLocalService.addResources(
				dataComment.getCompanyId(), 
				dataComment.getGroupId(), 
				dataComment.getUserId(), 
				DataComment.class.getName(), 
				dataComment.getPrimaryKey(), 
				false, 
				true, 
				true);
//			System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			dataComment.getUserId(), 
			dataComment.getGroupId(), 
			dataComment.getCreateDate(), 
			dataComment.getModifiedDate(),
			DataComment.class.getName(), 
			dataComment.getPrimaryKey(), 
			dataComment.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			dataComment.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			dataComment.getComment(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataComment.getCompanyId(), 
				dataComment.getGroupId(), 
				dataComment.getUserId(), 
				DataComment.class.getName(), 
				dataComment.getPrimaryKey(), 
				dataComment,
				sc);
		
		return dataComment;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataComment updateDataComment( 
					long dataCommentId,
					String commentModel,
					long dataId,
					String paramCode,
					long parentCommentId,
					String comment,
					int status,
					ServiceContext sc) throws PortalException {
		
		DataComment dataComment = dataCommentPersistence.fetchByPrimaryKey(dataCommentId);
		
		if( Validator.isNotNull(dataComment)) {
			throw new PortalException("[ERROR] No DataComment to update: " + dataCommentId);
		}
		
		dataComment.setCommentModel(commentModel);
		dataComment.setDataId(dataId);
		dataComment.setParamCode(paramCode);
		dataComment.setParentCommentId(parentCommentId);
		dataComment.setComment(comment);
		
		User user = userLocalService.getUser(sc.getUserId());
		Date now = new Date();
		dataComment.setCompanyId(sc.getCompanyId());
		dataComment.setGroupId(sc.getScopeGroupId());
		dataComment.setUserId(user.getUserId());;
		dataComment.setUserName(user.getFullName());
		dataComment.setModifiedDate(now);
		
		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != dataComment.getStatus()) {
			dataComment.setStatus(status);
			dataComment.setStatusByUserId(user.getUserId());
			dataComment.setStatusByUserName(user.getFullName());
			dataComment.setStatusDate(new Date());
			statusChanged = true;
		}
		
		dataComment.setExpandoBridgeAttributes(sc);
		
		super.dataCommentPersistence.update(dataComment, sc);
		
		super.resourceLocalService.updateResources(
				dataComment.getCompanyId(),
				dataComment.getGroupId(), 
				DataComment.class.getName(), 
				dataComment.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				dataComment.getUserId(), 
				dataComment.getGroupId(), 
				dataComment.getCreateDate(), 
				dataComment.getModifiedDate(),
				DataComment.class.getName(), 
				dataComment.getPrimaryKey(), 
				dataComment.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				dataComment.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				dataComment.getComment(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(DataComment.class.getName(), dataCommentId, true);
			} else {
				super.assetEntryLocalService.updateVisible(DataComment.class.getName(), dataCommentId, false);
			}
		}
		
		return dataComment;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataComment removeDataComment(long dataCommentId) throws PortalException {
		DataComment dataComment = dataCommentPersistence.remove(dataCommentId);
		
		super.assetEntryLocalService.deleteEntry(DataComment.class.getName(), dataComment.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				dataComment.getCompanyId(), 
				DataComment.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				dataComment.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    dataComment.getCompanyId(), 
			    dataComment.getGroupId(),
			    DataComment.class.getName(), 
			    dataComment.getDataCommentId());
		
		return dataComment;
	}
	
	public void removeDataComments( String commentModel, long dataId )
			throws PortalException {
		List<DataComment> commentList = dataCommentPersistence.findByDataId(commentModel, dataId);
		
		Iterator<DataComment> iterator = commentList.iterator();
		while( iterator.hasNext()) {
			 DataComment comment = iterator.next();
			 removeDataComment(comment.getDataCommentId());
		}
	}
	
	public void removeDataCommentsByParamCode(String commentModel,  long dataId, String paramCode )
			throws PortalException {
		List<DataComment> commentList = 
				dataCommentPersistence.findByParamCode(commentModel, dataId, paramCode);
		
		Iterator<DataComment> iterator = commentList.iterator();
		while( iterator.hasNext()) {
			 DataComment comment = iterator.next();
			 removeDataComment(comment.getDataCommentId());
		}

	}
	
	public List<DataComment> getDataCommentList( String commentModel, long dataId ){
		List<DataComment> commentList = dataCommentPersistence.findByDataId(commentModel, dataId);
		
		return commentList;
	}
	public int countDataComments( String commentModel,  long dataId ) {
		return dataCommentPersistence.countByDataId(commentModel, dataId);
	}
	
	public List<DataComment> getDataCommentListByParamCode( String commentModel, long dataId, String paramCode ){
		List<DataComment> commentList = dataCommentPersistence.findByParamCode(commentModel, dataId, paramCode);
		
		return commentList;
	}
	public int countDataCommentsByParamCode(String commentModel,  long dataId, String paramCode ) {
		return dataCommentPersistence.countByParamCode(commentModel, dataId, paramCode);
	}

	public boolean hasComments( String commentModel, long dataId ) {
		return countDataComments(commentModel, dataId) > 0 ? true : false;
	}
}