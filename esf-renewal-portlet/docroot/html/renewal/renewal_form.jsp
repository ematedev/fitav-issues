<%@page import="it.ethica.esf.service.persistence.CityPK"%>
<%@page import="com.ethica.esf.util.ESFRenewalConstants"%>
<%@page import="it.ethica.esf.service.ESFConfigurationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFConfiguration"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserRole"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFProvincePK"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFRegionPK"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.EmailAddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.EmailAddress"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ethica.esf.util.ESFKeys"%>
<%@page import="com.ethica.esf.util.ESFKeys.ESFAddressListType"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFProvincePK"%>
<%@page import="it.ethica.esf.service.persistence.ESFRegionPK"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFCityPK"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFCityUtil"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<% 
long esfUserId= user.getUserId();
Calendar calendar = CalendarFactoryUtil.getCalendar();
String year = String.valueOf(ManageDate.getYear(calendar.getTime()));
int yearO = (Integer.parseInt(year)-1);
String renewalDate = ManageDate.CalendarToString(calendar);
ESFOrganization esfOrganization = null;
String fieldAddress=StringPool.BLANK;
if (currentOrganizationId > 0) {

	esfOrganization = ESFOrganizationLocalServiceUtil
			.getESFOrganization(currentOrganizationId);
	//System.out.println("org :"+esfOrganization.getEsfOrganizationId());
}



String className = (String) request.getAttribute("phones.className");
long classPK = (Long) request.getAttribute("phones.classPK");
List<Phone> phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, classPK);
String phone = StringPool.BLANK;
if(Validator.isNotNull(phones) && phones.size()>0  && Validator.isNotNull(phones.get(0)) && Validator.isNotNull(phones.get(0).getNumber())){
	phone=phones.get(0).getNumber();
}

String emailAddress = StringPool.BLANK;
List<EmailAddress> emailAddresses = new ArrayList <EmailAddress>();
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
   
	mailingAddress= esfAddressesToPrint[j].getStreet1()+", "+
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
/*
	if(idCity>0){
		
	ESFCityPK cityPk = new ESFCityPK();
	cityPk.setIdCity(idCity);
	cityPk.setIdCountry(idCountry);
	cityPk.setIdProvince(idProvince);
	cityPk.setIdRegion(idRegion);
		if (Validator.isNotNull(cityPk)
				&& Validator.isNotNull(ESFCityLocalServiceUtil.fetchESFCity(cityPk))) {
			city = ESFCityLocalServiceUtil.fetchESFCity(cityPk).getName();
		}

	}

	if (Validator.isNotNull(idProvince)) {
		ESFRegionPK regionPK = new ESFRegionPK();
		regionPK.setIdRegion(idRegion);
		regionPK.setIdCountry(idCountry);
		region = ESFRegionLocalServiceUtil.fetchESFRegion(
				regionPK).getName();
	}

	if (Validator.isNotNull(idProvince)) {
		ESFProvincePK provincePK = new ESFProvincePK();
		provincePK.setIdProvince(idProvince);
		provincePK.setIdCountry(idCountry);
		provincePK.setIdRegion(idRegion);
		province = ESFProvinceLocalServiceUtil
				.fetchESFProvince(provincePK).getName();
	}
	*/
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

%>


<portlet:renderURL var="renewFormURL">
 <portlet:param name="mvcPath" value='<%=templatePath+ "acknowledgment.jsp" %>'/>
 <portlet:param name="renewalDate" value='<%=renewalDate %>'/>
 <portlet:param name="amount" value='<%=value %>'/>
</portlet:renderURL>



<h4> MODULO DI RINNOVO DELL'AFFILIAZIONE  <b> <%=year %> </b> </h4>

<form id='pdfAjaxForm' class="renewal-form" action="" > 
	<aui:input label ="associationName" name="associationName" 
	value='<%= esfOrganization.getName() %>'
	readonly="true" inlineLabel="true" />
	
	<aui:input name="mailingAddress" inlineLabel="true" label="mailingAddress"
	readonly="true" 
	 value='<%=mailingAddress %>'
	 />
	
	<aui:input name="fieldAddress"  inlineLabel="true" label="fieldAddress"
	readonly="true" 
	 value='<%=fieldAddress %>'
	 />
	<aui:fieldset>
	<aui:input name="phoneNumbers" inlineLabel="true"
	readonly="true" 
	 inlineField="true"
	 value='<%=phone %>'	/>
	
	
	<aui:input name="phoneNumbers2" label ="" 
	readonly="true" 
	inlineLabel="true"
	 inlineField="true"/>
	
	
	<aui:input name="fax" inlineLabel="true"
	readonly="true" 
	 inlineField="true"/>
	</aui:fieldset>
	
	<aui:fieldset  >
	<aui:input name="email" inlineLabel="true" inlineField="true" label="email"
	readonly="true" 
	value='<%=emailAddress %>'
	 />
	
	<aui:input name="internetSite" inlineLabel="true" inlineField="true"
	readonly="true" 
	label="internetSite"
	/>
	
	</aui:fieldset>
	
	<aui:fieldset >
	<aui:input name="fiscalCode" inlineLabel="true" inlineField="true"
	readonly="true" 
	label="fiscalCode"
	value='<%=esfOrganization.getFiscalCode() %>'
	/>
	
	<aui:input name="vatNumber" inlineLabel="true" inlineField="true"
	readonly="true" 
	label="vatNumber"
	value='<%=esfOrganization.getVat() %>'
	/>
	</aui:fieldset>
	<aui:input name="ibanCode" inlineLabel="true" label="ibanCode"
	readonly="true" 
	value='<%=esfOrganization.getIbanCode() %>'
	/>


<p> In nome e per conto dell'Associazione, il sottoscritto dichiara :</p>


	<div>- di aver effettuato il versamento di Euro  <aui:input style="width:30px; height:14px;" 
	label="" name="versamento" inlineField="true" inlineLabel="true" readonly="true" value='<%=value %>'/> per il Rinnovo dell'Affiliazione <%=String.valueOf(yearO) %> </div> 
	<div> - di avere n. <aui:input label="" name="n_campi" style="width:20px; height:14px;" inlineField="true" inlineLabel="true" readonly="true" 
	value='<%=String.valueOf(numField) %>'
	/> campi da utilizzare in contemporanea </div> 
	 <div>- di essere inquadrato nella <aui:input label="" inlineLabel="true" name="category" inlineField="true" style="width:60px; height:14px;"
	 value='<%=categoryAssosiation %>' readonly="true" 
	 />Categoria di affiliazione</div>
	
	<p> COMPOSIZIONE DEL CONSIGLIO DIRETTIVO: </p>
	
<liferay-ui:search-container emptyResultsMessage="no-results"   >
	<liferay-ui:search-container-results>

		<%
			List<ESFUserRole> allEsfUserRolePerPage =
						ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(
							currentType, ESFKeys.ESFStateType.ENABLE, true,
							      searchContainer.getStart(),searchContainer.getEnd()
								)
							;

					int totalEsfUserRole =
						ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(
							currentType, ESFKeys.ESFStateType.ENABLE, true).size();

					List<ESFUserRole> sortableEsfUserRole =
						new ArrayList<ESFUserRole>(allEsfUserRolePerPage);

					pageContext.setAttribute("results", sortableEsfUserRole);
					pageContext.setAttribute("total", totalEsfUserRole);
			
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="it.ethica.esf.model.ESFUserRole" modelVar="userRole">

		<%
		List<ESFUserESFUserRole> esfUserESFUserRoles =
					ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
						currentOrganizationId, userRole.getEsfUserRoleId());

		String lastName = StringPool.BLANK;
		String firstName = StringPool.BLANK;
		String card = StringPool.BLANK;
		int j = 0;
		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
				ESFUser esfUser =
					ESFUserLocalServiceUtil.fetchESFUser(esfUserESFUserRole.getEsfUserId());
				ESFCard esfCard = null; 
				if(Validator.isNotNull(esfUser) && Validator.isNotNull(esfUser.getFirstName()) && Validator.isNotNull(esfUser.getLastName())){
					if (j == esfUserESFUserRoles.size()-1 || esfUserESFUserRoles.size()==1){
						lastName += "<span>"+esfUser.getLastName()+ "</span>";
						firstName += "<span>"+esfUser.getFirstName()+ "</span>";
						esfCard = 
								ESFCardLocalServiceUtil.getEsfCardByEsfUserId(esfUser.getEsfUserId());
						card += "<span>"+esfCard.getCode()+ "</span>";
					}
					else {
						lastName += "<span>"+esfUser.getLastName()+ "</span><br>" ;
						firstName += "<span>"+esfUser.getFirstName()+ "</span><br>" ;
						esfCard = 
								ESFCardLocalServiceUtil.getEsfCardByEsfUserId(esfUser.getEsfUserId());
						card += "<span>"+esfCard.getCode() + "</span><br>" ;
					}
					j ++;
				}
				
		}
		%>
		<liferay-ui:search-container-column-text property="title"
			 cssClass="firstCss"/> 
		
		<liferay-ui:search-container-column-text name="N.Tessera" cssClass="firstCss searchT" > 
			<%= card %>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="lastName" cssClass="firstCss searchT">
			<%=lastName%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="firstName" cssClass="firstCss searchT" >
			<%=  firstName%>
		</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfUserRole_action.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


	<aui:button-row>
		<aui:button  onClick='<%=renewFormURL %>' value="confirm"/> 
		<aui:button onClick='<%=backUrl %>' type="cancel"/> 
		<aui:button  value="DownloadPDF"  onclick="ajaxCall()"/> 
	</aui:button-row>
</form>


<aui:script use="liferay-portlet-url">
Liferay.provide(window,'ajaxCall',function(){
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('reportType', "pdf");
	$('input').each(function() {
        var input = $(this);
        resourceURL.setParameter(input.attr('name'), input.val());
      
    });
	var myRows =  [] ;
   //costruzione json del searchcontainer consiglio direttivo
	var $th = $('table th');
	$('table tbody tr').each(function(i, tr){
	    var obj = {}, $tds = $(tr).find('td');
	    $th.each(function(index, th){
	    	     if ($tds.eq(index).hasClass('searchT')){
	    	    	 var spans = $tds.eq(index).find('span');
	    	    	 var valore = '';
	    	    	 if (spans && spans.size()>0){
	    	    		 spans.each(function(k,span){
	    	    			 if (k==spans.size()-1){
	    	    				 valore += $(span).text();
	    	    			 }
	    	    			 else {
	    	    				 valore += $(span).text() + ';';
	    	    			 }
	    	    			
	    	    		 });
	    	    	 }
	    	    		 
	    	    	 obj[($(th).text()).trim()] = valore;
	    	     }
	    	
	    	     else {
	    	    	 obj[($(th).text()).trim()] = ($tds.eq(index).text()).trim();
	    	     }
	        
	    	
	    });
	    myRows.push(obj);
	});
	console.log(myRows);
	resourceURL.setParameter('arrTable',(JSON.stringify(myRows)));
    window.open(resourceURL.toString());
});
</aui:script>







