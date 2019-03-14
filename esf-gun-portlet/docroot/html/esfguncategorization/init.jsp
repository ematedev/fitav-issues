<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="it.ethica.esf.permission.ESFGunTypePermission"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.permission.ESFGunModelPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.permission.ESFGunKindPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<portlet:defineObjects />
<theme:defineObjects />
