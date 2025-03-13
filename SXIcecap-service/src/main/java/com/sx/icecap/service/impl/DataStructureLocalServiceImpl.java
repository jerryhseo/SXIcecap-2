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
import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.base.DataStructureLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataStructure",
	service = AopService.class
)
public class DataStructureLocalServiceImpl
	extends DataStructureLocalServiceBaseImpl {
	
	public DataStructure updateDataStructure(long dataTypeId, String version, String structure) {
		DataStructure dataStructure = null;
		try {
			dataStructure = dataStructurePersistence.findByDataTypeIdVersion(dataTypeId, version);
		} catch (NoSuchDataStructureException e) {
			long dataStructureId =  counterLocalService.increment();
			dataStructure = dataStructurePersistence.create(dataStructureId);
		}
		
		dataStructure.setDataTypeId(dataTypeId);
		dataStructure.setVersion(version);
		dataStructure.setStructure(structure);
		
		return dataStructurePersistence.update(dataStructure);
	}
	
	public void deleteDataStructures( long dataTypeId ) {
		dataStructurePersistence.removeByDataTypeId(dataTypeId);
	}
	
	public void deleteDataStructure( long dataTypeId, String version) throws NoSuchDataStructureException {
		dataStructurePersistence.removeByDataTypeIdVersion(dataTypeId, version);
	}
	
	public int countByDataTypeId(long dataTypeId) {
		return dataStructurePersistence.countByDataTypeId(dataTypeId);
	}
	
	public DataStructure getDataStructure(long dataTypeId, String version) throws NoSuchDataStructureException {
		return dataStructurePersistence.findByDataTypeIdVersion(dataTypeId, version);
	}
	
	public List<DataStructure> getDataStructures(long dataTypeId){
		return dataStructurePersistence.findByDataTypeId(dataTypeId);
	}
}