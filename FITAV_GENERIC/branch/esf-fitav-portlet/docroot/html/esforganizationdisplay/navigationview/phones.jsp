<%@include file="init.jsp"%>

<%
String className = (String)request.getAttribute("phones.className");
long classPK = (Long)request.getAttribute("phones.classPK");
List<Phone> phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, classPK);

%>

<h3><liferay-ui:message key="phone-numbers" /></h3>

<c:if test="<%= phones.isEmpty()%>">
	<div class="alert alert-info">
		<liferay-ui:message key="no-phone"></liferay-ui:message>
	</div>
</c:if>
<div class="row detail">
<%
int i = 1;
for(Phone phone : phones){
	if(i<=3){
		String label="";
		ESFPhone esfPhone = ESFPhoneLocalServiceUtil.fetchESFPhone(phone.getPhoneId());
		ListType type =  ListTypeServiceUtil.getListType(esfPhone.getListTypeId());
		if(Validator.isNotNull(type)){
			label = type.getName();
		}
	%>
	<h4><liferay-ui:message key="<%= label %>"></liferay-ui:message></h4>
	<p><%= phone.getNumber()%></p>
	<%
	}
	else{
%>
	<h4><liferay-ui:message key="phone-number-x" arguments="<%= i%>"></liferay-ui:message></h4>
	<p><%= phone.getNumber()%></p>
<%
} 
	i++;
}
%>
</div>
