<%@ include file="init.jsp" %>
<%
	ESFForniture esfForniture = null;
	long eSFFornitureId = ParamUtil.getLong(request, "esfFornitureId");
	if (eSFFornitureId > 0) {
		esfForniture = ESFFornitureLocalServiceUtil.getESFForniture(eSFFornitureId);
	}

	List <ESFFornitureType> esfFornitureTypes = ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes();
%>

<portlet:actionURL name="editESFForniture" var="editESFFornitureURL" windowState="<%=WindowState.NORMAL.toString()%>" />

<aui:form action="<%= editESFFornitureURL %>" name="<portlet:namespace />fm">
		<aui:model-context bean="<%= esfForniture %>" model="<%= ESFForniture.class %>" />

		<aui:fieldset>
			<aui:input type="hidden" name="esfFornitureId"
				value='<%= esfForniture == null ? "" : esfForniture.getEsfFornitureId() %>' />
			<aui:input name="code" />
			<aui:input name="name" />
			<aui:input name="description" type="textarea"/>
			<aui:select name="type" required="true" >
		      <%for (ESFFornitureType esfFornitureType : esfFornitureTypes) {  %>
      			<aui:option value="<%= esfFornitureType.getEsfFornitureTypeId() %>">
             		<liferay-ui:message key="<%= esfFornitureType.getDescription() %>" />
      			</aui:option>
     			<% } %>
		    </aui:select>
		    <aui:input label="sizeDress" name="size" type="text"/>
			<!-- aui:input name="numberFornitures"/-->
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
		</aui:button-row>
</aui:form>