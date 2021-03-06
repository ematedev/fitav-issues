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

import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFRegionModel;
import it.ethica.esf.service.persistence.ESFRegionPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFRegion service. Represents a row in the &quot;ESFRegion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFRegionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFRegionImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRegionImpl
 * @see it.ethica.esf.model.ESFRegion
 * @see it.ethica.esf.model.ESFRegionModel
 * @generated
 */
public class ESFRegionModelImpl extends BaseModelImpl<ESFRegion>
	implements ESFRegionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f region model instance should use the {@link it.ethica.esf.model.ESFRegion} interface instead.
	 */
	public static final String TABLE_NAME = "ESFRegion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "idRegion", Types.VARCHAR },
			{ "idCountry", Types.VARCHAR },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFRegion (idRegion VARCHAR(75) not null,idCountry VARCHAR(75) not null,name VARCHAR(75) null,primary key (idRegion, idCountry))";
	public static final String TABLE_SQL_DROP = "drop table ESFRegion";
	public static final String ORDER_BY_JPQL = " ORDER BY esfRegion.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFRegion.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFRegion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFRegion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFRegion"),
			true);
	public static long IDCOUNTRY_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFRegion"));

	public ESFRegionModelImpl() {
	}

	@Override
	public ESFRegionPK getPrimaryKey() {
		return new ESFRegionPK(_idRegion, _idCountry);
	}

	@Override
	public void setPrimaryKey(ESFRegionPK primaryKey) {
		setIdRegion(primaryKey.idRegion);
		setIdCountry(primaryKey.idCountry);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFRegionPK(_idRegion, _idCountry);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFRegionPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRegion.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRegion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idRegion", getIdRegion());
		attributes.put("idCountry", getIdCountry());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idRegion = (String)attributes.get("idRegion");

		if (idRegion != null) {
			setIdRegion(idRegion);
		}

		String idCountry = (String)attributes.get("idCountry");

		if (idCountry != null) {
			setIdCountry(idCountry);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public String getIdRegion() {
		if (_idRegion == null) {
			return StringPool.BLANK;
		}
		else {
			return _idRegion;
		}
	}

	@Override
	public void setIdRegion(String idRegion) {
		_idRegion = idRegion;
	}

	@Override
	public String getIdCountry() {
		if (_idCountry == null) {
			return StringPool.BLANK;
		}
		else {
			return _idCountry;
		}
	}

	@Override
	public void setIdCountry(String idCountry) {
		_columnBitmask |= IDCOUNTRY_COLUMN_BITMASK;

		if (_originalIdCountry == null) {
			_originalIdCountry = _idCountry;
		}

		_idCountry = idCountry;
	}

	public String getOriginalIdCountry() {
		return GetterUtil.getString(_originalIdCountry);
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
	public ESFRegion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFRegion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFRegionImpl esfRegionImpl = new ESFRegionImpl();

		esfRegionImpl.setIdRegion(getIdRegion());
		esfRegionImpl.setIdCountry(getIdCountry());
		esfRegionImpl.setName(getName());

		esfRegionImpl.resetOriginalValues();

		return esfRegionImpl;
	}

	@Override
	public int compareTo(ESFRegion esfRegion) {
		int value = 0;

		value = getName().compareTo(esfRegion.getName());

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

		if (!(obj instanceof ESFRegion)) {
			return false;
		}

		ESFRegion esfRegion = (ESFRegion)obj;

		ESFRegionPK primaryKey = esfRegion.getPrimaryKey();

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
		ESFRegionModelImpl esfRegionModelImpl = this;

		esfRegionModelImpl._originalIdCountry = esfRegionModelImpl._idCountry;

		esfRegionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFRegion> toCacheModel() {
		ESFRegionCacheModel esfRegionCacheModel = new ESFRegionCacheModel();

		esfRegionCacheModel.idRegion = getIdRegion();

		String idRegion = esfRegionCacheModel.idRegion;

		if ((idRegion != null) && (idRegion.length() == 0)) {
			esfRegionCacheModel.idRegion = null;
		}

		esfRegionCacheModel.idCountry = getIdCountry();

		String idCountry = esfRegionCacheModel.idCountry;

		if ((idCountry != null) && (idCountry.length() == 0)) {
			esfRegionCacheModel.idCountry = null;
		}

		esfRegionCacheModel.name = getName();

		String name = esfRegionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfRegionCacheModel.name = null;
		}

		return esfRegionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idRegion=");
		sb.append(getIdRegion());
		sb.append(", idCountry=");
		sb.append(getIdCountry());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRegion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idRegion</column-name><column-value><![CDATA[");
		sb.append(getIdRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCountry</column-name><column-value><![CDATA[");
		sb.append(getIdCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFRegion.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFRegion.class
		};
	private String _idRegion;
	private String _idCountry;
	private String _originalIdCountry;
	private String _name;
	private long _columnBitmask;
	private ESFRegion _escapedModel;
}