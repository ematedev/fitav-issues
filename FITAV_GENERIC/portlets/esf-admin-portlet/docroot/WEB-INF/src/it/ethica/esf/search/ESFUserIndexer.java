
package it.ethica.esf.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.permission.ESFUserPermission;
import it.ethica.esf.service.persistence.ESFUserActionableDynamicQuery;
import it.ethica.esf.util.PortletKeys;

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
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFUserIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {
		ESFUser.class.getName()
	};

	public static final String PORTLET_ID = PortletKeys.ESFUSER;

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
	public boolean hasPermission(
		PermissionChecker permissionChecker, String entryClassName,
		long entryClassPK, String actionId)
		throws Exception {

		return ESFUserPermission.contains(
			permissionChecker, entryClassPK, ActionKeys.VIEW);
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		ESFUser esfUser = (ESFUser) obj;

		deleteDocument(
			esfUser.getOriginalUser().getCompanyId(), esfUser.getEsfUserId());
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		ESFUser esfUser = (ESFUser) obj;
		User originalUser = esfUser.getOriginalUser();
		Document document = getBaseModelDocument(PORTLET_ID, esfUser);

		document.addDate(Field.MODIFIED_DATE, originalUser.getModifiedDate());
		document.addText(Field.TITLE, esfUser.getScreenName());
		document.addText(Field.CONTENT, esfUser.getLastName());

		document.addKeyword(Field.SCOPE_GROUP_ID, originalUser.getGroupId());
		document.addKeyword(Field.GROUP_ID, originalUser.getGroupId());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletURL portalURL)
		throws Exception {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Object obj)
		throws Exception {

		ESFUser esfUser = (ESFUser) obj;

		Document document = getDocument(esfUser);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), esfUser.getOriginalUser().getCompanyId(),
			document);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		reindexESFUsers(companyId);
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(classPK);

		doReindex(esfUser);
	}

	@Override
	protected String getPortletId(SearchContext sc) {

		return PORTLET_ID;
	}

	protected void reindexESFUsers(long companyId)
		throws SystemException, PortalException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery =
			new ESFUserActionableDynamicQuery() {

				@Override
				protected void addCriteria(DynamicQuery dynamicQuery) {

				}

				@Override
				protected void performAction(Object obj)
					throws PortalException, SystemException {

					ESFUser esfUser = (ESFUser) obj;

					Document document = getDocument(esfUser);

					documents.add(document);
				}
			};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
	}

}
