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

			_log.debug("Terminato processo AffiliazioniAssociazioni");
		}
}
