<%@include file="init.jsp"%>

<!-- SCRIPT PER INSERIRE LA DATA -->

<%
	
	date = calendar.getTime();
// 	Calendar vCalendar = Calendar.getInstance(TimeZone.getDefault());
	startDate = ManageDate.DateToString(date);
%>
<aui:script>
	$(function() {
		$("#<portlet:namespace/>startDate").datepicker();
		$("#<portlet:namespace/>startDate")
			.datepicker("option", "dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>startDate")
			.datepicker("setDate", '<%= startDate %>');
	});
</aui:script>

<aui:form action="<%=searchURL%>" method="get">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div>
		<aui:select inlineField="<%=true%>" name="organizationId"
			label="organization-id">
			<aui:option value="0" label="-"/>
			<%
				for (ESFOrganization o : organizations) {
			%>
			<aui:option value="<%=o.getEsfOrganizationId()%>">
				<%=o.getName()%>
			</aui:option>
			<%
				}
			%>
		</aui:select>

		<aui:input name="startDate" type="text" value="<%=startDate%>" />

		<aui:select name="matchDescId" label="match">
			<aui:option value="0" label="-"/>
			<%
				for (ESFMatch m : myMatches) {
							ESFDescription desc = null;
							try {
								desc = ESFDescriptionLocalServiceUtil
										.fetchESFDescription(m.getDescription());
							} catch (Exception e) {
								e.printStackTrace();
							}
							if (desc == null) {
								//non fa nulla, resta la sola option vuota
							} else {
			%>
			<aui:option value="<%=m.getDescription()%>">
				<%=desc.getName()%>
			</aui:option>
			<%
				}
						}
			%>
		</aui:select>
		<aui:select name="sportTypeId" label="sport-type-id">
			<aui:option value="0" label="-"/>
			<%
				for (ESFSportType st : sportTypes) {
			%>
			<aui:option value="<%=st.getEsfSportTypeId()%>">
				<%=st.getName()%>
			</aui:option>
			<%
				}
			%>
		</aui:select>
		<aui:input type="submit" value="submit" name="" />
	</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-results">
	<liferay-ui:search-container-results>
		<%
			List<ESFMatch> matches = myMatches;
					pageContext.setAttribute("results", matches);
					pageContext.setAttribute("total", matches.size());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">

		<liferay-ui:search-container-column-text property="createDate"
			name="create-date" />

		<liferay-ui:search-container-column-text property="endDate"
			name="end-date" />

		<%
			String desc = "";
			if(Validator.isNotNull(esfMatch)){
			if(Validator.isNotNull(esfMatch.getDescription())){
					desc = ESFDescriptionLocalServiceUtil
									.fetchESFDescription(esfMatch
											.getDescription())
												.getName();
			}
		}
		%>
		<liferay-ui:search-container-column-text value="<%=desc %>"
			name="description" />
		
		<liferay-ui:search-container-column-text property="notes" name="notes" />

		<%
			long matchTypeId = esfMatch.getEsfMatchTypeId();
					if (matchTypeId == 0) {
		%>
		<liferay-ui:search-container-column-text value="empty-match-type"
			name="matchDesc" />
		<%
			} else {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFMatchTypeLocalServiceUtil.getESFMatchType(
								matchTypeId).getName()%>"
			name="matchDesc" />
		<%
			}
		%>

		<%
			long sportTypeId = esfMatch.getEsfSportTypeId();
					if (sportTypeId == 0) {
		%>
		<liferay-ui:search-container-column-text value="empty"
			name="sportType" />
		<%
			} else {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFSportTypeLocalServiceUtil.getESFSportType(
								sportTypeId).getDescription()%>"
			name="sportType" />
		<%
			}
		%>
		<%
			long assId = esfMatch.getEsfAssociationId();
					if (assId == 0) {
		%>
		<liferay-ui:search-container-column-text value="empty-ass"
			name="sportAss" />
		<%
			} else {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFOrganizationLocalServiceUtil
								.getESFOrganization(assId).getName()%>"
			name="sportAss" />
		<%
			}
		%>

		<%
			long partId = partecipant.getEsfPartecipantTypeId();
			String nomePart="sono vuoto[1]";
			try{nomePart=ESFPartecipantTypeUtil
					.fetchByPrimaryKey(partId).getName();}
			catch(Exception e){e.printStackTrace(); nomePart="Sono vuoto[2]";}
			if (nomePart.equals(ESFKeys.ESFUserRoleDefault.DOCTOR)) {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFKeys.ESFUserRoleDefault.DOCTOR%>" name="partecipant" />
		<%
			}
			if (nomePart.equals(ESFKeys.ESFUserRoleDefault.COACH)) {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFKeys.ESFUserRoleDefault.COACH%>" name="partecipant" />
		<%
			}
			if (nomePart.equals(ESFKeys.ESFUserRoleDefault.STAFF)) {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFKeys.ESFUserRoleDefault.STAFF%>" name="partecipant" />
		<%
			}
			if (nomePart.equals(ESFKeys.ESFUserRoleDefault.REFEREE)) {
		%>
		<liferay-ui:search-container-column-text
			value="<%=ESFKeys.ESFUserRoleDefault.REFEREE%>" name="partecipant" />
		<%
			}
		%>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
