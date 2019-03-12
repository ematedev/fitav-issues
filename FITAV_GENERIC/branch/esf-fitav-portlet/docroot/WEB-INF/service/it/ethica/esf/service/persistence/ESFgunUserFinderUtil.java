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
public class ESFgunUserFinderUtil {
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findRifleByKind_Shooter(
		java.lang.String name, java.lang.String lastName, long kindId,
		int start, int end) {
		return getFinder()
				   .findRifleByKind_Shooter(name, lastName, kindId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFgunUser> findCaneByKind_Shooter(
		java.lang.String name, java.lang.String lastName, long kindId,
		int start, int end) {
		return getFinder()
				   .findCaneByKind_Shooter(name, lastName, kindId, start, end);
	}

	public static ESFgunUserFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFgunUserFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFgunUserFinder.class.getName());

			ReferenceRegistry.registerReference(ESFgunUserFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFgunUserFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFgunUserFinderUtil.class,
			"_finder");
	}

	private static ESFgunUserFinder _finder;
}