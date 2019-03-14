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

package com.ethica.esf.service.persistence;

import com.ethica.esf.model.ESFArticle;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s f article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticlePersistenceImpl
 * @see ESFArticleUtil
 * @generated
 */
public interface ESFArticlePersistence extends BasePersistence<ESFArticle> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFArticleUtil} to access the e s f article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f article where code = &#63; or throws a {@link com.ethica.esf.NoSuchArticleException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle findByArticleCode(
		java.lang.String code)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f article, or <code>null</code> if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByArticleCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f article, or <code>null</code> if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByArticleCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f article where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f article that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle removeByArticleCode(
		java.lang.String code)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f articles where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticleCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f articles where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @return the matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findByArticleType(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f articles where esfArticleTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleTypeId the esf article type ID
	* @param start the lower bound of the range of e s f articles
	* @param end the upper bound of the range of e s f articles (not inclusive)
	* @return the range of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findByArticleType(
		long esfArticleTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f articles where esfArticleTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleTypeId the esf article type ID
	* @param start the lower bound of the range of e s f articles
	* @param end the upper bound of the range of e s f articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findByArticleType(
		long esfArticleTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle findByArticleType_First(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article, or <code>null</code> if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByArticleType_First(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle findByArticleType_Last(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article, or <code>null</code> if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByArticleType_Last(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f articles before and after the current e s f article in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleId the primary key of the current e s f article
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle[] findByArticleType_PrevAndNext(
		long esfArticleId, long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f articles where esfArticleTypeId = &#63; from the database.
	*
	* @param esfArticleTypeId the esf article type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticleType(long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f articles where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @return the number of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticleType(long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f articles where name = &#63;.
	*
	* @param name the name
	* @return the matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f articles where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f articles
	* @param end the upper bound of the range of e s f articles (not inclusive)
	* @return the range of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f articles where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f articles
	* @param end the upper bound of the range of e s f articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article, or <code>null</code> if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article, or <code>null</code> if a matching e s f article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f articles before and after the current e s f article in the ordered set where name = &#63;.
	*
	* @param esfArticleId the primary key of the current e s f article
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle[] findByName_PrevAndNext(
		long esfArticleId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f articles where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f articles where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f article in the entity cache if it is enabled.
	*
	* @param esfArticle the e s f article
	*/
	public void cacheResult(com.ethica.esf.model.ESFArticle esfArticle);

	/**
	* Caches the e s f articles in the entity cache if it is enabled.
	*
	* @param esfArticles the e s f articles
	*/
	public void cacheResult(
		java.util.List<com.ethica.esf.model.ESFArticle> esfArticles);

	/**
	* Creates a new e s f article with the primary key. Does not add the e s f article to the database.
	*
	* @param esfArticleId the primary key for the new e s f article
	* @return the new e s f article
	*/
	public com.ethica.esf.model.ESFArticle create(long esfArticleId);

	/**
	* Removes the e s f article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article that was removed
	* @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle remove(long esfArticleId)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ethica.esf.model.ESFArticle updateImpl(
		com.ethica.esf.model.ESFArticle esfArticle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article with the primary key or throws a {@link com.ethica.esf.NoSuchArticleException} if it could not be found.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article
	* @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle findByPrimaryKey(long esfArticleId)
		throws com.ethica.esf.NoSuchArticleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfArticleId the primary key of the e s f article
	* @return the e s f article, or <code>null</code> if a e s f article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticle fetchByPrimaryKey(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f articles.
	*
	* @return the e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFArticle> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f articles
	* @param end the upper bound of the range of e s f articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticle> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f articles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f articles.
	*
	* @return the number of e s f articles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}