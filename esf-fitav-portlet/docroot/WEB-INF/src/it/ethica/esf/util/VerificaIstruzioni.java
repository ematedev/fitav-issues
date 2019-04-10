package it.ethica.esf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;


public class VerificaIstruzioni {
	
	/**
	 * @param fileRowsm esfMatchId
	 * @return la mappa che come chiave contiene il numero della riga e come valore
	 * un flag che dice se quel dato e' presente nella gara o meno nel db se tutti i valori
	 * sono presenti nel db, fa la ricerca della gara per quei valori.
	 * Se non trovo nessuna gara restituisco null
	 * 
	 */
	public static Map<Integer,Boolean> processaRighe(List<String> fileRows, long esfMatchId){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formatedDate = "";
		int numeroRighe = fileRows.size();
		
		Map<Integer,Boolean>results = new HashMap<Integer,Boolean>();
		
		for(int i = 1; i <= numeroRighe; i++){
			results.put(i, false);
		}
		
		String codeDb = "",
				sportAssotiationDb = "",
				descriptionDb = "",
				specialityDb = "";
		
		Date dateDb = new Date();
		
		String	codeStr = "",
				sportAssotiationStr = "",
				descriptionStr = "",
				specialityStr = "",
				dateStr = "";
		
		int indexOfAssignmentOperator = 0;
		int rowCounter = 0;
		
		//OrganizationLocalServiceUtil.fetchOrganization(companyId, name);
		for(String s : fileRows){
			indexOfAssignmentOperator = s.indexOf("=") + 1;
			
			if(rowCounter == 0)
				codeStr = s.substring(indexOfAssignmentOperator).toUpperCase();
			else if(rowCounter == 1)
				sportAssotiationStr = s.substring(indexOfAssignmentOperator).toUpperCase();
			else if(rowCounter == 2)
				descriptionStr = s.substring(indexOfAssignmentOperator).toUpperCase();	
			else if(rowCounter == 3)
				specialityStr = s.substring(indexOfAssignmentOperator).toUpperCase();
			else 
				dateStr = s.substring(indexOfAssignmentOperator);	
			rowCounter++;
		}
		
		try {
			 formatedDate = sdf.format(ManageDate.StringToDate(dateStr));
			
		}
		catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			ESFMatch esfMatch = ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
			
			if(Validator.isNotNull(esfMatch.getDescription())){
				descriptionDb = ESFDescriptionLocalServiceUtil.
									getESFDescription(esfMatch.getDescription()).
																getName().
																toUpperCase();
			}
			
			codeDb = esfMatch.getCode().toUpperCase();
			if(Validator.isNotNull(esfMatch.getEsfAssociationId())){
				sportAssotiationDb = OrganizationLocalServiceUtil.
										getOrganization(esfMatch.getEsfAssociationId()).
																	getName().
																	toUpperCase();
			}
			
			if(Validator.isNotNull(esfMatch.getEsfSportTypeId())){
				specialityDb = ESFSportTypeLocalServiceUtil.
									getESFSportType(esfMatch.getEsfSportTypeId()).
																getName().
																toUpperCase();
			}	
			dateDb = esfMatch.getStartDate();
			String formatedDbDate = sdf.format(dateDb);
			
			if(descriptionStr.equals(descriptionDb)){
				results.put(1, true);
			}
			if(codeStr.equals(codeDb)){
				results.put(2, true);
			}
			if(sportAssotiationStr.equals(sportAssotiationDb)){
				results.put(3, true);
			}
			if(specialityStr.equals(specialityDb)){
				results.put(4, true);
			}
			if(formatedDate.equals(formatedDbDate)){
				results.put(5, true);
			}	
		}
		catch (Exception e) {
			e.getMessage();
		}
		return results;
	}
	
}
