<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>


<%@page import="it.ethica.esf.model.ESFField"%><%@
page import="it.ethica.esf.permission.ESFFieldModelPermission"%><%@
page import="it.ethica.esf.permission.ESFFieldPermission"%><%@
page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%><%@

page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="it.ethica.esf.util.ActionKeys"%><%@
page import="com.liferay.portal.kernel.exception.PortalException"%><%@
page import="com.liferay.portal.kernel.exception.SystemException"%><%@
page import="com.liferay.portal.kernel.language.LanguageUtil"%><%@
page import="com.liferay.portal.kernel.log.Log"%><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil"%><%@
page import="com.liferay.portal.kernel.search.Document"%><%@
page import="com.liferay.portal.kernel.search.Field"%><%@
page import="com.liferay.portal.kernel.search.Hits"%><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%><%@
page import="com.liferay.portal.kernel.search.Indexer"%><%@
page import="com.liferay.portal.kernel.search.SearchContext"%><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory"%><%@
page import="com.liferay.portal.kernel.util.GetterUtil"%><%@
page import="com.liferay.portal.kernel.util.Validator"%><%@
page import="com.liferay.portal.util.PortalUtil"%><%@
page import="java.util.ArrayList"%><%@
page import="java.util.HashMap"%><%@
page import="java.util.List"%><%@
page import="java.util.Map"%>

<portlet:defineObjects />
<theme:defineObjects />

