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

import it.ethica.esf.model.ESFDeparture;
import it.ethica.esf.model.ESFDepartureModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFDeparture service. Represents a row in the &quot;ESFDeparture&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFDepartureModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFDepartureImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFDepartureImpl
 * @see it.ethica.esf.model.ESFDeparture
 * @see it.ethica.esf.model.ESFDepartureModel
 * @generated
 */
public class ESFDepartureModelImpl extends BaseModelImpl<ESFDeparture>
	implements ESFDepartureModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f departure model instance should use the {@link it.ethica.esf.model.ESFDeparture} interface instead.
	 */
	public static final String TABLE_NAME = "ESFDeparture";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfDepartureId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "leaveDate", Types.TIMESTAMP },
			{ "leaveHour", Types.VARCHAR },
			{ "arriveDate", Types.TIMESTAMP },
			{ "arriveHour", Types.VARCHAR },
			{ "code_", Types.VARCHAR },
			{ "companyName", Types.VARCHAR },
			{ "departureFrom", Types.VARCHAR },
			{ "arrivalTo", Types.VARCHAR },
			{ "esfMatchId", Types.BIGINT },
			{ "esfUserId", Types.BIGINT },
			{ "isReturn", Types.BOOLEAN },
			{ "meetingPlace", Types.VARCHAR },
			{ "typeTravel", Types.VARCHAR },
			{ "stopoverId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFDeparture (esfDepartureId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,leaveDate DATE null,leaveHour VARCHAR(75) null,arriveDate DATE null,arriveHour VARCHAR(75) null,code_ VARCHAR(75) null,companyName VARCHAR(75) null,departureFrom VARCHAR(75) null,arrivalTo VARCHAR(75) null,esfMatchId LONG,esfUserId LONG,isReturn BOOLEAN,meetingPlace VARCHAR(75) null,typeTravel VARCHAR(75) null,stopoverId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFDeparture";
	public static final String ORDER_BY_JPQL = " ORDER BY esfDeparture.esfDepartureId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFDeparture.esfDepartureId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFDeparture"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFDeparture"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFDeparture"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long COMPANYNAME_COLUMN_BITMASK = 2L;
	public static long DEPARTUREFROM_COLUMN_BITMASK = 4L;
	public static long ESFMATCHID_COLUMN_BITMASK = 8L;
	public static long ESFUSERID_COLUMN_BITMASK = 16L;
	public static long LEAVEDATE_COLUMN_BITMASK = 32L;
	public static long LEAVEHOUR_COLUMN_BITMASK = 64L;
	public static long ESFDEPARTUREID_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFDeparture"));

	public ESFDepartureModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfDepartureId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDepartureId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDepartureId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDeparture.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDeparture.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDepartureId", getEsfDepartureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("leaveDate", getLeaveDate());
		attributes.put("leaveHour", getLeaveHour());
		attributes.put("arriveDate", getArriveDate());
		attributes.put("arriveHour", getArriveHour());
		attributes.put("code", getCode());
		attributes.put("companyName", getCompanyName());
		attributes.put("departureFrom", getDepartureFrom());
		attributes.put("arrivalTo", getArrivalTo());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("isReturn", getIsReturn());
		attributes.put("meetingPlace", getMeetingPlace());
		attributes.put("typeTravel", getTypeTravel());
		attributes.put("stopoverId", getStopoverId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDepartureId = (Long)attributes.get("esfDepartureId");

		if (esfDepartureId != null) {
			setEsfDepartureId(esfDepartureId);
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

		Date leaveDate = (Date)attributes.get("leaveDate");

		if (leaveDate != null) {
			setLeaveDate(leaveDate);
		}

		String leaveHour = (String)attributes.get("leaveHour");

		if (leaveHour != null) {
			setLeaveHour(leaveHour);
		}

		Date arriveDate = (Date)attributes.get("arriveDate");

		if (arriveDate != null) {
			setArriveDate(arriveDate);
		}

		String arriveHour = (String)attributes.get("arriveHour");

		if (arriveHour != null) {
			setArriveHour(arriveHour);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String departureFrom = (String)attributes.get("departureFrom");

		if (departureFrom != null) {
			setDepartureFrom(departureFrom);
		}

		String arrivalTo = (String)attributes.get("arrivalTo");

		if (arrivalTo != null) {
			setArrivalTo(arrivalTo);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Boolean isReturn = (Boolean)attributes.get("isReturn");

		if (isReturn != null) {
			setIsReturn(isReturn);
		}

		String meetingPlace = (String)attributes.get("meetingPlace");

		if (meetingPlace != null) {
			setMeetingPlace(meetingPlace);
		}

		String typeTravel = (String)attributes.get("typeTravel");

		if (typeTravel != null) {
			setTypeTravel(typeTravel);
		}

		String stopoverId = (String)attributes.get("stopoverId");

		if (stopoverId != null) {
			setStopoverId(stopoverId);
		}
	}

	@Override
	public long getEsfDepartureId() {
		return _esfDepartureId;
	}

	@Override
	public void setEsfDepartureId(long esfDepartureId) {
		_esfDepartureId = esfDepartureId;
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
	public Date getLeaveDate() {
		return _leaveDate;
	}

	@Override
	public void setLeaveDate(Date leaveDate) {
		_columnBitmask |= LEAVEDATE_COLUMN_BITMASK;

		if (_originalLeaveDate == null) {
			_originalLeaveDate = _leaveDate;
		}

		_leaveDate = leaveDate;
	}

	public Date getOriginalLeaveDate() {
		return _originalLeaveDate;
	}

	@Override
	public String getLeaveHour() {
		if (_leaveHour == null) {
			return StringPool.BLANK;
		}
		else {
			return _leaveHour;
		}
	}

	@Override
	public void setLeaveHour(String leaveHour) {
		_columnBitmask |= LEAVEHOUR_COLUMN_BITMASK;

		if (_originalLeaveHour == null) {
			_originalLeaveHour = _leaveHour;
		}

		_leaveHour = leaveHour;
	}

	public String getOriginalLeaveHour() {
		return GetterUtil.getString(_originalLeaveHour);
	}

	@Override
	public Date getArriveDate() {
		return _arriveDate;
	}

	@Override
	public void setArriveDate(Date arriveDate) {
		_arriveDate = arriveDate;
	}

	@Override
	public String getArriveHour() {
		if (_arriveHour == null) {
			return StringPool.BLANK;
		}
		else {
			return _arriveHour;
		}
	}

	@Override
	public void setArriveHour(String arriveHour) {
		_arriveHour = arriveHour;
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
	public String getCompanyName() {
		if (_companyName == null) {
			return StringPool.BLANK;
		}
		else {
			return _companyName;
		}
	}

	@Override
	public void setCompanyName(String companyName) {
		_columnBitmask |= COMPANYNAME_COLUMN_BITMASK;

		if (_originalCompanyName == null) {
			_originalCompanyName = _companyName;
		}

		_companyName = companyName;
	}

	public String getOriginalCompanyName() {
		return GetterUtil.getString(_originalCompanyName);
	}

	@Override
	public String getDepartureFrom() {
		if (_departureFrom == null) {
			return StringPool.BLANK;
		}
		else {
			return _departureFrom;
		}
	}

	@Override
	public void setDepartureFrom(String departureFrom) {
		_columnBitmask |= DEPARTUREFROM_COLUMN_BITMASK;

		if (_originalDepartureFrom == null) {
			_originalDepartureFrom = _departureFrom;
		}

		_departureFrom = departureFrom;
	}

	public String getOriginalDepartureFrom() {
		return GetterUtil.getString(_originalDepartureFrom);
	}

	@Override
	public String getArrivalTo() {
		if (_arrivalTo == null) {
			return StringPool.BLANK;
		}
		else {
			return _arrivalTo;
		}
	}

	@Override
	public void setArrivalTo(String arrivalTo) {
		_arrivalTo = arrivalTo;
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
	public boolean getIsReturn() {
		return _isReturn;
	}

	@Override
	public boolean isIsReturn() {
		return _isReturn;
	}

	@Override
	public void setIsReturn(boolean isReturn) {
		_isReturn = isReturn;
	}

	@Override
	public String getMeetingPlace() {
		if (_meetingPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _meetingPlace;
		}
	}

	@Override
	public void setMeetingPlace(String meetingPlace) {
		_meetingPlace = meetingPlace;
	}

	@Override
	public String getTypeTravel() {
		if (_typeTravel == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeTravel;
		}
	}

	@Override
	public void setTypeTravel(String typeTravel) {
		_typeTravel = typeTravel;
	}

	@Override
	public String getStopoverId() {
		if (_stopoverId == null) {
			return StringPool.BLANK;
		}
		else {
			return _stopoverId;
		}
	}

	@Override
	public void setStopoverId(String stopoverId) {
		_stopoverId = stopoverId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFDeparture.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFDeparture toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFDeparture)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFDepartureImpl esfDepartureImpl = new ESFDepartureImpl();

		esfDepartureImpl.setEsfDepartureId(getEsfDepartureId());
		esfDepartureImpl.setGroupId(getGroupId());
		esfDepartureImpl.setCompanyId(getCompanyId());
		esfDepartureImpl.setUserId(getUserId());
		esfDepartureImpl.setUserName(getUserName());
		esfDepartureImpl.setCreateDate(getCreateDate());
		esfDepartureImpl.setModifiedDate(getModifiedDate());
		esfDepartureImpl.setLeaveDate(getLeaveDate());
		esfDepartureImpl.setLeaveHour(getLeaveHour());
		esfDepartureImpl.setArriveDate(getArriveDate());
		esfDepartureImpl.setArriveHour(getArriveHour());
		esfDepartureImpl.setCode(getCode());
		esfDepartureImpl.setCompanyName(getCompanyName());
		esfDepartureImpl.setDepartureFrom(getDepartureFrom());
		esfDepartureImpl.setArrivalTo(getArrivalTo());
		esfDepartureImpl.setEsfMatchId(getEsfMatchId());
		esfDepartureImpl.setEsfUserId(getEsfUserId());
		esfDepartureImpl.setIsReturn(getIsReturn());
		esfDepartureImpl.setMeetingPlace(getMeetingPlace());
		esfDepartureImpl.setTypeTravel(getTypeTravel());
		esfDepartureImpl.setStopoverId(getStopoverId());

		esfDepartureImpl.resetOriginalValues();

		return esfDepartureImpl;
	}

	@Override
	public int compareTo(ESFDeparture esfDeparture) {
		long primaryKey = esfDeparture.getPrimaryKey();

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

		if (!(obj instanceof ESFDeparture)) {
			return false;
		}

		ESFDeparture esfDeparture = (ESFDeparture)obj;

		long primaryKey = esfDeparture.getPrimaryKey();

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
		ESFDepartureModelImpl esfDepartureModelImpl = this;

		esfDepartureModelImpl._originalLeaveDate = esfDepartureModelImpl._leaveDate;

		esfDepartureModelImpl._originalLeaveHour = esfDepartureModelImpl._leaveHour;

		esfDepartureModelImpl._originalCode = esfDepartureModelImpl._code;

		esfDepartureModelImpl._originalCompanyName = esfDepartureModelImpl._companyName;

		esfDepartureModelImpl._originalDepartureFrom = esfDepartureModelImpl._departureFrom;

		esfDepartureModelImpl._originalEsfMatchId = esfDepartureModelImpl._esfMatchId;

		esfDepartureModelImpl._setOriginalEsfMatchId = false;

		esfDepartureModelImpl._originalEsfUserId = esfDepartureModelImpl._esfUserId;

		esfDepartureModelImpl._setOriginalEsfUserId = false;

		esfDepartureModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFDeparture> toCacheModel() {
		ESFDepartureCacheModel esfDepartureCacheModel = new ESFDepartureCacheModel();

		esfDepartureCacheModel.esfDepartureId = getEsfDepartureId();

		esfDepartureCacheModel.groupId = getGroupId();

		esfDepartureCacheModel.companyId = getCompanyId();

		esfDepartureCacheModel.userId = getUserId();

		esfDepartureCacheModel.userName = getUserName();

		String userName = esfDepartureCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfDepartureCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfDepartureCacheModel.createDate = createDate.getTime();
		}
		else {
			esfDepartureCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfDepartureCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfDepartureCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date leaveDate = getLeaveDate();

		if (leaveDate != null) {
			esfDepartureCacheModel.leaveDate = leaveDate.getTime();
		}
		else {
			esfDepartureCacheModel.leaveDate = Long.MIN_VALUE;
		}

		esfDepartureCacheModel.leaveHour = getLeaveHour();

		String leaveHour = esfDepartureCacheModel.leaveHour;

		if ((leaveHour != null) && (leaveHour.length() == 0)) {
			esfDepartureCacheModel.leaveHour = null;
		}

		Date arriveDate = getArriveDate();

		if (arriveDate != null) {
			esfDepartureCacheModel.arriveDate = arriveDate.getTime();
		}
		else {
			esfDepartureCacheModel.arriveDate = Long.MIN_VALUE;
		}

		esfDepartureCacheModel.arriveHour = getArriveHour();

		String arriveHour = esfDepartureCacheModel.arriveHour;

		if ((arriveHour != null) && (arriveHour.length() == 0)) {
			esfDepartureCacheModel.arriveHour = null;
		}

		esfDepartureCacheModel.code = getCode();

		String code = esfDepartureCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfDepartureCacheModel.code = null;
		}

		esfDepartureCacheModel.companyName = getCompanyName();

		String companyName = esfDepartureCacheModel.companyName;

		if ((companyName != null) && (companyName.length() == 0)) {
			esfDepartureCacheModel.companyName = null;
		}

		esfDepartureCacheModel.departureFrom = getDepartureFrom();

		String departureFrom = esfDepartureCacheModel.departureFrom;

		if ((departureFrom != null) && (departureFrom.length() == 0)) {
			esfDepartureCacheModel.departureFrom = null;
		}

		esfDepartureCacheModel.arrivalTo = getArrivalTo();

		String arrivalTo = esfDepartureCacheModel.arrivalTo;

		if ((arrivalTo != null) && (arrivalTo.length() == 0)) {
			esfDepartureCacheModel.arrivalTo = null;
		}

		esfDepartureCacheModel.esfMatchId = getEsfMatchId();

		esfDepartureCacheModel.esfUserId = getEsfUserId();

		esfDepartureCacheModel.isReturn = getIsReturn();

		esfDepartureCacheModel.meetingPlace = getMeetingPlace();

		String meetingPlace = esfDepartureCacheModel.meetingPlace;

		if ((meetingPlace != null) && (meetingPlace.length() == 0)) {
			esfDepartureCacheModel.meetingPlace = null;
		}

		esfDepartureCacheModel.typeTravel = getTypeTravel();

		String typeTravel = esfDepartureCacheModel.typeTravel;

		if ((typeTravel != null) && (typeTravel.length() == 0)) {
			esfDepartureCacheModel.typeTravel = null;
		}

		esfDepartureCacheModel.stopoverId = getStopoverId();

		String stopoverId = esfDepartureCacheModel.stopoverId;

		if ((stopoverId != null) && (stopoverId.length() == 0)) {
			esfDepartureCacheModel.stopoverId = null;
		}

		return esfDepartureCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{esfDepartureId=");
		sb.append(getEsfDepartureId());
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
		sb.append(", leaveDate=");
		sb.append(getLeaveDate());
		sb.append(", leaveHour=");
		sb.append(getLeaveHour());
		sb.append(", arriveDate=");
		sb.append(getArriveDate());
		sb.append(", arriveHour=");
		sb.append(getArriveHour());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", departureFrom=");
		sb.append(getDepartureFrom());
		sb.append(", arrivalTo=");
		sb.append(getArrivalTo());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", isReturn=");
		sb.append(getIsReturn());
		sb.append(", meetingPlace=");
		sb.append(getMeetingPlace());
		sb.append(", typeTravel=");
		sb.append(getTypeTravel());
		sb.append(", stopoverId=");
		sb.append(getStopoverId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDeparture");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDepartureId</column-name><column-value><![CDATA[");
		sb.append(getEsfDepartureId());
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
			"<column><column-name>leaveDate</column-name><column-value><![CDATA[");
		sb.append(getLeaveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveHour</column-name><column-value><![CDATA[");
		sb.append(getLeaveHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arriveDate</column-name><column-value><![CDATA[");
		sb.append(getArriveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arriveHour</column-name><column-value><![CDATA[");
		sb.append(getArriveHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departureFrom</column-name><column-value><![CDATA[");
		sb.append(getDepartureFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arrivalTo</column-name><column-value><![CDATA[");
		sb.append(getArrivalTo());
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
			"<column><column-name>isReturn</column-name><column-value><![CDATA[");
		sb.append(getIsReturn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>meetingPlace</column-name><column-value><![CDATA[");
		sb.append(getMeetingPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeTravel</column-name><column-value><![CDATA[");
		sb.append(getTypeTravel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stopoverId</column-name><column-value><![CDATA[");
		sb.append(getStopoverId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFDeparture.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFDeparture.class
		};
	private long _esfDepartureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _leaveDate;
	private Date _originalLeaveDate;
	private String _leaveHour;
	private String _originalLeaveHour;
	private Date _arriveDate;
	private String _arriveHour;
	private String _code;
	private String _originalCode;
	private String _companyName;
	private String _originalCompanyName;
	private String _departureFrom;
	private String _originalDepartureFrom;
	private String _arrivalTo;
	private long _esfMatchId;
	private long _originalEsfMatchId;
	private boolean _setOriginalEsfMatchId;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _originalEsfUserId;
	private boolean _setOriginalEsfUserId;
	private boolean _isReturn;
	private String _meetingPlace;
	private String _typeTravel;
	private String _stopoverId;
	private long _columnBitmask;
	private ESFDeparture _escapedModel;
}