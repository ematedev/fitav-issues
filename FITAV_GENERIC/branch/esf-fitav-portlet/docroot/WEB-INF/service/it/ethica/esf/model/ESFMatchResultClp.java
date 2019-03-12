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

package it.ethica.esf.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFMatchResultClp extends BaseModelImpl<ESFMatchResult>
	implements ESFMatchResult {
	public ESFMatchResultClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFMatchResult.class;
	}

	@Override
	public String getModelClassName() {
		return ESFMatchResult.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfMatchResultId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfMatchResultId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfMatchResultId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfMatchResultId", getEsfMatchResultId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfPartecipantId", getEsfPartecipantId());
		attributes.put("cardCode", getCardCode());
		attributes.put("generalClassPosition", getGeneralClassPosition());
		attributes.put("categoryClassPosition", getCategoryClassPosition());
		attributes.put("categoryName", getCategoryName());
		attributes.put("qualification", getQualification());
		attributes.put("first", getFirst());
		attributes.put("second", getSecond());
		attributes.put("third", getThird());
		attributes.put("fourth", getFourth());
		attributes.put("fifth", getFifth());
		attributes.put("total", getTotal());
		attributes.put("firstPlayOff", getFirstPlayOff());
		attributes.put("secondPlayOff", getSecondPlayOff());
		attributes.put("thirdPlayOff", getThirdPlayOff());
		attributes.put("totalAfterPlayOff", getTotalAfterPlayOff());
		attributes.put("nextFirstPlayOff", getNextFirstPlayOff());
		attributes.put("nextSecondPlayOff", getNextSecondPlayOff());
		attributes.put("nextTotalPlayOff", getNextTotalPlayOff());
		attributes.put("fiscalCode", getFiscalCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfMatchResultId = (Long)attributes.get("esfMatchResultId");

		if (esfMatchResultId != null) {
			setEsfMatchResultId(esfMatchResultId);
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

		Long esfPartecipantId = (Long)attributes.get("esfPartecipantId");

		if (esfPartecipantId != null) {
			setEsfPartecipantId(esfPartecipantId);
		}

		String cardCode = (String)attributes.get("cardCode");

		if (cardCode != null) {
			setCardCode(cardCode);
		}

		Integer generalClassPosition = (Integer)attributes.get(
				"generalClassPosition");

		if (generalClassPosition != null) {
			setGeneralClassPosition(generalClassPosition);
		}

		Integer categoryClassPosition = (Integer)attributes.get(
				"categoryClassPosition");

		if (categoryClassPosition != null) {
			setCategoryClassPosition(categoryClassPosition);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		Integer first = (Integer)attributes.get("first");

		if (first != null) {
			setFirst(first);
		}

		Integer second = (Integer)attributes.get("second");

		if (second != null) {
			setSecond(second);
		}

		Integer third = (Integer)attributes.get("third");

		if (third != null) {
			setThird(third);
		}

		Integer fourth = (Integer)attributes.get("fourth");

		if (fourth != null) {
			setFourth(fourth);
		}

		Integer fifth = (Integer)attributes.get("fifth");

		if (fifth != null) {
			setFifth(fifth);
		}

		Integer total = (Integer)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Integer firstPlayOff = (Integer)attributes.get("firstPlayOff");

		if (firstPlayOff != null) {
			setFirstPlayOff(firstPlayOff);
		}

		Integer secondPlayOff = (Integer)attributes.get("secondPlayOff");

		if (secondPlayOff != null) {
			setSecondPlayOff(secondPlayOff);
		}

		Integer thirdPlayOff = (Integer)attributes.get("thirdPlayOff");

		if (thirdPlayOff != null) {
			setThirdPlayOff(thirdPlayOff);
		}

		Integer totalAfterPlayOff = (Integer)attributes.get("totalAfterPlayOff");

		if (totalAfterPlayOff != null) {
			setTotalAfterPlayOff(totalAfterPlayOff);
		}

		Integer nextFirstPlayOff = (Integer)attributes.get("nextFirstPlayOff");

		if (nextFirstPlayOff != null) {
			setNextFirstPlayOff(nextFirstPlayOff);
		}

		Integer nextSecondPlayOff = (Integer)attributes.get("nextSecondPlayOff");

		if (nextSecondPlayOff != null) {
			setNextSecondPlayOff(nextSecondPlayOff);
		}

		Integer nextTotalPlayOff = (Integer)attributes.get("nextTotalPlayOff");

		if (nextTotalPlayOff != null) {
			setNextTotalPlayOff(nextTotalPlayOff);
		}

		String fiscalCode = (String)attributes.get("fiscalCode");

		if (fiscalCode != null) {
			setFiscalCode(fiscalCode);
		}
	}

	@Override
	public long getEsfMatchResultId() {
		return _esfMatchResultId;
	}

	@Override
	public void setEsfMatchResultId(long esfMatchResultId) {
		_esfMatchResultId = esfMatchResultId;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchResultId",
						long.class);

				method.invoke(_esfMatchResultRemoteModel, esfMatchResultId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfMatchResultRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfMatchResultRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfMatchResultRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfMatchResultRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfMatchResultRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfMatchResultRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfMatchResultRemoteModel, esfMatchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfPartecipantId() {
		return _esfPartecipantId;
	}

	@Override
	public void setEsfPartecipantId(long esfPartecipantId) {
		_esfPartecipantId = esfPartecipantId;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPartecipantId",
						long.class);

				method.invoke(_esfMatchResultRemoteModel, esfPartecipantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCardCode() {
		return _cardCode;
	}

	@Override
	public void setCardCode(String cardCode) {
		_cardCode = cardCode;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCardCode", String.class);

				method.invoke(_esfMatchResultRemoteModel, cardCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGeneralClassPosition() {
		return _generalClassPosition;
	}

	@Override
	public void setGeneralClassPosition(int generalClassPosition) {
		_generalClassPosition = generalClassPosition;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneralClassPosition",
						int.class);

				method.invoke(_esfMatchResultRemoteModel, generalClassPosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCategoryClassPosition() {
		return _categoryClassPosition;
	}

	@Override
	public void setCategoryClassPosition(int categoryClassPosition) {
		_categoryClassPosition = categoryClassPosition;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryClassPosition",
						int.class);

				method.invoke(_esfMatchResultRemoteModel, categoryClassPosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoryName() {
		return _categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryName", String.class);

				method.invoke(_esfMatchResultRemoteModel, categoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQualification() {
		return _qualification;
	}

	@Override
	public void setQualification(String qualification) {
		_qualification = qualification;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setQualification", String.class);

				method.invoke(_esfMatchResultRemoteModel, qualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFirst() {
		return _first;
	}

	@Override
	public void setFirst(int first) {
		_first = first;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFirst", int.class);

				method.invoke(_esfMatchResultRemoteModel, first);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSecond() {
		return _second;
	}

	@Override
	public void setSecond(int second) {
		_second = second;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSecond", int.class);

				method.invoke(_esfMatchResultRemoteModel, second);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getThird() {
		return _third;
	}

	@Override
	public void setThird(int third) {
		_third = third;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setThird", int.class);

				method.invoke(_esfMatchResultRemoteModel, third);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFourth() {
		return _fourth;
	}

	@Override
	public void setFourth(int fourth) {
		_fourth = fourth;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFourth", int.class);

				method.invoke(_esfMatchResultRemoteModel, fourth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFifth() {
		return _fifth;
	}

	@Override
	public void setFifth(int fifth) {
		_fifth = fifth;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFifth", int.class);

				method.invoke(_esfMatchResultRemoteModel, fifth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotal() {
		return _total;
	}

	@Override
	public void setTotal(int total) {
		_total = total;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setTotal", int.class);

				method.invoke(_esfMatchResultRemoteModel, total);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFirstPlayOff() {
		return _firstPlayOff;
	}

	@Override
	public void setFirstPlayOff(int firstPlayOff) {
		_firstPlayOff = firstPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstPlayOff", int.class);

				method.invoke(_esfMatchResultRemoteModel, firstPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSecondPlayOff() {
		return _secondPlayOff;
	}

	@Override
	public void setSecondPlayOff(int secondPlayOff) {
		_secondPlayOff = secondPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondPlayOff", int.class);

				method.invoke(_esfMatchResultRemoteModel, secondPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getThirdPlayOff() {
		return _thirdPlayOff;
	}

	@Override
	public void setThirdPlayOff(int thirdPlayOff) {
		_thirdPlayOff = thirdPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setThirdPlayOff", int.class);

				method.invoke(_esfMatchResultRemoteModel, thirdPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotalAfterPlayOff() {
		return _totalAfterPlayOff;
	}

	@Override
	public void setTotalAfterPlayOff(int totalAfterPlayOff) {
		_totalAfterPlayOff = totalAfterPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalAfterPlayOff",
						int.class);

				method.invoke(_esfMatchResultRemoteModel, totalAfterPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNextFirstPlayOff() {
		return _nextFirstPlayOff;
	}

	@Override
	public void setNextFirstPlayOff(int nextFirstPlayOff) {
		_nextFirstPlayOff = nextFirstPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNextFirstPlayOff", int.class);

				method.invoke(_esfMatchResultRemoteModel, nextFirstPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNextSecondPlayOff() {
		return _nextSecondPlayOff;
	}

	@Override
	public void setNextSecondPlayOff(int nextSecondPlayOff) {
		_nextSecondPlayOff = nextSecondPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNextSecondPlayOff",
						int.class);

				method.invoke(_esfMatchResultRemoteModel, nextSecondPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNextTotalPlayOff() {
		return _nextTotalPlayOff;
	}

	@Override
	public void setNextTotalPlayOff(int nextTotalPlayOff) {
		_nextTotalPlayOff = nextTotalPlayOff;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNextTotalPlayOff", int.class);

				method.invoke(_esfMatchResultRemoteModel, nextTotalPlayOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFiscalCode() {
		return _fiscalCode;
	}

	@Override
	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;

		if (_esfMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFiscalCode", String.class);

				method.invoke(_esfMatchResultRemoteModel, fiscalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFMatchResultRemoteModel() {
		return _esfMatchResultRemoteModel;
	}

	public void setESFMatchResultRemoteModel(
		BaseModel<?> esfMatchResultRemoteModel) {
		_esfMatchResultRemoteModel = esfMatchResultRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _esfMatchResultRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_esfMatchResultRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFMatchResultLocalServiceUtil.addESFMatchResult(this);
		}
		else {
			ESFMatchResultLocalServiceUtil.updateESFMatchResult(this);
		}
	}

	@Override
	public ESFMatchResult toEscapedModel() {
		return (ESFMatchResult)ProxyUtil.newProxyInstance(ESFMatchResult.class.getClassLoader(),
			new Class[] { ESFMatchResult.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFMatchResultClp clone = new ESFMatchResultClp();

		clone.setEsfMatchResultId(getEsfMatchResultId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfPartecipantId(getEsfPartecipantId());
		clone.setCardCode(getCardCode());
		clone.setGeneralClassPosition(getGeneralClassPosition());
		clone.setCategoryClassPosition(getCategoryClassPosition());
		clone.setCategoryName(getCategoryName());
		clone.setQualification(getQualification());
		clone.setFirst(getFirst());
		clone.setSecond(getSecond());
		clone.setThird(getThird());
		clone.setFourth(getFourth());
		clone.setFifth(getFifth());
		clone.setTotal(getTotal());
		clone.setFirstPlayOff(getFirstPlayOff());
		clone.setSecondPlayOff(getSecondPlayOff());
		clone.setThirdPlayOff(getThirdPlayOff());
		clone.setTotalAfterPlayOff(getTotalAfterPlayOff());
		clone.setNextFirstPlayOff(getNextFirstPlayOff());
		clone.setNextSecondPlayOff(getNextSecondPlayOff());
		clone.setNextTotalPlayOff(getNextTotalPlayOff());
		clone.setFiscalCode(getFiscalCode());

		return clone;
	}

	@Override
	public int compareTo(ESFMatchResult esfMatchResult) {
		long primaryKey = esfMatchResult.getPrimaryKey();

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

		if (!(obj instanceof ESFMatchResultClp)) {
			return false;
		}

		ESFMatchResultClp esfMatchResult = (ESFMatchResultClp)obj;

		long primaryKey = esfMatchResult.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{esfMatchResultId=");
		sb.append(getEsfMatchResultId());
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
		sb.append(", esfPartecipantId=");
		sb.append(getEsfPartecipantId());
		sb.append(", cardCode=");
		sb.append(getCardCode());
		sb.append(", generalClassPosition=");
		sb.append(getGeneralClassPosition());
		sb.append(", categoryClassPosition=");
		sb.append(getCategoryClassPosition());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", qualification=");
		sb.append(getQualification());
		sb.append(", first=");
		sb.append(getFirst());
		sb.append(", second=");
		sb.append(getSecond());
		sb.append(", third=");
		sb.append(getThird());
		sb.append(", fourth=");
		sb.append(getFourth());
		sb.append(", fifth=");
		sb.append(getFifth());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append(", firstPlayOff=");
		sb.append(getFirstPlayOff());
		sb.append(", secondPlayOff=");
		sb.append(getSecondPlayOff());
		sb.append(", thirdPlayOff=");
		sb.append(getThirdPlayOff());
		sb.append(", totalAfterPlayOff=");
		sb.append(getTotalAfterPlayOff());
		sb.append(", nextFirstPlayOff=");
		sb.append(getNextFirstPlayOff());
		sb.append(", nextSecondPlayOff=");
		sb.append(getNextSecondPlayOff());
		sb.append(", nextTotalPlayOff=");
		sb.append(getNextTotalPlayOff());
		sb.append(", fiscalCode=");
		sb.append(getFiscalCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFMatchResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfMatchResultId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchResultId());
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
			"<column><column-name>esfPartecipantId</column-name><column-value><![CDATA[");
		sb.append(getEsfPartecipantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardCode</column-name><column-value><![CDATA[");
		sb.append(getCardCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generalClassPosition</column-name><column-value><![CDATA[");
		sb.append(getGeneralClassPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryClassPosition</column-name><column-value><![CDATA[");
		sb.append(getCategoryClassPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualification</column-name><column-value><![CDATA[");
		sb.append(getQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>first</column-name><column-value><![CDATA[");
		sb.append(getFirst());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>second</column-name><column-value><![CDATA[");
		sb.append(getSecond());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>third</column-name><column-value><![CDATA[");
		sb.append(getThird());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fourth</column-name><column-value><![CDATA[");
		sb.append(getFourth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fifth</column-name><column-value><![CDATA[");
		sb.append(getFifth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstPlayOff</column-name><column-value><![CDATA[");
		sb.append(getFirstPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondPlayOff</column-name><column-value><![CDATA[");
		sb.append(getSecondPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thirdPlayOff</column-name><column-value><![CDATA[");
		sb.append(getThirdPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalAfterPlayOff</column-name><column-value><![CDATA[");
		sb.append(getTotalAfterPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextFirstPlayOff</column-name><column-value><![CDATA[");
		sb.append(getNextFirstPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextSecondPlayOff</column-name><column-value><![CDATA[");
		sb.append(getNextSecondPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextTotalPlayOff</column-name><column-value><![CDATA[");
		sb.append(getNextTotalPlayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fiscalCode</column-name><column-value><![CDATA[");
		sb.append(getFiscalCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfMatchResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfMatchId;
	private long _esfPartecipantId;
	private String _cardCode;
	private int _generalClassPosition;
	private int _categoryClassPosition;
	private String _categoryName;
	private String _qualification;
	private int _first;
	private int _second;
	private int _third;
	private int _fourth;
	private int _fifth;
	private int _total;
	private int _firstPlayOff;
	private int _secondPlayOff;
	private int _thirdPlayOff;
	private int _totalAfterPlayOff;
	private int _nextFirstPlayOff;
	private int _nextSecondPlayOff;
	private int _nextTotalPlayOff;
	private String _fiscalCode;
	private BaseModel<?> _esfMatchResultRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}