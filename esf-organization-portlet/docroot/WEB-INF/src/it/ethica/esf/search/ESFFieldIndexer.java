package it.ethica.esf.search;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.permission.ESFFieldModelPermission;
import it.ethica.esf.service.persistence.ESFFieldActionableDynamicQuery;
import it.ethica.esf.util.PortletKeys;

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
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFFieldIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { ESFField.class.getName() };

	public static final String PORTLET_ID = PortletKeys.ESFFIELD;

	public ESFFieldIndexer() {

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

		return ESFFieldModelPermission.contains(permissionChecker, entryClassPK,
				ActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		ESFField entry = (ESFField)obj;

		deleteDocument(entry.getCompanyId(), entry.getEsfFieldId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		ESFField entry = (ESFField)obj;

		Document document = getBaseModelDocument(PORTLET_ID, entry);

		document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());
		document.addText(Field.CONTENT, entry.getName());
		document.addText(Field.TITLE, entry.getName());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(entry.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, entry.getGroupId());

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

		ESFField entry = (ESFField)obj;

		Document document = getDocument(entry);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), entry.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		ESFField entry = ESFFieldLocalServiceUtil.getESFField(classPK);

		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}
	
	protected void reindexEntries(long companyId) throws PortalException,
			SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = 
				new ESFFieldActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				ESFField entry = (ESFField) object;

				Document document = getDocument(entry);

				documents.add(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
				documents);
	}

}
