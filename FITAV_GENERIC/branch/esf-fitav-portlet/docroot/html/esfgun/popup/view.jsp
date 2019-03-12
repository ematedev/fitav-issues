<%@page import="java.util.Hashtable"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>
<% String pageName =themeDisplay.getLayout().getName(themeDisplay.getLocale());
String lastName = ParamUtil.getString(request, "lastName");
String name = ParamUtil.getString(request, "name");

lastName=lastName.toUpperCase();
name= name.toUpperCase();

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", templatePath+"popup/view.jsp");
viewassURL.setParameter("lastName", lastName);
viewassURL.setParameter("name", name);


String orderByCol = ParamUtil.getString(request, "orderByCol");
String orderByType = ParamUtil
		.getString(request, "orderByType");
String sortingOrder = orderByType;

if (orderByType.equals("desc")) {
	orderByType = "asc";
} else {
	orderByType = "desc";
}

if (Validator.isNull(orderByType)) {
	orderByType = "desc";
}
List<ESFCard> cards =
ESFCardLocalServiceUtil.findAllESFCardsByState( ESFKeys.ESFStateType.ENABLE);
Hashtable<Long, ESFCard> allEsfCards =
new Hashtable<Long, ESFCard>();
for (ESFCard card : cards) {
allEsfCards.put(card.getEsfUserId(), card);
}
%>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath+"popup/view.jsp"%>' />
</liferay-portlet:renderURL>
<aui:form action="<%=searchURL.toString()%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
		<aui:input inlineField="<%=true%>" name="lastName"
			placeholder="lastName" size="30" title="search-entries" type="text" />
		<aui:input inlineField="<%=true%>" name="name"
			placeholder="name" size="30" title="search-entries" type="text" />  
		<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result"
	iteratorURL="<%=viewassURL%>" orderByType="<%=orderByType%>">
	<liferay-ui:search-container-results>
		<%
		List<ESFUser> esfusersSE =
		ESFUserLocalServiceUtil.getAllUserByLikeF_C_S(
			name, lastName, "", ESFKeys.ESFStateType.ENABLE,
				currentOrganizationId, searchContainer.getStart(),
				searchContainer.getEnd());
		
		List<ESFUser> esfusers =
		ESFUserLocalServiceUtil.getAllUserByLikeF_C_S(
			name, lastName, "", ESFKeys.ESFStateType.ENABLE,
			currentOrganizationId);
		
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
			pageContext.setAttribute("total", esfusers !=null ? esfusers.size() : 0);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName" orderable="true" orderableProperty="lastName"
			name="last-name" />

		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />

		<liferay-ui:search-container-column-text
			value="<%=esfUser.getFiscalCode()%>" name="fiscalCode" />

		<liferay-ui:search-container-column-text name="user-email">
		
		<a href="mailto:<%=esfUser.getUserEmail()%>" target="_top"><p><%=esfUser.getUserEmail()%></p></a>
		
		</liferay-ui:search-container-column-text>
		<%
			String userCard =
						allEsfCards.get(esfUser.getEsfUserId()).getCode();
		%>

		<liferay-ui:search-container-column-text value="<%=userCard%>"
			name="card" />

		<%
			String orgName =
						ESFOrganizationLocalServiceUtil.fetchESFOrganization(
							allEsfCards.get(esfUser.getEsfUserId()).getEsfOrganizationId()).getName();
		%>
		
		<liferay-ui:search-container-column-text value="<%=orgName%>" 
			name="orgName" />
			
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "popup/choose_user.jsp"%>'
			align="right" /> 

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


