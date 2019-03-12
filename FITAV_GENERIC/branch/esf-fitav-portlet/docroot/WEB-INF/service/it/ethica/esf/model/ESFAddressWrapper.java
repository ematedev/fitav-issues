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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFAddress}.
 * </p>
 *
 * @author Ethica
 * @see ESFAddress
 * @generated
 */
public class ESFAddressWrapper implements ESFAddress, ModelWrapper<ESFAddress> {
	public ESFAddressWrapper(ESFAddress esfAddress) {
		_esfAddress = esfAddress;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAddress.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAddress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfAddressId", getEsfAddressId());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());
		attributes.put("esfCountryId", getEsfCountryId());
		attributes.put("esfRegionId", getEsfRegionId());
		attributes.put("esfProvinceId", getEsfProvinceId());
		attributes.put("esfCityId", getEsfCityId());
		attributes.put("groupId", getGroupId());
		attributes.put("type", getType());
		attributes.put("listTypeId", getListTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfAddressId = (Long)attributes.get("esfAddressId");

		if (esfAddressId != null) {
			setEsfAddressId(esfAddressId);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String esfCountryId = (String)attributes.get("esfCountryId");

		if (esfCountryId != null) {
			setEsfCountryId(esfCountryId);
		}

		String esfRegionId = (String)attributes.get("esfRegionId");

		if (esfRegionId != null) {
			setEsfRegionId(esfRegionId);
		}

		String esfProvinceId = (String)attributes.get("esfProvinceId");

		if (esfProvinceId != null) {
			setEsfProvinceId(esfProvinceId);
		}

		Long esfCityId = (Long)attributes.get("esfCityId");

		if (esfCityId != null) {
			setEsfCityId(esfCityId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer listTypeId = (Integer)attributes.get("listTypeId");

		if (listTypeId != null) {
			setListTypeId(listTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f address.
	*
	* @return the primary key of this e s f address
	*/
	@Override
	public long getPrimaryKey() {
		return _esfAddress.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f address.
	*
	* @param primaryKey the primary key of this e s f address
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfAddress.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f address.
	*
	* @return the uuid of this e s f address
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfAddress.getUuid();
	}

	/**
	* Sets the uuid of this e s f address.
	*
	* @param uuid the uuid of this e s f address
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfAddress.setUuid(uuid);
	}

	/**
	* Returns the esf address ID of this e s f address.
	*
	* @return the esf address ID of this e s f address
	*/
	@Override
	public long getEsfAddressId() {
		return _esfAddress.getEsfAddressId();
	}

	/**
	* Sets the esf address ID of this e s f address.
	*
	* @param esfAddressId the esf address ID of this e s f address
	*/
	@Override
	public void setEsfAddressId(long esfAddressId) {
		_esfAddress.setEsfAddressId(esfAddressId);
	}

	/**
	* Returns the longitude of this e s f address.
	*
	* @return the longitude of this e s f address
	*/
	@Override
	public double getLongitude() {
		return _esfAddress.getLongitude();
	}

	/**
	* Sets the longitude of this e s f address.
	*
	* @param longitude the longitude of this e s f address
	*/
	@Override
	public void setLongitude(double longitude) {
		_esfAddress.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this e s f address.
	*
	* @return the latitude of this e s f address
	*/
	@Override
	public double getLatitude() {
		return _esfAddress.getLatitude();
	}

	/**
	* Sets the latitude of this e s f address.
	*
	* @param latitude the latitude of this e s f address
	*/
	@Override
	public void setLatitude(double latitude) {
		_esfAddress.setLatitude(latitude);
	}

	/**
	* Returns the esf country ID of this e s f address.
	*
	* @return the esf country ID of this e s f address
	*/
	@Override
	public java.lang.String getEsfCountryId() {
		return _esfAddress.getEsfCountryId();
	}

	/**
	* Sets the esf country ID of this e s f address.
	*
	* @param esfCountryId the esf country ID of this e s f address
	*/
	@Override
	public void setEsfCountryId(java.lang.String esfCountryId) {
		_esfAddress.setEsfCountryId(esfCountryId);
	}

	/**
	* Returns the esf region ID of this e s f address.
	*
	* @return the esf region ID of this e s f address
	*/
	@Override
	public java.lang.String getEsfRegionId() {
		return _esfAddress.getEsfRegionId();
	}

	/**
	* Sets the esf region ID of this e s f address.
	*
	* @param esfRegionId the esf region ID of this e s f address
	*/
	@Override
	public void setEsfRegionId(java.lang.String esfRegionId) {
		_esfAddress.setEsfRegionId(esfRegionId);
	}

	/**
	* Returns the esf province ID of this e s f address.
	*
	* @return the esf province ID of this e s f address
	*/
	@Override
	public java.lang.String getEsfProvinceId() {
		return _esfAddress.getEsfProvinceId();
	}

	/**
	* Sets the esf province ID of this e s f address.
	*
	* @param esfProvinceId the esf province ID of this e s f address
	*/
	@Override
	public void setEsfProvinceId(java.lang.String esfProvinceId) {
		_esfAddress.setEsfProvinceId(esfProvinceId);
	}

	/**
	* Returns the esf city ID of this e s f address.
	*
	* @return the esf city ID of this e s f address
	*/
	@Override
	public long getEsfCityId() {
		return _esfAddress.getEsfCityId();
	}

	/**
	* Sets the esf city ID of this e s f address.
	*
	* @param esfCityId the esf city ID of this e s f address
	*/
	@Override
	public void setEsfCityId(long esfCityId) {
		_esfAddress.setEsfCityId(esfCityId);
	}

	/**
	* Returns the group ID of this e s f address.
	*
	* @return the group ID of this e s f address
	*/
	@Override
	public long getGroupId() {
		return _esfAddress.getGroupId();
	}

	/**
	* Sets the group ID of this e s f address.
	*
	* @param groupId the group ID of this e s f address
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfAddress.setGroupId(groupId);
	}

	/**
	* Returns the type of this e s f address.
	*
	* @return the type of this e s f address
	*/
	@Override
	public java.lang.String getType() {
		return _esfAddress.getType();
	}

	/**
	* Sets the type of this e s f address.
	*
	* @param type the type of this e s f address
	*/
	@Override
	public void setType(java.lang.String type) {
		_esfAddress.setType(type);
	}

	/**
	* Returns the list type ID of this e s f address.
	*
	* @return the list type ID of this e s f address
	*/
	@Override
	public int getListTypeId() {
		return _esfAddress.getListTypeId();
	}

	/**
	* Sets the list type ID of this e s f address.
	*
	* @param listTypeId the list type ID of this e s f address
	*/
	@Override
	public void setListTypeId(int listTypeId) {
		_esfAddress.setListTypeId(listTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfAddress.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfAddress.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfAddress.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfAddress.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfAddress.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfAddress.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfAddress.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfAddress.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfAddress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfAddress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfAddress.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFAddressWrapper((ESFAddress)_esfAddress.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFAddress esfAddress) {
		return _esfAddress.compareTo(esfAddress);
	}

	@Override
	public int hashCode() {
		return _esfAddress.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFAddress> toCacheModel() {
		return _esfAddress.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFAddress toEscapedModel() {
		return new ESFAddressWrapper(_esfAddress.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFAddress toUnescapedModel() {
		return new ESFAddressWrapper(_esfAddress.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfAddress.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfAddress.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.persist();
	}

	@Override
	public boolean isWrapper() {
		return _esfAddress.isWrapper();
	}

	@Override
	public void setWrapper(boolean isWrapper) {
		_esfAddress.setWrapper(isWrapper);
	}

	@Override
	public long getCompanyId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getCompanyId();
	}

	@Override
	public void setCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setCompanyId(companyId);
	}

	@Override
	public long getUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getUserId();
	}

	@Override
	public void setUserId(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setUserId(userId);
	}

	@Override
	public java.lang.String getUserName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getUserName();
	}

	@Override
	public void setUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setUserName(userName);
	}

	@Override
	public java.util.Date getCreateDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getCreateDate();
	}

	@Override
	public void setCreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setCreateDate(createDate);
	}

	@Override
	public java.util.Date getModifiedDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getModifiedDate();
	}

	@Override
	public void setModifiedDate(java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setModifiedDate(modifiedDate);
	}

	@Override
	public long getClassNameId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getClassNameId();
	}

	@Override
	public void setClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setClassNameId(classNameId);
	}

	@Override
	public long getClassPk()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getClassPk();
	}

	@Override
	public void setClassPk(long classPk)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setClassPk(classPk);
	}

	@Override
	public java.lang.String getStreet1()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getStreet1();
	}

	@Override
	public void setStreet1(java.lang.String street1)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setStreet1(street1);
	}

	@Override
	public java.lang.String getStreet2()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getStreet2();
	}

	@Override
	public void setStreet2(java.lang.String street2)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setStreet2(street2);
	}

	@Override
	public java.lang.String getStreet3()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getStreet3();
	}

	@Override
	public void setStreet3(java.lang.String street3)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setStreet3(street3);
	}

	@Override
	public java.lang.String getZip()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getZip();
	}

	@Override
	public void setZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setZip(zip);
	}

	@Override
	public int getTypeId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getTypeId();
	}

	@Override
	public void setTypeId(int typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setTypeId(typeId);
	}

	@Override
	public boolean getMailing()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getMailing();
	}

	@Override
	public void setMailing(boolean mailing)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setMailing(mailing);
	}

	@Override
	public boolean getPrimary_()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAddress.getPrimary_();
	}

	@Override
	public void setPrimary_(boolean primary_)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfAddress.setPrimary_(primary_);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFAddressWrapper)) {
			return false;
		}

		ESFAddressWrapper esfAddressWrapper = (ESFAddressWrapper)obj;

		if (Validator.equals(_esfAddress, esfAddressWrapper._esfAddress)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFAddress getWrappedESFAddress() {
		return _esfAddress;
	}

	@Override
	public ESFAddress getWrappedModel() {
		return _esfAddress;
	}

	@Override
	public void resetOriginalValues() {
		_esfAddress.resetOriginalValues();
	}

	private ESFAddress _esfAddress;
}