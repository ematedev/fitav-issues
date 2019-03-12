<%@ include file="init.jsp"%>

<%long esfUserId = Long.parseLong(renderRequest.getParameter("esfUserId"));


String pathBack=ParamUtil.getString(renderRequest, "pathBack");
ESFGun esfGun = null;
String from =ParamUtil.getString(request, "from");
long esfCaneId = ParamUtil.getLong(request, "esfCaneId");

long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
String modifyMode=ParamUtil.getString(request, "modifyMode");
if (esfGunId > 0) {

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());

	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);
%>
<portlet:renderURL var="viewURL1">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="modifyMode" value='<%=modifyMode%>'/>

</portlet:renderURL>

<portlet:actionURL name="editESFGunKind" var="editESFGunKindURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="from" value="<%=from%>" />
	<portlet:param name="modifyMode" value='<%=modifyMode%>'/>


</portlet:actionURL>

<aui:form action="<%=editESFGunKindURL%>" name="<portlet:namespace />fm">
	
		
	<aui:fieldset>
	
	
	<aui:select name="gunTypeId" label="brand-id">
			<%
				for(ESFGunType esfGunType : esfGunTypes){
				%>
					<aui:option label="<%= esfGunType.getName()%>" value="<%= esfGunType.getEsfGunTypeId()%>" />
			<%
				}
			%>
	</aui:select>
	
		<aui:input name="name" label="model"/>

		<aui:input name="description" label="description"/>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL1 %>"></aui:button>
	</aui:button-row>
</aui:form>