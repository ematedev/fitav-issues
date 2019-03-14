<%
scid = 2;
contactQuery = DynamicQueryFactoryUtil.forClass(Contact.class,
		"contactQuery", PortletClassLoaderUtil.getClassLoader());

specCriterion = RestrictionsFactoryUtil.and(commonCriterion,
		RestrictionsFactoryUtil.lt("birthday", juniorMaxBirthday.getTime()));
specCriterion = RestrictionsFactoryUtil.and(specCriterion,
		RestrictionsFactoryUtil.eq("male", false));

contactQuery.add(specCriterion);
%>

