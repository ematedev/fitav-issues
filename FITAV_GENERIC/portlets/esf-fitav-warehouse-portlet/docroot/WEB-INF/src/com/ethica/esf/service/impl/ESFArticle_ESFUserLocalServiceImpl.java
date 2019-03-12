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

package com.ethica.esf.service.impl;

import java.util.Date;
import java.util.List;

import com.ethica.esf.model.ESFArticle_ESFUser;
import com.ethica.esf.service.base.ESFArticle_ESFUserLocalServiceBaseImpl;
import com.ethica.esf.service.persistence.ESFArticle_ESFUserPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;

/**
 * The implementation of the e s f article_ e s f user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ethica.esf.service.ESFArticle_ESFUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFArticle_ESFUserLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil
 */
public class ESFArticle_ESFUserLocalServiceImpl
	extends ESFArticle_ESFUserLocalServiceBaseImpl {
	
	@Override
	public ESFArticle_ESFUser addESFArticle_ESFUser(
		long esfArticleId, long esfUserId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, String description, Date deliveryDate)
		throws PortalException, SystemException {

		ESFArticle_ESFUserPK pk =
			new ESFArticle_ESFUserPK(esfArticleId, esfUserId);
		ESFArticle_ESFUser esfArticleEsfUser =
			esfArticle_ESFUserPersistence.create(pk);
		esfArticleEsfUser.setXxxlQty(xxxlQty);
		esfArticleEsfUser.setXxlQty(xxlQty);
		esfArticleEsfUser.setXlQty(xlQty);
		esfArticleEsfUser.setLQty(lQty);
		esfArticleEsfUser.setMQty(mQty);
		esfArticleEsfUser.setSQty(sQty);
		esfArticleEsfUser.setXsQty(xsQty);
		esfArticleEsfUser.setXxsQty(xxsQty);
		esfArticleEsfUser.setOtherQty(otherQty);
		esfArticleEsfUser.setTotalQty(totalQty);
		esfArticleEsfUser.setDescription(description);
		esfArticleEsfUser.setDeliveryDate(deliveryDate);

		esfArticle_ESFUserPersistence.update(esfArticleEsfUser);

		return esfArticleEsfUser;
	}

	@Override
	public ESFArticle_ESFUser updateESFArticle_ESFUser(
		long esfArticleId, long esfUserId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, String description, Date deliveryDate)
		throws PortalException, SystemException {

		ESFArticle_ESFUserPK pk =
			new ESFArticle_ESFUserPK(esfArticleId, esfUserId);
		ESFArticle_ESFUser esfArticleEsfUser =
			esfArticle_ESFUserPersistence.fetchByPrimaryKey(pk);
		esfArticleEsfUser.setXxxlQty(xxxlQty);
		esfArticleEsfUser.setXxlQty(xxlQty);
		esfArticleEsfUser.setXlQty(xlQty);
		esfArticleEsfUser.setLQty(lQty);
		esfArticleEsfUser.setMQty(mQty);
		esfArticleEsfUser.setSQty(sQty);
		esfArticleEsfUser.setXsQty(xsQty);
		esfArticleEsfUser.setXxsQty(xxsQty);
		esfArticleEsfUser.setOtherQty(otherQty);
		esfArticleEsfUser.setTotalQty(totalQty);
		esfArticleEsfUser.setDescription(description);
		esfArticleEsfUser.setDeliveryDate(deliveryDate);

		esfArticle_ESFUserPersistence.update(esfArticleEsfUser);

		return esfArticleEsfUser;
	}

	@Override
	public List<ESFArticle_ESFUser> findByEsfArticleId(long esfArticleId)
		throws PortalException, SystemException {

		return esfArticle_ESFUserPersistence.findByESFArticleId(esfArticleId);
	}

	@Override
	public long[] getEsfUserIdByEsfArticleId(long esfArticleId)
		throws PortalException, SystemException {

		List<ESFArticle_ESFUser> esfArticle_ESFUsers =
			esfArticle_ESFUserPersistence.findByESFArticleId(esfArticleId);
		long[] esfUserIds = new long[esfArticle_ESFUsers.size()];

		for (ESFArticle_ESFUser esfArticle_ESFUser : esfArticle_ESFUsers) {
			esfUserIds = ArrayUtil.append(
				esfUserIds, esfArticle_ESFUser.getEsfUserId());
		}
		return esfUserIds;
	}
}