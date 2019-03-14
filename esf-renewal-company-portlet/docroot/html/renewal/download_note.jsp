<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.service.ResourcePermissionServiceUtil"%>
<%@page import="com.liferay.portal.model.ResourceConstants"%>
<%@page import="com.liferay.portal.service.ResourcePermissionLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="it.ethica.esf.util.ConvertNumberToWords"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.liferay.portal.kernel.util.MimeTypesUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.io.File"%>
<%@page import="com.itextpdf.text.BaseColor"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.pdf.BaseFont"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.pdf.PdfStamper"%>
<%@page import="com.itextpdf.text.pdf.PdfReader"%>
<%@page import="it.ethica.esf.util.ESFRenewalConstants"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileShortcut"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileShortcutLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>


<%
String renewalDate = ParamUtil.getString(request, "renewalDate");
renewalDate = renewalDate.replace(StringPool.FORWARD_SLASH, StringPool.BLANK);
String amount = ParamUtil.getString(request, "amount");
String url = StringPool.BLANK;
long entryId = 0;
List<DLFileEntry> ls = 
	DLFileEntryLocalServiceUtil.getDLFileEntries(-1,-1);



DLFolder folder = DLFolderLocalServiceUtil.getFolder(siteGroupId,parentFolderId , ESFRenewalConstants.FOLDER_FITAV);
	

for(DLFileEntry ts:ls)
{
	if(ts.getTitle().equals(ESFRenewalConstants.DOCUMENT)){
		entryId = ts.getFileEntryId();
	}

}




DLFileEntry  fileShortcut = DLFileEntryLocalServiceUtil.fetchDLFileEntry(entryId);  //fetchFileEntry(group.getGroupId(), 0, "ricevuta");

if (Validator.isNotNull(fileShortcut)){

String fileP = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + globalId  + "/" + 
		fileShortcut.getFolderId() + "/" +fileShortcut.getTitle() ;

System.out.println (fileP);
	String title = ESFRenewalConstants.TITLE_FILE;
    File output = new File (title + ESFRenewalConstants.PDF_EXTENSION);
   
	PdfReader reader = new PdfReader(fileP);

    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
    		output));
    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252,
            BaseFont.NOT_EMBEDDED);
    	
    String letters = ConvertNumberToWords.convert(Integer.parseInt(amount));
    
        PdfContentByte over = stamper.getOverContent(1);
        over.beginText();
        over.setFontAndSize(bf, 15);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(710, 545);
        over.showText(amount);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 15);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(710, 255);
        over.showText(amount);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 15);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(240, 545);
        over.showText(amount);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 15);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(240, 255);
        over.showText(amount);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 13);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(480, 529);
        over.showText(letters);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 13);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(480, 239);
        over.showText(letters);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 13);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(100, 530);
        over.showText(letters);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 13);
        over.setColorFill(BaseColor.BLACK);
        over.setTextMatrix(100, 239);
        over.showText(letters);
        over.endText();
        
    stamper.close();
   
	
    String mimeType = MimeTypesUtil.getContentType(output);
	String description = ESFRenewalConstants.FILE_DESCRIPTION;
	String changeLog = "hi";
	long fileEntryTypeId = folder.getDefaultFileEntryTypeId();
	InputStream is = new FileInputStream( output );
	DLFileEntry dlFileEntry = null;
	try{
		dlFileEntry = 
				DLFileEntryLocalServiceUtil.fetchFileEntry(
						siteGroupId, folder.getFolderId(), title + 
						StringPool.UNDERLINE + renewalDate);
	}
	catch (Exception e){
	}
		if (Validator.isNull(dlFileEntry))	{	
		dlFileEntry = 
				DLFileEntryLocalServiceUtil.addFileEntry(
						user.getUserId(), siteGroupId, 
						siteGroupId, folder.getFolderId(),
		 output.getName(), mimeType, 
		 title + StringPool.UNDERLINE + renewalDate, description, 
		 changeLog, fileEntryTypeId, null, output, is, 
		output.length(), serviceContext);
	}
    //Change mode of Draft to Approved
	DLFileEntryLocalServiceUtil.updateFileEntry(user.getUserId(),
			dlFileEntry.getFileEntryId(), output.getName(),
	mimeType, title + StringPool.UNDERLINE + renewalDate, 
	description, ESFRenewalConstants.FILE_DRAFT, true, 
	dlFileEntry.getFileEntryTypeId(), null, output, null, output.length(), serviceContext);

    /*
	Role userRole = 
			RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), 
					ESFRenewalConstants.ROLE_RENEWAL);
  
	String[] actionsFile = new String[] { ActionKeys.VIEW };
	 ResourcePermissionLocalServiceUtil.setResourcePermissions(
			themeDisplay.getCompanyId(),  
			"com.liferay.portlet.documentlibrary.model.DLFileEntry",
			ResourceConstants.SCOPE_GROUP, String.valueOf(dlFileEntry.getFileEntryId()), 
			userRole.getRoleId(), actionsFile);
	 
	 String[] actionsFolder = new String[] { ActionKeys.ACCESS };
	 ResourcePermissionLocalServiceUtil.setResourcePermissions(
				themeDisplay.getCompanyId(),  
				"com.liferay.portlet.documentlibrary.model.DLFolder",
				ResourceConstants.SCOPE_GROUP, String.valueOf(dlFileEntry.getFolderId()), 
				userRole.getRoleId(), actionsFolder);
	
	ResourcePermissionLocalServiceUtil.addResourcePermission(
			themeDisplay.getCompanyId(), "com.liferay.portlet.documentlibrary.model.DLFileEntry",
			ResourceConstants.SCOPE_COMPANY, String.valueOf(dlFileEntry.getFileEntryId()), 
			userRole.getRoleId(), ActionKeys.VIEW);
	*/		
    
    System.out.println("file entry"+dlFileEntry.getFileEntryId());
	DLFileEntry fileCompilato =  
			DLFileEntryLocalServiceUtil.getFileEntry(dlFileEntry.getFileEntryId());   //(siteGroupId, folder.getFolderId(), title+"_"+renewalDate);
	url = themeDisplay.getPortalURL() + 
			themeDisplay.getPathContext() + "/documents/" + siteGroupId + "/" + 
			fileCompilato.getFolderId() + "/" +fileCompilato.getTitle() ;
   

%>


<div>
<h4> DOWNLOAD BOLLETTINO VUOTO</h4>


<liferay-ui:icon
				cssClass="lfr-asset-avatar"
				image="download"
				message='Download Ricevuta vuota'
				target="_blank"
				url='<%= fileP
				%>'
/>

</div>

<div>
<h4> DOWNLOAD BOLLETTINO COMPILATO</h4>


<liferay-ui:icon
				cssClass="lfr-asset-avatar"
				image="download"
				message='Download Ricevuta Compilata'
				target="_blank"
				url='<%=  url
				%>'
/>

</div>
<%
}
else {

%>
<div>
<h4>IMPOSSIBILE EFFETTUARE IL DOWNLOAD</h4>
</div>
<%} %>
</br> </br>


<portlet:renderURL var="paymentURL">
			<portlet:param name="mvcPath" value='<%= templatePath + "payment_page.jsp" %>' />
			<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
			<portlet:param name="amount" value='<%=amount %>'/>
</portlet:renderURL>
<aui:button value="back" onClick="<%=paymentURL %>"></aui:button>