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
import com.liferay.portal.kernel.lar.StagedModelType;
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

import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunKindModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFGunKind service. Represents a row in the &quot;ESF_ESFGunKind&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFGunKindModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFGunKindImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFGunKindImpl
 * @see it.ethica.esf.model.ESFGunKind
 * @see it.ethica.esf.model.ESFGunKindModel
 * @generated
 */
public class ESFGunKindModelImpl extends BaseModelImpl<ESFGunKind>
	implements ESFGunKindModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f gun kind model instance should use the {@link it.ethica.esf.model.ESFGunKind} interface instead.
	 */
	public static final String TABLE_NAME = "ESF_ESFGunKind";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfGunKindId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "esfGunTypeId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESF_ESFGunKind (uuid_ VARCHAR(75) null,esfGunKindId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,esfGunTypeId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESF_ESFGunKind";
	public static final String ORDER_BY_JPQL = " ORDER BY esfGunKind.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESF_ESFGunKind.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFGunKind"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFGunKind"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFGunKind"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long ESFGUNTYPEID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;
	public static long NAME_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFGunKind"));

	public ESFGunKindModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfGunKindId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfGunKindId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfGunKindId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFGunKind.class;
	}

	@Override
	public String getModelClassName() {
		return ESFGunKind.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("esfGunTypeId", getEsfGunTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getEsfGunKindId() {
		return _esfGunKindId;
	}

	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKindId = esfGunKindId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
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

		_name = name;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public long getEsfGunTypeId() {
		return _esfGunTypeId;
	}

	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_columnBitmask |= ESFGUNTYPEID_COLUMN_BITMASK;

		if (!_setOriginalEsfGunTypeId) {
			_setOriginalEsfGunTypeId = true;

			_originalEsfGunTypeId = _esfGunTypeId;
		}

		_esfGunTypeId = esfGunTypeId;
	}

	public long getOriginalEsfGunTypeId() {
		return _originalEsfGunTypeId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFGunKind.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFGunKind.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFGunKind toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFGunKind)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFGunKindImpl esfGunKindImpl = new ESFGunKindImpl();

		esfGunKindImpl.setUuid(getUuid());
		esfGunKindImpl.setEsfGunKindId(getEsfGunKindId());
		esfGunKindImpl.setGroupId(getGroupId());
		esfGunKindImpl.setCompanyId(getCompanyId());
		esfGunKindImpl.setUserId(getUserId());
		esfGunKindImpl.setUserName(getUserName());
		esfGunKindImpl.setCreateDate(getCreateDate());
		esfGunKindImpl.setModifiedDate(getModifiedDate());
		esfGunKindImpl.setName(getName());
		esfGunKindImpl.setDescription(getDescription());
		esfGunKindImpl.setEsfGunTypeId(getEsfGunTypeId());

		esfGunKindImpl.resetOriginalValues();

		return esfGunKindImpl;
	}

	@Override
	public int compareTo(ESFGunKind esfGunKind) {
		int value = 0;

		value = getName().compareTo(esfGunKind.getName());

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

		if (!(obj instanceof ESFGunKind)) {
			return false;
		}

		ESFGunKind esfGunKind = (ESFGunKind)obj;

		long primaryKey = esfGunKind.getPrimaryKey();

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
		ESFGunKindModelImpl esfGunKindModelImpl = this;

		esfGunKindModelImpl._originalUuid = esfGunKindModelImpl._uuid;

		esfGunKindModelImpl._originalGroupId = esfGunKindModelImpl._groupId;

		esfGunKindModelImpl._setOriginalGroupId = false;

		esfGunKindModelImpl._originalCompanyId = esfGunKindModelImpl._companyId;

		esfGunKindModelImpl._setOriginalCompanyId = false;

		esfGunKindModelImpl._originalEsfGunTypeId = esfGunKindModelImpl._esfGunTypeId;

		esfGunKindModelImpl._setOriginalEsfGunTypeId = false;

		esfGunKindModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFGunKind> toCacheModel() {
		ESFGunKindCacheModel esfGunKindCacheModel = new ESFGunKindCacheModel();

		esfGunKindCacheModel.uuid = getUuid();

		String uuid = esfGunKindCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfGunKindCacheModel.uuid = null;
		}

		esfGunKindCacheModel.esfGunKindId = getEsfGunKindId();

		esfGunKindCacheModel.groupId = getGroupId();

		esfGunKindCacheModel.companyId = getCompanyId();

		esfGunKindCacheModel.userId = getUserId();

		esfGunKindCacheModel.userName = getUserName();

		String userName = esfGunKindCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfGunKindCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfGunKindCacheModel.createDate = createDate.getTime();
		}
		else {
			esfGunKindCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfGunKindCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfGunKindCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfGunKindCacheModel.name = getName();

		String name = esfGunKindCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfGunKindCacheModel.name = null;
		}

		esfGunKindCacheModel.description = getDescription();

		String description = esfGunKindCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfGunKindCacheModel.description = null;
		}

		esfGunKindCacheModel.esfGunTypeId = getEsfGunTypeId();

		return esfGunKindCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfGunKindId=");
		sb.append(getEsfGunKindId());
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
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", esfGunTypeId=");
		sb.append(getEsfGunTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFGunKind");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunKindId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunKindId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFGunKind.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFGunKind.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfGunKindId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private long _esfGunTypeId;
	private long _originalEsfGunTypeId;
	private boolean _setOriginalEsfGunTypeId;
	private long _columnBitmask;
	private ESFGunKind _escapedModel;
}