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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFAnnualConiReportSoap implements Serializable {
	public static ESFAnnualConiReportSoap toSoapModel(ESFAnnualConiReport model) {
		ESFAnnualConiReportSoap soapModel = new ESFAnnualConiReportSoap();

		soapModel.setAnnualConiReportId(model.getAnnualConiReportId());
		soapModel.setAssId(model.getAssId());
		soapModel.setYear(model.getYear());

		return soapModel;
	}

	public static ESFAnnualConiReportSoap[] toSoapModels(
		ESFAnnualConiReport[] models) {
		ESFAnnualConiReportSoap[] soapModels = new ESFAnnualConiReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFAnnualConiReportSoap[][] toSoapModels(
		ESFAnnualConiReport[][] models) {
		ESFAnnualConiReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFAnnualConiReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFAnnualConiReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFAnnualConiReportSoap[] toSoapModels(
		List<ESFAnnualConiReport> models) {
		List<ESFAnnualConiReportSoap> soapModels = new ArrayList<ESFAnnualConiReportSoap>(models.size());

		for (ESFAnnualConiReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFAnnualConiReportSoap[soapModels.size()]);
	}

	public ESFAnnualConiReportSoap() {
	}

	public long getPrimaryKey() {
		return _annualConiReportId;
	}

	public void setPrimaryKey(long pk) {
		setAnnualConiReportId(pk);
	}

	public long getAnnualConiReportId() {
		return _annualConiReportId;
	}

	public void setAnnualConiReportId(long annualConiReportId) {
		_annualConiReportId = annualConiReportId;
	}

	public long getAssId() {
		return _assId;
	}

	public void setAssId(long assId) {
		_assId = assId;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	private long _annualConiReportId;
	private long _assId;
	private int _year;
}