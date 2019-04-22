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

import it.ethica.esf.model.ESFPublicAuthority;
import it.ethica.esf.model.ESFPublicAuthorityModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFPublicAuthority service. Represents a row in the &quot;ESFPublicAuthority&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFPublicAuthorityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFPublicAuthorityImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFPublicAuthorityImpl
 * @see it.ethica.esf.model.ESFPublicAuthority
 * @see it.ethica.esf.model.ESFPublicAuthorityModel
 * @generated
 */
public class ESFPublicAuthorityModelImpl extends BaseModelImpl<ESFPublicAuthority>
	implements ESFPublicAuthorityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f public authority model instance should use the {@link it.ethica.esf.model.ESFPublicAuthority} interface instead.
	 */
	public static final String TABLE_NAME = "ESFPublicAuthority";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfPublicAuthorityId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFPublicAuthority (esfPublicAuthorityId LONG not null primary key,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFPublicAuthority";
	public static final String ORDER_BY_JPQL = " ORDER BY esfPublicAuthority.esfPublicAuthorityId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFPublicAuthority.esfPublicAuthorityId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFPublicAuthority"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFPublicAuthority"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFPublicAuthority"));

	public ESFPublicAuthorityModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfPublicAuthorityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfPublicAuthorityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfPublicAuthorityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPublicAuthority.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPublicAuthority.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPublicAuthorityId", getEsfPublicAuthorityId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPublicAuthorityId = (Long)attributes.get("esfPublicAuthorityId");

		if (esfPublicAuthorityId != null) {
			setEsfPublicAuthorityId(esfPublicAuthorityId);
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
	}

	@Override
	public long getEsfPublicAuthorityId() {
		return _esfPublicAuthorityId;
	}

	@Override
	public void setEsfPublicAuthorityId(long esfPublicAuthorityId) {
		_esfPublicAuthorityId = esfPublicAuthorityId;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFPublicAuthority.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFPublicAuthority toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFPublicAuthority)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFPublicAuthorityImpl esfPublicAuthorityImpl = new ESFPublicAuthorityImpl();

		esfPublicAuthorityImpl.setEsfPublicAuthorityId(getEsfPublicAuthorityId());
		esfPublicAuthorityImpl.setCreateDate(getCreateDate());
		esfPublicAuthorityImpl.setModifiedDate(getModifiedDate());
		esfPublicAuthorityImpl.setDescription(getDescription());

		esfPublicAuthorityImpl.resetOriginalValues();

		return esfPublicAuthorityImpl;
	}

	@Override
	public int compareTo(ESFPublicAuthority esfPublicAuthority) {
		long primaryKey = esfPublicAuthority.getPrimaryKey();

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

		if (!(obj instanceof ESFPublicAuthority)) {
			return false;
		}

		ESFPublicAuthority esfPublicAuthority = (ESFPublicAuthority)obj;

		long primaryKey = esfPublicAuthority.getPrimaryKey();

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
	public CacheModel<ESFPublicAuthority> toCacheModel() {
		ESFPublicAuthorityCacheModel esfPublicAuthorityCacheModel = new ESFPublicAuthorityCacheModel();

		esfPublicAuthorityCacheModel.esfPublicAuthorityId = getEsfPublicAuthorityId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfPublicAuthorityCacheModel.createDate = createDate.getTime();
		}
		else {
			esfPublicAuthorityCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfPublicAuthorityCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfPublicAuthorityCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfPublicAuthorityCacheModel.description = getDescription();

		String description = esfPublicAuthorityCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfPublicAuthorityCacheModel.description = null;
		}

		return esfPublicAuthorityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfPublicAuthorityId=");
		sb.append(getEsfPublicAuthorityId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFPublicAuthority");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfPublicAuthorityId</column-name><column-value><![CDATA[");
		sb.append(getEsfPublicAuthorityId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFPublicAuthority.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFPublicAuthority.class
		};
	private long _esfPublicAuthorityId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private ESFPublicAuthority _escapedModel;
}