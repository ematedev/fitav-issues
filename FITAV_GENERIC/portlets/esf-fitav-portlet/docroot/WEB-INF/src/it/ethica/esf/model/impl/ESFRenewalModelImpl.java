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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.model.ESFRenewalModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFRenewal service. Represents a row in the &quot;ESFRenewal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFRenewalModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFRenewalImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalImpl
 * @see it.ethica.esf.model.ESFRenewal
 * @see it.ethica.esf.model.ESFRenewalModel
 * @generated
 */
public class ESFRenewalModelImpl extends BaseModelImpl<ESFRenewal>
	implements ESFRenewalModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f renewal model instance should use the {@link it.ethica.esf.model.ESFRenewal} interface instead.
	 */
	public static final String TABLE_NAME = "ESFRenewal";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfRenewalId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "quantity", Types.BIGINT },
			{ "paymentReason", Types.VARCHAR },
			{ "paymentType", Types.VARCHAR },
			{ "paymentDate", Types.TIMESTAMP },
			{ "paymentReceived", Types.BOOLEAN },
			{ "createDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "info", Types.VARCHAR },
			{ "madeBy", Types.VARCHAR },
			{ "amount", Types.DOUBLE },
			{ "organizationId", Types.BIGINT },
			{ "reportingYear", Types.INTEGER },
			{ "amountTotal", Types.DOUBLE },
			{ "isTotal", Types.BOOLEAN },
			{ "renewalFatherId", Types.BIGINT },
			{ "affiliates", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFRenewal (esfRenewalId LONG not null primary key,companyId LONG,userId LONG,modifiedDate DATE null,quantity LONG,paymentReason VARCHAR(75) null,paymentType VARCHAR(75) null,paymentDate DATE null,paymentReceived BOOLEAN,createDate DATE null,groupId LONG,info VARCHAR(75) null,madeBy VARCHAR(75) null,amount DOUBLE,organizationId LONG,reportingYear INTEGER,amountTotal DOUBLE,isTotal BOOLEAN,renewalFatherId LONG,affiliates BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table ESFRenewal";
	public static final String ORDER_BY_JPQL = " ORDER BY esfRenewal.esfRenewalId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFRenewal.esfRenewalId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFRenewal"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFRenewal"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFRenewal"),
			true);
	public static long ISTOTAL_COLUMN_BITMASK = 1L;
	public static long ORGANIZATIONID_COLUMN_BITMASK = 2L;
	public static long PAYMENTREASON_COLUMN_BITMASK = 4L;
	public static long PAYMENTRECEIVED_COLUMN_BITMASK = 8L;
	public static long RENEWALFATHERID_COLUMN_BITMASK = 16L;
	public static long REPORTINGYEAR_COLUMN_BITMASK = 32L;
	public static long USERID_COLUMN_BITMASK = 64L;
	public static long ESFRENEWALID_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFRenewal"));

	public ESFRenewalModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfRenewalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfRenewalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfRenewalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRenewal.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRenewal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfRenewalId", getEsfRenewalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("quantity", getQuantity());
		attributes.put("paymentReason", getPaymentReason());
		attributes.put("paymentType", getPaymentType());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("paymentReceived", getPaymentReceived());
		attributes.put("createDate", getCreateDate());
		attributes.put("groupId", getGroupId());
		attributes.put("info", getInfo());
		attributes.put("madeBy", getMadeBy());
		attributes.put("amount", getAmount());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("reportingYear", getReportingYear());
		attributes.put("amountTotal", getAmountTotal());
		attributes.put("isTotal", getIsTotal());
		attributes.put("renewalFatherId", getRenewalFatherId());
		attributes.put("affiliates", getAffiliates());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfRenewalId = (Long)attributes.get("esfRenewalId");

		if (esfRenewalId != null) {
			setEsfRenewalId(esfRenewalId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long quantity = (Long)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String paymentReason = (String)attributes.get("paymentReason");

		if (paymentReason != null) {
			setPaymentReason(paymentReason);
		}

		String paymentType = (String)attributes.get("paymentType");

		if (paymentType != null) {
			setPaymentType(paymentType);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Boolean paymentReceived = (Boolean)attributes.get("paymentReceived");

		if (paymentReceived != null) {
			setPaymentReceived(paymentReceived);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String madeBy = (String)attributes.get("madeBy");

		if (madeBy != null) {
			setMadeBy(madeBy);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Integer reportingYear = (Integer)attributes.get("reportingYear");

		if (reportingYear != null) {
			setReportingYear(reportingYear);
		}

		Double amountTotal = (Double)attributes.get("amountTotal");

		if (amountTotal != null) {
			setAmountTotal(amountTotal);
		}

		Boolean isTotal = (Boolean)attributes.get("isTotal");

		if (isTotal != null) {
			setIsTotal(isTotal);
		}

		Long renewalFatherId = (Long)attributes.get("renewalFatherId");

		if (renewalFatherId != null) {
			setRenewalFatherId(renewalFatherId);
		}

		Boolean affiliates = (Boolean)attributes.get("affiliates");

		if (affiliates != null) {
			setAffiliates(affiliates);
		}
	}

	@Override
	public long getEsfRenewalId() {
		return _esfRenewalId;
	}

	@Override
	public void setEsfRenewalId(long esfRenewalId) {
		_esfRenewalId = esfRenewalId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(long quantity) {
		_quantity = quantity;
	}

	@Override
	public String getPaymentReason() {
		if (_paymentReason == null) {
			return StringPool.BLANK;
		}
		else {
			return _paymentReason;
		}
	}

	@Override
	public void setPaymentReason(String paymentReason) {
		_columnBitmask |= PAYMENTREASON_COLUMN_BITMASK;

		if (_originalPaymentReason == null) {
			_originalPaymentReason = _paymentReason;
		}

		_paymentReason = paymentReason;
	}

	public String getOriginalPaymentReason() {
		return GetterUtil.getString(_originalPaymentReason);
	}

	@Override
	public String getPaymentType() {
		if (_paymentType == null) {
			return StringPool.BLANK;
		}
		else {
			return _paymentType;
		}
	}

	@Override
	public void setPaymentType(String paymentType) {
		_paymentType = paymentType;
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
	public boolean getPaymentReceived() {
		return _paymentReceived;
	}

	@Override
	public boolean isPaymentReceived() {
		return _paymentReceived;
	}

	@Override
	public void setPaymentReceived(boolean paymentReceived) {
		_columnBitmask |= PAYMENTRECEIVED_COLUMN_BITMASK;

		if (!_setOriginalPaymentReceived) {
			_setOriginalPaymentReceived = true;

			_originalPaymentReceived = _paymentReceived;
		}

		_paymentReceived = paymentReceived;
	}

	public boolean getOriginalPaymentReceived() {
		return _originalPaymentReceived;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
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
	public String getMadeBy() {
		if (_madeBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _madeBy;
		}
	}

	@Override
	public void setMadeBy(String madeBy) {
		_madeBy = madeBy;
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
	public int getReportingYear() {
		return _reportingYear;
	}

	@Override
	public void setReportingYear(int reportingYear) {
		_columnBitmask |= REPORTINGYEAR_COLUMN_BITMASK;

		if (!_setOriginalReportingYear) {
			_setOriginalReportingYear = true;

			_originalReportingYear = _reportingYear;
		}

		_reportingYear = reportingYear;
	}

	public int getOriginalReportingYear() {
		return _originalReportingYear;
	}

	@Override
	public double getAmountTotal() {
		return _amountTotal;
	}

	@Override
	public void setAmountTotal(double amountTotal) {
		_amountTotal = amountTotal;
	}

	@Override
	public boolean getIsTotal() {
		return _isTotal;
	}

	@Override
	public boolean isIsTotal() {
		return _isTotal;
	}

	@Override
	public void setIsTotal(boolean isTotal) {
		_columnBitmask |= ISTOTAL_COLUMN_BITMASK;

		if (!_setOriginalIsTotal) {
			_setOriginalIsTotal = true;

			_originalIsTotal = _isTotal;
		}

		_isTotal = isTotal;
	}

	public boolean getOriginalIsTotal() {
		return _originalIsTotal;
	}

	@Override
	public long getRenewalFatherId() {
		return _renewalFatherId;
	}

	@Override
	public void setRenewalFatherId(long renewalFatherId) {
		_columnBitmask |= RENEWALFATHERID_COLUMN_BITMASK;

		if (!_setOriginalRenewalFatherId) {
			_setOriginalRenewalFatherId = true;

			_originalRenewalFatherId = _renewalFatherId;
		}

		_renewalFatherId = renewalFatherId;
	}

	public long getOriginalRenewalFatherId() {
		return _originalRenewalFatherId;
	}

	@Override
	public boolean getAffiliates() {
		return _affiliates;
	}

	@Override
	public boolean isAffiliates() {
		return _affiliates;
	}

	@Override
	public void setAffiliates(boolean affiliates) {
		_affiliates = affiliates;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFRenewal.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFRenewal toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFRenewal)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFRenewalImpl esfRenewalImpl = new ESFRenewalImpl();

		esfRenewalImpl.setEsfRenewalId(getEsfRenewalId());
		esfRenewalImpl.setCompanyId(getCompanyId());
		esfRenewalImpl.setUserId(getUserId());
		esfRenewalImpl.setModifiedDate(getModifiedDate());
		esfRenewalImpl.setQuantity(getQuantity());
		esfRenewalImpl.setPaymentReason(getPaymentReason());
		esfRenewalImpl.setPaymentType(getPaymentType());
		esfRenewalImpl.setPaymentDate(getPaymentDate());
		esfRenewalImpl.setPaymentReceived(getPaymentReceived());
		esfRenewalImpl.setCreateDate(getCreateDate());
		esfRenewalImpl.setGroupId(getGroupId());
		esfRenewalImpl.setInfo(getInfo());
		esfRenewalImpl.setMadeBy(getMadeBy());
		esfRenewalImpl.setAmount(getAmount());
		esfRenewalImpl.setOrganizationId(getOrganizationId());
		esfRenewalImpl.setReportingYear(getReportingYear());
		esfRenewalImpl.setAmountTotal(getAmountTotal());
		esfRenewalImpl.setIsTotal(getIsTotal());
		esfRenewalImpl.setRenewalFatherId(getRenewalFatherId());
		esfRenewalImpl.setAffiliates(getAffiliates());

		esfRenewalImpl.resetOriginalValues();

		return esfRenewalImpl;
	}

	@Override
	public int compareTo(ESFRenewal esfRenewal) {
		long primaryKey = esfRenewal.getPrimaryKey();

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

		if (!(obj instanceof ESFRenewal)) {
			return false;
		}

		ESFRenewal esfRenewal = (ESFRenewal)obj;

		long primaryKey = esfRenewal.getPrimaryKey();

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
		ESFRenewalModelImpl esfRenewalModelImpl = this;

		esfRenewalModelImpl._originalUserId = esfRenewalModelImpl._userId;

		esfRenewalModelImpl._setOriginalUserId = false;

		esfRenewalModelImpl._originalPaymentReason = esfRenewalModelImpl._paymentReason;

		esfRenewalModelImpl._originalPaymentReceived = esfRenewalModelImpl._paymentReceived;

		esfRenewalModelImpl._setOriginalPaymentReceived = false;

		esfRenewalModelImpl._originalOrganizationId = esfRenewalModelImpl._organizationId;

		esfRenewalModelImpl._setOriginalOrganizationId = false;

		esfRenewalModelImpl._originalReportingYear = esfRenewalModelImpl._reportingYear;

		esfRenewalModelImpl._setOriginalReportingYear = false;

		esfRenewalModelImpl._originalIsTotal = esfRenewalModelImpl._isTotal;

		esfRenewalModelImpl._setOriginalIsTotal = false;

		esfRenewalModelImpl._originalRenewalFatherId = esfRenewalModelImpl._renewalFatherId;

		esfRenewalModelImpl._setOriginalRenewalFatherId = false;

		esfRenewalModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFRenewal> toCacheModel() {
		ESFRenewalCacheModel esfRenewalCacheModel = new ESFRenewalCacheModel();

		esfRenewalCacheModel.esfRenewalId = getEsfRenewalId();

		esfRenewalCacheModel.companyId = getCompanyId();

		esfRenewalCacheModel.userId = getUserId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfRenewalCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfRenewalCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfRenewalCacheModel.quantity = getQuantity();

		esfRenewalCacheModel.paymentReason = getPaymentReason();

		String paymentReason = esfRenewalCacheModel.paymentReason;

		if ((paymentReason != null) && (paymentReason.length() == 0)) {
			esfRenewalCacheModel.paymentReason = null;
		}

		esfRenewalCacheModel.paymentType = getPaymentType();

		String paymentType = esfRenewalCacheModel.paymentType;

		if ((paymentType != null) && (paymentType.length() == 0)) {
			esfRenewalCacheModel.paymentType = null;
		}

		Date paymentDate = getPaymentDate();

		if (paymentDate != null) {
			esfRenewalCacheModel.paymentDate = paymentDate.getTime();
		}
		else {
			esfRenewalCacheModel.paymentDate = Long.MIN_VALUE;
		}

		esfRenewalCacheModel.paymentReceived = getPaymentReceived();

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfRenewalCacheModel.createDate = createDate.getTime();
		}
		else {
			esfRenewalCacheModel.createDate = Long.MIN_VALUE;
		}

		esfRenewalCacheModel.groupId = getGroupId();

		esfRenewalCacheModel.info = getInfo();

		String info = esfRenewalCacheModel.info;

		if ((info != null) && (info.length() == 0)) {
			esfRenewalCacheModel.info = null;
		}

		esfRenewalCacheModel.madeBy = getMadeBy();

		String madeBy = esfRenewalCacheModel.madeBy;

		if ((madeBy != null) && (madeBy.length() == 0)) {
			esfRenewalCacheModel.madeBy = null;
		}

		esfRenewalCacheModel.amount = getAmount();

		esfRenewalCacheModel.organizationId = getOrganizationId();

		esfRenewalCacheModel.reportingYear = getReportingYear();

		esfRenewalCacheModel.amountTotal = getAmountTotal();

		esfRenewalCacheModel.isTotal = getIsTotal();

		esfRenewalCacheModel.renewalFatherId = getRenewalFatherId();

		esfRenewalCacheModel.affiliates = getAffiliates();

		return esfRenewalCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{esfRenewalId=");
		sb.append(getEsfRenewalId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", paymentReason=");
		sb.append(getPaymentReason());
		sb.append(", paymentType=");
		sb.append(getPaymentType());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", paymentReceived=");
		sb.append(getPaymentReceived());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", info=");
		sb.append(getInfo());
		sb.append(", madeBy=");
		sb.append(getMadeBy());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", reportingYear=");
		sb.append(getReportingYear());
		sb.append(", amountTotal=");
		sb.append(getAmountTotal());
		sb.append(", isTotal=");
		sb.append(getIsTotal());
		sb.append(", renewalFatherId=");
		sb.append(getRenewalFatherId());
		sb.append(", affiliates=");
		sb.append(getAffiliates());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRenewal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfRenewalId</column-name><column-value><![CDATA[");
		sb.append(getEsfRenewalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentReason</column-name><column-value><![CDATA[");
		sb.append(getPaymentReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentType</column-name><column-value><![CDATA[");
		sb.append(getPaymentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentReceived</column-name><column-value><![CDATA[");
		sb.append(getPaymentReceived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>info</column-name><column-value><![CDATA[");
		sb.append(getInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>madeBy</column-name><column-value><![CDATA[");
		sb.append(getMadeBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportingYear</column-name><column-value><![CDATA[");
		sb.append(getReportingYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountTotal</column-name><column-value><![CDATA[");
		sb.append(getAmountTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTotal</column-name><column-value><![CDATA[");
		sb.append(getIsTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewalFatherId</column-name><column-value><![CDATA[");
		sb.append(getRenewalFatherId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>affiliates</column-name><column-value><![CDATA[");
		sb.append(getAffiliates());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFRenewal.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFRenewal.class
		};
	private long _esfRenewalId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _modifiedDate;
	private long _quantity;
	private String _paymentReason;
	private String _originalPaymentReason;
	private String _paymentType;
	private Date _paymentDate;
	private boolean _paymentReceived;
	private boolean _originalPaymentReceived;
	private boolean _setOriginalPaymentReceived;
	private Date _createDate;
	private long _groupId;
	private String _info;
	private String _madeBy;
	private double _amount;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private int _reportingYear;
	private int _originalReportingYear;
	private boolean _setOriginalReportingYear;
	private double _amountTotal;
	private boolean _isTotal;
	private boolean _originalIsTotal;
	private boolean _setOriginalIsTotal;
	private long _renewalFatherId;
	private long _originalRenewalFatherId;
	private boolean _setOriginalRenewalFatherId;
	private boolean _affiliates;
	private long _columnBitmask;
	private ESFRenewal _escapedModel;
}