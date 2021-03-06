<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@ include file="init.jsp"%>

<%
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunUserId = ParamUtil.getLong(request, "esfgunUserId");
long userId = 0;
long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
ESFGunKind kind = new ESFGunKindImpl();
ESFGunType type = new ESFGunTypeImpl();
ESFCane cane = new ESFCaneImpl();

String name = "";
String typeName = "";
String kindName = "";
String note = "";
String code = "";
String caliber = "";
String measures = "";
int typeId = 0;
boolean favorite = false;

ESFgunUser gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);

if(Validator.isNotNull(gunUser) && Validator.isNotNull(gunUser.getEsfUserId()) ){
	userId = gunUser.getEsfUserId();
}



if(esfCaneId > 0 && Validator.isNotNull(ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId)) ){
	cane = ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId);
}

if(cane.getEsfCaneId() > 0 && Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId())) ){
	kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId());
	
}

if(cane.getEsfGunTypeId() > 0 && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(cane.getEsfGunTypeId()))){
	type = ESFGunTypeLocalServiceUtil.fetchESFGunType(cane.getEsfGunTypeId());
	
}

if(Validator.isNotNull(type) && Validator.isNotNull(type.getName())){
	typeName = type.getName().toUpperCase();
}

if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getName())){
	kindName =kind.getName().toUpperCase();
}

if(Validator.isNotNull(gunUser) ){
	if(Validator.isNotNull(gunUser.getCode())){
		code = gunUser.getCode();
	}
	if(Validator.isNotNull(gunUser.getNote())){
		note = gunUser.getNote();
	}
	if(Validator.isNotNull(gunUser.getIsFavorite())){
		favorite = gunUser.getIsFavorite();
	}
	if(Validator.isNotNull(gunUser.getEsfCaliber())){
		caliber = gunUser.getEsfCaliber();
	}
	if(Validator.isNotNull(gunUser.getEsfMeasures())){
		measures = gunUser.getEsfMeasures();
	}
	if(Validator.isNotNull(gunUser.getTypeId())){
		typeId = (int) gunUser.getTypeId();
	}
}
System.out.println("templatePath="+templatePath);
%>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%=templatePath + "tabs/edit_esfShooter.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
			<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId)%>' />
	</portlet:renderURL>
	
	
	<portlet:actionURL name="alterESFCane" var="alterESFCaneURL" >
		<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
		<portlet:param name="esfGunUserId" value="<%=String.valueOf(esfGunUserId)%>" />
		<portlet:param name="userId" value="<%=String.valueOf(userId)%>" />
		<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId)%>' />
	</portlet:actionURL>
	
	<aui:form action="<%=alterESFCaneURL%>" name="<portlet:namespace />fm">
	
		<aui:input name="brand-id"  value="<%= typeName%>" readonly = "true"/>
		
		<aui:input name="kind-name"  value="<%= kindName%>" readonly = "true"/>
		
		<aui:select name="typology">
			<%
				List<ListType>  listType = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFGun.type");
				for(ListType t : listType){
					boolean find = false;
					if(t.getListTypeId() == typeId){
						find = true;
					}
				%>
					<aui:option label="<%= t.getName()%>" value="<%= t.getListTypeId()%>" selected="<%=find %>"/>
			<%
				}
			%>
		</aui:select>
		
		<aui:input name="measures" label="measures" type="text" value="<%=measures %>"/>
		
		<aui:input name="caliber" label="caliber" type="text" value="<%= caliber%>">
			<aui:validator name="digits"></aui:validator>
		</aui:input>
		
		
		<aui:input name="freshman"  value="<%= code%>"/>
		
		<aui:input name="is-favorite-gun" type="checkbox" checked="<%=favorite %>"/>
		
		<aui:input name="shooter_note"  value="<%= note%>"/>
	
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
		</aui:button-row>
	</aui:form>