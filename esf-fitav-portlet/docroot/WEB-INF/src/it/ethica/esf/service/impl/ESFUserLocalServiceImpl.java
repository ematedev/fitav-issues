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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.ESFUserPortalUserException;
import it.ethica.esf.NoSuchCardException;
import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFDeparture;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFDepartureLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFUserFinderUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFKeys.ESFUserRoleType;

/**
 * O The implementation of the e s f user local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFUserLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author ethica
 * @see it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserLocalServiceUtil
 */
public class ESFUserLocalServiceImpl extends ESFUserLocalServiceBaseImpl {

	private static Log _log =
		LogFactoryUtil.getLog(ESFUserLocalServiceImpl.class);

	public List<ESFUser> getESFUsersByDeparture(long esfDepartureId) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		ESFDeparture esfDeparture = null;
		List<ESFDeparture> esfDepartures = new ArrayList<ESFDeparture>();
		long userIds[] = null;
		try {
			esfDeparture =
				ESFDepartureLocalServiceUtil.fetchESFDeparture(esfDepartureId);
			esfDepartures =
				ESFDepartureLocalServiceUtil.getESFDeparturesByEsfMatchId_F_L_L_C_D(
					esfDeparture.getEsfMatchId(), esfDeparture.getCode(),
					esfDeparture.getLeaveDate(), esfDeparture.getLeaveHour(),
					esfDeparture.getCompanyName(),
					esfDeparture.getDepartureFrom());
			if (esfDepartures.size() > 0) {
				userIds = new long[esfDepartures.size()];
				int i = 0;
				for (ESFDeparture e : esfDepartures) {
					userIds[i] = e.getEsfUserId();
					i++;
				}
				DynamicQuery esfUsersQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFUser.class, "esfUsersQuery",
						PortletClassLoaderUtil.getClassLoader());

				esfUsersQuery.add(PropertyFactoryUtil.forName(
					"esfUsersQuery.esfUserId").in(userIds));

				esfUsers = ESFUserLocalServiceUtil.dynamicQuery(esfUsersQuery);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return esfUsers;
	}

	public List<ESFUser> getESFUsersByCodeCode(String code) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		List<ESFDeparture> esfDepartures = new ArrayList<ESFDeparture>();
		try {
			esfDepartures =
				ESFDepartureLocalServiceUtil.findDeparturesByCode(code);

			long userIds[] = null;
			if (esfDepartures.size() > 0) {

				userIds = new long[esfDepartures.size()];
				int i = 0;
				for (ESFDeparture e : esfDepartures) {
					userIds[i] = e.getEsfUserId();
					i++;
				}
			}

			DynamicQuery esfUsersQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "esfUsersQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (userIds.length > 0) {

				esfUsersQuery.add(PropertyFactoryUtil.forName(
					"esfUsersQuery.esfUserId").in(userIds));
			}

			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(esfUsersQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return esfUsers;
	}

	public ESFUser getESFUserByUserCode(long userCode) throws it.ethica.esf.NoSuchUserException, SystemException{
		return esfUserPersistence.findByCodeUser(userCode);
	}
	public ESFUser getESFUserByCodeUser2(long userCode) throws it.ethica.esf.NoSuchUserException, SystemException{
		return esfUserPersistence.findByCodeUser2(userCode);
	}
	
	public List<ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, String firstName, String lastName, String fiscalCode,
		int state, long organizationId)
		throws SystemException {
		
		List<ESFUser> esfPartecipants =
			ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(esfMatchId);

		List<ESFUser> esfUsers =
			ESFUserFinderUtil.findShooterFiscalCode(
				firstName, lastName, organizationId, fiscalCode, state, 0,
				esfUserPersistence.countAll());

		long userIds[] = null;
		
		if (esfUsers.size() > 0) {

			userIds = new long[esfUsers.size()];
			int i = 0;
			for (ESFUser e : esfUsers) {
				if (!esfPartecipants.contains(e)) {
					userIds[i] = e.getEsfUserId();
					i++;
				}
			}
		}else{
			return esfUsers;
		}

		try {
			DynamicQuery esfUsersQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "esfUsersQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (userIds.length > 0) {

				esfUsersQuery.add(PropertyFactoryUtil.forName(
					"esfUsersQuery.esfUserId").in(userIds));
			}

			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(esfUsersQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}
		return esfUsers;
	}

	public List<ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, String firstName, String lastName, String fiscalCode,
		int state, long organizationId, int start, int end) {

		List<ESFUser> esfPartecipants =
			ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(esfMatchId);

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		long userIds[] = null;

		try {
			esfUsers =
				ESFUserFinderUtil.findShooterFiscalCode(
					firstName, lastName, organizationId, fiscalCode, state, 0,
					esfUserPersistence.countAll());

			if (esfUsers.size() > 0) {

				userIds = new long[esfUsers.size()];
				int i = 0;
				for (ESFUser e : esfUsers) {
					if (!esfPartecipants.contains(e)) {
						userIds[i] = e.getEsfUserId();
						i++;
					}
				}
			}else{
				return esfUsers;
			}
			
		}
		catch (SystemException e1) {
			e1.getMessage();
		}

		try {
			DynamicQuery esfUsersQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "esfUsersQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (Validator.isNotNull(userIds) && userIds.length > 0) {

				esfUsersQuery.add(PropertyFactoryUtil.forName(
					"esfUsersQuery.esfUserId").in(userIds));
			}

			esfUsers =
				ESFUserLocalServiceUtil.dynamicQuery(esfUsersQuery, start, end);
		}
		catch (Exception e) {
			e.getMessage();
		}

		return esfUsers;
	}

	public List<ESFUser> getESFUserByFirstName_LastName_FiscalCode(
		String firstName, String lastName, String fiscalCode, int state,
		long organizationId, int start, int end) {

		List<ESFUser> esfUsers =
			ESFUserFinderUtil.findShooterFiscalCode(
				firstName, lastName, organizationId, fiscalCode, state, start,
				end);
		
		return esfUsers;
	}

	
	public ESFUser getESFUserByFiscalCode(String fiscalCode) {

		List<ESFUser> esfUsers = null;
		try {

			DynamicQuery usersQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "usersQuery",
					PortletClassLoaderUtil.getClassLoader());
			if (Validator.isNotNull(fiscalCode)) {
				usersQuery.add(PropertyFactoryUtil.forName(
					"usersQuery.fiscalCode").eq(fiscalCode));
			}
			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(usersQuery);
		}
		catch (Exception e) {
			e.getMessage();
		}

		return esfUsers.get(0);
	}

	public List<ESFUser> getAllUserByLikeF_L(
		String firstName, String lastName, String screenName,
		int start, int end) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		List<User> users = new ArrayList<User>();

		try {

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					User.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.firstName").like(
				firstName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.lastName").like(
				lastName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.screenName").like(
				screenName + StringPool.PERCENT));

			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.lastName"));
			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.firstName"));

			users = UserLocalServiceUtil.dynamicQuery(userQuery, start, end);

			for (User user : users) {

				ESFUser esfUser =
					esfUserPersistence.fetchByPrimaryKey(user.getUserId());
				if(esfUser != null){
					esfUsers.add(esfUser);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUsers;
	}

	public int countAllUserByLikeF_L(
		String firstName, String lastName, String screenName) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		List<User> users = new ArrayList<User>();

		try {

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					User.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.firstName").like(
				firstName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.lastName").like(
				lastName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.screenName").like(
				screenName + StringPool.PERCENT));

			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.lastName"));
			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.firstName"));

			users = UserLocalServiceUtil.dynamicQuery(userQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (User user : users) {

				ESFUser esfUser =
					esfUserPersistence.fetchByPrimaryKey(user.getUserId());
				if(esfUser != null){
					esfUsers.add(esfUser);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUsers.size();
	}

	public List<ESFUser> getAllUserByLikeF_L_S(
		String firstName, String lastName, String screenName, int state,
		int start, int end) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFUserRole> esfUserRolesFitavManager =
				ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
					ESFKeys.ESFStateType.ENABLE);

			if (esfUserRolesFitavManager == null ||
				esfUserRolesFitavManager.size() == 0)
				return esfUsers;

			Long fitavManagerRoleId =
				esfUserRolesFitavManager.get(0).getEsfUserRoleId();

			List<User> userTemp =
				UserLocalServiceUtil.getRoleUsers(fitavManagerRoleId);
			List<User> users = new ArrayList<User>();
			for (int i = 0; i < userTemp.size(); i++) {

				ESFEntityState entityState =
					ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
						ESFUser.class.getName(), userTemp.get(i).getUserId(),
						state);
				if (Validator.isNotNull(entityState) &&
					entityState.getEsfEntityStateId() != 0)
					users.add(userTemp.get(i));
			}

			if (Validator.isNull(users) || users.size() == 0)
				return esfUsers;

			long[] classPKs = new long[users.size()];
			int i = 0;

			for (User user : users) {
				classPKs[i] = user.getUserId();
				i++;
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					User.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.firstName").like(
				firstName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.lastName").like(
				lastName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.screenName").like(
				screenName + StringPool.PERCENT));

			userQuery.add(PropertyFactoryUtil.forName("userQuery.userId").in(
				classPKs));
			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.lastName"));
			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.firstName"));

			users = UserLocalServiceUtil.dynamicQuery(userQuery, start, end);

			for (User user : users) {

				ESFUser esfUser =
					esfUserPersistence.fetchByPrimaryKey(user.getUserId());
				esfUsers.add(esfUser);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUsers;
	}

	public List<ESFUser> getAllUserByLikeF_L_S(
		String firstName, String lastName, String screenName, int state) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFUserRole> esfUserRolesFitavManager =
				ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
					ESFKeys.ESFStateType.ENABLE);

			_log.debug("esfUserRolesFitavManager "+esfUserRolesFitavManager);
			
			if (esfUserRolesFitavManager == null ||
				esfUserRolesFitavManager.size() == 0)
				return esfUsers;

			Long fitavManagerRoleId =
				esfUserRolesFitavManager.get(0).getEsfUserRoleId();

			_log.debug("fitavManagerRoleId "+fitavManagerRoleId);
			
			
			List<User> userTemp =
				UserLocalServiceUtil.getRoleUsers(fitavManagerRoleId);
			
			List<User> users = new ArrayList<User>();
			for (int i = 0; i < userTemp.size(); i++) {

				ESFEntityState entityState =
					ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
						ESFUser.class.getName(), userTemp.get(i).getUserId(),
						state);
				if (Validator.isNotNull(entityState) &&
					entityState.getEsfEntityStateId() != 0)
					users.add(userTemp.get(i));
			}

			_log.debug("userTemp "+userTemp.size());
			_log.debug("users "+users.size());
			

			if (Validator.isNull(users) || users.size() == 0)
				return esfUsers;

			long[] classPKs = new long[users.size()];
			int i = 0;

			for (User user : users) {
				classPKs[i] = user.getUserId();
				i++;
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					User.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.firstName").like(
				firstName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.lastName").like(
				lastName + StringPool.PERCENT));
			userQuery.add(PropertyFactoryUtil.forName("userQuery.screenName").like(
				screenName + StringPool.PERCENT));

			userQuery.add(PropertyFactoryUtil.forName("userQuery.userId").in(
				classPKs));
			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.lastName"));
			userQuery.addOrder(OrderFactoryUtil.asc("userQuery.firstName"));
			users = UserLocalServiceUtil.dynamicQuery(userQuery);

			for (User user : users) {

				ESFUser esfUser =
					esfUserPersistence.fetchByPrimaryKey(user.getUserId());
				esfUsers.add(esfUser);

			}
			_log.debug("esfUsers "+esfUsers.size());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUsers;
	}

	public List<ESFUser> getAllUserByLikeF_C_S(
		String firstName, String lastName, String cardCode, int state,
		long organizationId, int start, int end) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		List<ESFUser> esfStaff = new ArrayList<ESFUser>();
		try {

			esfUsers= ESFUserFinderUtil.findShooter(
				firstName, lastName, organizationId, cardCode, state, start,
				end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return esfUsers;
	}

	public List<ESFUser> getAllUserByLikeF_C_S(
		String firstName, String lastName, String cardCode, int state,
		long organizationId) {
		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
			try {
				int start=0;
				int end =esfUserPersistence.countAll();
				esfUsers= ESFUserFinderUtil.findShooter(
				firstName, lastName, organizationId, cardCode, state, start,
				end);
			return esfUsers;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return esfUsers;
	}


	public List<ESFUser> getAllShooterByLikeF_C_S(
			String firstName, String lastName, String cardCode,	long organizationId, int start, int end) {

			List<ESFUser> esfUsers = new ArrayList<ESFUser>();
			try {

				esfUsers= ESFUserFinderUtil.findAllShooter(
					firstName, lastName, organizationId, cardCode, start,
					end);

			}
			catch (Exception e) {
				e.printStackTrace();
			}

			return esfUsers;
	}

	public List<ESFUser> getAllShooterByLikeF_C_S(
		String firstName, String lastName, String cardCode, long organizationId) {
			
		List<ESFUser> esfUsers = new ArrayList<ESFUser>();
		try {
			int start = 0;
			int end = esfUserPersistence.countAll();
			esfUsers = ESFUserFinderUtil.findAllShooter(firstName, lastName, organizationId, cardCode, start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfUsers;
	}
		
	public List<ESFUser> getAllEsfUserByState(int state) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUser.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				classPKs));

			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(userQuery);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return esfUsers;
	}

	public List<ESFUser> getAllEsfUserByState(int state, int start, int end) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUser.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				classPKs));

			esfUsers =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUsers;
	}

	public List<ESFUser> findUserByRoleT_N_S(
		String title, String name, int state)
		throws NoSuchUserESFUserRoleException, SystemException {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		List<ESFUserRole> esfUserRoles =
			ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
				title, name, state);

		if (!esfUserRoles.isEmpty()) {

			ESFUserRole esfUserRole = esfUserRoles.get(0);

			List<ESFUserESFUserRole> esfUserESFUserRoles =
				ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfUserRoleId(esfUserRole.getEsfUserRoleId());

			List<Long> userIds = new ArrayList<Long>();

			for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {

				userIds.add(esfUserESFUserRole.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIds));

			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}

		return esfUsers;
	}

	public List<ESFUser> findAllShooters(int stateCard, int stateUser) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfUsersByState =
				ESFUserLocalServiceUtil.getAllEsfUserByState(stateUser);

			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfUserByState : esfUsersByState) {
				userIds.add(esfUserByState.getEsfUserId());

			}

			List<ESFCard> esfCards =
				ESFCardLocalServiceUtil.findAllESFCardsByState(stateCard);

			List<Long> userIdsInCard = new ArrayList<Long>();
			for (ESFCard esfCard : esfCards) {
				Long checkCard = new Long(esfCard.getEsfUserId());

				if (userIds.contains(checkCard))
					userIdsInCard.add(esfCard.getEsfUserId());
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsInCard.toArray()));

			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(userQuery);
		}
		catch (Exception e) {

		}

		return esfUsers;
	}

	public List<ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfUsersByState =
				ESFUserLocalServiceUtil.getAllEsfUserByState(stateUser);

			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfUserByState : esfUsersByState) {
				userIds.add(esfUserByState.getEsfUserId());

			}

			List<ESFCard> esfCards =
				ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(
					organizationId, false, stateCard);

			List<Long> userIdsInCard = new ArrayList<Long>();
			for (ESFCard esfCard : esfCards) {
				Long checkCard = new Long(esfCard.getEsfUserId());

				if (userIds.contains(checkCard))
					userIdsInCard.add(esfCard.getEsfUserId());
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsInCard.toArray()));

			esfUsers = ESFUserLocalServiceUtil.dynamicQuery(userQuery);
		}
		catch (Exception e) {

		}

		return esfUsers;
	}

	public List<ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser, int start, int end) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {

			List<ESFUser> esfUsersByState =
				ESFUserLocalServiceUtil.getAllEsfUserByState(stateUser);

			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfUserByState : esfUsersByState) {
				userIds.add(esfUserByState.getEsfUserId());

			}

			List<ESFCard> esfCards =
				ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(
					organizationId, false, stateCard);

			List<Long> userIdsInCard = new ArrayList<Long>();
			for (ESFCard esfCard : esfCards) {
				Long checkCard = new Long(esfCard.getEsfUserId());

				if (userIds.contains(checkCard))
					userIdsInCard.add(esfCard.getEsfUserId());
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsInCard.toArray()));

			esfUsers =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);
		}
		catch (Exception e) {

		}

		return esfUsers;
	}

	public List<ESFUser> findRoledUserOrganization(long organizationId)
		throws SystemException {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByOrganizationId(organizationId);

		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			esfUsers =
				(List<ESFUser>) ESFUserLocalServiceUtil.fetchESFUser(esfUserESFUserRole.getEsfUserId());
		}

		return esfUsers;
	}

	public List<ESFUser> findRoledUserOrganization(
		long organizationId, int start, int end)
		throws SystemException {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByOrganizationId(organizationId);

		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			esfUsers.add(ESFUserLocalServiceUtil.fetchESFUser(esfUserESFUserRole.getEsfUserId()));
		}

		List<ESFUser> esfUserRoleAssigned = null;

		for (; start < end && start < esfUsers.size(); start++)
			esfUserRoleAssigned.add(esfUsers.get(start));

		return esfUserRoleAssigned;
	}


	public List<ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end) {

		List<ESFUser> esfUsers =
			ESFUserFinderUtil.findShooterFiscalRole(
				organizationId, stateCard, esfUserRoleId, stateUser, start, end);
		return esfUsers;
	}

	public List<ESFUser> findAllShootersByLeafOrgAssignedName(String name, String lastName,
			long organizationId, int stateCard, long esfUserRoleId, int stateUser,
			int start, int end) {

			List<ESFUser> esfUsers =
				ESFUserFinderUtil.findShooterFiscalRoleName(name, lastName,
					organizationId, stateCard, esfUserRoleId, stateUser, start, end);
			return esfUsers;
	}
	
	public int countAllShootersByLeafOrgAssignedName(String name, String lastName,
			long organizationId, int stateCard, long esfUserRoleId, int stateUser) {
			int tot = 0;
			List<ESFUser> esfUsers =
				ESFUserFinderUtil.countShooterFiscalRoleName(name, lastName,
					organizationId, stateCard, esfUserRoleId, stateUser);
			
			return tot = esfUsers.size();
	}
	
	public List<ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser) {

		int size = 0;
		try {
			size =
				ESFUserFinderUtil.findShooterFiscalCode(
					"", "", organizationId, "", stateCard, 0,
					esfUserPersistence.countAll()).size();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		List<ESFUser> esfUsers =
			ESFUserFinderUtil.findShooterFiscalRole(
				organizationId, stateCard, esfUserRoleId, stateUser, 0, size);
		
		return esfUsers;

	}


	public List<ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfUsersWithRole = new ArrayList<ESFUser>();
			List<ESFUserRole> roles =
				ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(ESFUserRoleType.ORGANIZATION);
			for (ESFUserRole role : roles) {
				if (role.getIsBDO()) {
					esfUsersWithRole.addAll(findAllShootersByLeafOrgAssigned(
						organizationId, stateCard, role.getEsfUserRoleId(),
						stateUser));
				}
			}
			esfUsers.addAll(ESFUserFinderUtil.findShooterFiscalCode(
				"", "", organizationId, "", stateCard, 0,
				esfUserPersistence.countAll()));

			esfUsers.removeAll(esfUsersWithRole);
		}

		catch (SystemException e) {
			esfUsers = new ArrayList<ESFUser>();
			e.printStackTrace();
		}

		return esfUsers;
	}

	public List<ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser, int start, int end) {

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfUsersWithRole = new ArrayList<ESFUser>();
			List<ESFUserRole> roles =
				ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(ESFUserRoleType.ORGANIZATION);
			for (ESFUserRole role : roles) {
				if (role.getIsBDO()) {
					esfUsersWithRole.addAll(findAllShootersByLeafOrgAssigned(
						organizationId, stateCard, role.getEsfUserRoleId(),
						stateUser));
				}
			}
			esfUsers.addAll(ESFUserFinderUtil.findShooterFiscalCode(
				"", "", organizationId, "", stateCard, 0,
				esfUserPersistence.countAll()));

			esfUsers.removeAll(esfUsersWithRole);
		}

		catch (SystemException e) {
			esfUsers = new ArrayList<ESFUser>();
			e.printStackTrace();
		}

		List<ESFUser> esfUsersPaginator = new ArrayList<ESFUser>();
		for (int i = start; i < end && i < esfUsers.size(); i++)
			esfUsersPaginator.add(esfUsers.get(i));

		return esfUsersPaginator;
	}

	
	public List<ESFUser> finNationalDelegationESFUsersByMatchId(long esfMatchId) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				nationalIds[i] = e.getEsfUserId();
				i++;
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(nationalDelegationQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}
	
	
	public List<ESFUser> findAllStaff(Long esfMatchId, String firstName, String lastName, String fiscalCode,
			int state, Long organizationId, int start, int end)
			throws SystemException{
		List<ESFUser> userroled =  new ArrayList<ESFUser>();
		List<ESFUser> users =  new ArrayList<ESFUser>();
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllStaff(esfMatchId);
		List<Long> userId = new ArrayList<Long>();
		
		
		for(ESFUserESFUserRole uesrRoleId : esfUserESFUserRoles){
			userId.add(uesrRoleId.getEsfUserId());
		}
		
		List<ESFUser> esfUsers =ESFUserLocalServiceUtil.findAllUser();
		
		for(ESFUser user : esfUsers){
			if(userId.contains(user.getEsfUserId()))
				users.add(ESFUserLocalServiceUtil.fetchESFUser(user.getEsfUserId()));
		}
		
		
		return users;
	}
	
	
	public List<ESFUser> findAllStaffNamed(Long esfMatchId, String firstName, String lastName, String fiscalCode,
			int state, Long organizationId, int start, int end)
			throws SystemException{
		List<ESFUser> userroled =  new ArrayList<ESFUser>();
		List<ESFUser> users =  new ArrayList<ESFUser>();
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllStaff(esfMatchId);
		List<Long> userId = new ArrayList<Long>();
		
		
		for(ESFUserESFUserRole uesrRoleId : esfUserESFUserRoles){
			userId.add(uesrRoleId.getEsfUserId());
		}
		
		List<ESFUser> esfUsers =ESFUserLocalServiceUtil.
					getESFUserByFirstName_LastName_FiscalCode(
					firstName, lastName, fiscalCode, state, organizationId, start,
					end);
		
		for(ESFUser u : esfUsers){
			if(userId.contains(u.getEsfUserId())){
				users.add(u);
			}
		}

		return users;
	}
	
	
	public List<ESFUser> findStaffNamed(long esfMatchId, String firstName, String lastName, String fiscalCode)
			throws SystemException, PortalException{
		
		List<ESFUser> users =  new ArrayList<ESFUser>();
		List<User> usersNamed =  new ArrayList<User>();	
		List<Long>esfUserTotId = new ArrayList<Long>();
		List<Long>esfUserESFUserRolesId = new ArrayList<Long>();
		List<ESFUser> userRoled =  new ArrayList<ESFUser>();

		List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				getESFUserESFUserRoleStaff(esfMatchId);

		for(ESFUserESFUserRole e : esfUserESFUserRoles){
				esfUserESFUserRolesId.add(e.getEsfUserId());
		}
		
		for(Long id : esfUserESFUserRolesId){
			userRoled.add(ESFUserLocalServiceUtil.fetchESFUser(id));
			
		}

		for(ESFUser u : userRoled){
			if(u.getFirstName().toLowerCase().contains(firstName.toLowerCase())
					&& u.getLastName().toLowerCase().contains(lastName.toLowerCase())
						&& u.getFiscalCode().toLowerCase().contains(fiscalCode.toLowerCase()) ){
				users.add(u);
			}
			
		}
		
		return users;
	}
	
	public List<ESFUser> findStaffNamed(long esfMatchId, String firstName, String lastName, String fiscalCode,
			int start, int end)
			throws SystemException, PortalException{
		
		List<ESFUser> users =  new ArrayList<ESFUser>();
		List<User> usersNamed =  new ArrayList<User>();	
		List<Long>esfUserTotId = new ArrayList<Long>();
		List<ESFUser> userRoled =  new ArrayList<ESFUser>();
		List<ESFUser> usersStart =  new ArrayList<ESFUser>();	
		List<Long>esfUserESFUserRolesId = new ArrayList<Long>();
		List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllNationalStaff(esfMatchId);

		for(ESFUserESFUserRole e : esfUserESFUserRoles){
				esfUserESFUserRolesId.add(e.getEsfUserId());
		}
		
		for(Long id : esfUserESFUserRolesId){
			userRoled.add(ESFUserLocalServiceUtil.fetchESFUser(id));
			
		}

		for(ESFUser u : userRoled){
			if(u.getFirstName().toLowerCase().contains(firstName.toLowerCase())
					&& u.getLastName().toLowerCase().contains(lastName.toLowerCase())
						&& u.getFiscalCode().toLowerCase().contains(fiscalCode.toLowerCase()) ){
				users.add(u);
			}
			
		}

		if(end > users.size()){
			end=users.size();
		}
		usersStart = users.subList(start, end);
		
		return usersStart;
	}
	
	
	
	public List<ESFUser> findStaffNamedNational(long esfMatchId, String firstName, String lastName, String fiscalCode)
			throws SystemException, PortalException{
		List<ESFUser> users =  new ArrayList<ESFUser>();
		List<ESFUser> userRoled =  new ArrayList<ESFUser>();
		List<ESFUser> usersNamed =  new ArrayList<ESFUser>();	
		List<Long>esfUserTotId = new ArrayList<Long>();
		List<Long>esfUserESFUserRolesId = new ArrayList<Long>();
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllNationalStaff(esfMatchId);
			
		for(ESFUserESFUserRole e : esfUserESFUserRoles){
				esfUserESFUserRolesId.add(e.getEsfUserId());
		}
		
		for(Long id : esfUserESFUserRolesId){
			userRoled.add(ESFUserLocalServiceUtil.fetchESFUser(id));
			
		}

		for(ESFUser u : userRoled){
			if(u.getFirstName().contains(firstName) && u.getLastName().contains(lastName) && u.getFiscalCode().contains(fiscalCode) ){
				users.add(u);
			}
			
		}
		
		return users;
	}
	
	public List<ESFUser> findStaffNamedNational(long esfMatchId, String firstName, String lastName, String fiscalCode,
			int start, int end)
			throws SystemException, PortalException{
		List<ESFUser> users =  new ArrayList<ESFUser>();
		List<ESFUser> userRoled =  new ArrayList<ESFUser>();
		List<ESFUser> usersStart =  new ArrayList<ESFUser>();	
		List<Long>esfUserTotId = new ArrayList<Long>();
		List<Long>esfUserESFUserRolesId = new ArrayList<Long>();
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllNationalStaff(esfMatchId);
			
		for(ESFUserESFUserRole e : esfUserESFUserRoles){
				esfUserESFUserRolesId.add(e.getEsfUserId());
		}
		
		for(Long id : esfUserESFUserRolesId){
			userRoled.add(ESFUserLocalServiceUtil.fetchESFUser(id));
			
		}

		for(ESFUser u : userRoled){
			if(u.getFirstName().contains(firstName) && u.getLastName().contains(lastName) && u.getFiscalCode().contains(fiscalCode) ){
				users.add(u);
			}
			
		}
		
		if(end > users.size()){
			end=users.size();
		}
		usersStart = users.subList(start, end);
		
		return usersStart;
	}
	
	public List<ESFUser> findStaff(long esfMatchId)
			throws SystemException{
		
		List<ESFUser> users =  new ArrayList<ESFUser>();
		 
		 List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllStaff(esfMatchId);
		for(ESFUserESFUserRole user : esfUserESFUserRoles){
			users.add(ESFUserLocalServiceUtil.fetchESFUser(user.getEsfUserId()));
		}
		
		return users;
	}
	
	public List<ESFUser> findStaff(long esfMatchId, int start, int end)
			throws SystemException{
		
		List<ESFUser> users =  new ArrayList<ESFUser>();
		 
		 List<ESFUserESFUserRole> esfUserESFUserRoles =ESFUserESFUserRoleLocalServiceUtil.
				 getESFUserESFUserRoleAllStaff(esfMatchId);
		for(ESFUserESFUserRole user : esfUserESFUserRoles){
			users.add(ESFUserLocalServiceUtil.fetchESFUser(user.getEsfUserId()));
		}
		
		List<ESFUser> esfUserT =  new ArrayList<ESFUser>();
		
		for(  ; start<end && start<esfUserT.size() ; start++)
			users.add(esfUserT.get(start));
		
		return users;
	}
	

	public List<ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId, int start, int end) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				nationalIds[i] = e.getEsfUserId();
				i++;
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(
					nationalDelegationQuery, start, end);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}

	/**
	 * Trova lo staff di una specifica gara
	 */

	public List<ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				if (e.getEsfPartecipantTypeId() != ESFKeys.ESFNationalDelegationType.SHOOTER) {
					nationalIds[i] = e.getEsfUserId();
					i++;
				}
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(nationalDelegationQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}

	/**
	 * Trova lo staff di una specifica gara
	 */

	public List<ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId, int start, int end) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				if (e.getEsfPartecipantTypeId() != ESFKeys.ESFNationalDelegationType.SHOOTER) {
					nationalIds[i] = e.getEsfUserId();
					i++;
				}
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(
					nationalDelegationQuery, start, end);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}


	public List<ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				nationalIds[i] = e.getEsfUserId();
				i++;
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(nationalDelegationQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}

	public List<ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId, int start, int end) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				nationalIds[i] = e.getEsfUserId();
				i++;
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(
					nationalDelegationQuery, start, end);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}

	public List<ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					esfMatchId, esfPartecipantTypeId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				nationalIds[i] = e.getEsfUserId();
				i++;
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(nationalDelegationQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}

	public List<ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId, int start, int end) {

		List<ESFUser> nationalDelegationESFUsers = new ArrayList<ESFUser>();
		long nationalIds[] = null;
		try {

			List<ESFNationalDelegation> esfNationalDelegations =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					esfMatchId, esfPartecipantTypeId);

			if (esfNationalDelegations.size() <= 0)
				return nationalDelegationESFUsers;

			nationalIds = new long[esfNationalDelegations.size()];

			int i = 0;
			for (ESFNationalDelegation e : esfNationalDelegations) {
				nationalIds[i] = e.getEsfUserId();
				i++;
			}

			DynamicQuery nationalDelegationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "nationalDelegationQuery",
					PortletClassLoaderUtil.getClassLoader());

			nationalDelegationQuery.add(PropertyFactoryUtil.forName(
				"nationalDelegationQuery.esfUserId").in(nationalIds));

			nationalDelegationESFUsers =
				ESFUserLocalServiceUtil.dynamicQuery(
					nationalDelegationQuery, start, end);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return nationalDelegationESFUsers;
	}

	public List<ESFUser> findNationalShooters() {

		List<ESFUser> esfNationals = new ArrayList<ESFUser>();
		long shooterIds[] = null;

		try {
			List<ESFNational> esfActiveNationals =
				ESFNationalLocalServiceUtil.getActiveESFNationals(
					0, ESFNationalLocalServiceUtil.countActiveESFNationals());

			if (esfActiveNationals.size() <= 0)
				return esfNationals;

			shooterIds = new long[esfActiveNationals.size()];

			int i = 0;

			for (ESFNational national : esfActiveNationals) {
				shooterIds[i] = national.getEsfUserId();
				i++;
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				shooterIds));

			esfNationals = ESFUserLocalServiceUtil.dynamicQuery(userQuery);
		}
		catch (Exception e) {
			e.getMessage();
		}

		return esfNationals;
	}

	public List<ESFUser> findNationalShooters(int start, int end) {

		List<ESFUser> esfNationals = new ArrayList<ESFUser>();
		long shooterIds[] = null;

		try {
			List<ESFNational> esfActiveNationals =
				ESFNationalLocalServiceUtil.getActiveESFNationals(
					0, ESFNationalLocalServiceUtil.countActiveESFNationals());

			if (esfActiveNationals.size() <= 0)
				return esfNationals;

			shooterIds = new long[esfActiveNationals.size()];

			int i = 0;

			for (ESFNational national : esfActiveNationals) {
				shooterIds[i] = national.getEsfUserId();
				i++;
			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				shooterIds));

			esfNationals =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);
		}
		catch (Exception e) {
			e.getMessage();
		}

		return esfNationals;
	}

	/**
	 * Ricerca tutti gli Shooters che possono essere gia' stati associati ad una
	 * gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	 * non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 */
	public List<ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant)
		throws SystemException {

		List<ESFUser> esfShootersPartecipant = new ArrayList<ESFUser>();

		try {

			List<ESFNationalDelegation> esfNationalDels =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					idMatch, ESFKeys.ESFNationalDelegationType.SHOOTER);

			long[] userIdsPartecipant = null;

			if (isPartecipant) {

				if (esfNationalDels.size() <= 0)
					return esfShootersPartecipant;

				userIdsPartecipant = new long[esfNationalDels.size()];

				int i = 0;

				for (ESFNationalDelegation delegationl : esfNationalDels) {
					userIdsPartecipant[i] = delegationl.getEsfUserId();
					// i++;
				}
			}
			else {

				List<ESFNational> esfNational =
					ESFNationalLocalServiceUtil.getActiveESFNationals(
						0,
						ESFNationalLocalServiceUtil.countActiveESFNationals());

				if (esfNational == null || esfNational.size() <= 0)
					return esfShootersPartecipant;

				if (esfNationalDels.size() > 0) {
					for (ESFNationalDelegation delegation : esfNationalDels) {
						boolean notFinded = true;
						int k = 0;
						for (int j = 0; j < esfNational.size() && notFinded; j++) {
							if (esfNational.get(j).getEsfUserId() == delegation.getEsfUserId()) {
								notFinded = false;
								k = j;
							}
						}
						if (notFinded)
							esfNational.remove(k);
					}
				}
				userIdsPartecipant = new long[esfNational.size()];

				int i = 0;

				for (ESFNational national : esfNational) {
					userIdsPartecipant[i] = national.getEsfUserId();
				}

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsPartecipant));

			esfShootersPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}
		catch (Exception e) {
			e.getMessage();
		}

		return esfShootersPartecipant;
	}

	/**
	 * Ricerca tutti gli Shooters che possono essere gia' stati associati ad una
	 * gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	 * non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @param start
	 * @param end
	 * @return List<ESFUser>
	 * @throws SystemException
	 */
	public List<ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException {

		List<ESFUser> esfShootersPartecipant = new ArrayList<ESFUser>();

		try {

			List<ESFNationalDelegation> esfNationalDels =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					idMatch, ESFKeys.ESFNationalDelegationType.SHOOTER);

			long[] userIdsPartecipant = null;

			if (isPartecipant) {

				if (esfNationalDels.size() <= 0)
					return esfShootersPartecipant;

				userIdsPartecipant = new long[esfNationalDels.size()];

				int i = 0;

				for (ESFNationalDelegation delegationl : esfNationalDels) {
					userIdsPartecipant[i] = delegationl.getEsfUserId();
				}
			}
			else {

				List<ESFNational> esfNational =
					ESFNationalLocalServiceUtil.getActiveESFNationals(
						0,
						ESFNationalLocalServiceUtil.countActiveESFNationals());

				if (esfNational == null || esfNational.size() <= 0)
					return esfShootersPartecipant;

				if (esfNationalDels.size() > 0) {
					for (ESFNationalDelegation delegation : esfNationalDels) {
						boolean notFinded = true;
						int k = 0;
						for (int j = 0; j < esfNational.size() && notFinded; j++) {
							if (esfNational.get(j).getEsfUserId() == delegation.getEsfUserId()) {
								notFinded = false;
								k = j;
							}
						}
						if (notFinded)
							esfNational.remove(k);
					}
				}
				userIdsPartecipant = new long[esfNational.size()];

				int i = 0;

				for (ESFNational national : esfNational) {
					userIdsPartecipant[i] = national.getEsfUserId();
				}

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsPartecipant));

			esfShootersPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);

		}
		catch (Exception e) {

		}

		return esfShootersPartecipant;
	}

	/**
	 * Ricerca tutti gli Shooters con stato utente <b>stateUser</b> e con stato
	 * card <b>stateCard</b> che possono essere gia' stati associati ad una gara
	 * con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateCard
	 *            stato della Card
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 */
	public List<ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant)
		throws SystemException {

		List<ESFUser> esfShootersPartecipant = new ArrayList<ESFUser>();

		try {

			List<ESFUser> esfShooters = findAllShooters(stateCard, stateUser);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfShooter : esfShooters) {

				userIds.add(esfShooter.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.SHOOTER);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfShooter : esfShooters) {

					if (!userIdsPartecipant.contains(esfShooter.getEsfUserId())) {

						userIdsNotPartecipant.add(esfShooter.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfShootersPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}
		catch (Exception e) {

		}

		return esfShootersPartecipant;
	}

	/**
	 * Ricerca tutti gli Shooters con stato utente <b>stateUser</b> e con stato
	 * card <b>stateCard</b> che possono essere gia' stati associati ad una gara
	 * con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false) I parametri di <b>start</b>
	 * e <b>end</b> definiscono il range di oggetti da restituire.
	 * 
	 * @param stateCard
	 *            stato della Card
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @param start
	 * @param end
	 * @return List<ESFUser>
	 * @throws SystemException
	 */
	public List<ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant,
		int start, int end)
		throws SystemException {

		List<ESFUser> esfShootersPartecipant = new ArrayList<ESFUser>();

		try {

			List<ESFUser> esfShooters = findAllShooters(stateCard, stateUser);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfShooter : esfShooters) {

				userIds.add(esfShooter.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.SHOOTER);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfShooter : esfShooters) {

					if (!userIdsPartecipant.contains(esfShooter.getEsfUserId())) {

						userIdsNotPartecipant.add(esfShooter.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfShootersPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);

		}
		catch (Exception e) {

		}
		System.out.println("#############entra in findPartecipantShooters");
		return esfShootersPartecipant;
	}

	

	/**
	 * Ricerca tutti gli utenti che sono stati assegnati ad un match nazionale
	 * con ruolo Allenatore. L'utetne puï¿½ esseree gia' stati associato ad una
	 * gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	 * non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant)
		throws SystemException, NoSuchUserESFUserRoleException {

		return findNationalPartecipantByType(
			idMatch, isPartecipant, ESFKeys.ESFNationalDelegationType.COACH,
			ESFKeys.ESFUserRoleDefault.COACH);
	}

	/**
	 * Ricerca tutti gli utenti che sono stati assegnati ad un match nazionale
	 * con ruolo Allenatore. L'utetne puï¿½ esseree gia' stati associato ad una
	 * gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	 * non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @param start
	 * @param end
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		return findNationalPartecipantByType(
			idMatch, isPartecipant, ESFKeys.ESFNationalDelegationType.COACH,
			ESFKeys.ESFUserRoleDefault.COACH, start, end);
	}

	/**
	 * Ricerca tutti gli utenti con ruolo Allenatore con stato utente
	 * <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	 * id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfCoachesPartecipant = new ArrayList<ESFUser>();

		try {

			List<ESFUser> esfCoaches =
				findUserByRoleT_N_S(
					ESFKeys.ESFUserRoleDefault.COACH,
					ESFKeys.ESFUserRoleDefault.COACH,
					ESFKeys.ESFStateType.ENABLE);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfCoache : esfCoaches) {

				userIds.add(esfCoache.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.COACH);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfCoache : esfCoaches) {

					if (!userIdsPartecipant.contains(esfCoache.getEsfUserId())) {

						userIdsNotPartecipant.add(esfCoache.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfCoachesPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}
		catch (Exception e) {

		}

		return esfCoachesPartecipant;
	}

	/**
	 * Ricerca tutti gli utenti con ruolo Allenatore con stato utente
	 * <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	 * id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @param start
	 * @param end
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfCoachesPartecipant = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfCoaches =
				findUserByRoleT_N_S(
					ESFKeys.ESFUserRoleDefault.COACH,
					ESFKeys.ESFUserRoleDefault.COACH,
					ESFKeys.ESFStateType.ENABLE);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfCoache : esfCoaches) {

				userIds.add(esfCoache.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.COACH);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfCoache : esfCoaches) {

					if (!userIdsPartecipant.contains(esfCoache.getEsfUserId())) {

						userIdsNotPartecipant.add(esfCoache.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfCoachesPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);

		}
		catch (Exception e) {

		}

		return esfCoachesPartecipant;
	}


	/**
	 * Ricerca tutti gli utenti con ruolo Arbitro che possono essere gia' stati
	 * associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	 * true) o ancora non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant)
		throws SystemException, NoSuchUserESFUserRoleException {

		return findNationalPartecipantByType(
			idMatch, isPartecipant, ESFKeys.ESFNationalDelegationType.REFEREE,
			ESFKeys.ESFUserRoleDefault.REFEREE);
	}

	/**
	 * Ricerca tutti gli utenti con ruolo Arbitro che possono essere gia' stati
	 * associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	 * true) o ancora non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @param start
	 * @param end
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		return findNationalPartecipantByType(
			idMatch, isPartecipant, ESFKeys.ESFNationalDelegationType.REFEREE,
			ESFKeys.ESFUserRoleDefault.REFEREE, start, end);
	}

	/**
	 * Ricerca tutti gli utenti con ruolo Arbitro con stato utente
	 * <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	 * id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @param start
	 * @param end
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfRefereesPartecipant = new ArrayList<ESFUser>();

		try {

			List<ESFUser> esfReferees =
				findUserByRoleT_N_S(
					ESFKeys.ESFUserRoleDefault.REFEREE,
					ESFKeys.ESFUserRoleDefault.REFEREE,
					ESFKeys.ESFStateType.ENABLE);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfReferee : esfReferees) {

				userIds.add(esfReferee.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.REFEREE);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfReferee : esfReferees) {

					if (!userIdsPartecipant.contains(esfReferee.getEsfUserId())) {

						userIdsNotPartecipant.add(esfReferee.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfRefereesPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);

		}
		catch (Exception e) {

		}

		return esfRefereesPartecipant;
	}

	/**
	 * Ricerca tutti gli utenti con ruolo Arbitro con stato utente
	 * <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	 * id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfRefereesPartecipant = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfReferees =
				findUserByRoleT_N_S(
					ESFKeys.ESFUserRoleDefault.REFEREE,
					ESFKeys.ESFUserRoleDefault.REFEREE,
					ESFKeys.ESFStateType.ENABLE);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfReferee : esfReferees) {

				userIds.add(esfReferee.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.REFEREE);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfReferee : esfReferees) {

					if (!userIdsPartecipant.contains(esfReferee.getEsfUserId())) {

						userIdsNotPartecipant.add(esfReferee.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfRefereesPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}
		catch (Exception e) {

		}

		return esfRefereesPartecipant;
	}

	

	/**
	 * Ricerca tutti gli utenti con ruolo Medico che possono essere gia' stati
	 * associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	 * true) o ancora non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant)
		throws SystemException, NoSuchUserESFUserRoleException {

		return findNationalPartecipantByType(
			idMatch, isPartecipant, ESFKeys.ESFNationalDelegationType.DOCTOR,
			ESFKeys.ESFUserRoleDefault.DOCTOR);

	}

	/**
	 * Ricerca tutti gli utenti con ruolo Medico che possono essere gia' stati
	 * associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	 * true) o ancora non associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param esfTournamentId
	 *            id del Torneo
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		return findNationalPartecipantByType(
			idMatch, isPartecipant, ESFKeys.ESFNationalDelegationType.DOCTOR,
			ESFKeys.ESFUserRoleDefault.DOCTOR, start, end);

	}

	/**
	 * Ricerca tutti gli utenti con ruolo Medico con stato utente
	 * <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	 * id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfDoctorsPartecipant = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfDoctors =
				findUserByRoleT_N_S(
					ESFKeys.ESFUserRoleDefault.DOCTOR,
					ESFKeys.ESFUserRoleDefault.DOCTOR,
					ESFKeys.ESFStateType.ENABLE);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfDoctor : esfDoctors) {

				userIds.add(esfDoctor.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.DOCTOR);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfDoctor : esfDoctors) {

					if (!userIdsPartecipant.contains(esfDoctor.getEsfUserId())) {

						userIdsNotPartecipant.add(esfDoctor.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfDoctorsPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}
		catch (Exception e) {

		}

		return esfDoctorsPartecipant;
	}

	/**
	 * Ricerca tutti gli utenti con ruolo Medico con stato utente
	 * <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	 * id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	 * associati (caso <b>isPartecipant</b> = false)
	 * 
	 * @param stateUser
	 *            stato dello User
	 * @param idMatch
	 *            id del Match
	 * @param isPartecipant
	 *            'true' se voglio ricercare gli utenti associati ad una gara,
	 *            'false' altrimenti
	 * @return List<ESFUser>
	 * @throws SystemException
	 * @throws NoSuchUserESFUserRoleException
	 */
	public List<ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfDoctorsPartecipant = new ArrayList<ESFUser>();

		try {
			List<ESFUser> esfDoctors =
				findUserByRoleT_N_S(
					ESFKeys.ESFUserRoleDefault.DOCTOR,
					ESFKeys.ESFUserRoleDefault.DOCTOR,
					ESFKeys.ESFStateType.ENABLE);

			List<Long> userIdsPartecipant = new ArrayList<Long>();
			List<Long> userIdsNotPartecipant = new ArrayList<Long>();
			List<Long> userIds = new ArrayList<Long>();

			for (ESFUser esfDoctor : esfDoctors) {

				userIds.add(esfDoctor.getEsfUserId());

			}

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipants(
					idMatch, userIds.toArray(),
					ESFKeys.ESFNationalDelegationType.DOCTOR);

			for (ESFPartecipant esfPartecipant : esfPartecipants) {

				userIdsPartecipant.add(esfPartecipant.getEsfUserId());

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (isPartecipant) {

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsPartecipant.toArray()));

			}
			else {

				for (ESFUser esfDoctor : esfDoctors) {

					if (!userIdsPartecipant.contains(esfDoctor.getEsfUserId())) {

						userIdsNotPartecipant.add(esfDoctor.getEsfUserId());

					}

				}

				userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
					userIdsNotPartecipant.toArray()));

			}

			esfDoctorsPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);

		}
		catch (Exception e) {

		}

		return esfDoctorsPartecipant;
	}

	private List<ESFUser> findNationalPartecipantByType(
		long idMatch, boolean isPartecipant, int typeFinder, String typeDescs)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfPartecipant = new ArrayList<ESFUser>();

		try {
			List<ESFNationalDelegation> esfNationalDels =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					idMatch, typeFinder);

			long[] userIdsPartecipant = null;

			if (isPartecipant) {

				if (esfNationalDels.size() <= 0)
					return esfPartecipant;

				userIdsPartecipant = new long[esfNationalDels.size()];

				int i = 0;

				for (ESFNationalDelegation delegationl : esfNationalDels) {
					userIdsPartecipant[i] = delegationl.getEsfUserId();
				}
			}
			else {

				List<ESFUserRole> esfUserRoles =
					ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
						typeDescs, typeDescs, ESFKeys.ESFStateType.ENABLE);

				List<ESFUserESFUserRole> esfUserEsfUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.getESFUSerRoleByR_ED(esfUserRoles.get(
						0).getEsfUserRoleId());

				if (esfUserEsfUserRoles == null ||
					esfUserEsfUserRoles.size() <= 0)
					return esfPartecipant;

				if (esfNationalDels.size() > 0) {
					for (ESFNationalDelegation delegation : esfNationalDels) {
						boolean notFinded = true;
						int k = 0;
						for (int j = 0; j < esfUserEsfUserRoles.size() &&
							notFinded; j++) {
							if (esfUserEsfUserRoles.get(j).getEsfUserId() == delegation.getEsfUserId()) {
								notFinded = false;
								k = j;
							}
						}
						if (notFinded)
							esfUserEsfUserRoles.remove(k);
					}
				}
				userIdsPartecipant = new long[esfUserEsfUserRoles.size()];

				int i = 0;

				for (ESFUserESFUserRole uur : esfUserEsfUserRoles) {
					userIdsPartecipant[i] = uur.getEsfUserId();
				}

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsPartecipant));

			esfPartecipant = ESFUserLocalServiceUtil.dynamicQuery(userQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return esfPartecipant;
	}

	private List<ESFUser> findNationalPartecipantByType(
		long idMatch, boolean isPartecipant, int typeFinder, String typeDescs,
		int start, int end)
		throws SystemException, NoSuchUserESFUserRoleException {

		List<ESFUser> esfPartecipant = new ArrayList<ESFUser>();

		try {
			List<ESFNationalDelegation> esfNationalDels =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					idMatch, typeFinder);

			long[] userIdsPartecipant = null;

			if (isPartecipant) {

				if (esfNationalDels.size() <= 0)
					return esfPartecipant;

				userIdsPartecipant = new long[esfNationalDels.size()];

				int i = 0;

				for (ESFNationalDelegation delegationl : esfNationalDels) {
					userIdsPartecipant[i] = delegationl.getEsfUserId();
				}
			}
			else {

				List<ESFUserRole> esfUserRoles =
					ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
						typeDescs, typeDescs, ESFKeys.ESFStateType.ENABLE);

				List<ESFUserESFUserRole> esfUserEsfUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.getESFUSerRoleByR_ED(esfUserRoles.get(
						0).getEsfUserRoleId());

				if (esfUserEsfUserRoles == null ||
					esfUserEsfUserRoles.size() <= 0)
					return esfPartecipant;

				if (esfNationalDels.size() > 0) {
					for (ESFNationalDelegation delegation : esfNationalDels) {
						boolean notFinded = true;
						int k = 0;
						for (int j = 0; j < esfUserEsfUserRoles.size() &&
							notFinded; j++) {
							if (esfUserEsfUserRoles.get(j).getEsfUserId() == delegation.getEsfUserId()) {
								notFinded = false;
								k = j;
							}
						}
						if (notFinded)
							esfUserEsfUserRoles.remove(k);
					}
				}
				userIdsPartecipant = new long[esfUserEsfUserRoles.size()];

				int i = 0;

				for (ESFUserESFUserRole uur : esfUserEsfUserRoles) {
					userIdsPartecipant[i] = uur.getEsfUserId();
				}

			}

			DynamicQuery userQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUser.class, "userQuery",
					PortletClassLoaderUtil.getClassLoader());

			userQuery.add(PropertyFactoryUtil.forName("userQuery.esfUserId").in(
				userIdsPartecipant));

			esfPartecipant =
				ESFUserLocalServiceUtil.dynamicQuery(userQuery, start, end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return esfPartecipant;
	}

	public ESFUser addESFUser(
		long operatorId, String code, String firstName, String middleName,
		String lastName, String userEmail, String fiscalCode, int birthdayDay,
		int birthdayMonth, int birthdayYear, boolean male, String skype,
		String facebook, String twitter, String jobTitle,
		ESFEntityState esfEntityState, List<ESFAddress> esfAddresses,
		List<ESFPhone> phones, String birthcity, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User operator = userPersistence.findByPrimaryKey(operatorId);
		User portalUser = null;
		ESFUser esfUser = null;

		portalUser =
			userLocalService.addUser(
				operator.getUserId(), operator.getCompanyId(), true,
				StringPool.BLANK, StringPool.BLANK, true, StringPool.BLANK,
				userEmail, 0, StringPool.BLANK, operator.getLocale(),
				firstName, middleName, lastName, 0, 0, male, birthdayMonth,
				birthdayDay, birthdayYear, jobTitle, new long[0], new long[0],
				new long[0], new long[0], true, serviceContext);

		long portalUserId = portalUser.getUserId();

		Contact portalUserContact = portalUser.getContact();
		portalUserContact.setFacebookSn(facebook);
		portalUserContact.setSkypeSn(skype);
		portalUserContact.setTwitterSn(twitter);
		
		userLocalService.updateUser(portalUser);
		ContactLocalServiceUtil.updateContact(portalUserContact);

		long groupId = serviceContext.getScopeGroupId();

		validate(portalUserId);

		long esfUserId = portalUserId;

		for (ESFAddress esfAddress : esfAddresses) {

			esfAddressLocalService.addESFAddress(
				serviceContext.getUserId(), esfAddress.getLongitude(),
				esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
				esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
				esfAddress.getLatitude(), esfAddress.getType(),
				esfAddress.getListTypeId(), ESFUser.class.getName(), esfUserId,
				esfAddress.getStreet1(), esfAddress.getStreet2(),
				esfAddress.getStreet3(), esfAddress.getZip(),
				esfAddress.getTypeId(), esfAddress.getMailing(),
				esfAddress.getPrimary_(), esfAddress.getIsNotNational(),serviceContext);

		}

		boolean first = true;

		for (ESFPhone phone : phones) {

			ESFPhoneLocalServiceUtil.addESFPhone(
				operator.getUserId(), ESFUser.class.getName(), esfUserId,
				phone.getNumber(), StringPool.BLANK, phone.getListTypeId(),
				phone.getTypeId(), first, serviceContext);

			first = false;
		}

		ESFEntityStateLocalServiceUtil.addEntityState(
			serviceContext.getUserId(), ESFUser.class.getName(), esfUserId,
			esfEntityState.getEsfStateId(), serviceContext);

		esfUser = esfUserPersistence.create(esfUserId);

		esfUser.setUuid(serviceContext.getUuid());
		esfUser.setExpandoBridgeAttributes(serviceContext);
		esfUser.setCode(code);
		esfUser.setFiscalCode(fiscalCode);
		esfUser.setBirthcity(birthcity);
		esfUser.setJob(jobTitle);

		esfUserPersistence.update(esfUser);

		resourceLocalService.addResources(
			operator.getCompanyId(), groupId, operator.getUserId(),
			ESFUser.class.getName(), esfUserId, false, true, true);

		long organizationId =
			serviceContext.getScopeGroup().getOrganizationId();

		UserLocalServiceUtil.addOrganizationUser(organizationId, esfUserId);

		return esfUser;
	}

	public ESFUser addESFUserInOrganization(
		long userId, String code, String screenName, String emailAddress,
		long facebookId, Locale locale, String firstName, String middleName,
		String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
		ESFAddress esfAddress, ESFEntityState esfEntityState,
		List<Phone> phones, ServiceContext portalUserServiceContext,
		ServiceContext esfUserServiceContext)
		throws PortalException, SystemException {
		User operator = userPersistence.findByPrimaryKey(userId);
		User portalUser = null;
		ESFUser esfUser = null;
		try {
			portalUser =
					userLocalService.addUser(
						operator.getUserId(), operator.getCompanyId(), true, "", "",
						true, screenName, emailAddress, facebookId, "", locale,
						firstName, middleName, lastName, prefixId, suffixId, male,
						birthdayMonth, birthdayDay, birthdayYear, jobTitle,
						new long[0], new long[0], new long[0], new long[0], false,
						portalUserServiceContext);

		} catch (Exception e) {
			_log.debug(e);
		}

		long portalUserId = portalUser.getUserId();
		long groupId = esfUserServiceContext.getScopeGroupId();
		validate(portalUserId);

		long esfUserId = portalUserId;
		if (Validator.isNotNull(esfAddress)) {

			esfAddressLocalService.addESFAddress(
				esfUserServiceContext.getUserId(), esfAddress.getLongitude(),
				esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
				esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
				esfAddress.getLatitude(), esfAddress.getType(),
				esfAddress.getListTypeId(), ESFUser.class.getName(), esfUserId,
				esfAddress.getStreet1(), esfAddress.getStreet2(),
				esfAddress.getStreet3(), esfAddress.getZip(),
				esfAddress.getTypeId(), esfAddress.getMailing(),
				esfAddress.getPrimary_(), esfAddress.getIsNotNational(), esfUserServiceContext);
		}
		boolean first = true;
		for (Phone phone : phones) {

			PhoneLocalServiceUtil.addPhone(
				userId, ESFUser.class.getName(), esfUserId, phone.getNumber(),
				StringPool.BLANK, phone.getTypeId(), first,
				esfUserServiceContext);

			first = false;
		}
		if (Validator.isNotNull(esfEntityState)) {
			ESFEntityStateLocalServiceUtil.addEntityState(
				esfUserServiceContext.getUserId(), ESFUser.class.getName(),
				esfUserId, esfEntityState.getEsfStateId(), esfUserServiceContext);
		}
		esfUser = esfUserPersistence.create(esfUserId);
		esfUser.setUuid(esfUserServiceContext.getUuid());
		esfUser.setExpandoBridgeAttributes(esfUserServiceContext);
		esfUser.setCode(code);
		esfUserPersistence.update(esfUser);
		resourceLocalService.addResources(
			operator.getCompanyId(), groupId, userId, ESFUser.class.getName(),
			esfUserId, false, true, true);
		return esfUser;
	}

	public ESFUser addESFUserInOrganization(
		long userId, String code, String screenName, String emailAddress,
		long facebookId, Locale locale, String firstName, String middleName,
		String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
		ESFAddress esfAddress, long esfStateId, List<Phone> phones,
		ServiceContext portalUserServiceContext,
		ServiceContext esfUserServiceContext)
		throws PortalException, SystemException {

		User operator = userPersistence.findByPrimaryKey(userId);
		User portalUser = null;
		ESFUser esfUser = null;

		portalUser =
			userLocalService.addUser(
				operator.getUserId(), operator.getCompanyId(), true, "", "",
				false, screenName, emailAddress, facebookId, "", locale,
				firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle,
				new long[0], new long[0], new long[0], new long[0], false,
				portalUserServiceContext);

		long portalUserId = portalUser.getUserId();
		long groupId = esfUserServiceContext.getScopeGroupId();

		validate(portalUserId);

		long esfUserId = portalUserId;

		if (Validator.isNotNull(esfAddress)) {

			esfAddressLocalService.addESFAddress(
				esfUserServiceContext.getUserId(), esfAddress.getLongitude(),
				esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
				esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
				esfAddress.getLatitude(), esfAddress.getType(),
				esfAddress.getListTypeId(), ESFUser.class.getName(), esfUserId,
				esfAddress.getStreet1(), esfAddress.getStreet2(),
				esfAddress.getStreet3(), esfAddress.getZip(),
				esfAddress.getTypeId(), esfAddress.getMailing(),
				esfAddress.getPrimary_(), esfAddress.getIsNotNational(), esfUserServiceContext);
		}

		boolean first = true;

		for (Phone phone : phones) {

			PhoneLocalServiceUtil.addPhone(
				userId, ESFUser.class.getName(), esfUserId, phone.getNumber(),
				StringPool.BLANK, phone.getTypeId(), first,
				esfUserServiceContext);

			first = false;
		}

		ESFEntityStateLocalServiceUtil.addEntityState(
			esfUserServiceContext.getUserId(), ESFUser.class.getName(),
			esfUserId, esfStateId, esfUserServiceContext);

		esfUser = esfUserPersistence.create(esfUserId);

		esfUser.setUuid(esfUserServiceContext.getUuid());
		esfUser.setExpandoBridgeAttributes(esfUserServiceContext);
		esfUser.setCode(code);

		esfUserPersistence.update(esfUser);

		resourceLocalService.addResources(
			operator.getCompanyId(), groupId, userId, ESFUser.class.getName(),
			esfUserId, false, true, true);

		return esfUser;
	}

	public ESFUser deleteESFUser(
		long esfUserId, List<ESFAddress> esfAddresses,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFUser esfUser = getESFUser(esfUserId);

		try {
			User portalUser = userPersistence.findByPrimaryKey(esfUserId);

			resourceLocalService.deleteResource(
				serviceContext.getCompanyId(), ESFUser.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, esfUserId);

			for (ESFAddress esfAddress : esfAddresses) {

				ESFAddressLocalServiceUtil.deleteESFAddress(
					esfAddress.getEsfAddressId(), serviceContext);

			}
			esfUser = deleteESFUser(esfUser);

			userLocalService.deleteUser(portalUser);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return esfUser;
	}

	public ESFUser updateESFUser(
		long operatorId, long esfUserId, String code, String firstName,
		String middleName, String lastName, String userEmail,
		String fiscalCode, int birthdayDay, int birthdayMonth,
		int birthdayYear, boolean male, boolean disable, String skype,
		String facebook, String twitter, String jobTitle,
		ESFEntityState esfEntityState, List<ESFAddress> esfAddresses,
		List<ESFPhone> phones, String birthcity, ServiceContext serviceContext)
		throws SystemException, PortalException {

		ESFUser esfUser = null;
		User portalUser = userPersistence.findByPrimaryKey(esfUserId);
		User operator = userPersistence.findByPrimaryKey(operatorId);
		try {
			Contact portalUserContact = portalUser.getContact();
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.DAY_OF_MONTH, birthdayDay);
			calendar.set(Calendar.MONTH, birthdayMonth);
			calendar.set(Calendar.YEAR, birthdayYear);
			Date portalUserBirthday = calendar.getTime();
			portalUser.setEmailAddress(userEmail);
			portalUser.setFirstName(firstName);
			portalUser.setLastName(lastName);
			portalUser.setMiddleName(middleName);
			portalUserContact.setMale(male);
			portalUserContact.setSkypeSn(skype);
			portalUserContact.setFacebookSn(facebook);
			portalUserContact.setTwitterSn(twitter);
			portalUserContact.setBirthday(portalUserBirthday);
			portalUserContact.setJobTitle(jobTitle);
			userLocalService.updateUser(portalUser);
			ContactLocalServiceUtil.updateContact(portalUserContact);

			List<ESFAddress> esfAddressesInDb =
				ESFAddressLocalServiceUtil.getESFAddresses(
					portalUser.getCompanyId(), ESFUser.class.getName(),
					esfUserId);

			for (ESFAddress esfAddressInDb : esfAddressesInDb) {

				ESFAddressLocalServiceUtil.deleteESFAddress(
					esfAddressInDb.getEsfAddressId(), serviceContext);

			}

			for (ESFAddress esfAddress : esfAddresses) {

				esfAddressLocalService.addESFAddress(
					serviceContext.getUserId(), esfAddress.getLongitude(),
					esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
					esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
					esfAddress.getLatitude(), esfAddress.getType(),
					esfAddress.getListTypeId(), ESFUser.class.getName(),
					esfUserId, esfAddress.getStreet1(),
					esfAddress.getStreet2(), esfAddress.getStreet3(),
					esfAddress.getZip(), esfAddress.getTypeId(),
					esfAddress.getMailing(), esfAddress.getPrimary_(),esfAddress.getIsNotNational(),
					serviceContext);

			}

			List<Phone> phonesInDb =
				PhoneLocalServiceUtil.getPhones(
					portalUser.getCompanyId(), ESFUser.class.getName(),
					esfUserId);

			for (Phone phoneInDb : phonesInDb) {

				ESFPhoneLocalServiceUtil.deleteESFPhone(
					phoneInDb.getPhoneId(), serviceContext);

			}

			boolean first = true;

			for (ESFPhone phone : phones) {

				ESFPhoneLocalServiceUtil.addESFPhone(
					operatorId, ESFUser.class.getName(), esfUserId,
					phone.getNumber(), StringPool.BLANK, phone.getListTypeId(),
					phone.getTypeId(), first, serviceContext);

				first = false;
			}

			ESFEntityState esfEntityStateFromDB =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
					ESFUser.class.getName(), esfUserId);

			if (esfEntityStateFromDB != null &&
				esfEntityStateFromDB.getEsfStateId() != esfEntityState.getEsfStateId()) {

				ESFEntityStateLocalServiceUtil.updateEntityState(
					serviceContext.getUserId(),
					esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);

				ESFEntityStateLocalServiceUtil.addEntityState(
					serviceContext.getUserId(), ESFUser.class.getName(),
					esfUserId, esfEntityState.getEsfStateId(), serviceContext);
			}

			if (disable) {
				List<ESFUserESFUserRole> esfUserESFUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByESFUserId_ED(esfUserId);

				Date endDate = new Date();

				for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
					ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(
						esfUserId, esfUserESFUserRole.getEsfUserRoleId(),
						esfUserESFUserRole.getEsfOrganizationId(), endDate,
						serviceContext);
				}
			}

			long groupId = serviceContext.getScopeGroupId();

			validate(esfUserId);
			esfUser = getESFUser(esfUserId);

			esfUser.setUuid(serviceContext.getUuid());
			esfUser.setExpandoBridgeAttributes(serviceContext);
			esfUser.setCode(code);
			esfUser.setFiscalCode(fiscalCode);
			esfUser.setBirthcity(birthcity);
			esfUser.setJob(jobTitle);
			

			esfUserPersistence.update(esfUser);

			resourceLocalService.updateResources(
				operator.getCompanyId(), groupId, ESFUser.class.getName(),
				esfUserId, serviceContext.getGroupPermissions(),
				serviceContext.getGroupPermissions());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return esfUser;
	}

	public ESFUser addESFShooter(
		long operatorId, String code, String firstName, String middleName,
		String lastName, String userEmail, String fiscalCode, int birthdayDay,
		int birthdayMonth, int birthdayYear, String birthcity,
		String nationality, boolean male, String skype, String facebook,
		String twitter, long typearmy, boolean isSportsGroups, String job,
		String jobTitle, String issfIdNumber, ESFEntityState esfEntityState,
		ESFCard esfCard, List<ESFAddress> esfAddresses, List<ESFPhone> phones,
		boolean privacy1, boolean privacy2, boolean privacy3,
		Date datePrivacy1, Date datePrivacy2, Date datePrivacy3, boolean validateCF,
		long codeUser, ServiceContext esfUserServiceContext)
		throws PortalException, SystemException {

//		User operator = userPersistence.findByPrimaryKey(operatorId);
		User portalUser = null;
		ESFUser esfUser = null;

		try {

			portalUser =
				userLocalService.addUser(
					esfUserServiceContext.getUserId(),
					esfUserServiceContext.getCompanyId(), true, "", "", true,
					"", userEmail, 0, "", esfUserServiceContext.getLocale(),
					firstName, middleName, lastName, 0, 0, male, birthdayMonth,
					birthdayDay, birthdayYear, jobTitle, new long[0],
					new long[0], new long[0], new long[0], true,
					esfUserServiceContext);

			long portalUserId = portalUser.getUserId();

			Contact portalUserContact = portalUser.getContact();
			portalUserContact.setFacebookSn(facebook);
			portalUserContact.setSkypeSn(skype);
			portalUserContact.setTwitterSn(twitter);
		
			contactLocalService.updateContact(portalUserContact);

			long groupId = esfUserServiceContext.getScopeGroupId();

			validate(portalUserId);

			long esfUserId = portalUserId;

			for (ESFAddress esfAddress : esfAddresses) {

				esfAddressLocalService.addESFAddress(
					esfUserServiceContext.getUserId(),
					esfAddress.getLongitude(), esfAddress.getEsfCountryId(),
					esfAddress.getEsfRegionId(), esfAddress.getEsfProvinceId(),
					esfAddress.getEsfCityId(), esfAddress.getLatitude(),
					esfAddress.getType(), esfAddress.getListTypeId(),
					ESFUser.class.getName(), esfUserId,
					esfAddress.getStreet1(), esfAddress.getStreet2(),
					esfAddress.getStreet3(), esfAddress.getZip(),
					esfAddress.getTypeId(), esfAddress.getMailing(),
					esfAddress.getPrimary_(), esfAddress.getIsNotNational(), esfUserServiceContext);
			}

			boolean first = true;

			for (ESFPhone phone : phones) {

				ESFPhoneLocalServiceUtil.addESFPhone(
					esfUserServiceContext.getUserId(), ESFUser.class.getName(), esfUserId,
					phone.getNumber(), StringPool.BLANK, phone.getListTypeId(),
					phone.getTypeId(), first, esfUserServiceContext);

				first = false;
			}

			if (Validator.isNotNull(esfEntityState)) {
				ESFEntityStateLocalServiceUtil.addEntityState(
					esfUserServiceContext.getUserId(), ESFUser.class.getName(),
					esfUserId, esfEntityState.getEsfStateId(),
					esfUserServiceContext);
			}

			if (Validator.isNotNull(esfCard)) {
				ESFUserLocalServiceUtil.addESFUserToESFShooter(
					esfUserId, esfCard.getEsfCardId());
			}

			esfUser = esfUserPersistence.create(esfUserId);
			esfUser.setUuid(esfUserServiceContext.getUuid());
			esfUser.setExpandoBridgeAttributes(esfUserServiceContext);
			esfUser.setCode(code);
			esfUser.setBirthcity(birthcity);
			esfUser.setNationality(nationality);
			esfUser.setFiscalCode(fiscalCode);
			esfUser.setTypearmy(typearmy);
			esfUser.setIsSportsGroups(isSportsGroups);
			esfUser.setJob(job);
			esfUser.setIssfIdNumber(issfIdNumber);
			esfUser.setPrivacy1(privacy1);
			esfUser.setPrivacy2(privacy2);
			esfUser.setPrivacy3(privacy3);
			esfUser.setDatePrivacy1(datePrivacy1);
			esfUser.setDatePrivacy2(datePrivacy2);
			esfUser.setDatePrivacy3(datePrivacy3);
			esfUser.setValidateCF(validateCF);
			esfUser.setCodeUser(codeUser);
			
			esfUserPersistence.update(esfUser);
			resourceLocalService.addResources(
				esfUserServiceContext.getCompanyId(), groupId, esfUserServiceContext.getUserId(),
				ESFUser.class.getName(), esfUserId, false, true, true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return esfUser;
	}

	public ESFUser updateESFShooter(
		long operatorId, long esfUserId, String code, String firstName,
		String middleName, String lastName, String userEmail,
		String fiscalCode, int birthdayDay, int birthdayMonth,
		int birthdayYear, String birthcity, String nationality, boolean male,
		boolean disable, String skype, String facebook, String twitter,
		long typearmy, boolean isSportsGroups, String job, String jobTitle,
		String issfIdNumber, ESFEntityState esfEntityState, ESFCard esfCard,
		List<ESFAddress> esfAddresses, List<ESFPhone> phones, Date dateOfDeath,
		boolean privacy1, boolean privacy2, boolean privacy3,
		Date datePrivacy1, Date datePrivacy2, Date datePrivacy3, boolean validateCF,
		long codeUser, ServiceContext serviceContext)
		throws SystemException, PortalException {
		
		
		_log.debug("in updateESFShooter validateCF="+validateCF);
		
		ESFUser esfUser = null;
		User portalUser = userPersistence.findByPrimaryKey(esfUserId);
		User operator = userPersistence.findByPrimaryKey(operatorId);
		try {
			Contact portalUserContact = portalUser.getContact();
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.DAY_OF_MONTH, birthdayDay);
			calendar.set(Calendar.MONTH, birthdayMonth);
			calendar.set(Calendar.YEAR, birthdayYear);
			Date portalUserBirthday = calendar.getTime();

			portalUser.setEmailAddress(userEmail);
			portalUser.setFirstName(firstName);
			portalUser.setLastName(lastName);
			portalUser.setMiddleName(middleName);
			portalUserContact.setMale(male);
			portalUserContact.setSkypeSn(skype);
			portalUserContact.setFacebookSn(facebook);
			portalUserContact.setTwitterSn(twitter);
			portalUserContact.setBirthday(portalUserBirthday);
			portalUserContact.setJobTitle(job);

			userLocalService.updateUser(portalUser);
			ContactLocalServiceUtil.updateContact(portalUserContact);
			
			List<ESFAddress> esfAddressesInDb =
				ESFAddressLocalServiceUtil.getESFAddresses(
					portalUser.getCompanyId(), ESFUser.class.getName(),
					esfUserId);
			
			if(esfAddressesInDb.size()>0 ){
				
				for (ESFAddress esfAddressInDb : esfAddressesInDb) {
					if(Validator.isNotNull(esfAddressInDb)){
						ESFAddressLocalServiceUtil.deleteESFAddress(
								esfAddressInDb.getEsfAddressId(), serviceContext);
					}	
				}
			}
			if(esfAddresses.size()>0){
				for (ESFAddress esfAddress : esfAddresses) {
					if(Validator.isNotNull(esfAddress)){
						esfAddressLocalService.addESFAddress(
							serviceContext.getUserId(), esfAddress.getLongitude(),
							esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
							esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
							esfAddress.getLatitude(), esfAddress.getType(),
							esfAddress.getListTypeId(), ESFUser.class.getName(),
							esfUserId, esfAddress.getStreet1(),
							esfAddress.getStreet2(), esfAddress.getStreet3(),
							esfAddress.getZip(), esfAddress.getTypeId(),
							esfAddress.getMailing(), esfAddress.getPrimary_(),esfAddress.getIsNotNational(),
							serviceContext);
					}
				}
			}
			List<Phone> phonesInDb =
				PhoneLocalServiceUtil.getPhones(
					portalUser.getCompanyId(), ESFUser.class.getName(),
					esfUserId);

			for (Phone phoneInDb : phonesInDb) {

				ESFPhoneLocalServiceUtil.deleteESFPhone(
					phoneInDb.getPhoneId(), serviceContext);

			}

			boolean first = true;

			for (ESFPhone phone : phones) {

				ESFPhoneLocalServiceUtil.addESFPhone(
					operatorId, ESFUser.class.getName(), esfUserId,
					phone.getNumber(), StringPool.BLANK, phone.getListTypeId(),
					phone.getTypeId(), first, serviceContext);

				first = false;
			}

			ESFEntityState esfEntityStateFromDB =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
					ESFUser.class.getName(), esfUserId);

			if (esfEntityStateFromDB != null &&
				esfEntityStateFromDB.getEsfStateId() != esfEntityState.getEsfStateId()) {
				
				
				/*if(esfEntityState.getEsfStateId()==2){
					
					ESFEntityStateLocalServiceUtil.updateEntityState(
						serviceContext.getUserId(),
						esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);
				}
				else{*/
					ESFEntityStateLocalServiceUtil.updateEntityState(
						serviceContext.getUserId(),
						esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);
	
					ESFEntityStateLocalServiceUtil.addEntityState(
						serviceContext.getUserId(), ESFUser.class.getName(),
						esfUserId, esfEntityState.getEsfStateId(), serviceContext);
				//}
				
				
			}

			if (disable) {
				List<ESFUserESFUserRole> esfUserESFUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByESFUserId_ED(esfUserId);

				Date endDate = new Date();

				for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
					ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(
						esfUserId, esfUserESFUserRole.getEsfUserRoleId(),
						esfUserESFUserRole.getEsfOrganizationId(), endDate,
						serviceContext);
				}
			}

			List<ESFCard> esfCards =
				ESFCardLocalServiceUtil.findAllESFCardsByU_S(
					esfUserId, ESFKeys.ESFStateType.ENABLE);

			/*ESFUserLocalServiceUtil.updateESFUserToESFShooter(
				operatorId, esfUserId, esfCard, esfCards, serviceContext);*/

			long groupId = serviceContext.getScopeGroupId();

			validate(esfUserId);

			esfUser = getESFUser(esfUserId);

			esfUser.setUuid(serviceContext.getUuid());
			esfUser.setExpandoBridgeAttributes(serviceContext);
			esfUser.setCode(code);
			esfUser.setBirthcity(birthcity);
			esfUser.setNationality(nationality);
			esfUser.setFiscalCode(fiscalCode);
			esfUser.setTypearmy(typearmy);
			esfUser.setJob(jobTitle);
			esfUser.setIsSportsGroups(isSportsGroups);
			esfUser.setIssfIdNumber(issfIdNumber);
			esfUser.setDateOfDeath(dateOfDeath);
			esfUser.setPrivacy1(privacy1);
			esfUser.setPrivacy2(privacy2);
			esfUser.setPrivacy3(privacy3);
			esfUser.setDatePrivacy1(datePrivacy1);
			esfUser.setDatePrivacy2(datePrivacy2);
			esfUser.setDatePrivacy3(datePrivacy3);
			esfUser.setValidateCF(validateCF);
			esfUser.setCodeUser(codeUser);
			
			UserLocalServiceUtil.updateJobTitle(esfUserId, job);
			
			esfUserPersistence.update(esfUser);

			resourceLocalService.updateResources(
				operator.getCompanyId(), groupId, ESFUser.class.getName(),
				esfUserId, serviceContext.getGroupPermissions(),
				serviceContext.getGroupPermissions());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return esfUser;
	}

	public void updateESFUserToESFShooter(
		long userId, long esfUserId, ESFCard esfCard, List<ESFCard> esfCards,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		ESFEntityState esfEntityStateFromDB =
			ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
				ESFCard.class.getName(), esfCard.getEsfCardId());

		ESFCard cardFromDB = esfCards.get(0);

		if (cardFromDB != null &&
			cardFromDB.getEsfCardId() != esfCard.getEsfCardId()) {

			ESFCardLocalServiceUtil.updateESFCard(
				userId, cardFromDB.getEsfCardId(), cardFromDB.getCode(),
				cardFromDB.getCodeAlfa(), cardFromDB.getCodeNum(),
				cardFromDB.getEsfUserId(), cardFromDB.getEsfOrganizationId(),
				esfEntityStateFromDB, true, serviceContext);

			ESFCardLocalServiceUtil.updateESFCard(
				userId, esfCard.getEsfCardId(), esfCard.getCode(),
				cardFromDB.getCodeAlfa(), cardFromDB.getCodeNum(), esfUserId,
				esfCard.getEsfOrganizationId(), esfEntityStateFromDB, false,
				serviceContext);
		}

	}

	public void addESFUserToESFShooter(long esfUserId, long esfCardId)
		throws NoSuchCardException, SystemException {

		ESFCard esfCard = esfCardPersistence.findByPrimaryKey(esfCardId);
		esfCard.setEsfUserId(esfUserId);
		esfCardPersistence.update(esfCard);
	}

	protected void validate(long portalUserId)
		throws PortalException, SystemException {

		if (Validator.isNull(portalUserId) || portalUserId <= 0) {
			try {
				userPersistence.findByPrimaryKey(portalUserId);
			}
			catch (NoSuchUserException ex) {
				throw new ESFUserPortalUserException();
			}
		}
	}

	public int countByESFUserRole(long esfUserRoleId)
		throws SystemException, PortalException {

		return esfUserESFUserRolePersistence.findByESFUserRoleId(esfUserRoleId).size();
	}

	public List<ESFUserESFUserRole> getESFUserRoles(
		long esfUserId, boolean active)
		throws SystemException, PortalException {

		List<ESFUserESFUserRole> esfUserEsfUserRoles =
			esfUserESFUserRolePersistence.findByESFUserId(esfUserId);

		List<ESFUserESFUserRole> esfUserRoles =
			new ArrayList<ESFUserESFUserRole>();

		for (ESFUserESFUserRole esfUserEsfUserRole : esfUserEsfUserRoles) {

			if (active) {

				if (esfUserEsfUserRole.getEndDate() == null ||
					new Date().getTime() < esfUserEsfUserRole.getEndDate().getTime()) {

					esfUserRoles.add(esfUserEsfUserRole);
				}
			}
			else {
				esfUserRoles.add(esfUserEsfUserRole);
			}
		}

		return esfUserRoles;
	}

	public List<ESFUserESFUserRole> getActiveESFUserRoles(long esfUserId)
		throws SystemException, PortalException {

		return getESFUserRoles(esfUserId, true);
	}

	public List<ESFUser> findAllUser()
		throws SystemException {

		return esfUserPersistence.findAll();
	}

	public User checkEmailAddress(
		String emailAddress, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (Validator.isNotNull(emailAddress) &&
			!Validator.isBlank(emailAddress)) {
			return UserLocalServiceUtil.fetchUserByEmailAddress(
				serviceContext.getCompanyId(), emailAddress);
		}

		return null;
	}

	public User checkScreenName(String screenName, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (Validator.isNotNull(screenName) && !Validator.isBlank(screenName)) {

			return UserLocalServiceUtil.fetchUserByScreenName(
				serviceContext.getCompanyId(), screenName);

		}

		return null;
	}

	public List<ESFUser> findAllUserByAgeOnlyPeople()
			throws SystemException, PortalException {
	
			List<ESFUser> users = new ArrayList<ESFUser>();
			List<ESFUser> usersResult = new ArrayList<ESFUser>();
			List <ESFOrganization> organizations= new ArrayList<ESFOrganization>();
			organizations= esfOrganizationPersistence.findAll();
			List<Long> organizationId =  new ArrayList<Long>();
			Calendar cal = Calendar.getInstance();
			int year;
			for (ESFOrganization eo : organizations){
				organizationId.add(eo.getEsfOrganizationId());
			}
			users =  esfUserPersistence.findAll();
			for (ESFUser eu: users){
				
				cal.setTime(eu.getBirthday());
				year = cal.get(Calendar.YEAR);
				if(year<=2002 && year>=1995){
					if(!organizationId.contains(eu.getEsfUserId())){
					  
						ESFCard card = ESFCardLocalServiceUtil.getEsfCardByEsfUserId(eu.getEsfUserId());
						ESFEntityState ees =
								esfEntityStateLocalService.findESFEntityStateByC_PK_S("it.ethica.esf.model.ESFCard", card.getEsfCardId(), 1);
								
						if (Validator.isNotNull(ees)){
							usersResult.add(eu);
					}
					  
				}
			}}
			return usersResult;
		  }
	
	public List<ESFUser> findAllUserByRolenoNull(long roleId, long organizationId)
			throws SystemException, PortalException {
		
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		List<ESFUserESFUserRole> userRole =  ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(roleId, organizationId);
		
		for(ESFUserESFUserRole u : userRole){
			user.add(ESFUserLocalServiceUtil.fetchESFUser(u.getEsfUserId()));
		}
		
		
		return user;
	}
	
	public List<ESFUser> findShooterRoleAssignedName(String name, String lastName,
			
			long roleId, long organizationId, int start, int end)
			throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findShooterRoleAssignedName(
				name, lastName, organizationId, roleId, start, end);
				
		
		return user;
	}
	
	public int countShooterRoleAssignedName(String name, String lastName,
			long roleId, long organizationId)
			throws SystemException, PortalException {
		int tot = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		user = ESFUserFinderUtil.countShooterRoleAssignedName(
				name, lastName, organizationId, roleId);
		
		tot = user.size();
		return tot ;
	}
	
	public List<ESFUser> findStaffMatch(String name, String lastName, String fiscalcode,
			
			long matchId, long fitavId, int start, int end)
			throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findStaffMatch(name, lastName, fiscalcode, matchId,fitavId, start, end);
				
		
		return user;
	}
	
	public int countStaffMatch(String name, String lastName, String fiscalcode,
			long matchId, long fitavId)
			throws SystemException, PortalException {
		int tot = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		user = ESFUserFinderUtil.countStaffMatch(
				name, lastName, fiscalcode, matchId,fitavId);
		
		tot = user.size();
		return tot ;
	}
	
	//ricerca i tiratori in base a nome tessera e non ancora assegnata alla specialit olimpica
	public List<ESFUser> findShooterNotAssociated(String name, String lastName, String cardCode,
		long sportTypeId, int start, int end)
			throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findNotNationalShooterBySPT(name, lastName,cardCode, sportTypeId, start, end);

		return user;
	}
	
	public int countNotNationalShooterBySPT(String name, String lastName, String cardCode,long sportTypeId)
		throws SystemException, PortalException {
		int tot = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		tot = (int) ESFUserFinderUtil.countNotNationalShooterBySPT( name, lastName, cardCode, sportTypeId);
		return tot ;
	}
	//ricerca i tiratori non associati per l aspecialità olimpica
	
	public List<ESFUser> findALLShooterNotAssociated(String name, String lastName, String cardCode,
		long sportTypeId, int start, int end)
			throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findALLNotNationalShooterBySPT(name, lastName,cardCode, sportTypeId, start, end);

		return user;
	}
	
	public int countALLNotNationalShooterBySPT(String name, String lastName, String cardCode,long sportTypeId)
		throws SystemException, PortalException {
		int tot = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		tot = (int) ESFUserFinderUtil.countALLNotNationalShooterBySPT( name, lastName, cardCode, sportTypeId);
		return tot ;
	}
	
	public List<ESFUser> findStaffNormalMatch(String name, String lastName, String fiscalcode,
			
			long matchId, int start, int end)
			throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findStaffNormalMatch(
				name, lastName, fiscalcode, matchId, start, end);
				
		
		return user;
	}
	
	public int countStaffNormalMatch(String name, String lastName, String fiscalcode,
			long matchId)
			throws SystemException, PortalException {
		int tot = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		user = ESFUserFinderUtil.countStaffNormalMatch(
				name, lastName, fiscalcode, matchId);
		
		tot = user.size();
		return tot ;
	}
	
	public int countRenwalUser(String thisYear, String lastYear, long orgId)
			throws SystemException, PortalException {
		int tot = 0;
		tot = ESFUserFinderUtil.countRenwalUser(thisYear, lastYear ,orgId);

		return tot ;
	}
	
	public int countNewUser(String endDate, String startDate, long orgId)
			throws SystemException, PortalException {
		int tot = 0;
		tot = ESFUserFinderUtil.countNewUser(endDate, startDate, orgId);

		return tot ;
	}
	
	@Override
	public List<ESFUser> findByKeyword(String keyword, String columnName)
		throws SystemException, PortalException {

		Class<?> clazz = getClass();
		DynamicQuery queryUser =
			DynamicQueryFactoryUtil.forClass(
				User.class, PortalClassLoaderUtil.getClassLoader());
		queryUser.add(
			PropertyFactoryUtil.forName(columnName).like(
				StringPool.PERCENT + keyword + StringPool.PERCENT)).setProjection(
			PropertyFactoryUtil.forName("userId"));
		List<Long> usersId = UserLocalServiceUtil.dynamicQuery(queryUser);
		if (Validator.isNull(usersId) || usersId.size() == 0) {
			return new ArrayList<ESFUser>();
		}
		DynamicQuery queryESFUser =
			DynamicQueryFactoryUtil.forClass(
				ESFUser.class, clazz.getClassLoader());
		queryESFUser.add(PropertyFactoryUtil.forName("esfUserId").in(usersId));
		return ESFUserLocalServiceUtil.dynamicQuery(queryESFUser);
	}
	
	public List<ESFUser> findShooterByAss(String firstName, String lastName,
		String cardCode, long orgId, int start, int end)
		throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		user = ESFUserFinderUtil.findShooterByAss(firstName, lastName, orgId, cardCode);
		if(end <= user.size() ){
			user = user.subList(start, end);
		}else{
			user = user.subList(start, user.size());
		}
		return user;
	}
	
	public int countShooterByAss(String firstName, String lastName,
		
		String cardCode, long orgId)
		throws SystemException, PortalException {
		
		int tot = 0;
		
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findShooterByAss(firstName, lastName, orgId, cardCode);
		
		tot = user.size();
		
		return tot;
	}
	
	public List<ESFUser> findShooterByAssAndNoAss(String firstName, String lastName,
		String cardCode, long orgId, int start, int end)
		throws SystemException, PortalException {
		
		List<ESFUser> user = new ArrayList<ESFUser>();
		List<ESFUser> userAss = new ArrayList<ESFUser>();
		List<ESFUser> userNotAss = new ArrayList<ESFUser>();
		
		userAss = ESFUserFinderUtil.findShooterByAss(firstName, lastName, orgId, cardCode);
		userNotAss = ESFUserFinderUtil.findShooterNotAssociated(firstName,lastName,cardCode);
		
		user.addAll(userAss);
		user.addAll(userNotAss);
		
		if(end <= user.size() ){
			user = user.subList(start, end);
		}else{
			user = user.subList(start, user.size());
		}
		return user;
	}
	
	
	public int countShooterByAssAndNoAss(String firstName, String lastName,
		String cardCode, long orgId)
		throws SystemException, PortalException {
		int tot = 0;
		
		List<ESFUser> user = new ArrayList<ESFUser>();
		List<ESFUser> userAss = new ArrayList<ESFUser>();
		List<ESFUser> userNotAss = new ArrayList<ESFUser>();
		
		userAss = ESFUserFinderUtil.findShooterByAss(firstName, lastName, orgId, cardCode);
		userNotAss = ESFUserFinderUtil.findShooterNotAssociated(firstName,lastName,cardCode);
		
		user.addAll(userAss);
		user.addAll(userNotAss);
		
		tot = user.size();
		
		return tot;
	}
	
	public List<ESFUser> findDirectorByMatch(String firstName, String lastName,
			long matchId, long shootingDirectorQualificationId,int start, int end)
			throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findDirectorByMatch(firstName,lastName,matchId,shootingDirectorQualificationId,start,end);
		return user;
	}
	
	public int countDirectorByMatch(String firstName, String lastName,long matchId,long shootingDirectorQualificationId)
		throws SystemException, PortalException {
		
		List<ESFUser> user = new ArrayList<ESFUser>();
		int tot = 0;
	
		tot = ESFUserFinderUtil.countDirectorByMatch(firstName,lastName,matchId,shootingDirectorQualificationId);
		return tot;
	}
	
	public List<ESFUser> findNewYouthShooter(int year)
					throws SystemException, PortalException {
		
		List<ESFUser> newYotuh = new ArrayList<ESFUser>();
		
		newYotuh = ESFUserFinderUtil.findNewYouthShooter(year);

		return newYotuh;
	}
	
	/*
	 * ricerca giovani percategoria
	 */
	
	public List<ESFUser> findYouthByCategory(long categoryId, int  year,int start, int end)
		throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findYouthByCategory(categoryId,year,start,end);
		return user;
	}
	
	public int findYouthByCategoryTotal(long categoryId, int  year)
		throws SystemException, PortalException {
		int total = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findYouthByCategoryTotal(categoryId,year);
		total = user.size();
		return total;
	}
	
	/*
	 * ricerca dei tiratori non membri del consiglio direttivo
	 */
	
	public List<ESFUser> findNotBDOMemberByAssociatioId(String lastName, String firstName,long associationId, int start, int end)
		throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findNotBDOMemberByAssociatioId(lastName, firstName, associationId,start,end);
		return user;
	}
				
	public int countNotBDOMemberByAssociatioId(String lastName, String firstName, long associationId)
		throws SystemException, PortalException {
		int total = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.countNotBDOMemberByAssociatioId(lastName, firstName, associationId);
		total = user.size();
		return total;
	}
	
	/*
	 * 
	 * ricerca titori associati per nome, cognome, tessera e id società
	 */
	
	public List<ESFUser> findAssociatedShooterOrganization(String firstName, String lastName, String card ,long associationId, int start, int end)
		throws SystemException, PortalException {
		List<ESFUser> user = new ArrayList<ESFUser>();
		
		user = ESFUserFinderUtil.findAssociatedShooterOrganization(lastName, firstName, card  ,associationId,start,end);
		return user;
	}
				
	public int countAssociatedShooterOrganization(String firstName, String lastName, String card, long associationId)
		throws SystemException, PortalException {
		int total = 0;
		List<ESFUser> user = new ArrayList<ESFUser>();
		user = ESFUserFinderUtil.countAssociatedShooterOrganization(lastName, firstName, card ,associationId);
		total = user.size();		
		return total;
	}
	public List<ESFUser> findByESFFederalRole(long esfFederalRoleId) throws PortalException, SystemException{
		List<ESFUser> list = new ArrayList<ESFUser>();
		List<ESFUserESFFederalRole> userAssociations =  ESFUserESFFederalRoleLocalServiceUtil.findByEsfFederalRoleId(esfFederalRoleId);
		for(ESFUserESFFederalRole roleAssociation : userAssociations){
			list.add(ESFUserLocalServiceUtil.getESFUser(roleAssociation.getEsfUserId()));
		}
		return list;
	}

}