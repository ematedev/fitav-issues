
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.ESFTeam;
import it.ethica.esf.model.ESFTournament;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFNationalDelegationImpl;
import it.ethica.esf.model.impl.ESFResultImpl;
import it.ethica.esf.model.impl.ESFTeamImpl;
import it.ethica.esf.portlet.utility.ShooterUtility;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFReportUtil;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ExecuteUploadResult;
import it.ethica.esf.util.InsertResult;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.VerificaIstruzioni;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
/**
 * Portlet implementation class ESFNormalMatchPortlet
 */
public class ESFNormalMatchPortlet extends MVCPortlet {
	
	private boolean isNational = false;

	/*
	 * Variabili necessarie per la gestione dell'upload del file
	 * 
	 * */							  
	private final static int space = 104857600;//1073741824;	//se la dimensione libera sul disco e' migore di 100MB non fa l'upload
	private final static String baseDir = "/tmp/uploaded/";
	//private final static String fileInputName = "fileupload";

	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFGun(request, response, "esfnormalmatch");

	}

	public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFdocument(request, response, "esfnormalmatch");

	}

	public void updateESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.updateESFShooter(
			actionRequest, actionResponse, "esfnormalmatch");

	}
	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
		
		String esfMatchId = ParamUtil.getString(request, "esfMatchId");
		String firstName = ParamUtil.getString(request, "firstName");
		boolean flag=ParamUtil.getBoolean(request, "isEditShooter");
		if(flag){
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.render(request, response);
		}
		else{
		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();

		String op = ParamUtil.getString(request, "op");
		if (op.equals("addAddr")) {
			try {
				esfJsonUtil.prepareJSONAddAssociations(request, response);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
		}
		else if (op.equals("updAddr")) {
			try {
				esfJsonUtil.prepareJSONUpdAssociationsFields(request, response);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
		}
		super.render(request, response);
	}
	}
	
	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		boolean flag=ParamUtil.getBoolean(resourceRequest, "isEditShooter");
		/*if(flag){*/
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.serveResource(resourceRequest, resourceResponse);
		
		HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
		long description = ParamUtil.getLong(httpReq, "description",0);
		
		if (description > 0) {
			
			List<ESFMatchType> esfMatchTypes = new ArrayList<ESFMatchType>();
			
			try {
				esfMatchTypes=ESFMatchTypeLocalServiceUtil.
						findByDescription(ESFDescriptionLocalServiceUtil
								.fetchESFDescription(description).getName());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

			for(ESFMatchType esfMatchType : esfMatchTypes ){
				
				JSONObject esfMatchTypeIdName =
						JSONFactoryUtil.createJSONObject();
			
				esfMatchTypeIdName.put(
						"esfMatchTypesId", esfMatchType.getEsfMatchTypeId());
				esfMatchTypeIdName.put("name", esfMatchType.getName());
					resultJSONArr.put(esfMatchTypeIdName);
				}
			resultJSONObj.put("esfMatchTypes", resultJSONArr);

			resourceResponse.getWriter().write(resultJSONObj.toString());
		}
		/*
		}else{
		
		HttpServletRequest httpReq =
			PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletRequest servletRequest =
			PortalUtil.getOriginalServletRequest(httpReq);
		String action =
			GetterUtil.getString(resourceRequest.getParameter("action"));
		if (action.equals("report")) {

			Map<String, Object> parameters = new HashMap<String, Object>();

			String[] paramNames =
				ESFReportUtil.ESFReportContants.ESFNationalDeclaration.Parameters.NAMES;
			String[] paramValues =
				ESFReportUtil.ESFReportContants.ESFNationalDeclaration.Parameters.VALUES;

			for (int i = 0; i < paramNames.length; i++) {

				parameters.put(paramNames[i], paramValues[i]);
			}

			List<Map<String, ?>> maps = new ArrayList<Map<String, ?>>();

			long userId = Long.valueOf(resourceRequest.getParameter("userId"));

			try {
				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(resourceRequest);

				// Group userGroup = GroupLocalServiceUtil.getUserGroup(
				// serviceContext.getCompanyId(),
				// serviceContext.getUserId());
				// reperire sito dell'utente e verificare se corrisponde al
				// repositoryId.
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// User user = UserLocalServiceUtil.fetchUser(userId);
			// List<ESFGun> esfGuns =
			// ESFGunLocalServiceUtil.getESFGunsByUserId(userId);

			// ESFReport.downloadReport(resourceRequest, resourceResponse,
			// ESFKeys.ESFReport.INPUT_NATIONAL_DECLARATION,
			// ESFKeys.ESFReport.OUTPUT_NATIONAL_DECLARATION, parameters, maps);
		}
		else {

			try {
				ESFServiceUtil esfServiceUtil =
					new ESFServiceUtil(
						ESFTournament.class.getName(), resourceRequest);

				String param =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"param");

				long associationId =
					StringToLong(PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"idAssociation"));
				long fieldId =
					StringToLong(PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"idField"));
				String resourceID = resourceRequest.getResourceID();

				if (resourceID.equals("associations")) {
					esfServiceUtil.serveAssociationsFields(
						resourceRequest, resourceResponse, param, associationId);
				}
				else if (resourceID.equals("fields")) {
					esfServiceUtil.serveAssociationsSportTypes(
						resourceRequest, resourceResponse, param, fieldId);
				}

			}
			catch (IOException ioe) {
				throw ioe;
			}
			catch (PortletException pe) {
				throw pe;
			}
			catch (Exception e) {
				throw new PortletException(e);
			}
		}

		// super.serveResource(resourceRequest, resourceResponse);
	}*/
	}

	/*
	 * public void addESFMatch(ActionRequest request, ActionResponse response)
	 * throws PortalException, SystemException, ParseException { ServiceContext
	 * serviceContext =
	 * ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);
	 * long description = ParamUtil.getLong(request, "description"); String note
	 * = ParamUtil.getString(request, "notes"); boolean isDraft =
	 * ParamUtil.getBoolean(request, "isDraft"); long esfAssociationId =
	 * ParamUtil.getLong(request, "esfAssociationId"); long esfFieldId =
	 * ParamUtil.getLong(request, "esfFieldId"); long esfSportTypeId =
	 * ParamUtil.getLong(request, "esfSportTypeid"); Date startDate =
	 * ManageDate.StringToDate(ParamUtil.getString(request, "startDate")); Date
	 * endDate = ManageDate.StringToDate(ParamUtil.getString(request,
	 * "endDate")); String startHour = ParamUtil.getString(request,
	 * "startHour"); int numDisk = ParamUtil.getInteger(request, "numDisk"); int
	 * numFields = ParamUtil.getInteger(request, "numFields"); ESFEntityState
	 * esfEntityState = new ESFEntityStateImpl();
	 * esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE); if
	 * (startDate.after(endDate)) { SessionErrors.add(request, "date-message");
	 * } else { ESFMatchLocalServiceUtil.addESFMatch(
	 * serviceContext.getUserId(), 0, esfAssociationId, esfFieldId,
	 * esfSportTypeId, numDisk, startDate, endDate, numFields, startHour,
	 * isDraft, description, note, false, esfEntityState, serviceContext);
	 * SessionMessages.add(request, "match-success-insertupdate"); }
	 * response.setRenderParameter("mvcPath", templatePath + "/view.jsp"); }
	 */
	public void updateESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);

		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		_log.debug("nella portlet esfMatchId="+esfMatchId);
		String code = ParamUtil.getString(request, "code");
		String sd = ParamUtil.getString(request, "startDate");
		String ed = ParamUtil.getString(request, "endDate");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = ManageDate.StringToDate(sd);
			endDate = ManageDate.StringToDate(ed);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		String startHour = ParamUtil.getString(request, "startHour");
		long description = ParamUtil.getLong(request, "description");
		String note = ParamUtil.getString(request, "notes");
		boolean isDraft = ParamUtil.getBoolean(request, "isDraft");
		int numDisk = ParamUtil.getInteger(request, "numDisk");
		int numDiskTeam = ParamUtil.getInteger(request, "numDiskTeam");
		long esfAssociationId = ParamUtil.getLong(request, "esfAssociationId");
		int numFields = ParamUtil.getInteger(request, "numFields");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeid");
		boolean isIndividualMatch =
				ParamUtil.getBoolean(request, "isIndividualMatch");
		boolean isChangeCategoryMatch =
			ParamUtil.getBoolean(request, "isChangeCategoryMatch");
		boolean isTeamMatch = ParamUtil.getBoolean(request, "isTeamMatch");
		boolean isJuniorMatch = ParamUtil.getBoolean(request, "isJuniorMatch");
		long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
		String[] valuesQ = ParamUtil.getParameterValues(request, "values", new String[0]);
		String[] valuesSC = ParamUtil.getParameterValues(request, "valuesSC", new String[0]);
		
		long[] esfShooterCategoryIds = new long[valuesSC.length];
		long[] esfShooterQualificationIds = new long[valuesQ.length];

		for(int i = 0; i < valuesQ.length; i++) {
			esfShooterQualificationIds[i] = Long.valueOf(valuesQ[i]);
	    }
		for(int i = 0; i < valuesSC.length; i++) {
			esfShooterCategoryIds[i] = Long.valueOf(valuesSC[i]);
	    }
		
		/* Setto a null i dati non necessari per un match normale */
		long esfCountryId = 0;
		String site = StringPool.BLANK;
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

		if (startDate.after(endDate)) {

			SessionErrors.add(request, "date-message");

		}
		else {
			ESFMatch newMatch =
				ESFMatchLocalServiceUtil.addOrUpdateESFMatch(
					serviceContext.getUserId(), esfMatchId, esfAssociationId,
					code, startDate, endDate, startHour, description, note,
					isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
					isIndividualMatch, isTeamMatch, isJuniorMatch,
					esfMatchTypeId, isChangeCategoryMatch , esfShooterCategoryIds,
					esfShooterQualificationIds, esfCountryId, site, isNational,
					esfEntityState, serviceContext);
			
			if (newMatch == null || newMatch.getPrimaryKey() == 0) {
				_log.debug("Errore nell'operazione di salvataggio");
				SessionErrors.add(request, "match-error-operation");
			}
			else if (esfMatchId == 0) {
				_log.debug("Salvataggio OK");
				SessionMessages.add(request, "match-success-insert");
			}
			else {
				_log.debug("Aggiornamento OK");
				SessionMessages.add(request, "match-success-update");
			}
		}

		response.setRenderParameter("mvcPath", templatePath + "view.jsp");
	}

	public void deleteESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);

		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		List<ESFPartecipant> esfPartecipants =
			ESFPartecipantLocalServiceUtil.findPartecipantsByMatch(esfMatchId);

		if (!esfPartecipants.isEmpty()) {

			SessionErrors.add(request, "partecipant-already-assigned-message");

		}
		else {
			ESFMatchLocalServiceUtil.deleteESFMatch(esfMatchId, serviceContext);

			SessionMessages.add(request, "deleteESFMatch");
		}

		response.setRenderParameter("mvcPath", templatePath + "view.jsp");
	}

	/*
	 * public void addESFNationalDelegation( ActionRequest request,
	 * ActionResponse response) throws PortalException, SystemException,
	 * ParseException { ServiceContext serviceContext =
	 * ServiceContextFactory.getInstance( ESFNationalDelegation.class.getName(),
	 * request); long[] esfUserRequestIds = ParamUtil.getLongValues(request,
	 * "checkDelegateCheckbox"); long esfTournamentId =
	 * ParamUtil.getLong(request, "esfTournamentId"); String className =
	 * ParamUtil.getString(request, "className"); long classPK =
	 * ParamUtil.getLong(request, "classPK"); for (long esfUserRequestId :
	 * esfUserRequestIds) { long esfUserId = 0; if
	 * (className.equals(ESFNational.class.getName())) { ESFNational esfNational
	 * = ESFNationalLocalServiceUtil.getESFNational(esfUserRequestId); esfUserId
	 * = esfNational.getEsfUserId(); } else if
	 * (className.equals(ESFUserRole.class.getName())) { esfUserId =
	 * esfUserRequestId; }
	 * ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation(
	 * serviceContext.getUserId(), esfTournamentId, esfUserId, className,
	 * classPK, serviceContext); } response.setRenderParameter( "mvcPath",
	 * "/html/esftournament/delegation/view.jsp"); response.setRenderParameter(
	 * "esfTournamentId", String.valueOf(esfTournamentId)); } public void
	 * updateESFNationalDelegation( ActionRequest request, ActionResponse
	 * response) throws PortalException, SystemException, ParseException {
	 * ServiceContext serviceContext = ServiceContextFactory.getInstance(
	 * ESFNationalDelegation.class.getName(), request); DateFormat dateFormat =
	 * DateFormatFactoryUtil.getDate(serviceContext.getLocale()); long esfUserId
	 * = ParamUtil.getLong(request, "esfUserId"); long esfTournamentId =
	 * ParamUtil.getLong(request, "esfTournamentId"); String className =
	 * ParamUtil.getString(request, "className"); long classPK =
	 * ParamUtil.getLong(request, "classPK"); Date leaveDate =
	 * ParamUtil.getDate(request, "leaveDate", dateFormat); Date returnDate =
	 * ParamUtil.getDate(request, "returnDate", dateFormat); long esfGunId1 =
	 * ParamUtil.getLong(request, "esfGunId1"); long esfGunId2 =
	 * ParamUtil.getLong(request, "esfGunId2"); long esfSportTypeId =
	 * ParamUtil.getLong(request, "esfSportTypeId");
	 * ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(
	 * serviceContext.getUserId(), esfTournamentId, esfUserId, leaveDate,
	 * returnDate, className, classPK, esfSportTypeId, esfGunId1, esfGunId2,
	 * serviceContext); response.setRenderParameter( "mvcPath",
	 * "/html/esftournament/delegation/view.jsp"); response.setRenderParameter(
	 * "esfTournamentId", String.valueOf(esfTournamentId)); } public void
	 * deleteESFNationalDelegation( ActionRequest request, ActionResponse
	 * response) throws PortalException, SystemException, ParseException { long
	 * esfUserId = ParamUtil.getLong(request, "esfUserId"); long esfTournamentId
	 * = ParamUtil.getLong(request, "esfTournamentId");
	 * ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(
	 * esfTournamentId, esfUserId); response.setRenderParameter( "mvcPath",
	 * "/html/esftournament/delegation/view.jsp"); response.setRenderParameter(
	 * "esfTournamentId", String.valueOf(esfTournamentId)); }
	 */

	public void addESFPartecipant(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);
		
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		long userId = themeDisplay.getUserId();
		String userName = themeDisplay.getUser().getScreenName();
		long groupId = user.getGroupId();
		long companyId = user.getCompanyId();
		

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTeamId = ParamUtil.getLong(request, "esfTeamId");
		long ct = ParamUtil.getLong(request, "ct");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		Date now = new Date();
		Date matchDate = null;
		int suspensiveNum = 0;
		
		ESFMatch match = new ESFMatchImpl();
		
		try {
			match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
			matchDate = match.getStartDate();
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.debug("errore nel match");
		}
		
		ESFNationalDelegation del = new ESFNationalDelegationImpl();
		long delId = CounterLocalServiceUtil.increment(ESFNationalDelegation.class.getName());
		
		try {
			suspensiveNum = ESFSuspensiveShootingDirectorLocalServiceUtil.findSuspensive(matchDate, esfUserId);

			if(0 < suspensiveNum){
				
				response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
				response.setRenderParameter(
					"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");
				SessionErrors.add(request, "find-Suspensive");
				return;
			}
			
			del.setEsfNationalDelgationId(delId);
			
			del.setCompanyId(companyId);
			del.setGroupId(groupId);
			del.setUserName(userName);
			del.setUserId(userId);
			del.setCreateDate(now);
			
			del.setEsfUserId(esfUserId);
			del.setEsfMatchId(esfMatchId);
			del.setEsfPartecipantTypeId(esfPartecipantTypeId);
			del.setNominationDate(now);
			
			ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation(del);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "error-assign-director");
		}
		
		
		
		
		
		
/*		long result = ParamUtil.getLong(request, "result");
		ESFPartecipantLocalServiceUtil.addESFPartecipant(
			serviceContext.getUserId(), esfUserId, esfMatchId, esfTeamId, ct,
			esfPartecipantTypeId, result, serviceContext);
		
			
		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfShooter.jsp");

		}
		else{
			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");
		}*/

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		response.setRenderParameter(
			"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");
		/*response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");	*/

	}

	public void updateESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfPartecipantId = ParamUtil.getLong(request, "esfPartecipantId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		long esfTeamId = ParamUtil.getLong(request, "esfTeamId");
		long ct = ParamUtil.getLong(request, "ct");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long result = ParamUtil.getLong(request, "result");

		ESFPartecipantLocalServiceUtil.updateESFPartecipant(
			serviceContext.getUserId(), esfPartecipantId, esfUserId,
			esfMatchId, esfTeamId, ct, esfPartecipantTypeId, result,
			serviceContext);

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.STAFF) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");

		}


		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
	}

	public void updateMultiESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long[] esfUserId = ParamUtil.getLongValues(request, "esfUserId");
		long[] esfPartecipantId =
			ParamUtil.getLongValues(request, "esfPartecipantId");
		long[] esfTeamId = ParamUtil.getLongValues(request, "esfTeamId");
		long[] ct = ParamUtil.getLongValues(request, "ct");
		long[] result = ParamUtil.getLongValues(request, "result");

		for (int i = 0; i < esfUserId.length; i++) {

			ESFPartecipantLocalServiceUtil.updateESFPartecipant(
				serviceContext.getUserId(), esfPartecipantId[i], esfUserId[i],
				esfMatchId, esfTeamId[i], ct[i], esfPartecipantTypeId,
				result[i], serviceContext);
		}

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.STAFF) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfCT.jsp");

		}
		
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
	}
	
	public void refusal(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		
		_log.debug("-1-");
		
		long delegationId =
						ParamUtil.getLong(request, "delegationId");
		long instructId =
						ParamUtil.getLong(request, "instructId");
		String refusalMotivation = ParamUtil.getString(request, "refusalMotivation");
		String refusalString = ParamUtil.getString(request, "refusalDate");
		Date refusalDate = null;
		
		try {
			refusalDate = ManageDate.StringToDate(refusalString);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		_log.debug("-1-delegationId="+delegationId);
		_log.debug("-1-instruct="+instructId);
		_log.debug("-1-refusalMotivation="+refusalMotivation);
		_log.debug("-1-refusalString="+refusalString);
		_log.debug("-1-refusalDate="+refusalDate);
		
		ESFNationalDelegation delegation = ESFNationalDelegationLocalServiceUtil.fetchESFNationalDelegation(delegationId);
		
		_log.debug("-1-delegation="+delegation);
		
		delegation.setRefusalDate(refusalDate);
		delegation.setRefusal(refusalMotivation);
		delegation.setTaskId(instructId);
		
		ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(delegation);
		
		_log.debug("-2-delegation="+delegation);
		
		response.setRenderParameter(
			"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");
		
	}

	public void deleteESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long esfPartecipantId = ParamUtil.getLong(request, "esfPartecipantId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long delId = ParamUtil.getLong(request, "delId");

		/*ESFPartecipantLocalServiceUtil.deleteESFPartecipant(
			esfPartecipantId, serviceContext);*/
		
		try {
			ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(delId);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfShooter.jsp");

		}
		else{
			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_staff.jsp");
		} /*if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnormalmatch/edit_esfDoctor.jsp");

		}*/

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));

	}

	private List<ESFTeam> getESFTeamsName(
		ActionRequest request, ActionResponse response, String numNameTeems) {

		List<ESFTeam> esfTeams = new ArrayList<ESFTeam>();
		int[] numNameTeemsIndexes = StringUtil.split(numNameTeems, 0);

		for (int numNameTeemsIndexe : numNameTeemsIndexes) {

			ESFTeam esfTeam = new ESFTeamImpl();

			String nameTeam =
				ParamUtil.getString(request, "nameTeam" + numNameTeemsIndexe);
			esfTeam.setName(nameTeam);

			esfTeams.add(esfTeam);
		}

		return esfTeams;
	}

	private boolean checkMaxMin(int maxnum, int minnum) {

		if (maxnum < minnum)
			return true;

		return false;
	}

	private long StringToLong(String value) {

		if (value != null && !value.equals(""))
			return Long.parseLong(value);

		else
			return 0;
	}

	/*
	 * Upload del file con le info relative alla gara e al punteggio del
	 * partecipante 
	 * */
	public void uploadCase(ActionRequest request, ActionResponse response)
				throws Exception {
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			
			ESFMatch match = new ESFMatchImpl();
			
			String sourceFileName = uploadRequest.getFileName("fileName");
			String title = ParamUtil.getString(request,"title");
			String message="File errato, verificare i dati di gara e file risultati";
			
			Long esfMatchId = ParamUtil.getLong(request,"esfMatchId");
			Long associationId = ParamUtil.getLong(request,"associationId");
			Long sptId = ParamUtil.getLong(request,"sptId");
			
			boolean isIndividual = false;
			
			File file = uploadRequest.getFile("fileName");
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			
			try {
				match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
				isIndividual = match.getIsIndividualMatch();
			}
			catch (Exception e) {
				// TODO: handle exception
			}

			if(sourceFileName.equalsIgnoreCase(title+"RI.TXT") && isIndividual){
				
				InsertResult insertResult = new InsertResult();
				insertResult.setRequest(request);
				insertResult.setResponse(response);
				insertResult.insertResult(bufferedReader, esfMatchId, associationId,sptId, isIndividual);
				
			}else if(sourceFileName.equalsIgnoreCase(title+"RT.TXT") && !isIndividual){
				
				InsertResult insertResult = new InsertResult();
				insertResult.setRequest(request);
				insertResult.setResponse(response);
				insertResult.insertResult(bufferedReader, esfMatchId, associationId,sptId, isIndividual);
				
			}else{
				
				SessionErrors.add(request, "errorMessage");
				request.setAttribute("ErrorMessage", message);
				
			}
			response.setRenderParameter("mvcPath", ParamUtil.getString(request, "mvcPath"));
			response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId) );
			
	}
	
	public void uploadAllData(ActionRequest request, ActionResponse response)
					throws Exception {
		ExecuteUploadResult executeUpload = new ExecuteUploadResult();
		executeUpload.setRequest(request);
		executeUpload.setResponse(response);
		Thread t = new Thread(executeUpload);
		t.run();
	}
	
	public void editESFdescription(
			ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMatchTypePortlet.class.getName(), request);

			long esfDescriptionId = ParamUtil.getLong(request, "esfDescriptionId");
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			String name = ParamUtil.getString(request, "name");
			boolean isNational = ParamUtil.getBoolean(request, "isNational");
			if (esfDescriptionId > 0) {
				ESFDescriptionLocalServiceUtil.updateEsfDescription(
					esfDescriptionId, name, isNational, serviceContext);
			}
			else {
				ESFDescriptionLocalServiceUtil.addEsfDescription(
					name, isNational, serviceContext);
			}
			response.setRenderParameter("mvcPath", templatePath+"new_edit_esfMatch.jsp");
			response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId) );
		}
	
	public void editESFMatchType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMatchTypePortlet.class.getName(), request);
			
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
			String name = ParamUtil.getString(request, "name");
			boolean isCategoryQualification =
				ParamUtil.getBoolean(request, "isCategoryQualification");
			boolean isNational = ParamUtil.getBoolean(request, "isNational");
			
			if (esfMatchTypeId > 0) {

				ESFMatchTypeLocalServiceUtil.updateEsfMatchType(
					esfMatchTypeId, name, isCategoryQualification, isNational,
					 serviceContext);

			}
			else {

				ESFMatchTypeLocalServiceUtil.addEsfMatchType(
					name, isCategoryQualification, isNational,
					serviceContext);
			}
			
			response.setRenderParameter("mvcPath", templatePath+"new_edit_esfMatch.jsp");
			response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId) );

		}
	
	public void updateResult(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		
		/*Modalit� di sola lettura dei risultati (nella configurazione della portlet)
		 *se attivata non deve fare update dei risultati 
		 * */
		
		PortletPreferences prefs = request.getPreferences();
		boolean isViewMode = Boolean.valueOf(prefs.getValue("isViewMode", StringPool.TRUE));
		
		if(_log.isInfoEnabled()){
			_log.debug("view mode is set to : " + isViewMode);
		}
		if(isViewMode){
			
			SessionMessages.add(request, "errorUpdateResultPortletIsSetInViewMode");
			response.setRenderParameter("mvcPath", mvcPath);
			response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId));
			
			return;
		}
		
		List<ESFResult> results = new ArrayList<ESFResult>();
		results = ESFResultLocalServiceUtil.findByESFMatchid(esfMatchId);

		
		try{
			for(ESFResult r : results){
				
				ESFResult result = new ESFResultImpl();
				long resultId = r.getEsfResultId();
				
				result = ESFResultLocalServiceUtil.fetchESFResult(resultId);
				
				int finalTotal =  0;
				int totalS = 0;
				
				String card = ParamUtil.getString(request, "card"+resultId);
				int position =  ParamUtil.getInteger(request, "position"+resultId);
				int s1 =  ParamUtil.getInteger(request, "s1"+resultId);
				int s2 =  ParamUtil.getInteger(request, "s2"+resultId);
				int s3 =  ParamUtil.getInteger(request, "s3"+resultId);
				int s4 =  ParamUtil.getInteger(request, "s4"+resultId);
				int s5 =  ParamUtil.getInteger(request, "s5"+resultId);
				int s6 =  ParamUtil.getInteger(request, "s6"+resultId);
				int s7 =  ParamUtil.getInteger(request, "s7"+resultId);
				int s8 =  ParamUtil.getInteger(request, "s8"+resultId);
				int finalS =  ParamUtil.getInteger(request, "finalS"+resultId);
				int barrage =  ParamUtil.getInteger(request, "barrage"+resultId);
				int american1 =  ParamUtil.getInteger(request, "american1"+resultId);
				int american2 =  ParamUtil.getInteger(request, "american2"+resultId);
				int american3 =  ParamUtil.getInteger(request, "american3"+resultId);
				String rifle = ParamUtil.getString(request, "rifle"+resultId);
				String catridge = ParamUtil.getString(request, "catridge"+resultId);
				String caliber = ParamUtil.getString(request, "caliber"+resultId);
				
				totalS = s1+ s2 + s3 + s4 + s5 + s6 +s7 + s8;
				
				finalTotal = totalS + finalS;
				
				result.setCardNumber(card);
				result.setPosition(position);
				result.setResultS1(s1);
				result.setResultS2(s2);
				result.setResultS3(s3);
				result.setResultS4(s4);
				result.setResultS5(s5);
				result.setResultS6(s6);
				result.setResultS7(s7);
				result.setResultS8(s8);
				result.setTotalS(totalS);
				result.setBarrage(barrage);
				result.setFinalS(finalS);
				result.setFinalTotal(finalTotal);
				result.setAmerican1(american1);
				result.setAmerican2(american2);
				result.setAmerican3(american3);
				result.setRifle(rifle);
				result.setCatridge(catridge);
				result.setCaliber(caliber);
				
				ESFResultLocalServiceUtil.updateESFResult(result);
				
			}
		}
		catch(Exception e){
			SessionErrors.add(request, "errorUpdateResult");
			e.printStackTrace();
			
		}
		
		SessionMessages.add(request, "succesUpdateResult");
		
		response.setRenderParameter("mvcPath", mvcPath);
		response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId) );
		
	}
	
	private Log _log = LogFactoryUtil.getLog(ESFNormalMatchPortlet.class);
}

