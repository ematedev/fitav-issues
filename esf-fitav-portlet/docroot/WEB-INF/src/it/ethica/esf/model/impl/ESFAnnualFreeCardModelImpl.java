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

import it.ethica.esf.model.ESFAnnualFreeCard;
import it.ethica.esf.model.ESFAnnualFreeCardModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFAnnualFreeCard service. Represents a row in the &quot;ESFAnnualFreeCard&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFAnnualFreeCardModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFAnnualFreeCardImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualFreeCardImpl
 * @see it.ethica.esf.model.ESFAnnualFreeCard
 * @see it.ethica.esf.model.ESFAnnualFreeCardModel
 * @generated
 */
public class ESFAnnualFreeCardModelImpl extends BaseModelImpl<ESFAnnualFreeCard>
	implements ESFAnnualFreeCardModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f annual free card model instance should use the {@link it.ethica.esf.model.ESFAnnualFreeCard} interface instead.
	 */
	public static final String TABLE_NAME = "ESFAnnualFreeCard";
	public static final Object[][] TABLE_COLUMNS = {
			{ "annualFreeCardId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "assId", Types.BIGINT },
			{ "code_", Types.VARCHAR },
			{ "cardCode", Types.VARCHAR },
			{ "assCode", Types.VARCHAR },
			{ "assName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFAnnualFreeCard (annualFreeCardId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,assId LONG,code_ VARCHAR(75) null,cardCode VARCHAR(75) null,assCode VARCHAR(75) null,assName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFAnnualFreeCard";
	public static final String ORDER_BY_JPQL = " ORDER BY esfAnnualFreeCard.annualFreeCardId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFAnnualFreeCard.annualFreeCardId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFAnnualFreeCard"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFAnnualFreeCard"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFAnnualFreeCard"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long ANNUALFREECARDID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFAnnualFreeCard"));

	public ESFAnnualFreeCardModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _annualFreeCardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnnualFreeCardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _annualFreeCardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAnnualFreeCard.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAnnualFreeCard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("annualFreeCardId", getAnnualFreeCardId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assId", getAssId());
		attributes.put("code", getCode());
		attributes.put("cardCode", getCardCode());
		attributes.put("assCode", getAssCode());
		attributes.put("assName", getAssName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long annualFreeCardId = (Long)attributes.get("annualFreeCardId");

		if (annualFreeCardId != null) {
			setAnnualFreeCardId(annualFreeCardId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long assId = (Long)attributes.get("assId");

		if (assId != null) {
			setAssId(assId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String cardCode = (String)attributes.get("cardCode");

		if (cardCode != null) {
			setCardCode(cardCode);
		}

		String assCode = (String)attributes.get("assCode");

		if (assCode != null) {
			setAssCode(assCode);
		}

		String assName = (String)attributes.get("assName");

		if (assName != null) {
			setAssName(assName);
		}
	}

	@Override
	public long getAnnualFreeCardId() {
		return _annualFreeCardId;
	}

	@Override
	public void setAnnualFreeCardId(long annualFreeCardId) {
		_columnBitmask = -1L;

		_annualFreeCardId = annualFreeCardId;
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
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
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
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getAssId() {
		return _assId;
	}

	@Override
	public void setAssId(long assId) {
		_assId = assId;
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
	public String getCardCode() {
		if (_cardCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _cardCode;
		}
	}

	@Override
	public void setCardCode(String cardCode) {
		_cardCode = cardCode;
	}

	@Override
	public String getAssCode() {
		if (_assCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _assCode;
		}
	}

	@Override
	public void setAssCode(String assCode) {
		_assCode = assCode;
	}

	@Override
	public String getAssName() {
		if (_assName == null) {
			return StringPool.BLANK;
		}
		else {
			return _assName;
		}
	}

	@Override
	public void setAssName(String assName) {
		_assName = assName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFAnnualFreeCard.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFAnnualFreeCard toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFAnnualFreeCard)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFAnnualFreeCardImpl esfAnnualFreeCardImpl = new ESFAnnualFreeCardImpl();

		esfAnnualFreeCardImpl.setAnnualFreeCardId(getAnnualFreeCardId());
		esfAnnualFreeCardImpl.setCompanyId(getCompanyId());
		esfAnnualFreeCardImpl.setUserId(getUserId());
		esfAnnualFreeCardImpl.setUserName(getUserName());
		esfAnnualFreeCardImpl.setCreateDate(getCreateDate());
		esfAnnualFreeCardImpl.setModifiedDate(getModifiedDate());
		esfAnnualFreeCardImpl.setAssId(getAssId());
		esfAnnualFreeCardImpl.setCode(getCode());
		esfAnnualFreeCardImpl.setCardCode(getCardCode());
		esfAnnualFreeCardImpl.setAssCode(getAssCode());
		esfAnnualFreeCardImpl.setAssName(getAssName());

		esfAnnualFreeCardImpl.resetOriginalValues();

		return esfAnnualFreeCardImpl;
	}

	@Override
	public int compareTo(ESFAnnualFreeCard esfAnnualFreeCard) {
		int value = 0;

		if (getAnnualFreeCardId() < esfAnnualFreeCard.getAnnualFreeCardId()) {
			value = -1;
		}
		else if (getAnnualFreeCardId() > esfAnnualFreeCard.getAnnualFreeCardId()) {
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

		if (!(obj instanceof ESFAnnualFreeCard)) {
			return false;
		}

		ESFAnnualFreeCard esfAnnualFreeCard = (ESFAnnualFreeCard)obj;

		long primaryKey = esfAnnualFreeCard.getPrimaryKey();

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
		ESFAnnualFreeCardModelImpl esfAnnualFreeCardModelImpl = this;

		esfAnnualFreeCardModelImpl._originalCode = esfAnnualFreeCardModelImpl._code;

		esfAnnualFreeCardModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFAnnualFreeCard> toCacheModel() {
		ESFAnnualFreeCardCacheModel esfAnnualFreeCardCacheModel = new ESFAnnualFreeCardCacheModel();

		esfAnnualFreeCardCacheModel.annualFreeCardId = getAnnualFreeCardId();

		esfAnnualFreeCardCacheModel.companyId = getCompanyId();

		esfAnnualFreeCardCacheModel.userId = getUserId();

		esfAnnualFreeCardCacheModel.userName = getUserName();

		String userName = esfAnnualFreeCardCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfAnnualFreeCardCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfAnnualFreeCardCacheModel.createDate = createDate.getTime();
		}
		else {
			esfAnnualFreeCardCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfAnnualFreeCardCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfAnnualFreeCardCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfAnnualFreeCardCacheModel.assId = getAssId();

		esfAnnualFreeCardCacheModel.code = getCode();

		String code = esfAnnualFreeCardCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfAnnualFreeCardCacheModel.code = null;
		}

		esfAnnualFreeCardCacheModel.cardCode = getCardCode();

		String cardCode = esfAnnualFreeCardCacheModel.cardCode;

		if ((cardCode != null) && (cardCode.length() == 0)) {
			esfAnnualFreeCardCacheModel.cardCode = null;
		}

		esfAnnualFreeCardCacheModel.assCode = getAssCode();

		String assCode = esfAnnualFreeCardCacheModel.assCode;

		if ((assCode != null) && (assCode.length() == 0)) {
			esfAnnualFreeCardCacheModel.assCode = null;
		}

		esfAnnualFreeCardCacheModel.assName = getAssName();

		String assName = esfAnnualFreeCardCacheModel.assName;

		if ((assName != null) && (assName.length() == 0)) {
			esfAnnualFreeCardCacheModel.assName = null;
		}

		return esfAnnualFreeCardCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{annualFreeCardId=");
		sb.append(getAnnualFreeCardId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", assId=");
		sb.append(getAssId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", cardCode=");
		sb.append(getCardCode());
		sb.append(", assCode=");
		sb.append(getAssCode());
		sb.append(", assName=");
		sb.append(getAssName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFAnnualFreeCard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>annualFreeCardId</column-name><column-value><![CDATA[");
		sb.append(getAnnualFreeCardId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assId</column-name><column-value><![CDATA[");
		sb.append(getAssId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardCode</column-name><column-value><![CDATA[");
		sb.append(getCardCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assCode</column-name><column-value><![CDATA[");
		sb.append(getAssCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assName</column-name><column-value><![CDATA[");
		sb.append(getAssName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFAnnualFreeCard.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFAnnualFreeCard.class
		};
	private long _annualFreeCardId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _assId;
	private String _code;
	private String _originalCode;
	private String _cardCode;
	private String _assCode;
	private String _assName;
	private long _columnBitmask;
	private ESFAnnualFreeCard _escapedModel;
}