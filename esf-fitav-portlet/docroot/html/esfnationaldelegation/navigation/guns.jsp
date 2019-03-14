
<%@include file="init.jsp"%>

<%
	String backUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	portletSession.setAttribute("backUrlEdit", backUrl);
	
	String tipo="";

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath","/html/esfnationaldelegation/navigation/guns.jsp");
    portletURL.setParameter("esfUserId", String.valueOf(esfUserId));

    int rifle = ESFKeys.ESFGunType.RIFLE;
	int caneType = ESFKeys.ESFGunType.CANE;
	int catridgeType = ESFKeys.ESFGunType.CATRIDGE;
%>

	<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_GUN_ADD) %>">	
	
		<portlet:renderURL var="addESFRifleURL">
				<portlet:param name="mvcPath"	value='<%= "/html/esfnationaldelegation/edit_esfRifle.jsp" %>' />
				<portlet:param name="esfUserId" value="<%=String.valueOf(esfUserId) %>" />
				<portlet:param name="modifyMode" value="false"/>
		</portlet:renderURL>
			
		<aui:button onClick="<%= addESFRifleURL.toString() %>" value="ADD-RIFLES" />
	</c:if>
		
		
	<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_GUN_CANE_ADD) %>">	
		<portlet:renderURL var="addESFCaneURL">
				<portlet:param name="mvcPath"
								value='<%= "/html/esfnationaldelegation/edit_esfCane.jsp" %>' />
				<portlet:param name="esfUserId"
									value="<%=String.valueOf(esfUserId) %>" />
				<portlet:param name="modifyMode" value="false"/>
		</portlet:renderURL>
			
		<aui:button onClick="<%= addESFCaneURL.toString() %>" value="ADD-CANES" />
	</c:if>

	<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_GUN_CATRIDGE_ADD) %>">	
		<portlet:renderURL var="addESFCatridgeURL">
			<portlet:param name="mvcPath"
							value='<%= "/html/esfnationaldelegation/edit_esfCatridge.jsp" %>' />
			<portlet:param name="esfUserId"
								value="<%=String.valueOf(esfUserId) %>" />
			<portlet:param name="modifyMode" value="false"/>
		</portlet:renderURL>

		<aui:button onClick="<%= addESFCatridgeURL.toString() %>" value="ADD-CATRIDGES" />
	</c:if>

<h3> <liferay-ui:message key="RIFLES"  /> </h3>		
<liferay-ui:search-container emptyResultsMessage="no-results" delta="5" curParam="sc1">
	<liferay-ui:search-container-results>
			<%
				List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
				int tot = 0;
				
					gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(esfUserId, rifle, 
							searchContainer.getStart(), searchContainer.getEnd());
					tot = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(esfUserId, rifle, 
							0, Integer.MAX_VALUE).size();
	
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
			
			if(Validator.isNotNull(esfGunU.getType()) && Validator.isNotNull(ListTypeServiceUtil.getListType((int) esfGunU.getTypeId())) &&
					Validator.isNotNull(ListTypeServiceUtil.getListType((int) esfGunU.getTypeId()).getName())){
			type = ListTypeServiceUtil.getListType((int) esfGunU.getTypeId()).getName() ;
			}
			
			shooter = ESFUserLocalServiceUtil.fetchESFUser(esfGunU.getEsfUserId());
			
			gunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunU.getEsfGunnTypeId());
			kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfGunU.getEsfGunId());
						
			if(Validator.isNotNull(gunType) && Validator.isNotNull(gunType.getName())){
				gunTypeName = gunType.getName();
			}
			
			if(Validator.isNotNull(kind) && Validator.isNotNull(kind.getName())){
				name = "-"+kind.getName();
			}
			name = (gunTypeName+name).toUpperCase();
			
			if(Validator.isNotNull(esfGunU.getEsfCaliber())){
				catridgeCaliber = esfGunU.getEsfCaliber();
			}
			if(Validator.isNotNull(esfGunU.getEsfMeasures())){
				measures = esfGunU.getEsfMeasures();
			}
			
			%>
					<liferay-ui:search-container-column-text name="Nome" value="<%= name%>" />
					<liferay-ui:search-container-column-text property="code" name='freshman' />
					<liferay-ui:search-container-column-text name='catridgeCaliber' value="<%=catridgeCaliber %>" />
					<liferay-ui:search-container-column-text name="typology" value='<%=type %>'/>
					<liferay-ui:search-container-column-text name="measures" value="<%=measures %>"/>
					<liferay-ui:search-container-column-text name="isFavoriteGun" value='<%= esfGunU.getIsFavorite() ? res.getString("yes") : res.getString("no") %>' />
					<liferay-ui:search-container-column-text property="note" name='shooter_note' />

				<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_GUN_VIEW) %>">	
			
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfnationaldelegation/navigation/guns_actions.jsp"%>' align="right" cssClass="gun_actions_button"/>	
				</c:if>
				
			</liferay-ui:search-container-row>
			
		 <liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>	
		
<h3> <liferay-ui:message key="CANES"  /> </h3>		
		<liferay-ui:search-container emptyResultsMessage="no-results" delta="5" curParam="sc2">
			<liferay-ui:search-container-results>
			<%
				List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
				int tot = 0;
				gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(esfUserId, caneType, 
						searchContainer.getStart(), searchContainer.getEnd());
				tot = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(esfUserId, caneType, 
						0, Integer.MAX_VALUE).size();

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
			
			cane = ESFCaneLocalServiceUtil.fetchESFCane(esfGunU.getEsfGunId());
			kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(cane.getEsfGunKindId());
			
			if(Validator.isNotNull(esfGunU.getEsfGunnTypeId()) && 
					Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunU.getEsfGunnTypeId())) &&
						Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunU.getEsfGunnTypeId()).getName())){
				gunTypeName = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunU.getEsfGunnTypeId()).getName();
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
					<liferay-ui:search-container-column-text name="Nome" value="<%= name%>" />
					<liferay-ui:search-container-column-text property="code" name='freshman' />
					<liferay-ui:search-container-column-text  name="catridgeCaliber" value="<%= caliber%>"/>
					<liferay-ui:search-container-column-text name="typology" value='<%=type %>'/>
					<liferay-ui:search-container-column-text name="measures" value="<%=measures %>"/>
					<liferay-ui:search-container-column-text name="isFavoriteGun" value='<%= esfGunU.getIsFavorite() ? res.getString("yes") : res.getString("no") %>' />
					<liferay-ui:search-container-column-text property="note" />
					
				<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_GUN_CANE_VIEW) %>">	
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfnationaldelegation/navigation/esfCane_actions.jsp"%>' align="right" cssClass="gun_actions_button"/>	
				</c:if>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" />
		</liferay-ui:search-container>
	
<h3> <liferay-ui:message key="CATRIDGES"/> </h3>
	<liferay-ui:search-container emptyResultsMessage="no-results" delta="5"  curParam= "sc3">
			<liferay-ui:search-container-results>
			<%
				List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
				int tot = 0;
				gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(esfUserId, catridgeType, 
						searchContainer.getStart(), searchContainer.getEnd());
				tot = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(esfUserId, catridgeType, 
						0, Integer.MAX_VALUE).size();
				
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
				
				if(gunUser.getEsfGunKindId() > 0){
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
					if(Validator.isNotNull(gunUser) && 
							Validator.isNotNull(gunUser.getNote())){
						catNote = gunUser.getNote();
					}
					if(Validator.isNotNull(catdrige) && 
							Validator.isNotNull(catdrige.getEsfGunTypeId()) && 
									Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(catdrige.getEsfGunTypeId()))){
						catBrand = ESFGunTypeLocalServiceUtil.fetchESFGunType(catdrige.getEsfGunTypeId()).getName();
					}
				}else{
					if(Validator.isNotNull(gunUser) && Validator.isNotNull(gunUser.getEsfGunnTypeId()) &&
							Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gunUser.getEsfGunnTypeId()))){
						catBrand = ESFGunTypeLocalServiceUtil.fetchESFGunType(gunUser.getEsfGunnTypeId()).getName();
					}
					if(Validator.isNotNull(gunUser) && Validator.isNotNull(gunUser.getNote())){
						catNote = gunUser.getNote();
					}
				}
				%>
					<liferay-ui:search-container-column-text name="brand-id" value="<%=catBrand %>" />
					<liferay-ui:search-container-column-text name="model" value="<%=catModel %>"  />
					<liferay-ui:search-container-column-text name="note" value="<%=catNote %>"  />
		
				<c:if test="<%= ESFNationalDelegationPermission.contains(permissionChecker,esfUserId, ActionKeys.ESFNATIONALDELEGATION_GUN_CATRIDGE_VIEW) %>">	
			
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfnationaldelegation/navigation/esfCatridge_actions.jsp"%>' align="right" cssClass="gun_actions_button"/>	
				</c:if>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>