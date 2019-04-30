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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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

import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.ESFUserRoleModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFUserRole service. Represents a row in the &quot;ESFUserRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFUserRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFUserRoleImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserRoleImpl
 * @see it.ethica.esf.model.ESFUserRole
 * @see it.ethica.esf.model.ESFUserRoleModel
 * @generated
 */
@JSON(strict = true)
public class ESFUserRoleModelImpl extends BaseModelImpl<ESFUserRole>
	implements ESFUserRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f user role model instance should use the {@link it.ethica.esf.model.ESFUserRole} interface instead.
	 */
	public static final String TABLE_NAME = "ESFUserRole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfUserRoleId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "isBDO", Types.BOOLEAN },
			{ "isLEA", Types.BOOLEAN },
			{ "type_", Types.INTEGER },
			{ "maxUser", Types.INTEGER },
			{ "isOrgAdmin", Types.BOOLEAN },
			{ "isEditable", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFUserRole (uuid_ VARCHAR(75) null,esfUserRoleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,isBDO BOOLEAN,isLEA BOOLEAN,type_ INTEGER,maxUser INTEGER,isOrgAdmin BOOLEAN,isEditable BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table ESFUserRole";
	public static final String ORDER_BY_JPQL = " ORDER BY esfUserRole.esfUserRoleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFUserRole.esfUserRoleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFUserRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFUserRole"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFUserRole"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long ISBDO_COLUMN_BITMASK = 4L;
	public static long ISLEA_COLUMN_BITMASK = 8L;
	public static long TYPE_COLUMN_BITMASK = 16L;
	public static long UUID_COLUMN_BITMASK = 32L;
	public static long ESFUSERROLEID_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFUserRole"));

	public ESFUserRoleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfUserRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfUserRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfUserRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUserRoleId", getEsfUserRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("isBDO", getIsBDO());
		attributes.put("isLEA", getIsLEA());
		attributes.put("type", getType());
		attributes.put("maxUser", getMaxUser());
		attributes.put("isOrgAdmin", getIsOrgAdmin());
		attributes.put("isEditable", getIsEditable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfUserRoleId = (Long)attributes.get("esfUserRoleId");

		if (esfUserRoleId != null) {
			setEsfUserRoleId(esfUserRoleId);
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

		Boolean isBDO = (Boolean)attributes.get("isBDO");

		if (isBDO != null) {
			setIsBDO(isBDO);
		}

		Boolean isLEA = (Boolean)attributes.get("isLEA");

		if (isLEA != null) {
			setIsLEA(isLEA);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer maxUser = (Integer)attributes.get("maxUser");

		if (maxUser != null) {
			setMaxUser(maxUser);
		}

		Boolean isOrgAdmin = (Boolean)attributes.get("isOrgAdmin");

		if (isOrgAdmin != null) {
			setIsOrgAdmin(isOrgAdmin);
		}

		Boolean isEditable = (Boolean)attributes.get("isEditable");

		if (isEditable != null) {
			setIsEditable(isEditable);
		}
	}

	@JSON
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

	@JSON
	@Override
	public long getEsfUserRoleId() {
		return _esfUserRoleId;
	}

	@Override
	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserRoleId = esfUserRoleId;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getIsBDO() {
		return _isBDO;
	}

	@Override
	public boolean isIsBDO() {
		return _isBDO;
	}

	@Override
	public void setIsBDO(boolean isBDO) {
		_columnBitmask |= ISBDO_COLUMN_BITMASK;

		if (!_setOriginalIsBDO) {
			_setOriginalIsBDO = true;

			_originalIsBDO = _isBDO;
		}

		_isBDO = isBDO;
	}

	public boolean getOriginalIsBDO() {
		return _originalIsBDO;
	}

	@JSON
	@Override
	public boolean getIsLEA() {
		return _isLEA;
	}

	@Override
	public boolean isIsLEA() {
		return _isLEA;
	}

	@Override
	public void setIsLEA(boolean isLEA) {
		_columnBitmask |= ISLEA_COLUMN_BITMASK;

		if (!_setOriginalIsLEA) {
			_setOriginalIsLEA = true;

			_originalIsLEA = _isLEA;
		}

		_isLEA = isLEA;
	}

	public boolean getOriginalIsLEA() {
		return _originalIsLEA;
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	@JSON
	@Override
	public int getMaxUser() {
		return _maxUser;
	}

	@Override
	public void setMaxUser(int maxUser) {
		_maxUser = maxUser;
	}

	@JSON
	@Override
	public boolean getIsOrgAdmin() {
		return _isOrgAdmin;
	}

	@Override
	public boolean isIsOrgAdmin() {
		return _isOrgAdmin;
	}

	@Override
	public void setIsOrgAdmin(boolean isOrgAdmin) {
		_isOrgAdmin = isOrgAdmin;
	}

	@JSON
	@Override
	public boolean getIsEditable() {
		return _isEditable;
	}

	@Override
	public boolean isIsEditable() {
		return _isEditable;
	}

	@Override
	public void setIsEditable(boolean isEditable) {
		_isEditable = isEditable;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFUserRole.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFUserRole.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFUserRole toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFUserRole)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFUserRoleImpl esfUserRoleImpl = new ESFUserRoleImpl();

		esfUserRoleImpl.setUuid(getUuid());
		esfUserRoleImpl.setEsfUserRoleId(getEsfUserRoleId());
		esfUserRoleImpl.setGroupId(getGroupId());
		esfUserRoleImpl.setCompanyId(getCompanyId());
		esfUserRoleImpl.setUserId(getUserId());
		esfUserRoleImpl.setUserName(getUserName());
		esfUserRoleImpl.setCreateDate(getCreateDate());
		esfUserRoleImpl.setModifiedDate(getModifiedDate());
		esfUserRoleImpl.setIsBDO(getIsBDO());
		esfUserRoleImpl.setIsLEA(getIsLEA());
		esfUserRoleImpl.setType(getType());
		esfUserRoleImpl.setMaxUser(getMaxUser());
		esfUserRoleImpl.setIsOrgAdmin(getIsOrgAdmin());
		esfUserRoleImpl.setIsEditable(getIsEditable());

		esfUserRoleImpl.resetOriginalValues();

		return esfUserRoleImpl;
	}

	@Override
	public int compareTo(ESFUserRole esfUserRole) {
		long primaryKey = esfUserRole.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserRole)) {
			return false;
		}

		ESFUserRole esfUserRole = (ESFUserRole)obj;

		long primaryKey = esfUserRole.getPrimaryKey();

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
		ESFUserRoleModelImpl esfUserRoleModelImpl = this;

		esfUserRoleModelImpl._originalUuid = esfUserRoleModelImpl._uuid;

		esfUserRoleModelImpl._originalGroupId = esfUserRoleModelImpl._groupId;

		esfUserRoleModelImpl._setOriginalGroupId = false;

		esfUserRoleModelImpl._originalCompanyId = esfUserRoleModelImpl._companyId;

		esfUserRoleModelImpl._setOriginalCompanyId = false;

		esfUserRoleModelImpl._originalIsBDO = esfUserRoleModelImpl._isBDO;

		esfUserRoleModelImpl._setOriginalIsBDO = false;

		esfUserRoleModelImpl._originalIsLEA = esfUserRoleModelImpl._isLEA;

		esfUserRoleModelImpl._setOriginalIsLEA = false;

		esfUserRoleModelImpl._originalType = esfUserRoleModelImpl._type;

		esfUserRoleModelImpl._setOriginalType = false;

		esfUserRoleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFUserRole> toCacheModel() {
		ESFUserRoleCacheModel esfUserRoleCacheModel = new ESFUserRoleCacheModel();

		esfUserRoleCacheModel.uuid = getUuid();

		String uuid = esfUserRoleCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfUserRoleCacheModel.uuid = null;
		}

		esfUserRoleCacheModel.esfUserRoleId = getEsfUserRoleId();

		esfUserRoleCacheModel.groupId = getGroupId();

		esfUserRoleCacheModel.companyId = getCompanyId();

		esfUserRoleCacheModel.userId = getUserId();

		esfUserRoleCacheModel.userName = getUserName();

		String userName = esfUserRoleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfUserRoleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfUserRoleCacheModel.createDate = createDate.getTime();
		}
		else {
			esfUserRoleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfUserRoleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfUserRoleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfUserRoleCacheModel.isBDO = getIsBDO();

		esfUserRoleCacheModel.isLEA = getIsLEA();

		esfUserRoleCacheModel.type = getType();

		esfUserRoleCacheModel.maxUser = getMaxUser();

		esfUserRoleCacheModel.isOrgAdmin = getIsOrgAdmin();

		esfUserRoleCacheModel.isEditable = getIsEditable();

		return esfUserRoleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfUserRoleId=");
		sb.append(getEsfUserRoleId());
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
		sb.append(", isBDO=");
		sb.append(getIsBDO());
		sb.append(", isLEA=");
		sb.append(getIsLEA());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", maxUser=");
		sb.append(getMaxUser());
		sb.append(", isOrgAdmin=");
		sb.append(getIsOrgAdmin());
		sb.append(", isEditable=");
		sb.append(getIsEditable());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFUserRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserRoleId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserRoleId());
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
			"<column><column-name>isBDO</column-name><column-value><![CDATA[");
		sb.append(getIsBDO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLEA</column-name><column-value><![CDATA[");
		sb.append(getIsLEA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxUser</column-name><column-value><![CDATA[");
		sb.append(getMaxUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isOrgAdmin</column-name><column-value><![CDATA[");
		sb.append(getIsOrgAdmin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isEditable</column-name><column-value><![CDATA[");
		sb.append(getIsEditable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFUserRole.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFUserRole.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfUserRoleId;
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
	private boolean _isBDO;
	private boolean _originalIsBDO;
	private boolean _setOriginalIsBDO;
	private boolean _isLEA;
	private boolean _originalIsLEA;
	private boolean _setOriginalIsLEA;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private int _maxUser;
	private boolean _isOrgAdmin;
	private boolean _isEditable;
	private long _columnBitmask;
	private ESFUserRole _escapedModel;
}