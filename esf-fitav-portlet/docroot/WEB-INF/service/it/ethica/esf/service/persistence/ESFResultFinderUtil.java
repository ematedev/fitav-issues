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
public class ESFResultFinderUtil {
	public static java.util.ArrayList<java.lang.String> findDescRanking(
		long matchId) {
		return getFinder().findDescRanking(matchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFResult> findResultByMatchIdDescRanking(
		long matchId, java.lang.String descRanking) {
		return getFinder().findResultByMatchIdDescRanking(matchId, descRanking);
	}

	public static ESFResultFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFResultFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFResultFinder.class.getName());

			ReferenceRegistry.registerReference(ESFResultFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFResultFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFResultFinderUtil.class, "_finder");
	}

	private static ESFResultFinder _finder;
}