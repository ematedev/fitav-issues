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

/**
 * @author Ethica
 */
public interface ESFUserFinder {
	public java.util.List<it.ethica.esf.model.ESFUser> findShooter(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String cardCode, int state, int begin, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooter(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String cardCode, int begin, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterFiscalCode(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String fiscalCode, int state, int begin, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterFiscalRole(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterFiscalRoleName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> countShooterFiscalRoleName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser);

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		long esfUserRoleId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> countShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		long esfUserRoleId);

	public java.util.List<it.ethica.esf.model.ESFUser> countStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId);

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId, int start,
		int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> countStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId);

	public int countRenwalUser(java.lang.String thisYear,
		java.lang.String lastYear, long orgId);

	public int countNewUser(java.lang.String thisYear,
		java.lang.String lastYear, long orgId);

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterByAss(
		java.lang.String firstName, java.lang.String lastName, long orgId,
		java.lang.String cardCode);

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterNotAssociated(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode);

	public java.util.List<it.ethica.esf.model.ESFUser> findNotNationalShooterBySPT(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end);

	public int countNotNationalShooterBySPT(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId);

	public java.util.List<it.ethica.esf.model.ESFUser> findALLNotNationalShooterBySPT(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end);

	public int countALLNotNationalShooterBySPT(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId);

	public java.util.List<it.ethica.esf.model.ESFUser> findDirectorByMatch(
		java.lang.String firstName, java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId, int start, int end);

	public int countDirectorByMatch(java.lang.String firstName,
		java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId);

	public java.util.List<it.ethica.esf.model.ESFUser> findNewYouthShooter(
		int year);

	public java.util.List<it.ethica.esf.model.ESFUser> findYouthByCategory(
		long categoryId, int year, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findYouthByCategoryTotal(
		long categoryId, int year);

	public java.util.List<it.ethica.esf.model.ESFUser> findNotBDOMemberByAssociatioId(
		java.lang.String lastName, java.lang.String firstName,
		long associationId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> countNotBDOMemberByAssociatioId(
		java.lang.String lastName, java.lang.String firstName,
		long associationId);

	public java.util.List<it.ethica.esf.model.ESFUser> findAssociatedShooterOrganization(
		java.lang.String lastName, java.lang.String firstName,
		java.lang.String card, long associationId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> countAssociatedShooterOrganization(
		java.lang.String lastName, java.lang.String firstName,
		java.lang.String card, long associationId);
}