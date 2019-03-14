<%@page import="java.text.MessageFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="init.jsp" %>

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
   
	mailingAddress= "via "+esfAddressesToPrint[j].getStreet1()+", "+
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

fieldAddress = "via "+street+ ", "+zip+" "+city+" "+province;


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

<liferay-ui:header title='<%= LanguageUtil.format(pageContext, "renewal-module-x", new String[]{year}) %>' backURL="<%= redirect %>" />

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
	label="" name="versamento" inlineField="true" inlineLabel="true" readonly="true" value='<%=value %>'/> per il Rinnovo dell'Affiliazione <%=String.valueOf(yearO) %> e di voler acquistare <aui:input style="width:30px; height:14px;" 
	label="" name="cardsNumber" inlineField="true" inlineLabel="true" value="0"/> tessere </div> 
	<div> - di avere n. <aui:input label="" name="n_campi" style="width:20px; height:14px;" inlineField="true" inlineLabel="true" readonly="true" 
	value='<%=String.valueOf(numField) %>'
	/> campi da utilizzare in contemporanea </div> 
	 <div>- di essere inquadrato nella <aui:input label="" inlineLabel="true" name="category" inlineField="true" style="width:60px; height:14px;"
	 value='<%=categoryAssosiation %>' readonly="true" 
	 />Categoria di affiliazione</div>
	
	<p> COMPOSIZIONE DEL CONSIGLIO DIRETTIVO: </p>
	
<liferay-ui:search-container emptyResultsMessage="no-results">
	<%
	List<ESFUserRole> allEsfUserRolePerPage = ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(currentType, ESFKeys.ESFStateType.ENABLE, true, searchContainer.getStart(),searchContainer.getEnd());

	int totalEsfUserRole = ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(currentType, ESFKeys.ESFStateType.ENABLE, true).size();

	List<ESFUserRole> sortableEsfUserRole = new ArrayList<ESFUserRole>(allEsfUserRolePerPage);
	%>
	<liferay-ui:search-container-results
		results="<%= sortableEsfUserRole %>"
		total="<%= totalEsfUserRole %>" />
	<liferay-ui:search-container-row 
		className="it.ethica.esf.model.ESFUserRole" modelVar="userRole">

		<%
		List<ESFUserESFUserRole> esfUserESFUserRoles = ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(currentOrganizationId, userRole.getEsfUserRoleId());
		String lastName = StringPool.BLANK;
		String firstName = StringPool.BLANK;
		String card = StringPool.BLANK;
		ESFCard esfCard = null;
		List<ESFCard> esfCards = new ArrayList<ESFCard> ();
		//verifica tessere del consiglio direttivo errore per mancanza di tessere, da verificare e gestire errore
		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			ESFUser esfUser = ESFUserLocalServiceUtil.fetchESFUser(esfUserESFUserRole.getEsfUserId());
			
			if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFirstName()) && Validator.isNotNull(esfUser.getLastName())){
				
				lastName=esfUser.getLastName();
				firstName=esfUser.getFirstName();
				esfCards = ESFCardLocalServiceUtil.findAllESFCardsByU_S(esfUser.getEsfUserId(), ESFKeys.ESFStateType.ENABLE);
				if (esfCards.size() > 0){
					esfCard = esfCards.get(0);
					card = esfCard.getCode();
				}
			}
		}
		// Rimuovo dalla lista i campi richiesti che hanno il valore della tessera
		if (Validator.isNotNull(card) && ArrayUtil.contains(requiredRolesList, Long.toString(userRole.getEsfUserRoleId()))) {
			requiredRolesListClone = ArrayUtil.remove(requiredRolesListClone, Long.toString(userRole.getEsfUserRoleId()));
		}
		%>
		<liferay-ui:search-container-column-text property="title"
			 cssClass="firstCss" />
		<liferay-ui:search-container-column-text name="N.Tessera" cssClass="firstCss">
			<%= card %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="lastName" cssClass="firstCss">
			<%=lastName%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="firstName" cssClass="firstCss" >
			<%= firstName%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

	<aui:button-row>
		<aui:button type="submit" value="confirm"/> 
		<aui:button onClick='<%=backUrl %>' type="cancel"/> 
		<aui:button  value="DownloadPDF"  onclick="ajaxCall()"/> 
	</aui:button-row>
</aui:form>


<aui:script use="liferay-portlet-url">
var requiredRolesListLength = <%= requiredRolesListClone.length %>;
Liferay.provide(window, '<portlet:namespace />renewalFormSubmit',function(){
	submitForm(document.<portlet:namespace />fm);
	return;
	if (requiredRolesListLength == 0) {
		submitForm(document.<portlet:namespace />fm);
	}
	else {
		var titles = '';
		<%
		int i = 1;
		String titles = StringPool.BLANK;
		for (String userRoleId : requiredRolesList) {
			String title = RoleLocalServiceUtil.getRole(Long.parseLong(userRoleId)).getTitle(locale);
			if (i == requiredRolesList.length) {
				titles += title;
			}
			else {
				titles += title + StringPool.COMMA;
			}
			titles += title + StringPool.SPACE;
			i++;
		}
		%>
		alert('<liferay-ui:message key="required-roles-are-necessary" arguments="<%=new String[]{titles}%>"/>')
	}
});

Liferay.provide(window,'ajaxCall',function(){
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('reportType', "pdf");
	$('input').each(function() {
		var input = $(this);
		resourceURL.setParameter(input.attr('name'), input.val());
	});
	var myRows =  [] ;
	var $th = $('table th');
	$('table tbody tr').each(function(i, tr){
		var obj = {}, $tds = $(tr).find('td');
		$th.each(function(index, th){
			obj[($(th).text()).trim()] = ($tds.eq(index).text()).trim();
		});
		myRows.push(obj);
	});
	resourceURL.setParameter('arrTable',(JSON.stringify(myRows)));
    window.open(resourceURL.toString());
});
</aui:script>
