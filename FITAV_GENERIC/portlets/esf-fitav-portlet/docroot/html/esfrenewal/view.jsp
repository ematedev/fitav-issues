
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@include file="init.jsp"%>

<portlet:renderURL var="tabURL" />

<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	String tab = ParamUtil.getString(request, "myParam",
			"Prima registrazione");
	double firstRegistrationCost = Double.parseDouble(PortletProps
			.get("esf-renewal-first-registration-cost"));
	
	boolean disableFirstRegistrationTab_view = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"firstRegistrationTabAbilitation", StringPool.TRUE));
	
	boolean disableBuyOneCardTab_view = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"buyOneCardTabAbilitation", StringPool.TRUE));
	
	boolean disableBuyManyCardsTab_view = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"buyManyCardsTabAbilitation", StringPool.TRUE));
	
	boolean disableAnnualMembershipDueTab_view = 
					GetterUtil.getBoolean(
							portletPreferences.getValue(
									"annualMembershipDueTabAbilitation", StringPool.TRUE));
	
	boolean disableIntegration_cfg = 
			GetterUtil.getBoolean(
					portletPreferences.getValue(
							"integrationTabAbilitation", StringPool.TRUE));
	
	String tabs = "", tab1 = "", tab2 = "", tab3 = "", tab4 = "",tab5= "";
	
	int disabledTabsCounter = 0;
	
	if(!disableFirstRegistrationTab_view){
		tab1 += "Prima registrazione,";
		disabledTabsCounter++;
	}
	if(!disableAnnualMembershipDueTab_view){
		tab2 += "Paga quota affiliazione,";
		disabledTabsCounter++;
	}
	if(!disableBuyOneCardTab_view){
		tab3 += "Acquisto tessera,";
		disabledTabsCounter++;
	}
	if(!disableBuyManyCardsTab_view){
		tab4 += "Acquisto di piu\' tessere,";
		disabledTabsCounter++;
	}
	if(!disableBuyManyCardsTab_view){
		tab5 += "Integrazione";
		disabledTabsCounter++;
	}
	
	tabs = tab1 + tab2 + tab3 + tab4 + tab5;
	if(disabledTabsCounter == 1){
		tabs = tabs.substring(tabs.indexOf(',') - 1);
	}

%>
<aui:script>
	$(function() {
		$("#<portlet:namespace/>paymentDate").datepicker();
		$("#<portlet:namespace/>paymentDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>paymentDate").datepicker("setDate",
				'<%= currDate %>');
	});
</aui:script>

<liferay-ui:tabs names="<%=tabs%>" url="<%=tabURL.toString()%>" 
											param="myParam" refresh="true">
											
	<c:if test='<%=/*!disableFirstRegistrationTab_view && */
								tab.equalsIgnoreCase("Prima registrazione")%>'>
		<jsp:include page="tabs/first_registration.jsp" flush="true" />
	</c:if>

	<c:if test='<%=/*!disableAnnualMembershipDueTab_view && */
								tab.equalsIgnoreCase("Paga quota affiliazione")%>'>
		<jsp:include page="tabs/annual_membership_dues.jsp" flush="true" />
	</c:if>

	<c:if test='<%=/*!disableBuyOneCardTab_view &&*/ 
								tab.equalsIgnoreCase("Acquisto tessera")%>'>
		<jsp:include page="tabs/buy_one_card.jsp" flush="true" />
	</c:if>
	<c:if test='<%=/*!disableBuyManyCardsTab_view && */
								tab.equalsIgnoreCase("Acquisto di piu\' tessere")%>'>
		<jsp:include page="tabs/buy_many_cards.jsp" flush="true" />
	</c:if>
	<c:if test='<%=/*!disableBuyManyCardsTab_view && */
								tab.equalsIgnoreCase("Integrazione")%>'>
		<jsp:include page="tabs/integration.jsp" flush="true" />
	</c:if>
	
</liferay-ui:tabs>