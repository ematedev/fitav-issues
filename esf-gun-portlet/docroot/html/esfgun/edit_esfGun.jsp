<%@page import="com.liferay.portal.model.User"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp" %>

<%
	ESFGun esfGun = null;

	long esfGunId = ParamUtil.getLong(request, "esfGunId");

	if (esfGunId > 0) {

		esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);
	}

	List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();

	List<User> users = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<portlet:resourceURL var="resourceURL" escapeXml="false" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/esfgun/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGun" var="editESFGunURL">
	<portlet:param name="esfGunId" value="<%= String.valueOf(esfGunId) %>" />
</portlet:actionURL>

<aui:form action="<%= editESFGunURL %>" name="<portlet:namespace />fm">

		<aui:fieldset>
			<aui:input name="code" />
			<aui:select showEmptyOption="true" name="esfUserId" required="true">
				<% 
				for (User gunner : users) { %>
					<aui:option 
						label="<%= gunner.getScreenName() %>" 
						value="<%= gunner.getUserId()  %>"/>
				<% } %>
			</aui:select>
			<aui:select showEmptyOption="true" name="esfGunTypeId" onchange="changeSelect(this);" required="true">
				<% 
				for (ESFGunType esfGunType : esfGunTypes) { %>
					<aui:option 
						label="<%= esfGunType.getName() %>" 
						value="<%= esfGunType.getEsfGunTypeId()  %>"/>
				<% } %>
			</aui:select>
			<aui:select name="esfGunKindId" cssClass="esfGunKindSelect" required="true">
			</aui:select>
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>

<aui:script use="node,aui-io-request,liferay-portlet-url">

window.changeSelect = function(element) {
	
	var esfGunTypeId = element.value;
	
	A.io.request(
		'<%= resourceURL %>',
		{
			method: "POST",
			data: {
				esfGunTypeId:esfGunTypeId,
			},
			contentType: "application/json; charset=utf-8",
			dataType: "json",
		on: {
			success: function() {
				var results = this.get('responseData');
				if(results) {
					console.log("NON E' null!!");
					var resultsOption = "";
					for(index in results.esfGunKinds) {
						console.log(results.esfGunKinds[index].name);
						resultsOption += "<option value='" + results.esfGunKinds[index].esfGunKindId + "'>" + results.esfGunKinds[index].name + "</option>";
					}
					A.one("#<portlet:namespace/>esfGunKindId").html(resultsOption);
				} else {
					console.log("E' null!!");
					A.one("#<portlet:namespace/>esfGunKindId").html('');
				}
			}
		}
	});	
}
changeSelect(A.one("#<portlet:namespace/>esfGunTypeId"));
</aui:script>
