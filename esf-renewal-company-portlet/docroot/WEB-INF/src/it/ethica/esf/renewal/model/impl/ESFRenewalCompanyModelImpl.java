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

package it.ethica.esf.renewal.model.impl;

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

import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.model.ESFRenewalCompanyModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFRenewalCompany service. Represents a row in the &quot;ESFRenewalCompany&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.renewal.model.ESFRenewalCompanyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFRenewalCompanyImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalCompanyImpl
 * @see it.ethica.esf.renewal.model.ESFRenewalCompany
 * @see it.ethica.esf.renewal.model.ESFRenewalCompanyModel
 * @generated
 */
public class ESFRenewalCompanyModelImpl extends BaseModelImpl<ESFRenewalCompany>
	implements ESFRenewalCompanyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f renewal company model instance should use the {@link it.ethica.esf.renewal.model.ESFRenewalCompany} interface instead.
	 */
	public static final String TABLE_NAME = "ESFRenewalCompany";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfRenewalCompanyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "esfOrganizationId", Types.BIGINT },
			{ "cardsNumber", Types.INTEGER },
			{ "year", Types.INTEGER },
			{ "date_", Types.TIMESTAMP },
			{ "paymentType", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "amount", Types.DOUBLE },
			{ "info", Types.VARCHAR },
			{ "accountholder", Types.VARCHAR },
			{ "paymentDate", Types.TIMESTAMP },
			{ "integrationAmount", Types.DOUBLE },
			{ "integrationDate", Types.TIMESTAMP },
			{ "integrationType", Types.INTEGER },
			{ "integrationAccountholder", Types.VARCHAR },
			{ "join_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFRenewalCompany (esfRenewalCompanyId LONG not null primary key,userId LONG,esfOrganizationId LONG,cardsNumber INTEGER,year INTEGER,date_ DATE null,paymentType INTEGER,status INTEGER,amount DOUBLE,info STRING null,accountholder VARCHAR(75) null,paymentDate DATE null,integrationAmount DOUBLE,integrationDate DATE null,integrationType INTEGER,integrationAccountholder VARCHAR(75) null,join_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table ESFRenewalCompany";
	public static final String ORDER_BY_JPQL = " ORDER BY esfRenewalCompany.esfRenewalCompanyId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFRenewalCompany.esfRenewalCompanyId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.renewal.model.ESFRenewalCompany"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.renewal.model.ESFRenewalCompany"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.renewal.model.ESFRenewalCompany"),
			true);
	public static long ESFORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long PAYMENTTYPE_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long YEAR_COLUMN_BITMASK = 8L;
	public static long ESFRENEWALCOMPANYID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.renewal.model.ESFRenewalCompany"));

	public ESFRenewalCompanyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfRenewalCompanyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfRenewalCompanyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfRenewalCompanyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRenewalCompany.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRenewalCompany.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfRenewalCompanyId", getEsfRenewalCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("cardsNumber", getCardsNumber());
		attributes.put("year", getYear());
		attributes.put("date", getDate());
		attributes.put("paymentType", getPaymentType());
		attributes.put("status", getStatus());
		attributes.put("amount", getAmount());
		attributes.put("info", getInfo());
		attributes.put("accountholder", getAccountholder());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("integrationAmount", getIntegrationAmount());
		attributes.put("integrationDate", getIntegrationDate());
		attributes.put("integrationType", getIntegrationType());
		attributes.put("integrationAccountholder", getIntegrationAccountholder());
		attributes.put("join", getJoin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfRenewalCompanyId = (Long)attributes.get("esfRenewalCompanyId");

		if (esfRenewalCompanyId != null) {
			setEsfRenewalCompanyId(esfRenewalCompanyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Integer cardsNumber = (Integer)attributes.get("cardsNumber");

		if (cardsNumber != null) {
			setCardsNumber(cardsNumber);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer paymentType = (Integer)attributes.get("paymentType");

		if (paymentType != null) {
			setPaymentType(paymentType);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String accountholder = (String)attributes.get("accountholder");

		if (accountholder != null) {
			setAccountholder(accountholder);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Double integrationAmount = (Double)attributes.get("integrationAmount");

		if (integrationAmount != null) {
			setIntegrationAmount(integrationAmount);
		}

		Date integrationDate = (Date)attributes.get("integrationDate");

		if (integrationDate != null) {
			setIntegrationDate(integrationDate);
		}

		Integer integrationType = (Integer)attributes.get("integrationType");

		if (integrationType != null) {
			setIntegrationType(integrationType);
		}

		String integrationAccountholder = (String)attributes.get(
				"integrationAccountholder");

		if (integrationAccountholder != null) {
			setIntegrationAccountholder(integrationAccountholder);
		}

		Boolean join = (Boolean)attributes.get("join");

		if (join != null) {
			setJoin(join);
		}
	}

	@Override
	public long getEsfRenewalCompanyId() {
		return _esfRenewalCompanyId;
	}

	@Override
	public void setEsfRenewalCompanyId(long esfRenewalCompanyId) {
		_esfRenewalCompanyId = esfRenewalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_columnBitmask |= ESFORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalEsfOrganizationId) {
			_setOriginalEsfOrganizationId = true;

			_originalEsfOrganizationId = _esfOrganizationId;
		}

		_esfOrganizationId = esfOrganizationId;
	}

	public long getOriginalEsfOrganizationId() {
		return _originalEsfOrganizationId;
	}

	@Override
	public int getCardsNumber() {
		return _cardsNumber;
	}

	@Override
	public void setCardsNumber(int cardsNumber) {
		_cardsNumber = cardsNumber;
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

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	@Override
	public int getPaymentType() {
		return _paymentType;
	}

	@Override
	public void setPaymentType(int paymentType) {
		_columnBitmask |= PAYMENTTYPE_COLUMN_BITMASK;

		if (!_setOriginalPaymentType) {
			_setOriginalPaymentType = true;

			_originalPaymentType = _paymentType;
		}

		_paymentType = paymentType;
	}

	public int getOriginalPaymentType() {
		return _originalPaymentType;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;
	}

	@Override
	public String getInfo() {
		if (_info == null) {
			return StringPool.BLANK;
		}
		else {
			return _info;
		}
	}

	@Override
	public void setInfo(String info) {
		_info = info;
	}

	@Override
	public String getAccountholder() {
		if (_accountholder == null) {
			return StringPool.BLANK;
		}
		else {
			return _accountholder;
		}
	}

	@Override
	public void setAccountholder(String accountholder) {
		_accountholder = accountholder;
	}

	@Override
	public Date getPaymentDate() {
		return _paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	@Override
	public double getIntegrationAmount() {
		return _integrationAmount;
	}

	@Override
	public void setIntegrationAmount(double integrationAmount) {
		_integrationAmount = integrationAmount;
	}

	@Override
	public Date getIntegrationDate() {
		return _integrationDate;
	}

	@Override
	public void setIntegrationDate(Date integrationDate) {
		_integrationDate = integrationDate;
	}

	@Override
	public int getIntegrationType() {
		return _integrationType;
	}

	@Override
	public void setIntegrationType(int integrationType) {
		_integrationType = integrationType;
	}

	@Override
	public String getIntegrationAccountholder() {
		if (_integrationAccountholder == null) {
			return StringPool.BLANK;
		}
		else {
			return _integrationAccountholder;
		}
	}

	@Override
	public void setIntegrationAccountholder(String integrationAccountholder) {
		_integrationAccountholder = integrationAccountholder;
	}

	@Override
	public boolean getJoin() {
		return _join;
	}

	@Override
	public boolean isJoin() {
		return _join;
	}

	@Override
	public void setJoin(boolean join) {
		_join = join;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFRenewalCompany.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFRenewalCompany toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFRenewalCompany)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFRenewalCompanyImpl esfRenewalCompanyImpl = new ESFRenewalCompanyImpl();

		esfRenewalCompanyImpl.setEsfRenewalCompanyId(getEsfRenewalCompanyId());
		esfRenewalCompanyImpl.setUserId(getUserId());
		esfRenewalCompanyImpl.setEsfOrganizationId(getEsfOrganizationId());
		esfRenewalCompanyImpl.setCardsNumber(getCardsNumber());
		esfRenewalCompanyImpl.setYear(getYear());
		esfRenewalCompanyImpl.setDate(getDate());
		esfRenewalCompanyImpl.setPaymentType(getPaymentType());
		esfRenewalCompanyImpl.setStatus(getStatus());
		esfRenewalCompanyImpl.setAmount(getAmount());
		esfRenewalCompanyImpl.setInfo(getInfo());
		esfRenewalCompanyImpl.setAccountholder(getAccountholder());
		esfRenewalCompanyImpl.setPaymentDate(getPaymentDate());
		esfRenewalCompanyImpl.setIntegrationAmount(getIntegrationAmount());
		esfRenewalCompanyImpl.setIntegrationDate(getIntegrationDate());
		esfRenewalCompanyImpl.setIntegrationType(getIntegrationType());
		esfRenewalCompanyImpl.setIntegrationAccountholder(getIntegrationAccountholder());
		esfRenewalCompanyImpl.setJoin(getJoin());

		esfRenewalCompanyImpl.resetOriginalValues();

		return esfRenewalCompanyImpl;
	}

	@Override
	public int compareTo(ESFRenewalCompany esfRenewalCompany) {
		long primaryKey = esfRenewalCompany.getPrimaryKey();

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

		if (!(obj instanceof ESFRenewalCompany)) {
			return false;
		}

		ESFRenewalCompany esfRenewalCompany = (ESFRenewalCompany)obj;

		long primaryKey = esfRenewalCompany.getPrimaryKey();

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
		ESFRenewalCompanyModelImpl esfRenewalCompanyModelImpl = this;

		esfRenewalCompanyModelImpl._originalEsfOrganizationId = esfRenewalCompanyModelImpl._esfOrganizationId;

		esfRenewalCompanyModelImpl._setOriginalEsfOrganizationId = false;

		esfRenewalCompanyModelImpl._originalYear = esfRenewalCompanyModelImpl._year;

		esfRenewalCompanyModelImpl._setOriginalYear = false;

		esfRenewalCompanyModelImpl._originalPaymentType = esfRenewalCompanyModelImpl._paymentType;

		esfRenewalCompanyModelImpl._setOriginalPaymentType = false;

		esfRenewalCompanyModelImpl._originalStatus = esfRenewalCompanyModelImpl._status;

		esfRenewalCompanyModelImpl._setOriginalStatus = false;

		esfRenewalCompanyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFRenewalCompany> toCacheModel() {
		ESFRenewalCompanyCacheModel esfRenewalCompanyCacheModel = new ESFRenewalCompanyCacheModel();

		esfRenewalCompanyCacheModel.esfRenewalCompanyId = getEsfRenewalCompanyId();

		esfRenewalCompanyCacheModel.userId = getUserId();

		esfRenewalCompanyCacheModel.esfOrganizationId = getEsfOrganizationId();

		esfRenewalCompanyCacheModel.cardsNumber = getCardsNumber();

		esfRenewalCompanyCacheModel.year = getYear();

		Date date = getDate();

		if (date != null) {
			esfRenewalCompanyCacheModel.date = date.getTime();
		}
		else {
			esfRenewalCompanyCacheModel.date = Long.MIN_VALUE;
		}

		esfRenewalCompanyCacheModel.paymentType = getPaymentType();

		esfRenewalCompanyCacheModel.status = getStatus();

		esfRenewalCompanyCacheModel.amount = getAmount();

		esfRenewalCompanyCacheModel.info = getInfo();

		String info = esfRenewalCompanyCacheModel.info;

		if ((info != null) && (info.length() == 0)) {
			esfRenewalCompanyCacheModel.info = null;
		}

		esfRenewalCompanyCacheModel.accountholder = getAccountholder();

		String accountholder = esfRenewalCompanyCacheModel.accountholder;

		if ((accountholder != null) && (accountholder.length() == 0)) {
			esfRenewalCompanyCacheModel.accountholder = null;
		}

		Date paymentDate = getPaymentDate();

		if (paymentDate != null) {
			esfRenewalCompanyCacheModel.paymentDate = paymentDate.getTime();
		}
		else {
			esfRenewalCompanyCacheModel.paymentDate = Long.MIN_VALUE;
		}

		esfRenewalCompanyCacheModel.integrationAmount = getIntegrationAmount();

		Date integrationDate = getIntegrationDate();

		if (integrationDate != null) {
			esfRenewalCompanyCacheModel.integrationDate = integrationDate.getTime();
		}
		else {
			esfRenewalCompanyCacheModel.integrationDate = Long.MIN_VALUE;
		}

		esfRenewalCompanyCacheModel.integrationType = getIntegrationType();

		esfRenewalCompanyCacheModel.integrationAccountholder = getIntegrationAccountholder();

		String integrationAccountholder = esfRenewalCompanyCacheModel.integrationAccountholder;

		if ((integrationAccountholder != null) &&
				(integrationAccountholder.length() == 0)) {
			esfRenewalCompanyCacheModel.integrationAccountholder = null;
		}

		esfRenewalCompanyCacheModel.join = getJoin();

		return esfRenewalCompanyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{esfRenewalCompanyId=");
		sb.append(getEsfRenewalCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", cardsNumber=");
		sb.append(getCardsNumber());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", paymentType=");
		sb.append(getPaymentType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", info=");
		sb.append(getInfo());
		sb.append(", accountholder=");
		sb.append(getAccountholder());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", integrationAmount=");
		sb.append(getIntegrationAmount());
		sb.append(", integrationDate=");
		sb.append(getIntegrationDate());
		sb.append(", integrationType=");
		sb.append(getIntegrationType());
		sb.append(", integrationAccountholder=");
		sb.append(getIntegrationAccountholder());
		sb.append(", join=");
		sb.append(getJoin());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.renewal.model.ESFRenewalCompany");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfRenewalCompanyId</column-name><column-value><![CDATA[");
		sb.append(getEsfRenewalCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardsNumber</column-name><column-value><![CDATA[");
		sb.append(getCardsNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentType</column-name><column-value><![CDATA[");
		sb.append(getPaymentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>info</column-name><column-value><![CDATA[");
		sb.append(getInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountholder</column-name><column-value><![CDATA[");
		sb.append(getAccountholder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationAmount</column-name><column-value><![CDATA[");
		sb.append(getIntegrationAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationDate</column-name><column-value><![CDATA[");
		sb.append(getIntegrationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationType</column-name><column-value><![CDATA[");
		sb.append(getIntegrationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationAccountholder</column-name><column-value><![CDATA[");
		sb.append(getIntegrationAccountholder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>join</column-name><column-value><![CDATA[");
		sb.append(getJoin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFRenewalCompany.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFRenewalCompany.class
		};
	private long _esfRenewalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _esfOrganizationId;
	private long _originalEsfOrganizationId;
	private boolean _setOriginalEsfOrganizationId;
	private int _cardsNumber;
	private int _year;
	private int _originalYear;
	private boolean _setOriginalYear;
	private Date _date;
	private int _paymentType;
	private int _originalPaymentType;
	private boolean _setOriginalPaymentType;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private double _amount;
	private String _info;
	private String _accountholder;
	private Date _paymentDate;
	private double _integrationAmount;
	private Date _integrationDate;
	private int _integrationType;
	private String _integrationAccountholder;
	private boolean _join;
	private long _columnBitmask;
	private ESFRenewalCompany _escapedModel;
}