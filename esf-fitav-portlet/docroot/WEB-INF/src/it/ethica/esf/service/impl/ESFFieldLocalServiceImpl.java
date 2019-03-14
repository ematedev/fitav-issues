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

import it.ethica.esf.ESFFieldNameException;
import it.ethica.esf.NoSuchFieldESFSportTypeException;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.ESFLentField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFLentFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.base.ESFFieldLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePK;
import it.ethica.esf.util.ESFKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the e s f field local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFFieldLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFieldLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFieldLocalServiceUtil
 */
public class ESFFieldLocalServiceImpl extends ESFFieldLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFFieldLocalServiceUtil} to access the e s
	 * f field local service.
	 */
	public List<ESFField> getESFFields(long groupId)
		throws SystemException {
	
		return esfFieldPersistence.findByGroupId(groupId);
	}
	
	public List<ESFField> getESFFields(long groupId, int start, int end)
		throws SystemException {
	
		return esfFieldPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<ESFField> getEsfFieldByState(int state) {
	
		List<ESFField> esfFields = new ArrayList<ESFField>();
		
		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFField.class.getName(), state);
			
			if(entityStates == null || entityStates.size()<=0)
				return esfFields;
			
			long[] classPKs = new long[entityStates.size()];
			
			int i = 0;
			
			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}
			
			DynamicQuery fieldQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFField.class, "fieldQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			
			fieldQuery.add(PropertyFactoryUtil.forName("fieldQuery.esfFieldId").in(
				classPKs));
			
			esfFields =
					ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfFields;
	}
	
	public List<ESFField> getEsfFieldByState(int state, int start, int end) {
	
		List<ESFField> esfFields = new ArrayList<ESFField>();
		
		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFField.class.getName(), state);
			
			if(entityStates == null || entityStates.size()<=0)
				return esfFields;
		
			long[] classPKs = new long[entityStates.size()];
			
			int i = 0;
			
			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}
			
			DynamicQuery fieldQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFField.class, "fieldQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			fieldQuery.add(PropertyFactoryUtil.forName("fieldQuery.esfFieldId").in(
				classPKs));
			
			esfFields =
				ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery, start, end);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return esfFields;
	}
	
	public int countByGroupId(long groupId)
		throws SystemException {
	
		return esfFieldPersistence.countByGroupId(groupId);
	}
	
	public int countByESFOrganization(long esfOrganizationId)
		throws SystemException, PortalException {
	
		return esfFieldPersistence.countByOwnerOrganizationId(esfOrganizationId);
	}
	
	public List<ESFField> findByRealOwner(
		long esfStateId, long esfOrganizationId)
		throws SystemException {
	
		List<ESFField> esfFields = new ArrayList<ESFField>();
		
		List<ESFLentField> esfLentFields =
			ESFLentFieldLocalServiceUtil.findESFLentFieldsbyF_S(
				esfStateId, esfOrganizationId);
		
		long[] classPKs = new long[esfLentFields.size()];
		
		int i = 0;
		
		for (ESFLentField esfLentField : esfLentFields) {
			classPKs[i] = esfLentField.getEsfFieldId();
			i++;
		}
		
		try {
			
			DynamicQuery fieldQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFField.class, "fieldQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			fieldQuery.add(PropertyFactoryUtil.forName("fieldQuery.esfFieldId").in(
				classPKs));
			
			esfFields = ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery);
			
		}
		catch (Exception e) {
			
		}
		
		return esfFields;
	}
	
	public List<ESFField> findByRealOwner(
		long esfStateId, long esfOrganizationId, int start, int end)
		throws SystemException {
	
		List<ESFField> esfFields = new ArrayList<ESFField>();
		
		List<ESFLentField> esfLentFields =
			ESFLentFieldLocalServiceUtil.findESFLentFieldsbyF_S(
				esfStateId, esfOrganizationId);
		
		long[] classPKs = new long[esfLentFields.size()];
		
		int i = 0;
		
		for (ESFLentField esfLentField : esfLentFields) {
			classPKs[i] = esfLentField.getEsfFieldId();
			i++;
		}
		
		try {
			
			DynamicQuery fieldQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFField.class, "fieldQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			fieldQuery.add(PropertyFactoryUtil.forName("fieldQuery.esfFieldId").in(
				classPKs));
			
			esfFields =
				ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery, start, end);
			
		}
		catch (Exception e) {
			
		}
		
		return esfFields;
	}
	//
	public List<ESFField> findByESFOrganization(
		long esfOrganizationId, int state)
		throws SystemException, PortalException {
	
		List<ESFField> esfFieldsByState =
				ESFFieldLocalServiceUtil.getEsfFieldByState(state);
		
		List<ESFField> esfFields = new ArrayList<ESFField>();
		
		try {
			long[] classPKs = new long[esfFieldsByState.size()];
			
			int i = 0;
			
			for (ESFField esfFieldByState : esfFieldsByState) {
				classPKs[i] = esfFieldByState.getEsfFieldId();
				i++;
			}
			
			DynamicQuery fieldQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFField.class, "fieldQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			fieldQuery.add(PropertyFactoryUtil.forName(
				"fieldQuery.ownerOrganizationId").eq(esfOrganizationId));
			fieldQuery.add(PropertyFactoryUtil.forName("fieldQuery.esfFieldId").in(
				classPKs));
			
			esfFields = ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery);
		}
		catch (Exception e) {
			
		}
		return esfFields;
	}
	

	public List<ESFField> findByESFOrganization(
			long esfOrganizationId)
			throws SystemException, PortalException {

			List<ESFField> esfFields = new ArrayList<ESFField>();
				
				DynamicQuery fieldQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFField.class, "fieldQuery",
						PortletClassLoaderUtil.getClassLoader());
				
				fieldQuery.add(PropertyFactoryUtil.forName(
					"fieldQuery.ownerOrganizationId").eq(esfOrganizationId));

				esfFields = ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery);
			return esfFields;
		}
	
	public List<ESFField> findByESFOrganization(
			long esfOrganizationId, int start, int end)
			throws SystemException, PortalException {

			List<ESFField> esfFields = new ArrayList<ESFField>();
				
				DynamicQuery fieldQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFField.class, "fieldQuery",
						PortletClassLoaderUtil.getClassLoader());
				
				fieldQuery.add(PropertyFactoryUtil.forName(
					"fieldQuery.ownerOrganizationId").eq(esfOrganizationId));

				esfFields = ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery, start, end);
			return esfFields;
		}
	
	public List<ESFField> findByESFOrganization(
		long esfOrganizationId, int state, int start, int end)
		throws SystemException, PortalException {
	
		List<ESFField> esfFieldsByState =
			ESFFieldLocalServiceUtil.getEsfFieldByState(state);
		
		List<ESFField> esfFields = new ArrayList<ESFField>();
		try {
			long[] classPKs = new long[esfFieldsByState.size()];
			
			int i = 0;
			
			for (ESFField esfFieldByState : esfFieldsByState) {
				classPKs[i] = esfFieldByState.getEsfFieldId();
				i++;
			}
			
			DynamicQuery fieldQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFField.class, "fieldQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			fieldQuery.add(PropertyFactoryUtil.forName(
				"fieldQuery.ownerOrganizationId").eq(esfOrganizationId));
			fieldQuery.add(PropertyFactoryUtil.forName("fieldQuery.esfFieldId").in(
				classPKs));
			
			esfFields =
				ESFFieldLocalServiceUtil.dynamicQuery(fieldQuery, start, end);
		}
		catch (Exception e) {
			
		}
		return esfFields;
	}
	
	public List<ESFFieldESFSportType> findESFFieldESFSportTypeByField(
		long esfFieldId)
		throws SystemException {
	
		return esfFieldESFSportTypePersistence.findByesfFieldId(esfFieldId);
	}
	
	public List<ESFField> findByESFSportTypeId(long esfSportTypeId)
		throws SystemException, PortalException {
	
		List<ESFField> esfFields = new ArrayList<ESFField>();
		
		List<ESFFieldESFSportType> esfFieldEsfSportTypes =
			esfFieldESFSportTypePersistence.findByesfSportTypeId(esfSportTypeId);
		
		for (ESFFieldESFSportType esfFieldEsfSportType : esfFieldEsfSportTypes) {
			
			esfFields.add(esfFieldLocalService.getESFField(esfFieldEsfSportType.getEsfFieldId()));
		}
		
		return esfFields;
	}
	
	public ESFField addESFField(
		long userId, String name, long ownerOrganizationId,
		long esfAddressIdId, long esfStateId, long esfSportTypeIds[],
		String note, long billboard, boolean billboardStations,
		boolean backgroundRampart, boolean backgroundNet,
		boolean backgroundLeadRecovery, boolean disabledaccess,
		List<ESFFieldESFElectronic> esfFieldESFElectronics,
		ServiceContext serviceContext)
		throws SystemException, PortalException {
	
		long groupId = serviceContext.getScopeGroupId();
		
		User user = UserLocalServiceUtil.fetchUserById(userId);
		
		Date now = new Date();
		
		validate(name);
		
		long esfFieldId = counterLocalService.increment();
		
		ESFField esfField = esfFieldPersistence.create(esfFieldId);
		
		esfField.setUserId(userId);
		
		esfField.setGroupId(groupId);
		esfField.setCompanyId(user.getCompanyId());
		esfField.setUserName(user.getFullName());
		esfField.setCreateDate(serviceContext.getCreateDate(now));
		esfField.setModifiedDate(serviceContext.getModifiedDate(now));
		esfField.setName(name);
		esfField.setOwnerOrganizationId(ownerOrganizationId);
		esfField.setEsfAddressId(esfAddressIdId);
		esfField.setNote(note);
		esfField.setBillboard(billboard);
		esfField.setBillboardStations(billboardStations);
		esfField.setBackgroundRampart(backgroundRampart);
		esfField.setBackgroundNet(backgroundNet);
		esfField.setBackgroundLeadRecovery(backgroundLeadRecovery);
		
		esfField.setDisabledAccess(disabledaccess);
		esfField.setExpandoBridgeAttributes(serviceContext);
		
		ESFFieldLocalServiceUtil.updateESFField(esfField);
		
		for (ESFFieldESFElectronic esfFieldESFElectronic : esfFieldESFElectronics) {
			
			ESFFieldESFElectronicLocalServiceUtil.addESFFieldESFElectronic(
				esfFieldESFElectronic.getBrandId(),
				esfFieldESFElectronic.getElectronicId(),esfFieldId,
				esfFieldESFElectronic.getDescription(),
				serviceContext);
			
		}
		
		ESFEntityStateLocalServiceUtil.addEntityState(
			serviceContext.getUserId(), ESFField.class.getName(), esfFieldId,
			esfStateId, serviceContext);
		
		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFField.class.getName(),
			esfFieldId, false, true, true);
		
	/*	AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfField.getCreateDate(),
				esfField.getModifiedDate(), ESFField.class.getName(),
				esfFieldId, esfField.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfField.getName(), null, null, null,
				null, 0, 0, null, false);*/
		
	/*	assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);*/
		
		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);
		
		indexer.reindex(esfField);
		
		updateESFFieldESFSportType(esfFieldId, esfSportTypeIds, serviceContext);
		
		int numField = 0;
		String categoryAssosiation = "";
		
		numField=ESFFieldLocalServiceUtil.
				findByESFOrganization(ownerOrganizationId,ESFKeys.ESFStateType.ENABLE).size();
			if(numField==1 || numField == 0){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
			}else if(numField==2 || numField ==3){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
			}else if(numField==4 || numField ==5){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
			}else{
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
			}
			
		ESFOrganization org = new ESFOrganizationImpl();
		org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(ownerOrganizationId);
		org.setOrganizzationCategory(categoryAssosiation);
		ESFOrganizationLocalServiceUtil.updateESFOrganization(org);
		
		
		return esfField;
		
	}
	
	public ESFField addESFField(
		long userId, String name, long ownerOrganizationId,
		long esfAddressIdId, long esfSportTypeIds[],
		ESFEntityState esfEntityState, String note, long billboard,
		boolean billboardStations, boolean backgroundRampart,
		boolean backgroundNet, boolean backgroundLeadRecovery,
		boolean disabledaccess,
		List<ESFFieldESFElectronic> esfFieldESFElectronics,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long esfFieldId = counterLocalService.increment();

		ESFField esfField = esfFieldPersistence.create(esfFieldId);

		esfField.setUserId(userId);

		esfField.setGroupId(groupId);
		esfField.setCompanyId(user.getCompanyId());
		esfField.setUserName(user.getFullName());
		esfField.setCreateDate(serviceContext.getCreateDate(now));
		esfField.setModifiedDate(serviceContext.getModifiedDate(now));
		esfField.setName(name);
		esfField.setOwnerOrganizationId(ownerOrganizationId);
		esfField.setEsfAddressId(esfAddressIdId);
		esfField.setNote(note);
		esfField.setBillboard(billboard);
		esfField.setBillboardStations(billboardStations);
		esfField.setBackgroundRampart(backgroundRampart);
		esfField.setBackgroundNet(backgroundNet);
		esfField.setBackgroundLeadRecovery(backgroundLeadRecovery);

		esfField.setDisabledAccess(disabledaccess);
		esfField.setExpandoBridgeAttributes(serviceContext);

		esfFieldPersistence.update(esfField);

		for (ESFFieldESFElectronic esfFieldESFElectronic : esfFieldESFElectronics) {
			ESFFieldESFElectronicLocalServiceUtil.addESFFieldESFElectronic(
				esfFieldESFElectronic.getBrandId(),
				esfFieldESFElectronic.getElectronicId(),
				 esfFieldId, esfFieldESFElectronic.getDescription(),
				serviceContext);
		}

		ESFEntityStateLocalServiceUtil.addEntityState(
			serviceContext.getUserId(), ESFField.class.getName(), esfFieldId,
			esfEntityState.getEsfStateId(), serviceContext);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFField.class.getName(),
			esfFieldId, false, true, true);

	/*	AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfField.getCreateDate(),
				esfField.getModifiedDate(), ESFField.class.getName(),
				esfFieldId, esfField.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfField.getName(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);*/

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);

		indexer.reindex(esfField);

		updateESFFieldESFSportType(esfFieldId, esfSportTypeIds, serviceContext);
		
		int numField = 0;
		String categoryAssosiation = "";
		
		numField=ESFFieldLocalServiceUtil.
				findByESFOrganization(ownerOrganizationId,ESFKeys.ESFStateType.ENABLE).size();
			if(numField==1 || numField == 0){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
			}else if(numField==2 || numField ==3){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
			}else if(numField==4 || numField ==5){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
			}else{
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
			}
			
		ESFOrganization org = new ESFOrganizationImpl();
		org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(ownerOrganizationId);
		org.setOrganizzationCategory(categoryAssosiation);
		ESFOrganizationLocalServiceUtil.updateESFOrganization(org);

		return esfField;

	}
	
	public ESFField updateESFField(
		long userId, long esfFieldId, String name, long ownerOrganizationId,
		long esfAddressId, long esfSportTypeIds[],
		ESFEntityState esfEntityState, String note, long billboard,
		boolean billboardStations, boolean backgroundRampart,
		boolean backgroundNet, boolean backgroundLeadRecovery,
		boolean disabledaccess,
		List<ESFFieldESFElectronic> esfFieldESFElectronics,
		ServiceContext serviceContext)
		throws PortalException, SystemException {
	
		Date now = new Date();
		
		validate(name);
		
		ESFField esfField = getESFField(esfFieldId);
		
		User user = UserLocalServiceUtil.getUser(userId);
		
		esfField.setUserId(userId);
		esfField.setUserName(user.getFullName());
		esfField.setModifiedDate(serviceContext.getModifiedDate(now));
		esfField.setName(name);
		esfField.setOwnerOrganizationId(ownerOrganizationId);
		esfField.setEsfAddressId(esfAddressId);
		esfField.setNote(note);
		esfField.setBillboard(billboard);
		esfField.setBillboardStations(billboardStations);
		esfField.setBackgroundRampart(backgroundRampart);
		esfField.setBackgroundNet(backgroundNet);
		esfField.setBackgroundLeadRecovery(backgroundLeadRecovery);

		esfField.setDisabledAccess(disabledaccess);
		esfField.setExpandoBridgeAttributes(serviceContext);
		
		esfFieldPersistence.update(esfField);
		
		List<ESFFieldESFElectronic> esfFieldESFElectronicsFromDb =
			ESFFieldESFElectronicLocalServiceUtil.findByFieldId(esfFieldId);
		
		for (ESFFieldESFElectronic esfFieldESFElectronicFromDb : esfFieldESFElectronicsFromDb) {
			
			ESFFieldESFElectronicLocalServiceUtil.deleteESFFieldESFElectronic(
				esfFieldESFElectronicFromDb.getId(), serviceContext);
		}
		
		for (ESFFieldESFElectronic esfFieldESFElectronic : esfFieldESFElectronics) {
			
			ESFFieldESFElectronicLocalServiceUtil.addESFFieldESFElectronic(
				esfFieldESFElectronic.getBrandId(),
				esfFieldESFElectronic.getElectronicId(), esfFieldId,
				esfFieldESFElectronic.getDescription(),
				serviceContext);
			
		}
		
		ESFEntityState esfEntityStateFromDB =
			ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
				ESFField.class.getName(), esfFieldId);
		
		if (esfEntityStateFromDB != null &&
			esfEntityStateFromDB.getEsfStateId() != esfEntityState.getEsfStateId()) {
			
			ESFEntityStateLocalServiceUtil.updateEntityState(
				serviceContext.getUserId(),
				esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);
			
			ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFField.class.getName(),
				esfFieldId, esfEntityState.getEsfStateId(), serviceContext);
			
			List<ESFField> esfFields =
				findByESFOrganization(
					ownerOrganizationId, ESFKeys.ESFStateType.ENABLE);
			
			if (esfFields.isEmpty()) {
				
				ESFOrganizationLocalServiceUtil.updateOnlyESFOrganitazionState(
					ownerOrganizationId, serviceContext);
				
			}
		}
		
		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			name, esfFieldId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());
		
	/*	AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				esfField.getUserId(), esfField.getGroupId(),
				esfField.getCreateDate(), esfField.getModifiedDate(),
				ESFField.class.getName(), esfFieldId, esfField.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfField.getName(), null, null, null,
				null, 0, 0, null, false);
		
		assetLinkLocalService.updateLinks(
			serviceContext.getUserId(), assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);*/
		
		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);
		
		indexer.reindex(esfField);
		
		updateESFFieldESFSportType(esfFieldId, esfSportTypeIds, serviceContext);
		
		int numField = 0;
		String categoryAssosiation = "";
		
		numField=ESFFieldLocalServiceUtil.
				findByESFOrganization(ownerOrganizationId,ESFKeys.ESFStateType.ENABLE).size();
			if(numField==1 || numField == 0){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
			}else if(numField==2 || numField ==3){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
			}else if(numField==4 || numField ==5){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
			}else{
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
			}
			
		ESFOrganization org = new ESFOrganizationImpl();
		org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(ownerOrganizationId);
		org.setOrganizzationCategory(categoryAssosiation);
		ESFOrganizationLocalServiceUtil.updateESFOrganization(org);
		
		return esfField;
	}
	
	public ESFField deleteESFField(
		long esfFieldId, ServiceContext serviceContext)
		throws PortalException, SystemException {
	
		ESFField esfField = getESFField(esfFieldId);
		
		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFField.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfFieldId);
		
		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFField.class.getName(), esfFieldId);
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		
		assetEntryLocalService.deleteEntry(assetEntry);
		
		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);
		
		indexer.delete(esfField);
		
		esfFieldESFSportTypePersistence.removeByesfFieldId(esfFieldId);
		
		esfField = deleteESFField(esfFieldId);
		
		List<ESFFieldESFElectronic> esfFieldESFElectronicsFromDb =
			ESFFieldESFElectronicLocalServiceUtil.findByFieldId(esfFieldId);
		
		for (ESFFieldESFElectronic esfFieldESFElectronicFromDb : esfFieldESFElectronicsFromDb) {
			
			ESFFieldESFElectronicLocalServiceUtil.deleteESFFieldESFElectronic(
				esfFieldESFElectronicFromDb.getId(), serviceContext);
		}
		
		return esfField;
	}
	
	public ESFField giveWayESFField(
		long esfFieldId, long actualOwnerId, ServiceContext serviceContext)
		throws PortalException, SystemException {
	
		ESFField esfField = getESFField(esfFieldId);
		
		long realOwnerId = esfField.getOwnerOrganizationId();
		
		esfField.setOwnerOrganizationId(actualOwnerId);
		
		esfFieldPersistence.update(esfField);
		
		ESFEntityState esfEntityState =
			ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFField.class.getName(),
				esfFieldId, ESFKeys.ESFStateType.GIVEWAY, serviceContext);
		
		ESFLentFieldLocalServiceUtil.addESFLentField(
			esfEntityState.getEsfEntityStateId(), esfFieldId, realOwnerId,
			actualOwnerId);
		
		int numField = 0;
		String categoryAssosiation = "";
		
		numField=ESFFieldLocalServiceUtil.
				findByESFOrganization(actualOwnerId,ESFKeys.ESFStateType.ENABLE).size();
			if(numField==1 || numField == 0){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
			}else if(numField==2 || numField ==3){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
			}else if(numField==4 || numField ==5){
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
			}else{
				categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
			}
			
		ESFOrganization org = new ESFOrganizationImpl();
		org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(actualOwnerId);
		org.setOrganizzationCategory(categoryAssosiation);
		ESFOrganizationLocalServiceUtil.updateESFOrganization(org);
		
		/////////////////////////////////////
		
		
		int numFieldOld = 0;
		String categoryAssosiationOld = "";
		
		numFieldOld=ESFFieldLocalServiceUtil.
				findByESFOrganization(realOwnerId,ESFKeys.ESFStateType.ENABLE).size();
			if(numFieldOld==1 || numFieldOld == 0){
				categoryAssosiationOld = ESFKeys.ESFOrganizationCategory.fourth;
			}else if(numFieldOld==2 || numFieldOld ==3){
				categoryAssosiationOld = ESFKeys.ESFOrganizationCategory.third;
			}else if(numFieldOld==4 || numFieldOld ==5){
				categoryAssosiationOld = ESFKeys.ESFOrganizationCategory.second;
			}else{
				categoryAssosiationOld = ESFKeys.ESFOrganizationCategory.first;
			}
			
		ESFOrganization orgOld = new ESFOrganizationImpl();
		orgOld = ESFOrganizationLocalServiceUtil.fetchESFOrganization(realOwnerId);
		orgOld.setOrganizzationCategory(categoryAssosiationOld);
		ESFOrganizationLocalServiceUtil.updateESFOrganization(orgOld);
		
		
		
		
		return esfField;
	}
	
	public ESFField returnESFField(
		long esfFieldId, long actualOwnerId, ServiceContext serviceContext)
		throws PortalException, SystemException {
	
		ESFEntityState esfEntityStateFromDB =
			ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
				ESFField.class.getName(), esfFieldId,
				ESFKeys.ESFStateType.GIVEWAY);
		
		ESFEntityStateLocalServiceUtil.updateEntityState(
			serviceContext.getUserId(),
			esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);
		
		ESFLentField esfLentField =
			ESFLentFieldLocalServiceUtil.findESFLentFieldbyF_S(
				esfFieldId, esfEntityStateFromDB.getEsfEntityStateId());
		
		ESFField esfField = getESFField(esfFieldId);
		
		esfField.setOwnerOrganizationId(esfLentField.getRealOwnerId());
		
		esfFieldPersistence.update(esfField);
		
		return esfField;
	}
	
	protected void validate(String name)
		throws PortalException {
	
		if (Validator.isNull(name)) {
			throw new ESFFieldNameException();
		}
	}
	
	protected void updateESFFieldESFSportType(
		long esfFieldId, long esfSportTypeIds[], ServiceContext serviceContext)
		throws SystemException {
	
		List<ESFFieldESFSportType> currentESFFieldESFSportType =
			esfFieldESFSportTypePersistence.findByesfFieldId(esfFieldId);
		
		for (ESFFieldESFSportType esfFieldESFSportType : currentESFFieldESFSportType) {
			
			long esfSportTypeId = esfFieldESFSportType.getEsfSportTypeId();
			
			if (!ArrayUtil.contains(esfSportTypeIds, esfSportTypeId)) {
				
				try {
					
					esfFieldESFSportTypePersistence.remove(esfFieldESFSportType);
				}
				catch (SystemException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		for (long esfSportTypeId : esfSportTypeIds) {
			
			if (Validator.isNotNull(esfSportTypeId) && esfSportTypeId > 0) {
				ESFFieldESFSportTypePK esfFieldEsfSportTypePK =
					new ESFFieldESFSportTypePK(esfFieldId, esfSportTypeId);
				
				ESFFieldESFSportType esfFieldESFSportType = null;
				
				try {
					
					esfFieldESFSportType =
						esfFieldESFSportTypePersistence.findByPrimaryKey(esfFieldEsfSportTypePK);
				}
				catch (NoSuchFieldESFSportTypeException e) {
					
					esfFieldESFSportType =
						esfFieldESFSportTypePersistence.create(esfFieldEsfSportTypePK);
				}
				
				esfFieldESFSportTypePersistence.update(
					esfFieldESFSportType, serviceContext);
				
			}
		}
		
	}
	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
	
}
