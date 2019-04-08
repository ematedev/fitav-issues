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
public class ESFShooterAffiliationChronoFinderUtil {
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByData(
		java.lang.String data, int start, int end) {
		return getFinder().findByData(data, start, end);
	}

	public static int findByData(java.lang.String data) {
		return getFinder().findByData(data);
	}

	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> shooterThisYear(
		java.lang.String startDateStr, java.lang.String organizationCode) {
		return getFinder().shooterThisYear(startDateStr, organizationCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> shooterByYear(
		java.lang.String startDateStr, java.lang.String organizationCode) {
		return getFinder().shooterByYear(startDateStr, organizationCode);
	}

	public static ESFShooterAffiliationChronoFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFShooterAffiliationChronoFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShooterAffiliationChronoFinder.class.getName());

			ReferenceRegistry.registerReference(ESFShooterAffiliationChronoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFShooterAffiliationChronoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFShooterAffiliationChronoFinderUtil.class,
			"_finder");
	}

	private static ESFShooterAffiliationChronoFinder _finder;
}