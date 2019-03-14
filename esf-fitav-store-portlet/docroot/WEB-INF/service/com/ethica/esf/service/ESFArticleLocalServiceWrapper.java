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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFArticleLocalService}.
 *
 * @author Ethica
 * @see ESFArticleLocalService
 * @generated
 */
public class ESFArticleLocalServiceWrapper implements ESFArticleLocalService,
	ServiceWrapper<ESFArticleLocalService> {
	public ESFArticleLocalServiceWrapper(
		ESFArticleLocalService esfArticleLocalService) {
		_esfArticleLocalService = esfArticleLocalService;
	}

	/**
	* Adds the e s f article to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle the e s f article
	* @return the e s f article that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle addESFArticle(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.addESFArticle(esfArticle);
	}

	/**
	* Creates a new e s f article with the primary key. Does not add the e s f article to the database.
	*
	* @param esfArticleId the primary key for the new e s f article
	* @return the new e s f article
	*/
	@Override
	public com.ethica.esf.model.ESFArticle createESFArticle(long esfArticleId) {
		return _esfArticleLocalService.createESFArticle(esfArticleId);
	}

	/**
	* Deletes the e s f article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article that was removed
	* @throws PortalException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle deleteESFArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.deleteESFArticle(esfArticleId);
	}

	/**
	* Deletes the e s f article from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle the e s f article
	* @return the e s f article that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle deleteESFArticle(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.deleteESFArticle(esfArticle);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfArticleLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ethica.esf.model.ESFArticle fetchESFArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.fetchESFArticle(esfArticleId);
	}

	/**
	* Returns the e s f article with the primary key.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article
	* @throws PortalException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle getESFArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getESFArticle(esfArticleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle> getESFArticles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getESFArticles(start, end);
	}

	/**
	* Returns the number of e s f articles.
	*
	* @return the number of e s f articles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFArticlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getESFArticlesCount();
	}

	/**
	* Updates the e s f article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticle the e s f article
	* @return the e s f article that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticle updateESFArticle(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.updateESFArticle(esfArticle);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfArticleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfArticleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfArticleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ethica.esf.model.ESFArticle addESFArticle(
		java.lang.String code, java.lang.String name,
		java.lang.String description, long xxxlQty, long xxlQty, long xlQty,
		long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, double price, double tax, double sale,
		long esfArticleTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.addESFArticle(code, name, description,
			xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty,
			price, tax, sale, esfArticleTypeId, serviceContext);
	}

	@Override
	public com.ethica.esf.model.ESFArticle checkCode(java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.checkCode(code, serviceContext);
	}

	@Override
	public com.ethica.esf.model.ESFArticle decrementESFArticleQ(
		long esfArticleId, long xxxlQty, long xxlQty, long xlQty, long lQty,
		long mQty, long sQty, long xsQty, long xxsQty, long otherQty)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.decrementESFArticleQ(esfArticleId,
			xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty);
	}

	@Override
	public java.lang.String getDescriptionType(long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getDescriptionType(esfArticleTypeId);
	}

	@Override
	public long getElements(com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getElements(esfArticle);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link it.ethica.esf.service.ESFArticleLocalServiceUtil} to access the e
	* s f article local service.
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle> getESFArticleByArticleTypeId(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getESFArticleByArticleTypeId(esfArticleTypeId);
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
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle> getESFArticleByLikeC_N_T(
		java.lang.String code, java.lang.String name, long esfArticleTypeId) {
		return _esfArticleLocalService.getESFArticleByLikeC_N_T(code, name,
			esfArticleTypeId);
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
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle> getESFArticleByLikeC_N_T(
		java.lang.String code, java.lang.String name, long esfArticleTypeId,
		int start, int end) {
		return _esfArticleLocalService.getESFArticleByLikeC_N_T(code, name,
			esfArticleTypeId, start, end);
	}

	@Override
	public java.util.List<com.ethica.esf.model.ESFArticle> getESFArticles()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.getESFArticles();
	}

	@Override
	public com.ethica.esf.model.ESFArticle updateESFArticle(long esfArticleId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, long xxxlQty, long xxlQty, long xlQty,
		long lQty, long mQty, long sQty, long xsQty, long xxsQty,
		long otherQty, double price, double tax, double sale,
		long esfArticleTypeId,
		com.liferay.portal.service.ServiceContext serviceContext, boolean editS)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleLocalService.updateESFArticle(esfArticleId, code,
			name, description, xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty,
			xxsQty, otherQty, price, tax, sale, esfArticleTypeId,
			serviceContext, editS);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFArticleLocalService getWrappedESFArticleLocalService() {
		return _esfArticleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFArticleLocalService(
		ESFArticleLocalService esfArticleLocalService) {
		_esfArticleLocalService = esfArticleLocalService;
	}

	@Override
	public ESFArticleLocalService getWrappedService() {
		return _esfArticleLocalService;
	}

	@Override
	public void setWrappedService(ESFArticleLocalService esfArticleLocalService) {
		_esfArticleLocalService = esfArticleLocalService;
	}

	private ESFArticleLocalService _esfArticleLocalService;
}