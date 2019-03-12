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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFDescription;
import it.ethica.esf.model.ESFDescriptionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFDescription service. Represents a row in the &quot;ESFDescription&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFDescriptionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFDescriptionImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFDescriptionImpl
 * @see it.ethica.esf.model.ESFDescription
 * @see it.ethica.esf.model.ESFDescriptionModel
 * @generated
 */
public class ESFDescriptionModelImpl extends BaseModelImpl<ESFDescription>
	implements ESFDescriptionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f description model instance should use the {@link it.ethica.esf.model.ESFDescription} interface instead.
	 */
	public static final String TABLE_NAME = "ESFDescription";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfDescriptionId", Types.BIGINT },
			{ "isNational", Types.BOOLEAN },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFDescription (esfDescriptionId LONG not null primary key,isNational BOOLEAN,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFDescription";
	public static final String ORDER_BY_JPQL = " ORDER BY esfDescription.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFDescription.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFDescription"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFDescription"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFDescription"),
			true);
	public static long ISNATIONAL_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFDescription"));

	public ESFDescriptionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfDescriptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDescriptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDescriptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDescription.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDescription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDescriptionId", getEsfDescriptionId());
		attributes.put("isNational", getIsNational());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDescriptionId = (Long)attributes.get("esfDescriptionId");

		if (esfDescriptionId != null) {
			setEsfDescriptionId(esfDescriptionId);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getEsfDescriptionId() {
		return _esfDescriptionId;
	}

	@Override
	public void setEsfDescriptionId(long esfDescriptionId) {
		_esfDescriptionId = esfDescriptionId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFDescription.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFDescription toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFDescription)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFDescriptionImpl esfDescriptionImpl = new ESFDescriptionImpl();

		esfDescriptionImpl.setEsfDescriptionId(getEsfDescriptionId());
		esfDescriptionImpl.setIsNational(getIsNational());
		esfDescriptionImpl.setName(getName());

		esfDescriptionImpl.resetOriginalValues();

		return esfDescriptionImpl;
	}

	@Override
	public int compareTo(ESFDescription esfDescription) {
		int value = 0;

		value = getName().compareTo(esfDescription.getName());

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

		if (!(obj instanceof ESFDescription)) {
			return false;
		}

		ESFDescription esfDescription = (ESFDescription)obj;

		long primaryKey = esfDescription.getPrimaryKey();

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
		ESFDescriptionModelImpl esfDescriptionModelImpl = this;

		esfDescriptionModelImpl._originalIsNational = esfDescriptionModelImpl._isNational;

		esfDescriptionModelImpl._setOriginalIsNational = false;

		esfDescriptionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFDescription> toCacheModel() {
		ESFDescriptionCacheModel esfDescriptionCacheModel = new ESFDescriptionCacheModel();

		esfDescriptionCacheModel.esfDescriptionId = getEsfDescriptionId();

		esfDescriptionCacheModel.isNational = getIsNational();

		esfDescriptionCacheModel.name = getName();

		String name = esfDescriptionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfDescriptionCacheModel.name = null;
		}

		return esfDescriptionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfDescriptionId=");
		sb.append(getEsfDescriptionId());
		sb.append(", isNational=");
		sb.append(getIsNational());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDescription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDescriptionId</column-name><column-value><![CDATA[");
		sb.append(getEsfDescriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNational</column-name><column-value><![CDATA[");
		sb.append(getIsNational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFDescription.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFDescription.class
		};
	private long _esfDescriptionId;
	private boolean _isNational;
	private boolean _originalIsNational;
	private boolean _setOriginalIsNational;
	private String _name;
	private long _columnBitmask;
	private ESFDescription _escapedModel;
}