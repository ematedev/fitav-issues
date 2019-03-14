<%@include file="init.jsp"%>

<%

long connectedUserId = 0;
User currentUser = PortalUtil.getUser(request);

connectedUserId = currentUser.getUserId();
%>
<aui:input name="connectedUserId" type="hidden" value="<%=connectedUserId %>"/>

<%if(connectedUserId == esfUserId){ %>
	<aui:input name="lastPass" type="password" label="lastPass">
		<aui:validator  name="required "  errorMessage="Field is required" />
	</aui:input> 
<%} %>
	<aui:input name="newPass" type="password" label="newPass">
		<aui:validator  name="required "  errorMessage="Field is required" />
	</aui:input> 
	<aui:input name="confirmNewPass" type="password" label="confirmNewPass">
		<aui:validator  name="required "  errorMessage="Field is required" />
	</aui:input> 