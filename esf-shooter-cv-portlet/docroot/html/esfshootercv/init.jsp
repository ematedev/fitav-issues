<%@ include file="/html/init.jsp" %>

<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@page import="com.ethica.esf.cv.util.ESFConstantsCV"%>
<%@page import="com.ethica.esf.cv.util.ManageDate"%>
<%@page import="it.ethica.esf.service.ESFNationalLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFNational"%>
<%@page import="it.ethica.esf.service.CityLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.City"%>
<%@page import="it.ethica.esf.service.persistence.CityPK"%>
<%@page import="it.ethica.esf.service.ProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.Province"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatchResult"%>
<%@page import="it.ethica.esf.service.ESFMatchResultLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="it.ethica.esf.model.ESFNationalMatchResult"%>
<%@page import="it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="it.ethica.esf.service.RegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualificationESFMatch"%>
<%@page import="it.ethica.esf.model.ESFCountry"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="it.ethica.esf.service.RegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.RegionLocalService"%>
<%@page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@page import="com.liferay.portal.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategoryESFMatch"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualification"%>

<portlet:renderURL var="backUrl">
			<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</portlet:renderURL>


<%

long esfUserId = user.getUserId(); 
ESFCard esfCard =null;
try{

	esfCard = ESFCardLocalServiceUtil.getEsfCardByEsfUserId(esfUserId);
}
catch (Exception e){
	System.out.println ("user no card:"+e.toString());
}

%>