<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>

<%
String firstname = ParamUtil.getString(request, "firstname");
String lastname = ParamUtil.getString(request, "lastname");
String cardCode = ParamUtil.getString(request, "card");
String regionId = ParamUtil.getString(request, "regionId");
long shDtId = ParamUtil.getLong(request, "shDtId");
long stId = ParamUtil.getLong(request, "stId");

List<ESFRegion> regions = new ArrayList<ESFRegion>();
List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
List<ESFSportType> sportTypes = new ArrayList<ESFSportType>();

regions = ESFRegionLocalServiceUtil.getESFRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();


PortletURL viewassURL = renderResponse.createRenderURL();

viewassURL.setParameter(
	"mvcPath",  "/html/esfshooteingdirector/viewSearch.jsp");
viewassURL.setParameter("firstname", firstname);
viewassURL.setParameter("lastname", lastname);
viewassURL.setParameter("cardCode", cardCode);
viewassURL.setParameter("regionId",String.valueOf( regionId));
viewassURL.setParameter("shDtId",String.valueOf( shDtId));
viewassURL.setParameter("stId",String.valueOf( stId));

%>
<liferay-ui:error key="error-delete-shDr" message="error-delete-shDr" />

	<aui:button-row cssClass="esfshooter-admin-buttons">
		<portlet:renderURL var="newShootingDirectorURL">
			<portlet:param name="mvcPath" value='<%=templatePath + "newShootingDirector.jsp"%>' />
		</portlet:renderURL>

	<aui:button onClick="<%= newShootingDirectorURL.toString() %>" value="add-shDirector" />
	</aui:button-row>
	
<liferay-ui:header backURL="<%=viewURL.toString()%>" title="search" />

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "viewSearch.jsp"%>' />
</liferay-portlet:renderURL>
	
<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		<div class="search-form">
			<span class="aui-search-bar">
				<aui:input inlineField="<%=true%>" label="lastName" name="lastname"
					placeholder="last-name" size="30" title="search-entries" type="text" />
				<aui:input inlineField="<%=true%>" label="firstName" name="firstname"
					placeholder="first-name" size="30" title="search-entries" type="text" />
				<aui:input inlineField="<%=true%>" label="card" name="card" 
					placeholder="card" size="30" title="search-entries" type="text" />
				<aui:select  name="regionId" inlineField="<%=true%>" label="regions">
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFRegion r : regions){ %>
					<aui:option value="<%=r.getIdRegion()%>"  label="<%=r.getName()%>"></aui:option>
				<%}%>
				</aui:select>
				<aui:select  name="shDtId" inlineField="<%=true%>" label="qualification" >
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFShootingDirectorQualification s : shDts){%>
					<aui:option value="<%=s.getEsfShootingDirectorQualificationId()%>"  label="<%=s.getEsfShootingDirectorQualificationDesc()%>"></aui:option>
				<%}%>
				</aui:select>
				<aui:select  name="stId" inlineField="<%=true%>" label="sport-type" >
					<aui:option value="0"  label="-"></aui:option>
				<%for(ESFSportType st : sportTypes){%>
					<aui:option value="<%=st.getEsfSportTypeId()%>"  label="<%=st.getName()%>"></aui:option>
				<%} %>
				</aui:select>
				
	<aui:button type="submit" value="search" />
			</span>
		</div>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-result" >
	<liferay-ui:search-container-results
		results = "<%=ESFShootingDirectorLocalServiceUtil.findShootingDirector(lastname, firstname, cardCode, regionId,	shDtId, stId, 
				searchContainer.getStart(), searchContainer.getEnd()) %>"
		total= "<%=ESFShootingDirectorLocalServiceUtil.countShootingDirector( lastname, firstname, cardCode, regionId,	shDtId, stId)%>" />

		<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFShootingDirector" modelVar="shDt">
		
		<%
			ESFUser shDtInfo = new ESFUserImpl();
			ESFCard userCard= null;
			List<ESFCard> cardstest = new ArrayList<ESFCard>();
			String name = "";
			String cardCodeS = "";
			String qualification ="";
			String stName= "";
			
			if(Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()))){
				name = ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getFirstName();
				
				name = name + " " + ESFUserLocalServiceUtil.fetchESFUser(shDt.getEsfUserId()).getLastName();
				
				try{
					cardstest = ESFCardLocalServiceUtil.findActualUserCards(shDt.getEsfUserId());
					
					if(Validator.isNotNull(cardstest) && 0 < cardstest.size()){
						cardCodeS = cardstest.get(0).getCode();
					}
					
				}
				catch(Exception e){
					
				}
			}
			
			if(Validator.isNotNull(ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()))){
				qualification = ESFShootingDirectorQualificationLocalServiceUtil.
						fetchESFShootingDirectorQualification(shDt.getShootingDirectorQualificationId()).getEsfShootingDirectorQualificationDesc();
			}
			
			if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()))){
				stName = ESFSportTypeLocalServiceUtil.fetchESFSportType(shDt.getSportTypeId()).getName();
			}
		%>
		
		<liferay-ui:search-container-column-text name="name" value="<%=name %>" />
		<liferay-ui:search-container-column-text name="card" value="<%=cardCodeS %>"/>
		<liferay-ui:search-container-column-text name="region-code" value="<%=shDt.getRegionId() %>" />
		<liferay-ui:search-container-column-text name="qualification" value="<%=qualification %>" />
		<liferay-ui:search-container-column-text name="sport-type" value="<%=stName %>" />
		<liferay-ui:search-container-column-text name="esf-date-assign" value="<%=sdf.format(shDt.getEsfStartData()) %>" />
		<liferay-ui:search-container-column-jsp
				path='<%=templatePath + "modifyShDrAction.jsp"%>' align="right" />

		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
