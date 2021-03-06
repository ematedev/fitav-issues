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

package com.ethica.esf.model.impl;

import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.model.ESFOrderModel;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFOrder service. Represents a row in the &quot;ESFOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ethica.esf.model.ESFOrderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFOrderImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrderImpl
 * @see com.ethica.esf.model.ESFOrder
 * @see com.ethica.esf.model.ESFOrderModel
 * @generated
 */
public class ESFOrderModelImpl extends BaseModelImpl<ESFOrder>
	implements ESFOrderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f order model instance should use the {@link com.ethica.esf.model.ESFOrder} interface instead.
	 */
	public static final String TABLE_NAME = "ESFOrder";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfOrderId", Types.BIGINT },
			{ "code_", Types.VARCHAR },
			{ "data_", Types.TIMESTAMP },
			{ "description", Types.VARCHAR },
			{ "esfStockistId", Types.BIGINT },
			{ "qty", Types.BIGINT },
			{ "esfArticleId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFOrder (esfOrderId LONG not null primary key,code_ VARCHAR(256) null,data_ DATE null,description VARCHAR(2000) null,esfStockistId LONG,qty LONG,esfArticleId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFOrder";
	public static final String ORDER_BY_JPQL = " ORDER BY esfOrder.esfOrderId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFOrder.esfOrderId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ethica.esf.model.ESFOrder"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ethica.esf.model.ESFOrder"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ethica.esf.model.ESFOrder"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long ESFARTICLEID_COLUMN_BITMASK = 2L;
	public static long ESFSTOCKISTID_COLUMN_BITMASK = 4L;
	public static long ESFORDERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ethica.esf.model.ESFOrder"));

	public ESFOrderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfOrderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfOrderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfOrderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("code", getCode());
		attributes.put("data", getData());
		attributes.put("description", getDescription());
		attributes.put("esfStockistId", getEsfStockistId());
		attributes.put("qty", getQty());
		attributes.put("esfArticleId", getEsfArticleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfStockistId = (Long)attributes.get("esfStockistId");

		if (esfStockistId != null) {
			setEsfStockistId(esfStockistId);
		}

		Long qty = (Long)attributes.get("qty");

		if (qty != null) {
			setQty(qty);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}
	}

	@Override
	public long getEsfOrderId() {
		return _esfOrderId;
	}

	@Override
	public void setEsfOrderId(long esfOrderId) {
		_esfOrderId = esfOrderId;
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_columnBitmask |= CODE_COLUMN_BITMASK;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	@Override
	public Date getData() {
		return _data;
	}

	@Override
	public void setData(Date data) {
		_data = data;
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
	public long getEsfStockistId() {
		return _esfStockistId;
	}

	@Override
	public void setEsfStockistId(long esfStockistId) {
		_columnBitmask |= ESFSTOCKISTID_COLUMN_BITMASK;

		if (!_setOriginalEsfStockistId) {
			_setOriginalEsfStockistId = true;

			_originalEsfStockistId = _esfStockistId;
		}

		_esfStockistId = esfStockistId;
	}

	public long getOriginalEsfStockistId() {
		return _originalEsfStockistId;
	}

	@Override
	public long getQty() {
		return _qty;
	}

	@Override
	public void setQty(long qty) {
		_qty = qty;
	}

	@Override
	public long getEsfArticleId() {
		return _esfArticleId;
	}

	@Override
	public void setEsfArticleId(long esfArticleId) {
		_columnBitmask |= ESFARTICLEID_COLUMN_BITMASK;

		if (!_setOriginalEsfArticleId) {
			_setOriginalEsfArticleId = true;

			_originalEsfArticleId = _esfArticleId;
		}

		_esfArticleId = esfArticleId;
	}

	public long getOriginalEsfArticleId() {
		return _originalEsfArticleId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFOrder.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFOrder toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFOrder)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFOrderImpl esfOrderImpl = new ESFOrderImpl();

		esfOrderImpl.setEsfOrderId(getEsfOrderId());
		esfOrderImpl.setCode(getCode());
		esfOrderImpl.setData(getData());
		esfOrderImpl.setDescription(getDescription());
		esfOrderImpl.setEsfStockistId(getEsfStockistId());
		esfOrderImpl.setQty(getQty());
		esfOrderImpl.setEsfArticleId(getEsfArticleId());

		esfOrderImpl.resetOriginalValues();

		return esfOrderImpl;
	}

	@Override
	public int compareTo(ESFOrder esfOrder) {
		long primaryKey = esfOrder.getPrimaryKey();

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

		if (!(obj instanceof ESFOrder)) {
			return false;
		}

		ESFOrder esfOrder = (ESFOrder)obj;

		long primaryKey = esfOrder.getPrimaryKey();

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
		ESFOrderModelImpl esfOrderModelImpl = this;

		esfOrderModelImpl._originalCode = esfOrderModelImpl._code;

		esfOrderModelImpl._originalEsfStockistId = esfOrderModelImpl._esfStockistId;

		esfOrderModelImpl._setOriginalEsfStockistId = false;

		esfOrderModelImpl._originalEsfArticleId = esfOrderModelImpl._esfArticleId;

		esfOrderModelImpl._setOriginalEsfArticleId = false;

		esfOrderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFOrder> toCacheModel() {
		ESFOrderCacheModel esfOrderCacheModel = new ESFOrderCacheModel();

		esfOrderCacheModel.esfOrderId = getEsfOrderId();

		esfOrderCacheModel.code = getCode();

		String code = esfOrderCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfOrderCacheModel.code = null;
		}

		Date data = getData();

		if (data != null) {
			esfOrderCacheModel.data = data.getTime();
		}
		else {
			esfOrderCacheModel.data = Long.MIN_VALUE;
		}

		esfOrderCacheModel.description = getDescription();

		String description = esfOrderCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfOrderCacheModel.description = null;
		}

		esfOrderCacheModel.esfStockistId = getEsfStockistId();

		esfOrderCacheModel.qty = getQty();

		esfOrderCacheModel.esfArticleId = getEsfArticleId();

		return esfOrderCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{esfOrderId=");
		sb.append(getEsfOrderId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", data=");
		sb.append(getData());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", esfStockistId=");
		sb.append(getEsfStockistId());
		sb.append(", qty=");
		sb.append(getQty());
		sb.append(", esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfOrderId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfStockistId</column-name><column-value><![CDATA[");
		sb.append(getEsfStockistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qty</column-name><column-value><![CDATA[");
		sb.append(getQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFOrder.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFOrder.class
		};
	private long _esfOrderId;
	private String _code;
	private String _originalCode;
	private Date _data;
	private String _description;
	private long _esfStockistId;
	private long _originalEsfStockistId;
	private boolean _setOriginalEsfStockistId;
	private long _qty;
	private long _esfArticleId;
	private long _originalEsfArticleId;
	private boolean _setOriginalEsfArticleId;
	private long _columnBitmask;
	private ESFOrder _escapedModel;
}