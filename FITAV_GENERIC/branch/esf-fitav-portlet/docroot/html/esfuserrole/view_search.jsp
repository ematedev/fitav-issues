<%@include file="init.jsp"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<%
	String title = ParamUtil.getString(request, "title");
	String name = ParamUtil.getString(request, "name");
	Integer typestate = ParamUtil.getInteger(request, "typestate");
%>

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
		<aui:input inlineField="<%=true%>" label="" name="title"
			placeholder="Title" size="30" title="search-entries" type="text" /> 
		<aui:input inlineField="<%=true%>" label="" name="name" placeholder="name" size="30"
			title="search-entries" type="text" />
		<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result">
	<liferay-ui:search-container-results>
		<%
		System.out.println(title+" "+name+" "+ typestate);
		
			List<ESFUserRole> esfUserRoles = ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(title, name, typestate);
			System.out.println(esfUserRoles);
			List<ESFUserRole> esfUserRolesSE =ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(title, name, typestate, 
			searchContainer.getStart(), searchContainer.getEnd()); 
					System.out.println(esfUserRolesSE);
					pageContext.setAttribute("results", esfUserRolesSE);
					pageContext.setAttribute("total", esfUserRoles.size());
		%>
	</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUserRole" modelVar="userRole">
		
	    <portlet:renderURL var="viewESFUserRole">
			<portlet:param name="mvcPath"
				value="/html/esfuserrole/edit_esfUserRole.jsp" />
			<portlet:param name="esfUserRoleId"
				value="<%=String.valueOf(userRole.getEsfUserRoleId())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text property="title"
			orderable="true" orderableProperty="title" name="title" />

		<liferay-ui:search-container-column-text property="name"
			orderable="true" orderableProperty="name" name="name" />

		<liferay-ui:search-container-column-text property="description"
			orderable="true" orderableProperty="description" name="description" />

		<liferay-ui:search-container-column-text property="isBDO" name="is-bdo"/>

		<liferay-ui:search-container-column-text property="isLEA" name="is-lea"/>

		<liferay-ui:search-container-column-jsp
			path="/html/esfuserrole/esfUserRole_action.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>