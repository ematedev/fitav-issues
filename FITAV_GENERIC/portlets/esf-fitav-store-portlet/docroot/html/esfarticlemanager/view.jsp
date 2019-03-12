
<%@page import="it.ethica.esf.permission.ESFArticleManagerPermission"%>
<%@page import="it.ethica.esf.permission.ESFArticleManagerModelPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="esfArticleCodeError"
message="esfArticleCodeError" />

<liferay-ui:error key="esfOrderReferenceError"
message="esfOrderReferenceError" />

<liferay-ui:error key="esfArticleDeliveredReferenceError"
message="esfArticleDeliveredReferenceError" />

<liferay-ui:error key="esfArticleDeliveredShooterError"
message="esfArticleDeliveredShooterError" />

	<aui:form action="<%= searchURL %>" method="get" name="fm">
		<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="search-form">
			<span class="aui-search-bar">
				<aui:input inlineField="<%= true %>" label="" name="code" placeholder="code"
						size="30" title="search-entries" type="text" />

				<aui:input inlineField="<%= true %>" label="" name="name" placeholder="name"
						size="30" title="search-entries" type="text" />

				<aui:input inlineField="<%= true %>" label="" name="type" placeholder="type"
						size="30" title="search-entries" type="text" />

				<aui:button type="submit" value="search" />
			</span>
		</div>
	</aui:form>

	<aui:button-row cssClass="esfarticle-admin-buttons">

<c:if test="<%= ESFArticleManagerModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFTYPE_ADD) %>">	
			<portlet:renderURL var="addESFArticleTypeURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfArticleType.jsp" %>' />
			</portlet:renderURL>
			<aui:button onClick="<%= addESFArticleTypeURL.toString() %>"
					value="add-esfarticletype" />
</c:if>
<c:if test="<%= ESFArticleManagerModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFARTICLE_ADD) %>">	
			<portlet:renderURL var="addESFArticleURL">
			<portlet:param name="mvcPath"
				value='<%= templatePath + "add_esfArticle.jsp" %>' />
			</portlet:renderURL>
			<aui:button onClick="<%= addESFArticleURL.toString() %>"
			value="add-esfarticle" />
</c:if>
<c:if test="<%= ESFArticleManagerModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFARTICLESTOKIST_ADD) %>">	
			<portlet:renderURL var="addESFStockistURL">
			<portlet:param name="mvcPath"
				value='<%= templatePath + "edit_esfStockist.jsp" %>' />
			</portlet:renderURL>
			<aui:button onClick="<%= addESFStockistURL.toString() %>"
			value="add-esfstockist" />
</c:if>
	</aui:button-row>

		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results results="<%= ESFArticleLocalServiceUtil.getESFArticles() %>"
												 total="<%= ESFArticleLocalServiceUtil.getESFArticlesCount() %>" />

			<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticle" modelVar="esfArticle">
					<liferay-ui:search-container-column-text name="code" value="<%= esfArticle.getCode() %>" />
					<liferay-ui:search-container-column-text name="name" value="<%= esfArticle.getName() %>" />
					<liferay-ui:search-container-column-text name="description" value="<%= esfArticle.getDescription() %>" />
					<liferay-ui:search-container-column-text name="type"
					value="<%= ESFArticleLocalServiceUtil.getDescriptionType(esfArticle.getEsfArticleTypeId()) %>" />
					<liferay-ui:search-container-column-text name="elements" value="<%= String.valueOf(ESFArticleLocalServiceUtil.getElements(esfArticle)) %>" />

<c:if test="<%= (ESFArticleManagerPermission.contains(permissionChecker,esfArticle.getEsfArticleId(), scopeGroupId, ActionKeys.ESFARTICLE_ASSIGN) ||
						ESFArticleManagerPermission.contains(permissionChecker, esfArticle.getEsfArticleId() , scopeGroupId , ActionKeys.ESFARTICLE_REMOVE) ||
							ESFArticleManagerPermission.contains(permissionChecker,esfArticle.getEsfArticleId(), scopeGroupId, ActionKeys.ESFARTICLE_UPDATE))%>">
			<liferay-ui:search-container-column-jsp
					path='<%= templatePath + "esfArticle_actions.jsp" %>' align="right" />
</c:if>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>