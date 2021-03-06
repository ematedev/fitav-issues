package it.ethica.esf.search;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFCardActionableDynamicQuery;
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


public class ESFCardIndexer extends BaseIndexer {

public static final String[] CLASS_NAMES = { ESFCard.class.getName() };
	
	public static final String PORTLET_ID = PortletKeys.ESFCARD;
	
	public ESFCardIndexer() {
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
		
		ESFCard ESFCard = (ESFCard)obj;
		deleteDocument(ESFCard.getCompanyId(), ESFCard.getEsfCardId());
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {
		ESFCard ESFCard = (ESFCard)obj;
		
		Document document = getBaseModelDocument(PORTLET_ID, ESFCard);
		document.addDate(Field.MODIFIED_DATE, ESFCard.getModifiedDate());
		document.addText(Field.CONTENT, ESFCard.getCode());
		document.addText(Field.TITLE, ESFCard.getCode());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(ESFCard.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, ESFCard.getGroupId());
		document.addDate("startDate", ESFCard.getStartDate());
		document.addDate("endDate", ESFCard.getEndDate());
		
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

		ESFCard ESFCard = (ESFCard)obj;

		Document document = getDocument(ESFCard);
		System.out.println("In doReindex the companyId is: "+ESFCard.getCompanyId());
		SearchEngineUtil.updateDocument(
			getSearchEngineId(), ESFCard.getCompanyId(), document);
		
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		ESFCard ESFCard = ESFCardLocalServiceUtil.getESFCard(classPK);

		doReindex(ESFCard);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		System.out.println("In doReindex(String[]) the companyId is: "+companyId);
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
			new ESFCardActionableDynamicQuery() {

				@Override
				protected void addCriteria(DynamicQuery dynamicQuery) {

				}

				@Override
				protected void performAction(Object object)
					throws PortalException {

					ESFCard ESFCard = (ESFCard) object;

					Document document = getDocument(ESFCard);

					documents.add(document);
				}

			};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
}

}
