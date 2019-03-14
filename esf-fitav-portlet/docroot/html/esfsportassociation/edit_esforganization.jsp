<%@include file="init.jsp"%>

<%
	int numberOfPhones = 3;

	String[] _CATEGORY_NAMES = new String[] {"Main"};
	
	String[][] categorySections = new String[][] {{"details", "addresses", "phones"}};
	
%>

<portlet:actionURL name="editESFOrganization" var="editESFOrganizationURL">
	<portlet:param name="esfOrganizationId" 	value="<%=String.valueOf(esfOrganizationId)%>" />
	<portlet:param name="isSimplyOrganizzation" 	value="<%=String.valueOf(isSimplyOrganizzation)%>" />
</portlet:actionURL>

<div>
	<h3><liferay-ui:message key="new-esf-sport-association" /></h3>

	<aui:form action="<%=editESFOrganizationURL.toString()%>" name="fma">

		<%
			request.setAttribute("addresses.className", Organization.class.getName());
			request.setAttribute("addresses.classPK", esfOrganizationId);
			request.setAttribute("emailAddresses.className", ESFOrganization.class.getName());
			request.setAttribute("emailAddresses.classPK", esfOrganizationId);
			request.setAttribute("phones.className", Organization.class.getName());
			request.setAttribute("phones.classPK", esfOrganizationId);
			request.setAttribute("phones.number", numberOfPhones);
			request.setAttribute("websites.className", ESFOrganization.class.getName());
			request.setAttribute("websites.classPK", esfOrganizationId);
		%>

		<liferay-ui:form-navigator backURL="<%=viewURL%>"
			categoryNames="<%=_CATEGORY_NAMES%>"
			categorySections="<%=categorySections%>"
			formName="fma"
			jspPath='<%=templatePath + "navigation/"%>' />
				
		<aui:button-row cssClass="esfesfsportassociation-buttons">
				
			<aui:button onClick="<%= viewURL.toString() %>"	value='cancel'  />
					
		</aui:button-row>
	</aui:form>
</div>
	