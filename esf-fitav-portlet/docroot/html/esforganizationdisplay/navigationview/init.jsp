<%@include file="../init.jsp"%>

<%@page import="it.ethica.esf.service.ESFStateLocalServiceUtil"%>
<%@page import="com.liferay.portal.AddressCityException"%>
<%@page import="com.liferay.portal.AddressStreetException"%>
<%@page import="com.liferay.portal.AddressZipException"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.EmailAddress"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="com.liferay.portal.model.ListTypeConstants"%>
<%@page import="com.liferay.portal.NoSuchListTypeException"%>
<%@page import="com.liferay.portal.NoSuchRegionException"%>
<%@page import="com.liferay.portal.service.EmailAddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.ethica.esf.model.ESFAddress"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.model.impl.ESFAddressImpl"%>
<%@page import="it.ethica.esf.permission.ESFFieldPermission"%>
<%@page import="it.ethica.esf.service.ESFAddressLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFFieldLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFListType"%>
<%@page import="it.ethica.esf.model.ESFEntityState"%>
<%@page import="it.ethica.esf.service.ESFEntityStateLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.util.ManageDate"%>
<%@page import="it.ethica.esf.util.ESFKeys.ESFAddressListType"%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

String classNameAddr = (String)request.getAttribute("addresses.className");
long classPKAddr = (Long)request.getAttribute("addresses.classPK");

List<ESFAddress> esfAddresses = Collections.emptyList();

esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(
	themeDisplay.getCompanyId(), classNameAddr, classPKAddr);

ESFAddress esfAddressesToPrint [] = new ESFAddress[esfAddresses.size()];

int x = 0;

for(ESFAddress esfAddress : esfAddresses) {
	
	esfAddressesToPrint[x] = esfAddress;
	x++;
}

%>