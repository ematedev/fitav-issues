<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="init.jsp" %>
<%
String renewalDate= ParamUtil.getString(request, "renewalDate");
String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);
String amount = ParamUtil.getString(request, "amount");
%>

<portlet:renderURL var="paymentURL">
	<portlet:param name="mvcPath" value='<%= templatePath+ "payment_page.jsp" %>'/>
	 <portlet:param name="renewalDate" value='<%=renewalDate %>'/>
	 <portlet:param name="amount" value='<%=amount %>'/>
</portlet:renderURL>

<aui:form action='<%= paymentURL %>' name="fm">

		<strong><u>Dichiarazione di veridicità dei dati </u></strong>.<br />
				
			<p> Il sottoscritto, consapevole della responsabilità e
			 delle pene stabilite dalla legge per attestazioni 
			false, o dichiarazioni mendaci,  <br>
			che costituiscono reato punito ai sensi del Codice Penale e
			 delle leggi speciali in materia,  <br>
			sotto la propria 
			responsabilità DICHIARA che   <br>
			i dati riportati nella 
			documentazione allegata corrispondono a verità.
			</p>


	
		<aui:button-row>
			<aui:button type="submit" value="i-agree" />

			<%
			String taglibOnClick = "alert('" + UnicodeLanguageUtil.get(pageContext, "you-must-agree-with-the-terms-of-use-to-continue") + "');";
			%>

			<aui:button onClick="<%= taglibOnClick %>" type="cancel" value="i-disagree" />
		</aui:button-row>

</aui:form>