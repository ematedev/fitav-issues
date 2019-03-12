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

package it.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFSuspensiveShootingDirector}.
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveShootingDirector
 * @generated
 */
public class ESFSuspensiveShootingDirectorWrapper
	implements ESFSuspensiveShootingDirector,
		ModelWrapper<ESFSuspensiveShootingDirector> {
	public ESFSuspensiveShootingDirectorWrapper(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		_esfSuspensiveShootingDirector = esfSuspensiveShootingDirector;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSuspensiveShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSuspensiveShootingDirector.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfSuspensiveShooingDirectorId",
			getEsfSuspensiveShooingDirectorId());
		attributes.put("esfData", getEsfData());
		attributes.put("esfCodeData", getEsfCodeData());
		attributes.put("esfStartData", getEsfStartData());
		attributes.put("esfEndData", getEsfEndData());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("codeUser", getCodeUser());
		attributes.put("Codice_Sosp", getCodice_Sosp());
		attributes.put("note", getNote());
		attributes.put("Qualif1_Utiliz", getQualif1_Utiliz());
		attributes.put("Qualif2_Utiliz", getQualif2_Utiliz());
		attributes.put("Qualif3_Utiliz", getQualif3_Utiliz());
		attributes.put("Tipo_Gara1_noUtil", getTipo_Gara1_noUtil());
		attributes.put("Tipo_Gara2_noUtil", getTipo_Gara2_noUtil());
		attributes.put("Tipo_Gara3_noUtil", getTipo_Gara3_noUtil());
		attributes.put("Tipo_Gara4_noUtil", getTipo_Gara4_noUtil());
		attributes.put("Tipo_Gara5_noUtil", getTipo_Gara5_noUtil());
		attributes.put("Tipo_Gara6_noUtil", getTipo_Gara6_noUtil());
		attributes.put("Tipo_Gara7_noUtil", getTipo_Gara7_noUtil());
		attributes.put("Tipo_Gara8_noUtil", getTipo_Gara8_noUtil());
		attributes.put("Tipo_Gara9_noUtil", getTipo_Gara9_noUtil());
		attributes.put("Tipo_Gara10_noUtil", getTipo_Gara10_noUtil());
		attributes.put("esfVariationData", getEsfVariationData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfSuspensiveShooingDirectorId = (Long)attributes.get(
				"esfSuspensiveShooingDirectorId");

		if (esfSuspensiveShooingDirectorId != null) {
			setEsfSuspensiveShooingDirectorId(esfSuspensiveShooingDirectorId);
		}

		Date esfData = (Date)attributes.get("esfData");

		if (esfData != null) {
			setEsfData(esfData);
		}

		String esfCodeData = (String)attributes.get("esfCodeData");

		if (esfCodeData != null) {
			setEsfCodeData(esfCodeData);
		}

		Date esfStartData = (Date)attributes.get("esfStartData");

		if (esfStartData != null) {
			setEsfStartData(esfStartData);
		}

		Date esfEndData = (Date)attributes.get("esfEndData");

		if (esfEndData != null) {
			setEsfEndData(esfEndData);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long codeUser = (Long)attributes.get("codeUser");

		if (codeUser != null) {
			setCodeUser(codeUser);
		}

		Long Codice_Sosp = (Long)attributes.get("Codice_Sosp");

		if (Codice_Sosp != null) {
			setCodice_Sosp(Codice_Sosp);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long Qualif1_Utiliz = (Long)attributes.get("Qualif1_Utiliz");

		if (Qualif1_Utiliz != null) {
			setQualif1_Utiliz(Qualif1_Utiliz);
		}

		Long Qualif2_Utiliz = (Long)attributes.get("Qualif2_Utiliz");

		if (Qualif2_Utiliz != null) {
			setQualif2_Utiliz(Qualif2_Utiliz);
		}

		Long Qualif3_Utiliz = (Long)attributes.get("Qualif3_Utiliz");

		if (Qualif3_Utiliz != null) {
			setQualif3_Utiliz(Qualif3_Utiliz);
		}

		Long Tipo_Gara1_noUtil = (Long)attributes.get("Tipo_Gara1_noUtil");

		if (Tipo_Gara1_noUtil != null) {
			setTipo_Gara1_noUtil(Tipo_Gara1_noUtil);
		}

		Long Tipo_Gara2_noUtil = (Long)attributes.get("Tipo_Gara2_noUtil");

		if (Tipo_Gara2_noUtil != null) {
			setTipo_Gara2_noUtil(Tipo_Gara2_noUtil);
		}

		Long Tipo_Gara3_noUtil = (Long)attributes.get("Tipo_Gara3_noUtil");

		if (Tipo_Gara3_noUtil != null) {
			setTipo_Gara3_noUtil(Tipo_Gara3_noUtil);
		}

		Long Tipo_Gara4_noUtil = (Long)attributes.get("Tipo_Gara4_noUtil");

		if (Tipo_Gara4_noUtil != null) {
			setTipo_Gara4_noUtil(Tipo_Gara4_noUtil);
		}

		Long Tipo_Gara5_noUtil = (Long)attributes.get("Tipo_Gara5_noUtil");

		if (Tipo_Gara5_noUtil != null) {
			setTipo_Gara5_noUtil(Tipo_Gara5_noUtil);
		}

		Long Tipo_Gara6_noUtil = (Long)attributes.get("Tipo_Gara6_noUtil");

		if (Tipo_Gara6_noUtil != null) {
			setTipo_Gara6_noUtil(Tipo_Gara6_noUtil);
		}

		Long Tipo_Gara7_noUtil = (Long)attributes.get("Tipo_Gara7_noUtil");

		if (Tipo_Gara7_noUtil != null) {
			setTipo_Gara7_noUtil(Tipo_Gara7_noUtil);
		}

		Long Tipo_Gara8_noUtil = (Long)attributes.get("Tipo_Gara8_noUtil");

		if (Tipo_Gara8_noUtil != null) {
			setTipo_Gara8_noUtil(Tipo_Gara8_noUtil);
		}

		Long Tipo_Gara9_noUtil = (Long)attributes.get("Tipo_Gara9_noUtil");

		if (Tipo_Gara9_noUtil != null) {
			setTipo_Gara9_noUtil(Tipo_Gara9_noUtil);
		}

		Long Tipo_Gara10_noUtil = (Long)attributes.get("Tipo_Gara10_noUtil");

		if (Tipo_Gara10_noUtil != null) {
			setTipo_Gara10_noUtil(Tipo_Gara10_noUtil);
		}

		Date esfVariationData = (Date)attributes.get("esfVariationData");

		if (esfVariationData != null) {
			setEsfVariationData(esfVariationData);
		}
	}

	/**
	* Returns the primary key of this e s f suspensive shooting director.
	*
	* @return the primary key of this e s f suspensive shooting director
	*/
	@Override
	public long getPrimaryKey() {
		return _esfSuspensiveShootingDirector.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f suspensive shooting director.
	*
	* @param primaryKey the primary key of this e s f suspensive shooting director
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfSuspensiveShootingDirector.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf suspensive shooing director ID of this e s f suspensive shooting director.
	*
	* @return the esf suspensive shooing director ID of this e s f suspensive shooting director
	*/
	@Override
	public long getEsfSuspensiveShooingDirectorId() {
		return _esfSuspensiveShootingDirector.getEsfSuspensiveShooingDirectorId();
	}

	/**
	* Sets the esf suspensive shooing director ID of this e s f suspensive shooting director.
	*
	* @param esfSuspensiveShooingDirectorId the esf suspensive shooing director ID of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfSuspensiveShooingDirectorId(
		long esfSuspensiveShooingDirectorId) {
		_esfSuspensiveShootingDirector.setEsfSuspensiveShooingDirectorId(esfSuspensiveShooingDirectorId);
	}

	/**
	* Returns the esf data of this e s f suspensive shooting director.
	*
	* @return the esf data of this e s f suspensive shooting director
	*/
	@Override
	public java.util.Date getEsfData() {
		return _esfSuspensiveShootingDirector.getEsfData();
	}

	/**
	* Sets the esf data of this e s f suspensive shooting director.
	*
	* @param esfData the esf data of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfData(java.util.Date esfData) {
		_esfSuspensiveShootingDirector.setEsfData(esfData);
	}

	/**
	* Returns the esf code data of this e s f suspensive shooting director.
	*
	* @return the esf code data of this e s f suspensive shooting director
	*/
	@Override
	public java.lang.String getEsfCodeData() {
		return _esfSuspensiveShootingDirector.getEsfCodeData();
	}

	/**
	* Sets the esf code data of this e s f suspensive shooting director.
	*
	* @param esfCodeData the esf code data of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfCodeData(java.lang.String esfCodeData) {
		_esfSuspensiveShootingDirector.setEsfCodeData(esfCodeData);
	}

	/**
	* Returns the esf start data of this e s f suspensive shooting director.
	*
	* @return the esf start data of this e s f suspensive shooting director
	*/
	@Override
	public java.util.Date getEsfStartData() {
		return _esfSuspensiveShootingDirector.getEsfStartData();
	}

	/**
	* Sets the esf start data of this e s f suspensive shooting director.
	*
	* @param esfStartData the esf start data of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfStartData(java.util.Date esfStartData) {
		_esfSuspensiveShootingDirector.setEsfStartData(esfStartData);
	}

	/**
	* Returns the esf end data of this e s f suspensive shooting director.
	*
	* @return the esf end data of this e s f suspensive shooting director
	*/
	@Override
	public java.util.Date getEsfEndData() {
		return _esfSuspensiveShootingDirector.getEsfEndData();
	}

	/**
	* Sets the esf end data of this e s f suspensive shooting director.
	*
	* @param esfEndData the esf end data of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfEndData(java.util.Date esfEndData) {
		_esfSuspensiveShootingDirector.setEsfEndData(esfEndData);
	}

	/**
	* Returns the esf user ID of this e s f suspensive shooting director.
	*
	* @return the esf user ID of this e s f suspensive shooting director
	*/
	@Override
	public java.lang.Long getEsfUserId() {
		return _esfSuspensiveShootingDirector.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f suspensive shooting director.
	*
	* @param esfUserId the esf user ID of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfUserId(java.lang.Long esfUserId) {
		_esfSuspensiveShootingDirector.setEsfUserId(esfUserId);
	}

	/**
	* Returns the code user of this e s f suspensive shooting director.
	*
	* @return the code user of this e s f suspensive shooting director
	*/
	@Override
	public java.lang.Long getCodeUser() {
		return _esfSuspensiveShootingDirector.getCodeUser();
	}

	/**
	* Sets the code user of this e s f suspensive shooting director.
	*
	* @param codeUser the code user of this e s f suspensive shooting director
	*/
	@Override
	public void setCodeUser(java.lang.Long codeUser) {
		_esfSuspensiveShootingDirector.setCodeUser(codeUser);
	}

	/**
	* Returns the codice_ sosp of this e s f suspensive shooting director.
	*
	* @return the codice_ sosp of this e s f suspensive shooting director
	*/
	@Override
	public long getCodice_Sosp() {
		return _esfSuspensiveShootingDirector.getCodice_Sosp();
	}

	/**
	* Sets the codice_ sosp of this e s f suspensive shooting director.
	*
	* @param Codice_Sosp the codice_ sosp of this e s f suspensive shooting director
	*/
	@Override
	public void setCodice_Sosp(long Codice_Sosp) {
		_esfSuspensiveShootingDirector.setCodice_Sosp(Codice_Sosp);
	}

	/**
	* Returns the note of this e s f suspensive shooting director.
	*
	* @return the note of this e s f suspensive shooting director
	*/
	@Override
	public java.lang.String getNote() {
		return _esfSuspensiveShootingDirector.getNote();
	}

	/**
	* Sets the note of this e s f suspensive shooting director.
	*
	* @param note the note of this e s f suspensive shooting director
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esfSuspensiveShootingDirector.setNote(note);
	}

	/**
	* Returns the qualif1_ utiliz of this e s f suspensive shooting director.
	*
	* @return the qualif1_ utiliz of this e s f suspensive shooting director
	*/
	@Override
	public long getQualif1_Utiliz() {
		return _esfSuspensiveShootingDirector.getQualif1_Utiliz();
	}

	/**
	* Sets the qualif1_ utiliz of this e s f suspensive shooting director.
	*
	* @param Qualif1_Utiliz the qualif1_ utiliz of this e s f suspensive shooting director
	*/
	@Override
	public void setQualif1_Utiliz(long Qualif1_Utiliz) {
		_esfSuspensiveShootingDirector.setQualif1_Utiliz(Qualif1_Utiliz);
	}

	/**
	* Returns the qualif2_ utiliz of this e s f suspensive shooting director.
	*
	* @return the qualif2_ utiliz of this e s f suspensive shooting director
	*/
	@Override
	public long getQualif2_Utiliz() {
		return _esfSuspensiveShootingDirector.getQualif2_Utiliz();
	}

	/**
	* Sets the qualif2_ utiliz of this e s f suspensive shooting director.
	*
	* @param Qualif2_Utiliz the qualif2_ utiliz of this e s f suspensive shooting director
	*/
	@Override
	public void setQualif2_Utiliz(long Qualif2_Utiliz) {
		_esfSuspensiveShootingDirector.setQualif2_Utiliz(Qualif2_Utiliz);
	}

	/**
	* Returns the qualif3_ utiliz of this e s f suspensive shooting director.
	*
	* @return the qualif3_ utiliz of this e s f suspensive shooting director
	*/
	@Override
	public long getQualif3_Utiliz() {
		return _esfSuspensiveShootingDirector.getQualif3_Utiliz();
	}

	/**
	* Sets the qualif3_ utiliz of this e s f suspensive shooting director.
	*
	* @param Qualif3_Utiliz the qualif3_ utiliz of this e s f suspensive shooting director
	*/
	@Override
	public void setQualif3_Utiliz(long Qualif3_Utiliz) {
		_esfSuspensiveShootingDirector.setQualif3_Utiliz(Qualif3_Utiliz);
	}

	/**
	* Returns the tipo_ gara1_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara1_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara1_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara1_noUtil();
	}

	/**
	* Sets the tipo_ gara1_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara1_noUtil the tipo_ gara1_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara1_noUtil(long Tipo_Gara1_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara1_noUtil(Tipo_Gara1_noUtil);
	}

	/**
	* Returns the tipo_ gara2_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara2_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara2_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara2_noUtil();
	}

	/**
	* Sets the tipo_ gara2_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara2_noUtil the tipo_ gara2_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara2_noUtil(long Tipo_Gara2_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara2_noUtil(Tipo_Gara2_noUtil);
	}

	/**
	* Returns the tipo_ gara3_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara3_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara3_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara3_noUtil();
	}

	/**
	* Sets the tipo_ gara3_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara3_noUtil the tipo_ gara3_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara3_noUtil(long Tipo_Gara3_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara3_noUtil(Tipo_Gara3_noUtil);
	}

	/**
	* Returns the tipo_ gara4_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara4_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara4_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara4_noUtil();
	}

	/**
	* Sets the tipo_ gara4_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara4_noUtil the tipo_ gara4_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara4_noUtil(long Tipo_Gara4_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara4_noUtil(Tipo_Gara4_noUtil);
	}

	/**
	* Returns the tipo_ gara5_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara5_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara5_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara5_noUtil();
	}

	/**
	* Sets the tipo_ gara5_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara5_noUtil the tipo_ gara5_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara5_noUtil(long Tipo_Gara5_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara5_noUtil(Tipo_Gara5_noUtil);
	}

	/**
	* Returns the tipo_ gara6_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara6_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara6_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara6_noUtil();
	}

	/**
	* Sets the tipo_ gara6_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara6_noUtil the tipo_ gara6_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara6_noUtil(long Tipo_Gara6_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara6_noUtil(Tipo_Gara6_noUtil);
	}

	/**
	* Returns the tipo_ gara7_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara7_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara7_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara7_noUtil();
	}

	/**
	* Sets the tipo_ gara7_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara7_noUtil the tipo_ gara7_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara7_noUtil(long Tipo_Gara7_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara7_noUtil(Tipo_Gara7_noUtil);
	}

	/**
	* Returns the tipo_ gara8_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara8_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara8_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara8_noUtil();
	}

	/**
	* Sets the tipo_ gara8_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara8_noUtil the tipo_ gara8_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara8_noUtil(long Tipo_Gara8_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara8_noUtil(Tipo_Gara8_noUtil);
	}

	/**
	* Returns the tipo_ gara9_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara9_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara9_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara9_noUtil();
	}

	/**
	* Sets the tipo_ gara9_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara9_noUtil the tipo_ gara9_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara9_noUtil(long Tipo_Gara9_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara9_noUtil(Tipo_Gara9_noUtil);
	}

	/**
	* Returns the tipo_ gara10_no util of this e s f suspensive shooting director.
	*
	* @return the tipo_ gara10_no util of this e s f suspensive shooting director
	*/
	@Override
	public long getTipo_Gara10_noUtil() {
		return _esfSuspensiveShootingDirector.getTipo_Gara10_noUtil();
	}

	/**
	* Sets the tipo_ gara10_no util of this e s f suspensive shooting director.
	*
	* @param Tipo_Gara10_noUtil the tipo_ gara10_no util of this e s f suspensive shooting director
	*/
	@Override
	public void setTipo_Gara10_noUtil(long Tipo_Gara10_noUtil) {
		_esfSuspensiveShootingDirector.setTipo_Gara10_noUtil(Tipo_Gara10_noUtil);
	}

	/**
	* Returns the esf variation data of this e s f suspensive shooting director.
	*
	* @return the esf variation data of this e s f suspensive shooting director
	*/
	@Override
	public java.util.Date getEsfVariationData() {
		return _esfSuspensiveShootingDirector.getEsfVariationData();
	}

	/**
	* Sets the esf variation data of this e s f suspensive shooting director.
	*
	* @param esfVariationData the esf variation data of this e s f suspensive shooting director
	*/
	@Override
	public void setEsfVariationData(java.util.Date esfVariationData) {
		_esfSuspensiveShootingDirector.setEsfVariationData(esfVariationData);
	}

	@Override
	public boolean isNew() {
		return _esfSuspensiveShootingDirector.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfSuspensiveShootingDirector.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfSuspensiveShootingDirector.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfSuspensiveShootingDirector.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfSuspensiveShootingDirector.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfSuspensiveShootingDirector.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfSuspensiveShootingDirector.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfSuspensiveShootingDirector.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfSuspensiveShootingDirector.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfSuspensiveShootingDirector.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfSuspensiveShootingDirector.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFSuspensiveShootingDirectorWrapper((ESFSuspensiveShootingDirector)_esfSuspensiveShootingDirector.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		return _esfSuspensiveShootingDirector.compareTo(esfSuspensiveShootingDirector);
	}

	@Override
	public int hashCode() {
		return _esfSuspensiveShootingDirector.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFSuspensiveShootingDirector> toCacheModel() {
		return _esfSuspensiveShootingDirector.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector toEscapedModel() {
		return new ESFSuspensiveShootingDirectorWrapper(_esfSuspensiveShootingDirector.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFSuspensiveShootingDirector toUnescapedModel() {
		return new ESFSuspensiveShootingDirectorWrapper(_esfSuspensiveShootingDirector.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfSuspensiveShootingDirector.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfSuspensiveShootingDirector.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfSuspensiveShootingDirector.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFSuspensiveShootingDirectorWrapper)) {
			return false;
		}

		ESFSuspensiveShootingDirectorWrapper esfSuspensiveShootingDirectorWrapper =
			(ESFSuspensiveShootingDirectorWrapper)obj;

		if (Validator.equals(_esfSuspensiveShootingDirector,
					esfSuspensiveShootingDirectorWrapper._esfSuspensiveShootingDirector)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFSuspensiveShootingDirector getWrappedESFSuspensiveShootingDirector() {
		return _esfSuspensiveShootingDirector;
	}

	@Override
	public ESFSuspensiveShootingDirector getWrappedModel() {
		return _esfSuspensiveShootingDirector;
	}

	@Override
	public void resetOriginalValues() {
		_esfSuspensiveShootingDirector.resetOriginalValues();
	}

	private ESFSuspensiveShootingDirector _esfSuspensiveShootingDirector;
}