<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="esfOrderReferenceError"
message="esfOrderReferenceError" />

<liferay-ui:error key="esfArticleDeliveredReferenceError"
message="esfArticleDeliveredReferenceError" />

<%
	String code = ParamUtil.getString(request, "code");
	String name = ParamUtil.getString(request, "name");
	String type = ParamUtil.getString(request, "type");
	long esfArticleTypesId=0;
	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfarticlemanager/view_search.jsp");
	viewassURL.setParameter("code", code);
	viewassURL.setParameter("name", name);
	viewassURL.setParameter("type", type);

List<ESFArticleType> esfArticleTypes = ESFArticleTypeLocalServiceUtil.getESFArticleTypes();
for (ESFArticleType esfArtType : esfArticleTypes) {
	if (esfArtType.getDescription().equalsIgnoreCase(type)) {
		esfArticleTypesId = esfArtType.getEsfArticleTypeId();
	}
}
%>

<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />

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

		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results results="<%= ESFArticleLocalServiceUtil.getESFArticleByLikeC_N_T(code, name,
												esfArticleTypesId, searchContainer.getStart(),searchContainer.getEnd()) %>"
												 total="<%= ESFArticleLocalServiceUtil.getESFArticleByLikeC_N_T(code, name, esfArticleTypesId).size() %>" />
			<liferay-ui:search-container-row className="com.ethica.esf.model.ESFArticle" modelVar="esfArticle">
					<liferay-ui:search-container-column-text name="code" value="<%= esfArticle.getCode() %>" />
					<liferay-ui:search-container-column-text name="name" value="<%= esfArticle.getName() %>" />
					<liferay-ui:search-container-column-text name="description" value="<%= esfArticle.getDescription() %>" />
					<liferay-ui:search-container-column-text name="type"
					value="<%= ESFArticleLocalServiceUtil.getDescriptionType(esfArticle.getEsfArticleTypeId()) %>" />
					<liferay-ui:search-container-column-text name="elements" value="<%= String.valueOf(ESFArticleLocalServiceUtil.getElements(esfArticle)) %>" />

			<liferay-ui:search-container-column-jsp
					path='<%= templatePath + "esfArticle_actions.jsp" %>' align="right" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>