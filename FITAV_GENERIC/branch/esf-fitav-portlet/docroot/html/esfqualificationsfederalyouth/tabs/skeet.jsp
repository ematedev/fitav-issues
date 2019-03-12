<%@page import="it.ethica.esf.model.ESFUser"%>
<p><h2><u>SKEET MASCHILE</u></h2></p>
<table>
	<%	if(Validator.isNotNull(skeetEsordientiMaschi)&&skeetEsordientiMaschi.size()>0){ %>
	<tr><td><h3>Esordienti</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 

	for(ESFUser eu:skeetEsordientiMaschi) {
	%>
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(skeetAllieviMaschi)&&skeetAllieviMaschi.size()>0){ %>
	<tr><td><h3>Allievi</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
		<% 
	for(ESFUser eu:skeetAllieviMaschi) {
	%>
	
	<tr>
			
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
		
	</tr>
	<%
	}}
	%>
	<% if(Validator.isNotNull(skeetJunioresMaschi)&&skeetJunioresMaschi.size()>0){%>
	<tr><td><h3>Juniores</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 
	
	for(ESFUser eu:skeetJunioresMaschi) {
	%>
	<tr>
		
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
		
	</tr>
	<%
	}}
	%>
</table>
<p><h2><u>SKEET FEMMINILE</u></h2></p>
<table>
	
	<%if(Validator.isNotNull(skeetEsordientiFemmine)&&skeetEsordientiFemmine.size()>0){ %>
	<tr><td><h3>Esordienti</h3></td></tr>
	<tr>
		
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
		
	<tr>
	<% 
	
	for(ESFUser eu:skeetEsordientiFemmine) {
	%>
	<tr>
		
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
		
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(skeetAllieviFemmine)&&skeetAllieviFemmine.size()>0){ %>
	<tr><td><h3>Allievi</h3></td></tr>
	<tr>
		
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
		
	<tr>
		<% 
	
	for(ESFUser eu:skeetAllieviFemmine) {
	%>
	
	<tr>
			
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
	
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(skeetJunioresFemmine)&&skeetJunioresFemmine.size()>0){ %>
	<tr><td><h3>Juniores</h3></td></tr>
	<tr>
		
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
		
	<tr>
	<% 
	
	for(ESFUser eu:skeetJunioresFemmine) {
	%>
	<tr>
			
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
		
	</tr>
	<%
	}}
	%>
</table>