
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@ include file="init.jsp"%>

<%
String pathBack=ParamUtil.getString(renderRequest, "pathBack");
String esfUserId = ParamUtil.getString(request, "esfUserId");
ESFGun esfGun = null;
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
long esfGunTypeId = 0;
ESFGunKind esfGunKind = null;
ESFGunType typeGun = new ESFGunTypeImpl();
if (esfGunId > 0) {

	esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

	esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKindsById(esfGun.getEsfGunKindId());

	if(esfGunKind != null){

		esfGunTypeId = esfGunKind.getEsfGunTypeId();
		typeGun = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunTypeId);
	}
}

List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);
String modifyMode=ParamUtil.getString(request, "modifyMode");
String from=ParamUtil.getString(request, "from");

%>
<portlet:renderURL var="viewURL1">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="modifyMode" value='<%=modifyMode %>'/>
	<portlet:param name="esfUserId" value='<%=esfUserId%>' />
</portlet:renderURL>

<portlet:actionURL name="editESFGunKind" var="editESFGunKindURL">
	<portlet:param name="mvcPath" value='<%= pathBack %>' />
	<portlet:param name="esfGunId" value="<%=String.valueOf(esfGunId)%>" />
	<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
	<portlet:param name="esfUserId" value='<%=esfUserId%>' />
	<portlet:param name="modifyMode" value='<%=modifyMode %>'/>
	<portlet:param name="from" value='<%=from %>'/>
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
	
		<aui:input name="name" label="model">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="description" label="description">
		</aui:input>
		<aui:select name="typology">
			<%
				List<ListType>  listType = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFGun.type");
				for(ListType t : listType){
				%>
					<aui:option label="<%= t.getName()%>" value="<%= t.getListTypeId()%>" />
			<%
				}
			%>
		</aui:select>
		<aui:input name="measures" label="measures"/>
		<aui:input name="caliber" label="caliber">
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL1 %>"></aui:button>
	</aui:button-row>
</aui:form>
