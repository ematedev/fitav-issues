<%@include file="init.jsp"%>
<%System.out.println("TESTTTTTT"); %>
<liferay-ui:success key="esfPartecipantInfo-success-insertupdate"
	message="esfPartecipantInfo-success-insertupdate-mess" />
<liferay-ui:success key="esfPartecipantInfo-success-insert"
	message="esfPartecipantInfo-success-insert" />
<liferay-ui:success key="esfPartecipantInfo-success-update"
	message="esfPartecipantInfo-success-update" />

<liferay-ui:error key="esfPartecipantInfo-message" message="esfPartecipantInfo-mess" />
	<aui:button-row cssClass="esfPartecipantInfo-admin-buttons">
		<portlet:renderURL var="addESFPartecipantInfoURL">
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfPartecipantInfo.jsp"%>' />
			<portlet:param name="organizationId"
				value="<%=String.valueOf(currentOrganizationId)%>" />	
			<portlet:param name="op" value="addAddr" />
		</portlet:renderURL>

		<aui:button onClick="<%= addESFPartecipantInfoURL.toString() %>"
			value="add-esfPartecipantInfo" />
	</aui:button-row>


<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%=true%>" label=""
				name="lastName" placeholder="last-name" size="30"
				title="search-entries" type="text" />  
			<aui:input inlineField="<%=true%>" label="" name="firstName"
				placeholder="first-name" size="30" title="search-entries"
				type="text" /> 
			<aui:input inlineField="<%=true%>" label="" name="protocolNumber" 
				placeholder="protocol-number" size="30" title="search-entries" type="text" /> 
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result">

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFPartecipantInfo" modelVar="esfPartecipant">

		<liferay-ui:search-container-column-text property="lastName"
			name="lastName" />
			
		<liferay-ui:search-container-column-text property="firstName"
			name="firstName" />
		
		<liferay-ui:search-container-column-text value="<%=String.valueOf(esfPartecipant.getProtocol())%>"
			name="protocolNumber" />
		
		<liferay-ui:search-container-column-text value="<%=String.valueOf(esfPartecipant.getFiscalCode())%>"
			name="fiscalCode" />
		
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfPartecipant.getDateOfBirth())%>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfPartecipant_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
