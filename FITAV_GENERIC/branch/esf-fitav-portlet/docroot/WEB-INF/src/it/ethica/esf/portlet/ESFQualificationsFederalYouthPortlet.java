package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFJuniores;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
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
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class QualificationsFederalYouth
 */
public class ESFQualificationsFederalYouthPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) 
				throws PortletException, IOException{
		List<ESFUser> allUsers = new ArrayList<ESFUser>();
		List<ESFUserCategory> allESFUserCategory = new ArrayList<ESFUserCategory>();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int year=cal.get(Calendar.YEAR);
		int anno =cal.get(Calendar.YEAR);
		try {
			
			//allUsers = ESFUserLocalServiceUtil.findAllUserByAgeOnlyPeople();
			allESFUserCategory = 
					ESFUserCategoryLocalServiceUtil.allESFUserCategoryByActualYear(anno);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		List<ESFUser> fossaOlimpicaEsordientiMaschi = new ArrayList<ESFUser>();
		List<ESFUser> fossaOlimpicaEsordientiFemmine = new ArrayList<ESFUser>();
		List<ESFUser> fossaOlimpicaGSMaschi = new ArrayList<ESFUser>();
		List<ESFUser> fossaOlimpicaAllieviMaschi = new ArrayList<ESFUser>();
		List<ESFUser> fossaOlimpicaAllieviFemmine = new ArrayList<ESFUser>();
		List<ESFUser> fossaOlimpicaJunioresFemmine = new ArrayList<ESFUser>();
		List<ESFUser> fossaOlimpicaJunioresMaschi = new ArrayList<ESFUser>();

		List<ESFUser> doubleTrapEsordientiMaschi = new ArrayList<ESFUser>();
		List<ESFUser> doubleTrapAllieviMaschi = new ArrayList<ESFUser>();
		List<ESFUser> doubleTrapJunioresMaschi = new ArrayList<ESFUser>();

		List<ESFUser> skeetEsordientiMaschi = new ArrayList<ESFUser>();
		List<ESFUser> skeetEsordientiFemmine = new ArrayList<ESFUser>();
		List<ESFUser> skeetAllieviMaschi = new ArrayList<ESFUser>();
		List<ESFUser> skeetAllieviFemmine = new ArrayList<ESFUser>();
		List<ESFUser> skeetJunioresFemmine = new ArrayList<ESFUser>();
		List<ESFUser> skeetJunioresMaschi = new ArrayList<ESFUser>();

		/*int yearBeginFossaOlimpicaEsordienti = 2001;
		int lunghezza = allUsers.size();
		Calendar cal = Calendar.getInstance();
				//Integer.parseInt(ESFConfigurationLocalServiceUtil.get)*/
		HashMap<String, Long> categorie= null;
		try {
			categorie = ESFCategoryLocalServiceUtil.findMapLongIdCategory();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		for (ESFUserCategory eu:allESFUserCategory)
		{
			try{
			if(eu.getEsfCategoryId()== categorie.get("FOESM")){
				fossaOlimpicaEsordientiMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("FOESF")){
				fossaOlimpicaEsordientiFemmine.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("FOGSM")){
				fossaOlimpicaGSMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("FOALM")){
				fossaOlimpicaAllieviMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("FOALF")){
				fossaOlimpicaAllieviFemmine.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("FOJM")){
				fossaOlimpicaJunioresMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("FOJF")){
				fossaOlimpicaJunioresFemmine.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("DTESM")){
				doubleTrapEsordientiMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("DTJM")){
				doubleTrapJunioresMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("SKEETJM")){
				skeetJunioresMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("DTALM")){
				doubleTrapAllieviMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("SKEETJF")){
				skeetJunioresFemmine.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("SKEETALF")){
				skeetAllieviFemmine.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("SKEETALM")){
				skeetAllieviMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("SKEETESM")){
				skeetEsordientiMaschi.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			if(eu.getEsfCategoryId()==categorie.get("SKEETESF")){
				skeetEsordientiFemmine.add(ESFUserLocalServiceUtil.getESFUser(eu.getEsfUserId()));}
			}
			catch (Exception e){
				
			}
		}
	
		request.setAttribute("fossaOlimpicaEsordientiMaschi", fossaOlimpicaEsordientiMaschi);
		request.setAttribute("fossaOlimpicaEsordientiFemmine", fossaOlimpicaEsordientiFemmine);
		request.setAttribute("fossaOlimpicaGSMaschi",fossaOlimpicaGSMaschi);
		request.setAttribute("fossaOlimpicaAllieviMaschi", fossaOlimpicaAllieviMaschi);
		request.setAttribute("fossaOlimpicaAllieviFemmine", fossaOlimpicaAllieviFemmine);
		request.setAttribute("doubleTrapEsordientiMaschi", doubleTrapEsordientiMaschi);
		request.setAttribute("doubleTrapAllieviMaschi", doubleTrapAllieviMaschi);
		request.setAttribute("skeetEsordientiMaschi", skeetEsordientiMaschi);
		request.setAttribute("skeetEsordientiFemmine", skeetEsordientiFemmine);
		request.setAttribute("skeetAllieviFemmine", skeetAllieviFemmine);
		request.setAttribute("skeetAllieviMaschi", skeetAllieviMaschi);
		request.setAttribute("skeetJunioresMaschi", skeetJunioresMaschi);
		request.setAttribute("skeetJunioresFemmine", skeetJunioresMaschi);
		request.setAttribute("fossaOlimpicaJunioresFemmine", fossaOlimpicaJunioresFemmine);
		request.setAttribute("fossaOlimpicaJunioresMaschi", fossaOlimpicaJunioresMaschi);
		request.setAttribute("doubleTrapJunioresMaschi", doubleTrapJunioresMaschi);
		super.render(request, response);
		
	}
	
	public void updateQualification(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		HashMap<String,Integer> ageForYoung = ESFConfigurationLocalServiceUtil.findAgeByName();
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
		int year=cal.get(Calendar.YEAR);
		Date gcInizio = sdf.parse("01/01/"+year);
		Date gcFine = sdf.parse("31/12/"+year);
		HashMap<String, Long> categorie= null;
		HashMap<String, Long> matchType = null;
		HashMap<String,Long> sports = ESFSportTypeLocalServiceUtil.findIDSportByName();
		try 
		{
			categorie = ESFCategoryLocalServiceUtil.findMapLongIdCategory();
			matchType = ESFMatchTypeLocalServiceUtil.allIdMatchTypeFromName();
		} 
		catch (SystemException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		year --;
		try 
		{
			allESFUserCategory =ESFUserCategoryLocalServiceUtil.allESFUserCategoryByActualYear(year);
		} 
		catch (SystemException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		/*Reinserisco in tabella i juniores che,anche in questo anno, hanno l'età giusta per essere nel settore
		   giovanile */
		for(ESFUserCategory eus: allESFUserCategory)
		{
			ESFUser eu = ESFUserLocalServiceUtil.getESFUser(eus.getEsfUserId());
			cal.setTime(eu.getBirthday());
			year = cal.get(Calendar.YEAR);
			if (year <=ageForYoung.get("fossaolimpicaEsordientiEnd") && year>=ageForYoung.get("fossaolimpicaALMBegin")){
				if (eus.getEsfCategoryId()==categorie.get("FOJM")
					||eus.getEsfCategoryId()==categorie.get("FOJF")
					||eus.getEsfCategoryId()==categorie.get("DTJM")
					||eus.getEsfCategoryId()==categorie.get("SKEETJM")
					||eus.getEsfCategoryId()==categorie.get("SKEETJF")){
					
					ESFUserCategory nuovo =  ESFUserCategoryLocalServiceUtil
							.createESFUserCategory(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory"));
					nuovo.setEsfUserId(eu.getEsfUserId());
					nuovo.setEndDate(gcFine);
					nuovo.setStartDate(gcInizio);
					nuovo.setEsfCategoryId(eus.getEsfUserCategoryId());
					nuovo.setEsfSportTypeId(eus.getEsfSportTypeId());
					ESFUserCategoryLocalServiceUtil.addESFUserCategory(nuovo);
					if(eus.getEsfCategoryId()==categorie.get("FOJM")||eus.getEsfCategoryId()==categorie.get("FOJF"))
					{
						allJunioresFO.add(eu);
					}
					if(eus.getEsfCategoryId()==categorie.get("DTJM"))
					{
						allJunioresDT.add(eu);
					}
					if(eus.getEsfCategoryId()==categorie.get("SKEETJM")
							||eus.getEsfCategoryId()==categorie.get("SKEETJF"))
					{
						allJunioresSKEET.add(eu);
					}
				}
			}
		}
		for (ESFMatch match:allMatch)
		{
			
			if(match.getIsJuniorMatch())
			{
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(match.getStartDate());
				if(cal2.get(Calendar.YEAR)== (Calendar.getInstance().get(Calendar.YEAR)-1))
				{
					
						/*Criterium */
						if(match.getEsfMatchTypeId()==matchType.get("criterium nazionale"));
						{
							
							/*Fossa Olimpica */
							if(match.getEsfSportTypeId()==sports.get("Fossa Olimpica"))
							{
							
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumFOM= risultati.get(0);
								
								if(risultatiCriteriumFOM.size()>2)
								{
									for(int i = 0; i<3;i++)
									{
										ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumFOM.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresM))
										{
											allJunioresFO.add(nuovoJuonioresM);
										}
									}
								}
								ArrayList<ESFMatchResult> risultatiCriteriumFOF= risultati.get(1);
								if(risultatiCriteriumFOF.size()>2)
								{
								/*Per ogni categoria scelgo i primi 3 posti*/
								
									for(int i = 0; i<3;i++)
									{
										ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCriteriumFOF.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresF))
										{
											allJunioresFO.add(nuovoJuonioresF);
										}
									}
								}
						
							}
							/* Skeet  */
							if( match.getEsfSportTypeId()==sports.get("Skeet"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumSKEETM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiCriteriumSKEETF= risultati.get(1);
								/*Per ogni categoria scelgo i primi 3 posti*/
								if(risultatiCriteriumSKEETM.size()>0)
								{
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumSKEETM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresSKEET.add(nuovoJuonioresM);
									}	
								}
								
								if(risultatiCriteriumSKEETF.size()>0)
								{
										ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCriteriumSKEETF.get(0), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresF))
										{
											allJunioresSKEET.add(nuovoJuonioresF);
										}
								}
							
							}
							/* Double Trap*/
							if( match.getEsfSportTypeId()==sports.get("Double Trap"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumDTM= risultati.get(0);
								if(risultatiCriteriumDTM.size()>0)
								{
									/*Per ogni categoria scelgo i primi 3 posti*/
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumDTM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresDT.add(nuovoJuonioresM);
									}
								}
							}	
						/*Campionato Italiano SG*/
						if(match.getEsfMatchTypeId()==matchType.get("CAMPIONATO ITALIANO S.G."))
						{ 
							/*Fossa Olimpica*/
							if(match.getEsfSportTypeId()==sports.get("Fossa Olimpica"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCIFOM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiCIFOF= risultati.get(1);
								if(risultatiCIFOM.size()>=3)
								{
									for (int i = 0;i<3;i++)
									{
									
										ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCIFOF.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresF))
										{
											allJunioresFO.add(nuovoJuonioresF);
										}
									}
								}
								if(risultatiCIFOM.size()>=3)
								{
									int allievi = 0;
									int gs=0;
									int count = 0;
									while(allievi!=5 && gs!=2)
									{
										if(count>risultatiCIFOM.size()) break;
										Calendar yearAllievo = Calendar.getInstance();
										ESFUser nuovoJuonioresM = ESFUserLocalServiceUtil.fetchESFUser(risultatiCIFOM.get(count).getEsfPartecipantId());
										yearAllievo.setTime(nuovoJuonioresM.getBirthday());
										if(yearAllievo.get(Calendar.YEAR)<=2000)
										{
											if(gs<2)
											{
												ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCIFOF.get(count), match, gcInizio,gcFine);
												if(Validator.isNotNull(nuovoJuonioresF))
												{
													allJunioresFO.add(nuovoJuonioresF);
												}
												gs++;
											}
										
										}
										else
										{
											if(allievi<5)
											{
												ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiCIFOF.get(count), match, gcInizio,gcFine);
												if(Validator.isNotNull(nuovoJuonioresF))
												{
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
							/*Skeet */
							if(match.getEsfSportTypeId()==sports.get("Skeet"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiF= risultati.get(1);
								if(risultatiM.size()>0)
								{
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresSKEET.add(nuovoJuonioresM);
									}
								}
								if(risultatiF.size()>0)
								{
									ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiF.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresF))
									{
										allJunioresSKEET.add(nuovoJuonioresF);
									}
								}
							}
							/*Double Trap*/
							if(match.getEsfSportTypeId()==sports.get("Double Trap"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								if(risultatiM.size()>0)
								{
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresDT.add(nuovoJuonioresM);
									}
								}
							}
						  }
						
						/*Gran Premio Open Source NORD SUD CENTRO*/
						if(match.getEsfMatchTypeId()==matchType.get("GRAN PREMIO OPEN NORD S.G.")||
						   match.getEsfMatchTypeId()==matchType.get("GRAN PREMIO OPEN CENTRO S.G.")||
						   match.getEsfMatchTypeId()==matchType.get("GRAN PREMIO OPEN SUD S.G."))
						{
							/*Fossa Olimpica */
							if(match.getEsfSportTypeId()==sports.get("Fossa Olimpica"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								if(risultatiM.size()>=2)
								{
									for(int i = 0; i<2;i++)
									{
										ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(i), match, gcInizio,gcFine);
										if(Validator.isNotNull(nuovoJuonioresM))
										{
											allJunioresFO.add(nuovoJuonioresM);
										}
									}
								}
							}
							/*Double Trap*/
							if(match.getEsfSportTypeId()==sports.get("Double Trap"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiCriteriumDTM= risultati.get(0);
								if(risultatiCriteriumDTM.size()>0)
								{
									/*Per ogni categoria scelgo i primi 3 posti*/
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiCriteriumDTM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresDT.add(nuovoJuonioresM);
									}
								}
							}
							/*Skeet */
							if(match.getEsfSportTypeId()==sports.get("Skeet"))
							{
								ArrayList<ArrayList<ESFMatchResult>> risultati = AddJuniores.returnResult(match);
								ArrayList<ESFMatchResult> risultatiM= risultati.get(0);
								ArrayList<ESFMatchResult> risultatiF= risultati.get(1);
								if(risultatiM.size()>0)
								{
									ESFUser nuovoJuonioresM = AddJuniores.addJuniores(risultatiM.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresM))
									{
										allJunioresSKEET.add(nuovoJuonioresM);
									}
								}
								if(risultatiF.size()>0)
								{
									ESFUser nuovoJuonioresF = AddJuniores.addJuniores(risultatiF.get(0), match, gcInizio,gcFine);
									if(Validator.isNotNull(nuovoJuonioresF))
									{
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
		/*Aggiungo i nuovi iscritti ovvero shooter che non hanno ancora qualifica e saranno assegnati solo in base all'età*/
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
					/*	fossaOlimpicaEsordientiMaschi.add(eu);
						doubleTrapEsordientiMaschi.add(eu);
						skeetEsordientiMaschi.add(eu);*/
						
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
					/*	fossaOlimpicaEsordientiFemmine.add(eu);
						skeetEsordientiFemmine.add(eu);*/
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
					/*	fossaOlimpicaGSMaschi.add(eu);
						doubleTrapAllieviMaschi.add(eu);
						skeetAllieviMaschi.add(eu);*/
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
					/*	fossaOlimpicaAllieviFemmine.add(eu);
						skeetAllieviFemmine.add(eu);*/
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
					/*	fossaOlimpicaAllieviMaschi.add(eu);
						doubleTrapAllieviMaschi.add(eu);
						skeetAllieviMaschi.add(eu);*/
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
					/*	fossaOlimpicaAllieviFemmine.add(eu);
						skeetAllieviFemmine.add(eu);*/
					}
			    	
			    }
				
			}
		    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			
		}
	}
}

