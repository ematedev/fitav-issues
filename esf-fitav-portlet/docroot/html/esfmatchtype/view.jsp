<%@page import="it.ethica.esf.permission.ESFMatchTypePermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFMatchTypeModelPermission"%>
<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFMatchTypeURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "edit_esfMatchType.jsp" %>' />
</portlet:renderURL>

<liferay-ui:error key="esfMatchtype-reference-error"
	message="esfMatchType-reference-error" />

<c:if test="<%= ESFMatchTypeModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFMATCHTYPE_ADD) %>">

	<aui:button onClick= "<%= addESFMatchTypeURL.toString()%>" 
		value="add-MatchType" />
		
</c:if>

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

<c:if test="<%= ESFMatchTypePermission.contains(permissionChecker,esfMatchType.getEsfMatchTypeId(), scopeGroupId, ActionKeys.ESFMATCHTYPE_VIEW_ACTION) %>">

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfMatchType_actions.jsp"%>' align="right" />
</c:if>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
