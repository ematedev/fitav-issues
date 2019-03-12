<%@ include file="/html/init.jsp" %>

<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.EmailAddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.PhoneNumberException"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.PhoneServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalService"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactory"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page	import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.model.ESFUser"%>

<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="it.ethica.esf.model.impl.ESFOrganizationImpl"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="it.ethica.esf.model.impl.ESFCatridgeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.permission.ESFShootePermission"%>
<%@page import="it.ethica.esf.permission.ESFShooteModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFUserAdminPermission"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
page import="it.ethica.esf.model.ESFGun"%><%@
page import="it.ethica.esf.model.ESFGunKind"%><%@
page import="it.ethica.esf.model.ESFGunType"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%><%@
page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCatridge"%><%@
page import="it.ethica.esf.service.ESFCaneLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCane"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDocument"%>
<%@page import="it.ethica.esf.util.ESFListType"%>
<%@
page import="it.ethica.esf.util.ESFKeys.ESFAddressListType"%><%@
page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%><%@
page import="com.liferay.portal.model.Contact"%><%@
page import="com.liferay.portal.model.User"%><%@
page import="com.liferay.portal.service.UserLocalServiceUtil"%><%@
page import="com.liferay.portal.kernel.util.StringUtil"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="it.ethica.esf.util.ESFListType"%><%@
page import="it.ethica.esf.model.ESFCountry"%><%@
page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFDocument"%><%@
page import="org.joda.time.Days"%><%@
page import="org.joda.time.DateTime"%><%@
page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%><%@
page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCatridge"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.service.persistence.UserPersistence"%>
<%@page import="com.liferay.portal.util.Portal"%>
<%@page import="com.liferay.portal.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ContactLocalService"%>
<%@page import="it.ethica.esf.model.ESFJob"%>
<%@page import="it.ethica.esf.service.ESFJobLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>


<%
	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

	long currentOrganizationId = group.getOrganizationId();

	ESFOrganization currentESFOrganization =
		ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);

	int currentType = 0;

	if (currentESFOrganization != null) {

		currentType =
			Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
	}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view_search.jsp"%>' />
</liferay-portlet:renderURL>