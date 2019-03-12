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
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFRenewalLocalServiceUtil;
import it.ethica.esf.service.base.ESFRenewalLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFRenewalUtil;
//import it.ethica.esf.service.persistence.ESFRenewalPersistence;
//import it.ethica.esf.service.persistence.ESFRenewalPersistenceImpl;
import it.ethica.esf.util.ESFKeys;

/**
 * The implementation of the e s f renewal local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFRenewalLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFRenewalLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFRenewalLocalServiceUtil
 */
public class ESFRenewalLocalServiceImpl extends ESFRenewalLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFRenewalLocalServiceUtil} to access the e
	 * s f renewal local service.
	 */
	
	public List<ESFRenewal> findByESFRenewalUser_id(long userId)
		throws SystemException {
		
		return esfRenewalPersistence.findByESFRenewalUser(userId);
	}
	
	public List<ESFRenewal> findAll()
			throws SystemException {

			return esfRenewalPersistence.findAll();
		}
	
	
	public List<ESFRenewal> findByRegion(long currentOrganizationId)
			throws SystemException {
		
		List<ESFRenewal> renewals = new ArrayList<ESFRenewal>();
		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();						
		try {
			associations = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId);
		
		long[] classPKs = new long[associations.size()];

		int i = 0;

		for (ESFOrganization association : associations) {
			classPKs[i] = association.getEsfOrganizationId();
			i++;
		}

		DynamicQuery renewalQuery =
			DynamicQueryFactoryUtil.forClass(
					ESFRenewal.class, "renewalQuery",
				PortletClassLoaderUtil.getClassLoader());

		renewalQuery.add(PropertyFactoryUtil.forName("renewalQuery.organizationId").in(
			classPKs));

		renewals = ESFRenewalLocalServiceUtil.dynamicQuery(renewalQuery);
	
		
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return renewals;
		}
	public List<ESFRenewal> findByRegion(long currentOrganizationId, int start, int end)
			throws SystemException {
		
		List<ESFRenewal> renewals = new ArrayList<ESFRenewal>();
		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();						
		try {
			associations = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId);
		
		long[] classPKs = new long[associations.size()];

		int i = 0;

		for (ESFOrganization association : associations) {
			classPKs[i] = association.getEsfOrganizationId();
			i++;
		}

		DynamicQuery renewalQuery =
			DynamicQueryFactoryUtil.forClass(
					ESFRenewal.class, "renewalQuery",
				PortletClassLoaderUtil.getClassLoader());

		renewalQuery.add(PropertyFactoryUtil.forName("renewalQuery.organizationId").in(
			classPKs));

		renewals = ESFRenewalLocalServiceUtil.dynamicQuery(renewalQuery, start, end);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return renewals;
		}
	
	public List<ESFRenewal>  findByOrgId_IsTotal(long currentOrganizationId, boolean isTotal)
			throws SystemException {
		
		return ESFRenewalUtil.findByOrgId_IsTotal(currentOrganizationId, isTotal);
	}
	public List<ESFRenewal>  findByRenewalFatherId(long renewalFatherId)
			throws SystemException {
		
		return ESFRenewalUtil.findByRenewalFatherId(renewalFatherId);
	}
	public List<ESFRenewal>  findByOrg_Year(long orgId, int year)
			throws SystemException {
		
		return ESFRenewalUtil.findByOrg_Year(orgId,year);
	}
	public List<ESFRenewal>  findByReason_IsTotal(String reason, boolean isTotal)
			throws SystemException {
		
		return ESFRenewalUtil.findByReason_IsTotal(reason,isTotal);
	}
	
	public List<ESFRenewal>  findByRenewalFatherId_OrgId(long renewalFatherId, long organizationId)
			throws SystemException, PortalException {
		List<ESFRenewal> renewals = new ArrayList<ESFRenewal>();
		List<ESFRenewal> renewalsOrg = new ArrayList<ESFRenewal>();
		renewalsOrg = ESFRenewalLocalServiceUtil.findByOrgId(organizationId);
		renewals = ESFRenewalLocalServiceUtil.findByRenewalFatherId(renewalFatherId);
		return renewals;
	}
	
	public List<ESFRenewal>  findByOrgId(long organizationId)
			throws SystemException, PortalException {
		List<ESFRenewal> renewals = new ArrayList<ESFRenewal>();
		List<ESFRenewal> orgRenewals = new ArrayList<ESFRenewal>();
		List<ESFRenewal> orgRenewalsAnnual = new ArrayList<ESFRenewal>();
		List<ESFRenewal> orgRenewalsAnnualComplete = new ArrayList<ESFRenewal>();
		List<ESFRenewal> orgRenewalsAnnualSons = new ArrayList<ESFRenewal>();
		double amount = 0;
		double amountFather = 0;
		double annualMembershipDueCost = 0;
		
		int fild;
		fild = ESFFieldLocalServiceUtil.findByESFOrganization(
				organizationId, ESFKeys.ESFStateType.ENABLE).size();
		if(fild==0){
			annualMembershipDueCost = Double.valueOf( ESFConfigurationLocalServiceUtil.
					 getESFConfigurationByESFKey("first-registration-cost").getValue());
			}else if(fild==1){
				annualMembershipDueCost = Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-1").getValue());
			}else if(fild==2 ){
				annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-2").getValue());
			}else if( fild==3){
				annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-3").getValue());
			}else if(fild==4){
				annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-4").getValue());
			}else if(fild==5){
				annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-5").getValue());
			}else{
				annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-6").getValue());
			}
		
		orgRenewals = ESFRenewalLocalServiceUtil.findAll();
		for(ESFRenewal r : orgRenewals){
			if(organizationId == r.getOrganizationId() && 0 == r.getRenewalFatherId()){
				orgRenewalsAnnual.add(r);
			}
		}
		
		for(ESFRenewal r : orgRenewalsAnnual){
			amountFather = r.getAmount();
			orgRenewalsAnnualSons = ESFRenewalLocalServiceUtil.findByRenewalFatherId(r.getEsfRenewalId());
			for(ESFRenewal e : orgRenewalsAnnualSons){
				amount = amount + e.getAmount();
			}
			if((amount+amountFather)<annualMembershipDueCost){
				renewals.add(r);
			}
			amount = 0;
		}
		return renewals;
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
}
