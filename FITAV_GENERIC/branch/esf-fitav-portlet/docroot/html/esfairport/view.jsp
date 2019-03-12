<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="init.jsp" %>
<style>
	#id {
	display:none;
	}
</style>
<liferay-ui:error key="esfairport-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFAirport.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfairport-admin-buttons">
			<c:if test='<%= true %>'>
				<portlet:renderURL var="addESFAirportURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + "edit_esfAirport.jsp"%>' />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFAirportURL.toString() %>"
					value="add-esfairport" />
			</c:if>
		</aui:button-row>
		<portlet:renderURL var="editURL">
	
		</portlet:renderURL>
		<liferay-ui:search-container emptyResultsMessage="no-results">

			<liferay-ui:search-container-results results="<%=ListUtil.subList(ESFAirportLocalServiceUtil.getAllESFAirport(),
																	searchContainer.getStart(), searchContainer.getEnd())%>"
												 total="<%= ESFAirportLocalServiceUtil.getAllESFAirport().size() %>" />

			<liferay-ui:search-container-row className="it.ethica.esf.model.ESFAirport" modelVar="esfAirport1">
					<aui:input type="hidden" name="id"  value="<%=String.valueOf(esfAirport1.getEsfAirportId()) %>"/>
					<liferay-ui:search-container-column-text name="name" value="<%=esfAirport1.getName() %>"/>
					<liferay-ui:search-container-column-text name="city" value="<%=esfAirport1.getCity() %>" />
					<liferay-ui:search-container-column-text name="country" value="<%=esfAirport1.getCountry() %>" />
					 <liferay-ui:search-container-column-jsp name="delete"
							path='<%= templatePath + "esfAirport_action.jsp"%>'
				 			align="right" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>


