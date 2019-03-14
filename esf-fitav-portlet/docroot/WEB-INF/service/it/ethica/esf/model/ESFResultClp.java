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
import it.ethica.esf.service.ESFResultLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFResultClp extends BaseModelImpl<ESFResult> implements ESFResult {
	public ESFResultClp() {
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
	public long getPrimaryKey() {
		return _esfResultId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfResultId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfResultId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEsfResultId() {
		return _esfResultId;
	}

	@Override
	public void setEsfResultId(long esfResultId) {
		_esfResultId = esfResultId;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfResultId", long.class);

				method.invoke(_esfResultRemoteModel, esfResultId);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfResultRemoteModel, groupId);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfResultRemoteModel, companyId);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfResultRemoteModel, userId);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfResultRemoteModel, userName);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfResultRemoteModel, createDate);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfResultRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMatchYear() {
		return _matchYear;
	}

	@Override
	public void setMatchYear(int matchYear) {
		_matchYear = matchYear;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setMatchYear", int.class);

				method.invoke(_esfResultRemoteModel, matchYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberMatch() {
		return _numberMatch;
	}

	@Override
	public void setNumberMatch(int numberMatch) {
		_numberMatch = numberMatch;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberMatch", int.class);

				method.invoke(_esfResultRemoteModel, numberMatch);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfResultRemoteModel, esfMatchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfResultRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName2() {
		return _name2;
	}

	@Override
	public void setName2(String name2) {
		_name2 = name2;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setName2", String.class);

				method.invoke(_esfResultRemoteModel, name2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfAssociationId() {
		return _esfAssociationId;
	}

	@Override
	public void setEsfAssociationId(long esfAssociationId) {
		_esfAssociationId = esfAssociationId;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfAssociationId",
						long.class);

				method.invoke(_esfResultRemoteModel, esfAssociationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSportTypeCode() {
		return _sportTypeCode;
	}

	@Override
	public void setSportTypeCode(String sportTypeCode) {
		_sportTypeCode = sportTypeCode;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSportTypeCode", String.class);

				method.invoke(_esfResultRemoteModel, sportTypeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartdDate() {
		return _startdDate;
	}

	@Override
	public void setStartdDate(Date startdDate) {
		_startdDate = startdDate;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setStartdDate", Date.class);

				method.invoke(_esfResultRemoteModel, startdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfResultRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupRanking() {
		return _groupRanking;
	}

	@Override
	public void setGroupRanking(String groupRanking) {
		_groupRanking = groupRanking;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupRanking", String.class);

				method.invoke(_esfResultRemoteModel, groupRanking);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescGroupRanking() {
		return _descGroupRanking;
	}

	@Override
	public void setDescGroupRanking(String descGroupRanking) {
		_descGroupRanking = descGroupRanking;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setDescGroupRanking",
						String.class);

				method.invoke(_esfResultRemoteModel, descGroupRanking);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		_position = position;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setPosition", int.class);

				method.invoke(_esfResultRemoteModel, position);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCardNumber() {
		return _cardNumber;
	}

	@Override
	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCardNumber", String.class);

				method.invoke(_esfResultRemoteModel, cardNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShooterName() {
		return _shooterName;
	}

	@Override
	public void setShooterName(String shooterName) {
		_shooterName = shooterName;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShooterName", String.class);

				method.invoke(_esfResultRemoteModel, shooterName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNationCode() {
		return _nationCode;
	}

	@Override
	public void setNationCode(String nationCode) {
		_nationCode = nationCode;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNationCode", String.class);

				method.invoke(_esfResultRemoteModel, nationCode);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_esfResultRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQualificationCode() {
		return _qualificationCode;
	}

	@Override
	public void setQualificationCode(String qualificationCode) {
		_qualificationCode = qualificationCode;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setQualificationCode",
						String.class);

				method.invoke(_esfResultRemoteModel, qualificationCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS1() {
		return _resultS1;
	}

	@Override
	public void setResultS1(int resultS1) {
		_resultS1 = resultS1;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS1", int.class);

				method.invoke(_esfResultRemoteModel, resultS1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS2() {
		return _resultS2;
	}

	@Override
	public void setResultS2(int resultS2) {
		_resultS2 = resultS2;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS2", int.class);

				method.invoke(_esfResultRemoteModel, resultS2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS3() {
		return _resultS3;
	}

	@Override
	public void setResultS3(int resultS3) {
		_resultS3 = resultS3;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS3", int.class);

				method.invoke(_esfResultRemoteModel, resultS3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS4() {
		return _resultS4;
	}

	@Override
	public void setResultS4(int resultS4) {
		_resultS4 = resultS4;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS4", int.class);

				method.invoke(_esfResultRemoteModel, resultS4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS5() {
		return _resultS5;
	}

	@Override
	public void setResultS5(int resultS5) {
		_resultS5 = resultS5;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS5", int.class);

				method.invoke(_esfResultRemoteModel, resultS5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS6() {
		return _resultS6;
	}

	@Override
	public void setResultS6(int resultS6) {
		_resultS6 = resultS6;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS6", int.class);

				method.invoke(_esfResultRemoteModel, resultS6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS7() {
		return _resultS7;
	}

	@Override
	public void setResultS7(int resultS7) {
		_resultS7 = resultS7;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS7", int.class);

				method.invoke(_esfResultRemoteModel, resultS7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultS8() {
		return _resultS8;
	}

	@Override
	public void setResultS8(int resultS8) {
		_resultS8 = resultS8;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultS8", int.class);

				method.invoke(_esfResultRemoteModel, resultS8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotalS() {
		return _totalS;
	}

	@Override
	public void setTotalS(int totalS) {
		_totalS = totalS;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalS", int.class);

				method.invoke(_esfResultRemoteModel, totalS);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBarrage() {
		return _barrage;
	}

	@Override
	public void setBarrage(int barrage) {
		_barrage = barrage;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setBarrage", int.class);

				method.invoke(_esfResultRemoteModel, barrage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFinalS() {
		return _finalS;
	}

	@Override
	public void setFinalS(int finalS) {
		_finalS = finalS;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalS", int.class);

				method.invoke(_esfResultRemoteModel, finalS);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFinalTotal() {
		return _finalTotal;
	}

	@Override
	public void setFinalTotal(int finalTotal) {
		_finalTotal = finalTotal;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalTotal", int.class);

				method.invoke(_esfResultRemoteModel, finalTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAmerican1() {
		return _american1;
	}

	@Override
	public void setAmerican1(int american1) {
		_american1 = american1;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setAmerican1", int.class);

				method.invoke(_esfResultRemoteModel, american1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAmerican2() {
		return _american2;
	}

	@Override
	public void setAmerican2(int american2) {
		_american2 = american2;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setAmerican2", int.class);

				method.invoke(_esfResultRemoteModel, american2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAmerican3() {
		return _american3;
	}

	@Override
	public void setAmerican3(int american3) {
		_american3 = american3;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setAmerican3", int.class);

				method.invoke(_esfResultRemoteModel, american3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRifle() {
		return _rifle;
	}

	@Override
	public void setRifle(String rifle) {
		_rifle = rifle;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setRifle", String.class);

				method.invoke(_esfResultRemoteModel, rifle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCaliber() {
		return _caliber;
	}

	@Override
	public void setCaliber(String caliber) {
		_caliber = caliber;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCaliber", String.class);

				method.invoke(_esfResultRemoteModel, caliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCatridge() {
		return _catridge;
	}

	@Override
	public void setCatridge(String catridge) {
		_catridge = catridge;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCatridge", String.class);

				method.invoke(_esfResultRemoteModel, catridge);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinalType() {
		return _finalType;
	}

	@Override
	public void setFinalType(String finalType) {
		_finalType = finalType;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalType", String.class);

				method.invoke(_esfResultRemoteModel, finalType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSemifinalResult() {
		return _semifinalResult;
	}

	@Override
	public void setSemifinalResult(int semifinalResult) {
		_semifinalResult = semifinalResult;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSemifinalResult", int.class);

				method.invoke(_esfResultRemoteModel, semifinalResult);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOff1s() {
		return _shootOff1s;
	}

	@Override
	public void setShootOff1s(int shootOff1s) {
		_shootOff1s = shootOff1s;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOff1s", int.class);

				method.invoke(_esfResultRemoteModel, shootOff1s);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOff2s() {
		return _shootOff2s;
	}

	@Override
	public void setShootOff2s(int shootOff2s) {
		_shootOff2s = shootOff2s;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOff2s", int.class);

				method.invoke(_esfResultRemoteModel, shootOff2s);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOff3s() {
		return _shootOff3s;
	}

	@Override
	public void setShootOff3s(int shootOff3s) {
		_shootOff3s = shootOff3s;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOff3s", int.class);

				method.invoke(_esfResultRemoteModel, shootOff3s);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBronzeResult() {
		return _bronzeResult;
	}

	@Override
	public void setBronzeResult(int bronzeResult) {
		_bronzeResult = bronzeResult;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setBronzeResult", int.class);

				method.invoke(_esfResultRemoteModel, bronzeResult);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOffBronze() {
		return _shootOffBronze;
	}

	@Override
	public void setShootOffBronze(int shootOffBronze) {
		_shootOffBronze = shootOffBronze;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOffBronze", int.class);

				method.invoke(_esfResultRemoteModel, shootOffBronze);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGoldResult() {
		return _goldResult;
	}

	@Override
	public void setGoldResult(int goldResult) {
		_goldResult = goldResult;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setGoldResult", int.class);

				method.invoke(_esfResultRemoteModel, goldResult);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOffGold() {
		return _shootOffGold;
	}

	@Override
	public void setShootOffGold(int shootOffGold) {
		_shootOffGold = shootOffGold;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOffGold", int.class);

				method.invoke(_esfResultRemoteModel, shootOffGold);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTeamCategory() {
		return _teamCategory;
	}

	@Override
	public void setTeamCategory(String teamCategory) {
		_teamCategory = teamCategory;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setTeamCategory", String.class);

				method.invoke(_esfResultRemoteModel, teamCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTeamName() {
		return _teamName;
	}

	@Override
	public void setTeamName(String teamName) {
		_teamName = teamName;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setTeamName", String.class);

				method.invoke(_esfResultRemoteModel, teamName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNaz_int() {
		return _naz_int;
	}

	@Override
	public void setNaz_int(String naz_int) {
		_naz_int = naz_int;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNaz_int", String.class);

				method.invoke(_esfResultRemoteModel, naz_int);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShowTypeCode() {
		return _showTypeCode;
	}

	@Override
	public void setShowTypeCode(int showTypeCode) {
		_showTypeCode = showTypeCode;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShowTypeCode", int.class);

				method.invoke(_esfResultRemoteModel, showTypeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShowType() {
		return _showType;
	}

	@Override
	public void setShowType(String showType) {
		_showType = showType;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShowType", String.class);

				method.invoke(_esfResultRemoteModel, showType);
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

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfResultRemoteModel, esfUserId);
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
	public Date getVariationDate() {
		return _variationDate;
	}

	@Override
	public void setVariationDate(Date variationDate) {
		_variationDate = variationDate;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setVariationDate", Date.class);

				method.invoke(_esfResultRemoteModel, variationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSent() {
		return _sent;
	}

	@Override
	public void setSent(int sent) {
		_sent = sent;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSent", int.class);

				method.invoke(_esfResultRemoteModel, sent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYouthQualification() {
		return _youthQualification;
	}

	@Override
	public void setYouthQualification(String youthQualification) {
		_youthQualification = youthQualification;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setYouthQualification",
						String.class);

				method.invoke(_esfResultRemoteModel, youthQualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfMatchTypeId() {
		return _esfMatchTypeId;
	}

	@Override
	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchTypeId = esfMatchTypeId;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchTypeId", long.class);

				method.invoke(_esfResultRemoteModel, esfMatchTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultClassTeam() {
		return _resultClassTeam;
	}

	@Override
	public void setResultClassTeam(int resultClassTeam) {
		_resultClassTeam = resultClassTeam;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setResultClassTeam", int.class);

				method.invoke(_esfResultRemoteModel, resultClassTeam);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSpare1() {
		return _spare1;
	}

	@Override
	public void setSpare1(int spare1) {
		_spare1 = spare1;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSpare1", int.class);

				method.invoke(_esfResultRemoteModel, spare1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSpare2() {
		return _spare2;
	}

	@Override
	public void setSpare2(int spare2) {
		_spare2 = spare2;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSpare2", int.class);

				method.invoke(_esfResultRemoteModel, spare2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShooterCode() {
		return _shooterCode;
	}

	@Override
	public void setShooterCode(long shooterCode) {
		_shooterCode = shooterCode;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShooterCode", long.class);

				method.invoke(_esfResultRemoteModel, shooterCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShooterQualification() {
		return _shooterQualification;
	}

	@Override
	public void setShooterQualification(long shooterQualification) {
		_shooterQualification = shooterQualification;

		if (_esfResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShooterQualification",
						long.class);

				method.invoke(_esfResultRemoteModel, shooterQualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFResultRemoteModel() {
		return _esfResultRemoteModel;
	}

	public void setESFResultRemoteModel(BaseModel<?> esfResultRemoteModel) {
		_esfResultRemoteModel = esfResultRemoteModel;
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

		Class<?> remoteModelClass = _esfResultRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfResultRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFResultLocalServiceUtil.addESFResult(this);
		}
		else {
			ESFResultLocalServiceUtil.updateESFResult(this);
		}
	}

	@Override
	public ESFResult toEscapedModel() {
		return (ESFResult)ProxyUtil.newProxyInstance(ESFResult.class.getClassLoader(),
			new Class[] { ESFResult.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFResultClp clone = new ESFResultClp();

		clone.setEsfResultId(getEsfResultId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMatchYear(getMatchYear());
		clone.setNumberMatch(getNumberMatch());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setName(getName());
		clone.setName2(getName2());
		clone.setEsfAssociationId(getEsfAssociationId());
		clone.setSportTypeCode(getSportTypeCode());
		clone.setStartdDate(getStartdDate());
		clone.setEndDate(getEndDate());
		clone.setGroupRanking(getGroupRanking());
		clone.setDescGroupRanking(getDescGroupRanking());
		clone.setPosition(getPosition());
		clone.setCardNumber(getCardNumber());
		clone.setShooterName(getShooterName());
		clone.setNationCode(getNationCode());
		clone.setCategory(getCategory());
		clone.setQualificationCode(getQualificationCode());
		clone.setResultS1(getResultS1());
		clone.setResultS2(getResultS2());
		clone.setResultS3(getResultS3());
		clone.setResultS4(getResultS4());
		clone.setResultS5(getResultS5());
		clone.setResultS6(getResultS6());
		clone.setResultS7(getResultS7());
		clone.setResultS8(getResultS8());
		clone.setTotalS(getTotalS());
		clone.setBarrage(getBarrage());
		clone.setFinalS(getFinalS());
		clone.setFinalTotal(getFinalTotal());
		clone.setAmerican1(getAmerican1());
		clone.setAmerican2(getAmerican2());
		clone.setAmerican3(getAmerican3());
		clone.setRifle(getRifle());
		clone.setCaliber(getCaliber());
		clone.setCatridge(getCatridge());
		clone.setFinalType(getFinalType());
		clone.setSemifinalResult(getSemifinalResult());
		clone.setShootOff1s(getShootOff1s());
		clone.setShootOff2s(getShootOff2s());
		clone.setShootOff3s(getShootOff3s());
		clone.setBronzeResult(getBronzeResult());
		clone.setShootOffBronze(getShootOffBronze());
		clone.setGoldResult(getGoldResult());
		clone.setShootOffGold(getShootOffGold());
		clone.setTeamCategory(getTeamCategory());
		clone.setTeamName(getTeamName());
		clone.setNaz_int(getNaz_int());
		clone.setShowTypeCode(getShowTypeCode());
		clone.setShowType(getShowType());
		clone.setEsfUserId(getEsfUserId());
		clone.setVariationDate(getVariationDate());
		clone.setSent(getSent());
		clone.setYouthQualification(getYouthQualification());
		clone.setEsfMatchTypeId(getEsfMatchTypeId());
		clone.setResultClassTeam(getResultClassTeam());
		clone.setSpare1(getSpare1());
		clone.setSpare2(getSpare2());
		clone.setShooterCode(getShooterCode());
		clone.setShooterQualification(getShooterQualification());

		return clone;
	}

	@Override
	public int compareTo(ESFResult esfResult) {
		int value = 0;

		value = getDescGroupRanking().compareTo(esfResult.getDescGroupRanking());

		if (value != 0) {
			return value;
		}

		if (getPosition() < esfResult.getPosition()) {
			value = -1;
		}
		else if (getPosition() > esfResult.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getShooterQualification() < esfResult.getShooterQualification()) {
			value = -1;
		}
		else if (getShooterQualification() > esfResult.getShooterQualification()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getShooterName().compareTo(esfResult.getShooterName());

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

		if (!(obj instanceof ESFResultClp)) {
			return false;
		}

		ESFResultClp esfResult = (ESFResultClp)obj;

		long primaryKey = esfResult.getPrimaryKey();

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
		StringBundler sb = new StringBundler(133);

		sb.append("{esfResultId=");
		sb.append(getEsfResultId());
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
		sb.append(", matchYear=");
		sb.append(getMatchYear());
		sb.append(", numberMatch=");
		sb.append(getNumberMatch());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", name2=");
		sb.append(getName2());
		sb.append(", esfAssociationId=");
		sb.append(getEsfAssociationId());
		sb.append(", sportTypeCode=");
		sb.append(getSportTypeCode());
		sb.append(", startdDate=");
		sb.append(getStartdDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", groupRanking=");
		sb.append(getGroupRanking());
		sb.append(", descGroupRanking=");
		sb.append(getDescGroupRanking());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", cardNumber=");
		sb.append(getCardNumber());
		sb.append(", shooterName=");
		sb.append(getShooterName());
		sb.append(", nationCode=");
		sb.append(getNationCode());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", qualificationCode=");
		sb.append(getQualificationCode());
		sb.append(", resultS1=");
		sb.append(getResultS1());
		sb.append(", resultS2=");
		sb.append(getResultS2());
		sb.append(", resultS3=");
		sb.append(getResultS3());
		sb.append(", resultS4=");
		sb.append(getResultS4());
		sb.append(", resultS5=");
		sb.append(getResultS5());
		sb.append(", resultS6=");
		sb.append(getResultS6());
		sb.append(", resultS7=");
		sb.append(getResultS7());
		sb.append(", resultS8=");
		sb.append(getResultS8());
		sb.append(", totalS=");
		sb.append(getTotalS());
		sb.append(", barrage=");
		sb.append(getBarrage());
		sb.append(", finalS=");
		sb.append(getFinalS());
		sb.append(", finalTotal=");
		sb.append(getFinalTotal());
		sb.append(", american1=");
		sb.append(getAmerican1());
		sb.append(", american2=");
		sb.append(getAmerican2());
		sb.append(", american3=");
		sb.append(getAmerican3());
		sb.append(", rifle=");
		sb.append(getRifle());
		sb.append(", caliber=");
		sb.append(getCaliber());
		sb.append(", catridge=");
		sb.append(getCatridge());
		sb.append(", finalType=");
		sb.append(getFinalType());
		sb.append(", semifinalResult=");
		sb.append(getSemifinalResult());
		sb.append(", shootOff1s=");
		sb.append(getShootOff1s());
		sb.append(", shootOff2s=");
		sb.append(getShootOff2s());
		sb.append(", shootOff3s=");
		sb.append(getShootOff3s());
		sb.append(", bronzeResult=");
		sb.append(getBronzeResult());
		sb.append(", shootOffBronze=");
		sb.append(getShootOffBronze());
		sb.append(", goldResult=");
		sb.append(getGoldResult());
		sb.append(", shootOffGold=");
		sb.append(getShootOffGold());
		sb.append(", teamCategory=");
		sb.append(getTeamCategory());
		sb.append(", teamName=");
		sb.append(getTeamName());
		sb.append(", naz_int=");
		sb.append(getNaz_int());
		sb.append(", showTypeCode=");
		sb.append(getShowTypeCode());
		sb.append(", showType=");
		sb.append(getShowType());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", variationDate=");
		sb.append(getVariationDate());
		sb.append(", sent=");
		sb.append(getSent());
		sb.append(", youthQualification=");
		sb.append(getYouthQualification());
		sb.append(", esfMatchTypeId=");
		sb.append(getEsfMatchTypeId());
		sb.append(", resultClassTeam=");
		sb.append(getResultClassTeam());
		sb.append(", spare1=");
		sb.append(getSpare1());
		sb.append(", spare2=");
		sb.append(getSpare2());
		sb.append(", shooterCode=");
		sb.append(getShooterCode());
		sb.append(", shooterQualification=");
		sb.append(getShooterQualification());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(202);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfResultId</column-name><column-value><![CDATA[");
		sb.append(getEsfResultId());
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
			"<column><column-name>matchYear</column-name><column-value><![CDATA[");
		sb.append(getMatchYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberMatch</column-name><column-value><![CDATA[");
		sb.append(getNumberMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name2</column-name><column-value><![CDATA[");
		sb.append(getName2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfAssociationId</column-name><column-value><![CDATA[");
		sb.append(getEsfAssociationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sportTypeCode</column-name><column-value><![CDATA[");
		sb.append(getSportTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startdDate</column-name><column-value><![CDATA[");
		sb.append(getStartdDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupRanking</column-name><column-value><![CDATA[");
		sb.append(getGroupRanking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descGroupRanking</column-name><column-value><![CDATA[");
		sb.append(getDescGroupRanking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardNumber</column-name><column-value><![CDATA[");
		sb.append(getCardNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shooterName</column-name><column-value><![CDATA[");
		sb.append(getShooterName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationCode</column-name><column-value><![CDATA[");
		sb.append(getNationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualificationCode</column-name><column-value><![CDATA[");
		sb.append(getQualificationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS1</column-name><column-value><![CDATA[");
		sb.append(getResultS1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS2</column-name><column-value><![CDATA[");
		sb.append(getResultS2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS3</column-name><column-value><![CDATA[");
		sb.append(getResultS3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS4</column-name><column-value><![CDATA[");
		sb.append(getResultS4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS5</column-name><column-value><![CDATA[");
		sb.append(getResultS5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS6</column-name><column-value><![CDATA[");
		sb.append(getResultS6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS7</column-name><column-value><![CDATA[");
		sb.append(getResultS7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultS8</column-name><column-value><![CDATA[");
		sb.append(getResultS8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalS</column-name><column-value><![CDATA[");
		sb.append(getTotalS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>barrage</column-name><column-value><![CDATA[");
		sb.append(getBarrage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalS</column-name><column-value><![CDATA[");
		sb.append(getFinalS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalTotal</column-name><column-value><![CDATA[");
		sb.append(getFinalTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>american1</column-name><column-value><![CDATA[");
		sb.append(getAmerican1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>american2</column-name><column-value><![CDATA[");
		sb.append(getAmerican2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>american3</column-name><column-value><![CDATA[");
		sb.append(getAmerican3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rifle</column-name><column-value><![CDATA[");
		sb.append(getRifle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>caliber</column-name><column-value><![CDATA[");
		sb.append(getCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catridge</column-name><column-value><![CDATA[");
		sb.append(getCatridge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalType</column-name><column-value><![CDATA[");
		sb.append(getFinalType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>semifinalResult</column-name><column-value><![CDATA[");
		sb.append(getSemifinalResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOff1s</column-name><column-value><![CDATA[");
		sb.append(getShootOff1s());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOff2s</column-name><column-value><![CDATA[");
		sb.append(getShootOff2s());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOff3s</column-name><column-value><![CDATA[");
		sb.append(getShootOff3s());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bronzeResult</column-name><column-value><![CDATA[");
		sb.append(getBronzeResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOffBronze</column-name><column-value><![CDATA[");
		sb.append(getShootOffBronze());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goldResult</column-name><column-value><![CDATA[");
		sb.append(getGoldResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOffGold</column-name><column-value><![CDATA[");
		sb.append(getShootOffGold());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>teamCategory</column-name><column-value><![CDATA[");
		sb.append(getTeamCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>teamName</column-name><column-value><![CDATA[");
		sb.append(getTeamName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>naz_int</column-name><column-value><![CDATA[");
		sb.append(getNaz_int());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showTypeCode</column-name><column-value><![CDATA[");
		sb.append(getShowTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showType</column-name><column-value><![CDATA[");
		sb.append(getShowType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>variationDate</column-name><column-value><![CDATA[");
		sb.append(getVariationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sent</column-name><column-value><![CDATA[");
		sb.append(getSent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>youthQualification</column-name><column-value><![CDATA[");
		sb.append(getYouthQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultClassTeam</column-name><column-value><![CDATA[");
		sb.append(getResultClassTeam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spare1</column-name><column-value><![CDATA[");
		sb.append(getSpare1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spare2</column-name><column-value><![CDATA[");
		sb.append(getSpare2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shooterCode</column-name><column-value><![CDATA[");
		sb.append(getShooterCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shooterQualification</column-name><column-value><![CDATA[");
		sb.append(getShooterQualification());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private String _esfUserUuid;
	private Date _variationDate;
	private int _sent;
	private String _youthQualification;
	private long _esfMatchTypeId;
	private int _resultClassTeam;
	private int _spare1;
	private int _spare2;
	private long _shooterCode;
	private long _shooterQualification;
	private BaseModel<?> _esfResultRemoteModel;
}