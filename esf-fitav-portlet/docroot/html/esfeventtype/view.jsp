<%@ include file="init.jsp"%>

<portlet:renderURL var="addESFEventTypeURL">
	<portlet:param name="mvcPath"
		value='<%=templatePath + "edit_esfEventType.jsp"%>' />
</portlet:renderURL>

<liferay-ui:error key="esfEventType-reference-error"
	message="esfEventType-reference-error" />

<aui:button onClick="<%= addESFEventTypeURL.toString()%>"
	value="add-EventType" />


<liferay-ui:search-container emptyResultsMessage="no-results">

	<liferay-ui:search-container-results
	
		results="<%=ESFEventTypeLocalServiceUtil.findAll()%>"
		total="<%=ESFEventTypeLocalServiceUtil.findAll().size()%>" />

	<liferay-ui:search-container-row
		className="it.ethica.esf.model.ESFEventType" modelVar="esfEventType">

		<liferay-ui:search-container-column-text property="macrocategory"  name="Macrocategory" />

		<liferay-ui:search-container-column-text property="eventType" name="EventType" />

		<liferay-ui:search-container-column-jsp
			path='<%=templatePath + "esfEventType_actions.jsp"%>' align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
