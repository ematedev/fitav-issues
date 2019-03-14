
package it.ethica.esf.search;

import it.ethica.esf.model.ESFTool;
import it.ethica.esf.service.ESFToolLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFToolActionableDynamicQuery;
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

public class ESFToolIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {
		ESFTool.class.getName()
	};

	public static final String PORTLET_ID = PortletKeys.ESFUSERADMIN;

	public ESFToolIndexer() {

		setPermissionAware(true);
	}

	@Override
	public String[] getClassNames() {

		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {

		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		ESFTool esfTool = (ESFTool) obj;
		deleteDocument(esfTool.getCompanyId(), esfTool.getEsfToolId());
		// TODO Auto-generated method stub
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		ESFTool esfTool = (ESFTool) obj;

		Document document = getBaseModelDocument(PORTLET_ID, esfTool);
		document.addDate(Field.MODIFIED_DATE, esfTool.getModifiedDate());
		document.addText(Field.CONTENT, esfTool.getDescription());
		document.addText(Field.TITLE, esfTool.getName());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(esfTool
				.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, esfTool.getGroupId());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletURL portletURL)
		throws Exception {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Object obj)
		throws Exception {

		ESFTool esfTool = (ESFTool) obj;

		Document document = getDocument(esfTool);
		SearchEngineUtil.updateDocument(
			getSearchEngineId(), esfTool.getCompanyId(), document);

	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		ESFTool esfTool =
			ESFToolLocalServiceUtil.getESFTool(classPK);

		doReindex(esfTool);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId)
		throws PortalException, SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery =
			new ESFToolActionableDynamicQuery() {

				@Override
				protected void addCriteria(DynamicQuery dynamicQuery) {

				}

				@Override
				protected void performAction(Object object)
					throws PortalException {

					ESFTool ESFTool = (ESFTool) object;

					Document document = getDocument(ESFTool);

					documents.add(document);
				}

			};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
	}

}
