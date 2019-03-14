
<%@page import="com.ethica.esf.util.ESFRenewalConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.DuplicateFolderNameException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@ include file="init.jsp" %>

<%
String renewalDate= ParamUtil.getString(request, "renewalDate");
String returnPath = backUrl;
String amount = ParamUtil.getString(request, "amount");


boolean mountPoint = false;   // mountPoint which is a boolean specifying whether the folder is a facade for mounting a third-party repository
boolean hidden = false; // true if you want to hidden the folder 
String folderName = ESFRenewalConstants.FOLDER_FITAV;
String description = ESFRenewalConstants.FOLDER_FITAV_DESCRIPTION;
try {
	DLFolderLocalServiceUtil.addFolder(
			themeDisplay.getDefaultUserId(),siteGroupId , siteGroupId, 
			mountPoint, parentFolderId, folderName, 
			description, hidden, serviceContext);
} catch (DuplicateFolderNameException ex){
	System.out.println("Cartella esistente");
}

%>

<h4> PAGAMENTO </h4>

<portlet:renderURL  var="downloadURL">
	<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
	<portlet:param name="mvcPath" value="/html/renewal/download_note.jsp"/>
	<portlet:param name="amount" value='<%=amount %>'/>
</portlet:renderURL>

 <portlet:renderURL  var="viewURL">
	<portlet:param name="renewalDate" value='<%=renewalDate %>'/>
	<portlet:param name="mvcPath" value="/html/renewal/bank_details.jsp"/>
	<portlet:param name="amount" value='<%=amount %>'/>
</portlet:renderURL>

<div class="container-fluid">
<div class="row-fluid">
	<div class="span2 span-pay">
    <label> - PAYPAL </label> 
    </div>
    <div class="span2 span-form"> 
 	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
              <fieldset>
                  <input type="hidden" name="cmd" value="_xclick" />
                  <input type="hidden" name="business" value="prova@fitav.it" />
                  <input type="hidden" name="lc" value="E" />
                  <input type="hidden" name="item_name" value="Renewal" />
                  <input type="hidden" name="item_number" value="1" />
                  <input type="hidden" name="currency_code" value="EUR" />
                  <input type="hidden" name="button_subtype" value="services" />
                  <input type="hidden" name="no_note" value="0" />
                  <input type="hidden" name="cn" value="Comments" />
                  <input type="hidden" name="no_shipping" value="1" />
                  <input type="hidden" name="rm" value="2" />
                  <input type="hidden" name="return" value='<%=returnPath%>' />
                  <input type="hidden" name="cancel_return" value='<%=returnPath%>' />
                  <input type="hidden" name="bn" value="PP-BuyNowBF:btn_paynowCC_LG.gif:NonHostedGuest" />
                  <input type="hidden" name="amount" value='<%=amount %>' maxlength="200" />
                <input style="position:relative; left:-10px; background:#ffffff; border:0;" type="image" src="https://www.sandbox.paypal.com/it_IT/IT/i/btn/btn_buynowCC_LG.gif" name="submit" alt="PayPal è il metodo rapido e sicuro per pagare e farsi pagare online." />
                 <img alt="" style="border:0;" src="https://www.sandbox.paypal.com/it_IT/i/scr/pixel.gif" width="1" height="1" />
              </fieldset>
     </form>
  	 </div>
</div>
<div class="row-fluid">
      <div class="span2 span-pay">
 	<label > - BOLLETTINO POSTALE</label>
      </div>
      <div class="span2 span-pay1">
	 <aui:button
	  value="DOWNLOAD" onClick='<%=downloadURL %>'/>
	  </div>
</div>
	
<div class="row-fluid">
        <div class="span2 span-pay">
	 	<label > - COORDINATE BANCARIE</label>
         </div>
         <div class="span2 span-pay1">
		 <aui:button
		  value="VISUALIZZA" onClick='<%=viewURL %>'/>
		  </div>
</div>
</div>

<aui:button-row>
 <aui:button value="cancel" onClick="<%=backUrl %>"/>
</aui:button-row>