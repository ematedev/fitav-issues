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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFDocument. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFDocumentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFDocumentLocalService
 * @see it.ethica.esf.service.base.ESFDocumentLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFDocumentLocalServiceImpl
 * @generated
 */
public class ESFDocumentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFDocumentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f document to the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocument the e s f document
	* @return the e s f document that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument addESFDocument(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFDocument(esfDocument);
	}

	/**
	* Creates a new e s f document with the primary key. Does not add the e s f document to the database.
	*
	* @param esfDocumentId the primary key for the new e s f document
	* @return the new e s f document
	*/
	public static it.ethica.esf.model.ESFDocument createESFDocument(
		long esfDocumentId) {
		return getService().createESFDocument(esfDocumentId);
	}

	/**
	* Deletes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document that was removed
	* @throws PortalException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument deleteESFDocument(
		long esfDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFDocument(esfDocumentId);
	}

	/**
	* Deletes the e s f document from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocument the e s f document
	* @return the e s f document that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument deleteESFDocument(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFDocument(esfDocument);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFDocument fetchESFDocument(
		long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFDocument(esfDocumentId);
	}

	/**
	* Returns the e s f document with the matching UUID and company.
	*
	* @param uuid the e s f document's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchESFDocumentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFDocumentByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f document matching the UUID and group.
	*
	* @param uuid the e s f document's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchESFDocumentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFDocumentByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f document with the primary key.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document
	* @throws PortalException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument getESFDocument(
		long esfDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDocument(esfDocumentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static it.ethica.esf.model.ESFDocument getESFDocumentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDocumentByUuidAndCompanyId(uuid, companyId);
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
	public static it.ethica.esf.model.ESFDocument getESFDocumentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDocumentByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<it.ethica.esf.model.ESFDocument> getESFDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDocuments(start, end);
	}

	/**
	* Returns the number of e s f documents.
	*
	* @return the number of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDocumentsCount();
	}

	/**
	* Updates the e s f document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfDocument the e s f document
	* @return the e s f document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument updateESFDocument(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFDocument(esfDocument);
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

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByIssuer(issuer);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByIssuer(issuer, start, end);
	}

	public static int countByIssuer(java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByIssuer(issuer);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLocationReference(locationReference);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByLocationReference(locationReference, start, end);
	}

	public static int countByLocationReference(
		java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByLocationReference(locationReference);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByName(name);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByName(name, start, end);
	}

	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByName(name);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByNumber(number);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByNumber(number, start, end);
	}

	public static int countByNumber(long number)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByNumber(number);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByO_O(ownerId, ownerType);
	}

	public static java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByO_O(ownerId, ownerType, start, end);
	}

	public static int countByO_O(long ownerId, java.lang.String ownerType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByO_O(ownerId, ownerType);
	}

	public static it.ethica.esf.model.ESFDocument addESFDocument(long userId,
		long ownerId, java.lang.String ownerType, java.lang.String type,
		java.lang.String name, long number, java.util.Date releaseDate,
		java.util.Date expireDate, java.lang.String issuer,
		java.lang.String contents, java.lang.String locationReference,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFDocument(userId, ownerId, ownerType, type, name,
			number, releaseDate, expireDate, issuer, contents,
			locationReference, serviceContext);
	}

	public static it.ethica.esf.model.ESFDocument deleteESFDocument(
		long esfDocumentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFDocument(esfDocumentId, serviceContext);
	}

	public static it.ethica.esf.model.ESFDocument updateESFDocument(
		long userId, long esfDocumentId, long ownerId,
		java.lang.String ownerType, java.lang.String type,
		java.lang.String name, long number, java.util.Date releaseDate,
		java.util.Date expireDate, java.lang.String issuer,
		java.lang.String contents, java.lang.String locationReference,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFDocument(userId, esfDocumentId, ownerId,
			ownerType, type, name, number, releaseDate, expireDate, issuer,
			contents, locationReference, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFDocumentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFDocumentLocalService.class.getName());

			if (invokableLocalService instanceof ESFDocumentLocalService) {
				_service = (ESFDocumentLocalService)invokableLocalService;
			}
			else {
				_service = new ESFDocumentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFDocumentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFDocumentLocalService service) {
	}

	private static ESFDocumentLocalService _service;
}