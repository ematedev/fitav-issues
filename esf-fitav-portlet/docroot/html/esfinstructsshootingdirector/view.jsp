<%@page import="it.ethica.esf.service.persistence.ESFInstructsShootingDirectorUtil"%>
<%@page import="it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil"%>
<%@include file="init.jsp"%>

	<aui:button-row cssClass="esfshooter-admin-buttons">
		<portlet:renderURL var="newShootingDirectorQualificationURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "editinstructorsshootingdirector.jsp"%>' />
		</portlet:renderURL>

	<aui:button onClick="<%= newShootingDirectorQualificationURL.toString() %>" value="add-InstructorsshDirector" />
	</aui:button-row>
	
<liferay-ui:search-container emptyResultsMessage="no-result" >

	<liferay-ui:search-container-results
		results = "<%=ESFInstructsShootingDirectorLocalServiceUtil.findAll(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total= "<%=ESFInstructsShootingDirectorLocalServiceUtil.total()%>" />
	
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFInstructsShootingDirector" modelVar="IshDt">
				
				<liferay-ui:search-container-column-text name="code" value="<%=IshDt.getEsfInstructsShootingDirectorCode() %>"/>
				<liferay-ui:search-container-column-text name="description" value="<%=IshDt.getEsfInstructsShootingDirectorDesc() %>"/>
				<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "esfinstructorsshootingdirector_actions.jsp"%>' align="right" />
		
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>