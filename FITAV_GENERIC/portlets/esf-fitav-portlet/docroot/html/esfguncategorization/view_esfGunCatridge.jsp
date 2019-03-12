<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="it.ethica.esf.permission.ESFGunCategorizationModelPermission"%>
<%@page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%>
<%@ include file="init.jsp"%>

<%
	long esfGunTypeId = ParamUtil
			.getLong(renderRequest, "esfGunTypeId");
	boolean isCatridge = false;
	

%>
<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</liferay-portlet:renderURL>



<%
	ESFGunType esfGunType = ESFGunTypeLocalServiceUtil
			.getESFGunType(esfGunTypeId);
%>

<h3><%=esfGunType.getName()%></h3>

<aui:button-row cssClass="esfguncategorization-admin-buttons">
<c:if test="<%= ESFGunCategorizationModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFGUNCATEGORIZZATION_ADD) %>">	
	<portlet:renderURL var="addESFGunCatridgeURL">
		<portlet:param name="mvcPath"
			value="/html/esfguncategorization/edit_esfGunCatridge.jsp" />
		<portlet:param name="esfGunTypeId"
			value="<%=String.valueOf(esfGunTypeId)%>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addESFGunCatridgeURL.toString() %>"
		value="add-esfgunkind" />
</c:if>		
		
	<aui:button onClick="<%= viewURL.toString() %>" value="go-back" />

</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
				results="<%= ESFCatridgeLocalServiceUtil.getESFCatridgesByType(esfGunTypeId,searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFCatridgeLocalServiceUtil.countESFCatridgesByType(esfGunTypeId) %>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFCatridge" modelVar="esfCatridge">

		<%
			String model = "";
					String name = "";
					String description = "";

					if (Validator.isNotNull(esfCatridge.getCatridgeModel())) {
						name = esfCatridge.getCatridgeModel();
					}
					if (Validator.isNotNull(esfCatridge.getNote())) {
						description = esfCatridge.getNote();
					}

					if (Validator.isNotNull(esfCatridge.getEsfGunTypeId())
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(esfCatridge
											.getEsfGunTypeId()))
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(
											esfCatridge.getEsfGunTypeId())
									.getName())) {

						model = ESFGunTypeLocalServiceUtil.fetchESFGunType(
								esfCatridge.getEsfGunTypeId()).getName();

					}
		%>

		<liferay-ui:search-container-column-text name="model"
			value="<%=model%>" />
		<liferay-ui:search-container-column-text name="Nome" value="<%=name%>" />
		<liferay-ui:search-container-column-text name="description"
			value="<%=description%>" />

<c:if test="<%= ESFGunPermission.containsCatridge(permissionChecker, esfCatridge.getEsfCatridgeId(), portletGroupId, ActionKeys.ESFGUN_VIEW_ACTION) %>">

		<liferay-ui:search-container-column-jsp
			path="/html/esfguncategorization/esfGunCatridge_actions.jsp"
			align="right" />
			
</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
