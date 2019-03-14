<%
scid = 3;
contactQuery = DynamicQueryFactoryUtil.forClass(Contact.class,
		"contactQuery", PortletClassLoaderUtil.getClassLoader());

specCriterion = RestrictionsFactoryUtil.and(commonCriterion,
		RestrictionsFactoryUtil.gt("birthday", juniorMaxBirthday.getTime()));
specCriterion = RestrictionsFactoryUtil.and(specCriterion,
		RestrictionsFactoryUtil.eq("male", false));

contactQuery.add(specCriterion);
%>

<%@ include file="search_container.jsp" %>

