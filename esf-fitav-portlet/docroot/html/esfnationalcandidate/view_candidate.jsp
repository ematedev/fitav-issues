<%-- <%@ include file="init.jsp" %>     --%> 

<h3>
	<liferay-ui:message key="choosen-candidates"></liferay-ui:message>
</h3>
<portlet:actionURL name="sendCandidates" var="sendCandidatesURL" />
<aui:form method="post" action="<%=sendCandidatesURL%>" name="fmCandidate">
	<%
		
		if (portletSession.getAttribute("maleCandidatesList") != null) {
			candidatesList =
					(List<Contact>) portletSession.getAttribute("maleCandidatesList");
		}
	%>

	<p class="lead">
		<liferay-ui:message key="man"></liferay-ui:message>
	</p>

	<%@ include file="search_container_candidate.jsp"%>

	<div class="separator"></div>

	<%
		if (portletSession.getAttribute("maleJuniorCandidatesList") != null) {
			candidatesList =
					(List<Contact>) portletSession.getAttribute("maleJuniorCandidatesList");
			}
	%>

	<p class="lead">
		<liferay-ui:message key="man-junior"></liferay-ui:message>
	</p>

	<%@ include file="search_container_candidate.jsp"%>

	<div class="separator"></div>

	<%
		if (portletSession.getAttribute("ladyCandidatesList") != null) {
			candidatesList =
					(List<Contact>) portletSession.getAttribute("ladyCandidatesList");
			}
	%>

	<p class="lead">
		<liferay-ui:message key="lady"></liferay-ui:message>
	</p>

	<%@ include file="search_container_candidate.jsp"%>

	<div class="separator"></div>

	<%
		if (portletSession.getAttribute("ladyJuniorCandidatesList") != null) {
			candidatesList =
					(List<Contact>) portletSession.getAttribute("ladyJuniorCandidatesList");
			}
	%>

	<p class="lead">
		<liferay-ui:message key="lady-junior"></liferay-ui:message>
	</p>

	<%@ include file="search_container_candidate.jsp"%>

	<div class="separator"></div>

	<%
		List<ESFSportType> esfSportTypes =
				ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
	%>
	<liferay-ui:message key="candidate-these-shooters-for-this-discipline"></liferay-ui:message>
	<aui:select label="" inlineField="true" name="esfSportTypeId"
		showEmptyOption="false" required="true">
		<%
			for (ESFSportType esfSportType : esfSportTypes) {
		%>
		<aui:option label="<%=esfSportType.getName()%>"
			value="<%=esfSportType.getEsfSportTypeId()%>"></aui:option>
		<%
			}
		%>
	</aui:select>
	<liferay-ui:message key="and-for-this-year"></liferay-ui:message>

	<aui:select label="" inlineField="true" name="year"
		showEmptyOption="false" required="true">
		<%
			Calendar now = CalendarFactoryUtil.getCalendar();
			for (int i = 0; i < 2; i++) {
		%>
			<aui:option label="<%=now.get(Calendar.YEAR) + i%>"
				value="<%=now.get(Calendar.YEAR) + i%>"></aui:option>
		<%
			}
		%>
	</aui:select>

	<aui:button type="submit" value="send"></aui:button>
</aui:form>


