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
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.VW_ShootersLocalServiceUtil;
import it.ethica.esf.service.persistence.VW_ShootersPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class VW_ShootersClp extends BaseModelImpl<VW_Shooters>
	implements VW_Shooters {
	public VW_ShootersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VW_Shooters.class;
	}

	@Override
	public String getModelClassName() {
		return VW_Shooters.class.getName();
	}

	@Override
	public VW_ShootersPK getPrimaryKey() {
		return new VW_ShootersPK(_userId, _organizationId);
	}

	@Override
	public void setPrimaryKey(VW_ShootersPK primaryKey) {
		setUserId(primaryKey.userId);
		setOrganizationId(primaryKey.organizationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VW_ShootersPK(_userId, _organizationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VW_ShootersPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("CodiceTessera", getCodiceTessera());
		attributes.put("CodiceOrganizzazione", getCodiceOrganizzazione());
		attributes.put("Nome", getNome());
		attributes.put("Cognome", getCognome());
		attributes.put("Email", getEmail());
		attributes.put("CF", getCF());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("invitato", getInvitato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String CodiceTessera = (String)attributes.get("CodiceTessera");

		if (CodiceTessera != null) {
			setCodiceTessera(CodiceTessera);
		}

		String CodiceOrganizzazione = (String)attributes.get(
				"CodiceOrganizzazione");

		if (CodiceOrganizzazione != null) {
			setCodiceOrganizzazione(CodiceOrganizzazione);
		}

		String Nome = (String)attributes.get("Nome");

		if (Nome != null) {
			setNome(Nome);
		}

		String Cognome = (String)attributes.get("Cognome");

		if (Cognome != null) {
			setCognome(Cognome);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String CF = (String)attributes.get("CF");

		if (CF != null) {
			setCF(CF);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Integer invitato = (Integer)attributes.get("invitato");

		if (invitato != null) {
			setInvitato(invitato);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vw_ShootersRemoteModel, userId);
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
	public String getCodiceTessera() {
		return _CodiceTessera;
	}

	@Override
	public void setCodiceTessera(String CodiceTessera) {
		_CodiceTessera = CodiceTessera;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceTessera", String.class);

				method.invoke(_vw_ShootersRemoteModel, CodiceTessera);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceOrganizzazione() {
		return _CodiceOrganizzazione;
	}

	@Override
	public void setCodiceOrganizzazione(String CodiceOrganizzazione) {
		_CodiceOrganizzazione = CodiceOrganizzazione;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceOrganizzazione",
						String.class);

				method.invoke(_vw_ShootersRemoteModel, CodiceOrganizzazione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _Nome;
	}

	@Override
	public void setNome(String Nome) {
		_Nome = Nome;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_vw_ShootersRemoteModel, Nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCognome() {
		return _Cognome;
	}

	@Override
	public void setCognome(String Cognome) {
		_Cognome = Cognome;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setCognome", String.class);

				method.invoke(_vw_ShootersRemoteModel, Cognome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _Email;
	}

	@Override
	public void setEmail(String Email) {
		_Email = Email;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_vw_ShootersRemoteModel, Email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCF() {
		return _CF;
	}

	@Override
	public void setCF(String CF) {
		_CF = CF;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setCF", String.class);

				method.invoke(_vw_ShootersRemoteModel, CF);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_vw_ShootersRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getInvitato() {
		return _invitato;
	}

	@Override
	public void setInvitato(int invitato) {
		_invitato = invitato;

		if (_vw_ShootersRemoteModel != null) {
			try {
				Class<?> clazz = _vw_ShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitato", int.class);

				method.invoke(_vw_ShootersRemoteModel, invitato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVW_ShootersRemoteModel() {
		return _vw_ShootersRemoteModel;
	}

	public void setVW_ShootersRemoteModel(BaseModel<?> vw_ShootersRemoteModel) {
		_vw_ShootersRemoteModel = vw_ShootersRemoteModel;
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

		Class<?> remoteModelClass = _vw_ShootersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_ShootersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VW_ShootersLocalServiceUtil.addVW_Shooters(this);
		}
		else {
			VW_ShootersLocalServiceUtil.updateVW_Shooters(this);
		}
	}

	@Override
	public VW_Shooters toEscapedModel() {
		return (VW_Shooters)ProxyUtil.newProxyInstance(VW_Shooters.class.getClassLoader(),
			new Class[] { VW_Shooters.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VW_ShootersClp clone = new VW_ShootersClp();

		clone.setUserId(getUserId());
		clone.setCodiceTessera(getCodiceTessera());
		clone.setCodiceOrganizzazione(getCodiceOrganizzazione());
		clone.setNome(getNome());
		clone.setCognome(getCognome());
		clone.setEmail(getEmail());
		clone.setCF(getCF());
		clone.setOrganizationId(getOrganizationId());
		clone.setInvitato(getInvitato());

		return clone;
	}

	@Override
	public int compareTo(VW_Shooters vw_Shooters) {
		VW_ShootersPK primaryKey = vw_Shooters.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_ShootersClp)) {
			return false;
		}

		VW_ShootersClp vw_Shooters = (VW_ShootersClp)obj;

		VW_ShootersPK primaryKey = vw_Shooters.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", CodiceTessera=");
		sb.append(getCodiceTessera());
		sb.append(", CodiceOrganizzazione=");
		sb.append(getCodiceOrganizzazione());
		sb.append(", Nome=");
		sb.append(getNome());
		sb.append(", Cognome=");
		sb.append(getCognome());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", CF=");
		sb.append(getCF());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", invitato=");
		sb.append(getInvitato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.VW_Shooters");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CodiceTessera</column-name><column-value><![CDATA[");
		sb.append(getCodiceTessera());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CodiceOrganizzazione</column-name><column-value><![CDATA[");
		sb.append(getCodiceOrganizzazione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Cognome</column-name><column-value><![CDATA[");
		sb.append(getCognome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CF</column-name><column-value><![CDATA[");
		sb.append(getCF());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invitato</column-name><column-value><![CDATA[");
		sb.append(getInvitato());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private String _CodiceTessera;
	private String _CodiceOrganizzazione;
	private String _Nome;
	private String _Cognome;
	private String _Email;
	private String _CF;
	private long _organizationId;
	private int _invitato;
	private BaseModel<?> _vw_ShootersRemoteModel;
}