  <%-- 
<%@include file="view.jsp" %> 
--%>
<%@page import="it.ethica.esf.service.ESFDescriptionLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFDescription"%>
<%@page import="it.ethica.esf.service.ESFMatchTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFMatchType"%>
<portlet:resourceURL var="actReportTiratoriURL" id="actReportTiratoriURL" escapeXml="false" >
</portlet:resourceURL>

<aui:form action="actReportTiratoriURL"  name="<portlet:namespace/>fm">
		
			<fieldset>
				<!-- prima era presente <div class="box"> -->
				<div class="">
					<div class="interBox">
			
						<aui:select name="elencoAssociazioni" id="elencoAssociazioni" >
							<aui:option value="<%=0%>">
								---
							</aui:option>
							<%
								for (ESFOrganization r : organizationShooters) {
									String idOrganization ="";
									try {
										idOrganization = r.getCode();
										organizationName = r.getName();
										}
									catch(Exception e){e.printStackTrace();}
							%>
							<aui:option value="<%=idOrganization%>">
								<%=organizationName%></aui:option>
							<%
								}
							%>
						</aui:select>
					</div>
				
					<div class="interBox">
				
						<aui:select name="elencoCategorieTiratori" id="elencoCategorieTiratori">
							<%
								for (ESFShooterCategory r : shootersCategory) {
									String idShootersCategory ="";
									try {
										idShootersCategory = String.valueOf(r.getPrimaryKey());
										shootersCategoryName = r.getName();
										}
									catch(Exception e){e.printStackTrace();}
							%>
							<aui:option value="<%=idShootersCategory%>">
								<%=shootersCategoryName%></aui:option>
							<%
								}
							%>
							
						</aui:select>
					</div>
				
					<div class="interBox">
					
						<aui:select name="elencoMatches" id="elencoMatches">
							<%
								for (ESFMatch r : matchShooters) {
									String idMatchShooter ="";
									try {
										idMatchShooter = String.valueOf(r.getEsfMatchId());
										ESFDescription descrn = ESFDescriptionLocalServiceUtil.fetchESFDescription(r.getDescription());
										matchShooterName = String.valueOf(descrn.getName());
										}
									catch(Exception e){e.printStackTrace();}
							%>
							<aui:option value="<%=idMatchShooter%>">
								<%=matchShooterName%></aui:option>
							<%
								}
							%>
							
						</aui:select>
					</div>
					
					<div class="interBox">
					
						<aui:select name="elencoQualificazioni" id="elencoQualificazioni">
							<%
								for (ESFShooterQualification r : shooterQualification) {
									String idshooterQualification ="";
									try {
										idshooterQualification = String.valueOf(r.getEsfShooterQualificationId());
										qualificationName = String.valueOf(r.getName());
										}
									catch(Exception e){e.printStackTrace();}
							%>
							<aui:option value="<%=idshooterQualification%>">
								<%=qualificationName%></aui:option>
							<%
								}
							%>
							
						</aui:select>
					</div>
						<div class="interBox">
					
						<aui:select name="elencoRuoli" id="elencoRuoli">
							<%
								for (ESFUserESFUserRole r : userRole) {
									String iduserRole ="";
									try {
										iduserRole = String.valueOf(r.getEsfUserRoleId());
										userRoleName = String.valueOf(r.getEsfUserRoleId());
										}
									catch(Exception e){e.printStackTrace();}
							%>
							<aui:option value="<%=iduserRole%>">
								<%=userRoleName%></aui:option>
							<%
								}
							%>
							
						</aui:select>
					</div>
				</div>
				
				<div class="separator"></div>
				</fieldset>
				<fieldset>
				<!-- prima era presente <div class="box"> -->
				<div class="">
							
					
					
					<div class="interBox">
					
					 	<aui:input name="name" type="text" placeholder="name" >
					 	</aui:input>
					 			
					</div>
					
					<div class="interBox">
					
					 	<aui:input name="surname" type="text" placeholder="surname" >
					 	</aui:input>
					 			
					</div>
					
					<div class="interBox">
					
					 	<aui:select name="shooterNationality" id="shooterNationality">
						 
							<%
								for (Country r : esfCountry) {
									String idCountry ="";
									try {
										idCountry = String.valueOf(r.getA2());
										countryName = r.getName();
										}
									catch(Exception e){e.printStackTrace();}
							%>
							<aui:option value="<%=idCountry%>">
								<%=countryName%></aui:option>
							<%
								}
							%>
					
						</aui:select>
					 			
					</div>
					<!-- 
					<div class="interBox">
					
					 	<aui:select name="membershipRegion" id="membershipRegion">
							
						</aui:select>
					 			
					</div>
					<div class="interBox">
					
					 	<aui:select name="membershipProvince" id="membershipProvince">
						
							
						</aui:select>
					 			
					</div>
					 -->
				</div>
				
			</fieldset>
			<div class="separator"></div>
			<fieldset>
					<!-- prima era presente <div class="box"> -->
					<div class="">
						<div class="interBox">
							 	<aui:select name="juniorSelect" id="juniorSelect">
										<aui:option value="SI">SI</aui:option> 
										<aui:option value="NO">NO</aui:option>
								</aui:select>
						</div>
						<div class="interBox">
							 	<aui:select name="sessoSelect" id="sessoSelect">
										<aui:option value="M">M</aui:option> 
										<aui:option value="F">F</aui:option>
								</aui:select>
						</div>
						<div class="interBox">
							 	<aui:select name="azzurriSelect" id="azzurriSelect">
										<aui:option value="SI">SI</aui:option> 
										<aui:option value="NO">NO</aui:option>
								</aui:select>
						</div>	 
					</div>
				<div class="separator"></div>				
				</fieldset>
				<fieldset>
					<div class="interBox">  
					
						<liferay-ui:message	key="Start-search-date-from:" />
						</div>
						<div class="interBox">										
							 <liferay-ui:input-date formName="date"  dayParam="d1" monthParam="m1" yearParam="y1"  
							 yearValue="2014" monthValue="09" dayValue="25"  autoFocus="true" >
							 </liferay-ui:input-date>
						</div>
				</fieldset>
				<div class="separator"></div>		
			<div class="interBox">
					
					<aui:input type="submit" name="sendReport" value="report"  ></aui:input>
					 
			
					</div>
		</aui:form>
		
		<aui:script>
		
		AUI().use('aui-base','aui-io-request','aui-node', function(A){
		    A.one('#<portlet:namespace/>shooterNationality').on('change',function(){        
		        A.io.request('<%=actReportTiratoriURL %>', //requesting call to serverResource method 
		                {
		             method: 'POST',
		             data: { 
		                         '<portlet:namespace/>countryCode' : A.one('#<portlet:namespace/>shooterNationality').val(),
		                          '<portlet:namespace/>countrySelected' :'countrySelected'
		                   
		                               },
		
		             dataType: 'json',
		             on: {
		             success: function() {
		               var countriesList =this.get('responseData');   //on success fuction we will get response data
		
		             A.one('#<portlet:namespace />membershipRegion').empty();
		           
		            A.one('#<portlet:namespace />membershipRegion').append("<option >Scegli</option> ");
		          //using for loop we iterating the list
		             for(var i in countriesList){
		 
		               A.one('#<portlet:namespace />membershipRegion').append("<option  value='"+ countriesList[i].regionCode +"' >"+countriesList[i].regionList+"</option> "); 
		              
		             }
		            
		             }
		             }
		            
		                });
		            });
		    A.one('#<portlet:namespace/>membershipRegion').on('change',function(){
		        
		        A.io.request('<%=actReportTiratoriURL %>',
		                {
		            
		            method :'POST',
		            data: {'<portlet:namespace/>regionShooterCode' : A.one('#<portlet:namespace/>membershipRegion').val() ,
		            	'<portlet:namespace/>regionShooterSelected' : 'regionShooterSelected'},
		            dataType: 'json',
		            on:{
		                success: function(){
		                    
		                    var statesList2 = this.get('responseData');
		                     A.one('#<portlet:namespace />membershipProvince').empty();
		                  
		                     A.one('#<portlet:namespace />membershipProvince').append("<option  >Scegli</option> "); 
		                     for(var i in statesList2){
		                    	 
		                    	
		                	 
		                            A.one('#<portlet:namespace />membershipProvince').append("<option    value='"+ statesList2[i].provinceShooterCode +"' >"+statesList2[i].provinceShooterList+"</option> "); 
		                    	 
		                    }
		                }
		                
		            }
		            
		                    
		    });
		        
		    });
		 
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		</aui:script>