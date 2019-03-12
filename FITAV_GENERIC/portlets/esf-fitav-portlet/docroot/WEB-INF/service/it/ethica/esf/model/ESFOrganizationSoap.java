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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFOrganizationSoap implements Serializable {
	public static ESFOrganizationSoap toSoapModel(ESFOrganization model) {
		ESFOrganizationSoap soapModel = new ESFOrganizationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCode(model.getCode());
		soapModel.setVat(model.getVat());
		soapModel.setFiscalCode(model.getFiscalCode());
		soapModel.setIbanCode(model.getIbanCode());
		soapModel.setIsMultiSport(model.getIsMultiSport());
		soapModel.setLegalForm(model.getLegalForm());
		soapModel.setCategory(model.getCategory());
		soapModel.setEstablishmentDate(model.getEstablishmentDate());
		soapModel.setClosureDate(model.getClosureDate());
		soapModel.setType(model.getType());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setConiDate(model.getConiDate());
		soapModel.setConiCode(model.getConiCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setIsYouthActive(model.getIsYouthActive());
		soapModel.setFirstAffiliationDate(model.getFirstAffiliationDate());
		soapModel.setVariations(model.getVariations());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setIdFatherAssociation(model.getIdFatherAssociation());
		soapModel.setConstitutiveAct(model.getConstitutiveAct());
		soapModel.setRegisteredStatus(model.getRegisteredStatus());
		soapModel.setPlanimetrySportsStand(model.getPlanimetrySportsStand());
		soapModel.setCertificateFITAV(model.getCertificateFITAV());
		soapModel.setNote(model.getNote());
		soapModel.setIsSimplyOrganizzation(model.getIsSimplyOrganizzation());
		soapModel.setWebSite(model.getWebSite());
		soapModel.setIncludeConiReport(model.getIncludeConiReport());
		soapModel.setOrganizzationCategory(model.getOrganizzationCategory());

		return soapModel;
	}

	public static ESFOrganizationSoap[] toSoapModels(ESFOrganization[] models) {
		ESFOrganizationSoap[] soapModels = new ESFOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFOrganizationSoap[][] toSoapModels(
		ESFOrganization[][] models) {
		ESFOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFOrganizationSoap[] toSoapModels(
		List<ESFOrganization> models) {
		List<ESFOrganizationSoap> soapModels = new ArrayList<ESFOrganizationSoap>(models.size());

		for (ESFOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFOrganizationSoap[soapModels.size()]);
	}

	public ESFOrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _esfOrganizationId;
	}

	public void setPrimaryKey(long pk) {
		setEsfOrganizationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getVat() {
		return _vat;
	}

	public void setVat(String vat) {
		_vat = vat;
	}

	public String getFiscalCode() {
		return _fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;
	}

	public String getIbanCode() {
		return _ibanCode;
	}

	public void setIbanCode(String ibanCode) {
		_ibanCode = ibanCode;
	}

	public boolean getIsMultiSport() {
		return _isMultiSport;
	}

	public boolean isIsMultiSport() {
		return _isMultiSport;
	}

	public void setIsMultiSport(boolean isMultiSport) {
		_isMultiSport = isMultiSport;
	}

	public String getLegalForm() {
		return _legalForm;
	}

	public void setLegalForm(String legalForm) {
		_legalForm = legalForm;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public Date getEstablishmentDate() {
		return _establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		_establishmentDate = establishmentDate;
	}

	public Date getClosureDate() {
		return _closureDate;
	}

	public void setClosureDate(Date closureDate) {
		_closureDate = closureDate;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public Date getInsertDate() {
		return _insertDate;
	}

	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	public Date getConiDate() {
		return _coniDate;
	}

	public void setConiDate(Date coniDate) {
		_coniDate = coniDate;
	}

	public String getConiCode() {
		return _coniCode;
	}

	public void setConiCode(String coniCode) {
		_coniCode = coniCode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getIsYouthActive() {
		return _isYouthActive;
	}

	public boolean isIsYouthActive() {
		return _isYouthActive;
	}

	public void setIsYouthActive(boolean isYouthActive) {
		_isYouthActive = isYouthActive;
	}

	public Date getFirstAffiliationDate() {
		return _firstAffiliationDate;
	}

	public void setFirstAffiliationDate(Date firstAffiliationDate) {
		_firstAffiliationDate = firstAffiliationDate;
	}

	public long getVariations() {
		return _variations;
	}

	public void setVariations(long variations) {
		_variations = variations;
	}

	public long getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(long regionCode) {
		_regionCode = regionCode;
	}

	public long getIdFatherAssociation() {
		return _idFatherAssociation;
	}

	public void setIdFatherAssociation(long idFatherAssociation) {
		_idFatherAssociation = idFatherAssociation;
	}

	public boolean getConstitutiveAct() {
		return _constitutiveAct;
	}

	public boolean isConstitutiveAct() {
		return _constitutiveAct;
	}

	public void setConstitutiveAct(boolean constitutiveAct) {
		_constitutiveAct = constitutiveAct;
	}

	public boolean getRegisteredStatus() {
		return _registeredStatus;
	}

	public boolean isRegisteredStatus() {
		return _registeredStatus;
	}

	public void setRegisteredStatus(boolean registeredStatus) {
		_registeredStatus = registeredStatus;
	}

	public boolean getPlanimetrySportsStand() {
		return _planimetrySportsStand;
	}

	public boolean isPlanimetrySportsStand() {
		return _planimetrySportsStand;
	}

	public void setPlanimetrySportsStand(boolean planimetrySportsStand) {
		_planimetrySportsStand = planimetrySportsStand;
	}

	public boolean getCertificateFITAV() {
		return _certificateFITAV;
	}

	public boolean isCertificateFITAV() {
		return _certificateFITAV;
	}

	public void setCertificateFITAV(boolean certificateFITAV) {
		_certificateFITAV = certificateFITAV;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public boolean getIsSimplyOrganizzation() {
		return _isSimplyOrganizzation;
	}

	public boolean isIsSimplyOrganizzation() {
		return _isSimplyOrganizzation;
	}

	public void setIsSimplyOrganizzation(boolean isSimplyOrganizzation) {
		_isSimplyOrganizzation = isSimplyOrganizzation;
	}

	public String getWebSite() {
		return _webSite;
	}

	public void setWebSite(String webSite) {
		_webSite = webSite;
	}

	public boolean getIncludeConiReport() {
		return _includeConiReport;
	}

	public boolean isIncludeConiReport() {
		return _includeConiReport;
	}

	public void setIncludeConiReport(boolean includeConiReport) {
		_includeConiReport = includeConiReport;
	}

	public String getOrganizzationCategory() {
		return _organizzationCategory;
	}

	public void setOrganizzationCategory(String organizzationCategory) {
		_organizzationCategory = organizzationCategory;
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
	private boolean _constitutiveAct;
	private boolean _registeredStatus;
	private boolean _planimetrySportsStand;
	private boolean _certificateFITAV;
	private String _note;
	private boolean _isSimplyOrganizzation;
	private String _webSite;
	private boolean _includeConiReport;
	private String _organizzationCategory;
}