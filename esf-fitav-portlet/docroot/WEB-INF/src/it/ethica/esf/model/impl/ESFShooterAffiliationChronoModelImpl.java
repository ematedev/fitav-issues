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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.ESFShooterAffiliationChronoModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFShooterAffiliationChrono service. Represents a row in the &quot;ESFShooterAffiliationChrono&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFShooterAffiliationChronoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFShooterAffiliationChronoImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterAffiliationChronoImpl
 * @see it.ethica.esf.model.ESFShooterAffiliationChrono
 * @see it.ethica.esf.model.ESFShooterAffiliationChronoModel
 * @generated
 */
@JSON(strict = true)
public class ESFShooterAffiliationChronoModelImpl extends BaseModelImpl<ESFShooterAffiliationChrono>
	implements ESFShooterAffiliationChronoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f shooter affiliation chrono model instance should use the {@link it.ethica.esf.model.ESFShooterAffiliationChrono} interface instead.
	 */
	public static final String TABLE_NAME = "ESFShooterAffiliationChrono";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfShooterAffiliationChronoId", Types.BIGINT },
			{ "esfuserId", Types.BIGINT },
			{ "affiliationDate", Types.TIMESTAMP },
			{ "year", Types.INTEGER },
			{ "Vcampo", Types.VARCHAR },
			{ "paymentDate", Types.TIMESTAMP },
			{ "payment", Types.VARCHAR },
			{ "card", Types.VARCHAR },
			{ "esfOrganization", Types.VARCHAR },
			{ "note", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFShooterAffiliationChrono (esfShooterAffiliationChronoId LONG not null primary key,esfuserId LONG,affiliationDate DATE null,year INTEGER,Vcampo VARCHAR(75) null,paymentDate DATE null,payment VARCHAR(75) null,card VARCHAR(75) null,esfOrganization VARCHAR(75) null,note VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFShooterAffiliationChrono";
	public static final String ORDER_BY_JPQL = " ORDER BY esfShooterAffiliationChrono.esfShooterAffiliationChronoId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFShooterAffiliationChrono.esfShooterAffiliationChronoId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFShooterAffiliationChrono"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFShooterAffiliationChrono"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFShooterAffiliationChrono"),
			true);
	public static long AFFILIATIONDATE_COLUMN_BITMASK = 1L;
	public static long CARD_COLUMN_BITMASK = 2L;
	public static long ESFUSERID_COLUMN_BITMASK = 4L;
	public static long YEAR_COLUMN_BITMASK = 8L;
	public static long ESFSHOOTERAFFILIATIONCHRONOID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFShooterAffiliationChrono"));

	public ESFShooterAffiliationChronoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfShooterAffiliationChronoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfShooterAffiliationChronoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfShooterAffiliationChronoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterAffiliationChrono.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterAffiliationChrono.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShooterAffiliationChronoId",
			getEsfShooterAffiliationChronoId());
		attributes.put("esfuserId", getEsfuserId());
		attributes.put("affiliationDate", getAffiliationDate());
		attributes.put("year", getYear());
		attributes.put("Vcampo", getVcampo());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("payment", getPayment());
		attributes.put("card", getCard());
		attributes.put("esfOrganization", getEsfOrganization());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShooterAffiliationChronoId = (Long)attributes.get(
				"esfShooterAffiliationChronoId");

		if (esfShooterAffiliationChronoId != null) {
			setEsfShooterAffiliationChronoId(esfShooterAffiliationChronoId);
		}

		Long esfuserId = (Long)attributes.get("esfuserId");

		if (esfuserId != null) {
			setEsfuserId(esfuserId);
		}

		Date affiliationDate = (Date)attributes.get("affiliationDate");

		if (affiliationDate != null) {
			setAffiliationDate(affiliationDate);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String Vcampo = (String)attributes.get("Vcampo");

		if (Vcampo != null) {
			setVcampo(Vcampo);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		String payment = (String)attributes.get("payment");

		if (payment != null) {
			setPayment(payment);
		}

		String card = (String)attributes.get("card");

		if (card != null) {
			setCard(card);
		}

		String esfOrganization = (String)attributes.get("esfOrganization");

		if (esfOrganization != null) {
			setEsfOrganization(esfOrganization);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@JSON
	@Override
	public long getEsfShooterAffiliationChronoId() {
		return _esfShooterAffiliationChronoId;
	}

	@Override
	public void setEsfShooterAffiliationChronoId(
		long esfShooterAffiliationChronoId) {
		_esfShooterAffiliationChronoId = esfShooterAffiliationChronoId;
	}

	@JSON
	@Override
	public long getEsfuserId() {
		return _esfuserId;
	}

	@Override
	public void setEsfuserId(long esfuserId) {
		_columnBitmask |= ESFUSERID_COLUMN_BITMASK;

		if (!_setOriginalEsfuserId) {
			_setOriginalEsfuserId = true;

			_originalEsfuserId = _esfuserId;
		}

		_esfuserId = esfuserId;
	}

	public long getOriginalEsfuserId() {
		return _originalEsfuserId;
	}

	@JSON
	@Override
	public Date getAffiliationDate() {
		return _affiliationDate;
	}

	@Override
	public void setAffiliationDate(Date affiliationDate) {
		_columnBitmask |= AFFILIATIONDATE_COLUMN_BITMASK;

		if (_originalAffiliationDate == null) {
			_originalAffiliationDate = _affiliationDate;
		}

		_affiliationDate = affiliationDate;
	}

	public Date getOriginalAffiliationDate() {
		return _originalAffiliationDate;
	}

	@JSON
	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_columnBitmask |= YEAR_COLUMN_BITMASK;

		if (!_setOriginalYear) {
			_setOriginalYear = true;

			_originalYear = _year;
		}

		_year = year;
	}

	public int getOriginalYear() {
		return _originalYear;
	}

	@JSON
	@Override
	public String getVcampo() {
		if (_Vcampo == null) {
			return StringPool.BLANK;
		}
		else {
			return _Vcampo;
		}
	}

	@Override
	public void setVcampo(String Vcampo) {
		_Vcampo = Vcampo;
	}

	@JSON
	@Override
	public Date getPaymentDate() {
		return _paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	@JSON
	@Override
	public String getPayment() {
		if (_payment == null) {
			return StringPool.BLANK;
		}
		else {
			return _payment;
		}
	}

	@Override
	public void setPayment(String payment) {
		_payment = payment;
	}

	@JSON
	@Override
	public String getCard() {
		if (_card == null) {
			return StringPool.BLANK;
		}
		else {
			return _card;
		}
	}

	@Override
	public void setCard(String card) {
		_columnBitmask |= CARD_COLUMN_BITMASK;

		if (_originalCard == null) {
			_originalCard = _card;
		}

		_card = card;
	}

	public String getOriginalCard() {
		return GetterUtil.getString(_originalCard);
	}

	@JSON
	@Override
	public String getEsfOrganization() {
		if (_esfOrganization == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfOrganization;
		}
	}

	@Override
	public void setEsfOrganization(String esfOrganization) {
		_esfOrganization = esfOrganization;
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return StringPool.BLANK;
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		_note = note;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFShooterAffiliationChrono.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFShooterAffiliationChrono toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFShooterAffiliationChrono)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFShooterAffiliationChronoImpl esfShooterAffiliationChronoImpl = new ESFShooterAffiliationChronoImpl();

		esfShooterAffiliationChronoImpl.setEsfShooterAffiliationChronoId(getEsfShooterAffiliationChronoId());
		esfShooterAffiliationChronoImpl.setEsfuserId(getEsfuserId());
		esfShooterAffiliationChronoImpl.setAffiliationDate(getAffiliationDate());
		esfShooterAffiliationChronoImpl.setYear(getYear());
		esfShooterAffiliationChronoImpl.setVcampo(getVcampo());
		esfShooterAffiliationChronoImpl.setPaymentDate(getPaymentDate());
		esfShooterAffiliationChronoImpl.setPayment(getPayment());
		esfShooterAffiliationChronoImpl.setCard(getCard());
		esfShooterAffiliationChronoImpl.setEsfOrganization(getEsfOrganization());
		esfShooterAffiliationChronoImpl.setNote(getNote());

		esfShooterAffiliationChronoImpl.resetOriginalValues();

		return esfShooterAffiliationChronoImpl;
	}

	@Override
	public int compareTo(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		long primaryKey = esfShooterAffiliationChrono.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterAffiliationChrono)) {
			return false;
		}

		ESFShooterAffiliationChrono esfShooterAffiliationChrono = (ESFShooterAffiliationChrono)obj;

		long primaryKey = esfShooterAffiliationChrono.getPrimaryKey();

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
	public void resetOriginalValues() {
		ESFShooterAffiliationChronoModelImpl esfShooterAffiliationChronoModelImpl =
			this;

		esfShooterAffiliationChronoModelImpl._originalEsfuserId = esfShooterAffiliationChronoModelImpl._esfuserId;

		esfShooterAffiliationChronoModelImpl._setOriginalEsfuserId = false;

		esfShooterAffiliationChronoModelImpl._originalAffiliationDate = esfShooterAffiliationChronoModelImpl._affiliationDate;

		esfShooterAffiliationChronoModelImpl._originalYear = esfShooterAffiliationChronoModelImpl._year;

		esfShooterAffiliationChronoModelImpl._setOriginalYear = false;

		esfShooterAffiliationChronoModelImpl._originalCard = esfShooterAffiliationChronoModelImpl._card;

		esfShooterAffiliationChronoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFShooterAffiliationChrono> toCacheModel() {
		ESFShooterAffiliationChronoCacheModel esfShooterAffiliationChronoCacheModel =
			new ESFShooterAffiliationChronoCacheModel();

		esfShooterAffiliationChronoCacheModel.esfShooterAffiliationChronoId = getEsfShooterAffiliationChronoId();

		esfShooterAffiliationChronoCacheModel.esfuserId = getEsfuserId();

		Date affiliationDate = getAffiliationDate();

		if (affiliationDate != null) {
			esfShooterAffiliationChronoCacheModel.affiliationDate = affiliationDate.getTime();
		}
		else {
			esfShooterAffiliationChronoCacheModel.affiliationDate = Long.MIN_VALUE;
		}

		esfShooterAffiliationChronoCacheModel.year = getYear();

		esfShooterAffiliationChronoCacheModel.Vcampo = getVcampo();

		String Vcampo = esfShooterAffiliationChronoCacheModel.Vcampo;

		if ((Vcampo != null) && (Vcampo.length() == 0)) {
			esfShooterAffiliationChronoCacheModel.Vcampo = null;
		}

		Date paymentDate = getPaymentDate();

		if (paymentDate != null) {
			esfShooterAffiliationChronoCacheModel.paymentDate = paymentDate.getTime();
		}
		else {
			esfShooterAffiliationChronoCacheModel.paymentDate = Long.MIN_VALUE;
		}

		esfShooterAffiliationChronoCacheModel.payment = getPayment();

		String payment = esfShooterAffiliationChronoCacheModel.payment;

		if ((payment != null) && (payment.length() == 0)) {
			esfShooterAffiliationChronoCacheModel.payment = null;
		}

		esfShooterAffiliationChronoCacheModel.card = getCard();

		String card = esfShooterAffiliationChronoCacheModel.card;

		if ((card != null) && (card.length() == 0)) {
			esfShooterAffiliationChronoCacheModel.card = null;
		}

		esfShooterAffiliationChronoCacheModel.esfOrganization = getEsfOrganization();

		String esfOrganization = esfShooterAffiliationChronoCacheModel.esfOrganization;

		if ((esfOrganization != null) && (esfOrganization.length() == 0)) {
			esfShooterAffiliationChronoCacheModel.esfOrganization = null;
		}

		esfShooterAffiliationChronoCacheModel.note = getNote();

		String note = esfShooterAffiliationChronoCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			esfShooterAffiliationChronoCacheModel.note = null;
		}

		return esfShooterAffiliationChronoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{esfShooterAffiliationChronoId=");
		sb.append(getEsfShooterAffiliationChronoId());
		sb.append(", esfuserId=");
		sb.append(getEsfuserId());
		sb.append(", affiliationDate=");
		sb.append(getAffiliationDate());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", Vcampo=");
		sb.append(getVcampo());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", payment=");
		sb.append(getPayment());
		sb.append(", card=");
		sb.append(getCard());
		sb.append(", esfOrganization=");
		sb.append(getEsfOrganization());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterAffiliationChrono");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfShooterAffiliationChronoId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterAffiliationChronoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfuserId</column-name><column-value><![CDATA[");
		sb.append(getEsfuserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>affiliationDate</column-name><column-value><![CDATA[");
		sb.append(getAffiliationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Vcampo</column-name><column-value><![CDATA[");
		sb.append(getVcampo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payment</column-name><column-value><![CDATA[");
		sb.append(getPayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>card</column-name><column-value><![CDATA[");
		sb.append(getCard());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganization</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganization());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFShooterAffiliationChrono.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFShooterAffiliationChrono.class
		};
	private long _esfShooterAffiliationChronoId;
	private long _esfuserId;
	private long _originalEsfuserId;
	private boolean _setOriginalEsfuserId;
	private Date _affiliationDate;
	private Date _originalAffiliationDate;
	private int _year;
	private int _originalYear;
	private boolean _setOriginalYear;
	private String _Vcampo;
	private Date _paymentDate;
	private String _payment;
	private String _card;
	private String _originalCard;
	private String _esfOrganization;
	private String _note;
	private long _columnBitmask;
	private ESFShooterAffiliationChrono _escapedModel;
}