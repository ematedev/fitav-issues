<%@ include file="init.jsp" %>
<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long esfOragnizationId = group.getOrganizationId();
long esfUserId = themeDisplay.getUserId();

%>

<portlet:actionURL name="createCard" var="createCardURL">
	<portlet:param name="mvcPath" value= '<%= templatePath + "view.jsp"%>' /> 
	<portlet:param name="esfOrganizationId"  value="<%=String.valueOf(esfOragnizationId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL> 

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<aui:form action = "<%=createCardURL%>">	

	<aui:input name="numCards" >
		<aui:validator  name="required "  errorMessage="Field_is_required" />
		<aui:validator name="number"></aui:validator>
		<aui:validator name="min">1</aui:validator>
	</aui:input>
	
	<aui:button type="submit" value="save" />
	<aui:button onClick="<%= viewURL %>" type="cancel" />
</aui:form>
