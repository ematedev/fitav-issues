<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFCatridgeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp" %>

<%
String tabs = ParamUtil.getString(request, "tabs1", "Fucili");
portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("mvcPath", "/html/esfgunuser/view.jsp");
portletURL.setParameter("tabs", tabs);

String tabNames = "Fucili,Canne,Cartucce";



User currentUser = PortalUtil.getUser(request);
long userId = currentUser.getUserId();
List<ESFGunKind> esfGunKinds = ESFGunKindLocalServiceUtil.getESFGunKinds();
String tipo="";
List<ESFGun> esfGuns = new ArrayList<ESFGun>();



%>
<liferay-ui:error key="duplicate_code" message="duplicate_code"/>
<liferay-ui:error key="esfGunKindId-reference-error" message="esfGunKindId-reference-error"/>


<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUN) %>">

		<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value="/html/esfgunuser/view_search.jsp" />
		</liferay-portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="search-form">
				<span class="aui-search-bar">
					<aui:input inlineField="<%= true %>" name="firstName" placeholder="firstName"
							size="30" title="search-entries" type="text" />
					<aui:input inlineField="<%= true %>"  name="lastName" placeholder="lastName"
							size="30" title="search-entries" type="text" />
					<aui:select inlineField="<%= true %>" name="esfGunKindId">
					<aui:option label="-" value="0" />
						<%
						for (ESFGunKind esfGunKind : esfGunKinds) {
						%>
							
							<aui:option label="<%= esfGunKind.getName()%>"
								value="<%= esfGunKind.getEsfGunKindId()%>" />
						<%
					
						}
						%>	
					</aui:select>
					
					<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>
<%if(currentOrganizationId !=0){  %>
		<aui:button-row cssClass="esfgun-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUN) %>'>
				<portlet:renderURL var="addESFRifleURL">
						<portlet:param name="mvcPath"
						value='<%= templatePath+"edit_esfRifle.jsp" %>' />
						<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>
				
				<aui:button onClick="<%= addESFRifleURL.toString() %>" value="ASSIGN-RIFLES" />
				
				<portlet:renderURL var="addESFCaneURL">
				<portlet:param name="mvcPath"
							value='<%= templatePath+"edit_esfCane.jsp" %>' />
						<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>
		
				<aui:button onClick="<%= addESFCaneURL.toString() %>" value="ASSIGN-CANES" />
				
				<portlet:renderURL var="addESFCatridgeURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath+"edit_esfCatridge.jsp" %>' />
					<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>

					<aui:button onClick="<%= addESFCatridgeURL.toString() %>" value="ASSIGN-CATRIDGES" />
			</c:if>
		</aui:button-row>
<%} %>


<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" >
	<c:if test='<%=tabs.equals("Fucili")%>'>
		<%@ include file="/html/esfgunuser/tabs/Fucili.jsp"%> 
	</c:if>
	
	<c:if test='<%=tabs.equals("Canne")%>'>
		<%@ include file="/html/esfgunuser/tabs/Canne.jsp"%>
	</c:if>
	
	<c:if test='<%=tabs.equals("Cartucce")%>'>
		<%@ include file="/html/esfgunuser/tabs/Cartucce.jsp"%>
	</c:if>
</liferay-ui:tabs>


	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>