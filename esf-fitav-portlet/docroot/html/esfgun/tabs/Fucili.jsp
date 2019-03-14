
<%@page import="it.ethica.esf.permission.ESFGunPermission"%>
<%@page
	import="com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="it.ethica.esf.service.ESFGunTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>


<h3>
	<liferay-ui:message key="RIFLES" />
</h3>

<liferay-ui:search-container emptyResultsMessage="no-results" delta="10"
	curParam="sc1">
	<liferay-ui:search-container-results
		results="<%=ESFGunKindLocalServiceUtil.getESFRifle(
						searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFGunKindLocalServiceUtil.countESFRifle()%>" />
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFGunKind" modelVar="esfGunKind">

		<%
			String model = "";
					String name = "";
					String description = "";

					if (Validator.isNotNull(esfGunKind.getName())) {
						name = esfGunKind.getName();
					}
					if (Validator.isNotNull(esfGunKind.getDescription())) {
						description = esfGunKind.getDescription();
					}
					if (Validator.isNotNull(esfGunKind.getEsfGunTypeId())
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(esfGunKind
											.getEsfGunTypeId()))
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(
											esfGunKind.getEsfGunTypeId())
									.getName())) {

						model = ESFGunTypeLocalServiceUtil.fetchESFGunType(
								esfGunKind.getEsfGunTypeId()).getName();

					}
		%>

		<liferay-ui:search-container-column-text name="esf-gun-type-name"
			value="<%=model%>" />
		<liferay-ui:search-container-column-text name="model" value="<%=name%>" />
		<liferay-ui:search-container-column-text name="description"
			value="<%=description%>" />
<% %>

<c:if test="<%= ESFGunPermission.containsRifle(permissionChecker,esfGunKind.getEsfGunKindId(), ActionKeys.ESFGUN_VIEW_ACTION) %>">	
		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfGun_actions.jsp"%>' align="right"
			cssClass="gun_actions_button" />
</c:if>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
