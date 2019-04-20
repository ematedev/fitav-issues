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

package it.ethica.esf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFShooterCategoryESFTournament;
import it.ethica.esf.model.ESFShooterQualificationESFTournament;
import it.ethica.esf.model.ESFTeam;
import it.ethica.esf.model.ESFTournament;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFTeamLocalServiceUtil;
import it.ethica.esf.service.ESFTournamentLocalServiceUtil;
import it.ethica.esf.service.base.ESFTournamentLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK;

/**
 * The implementation of the e s f tournament local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFTournamentLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFTournamentLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFTournamentLocalServiceUtil
 */
public class ESFTournamentLocalServiceImpl
	extends ESFTournamentLocalServiceBaseImpl {

	/**
	 * Cerca tutti I tornei sulla base dello stato [attivo o disattivo]
	 */
	public List<ESFTournament> findESFTournamentsByState(int state) {

		List<ESFTournament> esfTournaments = new ArrayList<ESFTournament>();

		try {

			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFTournament.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery tournamentQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFTournament.class, "tournamentQuery",
					PortletClassLoaderUtil.getClassLoader());

			tournamentQuery.add(PropertyFactoryUtil.forName(
				"tournamentQuery.esfTournamentId").in(classPKs));

			esfTournaments =
				ESFTournamentLocalServiceUtil.dynamicQuery(tournamentQuery);
		}
		catch (Exception e) {

		}
		return esfTournaments;
	}

	/**
	 * Cerca tutti I tornei sulla base dello stato [attivo o disattivo]
	 */
	public List<ESFTournament> findESFTournamentsByState(
		int state, int start, int end) {

		List<ESFTournament> esfTournaments = new ArrayList<ESFTournament>();

		try {

			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFTournament.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery tournamentQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFTournament.class, "tournamentQuery",
					PortletClassLoaderUtil.getClassLoader());

			tournamentQuery.add(PropertyFactoryUtil.forName(
				"tournamentQuery.esfTournamentId").in(classPKs));

			esfTournaments =
				ESFTournamentLocalServiceUtil.dynamicQuery(
					tournamentQuery, start, end);
		}
		catch (Exception e) {

		}
		return esfTournaments;
	}

	/**
	 * Cerca tutti i Tornei che hanno uno stato [attivo o disattivo] e che sono
	 * associate o alle organizzazioni sportive foglie dell' organizazione con
	 * Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	 * con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFTournament> findESFTournamentsByOrganizationId(
		long organizationId, boolean isLeaf, int state,
		boolean isNationalMatch) {

		List<ESFTournament> esfTournaments = new ArrayList<ESFTournament>();

		try {

			List<ESFTournament> esfTournamentsByState =
				ESFTournamentLocalServiceUtil.findESFTournamentsByState(state);

			List<Long> tournamentIds = new ArrayList<Long>();

			for (ESFTournament esfTournamentByState : esfTournamentsByState) {
				tournamentIds.add(esfTournamentByState.getEsfTournamentId());
			}

			List<Long> orgIds = new ArrayList<Long>();

			if (!isLeaf) {
				List<ESFOrganization> organizations =
					ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(organizationId);

				for (ESFOrganization esfOrganization : organizations) {
					for (ESFTournament esfTournament : esfTournamentsByState) {
						if (esfTournament.getEsfOrganizationId() == esfOrganization.getEsfOrganizationId())
							orgIds.add(esfTournament.getEsfTournamentId());
					}
				}
			}

			DynamicQuery tournamentQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFTournament.class, "tournamentQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (!isLeaf) {
				tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.esfTournamentId").in(orgIds));
			}
			else {
				tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.esfOrganizationId").eq(organizationId));
				tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.esfTournamentId").in(tournamentIds));
			}

			tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.isNationalMatch").eq(isNationalMatch));

			esfTournaments =
				ESFTournamentLocalServiceUtil.dynamicQuery(tournamentQuery);
		}
		catch (Exception e) {
		}

		return esfTournaments;
	}

	/**
	 * Cerca tutti i Tornei che hanno uno stato [attivo o disattivo] e che sono
	 * associate o alle organizzazioni sportive foglie dell' organizazione con
	 * Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	 * con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFTournament> findESFTournamentsByOrganizationId(
		long organizationId, boolean isLeaf, int state, boolean isNationalMatch,
		int start, int end) {

		List<ESFTournament> esfTournaments = new ArrayList<ESFTournament>();

		try {

			List<ESFTournament> esfTournamentsByState =
				ESFTournamentLocalServiceUtil.findESFTournamentsByState(state);

			List<Long> tournamentIds = new ArrayList<Long>();

			for (ESFTournament esfTournamentByState : esfTournamentsByState) {

				tournamentIds.add(esfTournamentByState.getEsfTournamentId());
			}

			List<Long> orgIds = new ArrayList<Long>();

			if (!isLeaf) {
				List<ESFOrganization> organizations =
					ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(organizationId);

				for (ESFOrganization esfOrganization : organizations) {
					for (ESFTournament esfTournament : esfTournamentsByState) {
						if (esfTournament.getEsfOrganizationId() == esfOrganization.getEsfOrganizationId())
							orgIds.add(esfTournament.getEsfTournamentId());
					}
				}
			}

			DynamicQuery tournamentQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFTournament.class, "tournamentQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (!isLeaf) {
				tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.esfTournamentId").in(orgIds));
			}
			else {
				tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.esfOrganizationId").eq(organizationId));
				tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.esfTournamentId").in(tournamentIds));
			}

			tournamentQuery.add(PropertyFactoryUtil.forName(
					"tournamentQuery.isNationalMatch").eq(isNationalMatch));

			esfTournaments =
				ESFTournamentLocalServiceUtil.dynamicQuery(
					tournamentQuery, start, end);
		}
		catch (Exception e) {

		}

		return esfTournaments;
	}

	public ESFTournament addESFTournament(long userId, long esfOrganizationId,
			String title, String description, int maxnum, int minnum,
			boolean isSingleMatch, boolean isTeamMatch,
			boolean isNationalMatch, boolean isIndividualMatch,
			boolean isJuniorMatch, boolean isFinal, long[] esfShooterCategoryIds,
			long[] esfShooterQualificationIds, Date startDate, Date endDate,
			List<ESFTeam> esfTeams, ESFEntityState esfEntityState,
			ServiceContext serviceContext)
		throws SystemException, PortalException {

		User operator = userPersistence.findByPrimaryKey(userId);

		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long esfTournamentId = counterLocalService.increment();

		ESFTournament esfTournament =
			esfTournamentPersistence.create(esfTournamentId);

		esfTournament.setUserId(userId);
		esfTournament.setGroupId(groupId);
		esfTournament.setCompanyId(operator.getCompanyId());
		esfTournament.setUserName(operator.getFullName());
		esfTournament.setCreateDate(serviceContext.getCreateDate(now));
		esfTournament.setModifiedDate(serviceContext.getModifiedDate(now));
		esfTournament.setExpandoBridgeAttributes(serviceContext);

		esfTournament.setEsfOrganizationId(esfOrganizationId);
		esfTournament.setTitle(title);
		esfTournament.setDescription(description);
		esfTournament.setMaxnum(maxnum);
		esfTournament.setMinnum(minnum);
		esfTournament.setIsSingleMatch(isSingleMatch);
		esfTournament.setIsNationalMatch(isNationalMatch);
		esfTournament.setIsTeamMatch(isTeamMatch);
		esfTournament.setStartDate(startDate);
		esfTournament.setEndDate(endDate);
		esfTournament.setIsFinal(isFinal);
		esfTournament.setIsIndividualMatch(isIndividualMatch);
		esfTournament.setIsJuniorMatch(isJuniorMatch);

		esfTournament = esfTournamentPersistence.update(esfTournament);

		for (long esfShooterCategoryId : esfShooterCategoryIds) {

			ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK =
					new ESFShooterCategoryESFTournamentPK(esfShooterCategoryId,
							esfTournamentId);

			if (esfShooterCategoryESFTournamentPersistence
					.fetchByPrimaryKey(esfShooterCategoryESFTournamentPK) == null) {

				ESFShooterCategoryESFTournament esfShooterCategoryESFTournament =
						esfShooterCategoryESFTournamentPersistence
								.create(esfShooterCategoryESFTournamentPK);

				esfShooterCategoryESFTournamentPersistence
						.update(esfShooterCategoryESFTournament);
			}
		}

		for (long esfShooterQualificationId : esfShooterQualificationIds) {

			ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK =
					new ESFShooterQualificationESFTournamentPK(esfShooterQualificationId,
							esfTournamentId);

			if (esfShooterQualificationESFTournamentPersistence
					.fetchByPrimaryKey(esfShooterQualificationESFTournamentPK) == null) {

				ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
						esfShooterQualificationESFTournamentPersistence
								.create(esfShooterQualificationESFTournamentPK);

				esfShooterQualificationESFTournamentPersistence
						.update(esfShooterQualificationESFTournament);
			}
		}

		for (ESFTeam esfTeam : esfTeams) {
			ESFTeamLocalServiceUtil.addESFTeam(
				userId, esfTeam.getName(), esfTournament.getEsfTournamentId(),
				serviceContext);
		}

		ESFEntityStateLocalServiceUtil.addEntityState(
			serviceContext.getUserId(), ESFTournament.class.getName(),
			esfTournamentId, esfEntityState.getEsfStateId(), serviceContext);

		resourceLocalService.addResources(
			esfTournament.getCompanyId(), groupId, userId,
			ESFTournament.class.getName(), esfTournamentId, false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfTournament.getCreateDate(),
				esfTournament.getModifiedDate(), ESFTournament.class.getName(),
				esfTournamentId, esfTournament.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfTournament.getTitle(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		return esfTournament;
	}

	public ESFTournament deleteESFTournament(
		long esfTournamentId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		List<ESFMatch> esfMatchs =null;
		//esfMatchs =
		//	ESFMatchLocalServiceUtil.findESFMatchsByT_S(
		//		esfTournamentId, ESFKeys.ESFStateType.ENABLE);

		for (ESFMatch esfMatch : esfMatchs) {

			ESFMatchLocalServiceUtil.deleteESFMatch(
				esfMatch.getEsfMatchId(), serviceContext);

		}

		ESFTournament esfTournament = getESFTournament(esfTournamentId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFTournament.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfTournamentId);

		esfTournament = deleteESFTournament(esfTournament);

		return esfTournament;
	}

	public ESFTournament updateESFTournament(long userId, long esfTournamentId,
			long esfOrganizationId, String title, String description,
			int maxnum, int minnum, boolean isSingleMatch, boolean isTeamMatch,
			boolean isNationalMatch, boolean isIndividualMatch,
			boolean isJuniorMatch, boolean isFinal, long[] categories,
			long[] qualifications, Date startDate,
			Date endDate, List<ESFTeam> esfTeams,
			ESFEntityState esfEntityState, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User operator = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		ESFTournament esfTournament = getESFTournament(esfTournamentId);

		esfTournament.setUserId(userId);
		esfTournament.setUserName(operator.getFullName());
		esfTournament.setModifiedDate(serviceContext.getModifiedDate(now));
		esfTournament.setExpandoBridgeAttributes(serviceContext);

		esfTournament.setEsfOrganizationId(esfOrganizationId);
		esfTournament.setTitle(title);
		esfTournament.setDescription(description);
		esfTournament.setMaxnum(maxnum);
		esfTournament.setMinnum(minnum);
		esfTournament.setIsSingleMatch(isSingleMatch);
		esfTournament.setIsTeamMatch(isTeamMatch);
		esfTournament.setIsNationalMatch(isNationalMatch);
		esfTournament.setStartDate(startDate);
		esfTournament.setEndDate(endDate);
		esfTournament.setIsFinal(isFinal);
		esfTournament.setIsIndividualMatch(isIndividualMatch);
		esfTournament.setIsJuniorMatch(isJuniorMatch);

		ESFEntityState esfEntityStateFromDB =
			ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
				ESFTournament.class.getName(), esfTournamentId);

		if (esfEntityStateFromDB != null &&
			(esfEntityStateFromDB.getEsfStateId() != esfEntityState.getEsfStateId())) {

			ESFEntityStateLocalServiceUtil.updateEntityState(
				serviceContext.getUserId(),
				esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);

			ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFTournament.class.getName(),
				esfTournamentId, esfEntityState.getEsfStateId(), serviceContext);
		}

		List<ESFTeam> oldEsfTeams =
			ESFTeamLocalServiceUtil.findByTournament(esfTournamentId);

		for (ESFTeam esfTeam : oldEsfTeams) {
			ESFTeamLocalServiceUtil.deleteESFTeam(esfTeam);
		}

		for (ESFTeam esfTeam : esfTeams) {
			ESFTeamLocalServiceUtil.addESFTeam(
				userId, esfTeam.getName(), esfTournament.getEsfTournamentId(),
				serviceContext);
		}

		esfTournamentPersistence.update(esfTournament);

		resourceLocalService.updateResources(
			operator.getCompanyId(), groupId, ESFTournament.class.getName(),
			esfTournamentId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfTournament.getCreateDate(),
				esfTournament.getModifiedDate(), ESFTournament.class.getName(),
				esfTournamentId, esfTournament.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfTournament.getTitle(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		return esfTournament;
	}
}
