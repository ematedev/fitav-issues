<%@include file="init.jsp"%>
<%	
	/*back to view*/
	String currentUrlPage = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	int urlEndIndex = currentUrlPage.indexOf('?');
	String backtoViewUrl = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId"); 
	if(urlEndIndex != -1){
		backtoViewUrl = currentUrlPage.substring(0, urlEndIndex);
	}
	portletDisplay.setURLBack(backtoViewUrl);
	/*end*/
	PortletURL viewassURL = renderResponse.createRenderURL();
	viewassURL.setParameter("mvcPath", templatePath +
		"edit_esfAddResult.jsp");
	viewassURL.setParameter(
		"organizationId", String.valueOf(currentOrganizationId));
	viewassURL.setWindowState(WindowState.NORMAL);
	int nationalShooterCounter = 0, externalShooterCounter = 0;
	boolean canUpdate=ESFNationalMatchPermission.contains(permissionChecker,esfMatchId, ActionKeys.ESFNATIONALMATCH_UPDATE_RESULT);
	long sportTypeid= 0;
	String externalIds = StringPool.BLANK;
%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" 
			value='<%=templatePath + "view.jsp"%>' />
</portlet:renderURL>
<portlet:actionURL var="addNationalMatchResURL"
			name="addNationalMatchRes">
		<portlet:param name="esfMatchId"
				value="<%=String.valueOf(esfMatchId)%>" />
		<portlet:param name="companyId"
				value="<%=String.valueOf(company.getCompanyId())%>" />
		<portlet:param name="groupId"
				value="<%=String.valueOf(group.getGroupId())%>" />
		<portlet:param name="userId"
				value="<%=String.valueOf(user.getUserId())%>" />
		<portlet:param name="mvcPath"
				value="/esfnationalmatch/edit_esfAddResult.jsp"/>
</portlet:actionURL>
<h2>
	<liferay-ui:message key="national-match-results" />
</h2>

<div class="alert alert-error hide" id="<portlet:namespace />submit-error">
	<liferay-ui:message key="insert-first-three-position" />
</div>
<portlet:resourceURL id="deleteExternalShooter" var="deleteExternalShooterVar">
	<portlet:param name="esfMatchId" value="<%= String.valueOf(esfMatchId) %>"/>
</portlet:resourceURL>
<aui:form action="<%=addNationalMatchResURL%>" cssClass="form-table" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitNationalMatchRes();" %>' name="fm">
	<liferay-ui:tabs names="skeetResultsAzzurri,doubleTrapResultsAzzurri,fossaOlimpicaAzzurri" refresh="false" tabsValues="skeetResultsAzzurri,doubleTrapResultsAzzurri,fossaOlimpicaAzzurri">
	    <liferay-ui:section>
	         <%@ include file="/html/esfnationalmatch/tabsResultsAzzurri/skeetResultsAzzurri.jsp" %>
	         <c:if test="<%= canUpdate %>">	
					<aui:button name="submit" type="submit" ></aui:button>
					<aui:button name="add" value="add" onClick='<%= renderResponse.getNamespace() + "addNationalMatchRes(\'fmskeet\',\'"+sportTypeid+"\');" %>' />
			</c:if>
	    </liferay-ui:section>
	     <liferay-ui:section>
	     	 <%@ include file="/html/esfnationalmatch/tabsResultsAzzurri/doubleTrapResultsAzzurri.jsp" %>
	     	 <c:if test="<%= canUpdate %>">	
					<aui:button name="submit" type="submit" ></aui:button>
					<aui:button name="add" value="add" onClick='<%= renderResponse.getNamespace() + "addNationalMatchRes(\'fmdoubletrap\',\'"+sportTypeid+"\');" %>' />
			</c:if>
	    </liferay-ui:section>
	    <liferay-ui:section>
	   		 <%@ include file="/html/esfnationalmatch/tabsResultsAzzurri/fossaOlimpicaResultsAzzurri.jsp" %>
	   		  <c:if test="<%= canUpdate %>">	
					<aui:button name="submit" type="submit" ></aui:button>
					<aui:button name="add" value="add" onClick='<%= renderResponse.getNamespace() + "addNationalMatchRes(\'fmfossaolimpica\',\'"+sportTypeid+"\');" %>' />
			</c:if>
	    </liferay-ui:section>
	</liferay-ui:tabs>
	<aui:input name="externalIds" type="hidden" value="<%= externalIds %>"/>
</aui:form>
<aui:button onClick='<%=backURL.toString() %>' value="back" />
<aui:script use="aui-base">
	var counter = <%= externalShooterCounter %>;
	var addAct=<%= canUpdate %>;
	Liferay.provide(
		window,
		'<portlet:namespace />addNationalMatchRes',
		function(nametable,sportTypeid) {
			var act='';
			var table =$( "table[name*=\'"+nametable+"\']" );
			if(addAct)
				act='<div class="delete-icon" onClick="<portlet:namespace />deleteExternalShooter(event.target);" data-value="-1" data-index="' + counter + '"></div>';
			var row = '<tr>' +
				'<td><div class="control-group shooter-name"><input type="text" name="<portlet:namespace />shooterName_ext_' + counter + '" />' +act+'</div></td>' +
				'<td><input type="number" class="position-input" min="0" name="<portlet:namespace />position_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />qualification_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />shootOff_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />clayPigeonTotal_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />finalResult_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="number" min="0" name="<portlet:namespace />shootOffFinal_ext_' + counter + '" value="0" /></td>' +
				'<td><input type="text" 		  name="<portlet:namespace />userNationality_ext_' + counter + '" value="" /></td>' +
				'<td><input type="hidden" 		  name="<portlet:namespace />sportTypeid_ext_' + counter + '" value="'+sportTypeid+'" /></td>' +
				'</tr>';
			table.one('tbody').append(row);
			A.one('#<portlet:namespace />externalIds').val(A.one('#<portlet:namespace />externalIds').val() + counter + ",");
			A.one('#<portlet:namespace />submit-error').hide();
			counter++;
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace />submitNationalMatchRes',
		function() {
			var podium= [1,2,3];
			var positions = A.all('table[name="fmskeet"] .position-input');
			var isPresent = false;
			positions.each(function(node){
				isPresent= true;
				var value = parseInt(node.val());
				if (podium.includes(value)) {
					var index = podium.indexOf(value);
					if (index > -1) {
						podium.splice(index, 1);
					}
				}
			});
			if (podium.length >= 1&& isPresent) {
				A.one('#<portlet:namespace />submit-error').show();
				return false;
			}
			podium= [1,2,3];
			positions = A.all('table[name="fmdoubletrap"] .position-input');
			isPresent = false;
			positions.each(function(node){
				var value = parseInt(node.val());
				isPresent= true;
				if (podium.includes(value)) {
					var index = podium.indexOf(value);
					if (index > -1) {
						podium.splice(index, 1);
					}
				}
			});
			if (podium.length >= 1&& isPresent) {
				A.one('#<portlet:namespace />submit-error').show();
				return false;
			}
			podium= [1,2,3];
			positions = A.all('table[name="fmfossaolimpica"] .position-input');
			isPresent = false;
			positions.each(function(node){
				isPresent = true;
				var value = parseInt(node.val());
				if (podium.includes(value)) {
					var index = podium.indexOf(value);
					if (index > -1) {
						podium.splice(index, 1);
					}
				}
			});
			if (podium.length >= 1 && isPresent) {
				A.one('#<portlet:namespace />submit-error').show();
				return false;
			}
			submitForm(document.<portlet:namespace />fm);
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace />deleteExternalShooter',
		function(element) {
			var el = A.one(element);
			var val = parseInt(el.getAttribute('data-value'));
			var index = parseInt(el.getAttribute('data-index'));
			var extIds = A.one('#<portlet:namespace />externalIds').val();
			extIds = extIds.replace(index + ',', '');
			A.one('#<portlet:namespace />externalIds').val(extIds);
			var tr = el.ancestor('tr');
			if (val == -1) {
				tr.remove();
				return;
			}
			A.io.request(
				'<%= deleteExternalShooterVar %>',
				{
					dataType: 'json',
					method: 'post',
					data: {
						<portlet:namespace />esfNationalMatchResultId: val
					},
					on: {
						complete: function() {
							tr.remove();
						}
					}
				}
			);
		}
	);
</aui:script>