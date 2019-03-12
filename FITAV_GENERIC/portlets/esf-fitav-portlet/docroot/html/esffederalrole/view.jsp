<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<portlet:actionURL name="updateEsfFederalRole"  var="updateEsfFederalRoleURL" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
			<aui:form action="${updateEsfFederalRoleURL}">
				<aui:fieldset>
					<aui:input name="esfFederalRoleId" type="hidden" value="${esfFederalRole.esfFederalRoleId}"></aui:input>
					<aui:input name="code" value="${esfFederalRole.code}" />
					<aui:input name="description" value="${esfFederalRole.description}" />
					<aui:input name="regional" type="checkbox" value="${esfFederalRole.regional}" />
					<aui:input name="provincial"  type="checkbox" value="${esfFederalRole.provincial}" />
				</aui:fieldset>
				<aui:button-row>
					<aui:button type="submit" value="save" />
					<aui:button type="reset" value="reset" />
				</aui:button-row>
			</aui:form>
		</div>
		<div class="span8">
			<liferay-ui:search-container emptyResultsMessage="no-results">
					<liferay-ui:search-container-results results="${results}" total="${total}" />
			
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFFederalRole" modelVar="federalRole">
					
					<liferay-ui:search-container-column-text property="code" />		
					<liferay-ui:search-container-column-text property="description" />
					<liferay-ui:search-container-column-text name="regional">
						<c:if test="${federalRole.regional}">
							<i class="icon-ok"></i>
						</c:if>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="provincial">
						<c:if test="${federalRole.provincial}">
							<i class="icon-ok"></i>
						</c:if>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="actions">
						<portlet:renderURL var="modifyEsfFederalRoleURL">
							<portlet:param name="esfFederalRoleId" value="${federalRole.esfFederalRoleId}"/>
						</portlet:renderURL>
						<a href="${modifyEsfFederalRoleURL}"><i class="icon-edit"></i></a>
					</liferay-ui:search-container-column-text>
				
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="false" />
			</liferay-ui:search-container>		
		</div>
	</div>
</div>
