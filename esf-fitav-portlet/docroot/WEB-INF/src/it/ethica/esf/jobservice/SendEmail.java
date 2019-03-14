package it.ethica.esf.jobservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.ethica.esf.migration.util.ESFKeys;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Portlet;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;


public class SendEmail implements MessageListener  {
	private static Log log = LogFactoryUtil.getLog(SendEmail.class);
	public void receive(Message arg0) throws MessageListenerException {
		log.debug("Inizio batch invia email");
		ESFConfiguration configurationMonthsMail = null;
	/*	try{
			configurationMonthsMail = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey(
					"SEND_EMAIL");
		}
		catch(Exception e){
			log.warn("Errore nel ritrovare configurazione invio email");
		}
		if(Validator.isNull(configurationMonthsMail)){
			log.warn("Nessun valore trovato nel bd nella tabella configurazione per la key: "
						+ configurationMonthsMail);
			return;
		}
		int monthSendMail = Integer.parseInt(configurationMonthsMail.getValue());
		Calendar today = Calendar.getInstance();
		today.add(Calendar.MONTH, 1);
		Calendar triggerDate = Calendar.getInstance();
		triggerDate.set(triggerDate.get(Calendar.YEAR), 12, 31);
		triggerDate.add(Calendar.MONTH, -1*(monthSendMail));
		String oggi = today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.MONTH)+"/"+today.get(Calendar.YEAR);
		String innesco = triggerDate.get(Calendar.DAY_OF_MONTH)+"/"+triggerDate.get(Calendar.MONTH)+"/"+triggerDate.get(Calendar.YEAR);
		log.info("Sto confrontando "+ oggi +" con "+innesco);
		log.info("Valori recuperati per configurazione invio email: "+configurationMonthsMail.getValue());
		if(today.equals(triggerDate)){
			
				List<ESFOrganization> allOrganitations = new ArrayList<ESFOrganization>();
				try {
					allOrganitations =  ESFOrganizationLocalServiceUtil.findAllESFOrganizations
						(ESFKeys.ESFOrganizationTypeId.ASSOCIATION, ESFKeys.ESFStateType.DISABLE);
				} catch (PortalException | SystemException e1) {
					// TODO Auto-generated catch block
					System.out.println("Errore nel ricercare le organizzazioni");
					e1.printStackTrace();
					return;
				}
				
				log.debug("Organizzazioni ritrovate: " + allOrganitations.size() );
				for (ESFOrganization esfOrganization : allOrganitations) {
					long organizationId = esfOrganization.getEsfOrganizationId();
					List<ESFUserESFUserRole> memberAssociations = new ArrayList<ESFUserESFUserRole>();
					try {
						//da cambiare id presidente
						memberAssociations = ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(
							12013, organizationId);
						log.debug("Membri associazione ritrovate : " + memberAssociations.size() );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.warn("Errore nel ritrovare il presidente dell'associazione con id : "+ organizationId);
						e.printStackTrace();
						continue;
					}
					for (ESFUserESFUserRole esfUserESFUserRole : memberAssociations) {
						long esfUserid = esfUserESFUserRole.getEsfUserId();
						ESFUser user = null;
						String to = "";
						try {
							user =  ESFUserLocalServiceUtil.fetchESFUser(esfUserid);
						    to = user.getUserEmail();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							log.warn("Errore nel cercare l'utente con id: "+esfUserid+ " o nel ritrovare l'email");
							e.printStackTrace();
							continue;
						}
						if(to == "" || to == null){
							log.warn("Errore email null");
							continue;
						}
						String from = "ethica.web@gmail.com";
						String subject="This is email title"; 
						String body="Hello World, this is my first email";
						try {
							System.out.println("Sto inviando l'email a: " + to);
							//MailEngine.send(from, to, subject, body);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							log.warn("Errore nell'invio della mail");
							e.printStackTrace();
							continue;
						}
					}
				}
				log.debug("Fine batch invio email");
			} else{
				log.debug("Non e' ancora il momento di inviare le email");
			}*/
	}
}
