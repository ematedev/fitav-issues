<%@page import="it.ethica.esf.permission.ESFArticleTypeManagerPermission"%>
<%@page import="it.ethica.esf.permission.ESFArticleTypeManagerModelPermission"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="esfArticleTypeDescriptionError"
message="Type with this description already exists" />

<liferay-ui:error key="esfArticleReferenceError"
message="Can not delete the type. Exists an association with an article" />

<liferay-ui:error key="esfArticleDeliveredShooterError"
message="Can not save the article's deliver. No select a shooter" />

		<aui:button-row cssClass="esfarticletype-admin-buttons">
			<c:if test="<%= ESFArticleTypeManagerModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFARTICOLTYPE_ADD)  %>">

				<portlet:renderURL var="addESFArticleTypeURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfArticleType.jsp" %>' />
				</portlet:renderURL>
				
			<aui:button onClick="<%= addESFArticleTypeURL.toString() %>"
					value="add-esfarticletype" />
			</c:if>
		</aui:button-row>

		<portlet:renderURL var="editURL">

		</portlet:renderURL>
		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results results="<%= ESFArticleTypeLocalServiceUtil.getESFArticleTypes() %>"
												 total="<%= ESFArticleTypeLocalServiceUtil.getESFArticleTypesCount() %>" />

			<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticleType" modelVar="esfArticleType">
					<liferay-ui:search-container-column-text name="description" value="<%= esfArticleType.getDescription() %>" />
					<liferay-ui:search-container-column-text name="area" value="<%= esfArticleType.getArea() %>" />
					<liferay-ui:search-container-column-text name="department" value="<%= esfArticleType.getDepartment() %>" />
<c:if test="<%=ESFArticleTypeManagerPermission.contains(permissionChecker,esfArticleType.getEsfArticleTypeId(), scopeGroupId, ActionKeys.ESFARTICOLTYPE_UPDATE) ||
					ESFArticleTypeManagerPermission.contains(permissionChecker, esfArticleType.getEsfArticleTypeId() , scopeGroupId , ActionKeys.ESFARTICOLTYPE_REMOVE)%>">	
			<liferay-ui:search-container-column-jsp
					path='<%= templatePath + "esfArticleType_actions.jsp" %>' align="right" />
</c:if>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>