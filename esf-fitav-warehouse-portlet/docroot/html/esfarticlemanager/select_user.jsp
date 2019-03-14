<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>

<%
long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

String firstname = ParamUtil.getString(request, "firstname");
String lastname = ParamUtil.getString(request, "lastname");
String cardCode = ParamUtil.getString(request, "card");
Integer typestate = ParamUtil.getInteger(request, "typestate");
boolean isRegional = ParamUtil.getBoolean(request, "isRegional");
boolean isAss = ParamUtil.getBoolean(request, "isAss");

PortletURL iteratorURL = renderResponse.createRenderURL();

iteratorURL.setParameter("mvcPath", templatePath + "select_user.jsp");
iteratorURL.setParameter("firstname", firstname);
iteratorURL.setParameter("lastname", lastname);
iteratorURL.setParameter("cardCode", cardCode);
iteratorURL.setParameter("typestate", String.valueOf(typestate));
iteratorURL.setParameter("isRegional", String.valueOf(isRegional));
iteratorURL.setParameter("isAss", String.valueOf(isAss));
iteratorURL.setParameter("esfArticleId", Long.toString(esfArticleId));

boolean visible = false;
ESFOrganization organization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
String organizationName ="";
String orgCode = "";

if(Validator.isNotNull(organization) && Validator.isNotNull(organization.getType()) && 3 == organization.getType()){
	visible = true;
	organizationName = organization.getName();
	orgCode = organization.getCode();
}

String orderByCol = ParamUtil.getString(request, "orderByCol","lastName");
String orderByType = ParamUtil
	.getString(request, "orderByType","asc");
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

if (visible) { 
	String[] orgDetails = {organizationName,orgCode};
}
%>

<liferay-ui:header backURL="<%= viewURL %>" title="select-user-to-assign" />

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "select_user.jsp"%>' />
</liferay-portlet:renderURL>
<aui:form action="<%= searchURL %>" method="get" name="fm">
	<aui:input name="esfArticleId" type="hidden" value="<%= esfArticleId %>" />

	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input inlineField="<%=true%>" label="" name="lastname" placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstname" placeholder="first-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="card" placeholder="card" size="30" title="search-entries" type="text" /> 
			<aui:input name="isAss" type="hidden" value="<%=isAss%>" inlineField="<%=true%>" />
			<aui:input name="typestate" type="hidden" value="<%= 1 %>" inlineField="<%=true%>"/> 
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%= iteratorURL %>" orderByType="<%=orderByType%>">

	<liferay-ui:search-container-results>
		<%
		List<ESFUser> esfusersSE = new ArrayList<ESFUser>();
		List<ESFUser> esfusers = new ArrayList<ESFUser>();
		int esfusersTot = 0 ;
		
		esfusersSE = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
				firstname, lastname, cardCode, currentOrganizationId, searchContainer.getStart(),
					searchContainer.getEnd());
			
		esfusers = ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S(
				firstname, lastname, cardCode,currentOrganizationId);
		pageContext.setAttribute("total", esfusers !=null ? esfusers.size() : 0);
		
		List<ESFUser> esfusersSESortable = new ArrayList<ESFUser>(esfusersSE);
		
		if (Validator.isNotNull(orderByCol)) {
			BeanComparator beanComparator = new BeanComparator(
					orderByCol);
			
		Collections.sort(esfusersSESortable,
				beanComparator);
		
			if (sortingOrder.equalsIgnoreCase("desc")) {
	
				Collections
						.reverse(esfusersSESortable);
			}
		} 
			
			pageContext.setAttribute("results", esfusersSESortable);
			
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName" orderable="true" orderableProperty="lastName" name="last-name" />

		<liferay-ui:search-container-column-text property="firstName" name="first-name" />

		<liferay-ui:search-container-column-text value="<%=esfUser.getFiscalCode()%>" name="fiscalCode" />

		<liferay-ui:search-container-column-text name="user-email">
		
			<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
		</liferay-ui:search-container-column-text>
		<%
		
			ESFCard userCard= null;
			String userCardCode ="";
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			
			try{
				cardstest = ESFCardLocalServiceUtil.findActualUserCards(esfUser.getEsfUserId());
				
				if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
					userCardCode = cardstest.get(0).getCode();
				}
				
			}
			catch(Exception e){
				
			}
		%>

		<liferay-ui:search-container-column-text value="<%=userCardCode %>" name="card" />

		<%
			String orgName = "";
			
			if(Validator.isNotNull(cardstest) && 0 < cardstest.size() && 
					Validator.isNotNull(cardstest.get(0)) && Validator.isNotNull( ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardstest.get(0).getEsfOrganizationId())) &&
						Validator.isNotNull( ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardstest.get(0).getEsfOrganizationId()).getCode())){
				orgName =  ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardstest.get(0).getEsfOrganizationId()).getCode();
			}
		%>

		<liferay-ui:search-container-column-text value="<%= orgName %>" name="orgName" />

		<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday" value="<%=sdf.format(esfUser.getBirthday())%>" />

		<liferay-ui:search-container-column-jsp path='<%=templatePath + "user_actions.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>