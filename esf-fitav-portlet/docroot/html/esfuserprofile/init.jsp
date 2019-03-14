
<%@include file="/html/init.jsp"%>

<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCountry"%>
<%@page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalService"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.Province"%>
<%@page import="it.ethica.esf.service.persistence.ProvincePK"%>
<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@page import="it.ethica.esf.service.CityLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.City"%>
<%@page import="it.ethica.esf.service.persistence.CityPK"%>
<%@page import="it.ethica.esf.model.Region"%>
<%@page import="it.ethica.esf.service.persistence.RegionPK"%>
<%@page import="it.ethica.esf.service.RegionLocalServiceUtil"%>


<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>


<%@page import="it.ethica.esf.model.ESFAddress"%><%@
page import="java.util.List"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="com.liferay.portal.service.ImageLocalServiceUtil"%><%@
page import="com.liferay.portal.theme.ThemeDisplay"%><%@
page import="it.ethica.esf.model.ESFUser"%><%@
page import="com.liferay.portal.model.PortletPreferences"%>

<%
	/*Eseguo il get dalle preferences per confrontarle dopo per vedere se abilitare o meno la modifica dei campi selezionati dall'utente */
	boolean updateFirstName_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateFirstName",
					StringPool.FALSE));
	boolean updateLastName_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateLastName",
					StringPool.FALSE));
	boolean updateGender_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateGender",
					StringPool.FALSE));
	boolean updateYearBirth_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateYearBirth",
					StringPool.FALSE));
	boolean updatePlaceBirth_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updatePlaceBirth",
					StringPool.FALSE));
	boolean updateResidence_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateResidence",
					StringPool.FALSE));
	boolean updateHeight_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateHeight",
					StringPool.FALSE));
	boolean updateWeight_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateWeight",
					StringPool.FALSE));
	boolean updateMaritalStatus_view = GetterUtil
			.getBoolean(portletPreferences.getValue(
					"updateMaritalStatus", StringPool.FALSE));
	boolean updateChildren_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateChildren",
					StringPool.FALSE));
	boolean updateHigherEducation_view = GetterUtil
			.getBoolean(portletPreferences.getValue(
					"updateHigherEducation", StringPool.FALSE));
	boolean updateProfession_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateProfession",
					StringPool.FALSE));
	boolean updateLanguages_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateLanguages",
					StringPool.FALSE));
	boolean updateHandedness_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateHandedness",
					StringPool.FALSE));
	boolean updateMasterEye_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateMasterEye",
					StringPool.FALSE));
	boolean updateOther_view = GetterUtil.getBoolean(portletPreferences
			.getValue("updateOther", StringPool.FALSE));
	boolean updateHobbies_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateHobbies",
					StringPool.FALSE));
	boolean updateComments_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateComments",
					StringPool.FALSE));
	boolean updateTShirt_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateTShirt",
					StringPool.FALSE));
	boolean updatePants_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updatePants",
					StringPool.FALSE));
	boolean updateHat_view = GetterUtil
			.getBoolean(portletPreferences.getValue("updateHat",
					StringPool.FALSE));
	boolean enableSubmit_view = false;
	if ((updateFirstName_view) || (updateLastName_view)
			|| (updateGender_view) || (updateYearBirth_view)
			|| (updatePlaceBirth_view) || (updateResidence_view)
			|| (updateHeight_view) || (updateWeight_view)
			|| (updateMaritalStatus_view) || (updateChildren_view)
			|| (updateHigherEducation_view) || (updateProfession_view)
			|| (updateLanguages_view) || (updateHobbies_view)
			|| (updateHandedness_view) || (updateMasterEye_view)
			|| (updateOther_view) || (updateComments_view) || (updateHat_view)
			|| (updatePants_view) || (updateTShirt_view))
		enableSubmit_view = true;
%>

<%
	/* Get dell'utente attualmente loggato */
	ESFUser utente =null;
	String userProfession="";
	long userId = 0;
	try{
		themeDisplay = (ThemeDisplay) request
			.getAttribute(WebKeys.THEME_DISPLAY);
		userId=themeDisplay.getUserId();
		System.out.println("Il mio userId e': "+userId
				+" e sto per gettare l'utente di questo id");
		utente = ESFUserLocalServiceUtil.getESFUser(userId);
		System.out.println("Utente get-tato");
		userProfession = utente.getJobTitle();
		System.out.println("user Profession: "+userProfession);
	}
	catch(Exception e){e.printStackTrace();}

	/* get delle chiavi di ricerca per le tabelle */
	long companyId = themeDisplay.getCompanyId();
	System.out.println("company id: "+companyId);
	String className = ESFUser.class.getName();
	System.out.println("class name: "+className);
	long classPK = utente.getPrimaryKey();
	System.out.println("classPK: "+classPK);

	/* Get di tutte le regioni */
	List<ESFRegion> regions = null;
	try {
		regions = ESFRegionLocalServiceUtil.getESFRegions(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	/* Get di tutte le nazioni */
	List<ESFCountry> countries=null;
	try{
		countries=ESFCountryLocalServiceUtil.getESFCountries(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch(Exception e){e.printStackTrace();}
	/* Get di tutte le citta' */
	List<ESFCity> cities = null;
	try {
		cities = ESFCityLocalServiceUtil.getESFCities(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	/* Get di tutte le province' */
	List<ESFProvince> provinces = null;
	try {
		provinces = ESFProvinceLocalServiceUtil.getESFProvinces(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}

	/*Get dell'indirizzo dell'utente loggato al momento */
	List<ESFAddress> addresses = null;
	String city="", street1="", country="", province="", region="", zip="";
	String countryId="", regionId="", provinceId="";
	long cityId = 0;
	try {
		addresses = ESFAddressLocalServiceUtil.getESFAddresses(
				companyId, className, classPK);
		for (ESFAddress a : addresses) {
			street1 = a.getStreet1();
			zip = a.getZip();
			countryId = a.getEsfCountryId();
			country = ESFCountryLocalServiceUtil.fetchESFCountry(
					countryId).getName();
			regionId=a.getEsfRegionId();
			provinceId = a.getEsfProvinceId();
			cityId = a.getEsfCityId();
			RegionPK regionPK=new RegionPK(regionId,countryId);
			Region region1 = RegionLocalServiceUtil.getRegion(regionPK);
			region=region1.getName();
			ProvincePK provincePK=new ProvincePK(provinceId,regionId,countryId);
			Province province1=ProvinceLocalServiceUtil.getProvince(provincePK);
			province=province1.getName();
			CityPK cityPK=new CityPK(cityId,provinceId,regionId,countryId);
			City city1 =CityLocalServiceUtil.getCity(cityPK);
			city=city1.getName();
			/* province = ESFProvinceLocalServiceUtil
			.findByProvinceId(provinceId).get(0).getName(); */
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	/* Get delle informazioni sul sesso dell'utente loggato */
	String genderUser = "M";
	if (themeDisplay.getLocale().toString().equals("en_US")) {
		if (user.getFemale())
			genderUser = "W";
	} else if (user.getFemale())
		genderUser = "F";
%>

<!--  Get della data con lo script bellino bellino (?) -->
<%
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String birthday = "";
	if (utente != null && utente.getBirthday() != null)
		birthday = ManageDate.DateToString(utente.getBirthday());
%>
<aui:script>
	$(function() {
		$("#<portlet:namespace/>birthday").datepicker();
		$("#<portlet:namespace/>birthday")
			.datepicker("option", "dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>birthday")
			.datepicker("setDate", '<%= birthday %>');
	});
</aui:script>

<!-- 
	/* codice abortito o da copia incollare (?) */

	// 	for (ESFAddress a : addresses) {

	//		regionId = a.getEsfRegionId();
	//		countryId = a.getEsfCountryId();
	//		provinceId = a.getEsfProvinceId();
	//		cityId = a.getEsfCityId();
	//		province = ESFAddressLocalServiceUtil.getNameProvince(regionId,
	//				provinceId);
	//		regionName = ESFAddressLocalServiceUtil.getNameRegion(regionId);
	//		city = ESFAddressLocalServiceUtil.getNameCity(regionId,
	//				provinceId, cityId);
	//		ESFCountry obj = ESFCountryLocalServiceUtil
	//				.getESFCountry(countryId);
	//		country = obj.getName();

	//		street1 = addresses.getStreet1();
	//		zip = addresses.getZip();
	//	}

	/* ESFAddress add=ESFAddressLocalServiceUtil.g */
	/* ESFRegion region1=ESFRegionLocalServiceUtil. */

	/* 
	 country = a.getCountry().getName();
	 city = a.getCity();
	 region = a.getRegion().getName();
	 street1 = a.getStreet1();
	 zip = a.getZip();
	 }  */
-->