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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.ESFArticle_ESFOrder;
import com.ethica.esf.model.ESFBill;
import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.service.base.ESFOrderLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppHelperLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

/**
 * The implementation of the e s f order local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFOrderLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFOrderLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFOrderLocalServiceUtil
 */
public class ESFOrderLocalServiceImpl extends ESFOrderLocalServiceBaseImpl {

	@Override
	public ESFOrder addESFOrder(
		String code, String name, String description, Date date, String note,
		String protocolCode, String attachment, int state, long esfStockistId)
		throws PortalException, SystemException {

		long esfOrderId = counterLocalService.increment();

		ESFOrder esfOrder = esfOrderPersistence.create(esfOrderId);

		esfOrder.setCode(code);
		esfOrder.setName(name);
		esfOrder.setDescription(description);
		esfOrder.setDate(date);
		esfOrder.setNote(note);
		esfOrder.setProtocolCode(protocolCode);
		esfOrder.setAttachment(attachment);
		esfOrder.setState(state);
		esfOrder.setEsfStockistId(esfStockistId);

		esfOrderPersistence.update(esfOrder);

		return esfOrder;
	}

	@Override
	public ESFOrder deleteESFOrder(
		long userId, long groupId, long folderId, long esfOrderId)
		throws PortalException, SystemException {

		List<ESFArticle_ESFOrder> esfArticle_ESFOrders =
			esfArticle_ESFOrderPersistence.findByESFOrderId(esfOrderId);

		for (ESFArticle_ESFOrder esfArticle_ESFOrder : esfArticle_ESFOrders) {
			List<ESFBill> esfBills =
				esfBillPersistence.findByEA_EO(
					esfArticle_ESFOrder.getEsfArticleId(), esfOrderId);

			for (ESFBill esfBill : esfBills) {
				esfBillLocalService.deleteESFBill(esfBill);
			}
			esfArticle_ESFOrderLocalService.deleteESFArticle_ESFOrder(esfArticle_ESFOrder);
		}
		ESFOrder esfOrder = esfOrderPersistence.fetchByPrimaryKey(esfOrderId);
		String fileName = StringPool.BLANK;
		if (Validator.isNotNull(esfOrder) &&
			Validator.isNotNull(esfOrder.getAttachment())) {
			fileName = esfOrder.getAttachment();
			try {
				FileEntry fileEntry =
					DLAppLocalServiceUtil.getFileEntry(
						groupId, folderId, fileName);
				DLAppHelperLocalServiceUtil.moveFileEntryToTrash(
					userId, fileEntry);
				DLAppHelperLocalServiceUtil.deleteFileEntry(fileEntry);
			}
			catch (Exception ex) {
				throw new SystemException();
			}
		}
		return esfOrderLocalService.deleteESFOrder(esfOrder);
	}

	@Override
	public ESFOrder deleteESFOrder(long esfOrderId)
		throws PortalException, SystemException {

		List<ESFArticle_ESFOrder> esfArticle_ESFOrders =
			esfArticle_ESFOrderPersistence.findByESFOrderId(esfOrderId);

		for (ESFArticle_ESFOrder esfArticle_ESFOrder : esfArticle_ESFOrders) {
			List<ESFBill> esfBills =
				esfBillPersistence.findByEA_EO(
					esfArticle_ESFOrder.getEsfArticleId(), esfOrderId);

			for (ESFBill esfBill : esfBills) {
				esfBillLocalService.deleteESFBill(esfBill);
			}
			esfArticle_ESFOrderLocalService.deleteESFArticle_ESFOrder(esfArticle_ESFOrder);
		}
		ESFOrder esfOrder = esfOrderPersistence.fetchByPrimaryKey(esfOrderId);
		return esfOrderLocalService.deleteESFOrder(esfOrder);
	}

	@Override
	public ESFOrder updateESFOrder(
		long esfOrderId, String code, String name, String description,
		Date date, String note, String protocolCode, String attachment,
		int state, long esfStockistId)
		throws PortalException, SystemException {

		ESFOrder esfOrder = getESFOrder(esfOrderId);

		esfOrder.setCode(code);
		esfOrder.setName(name);
		esfOrder.setDescription(description);
		esfOrder.setDate(date);
		esfOrder.setNote(note);
		esfOrder.setProtocolCode(protocolCode);
		esfOrder.setAttachment(attachment);
		esfOrder.setState(state);
		esfOrder.setEsfStockistId(esfStockistId);

		esfOrderPersistence.update(esfOrder);

		return esfOrder;
	}

	@Override
	public List<ESFArticle> getAvailableArticles(long esfOrderId)
		throws PortalException, SystemException {

		List<ESFArticle> articles =
			esfArticleLocalService.getEnabledESFArticles();
		long[] esfArticleEsfOrderIds =
			esfArticle_ESFOrderLocalService.getEsfArticleIdByEsfOrderId(esfOrderId);
		if (ArrayUtil.isEmpty(esfArticleEsfOrderIds)) {
			return articles;
		}
		List<ESFArticle> results = new ArrayList<ESFArticle>();
		long temp;
		for (ESFArticle article : articles) {
			temp = article.getEsfArticleId();
			if (!ArrayUtil.contains(esfArticleEsfOrderIds, temp)) {
				results.add(esfArticleLocalService.getESFArticle(temp));
			}
		}

		return results;
	}

	@Override
	public List<ESFOrder> getESFOrdersByESFStockistId(long esfStockistId)
		throws PortalException, SystemException {

		return esfOrderPersistence.findByESFStockistId(esfStockistId);
	}
}
