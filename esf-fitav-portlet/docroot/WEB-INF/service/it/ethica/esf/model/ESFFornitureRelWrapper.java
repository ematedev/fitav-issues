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

package it.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFFornitureRel}.
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureRel
 * @generated
 */
public class ESFFornitureRelWrapper implements ESFFornitureRel,
	ModelWrapper<ESFFornitureRel> {
	public ESFFornitureRelWrapper(ESFFornitureRel esfFornitureRel) {
		_esfFornitureRel = esfFornitureRel;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFornitureRel.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFornitureRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfToolId", getEsfToolId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assignmentDate", getAssignmentDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfToolId = (Long)attributes.get("esfToolId");

		if (esfToolId != null) {
			setEsfToolId(esfToolId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date assignmentDate = (Date)attributes.get("assignmentDate");

		if (assignmentDate != null) {
			setAssignmentDate(assignmentDate);
		}
	}

	/**
	* Returns the primary key of this e s f forniture rel.
	*
	* @return the primary key of this e s f forniture rel
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFFornitureRelPK getPrimaryKey() {
		return _esfFornitureRel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f forniture rel.
	*
	* @param primaryKey the primary key of this e s f forniture rel
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFFornitureRelPK primaryKey) {
		_esfFornitureRel.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf tool ID of this e s f forniture rel.
	*
	* @return the esf tool ID of this e s f forniture rel
	*/
	@Override
	public long getEsfToolId() {
		return _esfFornitureRel.getEsfToolId();
	}

	/**
	* Sets the esf tool ID of this e s f forniture rel.
	*
	* @param esfToolId the esf tool ID of this e s f forniture rel
	*/
	@Override
	public void setEsfToolId(long esfToolId) {
		_esfFornitureRel.setEsfToolId(esfToolId);
	}

	/**
	* Returns the class name of this e s f forniture rel.
	*
	* @return the class name of this e s f forniture rel
	*/
	@Override
	public java.lang.String getClassName() {
		return _esfFornitureRel.getClassName();
	}

	/**
	* Sets the class name of this e s f forniture rel.
	*
	* @param className the class name of this e s f forniture rel
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_esfFornitureRel.setClassName(className);
	}

	/**
	* Returns the class p k of this e s f forniture rel.
	*
	* @return the class p k of this e s f forniture rel
	*/
	@Override
	public long getClassPK() {
		return _esfFornitureRel.getClassPK();
	}

	/**
	* Sets the class p k of this e s f forniture rel.
	*
	* @param classPK the class p k of this e s f forniture rel
	*/
	@Override
	public void setClassPK(long classPK) {
		_esfFornitureRel.setClassPK(classPK);
	}

	/**
	* Returns the group ID of this e s f forniture rel.
	*
	* @return the group ID of this e s f forniture rel
	*/
	@Override
	public long getGroupId() {
		return _esfFornitureRel.getGroupId();
	}

	/**
	* Sets the group ID of this e s f forniture rel.
	*
	* @param groupId the group ID of this e s f forniture rel
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfFornitureRel.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f forniture rel.
	*
	* @return the company ID of this e s f forniture rel
	*/
	@Override
	public long getCompanyId() {
		return _esfFornitureRel.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f forniture rel.
	*
	* @param companyId the company ID of this e s f forniture rel
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfFornitureRel.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f forniture rel.
	*
	* @return the user ID of this e s f forniture rel
	*/
	@Override
	public long getUserId() {
		return _esfFornitureRel.getUserId();
	}

	/**
	* Sets the user ID of this e s f forniture rel.
	*
	* @param userId the user ID of this e s f forniture rel
	*/
	@Override
	public void setUserId(long userId) {
		_esfFornitureRel.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f forniture rel.
	*
	* @return the user uuid of this e s f forniture rel
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureRel.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f forniture rel.
	*
	* @param userUuid the user uuid of this e s f forniture rel
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfFornitureRel.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f forniture rel.
	*
	* @return the user name of this e s f forniture rel
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfFornitureRel.getUserName();
	}

	/**
	* Sets the user name of this e s f forniture rel.
	*
	* @param userName the user name of this e s f forniture rel
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfFornitureRel.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f forniture rel.
	*
	* @return the create date of this e s f forniture rel
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfFornitureRel.getCreateDate();
	}

	/**
	* Sets the create date of this e s f forniture rel.
	*
	* @param createDate the create date of this e s f forniture rel
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfFornitureRel.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f forniture rel.
	*
	* @return the modified date of this e s f forniture rel
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfFornitureRel.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f forniture rel.
	*
	* @param modifiedDate the modified date of this e s f forniture rel
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfFornitureRel.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the assignment date of this e s f forniture rel.
	*
	* @return the assignment date of this e s f forniture rel
	*/
	@Override
	public java.util.Date getAssignmentDate() {
		return _esfFornitureRel.getAssignmentDate();
	}

	/**
	* Sets the assignment date of this e s f forniture rel.
	*
	* @param assignmentDate the assignment date of this e s f forniture rel
	*/
	@Override
	public void setAssignmentDate(java.util.Date assignmentDate) {
		_esfFornitureRel.setAssignmentDate(assignmentDate);
	}

	@Override
	public boolean isNew() {
		return _esfFornitureRel.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFornitureRel.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFornitureRel.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFornitureRel.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFornitureRel.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFornitureRel.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFornitureRel.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFornitureRel.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFornitureRel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFornitureRel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFornitureRel.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFornitureRelWrapper((ESFFornitureRel)_esfFornitureRel.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFFornitureRel esfFornitureRel) {
		return _esfFornitureRel.compareTo(esfFornitureRel);
	}

	@Override
	public int hashCode() {
		return _esfFornitureRel.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFornitureRel> toCacheModel() {
		return _esfFornitureRel.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFornitureRel toEscapedModel() {
		return new ESFFornitureRelWrapper(_esfFornitureRel.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFornitureRel toUnescapedModel() {
		return new ESFFornitureRelWrapper(_esfFornitureRel.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFornitureRel.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFornitureRel.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFornitureRel.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFornitureRelWrapper)) {
			return false;
		}

		ESFFornitureRelWrapper esfFornitureRelWrapper = (ESFFornitureRelWrapper)obj;

		if (Validator.equals(_esfFornitureRel,
					esfFornitureRelWrapper._esfFornitureRel)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFornitureRel getWrappedESFFornitureRel() {
		return _esfFornitureRel;
	}

	@Override
	public ESFFornitureRel getWrappedModel() {
		return _esfFornitureRel;
	}

	@Override
	public void resetOriginalValues() {
		_esfFornitureRel.resetOriginalValues();
	}

	private ESFFornitureRel _esfFornitureRel;
}