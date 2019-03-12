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

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the ESFUser service. Represents a row in the &quot;ESFUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.model.ESFUser} interface.
 * </p>
 *
 * @author Ethica
 */
public class ESFUserImpl extends ESFUserBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a e s f user model instance should use the {@link it.ethica.esf.model.ESFUser} interface instead.
	 */
	private String userEmail;
	private String lastName;
	private Date birthday;
	private String firstName;
	private String screenName;
	private boolean male;
	private String jobTitle;
	
	public ESFUserImpl() { 
		userEmail = null;
		lastName = null;
		firstName = null;
		birthday = null;
		screenName = null;
		male = true;
	}
	
	public String getUserEmail() throws PortalException, SystemException {
		userEmail = UserLocalServiceUtil.getUser(getPortalUserId()).getEmailAddress();
		return userEmail;
	}
	
	public Date getBirthday() throws PortalException, SystemException {
		birthday = UserLocalServiceUtil.getUser(getPortalUserId()).getBirthday();
		return birthday;
	}
	
	public String getFirstName() throws PortalException, SystemException {
		firstName = UserLocalServiceUtil.getUser(getPortalUserId()).getFirstName();
		return firstName;
	}
	
	public String getLastName() throws PortalException, SystemException {
		lastName = UserLocalServiceUtil.getUser(getPortalUserId()).getLastName();
		return lastName;
	}
	
	public String getScreenName() throws PortalException, SystemException {
		screenName = UserLocalServiceUtil.getUser(getPortalUserId()).getScreenName();
		return screenName;
	}
	
	public boolean getMale() throws PortalException, SystemException {
		male = UserLocalServiceUtil.getUser(getPortalUserId()).getMale();
		return male;
	}
	
	public String getJobTitle() throws PortalException, SystemException {
		jobTitle = UserLocalServiceUtil.getUser(getPortalUserId()).getJobTitle();
		return jobTitle;
	}
}