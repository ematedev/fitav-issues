<%@page import="com.liferay.portal.kernel.util.Validator"%>

<% 

	String esfUserIdsString = ParamUtil.getString(request, "esfUserIds");
	portletURL.setParameter("tabs1", "Non Assegnati");
	String esfUserIdsWithoutBrackets = "";
	
	for(int i = 0; i < esfUserIdsString.length(); i ++){
		char charIndex = esfUserIdsString.charAt(i);
		if(charIndex != '[' && charIndex != ']' && charIndex != ' '){
			esfUserIdsWithoutBrackets += charIndex;
		}
	}
	
	esfUserIdsWithoutBrackets += ','; 
	
	List<Long> userIds = new ArrayList<Long>();
	
	int firstIndex = 0;
	for(int j = 0; j < esfUserIdsWithoutBrackets.length(); j++){
		if(esfUserIdsWithoutBrackets.charAt(j) == ','){
			if(!esfUserIdsWithoutBrackets.substring(firstIndex, j).equals("")){
				userIds.add(Long.valueOf(esfUserIdsWithoutBrackets.substring(firstIndex, j)));
				if(Validator.isNotNull(firstIndex) && Validator.isNotNull(j)){
					firstIndex = j + 1;
				}
			}	
		}
	}
	
	portletURL.setParameter("esfUserIds", String.valueOf(esfUserIdsString));
	String lastname = ParamUtil.getString(request, "lastname");
	String firstname = ParamUtil.getString(request, "firstname");
%>

<liferay-ui:error key="BDO-Change-reference-error" message="BDO-Change-reference-error"/>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view.jsp"%>'></portlet:param>
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath +"assignMembers_esfUserRole.jsp"%>' />
	<portlet:param name="tabs1" value='<%= "Non Assegnati"%>' />
</liferay-portlet:renderURL>


<portlet:actionURL name="updateAddESFUserESFRole"
	var="updateAddESFUserESFRoleVar" />

<aui:form action="<%=searchURL%>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<span class="aui-search-bar">
			<aui:input inlineField="<%=true%>" label="" name="lastname"
				placeholder="last-name" size="30" title="search-entries" type="text" />
			<aui:input inlineField="<%=true%>" label="" name="firstname"
				placeholder="first-name" size="30" title="search-entries" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
	
</aui:form>

<aui:form action="<%=updateAddESFUserESFRoleVar%>"
	name="<portlet:namespace />fmn">

	<aui:button-row>
		<aui:button type="submit" value="Associa"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results"  iteratorURL="<%= portletURL %>">
		<liferay-ui:search-container-results>
			<%
			List<ESFUser> allEsfUser =
							ESFUserLocalServiceUtil.findNotBDOMemberByAssociatioId(lastname, firstname, 
								currentOrganizationId,
								searchContainer.getStart(),
								searchContainer.getEnd());

						int totalEsfUser =
							ESFUserLocalServiceUtil.countNotBDOMemberByAssociatioId(lastname, firstname,
								currentOrganizationId);

						pageContext.setAttribute("results", allEsfUser);
						pageContext.setAttribute("total", totalEsfUser);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">
			<%//finder con idorganization in pi�
			ESFUserESFUserRole esfUserESFUserRole = null;
						esfUserESFUserRole =
							ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByU_R_O(
								esfUser.getEsfUserId(), esfUserRoleId, esfOrganizationId);
						
			String fiscalCode ="";
			if(Validator.isNotNull(esfUser.getFiscalCode())){
				fiscalCode = esfUser.getFiscalCode();
			}
			
			if(esfUserESFUserRole == null){
			%>
			<portlet:renderURL var="changeFCURL">
					<portlet:param name="esfUserId"
						value="<%=String.valueOf(esfUser.getEsfUserId())%>" />
					<portlet:param name="lastname" value='<%=lastname%>' />
					<portlet:param name="firstname" value='<%=firstname%>' />
					<portlet:param name="backPage" value='<%= templatePath +"assignMembers_esfUserRole.jsp"%>' />
					<portlet:param name="tabs1" value='<%= "Non Assegnati"%>' />
					<portlet:param name="esfOrganizationId" value='<%= String.valueOf(esfOrganizationId)%>' />
					<portlet:param name="esfUserRoleId" value='<%= String.valueOf(esfUserRoleId)%>' />
					
					<portlet:param name="mvcPath" value='<%=templatePath +"changeFiscalcode.jsp"%>' />
			</portlet:renderURL>
			
			
				<liferay-ui:search-container-column-text>
				<%
					boolean disabled = true;
					if(!userIds.contains(esfUser.getEsfUserId())){
						disabled = false;
					}
					String fiscalCodeName = "fiscalCode"+esfUser.getEsfUserId();
				%>
					<aui:input name="choose" label="" type="checkbox"
						id='<%="choose_" + esfUser.getEsfUserId()%>' disabled = "<%=disabled%>">
					</aui:input>
	
					<aui:input type="hidden" name="esfUserIds"
						id='<%="esfUserIds_" + esfUser.getEsfUserId()%>'
						value='<%=esfUser.getEsfUserId()%>' />
				
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text property="lastName" name="last-name"/>
				
				<liferay-ui:search-container-column-text property="firstName" name="first-name"/>
				
				<liferay-ui:search-container-column-text property="userEmail" name="user-email"/>
				
				<liferay-ui:search-container-column-text  name="fiscalCode" >
					<div class="btn-field-align">
						<aui:input name="<%fiscalCodeName%>" value="<%= fiscalCode%>" label="" readonly="true" inlineField="true"></aui:input>
						
						<aui:button onClick="<%= changeFCURL.toString() %>" value="please-enter-correct-fiscalcode" />
					</div>
				</liferay-ui:search-container-column-text>
			<% 
			}
			%>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:input type="hidden" name="type"
		value='NA' />
	<aui:input type="hidden" name="esfUserRoleId"
		value='<%= esfUserRoleId%>' />
	<aui:input type="hidden" name="esfOrganizationId"
		value='<%= esfOrganizationId%>' />
</aui:form>