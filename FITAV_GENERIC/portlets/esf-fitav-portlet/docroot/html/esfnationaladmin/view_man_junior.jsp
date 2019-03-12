<%
scid = 1;
contactQuery = DynamicQueryFactoryUtil.forClass(Contact.class,
		"contactQuery", PortletClassLoaderUtil.getClassLoader());

specCriterion = RestrictionsFactoryUtil.and(commonCriterion,
		RestrictionsFactoryUtil.gt("birthday", juniorMaxBirthday.getTime()));
specCriterion = RestrictionsFactoryUtil.and(specCriterion,
		RestrictionsFactoryUtil.eq("male", true));

contactQuery.add(specCriterion);
%>

