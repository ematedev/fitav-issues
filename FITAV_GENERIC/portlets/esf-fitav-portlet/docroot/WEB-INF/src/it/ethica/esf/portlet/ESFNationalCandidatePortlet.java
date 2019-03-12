package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;
//import com.sun.xml.internal.ws.util.xml.XmlUtil;

/**
 * Portlet implementation class ESFNationalCandidate
 */
public class ESFNationalCandidatePortlet extends MVCPortlet {

	public void chooseCandidate(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		PortletSession portletSession = request.getPortletSession();

		long[] contactIds = ParamUtil.getLongValues(request, "checkCandidateCheckbox");

		for (long contactId : contactIds) {

			Contact shooter = ContactLocalServiceUtil.getContact(contactId);

			String sessAttr = getSessAttr(contactId, portletSession);

			List<Contact> candidates = new ArrayList<Contact>();

			if (portletSession.getAttribute(sessAttr) != null) {

				candidates = (List<Contact>) portletSession.getAttribute(sessAttr);
			}

			if (!candidates.contains(shooter)) {
				
				candidates.add(shooter);
			}

			portletSession.setAttribute(sessAttr, candidates);
		}

	}

	public void deleteCandidate(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		long contactId = ParamUtil.getLong(request, "contactId");

		Contact shooter = ContactLocalServiceUtil.getContact(contactId);

		PortletSession portletSession = request.getPortletSession();

		String sessAttr = getSessAttr(contactId, portletSession);

		List<Contact> candidates = new ArrayList<Contact>();

		if (portletSession.getAttribute(sessAttr) != null) {

			candidates = (List<Contact>) portletSession.getAttribute(sessAttr);
		}

		candidates.remove(shooter);

		portletSession.setAttribute(sessAttr, candidates);

	}

	@SuppressWarnings("deprecation")
	public void sendCandidates(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
	
		PortletSession portletSession = request.getPortletSession();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		User user = themeDisplay.getUser();

		String mailTo =user.getEmailAddress();
		String mailFrom = "antopas84@gmail.com";// user.getEmailAddress();

		int year = ParamUtil.getInteger(request, "year");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeId");
		
		
		Calendar now = CalendarFactoryUtil.getCalendar();
		
		List<Contact> maleCandidates1 =(List<Contact>)request.getPortletSession().getAttribute("maleCandidatesList");
		List<Contact> maleJuniorCandidates1 =(List<Contact>)request.getPortletSession().getAttribute("maleJuniorCandidatesList");
		List<Contact> ladyCandidates1 = (List<Contact>)request.getPortletSession().getAttribute("ladyCandidatesList");
		List<Contact> ladyJuniorCandidates1 =(List<Contact>)request.getPortletSession().getAttribute("ladyJuniorCandidatesList");
		
	
		
		
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(ESFNational.class.getName(), request);
		
		now.set(Calendar.YEAR, year);
		Date startDate = now.getTime();




		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, 11);
		now.set(Calendar.DAY_OF_MONTH, 31);
		Date endDate =now.getTime();
	
		for(Contact contact: maleJuniorCandidates1){
			long nationalIds=contact.getContactId();
		try{
			
				
			
	ESFNational candidato=	ESFNationalLocalServiceUtil.getESFNational(nationalIds); 	
	Date date=candidato.getEndDate();
	if(!date.equals(endDate)) ESFNationalLocalServiceUtil.addESFNational(
			serviceContext.getUserId(), nationalIds, esfSportTypeId,
			startDate, endDate, startDate, serviceContext);
			
			
		}catch(Exception e){
			
			ESFNationalLocalServiceUtil.addESFNational(
					serviceContext.getUserId(), nationalIds, esfSportTypeId,
					startDate, endDate, startDate, serviceContext);
		}
		}
		for(Contact contact: maleCandidates1){
			long nationalIds=contact.getContactId();
		try{
			
				
			
	ESFNational candidato=	ESFNationalLocalServiceUtil.getESFNational(nationalIds); 	
	Date date=candidato.getEndDate();
	if(!date.equals(endDate)) ESFNationalLocalServiceUtil.addESFNational(
			serviceContext.getUserId(), nationalIds, esfSportTypeId,
			startDate, endDate, startDate, serviceContext);
			
			
		}catch(Exception e){
			
			ESFNationalLocalServiceUtil.addESFNational(
					serviceContext.getUserId(), nationalIds, esfSportTypeId,
					startDate, endDate, startDate, serviceContext);
		}
		}
		for(Contact contact: ladyJuniorCandidates1){
			long nationalIds=contact.getContactId();
		try{
			
				
			
	ESFNational candidato=	ESFNationalLocalServiceUtil.getESFNational(nationalIds); 	
	Date date=candidato.getEndDate();
	if(!date.equals(endDate)) ESFNationalLocalServiceUtil.addESFNational(
			serviceContext.getUserId(), nationalIds, esfSportTypeId,
			startDate, endDate, startDate, serviceContext);
			
			
		}catch(Exception e){
			
			ESFNationalLocalServiceUtil.addESFNational(
					serviceContext.getUserId(), nationalIds, esfSportTypeId,
					startDate, endDate, startDate, serviceContext);
		}
		}
		for(Contact contact: ladyCandidates1){
			long nationalIds=contact.getContactId();
		try{
			
				
			
	ESFNational candidato=	ESFNationalLocalServiceUtil.getESFNational(nationalIds); 	
		Date date=candidato.getEndDate();
			if(!date.equals(endDate)) ESFNationalLocalServiceUtil.addESFNational(
					serviceContext.getUserId(), nationalIds, esfSportTypeId,
					startDate, endDate, startDate, serviceContext);
			
		}catch(Exception e){
			
			ESFNationalLocalServiceUtil.addESFNational(
					serviceContext.getUserId(), nationalIds, esfSportTypeId,
					startDate, endDate, startDate, serviceContext);
		}
		}
		ESFSportType esfSportType = ESFSportTypeLocalServiceUtil
				.getESFSportType(esfSportTypeId);

		String ladyCandidates = getSessList(sessAttrLady, portletSession);
		String ladyJuniorCandidates = getSessList(sessAttrLadyJunior,
				portletSession);

		String maleCandidates = getSessList(sessAttrMale, portletSession);
		String maleJuniorCandidates = getSessList(sessAttrMaleJunior,
				portletSession);

		portletSession.removeAttribute(sessAttrLady);
		portletSession.removeAttribute(sessAttrLadyJunior);
		portletSession.removeAttribute(sessAttrMale);
		portletSession.removeAttribute(sessAttrMaleJunior);

		long mailTemplateId = 17501;

		JournalArticle template = JournalArticleLocalServiceUtil
				.getLatestArticle(themeDisplay.getScopeGroupId(),
						String.valueOf(mailTemplateId));

		MailMessage mailMessage = new MailMessage();

		try {

			mailMessage.setFrom(new InternetAddress(mailFrom));
			mailMessage.setTo(new InternetAddress(mailTo));
		} catch (AddressException e) {

			e.printStackTrace();
			SessionErrors.add(request, "email-address-error");
		}

		String content = template
				.getContentByLocale(themeDisplay.getLanguageId());
		//System.out.println("CONTENT: "+content);
		content = content.replace(START_VAR_TAG + YEAR + END_VAR_TAG,
				String.valueOf(year));
		content = content.replace(START_VAR_TAG + ESF_SPORT_TYPE + END_VAR_TAG,
				esfSportType.getName());
		content = content.replace(START_VAR_TAG + LADY_LIST + END_VAR_TAG,
				ladyCandidates);
		content = content.replace(
				START_VAR_TAG + LADY_JUNIOR_LIST + END_VAR_TAG,
				ladyJuniorCandidates);
		content = content.replace(START_VAR_TAG + MAN_LIST + END_VAR_TAG,
				maleCandidates);
		content = content.replace(START_VAR_TAG + MAN_JUNIOR_LIST + END_VAR_TAG,
				maleJuniorCandidates);
		content = content.replace(START_VAR_TAG + SENDER_NAME + END_VAR_TAG,
				user.getFirstName() + StringPool.SPACE + user.getLastName());
		//just for fixing a little bug...
		content = content.replace("]]>", StringPool.BLANK);

		String subject = template.getDescription(themeDisplay.getLocale());

		mailMessage.setSubject(subject);
		mailMessage.setBody(content);
		mailMessage.setHTMLFormat(true);

		MailServiceUtil.sendEmail(mailMessage);
	}

	private static String getSessAttr(long contactId,
			PortletSession portletSession)
					throws PortalException, SystemException {

		int juniorMaxAge = 20;

		Calendar juniorMaxBirthday = CalendarFactoryUtil.getCalendar();

		juniorMaxBirthday.add(Calendar.YEAR, -juniorMaxAge);

		Contact shooter = ContactLocalServiceUtil.getContact(contactId);

		String sessAttr = StringPool.BLANK;

		if (shooter.isMale()) {

			if (shooter.getBirthday().after(juniorMaxBirthday.getTime())) {

				sessAttr = sessAttrMaleJunior;
			}
			else {

				sessAttr = sessAttrMale;
			}
		}
		else {

			if (shooter.getBirthday().after(juniorMaxBirthday.getTime())) {

				sessAttr = sessAttrLadyJunior;
			}
			else {

				sessAttr = sessAttrLady;
			}
		}

		return sessAttr;
	}

	private static String getSessList(String sessAttr,
			PortletSession portletSession) {

		String result = StringPool.BLANK;

		List<Contact> candidates = new ArrayList<Contact>();

		if (portletSession.getAttribute(sessAttr) != null) {

			candidates = (List<Contact>) portletSession
					.getAttribute(sessAttr);
		}

		for (Contact candidate : candidates) {

			result += "<p>" + candidate.getLastName().toUpperCase()
					+ StringPool.SPACE + candidate.getFirstName() + "</p>";
		}

		return result;
	}

	private final static String sessAttrLady = "ladyCandidatesList";
	private final static String sessAttrLadyJunior = "ladyJuniorCandidatesList";
	private final static String sessAttrMale = "maleCandidatesList";
	private final static String sessAttrMaleJunior = "maleJuniorCandidatesList";

	private final static String START_VAR_TAG = "${";
	private final static String END_VAR_TAG = "}";
	private final static String YEAR = "YEAR";
	private final static String ESF_SPORT_TYPE = "ESF_SPORT_TYPE";
	private final static String LADY_LIST = "LADY_LIST";
	private final static String LADY_JUNIOR_LIST = "LADY_JUNIOR_LIST";
	private final static String MAN_LIST = "MAN_LIST";
	private final static String MAN_JUNIOR_LIST = "MAN_JUNIOR_LIST";
	private final static String SENDER_NAME = "SENDER_NAME";
}
