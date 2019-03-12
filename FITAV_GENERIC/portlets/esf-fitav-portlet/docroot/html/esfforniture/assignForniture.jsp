<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="it.ethica.esf.util.ManageDate"%>  
<%@page import="java.util.Calendar"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@ include file="init.jsp"%>
<% String esfFornitureId = ParamUtil.getString(renderRequest,"esfFornitureId");
   Long esfFornitureIdLong = Long.parseLong(esfFornitureId);
   String esfUserId = ParamUtil.getString(renderRequest,"esfUserId");
   ESFForniture esfForniture = ESFFornitureLocalServiceUtil.fetchESFForniture(esfFornitureIdLong);
   %>
<%
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	String currDate = ManageDate.CalendarToString(calendar);
	
	
%>
<portlet:actionURL name="assignForniture" var="assignForniture" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="esfFornitureId"
				value="<%= esfFornitureId %>" />
			<portlet:param name="esfUserId"
				value="<%= esfUserId %>" />
</portlet:actionURL>

<aui:script>
	$(function() {
		$("#<portlet:namespace/>esfDateAssign").datepicker();
		$("#<portlet:namespace/>esfDateAssign").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>esfDateAssign").datepicker("setDate",
				'<%= currDate %>');

	});
</aui:script>
<aui:form action="<%=assignForniture %>">
 <h3>Inserisci quantità:</h3>
 <p>Quantità massima disponibile di <%=esfForniture.getName() %> è: <%=Long.toString(esfForniture.getNumberFornitures()) %> </p>
 <aui:input name="quantity" type="text" value="1">
 	<aui:validator name="required" errorMessage="This field can not to be blank" />
 	<aui:validator name="min" errorMessage="This is not a positive number">1</aui:validator>
 	<aui:validator name="max" errorMessage="Out of pieces avaibles"><%=esfForniture.getNumberFornitures()%></aui:validator>
 </aui:input>
 <h3>Inserisci data assegnazione:</h3>
 <aui:input type="text" name="esfDateAssign">
 	<aui:validator name="required" errorMessage="This field can not to be blank" />
 </aui:input>
 <aui:button name="send" type="submit" value="Invia"/>
 <aui:button id="enabled-button" onClick="<%=viewURL.toString() %>" value="Return"/>
</aui:form>