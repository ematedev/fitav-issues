<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>
<%@page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFGunLocalService"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="it.ethica.esf.service.ESFDocumentLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDocument"%>
<%@page import="com.liferay.portal.service.ListTypeService"%>
<%@page import="it.ethica.esf.service.ESFPhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="it.ethica.esf.model.ESFPhone"%>
<%@page import="it.ethica.esf.service.persistence.ESFProvincePK"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@page import="it.ethica.esf.service.persistence.ESFCityPK"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@include file="init.jsp"%>

<%
ResultRow row =
	(ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ESFUser esfUser = (ESFUser) row.getObject();
User liferayUser = UserLocalServiceUtil.getUser(esfUser.getEsfUserId());

/* Retriving user postal address */

ESFAddress esfUserPostalAddress = null;
Contact userContact = liferayUser .getContact();

List <Address> userAddresses = AddressLocalServiceUtil.getAddresses(liferayUser.getCompanyId(), 
	ESFUser.class.getName(), esfUser.getEsfUserId()) ;

for(Address a : userAddresses){
		ESFAddress ea = null;
		long addressId =0;
		try 
		{
			addressId = a.getAddressId();
			ea = ESFAddressLocalServiceUtil.getESFAddress(a.getAddressId());
		}
		catch (Exception e)
		{
			ea = null;
			addressId = 0;
		}
		if(addressId != 0 && ea != null){
			ESFAddress esfAddressTemp = ESFAddressLocalServiceUtil.getESFAddress(a.getAddressId());
			
			if(Validator.isNotNull(esfAddressTemp.getType())){
				if(esfAddressTemp.getType().equals(ESFKeys.ESFAddressType.POSTAL) ){
					esfUserPostalAddress = ESFAddressLocalServiceUtil.getESFAddress(a.getAddressId());
			}
		}
	}
}
liferayUser.getAddresses();
String namespace = renderResponse.getNamespace();

/*------------User general info----------*/

String firstName = esfUser.getFirstName();
String lastName = esfUser.getLastName();
String placeOfBirth = esfUser.getBirthcity();
String dateOfBirth = ManageDate.DateToString(esfUser.getBirthday());

/*---------------User address info--------------*/
/*In case user postal address is null*/
String residenceCity = "";
String province = "";
String zip = "";
String address = "";
/*In case user postal address is NOT null*/
if(Validator.isNotNull(esfUserPostalAddress)){
	if(esfUserPostalAddress.getEsfCityId() > 0){
		/*ESFCity primary key creation*/
		ESFCityPK esfCityPk = ESFCityPK.class.newInstance();
		
		if(Validator.isNotNull(esfUserPostalAddress.getEsfCityId())){
			esfCityPk.setIdCity(esfUserPostalAddress.getEsfCityId());
		}
		if(Validator.isNotNull(esfUserPostalAddress.getEsfRegionId())){
			esfCityPk.setIdRegion(esfUserPostalAddress.getEsfRegionId());
		}
		if(Validator.isNotNull(esfUserPostalAddress.getEsfCountryId())){
			esfCityPk.setIdCountry(esfUserPostalAddress.getEsfCountryId());
		}
		if(Validator.isNotNull(esfUserPostalAddress.getEsfProvinceId())){
			esfCityPk.setIdProvince(esfUserPostalAddress.getEsfProvinceId());
		}
		
		ESFCity city = ESFCityLocalServiceUtil.fetchESFCity(esfCityPk);
		
		if(Validator.isNotNull(city)){
			residenceCity = city.getName();
		}
		
		if(Validator.isNotNull(esfUserPostalAddress.getEsfProvinceId()) &&
											Validator.isNotNull(city)){
			ESFProvincePK esfProvincePK = ESFProvincePK.class.newInstance();
			
			if(Validator.isNotNull(city.getIdCountry())){
				esfProvincePK.setIdCountry(city.getIdCountry());
			}
			if(Validator.isNotNull(city.getIdProvince())){
				esfProvincePK.setIdProvince(city.getIdProvince());
			}
			if(Validator.isNotNull(city.getIdRegion())){
				esfProvincePK.setIdRegion(city.getIdRegion());
			}
			ESFProvince esfProvince = ESFProvinceLocalServiceUtil.fetchESFProvince(esfProvincePK);
			
			if(Validator.isNotNull(esfProvince)){
				province = esfProvince.getName();
			}
		}
		
		if(Validator.isNotNull(city) && Validator.isNotNull(city.getZip())){
			zip = esfUserPostalAddress.getZip();
		}
		
		if(Validator.isNotNull(esfUserPostalAddress.getStreet1())){
			
			address = esfUserPostalAddress.getStreet1();
		}
		
	}
}

/*User contact info*/

String phoneNumber = "";

List<Phone> userPhones = PhoneLocalServiceUtil.getPhones(
							liferayUser.getCompanyId(),ESFUser.class.getName(), 
							esfUser.getEsfUserId());

for(Phone p : userPhones){
	ESFPhone esfUserPhone = ESFPhoneLocalServiceUtil.getESFPhone(p.getPhoneId());
	long phoneType = esfUserPhone.getListTypeId();
	if(Validator.isNotNull(phoneType)){
		if(phoneType == ESFKeys.ESFPhoneListType.MOBILE){
			phoneNumber = p.getNumber();
		}
	}
}

String email = "";

if(Validator.isNotNull(liferayUser.getContact()) && 
				Validator.isNotNull(liferayUser.getContact().getEmailAddress())){
	email = liferayUser.getContact().getEmailAddress();
}

String fiscalCode = "";
//String maritialStatus = user.getM;
if(Validator.isNotNull(esfUser.getFiscalCode())){
	fiscalCode = esfUser.getFiscalCode();
}

/*User documents info*/

String releasedBy = "";
String passportReleaseDate = "";
String passportExpirationDate = "";
String passport = "";
String europeanCardNumber = "";
String europeanCardReleaseDate = "";
String europeanCardExpirationDate = "";
String gunLicenceNumber = "";
String gunLicenceReleaseDate = "";
String gunLicenceExpirationDate = "";


ESFDocument esfPassport = null;
ESFDocument esfGunLicence = null;
ESFDocument esfEuropeanCard = null;

List<ESFDocument> esfDocuments = null;
esfDocuments = ESFDocumentLocalServiceUtil.findByT_U(
											ESFKeys.ESFDocumentType.PASSPORT,
											esfUser.getEsfUserId());
if(Validator.isNotNull(esfDocuments) && esfDocuments.size() > 0){
	esfPassport = esfDocuments.get(0);
}
esfDocuments = null;

esfDocuments = ESFDocumentLocalServiceUtil.findByT_U(
											ESFKeys.ESFDocumentType.GUNLICENCE,
											esfUser.getEsfUserId());

if(Validator.isNotNull(esfDocuments) && esfDocuments.size() > 0){
	esfGunLicence = esfDocuments.get(0);
}

esfDocuments = null;

esfDocuments = ESFDocumentLocalServiceUtil.findByT_U(
											ESFKeys.ESFDocumentType.EUROPEANCARD,
											esfUser.getEsfUserId());

if(Validator.isNotNull(esfDocuments) && esfDocuments.size() > 0){
	esfEuropeanCard = esfDocuments.get(0);
}

if(Validator.isNotNull(esfPassport)){
	passport = esfPassport.getCode();
	passportReleaseDate = ManageDate.DateToString(esfPassport.getReleaseDate());
	releasedBy = esfPassport.getReleasedBy();
	passportExpirationDate = ManageDate.DateToString(esfPassport.getExpirationDate());
	passportReleaseDate = ManageDate.DateToString(esfPassport.getReleaseDate());
}

if(Validator.isNotNull(esfGunLicence)){
	gunLicenceNumber = esfGunLicence.getCode();
	gunLicenceExpirationDate = ManageDate.DateToString(esfGunLicence.getExpirationDate());
	gunLicenceReleaseDate = ManageDate.DateToString(esfGunLicence.getReleaseDate());
}

if(Validator.isNotNull(esfEuropeanCard)){
	europeanCardNumber = esfEuropeanCard.getCode();
	europeanCardExpirationDate = ManageDate.DateToString(esfEuropeanCard.getExpirationDate());
	europeanCardReleaseDate = ManageDate.DateToString(esfEuropeanCard.getReleaseDate());
}

/*-----------------------User gun info-----------------------------------------*/
String firstGunType = "";
String firstGunExtraCanes = "";
String firstGunKind = "";
String firstGunCaliber = "";
String firstGunCode = "";
String secondGunType = "";
String secondGunKind = "";
String secondGunCaliber = "";
String secondGunCode = "";
String secondGunExtraCanes = "";
String firstGunTypeId = "";
String firstGunKindId = "";
String secondGunTypeId = "";
String secondGunKindId = "";
String isPortalUser = "true";

List<ESFGun> esfUserGuns = ESFGunLocalServiceUtil.getESFGunsByUserId(esfUser.getEsfUserId());
List<ESFGun> userFavoriteGuns = new ArrayList<ESFGun>();

for(ESFGun esfGun :esfUserGuns ){
	if(Validator.isNotNull(esfGun.getIsFavoriteGun()) && esfGun.getIsFavoriteGun()){
		userFavoriteGuns.add(esfGun);
	}
}

if(userFavoriteGuns.size() > 0){
	
	ESFGun esfFirstGun = userFavoriteGuns.get(0);
	
	/*
	if(Validator.isNotNull(esfFirstGun.getCanesExtra())){
		firstGunExtraCanes = esfFirstGun.getCanesExtra();
	}
	*/
	firstGunCode = esfFirstGun.getCode();
	if(Validator.isNotNull(esfFirstGun.getEsfGunKindId())){
		
		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKind(
								esfFirstGun.getEsfGunKindId());
		
		if(Validator.isNotNull(esfGunKind)){
		
			firstGunKindId = String.valueOf(esfGunKind.getEsfGunKindId());
			
			ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(
														esfGunKind.getEsfGunTypeId());
			
			if(Validator.isNotNull(esfGunType)){

				firstGunTypeId = String.valueOf(esfGunType.getEsfGunTypeId());
				
				firstGunType = esfGunType.getName();
				firstGunKind = esfGunKind.getName();
			
				firstGunCaliber = String.valueOf(esfGunKind.getCaliber());
			}
		}	
	}
	if(userFavoriteGuns.size() >= 2){
		ESFGun esfSecondGun = userFavoriteGuns.get(1);
		/*
		if(Validator.isNotNull(esfSecondGun.getCanesExtra())){
			secondGunExtraCanes = esfSecondGun.getCanesExtra();
		}*/
		secondGunCode = esfSecondGun.getCode();
		
		if(Validator.isNotNull(esfSecondGun.getEsfGunKindId())){
			
			ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKind(
									esfSecondGun.getEsfGunKindId());
			
			if(Validator.isNotNull(esfGunKind)){
				
				secondGunKindId = String.valueOf(esfGunKind.getEsfGunKindId());
				
				ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(
															esfGunKind.getEsfGunTypeId());
				if(Validator.isNotNull(esfGunType)){
				
					secondGunTypeId = String.valueOf(esfGunType.getEsfGunTypeId());
					
					secondGunType = esfGunType.getName();
					secondGunKind = esfGunType.getName();
					secondGunCaliber = String.valueOf(esfGunKind.getCaliber());
				}
			}
		}
	}

}

if(/*esfUserGuns.size() == 1 || */esfUserGuns.size() >= 1 && userFavoriteGuns.size() == 0){
	ESFGun esfUserGun = esfUserGuns.get(0);
	/*
	if(Validator.isNotNull(esfUserGun.getCanesExtra())){ 
		firstGunExtraCanes = esfUserGun.getCanesExtra();
	}
	*/
	firstGunCode = esfUserGun.getCode();
	if(Validator.isNotNull(esfUserGun.getEsfGunKindId())){
		
		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKind(
													esfUserGun.getEsfGunKindId());
		
		if(Validator.isNotNull(esfGunKind)){
		
			firstGunKindId = String.valueOf(esfGunKind.getEsfGunKindId());
			
			ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(
														esfGunKind.getEsfGunTypeId());
			
			if(Validator.isNotNull(esfGunType)){
			
				firstGunTypeId = String.valueOf(esfGunType.getEsfGunTypeId());
				
				firstGunType = esfGunType.getName();
				firstGunKind = esfGunKind.getName();
			
				firstGunCaliber = String.valueOf(esfGunKind.getCaliber());
			}
		}	
	}	
}

List<ESFGun> userNotFavoriteGuns = new ArrayList<ESFGun>();
for(ESFGun e : esfUserGuns){
	if(Validator.isNotNull(e.getIsFavoriteGun()) && !e.getIsFavoriteGun()){
		userNotFavoriteGuns.add(e);
	}
}

if(esfUserGuns.size() >= 2){
	
	ESFGun esfUserGun = esfUserGuns.get(1);
	if(userFavoriteGuns.size() == 1 && userNotFavoriteGuns.size() > 0){
		esfUserGun = userNotFavoriteGuns.get(0);
	}
	/*
	if(Validator.isNotNull(esfUserGun.getCanesExtra())){
		secondGunExtraCanes = esfUserGun.getCanesExtra();
	}*/
	secondGunCode = esfUserGun.getCode();
	
	if(Validator.isNotNull(esfUserGun.getEsfGunKindId())){
		
		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil.getESFGunKind(
												esfUserGun.getEsfGunKindId());
		
		if(Validator.isNotNull(esfGunKind)){
			
			secondGunKindId = String.valueOf(esfGunKind.getEsfGunKindId());
			
			ESFGunType esfGunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(
														esfGunKind.getEsfGunTypeId());
			if(Validator.isNotNull(esfGunType)){
			
				secondGunTypeId = String.valueOf(esfGunType.getEsfGunTypeId());
				
				secondGunType = esfGunType.getName();
				secondGunKind = esfGunType.getName();
				secondGunCaliber = String.valueOf(esfGunKind.getCaliber());
			}
		}
	}
}

String esfUserId = String.valueOf(esfUser.getEsfUserId());

%>

<button id='<%= namespace + "sendUser" + esfUserId%>'
	class="btn btn-small"
	firstName = "<%=firstName %>"
	lastName = "<%=lastName%>"
	placeOfBirth = "<%= placeOfBirth %>"
	dateOfBirth = "<%= dateOfBirth %>"
	residenceCity = "<%= residenceCity %>"
	province = "<%= province %>"
	zip = "<%= zip %>"
	address = "<%= address %>"
	phoneNumber = "<%= phoneNumber %>"
	email = "<%= email %>"
	fiscalCode = "<%= fiscalCode %>"
	releasedBy = "<%= releasedBy %>"
	passportReleaseDate ="<%= passportReleaseDate %>"
	passportExpirationDate = "<%= passportExpirationDate %>"
	passport = "<%= passport %>"
	europeanCardNumber = "<%= europeanCardNumber %>"
	europeanCardReleaseDate = "<%= europeanCardReleaseDate %>"
	europeanCardExpirationDate = "<%= europeanCardExpirationDate %>"
	gunLicenceNumber = "<%= gunLicenceNumber %>"
	gunLicenceReleaseDate = "<%= gunLicenceReleaseDate %>"
	gunLicenceExpirationDate = "<%= gunLicenceExpirationDate %>"
	firstGunType = "<%= firstGunType %>"
	firstGunExtraCanes = "<%= firstGunExtraCanes %>"
	firstGunKind = "<%= firstGunKind %>"
	firstGunCaliber = "<%= firstGunCaliber %>"
	firstGunCode = "<%= firstGunCode %>"
	secondGunType = "<%= secondGunType %>"
	secondGunKind = "<%= secondGunKind %>"
	secondGunCaliber = "<%= secondGunCaliber %>"
	secondGunCode = "<%= secondGunCode %>"
	secondGunExtraCanes = "<%= secondGunExtraCanes %>"
	esfUserId = "<%=esfUserId%>"
	firstGunTypeId = "<%=firstGunTypeId%>"
	firstGunKindId = "<%=firstGunKindId%>"
	secondGunTypeId = "<%=secondGunTypeId%>"
	secondGunKindId = "<%=secondGunKindId%>"
	isPortalUser = "<%=isPortalUser%>"
	esfUserId = "<%= esfUser.getEsfUserId()%>">
	
	<liferay-ui:icon image="add" message="add" />
</button>

<aui:script use="aui-base,node">

A.one('#<portlet:namespace/>sendUser<%=esfUserId%>').on('click', function(event) {

	var dataId = event._currentTarget.getAttribute('dataid');
	var dataName = event._currentTarget.getAttribute('dataname');
	
	var firstName = event._currentTarget.getAttribute('firstName');
	var lastName = event._currentTarget.getAttribute('lastName');
	var placeOfBirth = event._currentTarget.getAttribute('placeOfBirth');
	var dateOfBirth = event._currentTarget.getAttribute('dateOfBirth');
	var residenceCity = event._currentTarget.getAttribute('residenceCity');
	var province = event._currentTarget.getAttribute('province');
	var zip = event._currentTarget.getAttribute('zip');
	var address = event._currentTarget.getAttribute('address');
	var phoneNumber = event._currentTarget.getAttribute('phoneNumber');
	var email = event._currentTarget.getAttribute('email');
	var fiscalCode = event._currentTarget.getAttribute('fiscalCode');
	var releasedBy = event._currentTarget.getAttribute('releasedBy');
	var passportReleaseDate = event._currentTarget.getAttribute('passportReleaseDate');
	var passportExpirationDate = event._currentTarget.getAttribute('passportExpirationDate');
	var passport = event._currentTarget.getAttribute('passport');
	var europeanCardNumber = event._currentTarget.getAttribute('europeanCardNumber');
	var europeanCardReleaseDate = event._currentTarget.getAttribute('europeanCardReleaseDate');
	var europeanCardExpirationDate = event._currentTarget.getAttribute('europeanCardExpirationDate');
	var gunLicenceNumber = event._currentTarget.getAttribute('gunLicenceNumber');
	var gunLicenceReleaseDate = event._currentTarget.getAttribute('gunLicenceReleaseDate');
	var gunLicenceExpirationDate = event._currentTarget.getAttribute('gunLicenceExpirationDate');
	var firstGunType = event._currentTarget.getAttribute('firstGunType');
	var firstGunExtraCanes = event._currentTarget.getAttribute('firstGunExtraCanes');
	var firstGunKind = event._currentTarget.getAttribute('firstGunKind');
	var firstGunCaliber = event._currentTarget.getAttribute('firstGunCaliber');
	var firstGunCode = event._currentTarget.getAttribute('firstGunCode');
	var secondGunType = event._currentTarget.getAttribute('secondGunType');
	var secondGunKind = event._currentTarget.getAttribute('secondGunKind');
	var secondGunCaliber = event._currentTarget.getAttribute('secondGunCaliber');
	var secondGunCode = event._currentTarget.getAttribute('secondGunCode');
	var secondGunExtraCanes = event._currentTarget.getAttribute('secondGunExtraCanes');
	var esfUserId = event._currentTarget.getAttribute('esfUserId');
	var firstGunTypeId = event._currentTarget.getAttribute('firstGunTypeId');
	var firstGunKindId = event._currentTarget.getAttribute('firstGunKindId');
	var secondGunTypeId = event._currentTarget.getAttribute('secondGunTypeId');
	var secondGunKindId = event._currentTarget.getAttribute('secondGunKindId');
	var isPortalUser = event._currentTarget.getAttribute('isPortalUser');
	var esfUserId =  event._currentTarget.getAttribute('esfUserId');
	Liferay.Util.getOpener().<portlet:namespace/>retrieveAssociation(firstName, 
				lastName, placeOfBirth, dateOfBirth, residenceCity, province, zip,
				address, phoneNumber, email, fiscalCode, releasedBy, passportReleaseDate,
				passportExpirationDate, passport, europeanCardNumber, europeanCardReleaseDate,
				europeanCardExpirationDate, gunLicenceNumber, gunLicenceReleaseDate, 
				gunLicenceExpirationDate, firstGunType, firstGunExtraCanes, firstGunKind,
				firstGunCaliber, firstGunCode, secondGunType, secondGunKind, secondGunCaliber,
				secondGunCode, secondGunExtraCanes, firstGunTypeId, firstGunKindId, 
				secondGunTypeId, secondGunKindId, isPortalUser, esfUserId);
});
</aui:script>
