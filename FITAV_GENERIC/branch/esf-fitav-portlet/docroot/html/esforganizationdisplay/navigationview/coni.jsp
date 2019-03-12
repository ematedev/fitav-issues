<%@include file="init.jsp"%>

<h3><liferay-ui:message key="coni" /></h3>

<c:choose>

	<c:when test="<%=currentESFOrganization != null && currentESFOrganization.getConiDate() != null%>">
	<div class="detail">
		<h4><liferay-ui:message key="coni-date"/>:</h4>
		<p>
			<%= ManageDate.DateToString(currentESFOrganization.getConiDate()) %>
		</p>
		<h4><liferay-ui:message key="coni-code"/>:</h4>
		<p>
			<%= currentESFOrganization.getConiCode()%>
		</p>
	</div>
		
	</c:when>
	
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="no-content-coni" />
		</div>
	</c:otherwise>

</c:choose>
