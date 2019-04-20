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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.base.ESFPartecipantLocalServiceBaseImpl;

/**
 * The implementation of the e s f partecipant local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFPartecipantLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFPartecipantLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFPartecipantLocalServiceUtil
 */
public class ESFPartecipantLocalServiceImpl
	extends ESFPartecipantLocalServiceBaseImpl {

public ESFPartecipant getESFPartecipantByESFMatchId_ESFUserId(long esfMatchId, long esfUserId){
	
	List<ESFPartecipant> esfPartecipants = new ArrayList<ESFPartecipant>();

	try {
		DynamicQuery partecipantQuery =
			DynamicQueryFactoryUtil.forClass(
				ESFPartecipant.class, "partecipantQuery",
				PortletClassLoaderUtil.getClassLoader());

		partecipantQuery.add(PropertyFactoryUtil.forName(
			"partecipantQuery.esfUserId").eq(esfUserId));

		partecipantQuery.add(PropertyFactoryUtil.forName(
			"partecipantQuery.esfMatchId").eq(esfMatchId));

		esfPartecipants =
			ESFPartecipantLocalServiceUtil.dynamicQuery(partecipantQuery);

	}
	catch (Exception e) {
		e.getMessage();
	}
	if(!esfPartecipants.isEmpty()){
		return esfPartecipants.get(0);
	}
	else{
		return null;
	}
}
public List<ESFPartecipant> getESFPartecipantsByESFMatchId(long esfMatchId){
	
	List<ESFPartecipant> esfPartecipants = new ArrayList<ESFPartecipant>();

	try {
		DynamicQuery partecipantQuery =
			DynamicQueryFactoryUtil.forClass(
				ESFPartecipant.class, "partecipantQuery",
				PortletClassLoaderUtil.getClassLoader());


		partecipantQuery.add(PropertyFactoryUtil.forName(
			"partecipantQuery.esfMatchId").eq(esfMatchId));

		esfPartecipants =
			ESFPartecipantLocalServiceUtil.dynamicQuery(partecipantQuery);

	}
	catch (Exception e) {
		e.getMessage();
	}

	return esfPartecipants;
}
public List<ESFPartecipant> getESFPartecipantsByESFMatchId(long esfMatchId,int start,int end){
	
	List<ESFPartecipant> esfPartecipants = new ArrayList<ESFPartecipant>();

	try {
		DynamicQuery partecipantQuery =
			DynamicQueryFactoryUtil.forClass(
				ESFPartecipant.class, "partecipantQuery",
				PortletClassLoaderUtil.getClassLoader());


		partecipantQuery.add(PropertyFactoryUtil.forName(
			"partecipantQuery.esfMatchId").eq(esfMatchId));

		esfPartecipants =
			ESFPartecipantLocalServiceUtil.dynamicQuery(partecipantQuery,start , end);

	}
	catch (Exception e) {
		e.getMessage();
	}

	return esfPartecipants;
}
	public List<ESFPartecipant> findPartecipants(
		long idMatch, Object[] userIds, long esfPartecipantTypeId)
		throws SystemException {

		List<ESFPartecipant> esfPartecipants = new ArrayList<ESFPartecipant>();

		try {
			DynamicQuery partecipantQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFPartecipant.class, "partecipantQuery",
					PortletClassLoaderUtil.getClassLoader());

			partecipantQuery.add(PropertyFactoryUtil.forName(
				"partecipantQuery.esfUserId").in(userIds));

			partecipantQuery.add(PropertyFactoryUtil.forName(
				"partecipantQuery.esfMatchId").eq(idMatch));

			partecipantQuery.add(PropertyFactoryUtil.forName(
				"partecipantQuery.esfPartecipantTypeId").eq(
				esfPartecipantTypeId));

			esfPartecipants =
				ESFPartecipantLocalServiceUtil.dynamicQuery(partecipantQuery);

		}
		catch (Exception e) {
		}

		return esfPartecipants;

	}

	public ESFPartecipant findbyUserId(long userId) 
			throws Exception{
		ESFPartecipant partecipant=null;
		partecipant=esfPartecipantPersistence.findByUserId(userId);
		return partecipant;
		}
	
	public List<ESFPartecipant> findPartecipantsByMatch(long esfMatchId)
		throws SystemException {

		List<ESFPartecipant> esfPartecipants = new ArrayList<ESFPartecipant>();

		esfPartecipants = esfPartecipantPersistence.findByMatch(esfMatchId);

		return esfPartecipants;

	}

	public List<ESFPartecipant> findPartecipantsByTournament(
		long esfTournamentId)
		throws SystemException {

		List<ESFMatch> esfMatchs =null;
		
		List<ESFPartecipant> esfPartecipants = new ArrayList<ESFPartecipant>();

		for (ESFMatch esfMatch : esfMatchs) {

			List<ESFPartecipant> esfPartecipantsTmp =
				esfPartecipantPersistence.findByMatch(esfMatch.getEsfMatchId());

			esfPartecipants.addAll(esfPartecipantsTmp);
		}
		
		return esfPartecipants;

	}

	public ESFPartecipant getPartecipantByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws SystemException {

		return esfPartecipantPersistence.fetchByU_M_T(
			esfUserId, esfMatchId, esfPartecipantTypeId);

	}

	public ESFPartecipant addESFPartecipant(
		long userId, long esfUserId, long esfMatchId, long esfTeamId, long ct,
		long esfPartecipantTypeId, long result, ServiceContext serviceContext)
		throws SystemException, PortalException {

		User operator = userPersistence.findByPrimaryKey(userId);

		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long esfPartecipantId = counterLocalService.increment();

		ESFPartecipant esfPartecipant =
			esfPartecipantPersistence.create(esfPartecipantId);

		esfPartecipant.setUserId(userId);
		esfPartecipant.setGroupId(groupId);
		esfPartecipant.setCompanyId(operator.getCompanyId());
		esfPartecipant.setUserName(operator.getFullName());
		esfPartecipant.setCreateDate(serviceContext.getCreateDate(now));
		esfPartecipant.setModifiedDate(serviceContext.getModifiedDate(now));
		esfPartecipant.setExpandoBridgeAttributes(serviceContext);
		esfPartecipant.setEsfUserId(esfUserId);
		esfPartecipant.setEsfMatchId(esfMatchId);
		esfPartecipant.setEsfTeamId(esfTeamId);
		esfPartecipant.setCt(ct);
		esfPartecipant.setEsfPartecipantTypeId(esfPartecipantTypeId);
		esfPartecipant.setResult(result);

		esfPartecipant = esfPartecipantPersistence.update(esfPartecipant);

		return esfPartecipant;
	}

	public ESFPartecipant deleteESFPartecipant(
		long esfPartecipantId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFPartecipant esfPartecipant = getESFPartecipant(esfPartecipantId);

		esfPartecipant = deleteESFPartecipant(esfPartecipant);

		return esfPartecipant;
	}

	public ESFPartecipant updateESFPartecipant(
		long userId, long esfPartecipantId, long esfUserId, long esfMatchId,
		long esfTeamId, long ct, long esfPartecipantTypeId, long result,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User operator = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		ESFPartecipant esfPartecipant = getESFPartecipant(esfPartecipantId);

		esfPartecipant.setUserName(operator.getFullName());
		esfPartecipant.setModifiedDate(serviceContext.getModifiedDate(now));
		esfPartecipant.setExpandoBridgeAttributes(serviceContext);
		esfPartecipant.setEsfUserId(esfUserId);
		esfPartecipant.setEsfMatchId(esfMatchId);
		esfPartecipant.setEsfTeamId(esfTeamId);
		esfPartecipant.setCt(ct);
		esfPartecipant.setEsfPartecipantTypeId(esfPartecipantTypeId);
		esfPartecipant.setResult(result);

		esfPartecipantPersistence.update(esfPartecipant);

		return esfPartecipant;
	}

}
