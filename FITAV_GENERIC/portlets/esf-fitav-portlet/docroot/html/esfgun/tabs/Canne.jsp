<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFgunUserImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>


<h3>
	<liferay-ui:message key="CANES" />
</h3>

<liferay-ui:search-container emptyResultsMessage="no-results" delta="5"
	curParam="sc2">
	<liferay-ui:search-container-results
		results="<%=ESFCaneLocalServiceUtil.getESFCanes(
						searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=ESFCaneLocalServiceUtil.getESFCanes().size()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFCane" modelVar="esfCane">
		<%
			String shooterName = "";
					String freshman = "";
					String caneCaliber = "";
					String measures = "";
					String typology = "";
					String name = "";
					String nameGun = "";
					String nameType = "";
					String shooter_note = "";
					long gUId = 0;
					ESFUser shooter = ESFUserLocalServiceUtil
							.fetchESFUser(esfCane.getShooterId());
					List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil
							.findbyESFGunId(esfCane.getEsfCaneId());
					ESFgunUser gU = new ESFgunUserImpl();
					ESFGun gun = ESFGunLocalServiceUtil.fetchESFGun(esfCane
							.getEsfGunKindId());
					ESFGunKind kind = new ESFGunKindImpl();
					ESFGunType type = new ESFGunTypeImpl();

					if (Validator.isNotNull(shooter)) {

						if (Validator.isNotNull(shooter.getFirstName())) {
							shooterName = shooter.getFirstName().toUpperCase();
						}
						if (Validator.isNotNull(shooter.getLastName())) {
							shooterName = shooterName + " "
									+ shooter.getLastName().toUpperCase();
						}

					}
					for (ESFgunUser gunUser : gunUsers) {
						if (ESFKeys.ESFGunType.CANE == gunUser.getType()) {
							gU = gunUser;
						}
					}
					if (Validator.isNotNull(gU)
							&& Validator.isNotNull(gU.getCode())) {
						freshman = gU.getCode();
					}
					if (Validator.isNotNull(gU)
							&& Validator.isNotNull(gU.getNote())) {
						shooter_note = gU.getNote();
					}
					if (Validator.isNotNull(esfCane.getCaneCaliber())) {
						caneCaliber = String.valueOf(esfCane.getCaneCaliber());
					}
					if (Validator.isNotNull(esfCane.getMeasures())) {
						measures = esfCane.getMeasures();
					}
					if (Validator.isNotNull(esfCane.getTypeId())
							&& Validator.isNotNull(ListTypeServiceUtil
									.getListType((int) esfCane.getTypeId()))
							&& Validator.isNotNull(ListTypeServiceUtil
									.getListType((int) esfCane.getTypeId())
									.getName())) {
						typology = ListTypeServiceUtil.getListType(
								(int) esfCane.getTypeId()).getName();
					}
					if (Validator.isNotNull(esfCane.getEsfGunKindId())
							&& Validator
									.isNotNull(ESFGunKindLocalServiceUtil
											.fetchESFGunKind(esfCane
													.getEsfGunKindId()))) {
						kind = ESFGunKindLocalServiceUtil
								.fetchESFGunKind(esfCane.getEsfGunKindId());
					}
					if (Validator.isNotNull(kind.getName())) {
						name = kind.getName().toUpperCase();
					}
					if (Validator.isNotNull(esfCane.getEsfGunTypeId())
							&& Validator
									.isNotNull(ESFGunTypeLocalServiceUtil
											.fetchESFGunType(esfCane
													.getEsfGunTypeId()))
							&& Validator.isNotNull(ESFGunTypeLocalServiceUtil
									.fetchESFGunType(esfCane.getEsfGunTypeId())
									.getName())) {
						nameGun = ESFGunTypeLocalServiceUtil.fetchESFGunType(
								esfCane.getEsfGunTypeId()).getName();
					}
					name = nameGun + "-" + name;
		%>
		<liferay-ui:search-container-row-parameter name="gUId"
			value="<%=gUId%>" />
		<liferay-ui:search-container-column-text name="shooter"
			value="<%=shooterName%>" />
		<liferay-ui:search-container-column-text name="Nome" value="<%=name%>" />
		<liferay-ui:search-container-column-text value="<%=freshman%>"
			name="freshman" />
		<liferay-ui:search-container-column-text value="<%=caneCaliber%>"
			name="catridgeCaliber" />
		<liferay-ui:search-container-column-text name="typology"
			value='<%=typology%>' />
		<liferay-ui:search-container-column-text value="<%=measures%>"
			name="measures" />
		<liferay-ui:search-container-column-text value="<%=shooter_note%>"
			name="shooter_note" />
			
<c:if test="<%= ESFGunPermission.containsCane(permissionChecker,esfCane.getEsfCaneId(), ActionKeys.ESFGUN_VIEW_ACTION) %>">	
		<liferay-ui:search-container-column-jsp
			path='<%="/html/esfgun/esfCane_actions.jsp"%>' align="right"
			cssClass="gun_actions_button" />
			
</c:if>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
