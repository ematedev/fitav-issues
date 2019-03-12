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

import com.ethica.esf.model.ESFArticle_ESFOrder;
import com.ethica.esf.service.base.ESFArticle_ESFOrderLocalServiceBaseImpl;
import com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;

/**
 * The implementation of the e s f article_ e s f order local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFArticle_ESFOrderLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFArticle_ESFOrderLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFArticle_ESFOrderLocalServiceUtil
 */
public class ESFArticle_ESFOrderLocalServiceImpl
	extends ESFArticle_ESFOrderLocalServiceBaseImpl {

	@Override
	public ESFArticle_ESFOrder addESFArticle_ESFOrder(
		long esfArticleId, long esfOrderId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, double price, double vat, double sale)
		throws PortalException, SystemException {

		ESFArticle_ESFOrderPK pk =
			new ESFArticle_ESFOrderPK(esfArticleId, esfOrderId);
		ESFArticle_ESFOrder esfArticleEsfOrder =
			esfArticle_ESFOrderPersistence.create(pk);
		esfArticleEsfOrder.setXxxlQty(xxxlQty);
		esfArticleEsfOrder.setXxlQty(xxlQty);
		esfArticleEsfOrder.setXlQty(xlQty);
		esfArticleEsfOrder.setLQty(lQty);
		esfArticleEsfOrder.setMQty(mQty);
		esfArticleEsfOrder.setSQty(sQty);
		esfArticleEsfOrder.setXsQty(xsQty);
		esfArticleEsfOrder.setXxsQty(xxsQty);
		esfArticleEsfOrder.setOtherQty(otherQty);
		esfArticleEsfOrder.setTotalQty(totalQty);
		esfArticleEsfOrder.setPrice(price);
		esfArticleEsfOrder.setVat(vat);
		esfArticleEsfOrder.setSale(sale);

		esfArticle_ESFOrderPersistence.update(esfArticleEsfOrder);

		return esfArticleEsfOrder;
	}

	@Override
	public ESFArticle_ESFOrder updateESFArticle_ESFOrder(
		long esfArticleId, long esfOrderId, long xxxlQty, long xxlQty,
		long xlQty, long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, long totalQty, double price, double vat, double sale)
		throws PortalException, SystemException {

		ESFArticle_ESFOrderPK pk =
			new ESFArticle_ESFOrderPK(esfArticleId, esfOrderId);
		ESFArticle_ESFOrder esfArticleEsfOrder =
			esfArticle_ESFOrderPersistence.fetchByPrimaryKey(pk);
		esfArticleEsfOrder.setXxxlQty(xxxlQty);
		esfArticleEsfOrder.setXxlQty(xxlQty);
		esfArticleEsfOrder.setXlQty(xlQty);
		esfArticleEsfOrder.setLQty(lQty);
		esfArticleEsfOrder.setMQty(mQty);
		esfArticleEsfOrder.setSQty(sQty);
		esfArticleEsfOrder.setXsQty(xsQty);
		esfArticleEsfOrder.setXxsQty(xxsQty);
		esfArticleEsfOrder.setOtherQty(otherQty);
		esfArticleEsfOrder.setTotalQty(totalQty);
		esfArticleEsfOrder.setPrice(price);
		esfArticleEsfOrder.setVat(vat);
		esfArticleEsfOrder.setSale(sale);

		esfArticle_ESFOrderPersistence.update(esfArticleEsfOrder);

		return esfArticleEsfOrder;
	}

	@Override
	public List<ESFArticle_ESFOrder> findByEsfOrderId(long esfOrderId)
		throws PortalException, SystemException {

		return esfArticle_ESFOrderPersistence.findByESFOrderId(esfOrderId);
	}

	@Override
	public long[] getEsfArticleIdByEsfOrderId(long esfOrderId)
		throws PortalException, SystemException {

		List<ESFArticle_ESFOrder> esfArticle_ESFOrders =
			esfArticle_ESFOrderPersistence.findByESFOrderId(esfOrderId);
		long[] esfArticleIds = new long[esfArticle_ESFOrders.size()];

		for (ESFArticle_ESFOrder esfArticle_ESFOrder : esfArticle_ESFOrders) {
			esfArticleIds =
				ArrayUtil.append(
					esfArticleIds, esfArticle_ESFOrder.getEsfArticleId());
		}
		return esfArticleIds;
	}
}
