<%@page import="java.util.Collection"%>
<%@ include file="init.jsp" %>

<%@page import="it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera"%>

<%
String className = (String) request.getAttribute("phones.className");
long classPK = (Long) request.getAttribute("phones.classPK");
long esfUserId= user.getUserId();
Calendar calendar = CalendarFactoryUtil.getCalendar();
String year = String.valueOf(ManageDate.getYear(calendar.getTime()));
int yearO = (Integer.parseInt(year)-1);
String renewalDate = ManageDate.CalendarToString(calendar);
ESFOrganization esfOrganization = null;
List<Phone> phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, classPK);
String phone = StringPool.BLANK;
String phone1 = StringPool.BLANK;
String fieldAddress=StringPool.BLANK;

if (currentOrganizationId > 0) {

	esfOrganization = ESFOrganizationLocalServiceUtil
			.getESFOrganization(currentOrganizationId);
}

if(Validator.isNotNull(phones) && phones.size()>0  && Validator.isNotNull(phones.get(0)) && Validator.isNotNull(phones.get(0).getNumber())){
	phone = phones.get(0).getNumber();
}
if(Validator.isNotNull(phones) && phones.size()>0  && Validator.isNotNull(phones.get(1)) && Validator.isNotNull(phones.get(1).getNumber())){
	phone1 = phones.get(1).getNumber();
}

String emailAddress = StringPool.BLANK;
List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>(); 
try {
emailAddresses = EmailAddressLocalServiceUtil
.getEmailAddresses(themeDisplay.getCompanyId(),
		Organization.class.getName(),
		currentESFOrganization.getEsfOrganizationId());
}
	catch (Exception e){
		
	}

if (emailAddresses != null && emailAddresses.size() > 0) {

	emailAddress = emailAddresses.get(0).getAddress();
}

String mailingAddress=StringPool.BLANK;

for (int j = 0; j < esfAddressesToPrint.length; j++) {
	
	if(j!=ESFKeys.ESFAddressType.TYPES_POSITION_FIELD && Validator.isNotNull(esfAddressesToPrint[j])){
		
	ListType addressType = null;

	if ( Validator.isNull(esfAddressesToPrint[j]) || Validator.isNull(esfAddressesToPrint[j].getListTypeId()))

		addressType = ListTypeServiceUtil
			.getListType(ESFAddressListType.OTHER);

	else{
		addressType = ListTypeServiceUtil
			.getListType(esfAddressesToPrint[j]
					.getListTypeId());
	}
   
	mailingAddress= esfAddressesToPrint[j].getStreet1()+ StringPool.COMMA + StringPool.SPACE +
			esfAddressesToPrint[j].getZip()+ " "+esfAddressesToPrint[j].getEsfProvinceId();
	
	}
	
	
}		


int numField = 0;
String categoryAssosiation = StringPool.BLANK;
String city = StringPool.BLANK;
String province = StringPool.BLANK;
String region = StringPool.BLANK;
String street = StringPool.BLANK;
String zip = StringPool.BLANK;
ListType addressType = null;


if(Validator.isNotNull(esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD])){

if ( Validator.isNull(esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getListTypeId())) {

	addressType = ListTypeServiceUtil
			.getListType(ESFAddressListType.OTHER);
} else {
	
	addressType = ListTypeServiceUtil
			.getListType(esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
					.getListTypeId());
	
}

long idCity = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getEsfCityId();
String idCountry = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getEsfCountryId();
String idProvince = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getEsfProvinceId();
String idRegion = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getEsfRegionId();

List<ESFCity> cities = ESFCityLocalServiceUtil.getESFCities(-1, -1);
if (cities.size()>0){
	for (ESFCity cit : cities){
		if (cit.getIdCity()==idCity){
			city = cit.getName();
			province = cit.getIdProvince();
			//zip= String.valueOf(cit.getZip());
		}
	}
}
	street = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getStreet1();
	zip = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD].getZip();

fieldAddress = street+ ", "+zip+" "+city+" "+province;


}

String key = ESFRenewalConstants.REGISTRATION_COST;
String value = StringPool.BLANK;
numField=ESFFieldLocalServiceUtil.
findByESFOrganization(currentOrganizationId,ESFKeys.ESFStateType.ENABLE).size();
if(numField==0){
	key = key+"-1";
categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
}
else if(numField==1){
	key = key+"-1";
categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
}else if(numField==2){
	key = key+"-2";
categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
}else
if(numField ==3){
		key = key+"-3";
	categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
}else if(numField ==5){
	key = key+"-4";
categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
}else if(numField ==5){
	key = key+"-5";
categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
} else {
categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
key = key+"-6";
}


ESFConfiguration conf = null;
try{
	conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey(key);
	value = conf.getValue();
}
catch (Exception e) {
	value = "0";
	e.printStackTrace();
}

String[] requiredRolesListClone = (String[])requiredRolesList.clone();
%>

<liferay-ui:error key="error" message="the-renewal-has-not-been-successful" />

<liferay-portlet:actionURL name="renewalCompanyAction" var="renewalCompanyActionURL" />

<liferay-ui:header title='<%= LanguageUtil.format(pageContext, "renewal-module-x", new String[]{year}) %>' />

<aui:form name="fm" class="renewal-form" action="<%= renewalCompanyActionURL %>" method="post" onSubmit='<%= "event.preventDefault();" + renderResponse.getNamespace() + "renewalFormSubmit();" %>'> 
	<aui:input type="hidden" value="<%= currentESFOrganization.getEsfOrganizationId() %>" name="esfOrganizationId"/>
	<aui:input label ="associationName" name="associationName" 
	value='<%= esfOrganization.getName() %>'
	readonly="true" />
	
	
	<div>
	
	<aui:input name="mailingAddress" label="mailingAddress"
	readonly="true"  value='<%=mailingAddress %>' inlineField="true"/>
	
	<aui:input name="fieldAddress"  label="fieldAddress"
	readonly="true" value='<%=fieldAddress %>' inlineField="true"/>
	
	</div>
	
	<div>
	<aui:fieldset>
	
	<aui:input name="phoneNumbers" 
	readonly="true" inlineField="true" value='<%=phone %>'	/>
	
	<aui:input name="phoneNumbers2" label ="" 
	readonly="true" inlineField="true" value="<%=phone1 %>"/>
	
	
	<!--  
	<aui:input name="fax" inlineLabel="true"
	readonly="true" 
	 inlineField="true"/>
	  -->
	</aui:fieldset>
	</div>
	
	<aui:fieldset  >
	<aui:input name="email" inlineField="true" label="email"
	readonly="true" 
	value='<%=emailAddress %>'
	 />
	
	<aui:input name="internetSite" inlineField="true"
	readonly="true" 
	label="internetSite"
	/>
	
	</aui:fieldset>
	
	<aui:fieldset >
		<aui:input name="fiscalCode" inlineField="true" readonly="true" label="fiscalCode" value='<%=esfOrganization.getFiscalCode() %>' />
		<aui:input name="vatNumber" inlineField="true" readonly="true" label="vatNumber" value='<%=esfOrganization.getVat() %>' />
		<aui:input name="ibanCode" inlineField="true" label="ibanCode" readonly="true" value='<%=esfOrganization.getIbanCode() %>' />
	</aui:fieldset>

	<p> In nome e per conto dell'Associazione, il sottoscritto dichiara :</p>

	<div>- di aver effettuato il versamento di Euro  <aui:input style="width:30px; height:14px;" 
	label="" name="versamento" inlineField="true" inlineLabel="true" readonly="true" value='<%=value %>'/> per il Rinnovo dell'Affiliazione <%=String.valueOf(yearO) %> e di voler acquistare <div class="cards-number-wrapper"><aui:input style="width:30px; height:14px;" 
	label="" name="cardsNumber" inlineField="true" inlineLabel="true" value="4" min="4" /><liferay-ui:icon-help message="minimum-cards-number-help-message"/></div> tessere </div> 
	<div> - di avere n. <aui:input label="" name="n_campi" style="width:20px; height:14px;" inlineField="true" inlineLabel="true" readonly="true" 
	value='<%=String.valueOf(numField) %>'
	/> campi da utilizzare in contemporanea </div> 
	 <div>- di essere inquadrato nella <aui:input label="" inlineLabel="true" name="category" inlineField="true" style="width:60px; height:14px;"
	 value='<%=categoryAssosiation %>' readonly="true" 
	 />Categoria di affiliazione</div>
	
	<p> COMPOSIZIONE DEL CONSIGLIO DIRETTIVO: </p>
	
	<liferay-ui:search-container emptyResultsMessage="no-results">
	
	<% List<VW_ESFListaIncarichiTessera> listaIncarichiConsiglioDirettivo = (List<VW_ESFListaIncarichiTessera>) request.getAttribute("listaIncarichiConsiglioDirettivo"); %>
	<% int size = listaIncarichiConsiglioDirettivo.size(); %>
	
		<liferay-ui:search-container-results
			results='<%= listaIncarichiConsiglioDirettivo %>'
			total='<%= size %>' />
			
			
		<liferay-ui:search-container-row  
			className="it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera" modelVar="incarico">

			<liferay-ui:search-container-column-text title="N. Tessera" cssClass="firstCss">
					<%= incarico.getCodiceTessera()  %>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text property="lastName" title="Cognome" cssClass="firstCss"/>
			
			<liferay-ui:search-container-column-text property="firstName" title="Nome" cssClass="firstCss" />
		</liferay-ui:search-container-row>
	

	</liferay-ui:search-container>
	
	<aui:field-wrapper label="payment-type">
		<aui:input name="paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_ELECTRONIC %>" type="radio" label="electronic-payment" checked="<%= true %>"/>
		<aui:input name="paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_POSTAL %>" type="radio" label="postal" />
		<aui:input name="paymentType" value="<%= ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_TRANSFER %>" type="radio" label="transfer" />
	</aui:field-wrapper>

	<strong><u><liferay-ui:message key="acknowledgment-title" /></u></strong>
	<p><liferay-ui:message key="acknowledgment" /></p>
	
	<aui:field-wrapper>
		<aui:input name="acknowledge" label="accept" type="radio" value="0" />
		<aui:input name="acknowledge" label="not-accept" type="radio" value="1" />
	</aui:field-wrapper>

	<aui:button-row>
		<aui:button type="submit" value="confirm" cssClass="submit-button" disabled="true"/> 
		<aui:button onClick='<%=backUrl %>' type="cancel"/> 
<%-- 		<aui:button  value="DownloadPDF"  onclick="ajaxCall()"/>  --%>
	</aui:button-row>
</aui:form>