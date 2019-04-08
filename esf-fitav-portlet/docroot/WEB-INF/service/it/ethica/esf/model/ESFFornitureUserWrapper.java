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

package it.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFFornitureUser}.
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureUser
 * @generated
 */
public class ESFFornitureUserWrapper implements ESFFornitureUser,
	ModelWrapper<ESFFornitureUser> {
	public ESFFornitureUserWrapper(ESFFornitureUser esfFornitureUser) {
		_esfFornitureUser = esfFornitureUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFornitureUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFornitureUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfIDForniture", getEsfIDForniture());
		attributes.put("esfIdUser", getEsfIdUser());
		attributes.put("esfQuantity", getEsfQuantity());
		attributes.put("esfDateAssign", getEsfDateAssign());
		attributes.put("esfFornitureUserID", getEsfFornitureUserID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfIDForniture = (Long)attributes.get("esfIDForniture");

		if (esfIDForniture != null) {
			setEsfIDForniture(esfIDForniture);
		}

		Long esfIdUser = (Long)attributes.get("esfIdUser");

		if (esfIdUser != null) {
			setEsfIdUser(esfIdUser);
		}

		Long esfQuantity = (Long)attributes.get("esfQuantity");

		if (esfQuantity != null) {
			setEsfQuantity(esfQuantity);
		}

		Date esfDateAssign = (Date)attributes.get("esfDateAssign");

		if (esfDateAssign != null) {
			setEsfDateAssign(esfDateAssign);
		}

		Long esfFornitureUserID = (Long)attributes.get("esfFornitureUserID");

		if (esfFornitureUserID != null) {
			setEsfFornitureUserID(esfFornitureUserID);
		}
	}

	/**
	* Returns the primary key of this e s f forniture user.
	*
	* @return the primary key of this e s f forniture user
	*/
	@Override
	public long getPrimaryKey() {
		return _esfFornitureUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f forniture user.
	*
	* @param primaryKey the primary key of this e s f forniture user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfFornitureUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf i d forniture of this e s f forniture user.
	*
	* @return the esf i d forniture of this e s f forniture user
	*/
	@Override
	public long getEsfIDForniture() {
		return _esfFornitureUser.getEsfIDForniture();
	}

	/**
	* Sets the esf i d forniture of this e s f forniture user.
	*
	* @param esfIDForniture the esf i d forniture of this e s f forniture user
	*/
	@Override
	public void setEsfIDForniture(long esfIDForniture) {
		_esfFornitureUser.setEsfIDForniture(esfIDForniture);
	}

	/**
	* Returns the esf ID user of this e s f forniture user.
	*
	* @return the esf ID user of this e s f forniture user
	*/
	@Override
	public long getEsfIdUser() {
		return _esfFornitureUser.getEsfIdUser();
	}

	/**
	* Sets the esf ID user of this e s f forniture user.
	*
	* @param esfIdUser the esf ID user of this e s f forniture user
	*/
	@Override
	public void setEsfIdUser(long esfIdUser) {
		_esfFornitureUser.setEsfIdUser(esfIdUser);
	}

	/**
	* Returns the esf quantity of this e s f forniture user.
	*
	* @return the esf quantity of this e s f forniture user
	*/
	@Override
	public long getEsfQuantity() {
		return _esfFornitureUser.getEsfQuantity();
	}

	/**
	* Sets the esf quantity of this e s f forniture user.
	*
	* @param esfQuantity the esf quantity of this e s f forniture user
	*/
	@Override
	public void setEsfQuantity(long esfQuantity) {
		_esfFornitureUser.setEsfQuantity(esfQuantity);
	}

	/**
	* Returns the esf date assign of this e s f forniture user.
	*
	* @return the esf date assign of this e s f forniture user
	*/
	@Override
	public java.util.Date getEsfDateAssign() {
		return _esfFornitureUser.getEsfDateAssign();
	}

	/**
	* Sets the esf date assign of this e s f forniture user.
	*
	* @param esfDateAssign the esf date assign of this e s f forniture user
	*/
	@Override
	public void setEsfDateAssign(java.util.Date esfDateAssign) {
		_esfFornitureUser.setEsfDateAssign(esfDateAssign);
	}

	/**
	* Returns the esf forniture user i d of this e s f forniture user.
	*
	* @return the esf forniture user i d of this e s f forniture user
	*/
	@Override
	public long getEsfFornitureUserID() {
		return _esfFornitureUser.getEsfFornitureUserID();
	}

	/**
	* Sets the esf forniture user i d of this e s f forniture user.
	*
	* @param esfFornitureUserID the esf forniture user i d of this e s f forniture user
	*/
	@Override
	public void setEsfFornitureUserID(long esfFornitureUserID) {
		_esfFornitureUser.setEsfFornitureUserID(esfFornitureUserID);
	}

	@Override
	public boolean isNew() {
		return _esfFornitureUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFornitureUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFornitureUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFornitureUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFornitureUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFornitureUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFornitureUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFornitureUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFornitureUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFornitureUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFornitureUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFornitureUserWrapper((ESFFornitureUser)_esfFornitureUser.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFFornitureUser esfFornitureUser) {
		return _esfFornitureUser.compareTo(esfFornitureUser);
	}

	@Override
	public int hashCode() {
		return _esfFornitureUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFornitureUser> toCacheModel() {
		return _esfFornitureUser.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFornitureUser toEscapedModel() {
		return new ESFFornitureUserWrapper(_esfFornitureUser.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFornitureUser toUnescapedModel() {
		return new ESFFornitureUserWrapper(_esfFornitureUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFornitureUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFornitureUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFornitureUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFornitureUserWrapper)) {
			return false;
		}

		ESFFornitureUserWrapper esfFornitureUserWrapper = (ESFFornitureUserWrapper)obj;

		if (Validator.equals(_esfFornitureUser,
					esfFornitureUserWrapper._esfFornitureUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFornitureUser getWrappedESFFornitureUser() {
		return _esfFornitureUser;
	}

	@Override
	public ESFFornitureUser getWrappedModel() {
		return _esfFornitureUser;
	}

	@Override
	public void resetOriginalValues() {
		_esfFornitureUser.resetOriginalValues();
	}

	private ESFFornitureUser _esfFornitureUser;
}