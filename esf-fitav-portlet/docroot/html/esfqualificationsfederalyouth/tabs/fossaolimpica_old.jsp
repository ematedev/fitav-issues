	<h2 class="sector-label">FOSSA OLIMPICA MASCHILE</h2>
	<%
	if(Validator.isNotNull(fossaOlimpicaEsordientiMaschi) && fossaOlimpicaEsordientiMaschi.size() > 0) {
	%>
		<p class="lead category-label"><liferay-ui:message key="beginners" /></p>
		<table class="data-table-display" >
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			for(ESFUser eu:fossaOlimpicaEsordientiMaschi) {
			%>
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				<td><%=sdf.format(eu.getBirthday()) %></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<hr/>
		<%
	}
	if(Validator.isNotNull(fossaOlimpicaGSMaschi) && fossaOlimpicaGSMaschi.size() > 0) {
	%>
		<p class="lead category-label"><liferay-ui:message key="young-prospects" /></h3>
		<table class="data-table-display">
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			for(ESFUser eu:fossaOlimpicaGSMaschi) {
			%>
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				<td><%=sdf.format(eu.getBirthday()) %></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<hr/>
		<%
	}
	if(Validator.isNotNull(fossaOlimpicaAllieviMaschi) && fossaOlimpicaAllieviMaschi.size() > 0) {
	%>
		<p class="lead category-label"><liferay-ui:message key="youths" /></p>
		<table class="data-table-display">
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			for(ESFUser eu:fossaOlimpicaAllieviMaschi) {
			%>
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				
				<td><%=sdf.format(eu.getBirthday())%></td>
				
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<hr/>
	<%
	}
	
	if(Validator.isNotNull(fossaOlimpicaJunioresMaschi) && fossaOlimpicaJunioresMaschi.size() > 0){
	%>
		<p class="lead category-label"><liferay-ui:message key="juniores" /></p>
		<table class="data-table-display">
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			for(ESFUser eu:fossaOlimpicaJunioresMaschi) {
			%>
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				<td><%=sdf.format(eu.getBirthday()) %></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	<%
	}
	%>


	<h2 class="sector-label">FOSSA OLIMPICA FEMMINILE</h2>
	<%
	if(Validator.isNotNull(fossaOlimpicaEsordientiFemmine) && fossaOlimpicaEsordientiFemmine.size()>0){
	%>
		<p class="lead category-label"><liferay-ui:message key="beginners" /></p>
		<table class="data-table-display">
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			for(ESFUser eu:fossaOlimpicaEsordientiFemmine) {
			%>
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				<td><%=sdf.format(eu.getBirthday()) %></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<hr/>
	<%
	}
	if(Validator.isNotNull(fossaOlimpicaAllieviFemmine)&&fossaOlimpicaAllieviFemmine.size()>0){
	%>
		<p class="lead category-label"><liferay-ui:message key="youths" /></p>
		<table class="data-table-display">
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			for(ESFUser eu:fossaOlimpicaAllieviFemmine) {
			%>
			
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				
				<td><%=sdf.format(eu.getBirthday())%></td>
			
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<hr/>
	<%
	}
	if(Validator.isNotNull(fossaOlimpicaJunioresFemmine) && fossaOlimpicaJunioresFemmine.size()>0){
	%>
		<p class="lead category-label"><liferay-ui:message key="juniores" /></p>
		<table class="data-table-display">
			<thead>
				<tr class="table-row-head">
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
			<% 
			
			for(ESFUser eu:fossaOlimpicaJunioresFemmine) {
			%>
			<tr class="table-row-data">
				<td><%=eu.getLastName() %></td>
				<td><%=eu.getFirstName() %></td>
				<td><%=sdf.format(eu.getBirthday()) %></td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	<%
	}
	%>
