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

package com.sx.icecap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeVisualizerLinkService}.
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLinkService
 * @generated
 */
public class TypeVisualizerLinkServiceWrapper
	implements ServiceWrapper<TypeVisualizerLinkService>,
			   TypeVisualizerLinkService {

	public TypeVisualizerLinkServiceWrapper(
		TypeVisualizerLinkService typeVisualizerLinkService) {

		_typeVisualizerLinkService = typeVisualizerLinkService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _typeVisualizerLinkService.getOSGiServiceIdentifier();
	}

	@Override
	public TypeVisualizerLinkService getWrappedService() {
		return _typeVisualizerLinkService;
	}

	@Override
	public void setWrappedService(
		TypeVisualizerLinkService typeVisualizerLinkService) {

		_typeVisualizerLinkService = typeVisualizerLinkService;
	}

	private TypeVisualizerLinkService _typeVisualizerLinkService;

}