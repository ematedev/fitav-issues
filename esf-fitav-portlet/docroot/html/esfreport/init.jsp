<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@include file="/html/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="it.ethica.esf.service.CountryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualification"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.service.ESFElectronicLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFElectronic"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFBrandLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFBrand"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFField"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFBrand"%>
<%@page import="it.ethica.esf.model.ESFUnitservice"%>
<%@page import="it.ethica.esf.service.ESFUnitserviceLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.util.ESFListType"%>

 <%-- 
<portlet:defineObjects />
<liferay-theme:defineObjects /> 
--%>

<%

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

%>