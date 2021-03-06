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

import it.ethica.esf.model.ESFInstructsShootingDirector;
import it.ethica.esf.model.ESFInstructsShootingDirectorModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFInstructsShootingDirector service. Represents a row in the &quot;ESFInstructsShootingDirector&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFInstructsShootingDirectorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFInstructsShootingDirectorImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFInstructsShootingDirectorImpl
 * @see it.ethica.esf.model.ESFInstructsShootingDirector
 * @see it.ethica.esf.model.ESFInstructsShootingDirectorModel
 * @generated
 */
public class ESFInstructsShootingDirectorModelImpl extends BaseModelImpl<ESFInstructsShootingDirector>
	implements ESFInstructsShootingDirectorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f instructs shooting director model instance should use the {@link it.ethica.esf.model.ESFInstructsShootingDirector} interface instead.
	 */
	public static final String TABLE_NAME = "ESFInstructsShootingDirector";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfInstructsShootingDirectorId", Types.BIGINT },
			{ "esfInstructsShootingDirectorCode", Types.VARCHAR },
			{ "esfInstructsShootingDirectorDesc", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFInstructsShootingDirector (esfInstructsShootingDirectorId LONG not null primary key,esfInstructsShootingDirectorCode VARCHAR(75) null,esfInstructsShootingDirectorDesc VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFInstructsShootingDirector";
	public static final String ORDER_BY_JPQL = " ORDER BY esfInstructsShootingDirector.esfInstructsShootingDirectorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFInstructsShootingDirector.esfInstructsShootingDirectorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFInstructsShootingDirector"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFInstructsShootingDirector"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFInstructsShootingDirector"));

	public ESFInstructsShootingDirectorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfInstructsShootingDirectorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfInstructsShootingDirectorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfInstructsShootingDirectorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFInstructsShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFInstructsShootingDirector.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfInstructsShootingDirectorId",
			getEsfInstructsShootingDirectorId());
		attributes.put("esfInstructsShootingDirectorCode",
			getEsfInstructsShootingDirectorCode());
		attributes.put("esfInstructsShootingDirectorDesc",
			getEsfInstructsShootingDirectorDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfInstructsShootingDirectorId = (Long)attributes.get(
				"esfInstructsShootingDirectorId");

		if (esfInstructsShootingDirectorId != null) {
			setEsfInstructsShootingDirectorId(esfInstructsShootingDirectorId);
		}

		String esfInstructsShootingDirectorCode = (String)attributes.get(
				"esfInstructsShootingDirectorCode");

		if (esfInstructsShootingDirectorCode != null) {
			setEsfInstructsShootingDirectorCode(esfInstructsShootingDirectorCode);
		}

		String esfInstructsShootingDirectorDesc = (String)attributes.get(
				"esfInstructsShootingDirectorDesc");

		if (esfInstructsShootingDirectorDesc != null) {
			setEsfInstructsShootingDirectorDesc(esfInstructsShootingDirectorDesc);
		}
	}

	@Override
	public long getEsfInstructsShootingDirectorId() {
		return _esfInstructsShootingDirectorId;
	}

	@Override
	public void setEsfInstructsShootingDirectorId(
		long esfInstructsShootingDirectorId) {
		_esfInstructsShootingDirectorId = esfInstructsShootingDirectorId;
	}

	@Override
	public String getEsfInstructsShootingDirectorCode() {
		if (_esfInstructsShootingDirectorCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfInstructsShootingDirectorCode;
		}
	}

	@Override
	public void setEsfInstructsShootingDirectorCode(
		String esfInstructsShootingDirectorCode) {
		_esfInstructsShootingDirectorCode = esfInstructsShootingDirectorCode;
	}

	@Override
	public String getEsfInstructsShootingDirectorDesc() {
		if (_esfInstructsShootingDirectorDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfInstructsShootingDirectorDesc;
		}
	}

	@Override
	public void setEsfInstructsShootingDirectorDesc(
		String esfInstructsShootingDirectorDesc) {
		_esfInstructsShootingDirectorDesc = esfInstructsShootingDirectorDesc;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFInstructsShootingDirector.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFInstructsShootingDirector toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFInstructsShootingDirector)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFInstructsShootingDirectorImpl esfInstructsShootingDirectorImpl = new ESFInstructsShootingDirectorImpl();

		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorId(getEsfInstructsShootingDirectorId());
		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorCode(getEsfInstructsShootingDirectorCode());
		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorDesc(getEsfInstructsShootingDirectorDesc());

		esfInstructsShootingDirectorImpl.resetOriginalValues();

		return esfInstructsShootingDirectorImpl;
	}

	@Override
	public int compareTo(
		ESFInstructsShootingDirector esfInstructsShootingDirector) {
		int value = 0;

		if (getEsfInstructsShootingDirectorId() < esfInstructsShootingDirector.getEsfInstructsShootingDirectorId()) {
			value = -1;
		}
		else if (getEsfInstructsShootingDirectorId() > esfInstructsShootingDirector.getEsfInstructsShootingDirectorId()) {
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

		if (!(obj instanceof ESFInstructsShootingDirector)) {
			return false;
		}

		ESFInstructsShootingDirector esfInstructsShootingDirector = (ESFInstructsShootingDirector)obj;

		long primaryKey = esfInstructsShootingDirector.getPrimaryKey();

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
	public CacheModel<ESFInstructsShootingDirector> toCacheModel() {
		ESFInstructsShootingDirectorCacheModel esfInstructsShootingDirectorCacheModel =
			new ESFInstructsShootingDirectorCacheModel();

		esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorId = getEsfInstructsShootingDirectorId();

		esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorCode = getEsfInstructsShootingDirectorCode();

		String esfInstructsShootingDirectorCode = esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorCode;

		if ((esfInstructsShootingDirectorCode != null) &&
				(esfInstructsShootingDirectorCode.length() == 0)) {
			esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorCode = null;
		}

		esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorDesc = getEsfInstructsShootingDirectorDesc();

		String esfInstructsShootingDirectorDesc = esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorDesc;

		if ((esfInstructsShootingDirectorDesc != null) &&
				(esfInstructsShootingDirectorDesc.length() == 0)) {
			esfInstructsShootingDirectorCacheModel.esfInstructsShootingDirectorDesc = null;
		}

		return esfInstructsShootingDirectorCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfInstructsShootingDirectorId=");
		sb.append(getEsfInstructsShootingDirectorId());
		sb.append(", esfInstructsShootingDirectorCode=");
		sb.append(getEsfInstructsShootingDirectorCode());
		sb.append(", esfInstructsShootingDirectorDesc=");
		sb.append(getEsfInstructsShootingDirectorDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFInstructsShootingDirector");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfInstructsShootingDirectorId</column-name><column-value><![CDATA[");
		sb.append(getEsfInstructsShootingDirectorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfInstructsShootingDirectorCode</column-name><column-value><![CDATA[");
		sb.append(getEsfInstructsShootingDirectorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfInstructsShootingDirectorDesc</column-name><column-value><![CDATA[");
		sb.append(getEsfInstructsShootingDirectorDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFInstructsShootingDirector.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFInstructsShootingDirector.class
		};
	private long _esfInstructsShootingDirectorId;
	private String _esfInstructsShootingDirectorCode;
	private String _esfInstructsShootingDirectorDesc;
	private ESFInstructsShootingDirector _escapedModel;
}