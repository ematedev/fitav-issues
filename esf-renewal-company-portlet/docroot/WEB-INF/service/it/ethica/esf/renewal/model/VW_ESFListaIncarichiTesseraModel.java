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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VW_ESFListaIncarichiTessera service. Represents a row in the &quot;vw_listaincarichitessera&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraImpl}.
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTessera
 * @see it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraImpl
 * @see it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl
 * @generated
 */
public interface VW_ESFListaIncarichiTesseraModel extends BaseModel<VW_ESFListaIncarichiTessera> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a v w_ e s f lista incarichi tessera model instance should use the {@link VW_ESFListaIncarichiTessera} interface instead.
	 */

	/**
	 * Returns the primary key of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the primary key of this v w_ e s f lista incarichi tessera
	 */
	public VW_ESFListaIncarichiTesseraPK getPrimaryKey();

	/**
	 * Sets the primary key of this v w_ e s f lista incarichi tessera.
	 *
	 * @param primaryKey the primary key of this v w_ e s f lista incarichi tessera
	 */
	public void setPrimaryKey(VW_ESFListaIncarichiTesseraPK primaryKey);

	/**
	 * Returns the anni precedenti of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the anni precedenti of this v w_ e s f lista incarichi tessera
	 */
	public int getAnniPrecedenti();

	/**
	 * Sets the anni precedenti of this v w_ e s f lista incarichi tessera.
	 *
	 * @param AnniPrecedenti the anni precedenti of this v w_ e s f lista incarichi tessera
	 */
	public void setAnniPrecedenti(int AnniPrecedenti);

	/**
	 * Returns the anno fine incarico of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the anno fine incarico of this v w_ e s f lista incarichi tessera
	 */
	public int getAnnoFineIncarico();

	/**
	 * Sets the anno fine incarico of this v w_ e s f lista incarichi tessera.
	 *
	 * @param AnnoFineIncarico the anno fine incarico of this v w_ e s f lista incarichi tessera
	 */
	public void setAnnoFineIncarico(int AnnoFineIncarico);

	/**
	 * Returns the anno inizio incarico of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the anno inizio incarico of this v w_ e s f lista incarichi tessera
	 */
	public int getAnnoInizioIncarico();

	/**
	 * Sets the anno inizio incarico of this v w_ e s f lista incarichi tessera.
	 *
	 * @param AnnoInizioIncarico the anno inizio incarico of this v w_ e s f lista incarichi tessera
	 */
	public void setAnnoInizioIncarico(int AnnoInizioIncarico);

	/**
	 * Returns the anno corrente of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the anno corrente of this v w_ e s f lista incarichi tessera
	 */
	public int getAnnoCorrente();

	/**
	 * Sets the anno corrente of this v w_ e s f lista incarichi tessera.
	 *
	 * @param AnnoCorrente the anno corrente of this v w_ e s f lista incarichi tessera
	 */
	public void setAnnoCorrente(int AnnoCorrente);

	/**
	 * Returns the nome ruolo of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the nome ruolo of this v w_ e s f lista incarichi tessera
	 */
	@AutoEscape
	public String getNomeRuolo();

	/**
	 * Sets the nome ruolo of this v w_ e s f lista incarichi tessera.
	 *
	 * @param NomeRuolo the nome ruolo of this v w_ e s f lista incarichi tessera
	 */
	public void setNomeRuolo(String NomeRuolo);

	/**
	 * Returns the end date of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the end date of this v w_ e s f lista incarichi tessera
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this v w_ e s f lista incarichi tessera.
	 *
	 * @param endDate the end date of this v w_ e s f lista incarichi tessera
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the start date of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the start date of this v w_ e s f lista incarichi tessera
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this v w_ e s f lista incarichi tessera.
	 *
	 * @param startDate the start date of this v w_ e s f lista incarichi tessera
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the esf user ID of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the esf user ID of this v w_ e s f lista incarichi tessera
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this v w_ e s f lista incarichi tessera.
	 *
	 * @param esfUserId the esf user ID of this v w_ e s f lista incarichi tessera
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the esf user uuid of this v w_ e s f lista incarichi tessera
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this v w_ e s f lista incarichi tessera.
	 *
	 * @param esfUserUuid the esf user uuid of this v w_ e s f lista incarichi tessera
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the esf organization ID of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the esf organization ID of this v w_ e s f lista incarichi tessera
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this v w_ e s f lista incarichi tessera.
	 *
	 * @param esfOrganizationId the esf organization ID of this v w_ e s f lista incarichi tessera
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

	/**
	 * Returns the last name of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the last name of this v w_ e s f lista incarichi tessera
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this v w_ e s f lista incarichi tessera.
	 *
	 * @param lastName the last name of this v w_ e s f lista incarichi tessera
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the first name of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the first name of this v w_ e s f lista incarichi tessera
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this v w_ e s f lista incarichi tessera.
	 *
	 * @param firstName the first name of this v w_ e s f lista incarichi tessera
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the codice tessera of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the codice tessera of this v w_ e s f lista incarichi tessera
	 */
	@AutoEscape
	public String getCodiceTessera();

	/**
	 * Sets the codice tessera of this v w_ e s f lista incarichi tessera.
	 *
	 * @param CodiceTessera the codice tessera of this v w_ e s f lista incarichi tessera
	 */
	public void setCodiceTessera(String CodiceTessera);

	/**
	 * Returns the data tesseramento of this v w_ e s f lista incarichi tessera.
	 *
	 * @return the data tesseramento of this v w_ e s f lista incarichi tessera
	 */
	public Date getDataTesseramento();

	/**
	 * Sets the data tesseramento of this v w_ e s f lista incarichi tessera.
	 *
	 * @param DataTesseramento the data tesseramento of this v w_ e s f lista incarichi tessera
	 */
	public void setDataTesseramento(Date DataTesseramento);

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
	public int compareTo(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VW_ESFListaIncarichiTessera> toCacheModel();

	@Override
	public VW_ESFListaIncarichiTessera toEscapedModel();

	@Override
	public VW_ESFListaIncarichiTessera toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}