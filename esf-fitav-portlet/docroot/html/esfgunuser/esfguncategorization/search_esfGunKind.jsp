<%@ include file="../init.jsp" %>
<%@page import="it.ethica.esf.permission.ESFGunKindPermission"%>

<%

	String name = ParamUtil.getString(request, "name");
	String description = ParamUtil.getString(request, "description");
	String model = ParamUtil.getString(request, "model");
	long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
	long esfGunId = ParamUtil.getLong(request, "esfGunId");
%>

<liferay-portlet:renderURL varImpl="viewCategorizationURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "esfguncategorization/view.jsp"%>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchCategorizationURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "esfguncategorization/search_esfGunKind.jsp"%>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchCategorizationURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="name" placeholder="name"
					size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="description" placeholder="description"
					size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="model" placeholder="model"
					size="30" title="search-entries" type="text" />
			<aui:input  name="esfGunTypeId"  type="hidden" value="<%= esfGunTypeId%>"/>
			
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUNKIND) %>">

		<%
		ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);
		%>

		<h3><%= esfGunType.getName() %></h3>

		<aui:button-row cssClass="esfguncategorization-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUNKIND) %>'>
				<portlet:renderURL var="addESFGunKindURL">
					<portlet:param name="mvcPath"
						value="/html/esfgunuser/esfguncategorization/edit_esfGunKind.jsp" />
					<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
					<portlet:param name="flagSearch" value="<%= String.valueOf(true) %>" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunKindURL.toString() %>"
					value="Add ESFGunKind" />

				<aui:button onClick="<%= viewURL.toString() %>" value="back" />
			</c:if>
		</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFGunKindLocalServiceUtil.getESFGunKindsByLikeN_D_M(
						name, description, model, esfGunTypeId,
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunKindLocalServiceUtil.getESFGunKindsByLikeN_D_M(
								name, description, model, esfGunTypeId).size() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGunKind" modelVar="esfGunKind">

				<c:if test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.UPDATE) %>">
					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
					<liferay-ui:search-container-column-text property="model" />
					<liferay-ui:search-container-column-text property="caliber" />
				</c:if>

				<c:if test="<%= ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.UPDATE) ||
						ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.PERMISSIONS) ||
						ESFGunKindPermission.contains(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.DELETE) %>">

					<liferay-ui:search-container-column-jsp
							path="/html/esfgunuser/esfguncategorization/esfGunKind_actions.jsp" 
				 			align="right" />
			 	</c:if>

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
