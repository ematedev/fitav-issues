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

package it.ethica.esf.model.impl;

import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/**
 * The extended model implementation for the ESFOrganization service. Represents a row in the &quot;ESFOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.model.ESFOrganization} interface.
 * </p>
 *
 * @author Ethica
 */
public class ESFOrganizationImpl extends ESFOrganizationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a e s f organization model instance should use the {@link it.ethica.esf.model.ESFOrganization} interface instead.
	 */
	private String name;
	private List<String> types;
	
	public ESFOrganizationImpl() {
		name = null;
		types = new ArrayList<String>();
	}
	
	public String getName() throws PortalException, SystemException {
		name = OrganizationLocalServiceUtil.getOrganization(getPortalOrganizationId()).getName();
		return name;
	}	
	
	public List<String> getTypes() throws PortalException, SystemException {
		return ESFOrganizationTypeLocalServiceUtil.getOrganizationTypes(getEsfOrganizationId());
	}
}