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
public class ESFResultSoap implements Serializable {
	public static ESFResultSoap toSoapModel(ESFResult model) {
		ESFResultSoap soapModel = new ESFResultSoap();

		soapModel.setEsfResultId(model.getEsfResultId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMatchYear(model.getMatchYear());
		soapModel.setNumberMatch(model.getNumberMatch());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setName(model.getName());
		soapModel.setName2(model.getName2());
		soapModel.setEsfAssociationId(model.getEsfAssociationId());
		soapModel.setSportTypeCode(model.getSportTypeCode());
		soapModel.setStartdDate(model.getStartdDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setGroupRanking(model.getGroupRanking());
		soapModel.setDescGroupRanking(model.getDescGroupRanking());
		soapModel.setPosition(model.getPosition());
		soapModel.setCardNumber(model.getCardNumber());
		soapModel.setShooterName(model.getShooterName());
		soapModel.setNationCode(model.getNationCode());
		soapModel.setCategory(model.getCategory());
		soapModel.setQualificationCode(model.getQualificationCode());
		soapModel.setResultS1(model.getResultS1());
		soapModel.setResultS2(model.getResultS2());
		soapModel.setResultS3(model.getResultS3());
		soapModel.setResultS4(model.getResultS4());
		soapModel.setResultS5(model.getResultS5());
		soapModel.setResultS6(model.getResultS6());
		soapModel.setResultS7(model.getResultS7());
		soapModel.setResultS8(model.getResultS8());
		soapModel.setTotalS(model.getTotalS());
		soapModel.setBarrage(model.getBarrage());
		soapModel.setFinalS(model.getFinalS());
		soapModel.setFinalTotal(model.getFinalTotal());
		soapModel.setAmerican1(model.getAmerican1());
		soapModel.setAmerican2(model.getAmerican2());
		soapModel.setAmerican3(model.getAmerican3());
		soapModel.setRifle(model.getRifle());
		soapModel.setCaliber(model.getCaliber());
		soapModel.setCatridge(model.getCatridge());
		soapModel.setFinalType(model.getFinalType());
		soapModel.setSemifinalResult(model.getSemifinalResult());
		soapModel.setShootOff1s(model.getShootOff1s());
		soapModel.setShootOff2s(model.getShootOff2s());
		soapModel.setShootOff3s(model.getShootOff3s());
		soapModel.setBronzeResult(model.getBronzeResult());
		soapModel.setShootOffBronze(model.getShootOffBronze());
		soapModel.setGoldResult(model.getGoldResult());
		soapModel.setShootOffGold(model.getShootOffGold());
		soapModel.setTeamCategory(model.getTeamCategory());
		soapModel.setTeamName(model.getTeamName());
		soapModel.setNaz_int(model.getNaz_int());
		soapModel.setShowTypeCode(model.getShowTypeCode());
		soapModel.setShowType(model.getShowType());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setVariationDate(model.getVariationDate());
		soapModel.setSent(model.getSent());
		soapModel.setYouthQualification(model.getYouthQualification());
		soapModel.setEsfMatchTypeId(model.getEsfMatchTypeId());
		soapModel.setResultClassTeam(model.getResultClassTeam());
		soapModel.setSpare1(model.getSpare1());
		soapModel.setSpare2(model.getSpare2());
		soapModel.setShooterCode(model.getShooterCode());
		soapModel.setShooterQualification(model.getShooterQualification());

		return soapModel;
	}

	public static ESFResultSoap[] toSoapModels(ESFResult[] models) {
		ESFResultSoap[] soapModels = new ESFResultSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFResultSoap[][] toSoapModels(ESFResult[][] models) {
		ESFResultSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFResultSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFResultSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFResultSoap[] toSoapModels(List<ESFResult> models) {
		List<ESFResultSoap> soapModels = new ArrayList<ESFResultSoap>(models.size());

		for (ESFResult model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFResultSoap[soapModels.size()]);
	}

	public ESFResultSoap() {
	}

	public long getPrimaryKey() {
		return _esfResultId;
	}

	public void setPrimaryKey(long pk) {
		setEsfResultId(pk);
	}

	public long getEsfResultId() {
		return _esfResultId;
	}

	public void setEsfResultId(long esfResultId) {
		_esfResultId = esfResultId;
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

	public int getMatchYear() {
		return _matchYear;
	}

	public void setMatchYear(int matchYear) {
		_matchYear = matchYear;
	}

	public int getNumberMatch() {
		return _numberMatch;
	}

	public void setNumberMatch(int numberMatch) {
		_numberMatch = numberMatch;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getName2() {
		return _name2;
	}

	public void setName2(String name2) {
		_name2 = name2;
	}

	public long getEsfAssociationId() {
		return _esfAssociationId;
	}

	public void setEsfAssociationId(long esfAssociationId) {
		_esfAssociationId = esfAssociationId;
	}

	public String getSportTypeCode() {
		return _sportTypeCode;
	}

	public void setSportTypeCode(String sportTypeCode) {
		_sportTypeCode = sportTypeCode;
	}

	public Date getStartdDate() {
		return _startdDate;
	}

	public void setStartdDate(Date startdDate) {
		_startdDate = startdDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getGroupRanking() {
		return _groupRanking;
	}

	public void setGroupRanking(String groupRanking) {
		_groupRanking = groupRanking;
	}

	public String getDescGroupRanking() {
		return _descGroupRanking;
	}

	public void setDescGroupRanking(String descGroupRanking) {
		_descGroupRanking = descGroupRanking;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public String getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;
	}

	public String getShooterName() {
		return _shooterName;
	}

	public void setShooterName(String shooterName) {
		_shooterName = shooterName;
	}

	public String getNationCode() {
		return _nationCode;
	}

	public void setNationCode(String nationCode) {
		_nationCode = nationCode;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getQualificationCode() {
		return _qualificationCode;
	}

	public void setQualificationCode(String qualificationCode) {
		_qualificationCode = qualificationCode;
	}

	public int getResultS1() {
		return _resultS1;
	}

	public void setResultS1(int resultS1) {
		_resultS1 = resultS1;
	}

	public int getResultS2() {
		return _resultS2;
	}

	public void setResultS2(int resultS2) {
		_resultS2 = resultS2;
	}

	public int getResultS3() {
		return _resultS3;
	}

	public void setResultS3(int resultS3) {
		_resultS3 = resultS3;
	}

	public int getResultS4() {
		return _resultS4;
	}

	public void setResultS4(int resultS4) {
		_resultS4 = resultS4;
	}

	public int getResultS5() {
		return _resultS5;
	}

	public void setResultS5(int resultS5) {
		_resultS5 = resultS5;
	}

	public int getResultS6() {
		return _resultS6;
	}

	public void setResultS6(int resultS6) {
		_resultS6 = resultS6;
	}

	public int getResultS7() {
		return _resultS7;
	}

	public void setResultS7(int resultS7) {
		_resultS7 = resultS7;
	}

	public int getResultS8() {
		return _resultS8;
	}

	public void setResultS8(int resultS8) {
		_resultS8 = resultS8;
	}

	public int getTotalS() {
		return _totalS;
	}

	public void setTotalS(int totalS) {
		_totalS = totalS;
	}

	public int getBarrage() {
		return _barrage;
	}

	public void setBarrage(int barrage) {
		_barrage = barrage;
	}

	public int getFinalS() {
		return _finalS;
	}

	public void setFinalS(int finalS) {
		_finalS = finalS;
	}

	public int getFinalTotal() {
		return _finalTotal;
	}

	public void setFinalTotal(int finalTotal) {
		_finalTotal = finalTotal;
	}

	public int getAmerican1() {
		return _american1;
	}

	public void setAmerican1(int american1) {
		_american1 = american1;
	}

	public int getAmerican2() {
		return _american2;
	}

	public void setAmerican2(int american2) {
		_american2 = american2;
	}

	public int getAmerican3() {
		return _american3;
	}

	public void setAmerican3(int american3) {
		_american3 = american3;
	}

	public String getRifle() {
		return _rifle;
	}

	public void setRifle(String rifle) {
		_rifle = rifle;
	}

	public String getCaliber() {
		return _caliber;
	}

	public void setCaliber(String caliber) {
		_caliber = caliber;
	}

	public String getCatridge() {
		return _catridge;
	}

	public void setCatridge(String catridge) {
		_catridge = catridge;
	}

	public String getFinalType() {
		return _finalType;
	}

	public void setFinalType(String finalType) {
		_finalType = finalType;
	}

	public int getSemifinalResult() {
		return _semifinalResult;
	}

	public void setSemifinalResult(int semifinalResult) {
		_semifinalResult = semifinalResult;
	}

	public int getShootOff1s() {
		return _shootOff1s;
	}

	public void setShootOff1s(int shootOff1s) {
		_shootOff1s = shootOff1s;
	}

	public int getShootOff2s() {
		return _shootOff2s;
	}

	public void setShootOff2s(int shootOff2s) {
		_shootOff2s = shootOff2s;
	}

	public int getShootOff3s() {
		return _shootOff3s;
	}

	public void setShootOff3s(int shootOff3s) {
		_shootOff3s = shootOff3s;
	}

	public int getBronzeResult() {
		return _bronzeResult;
	}

	public void setBronzeResult(int bronzeResult) {
		_bronzeResult = bronzeResult;
	}

	public int getShootOffBronze() {
		return _shootOffBronze;
	}

	public void setShootOffBronze(int shootOffBronze) {
		_shootOffBronze = shootOffBronze;
	}

	public int getGoldResult() {
		return _goldResult;
	}

	public void setGoldResult(int goldResult) {
		_goldResult = goldResult;
	}

	public int getShootOffGold() {
		return _shootOffGold;
	}

	public void setShootOffGold(int shootOffGold) {
		_shootOffGold = shootOffGold;
	}

	public String getTeamCategory() {
		return _teamCategory;
	}

	public void setTeamCategory(String teamCategory) {
		_teamCategory = teamCategory;
	}

	public String getTeamName() {
		return _teamName;
	}

	public void setTeamName(String teamName) {
		_teamName = teamName;
	}

	public String getNaz_int() {
		return _naz_int;
	}

	public void setNaz_int(String naz_int) {
		_naz_int = naz_int;
	}

	public int getShowTypeCode() {
		return _showTypeCode;
	}

	public void setShowTypeCode(int showTypeCode) {
		_showTypeCode = showTypeCode;
	}

	public String getShowType() {
		return _showType;
	}

	public void setShowType(String showType) {
		_showType = showType;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public Date getVariationDate() {
		return _variationDate;
	}

	public void setVariationDate(Date variationDate) {
		_variationDate = variationDate;
	}

	public int getSent() {
		return _sent;
	}

	public void setSent(int sent) {
		_sent = sent;
	}

	public String getYouthQualification() {
		return _youthQualification;
	}

	public void setYouthQualification(String youthQualification) {
		_youthQualification = youthQualification;
	}

	public long getEsfMatchTypeId() {
		return _esfMatchTypeId;
	}

	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchTypeId = esfMatchTypeId;
	}

	public int getResultClassTeam() {
		return _resultClassTeam;
	}

	public void setResultClassTeam(int resultClassTeam) {
		_resultClassTeam = resultClassTeam;
	}

	public int getSpare1() {
		return _spare1;
	}

	public void setSpare1(int spare1) {
		_spare1 = spare1;
	}

	public int getSpare2() {
		return _spare2;
	}

	public void setSpare2(int spare2) {
		_spare2 = spare2;
	}

	public long getShooterCode() {
		return _shooterCode;
	}

	public void setShooterCode(long shooterCode) {
		_shooterCode = shooterCode;
	}

	public long getShooterQualification() {
		return _shooterQualification;
	}

	public void setShooterQualification(long shooterQualification) {
		_shooterQualification = shooterQualification;
	}

	private long _esfResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _matchYear;
	private int _numberMatch;
	private long _esfMatchId;
	private String _name;
	private String _name2;
	private long _esfAssociationId;
	private String _sportTypeCode;
	private Date _startdDate;
	private Date _endDate;
	private String _groupRanking;
	private String _descGroupRanking;
	private int _position;
	private String _cardNumber;
	private String _shooterName;
	private String _nationCode;
	private String _category;
	private String _qualificationCode;
	private int _resultS1;
	private int _resultS2;
	private int _resultS3;
	private int _resultS4;
	private int _resultS5;
	private int _resultS6;
	private int _resultS7;
	private int _resultS8;
	private int _totalS;
	private int _barrage;
	private int _finalS;
	private int _finalTotal;
	private int _american1;
	private int _american2;
	private int _american3;
	private String _rifle;
	private String _caliber;
	private String _catridge;
	private String _finalType;
	private int _semifinalResult;
	private int _shootOff1s;
	private int _shootOff2s;
	private int _shootOff3s;
	private int _bronzeResult;
	private int _shootOffBronze;
	private int _goldResult;
	private int _shootOffGold;
	private String _teamCategory;
	private String _teamName;
	private String _naz_int;
	private int _showTypeCode;
	private String _showType;
	private long _esfUserId;
	private Date _variationDate;
	private int _sent;
	private String _youthQualification;
	private long _esfMatchTypeId;
	private int _resultClassTeam;
	private int _spare1;
	private int _spare2;
	private long _shooterCode;
	private long _shooterQualification;
}