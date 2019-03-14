<%@ include file="/html/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>
