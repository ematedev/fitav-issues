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

		if (esfUserId > 0) {
			esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
		}

		String[] _CATEGORY_NAMES = {
			"Main", "More"
		};
		String[][] categorySections = null;
		if(esfUserId>0){
			categorySections = new String[][] {
				{"details", "card","documents","guns"}, 
				{"addresses", "phone", "socialnetwork","stateshooter", "roles"}
			};
		}else{
			categorySections = new String[][] {
				{"details", "card"}, 
				{"addresses", "phone","socialnetwork"}
			};
		}
		
		
		boolean showBottons=ESFShooterPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFSHOOTER_UPDATE) || 
				ESFShooterModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFSHOOTER_ADD) ;
	%>

<portlet:actionURL
	name='<%= esfUser == null ? "addESFShooter" : "updateESFShooter"%>'
	var="editESFShooterURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<div>
<liferay-ui:error key="esfRole-reference-error" message="esfRole-reference-error"/>
<liferay-ui:error key="assigned_role" message="assigned_role"/>
<liferay-ui:error key="is_national" message="is_national"/>
<liferay-ui:error key="esfRole-MAx-User-reference-error" message="esfRole-MAx-User-reference-error"/>


	<aui:form action="<%=editESFShooterURL.toString()%>"
		name="fm">

		<%
			request.setAttribute(
					"addresses.className", ESFUser.class.getName());
				request.setAttribute("addresses.classPK", esfUserId);
				request.setAttribute(
					"phones.className", ESFUser.class.getName());
				request.setAttribute("phones.classPK", esfUserId);
				request.setAttribute(
					"websites.className", ESFUser.class.getName());
				request.setAttribute("websites.classPK", esfUserId);
				request.setAttribute(
					"card.userId", esfUserId);
		%>
		<liferay-ui:form-navigator backURL="<%=viewURL%>"
			categoryNames="<%=_CATEGORY_NAMES%>"
			categorySections="<%=categorySections%>"
			formName="fm"
			jspPath='<%=templatePath + "navigation/"%>' showButtons="<%= showBottons %>"/>
	</aui:form>
</div>


<aui:button-row cssClass="esfshooter-buttons">


	<aui:button type="cancel" onClick="<%= viewURL%>"></aui:button>


</aui:button-row>

