<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>

<%

//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 



%>

<p class="lead category-label"><liferay-ui:message key="junioresFOM" /></p>


<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=junioresFOMURL%>">
	<liferay-ui:search-container-results
		results="<%= ESFUserLocalServiceUtil.findYouthByCategory(1, 2018, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFUserLocalServiceUtil.findYouthByCategoryTotal(1, 2018)%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="jonioresFOM">
		<liferay-ui:search-container-column-text property="lastName" />
		<liferay-ui:search-container-column-text property="firstName" />
		<liferay-ui:search-container-column-text name="birthday" value='<%=sdf.format(jonioresFOM.getBirthday())%>'/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<p class="lead category-label"><liferay-ui:message key="junioresFOF" /></p>


<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=junioresFOFURL%>">
	<liferay-ui:search-container-results
		results="<%= ESFUserLocalServiceUtil.findYouthByCategory(2, 2018, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFUserLocalServiceUtil.findYouthByCategoryTotal(2, 2018)%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="jonioresFOF">
		<liferay-ui:search-container-column-text property="lastName" />
		<liferay-ui:search-container-column-text property="firstName" />
		<liferay-ui:search-container-column-text name="birthday" value='<%=sdf.format(jonioresFOF.getBirthday())%>'/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>