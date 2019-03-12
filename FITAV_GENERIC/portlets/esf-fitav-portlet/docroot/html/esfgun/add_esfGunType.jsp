
<%@ include file="init.jsp"%>

<% 
String pathBack = ParamUtil.getString(renderRequest, "pathBack");
String modifyMode = ParamUtil.getString(request, "modifyMode");
String isCatridgeProductor = ParamUtil.getString(request, "isCatridgeProductor");
%>
<portlet:renderURL var="viewURL1">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="modifyMode" value='<%=modifyMode %>'/>
</portlet:renderURL>

<portlet:actionURL name="editESFGunType" var="editESFGunTypeURL">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="modifyMode" value='<%=modifyMode %>'/>
	<portlet:param name="isCatridgeProductor" value='<%=isCatridgeProductor %>'/>
</portlet:actionURL>

<aui:form action="<%=editESFGunTypeURL%>" name="<portlet:namespace />fm">
	
		
	<aui:fieldset>
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="description">
		</aui:input>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL1 %>"></aui:button>
	</aui:button-row>
</aui:form>