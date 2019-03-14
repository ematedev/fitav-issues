<%-- <%@ include file="init.jsp" %> --%>

<%
iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", templatePath + "view.jsp");
iteratorURL.setParameter("tabs1", "all-shooters");

shooterCount = ContactLocalServiceUtil.dynamicQuery(contactQuery).size();
%>

<liferay-ui:search-container 
	iteratorURL="<%= iteratorURL %>"
	delta="5"
	id="<%= String.valueOf(scid) %>"
	curParam="<%= String.valueOf(scid) %>"
	emptyResultsMessage="no-shooters-for-this-type">
	<liferay-ui:search-container-results		
		results="<%= ContactLocalServiceUtil.dynamicQuery(contactQuery,
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= shooterCount %>" />

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Contact" modelVar="shooterContact">

		<%
		ESFUser shooter = ESFUserLocalServiceUtil.getESFUser(shooterContact.getClassPK());
		%>
		<liferay-ui:search-container-column-text>
			<aui:input label=""
				type="checkbox"
				name="checkCandidate"
				value="<%= shooterContact.getContactId() %>"
				id='<%= "checkCandidate" + shooterContact.getClassPK() %>'
			/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="name" value="<%= shooter.getLastName() + StringPool.SPACE + shooter.getFirstName() %>"/>
		<liferay-ui:search-container-column-text name="email" value="<%= shooter.getUserEmail() %>"/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>

