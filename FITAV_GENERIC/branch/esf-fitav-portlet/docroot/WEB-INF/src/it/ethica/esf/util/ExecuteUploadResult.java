
package it.ethica.esf.util;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class ExecuteUploadResult implements Runnable {
	private ActionRequest request;
	private ActionResponse response;
	
	
	
	
	public ActionRequest getRequest() {
	
		return request;
	}



	
	public void setRequest(ActionRequest request) {
	
		this.request = request;
	}



	
	public ActionResponse getResponse() {
	
		return response;
	}



	
	public void setResponse(ActionResponse response) {
	
		this.response = response;
	}



	@Override
	public void run() {
	
		String line = "";
		int permittedRowsCounter = 0;
		String fileName = ParamUtil.getString(request, "file");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		ESFMatch esfMatch = null;
		try {
			esfMatch = ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
		}
		catch (PortalException | SystemException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		if(esfMatch == null){
			return;
		}
		BufferedReader bufferedReader = null;
		File file = new File(fileName);
		
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String text = null;
			
			/*
			 * il primo while serve per saltare tutte le info relative alla
			 * verifica dellla gara
			 */
			int lineCounter = 0;
			while (lineCounter < 6) {
				String v = bufferedReader.readLine();
				lineCounter++;
			}
			
			String value = "";
			List<ESFMatchResult> esfMatcheResults =
				new ArrayList<ESFMatchResult>();
			
			while ((line = bufferedReader.readLine()) != null) {
				
				int firstSemicolonIndex = 0;
				int secondSemicolonIndex = 0;
				int wordNumber = 1;
				String cardCode = "";
				int generealClassPosition = 0;
				String categoryName = "";
				String qualification = "";
				int first = 0;
				int second = 0;
				int third = 0;
				int fourth = 0;
				int fifth = 0;
				int firstPlayOff = 0;
				int secondPlayOff = 0;
				int thirdPlayOff = 0;
				int totalAfterPlayOff = 0;
				int nextFirstPlayOff = 0;
				int nextSecondPlayOff = 0;
				int nextTotalPlayOff = 0;
				String fiscalCode = "";
				
				List<Boolean> oneTimeVisitedIfs = new ArrayList<Boolean>();
				for (int i = 0; i <= 35; i++) {
					oneTimeVisitedIfs.add(false);
				}
				
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == ';') {
						firstSemicolonIndex = secondSemicolonIndex;
						secondSemicolonIndex = i + 1;
						value =
							line.substring(
								firstSemicolonIndex, secondSemicolonIndex - 1).trim();
						wordNumber++;
						
					}
					if (wordNumber == 10 && !oneTimeVisitedIfs.get(wordNumber)) {
						if (value.equals("GENERALE")) {
							permittedRowsCounter++;
							oneTimeVisitedIfs.add(wordNumber, true);
						}
					}
					if (wordNumber == 11 && !oneTimeVisitedIfs.get(wordNumber)) {
						generealClassPosition = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 12 && !oneTimeVisitedIfs.get(wordNumber)) {
						cardCode = value;
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					
					if (wordNumber == 15 && !oneTimeVisitedIfs.get(wordNumber)) {
						categoryName = value;
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 16 && !oneTimeVisitedIfs.get(wordNumber)) {
						qualification = value;
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 17 && !oneTimeVisitedIfs.get(wordNumber)) {
						first = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 18 && !oneTimeVisitedIfs.get(wordNumber)) {
						second = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 19 && !oneTimeVisitedIfs.get(wordNumber)) {
						third = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 20 && !oneTimeVisitedIfs.get(wordNumber)) {
						fourth = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 21 && !oneTimeVisitedIfs.get(wordNumber)) {
						fifth = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 22 && !oneTimeVisitedIfs.get(wordNumber)) {
						firstPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 23 && !oneTimeVisitedIfs.get(wordNumber)) {
						secondPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 24 && !oneTimeVisitedIfs.get(wordNumber)) {
						thirdPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 25 && !oneTimeVisitedIfs.get(wordNumber)) {
						totalAfterPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 26 && !oneTimeVisitedIfs.get(wordNumber)) {
						nextFirstPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 27 && !oneTimeVisitedIfs.get(wordNumber)) {
						nextSecondPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 28 && !oneTimeVisitedIfs.get(wordNumber)) {
						nextTotalPlayOff = Integer.parseInt(value);
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					if (wordNumber == 35 && !oneTimeVisitedIfs.get(wordNumber)) {
						fiscalCode = value;
						oneTimeVisitedIfs.add(wordNumber, true);
					}
					
				}
				
				long esfMatchResultId =
					ESFMatchResultLocalServiceUtil.getESFMatchResultsCount() + 1;
				ESFUser esfUser =
					ESFUserLocalServiceUtil.getESFUserByFiscalCode(fiscalCode);
				
				long esfPartecipantId = 0;
				
				if (esfUser != null && esfUser.getFiscalCode() != null) {
					esfPartecipantId = esfUser.getEsfUserId();
					
				}
				ESFMatchResult esfMatchResult =
					ESFMatchResultLocalServiceUtil.createESFMatchResult(esfMatchResultId);
				
				esfMatchResult.setGroupId(esfMatch.getGroupId());
				esfMatchResult.setCompanyId(esfMatch.getCompanyId());
				esfMatchResult.setUserId(esfMatch.getUserId());
				esfMatchResult.setUserName(esfMatch.getUserName());;
				esfMatchResult.setCreateDate(new Date());;
				esfMatchResult.setModifiedDate(new Date());;
				esfMatchResult.setEsfMatchId(esfMatchId);
				esfMatchResult.setEsfPartecipantId(esfPartecipantId);
				esfMatchResult.setGeneralClassPosition(generealClassPosition);
				esfMatchResult.setCategoryName(categoryName);
				esfMatchResult.setQualification(qualification);
				esfMatchResult.setFirst(first);
				esfMatchResult.setSecond(second);
				esfMatchResult.setThird(third);
				esfMatchResult.setFourth(fourth);
				esfMatchResult.setFifth(fifth);
				esfMatchResult.setCardCode(cardCode);
				esfMatchResult.setFirstPlayOff(firstPlayOff);
				esfMatchResult.setSecondPlayOff(secondPlayOff);
				esfMatchResult.setThirdPlayOff(thirdPlayOff);
				esfMatchResult.setTotalAfterPlayOff(totalAfterPlayOff);
				esfMatchResult.setNextFirstPlayOff(nextFirstPlayOff);
				esfMatchResult.setNextSecondPlayOff(nextSecondPlayOff);
				esfMatchResult.setNextTotalPlayOff(nextTotalPlayOff);
				esfMatchResult.setFiscalCode(fiscalCode);
				
				if (!esfMatcheResults.contains(esfMatchResult)) {
					esfMatcheResults.add(esfMatchResult);
					ESFMatchResultLocalServiceUtil.addESFMatchResult(esfMatchResult);
				}
				
				lineCounter++;
			}
			Map<Integer, Boolean> visitedResults =
				new HashMap<Integer, Boolean>();
			for (int i = 0; i < esfMatcheResults.size(); i++) {
				visitedResults.put(i, false);
			}
			int i = 0;
			/* Trovo la classifica della categoria e aggiungo il risultato al db */
			for (ESFMatchResult e1 : esfMatcheResults) {
				i = 0;
				for (ESFMatchResult e2 : esfMatcheResults) {
					if (visitedResults.get(i) == false &&
						e1.getFiscalCode().equals(e2.getFiscalCode()) &&
						e1.getEsfMatchResultId() != e2.getEsfMatchResultId()) {
						visitedResults.put(i, true);
						e1.setCategoryClassPosition(e2.getGeneralClassPosition());
						ESFMatchResultLocalServiceUtil.updateESFMatchResult(e1);
					}
					i++;
				}
				
			}
			
			/* Cancello tutti i risultati ridondanti */
			for (int j = permittedRowsCounter; j < esfMatcheResults.size(); j++) {
				
				ESFMatchResult resToDelere = esfMatcheResults.get(j);
				ESFMatchResultLocalServiceUtil.deleteESFMatchResult(resToDelere);
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
			catch (IOException e) {
			}
		}
	}
	private static Log _log = LogFactoryUtil.getLog(ExecuteUploadResult.class);
}
