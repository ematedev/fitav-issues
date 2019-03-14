
<%@ include file="init.jsp" %>
<%
		String national="national";
		String nationalB="National_B/23";
		long typeSportId = ParamUtil.getLong(renderRequest, "sport");
		Calendar data = Calendar.getInstance();
		int annoPrecedente = data.get(Calendar.YEAR);
		Calendar dataStagionePrecedente = Calendar.getInstance();
		dataStagionePrecedente.set(annoPrecedente, 12, 31);
		List<ESFNational> actualESFNational = ESFNationalLocalServiceUtil.
				getActiveESFNationals(typeSportId, 0, ESFNationalLocalServiceUtil.countActiveESFNationals());
		List<Long> actualESFNationalId = new ArrayList<Long>();
		for(ESFNational en: actualESFNational) {
			actualESFNationalId.add(en.getEsfUserId());
		}
%>
<portlet:actionURL name="updateExNational"
	var="updateExNational">
	<portlet:param name="typeSportId" value="<%=String.valueOf(typeSportId) %>"/>
	<portlet:param name="mvcPath" value='<%=templatePath+"view.jsp" %>'/>
</portlet:actionURL>

<aui:form action="<%=updateExNational%>"
	name="<portlet:namespace />fm">

	<aui:button-row>
		<aui:button type="submit" value="promote"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-results">
		<liferay-ui:search-container-results>
			<%
			List<ESFNational> allNational =
							ESFNationalLocalServiceUtil.
							getEXESFNationalUser(typeSportId);
						int totalAllNational =
							allNational.size();
		    List<Long> exESFNationalId = new ArrayList<Long>();
		    for(ESFNational en: allNational)
		    {
		    	exESFNationalId.add(en.getEsfUserId());
		    }
			
		    pageContext.setAttribute("results", ListUtil.subList(allNational, searchContainer.getStart(), searchContainer.getEnd()));
			pageContext.setAttribute("total", totalAllNational);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="it.ethica.esf.model.ESFNational" modelVar="esfNational">
			<%if(!actualESFNationalId.contains(esfNational.getEsfUserId())){ %>
				<liferay-ui:search-container-column-text name="choose">
				
					<aui:input name="choose"  label="" type="checkbox"
						id='<%="choose_" + esfNational.getEsfUserId()%>'>
					</aui:input>
	
					<aui:input type="hidden" name="esfUserIds"
						id='<%="esfUserIds_" + esfNational.getEsfUserId()%>'
						value='<%=esfNational.getEsfUserId()%>' />
				</liferay-ui:search-container-column-text>
			<%} else { %>
					<liferay-ui:search-container-column-text name="choose">
						<liferay-ui:message key="justExist"  >justExist</liferay-ui:message>
					</liferay-ui:search-container-column-text>
			<%}
			User userNational = UserLocalServiceUtil.getUser(esfNational.getEsfUserId()); 

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			%>

		<liferay-ui:search-container-column-text 
			name="last-name" value="<%=userNational.getLastName() %>"  
			
			 />
			
		<liferay-ui:search-container-column-text 
			name="first-name" value="<%=userNational.getFirstName() %>"
			 
			 />
		<liferay-ui:search-container-column-text name="birthday"
			value="<%=sdf.format(userNational.getBirthday()).toString()%>"/>
			
		<liferay-ui:search-container-column-text 
			name="university" value='<%=(esfNational.getIsUniversity())?"yes":"no"  %>'
			orderableProperty="endDate" orderable="true" />
		
		<liferay-ui:search-container-column-text 
			name="isNational" value='<%=(esfNational.getIsNational())?res.getString(national):res.getString(nationalB)%>'
			orderableProperty="endDate" orderable="true" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>