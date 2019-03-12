<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@include file="init.jsp"%>

<%
String searchName = ParamUtil.getString(request, "searchName");
String searchSurname = ParamUtil.getString(request, "searchSurname");
String className = ParamUtil.getString(request, "className");
long classPK = ParamUtil.getLong(request, "classPK");

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", templatePath + "delegation/select_esfUser.jsp");
iteratorURL.setParameter("className", className);
iteratorURL.setParameter("classPK", String.valueOf(classPK));

int esfNationalDelegationType = 0;

if (className.equals(ESFNational.class.getName())) {

	esfNationalDelegationType = ESFKeys.ESFNationalDelegationType.SHOOTER;
}
else if (className.equals(ESFUserRole.class.getName())) {
	
	esfNationalDelegationType = ESFKeys.ESFNationalDelegationType.STAFF;
} %>

<portlet:actionURL name="addESFNationalDelegation" var="addESFNationalDelegationURL">
	<portlet:param name="esfTournamentId"
		value="<%= String.valueOf(esfTournamentId)%>" />
	<portlet:param name="className" value="<%= className %>" />
	<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
</portlet:actionURL>

<portlet:renderURL var="searchURL">
	<portlet:param name="esfTournamentId"
		value="<%= String.valueOf(esfTournamentId)%>" />
	<portlet:param name="className" value="<%= ESFNational.class.getName() %>"/>
	<portlet:param name="classPK" value="<%= String.valueOf(classPK) %>" />
	<portlet:param name="mvcPath" value='<%= templatePath + "delegation/select_esfUser.jsp" %>' />
</portlet:renderURL>

<aui:form method="post" action="<%= searchURL %>" name="fmSearch">
	<aui:input inlineField="true"
		name="searchName"
		label="user-name"
	/>
	<aui:input inlineField="true"
		name="searchSurname"
		label="user-surname"
	/>
	<aui:button type="submit"></aui:button>
</aui:form>

<aui:form method="post" action="<%= addESFNationalDelegationURL %>">

<%
if (esfNationalDelegationType == ESFKeys.ESFNationalDelegationType.SHOOTER) {
%>
	<!-- SearchContainer Azzurrini QUI -->

	<h3><liferay-ui:message key="available-national-shooter"></liferay-ui:message></h3>

	<liferay-ui:search-container
		iteratorURL="<%= iteratorURL %>"
		delta="5"
		emptyResultsMessage="no-esfusers-were-found">

		<%
		List<ESFNational> esfActiveNationals =  ESFNationalLocalServiceUtil
				.getActiveESFNationals(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Long> esfNationalIds = new ArrayList<Long>();

		for (ESFNational esfActiveNational : esfActiveNationals) {

			esfNationalIds.add(esfActiveNational.getEsfNationalId());
		}

		if (esfNationalIds.isEmpty()) {
System.out.println("VUOTO");
			esfNationalIds.add((long)0);
		}

		DynamicQuery esfNationalQuery = null;

		Criterion criterion = RestrictionsFactoryUtil.in("esfNationalId",
				esfNationalIds);

		if (Validator.isNotNull(searchName) || Validator.isNotNull(searchSurname)) {
			System.out.println("ENTRATO");
			List<ESFUser> esfSearchUsers = ESFUserLocalServiceUtil
					.getAllUserByLikeF_L_S(searchName, searchSurname, StringPool.BLANK,
							ESFKeys.ESFStateType.ENABLE);
			List<Long> esfSearchUserIds = new ArrayList<Long>();

			for (ESFUser esfSearchUser : esfSearchUsers) {

				esfSearchUserIds.add(esfSearchUser.getEsfUserId());
			}

			if (esfSearchUserIds.isEmpty()) {

				esfSearchUserIds.add((long)0);
			}

			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.in("esfUserId", esfSearchUserIds));
		}

		esfNationalQuery = DynamicQueryFactoryUtil.forClass(ESFNational.class,
				"esfNationalQuery", PortletClassLoaderUtil.getClassLoader());
		esfNationalQuery.add(criterion);

		int esfNationalCount = ESFNationalLocalServiceUtil.dynamicQuery(esfNationalQuery).size();
		System.out.println("SIZE : "+esfNationalCount);
		%>

		<liferay-ui:search-container-results
			results="<%= ESFNationalLocalServiceUtil.dynamicQuery(esfNationalQuery,
					searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= esfNationalCount %>" />

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFNational" modelVar="esfNational">

			<%
			ESFUser esfShooter = ESFUserLocalServiceUtil.getESFUser(esfNational.getEsfUserId());
			ESFSportType esfSportType = ESFSportTypeLocalServiceUtil.getESFSportType(esfNational.getEsfSportTypeId());
			ESFNationalDelegationPK esfNationalDelegationPK = new ESFNationalDelegationPK(esfTournamentId, esfNational.getEsfUserId());
			boolean isEsfDelegate = ESFNationalDelegationLocalServiceUtil.fetchESFNationalDelegation(esfNationalDelegationPK) != null;
			%>

			<liferay-ui:search-container-column-text>
				<aui:input label=""
					disabled="<%= isEsfDelegate %>"
					type="checkbox"
					name="checkDelegate"
					value="<%= esfNational.getEsfNationalId() %>"
					id='<%= "checkDelegate" + esfNational.getEsfNationalId() %>'
				/>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="name" value="<%= esfShooter.getLastName() + StringPool.SPACE + esfShooter.getFirstName() %>"/>
			<liferay-ui:search-container-column-text name="esfSportType" value="<%= esfSportType.getName() %>"/>
			<liferay-ui:search-container-column-text property="startDate"/>
			<liferay-ui:search-container-column-text property="endDate"/>

<%-- 			<liferay-ui:search-container-column-jsp --%>
<%-- 				path='<%= templatePath + "delegation/add_delegation_action.jsp"%>' --%>
<%-- 				align="right" /> --%>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="true" />
	</liferay-ui:search-container>
<%
}
else if (esfNationalDelegationType == ESFKeys.ESFNationalDelegationType.STAFF) {

	List<ESFUserESFUserRole> activeEsfUserEsfUserRoles = ESFUserESFUserRoleLocalServiceUtil.getESFUSerRoleByR_ED(classPK);
	List<Long> activeEsfUserEsfUserRolesIds = new ArrayList<Long>();

	for (ESFUserESFUserRole activeEsfUserEsfUserRole : activeEsfUserEsfUserRoles) {

		activeEsfUserEsfUserRolesIds.add(activeEsfUserEsfUserRole.getEsfUserId());
	}

	if (activeEsfUserEsfUserRolesIds.isEmpty()) {

		activeEsfUserEsfUserRolesIds.add((long)0);
	}

	List<ESFUser> esfSearchUsers = ESFUserLocalServiceUtil
			.getAllUserByLikeF_L_S(searchName, searchSurname, StringPool.BLANK,
					ESFKeys.ESFStateType.ENABLE);
	List<Long> activeEsfUsersIds = new ArrayList<Long>();

	for (ESFUser activeEsfUser : esfSearchUsers) {

		activeEsfUsersIds.add(activeEsfUser.getEsfUserId());
	}

	if (activeEsfUsersIds.isEmpty()) {

		activeEsfUsersIds.add((long)0);
	}

	DynamicQuery esfUserQuery = null;

	Criterion criterion = RestrictionsFactoryUtil.in("esfUserId",
			activeEsfUserEsfUserRolesIds);
	criterion = RestrictionsFactoryUtil.and(criterion,
			RestrictionsFactoryUtil.in("esfUserId", activeEsfUsersIds));

	esfUserQuery = DynamicQueryFactoryUtil.forClass(ESFUser.class,
			"esfUserQuery", PortletClassLoaderUtil.getClassLoader());
	esfUserQuery.add(criterion);

	int esfUserCount = ESFUserLocalServiceUtil.dynamicQuery(esfUserQuery).size();
%>
	<!-- SearchContainer Staff QUI -->

	<h3>
		<liferay-ui:message key="available-national-staff"></liferay-ui:message>
		:&nbsp;<%= ESFUserRoleLocalServiceUtil.getESFUserRole(classPK).getName() %>
	</h3>

	<liferay-ui:search-container
		iteratorURL="<%= iteratorURL %>"
		delta="5"
		emptyResultsMessage="no-esfusers-were-found">

		<liferay-ui:search-container-results
			results="<%= ESFUserLocalServiceUtil.dynamicQuery(esfUserQuery,
					searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= esfUserCount %>" />

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFUser" modelVar="esfUser">

			<%
			ESFNationalDelegationPK esfNationalDelegationPK =
					new ESFNationalDelegationPK(esfTournamentId, esfUser.getEsfUserId());
			boolean isEsfDelegate = ESFNationalDelegationLocalServiceUtil.
					fetchESFNationalDelegation(esfNationalDelegationPK) != null;
			%>
			<liferay-ui:search-container-column-text>
				<aui:input label=""
					disabled="<%= isEsfDelegate %>"
					type="checkbox"
					name="checkDelegate"
					value="<%= esfUser.getEsfUserId() %>"
					id='<%= "checkDelegate" + esfUser.getEsfUserId() %>'
				/>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="name" value="<%= esfUser.getLastName() + StringPool.SPACE + esfUser.getFirstName() %>"/>

<%-- 			<liferay-ui:search-container-column-jsp --%>
<%-- 				path='<%= templatePath + "delegation/add_delegation_action.jsp"%>' --%>
<%-- 				align="right" /> --%>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="true" />
	</liferay-ui:search-container>
<% } %>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= delegationURL %>"></aui:button>
	</aui:button-row>
</aui:form>