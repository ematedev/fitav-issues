<%@include file="init.jsp"%>

<%

	String className = (String)request.getAttribute("addresses.className");
	long classPK = (Long)request.getAttribute("addresses.classPK");
	int numField = 0;
	String categoryAssosiation = "";

	boolean readOnlyCode=!ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_CODE);
		
	boolean readOnlyName=!ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_NAME);
	
	boolean readOnlyField=!ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_ADDRESS_FIELD);
	
	boolean readOnlyAffiliation=!ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_AFFILIATION);
	
	boolean readOnlyFiscalCode=!ESFOrganizationDisplayPermission.contains(permissionChecker,currentOrganizationId, ActionKeys.ESFORGANIZATIONDISPLAY_UPDATE_FISCAL_CODE);


%>

<aui:fieldset>


	<aui:model-context bean="<%=currentESFOrganization%>"
		model="<%=ESFOrganization.class%>" />
		
	<div class = "row">
		<div class = "span6">
			<div id="idOne">

				<c:if
					test="<%=currentType == ESFKeys.ESFOrganizationTypeId.ASSOCIATION%>">

					<c:choose>
						<c:when test="<%=readOnlyCode %>">
							<aui:input name="codet" type="text" label="code" disabled="true" value="<%= currentESFOrganization.getCode() %>" />
							<aui:input name="codet" type="hidden" value="<%= currentESFOrganization.getCode() %>" />
						</c:when>
						<c:otherwise>
							<aui:input name="code">
								<aui:validator name="required" 
									errorMessage="this-field-is-required" />
							</aui:input>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:choose>
					<c:when test="<%= readOnlyName %>">
						<aui:input name="namet" type="text" label="name" disabled="true" value="<%= currentESFOrganization.getName() %>" />
						<aui:input name="name" type="hidden" value="<%= currentESFOrganization.getName() %>"></aui:input>
					</c:when>
					<c:otherwise>
						<aui:input name="name" >
							<aui:validator name="required"
								errorMessage="this-field-is-required" />
						</aui:input>
					</c:otherwise>
				</c:choose>
				
	
		</div>
	</div>
		<div class = "span6">
			<div id="idOne">
			
				<%
					String emailAddress = StringPool.BLANK;
			
						if (currentESFOrganization != null) {
			
							List<EmailAddress> emailAddresses =
								EmailAddressLocalServiceUtil.getEmailAddresses(
									themeDisplay.getCompanyId(),
									Organization.class.getName(),
									currentESFOrganization.getEsfOrganizationId());
			
							if (emailAddresses != null && emailAddresses.size() > 0) {
			
								emailAddress = emailAddresses.get(0).getAddress();
							}
						}
				%>
			
				
				<aui:input name="emailAddress" value="<%=emailAddress%>">
					<aui:validator name="required" errorMessage="this-field-is-required" />
					<aui:validator name="email" errorMessage="please-enter-a-valid-email-address" />
				</aui:input>
				
				<aui:input name="webSite" value="<%=currentESFOrganization.getWebSite()%>"></aui:input>
						
				</div>
		</div>
	</div>
	
		<%
			String iesima =Integer.toString(ESFKeys.ESFAddressType.TYPES_POSITION_FIELD);
		%>
	
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">	
			<liferay-util:include page='<%= jspAddressTL %>' servletContext="<%= application%>" >
				<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
				<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
				<liferay-util:param name="iesima" value="<%= iesima %>"></liferay-util:param>
				<liferay-util:param name="idOwner" value="<%= Long.toString(currentOrganizationId) %>"></liferay-util:param>
				<liferay-util:param name="listTypeId" value="<%= Integer.toString(ESFAddressListType.STAND) %>"></liferay-util:param>
				<liferay-util:param name="requiredField" value="false"></liferay-util:param>
				<liferay-util:param name="readOnly" value="<%= String.valueOf( readOnlyField) %>"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>

	<%

		Calendar calendar = CalendarFactoryUtil.getCalendar();
		String currDateE = "";
		String currDateFA = "";
		
		if(currentESFOrganization!=null && currentESFOrganization.getEstablishmentDate() != null)
			currDateE =ManageDate.DateToString(currentESFOrganization.getEstablishmentDate());
		
		if(currentESFOrganization!=null && currentESFOrganization.getFirstAffiliationDate() != null)
		 currDateFA =ManageDate.DateToString(currentESFOrganization.getFirstAffiliationDate());
	%>

	<aui:script>
		$(function() {
			$("#<portlet:namespace/>firstAffiliationDate").datepicker();
			$("#<portlet:namespace/>firstAffiliationDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>firstAffiliationDate").datepicker("setDate", '<%= currDateFA %>');
			
		});
		
		
		$(function() {
			$("#<portlet:namespace/>establishmentDate").datepicker();
			$("#<portlet:namespace/>establishmentDate").datepicker("option", "dateFormat", "dd/mm/yy");
			$("#<portlet:namespace/>establishmentDate").datepicker("setDate", '<%= currDateE %>');
			
		});
	</aui:script>

	<div class = "row">
		<div class = "span6">
			<aui:input type="radio" label="is-mono-sport" name="isMultiSport"
					value="false" />
				<aui:input type="radio" label="is-multi-sport" name="isMultiSport"
					value="true" />
		</div>
		<div class = "span6">
			<aui:input name="isYouthActive" />
			
			<aui:input name="addToConiReport" label="add_to_coni_report" type="checkbox" value="<%=currentESFOrganization.getConiCode() %>"></aui:input>
		</div>
	</div>
	<div class="row">
		<div class="span6">
			<div id="idOne">

					<%
						numField=ESFFieldLocalServiceUtil.
							findByESFOrganization(currentOrganizationId,ESFKeys.ESFStateType.ENABLE).size();
						if(numField==1 || numField == 0){
							categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
						}else if(numField==2 || numField ==3){
							categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
						}else if(numField==4 || numField ==5){
							categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
						}else{
							categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
						}
					%>

				<aui:input type="text" label="Category" name="Category" disabled="true"
					value='<%= categoryAssosiation%>' />


				<c:choose>
					<c:when test="<%=readOnlyAffiliation%>">
						<aui:input name="firstAffiliationDatet" type="text" label="firstAffiliationDate" disabled="true" value="<%=currentESFOrganization.getFirstAffiliationDate()%>" />
						<aui:input name="firstAffiliationDate" type="hidden" value="<%=currentESFOrganization.getFirstAffiliationDate() %>"></aui:input>
					</c:when>
					<c:otherwise>
						<aui:input name="firstAffiliationDate" type="text" >
							<aui:validator name="required"
								errorMessage="this-field-is-required" />
						</aui:input>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class="span6">
			<div id="idOne">

				<aui:input name="vat" />

				<c:choose>
					<c:when test="<%= readOnlyFiscalCode %>">
						<aui:input name="fiscalCodet" type="text" label="fiscalCode" disabled="true" value="<%= currentESFOrganization.getFiscalCode() %>" />
						<aui:input name="fiscalCode" type="hidden" value="<%= currentESFOrganization.getFiscalCode() %>"></aui:input>
					</c:when>
					<c:otherwise>
						<aui:input name="fiscalCode" value="<%= currentESFOrganization.getFiscalCode() %>">
							<%if(!currentESFOrganization.getIsSimplyOrganizzation()){ %>
							<aui:validator name="required"
								errorMessage="this-field-is-required" />
							<%} %>
						</aui:input>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>

</aui:fieldset>

<c:if test="<%=currentType == ESFKeys.ESFOrganizationTypeId.ASSOCIATION %>">

	<portlet:resourceURL var='setCodeURL' id='code' escapeXml="false" />

	<aui:script
		use="node,aui-io-request,aui-dialog,aui-aria, aui-dialog, aui-overlay-manager,dd-constrain">
	
		if(A.one('#<portlet:namespace/>provinces0')){
			A.one('#<portlet:namespace/>provinces0').on('change', setCode);
		}
		
		function setCode(event) {
			var element = event.currentTarget;
			var type = element.get('id').replace('<portlet:namespace/>', '');
			var param = '';
			var idProvince = A.one('#<portlet:namespace/>provinces0').get(
					'value');

			var resourceURL = '<%= setCodeURL %>';

			A.io.request(resourceURL, {
				method : 'POST',
				contentType : "application/json; charset=utf-8",
				data : {
					idProvince : idProvince
				},
				on : {
					success : function() {
						var results = JSON.parse(this.get('responseData'));
						var tmpCode = A.one('#<portlet:namespace/>code').get(
								"value");
						if (tmpCode == null || tmpCode === '')
							A.one('#<portlet:namespace/>code').set("value",
									results[0]);
						else {
							if (confirm(Liferay.Language.get('change-code'))) {
								A.one('#<portlet:namespace/>code').set("value",
										results[0]);
							}
						}
					}
				}
			});
		}
	
			
		</aui:script>

</c:if>