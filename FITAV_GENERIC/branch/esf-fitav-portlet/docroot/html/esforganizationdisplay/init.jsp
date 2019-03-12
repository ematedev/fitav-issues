<%@ include file="/html/init.jsp" %>

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.model.LayoutSetPrototype"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="it.ethica.esf.model.ESFField"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFOrganizationModel"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>

<%@page import="it.ethica.esf.permission.ESFOrganizationPermission"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFHistoricalAssociation"%>
<%@page import="it.ethica.esf.permission.ESFOrganizationDisplayPermission"%>
<%@page import="it.ethica.esf.model.impl.ESFHistoricalAssociationImpl"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.service.ESFRenewalLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFRenewal"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="it.ethica.esf.model.ESFUserESFUserRole"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.persistence.RoleFinderUtil"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFConfigurationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFConfiguration"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFHistoricalAssociationUtil"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="it.ethica.esf.service.ESFProvinceLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFProvincePK"%>
<%@page import="it.ethica.esf.service.persistence.ESFRegionPK"%>
<%@page import="it.ethica.esf.service.ESFRegionLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFCityPK"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="com.liferay.portal.PhoneNumberException"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.PhoneServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="it.ethica.esf.service.persistence.ESFCityUtil"%>
<%@page import="it.ethica.esf.service.impl.ESFCityLocalServiceImpl"%>
<%@page import="it.ethica.esf.model.ESFCity"%>
<%@page import="it.ethica.esf.service.ESFCityLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.persistence.ESFCityPK"%>
<%@page import="it.ethica.esf.service.ESFPhoneLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFPhone"%>
<%@page import="com.liferay.portal.service.EmailAddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.PhoneNumberException"%>
<%@page import="com.liferay.portal.service.PhoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.PhoneServiceUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFHistoricalAssociation"%>

<%
Locale local = renderRequest.getLocale();
ResourceBundle res = portletConfig.getResourceBundle(locale); 

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();

ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
		.fetchESFOrganization(currentOrganizationId);

int currentType = 0;

if (currentESFOrganization != null) {

	currentType = Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:renderURL var="editURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "edit_esforganization.jsp"%>' />
	<portlet:param name="op" value='updAddr' />
	<portlet:param name="esfOrganizationId" value="<%= String.valueOf(currentOrganizationId) %>" />
</portlet:renderURL>

<portlet:renderURL var="chooseAssociationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esforganizationdisplay/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<aui:script>
AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	
	if(A.one('#<portlet:namespace/>chooseAssociation')){
		A.one('#<portlet:namespace/>chooseAssociation').on('click', function(event){
		var login_popup= Liferay.Util.openWindow({
			dialog: {
				centered: true,
				destroyOnClose: true,
				cache: false,
				width: 700,
				height: 500,
				modal: true
			},
			title: 'Scegli organizzazione',
			id:'<portlet:namespace/>chooseAssociationPopUp',
			uri:'<%=chooseAssociationURL.toString()%>'
			});

		});
		
		Liferay.provide(
				window,
				'<portlet:namespace/>retrieveAssociation',
				function(dataId, dataName, dataCode) {
					var A = AUI();

					A.one('#<portlet:namespace/>organizationName').set('value', dataName);
					A.one('#<portlet:namespace/>organizationCode').set('value', dataCode);
					A.one('#<portlet:namespace/>idFatherAssociation').set('value', dataId);
					var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
					dialog.destroy();
					A.one('#<portlet:namespace/>organizationName').focus();
				},
				['liferay-util-window']
			);
		
	}	

});
	
</aui:script>