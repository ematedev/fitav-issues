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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.persistence.vw_datidirettoretiroPK;
import it.ethica.esf.service.vw_datidirettoretiroLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class vw_datidirettoretiroClp extends BaseModelImpl<vw_datidirettoretiro>
	implements vw_datidirettoretiro {
	public vw_datidirettoretiroClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return vw_datidirettoretiro.class;
	}

	@Override
	public String getModelClassName() {
		return vw_datidirettoretiro.class.getName();
	}

	@Override
	public vw_datidirettoretiroPK getPrimaryKey() {
		return new vw_datidirettoretiroPK(_esfshootingdirectorid, _nome,
			_cognome, _esfstartdata, _categoryid, _numerotessera, _codiceregione);
	}

	@Override
	public void setPrimaryKey(vw_datidirettoretiroPK primaryKey) {
		setEsfshootingdirectorid(primaryKey.esfshootingdirectorid);
		setNome(primaryKey.nome);
		setCognome(primaryKey.cognome);
		setEsfstartdata(primaryKey.esfstartdata);
		setCategoryid(primaryKey.categoryid);
		setNumerotessera(primaryKey.numerotessera);
		setCodiceregione(primaryKey.codiceregione);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new vw_datidirettoretiroPK(_esfshootingdirectorid, _nome,
			_cognome, _esfstartdata, _categoryid, _numerotessera, _codiceregione);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((vw_datidirettoretiroPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfshootingdirectorid", getEsfshootingdirectorid());
		attributes.put("nome", getNome());
		attributes.put("cognome", getCognome());
		attributes.put("esfstartdata", getEsfstartdata());
		attributes.put("categoryid", getCategoryid());
		attributes.put("numerotessera", getNumerotessera());
		attributes.put("codiceregione", getCodiceregione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfshootingdirectorid = (Long)attributes.get(
				"esfshootingdirectorid");

		if (esfshootingdirectorid != null) {
			setEsfshootingdirectorid(esfshootingdirectorid);
		}

		Long nome = (Long)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		Long cognome = (Long)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		Date esfstartdata = (Date)attributes.get("esfstartdata");

		if (esfstartdata != null) {
			setEsfstartdata(esfstartdata);
		}

		Long categoryid = (Long)attributes.get("categoryid");

		if (categoryid != null) {
			setCategoryid(categoryid);
		}

		Long numerotessera = (Long)attributes.get("numerotessera");

		if (numerotessera != null) {
			setNumerotessera(numerotessera);
		}

		Long codiceregione = (Long)attributes.get("codiceregione");

		if (codiceregione != null) {
			setCodiceregione(codiceregione);
		}
	}

	@Override
	public long getEsfshootingdirectorid() {
		return _esfshootingdirectorid;
	}

	@Override
	public void setEsfshootingdirectorid(long esfshootingdirectorid) {
		_esfshootingdirectorid = esfshootingdirectorid;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfshootingdirectorid",
						long.class);

				method.invoke(_vw_datidirettoretiroRemoteModel,
					esfshootingdirectorid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNome() {
		return _nome;
	}

	@Override
	public void setNome(long nome) {
		_nome = nome;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", long.class);

				method.invoke(_vw_datidirettoretiroRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCognome() {
		return _cognome;
	}

	@Override
	public void setCognome(long cognome) {
		_cognome = cognome;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setCognome", long.class);

				method.invoke(_vw_datidirettoretiroRemoteModel, cognome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfstartdata() {
		return _esfstartdata;
	}

	@Override
	public void setEsfstartdata(Date esfstartdata) {
		_esfstartdata = esfstartdata;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfstartdata", Date.class);

				method.invoke(_vw_datidirettoretiroRemoteModel, esfstartdata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryid() {
		return _categoryid;
	}

	@Override
	public void setCategoryid(long categoryid) {
		_categoryid = categoryid;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryid", long.class);

				method.invoke(_vw_datidirettoretiroRemoteModel, categoryid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumerotessera() {
		return _numerotessera;
	}

	@Override
	public void setNumerotessera(long numerotessera) {
		_numerotessera = numerotessera;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setNumerotessera", long.class);

				method.invoke(_vw_datidirettoretiroRemoteModel, numerotessera);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCodiceregione() {
		return _codiceregione;
	}

	@Override
	public void setCodiceregione(long codiceregione) {
		_codiceregione = codiceregione;

		if (_vw_datidirettoretiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_datidirettoretiroRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceregione", long.class);

				method.invoke(_vw_datidirettoretiroRemoteModel, codiceregione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getvw_datidirettoretiroRemoteModel() {
		return _vw_datidirettoretiroRemoteModel;
	}

	public void setvw_datidirettoretiroRemoteModel(
		BaseModel<?> vw_datidirettoretiroRemoteModel) {
		_vw_datidirettoretiroRemoteModel = vw_datidirettoretiroRemoteModel;
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

		Class<?> remoteModelClass = _vw_datidirettoretiroRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_datidirettoretiroRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			vw_datidirettoretiroLocalServiceUtil.addvw_datidirettoretiro(this);
		}
		else {
			vw_datidirettoretiroLocalServiceUtil.updatevw_datidirettoretiro(this);
		}
	}

	@Override
	public vw_datidirettoretiro toEscapedModel() {
		return (vw_datidirettoretiro)ProxyUtil.newProxyInstance(vw_datidirettoretiro.class.getClassLoader(),
			new Class[] { vw_datidirettoretiro.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		vw_datidirettoretiroClp clone = new vw_datidirettoretiroClp();

		clone.setEsfshootingdirectorid(getEsfshootingdirectorid());
		clone.setNome(getNome());
		clone.setCognome(getCognome());
		clone.setEsfstartdata(getEsfstartdata());
		clone.setCategoryid(getCategoryid());
		clone.setNumerotessera(getNumerotessera());
		clone.setCodiceregione(getCodiceregione());

		return clone;
	}

	@Override
	public int compareTo(vw_datidirettoretiro vw_datidirettoretiro) {
		vw_datidirettoretiroPK primaryKey = vw_datidirettoretiro.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof vw_datidirettoretiroClp)) {
			return false;
		}

		vw_datidirettoretiroClp vw_datidirettoretiro = (vw_datidirettoretiroClp)obj;

		vw_datidirettoretiroPK primaryKey = vw_datidirettoretiro.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{esfshootingdirectorid=");
		sb.append(getEsfshootingdirectorid());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", cognome=");
		sb.append(getCognome());
		sb.append(", esfstartdata=");
		sb.append(getEsfstartdata());
		sb.append(", categoryid=");
		sb.append(getCategoryid());
		sb.append(", numerotessera=");
		sb.append(getNumerotessera());
		sb.append(", codiceregione=");
		sb.append(getCodiceregione());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.vw_datidirettoretiro");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfshootingdirectorid</column-name><column-value><![CDATA[");
		sb.append(getEsfshootingdirectorid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cognome</column-name><column-value><![CDATA[");
		sb.append(getCognome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfstartdata</column-name><column-value><![CDATA[");
		sb.append(getEsfstartdata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryid</column-name><column-value><![CDATA[");
		sb.append(getCategoryid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numerotessera</column-name><column-value><![CDATA[");
		sb.append(getNumerotessera());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceregione</column-name><column-value><![CDATA[");
		sb.append(getCodiceregione());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfshootingdirectorid;
	private long _nome;
	private long _cognome;
	private Date _esfstartdata;
	private long _categoryid;
	private long _numerotessera;
	private long _codiceregione;
	private BaseModel<?> _vw_datidirettoretiroRemoteModel;
}