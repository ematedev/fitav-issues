
<%@include file="init.jsp"%>

<%	
	/*back to view*/
	String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	int urlEndIndex = currentUrlPage.indexOf('?');
	String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	if(urlEndIndex != -1){
		backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
	}
	portletDisplay.setURLBack(backtoViewUrl);
	/*end*/
	PortletURL viewassURL = renderResponse.createRenderURL();
	
	viewassURL.setParameter("mvcPath", templatePath +
		"edit_esfAddResult.jsp");
	viewassURL.setParameter(
		"organizationId", String.valueOf(currentOrganizationId));
	viewassURL.setWindowState(WindowState.NORMAL);
	int nationalShooterCounter = 0, externalShooterCounter = 0;
	
	boolean canUpdate=ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_UPDATE_RESULT);
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" 
	value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>

		<portlet:actionURL var="addNationalMatchResURL"
			name="addNationalMatchRes">
			<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" />
			<portlet:param name="companyId"
				value="<%=String.valueOf(company.getCompanyId())%>" />
			<portlet:param name="groupId"
				value="<%=String.valueOf(group.getGroupId())%>" />
			<portlet:param name="userId"
				value="<%=String.valueOf(user.getUserId())%>" />
			<portlet:param name="mvcPath"
				value="/esfnationalmatch/edit_esfAddResult.jsp"/>
		</portlet:actionURL>
		
<h2>
	<liferay-ui:message key="national-match-results" />
</h2>

<div class="alert alert-error hide" id="<portlet:namespace />submit-error">
	<liferay-ui:message key="insert-first-three-position" />
</div>

<aui:form action="<%=addNationalMatchResURL%>" cssClass="form-table" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitNationalMatchRes();" %>' name="fm">
<%
		List<ESFNationalDelegation> esfNationalDelegations =
					ESFNationalDelegationLocalServiceUtil.
						getESFNationalDelegationByMatchId_PartecipantTypeId(
									esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);
%>
		<table class="aui">
		<thead>
			<tr>
				<th><%=res.getString("shooter")%></th>
				<th><%=res.getString("position")%></th>
				<th><%=res.getString("qualification")%></th>
				<th><%=res.getString("shoot-off")%></th>
				<th><%=res.getString("clay-pigeon-total")%></th>
				<th><%=res.getString("final-result")%></th>
				<th><%=res.getString("shoot-off-final")%></th>
			</tr>
		</thead>
		<tbody>
				
<%		
			
		List<ESFNationalMatchResult> totalShooters = new ArrayList<ESFNationalMatchResult>();
		for (ESFNationalDelegation e : esfNationalDelegations) {
			ESFNationalMatchResult nationalShooter = 
							ESFNationalMatchResultLocalServiceUtil.
								getESFNationalMatchResultByESFMatchId_ESFUserId(
													esfMatchId, e.getEsfUserId());
			if(Validator.isNotNull(nationalShooter)) {
				totalShooters.add(nationalShooter);
			}
			else {
				ESFNationalMatchResult esfNationalMatchResult = new ESFNationalMatchResultImpl();
				long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFNationalMatchResult.class.getName());
				esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultsId);
				
				esfNationalMatchResult.setCompanyId(company.getCompanyId());
				esfNationalMatchResult.setCreateDate(new Date());
				esfNationalMatchResult.setEsfMatchId(esfMatchId);
				esfNationalMatchResult.setEsfUserId(e.getEsfUserId());
				esfNationalMatchResult.setGroupId(scopeGroupId);
				esfNationalMatchResult.setModifiedDate(new Date());
				esfNationalMatchResult.setUserId(user.getUserId());
				esfNationalMatchResult.setUserName(user.getFullName());

				esfNationalMatchResult.setPosition(0);
				esfNationalMatchResult.setQualification(0);
				esfNationalMatchResult.setShootOff(0);
				esfNationalMatchResult.setClayPigeonTotal(0);
				esfNationalMatchResult.setFinalResult(0);
				esfNationalMatchResult.setShootOffFinal(0);
				esfNationalMatchResult.setExternalShooter(false);
				esfNationalMatchResult.setExternalName(StringPool.BLANK);
				
				ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);
				totalShooters.add(esfNationalMatchResult);
			}
		}
		List<ESFNationalMatchResult> externalShooters = ESFNationalMatchResultLocalServiceUtil.getExternalShooter(esfMatchId);
		for (ESFNationalMatchResult externalShooter : externalShooters) {
			if (Validator.isNotNull(externalShooter)) {
				totalShooters.add(externalShooter);
			}
		}
		ArrayList<ESFNationalMatchResult> ordertotalShooter = new ArrayList<ESFNationalMatchResult>();
		Collections.sort(totalShooters);
		
		
		String externalIds = StringPool.BLANK;
		for (ESFNationalMatchResult esfNationalMatchResult : totalShooters) {
			int position = 0, qualification = 0, shootOff = 0, clayPigeonTotal = 0, finalResult = 0, shootOffFinal = 0;
			long esfUserId;
			boolean isExternalShooter = esfNationalMatchResult.isExternalShooter();
			String suffixExt = "_ext_";
			String nameSuffix = (isExternalShooter?suffixExt + String.valueOf(externalShooterCounter):String.valueOf(nationalShooterCounter));

			position = esfNationalMatchResult.getPosition();
			qualification = esfNationalMatchResult.getQualification();
			shootOff = esfNationalMatchResult.getShootOff();
			clayPigeonTotal = esfNationalMatchResult.getClayPigeonTotal();
			finalResult = esfNationalMatchResult.getFinalResult();
			shootOffFinal = esfNationalMatchResult.getShootOffFinal();
			esfUserId = esfNationalMatchResult.getEsfUserId();
			String fullName = esfNationalMatchResult.getExternalName();
			if (esfUserId >= 0) {
				ESFUser eUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
				fullName = eUser.getLastName() + " " + eUser.getFirstName();
			}

			%>
				<tr>
					<td>
						
						<div class="control-group shooter-name">
							<input type="text" name='<%= renderResponse.getNamespace() + "shooterName" + nameSuffix %>' readonly value='<%=fullName%>' />
							<%
							if (isExternalShooter) {
							%>
								<div
									class="delete-icon"
									onClick="<portlet:namespace />deleteExternalShooter(event.target)"
									data-value="<%= esfNationalMatchResult.getEsfNationalMatchResultId() %>"
									data-index="<%= externalShooterCounter %>">
								</div>
							<%
							}
							%>
						</div>

						<aui:input wrapperCssClass="hide" style = "display : none;" label = "" 
						type = "text" name = '<%="ESFShooterId" + nameSuffix %>'
						value='<%=String.valueOf(esfUserId)%>'/>

						<aui:input name='<%= "esfNationalMatchResultId" + nameSuffix %>' type="hidden" value="<%= esfNationalMatchResult.getEsfNationalMatchResultId() %>" />
					</td>
					<td>
						<aui:input type="number" name='<%= "position" + nameSuffix %>' size="75" value = "<%=String.valueOf(position) %>" label=" " cssClass="position-input" min="0">
							<aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function (val, fieldNode, ruleValue) {
										var result = false;
										if (val >= 0) {
											result = true;
										}
											return result;
									}
							</aui:validator>
						</aui:input>
					</td>
					<td>
						<aui:input type="number" name='<%="qualification" + nameSuffix%>' size="75" value = "<%=String.valueOf(qualification) %>" label=" " min="0">
							<aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0" >
									function (val, fieldNode, ruleValue) {
										var result = false;
										if (val >= 0) {
											result = true;
										}
											return result;
									}
							</aui:validator>
						</aui:input>
					</td>
					<td>
						<aui:input type="number" name='<%="shootOff" + nameSuffix%>' size="75" value = "<%=String.valueOf(shootOff) %>" label=" " min="0">
							<aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0" >
									function (val, fieldNode, ruleValue) {
										var result = false;
										if (val >= 0) {
											result = true;
										}
											return result;
									}
							</aui:validator>
						</aui:input>
					</td>
					<td>
						<aui:input type="number" name='<%="clayPigeonTotal" + nameSuffix%>' size="75" value = "<%=String.valueOf(clayPigeonTotal) %>" label=" " min="0">
							<aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0"  >
									function (val, fieldNode, ruleValue) {
										var result = false;
										if (val >= 0) {
											result = true;
										}
											return result;
									}
							</aui:validator>
						</aui:input>
					</td>
					<td>
						<aui:input type="number" name='<%="finalResult" + nameSuffix%>' size="75" value = "<%=String.valueOf(finalResult) %>" label=" " min="0">
							<aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0" >
									function (val, fieldNode, ruleValue) {
										var result = false;
										if (val >= 0) {
											result = true;
										}
											return result;
									}
							</aui:validator>
						</aui:input>
					</td>
					<td>
						<aui:input type="number" name='<%="shootOffFinal" + nameSuffix%>' size="75" value = "<%=String.valueOf(shootOffFinal) %>" label=" " min="0">
							<aui:validator  name="custom"  errorMessage="please-enter-a-value-greater-than-or-equal-to-0" >
									function (val, fieldNode, ruleValue) {
										var result = false;
										if (val >= 0) {
											result = true;
										}
											return result;
									}
							</aui:validator>
						</aui:input>
					</td>
				</tr>
				<%
					if (isExternalShooter) {
						externalIds += externalShooterCounter + StringPool.COMMA;
						externalShooterCounter++;
						continue;
					}
					nationalShooterCounter++;
				}
				%>
			</tbody>
		</table>
		<aui:input name="externalIds" type="hidden" value="<%= externalIds %>"/>
	
		<c:if test="<%= canUpdate %>">	
			<aui:button name="submit" type="submit" ></aui:button>
			<aui:button name="add" value="add" onClick='<%= renderResponse.getNamespace() + "addNationalMatchRes();" %>' />
		</c:if>

		<aui:button onClick='<%=backURL.toString() %>' value="back" />
</aui:form>

<portlet:resourceURL id="deleteExternalShooter" var="deleteExternalShooterVar">
	<portlet:param name="esfMatchId" value="<%= String.valueOf(esfMatchId) %>"/>
</portlet:resourceURL>
<aui:script use="aui-base">
	var table = A.one('#<portlet:namespace />fm');
	var counter = <%= externalShooterCounter %>;
	var addAct=<%= canUpdate %>;
	Liferay.provide(
		window,
		'<portlet:namespace />addNationalMatchRes',
		function() {
			var act='';
			if(addAct)
				act='<div class="delete-icon" onClick="<portlet:namespace />deleteExternalShooter(event.target);" data-value="-1" data-index="' + counter + '"></div>';
			var row = '<tr>' +
				'<td><div class="control-group shooter-name"><input type="text" name="<portlet:namespace />shooterName_ext_' + counter + '" />' +act+'</div></td>' +
				'<td><input type="number" class="position-input" min="0" name="<portlet:namespace />position_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />qualification_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />shootOff_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />clayPigeonTotal_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />finalResult_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />shootOffFinal_ext_' + counter + '" value="0" /></td>' +
				'</tr>';
			table.one('tbody').append(row);
			A.one('#<portlet:namespace />externalIds').val(A.one('#<portlet:namespace />externalIds').val() + counter + ",");
			A.one('#<portlet:namespace />submit-error').hide();
			counter++;
		}
	);

	Liferay.provide(
		window,
		'<portlet:namespace />submitNationalMatchRes',
		function() {
			var podium = [1,2,3];
			var positions = A.all('.position-input');
			positions.each(function(node){
				var value = parseInt(node.val());
				if (podium.includes(value)) {
					var index = podium.indexOf(value);
					if (index > -1) {
						podium.splice(index, 1);
					}
				}
			});
			if (podium.length >= 1) {
				A.one('#<portlet:namespace />submit-error').show();
				return;
			}
			submitForm(document.<portlet:namespace />fm);
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace />deleteExternalShooter',
		function(element) {
			var el = A.one(element);
			var val = parseInt(el.getAttribute('data-value'));
			var index = parseInt(el.getAttribute('data-index'));
			var extIds = A.one('#<portlet:namespace />externalIds').val();
			extIds = extIds.replace(index + ',', '');
			A.one('#<portlet:namespace />externalIds').val(extIds);
			var tr = el.ancestor('tr');
			if (val == -1) {
				tr.remove();
				return;
			}
			A.io.request(
				'<%= deleteExternalShooterVar %>',
				{
					dataType: 'json',
					method: 'post',
					data: {
						<portlet:namespace />esfNationalMatchResultId: val
					},
					on: {
						complete: function() {
							tr.remove();
						}
					}
				}
			);
		}
	);
</aui:script>