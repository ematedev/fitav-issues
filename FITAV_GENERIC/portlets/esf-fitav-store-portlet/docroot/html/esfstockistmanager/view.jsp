<%@page import="it.ethica.esf.permission.ESFArticleTypeManagerModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFStokistModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFStokistPermission"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="esfStockistError"
message="esfStockistError" />

<liferay-ui:error key="esfOrderReferenceError"
message="esfOrderReferenceError" />

<c:if test="<%= ESFArticleTypeManagerModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFARTICOLTYPE_ADD) %>">	
		<aui:button-row cssClass="esfstockist-admin-buttons">

				<portlet:renderURL var="addESFStockistURL">
					<portlet:param name="mvcPath"
						value='<%= "/html/esfstockistmanager/"+"edit_esfStockist.jsp" %>' />
				</portlet:renderURL>
			<aui:button onClick="<%= addESFStockistURL %>"
					value="add-esfstockist" />
		</aui:button-row>
</c:if>

		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results results="<%= ESFStockistLocalServiceUtil.getESFStockists() %>"
												 total="<%= ESFStockistLocalServiceUtil.getESFStockistsCount() %>" />

			<liferay-ui:search-container-row className="com.ethica.esf.model.ESFStockist" modelVar="esfStockist">
					<liferay-ui:search-container-column-text name="name" value="<%= esfStockist.getName() %>" />
					<liferay-ui:search-container-column-text >
						<a href="mailto:<%=esfStockist.getEmail()%>" target="_top"><p><%=esfStockist.getEmail()%></p></a>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="phone" value="<%= esfStockist.getPhone() %>" />
					<liferay-ui:search-container-column-text name="address" value="<%= esfStockist.getAddress() %>" />
					<liferay-ui:search-container-column-text name="description" value="<%= esfStockist.getDescription() %>" />

<c:if test="<%= ESFStokistPermission.contains(permissionChecker,esfStockist.getEsfStockistId(), scopeGroupId, ActionKeys.ESFSTOKISTMANAGER_UPDATE) ||
					ESFStokistPermission.contains(permissionChecker, esfStockist.getEsfStockistId() , scopeGroupId , ActionKeys.ESFSTOKISTMANAGER_REMOVE)%>">	
			<liferay-ui:search-container-column-jsp
					path='<%= templatePath + "esfStockist_actions.jsp" %>' align="right" />

</c:if>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>