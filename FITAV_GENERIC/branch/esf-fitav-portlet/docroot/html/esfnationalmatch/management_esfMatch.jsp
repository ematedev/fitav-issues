<%@include file="init.jsp"%>
<% 
	String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	int urlEndIndex = currentUrlPage.indexOf('?');
	String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	if(urlEndIndex != -1){
		backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
	}
	portletDisplay.setURLBack(backtoViewUrl);

	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	ESFMatch currentMatch = null;

	if(Validator.isNotNull(esfMatchId)){
		currentMatch =
					ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
	}
		String matchDescription=StringPool.BLANK;
		String startDate = "";
		String endDate = "";
		
		
		if(Validator.isNotNull(currentMatch) ){
			if(Validator.isNotNull( currentMatch.getDescription()) && Validator.isNotNull(ESFDescriptionLocalServiceUtil.fetchESFDescription(currentMatch.getDescription())) &&
					Validator.isNotNull(ESFDescriptionLocalServiceUtil.fetchESFDescription(currentMatch.getDescription()).getName())){
				matchDescription=ESFDescriptionLocalServiceUtil.fetchESFDescription(currentMatch.getDescription()).getName();
			}
			if(Validator.isNotNull(currentMatch.getStartDate())){
				startDate = ManageDate.DateToString(currentMatch.getStartDate());
			}
			if(Validator.isNotNull(currentMatch.getEndDate())){
				endDate = ManageDate.DateToString(currentMatch.getEndDate());
			}
			
		}
		%>

		<div id="info-national-match">
			<h3> 
				<%=matchDescription%>
			</h3> 
			<div class = "text-left">
				
				<h3> <%=startDate + "  -  " + endDate%> </h3>
				
			</div>
			<%if(currentMatch.getCountryId() > 0){%>
			<h3 ><%=CountryServiceUtil.fetchCountry(
						currentMatch.getCountryId()).getName() +
						" " + currentMatch.getSite()%>
			</h3>
			<% }%>
		</div>	
		
		<%
			PortletURL tabURL = renderResponse.createRenderURL();
			String tab =
				ParamUtil.getString(request, "myParam", "Generale");
			tabURL.setParameter("mvcPath", templatePath + "/management_esfMatch.jsp");
			tabURL.setParameter("tab", tab);
			tabURL.setParameter("organizationId", String.valueOf(currentOrganizationId));
			tabURL.setParameter("esfMatchId", String.valueOf(esfMatchId));	
		
		%>
		
		<liferay-ui:tabs
			names="Generale,Itenerari,Stampe"
			url="<%=tabURL.toString()%>" param="myParam" refresh="true">
			<c:if test='<%=tab.equalsIgnoreCase("Generale")%>'>
				<jsp:include page="tabs/general.jsp" flush="true" />
			</c:if>
		
			<c:if test='<%=tab.equalsIgnoreCase("Itenerari")%>'>
				<jsp:include page="tabs/partenze.jsp" flush="true" />
			</c:if>
		
			<c:if test='<%=tab.equalsIgnoreCase("Stampe")%>'>
				<jsp:include page="tabs/stampe.jsp" flush="true" />
			</c:if>
			
		</liferay-ui:tabs>

