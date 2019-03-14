<%@include file="../init.jsp"%>

<%@
page import="it.ethica.esf.model.ESFCard"%><%@
page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%><%@
page import="it.ethica.esf.util.ESFKeys.ESFAddressListType"%><%@
page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%><%@
page import="com.liferay.portal.model.Contact"%><%@
page import="com.liferay.portal.model.User"%><%@
page import="com.liferay.portal.service.UserLocalServiceUtil"%><%@
page import="com.liferay.portal.kernel.util.StringUtil"%><%@
page import="com.liferay.portal.service.ListTypeServiceUtil"%><%@
page import="com.liferay.portal.model.ListType"%><%@
page import="it.ethica.esf.util.ESFListType"%><%@
page import="it.ethica.esf.model.ESFCountry"%><%@
page import="it.ethica.esf.service.ESFCountryLocalServiceUtil"%><%@
page import="it.ethica.esf.util.ESFKeys.ESFPhoneListType"%>
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


%>