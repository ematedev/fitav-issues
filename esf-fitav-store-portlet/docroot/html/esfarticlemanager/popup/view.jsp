<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ include file="init.jsp" %>

<aui:form action="<%= searchUserURL.toString() %>" 
method="get" name="fm">
<liferay-portlet:renderURLParams varImpl="searchUserURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label=""
				name="lastname" placeholder="last-name" size="30"
				title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" 
			name="firstname"
				placeholder="first-name" size="30" title="search-entries"
				type="text" />
			<aui:input inlineField="<%= true %>" label="" name="card"
				placeholder="card" size="30" title="search-entries" 
				type="text" />
			<aui:input name="typestate" type="hidden"
				value="1" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>
<%String cardCode = StringPool.BLANK; %>
	<liferay-ui:search-container emptyResultsMessage="no-result">
	  <liferay-ui:search-container-results results="<%= 
	  ESFUserLocalServiceUtil.getAllEsfUserByState(1) %>"
			total="<%= 
				ESFUserLocalServiceUtil.getAllEsfUserByState(1).size() %>" />
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />

		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />

		<%
			ESFCard card = null;
			
			try {
			card =
				ESFCardLocalServiceUtil.getEsfCardByEsfUserId(esfUser.getEsfUserId());
			cardCode = card.getCode();
			}
			catch (Exception e){
				System.out.println ("user no have esfcard--"+e.toString());
			}
			System.out.println ("carddd :"+cardCode);
		%>

		<liferay-ui:search-container-column-text value="<%= cardCode  %>"
			name="card" />

		<liferay-ui:search-container-column-jsp
			path='<%= templatePath + "popup/choose_user.jsp" %>'
			align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>