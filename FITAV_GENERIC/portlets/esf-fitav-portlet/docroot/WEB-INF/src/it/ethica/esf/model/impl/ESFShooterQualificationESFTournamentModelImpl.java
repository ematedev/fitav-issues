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

import it.ethica.esf.model.ESFShooterQualificationESFTournament;
import it.ethica.esf.model.ESFShooterQualificationESFTournamentModel;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFShooterQualificationESFTournament service. Represents a row in the &quot;ESFShooterQualificationESFTournament&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFShooterQualificationESFTournamentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFShooterQualificationESFTournamentImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFTournamentImpl
 * @see it.ethica.esf.model.ESFShooterQualificationESFTournament
 * @see it.ethica.esf.model.ESFShooterQualificationESFTournamentModel
 * @generated
 */
public class ESFShooterQualificationESFTournamentModelImpl extends BaseModelImpl<ESFShooterQualificationESFTournament>
	implements ESFShooterQualificationESFTournamentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f shooter qualification e s f tournament model instance should use the {@link it.ethica.esf.model.ESFShooterQualificationESFTournament} interface instead.
	 */
	public static final String TABLE_NAME = "ESFShooterQualificationESFTournament";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfShooterQualificationId", Types.BIGINT },
			{ "esfTournamentId", Types.BIGINT },
			{ "groupId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFShooterQualificationESFTournament (uuid_ VARCHAR(75) null,esfShooterQualificationId LONG not null,esfTournamentId LONG not null,groupId LONG,primary key (esfShooterQualificationId, esfTournamentId))";
	public static final String TABLE_SQL_DROP = "drop table ESFShooterQualificationESFTournament";
	public static final String ORDER_BY_JPQL = " ORDER BY esfShooterQualificationESFTournament.id.esfShooterQualificationId ASC, esfShooterQualificationESFTournament.id.esfTournamentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFShooterQualificationESFTournament.esfShooterQualificationId ASC, ESFShooterQualificationESFTournament.esfTournamentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFShooterQualificationESFTournament"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFShooterQualificationESFTournament"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFShooterQualificationESFTournament"),
			true);
	public static long ESFTOURNAMENTID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long ESFSHOOTERQUALIFICATIONID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFShooterQualificationESFTournament"));

	public ESFShooterQualificationESFTournamentModelImpl() {
	}

	@Override
	public ESFShooterQualificationESFTournamentPK getPrimaryKey() {
		return new ESFShooterQualificationESFTournamentPK(_esfShooterQualificationId,
			_esfTournamentId);
	}

	@Override
	public void setPrimaryKey(ESFShooterQualificationESFTournamentPK primaryKey) {
		setEsfShooterQualificationId(primaryKey.esfShooterQualificationId);
		setEsfTournamentId(primaryKey.esfTournamentId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFShooterQualificationESFTournamentPK(_esfShooterQualificationId,
			_esfTournamentId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFShooterQualificationESFTournamentPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterQualificationESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterQualificationESFTournament.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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
	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationId;
	}

	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationId = esfShooterQualificationId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFShooterQualificationESFTournament toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFShooterQualificationESFTournament)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFShooterQualificationESFTournamentImpl esfShooterQualificationESFTournamentImpl =
			new ESFShooterQualificationESFTournamentImpl();

		esfShooterQualificationESFTournamentImpl.setUuid(getUuid());
		esfShooterQualificationESFTournamentImpl.setEsfShooterQualificationId(getEsfShooterQualificationId());
		esfShooterQualificationESFTournamentImpl.setEsfTournamentId(getEsfTournamentId());
		esfShooterQualificationESFTournamentImpl.setGroupId(getGroupId());

		esfShooterQualificationESFTournamentImpl.resetOriginalValues();

		return esfShooterQualificationESFTournamentImpl;
	}

	@Override
	public int compareTo(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		ESFShooterQualificationESFTournamentPK primaryKey = esfShooterQualificationESFTournament.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterQualificationESFTournament)) {
			return false;
		}

		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			(ESFShooterQualificationESFTournament)obj;

		ESFShooterQualificationESFTournamentPK primaryKey = esfShooterQualificationESFTournament.getPrimaryKey();

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
		ESFShooterQualificationESFTournamentModelImpl esfShooterQualificationESFTournamentModelImpl =
			this;

		esfShooterQualificationESFTournamentModelImpl._originalUuid = esfShooterQualificationESFTournamentModelImpl._uuid;

		esfShooterQualificationESFTournamentModelImpl._originalEsfTournamentId = esfShooterQualificationESFTournamentModelImpl._esfTournamentId;

		esfShooterQualificationESFTournamentModelImpl._setOriginalEsfTournamentId = false;

		esfShooterQualificationESFTournamentModelImpl._originalGroupId = esfShooterQualificationESFTournamentModelImpl._groupId;

		esfShooterQualificationESFTournamentModelImpl._setOriginalGroupId = false;

		esfShooterQualificationESFTournamentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFShooterQualificationESFTournament> toCacheModel() {
		ESFShooterQualificationESFTournamentCacheModel esfShooterQualificationESFTournamentCacheModel =
			new ESFShooterQualificationESFTournamentCacheModel();

		esfShooterQualificationESFTournamentCacheModel.uuid = getUuid();

		String uuid = esfShooterQualificationESFTournamentCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfShooterQualificationESFTournamentCacheModel.uuid = null;
		}

		esfShooterQualificationESFTournamentCacheModel.esfShooterQualificationId = getEsfShooterQualificationId();

		esfShooterQualificationESFTournamentCacheModel.esfTournamentId = getEsfTournamentId();

		esfShooterQualificationESFTournamentCacheModel.groupId = getGroupId();

		return esfShooterQualificationESFTournamentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfShooterQualificationId=");
		sb.append(getEsfShooterQualificationId());
		sb.append(", esfTournamentId=");
		sb.append(getEsfTournamentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterQualificationESFTournament");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterQualificationId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTournamentId</column-name><column-value><![CDATA[");
		sb.append(getEsfTournamentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFShooterQualificationESFTournament.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFShooterQualificationESFTournament.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfShooterQualificationId;
	private long _esfTournamentId;
	private long _originalEsfTournamentId;
	private boolean _setOriginalEsfTournamentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _columnBitmask;
	private ESFShooterQualificationESFTournament _escapedModel;
}