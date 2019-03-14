<%@include file="init.jsp"%>

<%
	String className = (String)request.getAttribute("addresses.className");
	long classPK = (Long)request.getAttribute("addresses.classPK");
	boolean  isCkisarmy = ParamUtil.getBoolean(request,"ckisarmy");

%>

<aui:fieldset>
	<aui:model-context bean="<%=esfOrganization%>"
		model="<%=ESFOrganization.class%>" />

	<aui:input name="name" label="denomination">
		<aui:validator name="required" errorMessage="this-field-is-required" />
	</aui:input>
	
	<liferay-util:include page='<%= jspAddressTL %>' servletContext="<%= application%>" >
		<liferay-util:param name="className" value="<%= className %>"></liferay-util:param>
		<liferay-util:param name="classPK" value="<%= Long.toString(classPK) %>"></liferay-util:param>
		<liferay-util:param name="iesima" value="<%= Integer.toString(0) %>"></liferay-util:param>
		<liferay-util:param name="idOwner" value="<%= Long.toString(esfOrganizationId) %>"></liferay-util:param>
		<liferay-util:param name="listTypeId" value="<%= Integer.toString(ESFAddressListType.LEGAL) %>"></liferay-util:param>
		<liferay-util:param name="requiredField" value="true"></liferay-util:param>
	</liferay-util:include>
	
	<div class="separator"></div>

	<div class = "row detail">
	
		<div class = "span6">
		
			<aui:input name="code">
				<aui:validator name="required" errorMessage="this-field-is-required" />
			</aui:input>
			
			<%
				String emailAddress = StringPool.BLANK;
				String webSite = StringPool.BLANK;
		
				if (esfOrganization != null) {
		
					List<EmailAddress> emailAddresses = EmailAddressLocalServiceUtil
					.getEmailAddresses(themeDisplay.getCompanyId(),
							Organization.class.getName(),
							esfOrganization.getEsfOrganizationId());
		
					if (emailAddresses != null && emailAddresses.size() > 0) {
		
						emailAddress = emailAddresses.get(0).getAddress();
					}
					webSite = esfOrganization.getWebSite();
				}
			%>
	
				<aui:input name="emailAddress" value="<%=emailAddress%>">
					<aui:validator name="required" errorMessage="this-field-is-required" />
					<aui:validator name="email" errorMessage="please-enter-a-valid-email-address" />
				</aui:input>
				
				<aui:input name="webSite" value="<%=webSite%>"/>

				<aui:input name="fiscalCode" >
				<%if(!isCkisarmy){ %>
					<aui:validator name="required" errorMessage="this-field-is-required" />
				<%} %>
				</aui:input>
				<aui:input name="vat" />
				<aui:input name="ibanCode" />
				
				<h4><liferay-ui:message key="type-association"/></h4>
				<aui:input type="radio" label="is-mono-sport" name="isMultiSport" value="false" />
				<aui:input type="radio" label="is-multi-sport" name="isMultiSport" value="true" />
			</div>
			<div class = "span6">
				<aui:select name="legalForm">
					<%
						List<ListType> legalForms =  ListTypeServiceUtil.getListTypes(ESFOrganization.class.getName() + ESFListType.LEGAL_FORM);
			
						for (ListType legalForm : legalForms) {
					%>
			
							<aui:option label="<%=legalForm.getName()%>" value="<%=legalForm.getListTypeId()%>" />
			
					<%
						}
					%>
				</aui:select>
				
				<%
					Calendar calendar = CalendarFactoryUtil.getCalendar();
					String currDateE = "";
					String currDateFA = "";
					
					if(esfOrganization!=null && esfOrganization.getEstablishmentDate() != null)
						currDateE =ManageDate.DateToString(esfOrganization.getEstablishmentDate());
					
					if(esfOrganization!=null && esfOrganization.getFirstAffiliationDate() != null)
					 currDateFA =ManageDate.DateToString(esfOrganization.getFirstAffiliationDate());
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

			
				<aui:input name="establishmentDate" type="text" >
					<aui:validator name="required" errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="firstAffiliationDate" type="text" >
					<aui:validator name="required" errorMessage="this-field-is-required" />
				</aui:input>
				
				<aui:input name="isYouthActive" />
			
				<aui:input type="checkbox" name="constitutiveAct" />
				
				<aui:input type="checkbox" name="registeredStatus" />
				
				<aui:input type="checkbox" name="planimetrySportsStand" />
				
				<aui:input type="checkbox" name="certificateFITAV" />
				
				<aui:input name="description" type="textarea" />
				
				<aui:input name="note" type="textarea" />
			</div>
	</div>
</aui:fieldset>

<portlet:resourceURL var='setCodeURL' id='code'  escapeXml="false" />

<aui:script use="node,aui-io-request,aui-dialog,aui-aria, aui-dialog, aui-overlay-manager,dd-constrain">	

	A.one('#<portlet:namespace/>provinces0').on('change', setCode);
	
	function setCode(event) {
		var element = event.currentTarget;
		var type = element.get('id').replace('<portlet:namespace/>', '');
		var param = '';
		var idProvince = A.one('#<portlet:namespace/>provinces0').get('value');
		
		var resourceURL = '<%= setCodeURL %>';
		
		A.io.request(
			resourceURL,
			{
				method: 'POST',
				contentType: "application/json; charset=utf-8",
				data: {
					idProvince:idProvince
				},
				on: {
					success: function() {
						var results = JSON.parse(this.get('responseData'));
						var tmpCode=A.one('#<portlet:namespace/>code').get("value");
						if(tmpCode==null || tmpCode === '')
							A.one('#<portlet:namespace/>code').set("value",results[0]);
						else{
							if (confirm(Liferay.Language.get('change-code'))) {
								A.one('#<portlet:namespace/>code').set("value",results[0]);
							}
						}
					}
				}
			}
		);
	}

	
	
</aui:script>
