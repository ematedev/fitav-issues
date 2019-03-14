<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="it.ethica.esf.permission.ESFGunCategorizationModelPermission"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@ include file="init.jsp"%>

<%
	long esfGunTypeId = ParamUtil
			.getLong(renderRequest, "esfGunTypeId");
	boolean isCatridge = false;
	ESFGunType type = new ESFGunTypeImpl();
	type = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunTypeId);

	if (esfGunTypeId > 0 && Validator.isNotNull(type)
			&& Validator.isNotNull(type.getIsCatridgeProductor())) {

		isCatridge = type.getIsCatridgeProductor();
	}
%>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "search_esfGunKind.jsp"%>' />
</liferay-portlet:renderURL>

<%
	ESFGunType esfGunType = ESFGunTypeLocalServiceUtil
			.getESFGunType(esfGunTypeId);
%>

<h3><%=esfGunType.getName()%></h3>

<c:if test="<%= ESFGunCategorizationModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFGUNCATEGORIZZATION_ADD) %>">	

<aui:button-row cssClass="esfguncategorization-admin-buttons">

	<portlet:renderURL var="addESFGunKindURL">
		<portlet:param name="mvcPath"
			value="/html/esfguncategorization/edit_esfGunKind.jsp" />
		<portlet:param name="esfGunTypeId"
			value="<%=String.valueOf(esfGunTypeId)%>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addESFGunKindURL.toString() %>"
		value="add-esfgunkind" />
	<aui:button onClick="<%= viewURL.toString() %>" value="go-back" />

</aui:button-row>
</c:if>

<liferay-ui:search-container emptyResultsMessage="no-results">
				<liferay-ui:search-container-results
				results="<%= ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(
						esfGunTypeId,
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunKindLocalServiceUtil.getESFGunKindCountByESFGunType(esfGunTypeId) %>" />
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGunKind" modelVar="esfGunKind">

		<%
			String model = "";
					String name = "";
					String description = "";

					if (Validator.isNotNull(esfGunKind.getName())) {
						name = esfGunKind.getName();
					}
					if (Validator.isNotNull(esfGunKind.getDescription())) {
						description = esfGunKind.getDescription();
					}

					if (Validator.isNotNull(esfGunKind.getEsfGunTypeId())
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(esfGunKind
											.getEsfGunTypeId()))
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(
											esfGunKind.getEsfGunTypeId())
									.getName())) {

						model = ESFGunTypeLocalServiceUtil.fetchESFGunType(
								esfGunKind.getEsfGunTypeId()).getName();

					}
		%>

		<liferay-ui:search-container-column-text name="model"
			value="<%=model%>" />
		<liferay-ui:search-container-column-text name="Nome" value="<%=name%>" />
		<liferay-ui:search-container-column-text name="description"
			value="<%=description%>" />

<c:if test="<%= ESFGunPermission.containsRifle(permissionChecker, esfGunKind.getEsfGunKindId(), ActionKeys.ESFGUN_VIEW_ACTION) %>">
		<liferay-ui:search-container-column-jsp
			path="/html/esfguncategorization/esfGunKind_actions.jsp"
			align="right" />
</c:if>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
