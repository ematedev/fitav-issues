 package it.ethica.esf.util;

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
import it.ethica.esf.service.ESFCardLocalService;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFCardPersistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;


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
		DateFormat df = new SimpleDateFormat("dd/mm/yy");		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd"); 
		
		long groupId = 0;
		long companyId = 0;
		long userId = 0;
		String userName = "";
		//Date createDate = new Date();
		Date createDate = creditDate;
		Date modifiedDate = new Date();
		Date paymentDate = new Date();
		String reg = "";
		String cardNumber = "";
		String orgCode = "";
		String paymentType= "";
		String paymentDateS = "";
		String payment = "";
		String note = "";
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

				_log.info("**newLine="+newLine);
				
				if( 82 == newLine.trim().length()){

					_log.info("**dimensione riga esatta**");
					
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
						
						_log.info("**shooterCode="+shooterCode);
						
						try {
							user = ESFUserLocalServiceUtil.getESFUserByUserCode(Long.valueOf(shooterCode));
						}
						catch (Exception e) {
							// TODO: handle exception
							_log.info("tiratore non trovato");
							user = null;
						}
						
						if(Validator.isNotNull(user)){
						
							_log.info("**user="+user);
							
							affiliate = ESFShooterAffiliationChronoLocalServiceUtil.affiliated(user.getEsfUserId(), year);
							
							_log.info("**affiliate="+affiliate);
							if(!affiliate){
								
								List<ESFEntityState> oldCards = ESFEntityStateLocalServiceUtil.findESShooterLastCardActive(user.getEsfUserId());
								if(!oldCards.isEmpty() && Validator.isNotNull(oldCards.get(0))){
									OldCard =ESFCardLocalServiceUtil.fetchESFCard(oldCards.get(0).getClassPK());
									
									long cardId = CounterLocalServiceUtil.increment(ESFCard.class.getName());
									long entityStateId = CounterLocalServiceUtil.increment(ESFEntityState.class.getName());
									
									_log.info("**cardId="+cardId);
									_log.info("**entityStateId="+entityStateId);
									_log.info("**oldCards.get(0)="+oldCards.get(0));
									_log.info("*********OldCard="+OldCard);
									
									
									if(0 < OldCard.getEsfOrganizationId()){
										
										cardesfOrganizationId = OldCard.getEsfOrganizationId();
										_log.info("**cardesfOrganizationId="+cardesfOrganizationId);
										org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(cardesfOrganizationId);
										_log.info("**org="+org);
										orgCode = org.getCode();
										_log.info("**orgCode="+orgCode);
										codeAlfa = OldCard.getCodeAlfa();
										_log.info("**codeAlfa="+codeAlfa);
										codeNum = OldCard.getCodeNum();
										_log.info("**codeNum="+codeNum);
										code_ = OldCard.getCode();
										_log.info("**code_="+code_);
										shooterId = OldCard.getEsfUserId();
										_log.info("**shooterId="+shooterId);
										
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
										_log.info("**creato card");
										
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
										_log.info("**creato entitystate");
										
										/*ESFCardLocalServiceUtil.addESFCard(userId, code_, 
											codeAlfa, codeNum, entityState, shooterId, cardesfOrganizationId, serviceContext);*/
										
										long chronoId = CounterLocalServiceUtil.increment(ESFShooterAffiliationChrono.class.getName());
										_log.info("**chronoId="+chronoId);
										
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
										
										_log.info("**fine affiliazione utente");
									}else {
										long chronoId = CounterLocalServiceUtil.increment(ESFShooterAffiliationChrono.class.getName());
										String shooterName = user.getFirstName() + " " + user.getLastName();
										String oldCardCode = OldCard.getCode();
										shooterAssociationError = "Errore tiratore "+ shooterName + " tessera "+oldCardCode ;
										
										shooterId = OldCard.getEsfUserId();
										
										_log.info("///////chronoId="+chronoId);
										_log.info("////shooterId="+shooterId);
										_log.info("////createDate"+createDate);
										_log.info("////year="+year);
										_log.info("////paymentDate="+paymentDate);
										_log.info("////payment="+payment);
										_log.info("////Vcampo="+Vcampo);
										_log.info("////cardNumber="+cardNumber);
										_log.info("////orgCode="+orgCode);
										_log.info("////note="+shooterAssociationError);
										
										chrono.setEsfShooterAffiliationChronoId(chronoId);
										_log.info("---1----");
										chrono.setEsfuserId(shooterId);
										_log.info("---2----");
										chrono.setAffiliationDate(createDate);
										_log.info("---3----");
										chrono.setYear(year);
										_log.info("---4----");
										chrono.setPaymentDate(paymentDate);
										_log.info("---5----");
										chrono.setPayment(payment);
										_log.info("---6----");
										chrono.setVcampo(Vcampo);
										_log.info("---7----");
										chrono.setCard(cardNumber);
										_log.info("---8----");
										chrono.setEsfOrganization(orgCode);
										_log.info("---9----");
										chrono.setNote(shooterAssociationError);
										_log.info("---10----");
										ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono(chrono);
										_log.info("---11----");
									}
									_log.info("---12----");
								}
								_log.info("---13----");
							}
							_log.info("---14----");
						}
						_log.info("---15----");
					}else{
						long chronoId = CounterLocalServiceUtil.increment(ESFShooterAffiliationChrono.class.getName());
						_log.info("**bollettino errato chronoId="+chronoId);
						chrono.setEsfShooterAffiliationChronoId(chronoId);
						chrono.setPaymentDate(paymentDate);
						chrono.setPayment(payment);
						chrono.setNote(shooterAssociationError);
						chrono.setVcampo(Vcampo);
						ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono(chrono);
					}
				}
			}
			
			_log.info("**fine affiliazione");
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.info("errore affiliazione");
			errorAffiliationNumber = errorAffiliationNumber;
			return errorAffiliationNumber;
		}
		return 0;
	}
	
	private static Log _log = LogFactoryUtil.getLog(RenewalAffiliationShooter.class);
}
