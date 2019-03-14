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
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.ESFFieldESFSportTypeModel;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFFieldESFSportType service. Represents a row in the &quot;ESFFieldESFSportType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFFieldESFSportTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFFieldESFSportTypeImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFSportTypeImpl
 * @see it.ethica.esf.model.ESFFieldESFSportType
 * @see it.ethica.esf.model.ESFFieldESFSportTypeModel
 * @generated
 */
public class ESFFieldESFSportTypeModelImpl extends BaseModelImpl<ESFFieldESFSportType>
	implements ESFFieldESFSportTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f field e s f sport type model instance should use the {@link it.ethica.esf.model.ESFFieldESFSportType} interface instead.
	 */
	public static final String TABLE_NAME = "ESFFieldESFSportType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfFieldId", Types.BIGINT },
			{ "esfSportTypeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFFieldESFSportType (esfFieldId LONG not null,esfSportTypeId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,primary key (esfFieldId, esfSportTypeId))";
	public static final String TABLE_SQL_DROP = "drop table ESFFieldESFSportType";
	public static final String ORDER_BY_JPQL = " ORDER BY esfFieldESFSportType.id.esfFieldId ASC, esfFieldESFSportType.id.esfSportTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFFieldESFSportType.esfFieldId ASC, ESFFieldESFSportType.esfSportTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFFieldESFSportType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFFieldESFSportType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFFieldESFSportType"),
			true);
	public static long ESFFIELDID_COLUMN_BITMASK = 1L;
	public static long ESFSPORTTYPEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFFieldESFSportType"));

	public ESFFieldESFSportTypeModelImpl() {
	}

	@Override
	public ESFFieldESFSportTypePK getPrimaryKey() {
		return new ESFFieldESFSportTypePK(_esfFieldId, _esfSportTypeId);
	}

	@Override
	public void setPrimaryKey(ESFFieldESFSportTypePK primaryKey) {
		setEsfFieldId(primaryKey.esfFieldId);
		setEsfSportTypeId(primaryKey.esfSportTypeId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFFieldESFSportTypePK(_esfFieldId, _esfSportTypeId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFFieldESFSportTypePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFieldESFSportType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFieldESFSportType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
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
	}

	@Override
	public long getEsfFieldId() {
		return _esfFieldId;
	}

	@Override
	public void setEsfFieldId(long esfFieldId) {
		_columnBitmask |= ESFFIELDID_COLUMN_BITMASK;

		if (!_setOriginalEsfFieldId) {
			_setOriginalEsfFieldId = true;

			_originalEsfFieldId = _esfFieldId;
		}

		_esfFieldId = esfFieldId;
	}

	public long getOriginalEsfFieldId() {
		return _originalEsfFieldId;
	}

	@Override
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_columnBitmask |= ESFSPORTTYPEID_COLUMN_BITMASK;

		if (!_setOriginalEsfSportTypeId) {
			_setOriginalEsfSportTypeId = true;

			_originalEsfSportTypeId = _esfSportTypeId;
		}

		_esfSportTypeId = esfSportTypeId;
	}

	public long getOriginalEsfSportTypeId() {
		return _originalEsfSportTypeId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFFieldESFSportType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFFieldESFSportType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFFieldESFSportTypeImpl esfFieldESFSportTypeImpl = new ESFFieldESFSportTypeImpl();

		esfFieldESFSportTypeImpl.setEsfFieldId(getEsfFieldId());
		esfFieldESFSportTypeImpl.setEsfSportTypeId(getEsfSportTypeId());
		esfFieldESFSportTypeImpl.setGroupId(getGroupId());
		esfFieldESFSportTypeImpl.setCompanyId(getCompanyId());
		esfFieldESFSportTypeImpl.setUserId(getUserId());
		esfFieldESFSportTypeImpl.setUserName(getUserName());
		esfFieldESFSportTypeImpl.setCreateDate(getCreateDate());
		esfFieldESFSportTypeImpl.setModifiedDate(getModifiedDate());

		esfFieldESFSportTypeImpl.resetOriginalValues();

		return esfFieldESFSportTypeImpl;
	}

	@Override
	public int compareTo(ESFFieldESFSportType esfFieldESFSportType) {
		ESFFieldESFSportTypePK primaryKey = esfFieldESFSportType.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFieldESFSportType)) {
			return false;
		}

		ESFFieldESFSportType esfFieldESFSportType = (ESFFieldESFSportType)obj;

		ESFFieldESFSportTypePK primaryKey = esfFieldESFSportType.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		ESFFieldESFSportTypeModelImpl esfFieldESFSportTypeModelImpl = this;

		esfFieldESFSportTypeModelImpl._originalEsfFieldId = esfFieldESFSportTypeModelImpl._esfFieldId;

		esfFieldESFSportTypeModelImpl._setOriginalEsfFieldId = false;

		esfFieldESFSportTypeModelImpl._originalEsfSportTypeId = esfFieldESFSportTypeModelImpl._esfSportTypeId;

		esfFieldESFSportTypeModelImpl._setOriginalEsfSportTypeId = false;

		esfFieldESFSportTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFFieldESFSportType> toCacheModel() {
		ESFFieldESFSportTypeCacheModel esfFieldESFSportTypeCacheModel = new ESFFieldESFSportTypeCacheModel();

		esfFieldESFSportTypeCacheModel.esfFieldId = getEsfFieldId();

		esfFieldESFSportTypeCacheModel.esfSportTypeId = getEsfSportTypeId();

		esfFieldESFSportTypeCacheModel.groupId = getGroupId();

		esfFieldESFSportTypeCacheModel.companyId = getCompanyId();

		esfFieldESFSportTypeCacheModel.userId = getUserId();

		esfFieldESFSportTypeCacheModel.userName = getUserName();

		String userName = esfFieldESFSportTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfFieldESFSportTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfFieldESFSportTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			esfFieldESFSportTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfFieldESFSportTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfFieldESFSportTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return esfFieldESFSportTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{esfFieldId=");
		sb.append(getEsfFieldId());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFieldESFSportType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfFieldId</column-name><column-value><![CDATA[");
		sb.append(getEsfFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFFieldESFSportType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFFieldESFSportType.class
		};
	private long _esfFieldId;
	private long _originalEsfFieldId;
	private boolean _setOriginalEsfFieldId;
	private long _esfSportTypeId;
	private long _originalEsfSportTypeId;
	private boolean _setOriginalEsfSportTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private ESFFieldESFSportType _escapedModel;
}