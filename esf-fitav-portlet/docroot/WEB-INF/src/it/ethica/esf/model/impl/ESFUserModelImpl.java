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
import com.liferay.portal.kernel.json.JSON;
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

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserModel;
import it.ethica.esf.model.ESFUserSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ESFUser service. Represents a row in the &quot;ESFUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFUserModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFUserImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserImpl
 * @see it.ethica.esf.model.ESFUser
 * @see it.ethica.esf.model.ESFUserModel
 * @generated
 */
@JSON(strict = true)
public class ESFUserModelImpl extends BaseModelImpl<ESFUser>
	implements ESFUserModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f user model instance should use the {@link it.ethica.esf.model.ESFUser} interface instead.
	 */
	public static final String TABLE_NAME = "ESFUser";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfUserId", Types.BIGINT },
			{ "code_", Types.VARCHAR },
			{ "typearmy", Types.BIGINT },
			{ "fiscalCode", Types.VARCHAR },
			{ "birthcity", Types.VARCHAR },
			{ "nationality", Types.VARCHAR },
			{ "isSportsGroups", Types.BOOLEAN },
			{ "job", Types.VARCHAR },
			{ "issfIdNumber", Types.VARCHAR },
			{ "categoryId", Types.BIGINT },
			{ "pin", Types.BIGINT },
			{ "codeUser", Types.BIGINT },
			{ "DateOfDeath", Types.TIMESTAMP },
			{ "privacy1", Types.BOOLEAN },
			{ "privacy2", Types.BOOLEAN },
			{ "privacy3", Types.BOOLEAN },
			{ "datePrivacy1", Types.TIMESTAMP },
			{ "datePrivacy2", Types.TIMESTAMP },
			{ "datePrivacy3", Types.TIMESTAMP },
			{ "validateCF", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFUser (uuid_ VARCHAR(75) null,esfUserId LONG not null primary key,code_ VARCHAR(75) null,typearmy LONG,fiscalCode VARCHAR(75) null,birthcity VARCHAR(75) null,nationality VARCHAR(75) null,isSportsGroups BOOLEAN,job VARCHAR(75) null,issfIdNumber VARCHAR(75) null,categoryId LONG,pin LONG,codeUser LONG,DateOfDeath DATE null,privacy1 BOOLEAN,privacy2 BOOLEAN,privacy3 BOOLEAN,datePrivacy1 DATE null,datePrivacy2 DATE null,datePrivacy3 DATE null,validateCF BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table ESFUser";
	public static final String ORDER_BY_JPQL = " ORDER BY esfUser.esfUserId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFUser.esfUserId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFUser"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFUser"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFUser"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long CODEUSER_COLUMN_BITMASK = 2L;
	public static long ESFUSERID_COLUMN_BITMASK = 4L;
	public static long FISCALCODE_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ESFUser toModel(ESFUserSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ESFUser model = new ESFUserImpl();

		model.setUuid(soapModel.getUuid());
		model.setEsfUserId(soapModel.getEsfUserId());
		model.setCode(soapModel.getCode());
		model.setTypearmy(soapModel.getTypearmy());
		model.setFiscalCode(soapModel.getFiscalCode());
		model.setBirthcity(soapModel.getBirthcity());
		model.setNationality(soapModel.getNationality());
		model.setIsSportsGroups(soapModel.getIsSportsGroups());
		model.setJob(soapModel.getJob());
		model.setIssfIdNumber(soapModel.getIssfIdNumber());
		model.setCategoryId(soapModel.getCategoryId());
		model.setPin(soapModel.getPin());
		model.setCodeUser(soapModel.getCodeUser());
		model.setDateOfDeath(soapModel.getDateOfDeath());
		model.setPrivacy1(soapModel.getPrivacy1());
		model.setPrivacy2(soapModel.getPrivacy2());
		model.setPrivacy3(soapModel.getPrivacy3());
		model.setDatePrivacy1(soapModel.getDatePrivacy1());
		model.setDatePrivacy2(soapModel.getDatePrivacy2());
		model.setDatePrivacy3(soapModel.getDatePrivacy3());
		model.setValidateCF(soapModel.getValidateCF());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ESFUser> toModels(ESFUserSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ESFUser> models = new ArrayList<ESFUser>(soapModels.length);

		for (ESFUserSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFUser"));

	public ESFUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("typearmy", getTypearmy());
		attributes.put("fiscalCode", getFiscalCode());
		attributes.put("birthcity", getBirthcity());
		attributes.put("nationality", getNationality());
		attributes.put("isSportsGroups", getIsSportsGroups());
		attributes.put("job", getJob());
		attributes.put("issfIdNumber", getIssfIdNumber());
		attributes.put("categoryId", getCategoryId());
		attributes.put("pin", getPin());
		attributes.put("codeUser", getCodeUser());
		attributes.put("DateOfDeath", getDateOfDeath());
		attributes.put("privacy1", getPrivacy1());
		attributes.put("privacy2", getPrivacy2());
		attributes.put("privacy3", getPrivacy3());
		attributes.put("datePrivacy1", getDatePrivacy1());
		attributes.put("datePrivacy2", getDatePrivacy2());
		attributes.put("datePrivacy3", getDatePrivacy3());
		attributes.put("validateCF", getValidateCF());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long typearmy = (Long)attributes.get("typearmy");

		if (typearmy != null) {
			setTypearmy(typearmy);
		}

		String fiscalCode = (String)attributes.get("fiscalCode");

		if (fiscalCode != null) {
			setFiscalCode(fiscalCode);
		}

		String birthcity = (String)attributes.get("birthcity");

		if (birthcity != null) {
			setBirthcity(birthcity);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		Boolean isSportsGroups = (Boolean)attributes.get("isSportsGroups");

		if (isSportsGroups != null) {
			setIsSportsGroups(isSportsGroups);
		}

		String job = (String)attributes.get("job");

		if (job != null) {
			setJob(job);
		}

		String issfIdNumber = (String)attributes.get("issfIdNumber");

		if (issfIdNumber != null) {
			setIssfIdNumber(issfIdNumber);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long pin = (Long)attributes.get("pin");

		if (pin != null) {
			setPin(pin);
		}

		Long codeUser = (Long)attributes.get("codeUser");

		if (codeUser != null) {
			setCodeUser(codeUser);
		}

		Date DateOfDeath = (Date)attributes.get("DateOfDeath");

		if (DateOfDeath != null) {
			setDateOfDeath(DateOfDeath);
		}

		Boolean privacy1 = (Boolean)attributes.get("privacy1");

		if (privacy1 != null) {
			setPrivacy1(privacy1);
		}

		Boolean privacy2 = (Boolean)attributes.get("privacy2");

		if (privacy2 != null) {
			setPrivacy2(privacy2);
		}

		Boolean privacy3 = (Boolean)attributes.get("privacy3");

		if (privacy3 != null) {
			setPrivacy3(privacy3);
		}

		Date datePrivacy1 = (Date)attributes.get("datePrivacy1");

		if (datePrivacy1 != null) {
			setDatePrivacy1(datePrivacy1);
		}

		Date datePrivacy2 = (Date)attributes.get("datePrivacy2");

		if (datePrivacy2 != null) {
			setDatePrivacy2(datePrivacy2);
		}

		Date datePrivacy3 = (Date)attributes.get("datePrivacy3");

		if (datePrivacy3 != null) {
			setDatePrivacy3(datePrivacy3);
		}

		Boolean validateCF = (Boolean)attributes.get("validateCF");

		if (validateCF != null) {
			setValidateCF(validateCF);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_columnBitmask = -1L;

		if (!_setOriginalEsfUserId) {
			_setOriginalEsfUserId = true;

			_originalEsfUserId = _esfUserId;
		}

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

	public long getOriginalEsfUserId() {
		return _originalEsfUserId;
	}

	@JSON
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

	@JSON
	@Override
	public long getTypearmy() {
		return _typearmy;
	}

	@Override
	public void setTypearmy(long typearmy) {
		_typearmy = typearmy;
	}

	@JSON
	@Override
	public String getFiscalCode() {
		if (_fiscalCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _fiscalCode;
		}
	}

	@Override
	public void setFiscalCode(String fiscalCode) {
		_columnBitmask |= FISCALCODE_COLUMN_BITMASK;

		if (_originalFiscalCode == null) {
			_originalFiscalCode = _fiscalCode;
		}

		_fiscalCode = fiscalCode;
	}

	public String getOriginalFiscalCode() {
		return GetterUtil.getString(_originalFiscalCode);
	}

	@JSON
	@Override
	public String getBirthcity() {
		if (_birthcity == null) {
			return StringPool.BLANK;
		}
		else {
			return _birthcity;
		}
	}

	@Override
	public void setBirthcity(String birthcity) {
		_birthcity = birthcity;
	}

	@JSON
	@Override
	public String getNationality() {
		if (_nationality == null) {
			return StringPool.BLANK;
		}
		else {
			return _nationality;
		}
	}

	@Override
	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	@JSON
	@Override
	public boolean getIsSportsGroups() {
		return _isSportsGroups;
	}

	@Override
	public boolean isIsSportsGroups() {
		return _isSportsGroups;
	}

	@Override
	public void setIsSportsGroups(boolean isSportsGroups) {
		_isSportsGroups = isSportsGroups;
	}

	@JSON
	@Override
	public String getJob() {
		if (_job == null) {
			return StringPool.BLANK;
		}
		else {
			return _job;
		}
	}

	@Override
	public void setJob(String job) {
		_job = job;
	}

	@JSON
	@Override
	public String getIssfIdNumber() {
		if (_issfIdNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _issfIdNumber;
		}
	}

	@Override
	public void setIssfIdNumber(String issfIdNumber) {
		_issfIdNumber = issfIdNumber;
	}

	@JSON
	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	@JSON
	@Override
	public long getPin() {
		return _pin;
	}

	@Override
	public void setPin(long pin) {
		_pin = pin;
	}

	@JSON
	@Override
	public long getCodeUser() {
		return _codeUser;
	}

	@Override
	public void setCodeUser(long codeUser) {
		_columnBitmask |= CODEUSER_COLUMN_BITMASK;

		if (!_setOriginalCodeUser) {
			_setOriginalCodeUser = true;

			_originalCodeUser = _codeUser;
		}

		_codeUser = codeUser;
	}

	public long getOriginalCodeUser() {
		return _originalCodeUser;
	}

	@JSON
	@Override
	public Date getDateOfDeath() {
		return _DateOfDeath;
	}

	@Override
	public void setDateOfDeath(Date DateOfDeath) {
		_DateOfDeath = DateOfDeath;
	}

	@JSON
	@Override
	public boolean getPrivacy1() {
		return _privacy1;
	}

	@Override
	public boolean isPrivacy1() {
		return _privacy1;
	}

	@Override
	public void setPrivacy1(boolean privacy1) {
		_privacy1 = privacy1;
	}

	@JSON
	@Override
	public boolean getPrivacy2() {
		return _privacy2;
	}

	@Override
	public boolean isPrivacy2() {
		return _privacy2;
	}

	@Override
	public void setPrivacy2(boolean privacy2) {
		_privacy2 = privacy2;
	}

	@JSON
	@Override
	public boolean getPrivacy3() {
		return _privacy3;
	}

	@Override
	public boolean isPrivacy3() {
		return _privacy3;
	}

	@Override
	public void setPrivacy3(boolean privacy3) {
		_privacy3 = privacy3;
	}

	@JSON
	@Override
	public Date getDatePrivacy1() {
		return _datePrivacy1;
	}

	@Override
	public void setDatePrivacy1(Date datePrivacy1) {
		_datePrivacy1 = datePrivacy1;
	}

	@JSON
	@Override
	public Date getDatePrivacy2() {
		return _datePrivacy2;
	}

	@Override
	public void setDatePrivacy2(Date datePrivacy2) {
		_datePrivacy2 = datePrivacy2;
	}

	@JSON
	@Override
	public Date getDatePrivacy3() {
		return _datePrivacy3;
	}

	@Override
	public void setDatePrivacy3(Date datePrivacy3) {
		_datePrivacy3 = datePrivacy3;
	}

	@JSON
	@Override
	public boolean getValidateCF() {
		return _validateCF;
	}

	@Override
	public boolean isValidateCF() {
		return _validateCF;
	}

	@Override
	public void setValidateCF(boolean validateCF) {
		_validateCF = validateCF;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFUser toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFUser)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFUserImpl esfUserImpl = new ESFUserImpl();

		esfUserImpl.setUuid(getUuid());
		esfUserImpl.setEsfUserId(getEsfUserId());
		esfUserImpl.setCode(getCode());
		esfUserImpl.setTypearmy(getTypearmy());
		esfUserImpl.setFiscalCode(getFiscalCode());
		esfUserImpl.setBirthcity(getBirthcity());
		esfUserImpl.setNationality(getNationality());
		esfUserImpl.setIsSportsGroups(getIsSportsGroups());
		esfUserImpl.setJob(getJob());
		esfUserImpl.setIssfIdNumber(getIssfIdNumber());
		esfUserImpl.setCategoryId(getCategoryId());
		esfUserImpl.setPin(getPin());
		esfUserImpl.setCodeUser(getCodeUser());
		esfUserImpl.setDateOfDeath(getDateOfDeath());
		esfUserImpl.setPrivacy1(getPrivacy1());
		esfUserImpl.setPrivacy2(getPrivacy2());
		esfUserImpl.setPrivacy3(getPrivacy3());
		esfUserImpl.setDatePrivacy1(getDatePrivacy1());
		esfUserImpl.setDatePrivacy2(getDatePrivacy2());
		esfUserImpl.setDatePrivacy3(getDatePrivacy3());
		esfUserImpl.setValidateCF(getValidateCF());

		esfUserImpl.resetOriginalValues();

		return esfUserImpl;
	}

	@Override
	public int compareTo(ESFUser esfUser) {
		int value = 0;

		if (getEsfUserId() < esfUser.getEsfUserId()) {
			value = -1;
		}
		else if (getEsfUserId() > esfUser.getEsfUserId()) {
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

		if (!(obj instanceof ESFUser)) {
			return false;
		}

		ESFUser esfUser = (ESFUser)obj;

		long primaryKey = esfUser.getPrimaryKey();

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
		ESFUserModelImpl esfUserModelImpl = this;

		esfUserModelImpl._originalUuid = esfUserModelImpl._uuid;

		esfUserModelImpl._originalEsfUserId = esfUserModelImpl._esfUserId;

		esfUserModelImpl._setOriginalEsfUserId = false;

		esfUserModelImpl._originalCode = esfUserModelImpl._code;

		esfUserModelImpl._originalFiscalCode = esfUserModelImpl._fiscalCode;

		esfUserModelImpl._originalCodeUser = esfUserModelImpl._codeUser;

		esfUserModelImpl._setOriginalCodeUser = false;

		esfUserModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFUser> toCacheModel() {
		ESFUserCacheModel esfUserCacheModel = new ESFUserCacheModel();

		esfUserCacheModel.uuid = getUuid();

		String uuid = esfUserCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfUserCacheModel.uuid = null;
		}

		esfUserCacheModel.esfUserId = getEsfUserId();

		esfUserCacheModel.code = getCode();

		String code = esfUserCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfUserCacheModel.code = null;
		}

		esfUserCacheModel.typearmy = getTypearmy();

		esfUserCacheModel.fiscalCode = getFiscalCode();

		String fiscalCode = esfUserCacheModel.fiscalCode;

		if ((fiscalCode != null) && (fiscalCode.length() == 0)) {
			esfUserCacheModel.fiscalCode = null;
		}

		esfUserCacheModel.birthcity = getBirthcity();

		String birthcity = esfUserCacheModel.birthcity;

		if ((birthcity != null) && (birthcity.length() == 0)) {
			esfUserCacheModel.birthcity = null;
		}

		esfUserCacheModel.nationality = getNationality();

		String nationality = esfUserCacheModel.nationality;

		if ((nationality != null) && (nationality.length() == 0)) {
			esfUserCacheModel.nationality = null;
		}

		esfUserCacheModel.isSportsGroups = getIsSportsGroups();

		esfUserCacheModel.job = getJob();

		String job = esfUserCacheModel.job;

		if ((job != null) && (job.length() == 0)) {
			esfUserCacheModel.job = null;
		}

		esfUserCacheModel.issfIdNumber = getIssfIdNumber();

		String issfIdNumber = esfUserCacheModel.issfIdNumber;

		if ((issfIdNumber != null) && (issfIdNumber.length() == 0)) {
			esfUserCacheModel.issfIdNumber = null;
		}

		esfUserCacheModel.categoryId = getCategoryId();

		esfUserCacheModel.pin = getPin();

		esfUserCacheModel.codeUser = getCodeUser();

		Date DateOfDeath = getDateOfDeath();

		if (DateOfDeath != null) {
			esfUserCacheModel.DateOfDeath = DateOfDeath.getTime();
		}
		else {
			esfUserCacheModel.DateOfDeath = Long.MIN_VALUE;
		}

		esfUserCacheModel.privacy1 = getPrivacy1();

		esfUserCacheModel.privacy2 = getPrivacy2();

		esfUserCacheModel.privacy3 = getPrivacy3();

		Date datePrivacy1 = getDatePrivacy1();

		if (datePrivacy1 != null) {
			esfUserCacheModel.datePrivacy1 = datePrivacy1.getTime();
		}
		else {
			esfUserCacheModel.datePrivacy1 = Long.MIN_VALUE;
		}

		Date datePrivacy2 = getDatePrivacy2();

		if (datePrivacy2 != null) {
			esfUserCacheModel.datePrivacy2 = datePrivacy2.getTime();
		}
		else {
			esfUserCacheModel.datePrivacy2 = Long.MIN_VALUE;
		}

		Date datePrivacy3 = getDatePrivacy3();

		if (datePrivacy3 != null) {
			esfUserCacheModel.datePrivacy3 = datePrivacy3.getTime();
		}
		else {
			esfUserCacheModel.datePrivacy3 = Long.MIN_VALUE;
		}

		esfUserCacheModel.validateCF = getValidateCF();

		return esfUserCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", typearmy=");
		sb.append(getTypearmy());
		sb.append(", fiscalCode=");
		sb.append(getFiscalCode());
		sb.append(", birthcity=");
		sb.append(getBirthcity());
		sb.append(", nationality=");
		sb.append(getNationality());
		sb.append(", isSportsGroups=");
		sb.append(getIsSportsGroups());
		sb.append(", job=");
		sb.append(getJob());
		sb.append(", issfIdNumber=");
		sb.append(getIssfIdNumber());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", pin=");
		sb.append(getPin());
		sb.append(", codeUser=");
		sb.append(getCodeUser());
		sb.append(", DateOfDeath=");
		sb.append(getDateOfDeath());
		sb.append(", privacy1=");
		sb.append(getPrivacy1());
		sb.append(", privacy2=");
		sb.append(getPrivacy2());
		sb.append(", privacy3=");
		sb.append(getPrivacy3());
		sb.append(", datePrivacy1=");
		sb.append(getDatePrivacy1());
		sb.append(", datePrivacy2=");
		sb.append(getDatePrivacy2());
		sb.append(", datePrivacy3=");
		sb.append(getDatePrivacy3());
		sb.append(", validateCF=");
		sb.append(getValidateCF());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typearmy</column-name><column-value><![CDATA[");
		sb.append(getTypearmy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fiscalCode</column-name><column-value><![CDATA[");
		sb.append(getFiscalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthcity</column-name><column-value><![CDATA[");
		sb.append(getBirthcity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationality</column-name><column-value><![CDATA[");
		sb.append(getNationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSportsGroups</column-name><column-value><![CDATA[");
		sb.append(getIsSportsGroups());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>job</column-name><column-value><![CDATA[");
		sb.append(getJob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issfIdNumber</column-name><column-value><![CDATA[");
		sb.append(getIssfIdNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pin</column-name><column-value><![CDATA[");
		sb.append(getPin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeUser</column-name><column-value><![CDATA[");
		sb.append(getCodeUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DateOfDeath</column-name><column-value><![CDATA[");
		sb.append(getDateOfDeath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privacy1</column-name><column-value><![CDATA[");
		sb.append(getPrivacy1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privacy2</column-name><column-value><![CDATA[");
		sb.append(getPrivacy2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privacy3</column-name><column-value><![CDATA[");
		sb.append(getPrivacy3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datePrivacy1</column-name><column-value><![CDATA[");
		sb.append(getDatePrivacy1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datePrivacy2</column-name><column-value><![CDATA[");
		sb.append(getDatePrivacy2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datePrivacy3</column-name><column-value><![CDATA[");
		sb.append(getDatePrivacy3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validateCF</column-name><column-value><![CDATA[");
		sb.append(getValidateCF());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFUser.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFUser.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _originalEsfUserId;
	private boolean _setOriginalEsfUserId;
	private String _code;
	private String _originalCode;
	private long _typearmy;
	private String _fiscalCode;
	private String _originalFiscalCode;
	private String _birthcity;
	private String _nationality;
	private boolean _isSportsGroups;
	private String _job;
	private String _issfIdNumber;
	private long _categoryId;
	private long _pin;
	private long _codeUser;
	private long _originalCodeUser;
	private boolean _setOriginalCodeUser;
	private Date _DateOfDeath;
	private boolean _privacy1;
	private boolean _privacy2;
	private boolean _privacy3;
	private Date _datePrivacy1;
	private Date _datePrivacy2;
	private Date _datePrivacy3;
	private boolean _validateCF;
	private long _columnBitmask;
	private ESFUser _escapedModel;
}