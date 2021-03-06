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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.model.ESFShooterCategoryESFMatch;
import it.ethica.esf.model.ESFShooterCategoryESFMatchModel;
import it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFShooterCategoryESFMatch service. Represents a row in the &quot;ESFShooterCategoryESFMatch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFShooterCategoryESFMatchModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFShooterCategoryESFMatchImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategoryESFMatchImpl
 * @see it.ethica.esf.model.ESFShooterCategoryESFMatch
 * @see it.ethica.esf.model.ESFShooterCategoryESFMatchModel
 * @generated
 */
public class ESFShooterCategoryESFMatchModelImpl extends BaseModelImpl<ESFShooterCategoryESFMatch>
	implements ESFShooterCategoryESFMatchModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f shooter category e s f match model instance should use the {@link it.ethica.esf.model.ESFShooterCategoryESFMatch} interface instead.
	 */
	public static final String TABLE_NAME = "ESFShooterCategoryESFMatch";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfShooterCategoryId", Types.BIGINT },
			{ "esfMatchId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFShooterCategoryESFMatch (uuid_ VARCHAR(75) null,esfShooterCategoryId LONG not null,esfMatchId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,primary key (esfShooterCategoryId, esfMatchId))";
	public static final String TABLE_SQL_DROP = "drop table ESFShooterCategoryESFMatch";
	public static final String ORDER_BY_JPQL = " ORDER BY esfShooterCategoryESFMatch.id.esfShooterCategoryId ASC, esfShooterCategoryESFMatch.id.esfMatchId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFShooterCategoryESFMatch.esfShooterCategoryId ASC, ESFShooterCategoryESFMatch.esfMatchId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFShooterCategoryESFMatch"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFShooterCategoryESFMatch"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFShooterCategoryESFMatch"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long ESFMATCHID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;
	public static long ESFSHOOTERCATEGORYID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFShooterCategoryESFMatch"));

	public ESFShooterCategoryESFMatchModelImpl() {
	}

	@Override
	public ESFShooterCategoryESFMatchPK getPrimaryKey() {
		return new ESFShooterCategoryESFMatchPK(_esfShooterCategoryId,
			_esfMatchId);
	}

	@Override
	public void setPrimaryKey(ESFShooterCategoryESFMatchPK primaryKey) {
		setEsfShooterCategoryId(primaryKey.esfShooterCategoryId);
		setEsfMatchId(primaryKey.esfMatchId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFShooterCategoryESFMatchPK(_esfShooterCategoryId,
			_esfMatchId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFShooterCategoryESFMatchPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterCategoryESFMatch.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterCategoryESFMatch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterCategoryId", getEsfShooterCategoryId());
		attributes.put("esfMatchId", getEsfMatchId());
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
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterCategoryId = (Long)attributes.get("esfShooterCategoryId");

		if (esfShooterCategoryId != null) {
			setEsfShooterCategoryId(esfShooterCategoryId);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
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
	public long getEsfShooterCategoryId() {
		return _esfShooterCategoryId;
	}

	@Override
	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategoryId = esfShooterCategoryId;
	}

	@Override
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_columnBitmask |= ESFMATCHID_COLUMN_BITMASK;

		if (!_setOriginalEsfMatchId) {
			_setOriginalEsfMatchId = true;

			_originalEsfMatchId = _esfMatchId;
		}

		_esfMatchId = esfMatchId;
	}

	public long getOriginalEsfMatchId() {
		return _originalEsfMatchId;
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
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFShooterCategoryESFMatch.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFShooterCategoryESFMatch toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFShooterCategoryESFMatch)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFShooterCategoryESFMatchImpl esfShooterCategoryESFMatchImpl = new ESFShooterCategoryESFMatchImpl();

		esfShooterCategoryESFMatchImpl.setUuid(getUuid());
		esfShooterCategoryESFMatchImpl.setEsfShooterCategoryId(getEsfShooterCategoryId());
		esfShooterCategoryESFMatchImpl.setEsfMatchId(getEsfMatchId());
		esfShooterCategoryESFMatchImpl.setGroupId(getGroupId());
		esfShooterCategoryESFMatchImpl.setCompanyId(getCompanyId());
		esfShooterCategoryESFMatchImpl.setUserId(getUserId());
		esfShooterCategoryESFMatchImpl.setUserName(getUserName());
		esfShooterCategoryESFMatchImpl.setCreateDate(getCreateDate());
		esfShooterCategoryESFMatchImpl.setModifiedDate(getModifiedDate());

		esfShooterCategoryESFMatchImpl.resetOriginalValues();

		return esfShooterCategoryESFMatchImpl;
	}

	@Override
	public int compareTo(ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		ESFShooterCategoryESFMatchPK primaryKey = esfShooterCategoryESFMatch.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterCategoryESFMatch)) {
			return false;
		}

		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = (ESFShooterCategoryESFMatch)obj;

		ESFShooterCategoryESFMatchPK primaryKey = esfShooterCategoryESFMatch.getPrimaryKey();

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
		ESFShooterCategoryESFMatchModelImpl esfShooterCategoryESFMatchModelImpl = this;

		esfShooterCategoryESFMatchModelImpl._originalUuid = esfShooterCategoryESFMatchModelImpl._uuid;

		esfShooterCategoryESFMatchModelImpl._originalEsfMatchId = esfShooterCategoryESFMatchModelImpl._esfMatchId;

		esfShooterCategoryESFMatchModelImpl._setOriginalEsfMatchId = false;

		esfShooterCategoryESFMatchModelImpl._originalGroupId = esfShooterCategoryESFMatchModelImpl._groupId;

		esfShooterCategoryESFMatchModelImpl._setOriginalGroupId = false;

		esfShooterCategoryESFMatchModelImpl._originalCompanyId = esfShooterCategoryESFMatchModelImpl._companyId;

		esfShooterCategoryESFMatchModelImpl._setOriginalCompanyId = false;

		esfShooterCategoryESFMatchModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFShooterCategoryESFMatch> toCacheModel() {
		ESFShooterCategoryESFMatchCacheModel esfShooterCategoryESFMatchCacheModel =
			new ESFShooterCategoryESFMatchCacheModel();

		esfShooterCategoryESFMatchCacheModel.uuid = getUuid();

		String uuid = esfShooterCategoryESFMatchCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfShooterCategoryESFMatchCacheModel.uuid = null;
		}

		esfShooterCategoryESFMatchCacheModel.esfShooterCategoryId = getEsfShooterCategoryId();

		esfShooterCategoryESFMatchCacheModel.esfMatchId = getEsfMatchId();

		esfShooterCategoryESFMatchCacheModel.groupId = getGroupId();

		esfShooterCategoryESFMatchCacheModel.companyId = getCompanyId();

		esfShooterCategoryESFMatchCacheModel.userId = getUserId();

		esfShooterCategoryESFMatchCacheModel.userName = getUserName();

		String userName = esfShooterCategoryESFMatchCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfShooterCategoryESFMatchCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfShooterCategoryESFMatchCacheModel.createDate = createDate.getTime();
		}
		else {
			esfShooterCategoryESFMatchCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfShooterCategoryESFMatchCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfShooterCategoryESFMatchCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return esfShooterCategoryESFMatchCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfShooterCategoryId=");
		sb.append(getEsfShooterCategoryId());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterCategoryESFMatch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
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

	private static ClassLoader _classLoader = ESFShooterCategoryESFMatch.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFShooterCategoryESFMatch.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfShooterCategoryId;
	private long _esfMatchId;
	private long _originalEsfMatchId;
	private boolean _setOriginalEsfMatchId;
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
	private long _columnBitmask;
	private ESFShooterCategoryESFMatch _escapedModel;
}