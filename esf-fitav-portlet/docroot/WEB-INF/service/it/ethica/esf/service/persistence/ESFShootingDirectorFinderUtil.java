/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package it.ethica.esf.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Ethica
 */
public class ESFShootingDirectorFinderUtil {
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findShootingDirector(
		java.lang.String lastName, java.lang.String firstName,
		java.lang.String cardCode, java.lang.String regionId,
		long qualificationId, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findShootingDirector(lastName, firstName, cardCode,
			regionId, qualificationId, sportTypeId, start, end);
	}

	public static ESFShootingDirectorFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFShootingDirectorFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShootingDirectorFinder.class.getName());

			ReferenceRegistry.registerReference(ESFShootingDirectorFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFShootingDirectorFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFShootingDirectorFinderUtil.class,
			"_finder");
	}

	private static ESFShootingDirectorFinder _finder;
}