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
 * Provides a wrapper for {@link ESFCardLocalService}.
 *
 * @author Ethica
 * @see ESFCardLocalService
 * @generated
 */
public class ESFCardLocalServiceWrapper implements ESFCardLocalService,
	ServiceWrapper<ESFCardLocalService> {
	public ESFCardLocalServiceWrapper(ESFCardLocalService esfCardLocalService) {
		_esfCardLocalService = esfCardLocalService;
	}

	/**
	* Adds the e s f card to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard addESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.addESFCard(esfCard);
	}

	/**
	* Creates a new e s f card with the primary key. Does not add the e s f card to the database.
	*
	* @param esfCardId the primary key for the new e s f card
	* @return the new e s f card
	*/
	@Override
	public it.ethica.esf.model.ESFCard createESFCard(long esfCardId) {
		return _esfCardLocalService.createESFCard(esfCardId);
	}

	/**
	* Deletes the e s f card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card that was removed
	* @throws PortalException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard deleteESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.deleteESFCard(esfCardId);
	}

	/**
	* Deletes the e s f card from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard deleteESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.deleteESFCard(esfCard);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfCardLocalService.dynamicQuery();
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
		return _esfCardLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfCardLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfCardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFCard fetchESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.fetchESFCard(esfCardId);
	}

	/**
	* Returns the e s f card with the matching UUID and company.
	*
	* @param uuid the e s f card's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard fetchESFCardByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.fetchESFCardByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f card matching the UUID and group.
	*
	* @param uuid the e s f card's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard fetchESFCardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.fetchESFCardByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f card with the primary key.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card
	* @throws PortalException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard getESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCard(esfCardId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f card with the matching UUID and company.
	*
	* @param uuid the e s f card's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f card
	* @throws PortalException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard getESFCardByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCardByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f card matching the UUID and group.
	*
	* @param uuid the e s f card's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f card
	* @throws PortalException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard getESFCardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCardByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> getESFCards(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCards(start, end);
	}

	/**
	* Returns the number of e s f cards.
	*
	* @return the number of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFCardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCardsCount();
	}

	/**
	* Updates the e s f card in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard updateESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.updateESFCard(esfCard);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfCardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfCardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfCardLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.ethica.esf.model.ESFCard getEsfCardByEsfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getEsfCardByEsfUserId(esfUserId);
	}

	@Override
	public it.ethica.esf.model.ESFCard addESFCard(long userId,
		java.lang.String code, java.lang.String codeAlfa, long codeNum,
		it.ethica.esf.model.ESFEntityState esfEntityState, long esfUserId,
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.addESFCard(userId, code, codeAlfa, codeNum,
			esfEntityState, esfUserId, esfOrganizationId, serviceContext);
	}

	@Override
	public int createMultiESFCard(long userId, int numCards,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.createMultiESFCard(userId, numCards,
			serviceContext);
	}

	@Override
	public int addSelectedCard(long organizationId, int begin, int end,
		java.lang.String alfa, long esfUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.addSelectedCard(organizationId, begin, end,
			alfa, esfUserId, serviceContext);
	}

	@Override
	public int findAllESFCardsChildOrg(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsChildOrg(organizationId);
	}

	@Override
	public int findAllESFCardsReg_Prov(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsReg_Prov(organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsReg_ProvFree(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsReg_ProvFree(organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> getAllFreeCard() {
		return _esfCardLocalService.getAllFreeCard();
	}

	@Override
	public int findAllFreeCardInt() {
		return _esfCardLocalService.findAllFreeCardInt();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllFreeCards(
		int start, int end) {
		return _esfCardLocalService.findAllFreeCards(start, end);
	}

	@Override
	public long addMultiESFCard(long userId, java.lang.String codeAlfa,
		long numCards, it.ethica.esf.model.ESFEntityState esfEntityState,
		long esfUserId, long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.addMultiESFCard(userId, codeAlfa, numCards,
			esfEntityState, esfUserId, esfOrganizationId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFCard deleteESFCard(long resourcePrimKey,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.deleteESFCard(resourcePrimKey,
			serviceContext);
	}

	@Override
	public void deleteESFCard(long[] resourcePrimKeys,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfCardLocalService.deleteESFCard(resourcePrimKeys, serviceContext);
	}

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
	@Override
	public it.ethica.esf.model.ESFCard updateESFCard(long userId,
		long resourcePrimKey, java.lang.String code, java.lang.String codeAlfa,
		long codeNum, long esfUserId, long esfOrganizationId,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		boolean isNotChangeState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.updateESFCard(userId, resourcePrimKey,
			code, codeAlfa, codeNum, esfUserId, esfOrganizationId,
			esfEntityState, isNotChangeState, serviceContext);
	}

	/**
	* Cerca tutte le Card sulla base dello codice
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByCode_Organization(
		java.lang.String code, long organizationId) {
		return _esfCardLocalService.findAllESFCardsByCode_Organization(code,
			organizationId);
	}

	/**
	* Cerca le Cards che sono associate all' utente con Id = userId e che il
	* cui codice presenta parte del codice indicato
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByC_U_O(
		java.lang.String code, long userId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsByC_U_O(code, userId,
			organizationId);
	}

	/**
	* Cerca tutte le Card sulla base dello stato [attivo o disattivo]
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByState(
		int state) {
		return _esfCardLocalService.findAllESFCardsByState(state);
	}

	/**
	* Cerca tutte le Card sulla base dello stato [attivo o disattivo]
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByState(
		int state, int start, int end) {
		return _esfCardLocalService.findAllESFCardsByState(state, start, end);
	}

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllByOrganizationId(
		long organizationId, boolean isLeaf, int state) {
		return _esfCardLocalService.findAllByOrganizationId(organizationId,
			isLeaf, state);
	}

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllByOrganizationId(
		long organizationId, boolean isLeaf, int state, int start, int end) {
		return _esfCardLocalService.findAllByOrganizationId(organizationId,
			isLeaf, state, start, end);
	}

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByOrganizationId(
		long organizationId, boolean isLeaf, int state) {
		return _esfCardLocalService.findAllESFCardsByOrganizationId(organizationId,
			isLeaf, state);
	}

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByOrganizationId(
		long organizationId, boolean isLeaf, int state, int start, int end) {
		return _esfCardLocalService.findAllESFCardsByOrganizationId(organizationId,
			isLeaf, state, start, end);
	}

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate alle organizzazioni sportive figlie dell' organizazione con Id
	* = organizationId e alla stessa organizzazione
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByRootOrganizationId(
		long organizationId, int state) {
		return _esfCardLocalService.findAllESFCardsByRootOrganizationId(organizationId,
			state);
	}

	/**
	* Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	* associate alle organizzazioni sportive figlie dell' organizazione con Id
	* = organizationId e alla stessa organizzazione
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByRootOrganizationId(
		long organizationId, int state, int start, int end) {
		return _esfCardLocalService.findAllESFCardsByRootOrganizationId(organizationId,
			state, start, end);
	}

	/**
	* Cerca la Card che ha uno stato [attivo o disattivo] e che � associata
	* all' organizzazione con Id = organizationId e cardId = esfCardId
	*/
	@Override
	public it.ethica.esf.model.ESFCard findESFCardByO_C(long organizationId,
		long esfCardId, int state) {
		return _esfCardLocalService.findESFCardByO_C(organizationId, esfCardId,
			state);
	}

	/**
	* Cerca tutte le Card non ancora assegnate, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_S(
		long organizationId, boolean isLeaf, int state) {
		return _esfCardLocalService.findAllNotAssignedESFCardsByO_S(organizationId,
			isLeaf, state);
	}

	/**
	* Cerca tutte le Card non ancora assegnate, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_S(
		long organizationId, boolean isLeaf, int state, int start, int end) {
		return _esfCardLocalService.findAllNotAssignedESFCardsByO_S(organizationId,
			isLeaf, state, start, end);
	}

	/**
	* Cerca tutte le Card non ancora assegnate, tranne quella dell'utente che
	* corrisponde allo user id esfUserId, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_U_S(
		long organizationId, long esfUserId, boolean isLeaf, int state,
		int start, int end) {
		return _esfCardLocalService.findAllNotAssignedESFCardsByO_U_S(organizationId,
			esfUserId, isLeaf, state, start, end);
	}

	/**
	* Cerca tutte le Card non ancora assegnate, tranne quella dell'utente che
	* corrisponde allo user id esfUserId, che hanno uno stato [attivo o
	* disattivo] e che o sono associate alle organizzazioni sportive foglie
	* dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	* organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllNotAssignedESFCardsByO_U_S(
		long organizationId, boolean isLeaf, long esfUserId, int state) {
		return _esfCardLocalService.findAllNotAssignedESFCardsByO_U_S(organizationId,
			isLeaf, esfUserId, state);
	}

	/**
	* Cerca le Cards che hanno uno stato [attivo o disattivo], che sono
	* associate all' utente con Id = userId e all' organizzazione sportiva con
	* Id = organizationId
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_O_S(
		long userId, long organizationId, int state)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsByU_O_S(userId,
			organizationId, state);
	}

	/**
	* Cerca le Cards che hanno lo stato [disattivo], che sono associate all'
	* utente con Id = userId, che sono state emesse prima della date
	* passata per parametro.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_S_Y(
		long userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsByU_S_Y(userId, date);
	}

	/**
	* Cerca le Cards che hanno lo stato [disattivo], che sono associate all'
	* utente con Id = userId, che sono state emesse  prima della date
	* passata per parametro.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_S_Y(
		long userId, java.util.Date date, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsByU_S_Y(userId, date, start,
			end);
	}

	/**
	* Cerca le Cards che hanno uno stato [attivo o disattivo], che sono
	* associate all' utente con Id = userId
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findAllESFCardsByU_S(
		long userId, int state)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findAllESFCardsByU_S(userId, state);
	}

	/**
	* Cerca le Cards associate all' utente con Id = userId
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findCardByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findCardByUser(userId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> getAllEsfCardByLikeC(
		java.lang.String code, int state, int start, int end) {
		return _esfCardLocalService.getAllEsfCardByLikeC(code, state, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> getAllEsfCardByLikeC(
		java.lang.String code, int state) {
		return _esfCardLocalService.getAllEsfCardByLikeC(code, state);
	}

	@Override
	public it.ethica.esf.model.ESFCard getEsfCardByCode(java.lang.String code,
		int state) {
		return _esfCardLocalService.getEsfCardByCode(code, state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> checkCode(
		java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.checkCode(code, serviceContext);
	}

	@Override
	public java.lang.String buildCode(java.lang.String codeAlfa, long codeNum) {
		return _esfCardLocalService.buildCode(codeAlfa, codeNum);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findActualUserCards(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.findActualUserCards(esfUserId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFCardLocalService getWrappedESFCardLocalService() {
		return _esfCardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFCardLocalService(
		ESFCardLocalService esfCardLocalService) {
		_esfCardLocalService = esfCardLocalService;
	}

	@Override
	public ESFCardLocalService getWrappedService() {
		return _esfCardLocalService;
	}

	@Override
	public void setWrappedService(ESFCardLocalService esfCardLocalService) {
		_esfCardLocalService = esfCardLocalService;
	}

	private ESFCardLocalService _esfCardLocalService;
}