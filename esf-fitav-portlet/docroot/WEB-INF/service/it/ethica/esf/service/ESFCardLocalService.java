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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ESFCard. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFCardLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFCardLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFCardLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFCardLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFCardLocalServiceUtil} to access the e s f card local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFCardLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f card to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public it.ethica.esf.model.ESFCard addESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f card with the primary key. Does not add the e s f card to the database.
	*
	* @param esfCardId the primary key for the new e s f card
	* @return the new e s f card
	*/
	public it.ethica.esf.model.ESFCard createESFCard(long esfCardId);

	/**
	* Deletes the e s f card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card that was removed
	* @throws PortalException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public it.ethica.esf.model.ESFCard deleteESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f card from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public it.ethica.esf.model.ESFCard deleteESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard fetchESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f card with the matching UUID and company.
	*
	* @param uuid the e s f card's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard fetchESFCardByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f card matching the UUID and group.
	*
	* @param uuid the e s f card's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard fetchESFCardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f card with the primary key.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card
	* @throws PortalException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard getESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f card with the matching UUID and company.
	*
	* @param uuid the e s f card's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f card
	* @throws PortalException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard getESFCardByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f card matching the UUID and group.
	*
	* @param uuid the e s f card's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f card
	* @throws PortalException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard getESFCardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCard> getESFCards(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f cards.
	*
	* @return the number of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFCardsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f card in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public it.ethica.esf.model.ESFCard updateESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard getEsfCardByEsfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFCard addESFCard(long userId,
		java.lang.String code, java.lang.String codeAlfa, long codeNum,
		it.ethica.esf.model.ESFEntityState esfEntityState, long esfUserId,
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCard> getAllESFCardsByEsfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int createMultiESFCard(long userId, int numCards,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int addSelectedCard(long organizationId, int begin, int end,
		java.lang.String alfa, long esfUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int findAllESFCardsChildOrg(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int findAllESFCardsReg_Prov(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsReg_ProvFree(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCard> getAllFreeCard();

	public int findAllFreeCardInt();

	public java.util.List<it.ethica.esf.model.ESFCard> findAllFreeCards(
		int start, int end);

	public long addMultiESFCard(long userId, java.lang.String codeAlfa,
		long numCards, it.ethica.esf.model.ESFEntityState esfEntityState,
		long esfUserId, long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFCard deleteESFCard(long resourcePrimKey,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteESFCard(long[] resourcePrimKeys,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Effettua l'update dell'entit� ESFCard. Nel caso in cui viene fatto il
	* cambio di stato della card, viene aggiornata la tabella corrispondente.
	* Da notare che se isNotChangeState = true viene baipassato il controllo
	* sulla scelta di uno stato differente a quello gi� assegnato
	* all'entit�. Questo perch� delle volte bisogna creare un riferimento
	* nella tabella degli stati mantenendo lo stato preesistente (per lo
	* storico)
	*
	* @param userId
	* @param resourcePrimKey
	* @param code
	* @param esfUserId
	* @param esfOrganizationId
	* @param esfEntityState
	* @param isNotChangeState
	* @param serviceContext
	* @return ESFCard
	* @throws PortalException
	* @throws SystemException
	*/
	public it.ethica.esf.model.ESFCard updateESFCard(long userId,
		long resourcePrimKey, java.lang.String code, java.lang.String codeAlfa,
		long codeNum, long esfUserId, long esfOrganizationId,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		boolean isNotChangeState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Cerca tutte le Card sulla base dello codice
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByCode_Organization(
		java.lang.String code, long organizationId);

	/**
	* Cerca le Cards che sono associate all' utente con Id = userId e che il
	* cui codice presenta parte del codice indicato
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByC_U_O(
		java.lang.String code, long userId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Cerca tutte le Card sulla base dello stato [attivo o disattivo]
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByState(
		int state);

	/**
	* Cerca tutte le Card sulla base dello stato [attivo o disattivo]
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByState(
		int state, int start, int end);

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllByOrganizationId(
		long organizationId, boolean isLeaf, int state);

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllByOrganizationId(
		long organizationId, boolean isLeaf, int state, int start, int end);

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByOrganizationId(
		long organizationId, boolean isLeaf, int state);

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByOrganizationId(
		long organizationId, boolean isLeaf, int state, int start, int end);

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate alle organizzazioni sportive figlie dell' organizazione con Id
	* = organizationId e alla stessa organizzazione
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByRootOrganizationId(
		long organizationId, int state);

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate alle organizzazioni sportive figlie dell' organizazione con Id
	* = organizationId e alla stessa organizzazione
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByRootOrganizationId(
		long organizationId, int state, int start, int end);

	/**
	* Cerca la Card che ha uno stato [attivo o disattivo] e che � associata
	* all' organizzazione con Id = organizationId e cardId = esfCardId
	*/
	public it.ethica.esf.model.ESFCard findESFCardByO_C(long organizationId,
		long esfCardId, int state);

	/**
	* Cerca tutte le Card non ancora assegnate, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_S(
		long organizationId, boolean isLeaf, int state);

	/**
	* Cerca tutte le Card non ancora assegnate, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_S(
		long organizationId, boolean isLeaf, int state, int start, int end);

	/**
	* Cerca tutte le Card non ancora assegnate, tranne quella dell'utente che
	* corrisponde allo user id esfUserId, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_U_S(
		long organizationId, long esfUserId, boolean isLeaf, int state,
		int start, int end);

	/**
	* Cerca tutte le Card non ancora assegnate, tranne quella dell'utente che
	* corrisponde allo user id esfUserId, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_U_S(
		long organizationId, boolean isLeaf, long esfUserId, int state);

	/**
	* Cerca le Cards che hanno uno stato [attivo o disattivo], che sono
	* associate all' utente con Id = userId e all' organizzazione sportiva con
	* Id = organizationId
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_O_S(
		long userId, long organizationId, int state)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Cerca le Cards che hanno lo stato [disattivo], che sono associate all'
	* utente con Id = userId, che sono state emesse prima della date
	* passata per parametro.
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_S_Y(
		long userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Cerca le Cards che hanno lo stato [disattivo], che sono associate all'
	* utente con Id = userId, che sono state emesse  prima della date
	* passata per parametro.
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_S_Y(
		long userId, java.util.Date date, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Cerca le Cards che hanno uno stato [attivo o disattivo], che sono
	* associate all' utente con Id = userId
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_S(
		long userId, int state)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Cerca le Cards associate all' utente con Id = userId
	*/
	public java.util.List<it.ethica.esf.model.ESFCard> findCardByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCard> getAllEsfCardByLikeC(
		java.lang.String code, int state, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFCard> getAllEsfCardByLikeC(
		java.lang.String code, int state);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFCard getEsfCardByCode(java.lang.String code,
		int state);

	public java.util.List<it.ethica.esf.model.ESFCard> checkCode(
		java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String buildCode(java.lang.String codeAlfa, long codeNum);

	public java.util.List<it.ethica.esf.model.ESFCard> findActualUserCards(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFCard findShooterByCardActiveInMatch(
		java.lang.String cardCode, java.lang.String startDate,
		java.lang.String endDate);

	public it.ethica.esf.model.ESFCard addESFCardOldCode(
		java.lang.String oldCode, long userId, java.lang.String code,
		java.lang.String codeAlfa, long codeNum,
		it.ethica.esf.model.ESFEntityState esfEntityState, long esfUserId,
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}