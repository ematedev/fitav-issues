package it.ethica.esf.search;

import it.ethica.esf.model.ESFType;
import it.ethica.esf.service.ESFTypeLocalServiceUtil;
import it.ethica.esf.service.permission.ESFTypePermission;
import it.ethica.esf.service.persistence.ESFTypeActionableDynamicQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFTypeIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { ESFType.class.getName() };

	public static final String PORTLET_ID = "3";
	
	public ESFTypeIndexer() {
		
		setPermissionAware(true);
	}
	
	@Override
	public String[] getClassNames() {
		
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		
		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return ESFTypePermission.contains(permissionChecker, entryClassPK, actionId);
	}
	
	@Override
	protected void doDelete(Object obj) throws Exception {
		
		ESFType esfType = (ESFType) obj;

		deleteDocument(esfType.getCompanyId(), esfType.getEsfTypeId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		
		ESFType esfType = (ESFType) obj;

		Document document = getBaseModelDocument(PORTLET_ID, esfType);

		document.addText(Field.TITLE, esfType.getName());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		ESFType esfType = (ESFType) obj;

		Document document = getDocument(esfType);

		SearchEngineUtil.updateDocument(getSearchEngineId(),
				esfType.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexESFTypes(companyId);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		ESFType esfType = ESFTypeLocalServiceUtil.getESFType(classPK);
		
		doReindex(esfType);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		
		return PORTLET_ID;
	}
	
	protected void reindexESFTypes(long companyId) throws PortalException,
	SystemException {

		final Collection<Document> documents = new ArrayList<Document>();
		
		ActionableDynamicQuery actionableDynamicQuery = new ESFTypeActionableDynamicQuery() {
		
			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}
		
			@Override
			protected void performAction(Object object) throws PortalException {
				ESFType esfType = (ESFType) object;
		
				Document document = getDocument(esfType);
		
				documents.add(document);
			}
		
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
				documents);
	}

}
