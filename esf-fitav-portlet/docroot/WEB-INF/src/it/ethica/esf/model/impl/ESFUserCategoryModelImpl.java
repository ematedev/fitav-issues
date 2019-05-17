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

import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.ESFUserCategoryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFUserCategory service. Represents a row in the &quot;ESFUserCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFUserCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFUserCategoryImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserCategoryImpl
 * @see it.ethica.esf.model.ESFUserCategory
 * @see it.ethica.esf.model.ESFUserCategoryModel
 * @generated
 */
public class ESFUserCategoryModelImpl extends BaseModelImpl<ESFUserCategory>
	implements ESFUserCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f user category model instance should use the {@link it.ethica.esf.model.ESFUserCategory} interface instead.
	 */
	public static final String TABLE_NAME = "ESFUserCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfUserCategoryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "esfUserId", Types.BIGINT },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "esfCategoryId", Types.BIGINT },
			{ "esfSportTypeId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFUserCategory (esfUserCategoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,esfUserId LONG,startDate DATE null,endDate DATE null,esfCategoryId LONG,esfSportTypeId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFUserCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY esfUserCategory.esfUserCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFUserCategory.esfUserCategoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFUserCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFUserCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFUserCategory"),
			true);
	public static long ESFCATEGORYID_COLUMN_BITMASK = 1L;
	public static long ESFSPORTTYPEID_COLUMN_BITMASK = 2L;
	public static long ESFUSERID_COLUMN_BITMASK = 4L;
	public static long ESFUSERCATEGORYID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFUserCategory"));

	public ESFUserCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfUserCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfUserCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfUserCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserCategoryId", getEsfUserCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("esfCategoryId", getEsfCategoryId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserCategoryId = (Long)attributes.get("esfUserCategoryId");

		if (esfUserCategoryId != null) {
			setEsfUserCategoryId(esfUserCategoryId);
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

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long esfCategoryId = (Long)attributes.get("esfCategoryId");

		if (esfCategoryId != null) {
			setEsfCategoryId(esfCategoryId);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}
	}

	@Override
	public long getEsfUserCategoryId() {
		return _esfUserCategoryId;
	}

	@Override
	public void setEsfUserCategoryId(long esfUserCategoryId) {
		_esfUserCategoryId = esfUserCategoryId;
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
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_columnBitmask |= ESFUSERID_COLUMN_BITMASK;

		if (!_setOriginalEsfUserId) {
			_setOriginalEsfUserId = true;

			_originalEsfUserId = _esfUserId;
		}

		_esfUserId = esfUserId;
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	public long getOriginalEsfUserId() {
		return _originalEsfUserId;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public long getEsfCategoryId() {
		return _esfCategoryId;
	}

	@Override
	public void setEsfCategoryId(long esfCategoryId) {
		_columnBitmask |= ESFCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalEsfCategoryId) {
			_setOriginalEsfCategoryId = true;

			_originalEsfCategoryId = _esfCategoryId;
		}

		_esfCategoryId = esfCategoryId;
	}

	public long getOriginalEsfCategoryId() {
		return _originalEsfCategoryId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFUserCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFUserCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFUserCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFUserCategoryImpl esfUserCategoryImpl = new ESFUserCategoryImpl();

		esfUserCategoryImpl.setEsfUserCategoryId(getEsfUserCategoryId());
		esfUserCategoryImpl.setGroupId(getGroupId());
		esfUserCategoryImpl.setCompanyId(getCompanyId());
		esfUserCategoryImpl.setUserId(getUserId());
		esfUserCategoryImpl.setUserName(getUserName());
		esfUserCategoryImpl.setCreateDate(getCreateDate());
		esfUserCategoryImpl.setModifiedDate(getModifiedDate());
		esfUserCategoryImpl.setEsfUserId(getEsfUserId());
		esfUserCategoryImpl.setStartDate(getStartDate());
		esfUserCategoryImpl.setEndDate(getEndDate());
		esfUserCategoryImpl.setEsfCategoryId(getEsfCategoryId());
		esfUserCategoryImpl.setEsfSportTypeId(getEsfSportTypeId());

		esfUserCategoryImpl.resetOriginalValues();

		return esfUserCategoryImpl;
	}

	@Override
	public int compareTo(ESFUserCategory esfUserCategory) {
		long primaryKey = esfUserCategory.getPrimaryKey();

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

		if (!(obj instanceof ESFUserCategory)) {
			return false;
		}

		ESFUserCategory esfUserCategory = (ESFUserCategory)obj;

		long primaryKey = esfUserCategory.getPrimaryKey();

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
		ESFUserCategoryModelImpl esfUserCategoryModelImpl = this;

		esfUserCategoryModelImpl._originalEsfUserId = esfUserCategoryModelImpl._esfUserId;

		esfUserCategoryModelImpl._setOriginalEsfUserId = false;

		esfUserCategoryModelImpl._originalEsfCategoryId = esfUserCategoryModelImpl._esfCategoryId;

		esfUserCategoryModelImpl._setOriginalEsfCategoryId = false;

		esfUserCategoryModelImpl._originalEsfSportTypeId = esfUserCategoryModelImpl._esfSportTypeId;

		esfUserCategoryModelImpl._setOriginalEsfSportTypeId = false;

		esfUserCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFUserCategory> toCacheModel() {
		ESFUserCategoryCacheModel esfUserCategoryCacheModel = new ESFUserCategoryCacheModel();

		esfUserCategoryCacheModel.esfUserCategoryId = getEsfUserCategoryId();

		esfUserCategoryCacheModel.groupId = getGroupId();

		esfUserCategoryCacheModel.companyId = getCompanyId();

		esfUserCategoryCacheModel.userId = getUserId();

		esfUserCategoryCacheModel.userName = getUserName();

		String userName = esfUserCategoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfUserCategoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfUserCategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			esfUserCategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfUserCategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfUserCategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfUserCategoryCacheModel.esfUserId = getEsfUserId();

		Date startDate = getStartDate();

		if (startDate != null) {
			esfUserCategoryCacheModel.startDate = startDate.getTime();
		}
		else {
			esfUserCategoryCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			esfUserCategoryCacheModel.endDate = endDate.getTime();
		}
		else {
			esfUserCategoryCacheModel.endDate = Long.MIN_VALUE;
		}

		esfUserCategoryCacheModel.esfCategoryId = getEsfCategoryId();

		esfUserCategoryCacheModel.esfSportTypeId = getEsfSportTypeId();

		return esfUserCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{esfUserCategoryId=");
		sb.append(getEsfUserCategoryId());
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
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", esfCategoryId=");
		sb.append(getEsfCategoryId());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFUserCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfUserCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserCategoryId());
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
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFUserCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFUserCategory.class
		};
	private long _esfUserCategoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _originalEsfUserId;
	private boolean _setOriginalEsfUserId;
	private Date _startDate;
	private Date _endDate;
	private long _esfCategoryId;
	private long _originalEsfCategoryId;
	private boolean _setOriginalEsfCategoryId;
	private long _esfSportTypeId;
	private long _originalEsfSportTypeId;
	private boolean _setOriginalEsfSportTypeId;
	private long _columnBitmask;
	private ESFUserCategory _escapedModel;
}