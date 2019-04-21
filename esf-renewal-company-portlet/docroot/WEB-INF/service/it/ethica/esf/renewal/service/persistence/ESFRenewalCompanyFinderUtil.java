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

package it.ethica.esf.renewal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Ethica
 */
public class ESFRenewalCompanyFinderUtil {
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> getESFRenewalCompanyByN_C_R_Y(
		java.lang.String name, java.lang.String code, java.lang.String region,
		int year, int start, int end) {
		return getFinder()
				   .getESFRenewalCompanyByN_C_R_Y(name, code, region, year,
			start, end);
	}

	public static ESFRenewalCompanyFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFRenewalCompanyFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.renewal.service.ClpSerializer.getServletContextName(),
					ESFRenewalCompanyFinder.class.getName());

			ReferenceRegistry.registerReference(ESFRenewalCompanyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFRenewalCompanyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFRenewalCompanyFinderUtil.class,
			"_finder");
	}

	private static ESFRenewalCompanyFinder _finder;
}