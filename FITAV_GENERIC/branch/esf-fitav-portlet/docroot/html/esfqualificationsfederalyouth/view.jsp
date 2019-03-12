<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="init.jsp"%> 
<%
		String tabs = ParamUtil.getString(request, "tabs1", "Fossa Olimpica");
		portletURL.setWindowState(WindowState.NORMAL);

		portletURL.setParameter("mvcPath", "/html/esfqualificationsfederalyouth/view.jsp");
        portletURL.setParameter("tabs", tabs);

		String tabNames = "Fossa Olimpica,Double Trap,Skeet";
		ArrayList<ESFUser> fossaOlimpicaEsordientiMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaEsordientiMaschi");
		ArrayList<ESFUser> fossaOlimpicaEsordientiFemmine = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaEsordientiFemmine");
		ArrayList<ESFUser> fossaOlimpicaGSMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaGSMaschi");
		ArrayList<ESFUser> fossaOlimpicaAllieviMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaAllieviMaschi");
		ArrayList<ESFUser> fossaOlimpicaAllieviFemmine = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaAllieviFemmine");
		ArrayList<ESFUser> doubleTrapAllieviMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("doubleTrapAllieviMaschi");
		ArrayList<ESFUser> doubleTrapEsordientiMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("doubleTrapEsordientiMaschi");
		ArrayList<ESFUser> skeetEsordientiMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("skeetEsordientiMaschi");
		ArrayList<ESFUser> skeetEsordientiFemmine = (ArrayList<ESFUser>)renderRequest.getAttribute("skeetEsordientiFemmine");
		ArrayList<ESFUser> skeetAllieviMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("skeetAllieviMaschi");
		ArrayList<ESFUser> skeetAllieviFemmine = (ArrayList<ESFUser>)renderRequest.getAttribute("skeetAllieviFemmine");
		ArrayList<ESFUser> skeetJunioresFemmine = (ArrayList<ESFUser>)renderRequest.getAttribute("skeetJunioresFemmine");
		ArrayList<ESFUser> skeetJunioresMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("skeetJunioresMaschi");
		ArrayList<ESFUser> fossaOlimpicaJunioresMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaJunioresMaschi");
		ArrayList<ESFUser> fossaOlimpicaJunioresFemmine = (ArrayList<ESFUser>)renderRequest.getAttribute("fossaOlimpicaJunioresFemmine");
		ArrayList<ESFUser> doubleTrapJunioresMaschi = (ArrayList<ESFUser>)renderRequest.getAttribute("doubleTrapJunioresMaschi");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
       
%>
<portlet:actionURL var="updateQualification" name="updateQualification">
</portlet:actionURL>
<aui:button id= "update" value="update" onClick="<%= updateQualification %>"/>
<br/><br/>
<liferay-ui:tabs names="<%=tabNames%>" url="<%=portletURL.toString()%>" >
	<c:if test='<%=tabs.equals("Fossa Olimpica")%>'>
		<%@ include file="/html/esfqualificationsfederalyouth/tabs/fossaolimpica.jsp"%> 
	</c:if>
	
	<c:if test='<%=tabs.equals("Double Trap")%>'>
		<%@ include file="/html/esfqualificationsfederalyouth/tabs/doubletrap.jsp"%>
	</c:if>
	
	<c:if test='<%=tabs.equals("Skeet")%>'>
		<%@ include file="/html/esfqualificationsfederalyouth/tabs/skeet.jsp"%>
	</c:if>
</liferay-ui:tabs>