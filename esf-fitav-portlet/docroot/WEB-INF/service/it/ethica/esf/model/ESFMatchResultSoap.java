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
public class ESFMatchResultSoap implements Serializable {
	public static ESFMatchResultSoap toSoapModel(ESFMatchResult model) {
		ESFMatchResultSoap soapModel = new ESFMatchResultSoap();

		soapModel.setEsfMatchResultId(model.getEsfMatchResultId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfPartecipantId(model.getEsfPartecipantId());
		soapModel.setCardCode(model.getCardCode());
		soapModel.setGeneralClassPosition(model.getGeneralClassPosition());
		soapModel.setCategoryClassPosition(model.getCategoryClassPosition());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setQualification(model.getQualification());
		soapModel.setFirst(model.getFirst());
		soapModel.setSecond(model.getSecond());
		soapModel.setThird(model.getThird());
		soapModel.setFourth(model.getFourth());
		soapModel.setFifth(model.getFifth());
		soapModel.setTotal(model.getTotal());
		soapModel.setFirstPlayOff(model.getFirstPlayOff());
		soapModel.setSecondPlayOff(model.getSecondPlayOff());
		soapModel.setThirdPlayOff(model.getThirdPlayOff());
		soapModel.setTotalAfterPlayOff(model.getTotalAfterPlayOff());
		soapModel.setNextFirstPlayOff(model.getNextFirstPlayOff());
		soapModel.setNextSecondPlayOff(model.getNextSecondPlayOff());
		soapModel.setNextTotalPlayOff(model.getNextTotalPlayOff());
		soapModel.setFiscalCode(model.getFiscalCode());

		return soapModel;
	}

	public static ESFMatchResultSoap[] toSoapModels(ESFMatchResult[] models) {
		ESFMatchResultSoap[] soapModels = new ESFMatchResultSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFMatchResultSoap[][] toSoapModels(ESFMatchResult[][] models) {
		ESFMatchResultSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFMatchResultSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFMatchResultSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFMatchResultSoap[] toSoapModels(List<ESFMatchResult> models) {
		List<ESFMatchResultSoap> soapModels = new ArrayList<ESFMatchResultSoap>(models.size());

		for (ESFMatchResult model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFMatchResultSoap[soapModels.size()]);
	}

	public ESFMatchResultSoap() {
	}

	public long getPrimaryKey() {
		return _esfMatchResultId;
	}

	public void setPrimaryKey(long pk) {
		setEsfMatchResultId(pk);
	}

	public long getEsfMatchResultId() {
		return _esfMatchResultId;
	}

	public void setEsfMatchResultId(long esfMatchResultId) {
		_esfMatchResultId = esfMatchResultId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public long getEsfPartecipantId() {
		return _esfPartecipantId;
	}

	public void setEsfPartecipantId(long esfPartecipantId) {
		_esfPartecipantId = esfPartecipantId;
	}

	public String getCardCode() {
		return _cardCode;
	}

	public void setCardCode(String cardCode) {
		_cardCode = cardCode;
	}

	public int getGeneralClassPosition() {
		return _generalClassPosition;
	}

	public void setGeneralClassPosition(int generalClassPosition) {
		_generalClassPosition = generalClassPosition;
	}

	public int getCategoryClassPosition() {
		return _categoryClassPosition;
	}

	public void setCategoryClassPosition(int categoryClassPosition) {
		_categoryClassPosition = categoryClassPosition;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public String getQualification() {
		return _qualification;
	}

	public void setQualification(String qualification) {
		_qualification = qualification;
	}

	public int getFirst() {
		return _first;
	}

	public void setFirst(int first) {
		_first = first;
	}

	public int getSecond() {
		return _second;
	}

	public void setSecond(int second) {
		_second = second;
	}

	public int getThird() {
		return _third;
	}

	public void setThird(int third) {
		_third = third;
	}

	public int getFourth() {
		return _fourth;
	}

	public void setFourth(int fourth) {
		_fourth = fourth;
	}

	public int getFifth() {
		return _fifth;
	}

	public void setFifth(int fifth) {
		_fifth = fifth;
	}

	public int getTotal() {
		return _total;
	}

	public void setTotal(int total) {
		_total = total;
	}

	public int getFirstPlayOff() {
		return _firstPlayOff;
	}

	public void setFirstPlayOff(int firstPlayOff) {
		_firstPlayOff = firstPlayOff;
	}

	public int getSecondPlayOff() {
		return _secondPlayOff;
	}

	public void setSecondPlayOff(int secondPlayOff) {
		_secondPlayOff = secondPlayOff;
	}

	public int getThirdPlayOff() {
		return _thirdPlayOff;
	}

	public void setThirdPlayOff(int thirdPlayOff) {
		_thirdPlayOff = thirdPlayOff;
	}

	public int getTotalAfterPlayOff() {
		return _totalAfterPlayOff;
	}

	public void setTotalAfterPlayOff(int totalAfterPlayOff) {
		_totalAfterPlayOff = totalAfterPlayOff;
	}

	public int getNextFirstPlayOff() {
		return _nextFirstPlayOff;
	}

	public void setNextFirstPlayOff(int nextFirstPlayOff) {
		_nextFirstPlayOff = nextFirstPlayOff;
	}

	public int getNextSecondPlayOff() {
		return _nextSecondPlayOff;
	}

	public void setNextSecondPlayOff(int nextSecondPlayOff) {
		_nextSecondPlayOff = nextSecondPlayOff;
	}

	public int getNextTotalPlayOff() {
		return _nextTotalPlayOff;
	}

	public void setNextTotalPlayOff(int nextTotalPlayOff) {
		_nextTotalPlayOff = nextTotalPlayOff;
	}

	public String getFiscalCode() {
		return _fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;
	}

	private long _esfMatchResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}