<%@page import="it.ethica.esf.service.ESFResultLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.impl.ESFMatchImpl"%>
<%@page import="it.ethica.esf.model.ESFResult"%>
<%@include file="init.jsp"%>

<%
ESFMatch match = new ESFMatchImpl();

List<ESFResult> results = new ArrayList<ESFResult>();

String matchCode="";
String startDate="";
String endDate="";
String matchPlace = "";
String barrage = "Barrage";
String finalS ="Final S";
String matchName = "";

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
String descRanking = ParamUtil.getString(request, "descRanking","");

List<String> descRankingString = ESFResultLocalServiceUtil.findDescRanking(esfMatchId);

startDate = sdf.format(match.getStartDate());
endDate = sdf.format(match.getEndDate());
matchCode = match.getCode();

if(0 < match.getEsfAssociationId() && Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(match.getEsfAssociationId())) &&
		Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(match.getEsfAssociationId()).getName())){
	
	matchPlace =  ESFOrganizationLocalServiceUtil.fetchESFOrganization(match.getEsfAssociationId()).getName();
	
}

results = ESFResultLocalServiceUtil.findByESFMatchidDescRanking(esfMatchId, descRanking);

if(0 < results.size() && Validator.isNotNull(results.get(0)) && Validator.isNotNull(results.get(0))){
	matchName = results.get(0).getName();
}

String[] matchInformation = {matchName,startDate,endDate, matchPlace};

%>

<liferay-portlet:renderURL varImpl="searchRankingURL">
	<portlet:param name="mvcPath" value='<%=templatePath + "viewResult.jsp"%>' />
	<portlet:param name="esfMatchId" value='<%=String.valueOf(esfMatchId)%>' />
</liferay-portlet:renderURL>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" 
			value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

<portlet:actionURL var="updateResultURL" name="updateResult">
		<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="companyId"
				value="<%=String.valueOf(company.getCompanyId())%>" />
		<portlet:param name="groupId"
				value="<%=String.valueOf(group.getGroupId())%>" />
		<portlet:param name="userId"
				value="<%=String.valueOf(user.getUserId())%>" />
		<portlet:param name="mvcPath"
				value='<%=templatePath + "viewResult.jsp" %>'/>
</portlet:actionURL>

<liferay-ui:error key="errorUpdateResultPortletIsSetInViewMode" message="errorUpdateResultPortletIsSetInViewMode" />
<liferay-ui:success key="succesUpdateResult" message="succesUpdateResult" />
<liferay-ui:error key="errorUpdateResult" message="errorUpdateResult" />

<h2><b><liferay-ui:message key="result-match-x-in-date-x-/-x-in-place-x"  arguments="<%= matchInformation%>"/></b></h2><br>
<hr />

<aui:form action="<%=searchRankingURL%>" method="get">
	<liferay-portlet:renderURLParams varImpl="searchRankingURL" />
		<div class="search-form">
			<span class="aui-search-bar"> 
				<aui:select name="descRanking" label="selectDescriptionCategori" inlineField="<%=true%>">
					<aui:option label="-" value="" />
					<%for(String s : descRankingString){ %>
						<aui:option value = "<%=s%>">
						<%=s%>
					</aui:option>
					<%} %>
				</aui:select>
				<aui:button type="submit" value="search" />
			</span>
		</div>
</aui:form>

<aui:form action="<%=updateResultURL%>" cssClass="form-table" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitUpdateResult();" %>' name="fm">

	<div class="nationalMatchResultWrapper">
		<table class='aui <%=isViewMode ? "view-mode" : ""%>' name="fmNationalResult" id ="resultTable">
			<thead>
				<tr>
		
					<th><%=res.getString("shooter")%></th>
					<th><%=res.getString("esf-card-id")%></th>
					<th><%=res.getString("descRanking")%></th>
					<th><%=res.getString("position")%></th>
					<th><%=res.getString("Results1")%></th>
					<th><%=res.getString("Results2")%></th>
					<th><%=res.getString("Results3")%></th>
					<th><%=res.getString("Results4")%></th>
					<th><%=res.getString("Results5")%></th>
					<th><%=res.getString("Results6")%></th>
					<th><%=res.getString("Results7")%></th>
					<th><%=res.getString("Results8")%></th>
					<th><%=res.getString("TotalS")%></th>
					<th><%=barrage%></th>
					<th><%=finalS%></th>
					<th><%=res.getString("finalTotal")%></th>
					<th><%=res.getString("American1")%></th>
					<th><%=res.getString("American2")%></th>
					<th><%=res.getString("American3")%></th>
					<th><%=res.getString("RIFLES")%></th>
					<th><%=res.getString("CATRIDGES")%></th>
					<th><%=res.getString("caliber")%></th>
		
				</tr>
			</thead>
			
			<tbody>
			<%for(ESFResult r : results){ %>
			<tr>
			
				<td>
					<aui:input name='<%= "shooter" + r.getEsfResultId()%>' readonly='true'
							value='<%=r.getShooterName()%>' label="" inlineField="true" class="italianShooter"></aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "card" + r.getEsfResultId()%>'
							value='<%=r.getCardNumber()%>' label="" inlineField="true" cssClass="nationaMatchResultMedium"  ></aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "descRanking" + r.getEsfResultId()%>' readonly='true'
							value='<%=r.getDescGroupRanking()%>' label="" inlineField="true" cssClass="nationaMatchResultMedium"  ></aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "position" + r.getEsfResultId()%>' 
							value='<%=r.getPosition()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall" >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s1" + r.getEsfResultId()%>' 
							value='<%=r.getResultS1()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall" >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s2" + r.getEsfResultId()%>' 
							value='<%=r.getResultS2()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >	
							<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s3" + r.getEsfResultId()%>' 
							value='<%=r.getResultS3()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s4" + r.getEsfResultId()%>' 
							value='<%=r.getResultS4()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s5" + r.getEsfResultId()%>' 
							value='<%=r.getResultS5()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s6" + r.getEsfResultId()%>' 
							value='<%=r.getResultS6()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s7" + r.getEsfResultId()%>' 
							value='<%=r.getResultS7()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				<td>
					<aui:input name='<%= "s8" + r.getEsfResultId()%>' 
							value='<%=r.getResultS8()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "totalS" + r.getEsfResultId()%>' readonly='true'
							value='<%=r.getTotalS()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "barrage" + r.getEsfResultId()%>' 
							value='<%=r.getBarrage()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "finalS" + r.getEsfResultId()%>' 
							value='<%=r.getFinalS()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "finalTotal" + r.getEsfResultId()%>' readonly='true'
							value='<%=r.getFinalTotal()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "american1" + r.getEsfResultId()%>' 
							value='<%=r.getAmerican1()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "american2" + r.getEsfResultId()%>' 
							value='<%=r.getAmerican2()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "american3" + r.getEsfResultId()%>' 
							value='<%=r.getAmerican3()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "rifle" + r.getEsfResultId()%>' 
							value='<%=r.getRifle()%>' label="" inlineField="true" cssClass="nationaMatchResultMedium"  >
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "catridge" + r.getEsfResultId()%>' 
							value='<%=r.getCatridge()%>' label="" inlineField="true" cssClass="nationaMatchResultMedium"  >
					</aui:input>
				</td>
				
				<td>
					<aui:input name='<%= "caliber" + r.getEsfResultId()%>' 
							value='<%=r.getCaliber()%>' label="" inlineField="true" cssClass="nationaMatchResultSmall"  >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</td>
			<tr>
			<% }%>
			</tbody>
		</table>
	</div>
		<aui:button-row>
			<aui:button cssClass='<%= isViewMode ? "hide" : ""%>' name="submit" type="submit" inlineField="true"></aui:button>
			<aui:button onClick='<%=backURL.toString() %>' value="back" inlineField="true"/>
		</aui:button-row>
</aui:form>


<script>
	function <portlet:namespace />submitUpdateResult(){
		
		
		submitForm(document.<portlet:namespace />fm);
	}
</script>
