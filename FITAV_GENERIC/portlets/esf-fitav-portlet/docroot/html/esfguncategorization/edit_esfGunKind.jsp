
<%@ include file="init.jsp" %>

<%
	ESFGunKind esfGunKind = null;
	boolean flag=ParamUtil.getBoolean(request,"flagSearch");
	long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
	long esfGunTypeId = 0;
	String measures = "";
	
	if (esfGunKindId > 0) {
		esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindId);
		esfGunTypeId = esfGunKind.getEsfGunTypeId();
	}
	else {
		esfGunTypeId = ParamUtil.getLong(renderRequest, "esfGunTypeId");
	} 
	
%>

<h3><liferay-ui:message key="add-esfgunkind" /></h3>
<portlet:resourceURL var="locationURL" id="view.jsp" escapeXml="false" />

<portlet:renderURL var="viewURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfguncategorization/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunKind" var="editESFGunKindURL">
	<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
	<portlet:param name="flagSearch" value="<%= String.valueOf(flag) %>" />
</portlet:actionURL>

<aui:form action="<%= editESFGunKindURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfGunKind %>" model="<%= ESFGunKind.class %>" />
		<c:if test='<%= !flag %>'>

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
		<aui:input name="esfGunTypeName"  value="<%= typeName%>" type="text">
		</aui:input>
<%} %>
		</c:if>
		

			<aui:input type="hidden" name="esfGunKindId"
				value='<%= esfGunKind == null ? "" : esfGunKind.getEsfGunKindId() %>' />
				
			<aui:input name="name" >
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="description" type="textarea" />


		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>" value="back"></aui:button>
		</aui:button-row>
</aui:form>
