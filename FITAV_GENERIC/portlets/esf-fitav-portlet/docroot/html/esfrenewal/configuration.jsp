
<%@include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<%
boolean disableFirstRegistrationTab_cfg = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"firstRegistrationTabAbilitation", StringPool.TRUE));
boolean disableBuyOneCardTab_cfg = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"firstRegistrationTabAbilitation", StringPool.TRUE));

boolean disableBuyManyCardsTab_cfg = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"firstRegistrationTabAbilitation", StringPool.TRUE));

boolean disableAnnualMembershipDueTab_cfg = 
					GetterUtil.getBoolean(
						portletPreferences.getValue(
									"firstRegistrationTabAbilitation", StringPool.TRUE));
boolean disableIntegration_cfg = 
					GetterUtil.getBoolean(
						portletPreferences.getValue(
									"firstRegistrationTabAbilitation", StringPool.TRUE));
%>

<h2>
	<liferay-ui:message key = "choose-tab-to-disable"/>
</h2>

<aui:form action="<%= configurationURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<aui:input type = "checkbox" name = "preferences--firstRegistrationTabAbilitation--" 
			value="<%= disableFirstRegistrationTab_cfg %>" label="first-registration" />
	
	<aui:input type = "checkbox" name = "preferences--buyOneCardTabAbilitation--"
			value="<%= disableBuyOneCardTab_cfg %>" label="buy-one-card"/>
	
	<aui:input type = "checkbox" name = "preferences--buyManyCardsTabAbilitation--"
			value="<%=disableBuyManyCardsTab_cfg %>" label="buy-many-cards"/>
	
	<aui:input type = "checkbox" name = "preferences--annualMembershipDueTabAbilitation--" 
			value="<%= disableAnnualMembershipDueTab_cfg%>" label="annual-membership-due-payment"/>
	
	<aui:input type = "checkbox" name = "preferences--integrationTabAbilitation--" 
			value="<%= disableIntegration_cfg%>" label="integration-payment"/>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
	
</aui:form>