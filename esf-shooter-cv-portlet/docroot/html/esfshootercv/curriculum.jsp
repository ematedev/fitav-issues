
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@ include file="init.jsp" %>



<% 
	ESFUser esfUser =null;
	if (esfUserId > 0){
		esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
	}
	
	/* get delle chiavi di ricerca per le tabelle */
	long companyId = themeDisplay.getCompanyId();
	String className = ESFUser.class.getName();
	long classPK = esfUser.getEsfUserId();
	/*Get dell'indirizzo dell'utente loggato al momento */
	List<ESFAddress> addresses = null;
	String city=StringPool.BLANK, street1=StringPool.BLANK;
	String country=StringPool.BLANK, regionAbbr=StringPool.BLANK;
	String region=StringPool.BLANK, zip=StringPool.BLANK;
	String province = StringPool.BLANK;
	long countryId=0, provinceId=0;
	String regionId;
	long cityId = 0;
	try {
		addresses = ESFAddressLocalServiceUtil.getESFAddresses(companyId, className, classPK);
        ESFAddress address = null;
			for (ESFAddress a : addresses) {
				if (a.getListTypeId()==12038){
					address = a;
				}
				
			}
			street1 = address.getStreet1();
			zip = address.getZip();
			cityId = address.getEsfCityId();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	List<ESFCity> cities = ESFCityLocalServiceUtil.getESFCities(-1, -1);
	if (cities.size()>0){
		for (ESFCity cit : cities){
			if (cit.getIdCity()==cityId){
				city = cit.getName();
				province = cit.getIdProvince();
			}
		}
	}
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String birthday = StringPool.BLANK;
	if (esfUser != null && esfUser.getBirthday() != null)
		birthday = ManageDate.DateToString(esfUser.getBirthday());
	
	if (Validator.isNotNull(province)){
		province = " ("+province+")";
	}
	String userAddressLine1=(street1).toUpperCase();
	String userAddressLine2=(zip+"  "+city+"  "+province).toUpperCase();

	String code = StringPool.BLANK;
	
	try{
		code=  esfCard.getCode();
	}
	catch (Exception e){
		System.out.println ("user no card:"+e.toString());
	}
	List<ESFMatchResult> esfMatches = null;
	try {
	esfMatches = ESFMatchResultLocalServiceUtil.findByResultUserId(esfUserId);
	}
	catch (Exception e){
		
	}
	
	%>

<table id='tableAnagrafica' class="table-cv">
<tr>
<td> ** CURRICULUM: </td>
<td id='name_shooter'> <%= esfUser.getFirstName().toUpperCase() +" "+ esfUser.getLastName().toUpperCase() %>   </td> 								
<td id='birthday'> <%=birthday %> </td>
</tr>
<tr>
<td> </td>
<td id='address1'> <%=userAddressLine1 %> </td>
</tr>    
<tr> 
<td> </td>
<td id='address2'> <%=userAddressLine2%> </td>
<td> </td>
<td id='tessera'> Tessera: <%=code %> </td>
</tr>
</table>



</br>
</br>

<table class="table" id="noBold" >
<tr>
	<th> Descrizione Gara </th>
	<th> Data Da</th>
	<th> Data A</th>
	<th> Spec.</th>
	<th> I/S </th>
	<th> Cat.</th>
	<th> Qual.</th>
	<th> Posiz.</th>
	<th> Risult.</th>
	<th> Finale</th>
	<th> Spar.1</th>
	<th> Spar.2</th>
</tr>
<% 
	String speciality = StringPool.BLANK;
	String qualification = StringPool.BLANK;
for (ESFMatchResult emr : esfMatches){
	
	String label = StringPool.BLANK;
	String description = StringPool.BLANK ;
	int result = 0;
		
		ESFMatch esfMatch = ESFMatchLocalServiceUtil.getESFMatch(emr.getEsfMatchId());
		try{
		ESFDescription descr = ESFDescriptionLocalServiceUtil.getESFDescription(esfMatch.getDescription());
		description = descr.getDescription();
		ESFSportType spec = ESFSportTypeLocalServiceUtil.getESFSportType(esfMatch.getEsfSportTypeId());
		Map<String, String> specialita = ESFConstantsCV.spec;
		for(Map.Entry<String,String> entry : specialita.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
				if (spec.getName().equals(key)){
					speciality = value;
				}
		}
		result = emr.getFirst()+emr.getSecond()+emr.getThird()+emr.getFourth()+emr.getFifth();
		List<ESFShooterQualification> esfShooterQualifications =
				ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications();
		
		List<ESFShooterQualification> esfShooterQualificationsESFMatch =
				ESFShooterQualificationLocalServiceUtil.findByMatchId(esfMatch.getEsfMatchId());
		
		for (ESFShooterQualification esfShooterQualification : esfShooterQualificationsESFMatch) {
			label = esfShooterQualification.getName();
			Map<String, String> qualifications = ESFConstantsCV.qual;
			for(Map.Entry<String,String> entry : qualifications.entrySet()) {
				  String key1 = entry.getKey();
				  String value1 = entry.getValue();
					if (label.equalsIgnoreCase(key1)){
						qualification = value1;
					}
			}
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		
%>	
<tr>
	<td> <%= description %> </td> 
	<td> <%= ManageDate.DateToString(esfMatch.getStartDate())%> </td>
	<td> <%= ManageDate.DateToString(esfMatch.getEndDate()) %> </td>
	<td> <%= speciality %></td>
	<td> <%= (esfMatch.getIsTeamMatch()? ESFConstantsCV.TEAM_MATCH : StringPool.BLANK) %> </td>
	<td> <%= emr.getCategoryName() %> </td>
	<td><%=qualification %> </td>
	<td> <%=emr.getCategoryClassPosition() %></td>
	<td> <%=result %> </td>
	<td> <%=emr.getNextTotalPlayOff() %></td>
	<td> </td>
	<td> </td> 
</tr>
	<% }
		%>
</table>
			
			
</br>
</br>


<div>	<h5><b> Legenda Qualifica :</b></h5>  JL = Junior Lady;  L= Ladies;  </div>

<div>	<h5><b> Legenda Specialita' :</b></h5>  DT = Double Trap; EL = Elica;  FO = Fossa Olimpica;
											FU = Fossa Universale;  PC = Percorso Caccia;  PT = Percorso Caccia In Pedana;  SK = Skeet
</div>			
</br>	
<aui:button-row>	
<aui:button onClick="<%= backUrl %>" type="cancel" value ="back"> </aui:button>	

<aui:button value="PDF" onclick="ajaxCall('pdf')"/> 

<aui:button value="EXCEL"  onclick="ajaxCall('xls')"/>

</aui:button-row>

<aui:script use="liferay-portlet-url">
Liferay.provide(window,'ajaxCall',function(type){
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('reportType', type);

	//costruzione json da inviare per la costruzione del cv in PDF
	var table1 =  [] ;
   //costruzione json della tabella1
    var obj = {};
	$('#tableAnagrafica td[id]').each(function(i, td){
	    	    obj[$(this).attr('id')] = ($(this).text()).trim();
	});
	table1.push(obj);
	console.log(table1);
	resourceURL.setParameter('arrTable1',(JSON.stringify(table1)));
	
	
	var table2 =  [] ;
	
	   //costruzione json della tabella2
		var $th = $('#noBold th');
		$('#noBold tr').each(function(i, tr){
		var obj = {},$tds = $(this).find('td');
		$th.each(function(index, th){
	    	    	 obj[($(th).text()).trim()] = ($tds.eq(index).text()).trim();
	    	
		});
	    table2.push(obj);
		    
		});
	console.log(table2);
	resourceURL.setParameter('arrTable2',(JSON.stringify(table2)));
	
    window.open(resourceURL.toString());
});

</aui:script>

		 