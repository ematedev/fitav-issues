<%@ include file="init.jsp"%>

<% 
//long esfUserId = ParamUtil.getLong(request,"esfUserId");
%>
<portlet:renderURL var="addESFRifleURL">
		<portlet:param name="mvcPath"
		value='<%= templatePath+"edit_esfRifle.jsp" %>' />
		<portlet:param name="modifyMode" value="false"/>
</portlet:renderURL>

<aui:button onClick="<%= addESFRifleURL.toString() %>" value="RIFLES" />

<portlet:renderURL var="addESFCatridgeURL">
	<portlet:param name="mvcPath"
		value='<%= templatePath+"edit_esfCatridge.jsp" %>' />
	<portlet:param name="modifyMode" value="false"/>
</portlet:renderURL>

<aui:button onClick="<%= addESFCatridgeURL.toString() %>" value="CATRIDGES" />