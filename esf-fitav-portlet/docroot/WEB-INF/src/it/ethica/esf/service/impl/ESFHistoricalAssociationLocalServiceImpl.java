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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import it.ethica.esf.model.ESFHistoricalAssociation;
import it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil;
import it.ethica.esf.service.base.ESFHistoricalAssociationLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFHistoricalAssociationUtil;
import it.ethica.esf.util.ManageDate;

/**
 * The implementation of the e s f historical association local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFHistoricalAssociationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFHistoricalAssociationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil
 */
public class ESFHistoricalAssociationLocalServiceImpl
	extends ESFHistoricalAssociationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil} to access the e s f historical association local service.
	 */
	
	public List<ESFHistoricalAssociation> findESFHistoricalAssociationByesfOrganizationId(long esfOrganizationId) 
			throws SystemException{
		
		List<ESFHistoricalAssociation> historyOrganization = new ArrayList<ESFHistoricalAssociation>();
		
		DynamicQuery historyOrganizationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFHistoricalAssociation.class, "historyOrganizationQuery",
						PortletClassLoaderUtil.getClassLoader());
			
			
		historyOrganizationQuery.add(PropertyFactoryUtil.forName("historyOrganizationQuery.organizationId").
			eq(esfOrganizationId));
		
		historyOrganization = ESFHistoricalAssociationLocalServiceUtil.dynamicQuery(historyOrganizationQuery);
		
		return historyOrganization;
	}
	
	public List<ESFHistoricalAssociation> findESFHistoricalAssociationByesfOrganizationId(long esfOrganizationId, int start, int end) 
			throws SystemException{
		
		List<ESFHistoricalAssociation> historyOrganization = new ArrayList<ESFHistoricalAssociation>();
		
		DynamicQuery historyOrganizationQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFHistoricalAssociation.class, "historyOrganizationQuery",
						PortletClassLoaderUtil.getClassLoader());
			
		
		
		historyOrganizationQuery.add(PropertyFactoryUtil.forName("historyOrganizationQuery.organizationId").
			eq(esfOrganizationId));
		
		historyOrganization = ESFHistoricalAssociationLocalServiceUtil.dynamicQuery(historyOrganizationQuery, start, end);
		
		
		return historyOrganization;
	}
	
	public ESFHistoricalAssociation addESFHistoricalAssociation(
			long esfOrganizationId, String name, String code, Long stateId, Long variationId, String stateVariationDate)
			throws SystemException, PortalException, ParseException {

			Date now = new Date();
			long esfHistoricalAssociationId = counterLocalService.increment();
			if(!"".equalsIgnoreCase(stateVariationDate)){
				now = ManageDate.StringToDate(stateVariationDate);
			}
						
			ESFHistoricalAssociation esfHistoricalAssociation = esfHistoricalAssociationPersistence.create(esfHistoricalAssociationId);

			esfHistoricalAssociation.setName(name);
			esfHistoricalAssociation.setCode(code);
			esfHistoricalAssociation.setOrganizationId(esfOrganizationId);
			esfHistoricalAssociation.setDateChange(now);
			esfHistoricalAssociation.setStateId(stateId);
			esfHistoricalAssociation.setVariationId(variationId);

			esfHistoricalAssociationPersistence.update(esfHistoricalAssociation);

			return esfHistoricalAssociation;

		}
	
	public List<ESFHistoricalAssociation> findbyOrg_Date(long esfOrganizationId) 
			throws SystemException{
		
		return ESFHistoricalAssociationUtil.findByOrg_Date(esfOrganizationId);
	}
	
}