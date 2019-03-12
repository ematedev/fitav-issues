<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@include file="/html/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="it.ethica.esf.service.CountryLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatch"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFRegion"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterQualification"%>
<%@page import="it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFMatchLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterCategory"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.service.ESFElectronicLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFElectronic"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFBrandLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFBrand"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFField"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFBrand"%>
<%@page import="it.ethica.esf.model.ESFUnitservice"%>
<%@page import="it.ethica.esf.service.ESFUnitserviceLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="it.ethica.esf.util.ESFListType"%>

 <%-- 
<portlet:defineObjects />
<liferay-theme:defineObjects /> 
--%>

<%

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

long esfOrganizationId = ParamUtil.getLong(request,
			"esfOrganizationId");

	ESFOrganization esfOrganization = null;

	if (esfOrganizationId > 0) {
		esfOrganization = ESFOrganizationLocalServiceUtil
				.getESFOrganization(esfOrganizationId);
	}
	//liste per il tab associazioni
	List<ESFRegion> regions = null;
	List<ESFProvince> provinces = null;
	List<ESFOrganization> organizations = null;
	List<ESFEntityState> assStatus = null;
	List<ESFSportType> sportTypes = null;
	List<ESFField> fields = null;
	List<ESFUnitservice> services = null;
	List<ESFState> states = null;
	
	//liste per il tab tiratore
	List<ESFOrganization> organizationShooters = null;
	List<ESFShooterCategory> shootersCategory = null;
	List<ESFCard> cardShooters=null;
	List<ESFMatch> matchShooters=null;
	List<ESFShooterQualification> shooterQualification=null;
	List<ESFUserESFUserRole> userRole=null;
	List<Country> esfCountry=null;
	//liste per il tab gare
	List<ESFDescription> description=null;
	List<ESFMatchType> matchTypeReport=null;
	List<ESFUser> userReport=null;
	
	try {
		matchTypeReport = ESFMatchTypeLocalServiceUtil.getESFMatchTypes(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		userReport = ESFUserLocalServiceUtil.findAllUser();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		description = ESFDescriptionLocalServiceUtil.getESFDescriptions(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		organizationShooters = ESFOrganizationLocalServiceUtil.getESFOrganizations(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		esfCountry = CountryServiceUtil.getCountries(); //##########################################################################
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		shooterQualification = ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		userRole = ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoles(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		shootersCategory = ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		cardShooters = ESFCardLocalServiceUtil.getESFCards(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		matchShooters = ESFMatchLocalServiceUtil.getESFMatchs(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		regions = ESFRegionLocalServiceUtil.getESFRegions(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}

	try {
		provinces = ESFProvinceLocalServiceUtil.getESFProvinces(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		organizations = ESFOrganizationLocalServiceUtil
				.getESFOrganizations(
						com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
						com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		List<ESFAddress> addresses = ESFAddressLocalServiceUtil
				.getESFAddresses(
						com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
						com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		fields = ESFFieldLocalServiceUtil.getESFFields(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}

	try {
		assStatus = ESFEntityStateLocalServiceUtil.getESFEntityStates(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		services = ESFUnitserviceLocalServiceUtil.getESFUnitservices(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		states = ESFStateLocalServiceUtil.findAllESFStates();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

<%-- <aui:script use="node,aui-io-request">

		var regions = JSON.parse('<%= regions.equals("")?null:HtmlUtil.escapeJS(regions) %>');
		var provinces = JSON.parse('<%= provinces.equals("")?null:HtmlUtil.escapeJS(provinces) %>');
		var cities = JSON.parse('<%= cities.equals("")?null:HtmlUtil.escapeJS(cities) %>');

		var regionId = '<%= esfAddress != null?esfAddress.getEsfRegionId():ESFKeys.ESFAddressConstant.DEFAULT_STRING%>';
		var provinceId = '<%= esfAddress != null?esfAddress.getEsfProvinceId():ESFKeys.ESFAddressConstant.DEFAULT_STRING%>';
		var cityId = '<%= esfAddress != null?esfAddress.getEsfCityId():ESFKeys.ESFAddressConstant.DEFAULT_NUMBER%>';

		var regionsOptions = '<option value="">-</option>';
		for(regIndex in regions) {
			if(regions[regIndex][0] == regionId)
				regionsOptions += '<option selected="selected" value="'+ regions[regIndex][0] +'">' + regions[regIndex][1] + '</option>';
			else 
				regionsOptions += '<option value="'+ regions[regIndex][0] +'">' + regions[regIndex][1] + '</option>';
		}

		var provincesOptions = '<option value="">-</option>';
		for(provIndex in provinces) {
			if(provinces[provIndex][0] == provinceId)
				provincesOptions += '<option selected="selected" value="'+ provinces[provIndex][0] +'">' + provinces[provIndex][1] + '</option>';
			else    
				provincesOptions += '<option value="'+ provinces[provIndex][0] +'">' + provinces[provIndex][1] + '</option>';
		}

		var citiesOptions = '<option value="0">-</option>';
		for(cityIndex in cities) {
			if(cities[cityIndex][0] == cityId)
				citiesOptions += '<option selected="selected" value='+ cities[cityIndex][0] +'>' + cities[cityIndex][1] + '</option>';
			else
				citiesOptions += '<option value='+ cities[cityIndex][0] +'>' + cities[cityIndex][1] + '</option>';
		}

		A.one('#<portlet:namespace/>regions<%= iesima%>').html(regionsOptions);
		A.one('#<portlet:namespace/>provinces<%= iesima%>').html(provincesOptions);
		A.one('#<portlet:namespace/>cities<%= iesima%>').html(citiesOptions);

		A.one('#<portlet:namespace/>regions<%= iesima%>').on('change', changeSelect);
		A.one('#<portlet:namespace/>provinces<%= iesima%>').on('change', changeSelect);
		A.one('#<portlet:namespace/>cities<%= iesima%>').on('change', changeSelect);

		function changeSelect(event) {
			var element = event.currentTarget;
			var type = element.get('id').replace('<portlet:namespace/>', '');
			var param = '';
			var idRegion = ''; 
			var idProvince = '';
			if(type == 'regions<%= iesima%>') {
				idRegion = A.one('#<portlet:namespace/>regions<%= iesima%>')
				.get('value');
			}
			else if(type == 'provinces<%= iesima%>'){
				idRegion = A.one('#<portlet:namespace/>regions<%= iesima%>')
				.get('value');
			idProvince = A.one('#<portlet:namespace/>provinces<%= iesima%>')
			.get('value');
			}
		
			var resourceURL = '';
			if (type == 'regions<%= iesima%>') {
				resourceURL = '<%= regionsURL%>';
			}
			else if (type == 'provinces<%= iesima%>') {
				resourceURL = '<%= provincesURL %>';
			}
			else if (type == 'cities<%= iesima%>') {
				resourceURL = '<%= citiesURL %>';
			}
			A.io.request(
				resourceURL,
			{
					method: 'POST',
					contentType: "application/json; charset=utf-8",
					data: {
						param:param,
						idRegion:idRegion,
						idProvince:idProvince
					},
					on: {
						success: function() {
							var results = JSON.parse(this.get('responseData'));
							var resultsOption = '<option value="">-</option>';
							if(type == 'regions<%= iesima%>'){
								A.one('#<portlet:namespace/>provinces<%= iesima%>')
									.html('<option value="">-</option>');
								for(index in results) {
									resultsOption +=
										 '<option value="'+ results[index][0] +'">'
										  + results[index][1] + '</option>';
									A.one('#<portlet:namespace/>provinces<%= iesima%>')
										.html(resultsOption);
		                        }
		                        A.one('#<portlet:namespace/>cities<%= iesima%>')
		                        	.html('<option value="0">-</option>');
		                    }
		                    else if(type == 'provinces<%= iesima%>') {
		                        A.one('#<portlet:namespace/>cities<%= iesima%>')
		                        	.html('<option value="0">-</option>');
		                        for(index in results) {
		                            resultsOption += '<option value='+ results[index][0] +'>'
		                            	 + results[index][1] + '</option>';
		                            A.one('#<portlet:namespace/>cities<%= iesima%>')
		                            	.html(resultsOption);
		                        }
		                    }
		                }
		        }
		    });
		}
		</aui:script>

 --%>