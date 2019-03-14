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

import java.util.List;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.service.base.ESFArticleLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s f article local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFArticleLocalService} interface. <p> This is
 * a local service. Methods of this service will not have security checks based
 * on the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFArticleLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFArticleLocalServiceUtil
 */
public class ESFArticleLocalServiceImpl extends ESFArticleLocalServiceBaseImpl {

	@Override
	public ESFArticle addESFArticle(
		String code, String name, String description, long xxxlQty,
		long xxlQty, long xlQty, long lQty, long mQty, long sQty, long xsQty,
		long xxsQty, long otherQty, long totalQty, boolean disabled,
		long esfArticleTypeId)
		throws PortalException, SystemException {

		long esfArticleId = counterLocalService.increment();

		ESFArticle esfArticle = esfArticlePersistence.create(esfArticleId);
		esfArticle.setCode(code);
		esfArticle.setName(name);
		esfArticle.setDescription(description);
		esfArticle.setXxxlQty(xxxlQty);
		esfArticle.setXxlQty(xxlQty);
		esfArticle.setXlQty(xlQty);
		esfArticle.setLQty(lQty);
		esfArticle.setMQty(mQty);
		esfArticle.setSQty(sQty);
		esfArticle.setXsQty(xsQty);
		esfArticle.setXxsQty(xxsQty);
		esfArticle.setOtherQty(otherQty);
		esfArticle.setTotalQty(totalQty);
		esfArticle.setDisabled(disabled);
		esfArticle.setEsfArticleTypeId(esfArticleTypeId);
		esfArticlePersistence.update(esfArticle);

		return esfArticle;
	}

	@Override
	public ESFArticle updateESFArticle(
		long esfArticleId, String code, String name, String description,
		long xxxlQty, long xxlQty, long xlQty, long lQty, long mQty, long sQty,
		long xsQty, long xxsQty, long otherQty, long totalQty,
		boolean disabled, long esfArticleTypeId)
		throws PortalException, SystemException {

		ESFArticle esfArticle =
			esfArticlePersistence.fetchByPrimaryKey(esfArticleId);
		esfArticle.setCode(code);
		esfArticle.setName(name);
		esfArticle.setDescription(description);
		esfArticle.setXxxlQty(xxxlQty);
		esfArticle.setXxlQty(xxlQty);
		esfArticle.setXlQty(xlQty);
		esfArticle.setLQty(lQty);
		esfArticle.setMQty(mQty);
		esfArticle.setSQty(sQty);
		esfArticle.setXsQty(xsQty);
		esfArticle.setXxsQty(xxsQty);
		esfArticle.setOtherQty(otherQty);
		esfArticle.setTotalQty(totalQty);
		esfArticle.setDisabled(disabled);
		esfArticle.setEsfArticleTypeId(esfArticleTypeId);
		esfArticlePersistence.update(esfArticle);

		return esfArticle;
	}

	@Override
	public List<ESFArticle> getEnabledESFArticles()
		throws SystemException {

		return esfArticlePersistence.findByDisabled(false);
	}

	@Override
	public List<ESFArticle> getEnabledESFArticles(int start, int end)
		throws SystemException {

		return esfArticlePersistence.findByDisabled(false, start, end);
	}

	@Override
	public List<ESFArticle> getDisabledESFArticles()
		throws SystemException {

		return esfArticlePersistence.findByDisabled(true);
	}

	@Override
	public List<ESFArticle> getDisabledESFArticles(int start, int end)
		throws SystemException {

		return esfArticlePersistence.findByDisabled(true, start, end);
	}
}
