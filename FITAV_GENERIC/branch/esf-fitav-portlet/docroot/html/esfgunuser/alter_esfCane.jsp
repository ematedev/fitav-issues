<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>


<%
long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
long userId = 0;
ESFUser esfUser = new ESFUserImpl();
ESFGunKind kind = new ESFGunKindImpl();
ESFGunType type = new ESFGunTypeImpl();
ESFCane cane = new ESFCaneImpl();

String name = "";
String typeName = "";
String kindName = "";
String note = "";
String code = "";
boolean favorite = false;

ESFgunUser gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);

if(Validator.isNotNull(gunUser) && Validator.isNotNull(gunUser.getEsfUserId()) ){
	userId = gunUser.getEsfUserId();
}

if(userId > 0 && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(userId)) ){
	esfUser = ESFUserLocalServiceUtil.fetchESFUser(userId);
}

if(esfCaneId > 0 && Validator.isNotNull(ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId)) ){
	cane = ESFCaneLocalServiceUtil.fetchESFCane(esfCaneId);
}

if(cane.getEsfCaneId() > 0 && Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId())) ){
	kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId());
	
}

if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfGunTypeId()) &&
		Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId())) ){
	type = ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId());
}

if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFirstName()) &&
		Validator.isNotNull(esfUser.getLastName()) ){
	name = (esfUser.getFirstName() + " " + esfUser.getLastName()).toUpperCase();
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
}

%>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%="/html/esfgunuser/view.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
	</portlet:renderURL>
	
	
	<portlet:actionURL name="alterESFCane" var="alterESFCaneURL" >
		<portlet:param name="esfCaneId" value="<%=String.valueOf(esfCaneId)%>" />
		<portlet:param name="esfGunUserId" value="<%=String.valueOf(esfGunUserId)%>" />
		<portlet:param name="userId" value="<%=String.valueOf(userId)%>" />
	</portlet:actionURL>
	
	<aui:form action="<%=alterESFCaneURL%>" name="<portlet:namespace />fm">
	
		<aui:input name="firstName"  value="<%= name%>" readonly = "true"/>
		
		<aui:input name="brand-id"  value="<%= typeName%>" readonly = "true"/>
		
		<aui:input name="kind-name"  value="<%= kindName%>" readonly = "true"/>
		
		<aui:input name="freshman"  value="<%= code%>"/>
		
		<aui:input name="is-favorite-gun" type="checkbox" checked="<%=favorite %>"/>
		
		<aui:input name="shooter_note"  value="<%= note%>"/>
	
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
		</aui:button-row>
	</aui:form>