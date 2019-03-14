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

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.service.ESFArticleLocalServiceUtil;
import com.ethica.esf.service.ESFArticleTypeLocalServiceUtil;
import com.ethica.esf.service.base.ESFArticleLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the e s f article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFArticleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFArticleLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFArticleLocalServiceUtil
 */
public class ESFArticleLocalServiceImpl extends ESFArticleLocalServiceBaseImpl {
	public ESFArticle addESFArticle(String code, String name,
			String description,

			long xxxlQty, long xxlQty, long xlQty, long lQty, long mQty,
			long sQty, long xsQty, long xxsQty, long otherQty, double price,
			double tax, double sale, long esfArticleTypeId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

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
		esfArticle.setPrice(price);
		esfArticle.setTax(tax);
		esfArticle.setEsfArticleTypeId(esfArticleTypeId);
		esfArticle.setSale(sale);

		esfArticle.setExpandoBridgeAttributes(serviceContext);

		esfArticlePersistence.update(esfArticle);

		return esfArticle;
	}

	public ESFArticle checkCode(String code, ServiceContext serviceContext)
			throws PortalException, SystemException {

		if (Validator.isNotNull(code) && !Validator.isBlank(code)) {
			return esfArticlePersistence.fetchByArticleCode(code);
		}

		return null;
	}

	public ESFArticle decrementESFArticleQ(long esfArticleId, long xxxlQty,
			long xxlQty, long xlQty, long lQty, long mQty, long sQty,
			long xsQty, long xxsQty, long otherQty) throws PortalException,
			SystemException {

		ESFArticle esfArticle = ESFArticleLocalServiceUtil
				.getESFArticle(esfArticleId);
		long newXxxlqty = (esfArticle.getXxxlQty() - xxxlQty);
		long newXxlqty = (esfArticle.getXxlQty() - xxlQty);
		long newXlqty = (esfArticle.getXlQty() - xlQty);
		long newLqty = (esfArticle.getLQty() - lQty);
		long newMqty = (esfArticle.getMQty() - mQty);
		long newSqty = (esfArticle.getSQty() - sQty);
		long newXsqty = (esfArticle.getXsQty() - xsQty);
		long newXxsqty = (esfArticle.getXxsQty() - xxsQty);
		long newOtherqty = (esfArticle.getOtherQty() - otherQty);

		esfArticle.setXxxlQty(newXxxlqty);
		esfArticle.setXxlQty(newXxlqty);
		esfArticle.setXlQty(newXlqty);
		esfArticle.setLQty(newLqty);
		esfArticle.setMQty(newMqty);
		esfArticle.setSQty(newSqty);
		esfArticle.setXsQty(newXsqty);
		esfArticle.setXxsQty(newXxsqty);
		esfArticle.setOtherQty(newOtherqty);

		esfArticlePersistence.update(esfArticle);

		return esfArticle;
	}

	public String getDescriptionType(long esfArticleTypeId)
			throws SystemException {

		ESFArticleType esfArticleType = null;
		try {
			esfArticleType = ESFArticleTypeLocalServiceUtil
					.getESFArticleType(esfArticleTypeId);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return esfArticleType.getDescription();
	}

	public long getElements(ESFArticle esfArticle) throws SystemException {
		long sum = (esfArticle.getXxxlQty() + esfArticle.getXxlQty()
				+ esfArticle.getXlQty() + esfArticle.getLQty()
				+ esfArticle.getMQty() + esfArticle.getSQty()
				+ esfArticle.getXsQty() + esfArticle.getXxsQty() + esfArticle
				.getOtherQty());
		return sum;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFArticleLocalServiceUtil} to access the e
	 * s f article local service.
	 */

	public List<ESFArticle> getESFArticleByArticleTypeId(long esfArticleTypeId)
			throws SystemException {

		return esfArticlePersistence.findByArticleType(esfArticleTypeId);
	}

	/**
	 * Ricerca tutti gli oggetti ESFArticle sulla base del codice dell'articolo,
	 * del nome del tipo articolo.
	 *
	 *
	 * @param code
	 *            il codice dell'articolo
	 * @param name
	 *            il nome dell'articolo
	 * @param esfArticleTypeId
	 *            l'identificativo del tipo articolo
	 * @return List<ESFArticle>
	 */
	public List<ESFArticle> getESFArticleByLikeC_N_T(String code, String name,
			long esfArticleTypeId) {

		List<ESFArticle> esfArticles = new ArrayList<ESFArticle>();
		Criterion crit = null;
		try {
			DynamicQuery articleQuery = DynamicQueryFactoryUtil.forClass(
					ESFArticle.class, "articleQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfArticleTypeId != 0) {
				crit = PropertyFactoryUtil.forName("articleQuery.name").like(
						StringPool.PERCENT + name + StringPool.PERCENT);
				crit = RestrictionsFactoryUtil.and(
						crit,
						PropertyFactoryUtil.forName(
								"articleQuery.esfArticleTypeId").eq(
								esfArticleTypeId));
				articleQuery.add(crit);
			} else {
				articleQuery.add(PropertyFactoryUtil.forName(
						"articleQuery.name").like(
						StringPool.PERCENT + name + StringPool.PERCENT));
			}

			articleQuery.add(PropertyFactoryUtil.forName("articleQuery.code")
					.like(StringPool.PERCENT + code + StringPool.PERCENT));

			// articleQuery.add(PropertyFactoryUtil.forName("articleQuery.code").like(
			// StringPool.PERCENT + code + StringPool.PERCENT));
			// articleQuery.add(PropertyFactoryUtil.forName("articleQuery.esfArticleKindId").eq(
			// esfArticleKindId));

			esfArticles = ESFArticleLocalServiceUtil.dynamicQuery(articleQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return esfArticles;
	}

	/**
	 * Ricerca tutti gli oggetti ESFArticle sulla base del codice dell'articolo,
	 * del nome del tipo articolo.
	 *
	 * * * I parametri di <b>start</b> e <b>end</b> definiscono il range di
	 * oggetti da restituire.
	 * 
	 * @param code
	 *            il codice dell'articolo
	 * @param name
	 *            il nome dell'articolo
	 * @param esfArticleTypeId
	 *            l'identificativo del tipo articolo
	 * @return List<ESFArticle>
	 */

	public List<ESFArticle> getESFArticleByLikeC_N_T(String code, String name,
			long esfArticleTypeId, int start, int end) {

		List<ESFArticle> esfArticles = new ArrayList<ESFArticle>();
		Criterion crit = null;
		try {
			DynamicQuery articleQuery = DynamicQueryFactoryUtil.forClass(
					ESFArticle.class, "articleQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfArticleTypeId != 0) {
				crit = PropertyFactoryUtil.forName("articleQuery.name").like(
						StringPool.PERCENT + name + StringPool.PERCENT);
				crit = RestrictionsFactoryUtil.and(
						crit,
						PropertyFactoryUtil.forName(
								"articleQuery.esfArticleTypeId").eq(
								esfArticleTypeId));
				articleQuery.add(crit);
			} else {
				articleQuery.add(PropertyFactoryUtil.forName(
						"articleQuery.name").like(
						StringPool.PERCENT + name + StringPool.PERCENT));
			}

			articleQuery.add(PropertyFactoryUtil.forName("articleQuery.code")
					.like(StringPool.PERCENT + code + StringPool.PERCENT));

			// articleQuery.add(PropertyFactoryUtil.forName("articleQuery.code").like(
			// StringPool.PERCENT + code + StringPool.PERCENT));
			// articleQuery.add(PropertyFactoryUtil.forName("articleQuery.esfArticleKindId").eq(
			// esfArticleKindId));

			esfArticles = ESFArticleLocalServiceUtil.dynamicQuery(articleQuery,
					start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return esfArticles;
	}

	public List<ESFArticle> getESFArticles() throws SystemException {

		return esfArticlePersistence.findAll();
	}

	public ESFArticle updateESFArticle(long esfArticleId, String code,
			String name, String description, long xxxlQty, long xxlQty,
			long xlQty, long lQty, long mQty, long sQty, long xsQty,
			long xxsQty, long otherQty, double price, double tax, double sale,
			long esfArticleTypeId, ServiceContext serviceContext, boolean editS)
			throws PortalException, SystemException {

		ESFArticle esfArticle = ESFArticleLocalServiceUtil
				.getESFArticle(esfArticleId);
		esfArticle.setCode(code);
		esfArticle.setName(name);
		esfArticle.setDescription(description);

		if (!editS) {
			esfArticle.setXxxlQty(xxxlQty);
			esfArticle.setXxlQty(xxlQty);
			esfArticle.setXlQty(xlQty);
			esfArticle.setLQty(lQty);
			esfArticle.setMQty(mQty);
			esfArticle.setSQty(sQty);
			esfArticle.setXsQty(xsQty);
			esfArticle.setXxsQty(xxsQty);
			esfArticle.setOtherQty(otherQty);
			esfArticle.setPrice(price);
			esfArticle.setTax(tax);
			esfArticle.setEsfArticleTypeId(esfArticleTypeId);
			esfArticle.setSale(sale);
		}

		esfArticle.setExpandoBridgeAttributes(serviceContext);

		esfArticlePersistence.update(esfArticle);

		return esfArticle;
	}

}