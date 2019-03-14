<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESFOrder esfOrder = (ESFOrder)row.getObject();

%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
		<portlet:param name="modifyMode" value="true" />
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_order.jsp" %>' />
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" message="edit" url="<%= editURL.toString() %>" />
	
	<portlet:renderURL var="viewArticlesURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view_articles.jsp" %>' />
	</portlet:renderURL>
	
	<liferay-ui:icon image="view" message="view-articles" url="<%= viewArticlesURL.toString() %>" />

	<%
	if (Validator.isNotNull(esfOrder.getAttachment())) {
		String folderName = GetterUtil.getString(portletPreferences.getValue("folderName", StringPool.BLANK));

		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long dlFolderId = parentFolderId;
		try {
			dlFolderId =
				DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), parentFolderId, folderName).getFolderId();
		}
		catch (Exception e) {
		}
		try {
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(scopeGroupId, dlFolderId, esfOrder.getAttachment());
			String attachmentURL = "/c/document_library/get_file?uuid=" + dlFileEntry.getUuid() + "&groupId=" + dlFileEntry.getGroupId();
			%>
			<liferay-ui:icon label="download" image="download" url="<%= attachmentURL %>" target="_blank" />
			<%
		}
		catch (Exception ex) {
		}
	}
	%>

	<portlet:actionURL name="deleteESFOrder" var="deleteURL">
		<portlet:param name="esfOrderId" value="<%= String.valueOf(esfOrder.getEsfOrderId()) %>" />
		<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>'/>
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	
	
</liferay-ui:icon-menu>