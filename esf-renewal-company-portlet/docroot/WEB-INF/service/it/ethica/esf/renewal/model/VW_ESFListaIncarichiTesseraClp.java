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

package it.ethica.esf.renewal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.renewal.service.ClpSerializer;
import it.ethica.esf.renewal.service.VW_ESFListaIncarichiTesseraLocalServiceUtil;
import it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class VW_ESFListaIncarichiTesseraClp extends BaseModelImpl<VW_ESFListaIncarichiTessera>
	implements VW_ESFListaIncarichiTessera {
	public VW_ESFListaIncarichiTesseraClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VW_ESFListaIncarichiTessera.class;
	}

	@Override
	public String getModelClassName() {
		return VW_ESFListaIncarichiTessera.class.getName();
	}

	@Override
	public VW_ESFListaIncarichiTesseraPK getPrimaryKey() {
		return new VW_ESFListaIncarichiTesseraPK(_AnniPrecedenti,
			_AnnoFineIncarico, _AnnoInizioIncarico, _AnnoCorrente, _NomeRuolo,
			_startDate, _esfUserId, _esfOrganizationId, _lastName, _firstName);
	}

	@Override
	public void setPrimaryKey(VW_ESFListaIncarichiTesseraPK primaryKey) {
		setAnniPrecedenti(primaryKey.AnniPrecedenti);
		setAnnoFineIncarico(primaryKey.AnnoFineIncarico);
		setAnnoInizioIncarico(primaryKey.AnnoInizioIncarico);
		setAnnoCorrente(primaryKey.AnnoCorrente);
		setNomeRuolo(primaryKey.NomeRuolo);
		setStartDate(primaryKey.startDate);
		setEsfUserId(primaryKey.esfUserId);
		setEsfOrganizationId(primaryKey.esfOrganizationId);
		setLastName(primaryKey.lastName);
		setFirstName(primaryKey.firstName);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VW_ESFListaIncarichiTesseraPK(_AnniPrecedenti,
			_AnnoFineIncarico, _AnnoInizioIncarico, _AnnoCorrente, _NomeRuolo,
			_startDate, _esfUserId, _esfOrganizationId, _lastName, _firstName);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VW_ESFListaIncarichiTesseraPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("AnniPrecedenti", getAnniPrecedenti());
		attributes.put("AnnoFineIncarico", getAnnoFineIncarico());
		attributes.put("AnnoInizioIncarico", getAnnoInizioIncarico());
		attributes.put("AnnoCorrente", getAnnoCorrente());
		attributes.put("NomeRuolo", getNomeRuolo());
		attributes.put("endDate", getEndDate());
		attributes.put("startDate", getStartDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("lastName", getLastName());
		attributes.put("firstName", getFirstName());
		attributes.put("CodiceTessera", getCodiceTessera());
		attributes.put("DataTesseramento", getDataTesseramento());
		attributes.put("CodiceFiscale", getCodiceFiscale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer AnniPrecedenti = (Integer)attributes.get("AnniPrecedenti");

		if (AnniPrecedenti != null) {
			setAnniPrecedenti(AnniPrecedenti);
		}

		Integer AnnoFineIncarico = (Integer)attributes.get("AnnoFineIncarico");

		if (AnnoFineIncarico != null) {
			setAnnoFineIncarico(AnnoFineIncarico);
		}

		Integer AnnoInizioIncarico = (Integer)attributes.get(
				"AnnoInizioIncarico");

		if (AnnoInizioIncarico != null) {
			setAnnoInizioIncarico(AnnoInizioIncarico);
		}

		Integer AnnoCorrente = (Integer)attributes.get("AnnoCorrente");

		if (AnnoCorrente != null) {
			setAnnoCorrente(AnnoCorrente);
		}

		String NomeRuolo = (String)attributes.get("NomeRuolo");

		if (NomeRuolo != null) {
			setNomeRuolo(NomeRuolo);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String CodiceTessera = (String)attributes.get("CodiceTessera");

		if (CodiceTessera != null) {
			setCodiceTessera(CodiceTessera);
		}

		Date DataTesseramento = (Date)attributes.get("DataTesseramento");

		if (DataTesseramento != null) {
			setDataTesseramento(DataTesseramento);
		}

		String CodiceFiscale = (String)attributes.get("CodiceFiscale");

		if (CodiceFiscale != null) {
			setCodiceFiscale(CodiceFiscale);
		}
	}

	@Override
	public int getAnniPrecedenti() {
		return _AnniPrecedenti;
	}

	@Override
	public void setAnniPrecedenti(int AnniPrecedenti) {
		_AnniPrecedenti = AnniPrecedenti;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setAnniPrecedenti", int.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					AnniPrecedenti);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAnnoFineIncarico() {
		return _AnnoFineIncarico;
	}

	@Override
	public void setAnnoFineIncarico(int AnnoFineIncarico) {
		_AnnoFineIncarico = AnnoFineIncarico;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setAnnoFineIncarico", int.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					AnnoFineIncarico);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAnnoInizioIncarico() {
		return _AnnoInizioIncarico;
	}

	@Override
	public void setAnnoInizioIncarico(int AnnoInizioIncarico) {
		_AnnoInizioIncarico = AnnoInizioIncarico;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setAnnoInizioIncarico",
						int.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					AnnoInizioIncarico);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAnnoCorrente() {
		return _AnnoCorrente;
	}

	@Override
	public void setAnnoCorrente(int AnnoCorrente) {
		_AnnoCorrente = AnnoCorrente;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setAnnoCorrente", int.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					AnnoCorrente);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeRuolo() {
		return _NomeRuolo;
	}

	@Override
	public void setNomeRuolo(String NomeRuolo) {
		_NomeRuolo = NomeRuolo;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeRuolo", String.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel, NomeRuolo);
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

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel, startDate);
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

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel, esfUserId);
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
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceTessera() {
		return _CodiceTessera;
	}

	@Override
	public void setCodiceTessera(String CodiceTessera) {
		_CodiceTessera = CodiceTessera;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceTessera", String.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					CodiceTessera);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataTesseramento() {
		return _DataTesseramento;
	}

	@Override
	public void setDataTesseramento(Date DataTesseramento) {
		_DataTesseramento = DataTesseramento;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setDataTesseramento",
						Date.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					DataTesseramento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceFiscale() {
		return _CodiceFiscale;
	}

	@Override
	public void setCodiceFiscale(String CodiceFiscale) {
		_CodiceFiscale = CodiceFiscale;

		if (_vw_esfListaIncarichiTesseraRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceFiscale", String.class);

				method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
					CodiceFiscale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVW_ESFListaIncarichiTesseraRemoteModel() {
		return _vw_esfListaIncarichiTesseraRemoteModel;
	}

	public void setVW_ESFListaIncarichiTesseraRemoteModel(
		BaseModel<?> vw_esfListaIncarichiTesseraRemoteModel) {
		_vw_esfListaIncarichiTesseraRemoteModel = vw_esfListaIncarichiTesseraRemoteModel;
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

		Class<?> remoteModelClass = _vw_esfListaIncarichiTesseraRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_esfListaIncarichiTesseraRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VW_ESFListaIncarichiTesseraLocalServiceUtil.addVW_ESFListaIncarichiTessera(this);
		}
		else {
			VW_ESFListaIncarichiTesseraLocalServiceUtil.updateVW_ESFListaIncarichiTessera(this);
		}
	}

	@Override
	public VW_ESFListaIncarichiTessera toEscapedModel() {
		return (VW_ESFListaIncarichiTessera)ProxyUtil.newProxyInstance(VW_ESFListaIncarichiTessera.class.getClassLoader(),
			new Class[] { VW_ESFListaIncarichiTessera.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VW_ESFListaIncarichiTesseraClp clone = new VW_ESFListaIncarichiTesseraClp();

		clone.setAnniPrecedenti(getAnniPrecedenti());
		clone.setAnnoFineIncarico(getAnnoFineIncarico());
		clone.setAnnoInizioIncarico(getAnnoInizioIncarico());
		clone.setAnnoCorrente(getAnnoCorrente());
		clone.setNomeRuolo(getNomeRuolo());
		clone.setEndDate(getEndDate());
		clone.setStartDate(getStartDate());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setLastName(getLastName());
		clone.setFirstName(getFirstName());
		clone.setCodiceTessera(getCodiceTessera());
		clone.setDataTesseramento(getDataTesseramento());
		clone.setCodiceFiscale(getCodiceFiscale());

		return clone;
	}

	@Override
	public int compareTo(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		int value = 0;

		value = DateUtil.compareTo(getEndDate(),
				vw_esfListaIncarichiTessera.getEndDate());

		if (value != 0) {
			return value;
		}

		if (getEsfUserId() < vw_esfListaIncarichiTessera.getEsfUserId()) {
			value = -1;
		}
		else if (getEsfUserId() > vw_esfListaIncarichiTessera.getEsfUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof VW_ESFListaIncarichiTesseraClp)) {
			return false;
		}

		VW_ESFListaIncarichiTesseraClp vw_esfListaIncarichiTessera = (VW_ESFListaIncarichiTesseraClp)obj;

		VW_ESFListaIncarichiTesseraPK primaryKey = vw_esfListaIncarichiTessera.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{AnniPrecedenti=");
		sb.append(getAnniPrecedenti());
		sb.append(", AnnoFineIncarico=");
		sb.append(getAnnoFineIncarico());
		sb.append(", AnnoInizioIncarico=");
		sb.append(getAnnoInizioIncarico());
		sb.append(", AnnoCorrente=");
		sb.append(getAnnoCorrente());
		sb.append(", NomeRuolo=");
		sb.append(getNomeRuolo());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", CodiceTessera=");
		sb.append(getCodiceTessera());
		sb.append(", DataTesseramento=");
		sb.append(getDataTesseramento());
		sb.append(", CodiceFiscale=");
		sb.append(getCodiceFiscale());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>AnniPrecedenti</column-name><column-value><![CDATA[");
		sb.append(getAnniPrecedenti());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AnnoFineIncarico</column-name><column-value><![CDATA[");
		sb.append(getAnnoFineIncarico());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AnnoInizioIncarico</column-name><column-value><![CDATA[");
		sb.append(getAnnoInizioIncarico());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AnnoCorrente</column-name><column-value><![CDATA[");
		sb.append(getAnnoCorrente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NomeRuolo</column-name><column-value><![CDATA[");
		sb.append(getNomeRuolo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CodiceTessera</column-name><column-value><![CDATA[");
		sb.append(getCodiceTessera());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DataTesseramento</column-name><column-value><![CDATA[");
		sb.append(getDataTesseramento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CodiceFiscale</column-name><column-value><![CDATA[");
		sb.append(getCodiceFiscale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _AnniPrecedenti;
	private int _AnnoFineIncarico;
	private int _AnnoInizioIncarico;
	private int _AnnoCorrente;
	private String _NomeRuolo;
	private Date _endDate;
	private Date _startDate;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfOrganizationId;
	private String _lastName;
	private String _firstName;
	private String _CodiceTessera;
	private Date _DataTesseramento;
	private String _CodiceFiscale;
	private BaseModel<?> _vw_esfListaIncarichiTesseraRemoteModel;
}