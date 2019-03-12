<%@page import="it.ethica.esf.service.ESFPhoneLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFPhone"%>
<%@page import="it.ethica.esf.util.ESFListType"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="java.util.List"%>
<%@include file="init.jsp"%>

<%

String className = ParamUtil.getString(request, "className");
boolean isAssociation = ParamUtil.getBoolean(request, "isAssociation");
long classPK = ParamUtil.getLong(request, "classPK");
int iesima = ParamUtil.getInteger(request, "iesima");
long idOwner = ParamUtil.getLong(request, "idOwner");

List<Phone> phones = new ArrayList<Phone>();

%>

<fieldset>

	<%
	
	Phone phone = PhoneLocalServiceUtil.createPhone(0);
	
	int listTypeId = 0;
	
	if(idOwner > 0){
		
		phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, classPK);
	
		if (iesima < phones.size()) {

			phone = phones.get(iesima);
			
			ESFPhone esfPhone = ESFPhoneLocalServiceUtil.getESFPhone(phone.getPhoneId());
			
			listTypeId = esfPhone.getListTypeId();
		}
	}
	
	%>

	<aui:input type="hidden" name='<%= "phoneNumberId" + iesima %>' value="<%= phone.getPhoneId() %>" />

	<aui:select name='<%= "listTypeIdPhone"+iesima%>' label="list-type-id-addr">
	
		<% 
		String classPhone = Contact.class.getName();
		if(isAssociation){
			 classPhone = className;
		}
		List<ListType> addressTypes = ListTypeServiceUtil.getListTypes(
				classPhone + ESFListType.TYPEPHONES);
		
		for (ListType addressType : addressTypes) {
			
			String label = addressType.getName();
			if(addressType.getListTypeId() == listTypeId){
		%>
				<aui:option label="<%= label %>" 
					value="<%= addressType.getListTypeId() %>" selected="true"/>
		<%
				}
				else{
		%>
				<aui:option label="<%= label %>" 
					value="<%= addressType.getListTypeId() %>" />
					
		<%		}
			}
		
		%>
	</aui:select>
	
	<div class="input-prepend">
		<span class="add-on"><i class="icon-phone"></i></span>
		<aui:input inlineField="<%= true %>" name='<%= "phoneNumber" + iesima %>' value="<%= phone.getNumber() %>" label="">
			<aui:validator name="numbers" errorMessage="please-enter-just-numbers"></aui:validator>
		</aui:input>
	</div>
	

</fieldset>

<style>
.aui .input-append .help-inline div, .aui .input-prepend .help-inline div {
	font-size: 14px;
}
</style>

