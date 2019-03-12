<%@ include file="../init.jsp" %>

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

<portlet:resourceURL var="locationURL" id="view.jsp" escapeXml="false" />

<portlet:renderURL var="viewCategorizationURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcPath" value="/html/esfgun/esfguncategorization/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editESFGunKind" var="editESFGunKindURL">
	<portlet:param name="esfGunTypeId" value="<%= String.valueOf(esfGunTypeId) %>" />
	<portlet:param name="flagSearch" value="<%= String.valueOf(flag) %>" />
	<portlet:param name="mvcPath" value="/html/esfgun/view.jsp" />
</portlet:actionURL>

<aui:form action="<%= editESFGunKindURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfGunKind %>" model="<%= ESFGunKind.class %>" />
		<c:if test='<%= !flag %>'>

<% if(0 == esfGunTypeId){%>

			<aui:select name="gunTypeId" label="esf-gunType-select" required="true">
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
		<aui:input name="gunTypeId" value="<%= esfGunTypeId%>" type="hidden"  >
		</aui:input>
		<aui:input name="esfGunTypeName"  value="<%= typeName.toUpperCase()%>" type="text" readonly="true">
		</aui:input>
<%} %>
		</c:if>
		
		<aui:fieldset>
			<aui:input type="hidden" name="esfGunKindId"
				value='<%= esfGunKind == null ? "" : esfGunKind.getEsfGunKindId() %>' />
				
			<aui:input name="name" />
			<aui:input name="description" type="textarea" />
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewCategorizationURL %>" value="back"></aui:button>
		</aui:button-row>
</aui:form>
