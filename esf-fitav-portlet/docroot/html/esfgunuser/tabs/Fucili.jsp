<%@page import="it.ethica.esf.service.ESFGunKindLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFGunKind"%>
<%@page import="it.ethica.esf.model.ESFGun"%>
<%@page import="it.ethica.esf.model.ESFGunType"%>


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
					<liferay-ui:search-container-column-text property="note" name='shooter_note' />
					<liferay-ui:search-container-column-jsp
					path='<%="/html/esfgunuser/esfGun_actions.jsp"%>' align="right" />	
	
			</liferay-ui:search-container-row>
		 <liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>