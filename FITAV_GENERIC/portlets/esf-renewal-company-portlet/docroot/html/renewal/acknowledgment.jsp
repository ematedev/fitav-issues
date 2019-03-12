<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="init.jsp" %>
<%
String renewalDate= ParamUtil.getString(request, "renewalDate");
String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);
String amount = ParamUtil.getString(request, "amount");
%>

<portlet:renderURL var="paymentURL">
	<portlet:param name="mvcPath" value='<%= templatePath+ "payment.jsp" %>'/>
	<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
	<portlet:param name="amount" value='<%=amount %>'/>
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:renderURL>

<aui:form action='<%= paymentURL %>' name="fm">
	<strong><u><liferay-ui:message key="acknowledgment-title" /></u></strong>.<br />
				
	<p><liferay-ui:message key="acknowledgment" /></p>

	<aui:button-row>
		<aui:button type="submit" value="accept" />

		<%
		String taglibOnClick = "alert('" + UnicodeLanguageUtil.get(pageContext, "you-must-agree-with-the-terms-of-use-to-continue") + "');";
		%>

		<aui:button onClick="<%= taglibOnClick %>" type="cancel" value="not-accept" />
	</aui:button-row>
</aui:form>