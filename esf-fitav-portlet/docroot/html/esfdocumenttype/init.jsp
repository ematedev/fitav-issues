<%@ include file="/html/init.jsp"%>
<%@page import="it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDocumentType"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>