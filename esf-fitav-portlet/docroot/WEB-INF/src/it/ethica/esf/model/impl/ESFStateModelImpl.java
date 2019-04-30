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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFState;
import it.ethica.esf.model.ESFStateModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFState service. Represents a row in the &quot;ESFState&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFStateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFStateImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFStateImpl
 * @see it.ethica.esf.model.ESFState
 * @see it.ethica.esf.model.ESFStateModel
 * @generated
 */
@JSON(strict = true)
public class ESFStateModelImpl extends BaseModelImpl<ESFState>
	implements ESFStateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f state model instance should use the {@link it.ethica.esf.model.ESFState} interface instead.
	 */
	public static final String TABLE_NAME = "ESFState";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfStateId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFState (esfStateId LONG not null primary key,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFState";
	public static final String ORDER_BY_JPQL = " ORDER BY esfState.esfStateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFState.esfStateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFState"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFState"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFState"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;
	public static long ESFSTATEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFState"));

	public ESFStateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfStateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfStateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfStateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFState.class;
	}

	@Override
	public String getModelClassName() {
		return ESFState.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStateId", getEsfStateId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@JSON
	@Override
	public long getEsfStateId() {
		return _esfStateId;
	}

	@Override
	public void setEsfStateId(long esfStateId) {
		_esfStateId = esfStateId;
	}

	@JSON
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
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFState.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFState toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFState)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFStateImpl esfStateImpl = new ESFStateImpl();

		esfStateImpl.setEsfStateId(getEsfStateId());
		esfStateImpl.setName(getName());
		esfStateImpl.setDescription(getDescription());

		esfStateImpl.resetOriginalValues();

		return esfStateImpl;
	}

	@Override
	public int compareTo(ESFState esfState) {
		long primaryKey = esfState.getPrimaryKey();

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

		if (!(obj instanceof ESFState)) {
			return false;
		}

		ESFState esfState = (ESFState)obj;

		long primaryKey = esfState.getPrimaryKey();

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
		ESFStateModelImpl esfStateModelImpl = this;

		esfStateModelImpl._originalName = esfStateModelImpl._name;

		esfStateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFState> toCacheModel() {
		ESFStateCacheModel esfStateCacheModel = new ESFStateCacheModel();

		esfStateCacheModel.esfStateId = getEsfStateId();

		esfStateCacheModel.name = getName();

		String name = esfStateCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfStateCacheModel.name = null;
		}

		esfStateCacheModel.description = getDescription();

		String description = esfStateCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfStateCacheModel.description = null;
		}

		return esfStateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfStateId=");
		sb.append(getEsfStateId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFState");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFState.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFState.class
		};
	private long _esfStateId;
	private String _name;
	private String _originalName;
	private String _description;
	private long _columnBitmask;
	private ESFState _escapedModel;
}