<%@include file="init.jsp"%>

<liferay-ui:success key="user-success-insertupdate"
	message="user-success-insertupdate-mess" />
<liferay-ui:success key="shooter-success-insert"
	message="shooter-success-insert" />
<liferay-ui:success key="shooter-success-update"
	message="shooter-success-update" />
<%
	String esfFornitureId = ParamUtil.getString(renderRequest,"esfFornitureId");
	
%>


<h3>Scegli l'utente, inserisci parametri ricerca: </h3>
<aui:form action="<%=searchURL%>" method="get" name="fm"> 
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%=true%>" label=""
				name="lastname" placeholder="last-name" size="30"
				title="search-entries" type="text" />  
			<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries"
				type="text" /> 
			<aui:input inlineField="<%=true%>" label="" name="card" 
				placeholder="card" size="30" title="search-entries" type="text" /> 
			<aui:input name="typestate" type="hidden" 
				value="<%=ESFKeys.ESFStateType.ENABLE%>" /> 
			<aui:input name="esfFornitureId" type="hidden" value="<%=esfFornitureId %>"/>
			<br/>
			<aui:button type="submit" value="search" />
			<aui:button id="enabled-button" onClick="<%= viewURL.toString() %>" value ="return"/>
		</span>
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result">

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

		<liferay-ui:search-container-column-text property="lastName"
			name="last-name" />
			
		<liferay-ui:search-container-column-text property="firstName"
			name="first-name" />
		
		<liferay-ui:search-container-column-text value="<%=esfUser.getFiscalCode()%>"
			name="fiscalCode" />
		
		<%
			ESFCard card =
				ESFCardLocalServiceUtil.findAllESFCardsByU_S(
					esfUser.getEsfUserId(), ESFKeys.ESFStateType.ENABLE).get(0);
		%>
		
			
		<liferay-ui:search-container-column-text value="<%=card.getCode()%>"
			name="card" />
		<%
			String orgName = ESFOrganizationLocalServiceUtil.
								fetchESFOrganization(
									card.getEsfOrganizationId()).getName();
		%>	
			
		<liferay-ui:search-container-column-text value="<%=orgName%>"
			name="orgName" />
		
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(esfUser.getBirthday())%>" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfAssign_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>