<%-- <%@ include file="/html/esfconfigurationstate/init.jsp" %> --%>
<%-- <%@page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%> --%>
<%-- <%@ include file="init.jsp"%> --%>
<%-- <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> --%>
<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> --%>
<%-- <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> --%>
<%-- <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %> --%>
<!-- <portlet:defineObjects /> -->

<aui:form action="<%= updateESFStateAssEntityVar%>" name="<portlet:namespace />fm">
	<aui:button-row>
		<aui:button type="submit" value="Associa"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
	<aui:input type="hidden" name="type" value='NA' />
	<aui:input type="hidden" name="esfStateId" value='<%= esfStateId%>' />
	<liferay-ui:search-container delta="100" emptyResultsMessage="no-result" deltaConfigurable="false" >
		<liferay-ui:search-container-results>
			<%
			List<ClassName> allEsfClassName = ESFStateLocalServiceUtil.getESFClassNameNotAssigned(esfStateId);
			searchContainer.setResults(allEsfClassName);
			searchContainer.setTotal(allEsfClassName.size());
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.liferay.portal.model.ClassName" modelVar="className">
			<liferay-ui:search-container-column-text title="choose-entity">
				<aui:input name="choose" label="" type="checkbox"
					id='<%="choose_" + className.getClassNameId()%>'>
				</aui:input>
				<aui:input type="hidden" name="classNameIds"
					id='<%="classNameIds_" + className.getClassNameId()%>'
					value='<%= className.getClassNameId()%>' />
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="value" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="false" />
	</liferay-ui:search-container>
</aui:form>