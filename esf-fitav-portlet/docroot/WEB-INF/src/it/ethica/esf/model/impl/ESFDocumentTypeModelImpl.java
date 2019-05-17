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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFDocumentType;
import it.ethica.esf.model.ESFDocumentTypeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFDocumentType service. Represents a row in the &quot;ESFDocumentType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFDocumentTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFDocumentTypeImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentTypeImpl
 * @see it.ethica.esf.model.ESFDocumentType
 * @see it.ethica.esf.model.ESFDocumentTypeModel
 * @generated
 */
public class ESFDocumentTypeModelImpl extends BaseModelImpl<ESFDocumentType>
	implements ESFDocumentTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f document type model instance should use the {@link it.ethica.esf.model.ESFDocumentType} interface instead.
	 */
	public static final String TABLE_NAME = "ESFDocumentType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfDocumentTypeId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "description", Types.VARCHAR },
			{ "expirationMonthsNotice", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFDocumentType (esfDocumentTypeId LONG not null primary key IDENTITY,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null,expirationMonthsNotice INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ESFDocumentType";
	public static final String ORDER_BY_JPQL = " ORDER BY esfDocumentType.esfDocumentTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFDocumentType.esfDocumentTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFDocumentType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFDocumentType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFDocumentType"));

	public ESFDocumentTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDocumentTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocumentType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocumentType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDocumentTypeId", getEsfDocumentTypeId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("expirationMonthsNotice", getExpirationMonthsNotice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentTypeId = (Long)attributes.get("esfDocumentTypeId");

		if (esfDocumentTypeId != null) {
			setEsfDocumentTypeId(esfDocumentTypeId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer expirationMonthsNotice = (Integer)attributes.get(
				"expirationMonthsNotice");

		if (expirationMonthsNotice != null) {
			setExpirationMonthsNotice(expirationMonthsNotice);
		}
	}

	@Override
	public long getEsfDocumentTypeId() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setEsfDocumentTypeId(long esfDocumentTypeId) {
		_esfDocumentTypeId = esfDocumentTypeId;
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
	public int getExpirationMonthsNotice() {
		return _expirationMonthsNotice;
	}

	@Override
	public void setExpirationMonthsNotice(int expirationMonthsNotice) {
		_expirationMonthsNotice = expirationMonthsNotice;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFDocumentType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFDocumentType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFDocumentType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFDocumentTypeImpl esfDocumentTypeImpl = new ESFDocumentTypeImpl();

		esfDocumentTypeImpl.setEsfDocumentTypeId(getEsfDocumentTypeId());
		esfDocumentTypeImpl.setCreateDate(getCreateDate());
		esfDocumentTypeImpl.setModifiedDate(getModifiedDate());
		esfDocumentTypeImpl.setDescription(getDescription());
		esfDocumentTypeImpl.setExpirationMonthsNotice(getExpirationMonthsNotice());

		esfDocumentTypeImpl.resetOriginalValues();

		return esfDocumentTypeImpl;
	}

	@Override
	public int compareTo(ESFDocumentType esfDocumentType) {
		long primaryKey = esfDocumentType.getPrimaryKey();

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

		if (!(obj instanceof ESFDocumentType)) {
			return false;
		}

		ESFDocumentType esfDocumentType = (ESFDocumentType)obj;

		long primaryKey = esfDocumentType.getPrimaryKey();

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
	}

	@Override
	public CacheModel<ESFDocumentType> toCacheModel() {
		ESFDocumentTypeCacheModel esfDocumentTypeCacheModel = new ESFDocumentTypeCacheModel();

		esfDocumentTypeCacheModel.esfDocumentTypeId = getEsfDocumentTypeId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfDocumentTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			esfDocumentTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfDocumentTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfDocumentTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfDocumentTypeCacheModel.description = getDescription();

		String description = esfDocumentTypeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfDocumentTypeCacheModel.description = null;
		}

		esfDocumentTypeCacheModel.expirationMonthsNotice = getExpirationMonthsNotice();

		return esfDocumentTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{esfDocumentTypeId=");
		sb.append(getEsfDocumentTypeId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", expirationMonthsNotice=");
		sb.append(getExpirationMonthsNotice());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDocumentType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDocumentTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfDocumentTypeId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationMonthsNotice</column-name><column-value><![CDATA[");
		sb.append(getExpirationMonthsNotice());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFDocumentType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFDocumentType.class
		};
	private long _esfDocumentTypeId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private int _expirationMonthsNotice;
	private ESFDocumentType _escapedModel;
}