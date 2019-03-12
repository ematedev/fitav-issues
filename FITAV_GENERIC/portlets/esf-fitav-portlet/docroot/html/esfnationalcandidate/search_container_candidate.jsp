<%-- <%@ include file="init.jsp" %> --%>

<%
iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", templatePath + "view.jsp");

shooterCount = candidatesList.size();
%>

<liferay-ui:search-container emptyResultsMessage="no-candidate-for-this-type">

	<liferay-ui:search-container-results		
		results="<%= candidatesList %>"
		total="<%= shooterCount %>" />

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Contact" modelVar="shooterContact">

		<%
		ESFUser shooter = ESFUserLocalServiceUtil.getESFUser(shooterContact.getClassPK());
		%>

		<liferay-ui:search-container-column-text  name="name" value="<%= shooter.getLastName() + StringPool.SPACE + shooter.getFirstName() %>"/>
		<liferay-ui:search-container-column-text name="email" value="<%= shooter.getUserEmail() %>"/>

		<liferay-ui:search-container-column-jsp
			path='<%= templatePath + "delete_candidate.jsp"%>'
			align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>

