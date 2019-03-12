package it.ethica.esf.search;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFDocumentActionableDynamicQuery;

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

public class ESFDocumentIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { ESFDocument.class.getName() };

    public static final String PORTLET_ID = "guestbook-portlet";
	
    public ESFDocumentIndexer() {
		setPermissionAware(false);
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
	protected void doDelete(Object obj) throws Exception {
		ESFDocument esfDocument = (ESFDocument)obj;
		
		deleteDocument(esfDocument.getCompanyId(), esfDocument.getEsfDocumentId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		ESFDocument esfDocument = (ESFDocument)obj;
		Document document = getBaseModelDocument(PORTLET_ID, esfDocument);
		
		document.addDate(Field.MODIFIED_DATE, esfDocument.getModifiedDate());
		document.addText(Field.TITLE, esfDocument.getName());
		
		document.addKeyword(Field.SCOPE_GROUP_ID, esfDocument.getGroupId());
		document.addKeyword(Field.GROUP_ID, esfDocument.getGroupId());
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet,
			PortletURL portalURL) throws Exception {
		Summary summary = createSummary(document);
		
		summary.setMaxContentLength(200);
		
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		ESFDocument esfDocument = (ESFDocument)obj;
		
		Document document = getDocument(esfDocument);
		
		SearchEngineUtil.updateDocument(getSearchEngineId(), esfDocument.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexESFDocuments(companyId);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		ESFDocument esfDocument = ESFDocumentLocalServiceUtil.getESFDocument(classPK);
		
		doReindex(esfDocument);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		
		return PORTLET_ID;
	}
	
	protected void reindexESFDocuments(long companyId) throws SystemException, PortalException {
		
		final Collection<Document> documents = new ArrayList<Document>();
		
		ActionableDynamicQuery actionableDynamicQuery = new ESFDocumentActionableDynamicQuery() {
			@Override
            protected void addCriteria(DynamicQuery dynamicQuery) {
            }
			
			@Override
			protected void performAction(Object obj) throws PortalException,
					SystemException {
				
				ESFDocument esfDocument = (ESFDocument)obj;
				
				Document document = getDocument(esfDocument);
				
				documents.add(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}

}
