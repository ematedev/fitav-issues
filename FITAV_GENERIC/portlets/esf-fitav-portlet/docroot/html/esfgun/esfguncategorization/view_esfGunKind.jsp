<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@ include file="../init.jsp" %>
 
<%
long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
boolean show = false;
boolean isCatridge = false;

ESFGunType gunType = new ESFGunTypeImpl();

gunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunTypeId);

isCatridge = gunType.getIsCatridgeProductor();

%>
<liferay-ui:error key="esfGunKind-reference-error" message='esfGunKind-reference-error' />
<liferay-portlet:renderURL varImpl="viewCategorizationURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "esfguncategorization/view.jsp"%>' />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchCategorizationURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "esfguncategorization/search_esfGunKind.jsp"%>' />
</liferay-portlet:renderURL>
<%if(show){ %>
<aui:form action="<%= searchCategorizationURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%= true %>" label="" name="name" placeholder="name"
					size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="description" placeholder="description"
					size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%= true %>" label="" name="model" placeholder="model"
					size="30" title="search-entries" type="text" />
			<aui:input  name="esfGunTypeId"  type="hidden" value="<%= esfGunTypeId%>"/>
			
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>
<%} 
		ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);
%>

		<h3><%= esfGunType.getName() %></h3>

		<aui:button-row cssClass="esfguncategorization-admin-buttons">
				<portlet:renderURL var="addESFGunKindURL">
				<%if(!isCatridge){ %>
					<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/edit_esfGunKind.jsp" />
				<%}else{ %>
					<portlet:param name="mvcPath" value="/html/esfgun/edit_esfCatridge.jsp" />
				<%} %>
					<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunKindURL.toString() %>"
					value="add-esfgunkind" />
					
				<aui:button onClick="<%= viewCategorizationURL.toString() %>" value="go-back"/>
				
		</aui:button-row>
<%if(!isCatridge){ %>
		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(
						esfGunTypeId,
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunKindLocalServiceUtil.getESFGunKindCountByESFGunType(esfGunTypeId) %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGunKind" modelVar="esfGunKind">

					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />

					<liferay-ui:search-container-column-jsp
							path="/html/esfgun/esfguncategorization/esfGunKind_actions.jsp" 
				 			align="right" cssClass="gun_actions_button"/>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
		
<%}else{ %>
	<liferay-ui:search-container emptyResultsMessage="no-results">
		<liferay-ui:search-container-results
				results="<%= ESFCatridgeLocalServiceUtil.getESFCatridgesByType(
						esfGunTypeId,searchContainer.getStart(),searchContainer.getEnd()) %>"
				total="<%= ESFCatridgeLocalServiceUtil.countESFCatridgesByType(esfGunTypeId) %>" />
		
		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFCatridge" modelVar="esfcatridge">
				
				<liferay-ui:search-container-column-text name="Marca"
					value="<%=ESFCatridgeLocalServiceUtil
									.getNameM(esfcatridge)%>" />

				<liferay-ui:search-container-column-text property="catridgeModel" />

				<liferay-ui:search-container-column-text property="catridgeCaliber" />

				<liferay-ui:search-container-column-text property="note" />
	
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="true" />
	</liferay-ui:search-container>

<%} %>
