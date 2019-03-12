
<%@page import="it.ethica.esf.model.impl.ESFSportTypeImpl"%>
<%@include file="init.jsp"%>
<% 
Calendar cal = Calendar.getInstance();
int anno = cal.get(Calendar.YEAR)-1;
String ex = "add-ex-national";

List<Long> idSport = new ArrayList<Long>();

String sportName0 = "";
String sportName1 = "";
String sportName2 = "";

long idSport0 = 0;
long idSport1 = 0;
long idSport2 = 0;


ESFSportType type = new ESFSportTypeImpl();

List<ESFSportType> sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

for(ESFSportType sport : sports){
	if(sport.getIsOlimpic()){
		idSport.add(sport.getEsfSportTypeId());
	}
	
}

if(Validator.isNotNull(idSport) && 0 < idSport.size() && Validator.isNotNull(idSport.get(0))){
	
	idSport0 = idSport.get(0);
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport0)) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport0).getName())){
		sportName0 = ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport0).getName();
	}
}
if(Validator.isNotNull(idSport) && 1< idSport.size() && Validator.isNotNull(idSport.get(1))){
	
	idSport1 = idSport.get(1);
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport1)) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport1).getName())){
		sportName1 = ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport1).getName();
	}
}
if(Validator.isNotNull(idSport) && 2 < idSport.size() && Validator.isNotNull(idSport.get(2))){
	
	idSport2 = idSport.get(2);
	if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport2)) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport2).getName())){
		sportName2 = ESFSportTypeLocalServiceUtil.fetchESFSportType(idSport2).getName();
	}
}

String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil.getString(request, "orderByType");
String sortingOrder = orderByType;

if (orderByType.equals("desc")) {
	orderByType = "asc";
} else {
	orderByType = "desc";
}

if (Validator.isNull(orderByType)) {
	orderByType = "desc";
}
%>
<liferay-ui:error key="esfDelgation-reference-error" message="esfDelgation-reference-error"/>

<c:if test="<%= ESFNationalDelegationModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNATIONALDELEGATION_ADD) %>">

	<portlet:renderURL var="renderURL0">
				<portlet:param name="mvcPath" value='<%=templatePath+"shooterCandidate.jsp"%>' />
				<portlet:param name="stId" value='<%=String.valueOf(idSport0)%>' />
	</portlet:renderURL>
	
	<portlet:renderURL var="renderURL1">
		<portlet:param name="mvcPath" value='<%=templatePath+"shooterCandidate.jsp"%>' />
		<portlet:param name="stId" value='<%=String.valueOf(idSport1)%>' />
	</portlet:renderURL>
	
	<portlet:renderURL var="renderURL2">
		<portlet:param name="mvcPath" value='<%=templatePath+"shooterCandidate.jsp"%>' />
		<portlet:param name="stId" value='<%=String.valueOf(idSport2)%>' />
	</portlet:renderURL>

	<aui:button-row cssClass="esfnationaldelegation-admin-buttons">
<%
if(Validator.isNotNull(idSport0) && Validator.isNotNull(sportName0)){
	String buttonName0 = "add-to-national " + sportName0;
	buttonName0 = buttonName0.replace(" ", "-");
%>
			<aui:button onClick="<%= renderURL0.toString() %>" value='<%=buttonName0 %>' iconAlign="true"/>
<%
}
if(Validator.isNotNull(idSport1) && Validator.isNotNull(sportName1)){
	String buttonName1 = "add-to-national " + sportName1;
	buttonName1 = buttonName1.replace(" ", "-");
%>
			<aui:button onClick="<%= renderURL1.toString() %>" value='<%= buttonName1%>' iconAlign="true" />
<%
}
if(Validator.isNotNull(idSport2) && Validator.isNotNull(sportName2)){
	String buttonName2 = "add-to-national " + sportName2;
	buttonName2 = buttonName2.replace(" ", "-");
%>
			<aui:button onClick="<%= renderURL2.toString() %>" value='<%= buttonName2%>' iconAlign="true" />
<%
}
%>
	</aui:button-row>
	
</c:if>

<%
for(long id : idSport){
	
	type = ESFSportTypeLocalServiceUtil.fetchESFSportType(id);


%>
<h3><%=type.getName() %></h3>
	

<div class="separator"></div>	

<liferay-ui:search-container emptyResultsMessage="no-results" orderByType="<%=orderByType%>">
	<liferay-ui:search-container-results >
	
<% 
		List<ESFNational> shooters = ESFNationalLocalServiceUtil.getActiveESFNationals(id, searchContainer.getStart(), searchContainer.getEnd());
		
		int tot = ESFNationalLocalServiceUtil.getActiveESFNationals(id,-1,-1).size();
		
		List<ESFNational> shootersOrd = new ArrayList<ESFNational>(shooters);
		
		if (Validator.isNotNull(orderByCol)) {
			BeanComparator beanComparator = new BeanComparator(orderByCol);
			
			Collections.sort(shootersOrd,beanComparator);
			
			if (sortingOrder.equalsIgnoreCase("desc")) {
			
				Collections.reverse(shootersOrd);
			}
		}
		
		pageContext.setAttribute("results", shootersOrd);
		pageContext.setAttribute("total", tot);
%>
	</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFNational" modelVar="esfNational">
		
		<% 
		User userNational = UserLocalServiceUtil.getUser(esfNational.getUserId()); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="name" value="<%=esfNational.getUserName() %>" orderable="true" orderableProperty="userName"/>
			
		<liferay-ui:search-container-column-text name="birthday" value="<%=sdf.format(userNational.getBirthday()).toString()%>"/>
		<% 
		String d=sdf.format(esfNational.getEndDate());
		String d2=sdf.format(esfNational.getStartDate());
		String deliberateD ="";
		if(Validator.isNotNull(esfNational.getDeliberateDate()))
		{
			deliberateD = sdf.format(esfNational.getDeliberateDate());
		}
		%>			
		<liferay-ui:search-container-column-text name="user-email">	
		
		<%ESFUser esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfNational.getEsfUserId()); %>
		
		<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text 
			name="start-Date-National" value="<%=d2.toString() %>" orderable="true" orderableProperty="startDate"/>
		
		<liferay-ui:search-container-column-text 
			name="end-Date-National" value="<%=d.toString() %>"/>
			
		<liferay-ui:search-container-column-text orderable="true" orderableProperty="isNational"
			name="university" value='<%=(esfNational.getIsUniversity())?"SI":"NO" %>'/>
		
		<liferay-ui:search-container-column-text orderable="true" orderableProperty="isUniversity"
			name="isNational" value='<%=(esfNational.getIsNational())?"NAZIONALE":"NAZIONALE B/23" %>'/>
		
		<liferay-ui:search-container-column-text 
			name="deliberate" value='<%=esfNational.getDeliberate() %>'/>
			
		<liferay-ui:search-container-column-text 
			name="deliberateDate" value='<%=deliberateD.toString() %>'/>
		
		<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfNational.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_VIEW_ACTION) %>">	
	
			<liferay-ui:search-container-column-jsp
					path='<%=templatePath + "esfPopupModifyNational.jsp"%>' align="right" />
		</c:if>			


	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />	
</liferay-ui:search-container>
<%
String sportTypeAK ="ESFNATIONALDELEGATION_ADD_EX_SHOOTER"+"_"+type.getName().replace(" ","_").toUpperCase();
sportTypeAK = sportTypeAK.replace("-", "");
%>
<c:if test='<%= ESFNationalDelegationModelPermission.contains(permissionChecker,scopeGroupId, sportTypeAK.toUpperCase()) %>'>	
	<aui:button-row cssClass="esfnationaldelegation-admin-buttons">
		<portlet:renderURL var="exShooter">
			<portlet:param name="mvcPath" value='<%=templatePath+"addExNational.jsp"%>' />
			<portlet:param name="sport" value="<%=String.valueOf(id)  %>"/>
		</portlet:renderURL>
		
		<aui:button onClick="<%=exShooter.toString() %>" value="<%= ex %>" align="right"/>
	</aui:button-row>
</c:if>
<%

}
%>
