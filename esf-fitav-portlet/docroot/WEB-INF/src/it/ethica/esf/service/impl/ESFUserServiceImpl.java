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

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.base.ESFUserServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

/**
 * The implementation of the e s f user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFUserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserServiceUtil
 */
public class ESFUserServiceImpl extends ESFUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFUserServiceUtil} to access the e s f user remote service.
	 */
	public List<User> findByLastnameLike(long esfOrganizationId, String lastName){
		List<User> users = new ArrayList<User>();
		List<ESFUser> esfUsers = esfUserLocalService.getAllShooterByLikeF_C_S("", lastName, "", esfOrganizationId);
		if(esfUsers.size() > 0){
			for(ESFUser esfUser : esfUsers){
				User user = null;
				try {
					user = userPersistence.fetchByPrimaryKey(esfUser.getEsfUserId());
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
				if(user != null){
					users.add(user);
				}
			}
		}
		return users;
	}
	Log _log = LogFactoryUtil.getLog(ESFUserServiceImpl.class.getName());
}