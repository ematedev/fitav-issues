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

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.ESFArticleModel;

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

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFArticle service. Represents a row in the &quot;ESFArticle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ethica.esf.model.ESFArticleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFArticleImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticleImpl
 * @see com.ethica.esf.model.ESFArticle
 * @see com.ethica.esf.model.ESFArticleModel
 * @generated
 */
public class ESFArticleModelImpl extends BaseModelImpl<ESFArticle>
	implements ESFArticleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f article model instance should use the {@link com.ethica.esf.model.ESFArticle} interface instead.
	 */
	public static final String TABLE_NAME = "ESFArticle";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfArticleId", Types.BIGINT },
			{ "code_", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
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
			{ "disabled", Types.BOOLEAN },
			{ "esfArticleTypeId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFArticle (esfArticleId LONG not null primary key,code_ VARCHAR(75) null,name VARCHAR(75) null,description STRING null,xxxlQty LONG,xxlQty LONG,xlQty LONG,lQty LONG,mQty LONG,sQty LONG,xsQty LONG,xxsQty LONG,otherQty LONG,totalQty LONG,disabled BOOLEAN,esfArticleTypeId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFArticle";
	public static final String ORDER_BY_JPQL = " ORDER BY esfArticle.esfArticleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFArticle.esfArticleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ethica.esf.model.ESFArticle"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ethica.esf.model.ESFArticle"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ethica.esf.model.ESFArticle"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long DESCRIPTION_COLUMN_BITMASK = 2L;
	public static long DISABLED_COLUMN_BITMASK = 4L;
	public static long NAME_COLUMN_BITMASK = 8L;
	public static long ESFARTICLEID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ethica.esf.model.ESFArticle"));

	public ESFArticleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfArticleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfArticleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
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
		attributes.put("disabled", getDisabled());
		attributes.put("esfArticleTypeId", getEsfArticleTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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

		Boolean disabled = (Boolean)attributes.get("disabled");

		if (disabled != null) {
			setDisabled(disabled);
		}

		Long esfArticleTypeId = (Long)attributes.get("esfArticleTypeId");

		if (esfArticleTypeId != null) {
			setEsfArticleTypeId(esfArticleTypeId);
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
		_columnBitmask |= DESCRIPTION_COLUMN_BITMASK;

		if (_originalDescription == null) {
			_originalDescription = _description;
		}

		_description = description;
	}

	public String getOriginalDescription() {
		return GetterUtil.getString(_originalDescription);
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
	public boolean getDisabled() {
		return _disabled;
	}

	@Override
	public boolean isDisabled() {
		return _disabled;
	}

	@Override
	public void setDisabled(boolean disabled) {
		_columnBitmask |= DISABLED_COLUMN_BITMASK;

		if (!_setOriginalDisabled) {
			_setOriginalDisabled = true;

			_originalDisabled = _disabled;
		}

		_disabled = disabled;
	}

	public boolean getOriginalDisabled() {
		return _originalDisabled;
	}

	@Override
	public long getEsfArticleTypeId() {
		return _esfArticleTypeId;
	}

	@Override
	public void setEsfArticleTypeId(long esfArticleTypeId) {
		_esfArticleTypeId = esfArticleTypeId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFArticle.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFArticle toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFArticle)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFArticleImpl esfArticleImpl = new ESFArticleImpl();

		esfArticleImpl.setEsfArticleId(getEsfArticleId());
		esfArticleImpl.setCode(getCode());
		esfArticleImpl.setName(getName());
		esfArticleImpl.setDescription(getDescription());
		esfArticleImpl.setXxxlQty(getXxxlQty());
		esfArticleImpl.setXxlQty(getXxlQty());
		esfArticleImpl.setXlQty(getXlQty());
		esfArticleImpl.setLQty(getLQty());
		esfArticleImpl.setMQty(getMQty());
		esfArticleImpl.setSQty(getSQty());
		esfArticleImpl.setXsQty(getXsQty());
		esfArticleImpl.setXxsQty(getXxsQty());
		esfArticleImpl.setOtherQty(getOtherQty());
		esfArticleImpl.setTotalQty(getTotalQty());
		esfArticleImpl.setDisabled(getDisabled());
		esfArticleImpl.setEsfArticleTypeId(getEsfArticleTypeId());

		esfArticleImpl.resetOriginalValues();

		return esfArticleImpl;
	}

	@Override
	public int compareTo(ESFArticle esfArticle) {
		long primaryKey = esfArticle.getPrimaryKey();

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

		if (!(obj instanceof ESFArticle)) {
			return false;
		}

		ESFArticle esfArticle = (ESFArticle)obj;

		long primaryKey = esfArticle.getPrimaryKey();

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
		ESFArticleModelImpl esfArticleModelImpl = this;

		esfArticleModelImpl._originalCode = esfArticleModelImpl._code;

		esfArticleModelImpl._originalName = esfArticleModelImpl._name;

		esfArticleModelImpl._originalDescription = esfArticleModelImpl._description;

		esfArticleModelImpl._originalDisabled = esfArticleModelImpl._disabled;

		esfArticleModelImpl._setOriginalDisabled = false;

		esfArticleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFArticle> toCacheModel() {
		ESFArticleCacheModel esfArticleCacheModel = new ESFArticleCacheModel();

		esfArticleCacheModel.esfArticleId = getEsfArticleId();

		esfArticleCacheModel.code = getCode();

		String code = esfArticleCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfArticleCacheModel.code = null;
		}

		esfArticleCacheModel.name = getName();

		String name = esfArticleCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfArticleCacheModel.name = null;
		}

		esfArticleCacheModel.description = getDescription();

		String description = esfArticleCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfArticleCacheModel.description = null;
		}

		esfArticleCacheModel.xxxlQty = getXxxlQty();

		esfArticleCacheModel.xxlQty = getXxlQty();

		esfArticleCacheModel.xlQty = getXlQty();

		esfArticleCacheModel.lQty = getLQty();

		esfArticleCacheModel.mQty = getMQty();

		esfArticleCacheModel.sQty = getSQty();

		esfArticleCacheModel.xsQty = getXsQty();

		esfArticleCacheModel.xxsQty = getXxsQty();

		esfArticleCacheModel.otherQty = getOtherQty();

		esfArticleCacheModel.totalQty = getTotalQty();

		esfArticleCacheModel.disabled = getDisabled();

		esfArticleCacheModel.esfArticleTypeId = getEsfArticleTypeId();

		return esfArticleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
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
		sb.append(", disabled=");
		sb.append(getDisabled());
		sb.append(", esfArticleTypeId=");
		sb.append(getEsfArticleTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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
			"<column><column-name>disabled</column-name><column-value><![CDATA[");
		sb.append(getDisabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfArticleTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFArticle.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFArticle.class
		};
	private long _esfArticleId;
	private String _code;
	private String _originalCode;
	private String _name;
	private String _originalName;
	private String _description;
	private String _originalDescription;
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
	private boolean _disabled;
	private boolean _originalDisabled;
	private boolean _setOriginalDisabled;
	private long _esfArticleTypeId;
	private long _columnBitmask;
	private ESFArticle _escapedModel;
}