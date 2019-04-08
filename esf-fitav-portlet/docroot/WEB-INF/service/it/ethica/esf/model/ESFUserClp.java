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

package it.ethica.esf.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFUserClp extends BaseModelImpl<ESFUser> implements ESFUser {
	public ESFUserClp() {
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfUserRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfUserRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfUserRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypearmy() {
		return _typearmy;
	}

	@Override
	public void setTypearmy(long typearmy) {
		_typearmy = typearmy;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setTypearmy", long.class);

				method.invoke(_esfUserRemoteModel, typearmy);
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

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFiscalCode", String.class);

				method.invoke(_esfUserRemoteModel, fiscalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBirthcity() {
		return _birthcity;
	}

	@Override
	public void setBirthcity(String birthcity) {
		_birthcity = birthcity;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthcity", String.class);

				method.invoke(_esfUserRemoteModel, birthcity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNationality() {
		return _nationality;
	}

	@Override
	public void setNationality(String nationality) {
		_nationality = nationality;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setNationality", String.class);

				method.invoke(_esfUserRemoteModel, nationality);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

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

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setIsSportsGroups",
						boolean.class);

				method.invoke(_esfUserRemoteModel, isSportsGroups);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJob() {
		return _job;
	}

	@Override
	public void setJob(String job) {
		_job = job;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setJob", String.class);

				method.invoke(_esfUserRemoteModel, job);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIssfIdNumber() {
		return _issfIdNumber;
	}

	@Override
	public void setIssfIdNumber(String issfIdNumber) {
		_issfIdNumber = issfIdNumber;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setIssfIdNumber", String.class);

				method.invoke(_esfUserRemoteModel, issfIdNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_esfUserRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPin() {
		return _pin;
	}

	@Override
	public void setPin(long pin) {
		_pin = pin;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPin", long.class);

				method.invoke(_esfUserRemoteModel, pin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCodeUser() {
		return _codeUser;
	}

	@Override
	public void setCodeUser(long codeUser) {
		_codeUser = codeUser;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeUser", long.class);

				method.invoke(_esfUserRemoteModel, codeUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfDeath() {
		return _DateOfDeath;
	}

	@Override
	public void setDateOfDeath(Date DateOfDeath) {
		_DateOfDeath = DateOfDeath;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfDeath", Date.class);

				method.invoke(_esfUserRemoteModel, DateOfDeath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

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

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivacy1", boolean.class);

				method.invoke(_esfUserRemoteModel, privacy1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

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

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivacy2", boolean.class);

				method.invoke(_esfUserRemoteModel, privacy2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

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

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivacy3", boolean.class);

				method.invoke(_esfUserRemoteModel, privacy3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDatePrivacy1() {
		return _datePrivacy1;
	}

	@Override
	public void setDatePrivacy1(Date datePrivacy1) {
		_datePrivacy1 = datePrivacy1;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDatePrivacy1", Date.class);

				method.invoke(_esfUserRemoteModel, datePrivacy1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDatePrivacy2() {
		return _datePrivacy2;
	}

	@Override
	public void setDatePrivacy2(Date datePrivacy2) {
		_datePrivacy2 = datePrivacy2;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDatePrivacy2", Date.class);

				method.invoke(_esfUserRemoteModel, datePrivacy2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDatePrivacy3() {
		return _datePrivacy3;
	}

	@Override
	public void setDatePrivacy3(Date datePrivacy3) {
		_datePrivacy3 = datePrivacy3;

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDatePrivacy3", Date.class);

				method.invoke(_esfUserRemoteModel, datePrivacy3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

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

		if (_esfUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setValidateCF", boolean.class);

				method.invoke(_esfUserRemoteModel, validateCF);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getFirstName() {
		try {
			String methodName = "getFirstName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getLastName() {
		try {
			String methodName = "getLastName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getJobTitle() {
		try {
			String methodName = "getJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean getMale() {
		try {
			String methodName = "getMale";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getUserEmail() {
		try {
			String methodName = "getUserEmail";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getCompanyId() {
		try {
			String methodName = "getCompanyId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Date getBirthday() {
		try {
			String methodName = "getBirthday";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Date returnObj = (java.util.Date)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getScreenName() {
		try {
			String methodName = "getScreenName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getGroupId() {
		try {
			String methodName = "getGroupId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.model.User getOriginalUser() {
		try {
			String methodName = "getOriginalUser";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.model.User returnObj = (com.liferay.portal.model.User)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getESFUserRemoteModel() {
		return _esfUserRemoteModel;
	}

	public void setESFUserRemoteModel(BaseModel<?> esfUserRemoteModel) {
		_esfUserRemoteModel = esfUserRemoteModel;
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

		Class<?> remoteModelClass = _esfUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFUserLocalServiceUtil.addESFUser(this);
		}
		else {
			ESFUserLocalServiceUtil.updateESFUser(this);
		}
	}

	@Override
	public ESFUser toEscapedModel() {
		return (ESFUser)ProxyUtil.newProxyInstance(ESFUser.class.getClassLoader(),
			new Class[] { ESFUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFUserClp clone = new ESFUserClp();

		clone.setUuid(getUuid());
		clone.setEsfUserId(getEsfUserId());
		clone.setCode(getCode());
		clone.setTypearmy(getTypearmy());
		clone.setFiscalCode(getFiscalCode());
		clone.setBirthcity(getBirthcity());
		clone.setNationality(getNationality());
		clone.setIsSportsGroups(getIsSportsGroups());
		clone.setJob(getJob());
		clone.setIssfIdNumber(getIssfIdNumber());
		clone.setCategoryId(getCategoryId());
		clone.setPin(getPin());
		clone.setCodeUser(getCodeUser());
		clone.setDateOfDeath(getDateOfDeath());
		clone.setPrivacy1(getPrivacy1());
		clone.setPrivacy2(getPrivacy2());
		clone.setPrivacy3(getPrivacy3());
		clone.setDatePrivacy1(getDatePrivacy1());
		clone.setDatePrivacy2(getDatePrivacy2());
		clone.setDatePrivacy3(getDatePrivacy3());
		clone.setValidateCF(getValidateCF());

		return clone;
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

		if (!(obj instanceof ESFUserClp)) {
			return false;
		}

		ESFUserClp esfUser = (ESFUserClp)obj;

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

	private String _uuid;
	private long _esfUserId;
	private String _esfUserUuid;
	private String _code;
	private long _typearmy;
	private String _fiscalCode;
	private String _birthcity;
	private String _nationality;
	private boolean _isSportsGroups;
	private String _job;
	private String _issfIdNumber;
	private long _categoryId;
	private long _pin;
	private long _codeUser;
	private Date _DateOfDeath;
	private boolean _privacy1;
	private boolean _privacy2;
	private boolean _privacy3;
	private Date _datePrivacy1;
	private Date _datePrivacy2;
	private Date _datePrivacy3;
	private boolean _validateCF;
	private BaseModel<?> _esfUserRemoteModel;
}