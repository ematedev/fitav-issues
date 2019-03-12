<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFElectronicURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "edit_esfElectronic.jsp" %>' />
</portlet:renderURL>

<liferay-ui:error key="esfElectronic-reference-error" message="esfElectronic-reference-error" />

<aui:button onClick="<%= addESFElectronicURL.toString() %>"
	value="add-electronic" />
					
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

		<liferay-ui:search-container-column-jsp
				path="/html/esfelectronic/esfElectronic_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>