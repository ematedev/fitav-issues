<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.ethica.esf.service.ESFNationalLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFNational"%>
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>




<% 
	ESFUser u=null;
	boolean admin=true;
	boolean isNational=false;
	ESFNational esfUserNational = null;
	if (!(permissionChecker.isOmniadmin())){
		admin = false;
		u = ESFUserLocalServiceUtil.getESFUser(esfUserId);
	}
	try{
		esfUserNational = ESFNationalLocalServiceUtil.getActiveESFNational(esfUserId);
		if (Validator.isNotNull(esfUserNational)){
			isNational = true ;
		}
	} catch (SystemException ex){
		System.out.println("No user national");
	}
	 
	
%>

<portlet:renderURL var="cvURL">
					<portlet:param name="mvcPath"
						value='<%=  templatePath+"curriculum.jsp"%>' />
					<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>'/>
</portlet:renderURL>

<portlet:renderURL var="cvAzzurriURL">
					<portlet:param name="mvcPath"
						value='<%=  templatePath+"curriculumAzzurri.jsp"%>' />
					<portlet:param name="esfUserId" value='<%= String.valueOf(esfUserId) %>'/>
</portlet:renderURL>


<c:if test='<%= (!admin) %>'>

	<div align="center">
	<aui:row>
		<h3> <%=u.getFirstName()  %>  <%=u.getLastName()  %> </h3>
	</aui:row>
	
	<aui:button-row>
		<aui:button cssClass="btn btn-primary"
		value ="CV" onClick='<%=cvURL %>' /> 
		
		<c:if test='<%= (isNational) %>'>
				<aui:button cssClass="btn btn-primary"
			value ="CV AZZURRI" onClick='<%=cvAzzurriURL %>'/> 
		</c:if>
	</aui:button-row>
	</div>

</c:if>