<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/init.jsp"%>

<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ActionKeys"%>
<%@page import="it.ethica.esf.service.ESFGunLocalServiceUtil"%>
<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page import="it.ethica.esf.permission.ESFGunModelPermission"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%><%@
page import="com.liferay.portal.kernel.util.StringPool"%><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Locale" %><%@
page import="it.ethica.esf.service.ESFCaneLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCane"%><%@
page import="it.ethica.esf.service.ESFCatridgeLocalServiceUtil"%><%@
page import="it.ethica.esf.model.ESFCatridge"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
Locale local = renderRequest.getLocale();
ResourceBundle res = portletConfig.getResourceBundle(locale);
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

ESFOrganization esfOrganization = null;

if (esfOrganizationId > 0) {
esfOrganization =
	ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
}

Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

long currentOrganizationId = group.getOrganizationId();
	ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
		.fetchESFOrganization(currentOrganizationId);

int currentType = 0;

if (currentESFOrganization != null) {

	currentType = Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
}


%>

<portlet:renderURL var="chooseUserURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfgunuser/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>

<aui:script>
AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	
	if(A.one('#<portlet:namespace/>chooseUserTrigger')){
		A.one('#<portlet:namespace/>chooseUserTrigger').on('click', function(event){
		var login_popup= Liferay.Util.openWindow({
			dialog: {
				centered: true,
				destroyOnClose: true,
				cache: false,
				width: 800,
				height: 500,
				modal: true
			},
			title: 'Scegli Tiratore',
			id:'<portlet:namespace/>chooseUserPopUp',
			uri:'<%=chooseUserURL.toString()%>'
			});

		});
	
		Liferay.provide(
				window,
				'<portlet:namespace/>retrieveUser',
				function(dataId, dataName) {
					var A = AUI();

					A.one('#<portlet:namespace/>userName').set('value', dataName);
					A.one('#<portlet:namespace/>shooterId').set('value', dataId);
					var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseUserPopUp');
					dialog.destroy();
					
				},
				['liferay-util-window']
			);
			

	}	
});

</aui:script>
