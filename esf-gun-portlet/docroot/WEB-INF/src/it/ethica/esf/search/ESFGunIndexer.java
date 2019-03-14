package it.ethica.esf.search;

import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.permission.ESFGunModelPermission;
import it.ethica.esf.permission.ESFGunPermission;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFGunActionableDynamicQuery;
import it.ethica.esf.util.ActionKeys;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ESFGunIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { ESFGun.class.getName() };

	public static final String PORTLET_ID = PortletKeys.ESFGUN;

	public ESFGunIndexer() {

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

		return ESFGunModelPermission.contains(permissionChecker, entryClassPK,
				ActionKeys.VIEW_ESFGUN);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		ESFGun entry = (ESFGun)obj;

		deleteDocument(entry.getCompanyId(), entry.getEsfGunId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		ESFGun entry = (ESFGun)obj;

		Document document = getBaseModelDocument(PORTLET_ID, entry);

		String title = UserLocalServiceUtil
				.getUser(entry.getEsfUserId()).getFullName();
		
		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil
				.getESFGunKind(entry.getEsfGunKindId());
		ESFGunType esfGunType = ESFGunTypeLocalServiceUtil
				.getESFGunType(esfGunKind.getEsfGunTypeId());

		String content = StringUtil.add(esfGunType.getName(),
				esfGunKind.getName(), StringPool.SPACE);

		document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());
		document.addText(Field.CONTENT, content);
		document.addText(Field.TITLE, title);
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

		ESFGun entry = (ESFGun)obj;

		Document document = getDocument(entry);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), entry.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		ESFGun entry = ESFGunLocalServiceUtil.getESFGun(classPK);

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
				new ESFGunActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				ESFGun entry = (ESFGun) object;

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
