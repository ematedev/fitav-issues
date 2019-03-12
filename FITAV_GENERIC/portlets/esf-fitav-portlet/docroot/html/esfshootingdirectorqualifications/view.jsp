<%@page import="it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShootingDirectorQualification"%>
<%@include file="init.jsp"%>

<liferay-ui:error key="error-delete-shDrq" message="error-delete-shDrq" />

	<aui:button-row cssClass="esfshooter-admin-buttons">
		<portlet:renderURL var="newShootingDirectorQualificationURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "editshootingdirectorqualifications.jsp"%>' />
		</portlet:renderURL>

	<aui:button onClick="<%= newShootingDirectorQualificationURL.toString() %>" value="add-shDirectorQualifications" />
	</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-result" >

	<liferay-ui:search-container-results
		results = "<%=ESFShootingDirectorQualificationLocalServiceUtil.findAll(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total= "<%=ESFShootingDirectorQualificationLocalServiceUtil.countTotal()%>" />
	
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFShootingDirectorQualification" modelVar="shDtQ">
				
				<liferay-ui:search-container-column-text name="description" value="<%=shDtQ.getEsfShootingDirectorQualificationDesc() %>"/>
				<liferay-ui:search-container-column-jsp
					path='<%=templatePath + "esfshootingdirectorqualifications_actions.jsp"%>' align="right" />
		
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>