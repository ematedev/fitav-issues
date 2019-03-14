<%@include file="init.jsp"%>

<aui:script>
	AUI().use(
			'aui-base',
			'aui-form-validator',
			'liferay-form',
			function(A) {
				var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;
				
				var screenname = function(val, node, ruleValue) {

					var blankSpace = /^$|\s+/;

					if (blankSpace.test(val)) {
						return false;
					}
					return true;
				}

				A.mix(DEFAULTS_FORM_VALIDATOR.RULES, {
					screenname : screenname
				}, true);

			});
</aui:script>

<%
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	ESFUser esfUser = null;
	String userName = "";
	
	if (esfUserId > 0) {
		esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
	}
		
	if( Validator.isNotNull(esfUser) ){
			
		userName = esfUser.getFirstName()+" "+esfUser.getLastName();
		String[] userNameUpdate = {userName};
		
%>
<h4><b><liferay-ui:message key="update-user-x" arguments="<%= userNameUpdate%>"/></b>
				<div class="separator"></div>
<%
	}else{
%>
<h4><b><liferay-ui:message key="add-new-user" /></b>
				<div class="separator"></div>
<%
	}

	String[] _CATEGORY_NAMES = { "Main", "More" };
	String[][] categorySections = null;
	boolean showBottons = false;

	if (esfUserId > 0) {
		categorySections = new String[][] { { "details" ,"change_password"},
				{ "addresses", "phone", "socialnetwork", "state", "roles" } };
		
		showBottons= ESFUserAdminPermission.contains(permissionChecker, esfUserId,	ActionKeys.ESFUSERADMIN_UPDATE);
	
	} else {
		categorySections = new String[][] { { "details" }, { "addresses", "phone", "socialnetwork" } };
		
		showBottons= ESFUserAdminModelPermission.contains(permissionChecker, scopeGroupId,	ActionKeys.ESFUSERADMIN_ADD);
	}
%>

<portlet:actionURL
	name='<%=esfUser == null ? "addESFUser" : "updateESFUser"%>'
	var="editESFUserURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>


<div class="fitav-navigator">
	<aui:form action="<%=editESFUserURL.toString()%>" name="fmg">

		<%
			request.setAttribute("addresses.className", ESFUser.class.getName());
				request.setAttribute("addresses.classPK", esfUserId);
				request.setAttribute("phones.className", ESFUser.class.getName());
				request.setAttribute("phones.classPK", esfUserId);
				request.setAttribute("websites.className", ESFUser.class.getName());
				request.setAttribute("websites.classPK", esfUserId);
		%>
		<liferay-ui:form-navigator backURL="<%=viewURL%>"
			categoryNames="<%=_CATEGORY_NAMES%>"
			categorySections="<%=categorySections%>" formName="fmg"
			jspPath='<%=templatePath + "navigation/"%>' showButtons="<%= showBottons %>" />
	</aui:form>
</div>


<aui:button-row cssClass="esfuser-admin-buttons">


	<aui:button type="cancel" onClick="<%= viewURL%>"></aui:button>


</aui:button-row>
