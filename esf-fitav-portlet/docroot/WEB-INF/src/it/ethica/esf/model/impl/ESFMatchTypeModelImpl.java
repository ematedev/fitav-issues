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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFMatchTypeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFMatchType service. Represents a row in the &quot;ESFMatchType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFMatchTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFMatchTypeImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFMatchTypeImpl
 * @see it.ethica.esf.model.ESFMatchType
 * @see it.ethica.esf.model.ESFMatchTypeModel
 * @generated
 */
public class ESFMatchTypeModelImpl extends BaseModelImpl<ESFMatchType>
	implements ESFMatchTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f match type model instance should use the {@link it.ethica.esf.model.ESFMatchType} interface instead.
	 */
	public static final String TABLE_NAME = "ESFMatchType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfMatchTypeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "isCategoryQualification", Types.BOOLEAN },
			{ "isNational", Types.BOOLEAN },
			{ "code_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFMatchType (esfMatchTypeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,isCategoryQualification BOOLEAN,isNational BOOLEAN,code_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFMatchType";
	public static final String ORDER_BY_JPQL = " ORDER BY esfMatchType.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFMatchType.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFMatchType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFMatchType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFMatchType"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long ISNATIONAL_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFMatchType"));

	public ESFMatchTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfMatchTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfMatchTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfMatchTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFMatchType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFMatchType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfMatchTypeId", getEsfMatchTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("isCategoryQualification", getIsCategoryQualification());
		attributes.put("isNational", getIsNational());
		attributes.put("code", getCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfMatchTypeId = (Long)attributes.get("esfMatchTypeId");

		if (esfMatchTypeId != null) {
			setEsfMatchTypeId(esfMatchTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean isCategoryQualification = (Boolean)attributes.get(
				"isCategoryQualification");

		if (isCategoryQualification != null) {
			setIsCategoryQualification(isCategoryQualification);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}
	}

	@Override
	public long getEsfMatchTypeId() {
		return _esfMatchTypeId;
	}

	@Override
	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchTypeId = esfMatchTypeId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public boolean getIsCategoryQualification() {
		return _isCategoryQualification;
	}

	@Override
	public boolean isIsCategoryQualification() {
		return _isCategoryQualification;
	}

	@Override
	public void setIsCategoryQualification(boolean isCategoryQualification) {
		_isCategoryQualification = isCategoryQualification;
	}

	@Override
	public boolean getIsNational() {
		return _isNational;
	}

	@Override
	public boolean isIsNational() {
		return _isNational;
	}

	@Override
	public void setIsNational(boolean isNational) {
		_columnBitmask |= ISNATIONAL_COLUMN_BITMASK;

		if (!_setOriginalIsNational) {
			_setOriginalIsNational = true;

			_originalIsNational = _isNational;
		}

		_isNational = isNational;
	}

	public boolean getOriginalIsNational() {
		return _originalIsNational;
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_columnBitmask |= CODE_COLUMN_BITMASK;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFMatchType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFMatchType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFMatchType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFMatchTypeImpl esfMatchTypeImpl = new ESFMatchTypeImpl();

		esfMatchTypeImpl.setEsfMatchTypeId(getEsfMatchTypeId());
		esfMatchTypeImpl.setGroupId(getGroupId());
		esfMatchTypeImpl.setCompanyId(getCompanyId());
		esfMatchTypeImpl.setUserId(getUserId());
		esfMatchTypeImpl.setUserName(getUserName());
		esfMatchTypeImpl.setCreateDate(getCreateDate());
		esfMatchTypeImpl.setModifiedDate(getModifiedDate());
		esfMatchTypeImpl.setName(getName());
		esfMatchTypeImpl.setIsCategoryQualification(getIsCategoryQualification());
		esfMatchTypeImpl.setIsNational(getIsNational());
		esfMatchTypeImpl.setCode(getCode());

		esfMatchTypeImpl.resetOriginalValues();

		return esfMatchTypeImpl;
	}

	@Override
	public int compareTo(ESFMatchType esfMatchType) {
		int value = 0;

		value = getName().compareTo(esfMatchType.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFMatchType)) {
			return false;
		}

		ESFMatchType esfMatchType = (ESFMatchType)obj;

		long primaryKey = esfMatchType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ESFMatchTypeModelImpl esfMatchTypeModelImpl = this;

		esfMatchTypeModelImpl._originalName = esfMatchTypeModelImpl._name;

		esfMatchTypeModelImpl._originalIsNational = esfMatchTypeModelImpl._isNational;

		esfMatchTypeModelImpl._setOriginalIsNational = false;

		esfMatchTypeModelImpl._originalCode = esfMatchTypeModelImpl._code;

		esfMatchTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFMatchType> toCacheModel() {
		ESFMatchTypeCacheModel esfMatchTypeCacheModel = new ESFMatchTypeCacheModel();

		esfMatchTypeCacheModel.esfMatchTypeId = getEsfMatchTypeId();

		esfMatchTypeCacheModel.groupId = getGroupId();

		esfMatchTypeCacheModel.companyId = getCompanyId();

		esfMatchTypeCacheModel.userId = getUserId();

		esfMatchTypeCacheModel.userName = getUserName();

		String userName = esfMatchTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfMatchTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfMatchTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			esfMatchTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfMatchTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfMatchTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfMatchTypeCacheModel.name = getName();

		String name = esfMatchTypeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfMatchTypeCacheModel.name = null;
		}

		esfMatchTypeCacheModel.isCategoryQualification = getIsCategoryQualification();

		esfMatchTypeCacheModel.isNational = getIsNational();

		esfMatchTypeCacheModel.code = getCode();

		String code = esfMatchTypeCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfMatchTypeCacheModel.code = null;
		}

		return esfMatchTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{esfMatchTypeId=");
		sb.append(getEsfMatchTypeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", isCategoryQualification=");
		sb.append(getIsCategoryQualification());
		sb.append(", isNational=");
		sb.append(getIsNational());
		sb.append(", code=");
		sb.append(getCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFMatchType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfMatchTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isCategoryQualification</column-name><column-value><![CDATA[");
		sb.append(getIsCategoryQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNational</column-name><column-value><![CDATA[");
		sb.append(getIsNational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFMatchType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFMatchType.class
		};
	private long _esfMatchTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private boolean _isCategoryQualification;
	private boolean _isNational;
	private boolean _originalIsNational;
	private boolean _setOriginalIsNational;
	private String _code;
	private String _originalCode;
	private long _columnBitmask;
	private ESFMatchType _escapedModel;
}