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

import com.ethica.esf.model.ESFArticleDelivered;
import com.ethica.esf.service.base.ESFArticleDeliveredLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;

import com.ethica.esf.service.base.ESFArticleDeliveredLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the e s f article delivered local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ethica.esf.service.ESFArticleDeliveredLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFArticleDeliveredLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFArticleDeliveredLocalServiceUtil
 */
public class ESFArticleDeliveredLocalServiceImpl extends
ESFArticleDeliveredLocalServiceBaseImpl {
public ESFArticleDelivered addESFArticleDelivered(String description,
	Date dateD, long esfArticleId, long esfShooterId, long xxxlQty,
	long xxlQty, long xlQty, long lQty, long mQty, long sQty,
	long xsQty, long xxsQty, long otherQty,
	ServiceContext serviceContext) throws PortalException,
	SystemException {

long esfArticleDeliveredId = counterLocalService.increment();
ESFArticleDelivered esfArticleDelivered = esfArticleDeliveredPersistence
		.create(esfArticleDeliveredId);
esfArticleDelivered.setDescription(description);
esfArticleDelivered.setData(dateD);
esfArticleDelivered.setEsfArticleId(esfArticleId);
esfArticleDelivered.setEsfShooterId(esfShooterId);
esfArticleDelivered.setXxxlQty(xxxlQty);
esfArticleDelivered.setXxlQty(xxlQty);
esfArticleDelivered.setXlQty(xlQty);
esfArticleDelivered.setLQty(lQty);
esfArticleDelivered.setMQty(mQty);
esfArticleDelivered.setSQty(sQty);
esfArticleDelivered.setXsQty(xsQty);
esfArticleDelivered.setXxsQty(xxsQty);
esfArticleDelivered.setOtherQty(otherQty);

esfArticleDelivered.setExpandoBridgeAttributes(serviceContext);

esfArticleDeliveredPersistence.update(esfArticleDelivered);

return esfArticleDelivered;
}

/**
* NOTE FOR DEVELOPERS:
*
* Never reference this interface directly. Always use
* {@link it.ethica.esf.service.ESFArticleDeliveredLocalServiceUtil} to
* access the e s f article delivered local service.
*/
public List<ESFArticleDelivered> getESFArticleDeliveredByArticleId(
	long esfArticleId) throws SystemException {

return esfArticleDeliveredPersistence.findByEsfArticleId(esfArticleId);
}

}