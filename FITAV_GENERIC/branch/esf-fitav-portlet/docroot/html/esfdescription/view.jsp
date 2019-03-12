<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFDescriptionURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_esfDescription.jsp"%>' />
</portlet:renderURL>

<liferay-ui:error key="esfDescription-reference-error"
	message="esfDescription-reference-error" />

<aui:button onClick="<%= addESFDescriptionURL.toString()%>"
	value="add-Description" />

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%=ESFDescriptionLocalServiceUtil.findAll()%>"
		total="<%=ESFDescriptionLocalServiceUtil.getESFDescriptionsCount()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFDescription"
		modelVar="esfDescription">

		<liferay-ui:search-container-column-text name="name" />
		<%
			String isNational = "";
					if (esfDescription.getIsNational() == true) {
						isNational =  "yes";
					}
					else {
						isNational =  "no";
					}
		%>
		<liferay-ui:search-container-column-text name="isNational"
			value="<%=res.getString(isNational)%>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfDescription_action.jsp"%>' align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>