
<%@page import="it.ethica.esf.service.ESFUserLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFUser"%>
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
		
