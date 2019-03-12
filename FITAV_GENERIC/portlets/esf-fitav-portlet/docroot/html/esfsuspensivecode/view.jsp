<%@page import="it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil"%>
<%@include file="init.jsp"%>

<liferay-ui:error key="error-delete-suCode" message="error-delete-suCode" />

<aui:button-row cssClass="esfshooter-admin-buttons">
	<portlet:renderURL var="newSuspensiveCodeURL">
		<portlet:param name="mvcPath" value='<%=templatePath + "suspensivecode_edit.jsp"%>' />
	</portlet:renderURL>

	<aui:button onClick="<%= newSuspensiveCodeURL.toString() %>" value="add-suspensive-code" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-result" >
		<liferay-ui:search-container-results
		results = "<%= ESFSuspensiveCodeLocalServiceUtil.findAll(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total= "<%= ESFSuspensiveCodeLocalServiceUtil.conutTotal()%>" />
		
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFSuspensiveCode" modelVar="suCd">
		
		<liferay-ui:search-container-column-text name="code" value="<%=suCd.getCode() %>"/>
		<liferay-ui:search-container-column-text name="description" value="<%=suCd.getDescription() %>"/>
		<liferay-ui:search-container-column-jsp
					path='<%=templatePath + "suspensivecode_actions.jsp"%>' align="right" />
		
				
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>