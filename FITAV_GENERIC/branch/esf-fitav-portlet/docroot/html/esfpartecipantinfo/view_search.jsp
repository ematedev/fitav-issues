<%@page import="it.ethica.esf.model.ESFPartecipantInfo"%>
<%@page import="com.lowagie.text.pdf.PRTokeniser"%>
<%@page import="it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil"%>
<%@page import="java.util.Hashtable"%>
<%@include file="init.jsp"%>

<%
	String firstName = ParamUtil.getString(request, "firstName");
	String lastName = ParamUtil.getString(request, "lastName");
	long protocolNumber = ParamUtil.getLong(request, "protocolNumber");

	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter(
		"mvcPath", "/html/esfpartecipantinfo/view_search.jsp");
	viewassURL.setParameter("firstName", firstName);
	viewassURL.setParameter("lastName", lastName);
	viewassURL.setParameter("protocolNumber", String.valueOf(protocolNumber));
%>

<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input inlineField="<%=true%>" label="" name="lastName"
				placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstName"
				placeholder="first-name" size="30" title="search-entries" type="text" /> 
			<aui:input inlineField="<%=true%>" label=""
				name="protocolNumber" placeholder="protocol-number" size="30" title="search-entries" type="text" /> 
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result"
	iteratorURL="<%=viewassURL%>">
	<liferay-ui:search-container-results>
		<%
		List<ESFPartecipantInfo> esfPartecipantsInfosSE = 
							ESFPartecipantInfoLocalServiceUtil.
										getESFPartecipantInfosByFirstName_L_P(
											firstName, lastName, protocolNumber,
											searchContainer.getStart(), 
											searchContainer.getEnd());
		
		List<ESFPartecipantInfo> esfPartecipantsInfos = 
						ESFPartecipantInfoLocalServiceUtil.
									getESFPartecipantInfosByFirstName_L_P(
										firstName, lastName, protocolNumber);
			
			pageContext.setAttribute("results", esfPartecipantsInfosSE);
			pageContext.setAttribute("total", esfPartecipantsInfos !=null ? 
											esfPartecipantsInfos.size() : 0);
		%>
		
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFPartecipantInfo" modelVar="esfPartecipantInfo">

		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />

		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />

		<liferay-ui:search-container-column-text value="<%=String.valueOf(esfPartecipantInfo.getProtocol())%>"
			name="protocol-number" />
		
		<liferay-ui:search-container-column-text value="<%=esfPartecipantInfo.getFiscalCode()%>"
			name="fiscal-code" />
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfPartecipantInfo.getDateOfBirth())%>" />
			
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfPartecipantInfo_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
