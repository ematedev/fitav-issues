<%@page import="it.ethica.esf.util.DateUtilFormatter"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="java.util.Collection"%>
<%@page import="it.ethica.esf.model.VW_ESFListaIncarichi"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@ include file="init.jsp"%>

<%
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;


	if (orderByType.equals("desc")) {
		orderByType = "asc";
	}
	else {
		orderByType = "desc";
	}

	if (Validator.isNull(orderByType)) {
		orderByType = "desc";
	}
	
	
	String currYear = ManageDate.DateToString( new Date());
	int currentYear = Integer.valueOf(currYear.substring(currYear.lastIndexOf("/")+1));
	int maxYearAgo = ESFKeys.MaxYearAgo.maxYearAgo;
	String lastBdo = ParamUtil.getString(request, "lastBdo");
	String yearSelected = ParamUtil.getString(request, "yearSelected");
%>



<portlet:actionURL name="yearsEarlier" var="yearsEarlierURL">
	<portlet:param name="mvcPath" 
		value='<%=templatePath + "view.jsp" %>'></portlet:param>
	<portlet:param name="currentOrganizationId" 
		value='<%=String.valueOf(currentOrganizationId) %>'></portlet:param>
		
</portlet:actionURL>


<liferay-ui:error key="userrole-maxuser-error"
	message="userrole-maxuser-error" />

<liferay-ui:search-container orderByType="<%=orderByType%>" emptyResultsMessage="no-results">
	<liferay-ui:search-container-results>
<%
			List<ESFUserRole> allEsfUserRolePerPage =
					ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(currentType, ESFKeys.ESFStateType.ENABLE, true);

			int totalEsfUserRole = allEsfUserRolePerPage.size();


			List<ESFUserRole> sortableEsfUserRole =
					new ArrayList<ESFUserRole>(allEsfUserRolePerPage);

			if (Validator.isNotNull(orderByCol)) {
				BeanComparator beanComparator =
							new BeanComparator(orderByCol);

				Collections.sort(sortableEsfUserRole, beanComparator);

				if (sortingOrder.equalsIgnoreCase("desc")) {

							Collections.reverse(sortableEsfUserRole);
				}
			}
			
			pageContext.setAttribute("results", sortableEsfUserRole);
			pageContext.setAttribute("total", totalEsfUserRole);
			 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUserRole" modelVar="userRole">

		<%
		List<ESFUserESFUserRole> esfUserESFUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
						currentOrganizationId, userRole.getEsfUserRoleId());

	/*	List<ESFUserESFUserRole> esfUserESFUserRoles =
		ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R_D_NOL(
			currentOrganizationId, userRole.getEsfUserRoleId(),new java.sql.Date(Calendar.getInstance().getTimeInMillis()));*/
		String usersAssigned = "";
		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
				ESFUser esfUser =
					ESFUserLocalServiceUtil.fetchESFUser(esfUserESFUserRole.getEsfUserId());
				if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFirstName()) && Validator.isNotNull(esfUser.getLastName()))
					usersAssigned += esfUser.getFirstName()+" "+esfUser.getLastName()+"<br>";
				
		}
		%>
		<liferay-ui:search-container-column-text property="title"
			orderable="true" orderableProperty="title"  />

		<liferay-ui:search-container-column-text property="name"
			orderable="true" orderableProperty="name" />

		<liferay-ui:search-container-column-text property="description"
			orderable="true" orderableProperty="description"  />

		<liferay-ui:search-container-column-text name="user" >
			<%=  usersAssigned%>
		</liferay-ui:search-container-column-text>

		<c:if test="<%= ESFBDOPermission.contains(permissionChecker,userRole.getEsfUserRoleId(), ActionKeys.ESFBDO_UPDATE) %>">	
				<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfUserRole_action.jsp"%>' align="right" />
		</c:if>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<h3>	<liferay-ui:message key="select_years_earlier" /></h3>

<aui:form action="<%=yearsEarlierURL%>" name="fm">  
<aui:select name="year" showEmptyOption="false" id="year" required="true">
	<%for(int i = 1; i <= maxYearAgo ; i++){
		currentYear = currentYear-1;
		String year = String.valueOf(currentYear);
		if(Validator.isNotNull(yearSelected) && year== yearSelected){
		%>
			<aui:option label="<%=year %>" value="<%=year %>" selected="true" ></aui:option>
		
		<%	
		}else{
		%>
			<aui:option label="<%=year %>" value="<%=year %>" ></aui:option>
		
		<%	
		}
	} 
	%>
</aui:select>
<aui:button name = "submit" type="submit" value="run">	</aui:button>
</aui:form>

<%if(Validator.isNotNull(lastBdo)) {
		
	
	Collection<VW_ESFListaIncarichi> listaIncarichiConsiglieri = (Collection<VW_ESFListaIncarichi>)  request.getAttribute("userBDOAdmins");
	//List<ESFUserESFUserRole> userBDOAdminsAll = (List<ESFUserESFUserRole>)  request.getAttribute("userBDOAdminsAll");

	ESFUser admin = null;
	ESFUserRole role = null;
	
	if(Validator.isNotNull(listaIncarichiConsiglieri) && listaIncarichiConsiglieri.size()>0) { %>
	
		<h2><liferay-ui:message key="Board_of_year"/> <%=yearSelected %> </h2>
	<%
		for(VW_ESFListaIncarichi incaricoConsigliereCorrente : listaIncarichiConsiglieri) {	%>
	
			
	<div>
	
			<aui:input name="Role" label="role" type="text" value="<%= incaricoConsigliereCorrente.getNomeRuolo() %>" disabled="true" inlineField="true"></aui:input>
			<aui:input name="firstName" label="firstName" type="text" value="<%= incaricoConsigliereCorrente.getFirstName() %>" disabled="true" inlineField="true"></aui:input>
			<aui:input name="Lastname" label="lastName" type="text" value="<%=incaricoConsigliereCorrente.getLastName() %>" disabled="true" inlineField="true"></aui:input>
			<aui:input name="Dal" label="startDate" type="text" value="<%= DateUtilFormatter.formatDate( incaricoConsigliereCorrente.getStartDate() ) %>" disabled="true" inlineField="true"></aui:input>
			<aui:input name="al" label="endDate" type="text" value='<%= incaricoConsigliereCorrente.getEndDate() != null ? DateUtilFormatter.formatDate(incaricoConsigliereCorrente.getEndDate() ) : "" %>' disabled="true" inlineField="true"></aui:input>

	</div>
	<% } %>
	<% } else { %>
		<h3>	<liferay-ui:message	key="no-user" /></h3>
	<% } 

}%>
