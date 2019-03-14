<%@page import="it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil"%>
<%
		sportTypeid= 
			ESFSportTypeLocalServiceUtil.findESFSportTypeByName("Skeet").get(0).getEsfSportTypeId();
		
		List<ESFNationalDelegation> esfNationalDelegations =
			ESFNationalDelegationLocalServiceUtil.
			getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId(esfMatchId,ESFKeys.ESFNationalDelegationType.SHOOTER, sportTypeid);
%>
		<table class="aui" name="fmskeet">
		<thead>
			<tr>
				<th><%=res.getString("shooter")%></th>
				<th><%=res.getString("position")%></th>
				<th><%=res.getString("qualification")%></th>
				<th><%=res.getString("shoot-off")%></th>
				<th><%=res.getString("clay-pigeon-total")%></th>
				<th><%=res.getString("final-result")%></th>
				<th><%=res.getString("shoot-off-final")%></th>
				<th><%=res.getString("user-nationality")%></th>
			</tr>
		</thead>
		<tbody>		
<%			
		List<ESFNationalMatchResult> totalShooters = new ArrayList<ESFNationalMatchResult>();
		for (ESFNationalDelegation e : esfNationalDelegations) {
			ESFNationalMatchResult nationalShooter = 
							ESFNationalMatchResultLocalServiceUtil.
							getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(esfMatchId, e.getEsfUserId(), sportTypeid);				
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
				esfNationalMatchResult.setEsfSportTypeId(sportTypeid);
				ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);
				totalShooters.add(esfNationalMatchResult);
			}
		}
		List<ESFNationalMatchResult> externalShooters = 
					ESFNationalMatchResultLocalServiceUtil.getExternalShooterSportType(esfMatchId, sportTypeid);
		for (ESFNationalMatchResult externalShooter : externalShooters) {
			if (Validator.isNotNull(externalShooter)) {
				totalShooters.add(externalShooter);
			}
		}
		ArrayList<ESFNationalMatchResult> ordertotalShooter = new ArrayList<ESFNationalMatchResult>();
		Collections.sort(totalShooters);
		
		
		
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
			String userNationality=esfNationalMatchResult.getUserNationality();
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
			
						<aui:input wrapperCssClass="hide" style = "display : none;" label = "" 
						type = "text" name = '<%="sportTypeid" + nameSuffix %>'
						value='<%=String.valueOf(sportTypeid)%>'/>
						
						
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
					<td>
						<%
						if(!isExternalShooter){
						%>
							<aui:input type="text" name='<%="userNationality" + nameSuffix%>'  value = "<%= res.getString(\"italy\") %>" label="" disabled="true">
							</aui:input>
				
						<% 		
							} else {
						%>
							<aui:input type="text" name='<%="userNationality" + nameSuffix%>'  value = "<%=String.valueOf(userNationality) %>" label="">
							</aui:input>
					
						<%
							}
						%>
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

