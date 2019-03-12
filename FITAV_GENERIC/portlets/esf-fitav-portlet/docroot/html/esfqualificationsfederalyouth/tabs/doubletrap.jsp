<p class="lead category-label"><liferay-ui:message key="junioresDT" /></p>


<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=junioresDTURL%>">
	<liferay-ui:search-container-results
		results="<%= ESFUserLocalServiceUtil.findYouthByCategory(3, 2018, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFUserLocalServiceUtil.findYouthByCategoryTotal(3, 2018)%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="jonioresDT">
		<liferay-ui:search-container-column-text property="lastName" />
		<liferay-ui:search-container-column-text property="firstName" />
		<liferay-ui:search-container-column-text name="birthday" value='<%=sdf.format(jonioresDT.getBirthday())%>'/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>