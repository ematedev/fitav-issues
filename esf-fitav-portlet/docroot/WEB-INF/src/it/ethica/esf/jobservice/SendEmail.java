package it.ethica.esf.jobservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.joda.time.DateTime;
import org.joda.time.Days;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.NoSuchConfigurationException;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFDocumentType;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil;


public class SendEmail implements MessageListener  {
	private static Log log = LogFactoryUtil.getLog(SendEmail.class);
	
	public void receive(Message arg0) throws MessageListenerException {
		log.info("Inizio batch invio email");
		try {
			this.startJob();
		} catch (Exception e) {
			log.error("Impossibile inviare le notifiche di scadenza documenti", e);
		}
		log.info("Termine batch invio email");
	}
	
	private void startJob() throws SystemException, PortalException {
		Map<Long, User> idToUser = new HashMap<Long, User>();
		Map<Long, List<ESFDocument>> idToExpiringDocs = new HashMap<Long, List<ESFDocument>>();
		Map<Long, ESFDocumentType> idToDocumentType = null;
//		int count = ESFDocumentLocalServiceUtil.getESFDocumentsCount();	//TODO gestire iterazione con cicli a pagine ?
		List<ESFDocument> expiringDocs = null;
		User user = null;
		List<ESFDocument> documents = ESFDocumentLocalServiceUtil.findAll();
		List<ESFDocumentType> types = ESFDocumentTypeLocalServiceUtil.getESFDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		idToDocumentType = this.convertToMap(types);
		int months = 0;
		int days = 0;
		int daysToNotify = 0;
		ESFDocumentType type = null;
		boolean toNotify = false;
		Date today = DateUtil.newDate();
		String sDate = null;
		ESFConfiguration conf = null;
		String notificationMailFrom = null;
		String internalMailCC = null; 
		log.debug("Lettura della configurazione invio mail");
		try {
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("NOTIFICATION_TO_ADDRESS");
			notificationMailFrom = conf.getValue();
			conf = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("NOTIFICATION_CC_ADDRESS");
			internalMailCC = conf.getValue();
		} catch (SystemException e) {
			log.error("Errore durante la lettura della configurazione", e);
			throw e;
		}catch (NoSuchConfigurationException e){
			log.error("La configurazione richiesta non è stata trovata", e);
		}	
		for(ESFDocument document : documents){
			type = idToDocumentType.get(document.getEsfDocumentTypeId());
			months = type.getExpirationMonthsNotice();
			days = Days.daysBetween(new DateTime(today), new DateTime(document.getExpirationDate())).getDays();
			sDate = this.parseDate(document.getExpirationDate());
			log.debug("ExpirationDate: "+sDate);
			daysToNotify = months*30;
			
			toNotify = (days - daysToNotify) == 0; // da riportare a == 0 per non notificare giornalmente dopo la prima volta
			log.debug("Days: "+days+" - DaysToNotify: "+daysToNotify+" - toNotify: "+toNotify);
			if(toNotify && daysToNotify!=0){	//non invio la notifica se i mesi di preavviso sono settati a 0
				log.debug("Documento in scadenza: "+document.getEsfDocumentId());
				expiringDocs = idToExpiringDocs.get(document.getEsfUserId());	//Leggo la lista dei documenti scaduti dell'utente
				user = idToUser.get(document.getEsfUserId());
				try {
					if(expiringDocs==null){	
						//Se non esiste la creo e leggo le info dell'utente (Se non c'erano documenti per l'utente non c'è nemmeno lui nelle mappe d'appoggio)
						user = UserLocalServiceUtil.getUser(document.getEsfUserId());
						expiringDocs = new ArrayList<ESFDocument>();
						idToUser.put(document.getEsfUserId(), user);
					}
					expiringDocs.add(document);	//Inserisco il documento corrente
					idToExpiringDocs.put(document.getEsfUserId(), expiringDocs);
				} catch (Exception e) {
					log.error("[SendEmailError]Errore nella lettura dell'utente: "+document.getEsfUserId());
				}
			}
		}
		this.sendNotifications(idToUser, idToExpiringDocs, notificationMailFrom, internalMailCC);
	}
	
	private String parseDate(Date date){
		String sDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sDate = sdf.format(date);		
		return sDate;
	}
	
	private void sendNotifications(Map<Long, User> idToUser, Map<Long, List<ESFDocument>> idToExpiringDocs, String notificationMailFrom, String internalMailCC) throws PortalException, SystemException {
		InternetAddress fromAddress = null;
		InternetAddress[] ccAddresses = null;
		if(!idToUser.isEmpty()){
			log.debug("Indirizzo in FROM: "+notificationMailFrom);
			log.debug("Indirizzi in CC: "+internalMailCC);
			fromAddress = this.createAddress(notificationMailFrom); 
			ccAddresses = this.createCCFromConfiguration(internalMailCC);
			for(User user : idToUser.values()){
				this.sendNotification(user, idToExpiringDocs.get(user.getUserId()), fromAddress, ccAddresses);
			}
			log.info("Inviate "+idToUser.size() +" notifiche");
		}
	}

	private Map<Long, ESFDocumentType> convertToMap(List<ESFDocumentType> types){
		Map<Long, ESFDocumentType> idToDocumentType = new HashMap<Long, ESFDocumentType>();
		for(ESFDocumentType type : types){
			idToDocumentType.put(type.getEsfDocumentTypeId(), type);
		}		
		return idToDocumentType;
	}

	private void sendNotification(User utente, List<ESFDocument> documents, InternetAddress fromAddress, InternetAddress[] ccAddresses) throws PortalException, SystemException{
		String msg = null;
		String docs = "";		
		String completeMsg = "Gentile %s %s,%nla presente per notificare la scadenza del/i documento/i: %s%n%nSi prega di provvedere al rinnovo.%nDistinti saluti";
		for(ESFDocument doc : documents){
			docs = docs.concat(String.format("%nTipo Documento: %s - Numero Documento: %s - Data Scadenza: %s", doc.getType(), doc.getCode(), this.parseDate(doc.getExpirationDate())));
		}
//		msg = prefix + docs + suffix;
		msg = String.format(completeMsg, utente.getFirstName(), utente.getLastName(), docs);
		log.debug("Messaggio mail da inviare: "+msg);
//		InternetAddress fromAddress = new InternetAddress();
//		fromAddress.setAddress(notificationMailFrom);
//		InternetAddress toAddress= new InternetAddress();
//		toAddress.setAddress(utente.getEmailAddress());
		
		MailMessage mailMessage = new MailMessage();
		mailMessage.setTo(fromAddress);
		mailMessage.setFrom(fromAddress);
		mailMessage.setCC(ccAddresses);
		mailMessage.setSubject("Notifica Documento/i in scadenza");
		mailMessage.setBody(msg);
//		MailServiceUtil.sendEmail(mailMessage);	//TODO scommentare per abilitare l'invio
	}
	
	private InternetAddress[] createCCFromConfiguration(String internalMailCC){
		InternetAddress address = null;
		List<InternetAddress> addresses = new ArrayList<InternetAddress>();
		String[] indirizziConf = null;
		if(internalMailCC!=null && !internalMailCC.isEmpty()){
			indirizziConf = internalMailCC.split(",");
			for(String indirizzo : indirizziConf){
				address= createAddress(indirizzo);
				addresses.add(address);
			}
		}
		return addresses.toArray(new InternetAddress[addresses.size()]);
	}
	
	private InternetAddress createAddress(String indirizzo){
		InternetAddress address = null;
		address= new InternetAddress();
		address.setAddress(indirizzo);
		return address;
	}
}
