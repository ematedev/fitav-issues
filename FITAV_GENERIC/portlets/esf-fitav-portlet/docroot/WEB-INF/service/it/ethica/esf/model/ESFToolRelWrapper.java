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
 * This class is a wrapper for {@link ESFToolRel}.
 * </p>
 *
 * @author Ethica
 * @see ESFToolRel
 * @generated
 */
public class ESFToolRelWrapper implements ESFToolRel, ModelWrapper<ESFToolRel> {
	public ESFToolRelWrapper(ESFToolRel esfToolRel) {
		_esfToolRel = esfToolRel;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFToolRel.class;
	}

	@Override
	public String getModelClassName() {
		return ESFToolRel.class.getName();
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
	* Returns the primary key of this e s f tool rel.
	*
	* @return the primary key of this e s f tool rel
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFToolRelPK getPrimaryKey() {
		return _esfToolRel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f tool rel.
	*
	* @param primaryKey the primary key of this e s f tool rel
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFToolRelPK primaryKey) {
		_esfToolRel.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf tool ID of this e s f tool rel.
	*
	* @return the esf tool ID of this e s f tool rel
	*/
	@Override
	public long getEsfToolId() {
		return _esfToolRel.getEsfToolId();
	}

	/**
	* Sets the esf tool ID of this e s f tool rel.
	*
	* @param esfToolId the esf tool ID of this e s f tool rel
	*/
	@Override
	public void setEsfToolId(long esfToolId) {
		_esfToolRel.setEsfToolId(esfToolId);
	}

	/**
	* Returns the class name of this e s f tool rel.
	*
	* @return the class name of this e s f tool rel
	*/
	@Override
	public java.lang.String getClassName() {
		return _esfToolRel.getClassName();
	}

	/**
	* Sets the class name of this e s f tool rel.
	*
	* @param className the class name of this e s f tool rel
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_esfToolRel.setClassName(className);
	}

	/**
	* Returns the class p k of this e s f tool rel.
	*
	* @return the class p k of this e s f tool rel
	*/
	@Override
	public long getClassPK() {
		return _esfToolRel.getClassPK();
	}

	/**
	* Sets the class p k of this e s f tool rel.
	*
	* @param classPK the class p k of this e s f tool rel
	*/
	@Override
	public void setClassPK(long classPK) {
		_esfToolRel.setClassPK(classPK);
	}

	/**
	* Returns the group ID of this e s f tool rel.
	*
	* @return the group ID of this e s f tool rel
	*/
	@Override
	public long getGroupId() {
		return _esfToolRel.getGroupId();
	}

	/**
	* Sets the group ID of this e s f tool rel.
	*
	* @param groupId the group ID of this e s f tool rel
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfToolRel.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f tool rel.
	*
	* @return the company ID of this e s f tool rel
	*/
	@Override
	public long getCompanyId() {
		return _esfToolRel.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f tool rel.
	*
	* @param companyId the company ID of this e s f tool rel
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfToolRel.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f tool rel.
	*
	* @return the user ID of this e s f tool rel
	*/
	@Override
	public long getUserId() {
		return _esfToolRel.getUserId();
	}

	/**
	* Sets the user ID of this e s f tool rel.
	*
	* @param userId the user ID of this e s f tool rel
	*/
	@Override
	public void setUserId(long userId) {
		_esfToolRel.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f tool rel.
	*
	* @return the user uuid of this e s f tool rel
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfToolRel.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f tool rel.
	*
	* @param userUuid the user uuid of this e s f tool rel
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfToolRel.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f tool rel.
	*
	* @return the user name of this e s f tool rel
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfToolRel.getUserName();
	}

	/**
	* Sets the user name of this e s f tool rel.
	*
	* @param userName the user name of this e s f tool rel
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfToolRel.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f tool rel.
	*
	* @return the create date of this e s f tool rel
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfToolRel.getCreateDate();
	}

	/**
	* Sets the create date of this e s f tool rel.
	*
	* @param createDate the create date of this e s f tool rel
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfToolRel.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f tool rel.
	*
	* @return the modified date of this e s f tool rel
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfToolRel.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f tool rel.
	*
	* @param modifiedDate the modified date of this e s f tool rel
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfToolRel.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the assignment date of this e s f tool rel.
	*
	* @return the assignment date of this e s f tool rel
	*/
	@Override
	public java.util.Date getAssignmentDate() {
		return _esfToolRel.getAssignmentDate();
	}

	/**
	* Sets the assignment date of this e s f tool rel.
	*
	* @param assignmentDate the assignment date of this e s f tool rel
	*/
	@Override
	public void setAssignmentDate(java.util.Date assignmentDate) {
		_esfToolRel.setAssignmentDate(assignmentDate);
	}

	@Override
	public boolean isNew() {
		return _esfToolRel.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfToolRel.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfToolRel.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfToolRel.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfToolRel.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfToolRel.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfToolRel.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfToolRel.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfToolRel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfToolRel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfToolRel.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFToolRelWrapper((ESFToolRel)_esfToolRel.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFToolRel esfToolRel) {
		return _esfToolRel.compareTo(esfToolRel);
	}

	@Override
	public int hashCode() {
		return _esfToolRel.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFToolRel> toCacheModel() {
		return _esfToolRel.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFToolRel toEscapedModel() {
		return new ESFToolRelWrapper(_esfToolRel.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFToolRel toUnescapedModel() {
		return new ESFToolRelWrapper(_esfToolRel.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfToolRel.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfToolRel.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFToolRelWrapper)) {
			return false;
		}

		ESFToolRelWrapper esfToolRelWrapper = (ESFToolRelWrapper)obj;

		if (Validator.equals(_esfToolRel, esfToolRelWrapper._esfToolRel)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFToolRel getWrappedESFToolRel() {
		return _esfToolRel;
	}

	@Override
	public ESFToolRel getWrappedModel() {
		return _esfToolRel;
	}

	@Override
	public void resetOriginalValues() {
		_esfToolRel.resetOriginalValues();
	}

	private ESFToolRel _esfToolRel;
}