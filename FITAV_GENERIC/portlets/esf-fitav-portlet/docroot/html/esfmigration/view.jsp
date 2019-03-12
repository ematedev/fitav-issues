<%@ include file="init.jsp"%>

<portlet:actionURL name="createProvincesAndRegions" var="createProvincesAndRegionsURL" />
<aui:form action="<%= createProvincesAndRegionsURL %>" method="post" name="fm1">
	<span>Crea le organizzazioni associate alle ESFProvinces e ESFRegions</span>
	<aui:button type="submit" value="Crea Province e Regioni" />
</aui:form>

<hr/>

<portlet:actionURL name="populateCategoryAndQualification" var="populateCategoryAndQualificationURL" />
<aui:form action="<%= populateCategoryAndQualificationURL %>" method="post" name="fm2">
	<span>Crea ESFShooterCategory e ESFShooterQualification</span>
	<aui:button type="submit" value="Crea Categorie e Qualifiche" />
</aui:form>

<hr/>

<portlet:actionURL name="populateMatchType" var="populateMatchTypeURL" />
<aui:form action="<%= populateMatchTypeURL %>" method="post" name="fm3">
	<span>Popola la tabella ESFMatchType</span>
	<aui:button type="submit" value="Crea Match Type" />
</aui:form>

<hr/>

<portlet:actionURL name="addNewCardOldShooter" var="addNewCardOldShooterURL" />
<aui:form action="<%= addNewCardOldShooterURL %>" method="post" name="fm3">
	<span>Inserire le tessere nuove per i tiratori già tesserati</span>
	<aui:button type="submit" value="Crea Match Type" />
</aui:form>
<hr/>

<c:choose>
	<c:when
		test="<%=UserPermissionUtil.contains(
						permissionChecker, userId,
						ActionKeys.VIEW_CONTROL_PANEL)%>">
		<div class="display-info">

			<liferay-ui:error key="migration-error" message="migration-error" />

			<liferay-ui:success key="migration-success" message="migration-success" />

			<!-- Organization Migration -->
			<aui:form action="<%=migrationOrganizationURL%>" method="post" name="fm4">
				<liferay-ui:message key="you-can-migrate-the-oragnizzation-data-from-old-database-in-your-database" />
				<aui:button type="submit" value="Importa Associazioni" />
			</aui:form>


			<aui:form action="<%=migrationShooterURL%>" method="post" name="fm5">
				<liferay-ui:message key="you-can-migrate-the-shooter-data-from-old-database-in-your-database" />
				<aui:input name="selectShooter" />
				<aui:button type="submit" value="Importa tiratori" />
			</aui:form>
			
			
<%-- 			<liferay-ui:message --%>
<%-- 				key="you-can-update-user-site" /> --%>
<%-- 			<aui:form action="<%=updateShooterURL%>" method="post" name="fm6"> --%>
<%-- 				<aui:button type="submit" value="execute" /> --%>
<%-- 			</aui:form> --%>
			

			<aui:form action="<%=migrationBDOURL%>" method="post" name="fm7">
				<liferay-ui:message key="you-can-migrate-the-bdo-data-from-old-database-in-your-database" />
				<aui:button type="submit" value="execute" />
			</aui:form>
			

<%-- 			<aui:form action="<%=migrationShooterSetDateURL%>" method="post" name="fm8"> --%>
<%-- 				<liferay-ui:message key="you-can-update-date-for-user" /> --%>
<%-- 				<aui:button type="submit" value="execute" /> --%>
<%-- 			</aui:form> --%>

			<aui:form action="<%=migrationMatchesURL%>" method="post" name="fm4">
				<liferay-ui:message
					key="you-can-migrate-the-matches-data-from-old-database-in-your-database" />
				<aui:input showRequiredLabel="true" name="schemaDotTableName" label="Inserisci schema.table di origine dei Match:"></aui:input>
				<aui:button type="submit" value="Importa Matches" />
				
			</aui:form> 
			
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message
				key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>





