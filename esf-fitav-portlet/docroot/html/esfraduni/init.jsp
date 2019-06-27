<%///////////////////// IMPORT INIT GENERALE //////////////////////%>
<%@ include file="/html/init.jsp"%>
<%///////////////////// IMPORT MODULI ETHICA //////////////////////%>
<%@page import="it.ethica.esf.service.ESFRadunoTipoLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoFilesLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFOrganizationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.VW_AzzurriLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.VW_StaffLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.VW_ShootersLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFRadunoTipo"%>
<%@page import="it.ethica.esf.util.DateUtilFormatter"%>
<%@page import="it.ethica.esf.model.ESFRaduno"%>
<%@page import="it.ethica.esf.model.ESFRadunoTipo"%>
<%@page import="it.ethica.esf.model.ESFRadunoSottotipo"%>
<%@page import="it.ethica.esf.model.ESFRadunoFiles"%>
<%@page import="it.ethica.esf.model.ESFRadunoAzzurri"%>
<%@page import="it.ethica.esf.model.ESFOrganization"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.model.VW_Azzurri"%>
<%@page import="it.ethica.esf.model.VW_Staff"%>
<%@page import="it.ethica.esf.model.VW_Shooters"%>
<%@page import="it.ethica.esf.model.ESFNational"%>
<%@page import="it.ethica.esf.model.ESFShootingDirectorQualification"%>
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
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>






