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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.ethica.esf.model.ESFArticleDelivered;
import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.service.ESFOrderLocalServiceUtil;
import com.ethica.esf.service.base.ESFOrderLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the e s f order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFOrderLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFOrderLocalServiceUtil
 */
public class ESFOrderLocalServiceImpl extends ESFOrderLocalServiceBaseImpl {

	public List<ESFOrder> getESFOrderByArticleId(long esfArticleId)
			throws SystemException {

		return esfOrderPersistence.findByEsfArticle(esfArticleId);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.ethica.esf.service.ESFOrderLocalServiceUtil} to access the e s
	 * f order local service.
	 */
	public List<ESFOrder> getESFOrderByStockistId(long esfStockistId)
			throws SystemException {

		return esfOrderPersistence.findByStockist(esfStockistId);
	}

	public ESFOrder updateESFOrder(long esfOrderId, String description,
			long esfStockistId, Date dateO, long qty,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFOrder esfOrder = ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
		esfOrder.setData(dateO);
		esfOrder.setDescription(description);
		esfOrder.setEsfStockistId(esfStockistId);
		esfOrder.setQty(qty);
		esfOrder.setExpandoBridgeAttributes(serviceContext);

		esfOrderPersistence.update(esfOrder);

		return esfOrder;
	}

	public ESFOrder updateESFOrderQty(long esfOrderId, long qty,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFOrder esfOrder = ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
		esfOrder.setQty(qty);
		esfOrder.setExpandoBridgeAttributes(serviceContext);

		esfOrderPersistence.update(esfOrder);

		return esfOrder;
	}

	public ESFOrder addESFOrder(String description, String code,
			long esfStockistId, long esfArticleId, long qty, Date dateO,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		long esfOrderId = counterLocalService.increment();
		ESFOrder esfOrder = esfOrderPersistence.create(esfOrderId);
		esfOrder.setEsfArticleId(esfArticleId);
		esfOrder.setCode(code);
		esfOrder.setDescription(description);
		esfOrder.setEsfStockistId(esfStockistId);
		esfOrder.setData(dateO);
		esfOrder.setQty(qty);
		esfOrder.setExpandoBridgeAttributes(serviceContext);

		esfOrderPersistence.update(esfOrder);

		return esfOrder;
	}
}