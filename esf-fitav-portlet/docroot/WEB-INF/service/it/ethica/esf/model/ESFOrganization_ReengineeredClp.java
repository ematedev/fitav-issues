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

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFOrganization_ReengineeredLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFOrganization_ReengineeredClp extends BaseModelImpl<ESFOrganization_Reengineered>
	implements ESFOrganization_Reengineered {
	public ESFOrganization_ReengineeredClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganization_Reengineered.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganization_Reengineered.class.getName();
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

		attributes.put("esfOrganizationId", getEsfOrganizationId());
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
		attributes.put("constitutiveAct", getConstitutiveAct());
		attributes.put("registeredStatus", getRegisteredStatus());
		attributes.put("planimetrySportsStand", getPlanimetrySportsStand());
		attributes.put("certificateFITAV", getCertificateFITAV());
		attributes.put("note", getNote());
		attributes.put("isSimplyOrganizzation", getIsSimplyOrganizzation());
		attributes.put("webSite", getWebSite());
		attributes.put("includeConiReport", getIncludeConiReport());
		attributes.put("organizzationCategory", getOrganizzationCategory());
		attributes.put("type_", getType_());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
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

		Boolean constitutiveAct = (Boolean)attributes.get("constitutiveAct");

		if (constitutiveAct != null) {
			setConstitutiveAct(constitutiveAct);
		}

		Boolean registeredStatus = (Boolean)attributes.get("registeredStatus");

		if (registeredStatus != null) {
			setRegisteredStatus(registeredStatus);
		}

		Boolean planimetrySportsStand = (Boolean)attributes.get(
				"planimetrySportsStand");

		if (planimetrySportsStand != null) {
			setPlanimetrySportsStand(planimetrySportsStand);
		}

		Boolean certificateFITAV = (Boolean)attributes.get("certificateFITAV");

		if (certificateFITAV != null) {
			setCertificateFITAV(certificateFITAV);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Boolean isSimplyOrganizzation = (Boolean)attributes.get(
				"isSimplyOrganizzation");

		if (isSimplyOrganizzation != null) {
			setIsSimplyOrganizzation(isSimplyOrganizzation);
		}

		String webSite = (String)attributes.get("webSite");

		if (webSite != null) {
			setWebSite(webSite);
		}

		Boolean includeConiReport = (Boolean)attributes.get("includeConiReport");

		if (includeConiReport != null) {
			setIncludeConiReport(includeConiReport);
		}

		String organizzationCategory = (String)attributes.get(
				"organizzationCategory");

		if (organizzationCategory != null) {
			setOrganizzationCategory(organizzationCategory);
		}

		Integer type_ = (Integer)attributes.get("type_");

		if (type_ != null) {
			setType_(type_);
		}
	}

	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					esfOrganizationId);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, code);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setVat", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, vat);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setFiscalCode", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					fiscalCode);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setIbanCode", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, ibanCode);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMultiSport", boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					isMultiSport);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setLegalForm", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					legalForm);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, category);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setEstablishmentDate",
						Date.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					establishmentDate);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setClosureDate", Date.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					closureDate);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, type);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					insertDate);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setConiDate", Date.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, coniDate);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setConiCode", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, coniCode);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					description);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setIsYouthActive",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					isYouthActive);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstAffiliationDate",
						Date.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					firstAffiliationDate);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setVariations", long.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					variations);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", long.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					regionCode);
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

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setIdFatherAssociation",
						long.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					idFatherAssociation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getConstitutiveAct() {
		return _constitutiveAct;
	}

	@Override
	public boolean isConstitutiveAct() {
		return _constitutiveAct;
	}

	@Override
	public void setConstitutiveAct(boolean constitutiveAct) {
		_constitutiveAct = constitutiveAct;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setConstitutiveAct",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					constitutiveAct);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRegisteredStatus() {
		return _registeredStatus;
	}

	@Override
	public boolean isRegisteredStatus() {
		return _registeredStatus;
	}

	@Override
	public void setRegisteredStatus(boolean registeredStatus) {
		_registeredStatus = registeredStatus;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setRegisteredStatus",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					registeredStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPlanimetrySportsStand() {
		return _planimetrySportsStand;
	}

	@Override
	public boolean isPlanimetrySportsStand() {
		return _planimetrySportsStand;
	}

	@Override
	public void setPlanimetrySportsStand(boolean planimetrySportsStand) {
		_planimetrySportsStand = planimetrySportsStand;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setPlanimetrySportsStand",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					planimetrySportsStand);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCertificateFITAV() {
		return _certificateFITAV;
	}

	@Override
	public boolean isCertificateFITAV() {
		return _certificateFITAV;
	}

	@Override
	public void setCertificateFITAV(boolean certificateFITAV) {
		_certificateFITAV = certificateFITAV;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateFITAV",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					certificateFITAV);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsSimplyOrganizzation() {
		return _isSimplyOrganizzation;
	}

	@Override
	public boolean isIsSimplyOrganizzation() {
		return _isSimplyOrganizzation;
	}

	@Override
	public void setIsSimplyOrganizzation(boolean isSimplyOrganizzation) {
		_isSimplyOrganizzation = isSimplyOrganizzation;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setIsSimplyOrganizzation",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					isSimplyOrganizzation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebSite() {
		return _webSite;
	}

	@Override
	public void setWebSite(String webSite) {
		_webSite = webSite;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setWebSite", String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, webSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIncludeConiReport() {
		return _includeConiReport;
	}

	@Override
	public boolean isIncludeConiReport() {
		return _includeConiReport;
	}

	@Override
	public void setIncludeConiReport(boolean includeConiReport) {
		_includeConiReport = includeConiReport;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setIncludeConiReport",
						boolean.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					includeConiReport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrganizzationCategory() {
		return _organizzationCategory;
	}

	@Override
	public void setOrganizzationCategory(String organizzationCategory) {
		_organizzationCategory = organizzationCategory;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizzationCategory",
						String.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel,
					organizzationCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType_() {
		return _type_;
	}

	@Override
	public void setType_(int type_) {
		_type_ = type_;

		if (_esfOrganization_ReengineeredRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganization_ReengineeredRemoteModel.getClass();

				Method method = clazz.getMethod("setType_", int.class);

				method.invoke(_esfOrganization_ReengineeredRemoteModel, type_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFOrganization_ReengineeredRemoteModel() {
		return _esfOrganization_ReengineeredRemoteModel;
	}

	public void setESFOrganization_ReengineeredRemoteModel(
		BaseModel<?> esfOrganization_ReengineeredRemoteModel) {
		_esfOrganization_ReengineeredRemoteModel = esfOrganization_ReengineeredRemoteModel;
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

		Class<?> remoteModelClass = _esfOrganization_ReengineeredRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfOrganization_ReengineeredRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFOrganization_ReengineeredLocalServiceUtil.addESFOrganization_Reengineered(this);
		}
		else {
			ESFOrganization_ReengineeredLocalServiceUtil.updateESFOrganization_Reengineered(this);
		}
	}

	@Override
	public ESFOrganization_Reengineered toEscapedModel() {
		return (ESFOrganization_Reengineered)ProxyUtil.newProxyInstance(ESFOrganization_Reengineered.class.getClassLoader(),
			new Class[] { ESFOrganization_Reengineered.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFOrganization_ReengineeredClp clone = new ESFOrganization_ReengineeredClp();

		clone.setEsfOrganizationId(getEsfOrganizationId());
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
		clone.setConstitutiveAct(getConstitutiveAct());
		clone.setRegisteredStatus(getRegisteredStatus());
		clone.setPlanimetrySportsStand(getPlanimetrySportsStand());
		clone.setCertificateFITAV(getCertificateFITAV());
		clone.setNote(getNote());
		clone.setIsSimplyOrganizzation(getIsSimplyOrganizzation());
		clone.setWebSite(getWebSite());
		clone.setIncludeConiReport(getIncludeConiReport());
		clone.setOrganizzationCategory(getOrganizzationCategory());
		clone.setType_(getType_());

		return clone;
	}

	@Override
	public int compareTo(
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		long primaryKey = esfOrganization_Reengineered.getPrimaryKey();

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

		if (!(obj instanceof ESFOrganization_ReengineeredClp)) {
			return false;
		}

		ESFOrganization_ReengineeredClp esfOrganization_Reengineered = (ESFOrganization_ReengineeredClp)obj;

		long primaryKey = esfOrganization_Reengineered.getPrimaryKey();

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
		StringBundler sb = new StringBundler(61);

		sb.append("{esfOrganizationId=");
		sb.append(getEsfOrganizationId());
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
		sb.append(", constitutiveAct=");
		sb.append(getConstitutiveAct());
		sb.append(", registeredStatus=");
		sb.append(getRegisteredStatus());
		sb.append(", planimetrySportsStand=");
		sb.append(getPlanimetrySportsStand());
		sb.append(", certificateFITAV=");
		sb.append(getCertificateFITAV());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", isSimplyOrganizzation=");
		sb.append(getIsSimplyOrganizzation());
		sb.append(", webSite=");
		sb.append(getWebSite());
		sb.append(", includeConiReport=");
		sb.append(getIncludeConiReport());
		sb.append(", organizzationCategory=");
		sb.append(getOrganizzationCategory());
		sb.append(", type_=");
		sb.append(getType_());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFOrganization_Reengineered");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
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
		sb.append(
			"<column><column-name>constitutiveAct</column-name><column-value><![CDATA[");
		sb.append(getConstitutiveAct());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registeredStatus</column-name><column-value><![CDATA[");
		sb.append(getRegisteredStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>planimetrySportsStand</column-name><column-value><![CDATA[");
		sb.append(getPlanimetrySportsStand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateFITAV</column-name><column-value><![CDATA[");
		sb.append(getCertificateFITAV());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSimplyOrganizzation</column-name><column-value><![CDATA[");
		sb.append(getIsSimplyOrganizzation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webSite</column-name><column-value><![CDATA[");
		sb.append(getWebSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>includeConiReport</column-name><column-value><![CDATA[");
		sb.append(getIncludeConiReport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizzationCategory</column-name><column-value><![CDATA[");
		sb.append(getOrganizzationCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type_</column-name><column-value><![CDATA[");
		sb.append(getType_());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfOrganizationId;
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
	private boolean _constitutiveAct;
	private boolean _registeredStatus;
	private boolean _planimetrySportsStand;
	private boolean _certificateFITAV;
	private String _note;
	private boolean _isSimplyOrganizzation;
	private String _webSite;
	private boolean _includeConiReport;
	private String _organizzationCategory;
	private int _type_;
	private BaseModel<?> _esfOrganization_ReengineeredRemoteModel;
}