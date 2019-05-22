<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.model.VW_ESFIncarichiFederali"%>
<%@page
	import="it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliUtil"%>
<%@page
	import="it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil"%>
<%@page
	import="it.ethica.esf.service.impl.ESFUserESFUserRoleLocalServiceImpl"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="java.util.Calendar"%>
<%@page
	import="it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUserESFFederalRole"%>
<%@page import="it.ethica.esf.util.DateUtilFormatter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="it.ethica.esf.service.ESFFederalRoleLocalServiceUtil"%>
<%@ page import="it.ethica.esf.service.ESFSpecificLocalServiceUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	long esfUserId = ParamUtil.getLong(request, "esfUserId", -1);
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String endDate = ManageDate.CalendarToString(calendar);
%>
<portlet:actionURL name="associateEsfFederalRole"
	var="associateEsfFederalRoleActionURL">
	<portlet:param name="mvcPath"
		value='/html/esfshooter/edit_esfShooter.jsp' />
</portlet:actionURL>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h4>ATTRIBUZIONE INCARICHI FEDERALI</h4>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span7">


			<%-- TEST --%>

			<liferay-ui:search-container emptyResultsMessage="no-results">
				<liferay-ui:search-container-results
 					results="${listaIncarichiAttivi}" total="${totaleIncarichiAttivi}" /> 

 				<liferay-ui:search-container-row 
 					className="it.ethica.esf.model.VW_ESFIncarichiFederali" 
 					modelVar="incarichiFederaliAttivi"> 

 					<liferay-ui:search-container-column-text name="endDate" /> 
 					<c:if test="<%=incarichiFederaliAttivi.getEndDate() != null%>"> 
 						<%=DateUtilFormatter.formatDate(incarichiFederaliAttivi.getEndDate())%> 
 					</c:if> 

 					<liferay-ui:search-container-column-text name="startDate"> 
 						<c:if test="<%=incarichiFederaliAttivi.getStartDate() > 0%>"> 
 							<%=incarichiFederaliAttivi.getStartDate()%> 
 						</c:if> 
 					</liferay-ui:search-container-column-text> 

 					<liferay-ui:search-container-column-text name="code" /> 

 					<liferay-ui:search-container-column-text name="description" /> 


 				</liferay-ui:search-container-row> 

   				<liferay-ui:search-iterator /> 
 			</liferay-ui:search-container> 


		









			<%-- Parte funzionante versione vecchia--%>

			<%-- 			<liferay-ui:search-container emptyResultsMessage="no-results"> --%>
			<%-- 				<liferay-ui:search-container-results results="${results}" total="${total}" /> --%>

			<%-- 				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFFederalRole" modelVar="federalRole"> --%>

			<%-- 					<liferay-ui:search-container-column-text property="code" /> --%>
			<%-- 					<liferay-ui:search-container-column-text property="description" /> --%>
			<%-- 					<liferay-ui:search-container-column-text name="startDate"> --%>
			<%-- 						<c:if test="<%=ESFFederalRoleLocalServiceUtil.isAssociated(esfUserId, federalRole.getEsfFederalRoleId())%>"> --%>
			<%-- 							<fmt:formatDate value='<%=ESFFederalRoleLocalServiceUtil.getActiveAssociationDate(esfUserId, federalRole.getEsfFederalRoleId())%>' type='date' pattern='dd-MM-yyyy' /> --%>
			<%-- 						</c:if> --%>
			<%-- 					</liferay-ui:search-container-column-text> --%>



			<%-- 					<liferay-ui:search-container-column-text name="endDate"> --%>
			<%-- 						<c:if test="<%=ESFFederalRoleLocalServiceUtil.isAssociated(esfUserId, federalRole.getEsfFederalRoleId())%>"> --%>
			<%-- 						</c:if> --%>
			<%-- 					</liferay-ui:search-container-column-text> --%>



			<%-- 					<liferay-ui:search-container-column-text name="associated"> --%>
			<%-- 						<c:choose> --%>
			<%-- 							<c:when test="<%=ESFFederalRoleLocalServiceUtil.isAssociated(esfUserId, federalRole.getEsfFederalRoleId())%>"> --%>
			<%-- 								<portlet:actionURL name="deAssociateEsfFederalRole" var="deAssociateEsfFederalRoleURL"> --%>
			<%-- 									<portlet:param name="mvcPath" value='/html/esfshooter/edit_esfShooter.jsp' /> --%>
			<%-- 									<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' /> --%>
			<%-- 									<portlet:param name="esfFederalRoleId" value='<%=String.valueOf(federalRole.getEsfFederalRoleId())%>' /> --%>
			<%-- 								</portlet:actionURL> --%>
			<!-- 								<i class="icon-ok"></i> -->
			<%-- 							</c:when> --%>
			<%-- 							<c:otherwise> --%>
			<%-- 								<portlet:actionURL name="associateEsfFederalRole" var="associateEsfFederalRoleURL"> --%>
			<%-- 									<portlet:param name="mvcPath" value='/html/esfshooter/edit_esfShooter.jsp' /> --%>
			<%-- 									<portlet:param name="esfUserId" value='<%=String.valueOf(esfUserId)%>' /> --%>
			<%-- 									<portlet:param name="esfFederalRoleId" value='<%=String.valueOf(federalRole.getEsfFederalRoleId())%>' /> --%>
			<%-- 								</portlet:actionURL> --%>
			<%-- 								<aui:a href="javascript:void(0)" onclick="associateEsfFederalRole(${federalRole.esfFederalRoleId},'${federalRole.code}')"> --%>
			<!-- 									<i class="icon-link"></i> -->
			<%-- 								</aui:a> --%>
			<%-- 							</c:otherwise> --%>
			<%-- 						</c:choose> --%>
			<%-- 					</liferay-ui:search-container-column-text> --%>
			<%-- 					<liferay-ui:search-container-column-text name="Termina Mandato"> --%>
			<%-- 						<c:if test="<%= ESFFederalRoleLocalServiceUtil.isAssociated(esfUserId, federalRole.getEsfFederalRoleId()) %>"> --%>
			<%-- 							<portlet:actionURL name="deAssociateEsfFederalRole"  var="deAssociateEsfFederalRoleURL"> --%>
			<%-- 								<portlet:param name="mvcPath" value='/html/esfshooter/edit_esfShooter.jsp' /> --%>
			<%-- 								<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>' /> --%>
			<%-- 								<portlet:param name="esfFederalRoleId" value='<%= String.valueOf(federalRole.getEsfFederalRoleId()) %>' /> --%>
			<%-- 							</portlet:actionURL> --%>
			<%-- 							<aui:a href="${deAssociateEsfFederalRoleURL}"> --%>
			<!-- 								<i class="icon-remove"></i> -->
			<%-- 							</aui:a> --%>
			<%-- 						</c:if> --%>
			<%-- 					</liferay-ui:search-container-column-text> --%>
			<%-- 					<liferay-ui:search-container-column-text name="Elimina Definittivamente"> --%>
			<%-- 						<liferay-ui:icon-delete url=""/> --%>
			<%-- 					</liferay-ui:search-container-column-text> --%>

			<%-- 				</liferay-ui:search-container-row> --%>
			<%-- 				<liferay-ui:search-iterator /> --%>
			<%-- 			</liferay-ui:search-container> --%>
		</div>
		<div class="span5">
			<div
				id="<portlet:namespace />esfuser-esffederalrole-association-form-box"
				class="hide">
				<hr />
				<div class="row-fluid">
					<div class="span12">
						<div
							id="<portlet:namespace />esf-user-esf-federal-role-association-caption">
						</div>
					</div>
				</div>
				<aui:form action="${associateEsfFederalRoleActionURL}">
					<aui:input name="esfUserId" type="hidden"
						value="<%=String.valueOf(esfUserId)%>" />
					<aui:input name="esfFederalRoleId" type="hidden" />
					<aui:input name="notes" type="textarea" />
					<aui:select name="esfSpecificId">
					</aui:select>
					<aui:button type="submit" value="associate" />
				</aui:form>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<h4>STORICO INCARICHI</h4>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<liferay-ui:search-container emptyResultsMessage="no-results">
				<liferay-ui:search-container-results results="${associations}"
					total="${assTotal}" />

				<liferay-ui:search-container-row
					className="it.ethica.esf.model.ESFUserESFFederalRole"
					modelVar="association">

					<liferay-ui:search-container-column-text name="startDate">
						<c:if test="<%=association.getStartDate() > 0%>">
							<fmt:formatDate value='<%=new Date(association.getStartDate())%>'
								type='date' pattern='dd-MM-yyyy' />
						</c:if>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="endDate">
						<c:if test="<%=association.getEndDate() != null%>">
							<%=DateUtilFormatter.formatDate(association.getEndDate())%>
						</c:if>
					</liferay-ui:search-container-column-text>

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</div>
</div>

<aui:script>
	function associateEsfFederalRole(id, name) {
		AUI()
				.use(
						function(A) {
							var esfFederalRoleAssociationFormBox = A
									.one("#<portlet:namespace />esfuser-esffederalrole-association-form-box");
							var esfFederalRoleId = A
									.one("#<portlet:namespace />esfFederalRoleId");
							var esfFederalRoleAssociationCaption = A
									.one("#<portlet:namespace />esf-user-esf-federal-role-association-caption");
							if (esfFederalRoleId) {
								Liferay
										.Service(
												'/esf-fitav-portlet.esffederalrole/get-federal-role-specifics',
												{
													esfFederalRoleId : id
												}, function(specs) {
													fillSpecificSelect(specs);
												});
								esfFederalRoleId.set('value', id);
								esfFederalRoleAssociationCaption.html(name);
							}
							esfFederalRoleAssociationFormBox
									.removeClass("hide");
						});
	}

	function fillSpecificSelect(specs) {
		AUI()
				.use(
						function(A) {
							var specificIdSelect = A
									.one("#<portlet:namespace />esfSpecificId");
							if (specificIdSelect) {
								for (var i = 0; i < specs.length; i++) {
									specificIdSelect
											.append("<option value='" + specs[i].esfSpecificId + "'>"
													+ specs[i].description
													+ " ("
													+ specs[i].code
													+ ")</input");
								}
							}
						});

	}

	
</aui:script>