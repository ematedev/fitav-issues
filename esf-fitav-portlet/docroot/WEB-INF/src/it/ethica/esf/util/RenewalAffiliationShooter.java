 package it.ethica.esf.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.model.impl.ESFShooterAffiliationChronoImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;


public class RenewalAffiliationShooter {
	
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
	

	public int renewalAffiliation( BufferedReader buffer,Date creditDate)
		throws IOException{

		int errorAffiliationNumber = 0;
		String newLine = "";
		BufferedReader bufferedReader = buffer;

		ThemeDisplay themeDysplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
//		DateFormat df = new SimpleDateFormat("dd/mm/yy");		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd"); 
		
		long groupId = 0;
		long companyId = 0;
		long userId = 0;
		String userName = "";
		Date createDate = creditDate;
		Date paymentDate = new Date();
		String reg = "";
		String cardNumber = "";
		String orgCode = "";
		String paymentType= "";
		String paymentDateS = "";
		String payment = "";
		String Vcampo = "";
		String shooterAssociationError = "";
		
		int year = Calendar.getInstance().get(Calendar.YEAR);

		groupId = themeDysplay.getLayout().getGroupId();
		companyId = themeDysplay.getCompanyId();
		userId = themeDysplay.getUserId();
		userName = themeDysplay.getUser().getScreenName();
		
		ESFCard card = new ESFCardImpl();
		ESFCard OldCard = new ESFCardImpl();
		ESFShooterAffiliationChrono chrono = new ESFShooterAffiliationChronoImpl();
		ESFEntityState entityState = new ESFEntityStateImpl();
		ESFUser user =  new ESFUserImpl();
		ESFOrganization org = new ESFOrganizationImpl();
		
		ServiceContext serviceContext = new ServiceContext();
		try {

			while((newLine = bufferedReader.readLine())!= null ){
				
				if( 82 == newLine.trim().length()){
					
					errorAffiliationNumber = errorAffiliationNumber +1;
					String shooterCode = "";
					String codeAlfa ="";
					String code_ ="";

					
					
					long shooterId = 0;
					long cardesfOrganizationId = 0;
					long codeNum = 0;

					boolean affiliate = false;

					paymentType = newLine.substring(33,36);
					paymentDateS = newLine.substring(27,33 );
					paymentDate = dt.parse(paymentDateS);
					
					String paymentI = newLine.substring(36,44);
					String paymentD = newLine.substring(44,46);
					payment = paymentI+","+paymentD;
					
					Vcampo = newLine.substring(61,77);
					
					reg = newLine.substring(62,64);
					cardNumber = newLine.substring(64,70);
					
					if("01".equals(reg)){
						reg = "PV";
					}else if("02".equals(reg)){
						reg = "VA";
					}else if("03".equals(reg)){
						reg = "LG";
					}else if("04".equals(reg)){
						reg = "LM";
					}else if("05".equals(reg)){
						reg = "TA";
					}else if("06".equals(reg)){
						reg = "FG";
					}else if("07".equals(reg)){
						reg = "VN";
					}else if("08".equals(reg)){
						reg = "ER";
					}else if("09".equals(reg)){
						reg = "PS";
					}else if("10".equals(reg)){
						reg = "MR";
					}else if("11".equals(reg)){
						reg = "UB";
					}else if("12".equals(reg)){
						reg = "LZ";
					}else if("13".equals(reg)){
						reg = "AB";
					}else if("14".equals(reg)){
						reg = "ML";
					}else if("15".equals(reg)){
						reg = "CP";
					}else if("16".equals(reg)){
						reg = "BS";
					}else if("17".equals(reg)){
						reg = "PG";
					}else if("18".equals(reg)){
						reg = "CL";
					}else if("19".equals(reg)){
						reg = "SC";
					}else if("20".equals(reg)){
						reg = "SD";
					}
					
					cardNumber=reg+String.valueOf(Integer.valueOf(cardNumber));
					
					if("674".equals(paymentType)){
						shooterCode = newLine.substring(70, 76);
						
						_log.debug("**shooterCode="+shooterCode);
						
						try {
							user = ESFUserLocalServiceUtil.getESFUserByUserCode(Long.valueOf(shooterCode));
						}
						catch (Exception e) {
							// TODO: handle exception
							_log.error("tiratore [" + shooterCode + "] non trovato");
							user = null;
						}
						
						if(Validator.isNotNull(user)){
						
							_log.debug("**user="+user);
							
							affiliate = ESFShooterAffiliationChronoLocalServiceUtil.affiliated(user.getEsfUserId(), year);
							
							_log.debug("**affiliate="+affiliate);
							if(!affiliate){
								
								List<ESFEntityState> oldCards = ESFEntityStateLocalServiceUtil.findESShooterLastCardActive(user.getEsfUserId());
								if(!oldCards.isEmpty() && Validator.isNotNull(oldCards.get(0))){
									OldCard =ESFCardLocalServiceUtil.fetchESFCard(oldCards.get(0).getClassPK());
									
									long cardId = CounterLocalServiceUtil.increment(ESFCard.class.getName());
									long entityStateId = CounterLocalServiceUtil.increment(ESFEntityState.class.getName());
									
									_log.debug("**cardId="+cardId);
									_log.debug("**entityStateId="+entityStateId);
									_log.debug("**oldCards.get(0)="+oldCards.get(0));
									_log.debug("*********OldCard="+OldCard);
									
									
									if(0 < OldCard.getEsfOrganizationId()){
										
										cardesfOrganizationId = OldCard.getEsfOrganizationId();
										org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardesfOrganizationId);
										orgCode = org.getCode();
										codeAlfa = OldCard.getCodeAlfa();
										codeNum = OldCard.getCodeNum();
										code_ = OldCard.getCode();
										shooterId = OldCard.getEsfUserId();
										
										card.setUuid(serviceContext.getUuid());
										card.setEsfCardId(cardId);
										card.setCreateDate(createDate);
										card.setModifiedDate(null);
										card.setGroupId(groupId);
										card.setCompanyId(companyId);
										card.setUserId(userId);
										card.setUserName(userName);
										card.setEsfOrganizationId(cardesfOrganizationId);
										card.setCodeAlfa(codeAlfa);
										card.setCodeNum(codeNum);
										card.setCode(code_);
										card.setEsfUserId(shooterId);
										ESFCardLocalServiceUtil.addESFCard(card);
										
										entityState.setEsfEntityStateId(entityStateId);
										entityState.setCreateDate(createDate);
										entityState.setModifiedDate(null);
										entityState.setGroupId(groupId);
										entityState.setCompanyId(companyId);
										entityState.setUserId(userId);
										entityState.setUserName(userName);
										entityState.setClassName("it.ethica.esf.model.ESFCard");
										entityState.setClassPK(cardId);
										entityState.setStartDate(new Date());
										entityState.setEndDate(null);
										entityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);
										ESFEntityStateLocalServiceUtil.addESFEntityState(entityState);
										_log.debug("**creato entitystate");
										
										/*ESFCardLocalServiceUtil.addESFCard(userId, code_, 
											codeAlfa, codeNum, entityState, shooterId, cardesfOrganizationId, serviceContext);*/
										
										long chronoId = CounterLocalServiceUtil.increment(ESFShooterAffiliationChrono.class.getName());
										_log.debug("**chronoId="+chronoId);
										
										chrono.setEsfShooterAffiliationChronoId(chronoId);
										chrono.setEsfuserId(shooterId);
										chrono.setAffiliationDate(createDate);
										chrono.setYear(year);
										chrono.setEsfShooterAffiliationChronoId(chronoId);
										chrono.setPaymentDate(paymentDate);
										chrono.setPayment(payment);
										chrono.setVcampo(Vcampo);
										chrono.setCard(cardNumber);
										chrono.setEsfOrganization(orgCode);
										ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono(chrono);
										
										_log.debug("**fine affiliazione utente");
									}else {
										long chronoId = CounterLocalServiceUtil.increment(ESFShooterAffiliationChrono.class.getName());
										String shooterName = user.getFirstName() + " " + user.getLastName();
										String oldCardCode = OldCard.getCode();
										shooterAssociationError = "Errore tiratore "+ shooterName + " tessera "+oldCardCode ;
										
										shooterId = OldCard.getEsfUserId();
										
										_log.debug("///////chronoId="+chronoId);
										_log.debug("////shooterId="+shooterId);
										_log.debug("////createDate"+createDate);
										_log.debug("////year="+year);
										_log.debug("////paymentDate="+paymentDate);
										_log.debug("////payment="+payment);
										_log.debug("////Vcampo="+Vcampo);
										_log.debug("////cardNumber="+cardNumber);
										_log.debug("////orgCode="+orgCode);
										_log.debug("////note="+shooterAssociationError);
										
										chrono.setEsfShooterAffiliationChronoId(chronoId);
										_log.debug("---1----");
										chrono.setEsfuserId(shooterId);
										_log.debug("---2----");
										chrono.setAffiliationDate(createDate);
										chrono.setYear(year);
										chrono.setPaymentDate(paymentDate);
										chrono.setPayment(payment);
										chrono.setVcampo(Vcampo);
										chrono.setCard(cardNumber);
										chrono.setEsfOrganization(orgCode);
										chrono.setNote(shooterAssociationError);
										ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono(chrono);
									}
								}
							}
						}
					}else{
						long chronoId = CounterLocalServiceUtil.increment(ESFShooterAffiliationChrono.class.getName());
						_log.debug("**bollettino errato chronoId="+chronoId);
						chrono.setEsfShooterAffiliationChronoId(chronoId);
						chrono.setPaymentDate(paymentDate);
						chrono.setPayment(payment);
						chrono.setNote(shooterAssociationError);
						chrono.setVcampo(Vcampo);
						ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono(chrono);
					}
				}
			}
			
			_log.debug("**fine affiliazione");
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.error("errore affiliazione");
			return errorAffiliationNumber;
		}
		return 0;
	}
	
	private static Log _log = LogFactoryUtil.getLog(RenewalAffiliationShooter.class);
}
