package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFJuniores;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.impl.ESFUserCategoryImpl;
import it.ethica.esf.portlet.utility.AddJuniores;
import it.ethica.esf.portlet.utility.CustomComparator;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFJunioresLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFCardLocalServiceImpl;
import it.ethica.esf.service.impl.ESFCategoryLocalServiceImpl;
import it.ethica.esf.service.impl.ESFUserLocalServiceImpl;
import it.ethica.esf.util.ESFKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class QualificationsFederalYouth
 */
public class ESFQualificationsFederalYouthPortlet extends MVCPortlet {

	
	public void updateQualification(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		//HashMap<String,Integer> ageForYoung = ESFConfigurationLocalServiceUtil.findAgeByName(); modificato da Dario
	/*	HashMap<String,Integer> ageForYoung = ESFConfigurationLocalServiceUtil.findAgeYouthShooter("youth-age-");
		List<ESFUserCategory> allESFUserCategory = new ArrayList<ESFUserCategory>();
		List<ESFUser> allJunioresFO = new ArrayList<ESFUser>();
		List<ESFUser> allJunioresDT = new ArrayList<ESFUser>();
		List<ESFUser> allJunioresSKEET = new ArrayList<ESFUser>();
		List<ESFUser> allUsers = new ArrayList<ESFUser>();
		List<ESFMatch> allMatch = new ArrayList<ESFMatch>();
		allMatch = ESFMatchLocalServiceUtil.getESFMatchs(0, ESFMatchLocalServiceUtil.getESFMatchsCount());
		allUsers = ESFUserLocalServiceUtil.findAllUserByAgeOnlyPeople();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int year = cal.get(Calendar.YEAR);
		Date gcInizio = sdf.parse("01/01/"+year);
		Date gcFine = sdf.parse("31/12/"+year);
		HashMap<String, Long> categorie= null;
		HashMap<String, Long> matchType = null;
		HashMap<String,Long> sports = ESFSportTypeLocalServiceUtil.findIDSportByName();
		
		try {
			categorie = ESFCategoryLocalServiceUtil.findMapLongIdCategory();
		//	matchType = ESFMatchTypeLocalServiceUtil.allIdMatchTypeFromName();
		}catch (SystemException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		year --;
		try {
			allESFUserCategory = ESFUserCategoryLocalServiceUtil.allESFUserCategoryByActualYear(year);
		} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//Reinserisco in tabella i juniores che,anche in questo anno, hanno l'età giusta per essere nel settore
		//	giovanile  
		//aggiunto da Dario
		Calendar calendar = GregorianCalendar.getInstance();//
		int actualYear = calendar.get( Calendar.YEAR );//
		
		for(ESFUserCategory eus: allESFUserCategory){
			ESFUser eu = ESFUserLocalServiceUtil.getESFUser(eus.getEsfUserId());
			cal.setTime(eu.getBirthday());
			year = cal.get(Calendar.YEAR);
			int ageShooter = 0;//aggiunto da Dario
			
			ageShooter = actualYear - year;
			
			
			//if (year <= ageForYoung.get("fossaolimpicaEsordientiEnd") && year >= ageForYoung.get("fossaolimpicaALMBegin")){
			if (ageShooter <= ageForYoung.get("youth-age-MAX") && ageShooter >= ageForYoung.get("youth-age-min")){
				if (eus.getEsfCategoryId() == categorie.get("FOJM")
					||eus.getEsfCategoryId() == categorie.get("FOJF")
					||eus.getEsfCategoryId() == categorie.get("DTJM")
					||eus.getEsfCategoryId() == categorie.get("SKEETJM")
					||eus.getEsfCategoryId() == categorie.get("SKEETJF")){
					
					ESFUserCategory nuovo =  ESFUserCategoryLocalServiceUtil
							.createESFUserCategory(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory"));
					
					nuovo.setEsfUserId(eu.getEsfUserId());
					nuovo.setEndDate(gcFine);
					nuovo.setStartDate(gcInizio);
					nuovo.setEsfCategoryId(eus.getEsfUserCategoryId());
					nuovo.setEsfSportTypeId(eus.getEsfSportTypeId());
					ESFUserCategoryLocalServiceUtil.addESFUserCategory(nuovo);
					
					if(eus.getEsfCategoryId() == categorie.get("FOJM")||eus.getEsfCategoryId() == categorie.get("FOJF")) {
						allJunioresFO.add(eu);
					}
					
					if(eus.getEsfCategoryId()==categorie.get("DTJM")) {
						allJunioresDT.add(eu);
					}
					
					if(eus.getEsfCategoryId()==categorie.get("SKEETJM")
							||eus.getEsfCategoryId()==categorie.get("SKEETJF")) {
						allJunioresSKEET.add(eu);
					}
				}
			}
		}
		
	/*	for (ESFMatch match:allMatch){
			
			if(match.getIsJuniorMatch()) {
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(match.getStartDate());
				if(cal2.get(Calendar.YEAR)== (Calendar.getInstance().get(Calendar.YEAR)-1)) {
					
						//Criterium 
						if(match.getEsfMatchTypeId()==matchType.get("criterium nazionale")) { //prima era if(match.getEsfMatchTypeId()==matchType.get("criterium nazionale"));
							
							//Fossa Olimpica 
							if(match.getEsfSportTypeId()==sports.get("Fossa Olimpica")) {
							
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumFOM= risultati.get(0);
								
								if(risultatiCriteriumFOM.size()>2) {
									for(int i = 0; i<3;i++) {
										ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumFOM.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresM)) {
											allJunioresFO.add(nuovoJuonioresM);
										}
									}
								}
								
								ArrayList<ESFMatchResult> risultatiCriteriumFOF= risultati.get(1);
								if(risultatiCriteriumFOF.size()>2) {
								//Per ogni categoria scelgo i primi 3 posti
								
									for(int i = 0; i<3;i++) {
										ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCriteriumFOF.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresF))
										{
											allJunioresFO.add(nuovoJuonioresF);
										}
									}
								}
						
							}
							// Skeet  
							if( match.getEsfSportTypeId()==sports.get("Skeet")) {
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumSKEETM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiCriteriumSKEETF= risultati.get(1);
								
								//Per ogni categoria scelgo i primi 3 posti
								if(risultatiCriteriumSKEETM.size()>0) {
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumSKEETM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresSKEET.add(nuovoJuonioresM);
									}	
								}
								
								if(risultatiCriteriumSKEETF.size()>0) {
										ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCriteriumSKEETF.get(0), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresF))
										{
											allJunioresSKEET.add(nuovoJuonioresF);
										}
								}
							
							}
							// Double Trap
							if( match.getEsfSportTypeId()==sports.get("Double Trap")) {
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumDTM= risultati.get(0);
								if(risultatiCriteriumDTM.size()>0) {
								
									//Per ogni categoria scelgo i primi 3 posti
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumDTM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM)) {
										allJunioresDT.add(nuovoJuonioresM);
									}
								}
							}	
							
						//Campionato Italiano SG
						 
						if(match.getEsfMatchTypeId()==matchType.get("CAMPIONATO ITALIANO S.G.")){ 
							
							//Fossa Olimpica
							 
							if(match.getEsfSportTypeId()==sports.get("Fossa Olimpica")) {
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCIFOM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiCIFOF= risultati.get(1);
								if(risultatiCIFOM.size()>=3) {
									for (int i = 0;i<3;i++) {
									
										ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCIFOF.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresF)) {
											allJunioresFO.add(nuovoJuonioresF);
										}
									}
								}
								if(risultatiCIFOM.size()>=3) {
									int allievi = 0;
									int gs=0;
									int count = 0;
									while(allievi!=5 && gs!=2) {
										if(count>risultatiCIFOM.size()) break;
										Calendar yearAllievo = Calendar.getInstance();
										ESFUser nuovoJuonioresM = ESFUserLocalServiceUtil.fetchESFUser(risultatiCIFOM.get(count).getEsfPartecipantId());
										yearAllievo.setTime(nuovoJuonioresM.getBirthday());
										if(yearAllievo.get(Calendar.YEAR)<=2000) {
											if(gs<2) {
												ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCIFOF.get(count), match, gcInizio,gcFine);
												if(Validator.isNotNull(nuovoJuonioresF)) {
													allJunioresFO.add(nuovoJuonioresF);
												}
												gs++;
											}
										
										}
										else {
											if(allievi<5) {
												ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCIFOF.get(count), match, gcInizio,gcFine);
												if(Validator.isNotNull(nuovoJuonioresF)) {
													allJunioresFO.add(nuovoJuonioresF);
												}
												allievi++;
											}
										}
										count++;
										//da finire 
									}
								}
							}
							
							//Skeet 
							 
							if(match.getEsfSportTypeId()==sports.get("Skeet")){
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiF= risultati.get(1);
								if(risultatiM.size()>0) {
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM)) {
										allJunioresSKEET.add(nuovoJuonioresM);
									}
								}
								if(risultatiF.size()>0) {
									ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiF.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresF)) {
										allJunioresSKEET.add(nuovoJuonioresF);
									}
								}
							}
							
							//Double Trap
							
							if(match.getEsfSportTypeId()==sports.get("Double Trap")){
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								if(risultatiM.size()>0) {
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM)) {
										allJunioresDT.add(nuovoJuonioresM);
									}
								}
							}
						  }
						
						//Gran Premio Open Source NORD SUD CENTRO
						
						if(match.getEsfMatchTypeId()==matchType.get("GRAN PREMIO OPEN NORD S.G.")||
							match.getEsfMatchTypeId()==matchType.get("GRAN PREMIO OPEN CENTRO S.G.")||
							match.getEsfMatchTypeId()==matchType.get("GRAN PREMIO OPEN SUD S.G.")){
						
							//Fossa Olimpica 
						
							if(match.getEsfSportTypeId()==sports.get("Fossa Olimpica")) {
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								if(risultatiM.size()>=2) {
									for(int i = 0; i<2;i++) {
										ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresM)) {
											allJunioresFO.add(nuovoJuonioresM);
										}
									}
								}
							}
							
							//Double Trap
							
							if(match.getEsfSportTypeId()==sports.get("Double Trap")){
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumDTM= risultati.get(0);
								if(risultatiCriteriumDTM.size()>0) {
								
									//Per ogni categoria scelgo i primi 3 posti
								
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumDTM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM)) {
										allJunioresDT.add(nuovoJuonioresM);
									}
								}
							}

							//Skeet 
							
							if(match.getEsfSportTypeId()==sports.get("Skeet")){
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiF= risultati.get(1);
								if(risultatiM.size()>0){
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM)) {
										allJunioresSKEET.add(nuovoJuonioresM);
									}
								}
								if(risultatiF.size()>0){
									ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiF.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresF)) {
										allJunioresSKEET.add(nuovoJuonioresF);
									}
								}
							}
						
						}
			}
		}
		
		//ArrayList<ESFUserCategory>	allESFUserCategoryNow = (ArrayList<ESFUserCategory>) ESFUserCategoryLocalServiceUtil.allESFUserCategoryByActualYear(year++);
			}
	}
		
		//Aggiungo i nuovi iscritti ovvero shooter che non hanno ancora qualifica e saranno assegnati solo in base all'età
		
		ArrayList<Long> allESFUserCategoryNowFOID = new ArrayList<Long>();
		ArrayList<Long> allESFUserCategoryNowDTID = new ArrayList<Long>();
		ArrayList<Long> allESFUserCategoryNowSKEETID = new ArrayList<Long>();
		
		for(ESFUser esc:allJunioresFO){
			allESFUserCategoryNowFOID.add(esc.getEsfUserId());
		}
		for(ESFUser esc:allJunioresDT){
			allESFUserCategoryNowDTID.add(esc.getEsfUserId());
		}
		for(ESFUser esc:allJunioresSKEET){
			allESFUserCategoryNowSKEETID.add(esc.getEsfUserId());
		}
		
		
		for (ESFUser tiratore: allUsers)
		{
				try {
				
				cal.setTime(tiratore.getBirthday());
				int year2=cal.get(Calendar.YEAR);
				if(year2==ageForYoung.get("fossaolimpicaEsordientiEnd") || 
				   year2==ageForYoung.get("fossaolimpicaEsordientiBegin") ){
					if(tiratore.getMale()){
						if(!allESFUserCategoryNowFOID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("FOESM"), (long)sports.get("Fossa Olimpica"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowDTID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("DTESM"), (long)sports.get("Double Trap"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowSKEETID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("SKEETESM"), (long)sports.get("Skeet"), gcInizio, gcFine);
						}
					//	fossaOlimpicaEsordientiMaschi.add(eu);
					//	doubleTrapEsordientiMaschi.add(eu);
					//	skeetEsordientiMaschi.add(eu);
						
					}
					else {
						if(!allESFUserCategoryNowFOID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("FOESF"), (long)sports.get("Fossa Olimpica"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowSKEETID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("SKEETESF"), (long)sports.get("Skeet"), gcInizio, gcFine);
						}
					//	fossaOlimpicaEsordientiFemmine.add(eu);
						skeetEsordientiFemmine.add(eu);
					}
				}
			    if (year2==ageForYoung.get("fossaolimpicaGSBegin") ||
			    	year2==ageForYoung.get("fossaolimpicaGSEnd")){
					if(tiratore.getMale()){
						if(!allESFUserCategoryNowFOID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("FOGSM"), (long)sports.get("Fossa Olimpica"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowDTID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("DTALM"), (long)sports.get("Double Trap"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowSKEETID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("SKEETALM"), (long)sports.get("Skeet"), gcInizio, gcFine);
						}
					//	fossaOlimpicaGSMaschi.add(eu);
					//	doubleTrapAllieviMaschi.add(eu);
					//	skeetAllieviMaschi.add(eu);
					}
					else {
						if(!allESFUserCategoryNowFOID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("FOALF"), (long)sports.get("Fossa Olimpica"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowSKEETID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("SKEETALF"), (long)sports.get("Skeet"), gcInizio, gcFine);
						}
					//	fossaOlimpicaAllieviFemmine.add(eu);
					//	skeetAllieviFemmine.add(eu);
					}
				}
			    if(year2<=ageForYoung.get("fossaolimpicaALMEnd") && year2==ageForYoung.get("fossaolimpicaALMBegin")){
			    	if(tiratore.getMale()){
			    		if(!allESFUserCategoryNowFOID.contains(tiratore.getEsfUserId()))
			    		{
			    			AddJuniores.addNewJunior(tiratore, categorie.get("FOALM"), (long)sports.get("Fossa Olimpica"), gcInizio, gcFine);
			    		}
			    		if(!allESFUserCategoryNowDTID.contains(tiratore.getEsfUserId()))
			    		{
			    			AddJuniores.addNewJunior(tiratore, categorie.get("DTALM"), (long)sports.get("Double Trap"), gcInizio, gcFine);
			    		}
			    		if(!allESFUserCategoryNowSKEETID.contains(tiratore.getEsfUserId()))
			    		{
			    			AddJuniores.addNewJunior(tiratore, categorie.get("SKEETALM"), (long)sports.get("Skeet"), gcInizio, gcFine);
			    		}
					//	fossaOlimpicaAllieviMaschi.add(eu);
					//	doubleTrapAllieviMaschi.add(eu);
					//	skeetAllieviMaschi.add(eu);
					}
					else {
						if(!allESFUserCategoryNowFOID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("FOALF"), (long)sports.get("Fossa Olimpica"), gcInizio, gcFine);
						}
						if(!allESFUserCategoryNowSKEETID.contains(tiratore.getEsfUserId()))
						{
							AddJuniores.addNewJunior(tiratore, categorie.get("SKEETALF"), (long)sports.get("Skeet"), gcInizio, gcFine);
						}
					//	fossaOlimpicaAllieviFemmine.add(eu);
					//	skeetAllieviFemmine.add(eu);
					}
			    	
			    }
				
			}
		    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			
		}*/
		
		// Nuova Gestione
		
		//	Calcolo delle categorie da eseguire sui tiratori Juniores in base ai meriti sportivi
		//	Da chiedere a Mario Magnanini come gestire perchè sono cambiate le gare
		//	Dopo il calcolo dei meriti sportivi si insericono i tiratori ancora in età Juniores
		//	nelle giusta Categoria per l'anno in esame
		//	passo ora a vedere gli Juniores che non hanno cambaito categoria per merito sportivo 
		//	e li iserisco nella categoria che avevano l'anno precedente
		
		//	ricerca dei tiratori che sono presenti in Juoniores che hanno ancora età da Juniores e non sono 
		//	presenti in ESFUserCategory con startDate dell'anno in esame
		
		//anno attuale
		
		ThemeDisplay themeDisplay = 
						(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long companyId = themeDisplay.getLayout().getCompanyId();
		long userId = themeDisplay.getLayout().getUserId();
		String userName = themeDisplay.getLayout().getUserName();
		
		
		
		Date today = new Date();
		
		Calendar calendar = GregorianCalendar.getInstance();
		int actualYear = calendar.get( Calendar.YEAR );
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = sdf.parse("01/01/"+actualYear);
		Date endDate = sdf.parse("31/12/"+actualYear);
		int year = 0;
		int MAXage = 0;
		
		_log.info("******actualYear="+actualYear);
		
		ESFConfiguration youthMAXAge = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("youth-age-MAX");
		
		_log.info("******youthMAXAge="+youthMAXAge);
		
		MAXage = Integer.parseInt(youthMAXAge.getValue());
		
		year = actualYear-MAXage;
		
		_log.info("******year="+year);
		
		List<ESFUserCategory> youthNotPromoved = new ArrayList<ESFUserCategory>();
		youthNotPromoved = ESFUserCategoryLocalServiceUtil.findYouthNotPromoved(year);
		
		_log.info("******youthNotPromoved="+youthNotPromoved);
		
		for (ESFUserCategory cat : youthNotPromoved){
			
			_log.info("******cat="+cat);

			ESFUserCategory youth = new ESFUserCategoryImpl();
			long userCategoryId = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youth.setEsfUserCategoryId(userCategoryId);
			youth.setGroupId(cat.getGroupId());
			youth.setCompanyId(cat.getCompanyId());
			youth.setUserId(cat.getUserId());
			youth.setUserName(cat.getUserName());
			youth.setCreateDate(today);
			youth.setEsfUserId(cat.getEsfUserId());
			youth.setEsfCategoryId(cat.getEsfCategoryId());
			youth.setEsfSportTypeId(cat.getEsfSportTypeId());
			youth.setStartDate(startDate);
			youth.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youth);
		}
		
		//ricerco i tiratori in età da Juniores che non erano presenti 
		
		List<ESFUser> newYouth = new ArrayList<ESFUser>();
		newYouth = ESFUserLocalServiceUtil.findNewYouthShooter(year);
		
		for(ESFUser user : newYouth){
			
			_log.info("******user="+user);
			_log.info("*****user name ="+user.getFirstName());
			_log.info("*****user lastName ="+user.getLastName());
			_log.info("*****user birthday ="+user.getBirthday().toString());
			long foId = ESFSportTypeLocalServiceUtil.findIDSportByCode("DO013");
			long skId = ESFSportTypeLocalServiceUtil.findIDSportByCode("DO010");
			long dtId = ESFSportTypeLocalServiceUtil.findIDSportByCode("DO003");
			
			//aggiungo utente a juniores FossaOlimpica
			
			ESFUserCategory youthFO = new ESFUserCategoryImpl();
			long userCategoryIdFO = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youthFO.setEsfUserCategoryId(userCategoryIdFO);
			youthFO.setGroupId(groupId);
			youthFO.setCompanyId(companyId);
			youthFO.setUserId(userId);
			youthFO.setUserName(userName);
			youthFO.setCreateDate(today);
			youthFO.setEsfUserId(user.getEsfUserId());
			//verifico se user maschio o donna
			if(user.getMale()){
				youthFO.setEsfCategoryId(1); //ID categoria FollaOlimpica Junior Maschile
			}else{
				youthFO.setEsfCategoryId(2); //ID categoria FollaOlimpica Junior Femminile
			}
			
			youthFO.setEsfSportTypeId(foId); //id fossa olimpica
			youthFO.setStartDate(startDate);
			youthFO.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youthFO);
			
			
			//aggiungo utente a juniores Doubletrap
			
			ESFUserCategory youthDt = new ESFUserCategoryImpl();
			long userCategoryIdDt = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youthDt.setEsfUserCategoryId(userCategoryIdDt);
			youthDt.setGroupId(groupId);
			youthDt.setCompanyId(companyId);
			youthDt.setUserId(userId);
			youthDt.setUserName(userName);
			youthDt.setCreateDate(today);
			youthDt.setEsfUserId(user.getEsfUserId());
			youthDt.setEsfCategoryId(3); //ID categoria DoubleTrap Junior Maschile
			youthDt.setEsfSportTypeId(dtId); //id doubleTrap
			youthDt.setStartDate(startDate);
			youthDt.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youthDt);
			
			
			//aggiungo utente juniores a Skeet
			
			ESFUserCategory youthSK = new ESFUserCategoryImpl();
			long userCategoryIdSK = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youthSK.setEsfUserCategoryId(userCategoryIdSK);
			youthSK.setGroupId(groupId);
			youthSK.setCompanyId(companyId);
			youthSK.setUserId(userId);
			youthSK.setUserName(userName);
			youthSK.setCreateDate(today);
			youthSK.setEsfUserId(user.getEsfUserId());
			//verifico se user maschio o donna
			if(user.getMale()){
				youthSK.setEsfCategoryId(4); //ID categoria Skeet Junior Maschile
			}else{
				youthSK.setEsfCategoryId(5); //ID Skeet Skeet Junior Femminile
			}
			
			youthSK.setEsfSportTypeId(skId); //id Skeet 
			youthSK.setStartDate(startDate);
			youthSK.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youthSK);
		}
		
		_log.info("esco dal metodo");
		
	}
	private static Log _log =
					LogFactoryUtil.getLog(ESFQualificationsFederalYouthPortlet.class);
}

