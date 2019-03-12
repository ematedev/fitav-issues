<%@include file="/init.jsp"%>

<%@page import="com.liferay.portal.AddressCityException"%>
<%@page import="com.liferay.portal.AddressStreetException"%>
<%@page import="com.liferay.portal.AddressZipException"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.ListTypeConstants"%>
<%@page import="com.liferay.portal.NoSuchListTypeException"%>
<%@page import="com.liferay.portal.NoSuchRegionException"%>

<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.model.impl.ESFAddressImpl"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>

<%
long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");

ESFOrganization esfOrganization = null;

if (esfOrganizationId > 0) {
esfOrganization =
	ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
}
%>