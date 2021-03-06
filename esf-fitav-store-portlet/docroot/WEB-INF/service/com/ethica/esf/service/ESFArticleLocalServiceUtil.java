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

package com.ethica.esf.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFArticle. This utility wraps
 * {@link com.ethica.esf.service.impl.ESFArticleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFArticleLocalService
 * @see com.ethica.esf.service.base.ESFArticleLocalServiceBaseImpl
 * @see com.ethica.esf.service.impl.ESFArticleLocalServiceImpl
 * @generated
 */
public class ESFArticleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ethica.esf.service.impl.ESFArticleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f article to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle the e s f article
	* @return the e s f article that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle addESFArticle(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFArticle(esfArticle);
	}

	/**
	* Creates a new e s f article with the primary key. Does not add the e s f article to the database.
	*
	* @param esfArticleId the primary key for the new e s f article
	* @return the new e s f article
	*/
	public static com.ethica.esf.model.ESFArticle createESFArticle(
		long esfArticleId) {
		return getService().createESFArticle(esfArticleId);
	}

	/**
	* Deletes the e s f article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article that was removed
	* @throws PortalException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle deleteESFArticle(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFArticle(esfArticleId);
	}

	/**
	* Deletes the e s f article from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle the e s f article
	* @return the e s f article that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle deleteESFArticle(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFArticle(esfArticle);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ethica.esf.model.ESFArticle fetchESFArticle(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFArticle(esfArticleId);
	}

	/**
	* Returns the e s f article with the primary key.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article
	* @throws PortalException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle getESFArticle(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticle(esfArticleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f articles
	* @param end the upper bound of the range of e s f articles (not inclusive)
	* @return the range of e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle> getESFArticles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticles(start, end);
	}

	/**
	* Returns the number of e s f articles.
	*
	* @return the number of e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFArticlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticlesCount();
	}

	/**
	* Updates the e s f article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticle the e s f article
	* @return the e s f article that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle updateESFArticle(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFArticle(esfArticle);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.ethica.esf.model.ESFArticle addESFArticle(
		java.lang.String code, java.lang.String name,
		java.lang.String description, long xxxlQty, long xxlQty, long xlQty,
		long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, double price, double tax, double sale,
		long esfArticleTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFArticle(code, name, description, xxxlQty, xxlQty,
			xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty, price, tax, sale,
			esfArticleTypeId, serviceContext);
	}

	public static com.ethica.esf.model.ESFArticle checkCode(
		java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkCode(code, serviceContext);
	}

	public static com.ethica.esf.model.ESFArticle decrementESFArticleQ(
		long esfArticleId, long xxxlQty, long xxlQty, long xlQty, long lQty,
		long mQty, long sQty, long xsQty, long xxsQty, long otherQty)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .decrementESFArticleQ(esfArticleId, xxxlQty, xxlQty, xlQty,
			lQty, mQty, sQty, xsQty, xxsQty, otherQty);
	}

	public static java.lang.String getDescriptionType(long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDescriptionType(esfArticleTypeId);
	}

	public static long getElements(com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getElements(esfArticle);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link it.ethica.esf.service.ESFArticleLocalServiceUtil} to access the e
	* s f article local service.
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle> getESFArticleByArticleTypeId(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticleByArticleTypeId(esfArticleTypeId);
	}

	/**
	* Ricerca tutti gli oggetti ESFArticle sulla base del codice dell'articolo,
	* del nome del tipo articolo.
	*
	* @param code
	il codice dell'articolo
	* @param name
	il nome dell'articolo
	* @param esfArticleTypeId
	l'identificativo del tipo articolo
	* @return List<ESFArticle>
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle> getESFArticleByLikeC_N_T(
		java.lang.String code, java.lang.String name, long esfArticleTypeId) {
		return getService()
				   .getESFArticleByLikeC_N_T(code, name, esfArticleTypeId);
	}

	/**
	* Ricerca tutti gli oggetti ESFArticle sulla base del codice dell'articolo,
	* del nome del tipo articolo.
	*
	* * * I parametri di <b>start</b> e <b>end</b> definiscono il range di
	* oggetti da restituire.
	*
	* @param code
	il codice dell'articolo
	* @param name
	il nome dell'articolo
	* @param esfArticleTypeId
	l'identificativo del tipo articolo
	* @return List<ESFArticle>
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle> getESFArticleByLikeC_N_T(
		java.lang.String code, java.lang.String name, long esfArticleTypeId,
		int start, int end) {
		return getService()
				   .getESFArticleByLikeC_N_T(code, name, esfArticleTypeId,
			start, end);
	}

	public static java.util.List<com.ethica.esf.model.ESFArticle> getESFArticles()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFArticles();
	}

	public static com.ethica.esf.model.ESFArticle updateESFArticle(
		long esfArticleId, java.lang.String code, java.lang.String name,
		java.lang.String description, long xxxlQty, long xxlQty, long xlQty,
		long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, double price, double tax, double sale,
		long esfArticleTypeId,
		com.liferay.portal.service.ServiceContext serviceContext, boolean editS)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFArticle(esfArticleId, code, name, description,
			xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty,
			price, tax, sale, esfArticleTypeId, serviceContext, editS);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFArticleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFArticleLocalService.class.getName());

			if (invokableLocalService instanceof ESFArticleLocalService) {
				_service = (ESFArticleLocalService)invokableLocalService;
			}
			else {
				_service = new ESFArticleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFArticleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFArticleLocalService service) {
	}

	private static ESFArticleLocalService _service;
}