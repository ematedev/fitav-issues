<%@page import="it.ethica.esf.model.VM_TiratoriTesserati"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp"%>

<%

//Prende l'url dall'attributo dell'mvcPath
String mvcPath = ParamUtil.getString(request, "mvcPath");
//Prende l'oggetto che rappresenta la riga che ha chiamato questa pagina
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
//Prende l'utente
VM_TiratoriTesserati tiratore = (VM_TiratoriTesserati)row.getObject();
//System.out.printf("#########################################################[%s]\n",tiratore.getUserId);
%>
	<!-- Definisce la render url -->
	<portlet:renderURL var="editURL">
			<portlet:param name="esfUserId"
				value="<%= String.valueOf(tiratore.getUserId())%>" />
			<portlet:param name="mvcPath"
				value='<%=templatePath + "shootingDirectorInfo.jsp"%>' />
	</portlet:renderURL>
 	<!-- Definisce l'icona visualizza della tabella -->
	<liferay-ui:icon image="edit" message="Visualizza e assegna" url="<%=editURL.toString()%>" />
 	
 	

