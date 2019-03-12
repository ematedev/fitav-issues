<%@page import="it.ethica.esf.util.ESFRenewalConstants"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sun.corba.se.spi.orb.StringPair"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ include file="init.jsp" %>
<%
String renewalDate= ParamUtil.getString(request, "renewalDate");
String amount = ParamUtil.getString(request, "amount");
//long groupid = themeDisplay.getLayout().getGroupId(); //10181;
//System.out.println(groupid);
JournalArticle ja = 
JournalArticleLocalServiceUtil.getArticleByUrlTitle(globalId, 
		ESFRenewalConstants.WEB_CONTENT_BANK);
String artcleid = StringPool.BLANK;
if (Validator.isNotNull(ja)){
	artcleid = ja.getArticleId();
}


%>

<portlet:renderURL var="paymentURL">
			<portlet:param name="mvcPath" value='<%= templatePath + "payment_page.jsp" %>' />
			<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
			<portlet:param name="amount" value='<%=amount %>'/>
</portlet:renderURL>
<%
if(artcleid != null){
%>

<div>
<liferay-ui:journal-article articleId="<%=artcleid%>" groupId="<%=globalId%>"/>
</div>
<%
}
%> 

<aui:button-row>
<aui:button value="back" onClick="<%=paymentURL %>"></aui:button>
</aui:button-row>
