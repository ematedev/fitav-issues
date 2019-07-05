<%-- <%@ include file="/html/esfconfigurationstate/init.jsp" %> --%>
<%-- <%@ include file="init.jsp"%> --%>
<%-- <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> --%>
<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> --%>
<%-- <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> --%>
<%-- <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %> --%>
<!-- <portlet:defineObjects /> -->

<aui:form action="<%= updateESFStateAssEntityVar%>" name="<portlet:namespace />fm">
	<aui:button-row>
		<aui:button type="submit" value="Dissocia"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>
	<aui:input type="hidden" name="type" value='A' />
	<aui:input type="hidden" name="esfStateId" value='<%= esfStateId%>' />
	<liferay-ui:search-container delta="100" emptyResultsMessage="no-result" deltaConfigurable="false" >
		<liferay-ui:search-container-results>
			<%
			List<ClassName> allEsfClassName = ESFStateLocalServiceUtil.getESFClassNameAssigned(esfStateId);
			pageContext.setAttribute("results", allEsfClassName);
			pageContext.setAttribute("total", allEsfClassName.size());
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.liferay.portal.model.ClassName" modelVar="className">
			<liferay-ui:search-container-column-text title="choose-entity" >			
				<%
				ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
					className.getValue(), esfStateId);
				boolean disabled = false;
				if(esfEntityState != null)
					disabled = true;
				%>
				<aui:input name="choose" label="" type="checkbox"
					id='<%="choose_" + className.getClassNameId()%>'
					disabled="<%= disabled %>">
				</aui:input>

				<aui:input type="hidden" name="classNameIds"
					id='<%="classNameIds_" + className.getClassNameId()%>'
					value='<%= className.getClassNameId()%>' />

			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="value" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>