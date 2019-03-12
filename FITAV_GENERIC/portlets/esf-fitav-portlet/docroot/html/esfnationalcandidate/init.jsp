<%@ include file="/html/init.jsp"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ContactServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.ethica.esf.model.ESFCard"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
<%@page import="it.ethica.esf.service.ESFCardLocalServiceUtil"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.util.ESFKeys"%>
<%@page import="it.ethica.esf.model.ESFSportType"%>
<%@page import="it.ethica.esf.service.ESFSportTypeLocalServiceUtil"%>


<%
	int juniorMaxAge = 20;

	Calendar juniorMaxBirthday = CalendarFactoryUtil.getCalendar();

	juniorMaxBirthday.set((Calendar.YEAR-juniorMaxAge),Calendar.MONTH,Calendar.DATE);

	List<ESFCard> esfCards =
		ESFCardLocalServiceUtil.findAllESFCardsByState(ESFKeys.ESFStateType.ENABLE);

	List<Long> shooterIds = new ArrayList<Long>();

	for (ESFCard esfCard : esfCards) {

		shooterIds.add(esfCard.getEsfUserId());
	}

	List<Contact> candidatesList = new ArrayList<Contact>();

	String search = ParamUtil.getString(request, "search");

	DynamicQuery contactQuery = null;

	Criterion commonCriterion1 =
		RestrictionsFactoryUtil.in("classPK", shooterIds);
	Criterion commonCriterion2 =
		RestrictionsFactoryUtil.eq("classNameId",
			ClassNameLocalServiceUtil.getClassNameId(User.class));
		
	
	Criterion commonCriterion =
		RestrictionsFactoryUtil.and(commonCriterion1,commonCriterion2);

	if (Validator.isNotNull(search)) {

		commonCriterion =
			RestrictionsFactoryUtil.and(
				commonCriterion, RestrictionsFactoryUtil.or(
					RestrictionsFactoryUtil.like("firstName", search),
					RestrictionsFactoryUtil.like("lastName", search)));
	}

	Criterion specCriterion = null;
	PortletURL iteratorURL = null;
	int shooterCount = 0;
	int scid = 0;
	
	contactQuery = DynamicQueryFactoryUtil.forClass(Contact.class,
		"contactQuery", PortletClassLoaderUtil.getClassLoader());
	
%>

