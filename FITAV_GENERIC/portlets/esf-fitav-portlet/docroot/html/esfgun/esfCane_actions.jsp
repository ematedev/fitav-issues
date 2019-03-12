<%@ include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFCane esfCane = (ESFCane)row.getObject(); 
String mvcPath1 = "";//ParamUtil.getString(request, "mvcPath");
String templatePath1="/html/esfgun/";

long shooterId = esfCane.getShooterId();

mvcPath1="edit_esfCane.jsp";
%>
<liferay-ui:icon-menu>
	
		<portlet:renderURL var="editURL">
			<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCane.getEsfCaneId()) %>" />
			<portlet:param name="mvcPath" value='<%=templatePath1+mvcPath1 %>' />
			<portlet:param name="modifyMode" value="true"/>
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="shooterId" value='<%=String.valueOf(shooterId)%>' />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString() %>" />
	
		<portlet:actionURL name="deleteESFCane" var="deleteURL">
			<portlet:param name="esfCaneId" value="<%= String.valueOf(esfCane.getEsfCaneId()) %>" />
			<portlet:param name="mvcPath" value='/html/esfgun/view.jsp'/>
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="delete_confirm"/>

</liferay-ui:icon-menu>