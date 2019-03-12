<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../init.jsp" %>

<%
	ESFGunType esfGunType = null;

	long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
	boolean isChange = false;
	boolean checked = false;
	
	if (esfGunTypeId > 0) {
		esfGunType = ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);
		isChange = true;
	}
	if(isChange){
%>
		<h4><liferay-ui:message key="GunProducerUpdates" /></h4>
<%	}else{ %>
		<h4><liferay-ui:message key="GunProducerAdd" /></h4>
<%	} %>

<portlet:resourceURL var="locationURL" id="view.jsp" escapeXml="false" />

<portlet:renderURL var="viewCategorizationURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunType" var="editESFGunTypeURL" >
	<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/view.jsp" />
</portlet:actionURL>

<aui:form action="<%= editESFGunTypeURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfGunType %>" model="<%= ESFGunType.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfGunTypeId"
				value='<%= esfGunType == null ? "" : esfGunType.getEsfGunTypeId() %>' />
			<aui:input name="name" />
			<aui:input name="description" type="textarea" />
			<%if(isChange){
				checked = esfGunType.getIsCatridgeProductor();
				
			}%>
			
			<aui:input name="isCatridgeProductor" type="checkbox" checked="<%=checked%>"/>
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewCategorizationURL %>" value="back"></aui:button>
		</aui:button-row>
</aui:form>
