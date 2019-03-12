 <%-- 
<%@include file="view.jsp" %> 
--%>

<portlet:actionURL name="actionMatchReport" var="actionMatchReportURL" />

<aui:form action="actionMatchReportURL" method="post">
	
	<div class="interBox">
		
		<aui:select name="nazionale" id="nazionale" >
					
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
					<aui:option value="<%=1%>">
					SI
					</aui:option>		
					<aui:option value="<%=2%>">
					NO
					</aui:option>				
					
		</aui:select>
	
	
	</div>
	
	<div class="separator"></div>
	<div class="box">
	
		<div class="interBox">
		
		Start date:
		
			<div class="interBox">										
				 <liferay-ui:input-date formName="date"  dayParam="d1" monthParam="m1" yearParam="y1"  
				 yearValue="2014" monthValue="09" dayValue="25"  autoFocus="true" >
				 </liferay-ui:input-date>
			</div>
			
		</div>
		
		<div class="interBox">
		End date:
		
			<div class="interBox">	
												
				 <liferay-ui:input-date formName="date"  dayParam="d1" monthParam="m1" yearParam="y1"  
				 yearValue="2014" monthValue="09" dayValue="25"  autoFocus="true" >
				 </liferay-ui:input-date>
				 
			</div>
			
		</div>
		
	</div>
	
	<div class="separator"></div>
	<div class="box">
		
		<div class="interBox">
			<aui:select name="elencoUserReport" id="elencoUserReport" >
					
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
					
							<%
							for (ESFUser r : userReport) {
								String idUser ="";
									
										try {
											idUser = String.valueOf(r.getEsfUserId());
											User shooter=UserLocalServiceUtil.fetchUser(r.getEsfUserId());
											if(!(shooter.getLastName().equals(shooter.getFirstName()))){
											userNameReport = shooter.getFirstName()+" "+shooter.getLastName();
											
						%>
					<aui:option value="<%=idUser%>">
						<%=userNameReport%>
					</aui:option>
						<%
											}}
										catch(Exception e){e.printStackTrace();}}
						%>
					
					
			</aui:select>
			
		
		</div>
		
		<div class="interBox">
		
			<aui:input type="number" name="nBersaglio">
						<aui:validator errorMessage="must-be-number" name="number" />
					</aui:input>
		
		</div>		
		
	</div>
	
	<div class="separator"></div>
	
	<div class="interBox">
	
		<aui:input type="checkbox" name="individuale" 
			value="individuale"/>
			
		<aui:input type="checkbox" name="squadre" 
			value="squadre"/>
			
		<aui:input type="checkbox" name="settore giovanile" 
			value="settore giovanile"/>
			
		<aui:input type="checkbox" name="has-penality" 
			value="has-penality"/>
	
	</div>
	
	<div class="separator"></div>
	<!-- prima era presente <div class="box"> -->
	<div class="">		
			<div class="interBox">
			
				<aui:select name="elencoAssociazioniReport" id="elencoAssociazioniReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFOrganization r : organizationShooters) {
								String idOrganization ="";
									if(r.getType_().equals("3")){	
										try {
											idOrganization = r.getCode();
											organizationNameReport = r.getName();
											}
											catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idOrganization%>">
						<%=organizationName%>
					</aui:option>
						<%
							}}
						%>
				</aui:select>
			</div>
			<div class="interBox">
			
				<aui:select name="elencoCountryReport" id="elencoCountryReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (Country r : esfCountry) {
								String idCountry ="";										
									try {
										idCountry =r.getA2();
										countryReportName = r.getName();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idCountry%>">
						<%=countryReportName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
			<div class="interBox">
			
				<aui:select name="elencoSedeReport" id="elencoSedeReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFMatch r : matchShooters) {
								String idMatch ="";										
									try {
										idMatch =r.getSite();
										matchReportName = r.getSite();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idMatch%>">
						<%=matchReportName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
			<div class="interBox">
			
				<aui:input type="text" name="siteReport" id="siteReport" label="match-site">
				</aui:input>

			</div>
		</div>
		
		<div class="separator"></div>
			<!-- prima era presente <div class="box"> -->
		<div class="">
			<div class="interBox">
			
				<aui:select name="elencoDescrizioniReport" id="elencoDescrizioniReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFDescription r : description) {
								String idDescription ="";										
									try {
										idDescription =String.valueOf( r.getName() );
										descriptionName = r.getName();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idDescription%>">
						<%=descriptionName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
			<div class="interBox">
			
				<aui:select name="elencoTipoMatchReport" id="elencoTipoMatchReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFMatchType r : matchTypeReport) {
								String idMatchType ="";										
									try {
										idMatchType =String.valueOf(r.getEsfMatchTypeId());
										matchTypeReportName = r.getName();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idMatchType%>">
						<%=matchTypeReportName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
			<div class="interBox">
			
				<aui:select name="elencoTipoSportReport" id="elencoTipoSportReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFSportType r : sportTypes) {
								String idSportType ="";										
									try {
										idSportType =String.valueOf(r.getEsfSportTypeId());
										sportTypeReportName = r.getName();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idSportType%>">
						<%=sportTypeReportName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
			
			<div class="interBox">
			
				<aui:select name="elencoQualificaReport" id="elencoQualificaReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFShooterQualification r : shooterQualification) {
								String idQualification ="";										
									try {
										idQualification =String.valueOf(r.getEsfShooterQualificationId());
										qualificationReportName = r.getName();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idQualification%>">
						<%=qualificationReportName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
			
			<div class="interBox">
			
				<aui:select name="elencoCategoriaReport" id="elencoCategoriaReport" >
					<aui:option value="<%=0%>">
								Scegli
					</aui:option>
						<%
							for (ESFShooterCategory r : shootersCategory) {
								String idCategory ="";										
									try {
										idCategory =String.valueOf(r.getEsfShooterCategoryId());
										categoryReportName = r.getName();
										}
										catch(Exception e){e.printStackTrace();}
						%>
					<aui:option value="<%=idCategory%>">
						<%=categoryReportName%>
					</aui:option>
						<%
							}
						%>
				</aui:select>
			</div>
		

	</div>
	
	<div class="separator"></div>

	<div class="interBox">
	
		<aui:input type="submit" value="Search" name="" />
	
	
	</div>








</aui:form>
