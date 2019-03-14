<%-- <%@ include file="init.jsp" %> --%>

<%
iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", templatePath + "view.jsp");

nationalCount = ContactLocalServiceUtil.dynamicQuery(contactQuery).size();
%>

<liferay-ui:search-container emptyResultsMessage="no-national-for-this-type">

	<liferay-ui:search-container-results
		results="<%= ContactLocalServiceUtil.dynamicQuery(contactQuery,
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= nationalCount %>" />

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Contact" modelVar="nationalContact">

		<%
		ESFUser shooter = ESFUserLocalServiceUtil.getESFUser(nationalContact.getClassPK());

		ESFNational esfNational = ESFNationalLocalServiceUtil.getActiveESFNational(nationalContact.getClassPK());

		ESFSportType esfSportType = ESFSportTypeLocalServiceUtil.getESFSportType(esfNational.getEsfSportTypeId());

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		%>

		<liferay-ui:search-container-column-text  name="name" value="<%= shooter.getLastName() + StringPool.SPACE + shooter.getFirstName() %>"/>
		<liferay-ui:search-container-column-text name="email" value="<%= shooter.getUserEmail() %>"/>
		<liferay-ui:search-container-column-text name="startDate" value="<%= sdf.format(esfNational.getStartDate()) %>"/>
		<liferay-ui:search-container-column-text name="endDate" value="<%= sdf.format(esfNational.getEndDate()) %>"/>
		<liferay-ui:search-container-column-text name="esfSportType" value="<%= esfSportType.getName() %>"/>

		<liferay-ui:search-container-column-jsp
			path='<%= templatePath + "national_actions.jsp"%>'
			align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>

