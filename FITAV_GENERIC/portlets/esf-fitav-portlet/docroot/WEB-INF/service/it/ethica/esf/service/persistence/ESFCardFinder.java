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

/**
 * @author Ethica
 */
public interface ESFCardFinder {
	public java.util.List<it.ethica.esf.model.ESFCard> findCardByOrganizationId(
		long orgId);

	public java.util.List<it.ethica.esf.model.ESFCard> findCardByOrganizationIdFree(
		long orgId);

	public java.util.List<it.ethica.esf.model.ESFCard> findFreeCardsInt();

	public java.util.List<it.ethica.esf.model.ESFCard> getFreeCards();

	public java.util.List<it.ethica.esf.model.ESFCard> findFreeCards(
		int begin, int end);

	public java.util.List<it.ethica.esf.model.ESFCard> findActualUserCards(
		long esfUserId);

	public java.util.List<it.ethica.esf.model.ESFCard> findCardByUserState(
		int state, long userId);

	public java.util.List<it.ethica.esf.model.ESFCard> findCardByUser(
		long userId);

	public java.util.List<it.ethica.esf.model.ESFCard> findCardsByOrgId(
		long esforgId);

	public it.ethica.esf.model.ESFCard findShooterByCardActiveInMatch(
		java.lang.String cardCode, java.lang.String startDate,
		java.lang.String endDate);
}