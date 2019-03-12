
package it.ethica.esf.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.impl.ESFConfigurationImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;

public class ESFCardPortlet extends MVCPortlet {

	private String templatePath = new String();

	@Override
	public void init(PortletConfig config)
		throws PortletException {

		templatePath = config.getInitParameter("template-path");
		super.init(config);
	}
	
	public void associateCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFCard.class.getName(), request);
		String to = ParamUtil.getString(request, "to");
		String from = ParamUtil.getString(request, "from");
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String maxAlfa = "";
		String alfa = "";
		String alfaEnd = "";
		int begin = 0;
		int end = 0;
		int maxnum = 0;
		List<ESFConfiguration> conf = new ArrayList<ESFConfiguration>();
		ESFConfiguration confMaxalfa = new ESFConfigurationImpl();
		ESFConfiguration confMaxnum = new ESFConfigurationImpl();
		long esfStateId = ESFKeys.ESFStateType.ENABLE;
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(esfStateId);
		conf = ESFConfigurationLocalServiceUtil
				.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.maxAlfa);
		
		confMaxalfa = conf.get(0);
		maxAlfa = confMaxalfa.getValue().toUpperCase();
		
		conf = ESFConfigurationLocalServiceUtil
				.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.maxNum);
		
		confMaxnum = conf.get(0);
		maxnum = Integer.valueOf(confMaxnum.getValue());
		
		
		
		alfa = from.substring(0, 2).toUpperCase();
		alfaEnd = to.substring(0, 2).toUpperCase();
		
		if(!alfa.equals(alfaEnd)){
			SessionErrors.add(request, "format-alfa-card-reference-error");
			response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
			return;
		}
		
		try {
			begin = Integer.valueOf((String) from.substring(2));
		} catch (Exception e) {
			SessionErrors.add(request, "format-num-card-reference-error");
			response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
			return;
		}
		try {
			end = Integer.valueOf((String) to.substring(2));
		} catch (Exception e) {
			SessionErrors.add(request, "format-num-card-reference-error");
			response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
			return;
		}
		if(end <= begin){
		SessionErrors.add(request, "begin-card-reference-error");
		response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
			return;
		}
		
		ESFCardLocalServiceUtil.addSelectedCard(esfOrganizationId, begin, end, alfa,
				 esfUserId , serviceContext);
		
		if((alfa.toUpperCase().compareTo(maxAlfa.toUpperCase()))>0 ){
			confMaxalfa.setValue(alfa);
			ESFConfigurationLocalServiceUtil.updateESFConfiguration(confMaxalfa);
			confMaxnum.setValue(String.valueOf(end));
			ESFConfigurationLocalServiceUtil.updateESFConfiguration(confMaxnum);
		}else if((alfa.toUpperCase().compareTo(maxAlfa.toUpperCase())) == 0 ){
			if(end > maxnum){
				confMaxnum.setValue(String.valueOf(end));
				ESFConfigurationLocalServiceUtil.updateESFConfiguration(confMaxnum);
			}
		}
		
		List<ESFConfiguration> configurations = new ArrayList<ESFConfiguration>();
		ESFConfiguration regionMaxCard = new ESFConfigurationImpl();
		configurations = ESFConfigurationLocalServiceUtil.getAllEsfConfigurations();
		
		
		for(ESFConfiguration configuration: configurations){
			
			if(configuration.getValue().length() >1){
			}
			if(configuration.getValue().length() > 2 && configuration.getValue().substring(0, 2).toUpperCase().equalsIgnoreCase(from.substring(0, 2).toUpperCase())){
				regionMaxCard = configuration;
				regionMaxCard.setValue(to);
				ESFConfigurationLocalServiceUtil.updateESFConfiguration(regionMaxCard);
			}
		}
		response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
		
	}
	
	public void updateRegionCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		
		String maxCardABR = ParamUtil.getString(request, "maxCardABR");
		String maxCardCAL = ParamUtil.getString(request, "maxCardCAL");
		String maxCardBAS = ParamUtil.getString(request, "maxCardBAS");
		
		String maxCardCAM = ParamUtil.getString(request, "maxCardCAM");
		String maxCardEMR = ParamUtil.getString(request, "maxCardEMR");
		String maxCardFVG = ParamUtil.getString(request, "maxCardFVG");
		
		String maxCardLAZ = ParamUtil.getString(request, "maxCardLAZ");
		String maxCardLIG = ParamUtil.getString(request, "maxCardLIG");
		String maxCardLOM = ParamUtil.getString(request, "maxCardLOM");
		
		String maxCardMAR = ParamUtil.getString(request, "maxCardMAR");
		String maxCardMOL = ParamUtil.getString(request, "maxCardMOL");
		String maxCardPIE = ParamUtil.getString(request, "maxCardPIE");
		
		String maxCardPUG = ParamUtil.getString(request, "maxCardPUG");
		String maxCardSAR = ParamUtil.getString(request, "maxCardSAR");
		String maxCardSIC = ParamUtil.getString(request, "maxCardSIC");
		
		String maxCardTOS = ParamUtil.getString(request, "maxCardTOS");
		String maxCardTAA = ParamUtil.getString(request, "maxCardTAA");
		String maxCardUMB = ParamUtil.getString(request, "maxCardUMB");
		
		String maxCardAOS = ParamUtil.getString(request, "maxCardAOS");
		String maxCardVEN = ParamUtil.getString(request, "maxCardVEN");
		
		ESFConfiguration conf = new ESFConfigurationImpl();
		
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_ABR");
		conf.setValue(maxCardABR); 
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_BAS");
		conf.setValue(maxCardBAS); 
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAL");
		conf.setValue(maxCardCAL); 
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_CAM");
		conf.setValue(maxCardCAM);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_EMR");
		conf.setValue(maxCardEMR);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_FVG");
		conf.setValue(maxCardFVG);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LAZ");
		conf.setValue(maxCardLAZ);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LIG");
		conf.setValue(maxCardLIG);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_LOM");
		conf.setValue(maxCardLOM);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MAR");
		conf.setValue(maxCardMAR);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_MOL");
		conf.setValue(maxCardMOL);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PIE");
		conf.setValue(maxCardPIE);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_PUG");
		conf.setValue(maxCardPUG);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SAR");
		conf.setValue(maxCardSAR);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_SIC");
		conf.setValue(maxCardSIC);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TOS");
		conf.setValue(maxCardTOS);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_TAA");
		conf.setValue(maxCardTAA);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_UMB");
		conf.setValue(maxCardUMB);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_AOS");
		conf.setValue(maxCardAOS);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		conf =  ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("MAXCODECARD_VEN");
		conf.setValue(maxCardVEN);
		ESFConfigurationLocalServiceUtil.updateESFConfiguration(conf);
		
		response.setRenderParameter("mvcPath", templatePath +
				"selectcard.jsp");
	}

	public void assignCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		int numTotCards = ParamUtil.getInteger(request, "numTotCards");
		int numCards = ParamUtil.getInteger(request, "numberOfCard");
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
		List<ESFCard> cards =  ESFCardLocalServiceUtil.getAllFreeCard();
		
		if(numCards > numTotCards){
			SessionErrors.add(request, "numberCard-reference-error");
			
		}else{
			for(int i = 0 ; i < numCards ; i++){
				cards.get(i).setEsfOrganizationId(esfOrganizationId);
				ESFCardLocalServiceUtil.updateESFCard(cards.get(i));
			}
		}
		response.setRenderParameter("mvcPath", "/html/esfcard/view.jsp");
		
	}

	public void createCard(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFCard.class.getName(), request);
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			int numCards = ParamUtil.getInteger(request, "numCards");
			int create = ESFCardLocalServiceUtil.createMultiESFCard( esfUserId, numCards, serviceContext);
			if(create == numCards){
				SessionMessages.add(request, "esfcard-add-success");
			}else{
				SessionMessages.add(request, "esfcard-partialadd-success");
			}
			
			response.setRenderParameter("mvcPath", templatePath +
					"view.jsp");
			
		}

}
