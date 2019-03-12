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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;

/**
 * The extended model implementation for the ESFUserRole service. Represents a
 * row in the &quot;ESFUserRole&quot; database table, with each column mapped to
 * a property of this class. <p> Helper methods and all application logic should
 * be put in this class. Whenever methods are added, rerun ServiceBuilder to
 * copy their definitions into the {@link it.ethica.esf.model.ESFUserRole}
 * interface. </p>
 *
 * @author Ethica
 */
public class ESFUserRoleImpl extends ESFUserRoleBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a e s f user role model instance should use the {@link
	 * it.ethica.esf.model.ESFUserRole} interface instead.
	 */
	public ESFUserRoleImpl() {

	}

	private String name;
	private String description;
	private String title;

	public String getTitle()
		throws PortalException, SystemException {

		title = RoleLocalServiceUtil.getRole(getEsfUserRoleId()).getTitle(LocaleUtil.getDefault());
		return title;
	}

	public void setTitle(String title)
		throws PortalException, SystemException {

		RoleLocalServiceUtil.getRole(getEsfUserRoleId()).setTitle(title);
		this.title = title;
	}

	public String getName()
		throws PortalException, SystemException {

		name = RoleLocalServiceUtil.getRole(getEsfUserRoleId()).getName();
		return name;
	}

	public void setName(String name)
		throws PortalException, SystemException {

		RoleLocalServiceUtil.getRole(getEsfUserRoleId()).setName(name);
		this.name = name;
	}

	public String getDescription()
		throws PortalException, SystemException {

		description = RoleLocalServiceUtil.getRole(getEsfUserRoleId()).getDescription(LocaleUtil.getDefault());
		return description;
	}

	public void setDescription(String description)
		throws PortalException, SystemException {

		RoleLocalServiceUtil.getRole(getEsfUserRoleId()).setDescription(
			description);
		this.description = description;
	}

}
