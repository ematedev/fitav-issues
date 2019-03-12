<%@page import="it.ethica.esf.permission.ESFSportTypeModelPermission"%>
<%@include file="init.jsp" %>




		<liferay-ui:error key="esfSportRype-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFSportType.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfsporttype-admin-buttons">

				<portlet:renderURL var="addESFSportTypeURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfSportType.jsp"%>' />
				</portlet:renderURL>

<c:if test="<%= ESFSportTypeModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ESFSPORTTYPE_ADD) %>">

				<aui:button onClick="<%= addESFSportTypeURL.toString() %>"
					value="add-esfsporttype" />
</c:if>

		</aui:button-row>
		
		<aui:form action="<%=searchURL%>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="search-form">
				<span class="aui-search-bar"> <aui:input
						inlineField="<%=true%>" label="" name="name"
						placeholder="name" size="30" title="search-entries" type="text" />
				<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFSportTypeLocalServiceUtil.getAllESFSportTypes(
								searchContainer.getStart(),
								searchContainer.getEnd()) %>"
				total="<%= ESFSportTypeLocalServiceUtil.getAllESFSportTypes().size() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFSportType" modelVar="esfSportType">
					
					<liferay-ui:search-container-column-text property="code" />
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
					<%
						String National = "";
											if (esfSportType.getNational()) {
												National = "yes";
											} else {
												National = "no";
											}
					%>
					<liferay-ui:search-container-column-text name="national" value="<%=res.getString(National) %>"/>
										<%
						String isOlimpic = "";
											if (esfSportType.getIsOlimpic()) {
												isOlimpic = "yes";
											} else {
												isOlimpic = "no";
											}
					%>
					<liferay-ui:search-container-column-text name="olimpicSport" value="<%=res.getString(isOlimpic) %>"/>

<c:if test="<%= ESFSportTypePermission.contains(permissionChecker,esfSportType.getEsfSportTypeId(), scopeGroupId, ActionKeys.ESFSPORTTYPE_VIEW_ACTION) %>">

					<liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfSportType_actions.jsp"%>'
				 			align="right" />
</c:if>
			
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
