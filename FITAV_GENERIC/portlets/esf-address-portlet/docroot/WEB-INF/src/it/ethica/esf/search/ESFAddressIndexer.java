package it.ethica.esf.search;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFAddressActionableDynamicQuery;
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


public class ESFAddressIndexer extends BaseIndexer{

	public static final String[] CLASS_NAMES = { ESFAddress.class.getName() };
	
	public static final String PORTLET_ID = PortletKeys.ESFADDRESS;
	
	public ESFAddressIndexer() {
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
		
		ESFAddress esfAddress = (ESFAddress)obj;
		deleteDocument(esfAddress.getCompanyId(), esfAddress.getEsfAddressId());
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {
		ESFAddress esfAddress = (ESFAddress)obj;
		
		Document document = getBaseModelDocument(PORTLET_ID, esfAddress);
		System.out.println("GROUP ID IS: "+esfAddress.getGroupId());
		document.addDate(Field.MODIFIED_DATE, esfAddress.getModifiedDate());
		document.addText(Field.CONTENT, esfAddress.getStreet1());
		document.addText(Field.TITLE, esfAddress.getStreet1());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(esfAddress.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, esfAddress.getGroupId());
		document.addText("street1", esfAddress.getStreet1());
		document.addNumber("longitude", esfAddress.getLongitude());
		document.addNumber("latitude", esfAddress.getLatitude());
		
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

		ESFAddress esfAddress = (ESFAddress)obj;

		Document document = getDocument(esfAddress);
		System.out.println("In doReindex the companyId is: "+esfAddress.getCompanyId());
		SearchEngineUtil.updateDocument(
			getSearchEngineId(), esfAddress.getCompanyId(), document);
		
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		ESFAddress esfAddress = ESFAddressLocalServiceUtil.getESFAddress(classPK);

		doReindex(esfAddress);
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
			new ESFAddressActionableDynamicQuery() {

				@Override
				protected void addCriteria(DynamicQuery dynamicQuery) {

				}

				@Override
				protected void performAction(Object object)
					throws PortalException {

					ESFAddress esfAddress = (ESFAddress) object;

					Document document = getDocument(esfAddress);

					documents.add(document);
				}

			};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
}

}
