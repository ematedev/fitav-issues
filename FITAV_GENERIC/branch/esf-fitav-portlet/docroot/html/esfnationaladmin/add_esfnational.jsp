<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="init.jsp" %>

<%
String search = ParamUtil.getString(request, "search");
long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");

List<ESFCard> esfCards =
	ESFCardLocalServiceUtil.findAllESFCardsByState(ESFKeys.ESFStateType.ENABLE);

List<Long> shooterIds = new ArrayList<Long>();

for (ESFCard esfCard : esfCards) {

	shooterIds.add(esfCard.getEsfUserId());
}

//just to avoid a bug with the in clause and empty Lists
if(shooterIds.size() == 0) {

	shooterIds.add(new Long(0));
}

DynamicQuery contactQuery = null;

Criterion commonCriterion = RestrictionsFactoryUtil.in("classPK", shooterIds);
commonCriterion = RestrictionsFactoryUtil.and(commonCriterion,
		RestrictionsFactoryUtil.eq("classNameId",
		ClassNameLocalServiceUtil.getClassNameId(User.class)));

if (Validator.isNotNull(search)) {

	commonCriterion = RestrictionsFactoryUtil.and(commonCriterion,
			RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.like("firstName", search),
					RestrictionsFactoryUtil.like("lastName", search)));
}

Criterion specCriterion = null;
PortletURL iteratorURL = null;
int shooterCount = 0;
int scid = 0;
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'/>
</portlet:renderURL>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "add_esfnational.jsp" %>'/>
</portlet:renderURL>

<portlet:actionURL name="addNational" var="addNationalURL"/>

<h3>
	<liferay-ui:message key="available-shooters"></liferay-ui:message>
</h3>
<aui:form method="post" action="<%= searchURL %>" name="fmSearch">
	<aui:input inlineField="true"
		name="search"
		label="shooter-name-or-surname"
	/>
	<aui:button type="submit"></aui:button>
</aui:form>
<aui:form method="post" action="<%= addNationalURL %>" name="fmChoose">
	<p class="lead">
		<liferay-ui:message key="man"></liferay-ui:message>
	</p>
	<%@ include file="view_man.jsp" %>
	<%@ include file="search_container_shooter.jsp" %>
	<div class="separator"></div>
	
	<p class="lead">
		<liferay-ui:message key="man-junior"></liferay-ui:message>
	</p>
	<%@ include file="view_man_junior.jsp" %>
	<%@ include file="search_container_shooter.jsp" %>
	<div class="separator"></div>
	
	<p class="lead">
		<liferay-ui:message key="lady"></liferay-ui:message>
	</p>
	<%@ include file="view_lady.jsp" %>
	<%@ include file="search_container_shooter.jsp" %>
	<div class="separator"></div>
	
	<p class="lead">
		<liferay-ui:message key="lady-junior"></liferay-ui:message>
	</p>
	<%@ include file="view_lady_junior.jsp" %>
	<%@ include file="search_container_shooter.jsp" %>
	<div class="separator"></div>

	<aui:input name="esfSportTypeId" type="hidden" value="<%= esfSportTypeId %>"></aui:input>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
</aui:form>
