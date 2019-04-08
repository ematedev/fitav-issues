/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
 * Provides the local service utility for ESFUserCategory. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFUserCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFUserCategoryLocalService
 * @see it.ethica.esf.service.base.ESFUserCategoryLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFUserCategoryLocalServiceImpl
 * @generated
 */
public class ESFUserCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFUserCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f user category to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserCategory the e s f user category
	* @return the e s f user category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory addESFUserCategory(
		it.ethica.esf.model.ESFUserCategory esfUserCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFUserCategory(esfUserCategory);
	}

	/**
	* Creates a new e s f user category with the primary key. Does not add the e s f user category to the database.
	*
	* @param esfUserCategoryId the primary key for the new e s f user category
	* @return the new e s f user category
	*/
	public static it.ethica.esf.model.ESFUserCategory createESFUserCategory(
		long esfUserCategoryId) {
		return getService().createESFUserCategory(esfUserCategoryId);
	}

	/**
	* Deletes the e s f user category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category that was removed
	* @throws PortalException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory deleteESFUserCategory(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserCategory(esfUserCategoryId);
	}

	/**
	* Deletes the e s f user category from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserCategory the e s f user category
	* @return the e s f user category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory deleteESFUserCategory(
		it.ethica.esf.model.ESFUserCategory esfUserCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserCategory(esfUserCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFUserCategory fetchESFUserCategory(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUserCategory(esfUserCategoryId);
	}

	/**
	* Returns the e s f user category with the primary key.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category
	* @throws PortalException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory getESFUserCategory(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserCategory(esfUserCategoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f user categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user categories
	* @param end the upper bound of the range of e s f user categories (not inclusive)
	* @return the range of e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> getESFUserCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserCategories(start, end);
	}

	/**
	* Returns the number of e s f user categories.
	*
	* @return the number of e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFUserCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserCategoriesCount();
	}

	/**
	* Updates the e s f user category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUserCategory the e s f user category
	* @return the e s f user category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory updateESFUserCategory(
		it.ethica.esf.model.ESFUserCategory esfUserCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFUserCategory(esfUserCategory);
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

	public static java.util.List<it.ethica.esf.model.ESFUserCategory> allESFUserCategoryByActualYear(
		int year) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().allESFUserCategoryByActualYear(year);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserCategory> allESFUserCategoryByIdUtente(
		long idUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().allESFUserCategoryByIdUtente(idUtente);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findUserFO(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService().findUserFO(esfSportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findUserByS_ED(
		long esfSportTypeId, int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService().findUserByS_ED(esfSportTypeId, year);
	}

	public static it.ethica.esf.model.ESFUserCategory fetchUserByS_ED_UI(
		long userId, long esfSportTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .fetchUserByS_ED_UI(userId, esfSportTypeId, serviceContext);
	}

	public static it.ethica.esf.model.ESFUserCategory addEsfUserCategory(
		long userId, long esfUserId, long esfCategoryId, long esfSportTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEsfUserCategory(userId, esfUserId, esfCategoryId,
			esfSportTypeId, serviceContext);
	}

	public static it.ethica.esf.model.ESFUserCategory updateEsfUserCategory(
		long userId, long esfUserCategoryId, long esfUserId,
		long esfCategoryId, long esfSportTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getService()
				   .updateEsfUserCategory(userId, esfUserCategoryId, esfUserId,
			esfCategoryId, esfSportTypeId, serviceContext);
	}

	public static it.ethica.esf.model.ESFUserCategory addEsfUserCategory(
		long userId, long nextCategory, long esfSportTypeId, int year,
		com.liferay.portal.model.User user, long groupId, long companyId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .addEsfUserCategory(userId, nextCategory, esfSportTypeId,
			year, user, groupId, companyId, serviceContext);
	}

	public static it.ethica.esf.model.ESFUserCategory findByU_C_S(
		long esfUserId, long esfCategoryId, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getService().findByU_C_S(esfUserId, esfCategoryId, esfSportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findYouthNotPromoved(
		int year) {
		return getService().findYouthNotPromoved(year);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFUserCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFUserCategoryLocalService.class.getName());

			if (invokableLocalService instanceof ESFUserCategoryLocalService) {
				_service = (ESFUserCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new ESFUserCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFUserCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFUserCategoryLocalService service) {
	}

	private static ESFUserCategoryLocalService _service;
}