package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.ESFSuspensiveShootingDirector;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFNationalDelegationImpl;
import it.ethica.esf.model.impl.ESFShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.util.ManageDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ESFShootingDirectorPortlet extends MVCPortlet{
	
	public void addShooterDirector (ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		ESFUser user = new ESFUserImpl();
		
		List<ESFAddress> esfAddresses = new ArrayList<ESFAddress>();
		ESFShootingDirector shDts = new ESFShootingDirectorImpl();
		ESFShootingDirector newShDts = new ESFShootingDirectorImpl();
		
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		long shDtId = ParamUtil.getLong(actionRequest, "shDtId");
		long stId = ParamUtil.getLong(actionRequest, "stId");
		
		String startDateS = ParamUtil.getString(actionRequest, "startDate");
		String regionId = "";
		String provinceId = "";
		
		String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		
		Date startDate = null;
		
		try {
			startDate = ManageDate.StringToDate(startDateS);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		
		shDts = ESFShootingDirectorLocalServiceUtil.findedShDr(esfUserId, shDtId, stId);
		

		
		if(Validator.isNotNull(shDts)){
			actionResponse.setRenderParameter("mvcPath", mvcPath);
			actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			SessionErrors.add(actionRequest, "findingOld");
			return ;
		}
		
		user = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
		
		esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), ESFUser.class.getName(), esfUserId);
		
		if(!esfAddresses.isEmpty()){
			if(Validator.isNotNull(esfAddresses.get(0).getEsfRegionId())){
				regionId = esfAddresses.get(0).getEsfRegionId();
			}
			
			if(Validator.isNotNull(esfAddresses.get(0).getEsfProvinceId())){
				provinceId = esfAddresses.get(0).getEsfProvinceId();
			}
		}
		
		long esfshDtId = CounterLocalServiceUtil.increment(ESFShootingDirector.class.getName());
		
		newShDts.setEsfShootingDirectorId(esfshDtId);
		newShDts.setEsfStartData(startDate);
		newShDts.setEsfUserId(esfUserId);
		newShDts.setProvinceId(provinceId);
		newShDts.setRegionId(regionId);
		newShDts.setSportTypeId(stId);
		newShDts.setShootingDirectorQualificationId(shDtId);
		
		ESFShootingDirectorLocalServiceUtil.updateESFShootingDirector(newShDts);
		
		actionResponse.setRenderParameter("mvcPath", "/html/esfshootingdirector/view.jsp");
	}
	
	public void deleteESFShdr (ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		ESFShootingDirector shDt = new ESFShootingDirectorImpl();
		long shDrId = ParamUtil.getLong(actionRequest, "shDrId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		String mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		
		if(StringPool.BLANK.equals(mvcPath)){
			mvcPath = "/html/esfshootingdirector/view.jsp";
		}
		
		if(0 < shDrId){
			shDt = ESFShootingDirectorLocalServiceUtil.fetchESFShootingDirector(shDrId);
			ESFShootingDirectorLocalServiceUtil.deleteESFShootingDirector(shDt);
		}else {
			SessionErrors.add(actionRequest, "error-delete-shDr");
		}
		
		actionResponse.setRenderParameter("esfUserId",String.valueOf(esfUserId) );
		actionResponse.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void updateSuspensive (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException {
		
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfSuspensionId = ParamUtil.getLong(request, "esfSuspensionId");
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		
		ESFSuspensiveShootingDirector suspensive = new ESFSuspensiveShootingDirectorImpl();
		
		String sd = ParamUtil.getString(request, "startDate");
		String ed = ParamUtil.getString(request, "endDate");
		String note = ParamUtil.getString(request, "note");
		
		long suspensiveCode =  ParamUtil.getLong(request, "suspensiveCode");
		
		String[] valuesInstructsSospensions = ParamUtil.getParameterValues(request, "valuesInstructsSospensions", new String[0]);
		String[] valuesMatchSospensions = ParamUtil.getParameterValues(request, "valuesMatchSospensions", new String[0]);
		
		try {
			if(0 < esfSuspensionId){
				suspensive = ESFSuspensiveShootingDirectorLocalServiceUtil.fetchESFSuspensiveShootingDirector(esfSuspensionId);
				
				suspensive.setQualif1_Utiliz(0);
				suspensive.setQualif2_Utiliz(0);
				suspensive.setQualif3_Utiliz(0);
				
				suspensive.setTipo_Gara1_noUtil(0);
				suspensive.setTipo_Gara2_noUtil(0);
				suspensive.setTipo_Gara3_noUtil(0);
				suspensive.setTipo_Gara4_noUtil(0);
				suspensive.setTipo_Gara5_noUtil(0);
				suspensive.setTipo_Gara6_noUtil(0);
				suspensive.setTipo_Gara7_noUtil(0);
				suspensive.setTipo_Gara8_noUtil(0);
				suspensive.setTipo_Gara9_noUtil(0);
				suspensive.setTipo_Gara10_noUtil(0);
				
				if( 1 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
				}else if(2 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
				}else if(3 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
					suspensive.setQualif3_Utiliz(Long.valueOf(valuesInstructsSospensions[2]));
				}
				
				
				if( 1 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
				}else if(2 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					
				}else if(3 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					
				}else if(4 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					
				}else if(5 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					
				}else if(6 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					
				}else if(7 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					
				}else if(8 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					
				}else if(9 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
				}else if(10 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
					suspensive.setTipo_Gara10_noUtil(Long.valueOf(valuesMatchSospensions[9]));
				}
				
				suspensive.setNote(note);
				suspensive.setCodice_Sosp(suspensiveCode);
				suspensive.setEsfUserId(esfUserId);
				suspensive.setEsfStartData(ManageDate.StringToDate(sd));
				suspensive.setEsfEndData(ManageDate.StringToDate(ed));
				
				ESFSuspensiveShootingDirectorLocalServiceUtil.updateESFSuspensiveShootingDirector(suspensive);
			}else{
				long esfsuspId = CounterLocalServiceUtil.increment(ESFSuspensiveShootingDirector.class.getName());
				
				if( 1 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
				}else if(2 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
				}else if(3 == valuesInstructsSospensions.length){
					suspensive.setQualif1_Utiliz(Long.valueOf(valuesInstructsSospensions[0]));
					suspensive.setQualif2_Utiliz(Long.valueOf(valuesInstructsSospensions[1]));
					suspensive.setQualif3_Utiliz(Long.valueOf(valuesInstructsSospensions[2]));
				}
				
				
				if( 1 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
				}else if(2 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					
				}else if(3 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					
				}else if(4 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					
				}else if(5 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					
				}else if(6 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					
				}else if(7 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					
				}else if(8 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					
				}else if(9 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
				}else if(10 == valuesMatchSospensions.length){
					suspensive.setTipo_Gara1_noUtil(Long.valueOf(valuesMatchSospensions[0]));
					suspensive.setTipo_Gara2_noUtil(Long.valueOf(valuesMatchSospensions[1]));
					suspensive.setTipo_Gara3_noUtil(Long.valueOf(valuesMatchSospensions[2]));
					suspensive.setTipo_Gara4_noUtil(Long.valueOf(valuesMatchSospensions[3]));
					suspensive.setTipo_Gara5_noUtil(Long.valueOf(valuesMatchSospensions[4]));
					suspensive.setTipo_Gara6_noUtil(Long.valueOf(valuesMatchSospensions[5]));
					suspensive.setTipo_Gara7_noUtil(Long.valueOf(valuesMatchSospensions[6]));
					suspensive.setTipo_Gara8_noUtil(Long.valueOf(valuesMatchSospensions[7]));
					suspensive.setTipo_Gara9_noUtil(Long.valueOf(valuesMatchSospensions[8]));
					suspensive.setTipo_Gara10_noUtil(Long.valueOf(valuesMatchSospensions[9]));
				}
				
				suspensive.setNote(note);
				suspensive.setCodice_Sosp(suspensiveCode);
				suspensive.setEsfUserId(esfUserId);
				suspensive.setEsfStartData(ManageDate.StringToDate(sd));
				suspensive.setEsfEndData(ManageDate.StringToDate(ed));
				suspensive.setEsfSuspensiveShooingDirectorId(esfsuspId);
				ESFSuspensiveShootingDirectorLocalServiceUtil.addESFSuspensiveShootingDirector(suspensive);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "error-updateSuspensive");
		}
		
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId) );
		response.setRenderParameter("mvcPath", mvcPath);
		
	}
	
	public void deleteSospensive (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException {
		
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfSuspensionId = ParamUtil.getLong(request, "esfSuspensionId");
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		
		ESFSuspensiveShootingDirector suspensive = new ESFSuspensiveShootingDirectorImpl();
		
		try {
			suspensive = ESFSuspensiveShootingDirectorLocalServiceUtil.fetchESFSuspensiveShootingDirector(esfSuspensionId);
			ESFSuspensiveShootingDirectorLocalServiceUtil.deleteESFSuspensiveShootingDirector(suspensive);
		}
		catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "error-deleteSospensive");
		}
		
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId) );
		response.setRenderParameter("mvcPath", mvcPath);
		
	}
	
	public void addShootingDirectorToMatch (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException {
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
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
			_log.error("errore nel match");
		}
		
		ESFNationalDelegation del = new ESFNationalDelegationImpl();
		long delId = CounterLocalServiceUtil.increment(ESFNationalDelegation.class.getName());
		
		try {
			
			suspensiveNum = ESFSuspensiveShootingDirectorLocalServiceUtil.findSuspensive(matchDate, esfUserId);

			if(0 < suspensiveNum){
				
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				response.setRenderParameter("mvcPath", "/html/esfshootingdirector/convocations.jsp");
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

		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("mvcPath", "/html/esfshootingdirector/convocations.jsp");
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFShootingDirectorPortlet.class);
}
