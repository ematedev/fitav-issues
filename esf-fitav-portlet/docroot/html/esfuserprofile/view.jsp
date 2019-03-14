<%@page import="it.ethica.esf.model.ESFProvince"%>
<%@ include file="init.jsp"%>

<div class="top-user-info">
	<%=utente.getFirstName()%>
	<%=" " + utente.getLastName()%>
	<%="(" + country + ")"%>
</div>
<portlet:actionURL var="updateUserURL" name="upUser" />
<aui:form action="<%=updateUserURL%>">
	<aui:input name="currentUserId" value="<%=utente.getEsfUserId()%>"
		type="hidden" />
	<div class="athlete-info">
		<div class="row">
			<div class="span2">
				<div class="image">
					<img
						src="<%=utente.getOriginalUser().getPortraitURL(themeDisplay)%>" />
				</div>
				<!-- Controllo per vedere se dalle preferenze e' possibile
                modificare Nome e Cognome -->
				<c:choose>
					<c:when test="<%=updateFirstName_view == true%>">
						<div class="info-row">
							<div class="info-name">
								<aui:input type="text" name="firstName"
									value="<%=utente.getFirstName()%>" />
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="info-row">
							<div class="info-name">
								<aui:input type="hidden" name="firstName" label="false"
									value="<%=utente.getFirstName()%>" />
							</div>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="<%=updateLastName_view == true%>">
						<div class="info-row">
							<div class="info-name">
								<aui:input type="text" name="lastName"
									value="<%=utente.getLastName()%>" />
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="info-row">
							<div class="info-name">
								<aui:input type="hidden" name="lastName"
									value="<%=utente.getLastName()%>" />
							</div>
						</div>
					</c:otherwise>
				</c:choose>
				<!-- Controllo se in base alle prefs modifico o meno il sesso -->
				<c:choose>
					<c:when test="<%=updateGender_view == true%>">
						<div class="info-row">
							<div class="info-name">
								<liferay-ui:message key="gender" />
							</div>
							<div class="info-value">
								<aui:select name="genderUser" label="false">
									<aui:option value="w">
										<liferay-ui:message key="female" />
									</aui:option>
									<aui:option value="m">
										<liferay-ui:message key="male" />
									</aui:option>
								</aui:select>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="info-row">
							<div class="info-name">
								<liferay-ui:message key="gender" />
							</div>
							<div class="info-value">
								<%=genderUser%>
							</div>
						</div>
					</c:otherwise>
				</c:choose>

				<c:choose>
				<c:when test="<%=updateYearBirth_view==true %>">
					<aui:input name="birthday" type="text" 
						value="<%=utente.getBirthday()%>"/>
				</c:when>
				<c:otherwise>
					<aui:input name="birthday" type="text" 
						value="<%=utente.getBirthday()%>" disabled="true"/>
				</c:otherwise>
				</c:choose>
				<!-- Controllo per vedere se abilitare la modifica del luogo di nascita -->
				<c:choose>
					<c:when test="<%=updatePlaceBirth_view == true%>">
						<div class="info-row">
							<div class="info-name">
								<liferay-ui:message key="Place_of_birth" />
							</div>
							<liferay-ui:custom-attribute
								className="<%=ESFUser.class.getName()%>"
								classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
								editable="<%=true%>" name="Place Of Birth" label="false" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="info-row">
							<div class="info-name">
								<liferay-ui:message key="Place_of_birth" />
							</div>
							<liferay-ui:custom-attribute
								className="<%=ESFUser.class.getName()%>"
								classPK="<%=utente != null ? utente.getEsfUserId()
									: 0%>"
								editable="<%=false%>" name="Place Of Birth" label="false">
							</liferay-ui:custom-attribute>
						</div>
					</c:otherwise>
				</c:choose>
				<!-- controllo per vedere se e' abilitata la modifica della residenza -->
				<c:choose>
					<c:when test="<%=updateResidence_view == false%>">
						<div class="info-row">
							<div class="info-name">
								<liferay-ui:message key="Residence" />
							</div>
							<div class="info-value">
								<div>
									<%=street1 + " " + city + " " + province%>
								</div>
								<div>
									<%=region + " " + zip + ", " + country%>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="info-row">
							<div class="info-name">
								<liferay-ui:message key="Residence" />
							</div>
							<div class="info-value">
								<aui:input type="text" name="street1" 
										value="<%=street1%>">
									<aui:validator name="alpha" 
										errorMessage="must-be-alpha" />
								</aui:input>
								<aui:select name="country">
									<%
										for (ESFCountry c : countries) {
									%>
									<aui:option value="<%=c.getIdCountry()%>">
										<%=c.getName()%>
									</aui:option>
									<%
										}
									%>
								</aui:select>
								<aui:select name="region">
									<%
										for (ESFRegion r : regions) {
									%>
									<aui:option value="<%=r.getIdRegion()%>">
										<%=r.getName()%>
									</aui:option>
									<%
										}
									%>
								</aui:select>
								<aui:select name="province">
									<%
										for (ESFProvince p : provinces) {
									%>
									<aui:option value="<%=p.getIdProvince()%>">
										<%=p.getName()%>
									</aui:option>
									<%
										}
									%>
								</aui:select>
								<aui:select name="city">
									<%
										for (ESFCity c : cities) {
									%>
									<aui:option value="<%=c.getIdCity()%>">
										<%=c.getName()%>
									</aui:option>
									<%
										}
									%>
								</aui:select>
								
								
								<aui:input type="text" name="zip" value="<%=zip%>">
									<aui:validator name="number" 
										errorMessage="must-be-number" />
								</aui:input>
								<aui:select name="region">
									<%
										for (ESFRegion r : regions) {
									%>
									<aui:option value="<%=r.getIdRegion()%>">
										<%=r.getName()%>
									</aui:option>
									<%
										}
									%>
								</aui:select>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="span5 middle">
			<div class="info-row">
				<div class="info-name">
					<c:choose>
				<c:when test="<%=updateHeight_view == true%>">
					<liferay-ui:message key="Height(cm)" />
							<liferay-ui:custom-attribute
								className="<%=ESFUser.class.getName()%>"
								classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
								editable="<%=true%>" name="Height (cm)" 
								label="false" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="Height(cm)" />
							<liferay-ui:custom-attribute
								className="<%=ESFUser.class.getName()%>"
								classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
								editable="<%=false%>" name="Height (cm)" 
								label="false" />
					</c:otherwise>
				</c:choose>
				</div>
			</div>
			</div>
			<c:choose>
				<c:when test="<%=updateWeight_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Weight(kg)" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Weight (kg)" 
							label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Weight(kg)" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Weight (kg)" 
							label="false" />
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateMaritalStatus_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Marital_Status" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Marital Status" 
							label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Marital_Status" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Marital Status" 
							label="false" />
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateChildren_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Children" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Children" 
							label="false"/>
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Children" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Children" 
							label="false"/>
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateHigherEducation_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Higher_Education" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Higher Education" 
							label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Higher_Education" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Higher Education" 
							label="false" />
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateProfession_view == true%>">
					<div class="info-row">
						<div class="info-value">
							<aui:input type="text" name="profession"
								value="<%=userProfession%>" disabled="true">
								<aui:validator name="alpha" errorMessage="must-be-alpha" />
							</aui:input>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-value">
							<aui:input type="text" name="profession"
								value="<%=utente.getJobTitle()%>">
								<aui:validator name="alpha" errorMessage="must-be-alpha" />
							</aui:input>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="info-row">
				<div class="info-name">
					<liferay-ui:message key="Languages" />
				</div>
				<c:choose>
				<c:when test="<%=updateLanguages_view == true%>">
					
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Languages" label="false" />
				</c:when>
				<c:otherwise>
					<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Languages" label="false" />
				</c:otherwise>
			</c:choose>
			</div>
			<c:choose>
				<c:when test="<%=updateHobbies_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Hobbies" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Hobbies" label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Hobbies" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Hobbies" label="false" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="span5 last">
			<c:choose>
				<c:when test="<%=updateHandedness_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Handedness" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Handedness" label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Handedness" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Handedness" label="false" />
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateMasterEye_view == false%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Master_Eye" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Master Eye" label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Master_Eye" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Master Eye" label="false" />
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateOther_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Other_Sport_Activities" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Other Sport Activities" label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Other_Sport_Activities" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Other Sport Activities" label="false" />
					</div>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="<%=updateComments_view == true%>">
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Comments" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="Comments" label="false" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="info-row">
						<div class="info-name">
							<liferay-ui:message key="Comments" />
						</div>
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="Comments" label="false" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="info-row">
				<div class="info-name">
					<liferay-ui:message key="upHat" />
				</div>
				<c:choose>
				<c:when test="<%=updateHat_view == true%>">
					
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="hat" label="false" />
				</c:when>
				<c:otherwise>
					<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="hat" label="false" />
				</c:otherwise>
			</c:choose>
			</div>
			<div class="info-row">
				<div class="info-name">
					<liferay-ui:message key="upTshirt" />
				</div>
				<c:choose>
				<c:when test="<%=updateTShirt_view == true%>">
					
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="tShirt" label="false" />
				</c:when>
				<c:otherwise>
					<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="tShirt" label="false" />
				</c:otherwise>
			</c:choose>
			</div>
			<div class="info-row">
				<div class="info-name">
					<liferay-ui:message key="upPants" />
				</div>
				<c:choose>
				<c:when test="<%=updatePants_view == true%>">
					
						<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=true%>" name="pants" label="false" />
				</c:when>
				<c:otherwise>
					<liferay-ui:custom-attribute
							className="<%=ESFUser.class.getName()%>"
							classPK="<%=utente != null ? utente.getEsfUserId() : 0%>"
							editable="<%=false%>" name="pants" label="false" />
				</c:otherwise>
			</c:choose>
			</div>
		<c:choose>
			<c:when test="<%=enableSubmit_view == true%>">
				<aui:input type="submit" value="Update" name="" />
			</c:when>
		</c:choose>
	</div>
</aui:form>


