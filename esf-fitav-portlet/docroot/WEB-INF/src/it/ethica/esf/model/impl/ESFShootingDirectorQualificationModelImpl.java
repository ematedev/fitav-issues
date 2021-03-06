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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.model.ESFShootingDirectorQualificationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFShootingDirectorQualification service. Represents a row in the &quot;ESFShootingDirectorQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFShootingDirectorQualificationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFShootingDirectorQualificationImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorQualificationImpl
 * @see it.ethica.esf.model.ESFShootingDirectorQualification
 * @see it.ethica.esf.model.ESFShootingDirectorQualificationModel
 * @generated
 */
public class ESFShootingDirectorQualificationModelImpl extends BaseModelImpl<ESFShootingDirectorQualification>
	implements ESFShootingDirectorQualificationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f shooting director qualification model instance should use the {@link it.ethica.esf.model.ESFShootingDirectorQualification} interface instead.
	 */
	public static final String TABLE_NAME = "ESFShootingDirectorQualification";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfShootingDirectorQualificationId", Types.BIGINT },
			{ "esfShootingDirectorQualificationDesc", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFShootingDirectorQualification (esfShootingDirectorQualificationId LONG not null primary key,esfShootingDirectorQualificationDesc VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFShootingDirectorQualification";
	public static final String ORDER_BY_JPQL = " ORDER BY esfShootingDirectorQualification.esfShootingDirectorQualificationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFShootingDirectorQualification.esfShootingDirectorQualificationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFShootingDirectorQualification"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFShootingDirectorQualification"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFShootingDirectorQualification"));

	public ESFShootingDirectorQualificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfShootingDirectorQualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfShootingDirectorQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfShootingDirectorQualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShootingDirectorQualification.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShootingDirectorQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorQualificationId",
			getEsfShootingDirectorQualificationId());
		attributes.put("esfShootingDirectorQualificationDesc",
			getEsfShootingDirectorQualificationDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorQualificationId = (Long)attributes.get(
				"esfShootingDirectorQualificationId");

		if (esfShootingDirectorQualificationId != null) {
			setEsfShootingDirectorQualificationId(esfShootingDirectorQualificationId);
		}

		String esfShootingDirectorQualificationDesc = (String)attributes.get(
				"esfShootingDirectorQualificationDesc");

		if (esfShootingDirectorQualificationDesc != null) {
			setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}
	}

	@Override
	public long getEsfShootingDirectorQualificationId() {
		return _esfShootingDirectorQualificationId;
	}

	@Override
	public void setEsfShootingDirectorQualificationId(
		long esfShootingDirectorQualificationId) {
		_esfShootingDirectorQualificationId = esfShootingDirectorQualificationId;
	}

	@Override
	public String getEsfShootingDirectorQualificationDesc() {
		if (_esfShootingDirectorQualificationDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfShootingDirectorQualificationDesc;
		}
	}

	@Override
	public void setEsfShootingDirectorQualificationDesc(
		String esfShootingDirectorQualificationDesc) {
		_esfShootingDirectorQualificationDesc = esfShootingDirectorQualificationDesc;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFShootingDirectorQualification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFShootingDirectorQualification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFShootingDirectorQualification)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFShootingDirectorQualificationImpl esfShootingDirectorQualificationImpl =
			new ESFShootingDirectorQualificationImpl();

		esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationId(getEsfShootingDirectorQualificationId());
		esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationDesc(getEsfShootingDirectorQualificationDesc());

		esfShootingDirectorQualificationImpl.resetOriginalValues();

		return esfShootingDirectorQualificationImpl;
	}

	@Override
	public int compareTo(
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		int value = 0;

		if (getEsfShootingDirectorQualificationId() < esfShootingDirectorQualification.getEsfShootingDirectorQualificationId()) {
			value = -1;
		}
		else if (getEsfShootingDirectorQualificationId() > esfShootingDirectorQualification.getEsfShootingDirectorQualificationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ESFShootingDirectorQualification)) {
			return false;
		}

		ESFShootingDirectorQualification esfShootingDirectorQualification = (ESFShootingDirectorQualification)obj;

		long primaryKey = esfShootingDirectorQualification.getPrimaryKey();

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
	public CacheModel<ESFShootingDirectorQualification> toCacheModel() {
		ESFShootingDirectorQualificationCacheModel esfShootingDirectorQualificationCacheModel =
			new ESFShootingDirectorQualificationCacheModel();

		esfShootingDirectorQualificationCacheModel.esfShootingDirectorQualificationId = getEsfShootingDirectorQualificationId();

		esfShootingDirectorQualificationCacheModel.esfShootingDirectorQualificationDesc = getEsfShootingDirectorQualificationDesc();

		String esfShootingDirectorQualificationDesc = esfShootingDirectorQualificationCacheModel.esfShootingDirectorQualificationDesc;

		if ((esfShootingDirectorQualificationDesc != null) &&
				(esfShootingDirectorQualificationDesc.length() == 0)) {
			esfShootingDirectorQualificationCacheModel.esfShootingDirectorQualificationDesc = null;
		}

		return esfShootingDirectorQualificationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{esfShootingDirectorQualificationId=");
		sb.append(getEsfShootingDirectorQualificationId());
		sb.append(", esfShootingDirectorQualificationDesc=");
		sb.append(getEsfShootingDirectorQualificationDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShootingDirectorQualification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfShootingDirectorQualificationId</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShootingDirectorQualificationDesc</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorQualificationDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFShootingDirectorQualification.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFShootingDirectorQualification.class
		};
	private long _esfShootingDirectorQualificationId;
	private String _esfShootingDirectorQualificationDesc;
	private ESFShootingDirectorQualification _escapedModel;
}