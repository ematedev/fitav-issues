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

package it.ethica.esf.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFJob;

/**
 * The persistence interface for the e s f job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFJobPersistenceImpl
 * @see ESFJobUtil
 * @generated
 */
public interface ESFJobPersistence extends BasePersistence<ESFJob> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFJobUtil} to access the e s f job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e s f job in the entity cache if it is enabled.
	*
	* @param esfJob the e s f job
	*/
	public void cacheResult(it.ethica.esf.model.ESFJob esfJob);

	/**
	* Caches the e s f jobs in the entity cache if it is enabled.
	*
	* @param esfJobs the e s f jobs
	*/
	public void cacheResult(java.util.List<it.ethica.esf.model.ESFJob> esfJobs);

	/**
	* Creates a new e s f job with the primary key. Does not add the e s f job to the database.
	*
	* @param esfJobId the primary key for the new e s f job
	* @return the new e s f job
	*/
	public it.ethica.esf.model.ESFJob create(long esfJobId);

	/**
	* Removes the e s f job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfJobId the primary key of the e s f job
	* @return the e s f job that was removed
	* @throws it.ethica.esf.NoSuchJobException if a e s f job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFJob remove(long esfJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchJobException;

	public it.ethica.esf.model.ESFJob updateImpl(
		it.ethica.esf.model.ESFJob esfJob)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f job with the primary key or throws a {@link it.ethica.esf.NoSuchJobException} if it could not be found.
	*
	* @param esfJobId the primary key of the e s f job
	* @return the e s f job
	* @throws it.ethica.esf.NoSuchJobException if a e s f job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFJob findByPrimaryKey(long esfJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchJobException;

	/**
	* Returns the e s f job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfJobId the primary key of the e s f job
	* @return the e s f job, or <code>null</code> if a e s f job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFJob fetchByPrimaryKey(long esfJobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f jobs.
	*
	* @return the e s f jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f jobs
	* @param end the upper bound of the range of e s f jobs (not inclusive)
	* @return the range of e s f jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFJob> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f jobs
	* @param end the upper bound of the range of e s f jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFJob> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f jobs.
	*
	* @return the number of e s f jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}