<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<portlet:actionURL name="createSingleAffiliation"  var="createSingleAffiliationURL" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span8">
			<aui:form action="${createSingleAffiliationURL}">
				<aui:fieldset>
					<aui:input name="esfCardId" type="text" label="ID tessera" required="true"/>
					<aui:input name="esfShooterId" type="hidden" />
					<aui:input name="esfOrganizationId" value="${esfOrganizationId}" type="hidden" />
					<aui:input name="input-node" label="lastName"/>
					<div id="<portlet:namespace/>autocomplete">
						<div id="<portlet:namespace/>autocomplete-list-node"></div>
						<div id="<portlet:namespace/>autocomplete-content">
						</div>
					</div>
					<aui:input name="paymentDate" />
				</aui:fieldset>
				<aui:button-row>
					<aui:button type="submit" value="save" />
				</aui:button-row>
			</aui:form>
		</div>
		<div class="span4">
			<div class="row-fluid">
				<div class="span12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>CARD</th>
							</tr>
						</thead>
						<tbody id="current-card-table-body">
						</tbody>
					</table>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>CARD HISTORY</th>
							</tr>
						</thead>
						<tbody id="history-card-table-body">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<aui:script>
var autocompleteUrl = Liferay.ThemeDisplay.getPortalURL()+'/api/jsonws/esf-fitav-portlet.esfuser/find-by-lastname-like/esf-organization-id/${esfOrganizationId}/last-name';
AUI().ready(
		'bootstrap',
		'aui-io-request',
		'datasource-jsonschema',		
		'datasource-io',
		'autocomplete-list',
		'autocomplete-filters',
		'autocomplete-sources',
		'autocomplete-highlighters',
		'dataschema-json',
		function(A) {
			var inputNode = A.one('#<portlet:namespace/>input-node');
			var inputNodeValue = A.one("#<portlet:namespace />esfShooterId");
		   	autocomplete = new A.AutoComplete({
	    		inputNode: '#<portlet:namespace/>input-node',
	    		source: autocompleteUrl,
	    		requestTemplate: '/{query}?p_auth='+Liferay.authToken,
	    		resultListLocator: function(val){
	    			return val;
	    		},
	    		resultTextLocator: function(val){
	    			return val.firstName + " " + val.lastName;
	    		},
	    		on: {
	    			select: function(event){
	    				inputNode.set('value', event.result.display);
	    				inputNodeValue.set('value', event.result.raw.userId);
	    				getCurrentUserCards(event.result.raw.userId);
	    				getHistoryUserCards(event.result.raw.userId);
	    			}
	    		}
	    	});
	    	autocomplete.render();
	    	inputNode.on('focus', function(){
	    		autocomplete.sendRequest();
	    	});
		});
		
function getCurrentUserCards(userId){
	AUI().use(function(A){
		Liferay.Service(
				  '/esf-fitav-portlet.esfcard/find-current-by-user-id',
				  {
				    userId: userId
				    
				  },
				  function(cards) {
				    fillCurrentCardTable(cards);
				  }
				);	
		});
}

function getHistoryUserCards(userId){
	AUI().use(function(A){
		Liferay.Service(
				  '/esf-fitav-portlet.esfcard/find-history-by-user-id',
				  {
				    userId: userId
				    
				  },
				  function(cards) {
				    fillHistoryCardTable(cards);
				  }
				);	
		});
}

function fillCurrentCardTable(cards){
	AUI().use(function(A){
		var cardTableBody = A.one("#current-card-table-body");
		if(cardTableBody){
			cardTableBody.empty();
			for(var i=0; i<cards.length; i++){
				console.log(cards[i]);
				cardTableBody.append("<tr><td><a href='javascript:void(0)' onclick='selectCard(" + cards[i].esfCardId + ")'>" + cards[i].code + " - ("+ cards[i].oldCode +")</a></td></tr>");
			}
		}
	});
}

function fillHistoryCardTable(cards){
	AUI().use(function(A){
		var cardTableBody = A.one("#history-card-table-body");
		if(cardTableBody){
			cardTableBody.empty();
			for(var i=0; i<cards.length; i++){
				console.log(cards[i]);
				cardTableBody.append("<tr><td><a href='javascript:void(0)' onclick='selectCard(" + cards[i].esfCardId + ")'>" + cards[i].code + " - ("+ cards[i].oldCode +")</a></td></tr>");
			}
		}
	});
}

function selectCard(cardId){
	AUI().use(function(A){
		var cardIdInput = A.one("#<portlet:namespace />esfCardId");
		if(cardIdInput){
			cardIdInput.set('value', cardId);
		}
	});
}
</aui:script>