
<%@page import="it.ethica.esf.model.impl.ESFCaneImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFCatridgeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunTypeImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunKindImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFUserImpl"%>
<%@page import="it.ethica.esf.model.impl.ESFGunImpl"%>
<%@page import="it.ethica.esf.service.ESFgunUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFgunUser"%>
<%@ include file="init.jsp" %>

<%

User currentUser = PortalUtil.getUser(request);
long userId = currentUser.getUserId();
List<ESFGunKind> esfGunKinds = ESFGunKindLocalServiceUtil.getESFGunKinds();
String tipo="";
List<ESFGun> esfGuns = new ArrayList<ESFGun>();

%>
<liferay-ui:error key="duplicate_code" message="duplicate_code"/>
<liferay-ui:error key="duplicate_code" message="duplicate_rifles"/>
<liferay-ui:error key="duplicate_code" message="error_rifles"/>
<c:choose>
	<c:when test="<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_ESFGUN) %>">

		<liferay-portlet:renderURL varImpl="searchURL">
				<portlet:param name="mvcPath" value="/html/esfgunuser/view_search.jsp" />
		</liferay-portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
			<div class="search-form">
				<span class="aui-search-bar">
					<aui:input inlineField="<%= true %>" label="" name="code" placeholder="code"
							size="30" title="search-entries" type="text" />
					<aui:select inlineField="<%= true %>" name="esfGunKindId">
					<aui:option label="-"
								value="0" />
						<%
						for (ESFGunKind esfGunKind : esfGunKinds) {
						%>
							
							<aui:option label="<%= esfGunKind.getName()%>"
								value="<%= esfGunKind.getEsfGunKindId()%>" />
						<%
					
						}
						%>	
					</aui:select>
					
					<aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>
<%if(currentOrganizationId !=0){  %>
		<aui:button-row cssClass="esfgun-admin-buttons">
			<c:if test='<%= ESFGunModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ESFGUN) %>'>
				<portlet:renderURL var="addESFRifleURL">
						<portlet:param name="mvcPath"
						value='<%= templatePath+"edit_esfRifle.jsp" %>' />
						<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>
				
				<aui:button onClick="<%= addESFRifleURL.toString() %>" value="ASSIGN-RIFLES" />
				
				<portlet:renderURL var="addESFCaneURL">
				<portlet:param name="mvcPath"
							value='<%= templatePath+"edit_esfCane.jsp" %>' />
						<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>
		
				<aui:button onClick="<%= addESFCaneURL.toString() %>" value="ASSIGN-CANES" />
				
				<portlet:renderURL var="addESFCatridgeURL">
					<portlet:param name="mvcPath"
						value='<%= templatePath+"edit_esfCatridge.jsp" %>' />
					<portlet:param name="modifyMode" value="false"/>
				</portlet:renderURL>

					<aui:button onClick="<%= addESFCatridgeURL.toString() %>" value="ASSIGN-CATRIDGES" />
			</c:if>
		</aui:button-row>
<%} %>
<h3><liferay-ui:message key="RIFLES"  /></h3>	
<liferay-ui:search-container emptyResultsMessage="no-results" delta="5"  curParam= "sc1">	
		<liferay-ui:search-container-results>
			<%
				List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
				int tot = 0;
				if(currentOrganizationId !=0){ 
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByT(ESFKeys.ESFGunType.RIFLE, 
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.countESFGunByT(ESFKeys.ESFGunType.RIFLE);
				}else{	
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(userId,ESFKeys.ESFGunType.RIFLE,
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.countESFGunByLikeS_T(userId, ESFKeys.ESFGunType.RIFLE);
					
				} 
				pageContext.setAttribute("results", gunUser);
				pageContext.setAttribute("total", tot);
			%>
		</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFgunUser" modelVar="esfGunU">
			<%
			String name = "";
			String userName = "no_assigned";
			String catridgeCaliber = "";
			String measures = "";
			String type="";
			String gunTypeName="";
			ESFGun gun = new ESFGunImpl();
			ESFUser shooter = new ESFUserImpl();
			ESFGunKind kind = new ESFGunKindImpl();
			ESFGunType gunType = new ESFGunTypeImpl();
			
		//	gun = ESFGunLocalServiceUtil.fetchESFGun(esfGunU.getEsfGunId());
			
			shooter = ESFUserLocalServiceUtil.fetchESFUser(esfGunU.getEsfUserId());
			

			kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunU.getEsfGunId());
						
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfGunTypeId()) &&
					Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId())) && 
					Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()).getName())){
				gunTypeName = ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()).getName();
			}
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getName())){
				name = kind.getName();
			}
			name = (gunTypeName+"-"+name).toUpperCase();
			
			if (Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName())
					&& Validator.isNotNull(shooter.getLastName()) && !"Test Test".equalsIgnoreCase(shooter.getLastName())
					&& !"Test Test".equalsIgnoreCase(shooter.getFirstName())){
				userName = shooter.getLastName() + " "+ shooter.getFirstName() ;
			}
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getCaliber())){
				catridgeCaliber = String.valueOf(kind.getCaliber()) ;
			}
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfMeasures())){
				measures = String.valueOf(kind.getEsfMeasures()) ;
			}
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfTypeId()) && 
					Validator.isNotNull(ListTypeServiceUtil.getListType((int)(kind.getEsfTypeId())))){
				type = ListTypeServiceUtil.getListType((int)(kind.getEsfTypeId())).getName() ;
			}
			
			%>
					<liferay-ui:search-container-column-text name="owner" 
						value="<%= UserLocalServiceUtil.getUser(esfGunU.getEsfUserId()).getFullName().toUpperCase() %>"/>
					<liferay-ui:search-container-column-text name="Nome" value="<%= name%>" />
					<liferay-ui:search-container-column-text property="code" name='freshman' />
					<liferay-ui:search-container-column-text name='catridgeCaliber' value="<%=catridgeCaliber %>" />
					<liferay-ui:search-container-column-text name="typology" value='<%=type %>'/>
					<liferay-ui:search-container-column-text name="measures" value="<%=measures %>"/>
					<liferay-ui:search-container-column-text name="isFavoriteGun" value='<%= esfGunU.getIsFavorite() ? res.getString("yes") : res.getString("no") %>' />
					
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfgunuser/esfGun_actions.jsp"%>' align="right" />	
	
			</liferay-ui:search-container-row>
		 <liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>
	
	
<h3><liferay-ui:message key="CANES"  /></h3>	
	<liferay-ui:search-container emptyResultsMessage="no-results" delta="5"  curParam= "sc2">
			<liferay-ui:search-container-results>
			<%
				List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
				int tot = 0;
				if(currentOrganizationId !=0){	
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByT(ESFKeys.ESFGunType.CANE, 
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.countESFGunByT(ESFKeys.ESFGunType.CANE);
				}else{	
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(userId,ESFKeys.ESFGunType.CANE,
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.countESFGunByLikeS_T(userId, ESFKeys.ESFGunType.CANE);
					
				} 

				pageContext.setAttribute("results", gunUser);
				pageContext.setAttribute("total", tot);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="it.ethica.esf.model.ESFgunUser" modelVar="esfGunU">
			<%
			String name = ""; 
			String userName = "no_assigned";
			String gunTypeName="";
			String kindName = ""; 
			String caliber = "";
			String type="";
			String measures = "";
			ESFCane cane = new ESFCaneImpl();
			ESFUser shooter = new ESFUserImpl();
			ESFGunKind kind = new ESFGunKindImpl();
			
			shooter = ESFUserLocalServiceUtil.fetchESFUser(esfGunU.getEsfUserId());

			if (Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName())
					&& Validator.isNotNull(shooter.getLastName())){
				userName = shooter.getFirstName() + " "+ shooter.getLastName();
			}
			
			cane = ESFCaneLocalServiceUtil.fetchESFCane(esfGunU.getEsfGunId());
			kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId());
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getEsfGunTypeId()) &&
					Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId())) && 
					Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()).getName())){
				gunTypeName = ESFGunTypeLocalServiceUtil.fetchESFGunType(kind.getEsfGunTypeId()).getName();
			}
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getName())){
				kindName = kind.getName();
			}
			name = (gunTypeName + "-"+kindName).toUpperCase();
			
			if(Validator.isNotNull(cane) && Validator.isNotNull(cane.getCaneCaliber())){
				caliber = String.valueOf(cane.getCaneCaliber());
			}
			if(Validator.isNotNull(cane) && Validator.isNotNull(cane.getMeasures())){
				measures = String.valueOf(cane.getMeasures());
			}
			if(Validator.isNotNull(cane) && Validator.isNotNull(cane.getTypeId()) && 
					Validator.isNotNull(ListTypeServiceUtil.getListType(Integer.valueOf(cane.getTypeId())))){
				type = ListTypeServiceUtil.getListType(Integer.valueOf(cane.getTypeId())).getName() ;
			}
			%>
				
				<liferay-ui:search-container-column-text name="owner" 
						value="<%= userName.toUpperCase() %>"/>
					<liferay-ui:search-container-column-text name="Nome"
						value="<%= name%>" />
					<liferay-ui:search-container-column-text property="code" name='freshman' />
					<liferay-ui:search-container-column-text  name="catridgeCaliber" value="<%= caliber%>"/>
					<liferay-ui:search-container-column-text name="typology" value='<%=type %>'/>
					<liferay-ui:search-container-column-text name="measures" value="<%=measures %>"/>
					<liferay-ui:search-container-column-text name="isFavoriteGun" value='<%= esfGunU.getIsFavorite() ? res.getString("yes") : res.getString("no") %>' />
					<liferay-ui:search-container-column-text property="note" />
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfgunuser/esfCane_actions.jsp"%>' align="right" />	
				
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" />
		</liferay-ui:search-container>
		
		
<h3><liferay-ui:message key="CATRIDGES"  /></h3>	
		
<liferay-ui:search-container emptyResultsMessage="no-results" delta="5"  curParam= "sc3">
			<liferay-ui:search-container-results>
			<%
				List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
				int tot = 0;
				if(currentOrganizationId !=0){ 
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByT(ESFKeys.ESFGunType.CATRIDGE, 
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.countESFGunByT(ESFKeys.ESFGunType.CATRIDGE);
				}else{	
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(userId,ESFKeys.ESFGunType.CATRIDGE,
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.countESFGunByLikeS_T(userId, ESFKeys.ESFGunType.CATRIDGE);
					
				} 
				
				pageContext.setAttribute("results", gunUser);
				pageContext.setAttribute("total", tot);
			%>
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row
				className="it.ethica.esf.model.ESFgunUser" modelVar="gunUser">
				<%
				String name = "";
				String lastName = "";
				String catBrand = "";
				String catModel = "";
				String catCaliber = "";
				String catNote = "";
				ESFUser shooter = new ESFUserImpl();
				ESFCatridge catdrige = new ESFCatridgeImpl();
				if(Validator.isNotNull(gunUser) && Validator.isNotNull(gunUser.getEsfUserId())){
					shooter = ESFUserLocalServiceUtil.fetchESFUser(gunUser.getEsfUserId());
				}
				if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName())){
					name = shooter.getFirstName();
				}
				if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getLastName())){
					lastName = shooter.getLastName();
				}
				name = name+" "+lastName;
				
				if(Validator.isNotNull(gunUser.getEsfGunId()) && 
						Validator.isNotNull(ESFCatridgeLocalServiceUtil.fetchESFCatridge(gunUser.getEsfGunId()))){
					catdrige = ESFCatridgeLocalServiceUtil.fetchESFCatridge(gunUser.getEsfGunId());
				}
				
				if(Validator.isNotNull(catdrige) && 
						Validator.isNotNull(catdrige.getCatridgeModel())){
					catModel = catdrige.getCatridgeModel();
				}
				if(Validator.isNotNull(catdrige) && 
						Validator.isNotNull(catdrige.getCatridgeCaliber())){
					catCaliber = String.valueOf( catdrige.getCatridgeCaliber());
				}
				if(Validator.isNotNull(catdrige) && 
						Validator.isNotNull(catdrige.getNote())){
					catNote = catdrige.getNote();
				}
				if(Validator.isNotNull(catdrige) && 
						Validator.isNotNull(catdrige.getEsfGunTypeId()) && 
								Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(catdrige.getEsfGunTypeId()))){
					catBrand = ESFGunTypeLocalServiceUtil.fetchESFGunType(catdrige.getEsfGunTypeId()).getName();
				}
				%>
					<liferay-ui:search-container-column-text name="owner" value="<%=name.toUpperCase()  %>"/>
					<liferay-ui:search-container-column-text name="brand-id" value="<%=catBrand %>" />
					<liferay-ui:search-container-column-text name="model" value="<%=catModel %>"  />
					<liferay-ui:search-container-column-text name="caliber" value="<%=catCaliber %>"  />
					<liferay-ui:search-container-column-text name="note" value="<%=catNote %>"  />
					
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfgunuser/esfCatridge_actions.jsp"%>' align="right" />	
				
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message key="you-do-not-have-the-required-permissions-to-access-this-content" />
		</div>
	</c:otherwise>
</c:choose>

