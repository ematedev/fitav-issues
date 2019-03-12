<%@include file="init.jsp"%>

<aui:fieldset>

	<aui:input name="skype" />

	<c:if test="<%=Validator.isNotNull(skype)%>">
		<a href="callto://<%=HtmlUtil.escapeAttribute(skype)%>">
			<img alt="<liferay-ui:message key="call-this-user" />"
			src="http://mystatus.skype.com/smallicon/<%=HtmlUtil.escapeAttribute(skype)%>" />
		</a>
	</c:if>

	<div class="social-network">
		<aui:input name="facebook" />

		<img alt="<liferay-ui:message key="facebook" />"
			src="<%=themeDisplay.getPathThemeImages()%>/users_admin/facebook.png" />
	</div>

	<div class="social-network">
		<aui:input name="twitter" />

		<img alt="<liferay-ui:message key="twitter" />" 
			class="social-network-logo"
			src="<%=themeDisplay.getPathThemeImages()%>/users_admin/twitter.png" />
	</div>
</aui:fieldset>