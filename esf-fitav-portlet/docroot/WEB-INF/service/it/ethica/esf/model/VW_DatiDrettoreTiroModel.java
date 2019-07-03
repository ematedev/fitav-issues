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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK;

import java.io.Serializable;

/**
 * The base model interface for the VW_DatiDrettoreTiro service. Represents a row in the &quot;vw_datidirettoretiro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.VW_DatiDrettoreTiroImpl}.
 * </p>
 *
 * @author Ethica
 * @see VW_DatiDrettoreTiro
 * @see it.ethica.esf.model.impl.VW_DatiDrettoreTiroImpl
 * @see it.ethica.esf.model.impl.VW_DatiDrettoreTiroModelImpl
 * @generated
 */
public interface VW_DatiDrettoreTiroModel extends BaseModel<VW_DatiDrettoreTiro> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a v w_ dati drettore tiro model instance should use the {@link VW_DatiDrettoreTiro} interface instead.
	 */

	/**
	 * Returns the primary key of this v w_ dati drettore tiro.
	 *
	 * @return the primary key of this v w_ dati drettore tiro
	 */
	public VW_DatiDrettoreTiroPK getPrimaryKey();

	/**
	 * Sets the primary key of this v w_ dati drettore tiro.
	 *
	 * @param primaryKey the primary key of this v w_ dati drettore tiro
	 */
	public void setPrimaryKey(VW_DatiDrettoreTiroPK primaryKey);

	/**
	 * Returns the esf shooting director ID of this v w_ dati drettore tiro.
	 *
	 * @return the esf shooting director ID of this v w_ dati drettore tiro
	 */
	public long getEsfShootingDirectorId();

	/**
	 * Sets the esf shooting director ID of this v w_ dati drettore tiro.
	 *
	 * @param esfShootingDirectorId the esf shooting director ID of this v w_ dati drettore tiro
	 */
	public void setEsfShootingDirectorId(long esfShootingDirectorId);

	/**
	 * Returns the nome of this v w_ dati drettore tiro.
	 *
	 * @return the nome of this v w_ dati drettore tiro
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this v w_ dati drettore tiro.
	 *
	 * @param Nome the nome of this v w_ dati drettore tiro
	 */
	public void setNome(String Nome);

	/**
	 * Returns the cognome of this v w_ dati drettore tiro.
	 *
	 * @return the cognome of this v w_ dati drettore tiro
	 */
	@AutoEscape
	public String getCognome();

	/**
	 * Sets the cognome of this v w_ dati drettore tiro.
	 *
	 * @param Cognome the cognome of this v w_ dati drettore tiro
	 */
	public void setCognome(String Cognome);

	/**
	 * Returns the codice regione of this v w_ dati drettore tiro.
	 *
	 * @return the codice regione of this v w_ dati drettore tiro
	 */
	@AutoEscape
	public String getCodiceRegione();

	/**
	 * Sets the codice regione of this v w_ dati drettore tiro.
	 *
	 * @param CodiceRegione the codice regione of this v w_ dati drettore tiro
	 */
	public void setCodiceRegione(String CodiceRegione);

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
		it.ethica.esf.model.VW_DatiDrettoreTiro vw_DatiDrettoreTiro);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.VW_DatiDrettoreTiro> toCacheModel();

	@Override
	public it.ethica.esf.model.VW_DatiDrettoreTiro toEscapedModel();

	@Override
	public it.ethica.esf.model.VW_DatiDrettoreTiro toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}