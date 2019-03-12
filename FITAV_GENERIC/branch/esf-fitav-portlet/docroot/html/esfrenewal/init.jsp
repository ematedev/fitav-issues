
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.service.ThemeLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeCompanyId"%>
<%@ include file="/html/init.jsp"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="it.ethica.esf.model.ESFRenewal"%>
<%@page import="it.ethica.esf.service.ESFRenewalLocalServiceUtil"%>
<%@page import="it.ethica.esf.migration.util.ManageDate"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.security.acl.Owner"%>
<%@page import="javax.portlet.PortletURL"%>
<!--%@page import="sun.security.acl.OwnerImpl"%-->
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactory"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.text.SimpleDateFormat"%><%@
page
	import="java.util.ResourceBundle"%><%@
page import="java.util.Locale"%>


<%
	Locale local = renderRequest.getLocale();
	ResourceBundle res = portletConfig.getResourceBundle(locale);

	String hiden = "";

	Long assotiationId = 0l;
	/*	
	long assotiationType = ESFKeys.ESFOrganizationTypeId.ASSOCIATION;
	
	Group group = GroupLocalServiceUtil.fetchGroup(themeDisplay
	.getScopeGroupId());
	if (group.isOrganization()) {
	assotiationId = group.getOrganizationId();
	}
	if (assotiationId != 0) {
	if (Validator.isNotNull(ESFOrganizationLocalServiceUtil
	.fetchESFOrganization(assotiationId))) {

	ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
	.fetchESFOrganization(assotiationId);

	if (esfOrganization.getType() == assotiationType) { // assotiationType = 3
	hiden = "none";
	}
	}
	}

	List<ESFOrganization> esfOrganizations = ESFOrganizationLocalServiceUtil
	.findAllESFOrganizations(assotiationType,
		ESFKeys.ESFStateType.ENABLE);
	
	long regionId = themeDisplay.getCompanyId();
	 
	System.out.println("<<<<<<<<<<<regionId vale:"+regionId);
	
	List<ESFOrganization> esfCitys = ESFOrganizationLocalServiceUtil
		.findAllChildOrganizations(regionId);

	System.out.println("<<<<<<<<<<<esfCitys vale:"+esfCitys);
	
	List<ESFOrganization> esfOrganization = ESFOrganizationLocalServiceUtil
		.findAllChildOrganizations(16501,
				ESFKeys.ESFStateType.ENABLE);

	List<ESFOrganization> regions = ESFOrganizationLocalServiceUtil
		.findAllLeafOrganizations(12860);*/

	// DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE

	//long assotiationType1 = ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

	//Group group1 = GroupLocalServiceUtil.getGroup(scopeGroupId);

	//long currentOrganizationId = group1.getOrganizationId();

	//System.out.println("<<<<<<<<<<<<<<<<numero associazioni="+regions.size());

	/*for(ESFOrganization region : regions){
		
		long regionid = region.getEsfOrganizationId();
			
		List<ESFOrganization> citys = ESFOrganizationLocalServiceUtil
				.findAllLeafOrganizations(regionid);
				
		for(ESFOrganization city : citys){
			
			long cityid = city.getEsfOrganizationId();
			
			List<ESFOrganization> organization = ESFOrganizationLocalServiceUtil
					.findAllLeafOrganizations(cityid);
		}
		
	}*/

	/*for (ESFOrganization org : regions) {
		System.out.println("<<<<<<<<<<<<<<name org vale:"
				+ org.getName());
		System.out.println("<<<<<<<<<<<<<<code org vale:"
				+ org.getCode());
		System.out.println("<<<<<<<<<<<<<<type org vale:"
				+ org.getType_());
	}*/
	// DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE DA CANCELLARE

	long esfOrganizationId = ParamUtil.getLong(request,
			"esfOrganizationId");

	int currentType = 0;

	int orgSelectedType = 0;

	ESFOrganization esfOrganization = null;

	if (esfOrganizationId > 0) {

		esfOrganization = ESFOrganizationLocalServiceUtil
				.getESFOrganization(esfOrganizationId);

		orgSelectedType = Integer.valueOf(String
				.valueOf(esfOrganization.getType()));
	}

	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

	/////////////////////////////////////////
	if (group.isOrganization()) {
		assotiationId = group.getOrganizationId();
	}
	///////////////////////////////////////////

	long currentOrganizationId = group.getOrganizationId();

	ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
			.fetchESFOrganization(currentOrganizationId);

	if (currentESFOrganization != null) {

		currentType = Integer.valueOf(String
				.valueOf(currentESFOrganization.getType()));
	}

	List<ListType> paymentTypes = ListTypeServiceUtil
			.getListTypes(it.ethica.esf.model.ESFRenewal.class
					.getName() + ".payment");
%>
<portlet:renderURL var="chooseAssociationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfrenewal/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="chooseAssociationIntegrationURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfrenewal/popupIntegration/view.jsp"%>'></portlet:param>
</portlet:renderURL>
<aui:script>
AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	
if(A.one('#<portlet:namespace/>chooseAssociationTrigger')){
	A.one('#<portlet:namespace/>chooseAssociationTrigger').on('click', function(event){
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
			function(dataId, dataName) {
				var A = AUI();

				//A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
				A.one('#<portlet:namespace/>organizationName').set('value', dataName);
				A.one('#<portlet:namespace/>organizationId').set('value', dataId);
				var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
				dialog.destroy();
				A.one('#<portlet:namespace/>organizationName').focus();
			},
			['liferay-util-window']
		);
		
	
	
}	
if(A.one('#<portlet:namespace/>chooseAssociationTriggerIntegration')){
	A.one('#<portlet:namespace/>chooseAssociationTriggerIntegration').on('click', function(event){
		var login_popupIncr= Liferay.Util.openWindow({
			dialog: {
				centered: true,
				destroyOnClose: true,
				cache: false,
				width: 700,
				height: 500,
				modal: true
			},
			title: 'Scegli organizzazione',
			id:'<portlet:namespace/>chooseAssociationPopUpIncr',
			uri:'<%=chooseAssociationIntegrationURL.toString()%>'
			});

		});
	
	Liferay.provide(
			window,
			'<portlet:namespace/>retrieveAssociation',
			function(dataId, dataName) {
				var A = AUI();

				//A.one('#<portlet:namespace/>esfAssociationId').set('value', dataId);
				A.one('#<portlet:namespace/>organizationName').set('value', dataName);
				A.one('#<portlet:namespace/>organizationId').set('value', dataId);
				var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUpIncr');
				dialog.destroy();
				A.one('#<portlet:namespace/>organizationName').focus();
			},
			['liferay-util-window']
		);	
}
});


	
	


	
</aui:script>