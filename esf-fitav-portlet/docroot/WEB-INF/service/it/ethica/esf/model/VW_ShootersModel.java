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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.service.persistence.VW_ShootersPK;

import java.io.Serializable;

/**
 * The base model interface for the VW_Shooters service. Represents a row in the &quot;VW_Shooters&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.VW_ShootersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.VW_ShootersImpl}.
 * </p>
 *
 * @author Ethica
 * @see VW_Shooters
 * @see it.ethica.esf.model.impl.VW_ShootersImpl
 * @see it.ethica.esf.model.impl.VW_ShootersModelImpl
 * @generated
 */
public interface VW_ShootersModel extends BaseModel<VW_Shooters> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a v w_ shooters model instance should use the {@link VW_Shooters} interface instead.
	 */

	/**
	 * Returns the primary key of this v w_ shooters.
	 *
	 * @return the primary key of this v w_ shooters
	 */
	public VW_ShootersPK getPrimaryKey();

	/**
	 * Sets the primary key of this v w_ shooters.
	 *
	 * @param primaryKey the primary key of this v w_ shooters
	 */
	public void setPrimaryKey(VW_ShootersPK primaryKey);

	/**
	 * Returns the user ID of this v w_ shooters.
	 *
	 * @return the user ID of this v w_ shooters
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this v w_ shooters.
	 *
	 * @param userId the user ID of this v w_ shooters
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this v w_ shooters.
	 *
	 * @return the user uuid of this v w_ shooters
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this v w_ shooters.
	 *
	 * @param userUuid the user uuid of this v w_ shooters
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the codice tessera of this v w_ shooters.
	 *
	 * @return the codice tessera of this v w_ shooters
	 */
	@AutoEscape
	public String getCodiceTessera();

	/**
	 * Sets the codice tessera of this v w_ shooters.
	 *
	 * @param CodiceTessera the codice tessera of this v w_ shooters
	 */
	public void setCodiceTessera(String CodiceTessera);

	/**
	 * Returns the codice organizzazione of this v w_ shooters.
	 *
	 * @return the codice organizzazione of this v w_ shooters
	 */
	@AutoEscape
	public String getCodiceOrganizzazione();

	/**
	 * Sets the codice organizzazione of this v w_ shooters.
	 *
	 * @param CodiceOrganizzazione the codice organizzazione of this v w_ shooters
	 */
	public void setCodiceOrganizzazione(String CodiceOrganizzazione);

	/**
	 * Returns the nome of this v w_ shooters.
	 *
	 * @return the nome of this v w_ shooters
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this v w_ shooters.
	 *
	 * @param Nome the nome of this v w_ shooters
	 */
	public void setNome(String Nome);

	/**
	 * Returns the cognome of this v w_ shooters.
	 *
	 * @return the cognome of this v w_ shooters
	 */
	@AutoEscape
	public String getCognome();

	/**
	 * Sets the cognome of this v w_ shooters.
	 *
	 * @param Cognome the cognome of this v w_ shooters
	 */
	public void setCognome(String Cognome);

	/**
	 * Returns the email of this v w_ shooters.
	 *
	 * @return the email of this v w_ shooters
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this v w_ shooters.
	 *
	 * @param Email the email of this v w_ shooters
	 */
	public void setEmail(String Email);

	/**
	 * Returns the c f of this v w_ shooters.
	 *
	 * @return the c f of this v w_ shooters
	 */
	@AutoEscape
	public String getCF();

	/**
	 * Sets the c f of this v w_ shooters.
	 *
	 * @param CF the c f of this v w_ shooters
	 */
	public void setCF(String CF);

	/**
	 * Returns the organization ID of this v w_ shooters.
	 *
	 * @return the organization ID of this v w_ shooters
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this v w_ shooters.
	 *
	 * @param organizationId the organization ID of this v w_ shooters
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the invitato of this v w_ shooters.
	 *
	 * @return the invitato of this v w_ shooters
	 */
	public int getInvitato();

	/**
	 * Sets the invitato of this v w_ shooters.
	 *
	 * @param invitato the invitato of this v w_ shooters
	 */
	public void setInvitato(int invitato);

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
	public int compareTo(it.ethica.esf.model.VW_Shooters vw_Shooters);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.VW_Shooters> toCacheModel();

	@Override
	public it.ethica.esf.model.VW_Shooters toEscapedModel();

	@Override
	public it.ethica.esf.model.VW_Shooters toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}