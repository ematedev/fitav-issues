
<%@ include file="../init.jsp"%>

<%
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
String thisPath = templatePath + "navigation/alter_esfRifle.isp";


ESFGunKind kind = new ESFGunKindImpl();
ESFGunType type = new ESFGunTypeImpl();

String name = "";
String typeName = "";
String kindName = "";
String note = "";
String code = "";
String measures = "";
String caliber = "";
int typeId = 0;

boolean favorite = false;

ESFgunUser gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);



if(gunUser.getEsfGunKindId() > 0 && Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gunUser.getEsfGunKindId())) ){
	kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(gunUser.getEsfGunKindId());
}

if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gunUser.getEsfGunnTypeId()))){
	type = ESFGunTypeLocalServiceUtil.fetchESFGunType(gunUser.getEsfGunnTypeId());
	
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
	if(Validator.isNotNull(gunUser.getEsfMeasures())){
		measures = gunUser.getEsfMeasures();
	}
	if(Validator.isNotNull(gunUser.getEsfCaliber())){
		caliber = gunUser.getEsfCaliber();
	}
	if(Validator.isNotNull(gunUser.getTypeId())){
		typeId =(int) gunUser.getTypeId();
	}
	
}

%>

	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%=templatePath + "edit_esfShooter.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	</portlet:renderURL>
	
	
	<portlet:actionURL name="alterESFRifle" var="alterESFRifleURL" >
		<portlet:param name="esfGunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
		<portlet:param name="userId" value="<%=String.valueOf(esfUserId)%>" />
		<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	</portlet:actionURL>
	
	<aui:form action="<%=alterESFRifleURL%>" name="<portlet:namespace />fm">
	
		
		<aui:input name="brand-id"  value="<%= typeName%>" readonly = "true"/>
		
		<aui:input name="brand-id"  value="<%= kindName%>" readonly = "true"/>
		
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
			<aui:validator name="min">0</aui:validator>
		</aui:input>
		
		<aui:input name="freshman"  value="<%= code%>"/>
		
		<aui:input name="is-favorite-gun" type="checkbox" checked="<%=favorite %>"/>
		
		<aui:input name="shooter_note"  value="<%= note%>"/>
	
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
		</aui:button-row>
	</aui:form>