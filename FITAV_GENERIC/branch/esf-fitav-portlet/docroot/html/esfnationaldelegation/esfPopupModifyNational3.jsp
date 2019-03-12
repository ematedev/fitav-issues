<%@include file="init.jsp"%>



	<portlet:actionURL var="actionModifyNationalURL2" name="actionModifyNational2"  >
	</portlet:actionURL>

	<portlet:renderURL var="renderURL">
		<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp"%>' />
	</portlet:renderURL>

<%
String userID=request.getParameter("esfNational");
ESFNational national=ESFNationalLocalServiceUtil.fetchESFNational((Long.parseLong(userID)));
long sportType=national.getEsfSportTypeId();
boolean isNat=national.getIsNational();
String valueChecked = "";
if(isNat){
	valueChecked = "true";
}
else 
{
	valueChecked ="false";
}
boolean isUniv=national.getIsUniversity();
ESFSportType sport=ESFSportTypeLocalServiceUtil.getESFSportType(sportType);
%>

<aui:form action="<%= actionModifyNationalURL2 %>" method="post" name="fm">
		
	<aui:input type="hidden" name="esfNationalID" value="<%=userID %>" />
	<aui:input type="hidden" name="sportType" value="<%=sportType %>" />
	
		<div class="interBox">
		<% 
		boolean checked=false;
		if(isNat){ 
			checked=true;
		} %>

	<aui:input type="radio" name="isNational" id="isNational" value="isNational" label="isNational" checked="<%= checked %>"/>
	<aui:input type="radio" name="isNational" id="isNational" value="isNationalB/23" label="isNationalB/23" checked="<%= !checked %>"/>
	

	</div>
		<div class="interBox">		
		<aui:input type="checkbox" name="isUniversity" key="is-University" value="<%=isUniv %>" />
	</div>
	
	<div class="separator"></div>
	
	<aui:button-row>
		<aui:button type="submit" value="OK"></aui:button>
		<aui:button type="cancel" onClick="<%= renderURL.toString() %>" value="back"></aui:button>
	</aui:button-row>
		
	
</aui:form>

 
