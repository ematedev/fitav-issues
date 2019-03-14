
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFTeam;
import it.ethica.esf.model.ESFTournament;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFTeamImpl;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFTournamentLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFReportUtil;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryFinderUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class ESFTournament
 */
public class ESFTournamentPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

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

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

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
				System.out.println("ScopeGroupId: " +
					serviceContext.getUserId());
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
	}
/*
	public void checkDocumentESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws SystemException, PortalException, ParseException,
		DocumentException {

		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		List<ESFUser> esfUsers = new ArrayList<ESFUser>();

		esfUsers =
			ESFUserLocalServiceUtil.findNationalPartecipantShooters(
				esfTournamentId, esfMatchId, true);

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);

		List<DLFileEntry> dlFileEntrys =
			DLFileEntryLocalServiceUtil.getFileEntries(-1, -1);

		for (ESFUser esfUser : esfUsers) {

			for (DLFileEntry dlFileEntry : dlFileEntrys) {

				DLFileEntryType dlFileEntryType =
					DLFileEntryTypeLocalServiceUtil.fetchDLFileEntryType(dlFileEntry.getFileEntryTypeId());
		
				TrashEntry trashEntry = TrashEntryLocalServiceUtil.fetchEntry(
					DLFileEntry.class.getName(), dlFileEntry.getFileEntryId());

				if (trashEntry == null) {

					Document document = SAXReaderUtil.read(dlFileEntryType.getName());
					Node node = document.selectSingleNode("/root/Name");
					String typeOfDoc = node.getText();

					if (esfUser.getEsfUserId() == dlFileEntry.getUserId() &&
						typeOfDoc.equalsIgnoreCase(ESFKeys.FileCostant.ENTRYTYPE_1)) {

						long fvId =
							dlFileEntry.getLatestFileVersion(true).getFileVersionId();

						Map<String, Fields> map =
							dlFileEntry.getFieldsMap(fvId);

						Iterator<Entry<String, Fields>> iter =
							map.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry<String, Fields> entry = iter.next();

							Iterator fields = entry.getValue().iterator();

							while (fields.hasNext()) {
								Field f = (Field) fields.next();

								if (f.getName().equalsIgnoreCase(
									ESFKeys.FileCostant.CUSTOMFIELD_2)) {

									System.out.println("FILE : " + dlFileEntry.getFileEntryId());
									String dateString = f.getValue() + "";
 									Date date = ManageDate.StringToDate( dateString, new SimpleDateFormat(
												"EEE MMM dd HH:mm:ss Z yyyy", LocaleUtil.ENGLISH));
									Calendar cal = ManageDate.DateToCalendar(date);
								
									String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
									System.out.println("formatedDate : " + formatedDate);

									// ############ USE checkDate();
									if (checkDate(cal, typeOfDoc)) {
										
										//	############ Use logic for calling email.
										
									}

								}

							}
						}

					}
				}

			}

		}

		// DLFileEntry dlFileEntrie =
		// DLFileEntryLocalServiceUtil.fetchDLFileEntry(43829);
		// for(ESFUser esfUser : esfUsers){
		// for(DLFileEntry dlFileEntrie : dlFileEntries){

		// if(dlFileEntrie.getUserId() == esfUser.getEsfUserId()){

		// }

		// }
		// }

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));

		response.setRenderParameter("mvcPath", templatePath + "match/view.jsp");
	}
*/
	public void addESFTournament(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFTournamentPortlet.class.getName(), request);

		String title = ParamUtil.getString(request, "title");
		String description = ParamUtil.getString(request, "description");
		int maxnum = ParamUtil.getInteger(request, "maxnum");
		int minnum = ParamUtil.getInteger(request, "minnum");
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		boolean isSingleMatch = ParamUtil.getBoolean(request, "isSingleMatch");
		boolean isTeamMatch = ParamUtil.getBoolean(request, "isTeamMatch");
		// boolean isNational = ParamUtil.getBoolean(request, "isNational");
		boolean isFinal = ParamUtil.getBoolean(request, "isFinal");
		boolean isIndividualMatch =
			ParamUtil.getBoolean(request, "isIndividualMatch");
		boolean isJuniorMatch = ParamUtil.getBoolean(request, "isJuniorMatch");
		long[] esfShooterQualificationIds =
			ParamUtil.getLongValues(request, "esfShooterQualificationIds");
		long[] esfShooterCategoryIds =
			ParamUtil.getLongValues(request, "esfShooterCategoryIds");

		Date startDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "startDate"));
		// ParamUtil.getDate(request, "startDate", new SimpleDateFormat(
		// "dd/MM/yyyy"));
		Date endDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "endDate"));
		// ParamUtil.getDate(request, "endDate", new SimpleDateFormat(
		// "dd/MM/yyyy"));

		List<ESFTeam> esfTeams = new ArrayList<ESFTeam>();

		if (checkMaxMin(maxnum, minnum)) {

			SessionErrors.add(request, "tournament-maxminnum-message");

		}
		else {
			if (isTeamMatch) {

				String numNameTeems =
					ParamUtil.getString(request, "esfTeamIndexes");

				esfTeams = getESFTeamsName(request, response, numNameTeems);

			}

			ESFEntityState esfEntityState = new ESFEntityStateImpl();
			esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

			ESFTournamentLocalServiceUtil.addESFTournament(
				serviceContext.getUserId(), esfOrganizationId, title,
				description, maxnum, minnum, isSingleMatch, isTeamMatch, true,
				isIndividualMatch, isJuniorMatch, isFinal,
				esfShooterCategoryIds, esfShooterQualificationIds, startDate,
				endDate, esfTeams, esfEntityState, serviceContext);

			SessionMessages.add(request, "tournament-success-insertupdate");
		}
	}

	public void updateESFTournament(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFTournamentPortlet.class.getName(), request);

		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		String title = ParamUtil.getString(request, "title");
		String description = ParamUtil.getString(request, "description");
		int maxnum = ParamUtil.getInteger(request, "maxnum");
		int minnum = ParamUtil.getInteger(request, "minnum");
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		boolean isSingleMatch = ParamUtil.getBoolean(request, "isSingleMatch");
		boolean isTeamMatch = ParamUtil.getBoolean(request, "isTeamMatch");
		boolean isFinal = ParamUtil.getBoolean(request, "isFinal");
		boolean isIndividualMatch =
			ParamUtil.getBoolean(request, "isIndividualMatch");
		boolean isJuniorMatch = ParamUtil.getBoolean(request, "isJuniorMatch");
		boolean isRoot = ParamUtil.getBoolean(request, "isRoot");
		long[] esfShooterQualificationIds =
			ParamUtil.getLongValues(request, "esfShooterQualificationIds");
		long[] esfShooterCategoryIds =
			ParamUtil.getLongValues(request, "esfShooterCategoryIds");

		Date startDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "startDate"));
		Date endDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "endDate"));

		List<ESFTeam> esfTeams = new ArrayList<ESFTeam>();

		int checkDateMatch = 0;

		List<ESFMatch> esfMatchs =null;
		//	esfMatchs =ESFMatchLocalServiceUtil.findESFMatchsByT_S(
		//		esfTournamentId, ESFKeys.ESFStateType.ENABLE);

		for (ESFMatch esfMatch : esfMatchs) {

			if (!esfMatch.getStartDate().equals(startDate) &&
				!esfMatch.getStartDate().equals(endDate) &&
				!(esfMatch.getStartDate().after(startDate) && esfMatch.getStartDate().before(
					endDate))) {

				checkDateMatch++;
			}

		}

		List<ESFPartecipant> esfPartecipants =
			ESFPartecipantLocalServiceUtil.findPartecipantsByTournament(esfTournamentId);

		if (!esfPartecipants.isEmpty()) {

			SessionErrors.add(request, "partecipant-already-assigned-message");

		}
		else if (checkDateMatch > 0) {

			SessionErrors.add(request, "date-torunament-message");

		}
		else if (checkMaxMin(maxnum, minnum)) {

			SessionErrors.add(request, "tournament-maxminnum-message");

		}
		else {

			if (isTeamMatch) {

				String numNameTeems =
					ParamUtil.getString(request, "esfTeamIndexes");

				esfTeams = getESFTeamsName(request, response, numNameTeems);

			}

			ESFEntityState esfEntityState = new ESFEntityStateImpl();
			esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

			ESFTournamentLocalServiceUtil.updateESFTournament(
				serviceContext.getUserId(), esfTournamentId, esfOrganizationId,
				title, description, maxnum, minnum, isSingleMatch, isTeamMatch,
				isRoot, isIndividualMatch, isJuniorMatch, isFinal,
				esfShooterCategoryIds, esfShooterQualificationIds, startDate,
				endDate, esfTeams, esfEntityState, serviceContext);

			SessionMessages.add(request, "tournament-success-insertupdate");
		}
	}

	public void deleteESFTournament(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFTournament.class.getName(), request);

		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");

		List<ESFPartecipant> esfPartecipants =
			ESFPartecipantLocalServiceUtil.findPartecipantsByTournament(esfTournamentId);

		if (!esfPartecipants.isEmpty()) {

			SessionErrors.add(request, "partecipant-already-assigned-message");

		}
		else {
			ESFTournamentLocalServiceUtil.deleteESFTournament(
				esfTournamentId, serviceContext);

			SessionMessages.add(request, "deleteESFTournament");
		}
	}

	public void addESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);

		long description = ParamUtil.getLong(request, "description");
		String note = ParamUtil.getString(request, "notes");
		boolean isDraft = ParamUtil.getBoolean(request, "isDraft");
		long esfAssociationId = ParamUtil.getLong(request, "esfAssociationId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeid");
		Date startDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "startDate"));
		Date endDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "endDate"));
		String startHour = ParamUtil.getString(request, "startHour");
		int numDisk = ParamUtil.getInteger(request, "numDisk");
		int numFields = ParamUtil.getInteger(request, "numFields");

		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

		ESFTournament esfTournament =
			ESFTournamentLocalServiceUtil.fetchESFTournament(esfTournamentId);

		int checkDateMatch = 0;

		if (!startDate.equals(esfTournament.getStartDate()) &&
			!startDate.equals(esfTournament.getEndDate()) &&
			!(startDate.after(esfTournament.getStartDate()) && startDate.before(esfTournament.getEndDate()))) {

			checkDateMatch++;
		}

		if (checkDateMatch > 0) {

			SessionErrors.add(request, "date-torunament-message");

		}
		else if (startDate.after(endDate)) {

			SessionErrors.add(request, "date-message");

		}
		else {
			/*
			ESFMatchLocalServiceUtil.addESFMatch(
				serviceContext.getUserId(), esfTournamentId, esfAssociationId,
				esfFieldId, esfSportTypeId, numDisk, startDate, endDate,
				numFields, startHour, isDraft, description, note, false,
				esfEntityState, serviceContext);
			 */
			SessionMessages.add(request, "match-success-insertupdate");
		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("mvcPath", templatePath + "match/view.jsp");
	}

	public void updateESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);

		long description = ParamUtil.getLong(request, "description");
		String note = ParamUtil.getString(request, "notes");
		boolean isDraft = ParamUtil.getBoolean(request, "isDraft");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfAssociationId = ParamUtil.getLong(request, "esfAssociationId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		long esfFieldId = ParamUtil.getLong(request, "esfFieldId");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeid");
		Date startDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "startDate"));
		Date endDate =
			ManageDate.StringToDate(ParamUtil.getString(request, "endDate"));
		String startHour = ParamUtil.getString(request, "startHour");
		int numDisk = ParamUtil.getInteger(request, "numDisk");
		int numFields = ParamUtil.getInteger(request, "numFields");

		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

		ESFTournament esfTournament =
			ESFTournamentLocalServiceUtil.fetchESFTournament(esfTournamentId);

		int checkDateMatch = 0;

		if (!startDate.equals(esfTournament.getStartDate()) &&
			!startDate.equals(esfTournament.getEndDate()) &&
			!(startDate.after(esfTournament.getStartDate()) && startDate.before(esfTournament.getEndDate()))) {

			checkDateMatch++;
		}

		if (checkDateMatch > 0) {

			SessionErrors.add(request, "date-torunament-message");

		}
		else if (startDate.after(endDate)) {

			SessionErrors.add(request, "date-message");

		}
		else {
			/*
			ESFMatchLocalServiceUtil.updateESFMatch(
				serviceContext.getUserId(), esfMatchId, esfTournamentId,
				esfAssociationId, esfFieldId, esfSportTypeId, startDate,
				endDate, numFields, startHour, numDisk, isDraft, description,
				note, false, esfEntityState, serviceContext);
			 */
			SessionMessages.add(request, "match-success-insertupdate");
		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("mvcPath", templatePath + "match/view.jsp");
	}

	public void deleteESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);

		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");

		// boolean isNational = ParamUtil.getBoolean(request, "isNational");

		List<ESFPartecipant> esfPartecipants =
			ESFPartecipantLocalServiceUtil.findPartecipantsByMatch(esfMatchId);

		if (!esfPartecipants.isEmpty()) {

			SessionErrors.add(request, "partecipant-already-assigned-message");

		}
		else {
			ESFMatchLocalServiceUtil.deleteESFMatch(esfMatchId, serviceContext);

			SessionMessages.add(request, "deleteESFMatch");
		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("mvcPath", templatePath + "match/view.jsp");
	}

	/*
	public void addESFNationalDelegation(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFNationalDelegation.class.getName(), request);

		long[] esfUserRequestIds =
			ParamUtil.getLongValues(request, "checkDelegateCheckbox");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		String className = ParamUtil.getString(request, "className");
		long classPK = ParamUtil.getLong(request, "classPK");

		for (long esfUserRequestId : esfUserRequestIds) {

			long esfUserId = 0;

			if (className.equals(ESFNational.class.getName())) {

				ESFNational esfNational =
					ESFNationalLocalServiceUtil.getESFNational(esfUserRequestId);

				esfUserId = esfNational.getEsfUserId();
			}
			else if (className.equals(ESFUserRole.class.getName())) {

				esfUserId = esfUserRequestId;
			}

			ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation(
				serviceContext.getUserId(), esfTournamentId, esfUserId,
				className, classPK, serviceContext);
		}

		response.setRenderParameter(
			"mvcPath", "/html/esftournament/delegation/view.jsp");
		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
	}

	public void updateESFNationalDelegation(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFNationalDelegation.class.getName(), request);

		DateFormat dateFormat =
			DateFormatFactoryUtil.getDate(serviceContext.getLocale());

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		String className = ParamUtil.getString(request, "className");
		long classPK = ParamUtil.getLong(request, "classPK");

		Date leaveDate = ParamUtil.getDate(request, "leaveDate", dateFormat);
		Date returnDate = ParamUtil.getDate(request, "returnDate", dateFormat);
		long esfGunId1 = ParamUtil.getLong(request, "esfGunId1");
		long esfGunId2 = ParamUtil.getLong(request, "esfGunId2");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");

		ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(
			serviceContext.getUserId(), esfTournamentId, esfUserId, leaveDate,
			returnDate, className, classPK, esfSportTypeId, esfGunId1,
			esfGunId2, serviceContext);

		response.setRenderParameter(
			"mvcPath", "/html/esftournament/delegation/view.jsp");
		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
	}

	public void deleteESFNationalDelegation(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");

		ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(
			esfTournamentId, esfUserId);

		response.setRenderParameter(
			"mvcPath", "/html/esftournament/delegation/view.jsp");
		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
	}

	*/

	public void addESFPartecipant(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		// boolean isNational = ParamUtil.getBoolean(request, "isNational");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
		long esfTeamId = ParamUtil.getLong(request, "esfTeamId");
		long ct = ParamUtil.getLong(request, "ct");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long result = ParamUtil.getLong(request, "result");

		ESFPartecipantLocalServiceUtil.addESFPartecipant(
			serviceContext.getUserId(), esfUserId, esfMatchId, esfTeamId, ct,
			esfPartecipantTypeId, result, serviceContext);

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfDoctor.jsp");

		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));

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
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");
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
				"mvcPath", "/html/esftournament/match/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfDoctor.jsp");

		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
	}

	public void updateMultiESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		// boolean isNational = ParamUtil.getBoolean(request, "isNational");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");

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
				"mvcPath", "/html/esftournament/match/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfDoctor.jsp");

		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
	}

	public void deleteESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		// boolean isNational = ParamUtil.getBoolean(request, "isNational");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long esfPartecipantId = ParamUtil.getLong(request, "esfPartecipantId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTournamentId = ParamUtil.getLong(request, "esfTournamentId");

		ESFPartecipantLocalServiceUtil.deleteESFPartecipant(
			esfPartecipantId, serviceContext);

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esftournament/match/edit_esfDoctor.jsp");

		}

		response.setRenderParameter(
			"esfTournamentId", String.valueOf(esfTournamentId));
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

	private boolean checkDate(Calendar dateToCheck, String typeOfDoc) {

		//########## HERE, INSERT PATTERN TO CHECK THE DATE

		return true;
	}
}
