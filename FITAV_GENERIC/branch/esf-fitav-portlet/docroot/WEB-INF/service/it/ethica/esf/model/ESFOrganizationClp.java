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

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFOrganizationClp extends BaseModelImpl<ESFOrganization>
	implements ESFOrganization {
	public ESFOrganizationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganization.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfOrganizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfOrganizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfOrganizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("code", getCode());
		attributes.put("vat", getVat());
		attributes.put("fiscalCode", getFiscalCode());
		attributes.put("ibanCode", getIbanCode());
		attributes.put("isMultiSport", getIsMultiSport());
		attributes.put("legalForm", getLegalForm());
		attributes.put("category", getCategory());
		attributes.put("establishmentDate", getEstablishmentDate());
		attributes.put("closureDate", getClosureDate());
		attributes.put("type", getType());
		attributes.put("insertDate", getInsertDate());
		attributes.put("coniDate", getConiDate());
		attributes.put("coniCode", getConiCode());
		attributes.put("description", getDescription());
		attributes.put("isYouthActive", getIsYouthActive());
		attributes.put("firstAffiliationDate", getFirstAffiliationDate());
		attributes.put("variations", getVariations());
		attributes.put("regionCode", getRegionCode());
		attributes.put("idFatherAssociation", getIdFatherAssociation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String vat = (String)attributes.get("vat");

		if (vat != null) {
			setVat(vat);
		}

		String fiscalCode = (String)attributes.get("fiscalCode");

		if (fiscalCode != null) {
			setFiscalCode(fiscalCode);
		}

		String ibanCode = (String)attributes.get("ibanCode");

		if (ibanCode != null) {
			setIbanCode(ibanCode);
		}

		Boolean isMultiSport = (Boolean)attributes.get("isMultiSport");

		if (isMultiSport != null) {
			setIsMultiSport(isMultiSport);
		}

		String legalForm = (String)attributes.get("legalForm");

		if (legalForm != null) {
			setLegalForm(legalForm);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Date establishmentDate = (Date)attributes.get("establishmentDate");

		if (establishmentDate != null) {
			setEstablishmentDate(establishmentDate);
		}

		Date closureDate = (Date)attributes.get("closureDate");

		if (closureDate != null) {
			setClosureDate(closureDate);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}

		Date coniDate = (Date)attributes.get("coniDate");

		if (coniDate != null) {
			setConiDate(coniDate);
		}

		String coniCode = (String)attributes.get("coniCode");

		if (coniCode != null) {
			setConiCode(coniCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isYouthActive = (Boolean)attributes.get("isYouthActive");

		if (isYouthActive != null) {
			setIsYouthActive(isYouthActive);
		}

		Date firstAffiliationDate = (Date)attributes.get("firstAffiliationDate");

		if (firstAffiliationDate != null) {
			setFirstAffiliationDate(firstAffiliationDate);
		}

		Long variations = (Long)attributes.get("variations");

		if (variations != null) {
			setVariations(variations);
		}

		Long regionCode = (Long)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Long idFatherAssociation = (Long)attributes.get("idFatherAssociation");

		if (idFatherAssociation != null) {
			setIdFatherAssociation(idFatherAssociation);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfOrganizationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfOrganizationRemoteModel, esfOrganizationId);
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

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfOrganizationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfOrganizationRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVat() {
		return _vat;
	}

	@Override
	public void setVat(String vat) {
		_vat = vat;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setVat", String.class);

				method.invoke(_esfOrganizationRemoteModel, vat);
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

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFiscalCode", String.class);

				method.invoke(_esfOrganizationRemoteModel, fiscalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIbanCode() {
		return _ibanCode;
	}

	@Override
	public void setIbanCode(String ibanCode) {
		_ibanCode = ibanCode;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIbanCode", String.class);

				method.invoke(_esfOrganizationRemoteModel, ibanCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsMultiSport() {
		return _isMultiSport;
	}

	@Override
	public boolean isIsMultiSport() {
		return _isMultiSport;
	}

	@Override
	public void setIsMultiSport(boolean isMultiSport) {
		_isMultiSport = isMultiSport;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMultiSport", boolean.class);

				method.invoke(_esfOrganizationRemoteModel, isMultiSport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLegalForm() {
		return _legalForm;
	}

	@Override
	public void setLegalForm(String legalForm) {
		_legalForm = legalForm;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setLegalForm", String.class);

				method.invoke(_esfOrganizationRemoteModel, legalForm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_esfOrganizationRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEstablishmentDate() {
		return _establishmentDate;
	}

	@Override
	public void setEstablishmentDate(Date establishmentDate) {
		_establishmentDate = establishmentDate;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setEstablishmentDate",
						Date.class);

				method.invoke(_esfOrganizationRemoteModel, establishmentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getClosureDate() {
		return _closureDate;
	}

	@Override
	public void setClosureDate(Date closureDate) {
		_closureDate = closureDate;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setClosureDate", Date.class);

				method.invoke(_esfOrganizationRemoteModel, closureDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_esfOrganizationRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_esfOrganizationRemoteModel, insertDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getConiDate() {
		return _coniDate;
	}

	@Override
	public void setConiDate(Date coniDate) {
		_coniDate = coniDate;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setConiDate", Date.class);

				method.invoke(_esfOrganizationRemoteModel, coniDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConiCode() {
		return _coniCode;
	}

	@Override
	public void setConiCode(String coniCode) {
		_coniCode = coniCode;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setConiCode", String.class);

				method.invoke(_esfOrganizationRemoteModel, coniCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfOrganizationRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsYouthActive() {
		return _isYouthActive;
	}

	@Override
	public boolean isIsYouthActive() {
		return _isYouthActive;
	}

	@Override
	public void setIsYouthActive(boolean isYouthActive) {
		_isYouthActive = isYouthActive;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsYouthActive",
						boolean.class);

				method.invoke(_esfOrganizationRemoteModel, isYouthActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFirstAffiliationDate() {
		return _firstAffiliationDate;
	}

	@Override
	public void setFirstAffiliationDate(Date firstAffiliationDate) {
		_firstAffiliationDate = firstAffiliationDate;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstAffiliationDate",
						Date.class);

				method.invoke(_esfOrganizationRemoteModel, firstAffiliationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVariations() {
		return _variations;
	}

	@Override
	public void setVariations(long variations) {
		_variations = variations;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setVariations", long.class);

				method.invoke(_esfOrganizationRemoteModel, variations);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(long regionCode) {
		_regionCode = regionCode;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", long.class);

				method.invoke(_esfOrganizationRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdFatherAssociation() {
		return _idFatherAssociation;
	}

	@Override
	public void setIdFatherAssociation(long idFatherAssociation) {
		_idFatherAssociation = idFatherAssociation;

		if (_esfOrganizationRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIdFatherAssociation",
						long.class);

				method.invoke(_esfOrganizationRemoteModel, idFatherAssociation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusId() {
		try {
			String methodName = "getStatusId";

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
	public void setTreePath(java.lang.String treePath) {
		try {
			String methodName = "setTreePath";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { treePath };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean getRecursable() {
		try {
			String methodName = "getRecursable";

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
	public void setRecursable(boolean recursable) {
		try {
			String methodName = "setRecursable";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { recursable };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
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
	public void setParentOrganizationId(long parentOrganizationId) {
		try {
			String methodName = "setParentOrganizationId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { parentOrganizationId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isRoot() {
		try {
			String methodName = "isRoot";

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
	public void setModifiedDate(java.util.Date modifiedDate) {
		try {
			String methodName = "setModifiedDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Date.class };

			Object[] parameterValues = new Object[] { modifiedDate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setType_(java.lang.String type_) {
		try {
			String methodName = "setType_";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { type_ };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getType_() {
		try {
			String methodName = "getType_";

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
	public java.util.Date getModifiedDate() {
		try {
			String methodName = "getModifiedDate";

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
	public boolean isAssociation() {
		try {
			String methodName = "isAssociation";

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
	public boolean isProvince() {
		try {
			String methodName = "isProvince";

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
	public void setCreateDate(java.util.Date createDate) {
		try {
			String methodName = "setCreateDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Date.class };

			Object[] parameterValues = new Object[] { createDate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getComments() {
		try {
			String methodName = "getComments";

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
	public boolean isRegion() {
		try {
			String methodName = "isRegion";

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
	public java.util.Date getCreateDate() {
		try {
			String methodName = "getCreateDate";

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
	public long getUserId() {
		try {
			String methodName = "getUserId";

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
	public java.lang.String getTreePath() {
		try {
			String methodName = "getTreePath";

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
	public java.lang.String getName() {
		try {
			String methodName = "getName";

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
	public long getDefaultLayoutSetPrototypeId(boolean publicLayout) {
		try {
			String methodName = "getDefaultLayoutSetPrototypeId";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { publicLayout };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStatusId(int statusId) {
		try {
			String methodName = "setStatusId";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { statusId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setUserId(long userId) {
		try {
			String methodName = "setUserId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { userId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setUserName(java.lang.String userName) {
		try {
			String methodName = "setUserName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { userName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setComments(java.lang.String comments) {
		try {
			String methodName = "setComments";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { comments };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setName(java.lang.String name) {
		try {
			String methodName = "setName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { name };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getParentOrganizationId() {
		try {
			String methodName = "getParentOrganizationId";

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
	public java.lang.String getUserName() {
		try {
			String methodName = "getUserName";

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
	public void setCompanyId(long companyId) {
		try {
			String methodName = "setCompanyId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { companyId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getESFOrganizationRemoteModel() {
		return _esfOrganizationRemoteModel;
	}

	public void setESFOrganizationRemoteModel(
		BaseModel<?> esfOrganizationRemoteModel) {
		_esfOrganizationRemoteModel = esfOrganizationRemoteModel;
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

		Class<?> remoteModelClass = _esfOrganizationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfOrganizationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFOrganizationLocalServiceUtil.addESFOrganization(this);
		}
		else {
			ESFOrganizationLocalServiceUtil.updateESFOrganization(this);
		}
	}

	@Override
	public ESFOrganization toEscapedModel() {
		return (ESFOrganization)ProxyUtil.newProxyInstance(ESFOrganization.class.getClassLoader(),
			new Class[] { ESFOrganization.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFOrganizationClp clone = new ESFOrganizationClp();

		clone.setUuid(getUuid());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setGroupId(getGroupId());
		clone.setCode(getCode());
		clone.setVat(getVat());
		clone.setFiscalCode(getFiscalCode());
		clone.setIbanCode(getIbanCode());
		clone.setIsMultiSport(getIsMultiSport());
		clone.setLegalForm(getLegalForm());
		clone.setCategory(getCategory());
		clone.setEstablishmentDate(getEstablishmentDate());
		clone.setClosureDate(getClosureDate());
		clone.setType(getType());
		clone.setInsertDate(getInsertDate());
		clone.setConiDate(getConiDate());
		clone.setConiCode(getConiCode());
		clone.setDescription(getDescription());
		clone.setIsYouthActive(getIsYouthActive());
		clone.setFirstAffiliationDate(getFirstAffiliationDate());
		clone.setVariations(getVariations());
		clone.setRegionCode(getRegionCode());
		clone.setIdFatherAssociation(getIdFatherAssociation());

		return clone;
	}

	@Override
	public int compareTo(ESFOrganization esfOrganization) {
		long primaryKey = esfOrganization.getPrimaryKey();

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

		if (!(obj instanceof ESFOrganizationClp)) {
			return false;
		}

		ESFOrganizationClp esfOrganization = (ESFOrganizationClp)obj;

		long primaryKey = esfOrganization.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", vat=");
		sb.append(getVat());
		sb.append(", fiscalCode=");
		sb.append(getFiscalCode());
		sb.append(", ibanCode=");
		sb.append(getIbanCode());
		sb.append(", isMultiSport=");
		sb.append(getIsMultiSport());
		sb.append(", legalForm=");
		sb.append(getLegalForm());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", establishmentDate=");
		sb.append(getEstablishmentDate());
		sb.append(", closureDate=");
		sb.append(getClosureDate());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", insertDate=");
		sb.append(getInsertDate());
		sb.append(", coniDate=");
		sb.append(getConiDate());
		sb.append(", coniCode=");
		sb.append(getConiCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", isYouthActive=");
		sb.append(getIsYouthActive());
		sb.append(", firstAffiliationDate=");
		sb.append(getFirstAffiliationDate());
		sb.append(", variations=");
		sb.append(getVariations());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", idFatherAssociation=");
		sb.append(getIdFatherAssociation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFOrganization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vat</column-name><column-value><![CDATA[");
		sb.append(getVat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fiscalCode</column-name><column-value><![CDATA[");
		sb.append(getFiscalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ibanCode</column-name><column-value><![CDATA[");
		sb.append(getIbanCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMultiSport</column-name><column-value><![CDATA[");
		sb.append(getIsMultiSport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>legalForm</column-name><column-value><![CDATA[");
		sb.append(getLegalForm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>establishmentDate</column-name><column-value><![CDATA[");
		sb.append(getEstablishmentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closureDate</column-name><column-value><![CDATA[");
		sb.append(getClosureDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDate</column-name><column-value><![CDATA[");
		sb.append(getInsertDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coniDate</column-name><column-value><![CDATA[");
		sb.append(getConiDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coniCode</column-name><column-value><![CDATA[");
		sb.append(getConiCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isYouthActive</column-name><column-value><![CDATA[");
		sb.append(getIsYouthActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstAffiliationDate</column-name><column-value><![CDATA[");
		sb.append(getFirstAffiliationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>variations</column-name><column-value><![CDATA[");
		sb.append(getVariations());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idFatherAssociation</column-name><column-value><![CDATA[");
		sb.append(getIdFatherAssociation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfOrganizationId;
	private long _groupId;
	private String _code;
	private String _vat;
	private String _fiscalCode;
	private String _ibanCode;
	private boolean _isMultiSport;
	private String _legalForm;
	private String _category;
	private Date _establishmentDate;
	private Date _closureDate;
	private int _type;
	private Date _insertDate;
	private Date _coniDate;
	private String _coniCode;
	private String _description;
	private boolean _isYouthActive;
	private Date _firstAffiliationDate;
	private long _variations;
	private long _regionCode;
	private long _idFatherAssociation;
	private BaseModel<?> _esfOrganizationRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}