<%@include file="init.jsp"%>
<%
	List<ESFState> esfStates = ESFStateLocalServiceUtil.findESFStates(ESFUser.class.getName());

	ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil
			.findESFEntityStateByC_PK(ESFUser.class.getName(), esfUserId);
%>

		<aui:fieldset>

			<aui:select name="esfStateId">
				<%
					for (ESFState esfState : esfStates) {
						if (esfEntityState != null
								&& esfEntityState.getEsfStateId() == esfState.getEsfStateId()) {
				%>
							<aui:option value="<%=esfState.getEsfStateId()%>" selected="<%= true %>"
								label="<%=esfState.getName()%>"></aui:option>
				<%
						} else {
				%>
							<aui:option value="<%=esfState.getEsfStateId()%>"
								label="<%=esfState.getName()%>"></aui:option>
				<%
						}
					}
				%>
			</aui:select>

		</aui:fieldset>

	