<%@ include file="/html/esfraduni/init.jsp"%>

<%

	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
	long currentOrganizationId = group.getOrganizationId();
	
	List<ESFOrganization> listaAssociazioni = new ArrayList<ESFOrganization>();
	int nElementi = 0;
	
	
	String self = request.getParameter("self");
	if (self == null)
		self = "";
	
	
	String code = ParamUtil.getString(request, "code");	
	String name = ParamUtil.getString(request, "name");
	code=code.toUpperCase();
	name= name.toUpperCase();
	PortletURL viewassURL = renderResponse.createRenderURL();

		viewassURL.setParameter(
			"mvcPath", "/html/esfraduni/popup/chooseAssociation.jsp");
		viewassURL.setParameter("code", code);
		viewassURL.setParameter("name", name);

	if(code!="" || name!=""){
		listaAssociazioni = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId,code,name);
		nElementi = listaAssociazioni.size();

	}else if (self.equals("self")){
		listaAssociazioni = ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId,"","");
		nElementi = listaAssociazioni.size();
	}

%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%="/html/esfraduni/popup/chooseAssociation.jsp"%>'/>
	<portlet:param name="self" value='self' />
</liferay-portlet:renderURL>


<aui:form action="<%=searchURL.toString()%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<aui:input inlineField="true" name="code" placeholder="code" size="30" title="search-entries" type="text" />
		<aui:input inlineField="true" name="name" placeholder="name" size="30" title="search-entries" type="text" />  
	<aui:button-row>
		<aui:button type="submit" value="search">
		</aui:button>

	</aui:button-row>
	</div>
</aui:form>


<liferay-ui:search-container delta="5" emptyResultsMessage="no-results" total="<%=nElementi%>" iteratorURL="<%=viewassURL%>">
	<liferay-ui:search-container-results 
		results="<%=ListUtil.subList(listaAssociazioni, searchContainer.getStart(), searchContainer.getEnd())%>" 
		 />
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFOrganization" modelVar="esfOrganization">
			<liferay-ui:search-container-column-text name="name"/>
		 	<liferay-ui:search-container-column-jsp path='<%="/html/esfraduni/popup/addAssociation.jsp"%>' align="right" /> 
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>