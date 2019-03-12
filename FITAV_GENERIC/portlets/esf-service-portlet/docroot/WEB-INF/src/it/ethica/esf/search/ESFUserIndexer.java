package it.ethica.esf.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserActionableDynamicQuery;

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

public class ESFUserIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = { ESFUser.class.getName() };

    public static final String PORTLET_ID = "guestbook-portlet";
	
    public ESFUserIndexer() {
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
		ESFUser esfUser = (ESFUser)obj;
		
		deleteDocument(esfUser.getCompanyId(), esfUser.getEsfUserId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		ESFUser esfUser = (ESFUser)obj;
		Document document = getBaseModelDocument(PORTLET_ID, esfUser);
		
		document.addDate(Field.MODIFIED_DATE, esfUser.getModifiedDate());
		document.addText(Field.TITLE, esfUser.getScreenName());
		
		document.addKeyword(Field.SCOPE_GROUP_ID, esfUser.getGroupId());
		document.addKeyword(Field.GROUP_ID, esfUser.getGroupId());
		
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
		ESFUser esfUser = (ESFUser)obj;
		
		Document document = getDocument(esfUser);
		
		SearchEngineUtil.updateDocument(getSearchEngineId(), esfUser.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexESFUsers(companyId);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(classPK);
		
		doReindex(esfUser);
	}

	@Override
	protected String getPortletId(SearchContext sc) {
		
		return PORTLET_ID;
	}
	
	protected void reindexESFUsers(long companyId) throws SystemException, PortalException {
		
		final Collection<Document> documents = new ArrayList<Document>();
		
		ActionableDynamicQuery actionableDynamicQuery = new ESFUserActionableDynamicQuery() {
			@Override
            protected void addCriteria(DynamicQuery dynamicQuery) {
            }
			
			@Override
			protected void performAction(Object obj) throws PortalException,
					SystemException {
				
				ESFUser esfUser = (ESFUser)obj;
				
				Document document = getDocument(esfUser);
				
				documents.add(document);
			}
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}

}
