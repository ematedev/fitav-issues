package it.ethica.esf.jobservice;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFRenewalLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class AffiliazioniAssociazioni implements MessageListener  {
		private static Log _log = LogFactoryUtil.getLog(AffiliazioniAssociazioni.class);
		
		public void receive(Message arg0) throws MessageListenerException {
			_log.debug("Inizio script AffiliazioniAssociazioni");
			List<ESFRenewal> esfrenewals = new ArrayList<ESFRenewal>();
			Date today =new Date();
			Calendar todayCalendar = Calendar.getInstance();
			int year = todayCalendar.get(Calendar.YEAR);	
			_log.debug("Valore Year: "+year);;
			_log.debug("Data di oggi: "+today);
			/*try {
				esfrenewals = ESFRenewalLocalServiceUtil.findByIsTotalYear(false,year);
				_log.debug("ESFRenewals non paganti ritrovati:  "+esfrenewals.size());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.info("Errore nel ritrovare esf renewals");
				e.printStackTrace();
				return;
			}
			for (ESFRenewal esfRenewal : esfrenewals) {
				long idESFOrganization = esfRenewal.getOrganizationId();
				ESFOrganization esfOrganization = null;
				try {
					 esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(idESFOrganization);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					_log.debug("Errore nel ritrovare l'esfOrganization con id = "+idESFOrganization );
					continue;
				}
				if(esfOrganization == null){
					_log.debug("Errore nel ritrovare l'esfOrganization con id = "+idESFOrganization );
					continue;
				}
				int typeOrganization = esfOrganization.getType();
				long primaryKeyOrganization = esfOrganization.getEsfOrganizationId();
				long groupId = 0;
				long companyId = 0;
				long userId = 0;
				String userName = "" ;
				try{
					groupId = esfOrganization.getGroupId();
					companyId = esfOrganization.getCompanyId();
					userId = esfOrganization.getUserId();
					userName = esfOrganization.getUserName();
				}
				catch(Exception e){
					_log.debug("Non trovate alcune informazioni non obbligatorie");
				}
				if(typeOrganization != ESFKeys.ESFOrganizationTypeId.ASSOCIATION){
					_log.debug("Trovato Organizzazione non di tipo Association");
					continue;
				}
				ESFEntityState esfEntityStateEnable = null;
				try {
					esfEntityStateEnable = 
					ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(ESFKeys.EsfClassInEntityState.organization, primaryKeyOrganization, ESFKeys.ESFStateType.ENABLE);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					_log.debug("Nessuna associazione attiva con id "+primaryKeyOrganization+" trovata");
					continue;
				}
				if(esfEntityStateEnable == null){
					_log.debug("Nessuna associazione attiva con id "+primaryKeyOrganization+" trovata");
					continue;
				}
				esfEntityStateEnable.setEndDate(today);
				try {
					ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityStateEnable);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					_log.debug("errore nell'aggiornare l'entity state  con id "+primaryKeyOrganization);
					continue;
				}
				
				ESFEntityState newESFEntityState = null;
				try {
					newESFEntityState = ESFEntityStateLocalServiceUtil.createESFEntityState(CounterLocalServiceUtil.increment("WEBINF.service.it.ethica.service.model.esfEntityState"));
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					_log.debug("Errore nel creare una nuova entity state");
				}
				newESFEntityState.setCreateDate(today);
				newESFEntityState.setStartDate(today);
				newESFEntityState.setClassPK(primaryKeyOrganization);
				newESFEntityState.setClassName(ESFKeys.EsfClassInEntityState.organization);
				newESFEntityState.setCompanyId(companyId);
				newESFEntityState.setUserId(userId);
				newESFEntityState.setUserName(userName);
				newESFEntityState.setGroupId(groupId);
				newESFEntityState.setEsfStateId(ESFKeys.ESFStateType.DISABLE);
				try {
					ESFEntityStateLocalServiceUtil.updateESFEntityState(newESFEntityState);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					_log.debug("Errore nel memorizzare la nuova entity state");
					e.printStackTrace();
					continue;
				}
				
			}*/
			_log.debug("Terminato processo AffiliazioniAssociazioni");
		}
}
