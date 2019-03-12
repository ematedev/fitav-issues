<%@page import="it.ethica.esf.model.ESFUserCategory"%>

<%-- <%@ include file="/html/esfchangeofcategory/init.jsp"%> --%>

<portlet:actionURL name="changeOfCategory" var="changeOfCategoryURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
	<portlet:param name="esfSportTypeId" 
		value='12935'></portlet:param>
		<portlet:param name="year" 
		value='<%=year %>'></portlet:param>
</portlet:actionURL>

<h1>DOUBLE TRAP</h1> 


<%
//String double_Trap = ParamUtil.getString(request, "double_Trap");

if(Validator.isNull(double_Trap)){
	%>	
	
	

	<%	
	
}else{
int yearInt = Integer.valueOf(year);
long esfSportTypeId = 12935;
	List<ESFUserCategory> selectedUser = ESFUserCategoryLocalServiceUtil.findUserByS_ED(esfSportTypeId, yearInt);
	List<Long> userOldId = new ArrayList<Long>();
			
if(Validator.isNotNull(selectedUser)){
	for(ESFUserCategory u : selectedUser){
		userOldId.add(u.getEsfUserId());
	}
}
	if(Validator.isNotNull(userRetrocededSecondCategoryDT)){%>
		<h3>retrocedibili in terza categoria</h3>
		<aui:form name = "changeOfCategory" type="submit" action="<%=changeOfCategoryURL%>" >

	<%	for(ESFUser userRetrocededSecondCategoryDTs : userRetrocededSecondCategoryDT){
		 	if (!userOldId.contains(userRetrocededSecondCategoryDTs.getEsfUserId())){
%>				
				<div>
						<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userRetrocededSecondCategoryDTs.getEsfUserId() %>' ></aui:input>
						<aui:input type="hidden" name="esfUserIds"
											id='<%="esfUserIds_" + userRetrocededSecondCategoryDTs.getEsfUserId()%>'
											value='<%=userRetrocededSecondCategoryDTs.getEsfUserId()%>' />
						<aui:input name="firstName" type="text" value="<%=userRetrocededSecondCategoryDTs.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="lastName" type="text" value="<%=userRetrocededSecondCategoryDTs.getLastName() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="fiscalCode" type="text" value="<%=userRetrocededSecondCategoryDTs.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
						<aui:input name="nextCategory" type="hidden" value="3" inlineField="true" ></aui:input>
	
				</div>
<%
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
}
%>