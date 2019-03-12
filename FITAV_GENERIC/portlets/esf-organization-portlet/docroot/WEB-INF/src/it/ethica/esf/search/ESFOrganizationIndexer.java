
package it.ethica.esf.search;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.permission.ESFOrganizationPermission;
import it.ethica.esf.service.persistence.ESFOrganizationActionableDynamicQuery;
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

public class ESFOrganizationIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {
		ESFOrganization.class.getName()
	};

	public static final String PORTLET_ID = PortletKeys.ESFORGANIZATION;

	public ESFOrganizationIndexer() {

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
	public boolean hasPermission(
		PermissionChecker permissionChecker, String esfOrganizationClassName,
		long esfOrganizationClassPK, String actionId)
		throws Exception {

		return ESFOrganizationPermission.contains(
			permissionChecker, esfOrganizationClassPK, ActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		ESFOrganization esfOrganization = (ESFOrganization) obj;

		deleteDocument(
			esfOrganization.getCompanyId(),
			esfOrganization.getEsfOrganizationId());

	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		ESFOrganization esfOrganization = (ESFOrganization) obj;

		Document document = getBaseModelDocument(PORTLET_ID, esfOrganization);

		document.addDate(Field.MODIFIED_DATE, esfOrganization.getModifiedDate());
		document.addText(Field.TITLE, esfOrganization.getName());
		
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(esfOrganization.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, esfOrganization.getGroupId());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale arg1, String arg2, PortletURL arg3)
		throws Exception {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Object obj)
		throws Exception {

		ESFOrganization esfOrganization = (ESFOrganization) obj;

		Document document = getDocument(esfOrganization);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), esfOrganization.getCompanyId(), document);

	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);

	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		ESFOrganization esfOrganization =
			ESFOrganizationLocalServiceUtil.getESFOrganization(classPK);

		doReindex(esfOrganization);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {

		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId)
		throws PortalException, SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery =
			new ESFOrganizationActionableDynamicQuery() {

				@Override
				protected void addCriteria(DynamicQuery dynamicQuery) {

				}

				@Override
				protected void performAction(Object object)
					throws PortalException {

					ESFOrganization esfOrganization = (ESFOrganization) object;

					Document document = getDocument(esfOrganization);

					documents.add(document);
				}

			};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
	}
}
