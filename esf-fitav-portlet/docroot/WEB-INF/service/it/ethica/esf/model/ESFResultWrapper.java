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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFResult}.
 * </p>
 *
 * @author Ethica
 * @see ESFResult
 * @generated
 */
public class ESFResultWrapper implements ESFResult, ModelWrapper<ESFResult> {
	public ESFResultWrapper(ESFResult esfResult) {
		_esfResult = esfResult;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFResult.class;
	}

	@Override
	public String getModelClassName() {
		return ESFResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfResultId", getEsfResultId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("matchYear", getMatchYear());
		attributes.put("numberMatch", getNumberMatch());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("name", getName());
		attributes.put("name2", getName2());
		attributes.put("esfAssociationId", getEsfAssociationId());
		attributes.put("sportTypeCode", getSportTypeCode());
		attributes.put("startdDate", getStartdDate());
		attributes.put("endDate", getEndDate());
		attributes.put("groupRanking", getGroupRanking());
		attributes.put("descGroupRanking", getDescGroupRanking());
		attributes.put("position", getPosition());
		attributes.put("cardNumber", getCardNumber());
		attributes.put("shooterName", getShooterName());
		attributes.put("nationCode", getNationCode());
		attributes.put("category", getCategory());
		attributes.put("qualificationCode", getQualificationCode());
		attributes.put("resultS1", getResultS1());
		attributes.put("resultS2", getResultS2());
		attributes.put("resultS3", getResultS3());
		attributes.put("resultS4", getResultS4());
		attributes.put("resultS5", getResultS5());
		attributes.put("resultS6", getResultS6());
		attributes.put("resultS7", getResultS7());
		attributes.put("resultS8", getResultS8());
		attributes.put("totalS", getTotalS());
		attributes.put("barrage", getBarrage());
		attributes.put("finalS", getFinalS());
		attributes.put("finalTotal", getFinalTotal());
		attributes.put("american1", getAmerican1());
		attributes.put("american2", getAmerican2());
		attributes.put("american3", getAmerican3());
		attributes.put("rifle", getRifle());
		attributes.put("caliber", getCaliber());
		attributes.put("catridge", getCatridge());
		attributes.put("finalType", getFinalType());
		attributes.put("semifinalResult", getSemifinalResult());
		attributes.put("shootOff1s", getShootOff1s());
		attributes.put("shootOff2s", getShootOff2s());
		attributes.put("shootOff3s", getShootOff3s());
		attributes.put("bronzeResult", getBronzeResult());
		attributes.put("shootOffBronze", getShootOffBronze());
		attributes.put("goldResult", getGoldResult());
		attributes.put("shootOffGold", getShootOffGold());
		attributes.put("teamCategory", getTeamCategory());
		attributes.put("teamName", getTeamName());
		attributes.put("naz_int", getNaz_int());
		attributes.put("showTypeCode", getShowTypeCode());
		attributes.put("showType", getShowType());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("variationDate", getVariationDate());
		attributes.put("sent", getSent());
		attributes.put("youthQualification", getYouthQualification());
		attributes.put("esfMatchTypeId", getEsfMatchTypeId());
		attributes.put("resultClassTeam", getResultClassTeam());
		attributes.put("spare1", getSpare1());
		attributes.put("spare2", getSpare2());
		attributes.put("shooterCode", getShooterCode());
		attributes.put("shooterQualification", getShooterQualification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfResultId = (Long)attributes.get("esfResultId");

		if (esfResultId != null) {
			setEsfResultId(esfResultId);
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

		Integer matchYear = (Integer)attributes.get("matchYear");

		if (matchYear != null) {
			setMatchYear(matchYear);
		}

		Integer numberMatch = (Integer)attributes.get("numberMatch");

		if (numberMatch != null) {
			setNumberMatch(numberMatch);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String name2 = (String)attributes.get("name2");

		if (name2 != null) {
			setName2(name2);
		}

		Long esfAssociationId = (Long)attributes.get("esfAssociationId");

		if (esfAssociationId != null) {
			setEsfAssociationId(esfAssociationId);
		}

		String sportTypeCode = (String)attributes.get("sportTypeCode");

		if (sportTypeCode != null) {
			setSportTypeCode(sportTypeCode);
		}

		Date startdDate = (Date)attributes.get("startdDate");

		if (startdDate != null) {
			setStartdDate(startdDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String groupRanking = (String)attributes.get("groupRanking");

		if (groupRanking != null) {
			setGroupRanking(groupRanking);
		}

		String descGroupRanking = (String)attributes.get("descGroupRanking");

		if (descGroupRanking != null) {
			setDescGroupRanking(descGroupRanking);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		String cardNumber = (String)attributes.get("cardNumber");

		if (cardNumber != null) {
			setCardNumber(cardNumber);
		}

		String shooterName = (String)attributes.get("shooterName");

		if (shooterName != null) {
			setShooterName(shooterName);
		}

		String nationCode = (String)attributes.get("nationCode");

		if (nationCode != null) {
			setNationCode(nationCode);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String qualificationCode = (String)attributes.get("qualificationCode");

		if (qualificationCode != null) {
			setQualificationCode(qualificationCode);
		}

		Integer resultS1 = (Integer)attributes.get("resultS1");

		if (resultS1 != null) {
			setResultS1(resultS1);
		}

		Integer resultS2 = (Integer)attributes.get("resultS2");

		if (resultS2 != null) {
			setResultS2(resultS2);
		}

		Integer resultS3 = (Integer)attributes.get("resultS3");

		if (resultS3 != null) {
			setResultS3(resultS3);
		}

		Integer resultS4 = (Integer)attributes.get("resultS4");

		if (resultS4 != null) {
			setResultS4(resultS4);
		}

		Integer resultS5 = (Integer)attributes.get("resultS5");

		if (resultS5 != null) {
			setResultS5(resultS5);
		}

		Integer resultS6 = (Integer)attributes.get("resultS6");

		if (resultS6 != null) {
			setResultS6(resultS6);
		}

		Integer resultS7 = (Integer)attributes.get("resultS7");

		if (resultS7 != null) {
			setResultS7(resultS7);
		}

		Integer resultS8 = (Integer)attributes.get("resultS8");

		if (resultS8 != null) {
			setResultS8(resultS8);
		}

		Integer totalS = (Integer)attributes.get("totalS");

		if (totalS != null) {
			setTotalS(totalS);
		}

		Integer barrage = (Integer)attributes.get("barrage");

		if (barrage != null) {
			setBarrage(barrage);
		}

		Integer finalS = (Integer)attributes.get("finalS");

		if (finalS != null) {
			setFinalS(finalS);
		}

		Integer finalTotal = (Integer)attributes.get("finalTotal");

		if (finalTotal != null) {
			setFinalTotal(finalTotal);
		}

		Integer american1 = (Integer)attributes.get("american1");

		if (american1 != null) {
			setAmerican1(american1);
		}

		Integer american2 = (Integer)attributes.get("american2");

		if (american2 != null) {
			setAmerican2(american2);
		}

		Integer american3 = (Integer)attributes.get("american3");

		if (american3 != null) {
			setAmerican3(american3);
		}

		String rifle = (String)attributes.get("rifle");

		if (rifle != null) {
			setRifle(rifle);
		}

		String caliber = (String)attributes.get("caliber");

		if (caliber != null) {
			setCaliber(caliber);
		}

		String catridge = (String)attributes.get("catridge");

		if (catridge != null) {
			setCatridge(catridge);
		}

		String finalType = (String)attributes.get("finalType");

		if (finalType != null) {
			setFinalType(finalType);
		}

		Integer semifinalResult = (Integer)attributes.get("semifinalResult");

		if (semifinalResult != null) {
			setSemifinalResult(semifinalResult);
		}

		Integer shootOff1s = (Integer)attributes.get("shootOff1s");

		if (shootOff1s != null) {
			setShootOff1s(shootOff1s);
		}

		Integer shootOff2s = (Integer)attributes.get("shootOff2s");

		if (shootOff2s != null) {
			setShootOff2s(shootOff2s);
		}

		Integer shootOff3s = (Integer)attributes.get("shootOff3s");

		if (shootOff3s != null) {
			setShootOff3s(shootOff3s);
		}

		Integer bronzeResult = (Integer)attributes.get("bronzeResult");

		if (bronzeResult != null) {
			setBronzeResult(bronzeResult);
		}

		Integer shootOffBronze = (Integer)attributes.get("shootOffBronze");

		if (shootOffBronze != null) {
			setShootOffBronze(shootOffBronze);
		}

		Integer goldResult = (Integer)attributes.get("goldResult");

		if (goldResult != null) {
			setGoldResult(goldResult);
		}

		Integer shootOffGold = (Integer)attributes.get("shootOffGold");

		if (shootOffGold != null) {
			setShootOffGold(shootOffGold);
		}

		String teamCategory = (String)attributes.get("teamCategory");

		if (teamCategory != null) {
			setTeamCategory(teamCategory);
		}

		String teamName = (String)attributes.get("teamName");

		if (teamName != null) {
			setTeamName(teamName);
		}

		String naz_int = (String)attributes.get("naz_int");

		if (naz_int != null) {
			setNaz_int(naz_int);
		}

		Integer showTypeCode = (Integer)attributes.get("showTypeCode");

		if (showTypeCode != null) {
			setShowTypeCode(showTypeCode);
		}

		String showType = (String)attributes.get("showType");

		if (showType != null) {
			setShowType(showType);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Date variationDate = (Date)attributes.get("variationDate");

		if (variationDate != null) {
			setVariationDate(variationDate);
		}

		Integer sent = (Integer)attributes.get("sent");

		if (sent != null) {
			setSent(sent);
		}

		String youthQualification = (String)attributes.get("youthQualification");

		if (youthQualification != null) {
			setYouthQualification(youthQualification);
		}

		Long esfMatchTypeId = (Long)attributes.get("esfMatchTypeId");

		if (esfMatchTypeId != null) {
			setEsfMatchTypeId(esfMatchTypeId);
		}

		Integer resultClassTeam = (Integer)attributes.get("resultClassTeam");

		if (resultClassTeam != null) {
			setResultClassTeam(resultClassTeam);
		}

		Integer spare1 = (Integer)attributes.get("spare1");

		if (spare1 != null) {
			setSpare1(spare1);
		}

		Integer spare2 = (Integer)attributes.get("spare2");

		if (spare2 != null) {
			setSpare2(spare2);
		}

		Long shooterCode = (Long)attributes.get("shooterCode");

		if (shooterCode != null) {
			setShooterCode(shooterCode);
		}

		Long shooterQualification = (Long)attributes.get("shooterQualification");

		if (shooterQualification != null) {
			setShooterQualification(shooterQualification);
		}
	}

	/**
	* Returns the primary key of this e s f result.
	*
	* @return the primary key of this e s f result
	*/
	@Override
	public long getPrimaryKey() {
		return _esfResult.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f result.
	*
	* @param primaryKey the primary key of this e s f result
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfResult.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf result ID of this e s f result.
	*
	* @return the esf result ID of this e s f result
	*/
	@Override
	public long getEsfResultId() {
		return _esfResult.getEsfResultId();
	}

	/**
	* Sets the esf result ID of this e s f result.
	*
	* @param esfResultId the esf result ID of this e s f result
	*/
	@Override
	public void setEsfResultId(long esfResultId) {
		_esfResult.setEsfResultId(esfResultId);
	}

	/**
	* Returns the group ID of this e s f result.
	*
	* @return the group ID of this e s f result
	*/
	@Override
	public long getGroupId() {
		return _esfResult.getGroupId();
	}

	/**
	* Sets the group ID of this e s f result.
	*
	* @param groupId the group ID of this e s f result
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfResult.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f result.
	*
	* @return the company ID of this e s f result
	*/
	@Override
	public long getCompanyId() {
		return _esfResult.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f result.
	*
	* @param companyId the company ID of this e s f result
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfResult.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f result.
	*
	* @return the user ID of this e s f result
	*/
	@Override
	public long getUserId() {
		return _esfResult.getUserId();
	}

	/**
	* Sets the user ID of this e s f result.
	*
	* @param userId the user ID of this e s f result
	*/
	@Override
	public void setUserId(long userId) {
		_esfResult.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f result.
	*
	* @return the user uuid of this e s f result
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfResult.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f result.
	*
	* @param userUuid the user uuid of this e s f result
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfResult.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f result.
	*
	* @return the user name of this e s f result
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfResult.getUserName();
	}

	/**
	* Sets the user name of this e s f result.
	*
	* @param userName the user name of this e s f result
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfResult.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f result.
	*
	* @return the create date of this e s f result
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfResult.getCreateDate();
	}

	/**
	* Sets the create date of this e s f result.
	*
	* @param createDate the create date of this e s f result
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfResult.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f result.
	*
	* @return the modified date of this e s f result
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfResult.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f result.
	*
	* @param modifiedDate the modified date of this e s f result
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfResult.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the match year of this e s f result.
	*
	* @return the match year of this e s f result
	*/
	@Override
	public int getMatchYear() {
		return _esfResult.getMatchYear();
	}

	/**
	* Sets the match year of this e s f result.
	*
	* @param matchYear the match year of this e s f result
	*/
	@Override
	public void setMatchYear(int matchYear) {
		_esfResult.setMatchYear(matchYear);
	}

	/**
	* Returns the number match of this e s f result.
	*
	* @return the number match of this e s f result
	*/
	@Override
	public int getNumberMatch() {
		return _esfResult.getNumberMatch();
	}

	/**
	* Sets the number match of this e s f result.
	*
	* @param numberMatch the number match of this e s f result
	*/
	@Override
	public void setNumberMatch(int numberMatch) {
		_esfResult.setNumberMatch(numberMatch);
	}

	/**
	* Returns the esf match ID of this e s f result.
	*
	* @return the esf match ID of this e s f result
	*/
	@Override
	public long getEsfMatchId() {
		return _esfResult.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f result.
	*
	* @param esfMatchId the esf match ID of this e s f result
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfResult.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the name of this e s f result.
	*
	* @return the name of this e s f result
	*/
	@Override
	public java.lang.String getName() {
		return _esfResult.getName();
	}

	/**
	* Sets the name of this e s f result.
	*
	* @param name the name of this e s f result
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfResult.setName(name);
	}

	/**
	* Returns the name2 of this e s f result.
	*
	* @return the name2 of this e s f result
	*/
	@Override
	public java.lang.String getName2() {
		return _esfResult.getName2();
	}

	/**
	* Sets the name2 of this e s f result.
	*
	* @param name2 the name2 of this e s f result
	*/
	@Override
	public void setName2(java.lang.String name2) {
		_esfResult.setName2(name2);
	}

	/**
	* Returns the esf association ID of this e s f result.
	*
	* @return the esf association ID of this e s f result
	*/
	@Override
	public long getEsfAssociationId() {
		return _esfResult.getEsfAssociationId();
	}

	/**
	* Sets the esf association ID of this e s f result.
	*
	* @param esfAssociationId the esf association ID of this e s f result
	*/
	@Override
	public void setEsfAssociationId(long esfAssociationId) {
		_esfResult.setEsfAssociationId(esfAssociationId);
	}

	/**
	* Returns the sport type code of this e s f result.
	*
	* @return the sport type code of this e s f result
	*/
	@Override
	public java.lang.String getSportTypeCode() {
		return _esfResult.getSportTypeCode();
	}

	/**
	* Sets the sport type code of this e s f result.
	*
	* @param sportTypeCode the sport type code of this e s f result
	*/
	@Override
	public void setSportTypeCode(java.lang.String sportTypeCode) {
		_esfResult.setSportTypeCode(sportTypeCode);
	}

	/**
	* Returns the startd date of this e s f result.
	*
	* @return the startd date of this e s f result
	*/
	@Override
	public java.util.Date getStartdDate() {
		return _esfResult.getStartdDate();
	}

	/**
	* Sets the startd date of this e s f result.
	*
	* @param startdDate the startd date of this e s f result
	*/
	@Override
	public void setStartdDate(java.util.Date startdDate) {
		_esfResult.setStartdDate(startdDate);
	}

	/**
	* Returns the end date of this e s f result.
	*
	* @return the end date of this e s f result
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfResult.getEndDate();
	}

	/**
	* Sets the end date of this e s f result.
	*
	* @param endDate the end date of this e s f result
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfResult.setEndDate(endDate);
	}

	/**
	* Returns the group ranking of this e s f result.
	*
	* @return the group ranking of this e s f result
	*/
	@Override
	public java.lang.String getGroupRanking() {
		return _esfResult.getGroupRanking();
	}

	/**
	* Sets the group ranking of this e s f result.
	*
	* @param groupRanking the group ranking of this e s f result
	*/
	@Override
	public void setGroupRanking(java.lang.String groupRanking) {
		_esfResult.setGroupRanking(groupRanking);
	}

	/**
	* Returns the desc group ranking of this e s f result.
	*
	* @return the desc group ranking of this e s f result
	*/
	@Override
	public java.lang.String getDescGroupRanking() {
		return _esfResult.getDescGroupRanking();
	}

	/**
	* Sets the desc group ranking of this e s f result.
	*
	* @param descGroupRanking the desc group ranking of this e s f result
	*/
	@Override
	public void setDescGroupRanking(java.lang.String descGroupRanking) {
		_esfResult.setDescGroupRanking(descGroupRanking);
	}

	/**
	* Returns the position of this e s f result.
	*
	* @return the position of this e s f result
	*/
	@Override
	public int getPosition() {
		return _esfResult.getPosition();
	}

	/**
	* Sets the position of this e s f result.
	*
	* @param position the position of this e s f result
	*/
	@Override
	public void setPosition(int position) {
		_esfResult.setPosition(position);
	}

	/**
	* Returns the card number of this e s f result.
	*
	* @return the card number of this e s f result
	*/
	@Override
	public java.lang.String getCardNumber() {
		return _esfResult.getCardNumber();
	}

	/**
	* Sets the card number of this e s f result.
	*
	* @param cardNumber the card number of this e s f result
	*/
	@Override
	public void setCardNumber(java.lang.String cardNumber) {
		_esfResult.setCardNumber(cardNumber);
	}

	/**
	* Returns the shooter name of this e s f result.
	*
	* @return the shooter name of this e s f result
	*/
	@Override
	public java.lang.String getShooterName() {
		return _esfResult.getShooterName();
	}

	/**
	* Sets the shooter name of this e s f result.
	*
	* @param shooterName the shooter name of this e s f result
	*/
	@Override
	public void setShooterName(java.lang.String shooterName) {
		_esfResult.setShooterName(shooterName);
	}

	/**
	* Returns the nation code of this e s f result.
	*
	* @return the nation code of this e s f result
	*/
	@Override
	public java.lang.String getNationCode() {
		return _esfResult.getNationCode();
	}

	/**
	* Sets the nation code of this e s f result.
	*
	* @param nationCode the nation code of this e s f result
	*/
	@Override
	public void setNationCode(java.lang.String nationCode) {
		_esfResult.setNationCode(nationCode);
	}

	/**
	* Returns the category of this e s f result.
	*
	* @return the category of this e s f result
	*/
	@Override
	public java.lang.String getCategory() {
		return _esfResult.getCategory();
	}

	/**
	* Sets the category of this e s f result.
	*
	* @param category the category of this e s f result
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_esfResult.setCategory(category);
	}

	/**
	* Returns the qualification code of this e s f result.
	*
	* @return the qualification code of this e s f result
	*/
	@Override
	public java.lang.String getQualificationCode() {
		return _esfResult.getQualificationCode();
	}

	/**
	* Sets the qualification code of this e s f result.
	*
	* @param qualificationCode the qualification code of this e s f result
	*/
	@Override
	public void setQualificationCode(java.lang.String qualificationCode) {
		_esfResult.setQualificationCode(qualificationCode);
	}

	/**
	* Returns the result s1 of this e s f result.
	*
	* @return the result s1 of this e s f result
	*/
	@Override
	public int getResultS1() {
		return _esfResult.getResultS1();
	}

	/**
	* Sets the result s1 of this e s f result.
	*
	* @param resultS1 the result s1 of this e s f result
	*/
	@Override
	public void setResultS1(int resultS1) {
		_esfResult.setResultS1(resultS1);
	}

	/**
	* Returns the result s2 of this e s f result.
	*
	* @return the result s2 of this e s f result
	*/
	@Override
	public int getResultS2() {
		return _esfResult.getResultS2();
	}

	/**
	* Sets the result s2 of this e s f result.
	*
	* @param resultS2 the result s2 of this e s f result
	*/
	@Override
	public void setResultS2(int resultS2) {
		_esfResult.setResultS2(resultS2);
	}

	/**
	* Returns the result s3 of this e s f result.
	*
	* @return the result s3 of this e s f result
	*/
	@Override
	public int getResultS3() {
		return _esfResult.getResultS3();
	}

	/**
	* Sets the result s3 of this e s f result.
	*
	* @param resultS3 the result s3 of this e s f result
	*/
	@Override
	public void setResultS3(int resultS3) {
		_esfResult.setResultS3(resultS3);
	}

	/**
	* Returns the result s4 of this e s f result.
	*
	* @return the result s4 of this e s f result
	*/
	@Override
	public int getResultS4() {
		return _esfResult.getResultS4();
	}

	/**
	* Sets the result s4 of this e s f result.
	*
	* @param resultS4 the result s4 of this e s f result
	*/
	@Override
	public void setResultS4(int resultS4) {
		_esfResult.setResultS4(resultS4);
	}

	/**
	* Returns the result s5 of this e s f result.
	*
	* @return the result s5 of this e s f result
	*/
	@Override
	public int getResultS5() {
		return _esfResult.getResultS5();
	}

	/**
	* Sets the result s5 of this e s f result.
	*
	* @param resultS5 the result s5 of this e s f result
	*/
	@Override
	public void setResultS5(int resultS5) {
		_esfResult.setResultS5(resultS5);
	}

	/**
	* Returns the result s6 of this e s f result.
	*
	* @return the result s6 of this e s f result
	*/
	@Override
	public int getResultS6() {
		return _esfResult.getResultS6();
	}

	/**
	* Sets the result s6 of this e s f result.
	*
	* @param resultS6 the result s6 of this e s f result
	*/
	@Override
	public void setResultS6(int resultS6) {
		_esfResult.setResultS6(resultS6);
	}

	/**
	* Returns the result s7 of this e s f result.
	*
	* @return the result s7 of this e s f result
	*/
	@Override
	public int getResultS7() {
		return _esfResult.getResultS7();
	}

	/**
	* Sets the result s7 of this e s f result.
	*
	* @param resultS7 the result s7 of this e s f result
	*/
	@Override
	public void setResultS7(int resultS7) {
		_esfResult.setResultS7(resultS7);
	}

	/**
	* Returns the result s8 of this e s f result.
	*
	* @return the result s8 of this e s f result
	*/
	@Override
	public int getResultS8() {
		return _esfResult.getResultS8();
	}

	/**
	* Sets the result s8 of this e s f result.
	*
	* @param resultS8 the result s8 of this e s f result
	*/
	@Override
	public void setResultS8(int resultS8) {
		_esfResult.setResultS8(resultS8);
	}

	/**
	* Returns the total s of this e s f result.
	*
	* @return the total s of this e s f result
	*/
	@Override
	public int getTotalS() {
		return _esfResult.getTotalS();
	}

	/**
	* Sets the total s of this e s f result.
	*
	* @param totalS the total s of this e s f result
	*/
	@Override
	public void setTotalS(int totalS) {
		_esfResult.setTotalS(totalS);
	}

	/**
	* Returns the barrage of this e s f result.
	*
	* @return the barrage of this e s f result
	*/
	@Override
	public int getBarrage() {
		return _esfResult.getBarrage();
	}

	/**
	* Sets the barrage of this e s f result.
	*
	* @param barrage the barrage of this e s f result
	*/
	@Override
	public void setBarrage(int barrage) {
		_esfResult.setBarrage(barrage);
	}

	/**
	* Returns the final s of this e s f result.
	*
	* @return the final s of this e s f result
	*/
	@Override
	public int getFinalS() {
		return _esfResult.getFinalS();
	}

	/**
	* Sets the final s of this e s f result.
	*
	* @param finalS the final s of this e s f result
	*/
	@Override
	public void setFinalS(int finalS) {
		_esfResult.setFinalS(finalS);
	}

	/**
	* Returns the final total of this e s f result.
	*
	* @return the final total of this e s f result
	*/
	@Override
	public int getFinalTotal() {
		return _esfResult.getFinalTotal();
	}

	/**
	* Sets the final total of this e s f result.
	*
	* @param finalTotal the final total of this e s f result
	*/
	@Override
	public void setFinalTotal(int finalTotal) {
		_esfResult.setFinalTotal(finalTotal);
	}

	/**
	* Returns the american1 of this e s f result.
	*
	* @return the american1 of this e s f result
	*/
	@Override
	public int getAmerican1() {
		return _esfResult.getAmerican1();
	}

	/**
	* Sets the american1 of this e s f result.
	*
	* @param american1 the american1 of this e s f result
	*/
	@Override
	public void setAmerican1(int american1) {
		_esfResult.setAmerican1(american1);
	}

	/**
	* Returns the american2 of this e s f result.
	*
	* @return the american2 of this e s f result
	*/
	@Override
	public int getAmerican2() {
		return _esfResult.getAmerican2();
	}

	/**
	* Sets the american2 of this e s f result.
	*
	* @param american2 the american2 of this e s f result
	*/
	@Override
	public void setAmerican2(int american2) {
		_esfResult.setAmerican2(american2);
	}

	/**
	* Returns the american3 of this e s f result.
	*
	* @return the american3 of this e s f result
	*/
	@Override
	public int getAmerican3() {
		return _esfResult.getAmerican3();
	}

	/**
	* Sets the american3 of this e s f result.
	*
	* @param american3 the american3 of this e s f result
	*/
	@Override
	public void setAmerican3(int american3) {
		_esfResult.setAmerican3(american3);
	}

	/**
	* Returns the rifle of this e s f result.
	*
	* @return the rifle of this e s f result
	*/
	@Override
	public java.lang.String getRifle() {
		return _esfResult.getRifle();
	}

	/**
	* Sets the rifle of this e s f result.
	*
	* @param rifle the rifle of this e s f result
	*/
	@Override
	public void setRifle(java.lang.String rifle) {
		_esfResult.setRifle(rifle);
	}

	/**
	* Returns the caliber of this e s f result.
	*
	* @return the caliber of this e s f result
	*/
	@Override
	public java.lang.String getCaliber() {
		return _esfResult.getCaliber();
	}

	/**
	* Sets the caliber of this e s f result.
	*
	* @param caliber the caliber of this e s f result
	*/
	@Override
	public void setCaliber(java.lang.String caliber) {
		_esfResult.setCaliber(caliber);
	}

	/**
	* Returns the catridge of this e s f result.
	*
	* @return the catridge of this e s f result
	*/
	@Override
	public java.lang.String getCatridge() {
		return _esfResult.getCatridge();
	}

	/**
	* Sets the catridge of this e s f result.
	*
	* @param catridge the catridge of this e s f result
	*/
	@Override
	public void setCatridge(java.lang.String catridge) {
		_esfResult.setCatridge(catridge);
	}

	/**
	* Returns the final type of this e s f result.
	*
	* @return the final type of this e s f result
	*/
	@Override
	public java.lang.String getFinalType() {
		return _esfResult.getFinalType();
	}

	/**
	* Sets the final type of this e s f result.
	*
	* @param finalType the final type of this e s f result
	*/
	@Override
	public void setFinalType(java.lang.String finalType) {
		_esfResult.setFinalType(finalType);
	}

	/**
	* Returns the semifinal result of this e s f result.
	*
	* @return the semifinal result of this e s f result
	*/
	@Override
	public int getSemifinalResult() {
		return _esfResult.getSemifinalResult();
	}

	/**
	* Sets the semifinal result of this e s f result.
	*
	* @param semifinalResult the semifinal result of this e s f result
	*/
	@Override
	public void setSemifinalResult(int semifinalResult) {
		_esfResult.setSemifinalResult(semifinalResult);
	}

	/**
	* Returns the shoot off1s of this e s f result.
	*
	* @return the shoot off1s of this e s f result
	*/
	@Override
	public int getShootOff1s() {
		return _esfResult.getShootOff1s();
	}

	/**
	* Sets the shoot off1s of this e s f result.
	*
	* @param shootOff1s the shoot off1s of this e s f result
	*/
	@Override
	public void setShootOff1s(int shootOff1s) {
		_esfResult.setShootOff1s(shootOff1s);
	}

	/**
	* Returns the shoot off2s of this e s f result.
	*
	* @return the shoot off2s of this e s f result
	*/
	@Override
	public int getShootOff2s() {
		return _esfResult.getShootOff2s();
	}

	/**
	* Sets the shoot off2s of this e s f result.
	*
	* @param shootOff2s the shoot off2s of this e s f result
	*/
	@Override
	public void setShootOff2s(int shootOff2s) {
		_esfResult.setShootOff2s(shootOff2s);
	}

	/**
	* Returns the shoot off3s of this e s f result.
	*
	* @return the shoot off3s of this e s f result
	*/
	@Override
	public int getShootOff3s() {
		return _esfResult.getShootOff3s();
	}

	/**
	* Sets the shoot off3s of this e s f result.
	*
	* @param shootOff3s the shoot off3s of this e s f result
	*/
	@Override
	public void setShootOff3s(int shootOff3s) {
		_esfResult.setShootOff3s(shootOff3s);
	}

	/**
	* Returns the bronze result of this e s f result.
	*
	* @return the bronze result of this e s f result
	*/
	@Override
	public int getBronzeResult() {
		return _esfResult.getBronzeResult();
	}

	/**
	* Sets the bronze result of this e s f result.
	*
	* @param bronzeResult the bronze result of this e s f result
	*/
	@Override
	public void setBronzeResult(int bronzeResult) {
		_esfResult.setBronzeResult(bronzeResult);
	}

	/**
	* Returns the shoot off bronze of this e s f result.
	*
	* @return the shoot off bronze of this e s f result
	*/
	@Override
	public int getShootOffBronze() {
		return _esfResult.getShootOffBronze();
	}

	/**
	* Sets the shoot off bronze of this e s f result.
	*
	* @param shootOffBronze the shoot off bronze of this e s f result
	*/
	@Override
	public void setShootOffBronze(int shootOffBronze) {
		_esfResult.setShootOffBronze(shootOffBronze);
	}

	/**
	* Returns the gold result of this e s f result.
	*
	* @return the gold result of this e s f result
	*/
	@Override
	public int getGoldResult() {
		return _esfResult.getGoldResult();
	}

	/**
	* Sets the gold result of this e s f result.
	*
	* @param goldResult the gold result of this e s f result
	*/
	@Override
	public void setGoldResult(int goldResult) {
		_esfResult.setGoldResult(goldResult);
	}

	/**
	* Returns the shoot off gold of this e s f result.
	*
	* @return the shoot off gold of this e s f result
	*/
	@Override
	public int getShootOffGold() {
		return _esfResult.getShootOffGold();
	}

	/**
	* Sets the shoot off gold of this e s f result.
	*
	* @param shootOffGold the shoot off gold of this e s f result
	*/
	@Override
	public void setShootOffGold(int shootOffGold) {
		_esfResult.setShootOffGold(shootOffGold);
	}

	/**
	* Returns the team category of this e s f result.
	*
	* @return the team category of this e s f result
	*/
	@Override
	public java.lang.String getTeamCategory() {
		return _esfResult.getTeamCategory();
	}

	/**
	* Sets the team category of this e s f result.
	*
	* @param teamCategory the team category of this e s f result
	*/
	@Override
	public void setTeamCategory(java.lang.String teamCategory) {
		_esfResult.setTeamCategory(teamCategory);
	}

	/**
	* Returns the team name of this e s f result.
	*
	* @return the team name of this e s f result
	*/
	@Override
	public java.lang.String getTeamName() {
		return _esfResult.getTeamName();
	}

	/**
	* Sets the team name of this e s f result.
	*
	* @param teamName the team name of this e s f result
	*/
	@Override
	public void setTeamName(java.lang.String teamName) {
		_esfResult.setTeamName(teamName);
	}

	/**
	* Returns the naz_int of this e s f result.
	*
	* @return the naz_int of this e s f result
	*/
	@Override
	public java.lang.String getNaz_int() {
		return _esfResult.getNaz_int();
	}

	/**
	* Sets the naz_int of this e s f result.
	*
	* @param naz_int the naz_int of this e s f result
	*/
	@Override
	public void setNaz_int(java.lang.String naz_int) {
		_esfResult.setNaz_int(naz_int);
	}

	/**
	* Returns the show type code of this e s f result.
	*
	* @return the show type code of this e s f result
	*/
	@Override
	public int getShowTypeCode() {
		return _esfResult.getShowTypeCode();
	}

	/**
	* Sets the show type code of this e s f result.
	*
	* @param showTypeCode the show type code of this e s f result
	*/
	@Override
	public void setShowTypeCode(int showTypeCode) {
		_esfResult.setShowTypeCode(showTypeCode);
	}

	/**
	* Returns the show type of this e s f result.
	*
	* @return the show type of this e s f result
	*/
	@Override
	public java.lang.String getShowType() {
		return _esfResult.getShowType();
	}

	/**
	* Sets the show type of this e s f result.
	*
	* @param showType the show type of this e s f result
	*/
	@Override
	public void setShowType(java.lang.String showType) {
		_esfResult.setShowType(showType);
	}

	/**
	* Returns the esf user ID of this e s f result.
	*
	* @return the esf user ID of this e s f result
	*/
	@Override
	public long getEsfUserId() {
		return _esfResult.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f result.
	*
	* @param esfUserId the esf user ID of this e s f result
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfResult.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f result.
	*
	* @return the esf user uuid of this e s f result
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfResult.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f result.
	*
	* @param esfUserUuid the esf user uuid of this e s f result
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfResult.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the variation date of this e s f result.
	*
	* @return the variation date of this e s f result
	*/
	@Override
	public java.util.Date getVariationDate() {
		return _esfResult.getVariationDate();
	}

	/**
	* Sets the variation date of this e s f result.
	*
	* @param variationDate the variation date of this e s f result
	*/
	@Override
	public void setVariationDate(java.util.Date variationDate) {
		_esfResult.setVariationDate(variationDate);
	}

	/**
	* Returns the sent of this e s f result.
	*
	* @return the sent of this e s f result
	*/
	@Override
	public int getSent() {
		return _esfResult.getSent();
	}

	/**
	* Sets the sent of this e s f result.
	*
	* @param sent the sent of this e s f result
	*/
	@Override
	public void setSent(int sent) {
		_esfResult.setSent(sent);
	}

	/**
	* Returns the youth qualification of this e s f result.
	*
	* @return the youth qualification of this e s f result
	*/
	@Override
	public java.lang.String getYouthQualification() {
		return _esfResult.getYouthQualification();
	}

	/**
	* Sets the youth qualification of this e s f result.
	*
	* @param youthQualification the youth qualification of this e s f result
	*/
	@Override
	public void setYouthQualification(java.lang.String youthQualification) {
		_esfResult.setYouthQualification(youthQualification);
	}

	/**
	* Returns the esf match type ID of this e s f result.
	*
	* @return the esf match type ID of this e s f result
	*/
	@Override
	public long getEsfMatchTypeId() {
		return _esfResult.getEsfMatchTypeId();
	}

	/**
	* Sets the esf match type ID of this e s f result.
	*
	* @param esfMatchTypeId the esf match type ID of this e s f result
	*/
	@Override
	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfResult.setEsfMatchTypeId(esfMatchTypeId);
	}

	/**
	* Returns the result class team of this e s f result.
	*
	* @return the result class team of this e s f result
	*/
	@Override
	public int getResultClassTeam() {
		return _esfResult.getResultClassTeam();
	}

	/**
	* Sets the result class team of this e s f result.
	*
	* @param resultClassTeam the result class team of this e s f result
	*/
	@Override
	public void setResultClassTeam(int resultClassTeam) {
		_esfResult.setResultClassTeam(resultClassTeam);
	}

	/**
	* Returns the spare1 of this e s f result.
	*
	* @return the spare1 of this e s f result
	*/
	@Override
	public int getSpare1() {
		return _esfResult.getSpare1();
	}

	/**
	* Sets the spare1 of this e s f result.
	*
	* @param spare1 the spare1 of this e s f result
	*/
	@Override
	public void setSpare1(int spare1) {
		_esfResult.setSpare1(spare1);
	}

	/**
	* Returns the spare2 of this e s f result.
	*
	* @return the spare2 of this e s f result
	*/
	@Override
	public int getSpare2() {
		return _esfResult.getSpare2();
	}

	/**
	* Sets the spare2 of this e s f result.
	*
	* @param spare2 the spare2 of this e s f result
	*/
	@Override
	public void setSpare2(int spare2) {
		_esfResult.setSpare2(spare2);
	}

	/**
	* Returns the shooter code of this e s f result.
	*
	* @return the shooter code of this e s f result
	*/
	@Override
	public long getShooterCode() {
		return _esfResult.getShooterCode();
	}

	/**
	* Sets the shooter code of this e s f result.
	*
	* @param shooterCode the shooter code of this e s f result
	*/
	@Override
	public void setShooterCode(long shooterCode) {
		_esfResult.setShooterCode(shooterCode);
	}

	/**
	* Returns the shooter qualification of this e s f result.
	*
	* @return the shooter qualification of this e s f result
	*/
	@Override
	public long getShooterQualification() {
		return _esfResult.getShooterQualification();
	}

	/**
	* Sets the shooter qualification of this e s f result.
	*
	* @param shooterQualification the shooter qualification of this e s f result
	*/
	@Override
	public void setShooterQualification(long shooterQualification) {
		_esfResult.setShooterQualification(shooterQualification);
	}

	@Override
	public boolean isNew() {
		return _esfResult.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfResult.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfResult.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfResult.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfResult.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfResult.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfResult.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfResult.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfResult.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfResult.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfResult.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFResultWrapper((ESFResult)_esfResult.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFResult esfResult) {
		return _esfResult.compareTo(esfResult);
	}

	@Override
	public int hashCode() {
		return _esfResult.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFResult> toCacheModel() {
		return _esfResult.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFResult toEscapedModel() {
		return new ESFResultWrapper(_esfResult.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFResult toUnescapedModel() {
		return new ESFResultWrapper(_esfResult.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfResult.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfResult.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfResult.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFResultWrapper)) {
			return false;
		}

		ESFResultWrapper esfResultWrapper = (ESFResultWrapper)obj;

		if (Validator.equals(_esfResult, esfResultWrapper._esfResult)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFResult getWrappedESFResult() {
		return _esfResult;
	}

	@Override
	public ESFResult getWrappedModel() {
		return _esfResult;
	}

	@Override
	public void resetOriginalValues() {
		_esfResult.resetOriginalValues();
	}

	private ESFResult _esfResult;
}