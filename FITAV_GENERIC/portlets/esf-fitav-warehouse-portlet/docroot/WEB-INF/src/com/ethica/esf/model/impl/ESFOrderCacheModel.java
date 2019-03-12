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

package com.ethica.esf.model.impl;

import com.ethica.esf.model.ESFOrder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrder in entity cache.
 *
 * @author Ethica
 * @see ESFOrder
 * @generated
 */
public class ESFOrderCacheModel implements CacheModel<ESFOrder>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{esfOrderId=");
		sb.append(esfOrderId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", date=");
		sb.append(date);
		sb.append(", note=");
		sb.append(note);
		sb.append(", protocolCode=");
		sb.append(protocolCode);
		sb.append(", attachment=");
		sb.append(attachment);
		sb.append(", state=");
		sb.append(state);
		sb.append(", esfStockistId=");
		sb.append(esfStockistId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFOrder toEntityModel() {
		ESFOrderImpl esfOrderImpl = new ESFOrderImpl();

		esfOrderImpl.setEsfOrderId(esfOrderId);

		if (code == null) {
			esfOrderImpl.setCode(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setCode(code);
		}

		if (name == null) {
			esfOrderImpl.setName(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setName(name);
		}

		if (description == null) {
			esfOrderImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setDescription(description);
		}

		if (date == Long.MIN_VALUE) {
			esfOrderImpl.setDate(null);
		}
		else {
			esfOrderImpl.setDate(new Date(date));
		}

		if (note == null) {
			esfOrderImpl.setNote(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setNote(note);
		}

		if (protocolCode == null) {
			esfOrderImpl.setProtocolCode(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setProtocolCode(protocolCode);
		}

		if (attachment == null) {
			esfOrderImpl.setAttachment(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setAttachment(attachment);
		}

		esfOrderImpl.setState(state);
		esfOrderImpl.setEsfStockistId(esfStockistId);

		esfOrderImpl.resetOriginalValues();

		return esfOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfOrderId = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		date = objectInput.readLong();
		note = objectInput.readUTF();
		protocolCode = objectInput.readUTF();
		attachment = objectInput.readUTF();
		state = objectInput.readInt();
		esfStockistId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfOrderId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(date);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (protocolCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(protocolCode);
		}

		if (attachment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachment);
		}

		objectOutput.writeInt(state);
		objectOutput.writeLong(esfStockistId);
	}

	public long esfOrderId;
	public String code;
	public String name;
	public String description;
	public long date;
	public String note;
	public String protocolCode;
	public String attachment;
	public int state;
	public long esfStockistId;
}