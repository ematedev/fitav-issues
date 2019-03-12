
<%@include file="init.jsp"%>
<% 
Calendar cal = Calendar.getInstance();
int anno = cal.get(Calendar.YEAR)-1;
String ex = "add-ex-national";

List<Long> idSport = new ArrayList<Long>();

List<ESFSportType> sports = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();

for(ESFSportType sport : sports){
	if(sport.getIsOlimpic()){
		idSport.add(sport.getEsfSportTypeId());
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
	<aui:button-row cssClass="esfnationaldelegation-admin-buttons">
	
		<portlet:renderURL var="renderURL">
			<portlet:param name="mvcPath" value='<%=templatePath+"shooterCandidate.jsp"%>' />
		</portlet:renderURL>
		
		<aui:button onClick="<%= renderURL.toString() %>" value="add-to-national" />
	</aui:button-row>
</c:if>

<%
for(long id : idSport){
	
	ESFSportType type = ESFSportTypeLocalServiceUtil.fetchESFSportType(id);


%>
<h3><%=type.getName() %></h3>
	

<div class="separator"></div>	

<liferay-ui:search-container emptyResultsMessage="no-results" orderByType="<%=orderByType%>">
	<liferay-ui:search-container-results >
	
<% 

		List<ESFNational> shooters = ESFNationalLocalServiceUtil.getActiveESFNationals(id, searchContainer.getStart(), searchContainer.getEnd());
		
		int tot = ESFNationalLocalServiceUtil.getActiveESFNationals(id).size();
		
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
		<liferay-ui:search-container-column-text name="name" value="<%=esfNational.getUserName() %>"/>
			
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
			name="start-Date-National" value="<%=d2.toString() %>" />
		
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
		
		<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFNATIONALDELEGATION_VIEW_ACTION) %>">	
	
			<liferay-ui:search-container-column-jsp
					path='<%=templatePath + "esfPopupModifyNational.jsp"%>' align="right" />
		</c:if>			


	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />	
</liferay-ui:search-container>

<c:if test="<%= ESFNationalDelegationModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFNATIONALDELEGATION_ADD_EX_SHOOTER+"_"+type.getName()) %>">	
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
