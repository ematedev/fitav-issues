<%@ include file="../init.jsp"%>

<%
String namespace = renderResponse.getNamespace();
long esfGunId = ParamUtil.getLong(request, "esfGunId");
int type = ParamUtil.getInteger(request, "type");
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
ESFUser shooter = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
String userName = "";
if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName()) && Validator.isNotNull(shooter.getLastName())){
	userName = (shooter.getFirstName() + " " +shooter.getLastName()).toUpperCase();
}
String gunName = "";
ESFGun gun = ESFGunLocalServiceUtil.fetchESFGun(esfGunId);
if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getName())){
	gunName = gun.getName();
}


%>
<liferay-ui:error key="duplicate_code" message="duplicate_code"/>
<h3><%=gunName.toUpperCase() %></h3>
<portlet:actionURL name="editESFGun" var="assigUserURL" >
	<portlet:param name="esfGunId" value='<%=String.valueOf(esfGunId)%>' />
	<portlet:param name="type" value='<%=String.valueOf(type)%>' />
	<portlet:param name="mvcPath" value='<%=templatePath %>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<aui:form action="<%=assigUserURL%>" name="<portlet:namespace />fm">
		<div id="show_checkKind">
		<aui:input type="hidden" label="userId" name="shooterId"  readonly="true"/>
		<aui:input type="text" name="userName" readonly="true" value="<%=userName %>">
			<aui:validator name="required" />
		</aui:input>
		<%if(1==type){ %>
		
		<aui:input type="text" name="code"  label="freshman">
			<aui:validator name="required" />
		</aui:input>
		
		
		<aui:input name="isFavoriteGun" label="is-favorite-gun" type="checkbox"/>
		<%} %>
		
		<aui:input type="text" name="note" />
		
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%="/html/esfgunuser/esfguncategorization/esfrifle.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
			<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
	</aui:button-row>
</aui:form>
