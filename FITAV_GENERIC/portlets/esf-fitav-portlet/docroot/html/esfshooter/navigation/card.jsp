<%@page import="it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFShooterAffiliationChrono"%>
<%@page import="it.ethica.esf.model.impl.ESFOrganizationImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFCardImpl"%>
<%@include file="init.jsp"%>

<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
long esfCardId = ParamUtil.getLong(request, "esfCardId");
Calendar calendar = CalendarFactoryUtil.getCalendar();
String currDate = "";
currDate=ManageDate.CalendarToString(calendar);	
String namespace = renderResponse.getNamespace();
String associations = "";
String cardIdToString = StringPool.BLANK;


PortletURL cardURL = renderResponse.createRenderURL();

cardURL.setParameter(
	"mvcPath", "/html/esfshooter/navigation/card.jsp");
cardURL.setParameter(
		"esfUserId",String.valueOf(esfUserId));

System.out.println("esfUserId="+esfUserId);

%>

<portlet:renderURL var="chooseAssociationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value='<%="/html/esfshooter/popup/view.jsp"%>'></portlet:param>
</portlet:renderURL>


<%
if(!(esfUserId > 0)){

%>

<div class="btn-field-align">

	<aui:input type="text" label="associationsID" id="associations"
		name="associations" required="required" readonly="true" inlineField="true" />
		
	<aui:input type="text" label="associationsName" id="associationsName"
		name="associationsName" readonly="true" inlineField="true" />
		
	<aui:button class="aui-icon aui-icon-large aui-iconfont-add"
		id='<%=namespace + "chooseAssociationTrigger"%>' value="selectCompany" inlineField="true">
	</aui:button>
</div>
<aui:select id="cards" name="esfCardId" showEmptyOption="true" required="true" />

<%
	}else{

		List<ESFCard> esfCards = Collections.emptyList();
		List<ESFShooterAffiliationChrono> esfShooterAffiliationChronos = Collections.emptyList();
		ESFCard esfCard = null;
		ESFShooterAffiliationChrono esfShooterAffiliationChrono=null;

		if (esfUserId > 0) {
			esfCards = ESFCardLocalServiceUtil.findAllESFCardsByU_S(esfUserId, ESFKeys.ESFStateType.ENABLE);
			
			if (esfCards.size() > 0){
				esfCard = esfCards.get(0);
				cardIdToString = Long.toString(esfCard.getEsfCardId());
				System.out.println("card code per ricerca: "+esfCard.getCode());
				esfShooterAffiliationChronos=
						ESFShooterAffiliationChronoLocalServiceUtil.findChronobyCardAndYear(
								esfCard.getCode(), Calendar.getInstance().get(Calendar.YEAR));
				if(esfShooterAffiliationChronos.size()>0){
					esfShooterAffiliationChrono=esfShooterAffiliationChronos.get(0);
				}
			%>
			<aui:model-context bean="<%=esfCard%>" model="<%=ESFCard.class%>" />

<!-- Action della portlet -->
<portlet:actionURL name="changeCard" var="changeCard">
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<%
		if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getEsfCardId())){
	%>
	<portlet:param name="cardUserId"
		value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
	<%
		}
	%>
</portlet:actionURL>

<portlet:renderURL var="eChangeCard">
	<portlet:param name="mvcPath"
		value='<%=templatePath+"change_Card.jsp"%>' />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
	<%
		if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getEsfCardId())){
	%>
	<portlet:param name="cardUserId"
		value="<%=String.valueOf(esfCard.getEsfCardId())%>" />
	<%
		}
	%>
</portlet:renderURL>

<aui:form action="<%=changeCard%>" name="fm">
	<aui:fieldset>
		<%
			List<ESFOrganization> orgs=ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(currentOrganizationId);
				String displaySelect = "";
				if(orgs.size()>1){
			long  associationId =  esfUserId > 0 && Validator.isNotNull(esfCard) ? esfCard.getEsfOrganizationId():0;
		%>
		<div id="ass-content" style="display: none;">
			<aui:select id="associations" name="associations"
				showEmptyOption="true" required="true">
				<%
					for(ESFOrganization org :orgs){
								 String select="";
								 String name = "-";
								 Organization orgSel = OrganizationLocalServiceUtil.getOrganization(org.getEsfOrganizationId());
								 if(org.getEsfOrganizationId()==associationId)
									 select="selected='selected'";
				%>
				<option <%=select%> value="<%=org.getEsfOrganizationId()%>"><%=orgSel.getName()%>
				</option>

				<%
					}
				%>
			</aui:select>

		</div>
		<%
			}
			else {
		%>
		<aui:input type="hidden" id="esfOrganizationId"
			name="esfOrganizationId" value='<%=currentOrganizationId%>' />
		<%
			}
		%>
		<span style="display: none;"> <aui:select id="cards"
				name="esfCardId" showEmptyOption="true" required="true">
			</aui:select>
		</span>
	</aui:fieldset>
	<%
	String cardCode = "";
	String changeData = "";
	String actualOrg = "";
	Organization organization = null;
	String creditDate="";
	String paymentDate="";
	
	if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getCode())){
		cardCode = esfCard.getCode();
		if(Validator.isNotNull(esfCard.getModifiedDate())){
			changeData = sdf.format(esfCard.getModifiedDate());
		}
		
		organization = OrganizationLocalServiceUtil.fetchOrganization(esfCard.getEsfOrganizationId());
	}
	if(Validator.isNotNull(esfShooterAffiliationChrono)){
		System.out.println("non è  null il chrono");
		if(Validator.isNotNull(esfShooterAffiliationChrono.getAffiliationDate())){
			creditDate = sdf.format(esfShooterAffiliationChrono.getAffiliationDate());
		}
		if(Validator.isNotNull(esfShooterAffiliationChrono.getPaymentDate())){
			paymentDate = sdf.format(esfShooterAffiliationChrono.getPaymentDate());
		}
	}
	if(Validator.isNotNull(organization) && Validator.isNotNull(organization.getName())){
		actualOrg = organization.getName();
	}
	

	%>
	<portlet:renderURL var="removeCardURL">
	<portlet:param name="mvcPath"
		value='<%="/html/esfshooter/navigation/removeCard.jsp"%>'></portlet:param>
	<portlet:param name="cardUserId"
		value='<%=String.valueOf(esfCard.getEsfCardId())%>'></portlet:param>
	<portlet:param name="esfUserId"
		value='<%=String.valueOf(esfUser.getEsfUserId())%>'></portlet:param>
	</portlet:renderURL>
	
	<div class="btn-field-align">
		<aui:input type="text" label="actualCard" id="actualCard"
			name="actualCard" value='<%=cardCode%>' readonly="true"
			inlineField="true" align="right" />
		<aui:input type="text" label="creditDate" name="creditDate"
			value='<%=creditDate%>' readonly="true" inlineField="true" />
		<aui:input type="text" label="payment-date" name="payment-date"
			value='<%=paymentDate%>' readonly="true" inlineField="true" />
		
		<aui:input type="text" label="assotiation-name"
			name="assotiation-name" value='<%=actualOrg%>' readonly="true"
			inlineField="true" />
		<c:if test="<%= ESFShooterPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFSHOOTER_CHANGE_CARD) %>">	
			<aui:button id="change" value="change-card"
				onClick="<%=eChangeCard.toString() %>" inlineField="true"/>
		</c:if>
		<%if(Validator.isNotNull(esfCard)){ %>
		<c:if test="<%= ESFShooterPermission.contains(permissionChecker,esfUser.getEsfUserId(), ActionKeys.ESFSHOOTER_REMOVE_CARD) %>">	

		<aui:button id="change" value="remove-card"
				onClick="<%=removeCardURL.toString() %>" inlineField="true" />
		</c:if>
		<%} %>
			
	</div>
</aui:form>
			
	<%}
	else{
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		calendar.setTime(new Date());
		String	startDate = calendar.toString() ;
		startDate= format1.format(new Date());
	%>
	<portlet:renderURL var="assignNewCardURL">
		<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>"/>
		<portlet:param name="mvcPath"
					value="/html/esfshooter/navigation/addNewCard.jsp"/>
	</portlet:renderURL>
	
	<aui:button type="button" value="assign-card" onClick="<%= assignNewCardURL.toString()%>" />
	
	<%
	}
}
%>


<c:choose>
	<c:when test="<%=esfUser != null%>">
		<liferay-ui:search-container emptyResultsMessage="no-card" curParam="cardParam" iteratorURL="<%=cardURL %>">
			<liferay-ui:search-container-results>
				<%
					List<ESFCard> userCards = ESFCardLocalServiceUtil
								.findAllESFCardsByU_S_Y(esfUser.getPrimaryKey(), new Date());
					int tot = ESFCardLocalServiceUtil
							.findAllESFCardsByU_S_Y(esfUser.getPrimaryKey(), new Date()).size();
					
					int start = searchContainer.getStart();
					int end = searchContainer.getEnd();
					
					if(end > userCards.size()){
						userCards = userCards.subList(start, userCards.size());
						
					}else{
						userCards = userCards.subList(start, end);
					}

						pageContext.setAttribute("results", userCards);
						pageContext.setAttribute("total", tot);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFCard" modelVar="card">
				<%
					String cardCode = "";
					if(Validator.isNotNull(esfCard) && Validator.isNotNull(esfCard.getCode())){
						cardCode = esfCard.getCode();
						
					}
				%>

				<liferay-ui:search-container-column-text property="code"
					value="<%=cardCode%>" />
				<%
					long esfOgranizzationId = card.getEsfOrganizationId();
							String orgName = "";
							if(esfOgranizzationId > 0){
								if(Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOgranizzationId)) &&
										Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOgranizzationId).getName())){
									orgName = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOgranizzationId).getName();
									}
							}
				%>
				<liferay-ui:search-container-column-text name="orgName"
					value="<%=orgName%>" />

				<%
					String creationYear =  "";
						if(Validator.isNotNull(card.getPrimaryKey()) && Validator.isNotNull(ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
								ESFCard.class.getName(), card.getPrimaryKey()))){
							ESFEntityState esfES = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
													ESFCard.class.getName(), card.getPrimaryKey());
							
							int creationYearInt = ManageDate.getYear(esfES.getStartDate());
							creationYear =  "" + ManageDate.getYear(esfES.getStartDate());
							_log.info("creation year: "+creationYearInt);
							List<ESFShooterAffiliationChrono> esfShooterAffiliationChronosList = Collections.emptyList();
							ESFShooterAffiliationChrono esfShooterAffiliationChronoResult=null;
							System.out.println("year: "+creationYearInt+" card code: "+card.getCode());
							try{
								esfShooterAffiliationChronosList=
								ESFShooterAffiliationChronoLocalServiceUtil.findChronobyCardAndYear(
										card.getCode(), creationYearInt);
								if(esfShooterAffiliationChronosList.size()>0){
									esfShooterAffiliationChronoResult=esfShooterAffiliationChronosList.get(0);
								}
							}catch(NullPointerException ex)
							{
								System.out.println("non ho trovato match su esfshooterchrono");
							};
							String creditDate="";
							String paymentDate="";
							if(Validator.isNotNull(esfShooterAffiliationChronoResult)){
								System.out.println("non è  null il chrono");
								if(Validator.isNotNull(esfShooterAffiliationChronoResult.getAffiliationDate())){
									creditDate = sdf.format(esfShooterAffiliationChronoResult.getAffiliationDate());
								}
								if(Validator.isNotNull(esfShooterAffiliationChronoResult.getPaymentDate())){
									paymentDate = sdf.format(esfShooterAffiliationChronoResult.getPaymentDate());
								}
							}
				%>

				<liferay-ui:search-container-column-text name="releaseYear"
					value="<%=creationYear%>" />
				<liferay-ui:search-container-column-text name="creditDate"
					value="<%=creditDate%>" />
				<liferay-ui:search-container-column-text name="payment-date"
					value="<%=paymentDate%>" />
				<%
					}
				%>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</c:when>
</c:choose>
<%
}

%>


<portlet:resourceURL var="associationsURL" id="associations" escapeXml="false" />

<aui:script use="node,aui-io-request">

var cardsOptions = '<option value="">-</option>';
var cardId = '<%= cardIdToString %>';

if(A.one("#<portlet:namespace />associations")  ){
A.one('#<portlet:namespace/>cards').html(cardsOptions);
A.one("#<portlet:namespace />associations").on('focus',changeSelect);
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
if(A.one('#<portlet:namespace/>chooseAssociationTrigger')){
	AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	
		A.one('#<portlet:namespace/>chooseAssociationTrigger').on('click', function(event){
		var login_popup= Liferay.Util.openWindow({
			dialog: {
				centered: true,
				destroyOnClose: true,
				cache: false,
				width: 700,
				height: 500,
				modal: true
			},
			title: 'Scegli organizzazione',
			id:'<portlet:namespace/>chooseAssociationPopUp',
			uri:'<%=chooseAssociationURL.toString()%>'
			});
	
		});
	});
}
Liferay.provide(
		window,
		'<portlet:namespace/>retrieveAssociation',
		function(dataId, dataName) {
			var A = AUI();

			A.one('#<portlet:namespace/>associations').set('value', dataId);
			A.one('#<portlet:namespace/>associationsName').set('value',dataName);
			var dialog = Liferay.Util.Window.getById('<portlet:namespace/>chooseAssociationPopUp');
			dialog.destroy();
			A.one('#<portlet:namespace/>associations').focus();
		},
		['liferay-util-window']
);
	
$(function() {
	
	$("#<portlet:namespace/>startDate").datepicker();
	$("#<portlet:namespace/>startDate").datepicker("option", "dateFormat", "dd/mm/yy");
	$("#<portlet:namespace/>startDate").datepicker("setDate", "<%= currDate %>" );
	
});

</aui:script>
