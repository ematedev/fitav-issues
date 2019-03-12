<%@ include file="init.jsp" %>

<%
List<ESFSportType> nationalSportTypes = ESFSportTypeLocalServiceUtil.getNational(true);

if (nationalSportTypes.size() == 0) {
%>
	<div class="alert alert-error">
		<liferay-ui:message key="no-one-national-discipline-found-create-one-and-come-back" />
	</div>
<%	
}
else {
	String tabNames = StringPool.BLANK;

	for (int i = 0 ; i < nationalSportTypes.size() ; i++) {

		ESFSportType nationalSportType = nationalSportTypes.get(i);

		tabNames += nationalSportType.getName();

		if (i != nationalSportTypes.size()) {

			tabNames += StringPool.COMMA;
		}
	}

	String tabs1 = ParamUtil.getString(request, "tabs1", nationalSportTypes.get(0).getName());
	%>
	
	<portlet:renderURL var="tabURL">
		<portlet:param name="tabs1" value="<%= tabs1 %>"/>
	</portlet:renderURL>

	<liferay-ui:tabs
		names="<%= tabNames %>"
		refresh="<%= false %>"
	>

	<%
	for (int i = 0 ; i < nationalSportTypes.size() ; i++) {
		
		ESFSportType nationalSportType = nationalSportTypes.get(i);
		
		List<ESFNational> esfNationals =
			ESFNationalLocalServiceUtil.getActiveESFNationals(nationalSportType.getEsfSportTypeId(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<Long> nationalIds = new ArrayList<Long>();

		for (ESFNational esfNational : esfNationals) {

			nationalIds.add(esfNational.getEsfUserId());
		}

		//just to avoid a bug with the in clause and empty Lists
		if(nationalIds.size() == 0) {

			nationalIds.add(new Long(0));
		}

		DynamicQuery contactQuery = null;

		Criterion commonCriterion = RestrictionsFactoryUtil.in("classPK", nationalIds);
		commonCriterion = RestrictionsFactoryUtil.and(commonCriterion,
				RestrictionsFactoryUtil.eq("classNameId",
				ClassNameLocalServiceUtil.getClassNameId(User.class)));

		Criterion specCriterion = null;
		PortletURL iteratorURL = null;
		int nationalCount = 0;
		int scid = 0;
	%>

	<liferay-ui:section>

		<aui:button-row>
			<portlet:renderURL var="addESFNationalURL">
				<portlet:param name="esfSportTypeId"
					value="<%= String.valueOf(nationalSportType.getEsfSportTypeId()) %>" />
				<portlet:param name="redirect" value="<%= redirect %>"/>
				<portlet:param name="mvcPath"
					value='<%= templatePath + "add_esfnational.jsp" %>' />
			</portlet:renderURL>

			<aui:button onClick="<%= addESFNationalURL.toString() %>"
				value="add-esfnational-for-this-type" />
		</aui:button-row>

		<p class="lead">
			<liferay-ui:message key="man"></liferay-ui:message>
		</p>
		<%@ include file="view_man.jsp" %>
		<%@ include file="search_container_national.jsp" %>
		<div class="separator"></div>

		<p class="lead">
			<liferay-ui:message key="man-junior"></liferay-ui:message>
		</p>
		<%@ include file="view_man_junior.jsp" %>
		<%@ include file="search_container_national.jsp" %>
		<div class="separator"></div>

		<p class="lead">
			<liferay-ui:message key="lady"></liferay-ui:message>
		</p>
		<%@ include file="view_lady.jsp" %>
		<%@ include file="search_container_national.jsp" %>
		<div class="separator"></div>

		<p class="lead">
			<liferay-ui:message key="lady-junior"></liferay-ui:message>
		</p>
		<%@ include file="view_lady_junior.jsp" %>
		<%@ include file="search_container_national.jsp" %>
		<div class="separator"></div>

	</liferay-ui:section>

	<% } %>

	</liferay-ui:tabs>
<% } %>