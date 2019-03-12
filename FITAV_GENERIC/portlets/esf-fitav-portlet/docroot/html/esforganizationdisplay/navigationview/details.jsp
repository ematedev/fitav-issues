
<%@page import="it.ethica.esf.renewal.model.ESFRenewalCompany"%>
<%@page import="it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil"%>
<%@include file="init.jsp"%>

<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	String namespace = renderResponse.getNamespace();
	Date yearData = ManageDate.CalendarToDate(calendar);
	int thisYear = ManageDate.getYear(yearData);

	ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil
			.findESFEntityStateByC_PK(ESFOrganization.class.getName(),
					currentOrganizationId);

	List<ESFRenewal> renevals = ESFRenewalLocalServiceUtil
			.findByOrg_Year(currentOrganizationId, thisYear);

	String stateChanged = "";
	String variationChanged = "";
	String noShooter = "no_number_min_of_shooter";
	String noPresident = "no_president";
	String noSecretary = "no_secretary";
	String no_outstanding_payments = "no_outstanding_payments";
	String out_standing_payments = "out_standing_payments";
	String no_payment_execute = "no_payment_execute";
	String coni_report_info = "no_coni_report";
	
	
	boolean missing_requirements_president = true;
	boolean missing_requirements_secretary = true;
	boolean missing_requirements_shooter = false;
	boolean paymentOk = false;
	boolean partialPayment = false;
	if (Validator.isNotNull(esfEntityState)) {
		stateChanged = ESFStateLocalServiceUtil.fetchESFState(
				esfEntityState.getEsfStateId()).getName()
				+ "**";
	}
	ESFOrganization org = null;
	org = ESFOrganizationLocalServiceUtil
			.fetchESFOrganization(currentOrganizationId);
	Integer varOrgId = (int) org.getVariations();
	if (varOrgId > 0) {
		variationChanged = ListTypeServiceUtil.getListType(varOrgId)
				.getName();
	}
	int minShooter = Integer.parseInt(ESFConfigurationLocalServiceUtil
			.getESFConfigurationByESFKey(
					"min-number-shooter-for-activate-association")
			.getValue());

	List<ESFUserESFUserRole> bdoUserRole = ESFUserESFUserRoleLocalServiceUtil
			.findESFUserESFRolesByEsfOrganizzationId(currentOrganizationId);

	Role president = RoleLocalServiceUtil.getRole(
			themeDisplay.getCompanyId(), "Presidente Associazione");
	Role secretary = RoleLocalServiceUtil.getRole(
			themeDisplay.getCompanyId(), "Segretario Associazione");
	String presidentValue = ESFConfigurationLocalServiceUtil
			.getESFConfigurationByESFKey(
					"presdent-is-required-for-activate-association")
			.getValue();
	String secretarytValue = ESFConfigurationLocalServiceUtil
			.getESFConfigurationByESFKey(
					"secretary-is-required-for-activate-association")
			.getValue();

	for (ESFUserESFUserRole bdo : bdoUserRole) {
		if (Boolean
				.valueOf(ESFConfigurationLocalServiceUtil
						.getESFConfigurationByESFKey(
								"presdent-is-required-for-activate-association")
						.getValue())
				&& (bdo.getEsfUserRoleId() == president.getClassPK())) {
			missing_requirements_president = false;
		}
		if (Boolean
				.valueOf(ESFConfigurationLocalServiceUtil
						.getESFConfigurationByESFKey(
								"secretary-is-required-for-activate-association")
						.getValue())
				&& (bdo.getEsfUserRoleId() == secretary.getClassPK())) {
			missing_requirements_secretary = false;
		}

	}
	List<ESFUser> orgShooter = ESFUserLocalServiceUtil
			.getAllUserByLikeF_C_S("", "", "",
					ESFKeys.ESFStateType.ENABLE, currentOrganizationId);

	if ((Validator.isNull(orgShooter) && 0 < minShooter)
			|| orgShooter.size() < minShooter) {
		missing_requirements_shooter = true;
	}

	/*if (renevals.size() > 0) {
		for (ESFRenewal r : renevals) {
			if (r.getIsTotal()) {
				paymentOk = true;
			}
		}
	}*/
	if(currentESFOrganization.getIncludeConiReport()){
		coni_report_info = "added_to_coni_report";
	}
	
	ESFRenewalCompany renewalCompany = null;
	renewalCompany = ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByE_Y(currentOrganizationId, thisYear);
	if(Validator.isNotNull(renewalCompany) && 2 == renewalCompany.getStatus()){
		paymentOk = true;
	}else if (Validator.isNotNull(renewalCompany) && 1 == renewalCompany.getStatus()){
		partialPayment = true;
	}
	
	
%>

<c:choose>
	<c:when test="<%=currentESFOrganization != null%>">
		<%
			int numField = 0;
					String categoryAssosiation = "";
					String emailAddress = StringPool.BLANK;
					List<EmailAddress> emailAddresses = EmailAddressLocalServiceUtil
							.getEmailAddresses(themeDisplay.getCompanyId(),
									Organization.class.getName(),
									currentESFOrganization
											.getEsfOrganizationId());

					if (emailAddresses != null && emailAddresses.size() > 0) {
						emailAddress = emailAddresses.get(0).getAddress();
					}

					String city = "";
					String province = "";
					String region = "";
					String street = "";
					String zip = "";
					ListType addressType = null;

					if (esfAddressesToPrint.length > ESFKeys.ESFAddressType.TYPES_POSITION_FIELD
							&& Validator
									.isNotNull(esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD])) {

						if (Validator
								.isNull(esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
										.getListTypeId())) {

							addressType = ListTypeServiceUtil
									.getListType(ESFAddressListType.OTHER);
						} else {

							addressType = ListTypeServiceUtil
									.getListType(esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
											.getListTypeId());

						}

						long idCity = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
								.getEsfCityId();
						String idCountry = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
								.getEsfCountryId();
						String idProvince = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
								.getEsfProvinceId();
						String idRegion = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
								.getEsfRegionId();

						if (idCity > 0) {
							ESFCityPK cityPk = new ESFCityPK();
							cityPk.setIdCity(idCity);
							cityPk.setIdCountry(idCountry);
							cityPk.setIdProvince(idProvince);
							cityPk.setIdRegion(idRegion);
							if (Validator.isNotNull(cityPk)
									&& Validator
											.isNotNull(ESFCityLocalServiceUtil
													.fetchESFCity(cityPk))) {
								city = ESFCityLocalServiceUtil.fetchESFCity(
										cityPk).getName();
							}

						}

						if (Validator.isNotNull(idProvince)) {
							ESFRegionPK regionPK = new ESFRegionPK();
							regionPK.setIdRegion(idRegion);
							regionPK.setIdCountry(idCountry);
							region = ESFRegionLocalServiceUtil.fetchESFRegion(
									regionPK).getName();
						}

						if (Validator.isNotNull(idProvince)) {
							ESFProvincePK provincePK = new ESFProvincePK();
							provincePK.setIdProvince(idProvince);
							provincePK.setIdCountry(idCountry);
							provincePK.setIdRegion(idRegion);
							province = ESFProvinceLocalServiceUtil
									.fetchESFProvince(provincePK).getName();
						}
						street = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
								.getStreet1();
						zip = esfAddressesToPrint[ESFKeys.ESFAddressType.TYPES_POSITION_FIELD]
								.getZip();
					}
		%>

		<div class="row detail">
			<div class="span6">
				<h4>
					<liferay-ui:message key="code" />
				</h4>
				<p><%=currentESFOrganization.getCode()%></p>

				<h4>
					<liferay-ui:message key="denomination" />
				</h4>
				<p><%=currentESFOrganization.getName()%></p>
				
				<h4>
				<b><liferay-ui:message key="<%=coni_report_info%>" /> </b>
				</h4>
				
			</div>
			<div class="span6">
				<%
					String className = (String) request
									.getAttribute("phones.className");
							long classPK = (Long) request
									.getAttribute("phones.classPK");
							List<Phone> phones = PhoneLocalServiceUtil.getPhones(
									themeDisplay.getCompanyId(), className, classPK);
				%>

				<h4>
					<liferay-ui:message key="phone-number"></liferay-ui:message>
				</h4>
				<%
					String phone = "";
							if (Validator.isNotNull(phones) && phones.size() > 0
									&& Validator.isNotNull(phones.get(0))
									&& Validator.isNotNull(phones.get(0).getNumber())) {
								phone = phones.get(0).getNumber();
							}
				%>
				<p><%=phone%></p>

				<h4>
					<liferay-ui:message key="email-address" />
				</h4>
				<p>
					<a href="mailto:<%=emailAddress%>" target="_top"><%=emailAddress%></a>
				</p>
				
				<h4>
					<liferay-ui:message key="webSite" />
				</h4>
				<a href="<%= currentESFOrganization.getWebSite()  %>" target="_blank"><%=currentESFOrganization.getWebSite()%></a>

			</div>
		</div>
		<div class="separator"></div>
		<div class="detail-error">
			<%
				String data = "";
						String lastName = "";
						String lastCode = "";
						String variation = "";
						String variationName = "";
						List<ESFHistoricalAssociation> historyTot = ESFHistoricalAssociationLocalServiceUtil
								.findbyOrg_Date(currentOrganizationId);
						List<ESFHistoricalAssociation> historyTotOrd = new ArrayList<ESFHistoricalAssociation>();
						if (historyTot.size() > 0) {

							for (ESFHistoricalAssociation h : historyTot) {
								lastName = h.getName();
								lastCode = h.getCode();
								data = sdf.format(h.getDateChange());
								Integer varId = (int) h.getVariationId();
								if (h.getStateId() > 0) {

									stateChanged = ESFStateLocalServiceUtil
											.fetchESFState(h.getStateId())
											.getName()
											+ "**";
								}
								if (h.getVariationId() > 0 && varId > 0) {

									variationChanged = ListTypeServiceUtil
											.getListType(varId).getName();
								}
								variation = variationChanged;

								String[] lastCangeName = { data, lastName };
								String[] lastCangeCode = { data, lastCode };
								if (!lastName.equals(currentESFOrganization
										.getName())
										|| !lastCode.equals(currentESFOrganization
												.getCode())) {
			%>

			<%
				if (!lastName.equals(currentESFOrganization
											.getName())) {
			%>
			<h4>
				<b><liferay-ui:message key="in-date-x-name-x"
						arguments="<%=lastCangeName%>" /></b>
				<div class="separator"></div>
				<%
					}
										if (!lastCode.equals(currentESFOrganization
												.getCode())) {
				%>
				<h4>
					<b><liferay-ui:message key="in-date-x-code-x"
							arguments="<%=lastCangeCode%>" /></b>
					<div class="separator"></div>
					<%
						}
											break;
										}

									}
								}

								if (missing_requirements_president
										|| missing_requirements_secretary
										|| missing_requirements_shooter) {
					%>

					<h4>
						<b><liferay-ui:message key="error_BDO" /> </b>
						<%
							if (missing_requirements_president) {
						%>
						<h4>
							<b><liferay-ui:message key="<%=noPresident%>" /> </b>
							<%
								}
											if (missing_requirements_secretary) {
							%>
							<h4>
								<b><liferay-ui:message key="<%=noSecretary%>" /></b>
								<%
									}
												if (missing_requirements_shooter) {
								%>
								<h4>
									<b><liferay-ui:message key="<%=noShooter%>" /></b>
									<%
										}
									%>
									<div class="separator"></div>
									<%
										}
										if (paymentOk) {
									%>
									<h4>
										<b><liferay-ui:message key="<%=no_outstanding_payments%>" /></b>
										<div class="separator"></div>

										<%
										} else if(partialPayment) {
										%>
										<h4>
											<b><liferay-ui:message key="<%=out_standing_payments%>" /></b>

											<div class="separator"></div>
											<%
										}else{
											%>
											<b><liferay-ui:message key="<%=no_payment_execute%>" /></b>

											<div class="separator"></div>
										<%} 
										if(currentESFOrganization.getIsSimplyOrganizzation()){
										%>
											<b><liferay-ui:message key="army_association" /></b>
										
										<div class="separator"></div>
										<%
										
										}%>
		</div>
		<!-- end div detail-error -->

		<%
			if (Validator.isNotNull(city)
							&& Validator.isNotNull(province)) {
		%>
		<h3>
			<ins>
				<liferay-ui:message key="field-address" />
			</ins>
		</h3>

		<div class="row detail">
			<div class="span6">
				<h4>
					<liferay-ui:message key="street1" />
				</h4>
				<p><%=street%></p>

				<h4>
					<liferay-ui:message key="city" />
				</h4>
				<p><%=city%></p>
			</div>

			<div class="span6">
				<h4>
					<liferay-ui:message key="province" />
				</h4>
				<p><%=province%></p>

				<h4>
					<liferay-ui:message key="zip" />
				</h4>
				<p><%=zip%></p>
			</div>
		</div>
		<div class="separator"></div>
		<%
			}
		%>

		<div class="row detail">
			<div class="span6">
				<h4>
					<liferay-ui:message key="type-association" />
				</h4>
				<%
					if (currentESFOrganization.isIsMultiSport()) {
				%>
				<p>
					<liferay-ui:message key="is-multi-sport" />
				</p>
				<%
					} else {
				%>
				<p>
					<liferay-ui:message key="is-mono-sport" />
				</p>
				<%
					}
				%>


				<h4>
					<liferay-ui:message key="category-state" />
				</h4>
				<%
					numField = ESFFieldLocalServiceUtil.findByESFOrganization(
									currentOrganizationId, ESFKeys.ESFStateType.ENABLE)
									.size();
							if (numField == 1 || numField == 0) {
								categoryAssosiation = ESFKeys.ESFOrganizationCategory.fourth;
							} else if (numField == 2 || numField == 3) {
								categoryAssosiation = ESFKeys.ESFOrganizationCategory.third;
							} else if (numField == 4 || numField == 5) {
								categoryAssosiation = ESFKeys.ESFOrganizationCategory.second;
							} else {
								categoryAssosiation = ESFKeys.ESFOrganizationCategory.first;
							}
				%>
				<p>
					<liferay-ui:message key="<%=categoryAssosiation%>" />
				</p>

				<h4>
					<liferay-ui:message key="first-affiliation-date" />
				</h4>

				<p>
					<%=currentESFOrganization.getFirstAffiliationDate() == null ? ""
							: ManageDate.DateToString(currentESFOrganization
									.getFirstAffiliationDate())%>
				</p>
			</div>
			<div class="span6">
				<h4>
					<liferay-ui:message key="is-youth-active" />
				</h4>
				<%
					if (currentESFOrganization.isIsYouthActive()) {
				%>
				<p>
					<liferay-ui:message key="y" />
				</p>
				<%
					} else {
				%>
				<p>
					<liferay-ui:message key="n" />
				</p>
				<%
					}
				%>
				<h4>
					<liferay-ui:message key="vat" />
				</h4>
				<p><%=currentESFOrganization.getVat()%></p>

				<h4>
					<liferay-ui:message key="fiscal-code" />
				</h4>
				<p><%=currentESFOrganization.getFiscalCode()%></p>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message key="no-content" />
		</div>
	</c:otherwise>
</c:choose>
