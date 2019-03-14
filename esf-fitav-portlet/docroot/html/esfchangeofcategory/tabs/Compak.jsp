

<%-- <%@ include file="/html/esfchangeofcategory/init.jsp"%> --%>
<%System.out.println("in compak year="+year); %>
<portlet:actionURL name="changeOfCategory" var="changeOfCategoryURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
	<portlet:param name="esfSportTypeId" 
		value='12933'></portlet:param>
		<portlet:param name="year" 
		value='<%=year %>'></portlet:param>
</portlet:actionURL>

<h1>Compak</h1>






<%
//String compak = ParamUtil.getString(request, "compak");

if(Validator.isNull(compak)){
%>	


<%	
}else{

	int yearInt = Integer.valueOf(year);
	long esfSportTypeId = 12933;
		List<ESFUserCategory> selectedUser = ESFUserCategoryLocalServiceUtil.findUserByS_ED(esfSportTypeId, yearInt);
		List<Long> userOldId = new ArrayList<Long>();
				
	if(Validator.isNotNull(selectedUser)){
		for(ESFUserCategory u : selectedUser){
			userOldId.add(u.getEsfUserId());
		}
	}

%>
<aui:form name = "changeOfCategory" type="submit" action="<%=changeOfCategoryURL%>" >
<%
	if(Validator.isNotNull(userPromovedSecondCategoryCK)){%>
	<h3>Promuovibili seconda categoria</h3>
	<% 
		for(ESFUser userPromovedSecondCategoryCKs : userPromovedSecondCategoryCK){
			if (!userOldId.contains(userPromovedSecondCategoryCKs.getEsfUserId())){
%>
				<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userPromovedSecondCategoryCKs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userPromovedSecondCategoryCKs.getEsfUserId()%>'
											value='<%=userPromovedSecondCategoryCKs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userPromovedSecondCategoryCKs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userPromovedSecondCategoryCKs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="Fiscalcode" type="text" value="<%=userPromovedSecondCategoryCKs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="nextCategory" type="hidden" value="1" inlineField="true" ></aui:input>
	
				</div>
<%
			}
		}
	}
	if(Validator.isNotNull(userPromovedThirdCategoryCK)){%>
	<h3>Promuovibili terza categoria</h3>
	<% 
		for(ESFUser userPromovedThirdCategoryCKs : userPromovedThirdCategoryCK){
			if (!userOldId.contains(userPromovedThirdCategoryCKs.getEsfUserId())){
	%>
			<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userPromovedThirdCategoryCKs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userPromovedThirdCategoryCKs.getEsfUserId()%>'
											value='<%=userPromovedThirdCategoryCKs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userPromovedThirdCategoryCKs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userPromovedThirdCategoryCKs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="Fiscalcode" type="text" value="<%=userPromovedThirdCategoryCKs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="nextCategory" type="hidden" value="2" inlineField="true" ></aui:input>
	
				</div>
<%
			}
		}
	}
	if(Validator.isNotNull(userRetrocessedFirstCategoryCK)){%>
	<h3>retrocedibili prima categoria</h3>
	<% 
		for(ESFUser userRetrocessedFirstCategoryCKs : userRetrocessedFirstCategoryCK){
			if (!userOldId.contains(userRetrocessedFirstCategoryCKs.getEsfUserId())){
%>
			<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userRetrocessedFirstCategoryCKs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userRetrocessedFirstCategoryCKs.getEsfUserId()%>'
											value='<%=userRetrocessedFirstCategoryCKs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userRetrocessedFirstCategoryCKs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userRetrocessedFirstCategoryCKs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="fiscalCode" type="text" value="<%=userRetrocessedFirstCategoryCKs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="nextCategory" type="hidden" value="2" inlineField="true" ></aui:input>
	
				</div>
<%
			}
		}
	}
	if(Validator.isNotNull(userRetrocessedExcellenceCategoryCK)){%>
	<h3>retrocedibili eccellenza categoria</h3>
	<% 
		for(ESFUser userRetrocessedExcellenceCategoryCKs : userRetrocessedExcellenceCategoryCK){
			if (!userOldId.contains(userRetrocessedExcellenceCategoryCKs.getEsfUserId())){
%>
			<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userRetrocessedExcellenceCategoryCKs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userRetrocessedExcellenceCategoryCKs.getEsfUserId()%>'
											value='<%=userRetrocessedExcellenceCategoryCKs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userRetrocessedExcellenceCategoryCKs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userRetrocessedExcellenceCategoryCKs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="fiscalCode" type="text" value="<%=userRetrocessedExcellenceCategoryCKs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
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