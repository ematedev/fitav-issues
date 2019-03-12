<%@ include file="init.jsp"%>

<%
String pathBack=ParamUtil.getString(renderRequest, "pathBack");
ESFGun esfGun = null;
ESFCane esfCane = null;
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
if (esfCaneId > 0) {

	esfCane = ESFCaneLocalServiceUtil.getESFCane(esfCaneId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfCane.getEsfGunKindId());

	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}
else if (esfGunId >0){

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());

	if(esfGunKind != null)

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();
String modifyMode=ParamUtil.getString(request, "modifyMode");
String from=ParamUtil.getString(request, "from");
%>
<portlet:renderURL var="viewURL1">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="modifyMode" value='<%=modifyMode %>'/>
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
</portlet:renderURL>

<portlet:actionURL name="editESFGunKind" var="editESFGunKindURL">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	<portlet:param name="modifyMode" value='<%=modifyMode %>'/>
	<portlet:param name="from" value='<%=from %>'/>
</portlet:actionURL>

<aui:form action="<%=editESFGunKindURL%>" name="<portlet:namespace />fm">
	
		
	<aui:fieldset>
	
	<aui:select name="gunTypeId" required="true" label="esf-gunType-select"  >
			
			<%
			for (ESFGunType esfGunType : esfGunTypes) {

				if(esfGunType.getEsfGunTypeId() == esfGunTypeId){
			%>
				<aui:option label="<%= esfGunType.getName()%>"
					value="<%= esfGunType.getEsfGunTypeId()%>" selected="true"/>
			<%
				}
				else{
			%>
				<aui:option label="<%= esfGunType.getName()%>"
					value="<%= esfGunType.getEsfGunTypeId()%>" />
			<%
				}
			}
			%>	
		</aui:select>

		<aui:input name="name" label="name">
		</aui:input>
		<aui:input name="description" label="Descrizione">
		</aui:input>

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL1 %>"></aui:button>
	</aui:button-row>
</aui:form>