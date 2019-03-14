
<%@include file="../init.jsp"%>

<%
	long esfUserId = ParamUtil.getLong(request, "esfUserId");

	ESFUser esfUser = null;
	String skype=null;
	long userCardId=0;

	if (esfUserId > 0) {
		esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
		User tmpUser = UserLocalServiceUtil.fetchUser(esfUserId);
		Contact userContatc = tmpUser.getContact();
		skype = userContatc.getSkypeSn();
	}
	
	Locale local = renderRequest.getLocale();
	ResourceBundle res = portletConfig.getResourceBundle(locale);

%>