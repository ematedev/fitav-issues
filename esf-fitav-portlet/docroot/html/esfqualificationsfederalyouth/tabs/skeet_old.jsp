	<h2 class="sector-label"><liferay-ui:message key="skeet-male" /></h2>
	<%
	if(Validator.isNotNull(skeetEsordientiMaschi) && skeetEsordientiMaschi.size() > 0){
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
				for(ESFUser eu:skeetEsordientiMaschi) {
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
	if(Validator.isNotNull(skeetAllieviMaschi) && skeetAllieviMaschi.size() > 0){
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
				
				for(ESFUser eu:skeetAllieviMaschi) {
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
	<%
	}
	if(Validator.isNotNull(skeetJunioresMaschi) && skeetJunioresMaschi.size() > 0){
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
			
			for(ESFUser eu:skeetJunioresMaschi) {
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


	<h2 class="sector-label"><liferay-ui:message key="skeet-female" /></h2>
	<%
	if(Validator.isNotNull(skeetEsordientiFemmine) && skeetEsordientiFemmine.size() > 0){
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
				for(ESFUser eu:skeetEsordientiFemmine) {
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
	if(Validator.isNotNull(skeetAllieviFemmine) && skeetAllieviFemmine.size() > 0){
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
				
				for(ESFUser eu:skeetAllieviFemmine) {
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
	<%
	}
	if(Validator.isNotNull(skeetJunioresFemmine) && skeetJunioresFemmine.size() > 0){
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
			
			for(ESFUser eu:skeetJunioresFemmine) {
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