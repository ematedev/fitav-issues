<%///////////////////// IMPORT INIT GENERALE //////////////////////%>
<%@ include file="/html/init.jsp"%>
<%///////////////////// IMPORT MODULI ETHICA //////////////////////%>
<%@page import="it.ethica.esf.service.ESFRadunoTipoLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoFilesLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoFilesLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoFilesLocalService"%>
<%@page import="it.ethica.esf.model.ESFRadunoTipo"%>
<%@page import="it.ethica.esf.util.DateUtilFormatter"%>
<%@page import="it.ethica.esf.model.ESFRaduno"%>
<%@page import="it.ethica.esf.model.ESFRadunoTipo"%>
<%@page import="it.ethica.esf.model.ESFRadunoSottotipo"%>
<%@page import="it.ethica.esf.model.ESFRadunoFiles"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.util.ManageDate"%>



<%///////////////////// IMPORT MODULI JAVA //////////////////////%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>

<%///////////////////// IMPORT MODULI LIFERAY //////////////////////%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>

