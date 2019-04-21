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

import it.ethica.esf.model.ESFTeam;
import it.ethica.esf.model.ESFTeamModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFTeam service. Represents a row in the &quot;ESFTeam&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFTeamModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFTeamImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFTeamImpl
 * @see it.ethica.esf.model.ESFTeam
 * @see it.ethica.esf.model.ESFTeamModel
 * @generated
 */
public class ESFTeamModelImpl extends BaseModelImpl<ESFTeam>
	implements ESFTeamModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f team model instance should use the {@link it.ethica.esf.model.ESFTeam} interface instead.
	 */
	public static final String TABLE_NAME = "ESFTeam";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfTeamId", Types.BIGINT },
			{ "esfTournamentId", Types.BIGINT },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFTeam (esfTeamId LONG not null primary key,esfTournamentId LONG,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFTeam";
	public static final String ORDER_BY_JPQL = " ORDER BY esfTeam.esfTeamId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFTeam.esfTeamId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFTeam"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFTeam"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFTeam"),
			true);
	public static long ESFTOURNAMENTID_COLUMN_BITMASK = 1L;
	public static long ESFTEAMID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFTeam"));

	public ESFTeamModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfTeamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfTeamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfTeamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTeam.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTeam.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTeamId", getEsfTeamId());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTeamId = (Long)attributes.get("esfTeamId");

		if (esfTeamId != null) {
			setEsfTeamId(esfTeamId);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getEsfTeamId() {
		return _esfTeamId;
	}

	@Override
	public void setEsfTeamId(long esfTeamId) {
		_esfTeamId = esfTeamId;
	}

	@Override
	public long getEsfTournamentId() {
		return _esfTournamentId;
	}

	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_columnBitmask |= ESFTOURNAMENTID_COLUMN_BITMASK;

		if (!_setOriginalEsfTournamentId) {
			_setOriginalEsfTournamentId = true;

			_originalEsfTournamentId = _esfTournamentId;
		}

		_esfTournamentId = esfTournamentId;
	}

	public long getOriginalEsfTournamentId() {
		return _originalEsfTournamentId;
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
		_name = name;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFTeam.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFTeam toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFTeam)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFTeamImpl esfTeamImpl = new ESFTeamImpl();

		esfTeamImpl.setEsfTeamId(getEsfTeamId());
		esfTeamImpl.setEsfTournamentId(getEsfTournamentId());
		esfTeamImpl.setName(getName());

		esfTeamImpl.resetOriginalValues();

		return esfTeamImpl;
	}

	@Override
	public int compareTo(ESFTeam esfTeam) {
		long primaryKey = esfTeam.getPrimaryKey();

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

		if (!(obj instanceof ESFTeam)) {
			return false;
		}

		ESFTeam esfTeam = (ESFTeam)obj;

		long primaryKey = esfTeam.getPrimaryKey();

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
		ESFTeamModelImpl esfTeamModelImpl = this;

		esfTeamModelImpl._originalEsfTournamentId = esfTeamModelImpl._esfTournamentId;

		esfTeamModelImpl._setOriginalEsfTournamentId = false;

		esfTeamModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFTeam> toCacheModel() {
		ESFTeamCacheModel esfTeamCacheModel = new ESFTeamCacheModel();

		esfTeamCacheModel.esfTeamId = getEsfTeamId();

		esfTeamCacheModel.esfTournamentId = getEsfTournamentId();

		esfTeamCacheModel.name = getName();

		String name = esfTeamCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfTeamCacheModel.name = null;
		}

		return esfTeamCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfTeamId=");
		sb.append(getEsfTeamId());
		sb.append(", esfTournamentId=");
		sb.append(getEsfTournamentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFTeam");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfTeamId</column-name><column-value><![CDATA[");
		sb.append(getEsfTeamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTournamentId</column-name><column-value><![CDATA[");
		sb.append(getEsfTournamentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFTeam.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFTeam.class
		};
	private long _esfTeamId;
	private long _esfTournamentId;
	private long _originalEsfTournamentId;
	private boolean _setOriginalEsfTournamentId;
	private String _name;
	private long _columnBitmask;
	private ESFTeam _escapedModel;
}