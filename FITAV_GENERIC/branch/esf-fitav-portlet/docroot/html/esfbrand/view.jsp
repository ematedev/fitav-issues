<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFBrandURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath + "edit_esfBrand.jsp" %>' />
</portlet:renderURL>

<liferay-ui:error key="esfBrand-reference-error" message="esfBrand-reference-error" />

<aui:button onClick="<%= addESFBrandURL.toString() %>"
	value="add-brand" />
					
<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results
		results="<%=ESFBrandLocalServiceUtil.getESFBrands(
					searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFBrandLocalServiceUtil.getESFBrandsCount()%>" />

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFBrand"
		modelVar="esfBrand">

		
		<liferay-ui:search-container-column-text name="name" />
		<liferay-ui:search-container-column-text name="description"/>

		<liferay-ui:search-container-column-jsp
				path="/html/esfbrand/esfBrand_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>