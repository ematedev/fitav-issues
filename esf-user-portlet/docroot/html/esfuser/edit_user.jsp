<%@include file="init.jsp"%>

<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");

ESFUser esfUser = null;

if (esfUserId > 0) {

	esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
}
%>

<portlet:actionURL name="editESFUser" var="editESFUserURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<div>
	<aui:form action="<%=editESFUserURL.toString()%>"
		name="<portlet:namespace />fm">
		<aui:fieldset>
			<aui:model-context bean="<%=esfUser%>" model="<%=ESFUser.class%>" />
			<aui:input name="firstName" />
			<aui:input name="lastName" />
			<aui:input name="screenName">
					<aui:validator name="required" errorMessage="Please enter your screen name." />
			</aui:input>
			<aui:input name="userEmail" />
			<aui:input name="birthday" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button onClick="<%= viewURL.toString() %>" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

