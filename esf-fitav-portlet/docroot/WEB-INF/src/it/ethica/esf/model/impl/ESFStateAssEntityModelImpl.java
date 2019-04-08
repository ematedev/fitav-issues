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

import it.ethica.esf.model.ESFStateAssEntity;
import it.ethica.esf.model.ESFStateAssEntityModel;
import it.ethica.esf.service.persistence.ESFStateAssEntityPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFStateAssEntity service. Represents a row in the &quot;ESFStateAssEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFStateAssEntityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFStateAssEntityImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFStateAssEntityImpl
 * @see it.ethica.esf.model.ESFStateAssEntity
 * @see it.ethica.esf.model.ESFStateAssEntityModel
 * @generated
 */
public class ESFStateAssEntityModelImpl extends BaseModelImpl<ESFStateAssEntity>
	implements ESFStateAssEntityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f state ass entity model instance should use the {@link it.ethica.esf.model.ESFStateAssEntity} interface instead.
	 */
	public static final String TABLE_NAME = "ESFStateAssEntity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfStateId", Types.BIGINT },
			{ "className", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFStateAssEntity (esfStateId LONG not null,className VARCHAR(75) not null,primary key (esfStateId, className))";
	public static final String TABLE_SQL_DROP = "drop table ESFStateAssEntity";
	public static final String ORDER_BY_JPQL = " ORDER BY esfStateAssEntity.id.esfStateId ASC, esfStateAssEntity.id.className ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFStateAssEntity.esfStateId ASC, ESFStateAssEntity.className ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFStateAssEntity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFStateAssEntity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFStateAssEntity"),
			true);
	public static long CLASSNAME_COLUMN_BITMASK = 1L;
	public static long ESFSTATEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFStateAssEntity"));

	public ESFStateAssEntityModelImpl() {
	}

	@Override
	public ESFStateAssEntityPK getPrimaryKey() {
		return new ESFStateAssEntityPK(_esfStateId, _className);
	}

	@Override
	public void setPrimaryKey(ESFStateAssEntityPK primaryKey) {
		setEsfStateId(primaryKey.esfStateId);
		setClassName(primaryKey.className);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFStateAssEntityPK(_esfStateId, _className);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFStateAssEntityPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFStateAssEntity.class;
	}

	@Override
	public String getModelClassName() {
		return ESFStateAssEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStateId", getEsfStateId());
		attributes.put("className", getClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}
	}

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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFStateAssEntity toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFStateAssEntity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFStateAssEntityImpl esfStateAssEntityImpl = new ESFStateAssEntityImpl();

		esfStateAssEntityImpl.setEsfStateId(getEsfStateId());
		esfStateAssEntityImpl.setClassName(getClassName());

		esfStateAssEntityImpl.resetOriginalValues();

		return esfStateAssEntityImpl;
	}

	@Override
	public int compareTo(ESFStateAssEntity esfStateAssEntity) {
		ESFStateAssEntityPK primaryKey = esfStateAssEntity.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFStateAssEntity)) {
			return false;
		}

		ESFStateAssEntity esfStateAssEntity = (ESFStateAssEntity)obj;

		ESFStateAssEntityPK primaryKey = esfStateAssEntity.getPrimaryKey();

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
		ESFStateAssEntityModelImpl esfStateAssEntityModelImpl = this;

		esfStateAssEntityModelImpl._originalEsfStateId = esfStateAssEntityModelImpl._esfStateId;

		esfStateAssEntityModelImpl._setOriginalEsfStateId = false;

		esfStateAssEntityModelImpl._originalClassName = esfStateAssEntityModelImpl._className;

		esfStateAssEntityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFStateAssEntity> toCacheModel() {
		ESFStateAssEntityCacheModel esfStateAssEntityCacheModel = new ESFStateAssEntityCacheModel();

		esfStateAssEntityCacheModel.esfStateId = getEsfStateId();

		esfStateAssEntityCacheModel.className = getClassName();

		String className = esfStateAssEntityCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			esfStateAssEntityCacheModel.className = null;
		}

		return esfStateAssEntityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{esfStateId=");
		sb.append(getEsfStateId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFStateAssEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFStateAssEntity.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFStateAssEntity.class
		};
	private long _esfStateId;
	private long _originalEsfStateId;
	private boolean _setOriginalEsfStateId;
	private String _className;
	private String _originalClassName;
	private long _columnBitmask;
	private ESFStateAssEntity _escapedModel;
}