<%@include file="init.jsp"%>
<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");
ESFUser esfUser = null;
String userName = "";

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
}else{
%>
<h4><b><liferay-ui:message key="add-new-shooter" /></b>
				<div class="separator"></div>
<liferay-ui:error key="error-federal-role" message="error-federal-role" />
<%
}
%>



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
		String[] _CATEGORY_NAMES = {
			"Main", "More"
		};
		String[][] categorySections = null;
		if(esfUserId>0){
			categorySections = new String[][] {
				{"details", "card","documents","guns"}, 
				{"addresses", "phone", "socialnetwork","stateshooter", "roles" , "federal_roles"}
			};
		}else{
			categorySections = new String[][] {
				{"details", "card"}, 
				{"addresses", "phone","socialnetwork","stateshooter"}
			};
		}
		
		boolean showBottons= false; 
		if(Validator.isNotNull(esfUserId)){
			showBottons=ESFShooterPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFSHOOTER_UPDATE) ;
		}else{
			showBottons=ESFShooterModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFSHOOTER_ADD) ;
		}
	
	%>

<portlet:actionURL
	name='<%= esfUser == null ? "addESFShooter" : "updateESFShooter"%>'
	var="editESFShooterURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="saveAndContinue" value="true" />
</portlet:actionURL>

<div class="fitav-navigator">
<liferay-ui:error key="esfRole-reference-error" message="esfRole-reference-error"/>
<liferay-ui:error key="assigned_role" message="assigned_role"/>
<liferay-ui:error key="is_national" message="is_national"/>
<liferay-ui:error key="esfRole-MAx-User-reference-error" message="esfRole-MAx-User-reference-error"/>
<liferay-ui:error key="shooter-error-update-deathDate" message="shooter-error-update-deathDate"/>


	<aui:form action="<%=editESFShooterURL.toString()%>"
		name="fmf">

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
		<liferay-ui:form-navigator
			 backURL="<%=viewURL%>"
			categoryNames="<%=_CATEGORY_NAMES%>"
			categorySections="<%=categorySections%>"
			formName="fmf"
			jspPath='<%=templatePath + "navigation/"%>' 
			showButtons="<%= showBottons %>"
		/>
	</aui:form>
</div>
<%if(!showBottons){ %>

<aui:button-row cssClass="esfshooter-buttons">


	<aui:button type="cancel" onClick="<%= viewURL%>"></aui:button>


</aui:button-row>

<% }%>



