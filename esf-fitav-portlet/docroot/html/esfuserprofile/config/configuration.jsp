<%@include file="init.jsp"%>


<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<%
	/*Eseguo il get dalle preferences per ricordarmi le preferenze 
	 *selezionate dall'utente, altrimenti inizializzo a FALSE tutti i campi
	 */
	boolean updateFirstName_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateFirstName",
					StringPool.FALSE));

	boolean updateLastName_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateLastName",
					StringPool.FALSE));

	boolean updateGender_cfg = GetterUtil.getBoolean(portletPreferences
			.getValue("updateGender", StringPool.FALSE));

	boolean updateYearBirth_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateYearBirth",
					StringPool.FALSE));

	boolean updatePlaceBirth_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updatePlaceBirth",
					StringPool.FALSE));

	boolean updateResidence_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateResidence",
					StringPool.FALSE));

	boolean updateHeight_cfg = GetterUtil.getBoolean(portletPreferences
			.getValue("updateHeight", StringPool.FALSE));

	boolean updateWeight_cfg = GetterUtil.getBoolean(portletPreferences
			.getValue("updateWeight", StringPool.FALSE));

	boolean updateMaritalStatus_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue(
					"updateMaritalStatus", StringPool.FALSE));

	boolean updateChildren_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateChildren",
					StringPool.FALSE));

	boolean updateHigherEducation_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue(
					"updateHigherEducation", StringPool.FALSE));

	boolean updateProfession_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateProfession",
					StringPool.FALSE));

	boolean updateLanguages_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateLanguages",
					StringPool.FALSE));

	boolean updateHobbies_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateHobbies",
					StringPool.FALSE));

	boolean updateHandedness_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateHandedness",
					StringPool.FALSE));

	boolean updateMasterEye_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateMasterEye",
					StringPool.FALSE));

	boolean updateOther_cfg = GetterUtil.getBoolean(portletPreferences
			.getValue("updateOther", StringPool.FALSE));

	boolean updateComments_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateComments",
					StringPool.FALSE));
	
	boolean updateTShirt_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateComments",
					StringPool.FALSE));
	
	boolean updatePants_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateComments",
					StringPool.FALSE));
	
	boolean updateHat_cfg = GetterUtil
			.getBoolean(portletPreferences.getValue("updateComments",
					StringPool.FALSE));
%>

<aui:form action="<%=configurationURL%>" method="post">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:input name="preferences--updateFirstName--" type="checkbox"
		value="<%=updateFirstName_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateLastName--" type="checkbox"
		value="<%=updateLastName_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateGender--" type="checkbox"
		value="<%=updateGender_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateYearBirth--" type="checkbox"
		value="<%=updateYearBirth_cfg%>">
	</aui:input>

	<aui:input name="preferences--updatePlaceBirth--" type="checkbox"
		value="<%=updatePlaceBirth_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateResidence--" type="checkbox"
		value="<%=updateResidence_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateHeight--" type="checkbox"
		value="<%=updateHeight_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateWeight--" type="checkbox"
		value="<%=updateWeight_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateMaritalStatus--" type="checkbox"
		value="<%=updateMaritalStatus_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateChildren--" type="checkbox"
		value="<%=updateChildren_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateHigherEducation--" type="checkbox"
		value="<%=updateHigherEducation_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateProfession--" type="checkbox"
		value="<%=updateProfession_cfg%>">
	</aui:input>
	
	<aui:input name="preferences--updateTShirt--" type="checkbox"
		value="<%=updateTShirt_cfg%>">
	</aui:input>
	
	<aui:input name="preferences--updatePants--" type="checkbox"
		value="<%=updatePants_cfg%>">
	</aui:input>
	
	<aui:input name="preferences--updateHat--" type="checkbox"
		value="<%=updateHat_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateLanguages--" type="checkbox"
		value="<%=updateLanguages_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateHobbies--" type="checkbox"
		value="<%=updateHobbies_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateHandedness--" type="checkbox"
		value="<%=updateHandedness_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateMasterEye--" type="checkbox"
		value="<%=updateMasterEye_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateOther--" type="checkbox"
		value="<%=updateOther_cfg%>">
	</aui:input>

	<aui:input name="preferences--updateComments--" type="checkbox"
		value="<%=updateComments_cfg%>">
	</aui:input>

	<aui:button-row>
		<aui:button type="submit" value="update" />
	</aui:button-row>
</aui:form>