<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCatridge"%>
<%@page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%>
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
	String orgUser = StringPool.BLANK;
	

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

	String speciality = StringPool.BLANK;
	String qualification = StringPool.BLANK;

	String cityOrg = StringPool.BLANK;
	String provinceOrg = StringPool.BLANK;
	try{
		Organization o = OrganizationLocalServiceUtil.fetchOrganization(esfCard.getEsfOrganizationId());
		try {
		
		Address orgA = AddressLocalServiceUtil.getAddress(o.getAddress().getAddressId());
		List<ESFCity> orgCities = ESFCityLocalServiceUtil.getESFCity(orgA.getCity());
		if (cities.size()>0){
			for (ESFCity cit : cities){
				if (cit.getName().equals(orgA.getCity())){
					cityOrg = cit.getName();
					provinceOrg = cit.getIdProvince();
				}
				
			}
		}
		
		}catch (Exception e){
			System.out.println ("eccezione  indirizzo esfOrganization :"+e.toString());
		}
		if (Validator.isNotNull(cityOrg)){
			cityOrg = " -- " + cityOrg;
		}
		if (Validator.isNotNull(provinceOrg)){
			provinceOrg = " ("+provinceOrg+")";
		}
		orgUser+=o.getName()+cityOrg+provinceOrg;
		
	}
	catch (Exception e){
		System.out.println ("eccezione esfOrganization :"+e.toString());
	}

	
	String catridgeUser = StringPool.BLANK;
	try {
		List <ESFCatridge> catridges = ESFCatridgeLocalServiceUtil.getESFCatridgesByUserId(esfUser.getEsfUserId());
	for (int i=0;i<catridges.size();i++){
		ESFCatridge cat = catridges.get(i);
		if (i==catridges.size()-1){
			catridgeUser+=cat.getCatridgeModel();
		}
		else{
			catridgeUser+=cat.getCatridgeModel()+", ";
		}
	}
	
	} catch (Exception e){
		System.out.println ("eccezione ESFCatridge :"+e.toString());
	}
	
	String gunUser = StringPool.BLANK;
	List<ESFGun> gunsUser = ESFGunLocalServiceUtil.getESFGunsByUserId(esfUser.getEsfUserId());
	
	for (int i=0;i<gunsUser.size();i++){
		ESFGun gun = gunsUser.get(i);
		if (i == gunsUser.size()-1){
			gunUser+=gun.getFullName();
		}
		else{
			gunUser+=gun.getFullName()+", ";
		}
	}
		
	List<ESFNationalMatchResult> esfMatches = null;
	
	try {
	esfMatches = ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchResultUserId(esfUserId);
	
	}
	catch (Exception e){
		System.out.println ("eccezione ESFNationaleMatchResult :"+e.toString());
	}
	
	
	String paese = StringPool.BLANK;
	
	String località = StringPool.BLANK;
	
	String matchDescription = StringPool.BLANK;
	%>
<%

List<ESFDescription> esfdescriptions = new ArrayList<ESFDescription>();
List<ESFMatch> gare = new ArrayList<ESFMatch>();
String cssHidden = "hidden";
try {
	esfdescriptions = (List<ESFDescription>)ESFDescriptionLocalServiceUtil.getESFDescriptionsByMatchUser(esfMatches);
	gare = (List<ESFMatch>)ESFMatchLocalServiceUtil.getAllEsfMatchByResults(esfMatches);
}
catch (Exception e){
	System.out.println("eccezione descr:"+e.toString());
	e.printStackTrace();
}
if (esfdescriptions.size()>0){
	cssHidden = StringPool.BLANK;
}

%>	
	

<div align="center">
	
<table class="table-cv" id="tableAnAzzurri">

<tr>
<td id='name_shooter'> <%= esfUser.getFirstName().toUpperCase() +" "+ esfUser.getLastName().toUpperCase() %>   </td> 								
</tr>
<tr>
<td id='address1'> <%=userAddressLine1 %> </td>
</tr>    
<tr> 
<td id='address2'> <%=userAddressLine2%> </td>
<td> </td>
</tr>

</table>

</br>
</br>


<%
String birthcity = "";
if(Validator.isNotNull(esfUser.getBirthcity())){
	birthcity =  esfUser.getBirthcity();
}
%>

<h3>  SCHEDA AZZURRI</h3>
<table class="table-cvAzzurri" id="tableAzzurri">
<tr> 
 <td> <b> Data e Luogo Di Nascita </b> </td>
 <td> <i><%= birthday+" - "+ birthcity %> </i> </td>
</tr>
<tr> 
 <td> <b> Professione </b> </td>
 <td> <i> <%= user.getJobTitle() %></i></td>
<tr> 
 <td> <b> Altri Sport </b> </td>
 <td> </td>
</tr>
<tr> 
 <td> <b> Hobby </b> </td>
 <td> </td>
</tr>
<tr> 
 <td> <b> Istruttori</b> </td>
 <td> </td>
</tr>
<tr> 
 <td> <b>Società D'Appartenenza</b> </td>
 <td> <i><%=orgUser %></i></td>
</tr>
<tr> 
 <td> <b> Carta Olimpica </b> </td>
 <td> </td>
</tr>
<tr> 
 <td> <b> Cartucce</b> </td>
 <td> <i> <%=catridgeUser %></i></td>
</tr>

<tr> 
  <td> <b> Fucile</b> </td>
  <td> <i> <%=gunUser %></i></td>
</tr>
</table>

	
	
	
<h3> MEDAGLIERE </h3>

<table id="table-medal" class="table cvMedagliere <%=cssHidden%>" >

<tr>
	<th class="noVisible">Descrizione </th>
	<th class="cvMedaglie"> Oro </th>
	<th class="cvMedaglie"> Argento </th>
	<th class="cvMedaglie"> Bronzo</th>
	<th>  </th>
	<th class="noVisible"> Anno</th>
	<th class="noVisible"> Qualificazione </th>
	<th class="noVisible"> Tipologia</th>
	<th class="noVisible"> Località</th>
	<th class="noVisible"> Stato</th>
	<th class="noVisible"> Specialità</th>
	<th> </th>
</tr>
<%
Set<String> descriSet = new HashSet<String>();

for (ESFDescription ed : esfdescriptions){
	descriSet.add(ed.getDescription());	
}
for (String st : descriSet){
	int oroTot=0;
	int argentoTot=0;
	int bronzoTot=0;
	for (ESFNationalMatchResult emr : esfMatches){
		ESFMatch esfMatch = ESFMatchLocalServiceUtil.getESFMatch(emr.getEsfMatchId());
		ESFDescription descr = ESFDescriptionLocalServiceUtil.getESFDescription(esfMatch.getDescription());
		
		if (st.equals(descr.getDescription())){
			int medalO = emr.getGoldMedals();
			int medalA = emr.getSilverMedals();
			int medalB = emr.getBronzeMedals();
			oroTot+=medalO;
			argentoTot+=medalA;
			bronzoTot+=medalB;
			
		}
	}
	
%>
<tr>
	<td> <b> <%= st%> </b> </td>
	<td class="cvMedaglie"> <b> <%=String.valueOf(oroTot) %></b></td>
	<td class="cvMedaglie"> <b> <%=String.valueOf(argentoTot) %></b> </td>
	<td class="cvMedaglie"> <b> <%=String.valueOf(bronzoTot) %></b> </td>
	<td> </td>
	<td> </td>
	<td> </td>
	<td> </td>
	<td> </td>
	<td> </td>
	<td> </td>
	<td> </td>
</tr>
<% 
for    (ESFMatch esfMatch : gare){// (ESFNationalMatchResult emr : esfMatches){
		//ESFMatch esfMatch = ESFMatchLocalServiceUtil.getESFMatch(emr.getEsfMatchId());
		ESFNationalMatchResult emr = ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchByEsFMatchId(esfMatch.getEsfMatchId());
		ESFDescription descr = ESFDescriptionLocalServiceUtil.getESFDescription(esfMatch.getDescription());
		ESFMatchType esfMatchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(esfMatch.getEsfMatchTypeId());
		if (st.equals(descr.getDescription())){
		int medalO = emr.getGoldMedals();
		int medalA = emr.getSilverMedals();
		int medalB = emr.getBronzeMedals();
		ESFSportType spec = ESFSportTypeLocalServiceUtil.getESFSportType(esfMatch.getEsfSportTypeId());
		Map<String, String> specialita = ESFConstantsCV.spec;
		for(Map.Entry<String,String> entry : specialita.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
				if (spec.getName().equals(key)){
					speciality = value;
				}
		}
		Country c = CountryServiceUtil.fetchCountry(esfMatch.getCountryId());
		List<ESFShooterQualification> esfShooterQualifications =
				ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications();
		
		List<ESFShooterQualification> esfShooterQualificationsESFMatch =
				ESFShooterQualificationLocalServiceUtil.findByMatchId(esfMatch.getEsfMatchId());
		String label = StringPool.BLANK;
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
		
		if(Validator.isNotNull(c)){
			paese = c.getA3();
		}
		if(Validator.isNotNull(esfMatch.getNotNationalAssotiation())){
			località = esfMatch.getNotNationalAssotiation();
		}
		
		if (Validator.isNotNull(esfMatchType)){
			matchDescription = esfMatchType.getDescription();
		}
%>	
<tr id='tr-medal-data'>
	<td class="cvMed"><span class="noVis"> <%=st+" - "%> </span> <%=matchDescription %> </td>
	<td class="cvMedaglie"> <%=(medalO==0) ? "" : String.valueOf(medalO) %> </td>
	<td class="cvMedaglie"> <%=(medalA==0) ? "" : String.valueOf(medalA)%> </td>
	<td class="cvMedaglie"> <%=(medalB==0) ? "" : String.valueOf(medalB) %></td>
	<td> </td>
	<td><%= ManageDate.getYear(esfMatch.getStartDate()) %> </td>
	
	<td> <%=qualification %></td>

	<td> <%= (esfMatch.getIsTeamMatch()? ESFConstantsCV.TEAM_MATCH : ESFConstantsCV.INDIVIDUAL_MATCH) %></td>
	
	<td>  <%= località %></td>

	<td> <%= paese %></td>
	
	
	<td> <%= speciality %></td>

	<td> </td> 
</tr>

	<%
	}
}	
}
%>
</table>
		
</div>	

</br>
</br>

<div>	<h5><b> Legenda Qualifica :</b></h5>  JL = Junior Lady;  L= Ladies;  </div>

<div>	<h5><b> Legenda Specialita' :</b></h5>  DT = Double Trap; EL = Elica;  FO = Fossa Olimpica;
											FU = Fossa Universale;  PC = Percorso Caccia;  PT = Percorso Caccia In Pedana;  SK = Skeet
</div>			
</br>

<aui:button-row>
<aui:button onClick="<%= backUrl %>" type="cancel" value ="back"/>
<aui:button value="PDF" onclick="ajaxCall('pdf')"/> 

<aui:button value="EXCEL"  onclick="ajaxCall('xls')"/>
</aui:button-row>


<aui:script use="liferay-portlet-url">
Liferay.provide(window,'ajaxCall',function(type){
	var resourceURL = Liferay.PortletURL.createResourceURL();
	resourceURL.setPortletId('<%=PortalUtil.getPortletId(request)%>');
	resourceURL.setParameter('reportType', type);
	resourceURL.setParameter('cvType', "azzurri");
	var table1 =  [] ;
   //costruzione json della tabella1
    var obj = {};
	$('#tableAnAzzurri td[id]').each(function(i, td){
	    	    obj[$(this).attr('id')] = ($(this).text()).trim();
	});
	table1.push(obj);
	console.log(table1);
	resourceURL.setParameter('arrTable1',(JSON.stringify(table1)));
	
	
	
	var table2 =  [] ;
	
	   //costruzione json della tabella2
		$('#tableAzzurri tr').each(function(i, tr){
		var obj = {},$tds = $(this).find('td');
	    obj[($tds.eq(0).text()).trim()] = ($tds.eq(1).text()).trim();
	  
	    table2.push(obj);
		    
		});
	console.log(table2);
	resourceURL.setParameter('arrTable2',(JSON.stringify(table2)));
	
	var table3 =  [] ;
	
	//costruzione json della tabella3
	$('#table-medal tr[id]').each(function(i, tr){
		var obj = {};
		var $tds = $(this).find('td');
		$('#table-medal th').each(function(k,th){
		        
		    	obj[($(th).text()).trim()] = ($tds.eq(k).text()).trim();
		    
		});  
		table3.push(obj);
	});
		
	console.log(table3);
	
	resourceURL.setParameter('arrTable3',(JSON.stringify(table3)));
	
    window.open(resourceURL.toString());
});
</aui:script>

		 