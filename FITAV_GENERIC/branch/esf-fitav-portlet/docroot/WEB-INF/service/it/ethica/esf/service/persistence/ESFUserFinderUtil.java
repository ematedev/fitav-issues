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
public class ESFUserFinderUtil {
	public static java.util.List<it.ethica.esf.model.ESFUser> findShooter(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String cardCode, int state, int begin, int end) {
		return getFinder()
				   .findShooter(firstName, lastName, orgId, cardCode, state,
			begin, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findAllShooter(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String cardCode, int begin, int end) {
		return getFinder()
				   .findAllShooter(firstName, lastName, orgId, cardCode, begin,
			end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterFiscalCode(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String fiscalCode, int state, int begin, int end) {
		return getFinder()
				   .findShooterFiscalCode(firstName, lastName, orgId,
			fiscalCode, state, begin, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterFiscalRole(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end) {
		return getFinder()
				   .findShooterFiscalRole(organizationId, stateCard,
			esfUserRoleId, stateUser, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterFiscalRoleName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser, int start, int end) {
		return getFinder()
				   .findShooterFiscalRoleName(name, lastName, organizationId,
			stateCard, esfUserRoleId, stateUser, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> countShooterFiscalRoleName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser) {
		return getFinder()
				   .countShooterFiscalRoleName(name, lastName, organizationId,
			stateCard, esfUserRoleId, stateUser);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		long esfUserRoleId, int start, int end) {
		return getFinder()
				   .findShooterRoleAssignedName(name, lastName, organizationId,
			esfUserRoleId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> countShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		long esfUserRoleId) {
		return getFinder()
				   .countShooterRoleAssignedName(name, lastName,
			organizationId, esfUserRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> countStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId) {
		return getFinder()
				   .countStaffMatch(name, lastName, fiscalcode, matchId, fitavId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId, int start,
		int end) {
		return getFinder()
				   .findStaffMatch(name, lastName, fiscalcode, matchId,
			fitavId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> findStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, int start, int end) {
		return getFinder()
				   .findStaffNormalMatch(name, lastName, fiscalcode, matchId,
			start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFUser> countStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId) {
		return getFinder()
				   .countStaffNormalMatch(name, lastName, fiscalcode, matchId);
	}

	public static ESFUserFinder getFinder() {
		if (_finder == null) {
			_finder = (ESFUserFinder)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFUserFinder.class.getName());

			ReferenceRegistry.registerReference(ESFUserFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ESFUserFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ESFUserFinderUtil.class, "_finder");
	}

	private static ESFUserFinder _finder;
}