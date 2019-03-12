<%@ include file="init.jsp"%>

<%
String namespace = renderResponse.getNamespace();
long esfGunId = ParamUtil.getLong(request, "esfGunId");
long esfGunTypeId = 0 ;
int type = ParamUtil.getInteger(request, "type");

String name = "";
String brand = "";
String crtidgeName = "";


if(3 == type){
	
	ESFCatridge gun = ESFCatridgeLocalServiceUtil.fetchESFCatridge(esfGunId);
	if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getCatridgeModel())){
		name = gun.getCatridgeModel().toUpperCase();
	}
	if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getEsfGunTypeId())){
		esfGunTypeId = gun.getEsfGunTypeId();
	}
	
}else{
	
	ESFGunKind gun = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunId);
	
	if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getName())){
		name = gun.getName().toUpperCase();
	}
	if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getEsfGunKindId()) &&
			Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId())) && 
					Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId()).getEsfGunTypeId()) &&
						Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId()).getEsfGunTypeId())) &&
						Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId()).getEsfGunTypeId()).getName())){
		brand = ESFGunTypeLocalServiceUtil.fetchESFGunType(ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId()).getEsfGunTypeId()).getName().toUpperCase();
	}
	if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getEsfGunTypeId())){
		esfGunTypeId = gun.getEsfGunTypeId();
	}

}

if(3==type){
	if(Validator.isNotNull(esfGunId) && Validator.isNotNull(ESFCatridgeLocalServiceUtil.fetchESFCatridge(esfGunId)) &&
			Validator.isNotNull(ESFCatridgeLocalServiceUtil.fetchESFCatridge(esfGunId).getCatridgeModel())){
		crtidgeName = ESFCatridgeLocalServiceUtil.fetchESFCatridge(esfGunId).getCatridgeModel();
	}
}

%>
<liferay-ui:error key="duplicate_code" message="duplicate_code"/>
<%if(3 != type){ %>
<h3><%=brand + "-" +name %></h3>
<%}else{ %>
<h3><%=crtidgeName.toUpperCase()%></h3>
<%} %>
<portlet:actionURL name="assigUser" var="assigUserURL" >
	<portlet:param name="esfGunId" value='<%=String.valueOf(esfGunId)%>' />
	<portlet:param name="esfGunTypeId" value='<%=String.valueOf(esfGunTypeId)%>' />
	<portlet:param name="type" value='<%=String.valueOf(type)%>' />
	<portlet:param name="mvcPath" value='<%=templatePath %>' />
</portlet:actionURL>

<aui:form action="<%=assigUserURL%>" name="<portlet:namespace />fm">
		<div id="show_checkKind" class="btn-field-align">
		<aui:input type="hidden" label="userId" name="shooterId"  readonly="true"/>
		<aui:input type="text" name="userName" readonly="true" inlineField="true">
			<aui:validator name="required" />
		</aui:input>
			<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
					id='<%=namespace + "chooseUserTrigger"%>' value="add">
			</aui:button>
		</div>
		<%if(1==type){ %>
		
		<aui:input type="text" name="freshman"  inlineField="true">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="isfavoritegun" label="is-favorite-gun" type="checkbox"/>
		
		<aui:input name="measures" label="measures"/>
		
		<aui:input name="caliber" label="caliber">
			<aui:validator name="number" />
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
		<%} %>
		
		<aui:input type="text" name="note" label="shooter_note"/>
		
	<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%="/html/esfgun/view.jsp"%>'  />
			<portlet:param name="op" value='<%="updAddr"%>' />
			<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' />
	</portlet:renderURL>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= backUrl%>"></aui:button>
	</aui:button-row>
</aui:form>
