<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="init.jsp" %>

<% 
long esfUserId= user.getUserId();
Calendar calendar = CalendarFactoryUtil.getCalendar();
boolean verify= ManageDate.checkPeriod(calendar);
String path = StringPool.BLANK;


if (permissionChecker.isOmniadmin()){
	path = "renewal_form.jsp";
}
else {
	path = "insert_pin.jsp" ;
}



%>


<c:choose>
<c:when test="<%= verify %>">
<aui:button-row cssClass="esfrenewal-admin-buttons">

				<portlet:renderURL var="renewalURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath + path%>' />
					<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>'/>
				</portlet:renderURL>
			<aui:button onClick="<%= renewalURL %>"
					value="renew" />
</aui:button-row>
</c:when>
<c:otherwise>
			<h3> <liferay-ui:message key="no-renew" /> </h3>
</c:otherwise>

</c:choose>