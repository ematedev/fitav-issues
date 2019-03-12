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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFAnnualConiReport;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFAnnualConiReport in entity cache.
 *
 * @author Ethica
 * @see ESFAnnualConiReport
 * @generated
 */
public class ESFAnnualConiReportCacheModel implements CacheModel<ESFAnnualConiReport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{annualConiReportId=");
		sb.append(annualConiReportId);
		sb.append(", assId=");
		sb.append(assId);
		sb.append(", year=");
		sb.append(year);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFAnnualConiReport toEntityModel() {
		ESFAnnualConiReportImpl esfAnnualConiReportImpl = new ESFAnnualConiReportImpl();

		esfAnnualConiReportImpl.setAnnualConiReportId(annualConiReportId);
		esfAnnualConiReportImpl.setAssId(assId);
		esfAnnualConiReportImpl.setYear(year);

		esfAnnualConiReportImpl.resetOriginalValues();

		return esfAnnualConiReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		annualConiReportId = objectInput.readLong();
		assId = objectInput.readLong();
		year = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(annualConiReportId);
		objectOutput.writeLong(assId);
		objectOutput.writeInt(year);
	}

	public long annualConiReportId;
	public long assId;
	public int year;
}