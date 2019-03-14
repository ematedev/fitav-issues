
<%@include file="init.jsp"%>



<%
	long organizationId = ParamUtil.getLong(request, "organizationId");
	// 	String date=ParamUtil.getString(request, "startDate");
	startDate = ParamUtil.getString(request, "startDate");
	long matchDescId = ParamUtil.getLong(request, "matchDescId");
	long sportTypeId = ParamUtil.getLong(request, "sportTypeId");

	PortletURL viewassURL = renderResponse.createRenderURL();

	viewassURL.setParameter("mvcPath",
	"/html/esfshowmymatch/view_search.jsp");
	viewassURL.setParameter("organizationId",
	String.valueOf(organizationId));
	viewassURL.setParameter("startDate", startDate.toString());
	// 	viewassURL.setParameter("startDate", date);
	viewassURL.setParameter("matchDescId", String.valueOf(matchDescId));
	viewassURL.setParameter("sportTypeId", String.valueOf(sportTypeId));
%>

<aui:script>
	$(function() {
		$("#<portlet:namespace/>startDate").datepicker();
		$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat",
				"dd/mm/yy");
		$("#<portlet:namespace/>startDate").datepicker("setDate",
				'<%= startDate %>');
	});
</aui:script>
	


<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<aui:form action="<%=searchURL%>" method="get">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div>
		<aui:select name="organizationId" label="organization-id">
			<aui:option value="0" label="-"/>
			<%
				for (ESFOrganization o : organizations) {
			%>
			<aui:option value="<%=o.getPrimaryKey()%>">
				<%=o.getName()%>
			</aui:option>
			<%
				}
			%>
		</aui:select>

		<aui:input name="startDate" type="text" placeholder="<%=startDate%>" />
		<%-- 		<aui:input name="startDate" type="text" value="<%=date%>" /> --%>

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
					matches = ESFMatchLocalServiceUtil
							.findMyMatches(userId, isNational,
									organizationId, date, matchDescId,
									sportTypeId);
					pageContext.setAttribute("results", matches);
					pageContext.setAttribute("total", matches.size());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFMatch" modelVar="esfMatch">
	<% 
// 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>
		<liferay-ui:search-container-column-text property="createDate"
			name="create-date" />

		<liferay-ui:search-container-column-text property="endDate"
			name="end-date" />

		<%-- <%
			long descriptionId = 0;
					String desc = "";
					if (Validator.isNotNull(esfMatch)) {
						descriptionId = esfMatch.getDescription();
						if (Validator.isNotNull(descriptionId)) {
							desc = ESFDescriptionLocalServiceUtil
									.getESFDescription(descriptionId)
									.getDescription();
						}
					}
		%>
		<liferay-ui:search-container-column-text value="<%=desc%>"
			name="description" /> --%>
		<%
			String notes = "";
			if (Validator.isNotNull(esfMatch)) {
				notes = esfMatch.getNotes();
			}
		%>
		<liferay-ui:search-container-column-text 
			value="<%=notes %>" name="notes" />

		<%
			long descId = 0;
					String matchDescName = "";
					if (Validator.isNotNull(esfMatch)) {
						descId = esfMatch.getDescription();
						if (Validator.isNotNull(matchDescId)) {
							matchDescName = ESFDescriptionLocalServiceUtil
									.getESFDescription(descId).getName();
						}
					}
		%>
		<liferay-ui:search-container-column-text value="<%=matchDescName%>"
			name="matchDesc" />
		<%
			long sportType = 0;
			String sportTypeName = "";
			if (Validator.isNotNull(esfMatch)) {
				sportType = esfMatch.getEsfSportTypeId();
				if (Validator.isNotNull(sportType)) {
					sportTypeName = ESFSportTypeLocalServiceUtil
								.getESFSportType(sportType).getDescription();
						}
					}
		%>
		<liferay-ui:search-container-column-text value="<%=sportTypeName%>"
			name="sportType" />

		<%
			long assId = 0;
			String ass = "";
			if (Validator.isNotNull(esfMatch)) {
				assId = esfMatch.getEsfAssociationId();
				if (Validator.isNotNull(assId)) {
					ass = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(assId).getName();
						}
					}
		%>
		<liferay-ui:search-container-column-text value="<%=ass%>"
			name="sportAss" />

		<%
			long partId = 0;
			long idUser=0;
			ESFPartecipant part=null;
			String nomePart = "sono vuoto";
			if (Validator.isNotNull(esfMatch)) {
				idUser = esfMatch.getUserId();
				try{
					part=ESFPartecipantLocalServiceUtil.findbyUserId(idUser);
					partId=part.getEsfPartecipantTypeId();
				}
				catch(Exception e){e.printStackTrace();}
				if (Validator.isNotNull(partId)) {
					nomePart = ESFPartecipantTypeUtil.fetchByPrimaryKey(partId)
							.getName();
						}
					}
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
