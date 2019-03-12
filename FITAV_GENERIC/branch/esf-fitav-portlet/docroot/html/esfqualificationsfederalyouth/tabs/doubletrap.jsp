<p><h2><u>DOUBLE TRAP MASCHILE</u></h2></p>
<table>
	<%if(Validator.isNotNull(doubleTrapEsordientiMaschi) &&doubleTrapEsordientiMaschi.size()>0){ %>
	<tr><td><h3>Esordienti</h3></td></tr>
		<tr>
	<td>Cognome</td>
	<td>Nome</td>
	<td>Data Nascita:</td>
	</tr>
	<% 

	for(ESFUser eu:doubleTrapEsordientiMaschi) {
	%>
	
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(doubleTrapAllieviMaschi)&&doubleTrapAllieviMaschi.size()>0){ %>
	<tr><td><h3>Allievi</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
		
	<tr>
		<%
	
	for(ESFUser eu:doubleTrapAllieviMaschi) {
	%>
	
	<tr>
		<td><%=eu.getFirstName() %></td>
		<td><%=eu.getLastName() %></td>
		<td><%=sdf.format(eu.getBirthday())%></td>
		
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(doubleTrapJunioresMaschi)&&doubleTrapJunioresMaschi.size()>0){ %>
	<tr><td><h3>Juniores</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
		
	<tr>
	<% 
	
	for(ESFUser eu:doubleTrapJunioresMaschi) {
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