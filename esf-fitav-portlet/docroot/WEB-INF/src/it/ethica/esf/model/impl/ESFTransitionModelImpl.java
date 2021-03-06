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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFTransition;
import it.ethica.esf.model.ESFTransitionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFTransition service. Represents a row in the &quot;ESFTransition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFTransitionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFTransitionImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFTransitionImpl
 * @see it.ethica.esf.model.ESFTransition
 * @see it.ethica.esf.model.ESFTransitionModel
 * @generated
 */
public class ESFTransitionModelImpl extends BaseModelImpl<ESFTransition>
	implements ESFTransitionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f transition model instance should use the {@link it.ethica.esf.model.ESFTransition} interface instead.
	 */
	public static final String TABLE_NAME = "ESFTransition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfTransitionId", Types.BIGINT },
			{ "esfUserId", Types.BIGINT },
			{ "esfCategoryId", Types.BIGINT },
			{ "season", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFTransition (esfTransitionId LONG not null primary key,esfUserId LONG,esfCategoryId LONG,season VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFTransition";
	public static final String ORDER_BY_JPQL = " ORDER BY esfTransition.esfTransitionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFTransition.esfTransitionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFTransition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFTransition"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFTransition"));

	public ESFTransitionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfTransitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfTransitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfTransitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTransition.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTransition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTransitionId", getEsfTransitionId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfCategoryId", getEsfCategoryId());
		attributes.put("season", getSeason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTransitionId = (Long)attributes.get("esfTransitionId");

		if (esfTransitionId != null) {
			setEsfTransitionId(esfTransitionId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfCategoryId = (Long)attributes.get("esfCategoryId");

		if (esfCategoryId != null) {
			setEsfCategoryId(esfCategoryId);
		}

		String season = (String)attributes.get("season");

		if (season != null) {
			setSeason(season);
		}
	}

	@Override
	public long getEsfTransitionId() {
		return _esfTransitionId;
	}

	@Override
	public void setEsfTransitionId(long esfTransitionId) {
		_esfTransitionId = esfTransitionId;
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public long getEsfCategoryId() {
		return _esfCategoryId;
	}

	@Override
	public void setEsfCategoryId(long esfCategoryId) {
		_esfCategoryId = esfCategoryId;
	}

	@Override
	public String getSeason() {
		if (_season == null) {
			return StringPool.BLANK;
		}
		else {
			return _season;
		}
	}

	@Override
	public void setSeason(String season) {
		_season = season;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFTransition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFTransition toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFTransition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFTransitionImpl esfTransitionImpl = new ESFTransitionImpl();

		esfTransitionImpl.setEsfTransitionId(getEsfTransitionId());
		esfTransitionImpl.setEsfUserId(getEsfUserId());
		esfTransitionImpl.setEsfCategoryId(getEsfCategoryId());
		esfTransitionImpl.setSeason(getSeason());

		esfTransitionImpl.resetOriginalValues();

		return esfTransitionImpl;
	}

	@Override
	public int compareTo(ESFTransition esfTransition) {
		long primaryKey = esfTransition.getPrimaryKey();

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

		if (!(obj instanceof ESFTransition)) {
			return false;
		}

		ESFTransition esfTransition = (ESFTransition)obj;

		long primaryKey = esfTransition.getPrimaryKey();

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
	public CacheModel<ESFTransition> toCacheModel() {
		ESFTransitionCacheModel esfTransitionCacheModel = new ESFTransitionCacheModel();

		esfTransitionCacheModel.esfTransitionId = getEsfTransitionId();

		esfTransitionCacheModel.esfUserId = getEsfUserId();

		esfTransitionCacheModel.esfCategoryId = getEsfCategoryId();

		esfTransitionCacheModel.season = getSeason();

		String season = esfTransitionCacheModel.season;

		if ((season != null) && (season.length() == 0)) {
			esfTransitionCacheModel.season = null;
		}

		return esfTransitionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfTransitionId=");
		sb.append(getEsfTransitionId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfCategoryId=");
		sb.append(getEsfCategoryId());
		sb.append(", season=");
		sb.append(getSeason());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFTransition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfTransitionId</column-name><column-value><![CDATA[");
		sb.append(getEsfTransitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>season</column-name><column-value><![CDATA[");
		sb.append(getSeason());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFTransition.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFTransition.class
		};
	private long _esfTransitionId;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfCategoryId;
	private String _season;
	private ESFTransition _escapedModel;
}