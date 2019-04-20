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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFLentField;
import it.ethica.esf.model.ESFLentFieldModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFLentField service. Represents a row in the &quot;ESFLentField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFLentFieldModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFLentFieldImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFLentFieldImpl
 * @see it.ethica.esf.model.ESFLentField
 * @see it.ethica.esf.model.ESFLentFieldModel
 * @generated
 */
public class ESFLentFieldModelImpl extends BaseModelImpl<ESFLentField>
	implements ESFLentFieldModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f lent field model instance should use the {@link it.ethica.esf.model.ESFLentField} interface instead.
	 */
	public static final String TABLE_NAME = "ESFLentField";
	public static final Object[][] TABLE_COLUMNS = {
			{ "lentFieldId", Types.BIGINT },
			{ "esfEntityStateId", Types.BIGINT },
			{ "esfFieldId", Types.BIGINT },
			{ "realOwnerId", Types.BIGINT },
			{ "actualOwnerId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFLentField (lentFieldId LONG not null primary key,esfEntityStateId LONG,esfFieldId LONG,realOwnerId LONG,actualOwnerId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFLentField";
	public static final String ORDER_BY_JPQL = " ORDER BY esfLentField.lentFieldId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFLentField.lentFieldId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFLentField"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFLentField"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFLentField"),
			true);
	public static long ESFENTITYSTATEID_COLUMN_BITMASK = 1L;
	public static long ESFFIELDID_COLUMN_BITMASK = 2L;
	public static long LENTFIELDID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFLentField"));

	public ESFLentFieldModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _lentFieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLentFieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lentFieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFLentField.class;
	}

	@Override
	public String getModelClassName() {
		return ESFLentField.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lentFieldId", getLentFieldId());
		attributes.put("esfEntityStateId", getEsfEntityStateId());
		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("realOwnerId", getRealOwnerId());
		attributes.put("actualOwnerId", getActualOwnerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lentFieldId = (Long)attributes.get("lentFieldId");

		if (lentFieldId != null) {
			setLentFieldId(lentFieldId);
		}

		Long esfEntityStateId = (Long)attributes.get("esfEntityStateId");

		if (esfEntityStateId != null) {
			setEsfEntityStateId(esfEntityStateId);
		}

		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
		}

		Long realOwnerId = (Long)attributes.get("realOwnerId");

		if (realOwnerId != null) {
			setRealOwnerId(realOwnerId);
		}

		Long actualOwnerId = (Long)attributes.get("actualOwnerId");

		if (actualOwnerId != null) {
			setActualOwnerId(actualOwnerId);
		}
	}

	@Override
	public long getLentFieldId() {
		return _lentFieldId;
	}

	@Override
	public void setLentFieldId(long lentFieldId) {
		_lentFieldId = lentFieldId;
	}

	@Override
	public long getEsfEntityStateId() {
		return _esfEntityStateId;
	}

	@Override
	public void setEsfEntityStateId(long esfEntityStateId) {
		_columnBitmask |= ESFENTITYSTATEID_COLUMN_BITMASK;

		if (!_setOriginalEsfEntityStateId) {
			_setOriginalEsfEntityStateId = true;

			_originalEsfEntityStateId = _esfEntityStateId;
		}

		_esfEntityStateId = esfEntityStateId;
	}

	public long getOriginalEsfEntityStateId() {
		return _originalEsfEntityStateId;
	}

	@Override
	public long getEsfFieldId() {
		return _esfFieldId;
	}

	@Override
	public void setEsfFieldId(long esfFieldId) {
		_columnBitmask |= ESFFIELDID_COLUMN_BITMASK;

		if (!_setOriginalEsfFieldId) {
			_setOriginalEsfFieldId = true;

			_originalEsfFieldId = _esfFieldId;
		}

		_esfFieldId = esfFieldId;
	}

	public long getOriginalEsfFieldId() {
		return _originalEsfFieldId;
	}

	@Override
	public long getRealOwnerId() {
		return _realOwnerId;
	}

	@Override
	public void setRealOwnerId(long realOwnerId) {
		_realOwnerId = realOwnerId;
	}

	@Override
	public long getActualOwnerId() {
		return _actualOwnerId;
	}

	@Override
	public void setActualOwnerId(long actualOwnerId) {
		_actualOwnerId = actualOwnerId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFLentField.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFLentField toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFLentField)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFLentFieldImpl esfLentFieldImpl = new ESFLentFieldImpl();

		esfLentFieldImpl.setLentFieldId(getLentFieldId());
		esfLentFieldImpl.setEsfEntityStateId(getEsfEntityStateId());
		esfLentFieldImpl.setEsfFieldId(getEsfFieldId());
		esfLentFieldImpl.setRealOwnerId(getRealOwnerId());
		esfLentFieldImpl.setActualOwnerId(getActualOwnerId());

		esfLentFieldImpl.resetOriginalValues();

		return esfLentFieldImpl;
	}

	@Override
	public int compareTo(ESFLentField esfLentField) {
		long primaryKey = esfLentField.getPrimaryKey();

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

		if (!(obj instanceof ESFLentField)) {
			return false;
		}

		ESFLentField esfLentField = (ESFLentField)obj;

		long primaryKey = esfLentField.getPrimaryKey();

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
		ESFLentFieldModelImpl esfLentFieldModelImpl = this;

		esfLentFieldModelImpl._originalEsfEntityStateId = esfLentFieldModelImpl._esfEntityStateId;

		esfLentFieldModelImpl._setOriginalEsfEntityStateId = false;

		esfLentFieldModelImpl._originalEsfFieldId = esfLentFieldModelImpl._esfFieldId;

		esfLentFieldModelImpl._setOriginalEsfFieldId = false;

		esfLentFieldModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFLentField> toCacheModel() {
		ESFLentFieldCacheModel esfLentFieldCacheModel = new ESFLentFieldCacheModel();

		esfLentFieldCacheModel.lentFieldId = getLentFieldId();

		esfLentFieldCacheModel.esfEntityStateId = getEsfEntityStateId();

		esfLentFieldCacheModel.esfFieldId = getEsfFieldId();

		esfLentFieldCacheModel.realOwnerId = getRealOwnerId();

		esfLentFieldCacheModel.actualOwnerId = getActualOwnerId();

		return esfLentFieldCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{lentFieldId=");
		sb.append(getLentFieldId());
		sb.append(", esfEntityStateId=");
		sb.append(getEsfEntityStateId());
		sb.append(", esfFieldId=");
		sb.append(getEsfFieldId());
		sb.append(", realOwnerId=");
		sb.append(getRealOwnerId());
		sb.append(", actualOwnerId=");
		sb.append(getActualOwnerId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFLentField");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lentFieldId</column-name><column-value><![CDATA[");
		sb.append(getLentFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfEntityStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfEntityStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFieldId</column-name><column-value><![CDATA[");
		sb.append(getEsfFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>realOwnerId</column-name><column-value><![CDATA[");
		sb.append(getRealOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualOwnerId</column-name><column-value><![CDATA[");
		sb.append(getActualOwnerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFLentField.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFLentField.class
		};
	private long _lentFieldId;
	private long _esfEntityStateId;
	private long _originalEsfEntityStateId;
	private boolean _setOriginalEsfEntityStateId;
	private long _esfFieldId;
	private long _originalEsfFieldId;
	private boolean _setOriginalEsfFieldId;
	private long _realOwnerId;
	private long _actualOwnerId;
	private long _columnBitmask;
	private ESFLentField _escapedModel;
}