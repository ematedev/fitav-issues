
<p><h2><u>FOSSA OLIMPICA MASCHILE</u></h2></p>
<table>
	<%if(Validator.isNotNull(fossaOlimpicaEsordientiMaschi)&&fossaOlimpicaEsordientiMaschi.size()>0){ %>
	<tr><td><h3>Esordienti</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 
	
	for(ESFUser eu:fossaOlimpicaEsordientiMaschi) {
	%>
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(fossaOlimpicaGSMaschi)&&fossaOlimpicaGSMaschi.size()>0){ %>
	<tr><td><h3>Giovani Speranze</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 
	
	for(ESFUser eu:fossaOlimpicaGSMaschi) {
	%>
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(fossaOlimpicaAllieviMaschi)&&fossaOlimpicaAllieviMaschi.size()>0){ %>
	<tr><td><h3>Allievi</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
		<% 
	
	for(ESFUser eu:fossaOlimpicaAllieviMaschi) {
	%>
	
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		
		<td><%=sdf.format(eu.getBirthday())%></td>
		
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(fossaOlimpicaJunioresMaschi)&&fossaOlimpicaJunioresMaschi.size()>0){ %>
	<tr><td><h3>Juniores</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 
	
	for(ESFUser eu:fossaOlimpicaJunioresMaschi) {
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
<p><h2><u>FOSSA OLIMPICA FEMMINILE</u></h2></p>
<table>
	<%if(Validator.isNotNull(fossaOlimpicaEsordientiFemmine)&&fossaOlimpicaEsordientiFemmine.size()>0){ %>
	
	<tr><td><h3>Esordienti</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 
	
	for(ESFUser eu:fossaOlimpicaEsordientiFemmine) {
	%>
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		<td><%=sdf.format(eu.getBirthday()) %></td>
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(fossaOlimpicaAllieviFemmine)&&fossaOlimpicaAllieviFemmine.size()>0){ %>
	<tr><td><h3>Allievi</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
		<% 
	
	for(ESFUser eu:fossaOlimpicaAllieviFemmine) {
	%>
	
	<tr>
		<td><%=eu.getLastName() %></td>
		<td><%=eu.getFirstName() %></td>
		
		<td><%=sdf.format(eu.getBirthday())%></td>
	
	</tr>
	<%
	}}
	%>
	<%if(Validator.isNotNull(fossaOlimpicaJunioresFemmine)&&fossaOlimpicaJunioresFemmine.size()>0){ %>
	<tr><td><h3>Juniores</h3></td></tr>
	<tr>
		<td>Cognome</td>
		<td>Nome</td>
		<td>Data Nascita:</td>
	<tr>
	<% 
	
	for(ESFUser eu:fossaOlimpicaJunioresFemmine) {
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