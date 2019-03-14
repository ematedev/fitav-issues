<%@page import="it.ethica.esf.permission.ESFElectronicModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFElectronicPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFElectronicURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "edit_esfElectronic.jsp" %>' />
</portlet:renderURL>

<liferay-ui:error key="esfElectronic-reference-error" message="esfElectronic-reference-error" />

<c:if test="<%= ESFElectronicModelPermission.contains(permissionChecker, groupId, ActionKeys.ESFELECTRONIC_ADD) %>">
	
	<aui:button onClick="<%= addESFElectronicURL.toString() %>"
	value="add-electronic" />
	
</c:if>
	
<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results>
		<%
		List<ESFElectronic> elettronicSE = ESFElectronicLocalServiceUtil.getESFElectronics(
				searchContainer.getStart(), searchContainer.getEnd());
		int tot = ESFElectronicLocalServiceUtil.getESFElectronicsCount();
		List<ESFElectronic> elettronic = new ArrayList <ESFElectronic>(elettronicSE);
		
		pageContext.setAttribute("results", elettronic);
		pageContext.setAttribute("total", tot);
		
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFElectronic"
		modelVar="esfElectronic">
		
		<liferay-ui:search-container-column-text name="name" />
		<liferay-ui:search-container-column-text name="description"/>

	<c:if test="<%= ESFElectronicPermission.contains(permissionChecker,esfElectronic.getElectronicId(), groupId, ActionKeys.ESFELECTRONIC_VIEW_ACTION) %>">
	
		<liferay-ui:search-container-column-jsp
				path="/html/esfelectronic/esfElectronic_actions.jsp" align="right" />
	</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>