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

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFDocumentModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFDocument service. Represents a row in the &quot;ESFDocument&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFDocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFDocumentImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentImpl
 * @see it.ethica.esf.model.ESFDocument
 * @see it.ethica.esf.model.ESFDocumentModel
 * @generated
 */
public class ESFDocumentModelImpl extends BaseModelImpl<ESFDocument>
	implements ESFDocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f document model instance should use the {@link it.ethica.esf.model.ESFDocument} interface instead.
	 */
	public static final String TABLE_NAME = "ESFDocument";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfDocumentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "code_", Types.VARCHAR },
			{ "releasedBy", Types.VARCHAR },
			{ "releaseDate", Types.TIMESTAMP },
			{ "expirationDate", Types.TIMESTAMP },
			{ "esfUserId", Types.BIGINT },
			{ "type_", Types.VARCHAR },
			{ "path_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFDocument (esfDocumentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,releasedBy VARCHAR(75) null,releaseDate DATE null,expirationDate DATE null,esfUserId LONG,type_ VARCHAR(75) null,path_ VARCHAR(255) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFDocument";
	public static final String ORDER_BY_JPQL = " ORDER BY esfDocument.esfDocumentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFDocument.esfDocumentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFDocument"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFDocument"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFDocument"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long ESFUSERID_COLUMN_BITMASK = 2L;
	public static long EXPIRATIONDATE_COLUMN_BITMASK = 4L;
	public static long TYPE_COLUMN_BITMASK = 8L;
	public static long ESFDOCUMENTID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFDocument"));

	public ESFDocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDocumentId", getEsfDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("releasedBy", getReleasedBy());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("type", getType());
		attributes.put("path", getPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentId = (Long)attributes.get("esfDocumentId");

		if (esfDocumentId != null) {
			setEsfDocumentId(esfDocumentId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String releasedBy = (String)attributes.get("releasedBy");

		if (releasedBy != null) {
			setReleasedBy(releasedBy);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}
	}

	@Override
	public long getEsfDocumentId() {
		return _esfDocumentId;
	}

	@Override
	public void setEsfDocumentId(long esfDocumentId) {
		_esfDocumentId = esfDocumentId;
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

	@Override
	public String getReleasedBy() {
		if (_releasedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _releasedBy;
		}
	}

	@Override
	public void setReleasedBy(String releasedBy) {
		_releasedBy = releasedBy;
	}

	@Override
	public Date getReleaseDate() {
		return _releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;
	}

	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		_columnBitmask |= EXPIRATIONDATE_COLUMN_BITMASK;

		if (_originalExpirationDate == null) {
			_originalExpirationDate = _expirationDate;
		}

		_expirationDate = expirationDate;
	}

	public Date getOriginalExpirationDate() {
		return _originalExpirationDate;
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
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@Override
	public String getPath() {
		if (_path == null) {
			return StringPool.BLANK;
		}
		else {
			return _path;
		}
	}

	@Override
	public void setPath(String path) {
		_path = path;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFDocument.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFDocument toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFDocument)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFDocumentImpl esfDocumentImpl = new ESFDocumentImpl();

		esfDocumentImpl.setEsfDocumentId(getEsfDocumentId());
		esfDocumentImpl.setGroupId(getGroupId());
		esfDocumentImpl.setCompanyId(getCompanyId());
		esfDocumentImpl.setUserId(getUserId());
		esfDocumentImpl.setUserName(getUserName());
		esfDocumentImpl.setCreateDate(getCreateDate());
		esfDocumentImpl.setModifiedDate(getModifiedDate());
		esfDocumentImpl.setCode(getCode());
		esfDocumentImpl.setReleasedBy(getReleasedBy());
		esfDocumentImpl.setReleaseDate(getReleaseDate());
		esfDocumentImpl.setExpirationDate(getExpirationDate());
		esfDocumentImpl.setEsfUserId(getEsfUserId());
		esfDocumentImpl.setType(getType());
		esfDocumentImpl.setPath(getPath());

		esfDocumentImpl.resetOriginalValues();

		return esfDocumentImpl;
	}

	@Override
	public int compareTo(ESFDocument esfDocument) {
		long primaryKey = esfDocument.getPrimaryKey();

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

		if (!(obj instanceof ESFDocument)) {
			return false;
		}

		ESFDocument esfDocument = (ESFDocument)obj;

		long primaryKey = esfDocument.getPrimaryKey();

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
		ESFDocumentModelImpl esfDocumentModelImpl = this;

		esfDocumentModelImpl._originalCode = esfDocumentModelImpl._code;

		esfDocumentModelImpl._originalExpirationDate = esfDocumentModelImpl._expirationDate;

		esfDocumentModelImpl._originalEsfUserId = esfDocumentModelImpl._esfUserId;

		esfDocumentModelImpl._setOriginalEsfUserId = false;

		esfDocumentModelImpl._originalType = esfDocumentModelImpl._type;

		esfDocumentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFDocument> toCacheModel() {
		ESFDocumentCacheModel esfDocumentCacheModel = new ESFDocumentCacheModel();

		esfDocumentCacheModel.esfDocumentId = getEsfDocumentId();

		esfDocumentCacheModel.groupId = getGroupId();

		esfDocumentCacheModel.companyId = getCompanyId();

		esfDocumentCacheModel.userId = getUserId();

		esfDocumentCacheModel.userName = getUserName();

		String userName = esfDocumentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfDocumentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfDocumentCacheModel.createDate = createDate.getTime();
		}
		else {
			esfDocumentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfDocumentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfDocumentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfDocumentCacheModel.code = getCode();

		String code = esfDocumentCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfDocumentCacheModel.code = null;
		}

		esfDocumentCacheModel.releasedBy = getReleasedBy();

		String releasedBy = esfDocumentCacheModel.releasedBy;

		if ((releasedBy != null) && (releasedBy.length() == 0)) {
			esfDocumentCacheModel.releasedBy = null;
		}

		Date releaseDate = getReleaseDate();

		if (releaseDate != null) {
			esfDocumentCacheModel.releaseDate = releaseDate.getTime();
		}
		else {
			esfDocumentCacheModel.releaseDate = Long.MIN_VALUE;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			esfDocumentCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			esfDocumentCacheModel.expirationDate = Long.MIN_VALUE;
		}

		esfDocumentCacheModel.esfUserId = getEsfUserId();

		esfDocumentCacheModel.type = getType();

		String type = esfDocumentCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			esfDocumentCacheModel.type = null;
		}

		esfDocumentCacheModel.path = getPath();

		String path = esfDocumentCacheModel.path;

		if ((path != null) && (path.length() == 0)) {
			esfDocumentCacheModel.path = null;
		}

		return esfDocumentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{esfDocumentId=");
		sb.append(getEsfDocumentId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", releasedBy=");
		sb.append(getReleasedBy());
		sb.append(", releaseDate=");
		sb.append(getReleaseDate());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", path=");
		sb.append(getPath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDocumentId</column-name><column-value><![CDATA[");
		sb.append(getEsfDocumentId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releasedBy</column-name><column-value><![CDATA[");
		sb.append(getReleasedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseDate</column-name><column-value><![CDATA[");
		sb.append(getReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFDocument.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFDocument.class
		};
	private long _esfDocumentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _originalCode;
	private String _releasedBy;
	private Date _releaseDate;
	private Date _expirationDate;
	private Date _originalExpirationDate;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _originalEsfUserId;
	private boolean _setOriginalEsfUserId;
	private String _type;
	private String _originalType;
	private String _path;
	private long _columnBitmask;
	private ESFDocument _escapedModel;
}