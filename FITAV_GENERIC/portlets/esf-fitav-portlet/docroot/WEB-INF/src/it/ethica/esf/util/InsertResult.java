package it.ethica.esf.util;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFResultImpl;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


public class InsertResult {
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
	
	public void insertResult( BufferedReader buffer, long matchId, long associationId, long sptId, boolean isIndividual)
					throws IOException{
		
		if(isIndividual){
			try {
				insertSingleMatchResult(buffer , matchId,  associationId,  sptId);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}else if(!isIndividual){
			try {
				insertTeamMatchResult(buffer , matchId, associationId, sptId);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		
	}
	
	public void insertSingleMatchResult( BufferedReader buffer, long matchId, long associationId, long sptId)
					throws IOException{
		_log.info("entro in insertSingleMatchResult");
		String newLine = "";
		BufferedReader bufferedReader = buffer;
		
		ThemeDisplay themeDysplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		long groupId = 0;
		long companyId = 0;
		long userId = 0;
		String userName = "";
		Date createDate = new Date();
		Date modifiedDate = new Date();
		
		
		groupId = themeDysplay.getLayout().getGroupId();
		companyId = themeDysplay.getCompanyId();
		userId = themeDysplay.getUserId();
		userName = themeDysplay.getUser().getScreenName();
		
		try {
			
				while((newLine = bufferedReader.readLine())!=null ){
					
					ESFResult result = new ESFResultImpl();
					
					long esfResultId = CounterLocalServiceUtil.increment(ESFResult.class.getName());
					
					result.setEsfResultId(esfResultId);
					result.setCreateDate(createDate);
					result.setModifiedDate(modifiedDate);
					result.setGroupId(groupId);
					result.setCompanyId(companyId);
					result.setUserId(userId);
					result.setUserName(userName);
					result.setEsfMatchId(matchId);
					result.setEsfAssociationId(associationId);
					result.setEsfMatchTypeId(sptId);
					
					
					String year = "";
					String numberMatch = "";
					String matchType = "";
					String codSoc = "";
					String spec = "";
					String start = "";
					String end = "";
					String groupClass = "";
					String descGruoupRanking = "";
					String pos = "";
					String card = "";
					String shooterName = "";
					String codNaz = "";
					String category = "";
					String qualificationCode = "";
					String qualificationresultS1 = "";
					String qualificationresultS2 = "";
					String qualificationresultS3 = "";
					String qualificationresultS4 = "";
					String qualificationresultS5 = "";
					String qualificationresultS6 = "";
					String qualificationresultS7 = "";
					String qualificationresultS8 = "";
					String total = "";
					String barrage = "";
					String finalS = "";
					String finalTotal = "";
					String american1 = "";
					String american2 = "";
					String american3 = "";
					String rifle = "";
					String catridge = "";
					String caliber = "";
					String finalType = "";
					String semifinalResult = "";
					String shootOff1 = "";
					String shootOff2 = "";
					String shootOff3 = "";
					String bronzeResult = "";
					String shootOffBronze = "";
					String goldResult = "";
					String shootOffGold = "";
				
					year = newLine.substring(0, 4).replace(" ", "");
					numberMatch = newLine.substring(5, 9).replace(" ", "");
					matchType = newLine.substring(10, 50);
					codSoc = newLine.substring(51, 55);
					spec = newLine.substring(56, 58);
					start = newLine.substring(59, 69);
					end = newLine.substring(70, 80);
					groupClass = newLine.substring(81, 84);
					descGruoupRanking = newLine.substring(85, 115);
					pos = newLine.substring(116, 120).replace(" ", "");
					card = newLine.substring(121, 131);
					shooterName = newLine.substring(132,167);
					codNaz = newLine.substring(168,171);
					category= newLine.substring(172,173);
					qualificationCode = newLine.substring(174,177);
					qualificationresultS1 = newLine.substring(178,180).replace(" ", "");
					qualificationresultS2 = newLine.substring(181,183).replace(" ", "");
					qualificationresultS3 = newLine.substring(184,186).replace(" ", "");
					qualificationresultS4 = newLine.substring(187,189).replace(" ", "");
					qualificationresultS5 = newLine.substring(190,192).replace(" ", "");
					qualificationresultS6 = newLine.substring(193,195).replace(" ", "");
					qualificationresultS7 = newLine.substring(196,198).replace(" ", "");
					qualificationresultS8 = newLine.substring(199,201).replace(" ", "");
					total = newLine.substring(202,205).replace(" ", "");
					barrage = newLine.substring(206,208).replace(" ", "");
					finalS = newLine.substring(209,211).replace(" ", "");
					finalTotal = newLine.substring(212,215).replace(" ", "");
					american1 = newLine.substring(216,218).replace(" ", "");
					american2 = newLine.substring(219,221).replace(" ", "");
					american3 = newLine.substring(222,224).replace(" ", "");
					rifle = newLine.substring(225,250);
					catridge = newLine.substring(251,276);
					caliber = newLine.substring(277,279);
					finalType = newLine.substring(280,281).replace(" ", "");
					semifinalResult = newLine.substring(282,284).replace(" ", "");
					shootOff1 = newLine.substring(285,287).replace(" ", "");
					shootOff2 = newLine.substring(288,290).replace(" ", "");
					shootOff3 = newLine.substring(291,293).replace(" ", "");
					bronzeResult = newLine.substring(294,296).replace(" ", "");
					shootOffBronze = newLine.substring(297,299).replace(" ", "");
					goldResult = newLine.substring(300,302).replace(" ", "");
					shootOffGold = newLine.substring(303,305).replace(" ", "");
					

					
					try {
						result.setMatchYear(Integer.valueOf(year));
						result.setNumberMatch(Integer.parseInt(numberMatch));
						result.setPosition(Integer.parseInt(pos));
						result.setResultS1(Integer.parseInt(qualificationresultS1));
						result.setResultS2(Integer.parseInt(qualificationresultS2));
						result.setResultS3(Integer.parseInt(qualificationresultS3));
						result.setResultS4(Integer.parseInt(qualificationresultS4));
						result.setResultS5(Integer.parseInt(qualificationresultS5));
						result.setResultS6(Integer.parseInt(qualificationresultS6));
						result.setResultS7(Integer.parseInt(qualificationresultS7));
						result.setResultS8(Integer.parseInt(qualificationresultS8));
						result.setTotalS(Integer.parseInt(total));
						result.setBarrage(Integer.parseInt(barrage));
						result.setFinalS(Integer.parseInt(finalS));
						result.setFinalTotal(Integer.parseInt(finalTotal));
						result.setAmerican1(Integer.parseInt(american1));
						result.setAmerican2(Integer.parseInt(american2));
						result.setAmerican3(Integer.parseInt(american3));
						result.setSemifinalResult(Integer.parseInt(semifinalResult));
						result.setShootOff1s(Integer.parseInt(shootOff1));
						result.setShootOff1s(Integer.parseInt(shootOff2));
						result.setShootOff1s(Integer.parseInt(shootOff3));
						result.setBronzeResult(Integer.parseInt(bronzeResult));
						result.setShootOffBronze(Integer.parseInt(shootOffBronze));
						result.setGoldResult(Integer.parseInt(goldResult));
						result.setShootOffGold(Integer.parseInt(shootOffGold));
						
					}
					catch (Exception e) {
						// TODO: handle exception
						_log.info("errore formato numero ");
						
						SessionErrors.add(request, "errorMessage");
						request.setAttribute("errorMessage","errore formato numero");
						return;
					}
					
					try {
						result.setStartdDate(sdf.parse(start));
						result.setEndDate(sdf.parse(end));
						
					}
					catch (Exception e) {
						// TODO: handle exception
						_log.info("errore formato data");
						SessionErrors.add(request, "errorMessage");
						request.setAttribute("errorMessage","errore formato data");
						return;
					}

					ESFCard userCard = new ESFCardImpl();
					String yearToReplace = "";
					String monthToReplace = "";
					String dayToReplace = "";
					String startS = "";
					String endS = "";
					
					dayToReplace = start.substring(0,2);
					monthToReplace = start.substring(3, 5);
					yearToReplace = start.substring(6, 10);
					
					startS = yearToReplace+"-"+monthToReplace+"-"+dayToReplace;
					
					dayToReplace = end.substring(0,2);
					monthToReplace = end.substring(3, 5);
					yearToReplace = end.substring(6, 10);
					
					endS = yearToReplace+"-"+monthToReplace+"-"+dayToReplace;
					
					try {
						
						if(Validator.isNotNull(card) && !"".equals(card)){
							userCard = ESFCardLocalServiceUtil.findShooterByCardActiveInMatch(card,startS, endS);
						}
						
					}
					catch (Exception e) {
						// TODO: handle exception
						_log.info("errore ricerca card");
					}
					
					if(Validator.isNotNull(userCard) && Validator.isNotNull(userCard.getEsfUserId())){
						result.setEsfUserId(userCard.getEsfUserId());
					}
					
					result.setName(matchType);
					result.setSportTypeCode(spec);
					result.setGroupRanking(groupClass);
					result.setDescGroupRanking(descGruoupRanking);
					result.setCardNumber(card);
					result.setShooterName(shooterName);
					result.setNationCode(codNaz);
					result.setCategory(category);
					result.setQualificationCode(qualificationCode);
					result.setRifle(rifle);
					result.setCatridge(catridge);
					result.setCaliber(caliber);
					result.setFinalType(finalType);
					
					ESFResultLocalServiceUtil.updateESFResult(result);
	
				}
		
		}
		catch (Exception e) {
			SessionErrors.add(request, "errorMessage");
			request.setAttribute("errorMessage","errore inserimento dati");
			// TODO: handle exception
		}
	}
	
	
	public void insertTeamMatchResult( BufferedReader buffer, long matchId, long associationId, long sptId)
					throws IOException{
		_log.info("entro in insertTeamMatchResult");
		
		String newLine = "";
		BufferedReader bufferedReader = buffer;
		
		ThemeDisplay themeDysplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		long groupId = 0;
		long companyId = 0;
		long userId = 0;
		String userName = "";
		Date createDate = new Date();
		Date modifiedDate = new Date();
		
		groupId = themeDysplay.getLayout().getGroupId();
		companyId = themeDysplay.getCompanyId();
		userId = themeDysplay.getUserId();
		userName = themeDysplay.getUser().getScreenName();
		
		try {
			while((newLine = bufferedReader.readLine())!=null ){
				
				ESFResult result = new ESFResultImpl();
				
				long esfResultId = CounterLocalServiceUtil.increment(ESFResult.class.getName());
				
				result.setEsfResultId(esfResultId);
				result.setCreateDate(createDate);
				result.setModifiedDate(modifiedDate);
				result.setGroupId(groupId);
				result.setCompanyId(companyId);
				result.setUserId(userId);
				result.setUserName(userName);
				result.setEsfMatchId(matchId);
				result.setEsfAssociationId(associationId);
				result.setEsfMatchTypeId(sptId);
				
				String year = "";
				String numberMatch = "";
				String matchType = "";
				String codSoc = "";
				String spec = "";
				String start = "";
				String end = "";
				String groupClass = "";
				String descGruoupRanking = "";
				String pos = "";
				String categoryTeam = "";
				String nameTeam = "";
				String card = "";
				String shooterName = "";
				String codNaz = "";
				String category = "";
				String qualificationCode = "";
				String qualificationresultS1 = "";
				String qualificationresultS2 = "";
				String qualificationresultS3 = "";
				String qualificationresultS4 = "";
				String qualificationresultS5 = "";
				String qualificationresultS6 = "";
				String qualificationresultS7 = "";
				String qualificationresultS8 = "";
				String total = "";
				String american1 = "";
				String american2 = "";
				String american3 = "";
				String rifle = "";
				String catridge = "";
				String caliber = "";
				
				year = newLine.substring(0, 4).replace(" ", "");
				numberMatch = newLine.substring(5, 9).replace(" ", "");
				matchType = newLine.substring(10, 50);
				codSoc = newLine.substring(51, 55);
				spec = newLine.substring(56, 58);
				start = newLine.substring(59, 69);
				end = newLine.substring(70, 80);
				groupClass = newLine.substring(81, 84);
				descGruoupRanking = newLine.substring(85, 115);
				pos = newLine.substring(116, 120).replace(" ", "");
				categoryTeam = newLine.substring(121, 122);
				nameTeam = newLine.substring(123, 138);
				card = newLine.substring(139, 149);
				shooterName = newLine.substring(150, 185);
				codNaz = newLine.substring(186, 189);
				category = newLine.substring(190, 191);
				qualificationCode = newLine.substring(192, 195);
				qualificationresultS1 = newLine.substring(196, 198).replace(" ", "");
				qualificationresultS2 = newLine.substring(199, 201).replace(" ", "");
				qualificationresultS3 = newLine.substring(202, 204).replace(" ", "");
				qualificationresultS4 = newLine.substring(205, 207).replace(" ", "");
				qualificationresultS5 = newLine.substring(208, 210).replace(" ", "");
				qualificationresultS6 = newLine.substring(211, 213).replace(" ", "");
				qualificationresultS7 = newLine.substring(214, 216).replace(" ", "");
				qualificationresultS8 = newLine.substring(217, 219).replace(" ", "");
				total = newLine.substring(220, 223).replace(" ", "");
				american1 = newLine.substring(224, 226).replace(" ", "");
				american2 = newLine.substring(227, 229).replace(" ", "");
				american3 = newLine.substring(230, 232).replace(" ", "");
				rifle = newLine.substring(233, 258);
				catridge = newLine.substring(259, 284);
				caliber = newLine.substring(285, 286);
				
				try {
					result.setMatchYear(Integer.valueOf(year));
					result.setNumberMatch(Integer.parseInt(numberMatch));
					result.setPosition(Integer.parseInt(pos));
					result.setResultS1(Integer.parseInt(qualificationresultS1));
					result.setResultS2(Integer.parseInt(qualificationresultS2));
					result.setResultS3(Integer.parseInt(qualificationresultS3));
					result.setResultS4(Integer.parseInt(qualificationresultS4));
					result.setResultS5(Integer.parseInt(qualificationresultS5));
					result.setResultS6(Integer.parseInt(qualificationresultS6));
					result.setResultS7(Integer.parseInt(qualificationresultS7));
					result.setResultS8(Integer.parseInt(qualificationresultS8));
					result.setTotalS(Integer.parseInt(total));
					result.setAmerican1(Integer.parseInt(american1));
					result.setAmerican2(Integer.parseInt(american2));
					result.setAmerican3(Integer.parseInt(american3));
				}
				catch (Exception e) {
					// TODO: handle exception
					_log.info("errore formato numero ");
					
					SessionErrors.add(request, "errorMessage");
					request.setAttribute("errorMessage","errore formato numero");
					return;
				}
				
				try {
					result.setStartdDate(sdf.parse(start));
					result.setEndDate(sdf.parse(end));
					
				}
				catch (Exception e) {
					// TODO: handle exception
					_log.info("errore formato data");
					SessionErrors.add(request, "errorMessage");
					request.setAttribute("errorMessage","errore formato data");
					return;
				}
				result.setName(matchType);
				result.setSportTypeCode(spec);
				result.setGroupRanking(groupClass);
				result.setDescGroupRanking(descGruoupRanking);
				result.setTeamCategory(categoryTeam);
				result.setTeamName(nameTeam);
				result.setCardNumber(card);
				result.setShooterName(shooterName);
				result.setNationCode(codNaz);
				result.setCategory(category);
				result.setQualificationCode(qualificationCode);
				result.setRifle(rifle);
				result.setCatridge(catridge);
				result.setCaliber(caliber);
				
				ESFResultLocalServiceUtil.updateESFResult(result);
				
			}
			
		}
		catch (Exception e) {
			SessionErrors.add(request, "errorMessage");
			request.setAttribute("errorMessage","errore inserimento dati");
			// TODO: handle exception
		}
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(InsertResult.class);
}
