<%@ include file="init.jsp" %>

<%
String pageName =themeDisplay.getLayout().getName(themeDisplay.getLocale());

String firstname = ParamUtil.getString(request, "firstname");
String lastname = ParamUtil.getString(request, "lastname");
String cardCode = ParamUtil.getString(request, "card");
Integer typestate = ParamUtil.getInteger(request, "typestate");
PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath", "/html/esfarticlemanager/popup/view_search.jsp");
viewassURL.setParameter("firstname", firstname);
viewassURL.setParameter("lastname", lastname);
viewassURL.setParameter("cardCode", cardCode);
viewassURL.setParameter("typestate", String.valueOf(typestate));

List<ESFCard> cards =
	ESFCardLocalServiceUtil.findAllESFCardsByState(typestate);
Hashtable<Long, ESFCard> allEsfCards =
	new Hashtable<Long, ESFCard>();
for (ESFCard card : cards) {
	allEsfCards.put(card.getEsfUserId(), card);
}

System.out.println ("typestate :"+typestate);
System.out.println ("cardCode :"+cardCode);
System.out.println ("curr org id :"+currentOrganizationId);
%>

<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />

<aui:form action="<%= searchUserURL.toString() %>" 
method="get" name="fm">
<liferay-portlet:renderURLParams varImpl="searchUserURL" />
	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%= true %>" label="" name="lastname"
				placeholder="last-name" size="30" 
				title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries"
				type="text" /> <aui:input inlineField="<%= true %>" label=""
				name="card" placeholder="card" size="30" 
				title="search-entries"
				type="text" /> <aui:input name="typestate" type="hidden"
				value="1" /> <aui:button
				type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result"
	iteratorURL="<%= viewassURL %>">

	<liferay-ui:search-container-results>

		<%
		List <ESFUser> esfusersSE =
		ESFUserLocalServiceUtil.getAllUserByLikeF_C_S(
			firstname, lastname, cardCode, typestate,
			currentOrganizationId, searchContainer.getStart(),
				 searchContainer.getEnd());

		List<ESFUser> esfusers =
		ESFUserLocalServiceUtil.getAllUserByLikeF_C_S(
			firstname, lastname, cardCode, typestate,
			currentOrganizationId);

			pageContext.setAttribute(
					"results",
					esfusersSE);
			pageContext.setAttribute(
					"total", 
					esfusers !=null ? esfusers.size() : 0);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />

		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />

		<%
			String userCard =
						allEsfCards.get(esfUser.getEsfUserId()).getCode();
		%>

		<liferay-ui:search-container-column-text value="<%= userCard %>"
			name="card" />
		<liferay-ui:search-container-column-jsp
			path='<%= templatePath + "popup/choose_user.jsp" %>'
			align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>