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

package it.ethica.esf.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Ethica
 */
public class ESFMatchFinderUtil {
	public static java.util.List<it.ethica.esf.model.ESFMatch> findDelegationActiveMatch(
		long esfUserId) {
		return getFinder().findDelegationActiveMatch(esfUserId);
	}

	public static ESFMatchFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFMatchFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFMatchFinder.class.getName());

			ReferenceRegistry.registerReference(ESFMatchFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFMatchFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFMatchFinderUtil.class, "_finder");
	}

	private static ESFMatchFinder _finder;
}