	<h2 class="sector-label">DOUBLE TRAP MASCHILE</h2>
	<%
	if(Validator.isNotNull(doubleTrapEsordientiMaschi) && doubleTrapEsordientiMaschi.size() > 0){
	%>
		<p class="lead category-label"><liferay-ui:message key="beginners" /></p>
		<table class="data-table-display">
			<thead>
				<tr>
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
				<% 
				for(ESFUser eu:doubleTrapEsordientiMaschi) {
				%>
				
				<tr>
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
	if(Validator.isNotNull(doubleTrapAllieviMaschi) && doubleTrapAllieviMaschi.size() > 0){
	%>
		<p class="lead category-label"><liferay-ui:message key="youths" /></p>
		<table class="data-table-display">
			<thead>
				<tr>
					<td><liferay-ui:message key="last-name" /></td>
					<td><liferay-ui:message key="first-name" /></td>
					<td><liferay-ui:message key="date-of-birth" /></td>
				</tr>
			</thead>
			<tbody>
				<%
				
				for(ESFUser eu:doubleTrapAllieviMaschi) {
				%>
				
				<tr>
					<td><%=eu.getLastName() %></td>
					<td><%=eu.getFirstName() %></td>
					<td><%=sdf.format(eu.getBirthday())%></td>
					
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	<%
	}
	if(Validator.isNotNull(doubleTrapJunioresMaschi) && doubleTrapJunioresMaschi.size() > 0){
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
			
			for(ESFUser eu:doubleTrapJunioresMaschi) {
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