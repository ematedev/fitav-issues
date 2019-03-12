<%@ include file="../init.jsp" %>
<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>
<%
long esfUserId = ParamUtil.getLong(request, "esfUserId");
long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
//long esfGunId = ParamUtil.getLong(request, "esfGunId");
%>
<liferay-portlet:renderURL varImpl="addRifleURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "esfguncategorization/edit_esfRifle.jsp"%>' />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addmodelTypeURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "esfguncategorization/view.jsp"%>' />
	<portlet:param name="esfgunUserId" value="<%=String.valueOf(esfgunUserId)%>" />
	<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId)%>" />
</liferay-portlet:renderURL>

<h3><liferay-ui:message key="RIFLES"/></h3>	


<aui:button onClick="<%= addRifleURL.toString() %>"
					value="ADD-RIFLES" />
<aui:button onClick="<%= addRifleURL.toString() %>"
					value="ADD-TYPE-MODEL" />

<liferay-ui:search-container emptyResultsMessage="no-results" delta="10"  curParam= "sc1">	
			<liferay-ui:search-container-results
				results="<%= ESFGunLocalServiceUtil.getESFGuns(searchContainer.getStart(), searchContainer.getEnd())  %>"
				total="<%=ESFGunLocalServiceUtil.getESFGunsCount() %>" />

			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFGun" modelVar="esfGun">
					
					<%
					String model = "";
					ESFGunKind kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGun.getEsfGunKindId());
					if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfGunTypeId()) && 
							Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId())) &&
							Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()).getName())){
								model = ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()).getName();
					}
					String name = "";
					if(Validator.isNotNull(model) && Validator.isNotNull(esfGun.getName())){
						name = (model+"   "+esfGun.getName()).toUpperCase();
					}else if(Validator.isNotNull(model)){
						name = ESFGunLocalServiceUtil.getFullName(esfGun);
					}
					%>
					
					<liferay-ui:search-container-column-text name="model" value="<%=model%>" />
					<liferay-ui:search-container-column-text name="Nome"
						value="<%= name%>" />

					<liferay-ui:search-container-column-text property="catridgeCaliber" />
					<liferay-ui:search-container-column-text name="typology" value='<%=ESFGunLocalServiceUtil.getNameT(esfGun) %>'/>
					<liferay-ui:search-container-column-text property="measures" />
					<liferay-ui:search-container-column-jsp
					path='<%= templatePath + "esfguncategorization/esfGun_actions.jsp" %>' align="right" />	

			</liferay-ui:search-container-row>
		 <liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>
