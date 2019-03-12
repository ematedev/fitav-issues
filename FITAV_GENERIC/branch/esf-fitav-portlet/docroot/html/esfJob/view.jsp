<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFJobURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_esfJob.jsp"%>' />
</portlet:renderURL>

<liferay-ui:error key="esfJob-reference-error"
	message="esfJob-reference-error" />

<aui:button onClick="<%= addESFJobURL.toString()%>"
	value="add-Job" />

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%=ESFJobLocalServiceUtil.findAll()%>"
		total="<%=ESFJobLocalServiceUtil.getESFJobsCount()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFJob"
		modelVar="esfJob">
		
			<%
			String job = esfJob.getEsfName();
			%>
		<liferay-ui:search-container-column-text name="job" 
			value="<%=job%>" />

<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfJob_action.jsp"%>' align="right" />
			
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>