<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="it.ethica.esf.service.ESFFederalRoleLocalServiceUtil" %>
<%@ page import="it.ethica.esf.service.ESFSpecificLocalServiceUtil" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	long esfUserId = ParamUtil.getLong(request, "esfUserId", -1);
%>
<portlet:actionURL name="associateEsfFederalRole"  var="associateEsfFederalRoleActionURL" copyCurrentRenderParameters="false">
	<portlet:param name="mvcPath" value='/html/esfshooter/edit_esfShooter.jsp' />
</portlet:actionURL>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h4>INCARICHI FEDERALI</h4>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<liferay-ui:search-container emptyResultsMessage="no-results">
					<liferay-ui:search-container-results results="${currentResults}" total="${currentTotal}" />
			
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUserESFFederalRole" modelVar="association">

					<liferay-ui:search-container-column-text name="code">
						<%= ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(association.getEsfFederalRoleId()).getCode() %>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="description">
						<%= ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(association.getEsfFederalRoleId()).getDescription() %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="startDate">
						<c:if test="<%= association.getStartDate() > 0 %>">
							<fmt:formatDate value='<%= new Date(association.getStartDate()) %>' type='date' pattern='dd-MM-yyyy'/>
						</c:if>	
					</liferay-ui:search-container-column-text>		
					<liferay-ui:search-container-column-text name="endDate">
						<c:if test="<%= association.getEndDate() != null %>">
							<fmt:formatDate value='<%= association.getEndDate() %>' type='date' pattern='dd-MM-yyyy'/>
						</c:if>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="specific">
						<c:if test="<%= association.getEsfSpecificId() > 0 %>">
							<%= ESFSpecificLocalServiceUtil.fetchESFSpecific(association.getEsfSpecificId()).getDescription() %>
						</c:if>
					</liferay-ui:search-container-column-text>
				
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="false" />
				
			</liferay-ui:search-container>		
		</div>
	<div class="row-fluid">
		<div class="span12">
			<a href="javascript:void(0)" onclick="<portlet:namespace />openModal()" class="btn">ASSEGNA INCARICO FEDERALE</a>
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
					<liferay-ui:search-container-results results="${associations}" total="${assTotal}" />
			
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFUserESFFederalRole" modelVar="association">

					<liferay-ui:search-container-column-text name="code">
						<%= ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(association.getEsfFederalRoleId()).getCode() %>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="description">
						<%= ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(association.getEsfFederalRoleId()).getDescription() %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="startDate">
						<c:if test="<%= association.getStartDate() > 0 %>">
							<fmt:formatDate value='<%= new Date(association.getStartDate()) %>' type='date' pattern='dd-MM-yyyy'/>
						</c:if>	
					</liferay-ui:search-container-column-text>		
					<liferay-ui:search-container-column-text name="endDate">
						<c:if test="<%= association.getEndDate() != null %>">
							<fmt:formatDate value='<%= association.getEndDate() %>' type='date' pattern='dd-MM-yyyy'/>
						</c:if>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="specific">
						<c:if test="<%= association.getEsfSpecificId() > 0 %>">
							<%= ESFSpecificLocalServiceUtil.fetchESFSpecific(association.getEsfSpecificId()).getDescription() %>
						</c:if>
					</liferay-ui:search-container-column-text>
				
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="false" />
				
			</liferay-ui:search-container>		
		</div>
	</div>
</div>
<div id="<portlet:namespace />availableFederalRolesBox" class="container-fluid hide">
	<div class="row-fluid">
		<div class="span7">
			<liferay-ui:search-container emptyResultsMessage="no-results">
					<liferay-ui:search-container-results results="${federalRoles}" total="${federalRolesTotal}" />
			
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFFederalRole" modelVar="federalRole">
					
					<liferay-ui:search-container-column-text property="code" />		
					<liferay-ui:search-container-column-text property="description" />
					<liferay-ui:search-container-column-text name="startDate">
						<c:if test="<%= ESFFederalRoleLocalServiceUtil.isAssociated(esfUserId, federalRole.getEsfFederalRoleId()) %>">
							<fmt:formatDate value='<%= ESFFederalRoleLocalServiceUtil.getActiveAssociationDate(esfUserId, federalRole.getEsfFederalRoleId()) %>' type='date' pattern='dd-MM-yyyy'/>
						</c:if>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="associated">
					<c:choose>
						<c:when test="<%= ESFFederalRoleLocalServiceUtil.isAssociated(esfUserId, federalRole.getEsfFederalRoleId()) %>">
							<portlet:actionURL name="deAssociateEsfFederalRole"  var="deAssociateEsfFederalRoleURL">
								<portlet:param name="mvcPath" value='/html/esfshooter/edit_esfShooter.jsp' />
								<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>' />
								<portlet:param name="esfFederalRoleId" value='<%= String.valueOf(federalRole.getEsfFederalRoleId()) %>' />
							</portlet:actionURL>
							<i class="icon-ok"></i>
							<aui:a href="${deAssociateEsfFederalRoleURL}">
								<i class="icon-remove"></i>
							</aui:a>
						</c:when>
						<c:otherwise>
							<portlet:actionURL name="associateEsfFederalRole"  var="associateEsfFederalRoleURL">
								<portlet:param name="mvcPath" value='/html/esfshooter/edit_esfShooter.jsp' />
								<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>' />
								<portlet:param name="esfFederalRoleId" value='<%= String.valueOf(federalRole.getEsfFederalRoleId()) %>' />
							</portlet:actionURL>
							<aui:a href="javascript:void(0)" onclick="associateEsfFederalRole(${federalRole.esfFederalRoleId},'${federalRole.code}')">
								<i class="icon-link"></i>
							</aui:a>
						</c:otherwise>
					</c:choose>
					</liferay-ui:search-container-column-text>
				
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="false" />
			</liferay-ui:search-container>		
		</div>
		<div class="span5">
			<div id="<portlet:namespace />esfuser-esffederalrole-association-form-box" class="hide">
				<hr />
				<div class="row-fluid">
					<div class="span12">
						<div id="<portlet:namespace />esf-user-esf-federal-role-association-caption">
						</div>
					</div>
				</div>
				<aui:form action="${associateEsfFederalRoleActionURL}">
					<aui:input name="esfUserId" type="hidden" value="<%= String.valueOf(esfUserId) %>" />
					<aui:input name="esfFederalRoleId" type="hidden" />
					<aui:input name="notes" type="textarea" />
					<aui:select name="esfSpecificId" label="specific">
					</aui:select>
					<a href="javascript:void(0)" onclick="<portlet:namespace />submitAssociationForm()" class="btn btn-primary">
						<liferay-ui:message key="associate" />
					</a>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<div class="yui3-skin-sam">
  <div id="<portlet:namespace />modal">
  </div>
</div>

<aui:script>
Liferay.provide(window, '<portlet:namespace />openModal', function(){
	AUI().use(function(A){
		var formContainer = A.one('#<portlet:namespace />availableFederalRolesBox');
		formContainer.removeClass("hide");
		var modal = new A.Modal(
			      {
			        bodyContent: formContainer,
			    	centered: true,
			        headerContent: "ASSOCIAZIONE INCARICHI FEDERALI",
			        modal: true,
			        render: '#<portlet:namespace />modal',
			        width: 800,
			        zIndex: 1100
			      }
			    ).render();
	});
});

function associateEsfFederalRole(id, name){
	AUI().use(function(A){
		var esfFederalRoleAssociationFormBox = A.one("#<portlet:namespace />esfuser-esffederalrole-association-form-box");
		var esfFederalRoleId = A.one("#<portlet:namespace />esfFederalRoleId");
		var esfFederalRoleAssociationCaption = A.one("#<portlet:namespace />esf-user-esf-federal-role-association-caption");
		if(esfFederalRoleId){
			Liferay.Service(
					  '/esf-fitav-portlet.esffederalrole/get-federal-role-specifics',
					  {
					    esfFederalRoleId: id
					  },
					  function(specs) {
						  fillSpecificSelect(specs);
					  }
					);	
			esfFederalRoleId.set('value', id);
			esfFederalRoleAssociationCaption.html(name);
		}
		esfFederalRoleAssociationFormBox.removeClass("hide");
	});
}

function fillSpecificSelect(specs){
	AUI().use(function(A){
		var specificIdSelect = A.one("#<portlet:namespace />esfSpecificId");
		if(specificIdSelect){
			for(var i=0; i< specs.length; i++){
				specificIdSelect.append("<option value='" + specs[i].esfSpecificId + "'>"+ specs[i].description + " (" + specs[i].code + ")</input");
			}
		}
	});
	
}

function <portlet:namespace />submitAssociationForm(){
	AUI().use('liferay-portlet-url', function(A){
		var notes = A.one("#<portlet:namespace />notes");
		var esfSpecificId = A.one("#<portlet:namespace />esfSpecificId");
		var esfFederalRoleId = A.one("#<portlet:namespace />esfFederalRoleId");
		var actionUrlString = 
			'${associateEsfFederalRoleActionURL}' +
			'&<portlet:namespace />esfUserId=${esfUserId}' +
			'&<portlet:namespace />esfFederalRoleId=' + esfFederalRoleId.get('value') +
			'&<portlet:namespace />notes=' + notes.get('value') +
			'&<portlet:namespace />esfSpecificId=' + esfSpecificId.get('value') +
			'#<portlet:namespace />tab=<portlet:namespace />federal_roles';
		window.location=actionUrlString;
	});
	
}
</aui:script>
