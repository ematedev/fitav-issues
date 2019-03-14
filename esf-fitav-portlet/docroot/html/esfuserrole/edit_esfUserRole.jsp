<%@include file="init.jsp"%>

<%
	String[] typeLabel = ESFKeys.ESFOrganizationTypeLabel;
%>


<portlet:renderURL var="viewURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value="/html/esfuserrole/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL
	name='<%=esfUserRole == null
				? "addESFUserRole" : "updateESFUserRole"%>'
	var="editESFUserRoleURL" />

<aui:form action="<%=editESFUserRoleURL%>"
	name="<portlet:namespace />fm">

	<aui:model-context bean="<%=esfUserRole%>"
		model="<%=ESFUserRole.class%>" />
	<aui:fieldset>

		<aui:input type="hidden" name="esfUserRoleId"
			value='<%=esfUserRole == null
						? "" : esfUserRole.getEsfUserRoleId()%>' />

		<aui:input name="name" type="text"
			value='<%=esfUserRole == null
							? "" : esfUserRole.getName()%>'>
			<aui:validator name="required" errorMessage="Please enter the name." />
		</aui:input>

		<aui:input name="title" type="text"
			value='<%=esfUserRole == null
							? "" : esfUserRole.getTitle()%>'>
		</aui:input>

		<aui:input name="description" type="textarea"
			value='<%=esfUserRole == null
							? "" : esfUserRole.getDescription()%>'>
		</aui:input>

		<aui:input name="maxUser" type="text"
			value='<%=esfUserRole == null
							? "" : esfUserRole.getMaxUser()%>'>
			<aui:validator name="digits"></aui:validator>
		</aui:input>

		<aui:select name="type">
			<aui:option value="<%= ESFKeys.ESFOrganizationTypeId.FITAV %>"
				label="<%=typeLabel[0]%>"></aui:option>
			<aui:option value="<%=ESFKeys.ESFOrganizationTypeId.REGION%>"
				label="<%=typeLabel[1]%>"></aui:option>
			<aui:option value="<%=ESFKeys.ESFOrganizationTypeId.PROVINCE%>"
				label="<%=typeLabel[2]%>"></aui:option>
			<aui:option value="<%=ESFKeys.ESFOrganizationTypeId.ASSOCIATION%>"
				label="<%=typeLabel[3]%>"></aui:option>
		</aui:select>

		<aui:input name="isBDO" type="checkbox"
			value='<%=esfUserRole == null
							? "false" : esfUserRole.getIsBDO()%>'>
		</aui:input>

		<aui:input name="isLEA" type="checkbox"
			value='<%=esfUserRole == null
							? "false" : esfUserRole.getIsLEA()%>'>
		</aui:input>
		
		<aui:input name="isOrgAdmin" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>