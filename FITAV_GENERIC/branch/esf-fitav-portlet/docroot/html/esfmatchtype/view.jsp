<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFMatchTypeURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "edit_esfMatchType.jsp" %>' />
</portlet:renderURL>

<liferay-ui:error key="esfMatchtype-reference-error"
	message="esfMatchType-reference-error" />

<aui:button onClick= "<%= addESFMatchTypeURL.toString()%>" 
	value="add-MatchType" />

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%=ESFMatchTypeLocalServiceUtil.getESFMatchTypes(searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFMatchTypeLocalServiceUtil.getESFMatchTypesCount()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFMatchType" modelVar="esfMatchType">

		<liferay-ui:search-container-column-text name="name" />
		<%
		String isCategoryQualification="";
		if(esfMatchType.getIsCategoryQualification()){
			isCategoryQualification = "yes";
		}
		else{
			isCategoryQualification="no";
		}
		%>
		<liferay-ui:search-container-column-text
			name="isCategoryQualification"
			value="<%=res.getString(isCategoryQualification)%>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfMatchType_actions.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
