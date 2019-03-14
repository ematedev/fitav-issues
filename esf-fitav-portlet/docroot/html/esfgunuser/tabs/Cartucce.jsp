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