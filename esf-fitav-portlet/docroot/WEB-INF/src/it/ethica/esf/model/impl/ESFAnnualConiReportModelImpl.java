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

import it.ethica.esf.model.ESFAnnualConiReport;
import it.ethica.esf.model.ESFAnnualConiReportModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFAnnualConiReport service. Represents a row in the &quot;ESFAnnualConiReport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFAnnualConiReportModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFAnnualConiReportImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualConiReportImpl
 * @see it.ethica.esf.model.ESFAnnualConiReport
 * @see it.ethica.esf.model.ESFAnnualConiReportModel
 * @generated
 */
public class ESFAnnualConiReportModelImpl extends BaseModelImpl<ESFAnnualConiReport>
	implements ESFAnnualConiReportModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f annual coni report model instance should use the {@link it.ethica.esf.model.ESFAnnualConiReport} interface instead.
	 */
	public static final String TABLE_NAME = "ESFAnnualConiReport";
	public static final Object[][] TABLE_COLUMNS = {
			{ "annualConiReportId", Types.BIGINT },
			{ "assId", Types.BIGINT },
			{ "year", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFAnnualConiReport (annualConiReportId LONG not null primary key,assId LONG,year INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ESFAnnualConiReport";
	public static final String ORDER_BY_JPQL = " ORDER BY esfAnnualConiReport.annualConiReportId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFAnnualConiReport.annualConiReportId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFAnnualConiReport"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFAnnualConiReport"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFAnnualConiReport"),
			true);
	public static long ASSID_COLUMN_BITMASK = 1L;
	public static long YEAR_COLUMN_BITMASK = 2L;
	public static long ANNUALCONIREPORTID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFAnnualConiReport"));

	public ESFAnnualConiReportModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _annualConiReportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnnualConiReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _annualConiReportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAnnualConiReport.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAnnualConiReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("annualConiReportId", getAnnualConiReportId());
		attributes.put("assId", getAssId());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long annualConiReportId = (Long)attributes.get("annualConiReportId");

		if (annualConiReportId != null) {
			setAnnualConiReportId(annualConiReportId);
		}

		Long assId = (Long)attributes.get("assId");

		if (assId != null) {
			setAssId(assId);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public long getAnnualConiReportId() {
		return _annualConiReportId;
	}

	@Override
	public void setAnnualConiReportId(long annualConiReportId) {
		_annualConiReportId = annualConiReportId;
	}

	@Override
	public long getAssId() {
		return _assId;
	}

	@Override
	public void setAssId(long assId) {
		_columnBitmask |= ASSID_COLUMN_BITMASK;

		if (!_setOriginalAssId) {
			_setOriginalAssId = true;

			_originalAssId = _assId;
		}

		_assId = assId;
	}

	public long getOriginalAssId() {
		return _originalAssId;
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_columnBitmask |= YEAR_COLUMN_BITMASK;

		if (!_setOriginalYear) {
			_setOriginalYear = true;

			_originalYear = _year;
		}

		_year = year;
	}

	public int getOriginalYear() {
		return _originalYear;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFAnnualConiReport.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFAnnualConiReport toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFAnnualConiReport)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFAnnualConiReportImpl esfAnnualConiReportImpl = new ESFAnnualConiReportImpl();

		esfAnnualConiReportImpl.setAnnualConiReportId(getAnnualConiReportId());
		esfAnnualConiReportImpl.setAssId(getAssId());
		esfAnnualConiReportImpl.setYear(getYear());

		esfAnnualConiReportImpl.resetOriginalValues();

		return esfAnnualConiReportImpl;
	}

	@Override
	public int compareTo(ESFAnnualConiReport esfAnnualConiReport) {
		long primaryKey = esfAnnualConiReport.getPrimaryKey();

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

		if (!(obj instanceof ESFAnnualConiReport)) {
			return false;
		}

		ESFAnnualConiReport esfAnnualConiReport = (ESFAnnualConiReport)obj;

		long primaryKey = esfAnnualConiReport.getPrimaryKey();

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
		ESFAnnualConiReportModelImpl esfAnnualConiReportModelImpl = this;

		esfAnnualConiReportModelImpl._originalAssId = esfAnnualConiReportModelImpl._assId;

		esfAnnualConiReportModelImpl._setOriginalAssId = false;

		esfAnnualConiReportModelImpl._originalYear = esfAnnualConiReportModelImpl._year;

		esfAnnualConiReportModelImpl._setOriginalYear = false;

		esfAnnualConiReportModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFAnnualConiReport> toCacheModel() {
		ESFAnnualConiReportCacheModel esfAnnualConiReportCacheModel = new ESFAnnualConiReportCacheModel();

		esfAnnualConiReportCacheModel.annualConiReportId = getAnnualConiReportId();

		esfAnnualConiReportCacheModel.assId = getAssId();

		esfAnnualConiReportCacheModel.year = getYear();

		return esfAnnualConiReportCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{annualConiReportId=");
		sb.append(getAnnualConiReportId());
		sb.append(", assId=");
		sb.append(getAssId());
		sb.append(", year=");
		sb.append(getYear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFAnnualConiReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>annualConiReportId</column-name><column-value><![CDATA[");
		sb.append(getAnnualConiReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assId</column-name><column-value><![CDATA[");
		sb.append(getAssId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFAnnualConiReport.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFAnnualConiReport.class
		};
	private long _annualConiReportId;
	private long _assId;
	private long _originalAssId;
	private boolean _setOriginalAssId;
	private int _year;
	private int _originalYear;
	private boolean _setOriginalYear;
	private long _columnBitmask;
	private ESFAnnualConiReport _escapedModel;
}