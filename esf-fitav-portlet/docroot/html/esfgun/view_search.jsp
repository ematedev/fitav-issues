
<%@page import="com.liferay.portal.model.ListTypeModel"%>
<%@page import="it.ethica.esf.model.impl.ESFgunUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>

<%
	//String code = ParamUtil.getString(request, "code");
	long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
	long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
	List<ESFGunKind> esfGunKinds = ESFGunKindLocalServiceUtil
			.getESFGunKinds();
	List<ESFGunType> esfGunTypes = ESFGunTypeLocalServiceUtil
			.getESFGunTypes();
	boolean show = false;
%>


<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "view_search.jsp"%>' />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<div class="search-form">
		<span class="aui-search-bar"> <aui:select
				inlineField="<%=true%>" name="esfGunTypeId">
				<aui:option label="-" value="0" />
				<%
					for (ESFGunType esfGunType : esfGunTypes) {
				%>

				<aui:option label="<%=esfGunType.getName()%>"
					value="<%=esfGunType.getEsfGunTypeId()%>" />
				<%
					}
				%>

			</aui:select> <%
 	if (show) {
 %> <aui:select inlineField="<%=true%>"
				name="esfGunKindId">
				<aui:option label="-" value="0" />
				<%
					for (ESFGunKind esfGunKind : esfGunKinds) {
				%>

				<aui:option label="<%=esfGunKind.getName()%>"
					value="<%=esfGunKind.getEsfGunKindId()%>" />
				<%
					}
				%>
			</aui:select> <%
 	}
 %> <aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>
<c:if test="<%= ESFGunModelPermission.contains(permissionChecker,scopeGroupId, ActionKeys.ESFGUN_ADD) %>">

	<aui:button-row cssClass="esfgun-admin-buttons">
	
		<portlet:renderURL var="addESFRifleURL">
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfRifle.jsp"%>' />
			<portlet:param name="modifyMode" value="false" />
		</portlet:renderURL>
	
		<aui:button onClick="<%= addESFRifleURL.toString() %>"
			value="ADD-RIFLES" />
	
		<portlet:renderURL var="addESFCaneURL">
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfCane.jsp"%>' />
			<portlet:param name="modifyMode" value="false" />
		</portlet:renderURL>
	
		<aui:button onClick="<%= addESFCaneURL.toString() %>" value="ADD-CANES" />
	
	
		<portlet:renderURL var="addESFCatridgeURL">
			<portlet:param name="mvcPath"
				value='<%=templatePath + "edit_esfCatridge.jsp"%>' />
			<portlet:param name="modifyMode" value="false" />
		</portlet:renderURL>
	
		<aui:button onClick="<%= addESFCatridgeURL.toString() %>"
			value="ADD-CATRIDGES" />
</aui:button-row>
</c:if>

<h3>
	<liferay-ui:message key="RIFLES" />
</h3>
<liferay-ui:search-container emptyResultsMessage="no-results"
	iteratorURL="<%=searchURL%>" delta="5" curParam="sc1">
	<liferay-ui:search-container-results
		results="<%=ESFGunKindLocalServiceUtil
						.getESFGunKindsByESFGunType(esfGunTypeId,
								searchContainer.getStart(),
								searchContainer.getEnd())%>"
		total="<%= ESFGunKindLocalServiceUtil.getESFGunKindCountByESFGunType(esfGunTypeId) %>" />
	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFGunKind" modelVar="esfGun">
		<%
			String model = "";
					String name = "";
					String description = "";
					ESFGunType guntype = new ESFGunTypeImpl();

					if (Validator.isNotNull(esfGun.getName())) {
						name = esfGun.getName().toUpperCase();
					}

					guntype = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGun
							.getEsfGunTypeId());

					if (Validator.isNotNull(guntype)
							&& Validator.isNotNull(guntype.getName())) {
						model = guntype.getName();
					}
					if (Validator.isNotNull(esfGun)
							&& Validator.isNotNull(esfGun.getDescription())) {
						description = esfGun.getDescription();
					}
		%>

		<liferay-ui:search-container-column-text name="model"
			value="<%=model%>" />
		<liferay-ui:search-container-column-text name="Nome"
			value="<%=name%>" />
		<liferay-ui:search-container-column-text name="description"
			value="<%=description%>" />
		<liferay-ui:search-container-column-jsp
			path='<%="/html/esfgun/esfGun_actions.jsp"%>' align="right"
			cssClass="gun_actions_button" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<h3>
	<liferay-ui:message key="CANES" />
</h3>

<liferay-ui:search-container emptyResultsMessage="no-results" iteratorURL="<%= searchURL %>"
		delta="5"
		curParam="sc2">
			<liferay-ui:search-container-results
				results="<%= ESFCaneLocalServiceUtil.getESFGunByLikeT(esfGunTypeId,
								  searchContainer.getStart(),searchContainer.getEnd())%>"
				total="<%= ESFCaneLocalServiceUtil.countESFGunByLikeT(esfGunTypeId) %>" />

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

		%>
		<liferay-ui:search-container-row-parameter name="gUId"
			value="<%=gUId%>" />
		<liferay-ui:search-container-column-text name="shooter"
			value="<%=shooterName%>" />
		<liferay-ui:search-container-column-text name="Nome"
			value="<%=name%>" />
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
		<liferay-ui:search-container-column-jsp
			path='<%="/html/esfgun/esfCane_actions.jsp"%>' align="right"
			cssClass="gun_actions_button" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
<br>
<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
