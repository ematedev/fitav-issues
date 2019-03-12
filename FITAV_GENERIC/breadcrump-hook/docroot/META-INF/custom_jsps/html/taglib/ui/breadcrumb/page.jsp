<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/taglib/ui/breadcrumb/init.jsp" %>

<% 
	String newGoHomeBreadcrumb = breadcrumbString;
	if(Validator.isNotNull(breadcrumbString)){
		int indexOfFirstClosingATag = breadcrumbString.indexOf("</a>");
		
		if(indexOfFirstClosingATag != -1){
			String firstHtmlElementContent = 
								breadcrumbString.substring(0, indexOfFirstClosingATag);
			int indexOfOpenATag = firstHtmlElementContent.lastIndexOf(">");
			String aTagInnerContent = 
								breadcrumbString.substring(
										indexOfOpenATag + 1, indexOfFirstClosingATag);
			newGoHomeBreadcrumb = 
					breadcrumbString.replaceFirst(aTagInnerContent, "Torna Alla Home");
		}
				
	}
%>

<c:if test="<%= Validator.isNotNull(breadcrumbString) %>">
	<ul aria-label="<%= LanguageUtil.get(pageContext, "breadcrumb") %>" class="breadcrumb">
		<%= newGoHomeBreadcrumb %>
	</ul>
</c:if>