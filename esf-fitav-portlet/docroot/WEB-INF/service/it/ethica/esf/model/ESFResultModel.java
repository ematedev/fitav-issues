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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFResult service. Represents a row in the &quot;ESFResult&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFResultModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFResultImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFResult
 * @see it.ethica.esf.model.impl.ESFResultImpl
 * @see it.ethica.esf.model.impl.ESFResultModelImpl
 * @generated
 */
public interface ESFResultModel extends BaseModel<ESFResult>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f result model instance should use the {@link ESFResult} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f result.
	 *
	 * @return the primary key of this e s f result
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f result.
	 *
	 * @param primaryKey the primary key of this e s f result
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf result ID of this e s f result.
	 *
	 * @return the esf result ID of this e s f result
	 */
	public long getEsfResultId();

	/**
	 * Sets the esf result ID of this e s f result.
	 *
	 * @param esfResultId the esf result ID of this e s f result
	 */
	public void setEsfResultId(long esfResultId);

	/**
	 * Returns the group ID of this e s f result.
	 *
	 * @return the group ID of this e s f result
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f result.
	 *
	 * @param groupId the group ID of this e s f result
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f result.
	 *
	 * @return the company ID of this e s f result
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f result.
	 *
	 * @param companyId the company ID of this e s f result
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f result.
	 *
	 * @return the user ID of this e s f result
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f result.
	 *
	 * @param userId the user ID of this e s f result
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f result.
	 *
	 * @return the user uuid of this e s f result
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f result.
	 *
	 * @param userUuid the user uuid of this e s f result
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f result.
	 *
	 * @return the user name of this e s f result
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f result.
	 *
	 * @param userName the user name of this e s f result
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f result.
	 *
	 * @return the create date of this e s f result
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f result.
	 *
	 * @param createDate the create date of this e s f result
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f result.
	 *
	 * @return the modified date of this e s f result
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f result.
	 *
	 * @param modifiedDate the modified date of this e s f result
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the match year of this e s f result.
	 *
	 * @return the match year of this e s f result
	 */
	public int getMatchYear();

	/**
	 * Sets the match year of this e s f result.
	 *
	 * @param matchYear the match year of this e s f result
	 */
	public void setMatchYear(int matchYear);

	/**
	 * Returns the number match of this e s f result.
	 *
	 * @return the number match of this e s f result
	 */
	public int getNumberMatch();

	/**
	 * Sets the number match of this e s f result.
	 *
	 * @param numberMatch the number match of this e s f result
	 */
	public void setNumberMatch(int numberMatch);

	/**
	 * Returns the esf match ID of this e s f result.
	 *
	 * @return the esf match ID of this e s f result
	 */
	public long getEsfMatchId();

	/**
	 * Sets the esf match ID of this e s f result.
	 *
	 * @param esfMatchId the esf match ID of this e s f result
	 */
	public void setEsfMatchId(long esfMatchId);

	/**
	 * Returns the name of this e s f result.
	 *
	 * @return the name of this e s f result
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f result.
	 *
	 * @param name the name of this e s f result
	 */
	public void setName(String name);

	/**
	 * Returns the name2 of this e s f result.
	 *
	 * @return the name2 of this e s f result
	 */
	@AutoEscape
	public String getName2();

	/**
	 * Sets the name2 of this e s f result.
	 *
	 * @param name2 the name2 of this e s f result
	 */
	public void setName2(String name2);

	/**
	 * Returns the esf association ID of this e s f result.
	 *
	 * @return the esf association ID of this e s f result
	 */
	public long getEsfAssociationId();

	/**
	 * Sets the esf association ID of this e s f result.
	 *
	 * @param esfAssociationId the esf association ID of this e s f result
	 */
	public void setEsfAssociationId(long esfAssociationId);

	/**
	 * Returns the sport type code of this e s f result.
	 *
	 * @return the sport type code of this e s f result
	 */
	@AutoEscape
	public String getSportTypeCode();

	/**
	 * Sets the sport type code of this e s f result.
	 *
	 * @param sportTypeCode the sport type code of this e s f result
	 */
	public void setSportTypeCode(String sportTypeCode);

	/**
	 * Returns the startd date of this e s f result.
	 *
	 * @return the startd date of this e s f result
	 */
	public Date getStartdDate();

	/**
	 * Sets the startd date of this e s f result.
	 *
	 * @param startdDate the startd date of this e s f result
	 */
	public void setStartdDate(Date startdDate);

	/**
	 * Returns the end date of this e s f result.
	 *
	 * @return the end date of this e s f result
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f result.
	 *
	 * @param endDate the end date of this e s f result
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the group ranking of this e s f result.
	 *
	 * @return the group ranking of this e s f result
	 */
	@AutoEscape
	public String getGroupRanking();

	/**
	 * Sets the group ranking of this e s f result.
	 *
	 * @param groupRanking the group ranking of this e s f result
	 */
	public void setGroupRanking(String groupRanking);

	/**
	 * Returns the desc group ranking of this e s f result.
	 *
	 * @return the desc group ranking of this e s f result
	 */
	@AutoEscape
	public String getDescGroupRanking();

	/**
	 * Sets the desc group ranking of this e s f result.
	 *
	 * @param descGroupRanking the desc group ranking of this e s f result
	 */
	public void setDescGroupRanking(String descGroupRanking);

	/**
	 * Returns the position of this e s f result.
	 *
	 * @return the position of this e s f result
	 */
	public int getPosition();

	/**
	 * Sets the position of this e s f result.
	 *
	 * @param position the position of this e s f result
	 */
	public void setPosition(int position);

	/**
	 * Returns the card number of this e s f result.
	 *
	 * @return the card number of this e s f result
	 */
	@AutoEscape
	public String getCardNumber();

	/**
	 * Sets the card number of this e s f result.
	 *
	 * @param cardNumber the card number of this e s f result
	 */
	public void setCardNumber(String cardNumber);

	/**
	 * Returns the shooter name of this e s f result.
	 *
	 * @return the shooter name of this e s f result
	 */
	@AutoEscape
	public String getShooterName();

	/**
	 * Sets the shooter name of this e s f result.
	 *
	 * @param shooterName the shooter name of this e s f result
	 */
	public void setShooterName(String shooterName);

	/**
	 * Returns the nation code of this e s f result.
	 *
	 * @return the nation code of this e s f result
	 */
	@AutoEscape
	public String getNationCode();

	/**
	 * Sets the nation code of this e s f result.
	 *
	 * @param nationCode the nation code of this e s f result
	 */
	public void setNationCode(String nationCode);

	/**
	 * Returns the category of this e s f result.
	 *
	 * @return the category of this e s f result
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this e s f result.
	 *
	 * @param category the category of this e s f result
	 */
	public void setCategory(String category);

	/**
	 * Returns the qualification code of this e s f result.
	 *
	 * @return the qualification code of this e s f result
	 */
	@AutoEscape
	public String getQualificationCode();

	/**
	 * Sets the qualification code of this e s f result.
	 *
	 * @param qualificationCode the qualification code of this e s f result
	 */
	public void setQualificationCode(String qualificationCode);

	/**
	 * Returns the result s1 of this e s f result.
	 *
	 * @return the result s1 of this e s f result
	 */
	public int getResultS1();

	/**
	 * Sets the result s1 of this e s f result.
	 *
	 * @param resultS1 the result s1 of this e s f result
	 */
	public void setResultS1(int resultS1);

	/**
	 * Returns the result s2 of this e s f result.
	 *
	 * @return the result s2 of this e s f result
	 */
	public int getResultS2();

	/**
	 * Sets the result s2 of this e s f result.
	 *
	 * @param resultS2 the result s2 of this e s f result
	 */
	public void setResultS2(int resultS2);

	/**
	 * Returns the result s3 of this e s f result.
	 *
	 * @return the result s3 of this e s f result
	 */
	public int getResultS3();

	/**
	 * Sets the result s3 of this e s f result.
	 *
	 * @param resultS3 the result s3 of this e s f result
	 */
	public void setResultS3(int resultS3);

	/**
	 * Returns the result s4 of this e s f result.
	 *
	 * @return the result s4 of this e s f result
	 */
	public int getResultS4();

	/**
	 * Sets the result s4 of this e s f result.
	 *
	 * @param resultS4 the result s4 of this e s f result
	 */
	public void setResultS4(int resultS4);

	/**
	 * Returns the result s5 of this e s f result.
	 *
	 * @return the result s5 of this e s f result
	 */
	public int getResultS5();

	/**
	 * Sets the result s5 of this e s f result.
	 *
	 * @param resultS5 the result s5 of this e s f result
	 */
	public void setResultS5(int resultS5);

	/**
	 * Returns the result s6 of this e s f result.
	 *
	 * @return the result s6 of this e s f result
	 */
	public int getResultS6();

	/**
	 * Sets the result s6 of this e s f result.
	 *
	 * @param resultS6 the result s6 of this e s f result
	 */
	public void setResultS6(int resultS6);

	/**
	 * Returns the result s7 of this e s f result.
	 *
	 * @return the result s7 of this e s f result
	 */
	public int getResultS7();

	/**
	 * Sets the result s7 of this e s f result.
	 *
	 * @param resultS7 the result s7 of this e s f result
	 */
	public void setResultS7(int resultS7);

	/**
	 * Returns the result s8 of this e s f result.
	 *
	 * @return the result s8 of this e s f result
	 */
	public int getResultS8();

	/**
	 * Sets the result s8 of this e s f result.
	 *
	 * @param resultS8 the result s8 of this e s f result
	 */
	public void setResultS8(int resultS8);

	/**
	 * Returns the total s of this e s f result.
	 *
	 * @return the total s of this e s f result
	 */
	public int getTotalS();

	/**
	 * Sets the total s of this e s f result.
	 *
	 * @param totalS the total s of this e s f result
	 */
	public void setTotalS(int totalS);

	/**
	 * Returns the barrage of this e s f result.
	 *
	 * @return the barrage of this e s f result
	 */
	public int getBarrage();

	/**
	 * Sets the barrage of this e s f result.
	 *
	 * @param barrage the barrage of this e s f result
	 */
	public void setBarrage(int barrage);

	/**
	 * Returns the final s of this e s f result.
	 *
	 * @return the final s of this e s f result
	 */
	public int getFinalS();

	/**
	 * Sets the final s of this e s f result.
	 *
	 * @param finalS the final s of this e s f result
	 */
	public void setFinalS(int finalS);

	/**
	 * Returns the final total of this e s f result.
	 *
	 * @return the final total of this e s f result
	 */
	public int getFinalTotal();

	/**
	 * Sets the final total of this e s f result.
	 *
	 * @param finalTotal the final total of this e s f result
	 */
	public void setFinalTotal(int finalTotal);

	/**
	 * Returns the american1 of this e s f result.
	 *
	 * @return the american1 of this e s f result
	 */
	public int getAmerican1();

	/**
	 * Sets the american1 of this e s f result.
	 *
	 * @param american1 the american1 of this e s f result
	 */
	public void setAmerican1(int american1);

	/**
	 * Returns the american2 of this e s f result.
	 *
	 * @return the american2 of this e s f result
	 */
	public int getAmerican2();

	/**
	 * Sets the american2 of this e s f result.
	 *
	 * @param american2 the american2 of this e s f result
	 */
	public void setAmerican2(int american2);

	/**
	 * Returns the american3 of this e s f result.
	 *
	 * @return the american3 of this e s f result
	 */
	public int getAmerican3();

	/**
	 * Sets the american3 of this e s f result.
	 *
	 * @param american3 the american3 of this e s f result
	 */
	public void setAmerican3(int american3);

	/**
	 * Returns the rifle of this e s f result.
	 *
	 * @return the rifle of this e s f result
	 */
	@AutoEscape
	public String getRifle();

	/**
	 * Sets the rifle of this e s f result.
	 *
	 * @param rifle the rifle of this e s f result
	 */
	public void setRifle(String rifle);

	/**
	 * Returns the caliber of this e s f result.
	 *
	 * @return the caliber of this e s f result
	 */
	@AutoEscape
	public String getCaliber();

	/**
	 * Sets the caliber of this e s f result.
	 *
	 * @param caliber the caliber of this e s f result
	 */
	public void setCaliber(String caliber);

	/**
	 * Returns the catridge of this e s f result.
	 *
	 * @return the catridge of this e s f result
	 */
	@AutoEscape
	public String getCatridge();

	/**
	 * Sets the catridge of this e s f result.
	 *
	 * @param catridge the catridge of this e s f result
	 */
	public void setCatridge(String catridge);

	/**
	 * Returns the final type of this e s f result.
	 *
	 * @return the final type of this e s f result
	 */
	@AutoEscape
	public String getFinalType();

	/**
	 * Sets the final type of this e s f result.
	 *
	 * @param finalType the final type of this e s f result
	 */
	public void setFinalType(String finalType);

	/**
	 * Returns the semifinal result of this e s f result.
	 *
	 * @return the semifinal result of this e s f result
	 */
	public int getSemifinalResult();

	/**
	 * Sets the semifinal result of this e s f result.
	 *
	 * @param semifinalResult the semifinal result of this e s f result
	 */
	public void setSemifinalResult(int semifinalResult);

	/**
	 * Returns the shoot off1s of this e s f result.
	 *
	 * @return the shoot off1s of this e s f result
	 */
	public int getShootOff1s();

	/**
	 * Sets the shoot off1s of this e s f result.
	 *
	 * @param shootOff1s the shoot off1s of this e s f result
	 */
	public void setShootOff1s(int shootOff1s);

	/**
	 * Returns the shoot off2s of this e s f result.
	 *
	 * @return the shoot off2s of this e s f result
	 */
	public int getShootOff2s();

	/**
	 * Sets the shoot off2s of this e s f result.
	 *
	 * @param shootOff2s the shoot off2s of this e s f result
	 */
	public void setShootOff2s(int shootOff2s);

	/**
	 * Returns the shoot off3s of this e s f result.
	 *
	 * @return the shoot off3s of this e s f result
	 */
	public int getShootOff3s();

	/**
	 * Sets the shoot off3s of this e s f result.
	 *
	 * @param shootOff3s the shoot off3s of this e s f result
	 */
	public void setShootOff3s(int shootOff3s);

	/**
	 * Returns the bronze result of this e s f result.
	 *
	 * @return the bronze result of this e s f result
	 */
	public int getBronzeResult();

	/**
	 * Sets the bronze result of this e s f result.
	 *
	 * @param bronzeResult the bronze result of this e s f result
	 */
	public void setBronzeResult(int bronzeResult);

	/**
	 * Returns the shoot off bronze of this e s f result.
	 *
	 * @return the shoot off bronze of this e s f result
	 */
	public int getShootOffBronze();

	/**
	 * Sets the shoot off bronze of this e s f result.
	 *
	 * @param shootOffBronze the shoot off bronze of this e s f result
	 */
	public void setShootOffBronze(int shootOffBronze);

	/**
	 * Returns the gold result of this e s f result.
	 *
	 * @return the gold result of this e s f result
	 */
	public int getGoldResult();

	/**
	 * Sets the gold result of this e s f result.
	 *
	 * @param goldResult the gold result of this e s f result
	 */
	public void setGoldResult(int goldResult);

	/**
	 * Returns the shoot off gold of this e s f result.
	 *
	 * @return the shoot off gold of this e s f result
	 */
	public int getShootOffGold();

	/**
	 * Sets the shoot off gold of this e s f result.
	 *
	 * @param shootOffGold the shoot off gold of this e s f result
	 */
	public void setShootOffGold(int shootOffGold);

	/**
	 * Returns the team category of this e s f result.
	 *
	 * @return the team category of this e s f result
	 */
	@AutoEscape
	public String getTeamCategory();

	/**
	 * Sets the team category of this e s f result.
	 *
	 * @param teamCategory the team category of this e s f result
	 */
	public void setTeamCategory(String teamCategory);

	/**
	 * Returns the team name of this e s f result.
	 *
	 * @return the team name of this e s f result
	 */
	@AutoEscape
	public String getTeamName();

	/**
	 * Sets the team name of this e s f result.
	 *
	 * @param teamName the team name of this e s f result
	 */
	public void setTeamName(String teamName);

	/**
	 * Returns the naz_int of this e s f result.
	 *
	 * @return the naz_int of this e s f result
	 */
	@AutoEscape
	public String getNaz_int();

	/**
	 * Sets the naz_int of this e s f result.
	 *
	 * @param naz_int the naz_int of this e s f result
	 */
	public void setNaz_int(String naz_int);

	/**
	 * Returns the show type code of this e s f result.
	 *
	 * @return the show type code of this e s f result
	 */
	public int getShowTypeCode();

	/**
	 * Sets the show type code of this e s f result.
	 *
	 * @param showTypeCode the show type code of this e s f result
	 */
	public void setShowTypeCode(int showTypeCode);

	/**
	 * Returns the show type of this e s f result.
	 *
	 * @return the show type of this e s f result
	 */
	@AutoEscape
	public String getShowType();

	/**
	 * Sets the show type of this e s f result.
	 *
	 * @param showType the show type of this e s f result
	 */
	public void setShowType(String showType);

	/**
	 * Returns the esf user ID of this e s f result.
	 *
	 * @return the esf user ID of this e s f result
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f result.
	 *
	 * @param esfUserId the esf user ID of this e s f result
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f result.
	 *
	 * @return the esf user uuid of this e s f result
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f result.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f result
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the variation date of this e s f result.
	 *
	 * @return the variation date of this e s f result
	 */
	public Date getVariationDate();

	/**
	 * Sets the variation date of this e s f result.
	 *
	 * @param variationDate the variation date of this e s f result
	 */
	public void setVariationDate(Date variationDate);

	/**
	 * Returns the sent of this e s f result.
	 *
	 * @return the sent of this e s f result
	 */
	public int getSent();

	/**
	 * Sets the sent of this e s f result.
	 *
	 * @param sent the sent of this e s f result
	 */
	public void setSent(int sent);

	/**
	 * Returns the youth qualification of this e s f result.
	 *
	 * @return the youth qualification of this e s f result
	 */
	@AutoEscape
	public String getYouthQualification();

	/**
	 * Sets the youth qualification of this e s f result.
	 *
	 * @param youthQualification the youth qualification of this e s f result
	 */
	public void setYouthQualification(String youthQualification);

	/**
	 * Returns the esf match type ID of this e s f result.
	 *
	 * @return the esf match type ID of this e s f result
	 */
	public long getEsfMatchTypeId();

	/**
	 * Sets the esf match type ID of this e s f result.
	 *
	 * @param esfMatchTypeId the esf match type ID of this e s f result
	 */
	public void setEsfMatchTypeId(long esfMatchTypeId);

	/**
	 * Returns the result class team of this e s f result.
	 *
	 * @return the result class team of this e s f result
	 */
	public int getResultClassTeam();

	/**
	 * Sets the result class team of this e s f result.
	 *
	 * @param resultClassTeam the result class team of this e s f result
	 */
	public void setResultClassTeam(int resultClassTeam);

	/**
	 * Returns the spare1 of this e s f result.
	 *
	 * @return the spare1 of this e s f result
	 */
	public int getSpare1();

	/**
	 * Sets the spare1 of this e s f result.
	 *
	 * @param spare1 the spare1 of this e s f result
	 */
	public void setSpare1(int spare1);

	/**
	 * Returns the spare2 of this e s f result.
	 *
	 * @return the spare2 of this e s f result
	 */
	public int getSpare2();

	/**
	 * Sets the spare2 of this e s f result.
	 *
	 * @param spare2 the spare2 of this e s f result
	 */
	public void setSpare2(int spare2);

	/**
	 * Returns the shooter code of this e s f result.
	 *
	 * @return the shooter code of this e s f result
	 */
	public long getShooterCode();

	/**
	 * Sets the shooter code of this e s f result.
	 *
	 * @param shooterCode the shooter code of this e s f result
	 */
	public void setShooterCode(long shooterCode);

	/**
	 * Returns the shooter qualification of this e s f result.
	 *
	 * @return the shooter qualification of this e s f result
	 */
	public long getShooterQualification();

	/**
	 * Sets the shooter qualification of this e s f result.
	 *
	 * @param shooterQualification the shooter qualification of this e s f result
	 */
	public void setShooterQualification(long shooterQualification);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ESFResult esfResult);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFResult> toCacheModel();

	@Override
	public ESFResult toEscapedModel();

	@Override
	public ESFResult toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}