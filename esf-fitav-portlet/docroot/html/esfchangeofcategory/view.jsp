<%@include file="init.jsp"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>

<portlet:actionURL name="computes" var="computesURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
</portlet:actionURL>

<portlet:actionURL name="print" var="printURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
</portlet:actionURL>

<%


String tabs = ParamUtil.getString(request, "tabs1", "Fossa_Olimpica");
portletURL.setParameter("tabs", tabs);
String tabNames = "Fossa_Olimpica,Skeet,Double_Trap,Compak";

PortletSession pSession = null;
if(renderRequest.getPortletSession()!=null){
	pSession  = renderRequest.getPortletSession();
}

boolean promoved = true;
String currYear = ManageDate.DateToString( new Date());
int currentYear = Integer.valueOf(currYear.substring(currYear.lastIndexOf("/")+1));

String thisYear = String.valueOf(currentYear).toString();
String lastYear = String.valueOf((currentYear-1)).toString();
List<ESFSportType> sportTypes = ESFSportTypeLocalServiceUtil.getESFSportTypesIsChangeCategory(promoved);

String calculate = (String) pSession.getAttribute("calculate");
String year = (String) pSession.getAttribute("year");
String fossa_Olimpica =(String) pSession.getAttribute("fossa_Olimpica");
String skeet =(String) pSession.getAttribute("skeet");
String double_Trap =(String) pSession.getAttribute("double_Trap");
String compak =(String) pSession.getAttribute("compak");

//utenti fossa olimpica
List<ESFUser> userPromovedSecondCategory = (List<ESFUser>) pSession.getAttribute("userPromovedSecondCategory");
List<ESFUser> userRetrocessedSecondCategory = (List<ESFUser>) pSession.getAttribute("userRetrocessedSecondCategory");
List<ESFUser> userRetrocessedFirstCategory = (List<ESFUser>) pSession.getAttribute("userRetrocessedFirstCategory");
List<ESFUser> userPromovedThirdCategory = (List<ESFUser>) pSession.getAttribute("userPromovedThirdCategory");
//utenti double trap
List<ESFUser> userRetrocededSecondCategoryDT = (List<ESFUser>) pSession.getAttribute("userRetrocededSecondCategoryDT");
//utenti compak
List<ESFUser> userPromovedSecondCategoryCK = (List<ESFUser>) pSession.getAttribute("userPromovedSecondCategoryCK");
List<ESFUser> userPromovedThirdCategoryCK = (List<ESFUser>) pSession.getAttribute("userPromovedThirdCategoryCK");
List<ESFUser> userRetrocessedFirstCategoryCK = (List<ESFUser>) pSession.getAttribute("userRetrocessedFirstCategoryCK");
List<ESFUser> userRetrocessedExcellenceCategoryCK = (List<ESFUser>) pSession.getAttribute("userRetrocessedExcellenceCategoryCK");
//utenti skeet
List<ESFUser> userPromovedThirdCategorySK = (List<ESFUser>) pSession.getAttribute("userPromovedThirdCategorySK");
List<ESFUser> userPromovedSecondCategorySK = (List<ESFUser>) pSession.getAttribute("userPromovedSecondCategorySK");


%>


<aui:form action="<%=computesURL%>" name="fm">

<aui:select name="year" showEmptyOption="false" id="year" required="true">
	<aui:option label="<%=thisYear %>" value="<%=thisYear %>"></aui:option>
	<aui:option label="<%=lastYear %>" value="<%=lastYear %>"></aui:option>
</aui:select>

<aui:select name="speciality" showEmptyOption="false" id="speciality" required="true">
			<aui:option label="All"
				value="0"></aui:option>
			<%for (ESFSportType sportType : sportTypes) { %>
			<aui:option label="<%=sportType.getName()%>"
				value="<%=sportType.getEsfSportTypeId()%>"></aui:option>
			<%
				}
			%>
</aui:select>

	<aui:button name = "submit" type="submit" value="run">	</aui:button>
	<aui:button type="cancel" onClick="<%=viewURL%>"></aui:button>
	
</aui:form>

<%

if(Validator.isNotNull(calculate)) { 
	
%>
	
	<aui:button name ="print"  onClick="<%=printURL%>"  value="print"></aui:button>
		

	
	<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>">
	
			<%
			System.out.println("nella view fossa_Olimpica vale :"+fossa_Olimpica);
			if(Validator.isNotNull(fossa_Olimpica)){
			%>
			<c:if test='<%=tabs.equals("Fossa_Olimpica")%>'>
					<%@ include file="/html/esfchangeofcategory/tabs/Fossa_Olimpica.jsp"%> 
				</c:if>
			<%
			
			}
			if(Validator.isNotNull(skeet)){
			%>
				<c:if test='<%=tabs.equals("Skeet")%>'>
					<%@ include file="/html/esfchangeofcategory/tabs/Skeet.jsp"%> 
				</c:if>
			
			<%
			}
			if(Validator.isNotNull(double_Trap)){
				%>
				<c:if test='<%=tabs.equals("Double_Trap")%>'>
					<%@ include file="/html/esfchangeofcategory/tabs/Double_Trap.jsp"%> 
				</c:if>
				
			<%} 
			if(Validator.isNotNull(compak)){
			%>
				<c:if test='<%=tabs.equals("Compak")%>'>
					<%@ include file="/html/esfchangeofcategory/tabs/Compak.jsp"%> 
				</c:if>
				
			<%} %>
			
	</liferay-ui:tabs>

<%	
}
%>		



