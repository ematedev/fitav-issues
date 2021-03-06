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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.model.ESFRadunoAzzurri;
import it.ethica.esf.model.ESFRadunoAzzurriModel;
import it.ethica.esf.service.persistence.ESFRadunoAzzurriPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFRadunoAzzurri service. Represents a row in the &quot;ESFRadunoAzzurri&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFRadunoAzzurriModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFRadunoAzzurriImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoAzzurriImpl
 * @see it.ethica.esf.model.ESFRadunoAzzurri
 * @see it.ethica.esf.model.ESFRadunoAzzurriModel
 * @generated
 */
public class ESFRadunoAzzurriModelImpl extends BaseModelImpl<ESFRadunoAzzurri>
	implements ESFRadunoAzzurriModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f raduno azzurri model instance should use the {@link it.ethica.esf.model.ESFRadunoAzzurri} interface instead.
	 */
	public static final String TABLE_NAME = "ESFRadunoAzzurri";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_esf_raduno_azzurri", Types.BIGINT },
			{ "id_esf_raduno", Types.BIGINT },
			{ "esfNationalId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFRadunoAzzurri (id_esf_raduno_azzurri LONG not null,id_esf_raduno LONG not null,esfNationalId LONG not null,primary key (id_esf_raduno_azzurri, id_esf_raduno, esfNationalId))";
	public static final String TABLE_SQL_DROP = "drop table ESFRadunoAzzurri";
	public static final String ORDER_BY_JPQL = " ORDER BY esfRadunoAzzurri.id.id_esf_raduno_azzurri ASC, esfRadunoAzzurri.id.id_esf_raduno ASC, esfRadunoAzzurri.id.esfNationalId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFRadunoAzzurri.id_esf_raduno_azzurri ASC, ESFRadunoAzzurri.id_esf_raduno ASC, ESFRadunoAzzurri.esfNationalId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFRadunoAzzurri"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFRadunoAzzurri"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFRadunoAzzurri"),
			true);
	public static long ESFNATIONALID_COLUMN_BITMASK = 1L;
	public static long ID_ESF_RADUNO_COLUMN_BITMASK = 2L;
	public static long ID_ESF_RADUNO_AZZURRI_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFRadunoAzzurri"));

	public ESFRadunoAzzurriModelImpl() {
	}

	@Override
	public ESFRadunoAzzurriPK getPrimaryKey() {
		return new ESFRadunoAzzurriPK(_id_esf_raduno_azzurri, _id_esf_raduno,
			_esfNationalId);
	}

	@Override
	public void setPrimaryKey(ESFRadunoAzzurriPK primaryKey) {
		setId_esf_raduno_azzurri(primaryKey.id_esf_raduno_azzurri);
		setId_esf_raduno(primaryKey.id_esf_raduno);
		setEsfNationalId(primaryKey.esfNationalId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFRadunoAzzurriPK(_id_esf_raduno_azzurri, _id_esf_raduno,
			_esfNationalId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFRadunoAzzurriPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoAzzurri.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoAzzurri.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_azzurri", getId_esf_raduno_azzurri());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("esfNationalId", getEsfNationalId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_azzurri = (Long)attributes.get(
				"id_esf_raduno_azzurri");

		if (id_esf_raduno_azzurri != null) {
			setId_esf_raduno_azzurri(id_esf_raduno_azzurri);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long esfNationalId = (Long)attributes.get("esfNationalId");

		if (esfNationalId != null) {
			setEsfNationalId(esfNationalId);
		}
	}

	@Override
	public long getId_esf_raduno_azzurri() {
		return _id_esf_raduno_azzurri;
	}

	@Override
	public void setId_esf_raduno_azzurri(long id_esf_raduno_azzurri) {
		_id_esf_raduno_azzurri = id_esf_raduno_azzurri;
	}

	@Override
	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_columnBitmask |= ID_ESF_RADUNO_COLUMN_BITMASK;

		if (!_setOriginalId_esf_raduno) {
			_setOriginalId_esf_raduno = true;

			_originalId_esf_raduno = _id_esf_raduno;
		}

		_id_esf_raduno = id_esf_raduno;
	}

	public long getOriginalId_esf_raduno() {
		return _originalId_esf_raduno;
	}

	@Override
	public long getEsfNationalId() {
		return _esfNationalId;
	}

	@Override
	public void setEsfNationalId(long esfNationalId) {
		_columnBitmask |= ESFNATIONALID_COLUMN_BITMASK;

		if (!_setOriginalEsfNationalId) {
			_setOriginalEsfNationalId = true;

			_originalEsfNationalId = _esfNationalId;
		}

		_esfNationalId = esfNationalId;
	}

	public long getOriginalEsfNationalId() {
		return _originalEsfNationalId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFRadunoAzzurri toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFRadunoAzzurri)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFRadunoAzzurriImpl esfRadunoAzzurriImpl = new ESFRadunoAzzurriImpl();

		esfRadunoAzzurriImpl.setId_esf_raduno_azzurri(getId_esf_raduno_azzurri());
		esfRadunoAzzurriImpl.setId_esf_raduno(getId_esf_raduno());
		esfRadunoAzzurriImpl.setEsfNationalId(getEsfNationalId());

		esfRadunoAzzurriImpl.resetOriginalValues();

		return esfRadunoAzzurriImpl;
	}

	@Override
	public int compareTo(ESFRadunoAzzurri esfRadunoAzzurri) {
		ESFRadunoAzzurriPK primaryKey = esfRadunoAzzurri.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoAzzurri)) {
			return false;
		}

		ESFRadunoAzzurri esfRadunoAzzurri = (ESFRadunoAzzurri)obj;

		ESFRadunoAzzurriPK primaryKey = esfRadunoAzzurri.getPrimaryKey();

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
		ESFRadunoAzzurriModelImpl esfRadunoAzzurriModelImpl = this;

		esfRadunoAzzurriModelImpl._originalId_esf_raduno = esfRadunoAzzurriModelImpl._id_esf_raduno;

		esfRadunoAzzurriModelImpl._setOriginalId_esf_raduno = false;

		esfRadunoAzzurriModelImpl._originalEsfNationalId = esfRadunoAzzurriModelImpl._esfNationalId;

		esfRadunoAzzurriModelImpl._setOriginalEsfNationalId = false;

		esfRadunoAzzurriModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFRadunoAzzurri> toCacheModel() {
		ESFRadunoAzzurriCacheModel esfRadunoAzzurriCacheModel = new ESFRadunoAzzurriCacheModel();

		esfRadunoAzzurriCacheModel.id_esf_raduno_azzurri = getId_esf_raduno_azzurri();

		esfRadunoAzzurriCacheModel.id_esf_raduno = getId_esf_raduno();

		esfRadunoAzzurriCacheModel.esfNationalId = getEsfNationalId();

		return esfRadunoAzzurriCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_azzurri=");
		sb.append(getId_esf_raduno_azzurri());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", esfNationalId=");
		sb.append(getEsfNationalId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoAzzurri");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_azzurri</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_azzurri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfNationalId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFRadunoAzzurri.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFRadunoAzzurri.class
		};
	private long _id_esf_raduno_azzurri;
	private long _id_esf_raduno;
	private long _originalId_esf_raduno;
	private boolean _setOriginalId_esf_raduno;
	private long _esfNationalId;
	private long _originalEsfNationalId;
	private boolean _setOriginalEsfNationalId;
	private long _columnBitmask;
	private ESFRadunoAzzurri _escapedModel;
}