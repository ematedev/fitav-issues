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
public class ESFCardFinderUtil {
	public static java.util.List<it.ethica.esf.model.ESFCard> findCardByOrganizationId(
		long orgId) {
		return getFinder().findCardByOrganizationId(orgId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findCardByOrganizationIdFree(
		long orgId) {
		return getFinder().findCardByOrganizationIdFree(orgId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findFreeCardsInt() {
		return getFinder().findFreeCardsInt();
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> getFreeCards() {
		return getFinder().getFreeCards();
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findFreeCards(
		int begin, int end) {
		return getFinder().findFreeCards(begin, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findActualUserCards(
		long esfUserId) {
		return getFinder().findActualUserCards(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findCardByUserState(
		int state, long userId) {
		return getFinder().findCardByUserState(state, userId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findCardByUser(
		long userId) {
		return getFinder().findCardByUser(userId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCard> findCardsByOrgId(
		long esforgId) {
		return getFinder().findCardsByOrgId(esforgId);
	}

	public static it.ethica.esf.model.ESFCard findShooterByCardActiveInMatch(
		java.lang.String cardCode, java.lang.String startDate,
		java.lang.String endDate) {
		return getFinder()
				   .findShooterByCardActiveInMatch(cardCode, startDate, endDate);
	}

	public static ESFCardFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFCardFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFCardFinder.class.getName());

			ReferenceRegistry.registerReference(ESFCardFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFCardFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFCardFinderUtil.class, "_finder");
	}

	private static ESFCardFinder _finder;
}