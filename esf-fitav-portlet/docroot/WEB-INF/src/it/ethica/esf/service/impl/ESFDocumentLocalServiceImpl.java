package it.ethica.esf.service.impl;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.service.base.ESFDocumentLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the e s f document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFDocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFDocumentLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFDocumentLocalServiceUtil
 */
public class ESFDocumentLocalServiceImpl extends
		ESFDocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * it.ethica.esf.service.ESFDocumentLocalServiceUtil} to access the e s f
	 * document local service.
	 */

	public List<ESFDocument> findAll() throws SystemException {

		return esfDocumentPersistence.findAll();
	}

	public ESFDocument addEsfDocument(long groupId, long companyId,
			String userName, long esfUserId, String code, String releasedBy,
			Date createDate, Date releaseDate, Date expirationDate, long esfDocumentTypeId, long esfPublicAuthorityId,
			String type, String path, ServiceContext serviceContext)
			throws SystemException {

		long esfDocumentId = counterLocalService.increment();

		ESFDocument esfDocument = esfDocumentLocalService
				.createESFDocument(esfDocumentId);

		esfDocument.setGroupId(groupId);
		esfDocument.setCompanyId(companyId);
		esfDocument.setUserName(userName);
		esfDocument.setUserId(serviceContext.getUserId());
		esfDocument.setCreateDate(createDate);
		esfDocument.setEsfUserId(esfUserId);
		esfDocument.setReleaseDate(releaseDate);
		esfDocument.setExpirationDate(expirationDate);
		esfDocument.setCode(code);
		esfDocument.setReleasedBy(releasedBy);
		esfDocument.setType(type);
		esfDocument.setEsfDocumentTypeId(esfDocumentTypeId);
		esfDocument.setEsfPublicAuthorityId(esfPublicAuthorityId);
		esfDocument.setPath(path);

		esfDocumentLocalService.updateESFDocument(esfDocument);

		return esfDocument;
	}

	public ESFDocument updateEsfDocument(long esfDocumentId, long groupId,
			long companyId, String userName, long esfUserId, String code,
			String releasedBy, Date modifiedDate, Date releaseDate,
			Date expirationDate, long esfDocumentTypeId, long esfPublicAuthorityId, String type, String path,
			ServiceContext serviceContext) throws SystemException {
		
		ESFDocument esfDocument = esfDocumentLocalService
				.fetchESFDocument(esfDocumentId);

		esfDocument.setGroupId(groupId);
		esfDocument.setCompanyId(companyId);
		esfDocument.setUserName(userName);
		esfDocument.setModifiedDate(modifiedDate);
		esfDocument.setEsfUserId(esfUserId);
		esfDocument.setReleaseDate(releaseDate);
		esfDocument.setExpirationDate(expirationDate);
		esfDocument.setCode(code);
		esfDocument.setReleasedBy(releasedBy);
		esfDocument.setEsfPublicAuthorityId(esfPublicAuthorityId);
		esfDocument.setType(type);
		esfDocument.setPath(path);

		esfDocumentLocalService.updateESFDocument(esfDocument);
		return esfDocument;
	}

	public List<ESFDocument> findByCode(String code) throws SystemException {

		return esfDocumentPersistence.findByCode(code);
	}

	public List<ESFDocument> findByesfUserId(long esfUserId)
			throws SystemException {		
		return esfDocumentPersistence.findByesfUserId(esfUserId);
	}
	
	public List<ESFDocument> findByEsfDocumentTypeId(long esfDocumentTypeId) throws SystemException{
		return this.esfDocumentPersistence.findByEsfDocumentTypeId(esfDocumentTypeId);
	}

	public List<ESFDocument> findByEsfPublicAuthorityId(long esfPublicAuthorityId) throws SystemException{
		return this.esfDocumentPersistence.findByEsfPublicAuthorityId(esfPublicAuthorityId);
	}
	
	public List<ESFDocument> findByT_U(String type, long esfUserId)
			throws SystemException {

		return esfDocumentPersistence.findByT_U(type, esfUserId);
	}

	public List<ESFDocument> findByU_ED(long esfUserId, Date expirationDate)
			throws SystemException {

		return esfDocumentPersistence.findByU_ED(esfUserId, expirationDate);
	}

	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
}