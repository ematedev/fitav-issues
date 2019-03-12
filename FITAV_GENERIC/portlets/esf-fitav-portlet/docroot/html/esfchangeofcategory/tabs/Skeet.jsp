
<%-- <%@ include file="/html/esfchangeofcategory/init.jsp"%> --%>

<%System.out.println("in skeet year="+year); %>
<portlet:actionURL name="changeOfCategory" var="changeOfCategoryURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
	<portlet:param name="esfSportTypeId" 
		value='12932'></portlet:param>
		<portlet:param name="year" 
		value='<%=year %>'></portlet:param>
</portlet:actionURL>

<h1>SKEET</h1>

<%
//String skeet = ParamUtil.getString(request, "skeet");
if(Validator.isNull(skeet)){
	%>	


	<%	
	
}else{
	
	int yearInt = Integer.valueOf(year);
	long esfSportTypeId = 12932;
		List<ESFUserCategory> selectedUser = ESFUserCategoryLocalServiceUtil.findUserByS_ED(esfSportTypeId, yearInt);
		List<Long> userOldId = new ArrayList<Long>();
				
	if(Validator.isNotNull(selectedUser)){
		for(ESFUserCategory u : selectedUser){
			userOldId.add(u.getEsfUserId());
		}
	}
	
	
	
%>
<h3>entro in skeet</h3>
<aui:form name = "changeOfCategory" type="submit" action="<%=changeOfCategoryURL%>" >
<%
	if(Validator.isNotNull(userPromovedThirdCategorySK)){%>
	<h3>Promuovibili terza categoria</h3>
	<% 
		for(ESFUser userPromovedThirdCategorySKs : userPromovedThirdCategorySK){
			if (!userOldId.contains(userPromovedThirdCategorySKs.getEsfUserId())){
%>
				<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userPromovedThirdCategorySKs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userPromovedThirdCategorySKs.getEsfUserId()%>'
											value='<%=userPromovedThirdCategorySKs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userPromovedThirdCategorySKs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userPromovedThirdCategorySKs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="fiscalCode" type="text" value="<%=userPromovedThirdCategorySKs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="nextCategory" type="hidden" value="2" inlineField="true" ></aui:input>
	
				</div>
<%
			}
		}
	}
	if(Validator.isNotNull(userPromovedSecondCategorySK)){%>
	<h3>Promuovibili seconda categoria</h3>
	<% 
	
		
		for(ESFUser userPromovedSecondCategorySKs : userPromovedSecondCategorySK){
			if (!userOldId.contains(userPromovedSecondCategorySKs.getEsfUserId())){
	%>
			<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userPromovedSecondCategorySKs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userPromovedSecondCategorySKs.getEsfUserId()%>'
											value='<%=userPromovedSecondCategorySKs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userPromovedSecondCategorySKs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userPromovedSecondCategorySKs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="fiscalCode" type="text" value="<%=userPromovedSecondCategorySKs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="nextCategory" type="hidden" value="1" inlineField="true" ></aui:input>
	
				</div>
<%
			}
		}
	}
%>


	<aui:button-row>
		<aui:button type="submit" value="Assoce_Category"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>
<%
}
%>