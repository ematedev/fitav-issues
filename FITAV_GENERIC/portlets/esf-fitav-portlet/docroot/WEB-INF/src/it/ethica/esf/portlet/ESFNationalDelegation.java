
package it.ethica.esf.portlet;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.AddressLocalService;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.lowagie.text.pdf.PdfCell;


import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.ESFShooterQualification;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFAddressImpl;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFCityImpl;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFGunTypeImpl;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFNationalImpl;
import it.ethica.esf.model.impl.ESFUserRoleImpl;
import it.ethica.esf.portlet.utility.MatchInfoCurriculum;
import it.ethica.esf.portlet.utility.ShooterUtility;

import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFNationalMatchResultLocalService;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;

/**
 * Portlet implementation class ESFNationalDelegation
 */
public class ESFNationalDelegation extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
		String from = ParamUtil.getString(request, "from");
		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();

		try {
			String op = ParamUtil.getString(request, "op");

			if (op.equals("chooseorg")) {
				esfJsonUtil.prepareJSONOrganizations(request, response);
				from = "from";
			}

		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		
		
		if (Validator.isNotNull(from)){
				super.render(request, response);
		}
		else {
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.render(request, response);
		}
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		boolean isCatridge = ParamUtil.getBoolean(httpReq, "isCatridge", false);
		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);
		boolean generateCurriculum = ParamUtil.getBoolean(resourceRequest, "generateCurriculum");
		
		String resourceID = resourceRequest.getResourceID();
		
		if(generateCurriculum){
			
			
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = ParamUtil.getLong(resourceRequest, "userId");
			
			try {
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				String shooterName = "";
				String birthDate= "";
				String birthCity = "";
				String job = "";
				String jobTitle = "";
				String rifle = "";
				String cane = "";
				String catridge = "";
				String soc = "";
				String olimpicCard = "";
				String cityS = "";
				String street = "";
				String region = "";
				String prov = "";
				String cardS = "";
				String guns = "";
				
				String regions;
				String provinces;
				String cities;
				
				
				ESFUser shooter = ESFUserLocalServiceUtil.fetchESFUser(userId);
				List<ESFgunUser> shooterRifles = new ArrayList<ESFgunUser>();
				List<ESFgunUser> shooterCanes = new ArrayList<ESFgunUser>();
				List<ESFgunUser> shooterCatridges = new ArrayList<ESFgunUser>();
				ESFCard card = new ESFCardImpl();
				
				if(Validator.isNotNull(ESFCardLocalServiceUtil.findActualUserCards(userId)) && 0< ESFCardLocalServiceUtil.findActualUserCards(userId).size() ){
					card =  ESFCardLocalServiceUtil.findActualUserCards(userId).get(0);
				}
				
				
				if(Validator.isNotNull(card) && Validator.isNotNull(card.getCode())){
					cardS = card.getCode();
				}
				/*
				List<ESFAddress> esfAdd = new ArrayList<ESFAddress>();
				ESFAddress add = new ESFAddressImpl();
				String className = ESFUser.class.getName();
				ESFCity city = new ESFCityImpl();
				esfAdd = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(),className , userId);
				add = esfAdd.get(0);*/
				
				
				shooterRifles = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(userId, ESFKeys.ESFGunType.RIFLE, 0, Integer.MAX_VALUE);
				shooterCanes = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(userId, ESFKeys.ESFGunType.CANE, 0, Integer.MAX_VALUE);
				shooterCatridges = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(userId, ESFKeys.ESFGunType.CATRIDGE, 0, Integer.MAX_VALUE);
				
				if(0 < shooterRifles.size() && Validator.isNotNull(shooterRifles) && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(shooterRifles.get(0).getEsfGunnTypeId()))){
					rifle = ESFGunTypeLocalServiceUtil.fetchESFGunType(shooterRifles.get(0).getEsfGunnTypeId()).getName();
				}
				if(0 < shooterCanes.size() && Validator.isNotNull(shooterCanes) && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(shooterCanes.get(0).getEsfGunnTypeId()))){
					cane = ESFGunTypeLocalServiceUtil.fetchESFGunType(shooterCanes.get(0).getEsfGunnTypeId()).getName();
				}
				if(0 < shooterCatridges.size() && Validator.isNotNull(shooterCatridges) && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(shooterCatridges.get(0).getEsfGunnTypeId()))){
					catridge = ESFGunTypeLocalServiceUtil.fetchESFGunType(shooterCatridges.get(0).getEsfGunnTypeId()).getName();
				}
				
				guns = "Fucile:   "+rifle +"        Canne:   "+cane +"      Cartucce:"   +catridge;
				
				if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getBirthcity())){
					birthCity = shooter.getBirthcity();
				}
				
				if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getJob())){
					job = shooter.getJob();
				}
				
				if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getIssfIdNumber())){
					olimpicCard = shooter.getIssfIdNumber();
				}
				
				if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getLastName()) &&
						Validator.isNotNull(shooter.getFirstName())){
					shooterName = shooter.getLastName().toUpperCase()+" "+shooter.getFirstName().toUpperCase();
				}
				
				List<Long> matchsId = new ArrayList<Long>();
				
				List<ESFResult> matchResults = new ArrayList<ESFResult>();
				matchResults = ESFResultLocalServiceUtil.findByESFShooterId(userId);
				
				List<ESFMatchType> matchTypes = new ArrayList<ESFMatchType>();
				matchTypes = ESFMatchTypeLocalServiceUtil.findAllByNational(true);
				
				long olimpicMTId = 0;
				long worldChampMTId = 0;
				long finalWorldCupMTId = 0;
				long worldCupMTId = 0;
				long europeanChampMTId = 0;
				long internationalChampMTId = 0;
				long italianChampMTId = 0;
				long finalItalianChampMTId = 0;
				long finalItalianCupMTId = 0;
				
				for(ESFMatchType mt : matchTypes){
					if("Olimpiadi".equalsIgnoreCase(mt.getName())){
						olimpicMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Campionato Del Mondo".equalsIgnoreCase(mt.getName())){
						worldChampMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Finale Coppa del Mondo".equalsIgnoreCase(mt.getName())){
						finalWorldCupMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Coppa Del Mondo".equalsIgnoreCase(mt.getName())){
						worldCupMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Campionato d'Europa".equalsIgnoreCase(mt.getName())){
						europeanChampMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Gara Internazionale".equalsIgnoreCase(mt.getName())){
						internationalChampMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Campionato Italiano".equalsIgnoreCase(mt.getName())){
						italianChampMTId = mt.getEsfMatchTypeId();
						continue;
					}
					if("Finale Campionato Italiano".equalsIgnoreCase(mt.getName())){
						finalItalianChampMTId = mt.getEsfMatchTypeId();
						continue;
					}
				}
				
				List<ESFSportType> sportTypes = new ArrayList<ESFSportType>();
				sportTypes = ESFSportTypeLocalServiceUtil.getNational(true);
				
				List<ESFResult> olimpicMatchs = new ArrayList<ESFResult>();
				List<ESFResult> worldChampMatchs = new ArrayList<ESFResult>();
				List<ESFResult> finalWorldCupMatchs = new ArrayList<ESFResult>();
				List<ESFResult> worldCupMatchs = new ArrayList<ESFResult>();
				List<ESFResult> europeanChampMatchs = new ArrayList<ESFResult>();
				List<ESFResult> internationalChampMatchs = new ArrayList<ESFResult>();
				List<ESFResult> italianChampMatchs = new ArrayList<ESFResult>();
				List<ESFResult> finalItalianChampMatchs = new ArrayList<ESFResult>();
				List<ESFResult> finalItalianCupMatchs = new ArrayList<ESFResult>();
				
				for(ESFResult mr : matchResults){
					
					ESFMatch match = new ESFMatchImpl();
					match = ESFMatchLocalServiceUtil.fetchESFMatch(mr.getEsfMatchId());
					
					if(Validator.isNotNull(match)){
						if(olimpicMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							olimpicMatchs.add(mr);
							continue;
						}
						if(worldChampMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							worldChampMatchs.add(mr);
							continue;
						}
						if(finalWorldCupMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							finalWorldCupMatchs.add(mr);
							continue;
						}
						if(worldCupMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							worldCupMatchs.add(mr);
							continue;
						}
						if(europeanChampMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							europeanChampMatchs.add(mr);
							continue;
						}
						if(internationalChampMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							internationalChampMatchs.add(mr);
							continue;
						}
						if(italianChampMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							italianChampMatchs.add(mr);
							continue;
						}
						if(finalItalianChampMTId == match.getEsfMatchTypeId() && mr.getPosition() <= 3){
							finalItalianChampMatchs.add(mr);
							continue;
						}
					}
				}
				/*Long sptIdqId[] = new Long[2];
				
				HashMap<ESFMatch, Long[]> goldOlimpicMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverOlimpicMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeOlimpicMatchs = new HashMap<ESFMatch, Long[]>();
				----------------------------------------------------------------------------------
				HashMap<ESFMatch, Long[]> goldWorldChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverWorldChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeWorldChampMatchs = new HashMap<ESFMatch, Long[]>();
				----------------------------
				HashMap<ESFMatch, Long[]> goldFinalWorldCupMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverFinalWorldCupMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeFinalWorldCupMatchs = new HashMap<ESFMatch, Long[]>();
				-------------------------
				HashMap<ESFMatch, Long[]> goldWorldCupMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverWorldCupMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeWorldCupMatchs = new HashMap<ESFMatch, Long[]>();
				------------------------
				HashMap<ESFMatch, Long[]> goldEuropeanChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverEuropeanChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeEuropeanChampMatchs = new HashMap<ESFMatch, Long[]>();
				-------------------------
				HashMap<ESFMatch, Long[]> goldInternationalChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverInternationalChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeInternationalChampMatchs = new HashMap<ESFMatch, Long[]>();
				------------------------
				HashMap<ESFMatch, Long[]> goldItalianChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverItalianChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeItalianChampMatchs = new HashMap<ESFMatch, Long[]>();
				-----------------------
				HashMap<ESFMatch, Long[]> goldFinalItalianChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> silverFinalItalianChampMatchs = new HashMap<ESFMatch, Long[]>();
				HashMap<ESFMatch, Long[]> bronzeFinalItalianChampMatchs = new HashMap<ESFMatch, Long[]>();*/
				
				
				ArrayList<MatchInfoCurriculum> goldOlimpicMatchs = new ArrayList<MatchInfoCurriculum>();
				ArrayList<MatchInfoCurriculum> silverOlimpicMatchs = new ArrayList<MatchInfoCurriculum>();
				ArrayList<MatchInfoCurriculum> bronzeOlimpicMatchs = new ArrayList<MatchInfoCurriculum>();
				
				ArrayList<MatchInfoCurriculum> goldWorldChampMatchs = new ArrayList<MatchInfoCurriculum>();
				ArrayList<MatchInfoCurriculum> silverWorldChampMatchs = new ArrayList<MatchInfoCurriculum>();
				ArrayList<MatchInfoCurriculum> bronzeWorldChampMatchs = new ArrayList<MatchInfoCurriculum>();
				
				ArrayList<MatchInfoCurriculum>  goldFinalWorldCupMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  silverFinalWorldCupMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  bronzeFinalWorldCupMatchs = new ArrayList<MatchInfoCurriculum> ();
				
				ArrayList<MatchInfoCurriculum>  goldWorldCupMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  silverWorldCupMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  bronzeWorldCupMatchs = new ArrayList<MatchInfoCurriculum> ();
				
				ArrayList<MatchInfoCurriculum>  goldEuropeanChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  silverEuropeanChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  bronzeEuropeanChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				
				ArrayList<MatchInfoCurriculum>  goldInternationalChampMatchs =new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  silverInternationalChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  bronzeInternationalChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				
				ArrayList<MatchInfoCurriculum>  goldItalianChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  silverItalianChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  bronzeItalianChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				
				ArrayList<MatchInfoCurriculum>  goldFinalItalianChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  silverFinalItalianChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				ArrayList<MatchInfoCurriculum>  bronzeFinalItalianChampMatchs = new ArrayList<MatchInfoCurriculum> ();
				
				
				
				
				for(ESFResult omr : olimpicMatchs){
					if(1 == omr.getPosition() ){
						
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldOlimpicMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverOlimpicMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeOlimpicMatchs.add(results);
					}
				}
				
				for(ESFResult omr : worldChampMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldWorldChampMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverWorldChampMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeWorldChampMatchs.add(results);
					}
				}
				
				for(ESFResult omr : finalWorldCupMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldFinalWorldCupMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverFinalWorldCupMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeFinalWorldCupMatchs.add(results);
					}
				}
				
				for(ESFResult omr : worldCupMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldWorldCupMatchs.add(results);
						
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverWorldCupMatchs.add(results);
						
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeWorldCupMatchs.add(results);
					}
				}
				
				for(ESFResult omr : europeanChampMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldEuropeanChampMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverEuropeanChampMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeEuropeanChampMatchs.add(results);
					}
				}
				
				for(ESFResult omr : internationalChampMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldInternationalChampMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverInternationalChampMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeInternationalChampMatchs.add(results);
					}
				}
				
				for(ESFResult omr : italianChampMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldItalianChampMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverItalianChampMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeItalianChampMatchs.add(results);
					}
				}
				
				for(ESFResult omr : finalItalianChampMatchs){
					if(1 == omr.getPosition() ){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						goldFinalItalianChampMatchs.add(results);
					}else if(2 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						silverFinalItalianChampMatchs.add(results);
					}else if(3 == omr.getPosition()){
						MatchInfoCurriculum results = new MatchInfoCurriculum();
						results.setmatchId(omr.getEsfMatchId()); 
						results.setmatchTypeId( omr.getEsfMatchTypeId());
						results.setqualificationId(omr.getShooterQualification());
						bronzeFinalItalianChampMatchs.add(results);
					}
				}
				
				////////////////////////////////////////////////
				////////////////////////creo e apro il documento
				
				com.itextpdf.text.Document document = new com.itextpdf.text.Document(); 
				ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
				PdfWriter writer = PdfWriter.getInstance(document, baos);
				document.open();
				
				Paragraph paragraph = new Paragraph();
				
				Paragraph paragraph1 = new Paragraph();
				Paragraph paragraph2 = new Paragraph();

				paragraph1.setIndentationLeft(180);
				paragraph1.setIndentationRight(180);
				paragraph1.add("SCHEDA AZZURRI");
				paragraph1.setAlignment(Element.ALIGN_CENTER);
				paragraph1.setSpacingAfter(15);
				
				document.add(paragraph1);
				document.add(new Paragraph(shooterName+""));
				document.add(new Paragraph("Data e luogo di nascita: "+sdf.format(shooter.getBirthday())+"     "+birthCity.toUpperCase()));
				document.add(new Paragraph("Professione:   "+jobTitle));
				document.add(new Paragraph(guns));
				document.add(new Paragraph("Tessera:   "+cardS+"                        Carta Olimpica:   "+olimpicCard));
				
				document.add(new Paragraph(" "));
				paragraph2.add("MEDAGLIERE");
				paragraph2.setAlignment(Element.TITLE);
				document.add(paragraph2);
				document.add(new Paragraph(" "));
				
				/////////////////////////////////////dati delle gare
				
				
				float[] columnWidths = {10,5,1,3,1,5,9,3};
				float paddingleft=10f;
				PdfPTable table = new PdfPTable(columnWidths); 
				
				table.setWidthPercentage(100);
				table.getDefaultCell().setPaddingLeft(paddingleft);
				
				if(0 < goldOlimpicMatchs.size() ){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Olimpiadi"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldOlimpicMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					for(int i = 0 ; i < goldOlimpicMatchs.size() ; i++){
						
						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldOlimpicMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverOlimpicMatchs.size() ){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Olimpiadi"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverOlimpicMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					for(int i = 0 ; i < silverOlimpicMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverOlimpicMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}

						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < bronzeOlimpicMatchs.size() ){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Olimpiadi"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeOlimpicMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					

					
					
					for(int i = 0 ; i < bronzeOlimpicMatchs.size() ; i++){
						
						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeOlimpicMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}

						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldWorldChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldWorldChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					for(int i = 0 ; i < goldWorldChampMatchs.size() ; i++){
						
						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldWorldChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}

						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverWorldChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverWorldChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					for(int i = 0 ; i < silverWorldChampMatchs.size() ; i++){
						
						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverWorldChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}

						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){
							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeWorldChampMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato del mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeWorldChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					for(int i = 0 ; i < bronzeWorldChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeWorldChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}

						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldFinalWorldCupMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Finale Coppa del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldFinalWorldCupMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					for(int i = 0 ; i < goldFinalWorldCupMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldFinalWorldCupMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverFinalWorldCupMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Finale Coppa del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverFinalWorldCupMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					for(int i = 0 ; i < silverFinalWorldCupMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverFinalWorldCupMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country = "-"+CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeFinalWorldCupMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Finale Coppa del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeFinalWorldCupMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					for(int i = 0 ; i < bronzeFinalWorldCupMatchs.size() ; i++){
						
						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeFinalWorldCupMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldWorldCupMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Coppa del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldWorldCupMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < goldWorldCupMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldWorldCupMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverWorldCupMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Coppa del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverWorldCupMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < silverWorldCupMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverWorldCupMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeWorldCupMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Coppa del Mondo"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeWorldCupMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					
					for(int i = 0 ; i < bronzeWorldCupMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeWorldCupMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldEuropeanChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato d'Europa"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldEuropeanChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < goldEuropeanChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldEuropeanChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverEuropeanChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato d'Europa"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverEuropeanChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < silverEuropeanChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverEuropeanChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeEuropeanChampMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato d'Europa"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeEuropeanChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					
					for(int i = 0 ; i < bronzeEuropeanChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeEuropeanChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldInternationalChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Gara Internazionale"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldInternationalChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < goldInternationalChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldInternationalChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverInternationalChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Gara Internazionale"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverInternationalChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < silverInternationalChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverInternationalChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeInternationalChampMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Gara Internazionale"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeInternationalChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					
					for(int i = 0 ; i < bronzeInternationalChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeInternationalChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldItalianChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato Italiano"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldItalianChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < goldItalianChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldItalianChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverItalianChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato Italiano"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverItalianChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < silverItalianChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverItalianChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeItalianChampMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Campionato Italiano"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeItalianChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					
					for(int i = 0 ; i < bronzeItalianChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeItalianChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < goldFinalItalianChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Finale Campionato Italiano"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Oro"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(goldFinalItalianChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					
					for(int i = 0 ; i < goldFinalItalianChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = goldFinalItalianChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}
				
				if(0 < silverFinalItalianChampMatchs.size()){

					PdfPCell cell1 = new PdfPCell(new Paragraph("Finale Campionato Italiano"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Argento"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(silverFinalItalianChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					document.add(new Paragraph(" "));
					
					
					
					for(int i = 0 ; i < silverFinalItalianChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = silverFinalItalianChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				if(0 < bronzeFinalItalianChampMatchs.size()){
					
					PdfPCell cell1 = new PdfPCell(new Paragraph("Finale Campionato Italiano"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Bronzo"));
					PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(bronzeFinalItalianChampMatchs.size())));
					PdfPCell cell4 = new PdfPCell(new Paragraph(""));
					PdfPCell cell5 = new PdfPCell(new Paragraph(""));
					PdfPCell cell6 = new PdfPCell(new Paragraph(""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(""));
					PdfPCell cell8 = new PdfPCell(new Paragraph(""));
					
					cell1.setBorder(0);
					cell2.setBorder(0);
					cell3.setBorder(0);
					cell4.setBorder(0);
					cell5.setBorder(0);
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					
					
					
					for(int i = 0 ; i < bronzeFinalItalianChampMatchs.size() ; i++){

						MatchInfoCurriculum res = new MatchInfoCurriculum();

						res = bronzeFinalItalianChampMatchs.get(i);

						ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(res.getmatchId());
						
						long qId = 0;
						long stId = 0;
						
						if(Validator.isNotNull(res.getmatchTypeId())){
							stId = res.getmatchTypeId();
						}
						
						if(Validator.isNotNull(res.getqualificationId())){
							qId = res.getqualificationId();
						}

						ESFSportType st = null;
						ESFShooterQualification sq = null;
						
						
						if(0 < stId){
							st = ESFSportTypeLocalServiceUtil.fetchESFSportType(stId);
						}
						if(0 < qId){
							sq = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(qId);
						}

						String team = "squadra";
						String country = "";
						String sptS = "";
						String sqS = "";
						String place = "";

						Calendar calendar = CalendarFactoryUtil.getCalendar();

						String yearTot = sdf.format(match.getStartDate());
						String yearA[] = yearTot.split("/");
						String year = yearA[2];

						
						if(Validator.isNotNull(match.getIsIndividualMatch())){

							team = "individuale";
						}
						
						if(Validator.isNotNull(st) && Validator.isNotNull(st.getCode())){

							sptS = st.getCode();
						}
						if( Validator.isNotNull(sq) && Validator.isNotNull(sq.getName())){
							sqS = sq.getCode();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getCountryId()) && Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()))
								&& Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getA3())){
							country ="-"+ CountryServiceUtil.fetchCountry(match.getCountryId()).getA3().toUpperCase();
						}

						if(Validator.isNotNull(match) && Validator.isNotNull(match.getNotNationalAssotiation())){

							place = match.getNotNationalAssotiation().toUpperCase();
							place = place + " "+country;
							
						}
						
						
						PdfPCell cell11 = new PdfPCell(new Paragraph(""));
						PdfPCell cell12 = new PdfPCell(new Paragraph(""));
						PdfPCell cell13 = new PdfPCell(new Paragraph(""));
						PdfPCell cell14 = new PdfPCell(new Paragraph(year));
						PdfPCell cell15 = new PdfPCell(new Paragraph(sqS));
						PdfPCell cell16 = new PdfPCell(new Paragraph(team));
						PdfPCell cell17 = new PdfPCell(new Paragraph(place));
						PdfPCell cell18 = new PdfPCell(new Paragraph(sptS));

						cell11.setBorder(0);
						cell12.setBorder(0);
						cell13.setBorder(0);
						cell14.setBorder(0);
						cell15.setBorder(0);
						cell16.setBorder(0);
						cell17.setBorder(0);
						cell18.setBorder(0);

						table.addCell(cell11);
						table.addCell(cell12);
						table.addCell(cell13);
						table.addCell(cell14);
						table.addCell(cell15);
						table.addCell(cell16);
						table.addCell(cell17);
						table.addCell(cell18);

					}
					
				}

				document.add(table);
				
				///////////////////////////////////////////////
				////////////////////////////chiudo il documento
				XMLWorkerHelper worker = XMLWorkerHelper.getInstance();	
				document.newPage();
				document.close();

				resourceResponse.setContentType("application/pdf");
				resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Scheda Azzurri.pdf;");
				OutputStream out = resourceResponse.getPortletOutputStream();
				baos.writeTo(out);
				out.flush();
				out.close();
				
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return;

		}
		
		if(isCatridge && esfGunTypeId > 0){
			List<ESFCatridge> catridges = new ArrayList<ESFCatridge>();
			List<ESFCatridge> catridgesTypes = new ArrayList<ESFCatridge>();
			try {
				catridges = ESFCatridgeLocalServiceUtil.getESFCatridges();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();
			
			for (ESFCatridge catridge : catridges) {
				if(catridge.getEsfGunTypeId() == esfGunTypeId){
					
					JSONObject esfcatridgeIdName = JSONFactoryUtil.createJSONObject();
					
					esfcatridgeIdName.put(
							"esfCatridgeId", catridge.getEsfCatridgeId());
					esfcatridgeIdName.put("name", catridge.getCatridgeModel());
						resultJSONArr.put(esfcatridgeIdName);
				}
				
			}
			resultJSONObj.put("esfCatridges", resultJSONArr);
			resourceResponse.getWriter().write(resultJSONObj.toString());
		}
		else if (resourceID.equals("liv1") || resourceID.equals("liv2") ||
					resourceID.equals("liv3")) {
				try {
					ESFServiceUtil esfServiceUtil =
							new ESFServiceUtil(ESFUser.class.getName(), resourceRequest);
	
					String param =
							PortalUtil.getOriginalServletRequest(httpReq).getParameter(
									"param");
					String idEsfOrganization =
							PortalUtil.getOriginalServletRequest(httpReq).getParameter(
									"esfOrganizationId");
					esfServiceUtil.serveOrganization(
							resourceRequest, resourceResponse, param, idEsfOrganization);
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
		}else if(!isCatridge && !resourceID.equals("fiscalCode")){
				ShooterUtility su = new ShooterUtility();
				su.init(this.getPortletConfig());
				su.serveResource(resourceRequest, resourceResponse);
		}else if (resourceID.equals("fiscalCode")) {
				try{
					JSONObject fiscalcode = serveFiscalCode(resourceRequest,resourceResponse);
					resourceResponse.getWriter().print(fiscalcode);
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
		
	}

	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFGun(request, response, "esfnationaldelegation");

	}
	


	public void deleteESFGun(ActionRequest request, ActionResponse response)
				throws PortalException, SystemException {

				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
				String esfUserId=ParamUtil.getString(request, "esfUserId");

				//String mvc=ParamUtil.getString(request, "mvcPath");
				long esfGunId = ParamUtil.getLong(request, "esfGunId");
				long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
				if (esfgunUserId > 0) {
					ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
					ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
				}
				response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			
	}
	
	
	public void removeRole(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {
		
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			
			String mvcPath = ParamUtil.getString(request, "mvcPath");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
			long esforgId = ParamUtil.getLong(request, "esforgId");
			String esfstartDate = ParamUtil.getString(request,  "esfstartDate");
			
			//esfstartDate = esfstartDate.substring(0, (esfstartDate.length()-2));
			
			SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate  = dateParser.parse(esfstartDate);
			
			ESFUserESFUserRolePK esfUserESFUserRolePK = new ESFUserESFUserRolePK();
			esfUserESFUserRolePK.setEsfUserId(esfUserId);
			esfUserESFUserRolePK.setEsfUserRoleId(esfUserRoleId);
			esfUserESFUserRolePK.setEsfOrganizationId(esforgId);
			esfUserESFUserRolePK.setStartDate(startDate);
			ESFUserESFUserRole userRole = ESFUserESFUserRoleLocalServiceUtil.fetchESFUserESFUserRole(esfUserESFUserRolePK);
			if(Validator.isNotNull(userRole)){
				ESFUserESFUserRoleLocalServiceUtil.deleteESFUserESFUserRole(userRole);
			}
			response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
						
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
	}
	
	
	public void editESFGunType(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					boolean found = false;
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

					long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
					String name = ParamUtil.getString(request, "name");
					String description = ParamUtil.getString(request, "description");
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					boolean isCatridgeProductor = ParamUtil.getBoolean(request, "isCatridgeProductor");
					if (esfGunTypeId > 0) {
						ESFGunType esfGunType =
							ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);

						if (ESFGunTypeLocalServiceUtil.checkNome(name, serviceContext) != null &&
							!esfGunType.getName().equals(name)) {
							SessionErrors.add(request, "esfGunType-reference-error");
						}
						else {
							ESFGunTypeLocalServiceUtil.updateESFGunType(
								serviceContext.getUserId(), esfGunTypeId, name,
								description, isCatridgeProductor, serviceContext);
						}
					}
					else {
						if (ESFGunTypeLocalServiceUtil.checkNome(name, serviceContext) != null) {
							SessionErrors.add(request, "esfGunType-reference-error");
						}
						else {
							ESFGunTypeLocalServiceUtil.addESFGunType(
								serviceContext.getUserId(), name, description, isCatridgeProductor,
								serviceContext);
						}
					}
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("mvcPath",mvc);
					response.setRenderParameter("modifyMode", modifyMode);
	}
	
	public void editESFGunKind(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
		String esfUserId=ParamUtil.getString(request, "esfUserId");
		String mvc=ParamUtil.getString(request, "mvcPath");
		boolean found = false;
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request, "gunTypeId");
		String description = ParamUtil.getString(request, "description");
		String model = ParamUtil.getString(request, "model");
		long caliber = ParamUtil.getLong(request, "caliber");
		String esfGunId=ParamUtil.getString(request, "esfGunId");
		String modifyMode=ParamUtil.getString(request, "modifyMode");
		String measures = ParamUtil.getString(request, "measures");
		long typologyId = ParamUtil.getLong(request, "typology");
		
		String name = ParamUtil.getString(request, "name");
		String from =ParamUtil.getString(request, "from");
		String esfCaneId=ParamUtil.getString(request, "esfCaneId");
		if (esfGunKindId > 0) {
			
				ESFGunKindLocalServiceUtil.updateESFGunKind(
					serviceContext.getUserId(), esfGunKindId, name,
					description, esfGunTypeId, serviceContext);
		}
		else {

			ESFGunKindLocalServiceUtil.addESFGunKind(
					serviceContext.getUserId(), name, description, 
					esfGunTypeId, serviceContext);

		}
		response.setRenderParameter("pathBack",mvc);
		response.setRenderParameter("esfUserId", esfUserId);
		response.setRenderParameter("mvcPath",mvc);
		response.setRenderParameter("esfGunId", esfGunId);
		response.setRenderParameter("modifyMode", modifyMode);
	}	

	public void editESFCatridge(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, PortletException {

ServiceContext serviceContext =
		ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
	long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	long catridgeModel = ParamUtil.getLong(request, "catridgeModel");
	long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
	long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
	String note=ParamUtil.getString(request, "note");
	long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
	long shooteId = ParamUtil.getLong(request, "esfUserId");
	long catridgeModelId = ParamUtil.getLong(request, "catridgeModel");
	int type = ESFKeys.ESFGunType.CATRIDGE;
	String code = "";
	boolean isFavoriteGun = false;
	long gunId = 0;
	long caliber = 0;
	
	
	if(catridgeModelId > 0){
		gunId = catridgeModelId;
		ESFCatridge catridge = ESFCatridgeLocalServiceUtil.fetchESFCatridge(catridgeModelId);
		caliber = catridge.getCatridgeCaliber();
	
	}else{
		gunId = esfGunTypeId;
	}
	
	
	
	if( shooteId > 0){
		ESFgunUserLocalServiceUtil.addESFGunUser(gunId, shooteId,
				code, isFavoriteGun, type, note, esfGunTypeId,
				catridgeModelId, 0, "", caliber , serviceContext);
	}else{
		SessionErrors.add(request, "Catridge-reference-error");
	}
	
	
	
	request.setAttribute("esfUserId", esfUserId);
	request.setAttribute("op", "updAddr");
	request.setAttribute("organizationId", esfOrganizationId);
	response.setRenderParameter(
		"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
	response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

	response.setRenderParameter("op", "updAddr");
	
}

	public void editESFCane(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			// long organizationId = ParamUtil.getLong(request, "organizationId");
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
			long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
			long esfOrganizationId =
				ParamUtil.getLong(request, "esfOrganizationId");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long caneCaliber =  ParamUtil.getLong(request, "caliber");
			int typeId= ParamUtil.getInteger(request, "typology") ;
			String measures=ParamUtil.getString(request, "measures");
			boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
			String code=ParamUtil.getString(request, "code");
			long shooterId = ParamUtil.getLong(request, "userId");
			String noteShooter=ParamUtil.getString(request, "noteShooter");
			long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
			

			int type = ESFKeys.ESFGunType.CANE;
			String shooter_note = ParamUtil.getString(request, "shooter_note");
			
			ESFGunKind kind = new ESFGunKindImpl();
			List<ESFgunUser> codeGuns = new ArrayList<ESFgunUser>();
			
			
		
			codeGuns = ESFgunUserLocalServiceUtil.findbyCode(code);
			
			if(codeGuns.size() > 0){
				SessionErrors.add(request, "duplicate_code");
				response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

				return ; 
			}else{
				
				ESFCaneLocalServiceUtil.addESFCane(
					serviceContext.getUserId(), esfGunKindId,esfGunTypeId,
					esfUserId, esfOrganizationId, code, caneCaliber, typeId, 
					measures, isFavoriteGun, esfUserId, shooter_note, serviceContext);

			
			}	
			request.setAttribute("esfUserId", esfUserId);
			request.setAttribute("op", "updAddr");
			request.setAttribute("organizationId", esfOrganizationId);
			response.setRenderParameter(
				"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));

			response.setRenderParameter("op", "updAddr");
	}	

	
	public void deleteESFCatridge(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
					if (esfCatridgeId > 0) {

						ESFCatridgeLocalServiceUtil.deleteESFCatridge(esfCatridgeId, serviceContext);
					}
					response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					
				
	}
	
	public void deleteESFCane(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					
					if (esfCaneId > 0) {

						ESFCaneLocalServiceUtil.deleteESFCane(esfCaneId, serviceContext);
					}
					response.setRenderParameter(
						"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					
				
	}
	
	public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFdocument(request, response, "esfnationaldelegation");

	}
	
	public void deleteESFdocument(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException,
					PortletException {

					ShooterUtility su = new ShooterUtility();
					su.init(this.getPortletConfig());
					su.deleteESFdocument(request, response, "esfnationaldelegation");

	}

	public void updateESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException,
		PortletException {

		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.updateESFShooter(
			actionRequest, actionResponse, "esfnationaldelegation");

	}

	public void deleteESFNational(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		String userID = ParamUtil.getString(request, "esfNationalId");

		Calendar now = CalendarFactoryUtil.getCalendar();

		ESFNational user =
			ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));

		user.setEndDate(now.getTime());

		ESFNationalLocalServiceUtil.updateESFNational(user);

	}

	public void actionModifyNational2(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {
		String userID = ParamUtil.getString(request, "esfNationalID");
		//String esfSportTypeId = ParamUtil.getString(request, "sportType");
		//boolean isNational = ParamUtil.getBoolean(request, "isNational");
		String isNational = request.getParameter("isNational");
		String isUniversity = ParamUtil.getString(request, "isUniversity");
		ESFNational user = ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));
		//user.setEsfSportTypeId(Long.parseLong(esfSportTypeId));
		long esfSportTypeId = ParamUtil.getLong(request, "nationalType");
		
		if(isNational.equals("isNational"))
		{
			user.setIsNational(true);
		}
		else
		{
			user.setIsNational(false);
		}
		
		user.setIsUniversity(Boolean.parseBoolean(isUniversity));
		user.setEsfSportTypeId(esfSportTypeId);
		ESFNationalLocalServiceUtil.updateESFNational(user);

	}

	public void actionModifyNational(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		String userID = ParamUtil.getString(request, "esfNationalID");
		// String esfSportTypeId=ParamUtil.getString(request, "sportType");
		String dateEnd = ParamUtil.getString(request, "endDate");
		String dateStart = ParamUtil.getString(request, "startDate");
		ESFNational user =
			ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));
		Calendar now = CalendarFactoryUtil.getCalendar();
		Calendar nowStart = CalendarFactoryUtil.getCalendar();
		String[] dateArray = dateEnd.split("/");
		String[] dateArrayStart = dateStart.split("/");
		now.set(
			Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1,
			Integer.parseInt(dateArray[0]));
		nowStart.set(Integer.parseInt(dateArrayStart[2]), Integer.parseInt(dateArrayStart[1]) - 1,
				Integer.parseInt(dateArrayStart[0]));
		if (user.getStartDate().after(now.getTime())) {
			SessionErrors.add(request, "insert-date-error-message"); 
			return;
		}
		else {
			// user.setEsfSportTypeId(Long.parseLong(esfSportTypeId));
			user.setEndDate(now.getTime());
			user.setStartDate(nowStart.getTime());
			ESFNationalLocalServiceUtil.updateESFNational(user);
		}
		
	}

	public void actionShooterToNational(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		int yearJsp = Integer.parseInt(ParamUtil.getString(request, "yearDelegation"));
		Calendar now = CalendarFactoryUtil.getCalendar();
		int year = now.get(Calendar.YEAR);
		Date startDate = null;
		Date endDate = null;
		
		if (year == yearJsp) {
			startDate = now.getTime();
			now.set(now.get(Calendar.YEAR), 11, 31);
			endDate = now.getTime();
		}
		else {
			now.set(yearJsp, 0, 1);
			startDate = now.getTime();
			now.set(yearJsp, 11, 31);
			endDate = now.getTime();

		}

		String sportType = ParamUtil.getString(request, "sportType");
		String isNational = ParamUtil.getString(request, "isNational");
		String isUniversity = ParamUtil.getString(request, "isUniversity");
		String userId = ParamUtil.getString(request, "esfUserID");

		ESFUser user = ESFUserLocalServiceUtil.getESFUser(Long.parseLong(userId));
		long count = CounterLocalServiceUtil.increment(ESFNational.class.toString());
		
		List<ESFNational> esfListNational =
			ESFNationalLocalServiceUtil.getESFNationals(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		now = CalendarFactoryUtil.getCalendar();
		
		boolean flag = true;
		
		for (ESFNational nat : esfListNational) {
			if (nat.getEsfUserId() == user.getEsfUserId() && nat.getEndDate().after(now.getTime()) &&
					nat.getEsfSportTypeId() == Long.parseLong(sportType)) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			ESFNational esfNational =
				ESFNationalLocalServiceUtil.createESFNational(count);
			esfNational.setEsfUserId(user.getEsfUserId());
			esfNational.setUserId(user.getEsfUserId());
			esfNational.setCompanyId(user.getCompanyId());
			esfNational.setEsfSportTypeId(Long.parseLong(sportType));
			esfNational.setGroupId(user.getGroupId());
			esfNational.setUserName(user.getLastName() + " " +
				user.getFirstName());
			esfNational.setStartDate(startDate);
			esfNational.setEndDate(endDate);
			esfNational.setIsNational(Boolean.parseBoolean(isNational));
			esfNational.setIsUniversity(Boolean.parseBoolean(isUniversity));
			ESFNationalLocalServiceUtil.addESFNational(esfNational);
		}
		else {

			ESFNational userNational = new ESFNationalImpl();
			List<ESFNational> userNationalSportType =
					ESFNationalLocalServiceUtil.getActiveESFNationals(Long.parseLong(sportType),
							com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
							com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			
			for(ESFNational nat : userNationalSportType){
				if(nat.getUserId() == user.getEsfUserId()){
					userNational = nat;
					break;
				}
			}
			
			userNational.setEsfSportTypeId(Long.parseLong(sportType));
			userNational.setEndDate(endDate);
			userNational.setIsNational(Boolean.parseBoolean(isNational));
			userNational.setIsUniversity(Boolean.parseBoolean(isUniversity));
			ESFNationalLocalServiceUtil.updateESFNational(userNational);

		}

	}
	
	public void changeCard(ActionRequest request, ActionResponse response) throws SystemException,
	PortletException, PortalException, ParseException
	{
		
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.editESFCard(request, response,"esfnationaldelegation");
	}
	
	public void updateExNational(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, ParseException
	{
		 ServiceContext serviceContext =
				   ServiceContextFactory .getInstance(ESFNational.class.getName(), actionRequest);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar start = Calendar.getInstance();
		int actualYear = start.get(Calendar.YEAR);
		String end = "31/12/"+actualYear;
		
		Date startD = start.getTime();
		Date endD = sdf.parse(end);
		
	
		long typeSportId = ParamUtil.getLong(actionRequest, "typeSportId");
		boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
		long[] esfUserIds =
			ParamUtil.getLongValues(actionRequest, "esfUserIds");
		for(int i = 0; i<chooses.length;i++)
		{
			if(chooses[i])
			{
				
				ESFNationalLocalServiceUtil.addESFNational
				(esfUserIds[i], esfUserIds[i], typeSportId, startD, endD, null,serviceContext);
			}
		}
	}
	
	public void actionModifyNationalDelibeDelibDate(ActionRequest request, ActionResponse response) 
			throws NumberFormatException, PortalException, SystemException
	{
		String userID = ParamUtil.getString(request, "esfNationalID");
		// String esfSportTypeId=ParamUtil.getString(request, "sportType");
		String deliberate = ParamUtil.getString(request, "deliberate");
		String delibDate = ParamUtil.getString(request, "delibDate");
		ESFNational user =
			ESFNationalLocalServiceUtil.getESFNational(Long.parseLong(userID));
		Calendar now = CalendarFactoryUtil.getCalendar();
		String[] dateArray = delibDate.split("/");
		
		now.set(
			Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1,
			Integer.parseInt(dateArray[0]));
		
			// user.setEsfSportTypeId(Long.parseLong(esfSportTypeId));
			user.setDeliberateDate(now.getTime());
			user.setDeliberate(deliberate);
			ESFNationalLocalServiceUtil.updateESFNational(user);
	}
	
	public void editESFRifle (ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFgunUser.class.getName(), request);
		
		long shooterId = ParamUtil.getLong(request, "esfUserId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		
		int type =ESFKeys.ESFGunType.RIFLE;
		
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "code");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		int typeId = ParamUtil.getInteger(request, "typology");
		String measures = ParamUtil.getString(request, "measures");
		long caliber = ParamUtil.getLong(request, "caliber");
		
		List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		
		if(gunUsers.size() == 0){
			ESFgunUserLocalServiceUtil.addESFGunUser(esfGunTypeId, shooterId, freshman, isFavoriteGun,
					type, shooter_note, esfGunTypeId, esfGunKindId,
					typeId, measures, caliber, serviceContext);
		}else{
			SessionErrors.add(request, "duplicate_code");
		}
			
		response.setRenderParameter("esfUserId", String.valueOf(shooterId));
		
		response.setRenderParameter(
				"mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
		
	}
	
	public void alterESFRifle (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		boolean favorite = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		int typeId = ParamUtil.getInteger(request, "typology");
		String measures = ParamUtil.getString(request, "measures");
		String caliber = ParamUtil.getString(request, "caliber");
		List<ESFgunUser> esfGunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		
		
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "esfGunType-reference-error");
		}
	
		if(esfGunUsers.size() > 0 &&
				esfGunUsers.get(0).getEsfGunUserId() != esfGunUserId){
			SessionErrors.add(request, "duplicate_code");
		}else{
		
			if(Validator.isNotNull(gunUser)){
				
				gunUser.setCode(freshman);
				gunUser.setNote(shooter_note);
				gunUser.setIsFavorite(favorite);
				gunUser.setEsfCaliber(caliber);
				gunUser.setEsfMeasures(measures);
				gunUser.setTypeId(typeId);
				
				ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
				
			}else{
				response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				return;
			}
		}
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(userId));
	}
	
	
	public void alterESFCane (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		String measures= ParamUtil.getString(request, "measures");
		long caliber= ParamUtil.getLong(request, "caliber");
		int typologyId = ParamUtil.getInteger(request, "typology");
		boolean favorite = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		List<ESFgunUser> esfGunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		ESFCane esfCane = new ESFCaneImpl();
		
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "esfGunType-reference-error");
		}
		esfCane = ESFCaneLocalServiceUtil.fetchESFCane(gunUser.getEsfGunId());
		
		if(esfGunUsers.size() > 0 &&
				esfGunUsers.get(0).getEsfGunUserId() != esfGunUserId){
			SessionErrors.add(request, "duplicate_code");
			
		}else{
			
			if(Validator.isNotNull(gunUser) && Validator.isNotNull(esfCane)){
				
				gunUser.setCode(freshman);
				gunUser.setNote(shooter_note);
				gunUser.setIsFavorite(favorite);
				gunUser.setEsfCaliber(String.valueOf(caliber));
				gunUser.setEsfMeasures(measures);
				gunUser.setTypeId(typologyId);
				
				ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
				
				esfCane.setCode(freshman);
				esfCane.setIsFavoriteGun(favorite);
				esfCane.setCaneCaliber(caliber);
				esfCane.setMeasures(measures);
				esfCane.setTypeId(typologyId);
				
				ESFCaneLocalServiceUtil.updateESFCane(esfCane);
				
			}else{
				response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				return;
			}
			
		}
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(userId));
		
	}
	
	public void assignMember (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		ESFUserRole userRole = new ESFUserRoleImpl();
		userRole = ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = userRole.getMaxUser();
		
		long esfLiv0Id = ParamUtil.getLong(request, "esfLiv0Id");
		long esfLiv1Id = ParamUtil.getLong(request, "esfLiv1Id");
		long esfLiv2Id = ParamUtil.getLong(request, "esfLiv2Id");
		long esfLiv3Id = ParamUtil.getLong(request, "esfLiv3Id");

		long esfOrganizationId = 0;
		Date date = new Date();
		if (esfLiv3Id != 0) {
			esfOrganizationId = esfLiv3Id;
		}
		else if (esfLiv2Id != 0) {
			esfOrganizationId = esfLiv2Id;
		}
		else if (esfLiv1Id != 0) {
			esfOrganizationId = esfLiv1Id;
		}
		else {
			esfOrganizationId = esfLiv0Id;
		}
		
		if(userRole.isIsBDO()){
			
			if(esfLiv3Id == 0){
				SessionErrors.add(request, "esfRole-reference-error");
				
				response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
				
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				return;
			}else{
				
				List<ESFUserESFUserRole> userRoleBDO =  ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(esfUserRoleId, esfLiv3Id);
				if ( userRoleBDO.size() >= maxUser){
					SessionErrors.add(request, "esfRole-MAx-User-reference-error");
					
					response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
					
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					return;
				}
			}
			
		}
		
		ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
				esfUserId, esfUserRoleId, esfOrganizationId, date);
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
			
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		
	}
	
	public void deleteESFDelegation (ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, PortletException {

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfNationalId = ParamUtil.getLong(request, "esfNationalId");
		
		List<ESFMatch> matchs = ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(esfUserId);

		if(matchs.size() > 0){
			SessionErrors.add(request, "esfDelgation-reference-error");
			response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/edit_esfShooter.jsp");
		}else{
			ESFNationalLocalServiceUtil.deleteESFNational(esfNationalId);
		}
		
		response.setRenderParameter("mvcPath", "/html/esfnationaldelegation/view.jsp");

	}
	
	public JSONObject serveFiscalCode(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {

		JSONObject jsonFiscalCode = JSONFactoryUtil.createJSONObject();
		
		String result = "ko";
		String fiscalCode = "01";
		
		String lastName =
				ParamUtil.getString(resourceRequest,"lastName").replace(" ", "");
		String firstName =
				ParamUtil.getString(resourceRequest,"firstName").replace(" ", "");
		String middleName =
				ParamUtil.getString(resourceRequest,"middleName").replace(" ", "");
		String birthcity =
				ParamUtil.getString(resourceRequest,"birthcity").replace(" ", "");
		Boolean male =
				ParamUtil.getBoolean(resourceRequest,"male");
		String birthday =
				ParamUtil.getString(resourceRequest,"birthday");
		String sex = "f";
		if (male){
			
			sex = "m";
			
		}
		String totalName= firstName.concat(middleName);
		String url = "http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?Nome="+totalName+"&Cognome="+lastName+"&ComuneNascita="
					+birthcity+"&DataNascita="+birthday+"&Sesso="+sex;
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		URLConnection connection = new URL(url).openConnection();
		
		con.setRequestMethod("GET");
		
		try {
			int responseCode = con.getResponseCode();
		} catch (Exception e) {
			fiscalCode = "02";
			jsonFiscalCode.put("result", result);
			jsonFiscalCode.put("fiscalCode", fiscalCode);
			
			return jsonFiscalCode;
		}
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(con.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String responseString = response.toString();
		
		
				
		if(responseString.length()>117 && !responseString.substring(101,117).contains(" ") && (StringPool.BLANK != birthday )
				&& (StringPool.BLANK != lastName ) && (StringPool.BLANK != firstName ) && (StringPool.BLANK != birthcity)){
			result = "ok";
			fiscalCode = responseString.substring(101,117);
		}
		jsonFiscalCode.put("result", result);
		jsonFiscalCode.put("fiscalCode", fiscalCode);
		return jsonFiscalCode;
	}

	private Log _log = LogFactoryUtil.getLog(ESFNationalDelegation.class);
}
