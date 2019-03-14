<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>

<h3>Creazione Nuovi Direttori di Tiro</h3>

<%

String firstname = ParamUtil.getString(request, "firstname");
String lastname = ParamUtil.getString(request, "lastname");
String cardCode = ParamUtil.getString(request, "card");

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/esfshootingdirector/newShootingDirector.jsp");
viewassURL.setParameter("firstname", firstname);
viewassURL.setParameter("lastname", lastname);
viewassURL.setParameter("cardCode", cardCode);
	
String orderByCol = ParamUtil.getString(request, "orderByCol","lastName");
String orderByType = ParamUtil
	.getString(request, "orderByType","asc");
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

<aui:button-row cssClass="esfshooter-admin-buttons">
	<aui:button onClick="<%= viewURL.toString() %>" value="cancel" />
</aui:button-row>

<liferay-portlet:renderURL varImpl="searchNewShDrURL">
	<portlet:param name="mvcPath" value='<%= "/html/esfshootingdirector/newShootingDirector.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchNewShDrURL%>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchNewShDrURL" />

		<div class="search-form">
		
			<span class="aui-search-bar"> 
			
			<aui:input inlineField="<%=true%>" label="" name="lastname"
					placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstname"
					placeholder="first-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="card" 
				placeholder="card" size="30" title="search-entries" type="text" /> 
			
			<aui:button type="submit" value="search" />
			
			</span>
			
		</div>
	
</aui:form>


<liferay-ui:search-container emptyResultsMessage="no-result" iteratorURL="<%=viewassURL%>" orderByType="<%=orderByType%>">

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

		<liferay-ui:search-container-column-text value="<%=orgName%>" name="orgName" />

		<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "addNewShDtaction.jsp"%>' align="right" />
				
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

