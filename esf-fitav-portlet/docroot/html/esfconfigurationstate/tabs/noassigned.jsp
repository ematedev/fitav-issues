<%-- <%@ include file="/html/esfconfigurationstate/init.jsp" %> --%>

<aui:form action="<%= updateESFStateAssEntityVar%>"
	name="<portlet:namespace />fm">

	<aui:button-row>
		<aui:button type="submit" value="Associa"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="no-result">
		<liferay-ui:search-container-results>
			<%
			List<ClassName> allEsfClassName =
								ESFStateLocalServiceUtil.getESFClassNameNotAssigned(esfStateId);

			pageContext.setAttribute("results", allEsfClassName);
			pageContext.setAttribute("total", allEsfClassName.size());
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.portal.model.ClassName" modelVar="className">
			<liferay-ui:search-container-column-text>
			
				<aui:input name="choose" label="" type="checkbox"
					id='<%="choose_" + className.getClassNameId()%>'>
				</aui:input>

				<aui:input type="hidden" name="classNameIds"
					id='<%="classNameIds_" + className.getClassNameId()%>'
					value='<%= className.getClassNameId()%>' />

			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text property="value" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<aui:input type="hidden" name="type"
		value='NA' />
	<aui:input type="hidden" name="esfStateId"
		value='<%= esfStateId%>' />
</aui:form>