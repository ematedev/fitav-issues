package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFDescription;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.impl.ESFUserCategoryBaseImpl;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFMatchLocalServiceImpl;
import it.ethica.esf.service.impl.ESFUserCategoryLocalServiceImpl;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFChangeOfCategory
 */
public class ESFChangeOfCategoryPortlet extends MVCPortlet {
	
	private Log _log = LogFactoryUtil.getLog(ESFChangeOfCategoryPortlet.class);
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
		
		
		
		super.render(request, response);

	}
	
 
	public void computes(ActionRequest request, ActionResponse response) 
			throws PortalException, SystemException, ParseException{
		
		PortletSession session  = request.getPortletSession();
		
		boolean IsChangeCategory = true;
		int minNumMatch = ESFKeys.ESFCategoryChanges.minNumberMatchs;
		String fossa_Olimpica = "fossa_Olimpica";
		
		int minPercent2TO1 = ESFKeys.ESFCategoryChanges.minPercent2TO1;
		int minPercent3TO2 = ESFKeys.ESFCategoryChanges.minPercent3TO2;
		int minPercent1TO2 = ESFKeys.ESFCategoryChanges.minPercent1TO2;
		int minPercent2TO3 = ESFKeys.ESFCategoryChanges.minPercent2TO3;
		int minPercentGP = ESFKeys.ESFCategoryChanges.minPercentGP;
		int minShooterFirstCategory = ESFKeys.ESFCategoryChanges.minShooterFirstCategory;
		int minPercent2TO1SK = ESFKeys.ESFCategoryChanges.minPercent2TO1SK;
		int minPercent3TO2SK = ESFKeys.ESFCategoryChanges.minPercent3TO2SK;
		int minPercent2TO1CK = ESFKeys.ESFCategoryChanges.minPercent2TO1CK;
		int minPercent3TO2CK = ESFKeys.ESFCategoryChanges.minPercent3TO2CK;
		int minPercentETO1CK = ESFKeys.ESFCategoryChanges.minPercentETO1CK;
		int minPercent1TO2CK = ESFKeys.ESFCategoryChanges.minPercent1TO2CK;
		
		List<Integer> valueFO = new ArrayList<Integer>();
		List<Integer> percentVotes = new ArrayList<Integer>();
		List<Long> idPossibleShooterFO = new ArrayList<Long>();
		List<Long> idShooterFOGP = new ArrayList<Long>();
		List<Long> idPossibleShooterFirstCategoryFO = new ArrayList<Long>();
		List<Long> idPossibleShooterSecondCategoryFO = new ArrayList<Long>();
		List<Long> idPossibleShooterThirdCategoryFO = new ArrayList<Long>();
		List<Long> idPossibleShooterFirstCategoryFOUnique = new ArrayList<Long>();
		List<Long> idPossibleShooterSecondCategoryFOUnique = new ArrayList<Long>();
		List<Long> idPossibleShooterThirdCategoryFOUnique = new ArrayList<Long>();
		List<Long> idPossiblePass2To1 = new ArrayList<Long>();
		List<Long> idPossiblePass3To2 = new ArrayList<Long>();
		List<Long> idPossiblePass1To2 = new ArrayList<Long>();
		List<Long> idPossiblePass2To3 = new ArrayList<Long>();
		List<ESFUser> userRetrocessedFirstCategory = new ArrayList<ESFUser>();
		List<ESFUser> userPromovedSecondCategory = new ArrayList<ESFUser>();
		List<ESFUser> userRetrocessedSecondCategory = new ArrayList<ESFUser>();
		List<ESFUser> userPromovedThirdCategory = new ArrayList<ESFUser>();
		
		List<ESFUser> userPromovedThirdCategorySK = new ArrayList<ESFUser>();
		List<ESFUser> userPromovedSecondCategorySK = new ArrayList<ESFUser>();
		List<ESFUser> userRetrocededSecondCategoryDT = new ArrayList<ESFUser>();
		List<ESFUser> userPromovedThirdCategoryCK = new ArrayList<ESFUser>();
		List<ESFUser> userPromovedSecondCategoryCK = new ArrayList<ESFUser>();
		List<ESFUser> userRetrocessedFirstCategoryCK = new ArrayList<ESFUser>();
		List<ESFUser> userRetrocessedExcellenceCategoryCK = new ArrayList<ESFUser>();
		
		int percent = 0;
		int somm = 0;
		List<Integer> substring = new ArrayList<Integer>();
		
		HashMap<Long, List<Integer>> shooterFirstCategoryFO = new HashMap<Long, List<Integer>>();
		HashMap<Long, List<Integer>> shooterSecondCategoryFO = new HashMap<Long, List<Integer>>();
		HashMap<Long, List<Integer>> shooterThirdCategoryFO = new HashMap<Long, List<Integer>>();
		
		HashMap<Long, List<Integer>> shooterFirstCategoryFOMinMatch = new HashMap<Long, List<Integer>>();
		HashMap<Long, List<Integer>> shooterSecondCategoryFOMinMatch = new HashMap<Long, List<Integer>>();
		HashMap<Long, List<Integer>> shooterThirdCategoryFOMinMatch = new HashMap<Long, List<Integer>>();
		
		HashMap<Long, Integer> shooterFirstCategoryPercent = new HashMap<Long, Integer>();
		HashMap<Long, Integer> shooterSecondCategoryPercent = new HashMap<Long, Integer>();
		HashMap<Long, Integer> shooterThirdCategoryPercent = new HashMap<Long, Integer>();
		
		HashMap<Integer, List<Long>> shooterFirstCategoryResult = new HashMap<Integer, List<Long>>();
		HashMap<Integer, List<Long>> shooterSecondCategoryResult = new HashMap<Integer, List<Long>>();
		HashMap<Integer, List<Long>> shooterThirdCategoryResult = new HashMap<Integer, List<Long>>();
		
		HashMap<Integer, List<Long>> shooterFirstCategoryResultOrdered = new HashMap<Integer, List<Long>>();
		
		List<ESFPartecipant> esfPartecipants = null;
		String calculate = "calculate";
		String print = ParamUtil.getString(request, "print");
		
		long speciality = ParamUtil.getLong(request, "speciality");
		
		int year = ParamUtil.getInteger(request, "year");
		
		//verifica funzionalità finder//

		//verifica del distanzimento per la categoria Fossa Olimpica//
		
		if(speciality == 11217 || speciality == 0){
			
			Long sportType = (long) 11217 ;
			Long descriptionid = (long) 5;//id della descrizione Gran Premio
			
			List<ESFMatch> matchsSelectedFossaOlimpica = new ArrayList<ESFMatch>();
			
			matchsSelectedFossaOlimpica = ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(IsChangeCategory, 11217, year);//match fossa olimpica
			
			List<ESFMatch> matchsSelectedFossaOlimpicaGP = new ArrayList<ESFMatch>();
			
			matchsSelectedFossaOlimpicaGP = ESFMatchLocalServiceUtil.findbyIsChangeCategoryYearDescription(IsChangeCategory, 11217, year, descriptionid);//match fossa olimpica con descrizione Gran Premio
			
			/*
			if(Validator.isNotNull(matchsSelectedFossaOlimpica)){
			}
			
			if(Validator.isNotNull(matchsSelectedFossaOlimpicaGP)){
			}
			*/
			
			List<ESFMatchResult> matchResultsFO = new ArrayList<ESFMatchResult>();
			List<ESFMatchResult> matchResultsFOGP = new ArrayList<ESFMatchResult>();
			
			
			for(ESFMatch match : matchsSelectedFossaOlimpica){
				matchResultsFO.addAll(ESFMatchResultLocalServiceUtil.findbyEsfMatchId(match.getEsfMatchId()));
			}
			
			for(ESFMatch match : matchsSelectedFossaOlimpicaGP){
				matchResultsFOGP.addAll(ESFMatchResultLocalServiceUtil.findbyEsfMatchId(match.getEsfMatchId()));
			}
			
			/*
			if(Validator.isNotNull(matchResultsFO)){
			}	
			
			if(Validator.isNotNull(matchResultsFOGP)){
			}	*/
			
			//insersco id dei tiratori
			
			for(ESFMatchResult matchResult : matchResultsFO){
				if(!idPossibleShooterFO.contains(matchResult.getEsfPartecipantId())){
					idPossibleShooterFO.add(matchResult.getEsfPartecipantId());
				}
			}
			
			int percentGP = 0;
			
			//insersco id dei tiratori dei GP della prima categoria con percentuale che mi interessa
			
			for(ESFMatchResult matchResultGP : matchResultsFOGP){
				
				if(!idShooterFOGP.contains(matchResultGP.getEsfPartecipantId()) && matchResultGP.getCategoryName().equals("1")){
					percentGP = 0;
					percentGP =(100*matchResultGP.getNextTotalPlayOff())/
							(ESFMatchLocalServiceUtil.fetchESFMatch(matchResultGP.getEsfMatchId()).getNumDisk());
					if(percentGP>=minPercentGP){
						idShooterFOGP.add(matchResultGP.getEsfPartecipantId());
					}
				}
			}
			
			/*
			if(Validator.isNotNull(idPossibleShooterFO)){
			}
			
			if(Validator.isNotNull(idShooterFOGP)){
			}
			
			if(Validator.isNotNull(idShooterFOGP)){
			}*/
			
			//separo i tiratori per categoria//
			
			for(Long l : idPossibleShooterFO){
				for(ESFMatchResult matchResult : matchResultsFO){
					if(matchResult.getEsfPartecipantId() == l && matchResult.getCategoryName().equals("1")){
						idPossibleShooterFirstCategoryFO.add(l);
					}else if(matchResult.getEsfPartecipantId() == l && matchResult.getCategoryName().equals("2")){
						idPossibleShooterSecondCategoryFO.add(l);
					}else if(matchResult.getEsfPartecipantId() == l && matchResult.getCategoryName().equals("3")){
						idPossibleShooterThirdCategoryFO.add(l);
					}
				}
			}
			/*
			if(Validator.isNotNull(idPossibleShooterFirstCategoryFO)){
			}
			if(Validator.isNotNull(idPossibleShooterSecondCategoryFO)){
			}
			if(Validator.isNotNull(idPossibleShooterThirdCategoryFO)){
			}*/

			//elimino le ridondanze degli id quindi ogni id compare nella giusta categoria una volta sola//
			
			for(int i = 0 ; i < idPossibleShooterFirstCategoryFO.size() ; i++){
				if(!idPossibleShooterFirstCategoryFOUnique.contains(idPossibleShooterFirstCategoryFO.get(i))){
					idPossibleShooterFirstCategoryFOUnique.add(idPossibleShooterFirstCategoryFO.get(i));
				}
			}
			
			idPossibleShooterFirstCategoryFOUnique.removeAll(idShooterFOGP);
			
			for(int i = 0 ; i < idPossibleShooterSecondCategoryFO.size() ; i++){
				if(!idPossibleShooterSecondCategoryFOUnique.contains(idPossibleShooterSecondCategoryFO.get(i))){
					idPossibleShooterSecondCategoryFOUnique.add(idPossibleShooterSecondCategoryFO.get(i));
				}
			}
			
			for(int i = 0 ; i < idPossibleShooterThirdCategoryFO.size() ; i++){
				if(!idPossibleShooterThirdCategoryFOUnique.contains(idPossibleShooterThirdCategoryFO.get(i))){
					idPossibleShooterThirdCategoryFOUnique.add(idPossibleShooterThirdCategoryFO.get(i));
				}
			}
			
/*
			if(Validator.isNotNull(idPossibleShooterFirstCategoryFOUnique)){
			}
			if(Validator.isNotNull(idPossibleShooterSecondCategoryFO)){
			}
			if(Validator.isNotNull(idPossibleShooterThirdCategoryFO)){
			}*/
			
			///riempio le hashmap con i valori dei risultati riportati come percentuale sul totale possibile

			for(Long l : idPossibleShooterFirstCategoryFOUnique){
					valueFO = new ArrayList<Integer>();
					for(ESFMatchResult match : matchResultsFO){
						if(match.getEsfPartecipantId() == l){
							int totalChecked = match.getNextTotalPlayOff();
							int total = ESFMatchLocalServiceUtil.fetchESFMatch(match.getEsfMatchId()).getNumDisk();
							valueFO.add(Integer.valueOf((100*totalChecked)/total));
						}
					}
					shooterFirstCategoryFO.put(l, valueFO);
				}
				
				for(Long l : idPossibleShooterSecondCategoryFOUnique){
					valueFO = new ArrayList<Integer>();
					for(ESFMatchResult match : matchResultsFO){
						if(match.getEsfPartecipantId() == l){
							int totalChecked = match.getNextTotalPlayOff();
							int total = ESFMatchLocalServiceUtil.fetchESFMatch(match.getEsfMatchId()).getNumDisk();
							valueFO.add(Integer.valueOf((100*totalChecked)/total));
						}
					}
					shooterSecondCategoryFO.put(l, valueFO);
				}
				
				for(Long l : idPossibleShooterThirdCategoryFOUnique){
					valueFO = new ArrayList<Integer>();
					for(ESFMatchResult match : matchResultsFO){
						if(match.getEsfPartecipantId() == l){
							int totalChecked = match.getNextTotalPlayOff();
							int total = ESFMatchLocalServiceUtil.fetchESFMatch(match.getEsfMatchId()).getNumDisk();
							valueFO.add(Integer.valueOf((100*totalChecked)/total));
						}
					}
					shooterThirdCategoryFO.put(l, valueFO);
				}
			/*
				if(Validator.isNotNull(shooterFirstCategoryFO)){
				}
				if(Validator.isNotNull(shooterSecondCategoryFO)){
				}
				if(Validator.isNotNull(shooterThirdCategoryFO)){
				}*/
			
			//controllo che il numero di match sia almeno il minimo richisto per il cambio di categoria//
				
				Set<Long> setKey1 = shooterFirstCategoryFO.keySet();
				Set<Long> setKey2 = shooterSecondCategoryFO.keySet();
				Set<Long> setKey3 = shooterThirdCategoryFO.keySet();
				List<Integer> result = new ArrayList<Integer>();
				
				
				//minNumMatch modificato per prova
				//minNumMatch = 1;
				
				for(Long key : setKey1){
					if(shooterFirstCategoryFO.get(key).size()>minNumMatch){
						result = new ArrayList<Integer>();
						result=shooterFirstCategoryFO.get(key);
						Collections.sort(result);
						shooterFirstCategoryFOMinMatch.put(key, result);
					}
				}
				
				for(Long key : setKey2){
					if(shooterSecondCategoryFO.get(key).size()>minNumMatch){
						result = new ArrayList<Integer>();
						result = shooterSecondCategoryFO.get(key);
						Collections.sort(result);
						shooterSecondCategoryFOMinMatch.put(key, result);
					}
				}

				for(Long key : setKey3){
					if(shooterThirdCategoryFO.get(key).size()>minNumMatch){
						result = new ArrayList<Integer>();
						result = shooterThirdCategoryFO.get(key);
						Collections.sort(result);
						shooterThirdCategoryFOMinMatch.put(key, result);
					}
				}
			
				/*
				if(Validator.isNotNull(shooterFirstCategoryFOMinMatch)){
				}
				if(Validator.isNotNull(shooterSecondCategoryFOMinMatch)){
				}
				if(Validator.isNotNull(shooterThirdCategoryFOMinMatch)){
				}*/

				//ordino i risulatati per ogni tiratore, inserisco i soli risultati migliori e infine ad ogni tiratore associo la media dei suoi risultati//
				
				Set<Long> setKey1MinMatch = shooterFirstCategoryFOMinMatch.keySet();
				Set<Long> setKey2MinMatch = shooterSecondCategoryFOMinMatch.keySet();
				Set<Long> setKey3MinMatch = shooterThirdCategoryFOMinMatch.keySet();


				for(Long key : setKey1MinMatch){
					result = new ArrayList<Integer>();
					substring = new ArrayList<Integer>();
					result=shooterFirstCategoryFOMinMatch.get(key);
					percent = (90*result.size())/100;
					substring.addAll(result.subList((result.size()-percent), result.size()));
					int i = 0;
					somm=0;
					for( i = 0 ; i < substring.size() ; i++){
						somm = somm + substring.get(i);
					}
					shooterFirstCategoryPercent.put(key, (somm/i));
				}
				
				for(Long key : setKey2MinMatch){
					result = new ArrayList<Integer>();
					substring = new ArrayList<Integer>();
					result=shooterSecondCategoryFOMinMatch.get(key);
					percent = (90*result.size())/100;
					substring.addAll(result.subList((result.size()-percent), result.size()));
					int i = 0;
					somm=0;
					for( i = 0 ; i < substring.size() ; i++){
						somm = somm + substring.get(i);
					}
					shooterSecondCategoryPercent.put(key, (somm/i));
				}
				
				for(Long key : setKey3MinMatch){
					result = new ArrayList<Integer>();
					substring = new ArrayList<Integer>();
					result=shooterThirdCategoryFOMinMatch.get(key);
					percent = (90*result.size())/100;
					substring.addAll(result.subList((result.size()-percent), result.size()));
					int i = 0;
					somm=0;
					for( i = 0 ; i < substring.size() ; i++){
						somm = somm + substring.get(i);
					}
					shooterThirdCategoryPercent.put(key, (somm/i));
				}
				
				//shooterFirstCategoryResult 
				//shooterSecondCategoryResult 
				//shooterThirdCategoryResult
				
				Set<Long> setKey1Result = shooterFirstCategoryPercent.keySet();
				Set<Long> setKey2Result = shooterSecondCategoryPercent.keySet();
				Set<Long> setKey3Result = shooterThirdCategoryPercent.keySet();
				List<Long> idAtResult = new ArrayList<Long>();
				
				for(Long key : setKey1Result){
					idAtResult = new ArrayList<Long>();
					
					
					if(shooterFirstCategoryResult.containsKey(shooterFirstCategoryPercent.get(key))){
						shooterFirstCategoryResult.get(shooterFirstCategoryPercent.get(key)).add(key);
					}else{
						idAtResult = new ArrayList<Long>();
						idAtResult.add(key);
						shooterFirstCategoryResult.put(shooterFirstCategoryPercent.get(key), idAtResult);
					}
				}
				
				for(Long key : setKey2Result){
					idAtResult = new ArrayList<Long>();
					
					
					if(shooterSecondCategoryResult.containsKey(shooterSecondCategoryPercent.get(key))){
						shooterSecondCategoryResult.get(shooterSecondCategoryPercent.get(key)).add(key);
					}else{
						idAtResult = new ArrayList<Long>();
						idAtResult.add(key);
						shooterSecondCategoryResult.put(shooterSecondCategoryPercent.get(key), idAtResult);
					}
				}

				for(Long key : setKey3Result){
					idAtResult = new ArrayList<Long>();
					
					
					if(shooterThirdCategoryResult.containsKey(shooterThirdCategoryPercent.get(key))){
						shooterThirdCategoryResult.get(shooterThirdCategoryPercent.get(key)).add(key);
					}else{
						idAtResult = new ArrayList<Long>();
						idAtResult.add(key);
						shooterThirdCategoryResult.put(shooterThirdCategoryPercent.get(key), idAtResult);
					}
				}
				
				Set<Integer> setKey1Pass = shooterFirstCategoryResult.keySet();
				for(Integer key : setKey1Pass){
					percentVotes.add(key);
				}
				
				Collections.sort(percentVotes);		
				int primacateogoriapresenti = 0;
				List<ESFUserCategory> firstCategoriFo = ESFUserCategoryLocalServiceUtil.findUserFO(sportType);
				
				if(Validator.isNotNull(firstCategoriFo)){
					primacateogoriapresenti = firstCategoriFo.size();
				}
				
				//creare finder che cerca nella prima categoria FO quanti tiratori sono presenti
				Set<Integer> setKey2Pass = shooterSecondCategoryResult.keySet();
				Set<Integer> setKey3Pass = shooterThirdCategoryResult.keySet();
				
				//controllo qui
				boolean notMin = true;
				
				for(Integer key : percentVotes){
					if(key < minPercent1TO2 && notMin){
						if((primacateogoriapresenti -(shooterFirstCategoryResult.get(key).size())>= minShooterFirstCategory)){
						idPossiblePass1To2.addAll(shooterFirstCategoryResult.get(key));
						primacateogoriapresenti= primacateogoriapresenti-(shooterFirstCategoryResult.get(key).size());
						}else{
							notMin=false;
						}
					}
				}
				//rimuovo i tiratori che hanno raggiunto il punteggio sufficiente nei GP
				//verifico che il numero di tiratori in prima categoria non scenda sotto i 400
				
				
				for(Integer key : setKey2Pass){
					_log.debug("key="+key);
					_log.debug("minPercent2TO3="+minPercent2TO3);
					if(key < minPercent2TO3){
						idPossiblePass2To3.addAll(shooterSecondCategoryResult.get(key));
					}else if(key > minPercent2TO1){
						idPossiblePass2To1.addAll(shooterSecondCategoryResult.get(key));
					}
					
				}
				
				for(Integer key : setKey3Pass){
					
					if(key > minPercent3TO2){
						idPossiblePass3To2.addAll(shooterThirdCategoryResult.get(key));
					}
					
				}
				
				
				if(Validator.isNotNull(idPossiblePass1To2)){
					for(int i = 0 ; i<idPossiblePass1To2.size();i++){
						userRetrocessedFirstCategory.add(ESFUserLocalServiceUtil.fetchESFUser(idPossiblePass1To2.get(i)));
					}
				}
				
				if(Validator.isNotNull(idPossiblePass2To1)){
					for(int i = 0 ; i<idPossiblePass2To1.size();i++){
						userPromovedSecondCategory.add(ESFUserLocalServiceUtil.fetchESFUser(idPossiblePass2To1.get(i)));
					}
				}
				
				if(Validator.isNotNull(idPossiblePass2To3)){
					for(int i = 0 ; i<idPossiblePass2To3.size();i++){
						userRetrocessedSecondCategory.add(ESFUserLocalServiceUtil.fetchESFUser(idPossiblePass2To3.get(i)));
					}
				}
				
				if(Validator.isNotNull(idPossiblePass3To2)){
					for(int i = 0 ; i<idPossiblePass3To2.size();i++){
						userPromovedThirdCategory.add(ESFUserLocalServiceUtil.fetchESFUser(idPossiblePass3To2.get(i)));
					}
				}
				
				session.setAttribute("userPromovedSecondCategory", userPromovedSecondCategory);
				session.setAttribute("userRetrocessedSecondCategory", userRetrocessedSecondCategory);
				session.setAttribute("userRetrocessedFirstCategory", userRetrocessedFirstCategory);
				session.setAttribute("userPromovedThirdCategory", userPromovedThirdCategory);
				session.setAttribute("fossa_Olimpica", String.valueOf(fossa_Olimpica));

				response.setRenderParameter("esfsporttypeFO", String.valueOf(11217));

		}
		
		if(speciality == 12932 || speciality == 0){
			String skeet = "skeet";
			
			int percentSK= 0;
			List<ESFMatch> matchsSelectedSkeet = new ArrayList<ESFMatch>();
			matchsSelectedSkeet = ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(IsChangeCategory, 12932, year);//match skeet
			
			List<ESFMatchResult> matchResultsSK = new ArrayList<ESFMatchResult>();
			List<Long> idUserSecondCategorySK = new ArrayList<Long>();
			List<Long> idUserThirdCategorySK = new ArrayList<Long>();
			List<Integer> resultSK = new ArrayList<Integer>();
			List<Long> idUserPass3_2SK = new ArrayList<Long>();
			List<Long> idUserPass2_1SK = new ArrayList<Long>();
			
			HashMap<Long, List<Integer>> shooterThirdCategorySK = new HashMap<Long, List<Integer>>();
			HashMap<Long, List<Integer>> shooterSecondCategorySK = new HashMap<Long, List<Integer>>();
			
			for(ESFMatch match : matchsSelectedSkeet){
				matchResultsSK.addAll(ESFMatchResultLocalServiceUtil.findbyEsfMatchId(match.getEsfMatchId()));
			}
			
			List<Long> idPossibleShooterSK = new ArrayList<Long>();
			
			for(ESFMatchResult matchResult : matchResultsSK){
				if(!idPossibleShooterSK.contains(matchResult.getEsfPartecipantId())){
					idPossibleShooterSK.add(matchResult.getEsfPartecipantId());
				}
			}
			
			//creo una lista con gli id dei tiratori della seconda e della terza categria
			
			for(Long l : idPossibleShooterSK){
				for(ESFMatchResult matchResult : matchResultsSK){
					if(matchResult.getEsfPartecipantId() == l && matchResult.getCategoryName().equals("2")){
						idUserSecondCategorySK.add(l);
					}else if(matchResult.getEsfPartecipantId() == l && matchResult.getCategoryName().equals("3")){
						idUserThirdCategorySK.add(l);
					}
				}
			}
			
			//riempio una hashmap con i risultati dei tiratori della seconda e della terza categoria ordinando i risultati
			for(Long id : idUserSecondCategorySK){
				int numDisk;
				int result;
				resultSK = new ArrayList<Integer>();
				for(ESFMatchResult matchresult : matchResultsSK){
					if(matchresult.getEsfPartecipantId() == id ){
						numDisk = ESFMatchLocalServiceUtil.fetchESFMatch(matchresult.getEsfMatchId()).getNumDisk();
						result = (matchresult.getNextTotalPlayOff()*100)/numDisk;
						resultSK.add(result);
					}
				}
				Collections.sort(resultSK);
				shooterSecondCategorySK.put(id, resultSK);
			}
			for(Long id : idUserThirdCategorySK){
				int result;
				int numDisk;
				resultSK = new ArrayList<Integer>();
				for(ESFMatchResult matchresult : matchResultsSK){
					if(matchresult.getEsfPartecipantId() == id ){
						numDisk = ESFMatchLocalServiceUtil.fetchESFMatch(matchresult.getEsfMatchId()).getNumDisk();
						result = (matchresult.getNextTotalPlayOff()*100)/numDisk;
						resultSK.add(result);
					}
				}
				Collections.sort(resultSK);
				shooterThirdCategorySK.put(id, resultSK);
			}
			//prelevo il 90% delle migliori gare e se il risultato supera la percentuale minima aggiungo ai possibili prouovibili
			
			Set<Long> setKey2SK = shooterSecondCategorySK.keySet();
			Set<Long> setKey3SK = shooterThirdCategorySK.keySet();
			
			//per testare
			minPercent2TO1SK = 50;
			minPercent3TO2SK= 50;
			
			
			for(Long key : setKey2SK){
				resultSK = new ArrayList<Integer>();
				substring = new ArrayList<Integer>();
				resultSK=shooterSecondCategorySK.get(key);
				percent = (90*resultSK.size())/100;
				substring.addAll(resultSK.subList((resultSK.size()-percent), resultSK.size()));
				int i = 1;
				somm=0;
				//for(  ; i < substring.size()+1; i++){
				for(  ; i < substring.size(); i++){
					somm = somm + substring.get(i);
				}
				somm=somm/i;
				if(somm>=minPercent2TO1SK){
					idUserPass2_1SK.add(key);
				}
			}
			
			for(Long key : setKey3SK){
				resultSK = new ArrayList<Integer>();
				substring = new ArrayList<Integer>();
				resultSK=shooterThirdCategorySK.get(key);
				percent = (90*resultSK.size())/100;
				substring.addAll(resultSK.subList((resultSK.size()-percent), resultSK.size()));
				int i = 1;
				somm=0;
				//for(  ; i < substring.size()+1 ; i++){
				for(  ; i < substring.size() ; i++){
					somm = somm + substring.get(i);
				}
				somm=somm/i;
				if(somm>=minPercent3TO2SK){
					idUserPass3_2SK.add(key);
				}
			}
			_log.debug("entro in skeet idUserPass3_2SK="+idUserPass3_2SK);
			_log.debug("entro in skeet idUserPass2_1SK="+idUserPass2_1SK);
			
			for(Long l : idUserPass3_2SK){
				userPromovedThirdCategorySK.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			
			for(Long l : idUserPass2_1SK){
				userPromovedSecondCategorySK.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			_log.debug("entro in skeet userPromovedThirdCategorySK="+userPromovedThirdCategorySK);
			_log.debug("entro in skeet userPromovedSecondCategorySK="+userPromovedSecondCategorySK);
			
			
			session.setAttribute("userPromovedThirdCategorySK", userPromovedThirdCategorySK);
			session.setAttribute("userPromovedSecondCategorySK", userPromovedSecondCategorySK);
			session.setAttribute("skeet", String.valueOf(skeet));
			//response.setRenderParameter("skeet", String.valueOf(skeet));
		}
		
		/////////////////////////////////////////////////////
		///////////////////compak////////////////////////////
		/////////////////////////////////////////////////////
		
		
		
		
		
		if(speciality == 12933 || speciality == 0){
			String compak = "compak";
			
			List<ESFMatch> matchsSelectedCK = new ArrayList<ESFMatch>();
			matchsSelectedCK = ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(IsChangeCategory, 12933, year);//match compak
			
			List<ESFMatchResult> matchResultsCK = new ArrayList<ESFMatchResult>();
			List<Long> idUserExcellenceCategoryCK = new ArrayList<Long>();
			List<Long> idUserFirstCategoryCK = new ArrayList<Long>();
			List<Long> idUserSecondCategoryCK = new ArrayList<Long>();
			List<Long> idUserThirdCategoryCK = new ArrayList<Long>();
			List<Integer> resultCK = new ArrayList<Integer>();
			List<Long> idUserPass3_2CK = new ArrayList<Long>();
			List<Long> idUserPass2_1CK = new ArrayList<Long>();
			List<Long> idUserPassE_1CK = new ArrayList<Long>();
			List<Long> idUserPass1_2CK = new ArrayList<Long>();
			
			HashMap<Long, List<Integer>> shooterThirdCategoryCK = new HashMap<Long, List<Integer>>();
			HashMap<Long, List<Integer>> shooterSecondCategoryCK = new HashMap<Long, List<Integer>>();
			HashMap<Long, List<Integer>> shooterFirstCategoryCK = new HashMap<Long, List<Integer>>();
			HashMap<Long, List<Integer>> shooterExcellenceCategoryCK = new HashMap<Long, List<Integer>>();
			
			for(ESFMatch match : matchsSelectedCK){
				matchResultsCK.addAll(ESFMatchResultLocalServiceUtil.findbyEsfMatchId(match.getEsfMatchId()));
			}
			
			List<Long> idPossibleShooterCK = new ArrayList<Long>();
			for(ESFMatchResult matchResult : matchResultsCK){
				if(!idPossibleShooterCK.contains(matchResult.getEsfPartecipantId())){
					idPossibleShooterCK.add(matchResult.getEsfPartecipantId());
				}
			}
			//creo una lista con gli id dei tiratori delle categorie eccellenza, prima, seconda, terza categria
			
			for(Long l : idPossibleShooterCK){
				for(ESFMatchResult matchresult : matchResultsCK){
					if(matchresult.getCategoryName().equals("2") && matchresult.getEsfPartecipantId() == l &&
							!idUserSecondCategoryCK.contains(matchresult.getEsfPartecipantId())){
						idUserSecondCategoryCK.add(matchresult.getEsfPartecipantId());
					}else if(matchresult.getCategoryName().equals("3") && matchresult.getEsfPartecipantId() == l &&
							!idUserThirdCategoryCK.contains(matchresult.getEsfPartecipantId())){
						idUserThirdCategoryCK.add(matchresult.getEsfPartecipantId());
					}else if(matchresult.getCategoryName().equals("1") && matchresult.getEsfPartecipantId() == l &&
							!idUserFirstCategoryCK.contains(matchresult.getEsfPartecipantId())){
						idUserFirstCategoryCK.add(matchresult.getEsfPartecipantId());
					}else if(matchresult.getCategoryName().equals("E") && matchresult.getEsfPartecipantId() == l &&
							!idUserExcellenceCategoryCK.contains(matchresult.getEsfPartecipantId())){
						idUserExcellenceCategoryCK.add(matchresult.getEsfPartecipantId());
					}
				}
			}
		
			//riempio una hashmap con i risultati dei tiratori delle 4 categorie ordinando i risultati
			for(Long id : idUserSecondCategoryCK){
				resultCK = new ArrayList<Integer>();
				for(ESFMatchResult matchresult : matchResultsCK){
					if(matchresult.getEsfPartecipantId() == id ){
						int result = matchresult.getNextTotalPlayOff();
						int target = ESFMatchLocalServiceUtil.fetchESFMatch(matchresult.getEsfMatchId()).getNumDisk();
						int resultPercent = (result * 100)/target;
						resultCK.add(resultPercent);
					}
				}
				Collections.sort(resultCK);
				shooterSecondCategoryCK.put(id, resultCK);
			}
			
			for(Long id : idUserThirdCategoryCK){
				resultCK = new ArrayList<Integer>();
				for(ESFMatchResult matchresult : matchResultsCK){
					if(matchresult.getEsfPartecipantId() == id ){
						int result = matchresult.getNextTotalPlayOff();
						int target = ESFMatchLocalServiceUtil.fetchESFMatch(matchresult.getEsfMatchId()).getNumDisk();
						int resultPercent = (result * 100)/target;
						resultCK.add(resultPercent);
					}
				}
				Collections.sort(resultCK);
				shooterThirdCategoryCK.put(id, resultCK);
			}
			
			for(Long id : idUserFirstCategoryCK){
				resultCK = new ArrayList<Integer>();
				for(ESFMatchResult matchresult : matchResultsCK){
					if(matchresult.getEsfPartecipantId() == id ){
						int result = matchresult.getNextTotalPlayOff();
						int target = ESFMatchLocalServiceUtil.fetchESFMatch(matchresult.getEsfMatchId()).getNumDisk();
						int resultPercent = (result * 100)/target;
						resultCK.add(resultPercent);
					}
				}
				Collections.sort(resultCK);
				shooterFirstCategoryCK.put(id, resultCK);
			}
			
			for(Long id : idUserExcellenceCategoryCK){
				resultCK = new ArrayList<Integer>();
				for(ESFMatchResult matchresult : matchResultsCK){
					if(matchresult.getEsfPartecipantId() == id ){
						int result = matchresult.getNextTotalPlayOff();
						int target = ESFMatchLocalServiceUtil.fetchESFMatch(matchresult.getEsfMatchId()).getNumDisk();
						int resultPercent = (result * 100)/target;
						resultCK.add(resultPercent);
					}
				}
				Collections.sort(resultCK);
				shooterExcellenceCategoryCK.put(id, resultCK);
			}
			
			//prelevo il 90% delle migliori gare e se il risultato supera la percentuale minima aggiungo ai possibili prouovibili
			
			Set<Long> setKey2CK = shooterSecondCategoryCK.keySet();
			Set<Long> setKey3CK = shooterThirdCategoryCK.keySet();
			Set<Long> setKey1CK = shooterFirstCategoryCK.keySet();
			Set<Long> setKeyECK = shooterExcellenceCategoryCK.keySet();
			//modificato per prova
			//minPercent2TO1CK = 1;
			
			
			for(Long key : setKey2CK){
				resultCK = new ArrayList<Integer>();
				substring = new ArrayList<Integer>();
				resultCK=shooterSecondCategoryCK.get(key);
				percent = (90*resultCK.size())/100;
				substring.addAll(resultCK.subList((resultCK.size()-percent), resultCK.size()));
				int i ;
				somm=0;
				for( i = 1 ; i < substring.size()+1 ; i++){
					somm = somm + substring.get(i-1);
				}
				if(i >0){
				somm=somm/(i-1);
					if(somm>=minPercent2TO1CK){
						idUserPass2_1CK.add(key);
					}
				}
			}

			//modificato per prova
			//minPercent3TO2CK = 2;
			
			for(Long key : setKey3CK){
				resultCK = new ArrayList<Integer>();
				substring = new ArrayList<Integer>();
				resultCK=shooterThirdCategoryCK.get(key);
				percent = (90*resultCK.size())/100;
				substring.addAll(resultCK.subList((resultCK.size()-percent), resultCK.size()));
				int i ;
				somm=0;
				for(i = 1  ; i < substring.size()+1 ; i++){
					somm = somm + substring.get(i-1);
				}
				somm=somm/(i-1);
				if(somm>=minPercent3TO2CK){
					idUserPass3_2CK.add(key);
				}
			}
			
			//modificato per prova
			//minPercentETO1CK = 2;
			
			for(Long key : setKeyECK){
				resultCK = new ArrayList<Integer>();
				substring = new ArrayList<Integer>();
				resultCK=shooterExcellenceCategoryCK.get(key);
				percent = (50*resultCK.size())/100;
				substring.addAll(resultCK.subList((resultCK.size()-percent), resultCK.size()));
				int i ;
				somm=0;
				for( i = 1 ; i < substring.size()+1 ; i++){
					somm = somm + substring.get(i-1);
				}
				somm=somm/(i-1);
				if(somm<=minPercentETO1CK){
					idUserPassE_1CK.add(key);
				}
			}
			
			//modificato per prova
			//minPercent1TO2CK = 2;
			
			for(Long key : setKey1CK){
				resultCK = new ArrayList<Integer>();
				substring = new ArrayList<Integer>();
				resultCK=shooterFirstCategoryCK.get(key);
				percent = (50*resultCK.size())/100;
				substring.addAll(resultCK.subList((resultCK.size()-percent), resultCK.size()));
				int i ;
				somm=0;
				//System.out.println("<<<<<<<<<<<<<<<shooterFirstCategoryCK  substring vale:"+substring.size());
				//System.out.println("<<<<<<<<<<<<<<<shooterFirstCategoryCK  i vale:"+(resultCK.size()-percent));
				//System.out.println("<<<<<<<<<<<<<<<shooterFirstCategoryCK  resultCK vale:"+resultCK.toString());
				for( i = 1 ; i < substring.size()+1 ; i++){
					somm = somm + substring.get(i-1);
				}
				somm=somm/(i-1);
				if(somm<=minPercent1TO2CK){
					idUserPass1_2CK.add(key);
				}
			}
			

			
			for(Long l : idUserPass2_1CK){
				userPromovedSecondCategoryCK.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			
			
			for(Long l : idUserPass3_2CK){
				userPromovedThirdCategoryCK.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			
			for(Long l : idUserPass1_2CK){
				userRetrocessedFirstCategoryCK.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			
			for(Long l : idUserPassE_1CK){
				userRetrocessedExcellenceCategoryCK.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			
			session.setAttribute("userPromovedSecondCategoryCK", userPromovedSecondCategoryCK);
			session.setAttribute("userPromovedThirdCategoryCK", userPromovedThirdCategoryCK);
			session.setAttribute("userRetrocessedFirstCategoryCK", userRetrocessedFirstCategoryCK);
			session.setAttribute("userRetrocessedExcellenceCategoryCK", userRetrocessedExcellenceCategoryCK);
			session.setAttribute("compak", String.valueOf(compak));
			
			
			//response.setRenderParameter("compak", String.valueOf(compak));
			
		}
		
		if(speciality == 12935 || speciality == 0){
			String double_Trap = "double_Trap";
			
			
			String secondCategory = "2";
			int minDTChecked = ESFKeys.ESFCategoryChanges.minDTChecked;
			List<ESFMatch> matchsSelectedDoubleTrap = new ArrayList<ESFMatch>();
			matchsSelectedDoubleTrap = ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(IsChangeCategory, 12935, year);//match double trap
			List<ESFMatchResult> matchResultsDT = new ArrayList<ESFMatchResult>();
			List<Long> idUserDT = new ArrayList<Long>();
			
			for(ESFMatch match : matchsSelectedDoubleTrap){
				matchResultsDT.addAll(ESFMatchResultLocalServiceUtil.findbyEsfMatchId(match.getEsfMatchId()));
			}
			
			
			for(ESFMatchResult matchResult : matchResultsDT){
				if(matchResult.getCategoryName().equals(secondCategory) && matchResult.getNextTotalPlayOff()<= minDTChecked 
						&& !idUserDT.contains(matchResult.getUserId())){
					idUserDT.add(matchResult.getEsfPartecipantId());
				}
			}
			
			for(Long l : idUserDT){
				userRetrocededSecondCategoryDT.add(ESFUserLocalServiceUtil.fetchESFUser(l));
			}
			
			session.setAttribute("double_Trap", String.valueOf(double_Trap));
			session.setAttribute("userRetrocededSecondCategoryDT", userRetrocededSecondCategoryDT);
			//response.setRenderParameter("double_Trap", String.valueOf(double_Trap));
		}
		

		
		response.setRenderParameter("mvcPath", templatePath +"view.jsp");
		session.setAttribute("calculate", String.valueOf(calculate));
		session.setAttribute("year", String.valueOf(year));
		
		
		
		////////////////////FINE METODO DEL DISTANZIAMENTO/////////////////
	}
	
	public void print(ActionRequest request, ActionResponse response) 
			throws PortalException, SystemException{
		
		String calculate = "calculate";
		
		
		System.out.println("<<<<<<<<<<<<<<<<<<<sono in print e calculate vale:"+calculate);
		
		
		long speciality = ParamUtil.getLong(request, "speciality");
		System.out.println("<<<<<<<<<<<<<<<<<<<sono in print e speciality vale:"+speciality);
		
		long year = ParamUtil.getLong(request, "year");
		System.out.println("<<<<<<<<<<<<<<<<<<<sono in print e year vale:"+year);
		
		response.setRenderParameter("mvcPath", templatePath +"view.jsp");
		response.setRenderParameter("calculate", String.valueOf(calculate));
		
	}
	
	
	public void changeOfCategory(ActionRequest request, ActionResponse response) 
			throws PortalException, SystemException, ParseException{

		ESFUserCategory userCategory ;
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFChangeOfCategoryPortlet.class.getName(), request);
		
		boolean[] chooses = ParamUtil.getBooleanValues(request, "choose");
		long[] esfUserIds =
				ParamUtil.getLongValues(request, "esfUserIds");
		long[] nextCategory =
				ParamUtil.getLongValues(request, "nextCategory");
		String esfSportType = ParamUtil.getString(request, "esfSportTypeId");
		Long esfSportTypeId = Long.parseLong(esfSportType);
		String yearString = ParamUtil.getString(request, "year");
		int year = Integer.valueOf(yearString)+1;
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			User user = themeDisplay.getUser();

			long groupId = user.getGroupId();

			long companyId = user.getCompanyId();
		
		
		
		if(Validator.isNotNull(chooses) && Validator.isNotNull(esfUserIds)){
			for(int i = 0 ; i < esfUserIds.length ; i++ ){
				
				
				
				if(chooses[i]){
					
					
					ESFUserCategoryLocalServiceUtil.
						addEsfUserCategory(esfUserIds[i], nextCategory[i],
								esfSportTypeId, year, user, groupId, companyId, serviceContext);
					
				}
			}
			
		}
		

		response.setRenderParameter("mvcPath", templatePath +"view.jsp");
		//response.setRenderParameter("calculate", String.valueOf(calculate));
	}
	
	

	
}

