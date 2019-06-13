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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFRadunoFiles}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoFiles
 * @generated
 */
public class ESFRadunoFilesWrapper implements ESFRadunoFiles,
	ModelWrapper<ESFRadunoFiles> {
	public ESFRadunoFilesWrapper(ESFRadunoFiles esfRadunoFiles) {
		_esfRadunoFiles = esfRadunoFiles;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoFiles.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoFiles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_files", getId_esf_raduno_files());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("nome", getNome());
		attributes.put("path", getPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_files = (Long)attributes.get("id_esf_raduno_files");

		if (id_esf_raduno_files != null) {
			setId_esf_raduno_files(id_esf_raduno_files);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}
	}

	/**
	* Returns the primary key of this e s f raduno files.
	*
	* @return the primary key of this e s f raduno files
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRadunoFiles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno files.
	*
	* @param primaryKey the primary key of this e s f raduno files
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRadunoFiles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_files of this e s f raduno files.
	*
	* @return the id_esf_raduno_files of this e s f raduno files
	*/
	@Override
	public long getId_esf_raduno_files() {
		return _esfRadunoFiles.getId_esf_raduno_files();
	}

	/**
	* Sets the id_esf_raduno_files of this e s f raduno files.
	*
	* @param id_esf_raduno_files the id_esf_raduno_files of this e s f raduno files
	*/
	@Override
	public void setId_esf_raduno_files(long id_esf_raduno_files) {
		_esfRadunoFiles.setId_esf_raduno_files(id_esf_raduno_files);
	}

	/**
	* Returns the id_esf_raduno of this e s f raduno files.
	*
	* @return the id_esf_raduno of this e s f raduno files
	*/
	@Override
	public long getId_esf_raduno() {
		return _esfRadunoFiles.getId_esf_raduno();
	}

	/**
	* Sets the id_esf_raduno of this e s f raduno files.
	*
	* @param id_esf_raduno the id_esf_raduno of this e s f raduno files
	*/
	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_esfRadunoFiles.setId_esf_raduno(id_esf_raduno);
	}

	/**
	* Returns the nome of this e s f raduno files.
	*
	* @return the nome of this e s f raduno files
	*/
	@Override
	public java.lang.String getNome() {
		return _esfRadunoFiles.getNome();
	}

	/**
	* Sets the nome of this e s f raduno files.
	*
	* @param nome the nome of this e s f raduno files
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_esfRadunoFiles.setNome(nome);
	}

	/**
	* Returns the path of this e s f raduno files.
	*
	* @return the path of this e s f raduno files
	*/
	@Override
	public java.lang.String getPath() {
		return _esfRadunoFiles.getPath();
	}

	/**
	* Sets the path of this e s f raduno files.
	*
	* @param path the path of this e s f raduno files
	*/
	@Override
	public void setPath(java.lang.String path) {
		_esfRadunoFiles.setPath(path);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoFiles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoFiles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoFiles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoFiles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoFiles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoFiles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoFiles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoFiles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoFiles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoFiles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoFiles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoFilesWrapper((ESFRadunoFiles)_esfRadunoFiles.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFRadunoFiles esfRadunoFiles) {
		return _esfRadunoFiles.compareTo(esfRadunoFiles);
	}

	@Override
	public int hashCode() {
		return _esfRadunoFiles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRadunoFiles> toCacheModel() {
		return _esfRadunoFiles.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRadunoFiles toEscapedModel() {
		return new ESFRadunoFilesWrapper(_esfRadunoFiles.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRadunoFiles toUnescapedModel() {
		return new ESFRadunoFilesWrapper(_esfRadunoFiles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoFiles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoFiles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoFiles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoFilesWrapper)) {
			return false;
		}

		ESFRadunoFilesWrapper esfRadunoFilesWrapper = (ESFRadunoFilesWrapper)obj;

		if (Validator.equals(_esfRadunoFiles,
					esfRadunoFilesWrapper._esfRadunoFiles)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRadunoFiles getWrappedESFRadunoFiles() {
		return _esfRadunoFiles;
	}

	@Override
	public ESFRadunoFiles getWrappedModel() {
		return _esfRadunoFiles;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoFiles.resetOriginalValues();
	}

	private ESFRadunoFiles _esfRadunoFiles;
}