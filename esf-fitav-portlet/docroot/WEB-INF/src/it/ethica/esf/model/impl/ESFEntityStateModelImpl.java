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

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFEntityStateModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFEntityState service. Represents a row in the &quot;ESFEntityState&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFEntityStateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFEntityStateImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFEntityStateImpl
 * @see it.ethica.esf.model.ESFEntityState
 * @see it.ethica.esf.model.ESFEntityStateModel
 * @generated
 */
@JSON(strict = true)
public class ESFEntityStateModelImpl extends BaseModelImpl<ESFEntityState>
	implements ESFEntityStateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f entity state model instance should use the {@link it.ethica.esf.model.ESFEntityState} interface instead.
	 */
	public static final String TABLE_NAME = "ESFEntityState";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfEntityStateId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "className", Types.VARCHAR },
			{ "classPK", Types.BIGINT },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "esfStateId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFEntityState (esfEntityStateId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,className VARCHAR(75) null,classPK LONG,startDate DATE null,endDate DATE null,esfStateId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFEntityState";
	public static final String ORDER_BY_JPQL = " ORDER BY esfEntityState.esfEntityStateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFEntityState.esfEntityStateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFEntityState"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFEntityState"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFEntityState"),
			true);
	public static long CLASSNAME_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long ESFSTATEID_COLUMN_BITMASK = 4L;
	public static long ESFENTITYSTATEID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFEntityState"));

	public ESFEntityStateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfEntityStateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfEntityStateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfEntityStateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFEntityState.class;
	}

	@Override
	public String getModelClassName() {
		return ESFEntityState.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfEntityStateId", getEsfEntityStateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("esfStateId", getEsfStateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfEntityStateId = (Long)attributes.get("esfEntityStateId");

		if (esfEntityStateId != null) {
			setEsfEntityStateId(esfEntityStateId);
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

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
		}
	}

	@JSON
	@Override
	public long getEsfEntityStateId() {
		return _esfEntityStateId;
	}

	@Override
	public void setEsfEntityStateId(long esfEntityStateId) {
		_esfEntityStateId = esfEntityStateId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
	public String getClassName() {
		if (_className == null) {
			return StringPool.BLANK;
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_columnBitmask |= CLASSNAME_COLUMN_BITMASK;

		if (_originalClassName == null) {
			_originalClassName = _className;
		}

		_className = className;
	}

	public String getOriginalClassName() {
		return GetterUtil.getString(_originalClassName);
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public long getEsfStateId() {
		return _esfStateId;
	}

	@Override
	public void setEsfStateId(long esfStateId) {
		_columnBitmask |= ESFSTATEID_COLUMN_BITMASK;

		if (!_setOriginalEsfStateId) {
			_setOriginalEsfStateId = true;

			_originalEsfStateId = _esfStateId;
		}

		_esfStateId = esfStateId;
	}

	public long getOriginalEsfStateId() {
		return _originalEsfStateId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFEntityState.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFEntityState toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFEntityState)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFEntityStateImpl esfEntityStateImpl = new ESFEntityStateImpl();

		esfEntityStateImpl.setEsfEntityStateId(getEsfEntityStateId());
		esfEntityStateImpl.setGroupId(getGroupId());
		esfEntityStateImpl.setCompanyId(getCompanyId());
		esfEntityStateImpl.setUserId(getUserId());
		esfEntityStateImpl.setUserName(getUserName());
		esfEntityStateImpl.setCreateDate(getCreateDate());
		esfEntityStateImpl.setModifiedDate(getModifiedDate());
		esfEntityStateImpl.setClassName(getClassName());
		esfEntityStateImpl.setClassPK(getClassPK());
		esfEntityStateImpl.setStartDate(getStartDate());
		esfEntityStateImpl.setEndDate(getEndDate());
		esfEntityStateImpl.setEsfStateId(getEsfStateId());

		esfEntityStateImpl.resetOriginalValues();

		return esfEntityStateImpl;
	}

	@Override
	public int compareTo(ESFEntityState esfEntityState) {
		long primaryKey = esfEntityState.getPrimaryKey();

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

		if (!(obj instanceof ESFEntityState)) {
			return false;
		}

		ESFEntityState esfEntityState = (ESFEntityState)obj;

		long primaryKey = esfEntityState.getPrimaryKey();

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
		ESFEntityStateModelImpl esfEntityStateModelImpl = this;

		esfEntityStateModelImpl._originalClassName = esfEntityStateModelImpl._className;

		esfEntityStateModelImpl._originalClassPK = esfEntityStateModelImpl._classPK;

		esfEntityStateModelImpl._setOriginalClassPK = false;

		esfEntityStateModelImpl._originalEsfStateId = esfEntityStateModelImpl._esfStateId;

		esfEntityStateModelImpl._setOriginalEsfStateId = false;

		esfEntityStateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFEntityState> toCacheModel() {
		ESFEntityStateCacheModel esfEntityStateCacheModel = new ESFEntityStateCacheModel();

		esfEntityStateCacheModel.esfEntityStateId = getEsfEntityStateId();

		esfEntityStateCacheModel.groupId = getGroupId();

		esfEntityStateCacheModel.companyId = getCompanyId();

		esfEntityStateCacheModel.userId = getUserId();

		esfEntityStateCacheModel.userName = getUserName();

		String userName = esfEntityStateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfEntityStateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfEntityStateCacheModel.createDate = createDate.getTime();
		}
		else {
			esfEntityStateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfEntityStateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfEntityStateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfEntityStateCacheModel.className = getClassName();

		String className = esfEntityStateCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			esfEntityStateCacheModel.className = null;
		}

		esfEntityStateCacheModel.classPK = getClassPK();

		Date startDate = getStartDate();

		if (startDate != null) {
			esfEntityStateCacheModel.startDate = startDate.getTime();
		}
		else {
			esfEntityStateCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			esfEntityStateCacheModel.endDate = endDate.getTime();
		}
		else {
			esfEntityStateCacheModel.endDate = Long.MIN_VALUE;
		}

		esfEntityStateCacheModel.esfStateId = getEsfStateId();

		return esfEntityStateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{esfEntityStateId=");
		sb.append(getEsfEntityStateId());
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
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", esfStateId=");
		sb.append(getEsfStateId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFEntityState");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfEntityStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfEntityStateId());
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
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
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
			"<column><column-name>esfStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfStateId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFEntityState.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFEntityState.class
		};
	private long _esfEntityStateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _className;
	private String _originalClassName;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private Date _startDate;
	private Date _endDate;
	private long _esfStateId;
	private long _originalEsfStateId;
	private boolean _setOriginalEsfStateId;
	private long _columnBitmask;
	private ESFEntityState _escapedModel;
}