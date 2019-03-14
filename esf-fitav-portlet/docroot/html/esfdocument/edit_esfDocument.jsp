<%@ include file="init.jsp"%>

<%
	ESFDocument esfDocument = null;

	long esfDocumentId = ParamUtil.getLong(request, "esfDocumentId");

	if (esfDocumentId > 0) {

		esfDocument = ESFDocumentLocalServiceUtil.getESFDocument(esfDocumentId);
	}

	String releaseDate = "";
	String expirationDate = "";
	String type = "";
	String code = "";
	String releasedby = "";
	String path = "";

	if (Validator.isNotNull(esfDocument)) {
		type = String.valueOf(esfDocument.getType());
		code = String.valueOf(esfDocument.getCode());
		releasedby = String.valueOf(esfDocument.getReleasedBy());
		releaseDate = ManageDate.DateToString(esfDocument.getReleaseDate());
		expirationDate = ManageDate.DateToString(esfDocument.getExpirationDate());
		path = String.valueOf(esfDocument.getPath());
	}else{
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		releaseDate=ManageDate.CalendarToString(calendar);	
		expirationDate=ManageDate.CalendarToString(calendar);	
	}
%>

<aui:script use="aui-base,node,aui-io-request">
	$(function() {
		$("#<portlet:namespace/>ReleaseDate").datepicker();
		$("#<portlet:namespace/>ReleaseDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>ReleaseDate").datepicker("setDate",
				'<%= releaseDate %>');
	});

	$(function() {
		$("#<portlet:namespace/>ExpirationDate").datepicker();
		$("#<portlet:namespace/>ExpirationDate").datepicker("option",
				"dateFormat", "dd/mm/yy");
		$("#<portlet:namespace/>ExpirationDate").datepicker("setDate",
				'<%= expirationDate %>');
	});
</aui:script>

<portlet:actionURL name="editESFdocument" var="editESFDocumentURL">
	<portlet:param name="esfDocumentId"
		value="<%=String.valueOf(esfDocumentId)%>" />
</portlet:actionURL>

<aui:form action="<%=editESFDocumentURL%>" enctype="multipart/form-data" name="fm">
	<aui:model-context bean="<%=esfDocument%>"
		model="<%=ESFDocument.class%>" />

	<aui:fieldset>
		<aui:input type="hidden" name="esfDocumentId"
			value='<%=esfDocumentId%>' />

		<%  if(esfDocumentId==0){ %>
				<aui:select id="type" name="type" showEmptyOption="false"
					required="true" label="type">
				<%
					List<ListType> document =
						ListTypeServiceUtil.getListTypes(ESFDocument.class.getName() +ESFListType.DOCUMENT);
					for (ListType documents : document) {
				%>
						<aui:option label="<%=documents.getName()%>" value="<%=documents.getName()%>" />
				<%
					}
				%>
				</aui:select>
			<%
			}else{
				List<ListType> documents =
					ListTypeServiceUtil.getListTypes(ESFDocument.class.getName() +ESFListType.DOCUMENT);
				for (ListType document : documents) {
					if(document.getName().equalsIgnoreCase(type)){
			%>	
						<aui:input type="text" name="typet" label="type" value='<%= document.getName()%>' disabled="true" />
						<aui:input type="hidden" name="type"	value='<%=document.getName()%>' />
			<%
					}
				}
			}
			%>
	

		<aui:input name="code" type="text" label="Code" value='<%=code%>'>
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="releasedby" type="text" label="ReleasedBy"
			value='<%=releasedby%>'>
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="releasedate" type="text" id="ReleaseDate"
			label="ReleaseDate" value='<%=releaseDate%>'>
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="expirationDate" type="text" id="ExpirationDate"
			label="ExpirationDate" value='<%=expirationDate%>'>
			<aui:validator name="required" />
		</aui:input>
		<%if(Validator.isNotNull(path)) {%>
			<a href="<%= path  %>" target="_blank">Download</a>
		<% } %>
		<aui:input name="path" type="file" label="File" >
		</aui:input>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
	</aui:button-row>

</aui:form>