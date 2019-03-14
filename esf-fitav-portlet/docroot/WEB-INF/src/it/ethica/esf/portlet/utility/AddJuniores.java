package it.ethica.esf.portlet.utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.service.ESFCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

public class AddJuniores 
{
	
	public static ESFUser addJuniores (ESFMatchResult esfMR,ESFMatch esfM, Date inizio, Date fine )throws Exception
	{
	
		HashMap<String, Long> categorie= null;
		HashMap<String,Long> sports = ESFSportTypeLocalServiceUtil.findIDSportByName();
		try {
			categorie = ESFCategoryLocalServiceUtil.findMapLongIdCategory();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		boolean isPresent = false;
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int year=cal.get(Calendar.YEAR);
		List<ESFUserCategory> allUserCategoryForId = new ArrayList<ESFUserCategory>();
		allUserCategoryForId = ESFUserCategoryLocalServiceUtil.allESFUserCategoryByIdUtente(esfMR.getEsfPartecipantId());
		ESFUser nuovoJuniores = ESFUserLocalServiceUtil.fetchESFUser(esfMR.getEsfPartecipantId());
		long actualCategory = esfM.getEsfSportTypeId();
		long newCategory = 0;
		if(actualCategory == sports.get("Fossa Olimpica"))
		{
			if(nuovoJuniores.getMale())
			{
				newCategory = categorie.get("FOJM");
				
			}
			else
			{
				newCategory=categorie.get("FOJF");
			}
		}
		if(actualCategory==sports.get("Double Trap"))
		{
				newCategory=categorie.get("DTJM");
			
		}
		if(actualCategory == sports.get("Skeet"))
		{
			if(nuovoJuniores.getMale())
			{
				newCategory = categorie.get("SKEETJM");
			}
			else
			{
				newCategory = categorie.get("SKEETJF");
			}
		}
		for (ESFUserCategory euc:allUserCategoryForId)
		{
			cal.setTime(euc.getStartDate());
			int yearInUserCategory = cal.get(Calendar.YEAR);
			long sport = euc.getEsfCategoryId();
			if(yearInUserCategory==year && sport ==newCategory)
			{
				isPresent = true;
				break;
			}
		}
		
		if(!isPresent)
		{
			
				ESFUserCategory nuovo =  
						ESFUserCategoryLocalServiceUtil
						.createESFUserCategory(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory"));
				nuovo.setEsfUserId(nuovoJuniores.getEsfUserId());
				nuovo.setEndDate(fine);
				nuovo.setStartDate(inizio);
				nuovo.setEsfCategoryId(newCategory);//da rivedere 
				nuovo.setEsfSportTypeId(esfM.getEsfSportTypeId());
				ESFUserCategoryLocalServiceUtil.addESFUserCategory(nuovo);
				return nuovoJuniores;
		}
		return null;
	}
	
	public static void addNewJunior (ESFUser utente,Long esfCategoryId,Long esfSportTypeId, Date inizio, Date fine )throws Exception
	{
		
		boolean isPresent = false;
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int year=cal.get(Calendar.YEAR);
		List<ESFUserCategory> allUserCategoryForId = new ArrayList<ESFUserCategory>();
		allUserCategoryForId = ESFUserCategoryLocalServiceUtil.allESFUserCategoryByIdUtente(utente.getEsfUserId());
		for (ESFUserCategory euc:allUserCategoryForId)
		{
			cal.setTime(euc.getStartDate());
			int yearInUserCategory = cal.get(Calendar.YEAR);
			long sport = euc.getEsfSportTypeId();
			if(yearInUserCategory==year && sport == esfSportTypeId){
				isPresent = true;
				break;
			}
		}
		
		if(isPresent==false)
		{
			ESFUserCategory nuovo =  
					ESFUserCategoryLocalServiceUtil
					.createESFUserCategory(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory"));
			nuovo.setEsfUserId(utente.getEsfUserId());
			nuovo.setEndDate(fine);
			nuovo.setStartDate(inizio);
			nuovo.setEsfCategoryId(esfCategoryId);
			nuovo.setEsfSportTypeId(esfSportTypeId);
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(nuovo);
		}
	}
	
	public static ArrayList<ArrayList<ESFMatchResult>> returnResult(ESFMatch match) throws Exception
	{
		HashMap<String,Integer> ageForYoung = ESFConfigurationLocalServiceUtil.findAgeByName();
		/* Estraggo tutti i risultati del match, separo i junior tra maschi e femmine*/
		ArrayList<ArrayList<ESFMatchResult>> results = new ArrayList<ArrayList<ESFMatchResult>>();
		List<ESFMatchResult> risultati = 
		(List<ESFMatchResult>) ESFMatchResultLocalServiceUtil.findbyEsfMatchId(match.getEsfMatchId());
		ArrayList<ESFMatchResult> risultatiM = new ArrayList();
		ArrayList<ESFMatchResult> risultatiF = new ArrayList();
		for (ESFMatchResult emr:risultati)
		{	
			ESFUser persona = ESFUserLocalServiceUtil.fetchESFUser(emr.getEsfPartecipantId());
			Calendar yearBirth = Calendar.getInstance();
			yearBirth.setTime(persona.getBirthday());
			
			if (yearBirth.get(Calendar.YEAR)<= ageForYoung.get("fossaolimpicaEsordientiEnd")
			    && yearBirth.get(Calendar.YEAR)>= ageForYoung.get("fossaolimpicaALMBegin"))
			{ 
				if(persona.getMale())
				{
					risultatiM.add(emr);
				}
				else 
				{
					risultatiF.add(emr);
					
				}
			}
		}
		/*Ordino i risultati del match sia dei maschi che delle femmine */
		Collections.sort(risultatiM,new CustomComparator());
		Collections.sort(risultatiF,new CustomComparator());
		results.add(0,risultatiM);
		results.add(1,risultatiF);
		return results;
		/*Per ogni categoria scelgo i primi 3 posti*/
	}
}
