package it.ethica.esf.portlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.impl.ESFUserCategoryImpl;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;


/**
 * Portlet implementation class QualificationsFederalYouth
 */
public class ESFQualificationsFederalYouthPortlet extends MVCPortlet {

	
	public void updateQualification(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		// Nuova Gestione
		
		//	Calcolo delle categorie da eseguire sui tiratori Juniores in base ai meriti sportivi
		//	Da chiedere a Mario Magnanini come gestire perchè sono cambiate le gare
		//	Dopo il calcolo dei meriti sportivi si insericono i tiratori ancora in età Juniores
		//	nelle giusta Categoria per l'anno in esame
		//	passo ora a vedere gli Juniores che non hanno cambaito categoria per merito sportivo 
		//	e li iserisco nella categoria che avevano l'anno precedente
		
		//	ricerca dei tiratori che sono presenti in Juoniores che hanno ancora età da Juniores e non sono 
		//	presenti in ESFUserCategory con startDate dell'anno in esame
		
		//anno attuale
		
		ThemeDisplay themeDisplay = 
						(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long companyId = themeDisplay.getLayout().getCompanyId();
		long userId = themeDisplay.getLayout().getUserId();
		String userName = themeDisplay.getLayout().getUserName();
		
		
		
		Date today = new Date();
		
		Calendar calendar = GregorianCalendar.getInstance();
		int actualYear = calendar.get( Calendar.YEAR );
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = sdf.parse("01/01/"+actualYear);
		Date endDate = sdf.parse("31/12/"+actualYear);
		int year = 0;
		int MAXage = 0;
		
		_log.debug("******actualYear="+actualYear);
		
		ESFConfiguration youthMAXAge = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("youth-age-MAX");
		
		_log.debug("******youthMAXAge="+youthMAXAge);
		
		MAXage = Integer.parseInt(youthMAXAge.getValue());
		
		year = actualYear-MAXage;
		
		_log.debug("******year="+year);
		
		List<ESFUserCategory> youthNotPromoved = new ArrayList<ESFUserCategory>();
		youthNotPromoved = ESFUserCategoryLocalServiceUtil.findYouthNotPromoved(year);
		
		_log.debug("******youthNotPromoved="+youthNotPromoved);
		
		for (ESFUserCategory cat : youthNotPromoved){
			
			_log.debug("******cat="+cat);

			ESFUserCategory youth = new ESFUserCategoryImpl();
			long userCategoryId = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youth.setEsfUserCategoryId(userCategoryId);
			youth.setGroupId(cat.getGroupId());
			youth.setCompanyId(cat.getCompanyId());
			youth.setUserId(cat.getUserId());
			youth.setUserName(cat.getUserName());
			youth.setCreateDate(today);
			youth.setEsfUserId(cat.getEsfUserId());
			youth.setEsfCategoryId(cat.getEsfCategoryId());
			youth.setEsfSportTypeId(cat.getEsfSportTypeId());
			youth.setStartDate(startDate);
			youth.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youth);
		}
		
		//ricerco i tiratori in età da Juniores che non erano presenti 
		
		List<ESFUser> newYouth = new ArrayList<ESFUser>();
		newYouth = ESFUserLocalServiceUtil.findNewYouthShooter(year);
		
		for(ESFUser user : newYouth){
			
			_log.debug("******user="+user);
			_log.debug("*****user name ="+user.getFirstName());
			_log.debug("*****user lastName ="+user.getLastName());
			_log.debug("*****user birthday ="+user.getBirthday().toString());
			long foId = ESFSportTypeLocalServiceUtil.findIDSportByCode("DO013");
			long skId = ESFSportTypeLocalServiceUtil.findIDSportByCode("DO010");
			long dtId = ESFSportTypeLocalServiceUtil.findIDSportByCode("DO003");
			
			//aggiungo utente a juniores FossaOlimpica
			
			ESFUserCategory youthFO = new ESFUserCategoryImpl();
			long userCategoryIdFO = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youthFO.setEsfUserCategoryId(userCategoryIdFO);
			youthFO.setGroupId(groupId);
			youthFO.setCompanyId(companyId);
			youthFO.setUserId(userId);
			youthFO.setUserName(userName);
			youthFO.setCreateDate(today);
			youthFO.setEsfUserId(user.getEsfUserId());
			//verifico se user maschio o donna
			if(user.getMale()){
				youthFO.setEsfCategoryId(1); //ID categoria FollaOlimpica Junior Maschile
			}else{
				youthFO.setEsfCategoryId(2); //ID categoria FollaOlimpica Junior Femminile
			}
			
			youthFO.setEsfSportTypeId(foId); //id fossa olimpica
			youthFO.setStartDate(startDate);
			youthFO.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youthFO);
			
			
			//aggiungo utente a juniores Doubletrap
			
			ESFUserCategory youthDt = new ESFUserCategoryImpl();
			long userCategoryIdDt = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youthDt.setEsfUserCategoryId(userCategoryIdDt);
			youthDt.setGroupId(groupId);
			youthDt.setCompanyId(companyId);
			youthDt.setUserId(userId);
			youthDt.setUserName(userName);
			youthDt.setCreateDate(today);
			youthDt.setEsfUserId(user.getEsfUserId());
			youthDt.setEsfCategoryId(3); //ID categoria DoubleTrap Junior Maschile
			youthDt.setEsfSportTypeId(dtId); //id doubleTrap
			youthDt.setStartDate(startDate);
			youthDt.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youthDt);
			
			
			//aggiungo utente juniores a Skeet
			
			ESFUserCategory youthSK = new ESFUserCategoryImpl();
			long userCategoryIdSK = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFUserCategory");
			
			youthSK.setEsfUserCategoryId(userCategoryIdSK);
			youthSK.setGroupId(groupId);
			youthSK.setCompanyId(companyId);
			youthSK.setUserId(userId);
			youthSK.setUserName(userName);
			youthSK.setCreateDate(today);
			youthSK.setEsfUserId(user.getEsfUserId());
			//verifico se user maschio o donna
			if(user.getMale()){
				youthSK.setEsfCategoryId(4); //ID categoria Skeet Junior Maschile
			}else{
				youthSK.setEsfCategoryId(5); //ID Skeet Skeet Junior Femminile
			}
			
			youthSK.setEsfSportTypeId(skId); //id Skeet 
			youthSK.setStartDate(startDate);
			youthSK.setEndDate(endDate);
			
			ESFUserCategoryLocalServiceUtil.addESFUserCategory(youthSK);
		}
		
		_log.debug("Uscita dal Metodo");
		
	}
	private static Log _log =
					LogFactoryUtil.getLog(ESFQualificationsFederalYouthPortlet.class);
}