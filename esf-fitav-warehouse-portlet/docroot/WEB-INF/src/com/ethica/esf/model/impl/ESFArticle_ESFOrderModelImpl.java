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

import com.ethica.esf.model.ESFArticle_ESFOrder;
import com.ethica.esf.model.ESFArticle_ESFOrderModel;
import com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFArticle_ESFOrder service. Represents a row in the &quot;ESFArticle_ESFOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ethica.esf.model.ESFArticle_ESFOrderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFArticle_ESFOrderImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFOrderImpl
 * @see com.ethica.esf.model.ESFArticle_ESFOrder
 * @see com.ethica.esf.model.ESFArticle_ESFOrderModel
 * @generated
 */
public class ESFArticle_ESFOrderModelImpl extends BaseModelImpl<ESFArticle_ESFOrder>
	implements ESFArticle_ESFOrderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f article_ e s f order model instance should use the {@link com.ethica.esf.model.ESFArticle_ESFOrder} interface instead.
	 */
	public static final String TABLE_NAME = "ESFArticle_ESFOrder";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfArticleId", Types.BIGINT },
			{ "esfOrderId", Types.BIGINT },
			{ "xxxlQty", Types.BIGINT },
			{ "xxlQty", Types.BIGINT },
			{ "xlQty", Types.BIGINT },
			{ "lQty", Types.BIGINT },
			{ "mQty", Types.BIGINT },
			{ "sQty", Types.BIGINT },
			{ "xsQty", Types.BIGINT },
			{ "xxsQty", Types.BIGINT },
			{ "otherQty", Types.BIGINT },
			{ "totalQty", Types.BIGINT },
			{ "price", Types.DOUBLE },
			{ "vat", Types.DOUBLE },
			{ "sale_", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFArticle_ESFOrder (esfArticleId LONG not null,esfOrderId LONG not null,xxxlQty LONG,xxlQty LONG,xlQty LONG,lQty LONG,mQty LONG,sQty LONG,xsQty LONG,xxsQty LONG,otherQty LONG,totalQty LONG,price DOUBLE,vat DOUBLE,sale_ DOUBLE,primary key (esfArticleId, esfOrderId))";
	public static final String TABLE_SQL_DROP = "drop table ESFArticle_ESFOrder";
	public static final String ORDER_BY_JPQL = " ORDER BY esfArticle_ESFOrder.id.esfArticleId ASC, esfArticle_ESFOrder.id.esfOrderId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFArticle_ESFOrder.esfArticleId ASC, ESFArticle_ESFOrder.esfOrderId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ethica.esf.model.ESFArticle_ESFOrder"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ethica.esf.model.ESFArticle_ESFOrder"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ethica.esf.model.ESFArticle_ESFOrder"),
			true);
	public static long ESFORDERID_COLUMN_BITMASK = 1L;
	public static long ESFARTICLEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ethica.esf.model.ESFArticle_ESFOrder"));

	public ESFArticle_ESFOrderModelImpl() {
	}

	@Override
	public ESFArticle_ESFOrderPK getPrimaryKey() {
		return new ESFArticle_ESFOrderPK(_esfArticleId, _esfOrderId);
	}

	@Override
	public void setPrimaryKey(ESFArticle_ESFOrderPK primaryKey) {
		setEsfArticleId(primaryKey.esfArticleId);
		setEsfOrderId(primaryKey.esfOrderId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFArticle_ESFOrderPK(_esfArticleId, _esfOrderId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFArticle_ESFOrderPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle_ESFOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle_ESFOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());
		attributes.put("totalQty", getTotalQty());
		attributes.put("price", getPrice());
		attributes.put("vat", getVat());
		attributes.put("sale", getSale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		Long xxxlQty = (Long)attributes.get("xxxlQty");

		if (xxxlQty != null) {
			setXxxlQty(xxxlQty);
		}

		Long xxlQty = (Long)attributes.get("xxlQty");

		if (xxlQty != null) {
			setXxlQty(xxlQty);
		}

		Long xlQty = (Long)attributes.get("xlQty");

		if (xlQty != null) {
			setXlQty(xlQty);
		}

		Long lQty = (Long)attributes.get("lQty");

		if (lQty != null) {
			setLQty(lQty);
		}

		Long mQty = (Long)attributes.get("mQty");

		if (mQty != null) {
			setMQty(mQty);
		}

		Long sQty = (Long)attributes.get("sQty");

		if (sQty != null) {
			setSQty(sQty);
		}

		Long xsQty = (Long)attributes.get("xsQty");

		if (xsQty != null) {
			setXsQty(xsQty);
		}

		Long xxsQty = (Long)attributes.get("xxsQty");

		if (xxsQty != null) {
			setXxsQty(xxsQty);
		}

		Long otherQty = (Long)attributes.get("otherQty");

		if (otherQty != null) {
			setOtherQty(otherQty);
		}

		Long totalQty = (Long)attributes.get("totalQty");

		if (totalQty != null) {
			setTotalQty(totalQty);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double vat = (Double)attributes.get("vat");

		if (vat != null) {
			setVat(vat);
		}

		Double sale = (Double)attributes.get("sale");

		if (sale != null) {
			setSale(sale);
		}
	}

	@Override
	public long getEsfArticleId() {
		return _esfArticleId;
	}

	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;
	}

	@Override
	public long getEsfOrderId() {
		return _esfOrderId;
	}

	@Override
	public void setEsfOrderId(long esfOrderId) {
		_columnBitmask |= ESFORDERID_COLUMN_BITMASK;

		if (!_setOriginalEsfOrderId) {
			_setOriginalEsfOrderId = true;

			_originalEsfOrderId = _esfOrderId;
		}

		_esfOrderId = esfOrderId;
	}

	public long getOriginalEsfOrderId() {
		return _originalEsfOrderId;
	}

	@Override
	public long getXxxlQty() {
		return _xxxlQty;
	}

	@Override
	public void setXxxlQty(long xxxlQty) {
		_xxxlQty = xxxlQty;
	}

	@Override
	public long getXxlQty() {
		return _xxlQty;
	}

	@Override
	public void setXxlQty(long xxlQty) {
		_xxlQty = xxlQty;
	}

	@Override
	public long getXlQty() {
		return _xlQty;
	}

	@Override
	public void setXlQty(long xlQty) {
		_xlQty = xlQty;
	}

	@Override
	public long getLQty() {
		return _lQty;
	}

	@Override
	public void setLQty(long lQty) {
		_lQty = lQty;
	}

	@Override
	public long getMQty() {
		return _mQty;
	}

	@Override
	public void setMQty(long mQty) {
		_mQty = mQty;
	}

	@Override
	public long getSQty() {
		return _sQty;
	}

	@Override
	public void setSQty(long sQty) {
		_sQty = sQty;
	}

	@Override
	public long getXsQty() {
		return _xsQty;
	}

	@Override
	public void setXsQty(long xsQty) {
		_xsQty = xsQty;
	}

	@Override
	public long getXxsQty() {
		return _xxsQty;
	}

	@Override
	public void setXxsQty(long xxsQty) {
		_xxsQty = xxsQty;
	}

	@Override
	public long getOtherQty() {
		return _otherQty;
	}

	@Override
	public void setOtherQty(long otherQty) {
		_otherQty = otherQty;
	}

	@Override
	public long getTotalQty() {
		return _totalQty;
	}

	@Override
	public void setTotalQty(long totalQty) {
		_totalQty = totalQty;
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;
	}

	@Override
	public double getVat() {
		return _vat;
	}

	@Override
	public void setVat(double vat) {
		_vat = vat;
	}

	@Override
	public double getSale() {
		return _sale;
	}

	@Override
	public void setSale(double sale) {
		_sale = sale;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFArticle_ESFOrder toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFArticle_ESFOrder)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFArticle_ESFOrderImpl esfArticle_ESFOrderImpl = new ESFArticle_ESFOrderImpl();

		esfArticle_ESFOrderImpl.setEsfArticleId(getEsfArticleId());
		esfArticle_ESFOrderImpl.setEsfOrderId(getEsfOrderId());
		esfArticle_ESFOrderImpl.setXxxlQty(getXxxlQty());
		esfArticle_ESFOrderImpl.setXxlQty(getXxlQty());
		esfArticle_ESFOrderImpl.setXlQty(getXlQty());
		esfArticle_ESFOrderImpl.setLQty(getLQty());
		esfArticle_ESFOrderImpl.setMQty(getMQty());
		esfArticle_ESFOrderImpl.setSQty(getSQty());
		esfArticle_ESFOrderImpl.setXsQty(getXsQty());
		esfArticle_ESFOrderImpl.setXxsQty(getXxsQty());
		esfArticle_ESFOrderImpl.setOtherQty(getOtherQty());
		esfArticle_ESFOrderImpl.setTotalQty(getTotalQty());
		esfArticle_ESFOrderImpl.setPrice(getPrice());
		esfArticle_ESFOrderImpl.setVat(getVat());
		esfArticle_ESFOrderImpl.setSale(getSale());

		esfArticle_ESFOrderImpl.resetOriginalValues();

		return esfArticle_ESFOrderImpl;
	}

	@Override
	public int compareTo(ESFArticle_ESFOrder esfArticle_ESFOrder) {
		ESFArticle_ESFOrderPK primaryKey = esfArticle_ESFOrder.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticle_ESFOrder)) {
			return false;
		}

		ESFArticle_ESFOrder esfArticle_ESFOrder = (ESFArticle_ESFOrder)obj;

		ESFArticle_ESFOrderPK primaryKey = esfArticle_ESFOrder.getPrimaryKey();

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
		ESFArticle_ESFOrderModelImpl esfArticle_ESFOrderModelImpl = this;

		esfArticle_ESFOrderModelImpl._originalEsfOrderId = esfArticle_ESFOrderModelImpl._esfOrderId;

		esfArticle_ESFOrderModelImpl._setOriginalEsfOrderId = false;

		esfArticle_ESFOrderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFArticle_ESFOrder> toCacheModel() {
		ESFArticle_ESFOrderCacheModel esfArticle_ESFOrderCacheModel = new ESFArticle_ESFOrderCacheModel();

		esfArticle_ESFOrderCacheModel.esfArticleId = getEsfArticleId();

		esfArticle_ESFOrderCacheModel.esfOrderId = getEsfOrderId();

		esfArticle_ESFOrderCacheModel.xxxlQty = getXxxlQty();

		esfArticle_ESFOrderCacheModel.xxlQty = getXxlQty();

		esfArticle_ESFOrderCacheModel.xlQty = getXlQty();

		esfArticle_ESFOrderCacheModel.lQty = getLQty();

		esfArticle_ESFOrderCacheModel.mQty = getMQty();

		esfArticle_ESFOrderCacheModel.sQty = getSQty();

		esfArticle_ESFOrderCacheModel.xsQty = getXsQty();

		esfArticle_ESFOrderCacheModel.xxsQty = getXxsQty();

		esfArticle_ESFOrderCacheModel.otherQty = getOtherQty();

		esfArticle_ESFOrderCacheModel.totalQty = getTotalQty();

		esfArticle_ESFOrderCacheModel.price = getPrice();

		esfArticle_ESFOrderCacheModel.vat = getVat();

		esfArticle_ESFOrderCacheModel.sale = getSale();

		return esfArticle_ESFOrderCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", esfOrderId=");
		sb.append(getEsfOrderId());
		sb.append(", xxxlQty=");
		sb.append(getXxxlQty());
		sb.append(", xxlQty=");
		sb.append(getXxlQty());
		sb.append(", xlQty=");
		sb.append(getXlQty());
		sb.append(", lQty=");
		sb.append(getLQty());
		sb.append(", mQty=");
		sb.append(getMQty());
		sb.append(", sQty=");
		sb.append(getSQty());
		sb.append(", xsQty=");
		sb.append(getXsQty());
		sb.append(", xxsQty=");
		sb.append(getXxsQty());
		sb.append(", otherQty=");
		sb.append(getOtherQty());
		sb.append(", totalQty=");
		sb.append(getTotalQty());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", vat=");
		sb.append(getVat());
		sb.append(", sale=");
		sb.append(getSale());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticle_ESFOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrderId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xxxlQty</column-name><column-value><![CDATA[");
		sb.append(getXxxlQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xxlQty</column-name><column-value><![CDATA[");
		sb.append(getXxlQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xlQty</column-name><column-value><![CDATA[");
		sb.append(getXlQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lQty</column-name><column-value><![CDATA[");
		sb.append(getLQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mQty</column-name><column-value><![CDATA[");
		sb.append(getMQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sQty</column-name><column-value><![CDATA[");
		sb.append(getSQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xsQty</column-name><column-value><![CDATA[");
		sb.append(getXsQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xxsQty</column-name><column-value><![CDATA[");
		sb.append(getXxsQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherQty</column-name><column-value><![CDATA[");
		sb.append(getOtherQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalQty</column-name><column-value><![CDATA[");
		sb.append(getTotalQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vat</column-name><column-value><![CDATA[");
		sb.append(getVat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sale</column-name><column-value><![CDATA[");
		sb.append(getSale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFArticle_ESFOrder.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFArticle_ESFOrder.class
		};
	private long _esfArticleId;
	private long _esfOrderId;
	private long _originalEsfOrderId;
	private boolean _setOriginalEsfOrderId;
	private long _xxxlQty;
	private long _xxlQty;
	private long _xlQty;
	private long _lQty;
	private long _mQty;
	private long _sQty;
	private long _xsQty;
	private long _xxsQty;
	private long _otherQty;
	private long _totalQty;
	private double _price;
	private double _vat;
	private double _sale;
	private long _columnBitmask;
	private ESFArticle_ESFOrder _escapedModel;
}