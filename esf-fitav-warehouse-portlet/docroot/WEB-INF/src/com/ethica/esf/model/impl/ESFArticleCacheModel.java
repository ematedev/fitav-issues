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

import com.ethica.esf.model.ESFArticle;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFArticle in entity cache.
 *
 * @author Ethica
 * @see ESFArticle
 * @generated
 */
public class ESFArticleCacheModel implements CacheModel<ESFArticle>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{esfArticleId=");
		sb.append(esfArticleId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", xxxlQty=");
		sb.append(xxxlQty);
		sb.append(", xxlQty=");
		sb.append(xxlQty);
		sb.append(", xlQty=");
		sb.append(xlQty);
		sb.append(", lQty=");
		sb.append(lQty);
		sb.append(", mQty=");
		sb.append(mQty);
		sb.append(", sQty=");
		sb.append(sQty);
		sb.append(", xsQty=");
		sb.append(xsQty);
		sb.append(", xxsQty=");
		sb.append(xxsQty);
		sb.append(", otherQty=");
		sb.append(otherQty);
		sb.append(", totalQty=");
		sb.append(totalQty);
		sb.append(", disabled=");
		sb.append(disabled);
		sb.append(", esfArticleTypeId=");
		sb.append(esfArticleTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFArticle toEntityModel() {
		ESFArticleImpl esfArticleImpl = new ESFArticleImpl();

		esfArticleImpl.setEsfArticleId(esfArticleId);

		if (code == null) {
			esfArticleImpl.setCode(StringPool.BLANK);
		}
		else {
			esfArticleImpl.setCode(code);
		}

		if (name == null) {
			esfArticleImpl.setName(StringPool.BLANK);
		}
		else {
			esfArticleImpl.setName(name);
		}

		if (description == null) {
			esfArticleImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfArticleImpl.setDescription(description);
		}

		esfArticleImpl.setXxxlQty(xxxlQty);
		esfArticleImpl.setXxlQty(xxlQty);
		esfArticleImpl.setXlQty(xlQty);
		esfArticleImpl.setLQty(lQty);
		esfArticleImpl.setMQty(mQty);
		esfArticleImpl.setSQty(sQty);
		esfArticleImpl.setXsQty(xsQty);
		esfArticleImpl.setXxsQty(xxsQty);
		esfArticleImpl.setOtherQty(otherQty);
		esfArticleImpl.setTotalQty(totalQty);
		esfArticleImpl.setDisabled(disabled);
		esfArticleImpl.setEsfArticleTypeId(esfArticleTypeId);

		esfArticleImpl.resetOriginalValues();

		return esfArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfArticleId = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		xxxlQty = objectInput.readLong();
		xxlQty = objectInput.readLong();
		xlQty = objectInput.readLong();
		lQty = objectInput.readLong();
		mQty = objectInput.readLong();
		sQty = objectInput.readLong();
		xsQty = objectInput.readLong();
		xxsQty = objectInput.readLong();
		otherQty = objectInput.readLong();
		totalQty = objectInput.readLong();
		disabled = objectInput.readBoolean();
		esfArticleTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfArticleId);

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

		objectOutput.writeLong(xxxlQty);
		objectOutput.writeLong(xxlQty);
		objectOutput.writeLong(xlQty);
		objectOutput.writeLong(lQty);
		objectOutput.writeLong(mQty);
		objectOutput.writeLong(sQty);
		objectOutput.writeLong(xsQty);
		objectOutput.writeLong(xxsQty);
		objectOutput.writeLong(otherQty);
		objectOutput.writeLong(totalQty);
		objectOutput.writeBoolean(disabled);
		objectOutput.writeLong(esfArticleTypeId);
	}

	public long esfArticleId;
	public String code;
	public String name;
	public String description;
	public long xxxlQty;
	public long xxlQty;
	public long xlQty;
	public long lQty;
	public long mQty;
	public long sQty;
	public long xsQty;
	public long xxsQty;
	public long otherQty;
	public long totalQty;
	public boolean disabled;
	public long esfArticleTypeId;
}