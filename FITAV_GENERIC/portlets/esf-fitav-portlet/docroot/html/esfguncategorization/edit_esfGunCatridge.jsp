<%@page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFCatridgeImpl"%>
<%@page import="it.ethica.esf.model.ESFCatridge"%>
<%@ include file="init.jsp" %>

<%
long esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
long esfCatridgeId = ParamUtil.getLong(renderRequest, "esfCatridgeId");
ESFCatridge catridge = new ESFCatridgeImpl();

if(0 < esfCatridgeId){
	catridge = ESFCatridgeLocalServiceUtil.fetchESFCatridge(esfCatridgeId);
	
}
String name = "";
long caliber = 0;
String description = "";

if(Validator.isNotNull(catridge)){
	name = catridge.getCatridgeModel();
	caliber = catridge.getCatridgeCaliber() ;
	description = catridge.getNote();
}

%>

<portlet:renderURL var="viewURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfguncategorization/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunCatridge" var="editESFGunCatridgeURL">
	<portlet:param name="esfCatridgeId" value="<%= String.valueOf(esfCatridgeId) %>" />
</portlet:actionURL>

<aui:form action="<%= editESFGunCatridgeURL %>" name="<portlet:namespace />fm">


<% if(0 == esfGunTypeId){%>
			<aui:select name="esfGunTypeSelect" label="esf-gunType-select" >
			<aui:option label="-" value="0" />
			<%
			List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);
			for (ESFGunType esfGunType : esfGunTypes) {
			
			%>

			<aui:option value="<%=esfGunType.getEsfGunTypeId()%>" 
				><%=esfGunType.getName()%></aui:option>
			<%
				}
			%>
		</aui:select>
<%}else{
	String typeName = "";
	if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunTypeId))){
		typeName = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunTypeId).getName();
	}
	%>
		<aui:input name="esfGunTypeSelect" value="<%= esfGunTypeId%>" type="hidden"  >
		</aui:input>
		<aui:input name="esfGunTypeName"  value="<%= typeName%>" type="text" readonly="true">
		</aui:input>
<%} %>
			
			<aui:input name="name" value="<%=name %>">
				<aui:validator name="required"/>
			</aui:input>
			
			<aui:input name="caliber" type="text" value="<%=caliber %>">
				<aui:validator name="digits"></aui:validator>
				<aui:validator name="min">0</aui:validator>
			</aui:input>
			
			<aui:input name="description" type="textarea" value="<%=description %>"/>
			
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>" value="back"></aui:button>
		</aui:button-row>
</aui:form>