<%@ include file="init.jsp"%>

<%
long esfUserId = Long.parseLong(renderRequest.getParameter("esfUserId"));
ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
String userName = "";
String pathBack=ParamUtil.getString(renderRequest, "pathBack");

boolean isCatridgeProductor = ParamUtil.getBoolean(renderRequest, "isCatridgeProductor");


if (esfUserId > 0) {
	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}

if( Validator.isNotNull(esfUser) ){
	
	userName = esfUser.getFirstName()+" "+esfUser.getLastName();
	String[] shooterName = {userName};
%>	
<h4><b><liferay-ui:message key="update-shooter-x" arguments="<%= shooterName%>"/></b>
				<div class="separator"></div>
<%
}
%>
<portlet:renderURL var="viewURL1">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
</portlet:renderURL>

<portlet:actionURL name="editESFGunType" var="editESFGunTypeURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="isCatridgeProductor" value='<%=String.valueOf(isCatridgeProductor)%>' />
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