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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFHistoricalAssociation;
import it.ethica.esf.model.ESFHistoricalAssociationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFHistoricalAssociation service. Represents a row in the &quot;ESFHistoricalAssociation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFHistoricalAssociationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFHistoricalAssociationImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFHistoricalAssociationImpl
 * @see it.ethica.esf.model.ESFHistoricalAssociation
 * @see it.ethica.esf.model.ESFHistoricalAssociationModel
 * @generated
 */
public class ESFHistoricalAssociationModelImpl extends BaseModelImpl<ESFHistoricalAssociation>
	implements ESFHistoricalAssociationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f historical association model instance should use the {@link it.ethica.esf.model.ESFHistoricalAssociation} interface instead.
	 */
	public static final String TABLE_NAME = "ESFHistoricalAssociation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "idHistoricalAssociation", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "code_", Types.VARCHAR },
			{ "dateChange", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "organizationId", Types.BIGINT },
			{ "stateId", Types.BIGINT },
			{ "variationId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFHistoricalAssociation (idHistoricalAssociation LONG not null primary key,name VARCHAR(75) null,code_ VARCHAR(75) null,dateChange DATE null,endDate DATE null,organizationId LONG,stateId LONG,variationId LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFHistoricalAssociation";
	public static final String ORDER_BY_JPQL = " ORDER BY esfHistoricalAssociation.dateChange ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFHistoricalAssociation.dateChange ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFHistoricalAssociation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFHistoricalAssociation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFHistoricalAssociation"),
			true);
	public static long ORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long DATECHANGE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFHistoricalAssociation"));

	public ESFHistoricalAssociationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _idHistoricalAssociation;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdHistoricalAssociation(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idHistoricalAssociation;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFHistoricalAssociation.class;
	}

	@Override
	public String getModelClassName() {
		return ESFHistoricalAssociation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idHistoricalAssociation", getIdHistoricalAssociation());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("dateChange", getDateChange());
		attributes.put("endDate", getEndDate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("stateId", getStateId());
		attributes.put("variationId", getVariationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idHistoricalAssociation = (Long)attributes.get(
				"idHistoricalAssociation");

		if (idHistoricalAssociation != null) {
			setIdHistoricalAssociation(idHistoricalAssociation);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Date dateChange = (Date)attributes.get("dateChange");

		if (dateChange != null) {
			setDateChange(dateChange);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long variationId = (Long)attributes.get("variationId");

		if (variationId != null) {
			setVariationId(variationId);
		}
	}

	@Override
	public long getIdHistoricalAssociation() {
		return _idHistoricalAssociation;
	}

	@Override
	public void setIdHistoricalAssociation(long idHistoricalAssociation) {
		_idHistoricalAssociation = idHistoricalAssociation;
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
		_code = code;
	}

	@Override
	public Date getDateChange() {
		return _dateChange;
	}

	@Override
	public void setDateChange(Date dateChange) {
		_columnBitmask = -1L;

		_dateChange = dateChange;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_columnBitmask |= ORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalOrganizationId) {
			_setOriginalOrganizationId = true;

			_originalOrganizationId = _organizationId;
		}

		_organizationId = organizationId;
	}

	public long getOriginalOrganizationId() {
		return _originalOrganizationId;
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	@Override
	public long getVariationId() {
		return _variationId;
	}

	@Override
	public void setVariationId(long variationId) {
		_variationId = variationId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFHistoricalAssociation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFHistoricalAssociation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFHistoricalAssociation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFHistoricalAssociationImpl esfHistoricalAssociationImpl = new ESFHistoricalAssociationImpl();

		esfHistoricalAssociationImpl.setIdHistoricalAssociation(getIdHistoricalAssociation());
		esfHistoricalAssociationImpl.setName(getName());
		esfHistoricalAssociationImpl.setCode(getCode());
		esfHistoricalAssociationImpl.setDateChange(getDateChange());
		esfHistoricalAssociationImpl.setEndDate(getEndDate());
		esfHistoricalAssociationImpl.setOrganizationId(getOrganizationId());
		esfHistoricalAssociationImpl.setStateId(getStateId());
		esfHistoricalAssociationImpl.setVariationId(getVariationId());

		esfHistoricalAssociationImpl.resetOriginalValues();

		return esfHistoricalAssociationImpl;
	}

	@Override
	public int compareTo(ESFHistoricalAssociation esfHistoricalAssociation) {
		int value = 0;

		value = DateUtil.compareTo(getDateChange(),
				esfHistoricalAssociation.getDateChange());

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

		if (!(obj instanceof ESFHistoricalAssociation)) {
			return false;
		}

		ESFHistoricalAssociation esfHistoricalAssociation = (ESFHistoricalAssociation)obj;

		long primaryKey = esfHistoricalAssociation.getPrimaryKey();

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
		ESFHistoricalAssociationModelImpl esfHistoricalAssociationModelImpl = this;

		esfHistoricalAssociationModelImpl._originalOrganizationId = esfHistoricalAssociationModelImpl._organizationId;

		esfHistoricalAssociationModelImpl._setOriginalOrganizationId = false;

		esfHistoricalAssociationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFHistoricalAssociation> toCacheModel() {
		ESFHistoricalAssociationCacheModel esfHistoricalAssociationCacheModel = new ESFHistoricalAssociationCacheModel();

		esfHistoricalAssociationCacheModel.idHistoricalAssociation = getIdHistoricalAssociation();

		esfHistoricalAssociationCacheModel.name = getName();

		String name = esfHistoricalAssociationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfHistoricalAssociationCacheModel.name = null;
		}

		esfHistoricalAssociationCacheModel.code = getCode();

		String code = esfHistoricalAssociationCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfHistoricalAssociationCacheModel.code = null;
		}

		Date dateChange = getDateChange();

		if (dateChange != null) {
			esfHistoricalAssociationCacheModel.dateChange = dateChange.getTime();
		}
		else {
			esfHistoricalAssociationCacheModel.dateChange = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			esfHistoricalAssociationCacheModel.endDate = endDate.getTime();
		}
		else {
			esfHistoricalAssociationCacheModel.endDate = Long.MIN_VALUE;
		}

		esfHistoricalAssociationCacheModel.organizationId = getOrganizationId();

		esfHistoricalAssociationCacheModel.stateId = getStateId();

		esfHistoricalAssociationCacheModel.variationId = getVariationId();

		return esfHistoricalAssociationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{idHistoricalAssociation=");
		sb.append(getIdHistoricalAssociation());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", dateChange=");
		sb.append(getDateChange());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", variationId=");
		sb.append(getVariationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFHistoricalAssociation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idHistoricalAssociation</column-name><column-value><![CDATA[");
		sb.append(getIdHistoricalAssociation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateChange</column-name><column-value><![CDATA[");
		sb.append(getDateChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>variationId</column-name><column-value><![CDATA[");
		sb.append(getVariationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFHistoricalAssociation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFHistoricalAssociation.class
		};
	private long _idHistoricalAssociation;
	private String _name;
	private String _code;
	private Date _dateChange;
	private Date _endDate;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private long _stateId;
	private long _variationId;
	private long _columnBitmask;
	private ESFHistoricalAssociation _escapedModel;
}