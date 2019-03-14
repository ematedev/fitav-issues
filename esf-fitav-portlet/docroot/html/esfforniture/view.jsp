<%@ include file="init.jsp" %>

<%List <ESFForniture> esfFornitures = ESFFornitureLocalServiceUtil.getAllESFFornitures(); %>

<c:choose>
	<c:when test="<%= ESFModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFSPORTTYPE) %>">

		<liferay-ui:error key="esfforniture-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFForniture.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfforniture-admin-buttons">
			<c:if test='<%= ESFModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFSPORTTYPE) %>'>
				<portlet:renderURL var="addESFFornitureURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfForniture.jsp"%>' />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFFornitureURL.toString() %>"
					value="add-esfforniture" />
			</c:if>
		</aui:button-row>
	
		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results results="<%= ESFFornitureLocalServiceUtil.getAllESFFornitures() %>"
												 total="<%= ESFFornitureLocalServiceUtil.getESFFornituresCount() %>" />

			<liferay-ui:search-container-row className="it.ethica.esf.model.ESFForniture" modelVar="esfForniture">

					<liferay-ui:search-container-column-text name="code" value="<%=esfForniture.getCode() %>"/>
					<liferay-ui:search-container-column-text name="name" value="<%=esfForniture.getName() %>"/>
					<liferay-ui:search-container-column-text name="description" value="<%=esfForniture.getDescription() %>" />
					<liferay-ui:search-container-column-text name="sizeDress" value="<%=esfForniture.getSize() %>" />
					<liferay-ui:search-container-column-text name="type" value="<%=ESFFornitureTypeLocalServiceUtil.getESFFornitureType(esfForniture.getType()).getDescription() %>" />
					<liferay-ui:search-container-column-text name="number-fornitures" value="<%=Long.toString(esfForniture.getNumberFornitures()) %>" />
	         <liferay-ui:search-container-column-jsp
							path='<%= templatePath + "esfForniture_actions.jsp"%>'
				 			align="right" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>