<%@ include file="init.jsp"%>

<c:choose>
	<c:when
		test="<%=UserPermissionUtil.contains(
						permissionChecker, userId,
						ActionKeys.VIEW_CONTROL_PANEL)%>">
		<div class="display-info">

			<liferay-ui:error key="migration-error" message="migration-error" />

			<liferay-ui:success key="migration-success" message="migration-success" />

			<!-- Organization Migration -->
			<liferay-ui:message key="you-can-migrate-the-oragnizzation-data-from-old-database-in-your-database" />
			<aui:form action="<%=migrationOrganizationURL%>" method="post" name="fm1">
				<aui:button type="submit" value="execute" />
			</aui:form>








			<liferay-ui:message
				key="you-can-migrate-the-shooter-data-from-old-database-in-your-database" />

			<aui:form action="<%=migrationShooterURL%>" method="post" name="fm2">
				<aui:button type="submit" value="execute" />
			</aui:form>
			
			
			<aui:form action="<%=updateShooterURL%>" method="post" name="fm2">
				<aui:button type="submit" value="execute" />
			</aui:form>
			
			
			
			<liferay-ui:message
				key="you-can-migrate-the-bdo-data-from-old-database-in-your-database" />

			<aui:form action="<%=migrationBDOURL%>" method="post" name="fm3">
				<aui:button type="submit" value="execute" />
			</aui:form>
			
			
			<%-- 
			<liferay-ui:message
				key="set-layout-template" />

			<aui:form action="<%=migrationLayoutOrganizationURL%>" method="post" name="fm2">
				<aui:button type="submit" value="execute" />
			</aui:form>
			--%>
			
			
			
			
			<liferay-ui:message
				key="you-can-update-date-for-user" />

			<aui:form action="<%=migrationShooterSetDateURL%>" method="post" name="fm2">
				<aui:button type="submit" value="execute" />
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





