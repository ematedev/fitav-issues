package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFSingleAffiliationPortlet
 */
public class ESFSingleAffiliationPortlet extends MVCPortlet {
 
	

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute("esfOrganizationId", themeDisplay.getScopeGroup().getOrganizationId());
		super.doView(renderRequest, renderResponse);
	}

	public void createSingleAffiliation(ActionRequest request, ActionResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		long esfShooterId = ParamUtil.getLong(request, "esfShooterId", -1);
		long esfCardId = ParamUtil.getLong(request, "esfCardId", -1);
		String paymentDate = ParamUtil.getString(request, "paymentDate", null);
		long esfOrganizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long userId = themeDisplay.getUserId();
		try {
			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);
			ESFCard currentCard = ESFCardLocalServiceUtil.fetchESFCard(esfCardId);
			ESFEntityState esfEntityState = new ESFEntityStateImpl();
			ESFCard newCard = ESFCardLocalServiceUtil.addESFCard(
					userId, 
					currentCard.getCode(), 
					currentCard.getCodeAlfa(), 
					currentCard.getCodeNum(), 
					esfEntityState, 
					esfShooterId, 
					esfOrganizationId, 
					ServiceContextFactory.getInstance(ESFCard.class.getName(), request));
			newCard.setOldCode(currentCard.getCode()+Calendar.getInstance().get(Calendar.YEAR));
			ESFCardLocalServiceUtil.updateESFCard(newCard);

			ESFEntityState es = ESFEntityStateLocalServiceUtil.findAllESFEntityStateByClassName_ClassPK(ESFCard.class.getName(), currentCard.getEsfCardId());
			es.setEndDate(Calendar.getInstance().getTime());
			es.setEsfStateId(2);
			ESFEntityStateLocalServiceUtil.updateESFEntityState(es);
			
			ESFEntityState newEs = ESFEntityStateLocalServiceUtil.findAllESFEntityStateByClassName_ClassPK(ESFCard.class.getName(), newCard.getEsfCardId());
			newEs.setStartDate(Calendar.getInstance().getTime());
			newEs.setEsfStateId(1);
			ESFEntityStateLocalServiceUtil.updateESFEntityState(newEs);

			ESFShooterAffiliationChrono chrono = ESFShooterAffiliationChronoLocalServiceUtil.createESFShooterAffiliationChrono(CounterLocalServiceUtil.increment());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
			try{
				date = sdf.parse(paymentDate);
			} catch (ParseException e) {
				date = Calendar.getInstance().getTime();
				_log.error(e.getMessage());
			}
			chrono.setAffiliationDate(date);
			chrono.setPaymentDate(date);
			chrono.setCard(newCard.getCode());
			chrono.setEsfOrganization(esfOrganization.getCode());
			chrono.setEsfuserId(esfShooterId);
			chrono.setPayment("50");
			chrono.setYear(Calendar.getInstance().get(Calendar.YEAR));
			ESFShooterAffiliationChronoLocalServiceUtil.updateESFShooterAffiliationChrono(chrono);
			
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		} catch (NoSuchUserException e) {
			_log.error(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		} 
	}
	
	private static final Log _log = LogFactoryUtil.getLog(ESFSingleAffiliationPortlet.class.getName());
}
