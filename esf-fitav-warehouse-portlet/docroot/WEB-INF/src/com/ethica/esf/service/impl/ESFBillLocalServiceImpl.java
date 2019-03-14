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

import com.ethica.esf.model.ESFBill;
import com.ethica.esf.service.base.ESFBillLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s f bill local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFBillLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFBillLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFBillLocalServiceUtil
 */
public class ESFBillLocalServiceImpl extends ESFBillLocalServiceBaseImpl {

	@Override
	public ESFBill addESFBill(
		long esfArticleId, long esfOrderId, String billNumber, long xxxlQty,
		long xxlQty, long xlQty, long lQty, long mQty, long sQty, long xsQty,
		long xxsQty, long otherQty, long totalQty)
		throws PortalException, SystemException {

		long esfBillId = counterLocalService.increment();

		ESFBill esfBill = esfBillPersistence.create(esfBillId);

		esfBill.setEsfArticleId(esfArticleId);
		esfBill.setEsfOrderId(esfOrderId);
		esfBill.setBillNumber(billNumber);
		esfBill.setXxxlQty(xxxlQty);
		esfBill.setXxlQty(xxlQty);
		esfBill.setXlQty(xlQty);
		esfBill.setLQty(lQty);
		esfBill.setMQty(mQty);
		esfBill.setSQty(sQty);
		esfBill.setXsQty(xsQty);
		esfBill.setXxsQty(xxsQty);
		esfBill.setOtherQty(otherQty);
		esfBill.setTotalQty(totalQty);

		esfBillPersistence.update(esfBill);

		return esfBill;
	}

	@Override
	public List<ESFBill> findByEA_EO(long esfArticleId, long esfOrderId)
		throws PortalException, SystemException {

		return esfBillPersistence.findByEA_EO(esfArticleId, esfOrderId);
	}

	@Override
	public ESFBill updateESFBill(
		long esfBillId, long esfArticleId, long esfOrderId, String billNumber,
		long xxxlQty, long xxlQty, long xlQty, long lQty, long mQty, long sQty,
		long xsQty, long xxsQty, long otherQty, long totalQty)
		throws PortalException, SystemException {

		ESFBill esfBill = esfBillPersistence.fetchByPrimaryKey(esfBillId);

		esfBill.setEsfArticleId(esfArticleId);
		esfBill.setEsfOrderId(esfOrderId);
		esfBill.setBillNumber(billNumber);
		esfBill.setXxxlQty(xxxlQty);
		esfBill.setXxlQty(xxlQty);
		esfBill.setXlQty(xlQty);
		esfBill.setLQty(lQty);
		esfBill.setMQty(mQty);
		esfBill.setSQty(sQty);
		esfBill.setXsQty(xsQty);
		esfBill.setXxsQty(xxsQty);
		esfBill.setOtherQty(otherQty);
		esfBill.setTotalQty(totalQty);

		esfBillPersistence.update(esfBill);

		return esfBill;
	}
}
