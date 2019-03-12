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
		if(esfUserId == 0){
			esfUserId = (Long)request.getAttribute("esfUserId");
		}
		ESFUser esfUser = null;
		String userName = "";
		
		if (esfUserId > 0) {
			esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
		}
		String[] _CATEGORY_NAMES = {
			"Main", "More"
		};

		String[][] categorySections = new String[][] {
				{"details", "card","documents","guns"}, 
				{"addresses", "phone", "socialnetwork","stateshooter", "roles"}
			};
		
				
		boolean showBottons=ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_UPDATE) ;	

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
		<%
		}
		%>



<portlet:actionURL	name="updateESFShooter"	var="editESFShooterURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</portlet:actionURL>

<div>
<liferay-ui:error key="esfRole-reference-error" message="esfRole-reference-error"/>
<liferay-ui:error key="esfRole-MAx-User-reference-error" message="esfRole-MAx-User-reference-error"/>

							

	<aui:form action="<%=editESFShooterURL.toString()%>"
		name="fmc">

		<%
			String backToGeneralUrl = (String)portletSession.getAttribute("backToGeneralUrl");
			portletDisplay.setURLBack(backToGeneralUrl);
			
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
		
		<portlet:renderURL var="backURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "view.jsp"%>' />
		</portlet:renderURL>
		<liferay-ui:form-navigator backURL="<%=backURL%>"
			categoryNames="<%=_CATEGORY_NAMES%>"
			categorySections="<%=categorySections%>"
			formName="fmc"
			jspPath='<%=templatePath + "/navigation/"%>' showButtons="<%=showBottons %>"/>
	</aui:form>
</div>


<aui:button-row>
	<aui:button type="cancel" onClick="<%= viewURL%>"></aui:button>
</aui:button-row>

