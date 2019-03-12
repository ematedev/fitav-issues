<%@ include file="init.jsp" %>
<% String esfFornitureId = ParamUtil.getString(renderRequest, "esfFornitureId") ; %>
<portlet:actionURL name="updateESFQuantity" var="updateESFQuantity" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFornitureId" value="<%= esfFornitureId  %>" />
</portlet:actionURL>


<h3>Inserisci la quantità aggiornata: </h3>
<aui:form action="<%=updateESFQuantity %>">
<aui:input name="quantity" type="text" value="0">
	<aui:validator name="min" errorMessage="The_number_is_not_positive">0</aui:validator>
	<aui:validator name="required"/>
</aui:input>
<aui:button name="update" type="submit" value="Update"/>
<aui:button id="enabled-button" onClick="<%= viewURL.toString() %>" value ="Return" />
</aui:form>