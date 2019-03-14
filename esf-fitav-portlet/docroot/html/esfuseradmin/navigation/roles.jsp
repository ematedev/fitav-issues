<%@include file="init.jsp"%>

<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/esfuseradmin/navigation/view.jsp");

%>

<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL %>">
	<liferay-ui:search-container-results>
	<%
		List<ESFUserESFUserRole> allESFUserESFUserRole=
			ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleByESFUserId(
				esfUserId,
				searchContainer.getStart(),
				searchContainer.getEnd());

		int totalESFUserESFUserRole =
			ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleCountByESFUserId(esfUserId);

		pageContext.setAttribute("results", allESFUserESFUserRole);
		pageContext.setAttribute("total", totalESFUserESFUserRole);
					
					
	%>
	</liferay-ui:search-container-results>


	<liferay-ui:search-container-row 
		className="it.ethica.esf.model.ESFUserESFUserRole" modelVar="esfUserESFUserRole">

		<%
			ESFUserRole esfUserRole = ESFUserRoleLocalServiceUtil.getESFUserRole(
				esfUserESFUserRole.getEsfUserRoleId());
		%>
		
		<liferay-ui:search-container-column-text name="title" 
		value='<%= esfUserRole.getTitle() %>' />

		<liferay-ui:search-container-column-text name="name" 
		value='<%= esfUserRole.getName() %>' />

		<liferay-ui:search-container-column-text name="description" 
		value='<%= esfUserRole.getDescription() %>' />
		
		<liferay-ui:search-container-column-text name="is-dbo" 
		value='<%= esfUserRole.getIsBDO()?"Si":"No" %>' />
		
		<liferay-ui:search-container-column-text name="is-lea" 
		value='<%= esfUserRole.getIsLEA()?"Si":"No" %>' />

		<liferay-ui:search-container-column-text name="start-date" 
			value="<%= sdf.format(esfUserESFUserRole.getStartDate())%>"/>

		<liferay-ui:search-container-column-text name="end-date"
			value='<%= esfUserESFUserRole.getEndDate() != null ? 
						sdf.format(esfUserESFUserRole.getStartDate()):
						""%>'/>


	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
