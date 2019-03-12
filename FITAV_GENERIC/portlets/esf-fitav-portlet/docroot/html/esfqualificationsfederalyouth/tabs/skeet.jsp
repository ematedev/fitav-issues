<p class="lead category-label"><liferay-ui:message key="junioresSKM" /></p>


<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=junioresSKMURL%>">
	<liferay-ui:search-container-results
		results="<%= ESFUserLocalServiceUtil.findYouthByCategory(4, 2018, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFUserLocalServiceUtil.findYouthByCategoryTotal(4, 2018)%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="junioresSKM">
		<liferay-ui:search-container-column-text property="lastName" />
		<liferay-ui:search-container-column-text property="firstName" />
		<liferay-ui:search-container-column-text name="birthday" value='<%=sdf.format(junioresSKM.getBirthday())%>'/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<p class="lead category-label"><liferay-ui:message key="junioresSKF" /></p>


<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%=junioresSKFURL%>">
	<liferay-ui:search-container-results
		results="<%= ESFUserLocalServiceUtil.findYouthByCategory(5, 2018, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%= ESFUserLocalServiceUtil.findYouthByCategoryTotal(5, 2018)%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="junioresSKF">
		<liferay-ui:search-container-column-text property="lastName" />
		<liferay-ui:search-container-column-text property="firstName" />
		<liferay-ui:search-container-column-text name="birthday" value='<%=sdf.format(junioresSKF.getBirthday())%>'/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>