<%@include file="init.jsp"%>

<%
	List<ESFCard> esfCards = Collections.emptyList();
	ESFCard esfCard = null;
	String associations;
	String cardIdToString=StringPool.BLANK;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	List<ESFCard> esfCardstry = new ArrayList<ESFCard>();
	esfCardstry = ESFCardLocalServiceUtil.findActualUserCards(esfUserId);
			
			
	currentOrganizationId = ParamUtil.getLong(renderRequest, "currentOrganizationId");
	if (esfUserId > 0) {
		//esfCards = ESFCardLocalServiceUtil.findAllESFCardsByU_S(esfUserId, ESFKeys.ESFStateType.ENABLE);
		esfCards = ESFCardLocalServiceUtil.findActualUserCards(esfUserId);
		if (esfCards.size() > 0){
			esfCard = esfCards.get(0);
			cardIdToString=Long.toString(esfCard.getEsfCardId());
		}
		else{
			List<ESFCard> cards = Collections.emptyList();
			cards = ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(currentOrganizationId, ESFKeys.ESFStateType.ENABLE);
			System.out.println("cards="+cards);
			if(Validator.isNotNull(cards) && cards.size() > 0){
				esfCard = cards.get(0);
				cardIdToString=Long.toString(esfCard.getEsfCardId());
			}
		}
	}

%>

<portlet:resourceURL var="associationsURL" id="associations" escapeXml="false" />

<aui:script use="node,aui-io-request">
	var cardsOptions = '<option value="">-</option>';
	var cardId = '<%= cardIdToString %>';

	A.one('#<portlet:namespace/>cards').html(cardsOptions);
	
	if(A.one('#<portlet:namespace/>associations'))	{
		A.one("#<portlet:namespace />associations").on("change",changeSelect);
	}

	function changeSelect(event) {
		var element = event.currentTarget;
		var type = element.get('id').replace('<portlet:namespace/>', '');
		var idAssociation = A.one('#<portlet:namespace/>associations').get('value');
		var resourceURL = '<%= associationsURL %>';
		callAction(resourceURL, idAssociation, type);
		
	}

	function callAction(resourceURL, idAssociation, type) {
		A.io
				.request(
						resourceURL,
						{
							method : 'POST',
							contentType : "application/json; charset=utf-8",
							data : {
								param : '',
								idAssociation : idAssociation,
								esfUserId : '<%= esfUserId%>'
							},
							on : {
								success : function() {
									var results = JSON.parse(this
											.get('responseData'));
									var resultsOption = '<option value="">-</option>';
									if (type == 'associations') {
										if (results.length > 0)
											resultsOption = '';
										for (index in results) {
											if (results[index][0] == cardId)
												resultsOption += '<option selected="selected" value="'+ results[index][0] +'">'
														+ results[index][1]
														+ '</option>';
											else
												resultsOption += '<option value="'+ results[index][0] +'">'
														+ results[index][1]
														+ '</option>';
										}
										A.one('#<portlet:namespace/>cards')
												.html(resultsOption);
									}
								}
							}
						});
	}
	if(A.one('#<portlet:namespace/>esfOrganizationId')){
		idAssociation = A.one('#<portlet:namespace/>esfOrganizationId').get('value');
		callAction('<%= associationsURL %>',idAssociation,'associations');
	}
</aui:script>

<aui:model-context bean="<%=esfCard%>" model="<%=ESFCard.class%>" />

<!-- Action della portlet -->
<portlet:actionURL name="changeCard" var="changeCard">
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
		<%if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getEsfCardId())){ %>
		<portlet:param name="cardUserId" value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
		<%} %>
</portlet:actionURL>

<portlet:renderURL var="eChangeCard">
		<portlet:param name="mvcPath"
					value='<%= templatePath+"change_Card.jsp" %>' />
		<portlet:param name="esfUserId"
										value="<%=String.valueOf(esfUserId) %>" />
		<%if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getEsfCardId())){ %>
		<portlet:param name="cardUserId" value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
		<%} %>
</portlet:renderURL>

<aui:form action="<%= changeCard %>">
<aui:fieldset>
	<%
		List<ESFOrganization> orgs=ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId);
		String displaySelect = "";
		if(orgs.size()>1){
			long  associationId =  esfUserId > 0? esfCard.getEsfOrganizationId():0;
		%>
			<div id="ass-content" style="display:none;">
				<aui:select id="associations" name="associations"
					showEmptyOption="true" >
					<%
					 for(ESFOrganization org :orgs){
						 String select="";
						 if(org.getEsfOrganizationId()==associationId)
							 select="selected='selected'";
					%>
						<option <%=select %>  value="<%= org.getEsfOrganizationId()%>"><%=org.getName() %>	</option>
	
					<%
					 }
					%>
				</aui:select>
				
				
				
			</div>
		<%
			}
			else {
			%>
				<aui:input type="hidden" id = "esfOrganizationId" name="esfOrganizationId"  value='<%=currentOrganizationId%>' />
			<%
			}
		%>
   <span style="display:none;" >
	<aui:select id="cards" name="esfCardId" showEmptyOption="true">
	</aui:select>
	</span>
</aui:fieldset>

<%

String cardCode = "";
String changeData = "";
String actualOrg = "";
Organization organization = null;
if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getCode())){
	cardCode = esfCard.getCode();
	changeData = sdf.format(esfCard.getModifiedDate());
	organization = OrganizationLocalServiceUtil.fetchOrganization(esfCard.getEsfOrganizationId());
}
if(Validator.isNotNull(organization) && Validator.isNotNull(organization.getName())){
	actualOrg = organization.getName();
}
if(Validator.isNotNull(esfCard)){
%>

<div class="btn-field-align">
<aui:input type="text" label="actualCard" id = "actualCard" name="actualCard"  value='<%=esfCard.getCode()%>' readonly="true" inlineField="true"/>
<aui:input type="text" label="date-change" name="date-change"  value='<%=changeData%>' readonly="true" inlineField="true"/>
<aui:input type="text" label="assotiation-name" name="assotiation-name" value='<%=actualOrg%>' readonly="true" inlineField="true"/>

<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_SHOOTER_UPDATE) %>">	
							
<aui:button id="change" value="change-card" onClick="<%=eChangeCard.toString() %>" inlineField="true"/>
</c:if>

</div>
<%} %>
</aui:form>
<c:choose>
	<c:when test="<%=esfUser != null%>">
		<liferay-ui:search-container emptyResultsMessage="no-card">
			<liferay-ui:search-container-results>
				<%
					List<ESFCard> userCards = ESFCardLocalServiceUtil
						.findAllESFCardsByU_S_Y(esfUser.getPrimaryKey(), new Date());
				pageContext.setAttribute("results", userCards);
				pageContext.setAttribute("total", userCards.size());
				
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFCard" modelVar="card">
				<liferay-ui:search-container-column-text property="code"
					value="<%=card.getCode()%>" />
				<%
					long esfOgranizzationId = card.getEsfOrganizationId();
					String orgName = "";
					if(esfOgranizzationId > 0){
						if(Validator.isNotNull(ESFOrganizationLocalServiceUtil.
									fetchESFOrganization(esfOgranizzationId))){
							orgName = ESFOrganizationLocalServiceUtil.
											fetchESFOrganization(
												esfOgranizzationId).getName();
							}
					}
					%>
				<liferay-ui:search-container-column-text name="orgName"
					value="<%=orgName%>" />

				<% 
				String creationYear =  "";
				if(Validator.isNotNull(card.getPrimaryKey()) && Validator.isNotNull(ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
						ESFCard.class.getName(), card.getPrimaryKey()))){
				ESFEntityState esfES = ESFEntityStateLocalServiceUtil.
										findESFEntityStateByC_PK(
											ESFCard.class.getName(),
														card.getPrimaryKey());
					
					creationYear =  "" + ManageDate.getYear(esfES.getStartDate());
					%>

				<liferay-ui:search-container-column-text name="releaseYear"
					value="<%=creationYear%>" />
				<liferay-ui:search-container-column-text name="date-change" value="<%=sdf.format(esfES.getEndDate())%>" />
				<%} %>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</c:when>
</c:choose>

