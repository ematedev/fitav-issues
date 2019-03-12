<%-- <%@ include file="init.jsp" %> --%>

<%
iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", templatePath + "add_esfnational.jsp");

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
		className="com.liferay.portal.model.Contact" modelVar="nationalContact">

		<%
		ESFUser shooter = ESFUserLocalServiceUtil.getESFUser(nationalContact.getClassPK());

		boolean isNational = ESFNationalLocalServiceUtil
				.isActiveESFNationals(nationalContact.getClassPK());
		%>

		<liferay-ui:search-container-column-text>
			<aui:input label=""
				disabled="<%= isNational %>"
				type="checkbox"
				name="checkNational"
				value="<%= nationalContact.getClassPK() %>"
				id='<%= "checkNational" + nationalContact.getClassPK() %>'
			/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text  name="name" value="<%= shooter.getLastName() + StringPool.SPACE + shooter.getFirstName() %>"/>
		<liferay-ui:search-container-column-text name="email" value="<%= shooter.getUserEmail() %>"/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>

