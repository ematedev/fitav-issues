<%@ include file="init.jsp" %>
	<% 
		
	long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
	
	%>

		<liferay-ui:error key="esfGunKind-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFGunKind.class.getSimpleName()) %>' />
				
		<liferay-ui:error key="esfGunType-reference-error" 
				message='<%= LanguageUtil.format(pageContext, "the-selected-x-is-referenced-by-one-or-more-objects", ESFGunType.class.getSimpleName()) %>' />

		<aui:button-row cssClass="esfguncategorization-admin-buttons">

				<portlet:renderURL var="addESFGunTypeURL">
					<portlet:param name="mvcPath"
						value="/html/esfguncategorization/edit_esfGunType.jsp" />
				</portlet:renderURL>

				<aui:button onClick="<%= addESFGunTypeURL.toString() %>"
					value="add-esfgunyype" />
				<portlet:renderURL var="addESFGunKindURL">
					
					<portlet:param name="mvcPath"
						value="/html/esfguncategorization/edit_esfGunKind.jsp" />
					<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
					<portlet:param name="flagSearch" value="<%= String.valueOf(false) %>" />
					
				</portlet:renderURL>
				
					<aui:button onClick="<%= addESFGunKindURL.toString() %>"
					value="add-esfgunkind" />
		</aui:button-row>
		
		<liferay-ui:search-container emptyResultsMessage="no-results">
			<liferay-ui:search-container-results
				results="<%= ESFGunTypeLocalServiceUtil.getESFGunTypes(
						searchContainer.getStart(),
						searchContainer.getEnd()) %>"
				total="<%= ESFGunTypeLocalServiceUtil.getESFGunTypesCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGunType" modelVar="esfGunType">

					<liferay-ui:search-container-column-text property="name" />
					<liferay-ui:search-container-column-text property="description" />
					<%
						String isCatridgeProductor="";
						if(esfGunType.getIsCatridgeProductor()){
							isCatridgeProductor = "yes";
						}
						else{
							isCatridgeProductor="no";
						}
						%>
					<liferay-ui:search-container-column-text name="isCatridgeProductor"
							value="<%=res.getString(isCatridgeProductor)%>" />


					<liferay-ui:search-container-column-jsp
							path="/html/esfguncategorization/esfGunType_actions.jsp" 
				 			align="right" />

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
