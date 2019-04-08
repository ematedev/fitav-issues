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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFResult;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFResult in entity cache.
 *
 * @author Ethica
 * @see ESFResult
 * @generated
 */
public class ESFResultCacheModel implements CacheModel<ESFResult>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(133);

		sb.append("{esfResultId=");
		sb.append(esfResultId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", matchYear=");
		sb.append(matchYear);
		sb.append(", numberMatch=");
		sb.append(numberMatch);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", name2=");
		sb.append(name2);
		sb.append(", esfAssociationId=");
		sb.append(esfAssociationId);
		sb.append(", sportTypeCode=");
		sb.append(sportTypeCode);
		sb.append(", startdDate=");
		sb.append(startdDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", groupRanking=");
		sb.append(groupRanking);
		sb.append(", descGroupRanking=");
		sb.append(descGroupRanking);
		sb.append(", position=");
		sb.append(position);
		sb.append(", cardNumber=");
		sb.append(cardNumber);
		sb.append(", shooterName=");
		sb.append(shooterName);
		sb.append(", nationCode=");
		sb.append(nationCode);
		sb.append(", category=");
		sb.append(category);
		sb.append(", qualificationCode=");
		sb.append(qualificationCode);
		sb.append(", resultS1=");
		sb.append(resultS1);
		sb.append(", resultS2=");
		sb.append(resultS2);
		sb.append(", resultS3=");
		sb.append(resultS3);
		sb.append(", resultS4=");
		sb.append(resultS4);
		sb.append(", resultS5=");
		sb.append(resultS5);
		sb.append(", resultS6=");
		sb.append(resultS6);
		sb.append(", resultS7=");
		sb.append(resultS7);
		sb.append(", resultS8=");
		sb.append(resultS8);
		sb.append(", totalS=");
		sb.append(totalS);
		sb.append(", barrage=");
		sb.append(barrage);
		sb.append(", finalS=");
		sb.append(finalS);
		sb.append(", finalTotal=");
		sb.append(finalTotal);
		sb.append(", american1=");
		sb.append(american1);
		sb.append(", american2=");
		sb.append(american2);
		sb.append(", american3=");
		sb.append(american3);
		sb.append(", rifle=");
		sb.append(rifle);
		sb.append(", caliber=");
		sb.append(caliber);
		sb.append(", catridge=");
		sb.append(catridge);
		sb.append(", finalType=");
		sb.append(finalType);
		sb.append(", semifinalResult=");
		sb.append(semifinalResult);
		sb.append(", shootOff1s=");
		sb.append(shootOff1s);
		sb.append(", shootOff2s=");
		sb.append(shootOff2s);
		sb.append(", shootOff3s=");
		sb.append(shootOff3s);
		sb.append(", bronzeResult=");
		sb.append(bronzeResult);
		sb.append(", shootOffBronze=");
		sb.append(shootOffBronze);
		sb.append(", goldResult=");
		sb.append(goldResult);
		sb.append(", shootOffGold=");
		sb.append(shootOffGold);
		sb.append(", teamCategory=");
		sb.append(teamCategory);
		sb.append(", teamName=");
		sb.append(teamName);
		sb.append(", naz_int=");
		sb.append(naz_int);
		sb.append(", showTypeCode=");
		sb.append(showTypeCode);
		sb.append(", showType=");
		sb.append(showType);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", variationDate=");
		sb.append(variationDate);
		sb.append(", sent=");
		sb.append(sent);
		sb.append(", youthQualification=");
		sb.append(youthQualification);
		sb.append(", esfMatchTypeId=");
		sb.append(esfMatchTypeId);
		sb.append(", resultClassTeam=");
		sb.append(resultClassTeam);
		sb.append(", spare1=");
		sb.append(spare1);
		sb.append(", spare2=");
		sb.append(spare2);
		sb.append(", shooterCode=");
		sb.append(shooterCode);
		sb.append(", shooterQualification=");
		sb.append(shooterQualification);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFResult toEntityModel() {
		ESFResultImpl esfResultImpl = new ESFResultImpl();

		esfResultImpl.setEsfResultId(esfResultId);
		esfResultImpl.setGroupId(groupId);
		esfResultImpl.setCompanyId(companyId);
		esfResultImpl.setUserId(userId);

		if (userName == null) {
			esfResultImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfResultImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfResultImpl.setCreateDate(null);
		}
		else {
			esfResultImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfResultImpl.setModifiedDate(null);
		}
		else {
			esfResultImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfResultImpl.setMatchYear(matchYear);
		esfResultImpl.setNumberMatch(numberMatch);
		esfResultImpl.setEsfMatchId(esfMatchId);

		if (name == null) {
			esfResultImpl.setName(StringPool.BLANK);
		}
		else {
			esfResultImpl.setName(name);
		}

		if (name2 == null) {
			esfResultImpl.setName2(StringPool.BLANK);
		}
		else {
			esfResultImpl.setName2(name2);
		}

		esfResultImpl.setEsfAssociationId(esfAssociationId);

		if (sportTypeCode == null) {
			esfResultImpl.setSportTypeCode(StringPool.BLANK);
		}
		else {
			esfResultImpl.setSportTypeCode(sportTypeCode);
		}

		if (startdDate == Long.MIN_VALUE) {
			esfResultImpl.setStartdDate(null);
		}
		else {
			esfResultImpl.setStartdDate(new Date(startdDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfResultImpl.setEndDate(null);
		}
		else {
			esfResultImpl.setEndDate(new Date(endDate));
		}

		if (groupRanking == null) {
			esfResultImpl.setGroupRanking(StringPool.BLANK);
		}
		else {
			esfResultImpl.setGroupRanking(groupRanking);
		}

		if (descGroupRanking == null) {
			esfResultImpl.setDescGroupRanking(StringPool.BLANK);
		}
		else {
			esfResultImpl.setDescGroupRanking(descGroupRanking);
		}

		esfResultImpl.setPosition(position);

		if (cardNumber == null) {
			esfResultImpl.setCardNumber(StringPool.BLANK);
		}
		else {
			esfResultImpl.setCardNumber(cardNumber);
		}

		if (shooterName == null) {
			esfResultImpl.setShooterName(StringPool.BLANK);
		}
		else {
			esfResultImpl.setShooterName(shooterName);
		}

		if (nationCode == null) {
			esfResultImpl.setNationCode(StringPool.BLANK);
		}
		else {
			esfResultImpl.setNationCode(nationCode);
		}

		if (category == null) {
			esfResultImpl.setCategory(StringPool.BLANK);
		}
		else {
			esfResultImpl.setCategory(category);
		}

		if (qualificationCode == null) {
			esfResultImpl.setQualificationCode(StringPool.BLANK);
		}
		else {
			esfResultImpl.setQualificationCode(qualificationCode);
		}

		esfResultImpl.setResultS1(resultS1);
		esfResultImpl.setResultS2(resultS2);
		esfResultImpl.setResultS3(resultS3);
		esfResultImpl.setResultS4(resultS4);
		esfResultImpl.setResultS5(resultS5);
		esfResultImpl.setResultS6(resultS6);
		esfResultImpl.setResultS7(resultS7);
		esfResultImpl.setResultS8(resultS8);
		esfResultImpl.setTotalS(totalS);
		esfResultImpl.setBarrage(barrage);
		esfResultImpl.setFinalS(finalS);
		esfResultImpl.setFinalTotal(finalTotal);
		esfResultImpl.setAmerican1(american1);
		esfResultImpl.setAmerican2(american2);
		esfResultImpl.setAmerican3(american3);

		if (rifle == null) {
			esfResultImpl.setRifle(StringPool.BLANK);
		}
		else {
			esfResultImpl.setRifle(rifle);
		}

		if (caliber == null) {
			esfResultImpl.setCaliber(StringPool.BLANK);
		}
		else {
			esfResultImpl.setCaliber(caliber);
		}

		if (catridge == null) {
			esfResultImpl.setCatridge(StringPool.BLANK);
		}
		else {
			esfResultImpl.setCatridge(catridge);
		}

		if (finalType == null) {
			esfResultImpl.setFinalType(StringPool.BLANK);
		}
		else {
			esfResultImpl.setFinalType(finalType);
		}

		esfResultImpl.setSemifinalResult(semifinalResult);
		esfResultImpl.setShootOff1s(shootOff1s);
		esfResultImpl.setShootOff2s(shootOff2s);
		esfResultImpl.setShootOff3s(shootOff3s);
		esfResultImpl.setBronzeResult(bronzeResult);
		esfResultImpl.setShootOffBronze(shootOffBronze);
		esfResultImpl.setGoldResult(goldResult);
		esfResultImpl.setShootOffGold(shootOffGold);

		if (teamCategory == null) {
			esfResultImpl.setTeamCategory(StringPool.BLANK);
		}
		else {
			esfResultImpl.setTeamCategory(teamCategory);
		}

		if (teamName == null) {
			esfResultImpl.setTeamName(StringPool.BLANK);
		}
		else {
			esfResultImpl.setTeamName(teamName);
		}

		if (naz_int == null) {
			esfResultImpl.setNaz_int(StringPool.BLANK);
		}
		else {
			esfResultImpl.setNaz_int(naz_int);
		}

		esfResultImpl.setShowTypeCode(showTypeCode);

		if (showType == null) {
			esfResultImpl.setShowType(StringPool.BLANK);
		}
		else {
			esfResultImpl.setShowType(showType);
		}

		esfResultImpl.setEsfUserId(esfUserId);

		if (variationDate == Long.MIN_VALUE) {
			esfResultImpl.setVariationDate(null);
		}
		else {
			esfResultImpl.setVariationDate(new Date(variationDate));
		}

		esfResultImpl.setSent(sent);

		if (youthQualification == null) {
			esfResultImpl.setYouthQualification(StringPool.BLANK);
		}
		else {
			esfResultImpl.setYouthQualification(youthQualification);
		}

		esfResultImpl.setEsfMatchTypeId(esfMatchTypeId);
		esfResultImpl.setResultClassTeam(resultClassTeam);
		esfResultImpl.setSpare1(spare1);
		esfResultImpl.setSpare2(spare2);
		esfResultImpl.setShooterCode(shooterCode);
		esfResultImpl.setShooterQualification(shooterQualification);

		esfResultImpl.resetOriginalValues();

		return esfResultImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfResultId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		matchYear = objectInput.readInt();
		numberMatch = objectInput.readInt();
		esfMatchId = objectInput.readLong();
		name = objectInput.readUTF();
		name2 = objectInput.readUTF();
		esfAssociationId = objectInput.readLong();
		sportTypeCode = objectInput.readUTF();
		startdDate = objectInput.readLong();
		endDate = objectInput.readLong();
		groupRanking = objectInput.readUTF();
		descGroupRanking = objectInput.readUTF();
		position = objectInput.readInt();
		cardNumber = objectInput.readUTF();
		shooterName = objectInput.readUTF();
		nationCode = objectInput.readUTF();
		category = objectInput.readUTF();
		qualificationCode = objectInput.readUTF();
		resultS1 = objectInput.readInt();
		resultS2 = objectInput.readInt();
		resultS3 = objectInput.readInt();
		resultS4 = objectInput.readInt();
		resultS5 = objectInput.readInt();
		resultS6 = objectInput.readInt();
		resultS7 = objectInput.readInt();
		resultS8 = objectInput.readInt();
		totalS = objectInput.readInt();
		barrage = objectInput.readInt();
		finalS = objectInput.readInt();
		finalTotal = objectInput.readInt();
		american1 = objectInput.readInt();
		american2 = objectInput.readInt();
		american3 = objectInput.readInt();
		rifle = objectInput.readUTF();
		caliber = objectInput.readUTF();
		catridge = objectInput.readUTF();
		finalType = objectInput.readUTF();
		semifinalResult = objectInput.readInt();
		shootOff1s = objectInput.readInt();
		shootOff2s = objectInput.readInt();
		shootOff3s = objectInput.readInt();
		bronzeResult = objectInput.readInt();
		shootOffBronze = objectInput.readInt();
		goldResult = objectInput.readInt();
		shootOffGold = objectInput.readInt();
		teamCategory = objectInput.readUTF();
		teamName = objectInput.readUTF();
		naz_int = objectInput.readUTF();
		showTypeCode = objectInput.readInt();
		showType = objectInput.readUTF();
		esfUserId = objectInput.readLong();
		variationDate = objectInput.readLong();
		sent = objectInput.readInt();
		youthQualification = objectInput.readUTF();
		esfMatchTypeId = objectInput.readLong();
		resultClassTeam = objectInput.readInt();
		spare1 = objectInput.readInt();
		spare2 = objectInput.readInt();
		shooterCode = objectInput.readLong();
		shooterQualification = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfResultId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(matchYear);
		objectOutput.writeInt(numberMatch);
		objectOutput.writeLong(esfMatchId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (name2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name2);
		}

		objectOutput.writeLong(esfAssociationId);

		if (sportTypeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sportTypeCode);
		}

		objectOutput.writeLong(startdDate);
		objectOutput.writeLong(endDate);

		if (groupRanking == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupRanking);
		}

		if (descGroupRanking == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descGroupRanking);
		}

		objectOutput.writeInt(position);

		if (cardNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cardNumber);
		}

		if (shooterName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shooterName);
		}

		if (nationCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nationCode);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (qualificationCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qualificationCode);
		}

		objectOutput.writeInt(resultS1);
		objectOutput.writeInt(resultS2);
		objectOutput.writeInt(resultS3);
		objectOutput.writeInt(resultS4);
		objectOutput.writeInt(resultS5);
		objectOutput.writeInt(resultS6);
		objectOutput.writeInt(resultS7);
		objectOutput.writeInt(resultS8);
		objectOutput.writeInt(totalS);
		objectOutput.writeInt(barrage);
		objectOutput.writeInt(finalS);
		objectOutput.writeInt(finalTotal);
		objectOutput.writeInt(american1);
		objectOutput.writeInt(american2);
		objectOutput.writeInt(american3);

		if (rifle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rifle);
		}

		if (caliber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(caliber);
		}

		if (catridge == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(catridge);
		}

		if (finalType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(finalType);
		}

		objectOutput.writeInt(semifinalResult);
		objectOutput.writeInt(shootOff1s);
		objectOutput.writeInt(shootOff2s);
		objectOutput.writeInt(shootOff3s);
		objectOutput.writeInt(bronzeResult);
		objectOutput.writeInt(shootOffBronze);
		objectOutput.writeInt(goldResult);
		objectOutput.writeInt(shootOffGold);

		if (teamCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(teamCategory);
		}

		if (teamName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(teamName);
		}

		if (naz_int == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(naz_int);
		}

		objectOutput.writeInt(showTypeCode);

		if (showType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(showType);
		}

		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(variationDate);
		objectOutput.writeInt(sent);

		if (youthQualification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(youthQualification);
		}

		objectOutput.writeLong(esfMatchTypeId);
		objectOutput.writeInt(resultClassTeam);
		objectOutput.writeInt(spare1);
		objectOutput.writeInt(spare2);
		objectOutput.writeLong(shooterCode);
		objectOutput.writeLong(shooterQualification);
	}

	public long esfResultId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int matchYear;
	public int numberMatch;
	public long esfMatchId;
	public String name;
	public String name2;
	public long esfAssociationId;
	public String sportTypeCode;
	public long startdDate;
	public long endDate;
	public String groupRanking;
	public String descGroupRanking;
	public int position;
	public String cardNumber;
	public String shooterName;
	public String nationCode;
	public String category;
	public String qualificationCode;
	public int resultS1;
	public int resultS2;
	public int resultS3;
	public int resultS4;
	public int resultS5;
	public int resultS6;
	public int resultS7;
	public int resultS8;
	public int totalS;
	public int barrage;
	public int finalS;
	public int finalTotal;
	public int american1;
	public int american2;
	public int american3;
	public String rifle;
	public String caliber;
	public String catridge;
	public String finalType;
	public int semifinalResult;
	public int shootOff1s;
	public int shootOff2s;
	public int shootOff3s;
	public int bronzeResult;
	public int shootOffBronze;
	public int goldResult;
	public int shootOffGold;
	public String teamCategory;
	public String teamName;
	public String naz_int;
	public int showTypeCode;
	public String showType;
	public long esfUserId;
	public long variationDate;
	public int sent;
	public String youthQualification;
	public long esfMatchTypeId;
	public int resultClassTeam;
	public int spare1;
	public int spare2;
	public long shooterCode;
	public long shooterQualification;
}