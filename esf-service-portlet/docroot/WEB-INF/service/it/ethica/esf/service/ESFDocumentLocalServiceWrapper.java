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

package it.ethica.esf.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFDocumentLocalService}.
 *
 * @author Ethica
 * @see ESFDocumentLocalService
 * @generated
 */
public class ESFDocumentLocalServiceWrapper implements ESFDocumentLocalService,
	ServiceWrapper<ESFDocumentLocalService> {
	public ESFDocumentLocalServiceWrapper(
		ESFDocumentLocalService esfDocumentLocalService) {
		_esfDocumentLocalService = esfDocumentLocalService;
	}

	/**
	* Adds the e s f document to the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocument the e s f document
	* @return the e s f document that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument addESFDocument(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.addESFDocument(esfDocument);
	}

	/**
	* Creates a new e s f document with the primary key. Does not add the e s f document to the database.
	*
	* @param esfDocumentId the primary key for the new e s f document
	* @return the new e s f document
	*/
	@Override
	public it.ethica.esf.model.ESFDocument createESFDocument(long esfDocumentId) {
		return _esfDocumentLocalService.createESFDocument(esfDocumentId);
	}

	/**
	* Deletes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document that was removed
	* @throws PortalException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument deleteESFDocument(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.deleteESFDocument(esfDocumentId);
	}

	/**
	* Deletes the e s f document from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocument the e s f document
	* @return the e s f document that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument deleteESFDocument(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.deleteESFDocument(esfDocument);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfDocumentLocalService.dynamicQuery();
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
		return _esfDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfDocumentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfDocumentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfDocumentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfDocumentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFDocument fetchESFDocument(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.fetchESFDocument(esfDocumentId);
	}

	/**
	* Returns the e s f document with the matching UUID and company.
	*
	* @param uuid the e s f document's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument fetchESFDocumentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.fetchESFDocumentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f document matching the UUID and group.
	*
	* @param uuid the e s f document's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument fetchESFDocumentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.fetchESFDocumentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f document with the primary key.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document
	* @throws PortalException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument getESFDocument(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.getESFDocument(esfDocumentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f document with the matching UUID and company.
	*
	* @param uuid the e s f document's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f document
	* @throws PortalException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument getESFDocumentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.getESFDocumentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f document matching the UUID and group.
	*
	* @param uuid the e s f document's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f document
	* @throws PortalException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument getESFDocumentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.getESFDocumentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> getESFDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.getESFDocuments(start, end);
	}

	/**
	* Returns the number of e s f documents.
	*
	* @return the number of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.getESFDocumentsCount();
	}

	/**
	* Updates the e s f document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfDocument the e s f document
	* @return the e s f document that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDocument updateESFDocument(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.updateESFDocument(esfDocument);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfDocumentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfDocumentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfDocumentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByIssuer(issuer);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByIssuer(issuer, start, end);
	}

	@Override
	public int countByIssuer(java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.countByIssuer(issuer);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByLocationReference(locationReference);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByLocationReference(locationReference,
			start, end);
	}

	@Override
	public int countByLocationReference(java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.countByLocationReference(locationReference);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByName(name);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByName(name, start, end);
	}

	@Override
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.countByName(name);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByNumber(number);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByNumber(number, start, end);
	}

	@Override
	public int countByNumber(long number)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.countByNumber(number);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByO_O(ownerId, ownerType);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.findByO_O(ownerId, ownerType, start, end);
	}

	@Override
	public int countByO_O(long ownerId, java.lang.String ownerType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.countByO_O(ownerId, ownerType);
	}

	@Override
	public it.ethica.esf.model.ESFDocument addESFDocument(long userId,
		long ownerId, java.lang.String ownerType, java.lang.String type,
		java.lang.String name, long number, java.util.Date releaseDate,
		java.util.Date expireDate, java.lang.String issuer,
		java.lang.String contents, java.lang.String locationReference,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.addESFDocument(userId, ownerId,
			ownerType, type, name, number, releaseDate, expireDate, issuer,
			contents, locationReference, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFDocument deleteESFDocument(
		long esfDocumentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.deleteESFDocument(esfDocumentId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFDocument updateESFDocument(long userId,
		long esfDocumentId, long ownerId, java.lang.String ownerType,
		java.lang.String type, java.lang.String name, long number,
		java.util.Date releaseDate, java.util.Date expireDate,
		java.lang.String issuer, java.lang.String contents,
		java.lang.String locationReference,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentLocalService.updateESFDocument(userId,
			esfDocumentId, ownerId, ownerType, type, name, number, releaseDate,
			expireDate, issuer, contents, locationReference, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFDocumentLocalService getWrappedESFDocumentLocalService() {
		return _esfDocumentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFDocumentLocalService(
		ESFDocumentLocalService esfDocumentLocalService) {
		_esfDocumentLocalService = esfDocumentLocalService;
	}

	@Override
	public ESFDocumentLocalService getWrappedService() {
		return _esfDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		ESFDocumentLocalService esfDocumentLocalService) {
		_esfDocumentLocalService = esfDocumentLocalService;
	}

	private ESFDocumentLocalService _esfDocumentLocalService;
}