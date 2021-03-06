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

import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.model.ESFNationalMatchResultModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFNationalMatchResult service. Represents a row in the &quot;ESFNationalMatchResult&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFNationalMatchResultModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFNationalMatchResultImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFNationalMatchResultImpl
 * @see it.ethica.esf.model.ESFNationalMatchResult
 * @see it.ethica.esf.model.ESFNationalMatchResultModel
 * @generated
 */
public class ESFNationalMatchResultModelImpl extends BaseModelImpl<ESFNationalMatchResult>
	implements ESFNationalMatchResultModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f national match result model instance should use the {@link it.ethica.esf.model.ESFNationalMatchResult} interface instead.
	 */
	public static final String TABLE_NAME = "ESFNationalMatchResult";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfNationalMatchResultId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "esfMatchId", Types.BIGINT },
			{ "esfUserId", Types.BIGINT },
			{ "position", Types.INTEGER },
			{ "qualification", Types.INTEGER },
			{ "shootOff", Types.INTEGER },
			{ "clayPigeonTotal", Types.INTEGER },
			{ "finalResult", Types.INTEGER },
			{ "shootOffFinal", Types.INTEGER },
			{ "externalShooter", Types.BOOLEAN },
			{ "externalName", Types.VARCHAR },
			{ "esfSportTypeId", Types.BIGINT },
			{ "userNationality", Types.VARCHAR },
			{ "esfUserQualification", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFNationalMatchResult (esfNationalMatchResultId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,esfMatchId LONG,esfUserId LONG,position INTEGER,qualification INTEGER,shootOff INTEGER,clayPigeonTotal INTEGER,finalResult INTEGER,shootOffFinal INTEGER,externalShooter BOOLEAN,externalName VARCHAR(75) null,esfSportTypeId LONG,userNationality VARCHAR(75) null,esfUserQualification LONG)";
	public static final String TABLE_SQL_DROP = "drop table ESFNationalMatchResult";
	public static final String ORDER_BY_JPQL = " ORDER BY esfNationalMatchResult.position ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFNationalMatchResult.position ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFNationalMatchResult"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFNationalMatchResult"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFNationalMatchResult"),
			true);
	public static long ESFMATCHID_COLUMN_BITMASK = 1L;
	public static long ESFSPORTTYPEID_COLUMN_BITMASK = 2L;
	public static long ESFUSERID_COLUMN_BITMASK = 4L;
	public static long ESFUSERQUALIFICATION_COLUMN_BITMASK = 8L;
	public static long EXTERNALSHOOTER_COLUMN_BITMASK = 16L;
	public static long POSITION_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFNationalMatchResult"));

	public ESFNationalMatchResultModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfNationalMatchResultId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfNationalMatchResultId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfNationalMatchResultId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFNationalMatchResult.class;
	}

	@Override
	public String getModelClassName() {
		return ESFNationalMatchResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfNationalMatchResultId", getEsfNationalMatchResultId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("position", getPosition());
		attributes.put("qualification", getQualification());
		attributes.put("shootOff", getShootOff());
		attributes.put("clayPigeonTotal", getClayPigeonTotal());
		attributes.put("finalResult", getFinalResult());
		attributes.put("shootOffFinal", getShootOffFinal());
		attributes.put("externalShooter", getExternalShooter());
		attributes.put("externalName", getExternalName());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("userNationality", getUserNationality());
		attributes.put("esfUserQualification", getEsfUserQualification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfNationalMatchResultId = (Long)attributes.get(
				"esfNationalMatchResultId");

		if (esfNationalMatchResultId != null) {
			setEsfNationalMatchResultId(esfNationalMatchResultId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Integer qualification = (Integer)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		Integer shootOff = (Integer)attributes.get("shootOff");

		if (shootOff != null) {
			setShootOff(shootOff);
		}

		Integer clayPigeonTotal = (Integer)attributes.get("clayPigeonTotal");

		if (clayPigeonTotal != null) {
			setClayPigeonTotal(clayPigeonTotal);
		}

		Integer finalResult = (Integer)attributes.get("finalResult");

		if (finalResult != null) {
			setFinalResult(finalResult);
		}

		Integer shootOffFinal = (Integer)attributes.get("shootOffFinal");

		if (shootOffFinal != null) {
			setShootOffFinal(shootOffFinal);
		}

		Boolean externalShooter = (Boolean)attributes.get("externalShooter");

		if (externalShooter != null) {
			setExternalShooter(externalShooter);
		}

		String externalName = (String)attributes.get("externalName");

		if (externalName != null) {
			setExternalName(externalName);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		String userNationality = (String)attributes.get("userNationality");

		if (userNationality != null) {
			setUserNationality(userNationality);
		}

		Long esfUserQualification = (Long)attributes.get("esfUserQualification");

		if (esfUserQualification != null) {
			setEsfUserQualification(esfUserQualification);
		}
	}

	@Override
	public long getEsfNationalMatchResultId() {
		return _esfNationalMatchResultId;
	}

	@Override
	public void setEsfNationalMatchResultId(long esfNationalMatchResultId) {
		_esfNationalMatchResultId = esfNationalMatchResultId;
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
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_columnBitmask |= ESFMATCHID_COLUMN_BITMASK;

		if (!_setOriginalEsfMatchId) {
			_setOriginalEsfMatchId = true;

			_originalEsfMatchId = _esfMatchId;
		}

		_esfMatchId = esfMatchId;
	}

	public long getOriginalEsfMatchId() {
		return _originalEsfMatchId;
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_columnBitmask |= ESFUSERID_COLUMN_BITMASK;

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

	@Override
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		_columnBitmask = -1L;

		_position = position;
	}

	@Override
	public int getQualification() {
		return _qualification;
	}

	@Override
	public void setQualification(int qualification) {
		_qualification = qualification;
	}

	@Override
	public int getShootOff() {
		return _shootOff;
	}

	@Override
	public void setShootOff(int shootOff) {
		_shootOff = shootOff;
	}

	@Override
	public int getClayPigeonTotal() {
		return _clayPigeonTotal;
	}

	@Override
	public void setClayPigeonTotal(int clayPigeonTotal) {
		_clayPigeonTotal = clayPigeonTotal;
	}

	@Override
	public int getFinalResult() {
		return _finalResult;
	}

	@Override
	public void setFinalResult(int finalResult) {
		_finalResult = finalResult;
	}

	@Override
	public int getShootOffFinal() {
		return _shootOffFinal;
	}

	@Override
	public void setShootOffFinal(int shootOffFinal) {
		_shootOffFinal = shootOffFinal;
	}

	@Override
	public boolean getExternalShooter() {
		return _externalShooter;
	}

	@Override
	public boolean isExternalShooter() {
		return _externalShooter;
	}

	@Override
	public void setExternalShooter(boolean externalShooter) {
		_columnBitmask |= EXTERNALSHOOTER_COLUMN_BITMASK;

		if (!_setOriginalExternalShooter) {
			_setOriginalExternalShooter = true;

			_originalExternalShooter = _externalShooter;
		}

		_externalShooter = externalShooter;
	}

	public boolean getOriginalExternalShooter() {
		return _originalExternalShooter;
	}

	@Override
	public String getExternalName() {
		if (_externalName == null) {
			return StringPool.BLANK;
		}
		else {
			return _externalName;
		}
	}

	@Override
	public void setExternalName(String externalName) {
		_externalName = externalName;
	}

	@Override
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_columnBitmask |= ESFSPORTTYPEID_COLUMN_BITMASK;

		if (!_setOriginalEsfSportTypeId) {
			_setOriginalEsfSportTypeId = true;

			_originalEsfSportTypeId = _esfSportTypeId;
		}

		_esfSportTypeId = esfSportTypeId;
	}

	public long getOriginalEsfSportTypeId() {
		return _originalEsfSportTypeId;
	}

	@Override
	public String getUserNationality() {
		if (_userNationality == null) {
			return StringPool.BLANK;
		}
		else {
			return _userNationality;
		}
	}

	@Override
	public void setUserNationality(String userNationality) {
		_userNationality = userNationality;
	}

	@Override
	public long getEsfUserQualification() {
		return _esfUserQualification;
	}

	@Override
	public void setEsfUserQualification(long esfUserQualification) {
		_columnBitmask |= ESFUSERQUALIFICATION_COLUMN_BITMASK;

		if (!_setOriginalEsfUserQualification) {
			_setOriginalEsfUserQualification = true;

			_originalEsfUserQualification = _esfUserQualification;
		}

		_esfUserQualification = esfUserQualification;
	}

	public long getOriginalEsfUserQualification() {
		return _originalEsfUserQualification;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFNationalMatchResult.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFNationalMatchResult toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFNationalMatchResult)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFNationalMatchResultImpl esfNationalMatchResultImpl = new ESFNationalMatchResultImpl();

		esfNationalMatchResultImpl.setEsfNationalMatchResultId(getEsfNationalMatchResultId());
		esfNationalMatchResultImpl.setGroupId(getGroupId());
		esfNationalMatchResultImpl.setCompanyId(getCompanyId());
		esfNationalMatchResultImpl.setUserId(getUserId());
		esfNationalMatchResultImpl.setUserName(getUserName());
		esfNationalMatchResultImpl.setCreateDate(getCreateDate());
		esfNationalMatchResultImpl.setModifiedDate(getModifiedDate());
		esfNationalMatchResultImpl.setEsfMatchId(getEsfMatchId());
		esfNationalMatchResultImpl.setEsfUserId(getEsfUserId());
		esfNationalMatchResultImpl.setPosition(getPosition());
		esfNationalMatchResultImpl.setQualification(getQualification());
		esfNationalMatchResultImpl.setShootOff(getShootOff());
		esfNationalMatchResultImpl.setClayPigeonTotal(getClayPigeonTotal());
		esfNationalMatchResultImpl.setFinalResult(getFinalResult());
		esfNationalMatchResultImpl.setShootOffFinal(getShootOffFinal());
		esfNationalMatchResultImpl.setExternalShooter(getExternalShooter());
		esfNationalMatchResultImpl.setExternalName(getExternalName());
		esfNationalMatchResultImpl.setEsfSportTypeId(getEsfSportTypeId());
		esfNationalMatchResultImpl.setUserNationality(getUserNationality());
		esfNationalMatchResultImpl.setEsfUserQualification(getEsfUserQualification());

		esfNationalMatchResultImpl.resetOriginalValues();

		return esfNationalMatchResultImpl;
	}

	@Override
	public int compareTo(ESFNationalMatchResult esfNationalMatchResult) {
		int value = 0;

		if (getPosition() < esfNationalMatchResult.getPosition()) {
			value = -1;
		}
		else if (getPosition() > esfNationalMatchResult.getPosition()) {
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

		if (!(obj instanceof ESFNationalMatchResult)) {
			return false;
		}

		ESFNationalMatchResult esfNationalMatchResult = (ESFNationalMatchResult)obj;

		long primaryKey = esfNationalMatchResult.getPrimaryKey();

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
		ESFNationalMatchResultModelImpl esfNationalMatchResultModelImpl = this;

		esfNationalMatchResultModelImpl._originalEsfMatchId = esfNationalMatchResultModelImpl._esfMatchId;

		esfNationalMatchResultModelImpl._setOriginalEsfMatchId = false;

		esfNationalMatchResultModelImpl._originalEsfUserId = esfNationalMatchResultModelImpl._esfUserId;

		esfNationalMatchResultModelImpl._setOriginalEsfUserId = false;

		esfNationalMatchResultModelImpl._originalExternalShooter = esfNationalMatchResultModelImpl._externalShooter;

		esfNationalMatchResultModelImpl._setOriginalExternalShooter = false;

		esfNationalMatchResultModelImpl._originalEsfSportTypeId = esfNationalMatchResultModelImpl._esfSportTypeId;

		esfNationalMatchResultModelImpl._setOriginalEsfSportTypeId = false;

		esfNationalMatchResultModelImpl._originalEsfUserQualification = esfNationalMatchResultModelImpl._esfUserQualification;

		esfNationalMatchResultModelImpl._setOriginalEsfUserQualification = false;

		esfNationalMatchResultModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFNationalMatchResult> toCacheModel() {
		ESFNationalMatchResultCacheModel esfNationalMatchResultCacheModel = new ESFNationalMatchResultCacheModel();

		esfNationalMatchResultCacheModel.esfNationalMatchResultId = getEsfNationalMatchResultId();

		esfNationalMatchResultCacheModel.groupId = getGroupId();

		esfNationalMatchResultCacheModel.companyId = getCompanyId();

		esfNationalMatchResultCacheModel.userId = getUserId();

		esfNationalMatchResultCacheModel.userName = getUserName();

		String userName = esfNationalMatchResultCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfNationalMatchResultCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfNationalMatchResultCacheModel.createDate = createDate.getTime();
		}
		else {
			esfNationalMatchResultCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfNationalMatchResultCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfNationalMatchResultCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfNationalMatchResultCacheModel.esfMatchId = getEsfMatchId();

		esfNationalMatchResultCacheModel.esfUserId = getEsfUserId();

		esfNationalMatchResultCacheModel.position = getPosition();

		esfNationalMatchResultCacheModel.qualification = getQualification();

		esfNationalMatchResultCacheModel.shootOff = getShootOff();

		esfNationalMatchResultCacheModel.clayPigeonTotal = getClayPigeonTotal();

		esfNationalMatchResultCacheModel.finalResult = getFinalResult();

		esfNationalMatchResultCacheModel.shootOffFinal = getShootOffFinal();

		esfNationalMatchResultCacheModel.externalShooter = getExternalShooter();

		esfNationalMatchResultCacheModel.externalName = getExternalName();

		String externalName = esfNationalMatchResultCacheModel.externalName;

		if ((externalName != null) && (externalName.length() == 0)) {
			esfNationalMatchResultCacheModel.externalName = null;
		}

		esfNationalMatchResultCacheModel.esfSportTypeId = getEsfSportTypeId();

		esfNationalMatchResultCacheModel.userNationality = getUserNationality();

		String userNationality = esfNationalMatchResultCacheModel.userNationality;

		if ((userNationality != null) && (userNationality.length() == 0)) {
			esfNationalMatchResultCacheModel.userNationality = null;
		}

		esfNationalMatchResultCacheModel.esfUserQualification = getEsfUserQualification();

		return esfNationalMatchResultCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{esfNationalMatchResultId=");
		sb.append(getEsfNationalMatchResultId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", qualification=");
		sb.append(getQualification());
		sb.append(", shootOff=");
		sb.append(getShootOff());
		sb.append(", clayPigeonTotal=");
		sb.append(getClayPigeonTotal());
		sb.append(", finalResult=");
		sb.append(getFinalResult());
		sb.append(", shootOffFinal=");
		sb.append(getShootOffFinal());
		sb.append(", externalShooter=");
		sb.append(getExternalShooter());
		sb.append(", externalName=");
		sb.append(getExternalName());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", userNationality=");
		sb.append(getUserNationality());
		sb.append(", esfUserQualification=");
		sb.append(getEsfUserQualification());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFNationalMatchResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfNationalMatchResultId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalMatchResultId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualification</column-name><column-value><![CDATA[");
		sb.append(getQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOff</column-name><column-value><![CDATA[");
		sb.append(getShootOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clayPigeonTotal</column-name><column-value><![CDATA[");
		sb.append(getClayPigeonTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalResult</column-name><column-value><![CDATA[");
		sb.append(getFinalResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOffFinal</column-name><column-value><![CDATA[");
		sb.append(getShootOffFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalShooter</column-name><column-value><![CDATA[");
		sb.append(getExternalShooter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalName</column-name><column-value><![CDATA[");
		sb.append(getExternalName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userNationality</column-name><column-value><![CDATA[");
		sb.append(getUserNationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserQualification</column-name><column-value><![CDATA[");
		sb.append(getEsfUserQualification());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFNationalMatchResult.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFNationalMatchResult.class
		};
	private long _esfNationalMatchResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfMatchId;
	private long _originalEsfMatchId;
	private boolean _setOriginalEsfMatchId;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _originalEsfUserId;
	private boolean _setOriginalEsfUserId;
	private int _position;
	private int _qualification;
	private int _shootOff;
	private int _clayPigeonTotal;
	private int _finalResult;
	private int _shootOffFinal;
	private boolean _externalShooter;
	private boolean _originalExternalShooter;
	private boolean _setOriginalExternalShooter;
	private String _externalName;
	private long _esfSportTypeId;
	private long _originalEsfSportTypeId;
	private boolean _setOriginalEsfSportTypeId;
	private String _userNationality;
	private long _esfUserQualification;
	private long _originalEsfUserQualification;
	private boolean _setOriginalEsfUserQualification;
	private long _columnBitmask;
	private ESFNationalMatchResult _escapedModel;
}