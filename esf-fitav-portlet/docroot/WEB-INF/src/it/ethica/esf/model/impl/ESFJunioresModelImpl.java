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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFJuniores;
import it.ethica.esf.model.ESFJunioresModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFJuniores service. Represents a row in the &quot;ESFJuniores&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFJunioresModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFJunioresImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFJunioresImpl
 * @see it.ethica.esf.model.ESFJuniores
 * @see it.ethica.esf.model.ESFJunioresModel
 * @generated
 */
public class ESFJunioresModelImpl extends BaseModelImpl<ESFJuniores>
	implements ESFJunioresModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f juniores model instance should use the {@link it.ethica.esf.model.ESFJuniores} interface instead.
	 */
	public static final String TABLE_NAME = "ESFJuniores";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ESFUserId", Types.BIGINT },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFJuniores (ESFUserId LONG not null primary key,startDate DATE null,endDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table ESFJuniores";
	public static final String ORDER_BY_JPQL = " ORDER BY esfJuniores.ESFUserId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFJuniores.ESFUserId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFJuniores"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFJuniores"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFJuniores"));

	public ESFJunioresModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ESFUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setESFUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ESFUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFJuniores.class;
	}

	@Override
	public String getModelClassName() {
		return ESFJuniores.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ESFUserId", getESFUserId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ESFUserId = (Long)attributes.get("ESFUserId");

		if (ESFUserId != null) {
			setESFUserId(ESFUserId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public long getESFUserId() {
		return _ESFUserId;
	}

	@Override
	public void setESFUserId(long ESFUserId) {
		_ESFUserId = ESFUserId;
	}

	@Override
	public String getESFUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getESFUserId(), "uuid", _ESFUserUuid);
	}

	@Override
	public void setESFUserUuid(String ESFUserUuid) {
		_ESFUserUuid = ESFUserUuid;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFJuniores.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFJuniores toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFJuniores)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFJunioresImpl esfJunioresImpl = new ESFJunioresImpl();

		esfJunioresImpl.setESFUserId(getESFUserId());
		esfJunioresImpl.setStartDate(getStartDate());
		esfJunioresImpl.setEndDate(getEndDate());

		esfJunioresImpl.resetOriginalValues();

		return esfJunioresImpl;
	}

	@Override
	public int compareTo(ESFJuniores esfJuniores) {
		long primaryKey = esfJuniores.getPrimaryKey();

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

		if (!(obj instanceof ESFJuniores)) {
			return false;
		}

		ESFJuniores esfJuniores = (ESFJuniores)obj;

		long primaryKey = esfJuniores.getPrimaryKey();

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
	}

	@Override
	public CacheModel<ESFJuniores> toCacheModel() {
		ESFJunioresCacheModel esfJunioresCacheModel = new ESFJunioresCacheModel();

		esfJunioresCacheModel.ESFUserId = getESFUserId();

		Date startDate = getStartDate();

		if (startDate != null) {
			esfJunioresCacheModel.startDate = startDate.getTime();
		}
		else {
			esfJunioresCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			esfJunioresCacheModel.endDate = endDate.getTime();
		}
		else {
			esfJunioresCacheModel.endDate = Long.MIN_VALUE;
		}

		return esfJunioresCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ESFUserId=");
		sb.append(getESFUserId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFJuniores");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ESFUserId</column-name><column-value><![CDATA[");
		sb.append(getESFUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFJuniores.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFJuniores.class
		};
	private long _ESFUserId;
	private String _ESFUserUuid;
	private Date _startDate;
	private Date _endDate;
	private ESFJuniores _escapedModel;
}