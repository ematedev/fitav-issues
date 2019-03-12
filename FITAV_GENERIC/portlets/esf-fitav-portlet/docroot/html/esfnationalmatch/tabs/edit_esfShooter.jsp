<%@include file="../init.jsp"%>

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
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
		ESFUser esfUser = null;
		
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
		System.out.println("esfMatchId="+esfMatchId);
		boolean show = ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_EDIT_SHOOTER_UPDATE);
	%>

<portlet:actionURL
	name='updateESFShooter' var="editESFShooterURL">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<portlet:param name="esfMatchId" value="<%=String.valueOf(esfMatchId)%>" />
</portlet:actionURL>

<div>
<liferay-ui:error key="duplicate_code" message="duplicate_code"/>
<liferay-ui:error key="esfRole-reference-error" message="esfRole-reference-error"/>
<liferay-ui:error key="esfRole-MAx-User-reference-error" message="esfRole-MAx-User-reference-error"/>
<liferay-ui:error key="esfCard-noFind-reference-error" message="esfCard-noFind-reference-error"/>

	<aui:form action="<%=editESFShooterURL.toString()%>" name="fmb">

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
			<portlet:param name="mvcPath" value='<%=templatePath + "management_esfMatch.jsp"%>' />
			<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId)%>' />
		</portlet:renderURL>
		<liferay-ui:form-navigator backURL="<%=backURL%>"
			categoryNames="<%=_CATEGORY_NAMES%>"
			categorySections="<%=categorySections%>"
			formName="fmb"
			jspPath='<%=templatePath + "tabs/navigation/"%>' showButtons="<%=show %>"/>
	</aui:form>
</div>

<aui:button type="cancel" onClick="<%= viewURL%>"></aui:button>

