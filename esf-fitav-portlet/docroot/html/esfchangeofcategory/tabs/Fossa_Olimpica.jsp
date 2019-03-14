<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="it.ethica.esf.model.ESFUser"%>



<%-- <%@ include file="/html/esfchangeofcategory/init.jsp"%> --%>

<%System.out.println("in fossa olimpica year="+year); %>

<portlet:actionURL name="changeOfCategory" var="changeOfCategoryURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
	<portlet:param name="esfSportTypeId" 
		value='11217'></portlet:param>
		<portlet:param name="year" 
		value='<%=year %>'></portlet:param>
</portlet:actionURL>

<h1>Fossa Olimpica</h1>


<% 




if(Validator.isNull(fossa_Olimpica)){
	
	
	%>	


	<%	
	
}else{
	int yearInt = Integer.valueOf(year);
	long esfSportTypeId = 11217;
		List<ESFUserCategory> selectedUser = ESFUserCategoryLocalServiceUtil.findUserByS_ED(esfSportTypeId, yearInt);
		List<Long> userOldId = new ArrayList<Long>();
				
	if(Validator.isNotNull(selectedUser)){
		for(ESFUserCategory u : selectedUser){
			userOldId.add(u.getEsfUserId());
		}
	}
	

	if(Validator.isNotNull(userPromovedSecondCategory) && Validator.isNotNull(userRetrocessedSecondCategory) &&
			Validator.isNotNull(userRetrocessedFirstCategory) && Validator.isNotNull(userPromovedThirdCategory)){
	

	%>
	<aui:form name = "changeOfCategory" type="submit" action="<%=changeOfCategoryURL%>" >
		
		<h3>POSSIBILI RETROCEDIBILI DALLA PRIMA CATEGORIA</h3>
	<%
	if(Validator.isNotNull(userRetrocessedFirstCategory)){
		for(ESFUser userRetrocessedFirstCategorys : userRetrocessedFirstCategory){
			if (!userOldId.contains(userRetrocessedFirstCategorys.getEsfUserId())){
		%>
	<div>
		<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userRetrocessedFirstCategorys.getEsfUserId() %>' ></aui:input>
		<aui:input type="hidden" name="esfUserIds"
							id='<%="esfUserIds_" + userRetrocessedFirstCategorys.getEsfUserId()%>'
							value='<%=userRetrocessedFirstCategorys.getEsfUserId()%>' />
		<aui:input name="firstName" type="text" value="<%=userRetrocessedFirstCategorys.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="lastName" type="text" value="<%=userRetrocessedFirstCategorys.getLastName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="fiscalCode" type="text" value="<%=userRetrocessedFirstCategorys.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="nextCategory" type="hidden" value="2" inlineField="true" ></aui:input>
	</div>
	<%
			}
		}
	}	
	%>

	<h3>POSSIBILI PROMUOVIBILI DALLA SECONDA CATEGORIA</h3>
	
	<%
	if(Validator.isNotNull(userRetrocessedFirstCategory)){
		for(ESFUser userPromovedSecondCategorys : userPromovedSecondCategory){
			if (!userOldId.contains(userPromovedSecondCategorys.getEsfUserId())){
		%>
		
		<div>
		<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userPromovedSecondCategorys.getEsfUserId() %>' ></aui:input>
		<aui:input type="hidden" name="esfUserIds"
							id='<%="esfUserIds_" + userPromovedSecondCategorys.getEsfUserId()%>'
							value='<%=userPromovedSecondCategorys.getEsfUserId()%>' />
		<aui:input name="firstName" type="text" value="<%=userPromovedSecondCategorys.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="lastName" type="text" value="<%=userPromovedSecondCategorys.getLastName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="fiscalCode" type="text" value="<%=userPromovedSecondCategorys.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="nextCategory" type="hidden" value="1" inlineField="true"></aui:input>
		</div>
		<%
			}
		}
	}	
	%>

	<h3>POSSIBILI RETROCEDIBILI DALLA SECONDA CATEGORIA</h3>

	<%
	if(Validator.isNotNull(userRetrocessedFirstCategory)){
		for(ESFUser userRetrocessedSecondCategorys : userRetrocessedSecondCategory){
			if (!userOldId.contains(userRetrocessedSecondCategorys.getEsfUserId())){
		%>
		
		<div>
		<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userRetrocessedSecondCategorys.getEsfUserId() %>' ></aui:input>
		<aui:input type="hidden" name="esfUserIds"
							id='<%="esfUserIds_" + userRetrocessedSecondCategorys.getEsfUserId()%>'
							value='<%=userRetrocessedSecondCategorys.getEsfUserId()%>' />
		<aui:input name="firstName" type="text" value="<%=userRetrocessedSecondCategorys.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="lastName" type="text" value="<%=userRetrocessedSecondCategorys.getLastName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="fiscalCode" type="text" value="<%=userRetrocessedSecondCategorys.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="nextCategory" type="hidden" value="3" inlineField="true"></aui:input>
		</div>
		<%
			}
		}
	} 
	%>

	<h3>POSSIBILI PROMUOVIBILI DALLA TERZA CATEGORIA</h3>
		
	<%
	if(Validator.isNotNull(userPromovedThirdCategory)){
		for(ESFUser userPromovedThirdCategorys : userPromovedThirdCategory){
			if (!userOldId.contains(userPromovedThirdCategorys.getEsfUserId())){
		%>
		
		<div>
		<aui:input name="choose" label="" type="checkbox" checked="false" id='<%="check"+userPromovedThirdCategorys.getEsfUserId() %>' ></aui:input>
		<aui:input type="hidden" name="esfUserIds"
							id='<%="esfUserIds_" + userPromovedThirdCategorys.getEsfUserId()%>'
							value='<%=userPromovedThirdCategorys.getEsfUserId()%>' />
		<aui:input name="firstName" type="text" value="<%=userPromovedThirdCategorys.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="lastName" type="text" value="<%=userPromovedThirdCategorys.getLastName() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="fiscalCode" type="text" value="<%=userPromovedThirdCategorys.getFiscalCode() %>" disabled="true" inlineField="true"></aui:input>
		<aui:input name="nextCategory" type="hidden" value="2" inlineField="true"></aui:input>
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
}
%>