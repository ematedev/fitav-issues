<%@page import="it.ethica.esf.permission.ESFModelPermission"%>
<%@ include file="init.jsp" %>

<%
String tabs = ParamUtil.getString(request, "tabs1", "Fucili");
portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("mvcPath", "/html/esfgun/view.jsp");
portletURL.setParameter("tabs", tabs);

String tabNames = "Fucili,Canne,Cartucce";

List<ESFGunKind> esfGunKinds = ESFGunKindLocalServiceUtil.getESFGunKinds();
List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();
String tipo="";
boolean show = false;
%>

<liferay-ui:error key="gun-assigned" message="gun-assigned"/>

		<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value='<%= templatePath + "view_search.jsp" %>' />
		</liferay-portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			
			<div class="search-form">
				<span class="aui-search-bar">
				
					
					<aui:select inlineField="<%= true %>" name="esfGunTypeId">
						<aui:option label="-"
								value="0" />
					<%for(ESFGunType esfGunType : esfGunTypes){ %>	
						
							<aui:option label="<%= esfGunType.getName()%>"
								value="<%= esfGunType.getEsfGunTypeId()%>" />	
					<%} %>		
								
					</aui:select>
<%if(show){ %>	
					<aui:select inlineField="<%= true %>" name="esfGunKindId">
						<aui:option label="-"
								value="0" />
						<%
						for (ESFGunKind esfGunKind : esfGunKinds) {
						%>
							
							<aui:option label="<%= esfGunKind.getName()%>"
								value="<%= esfGunKind.getEsfGunKindId()%>" />
						<%
					
						}
						%>	
					</aui:select>
<% }%>				
					<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>

		<aui:button-row cssClass="esfgun-admin-buttons">

			
			  	<portlet:renderURL var="gun_catogorizationURL">
					<portlet:param name="mvcPath"
					value='<%=templatePath+"esfguncategorization/view.jsp" %>' />
					<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>

				<aui:button onClick="<%= gun_catogorizationURL.toString() %>" value="GUN-CATEGORIZATION" />

				<portlet:renderURL var="addESFRifleURL">
					<portlet:param name="mvcPath"
					value='<%= templatePath+"edit_esfRifle.jsp" %>' />
					<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>

				<aui:button onClick="<%= addESFRifleURL.toString() %>" value="ADD-RIFLES" />

				<portlet:renderURL var="addESFCaneURL">
						<portlet:param name="mvcPath"
							value='<%= templatePath+"edit_esfCane.jsp" %>' />
						<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>
		
				<aui:button onClick="<%= addESFCaneURL.toString() %>" value="ADD-CANES" />
				
				<portlet:renderURL var="addESFCatridgeURL">
						<portlet:param name="mvcPath"
							value='<%= templatePath+"edit_esfCatridge.jsp" %>' />
						<portlet:param name="modifyMode" value="false"/>
			</portlet:renderURL>

					<aui:button onClick="<%= addESFCatridgeURL.toString() %>" value="ADD-CATRIDGES" />

		</aui:button-row>

<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" >
	<c:if test='<%=tabs.equals("Fucili")%>'>
		<%@ include file="/html/esfgun/tabs/Fucili.jsp"%> 
	</c:if>
	
	<c:if test='<%=tabs.equals("Canne")%>'>
		<%@ include file="/html/esfgun/tabs/Canne.jsp"%>
	</c:if>
	
	<c:if test='<%=tabs.equals("Cartucce")%>'>
		<%@ include file="/html/esfgun/tabs/Cartucce.jsp"%>
	</c:if>
</liferay-ui:tabs>


