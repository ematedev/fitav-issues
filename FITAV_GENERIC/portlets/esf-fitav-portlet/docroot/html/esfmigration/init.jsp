<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@
page import="com.liferay.portal.model.Group"%><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil"%><%@
page import="com.liferay.portal.security.permission.ActionKeys"%><%@
page import="com.liferay.portal.service.permission.UserPermissionUtil"%><%@
page import="com.liferay.portal.service.permission.UserPermission"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%

long userId=realUser.getUserId();

 %>

<portlet:actionURL var="migrationOrganizationURL" name="migrationOrganization" >
</portlet:actionURL>

<portlet:actionURL var="migrationShooterURL" name="migrationShooter" >
</portlet:actionURL>


<portlet:actionURL var="updateShooterURL" name="updateShooter" >
</portlet:actionURL>


<portlet:actionURL var="migrationBDOURL"  name="migrationBDO">
</portlet:actionURL>

<portlet:actionURL var="migrationMatchesURL" name="migrationMatches" >
</portlet:actionURL>


<%--  
<portlet:actionURL var="migrationLayoutOrganizationURL" name="migrationLayoutOrganization" >
</portlet:actionURL>
--%> 




<portlet:actionURL var="migrationShooterSetDateURL" name="migrationShooterSetDate" >
</portlet:actionURL>