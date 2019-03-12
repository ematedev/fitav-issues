<%@page import="java.util.HashMap"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import = "com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import = "com.liferay.portal.theme.ThemeDisplay" %>
<%@include file="init.jsp"%>

<%

String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());

String code = ParamUtil.getString(request, "code");
String name = ParamUtil.getString(request, "name");

PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/esfpartecipantinfo/popup/view.jsp");

String firstName = ParamUtil.getString(request, "firstName");
String lastName = ParamUtil.getString(request, "lastName");
String cardCode = ParamUtil.getString(request, "cardCode");

viewassURL.setParameter("firstName", String.valueOf(firstName));
viewassURL.setParameter("lastName", String.valueOf(lastName));
viewassURL.setParameter("cardCode", String.valueOf(cardCode));

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter(
	"mvcPath", templatePath+"popup/view.jsp");

%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath+"popup/view.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="search-form">
				<span class="aui-search-bar"> 
									
					<aui:input inlineField="<%=true%>" label="last-name" name="lastName"
						placeholder="last-name" size="" title="search-entries" />
						
					<aui:input inlineField="<%=true%>" label="first-name" name="firstName"
						placeholder="first-name" size="" title="search-entries" />
						
					<aui:input inlineField="<%=true%>" label="protocol-number" name="protocolNumber"
						placeholder="protocol-number" size="" title="search-entries" />	
					<aui:button type="submit" value="search" />
				</span>
			</div>
</aui:form>
<%
	List<ESFEntityState> ees = ESFEntityStateLocalServiceUtil
							.findESFEntityStateByC_S("it.ethica.esf.model.ESFCard", 1);
	HashMap<Long,String> cardForUser= new HashMap<Long,String>();
	List<ESFCard> totCard = ESFCardLocalServiceUtil.findAllESFCardsByState(ESFKeys.ESFStateType.ENABLE);
			
	for (ESFEntityState e:ees){
		
		if(totCard.contains(e.getClassPK()) && Validator.isNotNull(e) && Validator.isNotNull(e.getClassPK()) && Validator.isNotNull(ESFCardLocalServiceUtil.getESFCard(e.getClassPK()))){
			
			ESFCard ec = ESFCardLocalServiceUtil.getESFCard(e.getClassPK());
			cardForUser.put(ec.getEsfUserId(),ec.getCode());
		}
	}
%>
<liferay-ui:search-container delta="20" emptyResultsMessage="no-results" iteratorURL="<%= viewassURL%>">

	<liferay-ui:search-container-results>
	
	<% 
	 List<ESFUser> esfUsers = 
		ESFUserLocalServiceUtil.
		getAllUserByLikeF_C_S(firstName, lastName, 
				cardCode, ESFKeys.ESFStateType.ENABLE,
				currentOrganizationId, searchContainer.getStart(),
				searchContainer.getEnd());

	List<ESFUser> esfUsersT = ESFUserLocalServiceUtil.
						getAllUserByLikeF_C_S(firstName, lastName, 
								cardCode, ESFKeys.ESFStateType.ENABLE,
								currentOrganizationId);
	
    pageContext.setAttribute("results", esfUsers);

    pageContext.setAttribute("total", esfUsersT.size());
	System.out.println("La lunghezza di esfUsers è: "+ esfUsers.size());
	System.out.println("La lunghezza di esfUsersT è: "+esfUsersT.size());
    %>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text name="lastName" value="<%=esfUser.getLastName()%>"/>

		<liferay-ui:search-container-column-text name="firstName" value="<%=esfUser.getFirstName()%>"/>
		
		<liferay-ui:search-container-column-text name="email" value="<%=esfUser.getUserEmail()%>"/>
		
		<% 
			String esfCardCode = "";
			try
			{
				esfCardCode = cardForUser.get(esfUser.getEsfUserId());
			}
			catch(Exception e)
			{
				
			}
		/*	List<ESFCard> esfCards = 
								ESFCardLocalServiceUtil.findAllESFCardsByU_S(
											esfUser.getEsfUserId(), 
											ESFKeys.ESFStateType.ENABLE);
			if(Validator.isNotNull(esfCards) && esfCards.size() > 0){
				esfCardCode = esfCards.get(0).getCode();
			}*/
		%>
		<liferay-ui:search-container-column-text name="code" value="<%=esfCardCode%>"/>
		

		<liferay-ui:search-container-column-jsp 
			path='<%=templatePath + "popup/choose_user.jsp"%>' 
			align="right" />
			
			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

