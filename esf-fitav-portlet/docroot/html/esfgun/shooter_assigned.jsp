<%@page import="it.ethica.esf.model.impl.ESFgunUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp"%>
<%
long esfGunId = ParamUtil.getLong(request, "esfGunId");

int typeR =  ESFKeys.ESFGunType.RIFLE;
int typeC =  ESFKeys.ESFGunType.CANE;

String gunName = "";

ESFGunKind kind = new ESFGunKindImpl();
ESFGunType gType = new ESFGunTypeImpl();

kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunId);

if(Validator.isNotNull(kind) &&  Validator.isNotNull(kind.getEsfGunTypeId()) && 
		Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()))){
	gType = ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId());
}
if(Validator.isNotNull(gType) && Validator.isNotNull(gType.getName())){
	
	gunName = gType.getName().toUpperCase();
	
}

if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getName())){
	
	gunName +=  " " + kind.getName().toUpperCase();
	
}

/*if(Validator.isNotNull(gun) && Validator.isNotNull(gun.getName())){
	gunName = gun.getName().toUpperCase();
}*/

%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/esfgun/view.jsp" />
	<portlet:param name="flagSearch" value="<%= String.valueOf(false) %>" />
</portlet:renderURL>
				
<aui:button onClick="<%= backURL.toString() %>" value="go-back" />


<h3><liferay-ui:message key="<%=gunName %>"  /></h3>


<h3><liferay-ui:message key="RIFLES"  /></h3>

<liferay-ui:search-container emptyResultsMessage="no-results" delta="10"  curParam= "sc1">	
			<liferay-ui:search-container-results
				results="<%= ESFgunUserLocalServiceUtil.findbyGunId_Type(esfGunId, typeR, searchContainer.getStart(),searchContainer.getEnd())%>"
				total="<%= ESFgunUserLocalServiceUtil.countbyGunId_Type(esfGunId, typeR) %>" />
				<liferay-ui:search-container-row className="it.ethica.esf.model.ESFgunUser" modelVar="esfGunUser">
<%
String freshman = "";
String note = "";
String shooterName = "";

ESFUser shooter = ESFUserLocalServiceUtil.fetchESFUser(esfGunUser.getEsfUserId());


if(Validator.isNotNull(shooter)){
	
	if(Validator.isNotNull(shooter.getFirstName())){
		shooterName = shooter.getFirstName().toUpperCase();
	}
	if(Validator.isNotNull(shooter.getLastName())){
		shooterName = shooterName+" "+shooter.getLastName().toUpperCase();
	}
	
}

if(Validator.isNotNull(esfGunUser.getCode())){
	freshman = esfGunUser.getCode();
}
if(Validator.isNotNull(esfGunUser.getNote())){
	note = esfGunUser.getNote();
}				
				
%>
					<liferay-ui:search-container-column-text name="shooter" value="<%= shooterName%>" />
					<liferay-ui:search-container-column-text name="freshman" value="<%=freshman %>" />
					<liferay-ui:search-container-column-text name="is-favorite-gun" value='<%=esfGunUser.getIsFavorite() ? res.getString("yes") : res.getString("no")%>'/>
					<liferay-ui:search-container-column-text name="shooter_note" value="<%= note%>" />
					<liferay-ui:search-container-column-jsp path='<%= templatePath + "esfGunUser_actions.jsp" %>' align="right" cssClass="gun_actions_button"/>	
				</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />	
</liferay-ui:search-container>




<h3><liferay-ui:message key="CANES"/></h3>

<liferay-ui:search-container emptyResultsMessage="no-results" delta="10"  curParam= "sc2">	
	<liferay-ui:search-container-results
				results="<%= ESFCaneLocalServiceUtil.getCanebyKindId(esfGunId, searchContainer.getStart(),searchContainer.getEnd())%>"
				total="<%= ESFCaneLocalServiceUtil.countCanebyKindId(esfGunId) %>"/>
		<liferay-ui:search-container-row className="it.ethica.esf.model.ESFCane" modelVar="esfGunUserC">
		<%
		String shooterNameC = "";
		String freshmanC = "";
		String noteC = "";
		
		ESFgunUser gunUser = new ESFgunUserImpl();
		List<ESFgunUser> gunUsers = new ArrayList<ESFgunUser>();
		ESFUser shooterC = new ESFUserImpl();
		
		shooterC = ESFUserLocalServiceUtil.fetchESFUser(esfGunUserC.getShooterId());
		
		gunUsers = ESFgunUserLocalServiceUtil.findbyESFGunId_Type(esfGunUserC.getEsfCaneId(), typeC);
		if(Validator.isNotNull(gunUsers) && Validator.isNotNull(gunUsers.get(0))){
			gunUser = gunUsers.get(0);
		}
		
		
		if(Validator.isNotNull(shooterC)){
			
			if(Validator.isNotNull(shooterC.getFirstName())){
				shooterNameC = shooterC.getFirstName().toUpperCase();
			}
			if(Validator.isNotNull(shooterC.getLastName())){
				shooterNameC = shooterNameC+" "+shooterC.getLastName().toUpperCase();
			}
			
		}
		
		if(Validator.isNotNull(gunUser)){
			freshmanC = gunUser.getCode();
			noteC = gunUser.getNote();
		}
		
		
		%>
		<liferay-ui:search-container-column-text name="shooter" value="<%= shooterNameC%>" />
		<liferay-ui:search-container-column-text name="freshman" value="<%=freshmanC %>" />
		<liferay-ui:search-container-column-text name="is-favorite-gun" value='<%=gunUser.getIsFavorite() ? res.getString("yes") : res.getString("no")%>'/>
		<liferay-ui:search-container-column-text name="shooter_note" value="<%= noteC%>" />
		<liferay-ui:search-container-column-jsp path='<%= templatePath + "esfGunUserCane_actions.jsp" %>' align="right" cssClass="gun_actions_button"/>	
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />	
</liferay-ui:search-container>
