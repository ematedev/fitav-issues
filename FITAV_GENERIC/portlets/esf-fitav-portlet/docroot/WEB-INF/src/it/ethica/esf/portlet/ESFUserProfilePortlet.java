package it.ethica.esf.portlet;

//import it.ethica.esf.model.City;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCountry;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFUser;
//import it.ethica.esf.model.Province;
//import it.ethica.esf.model.Region;
//import it.ethica.esf.service.CityLocalServiceUtil;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCountryLocalServiceUtil;
import it.ethica.esf.service.ESFProvinceLocalServiceUtil;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
//import it.ethica.esf.service.ProvinceLocalServiceUtil;
//import it.ethica.esf.service.RegionLocalServiceUtil;
import it.ethica.esf.service.persistence.CityPK;
import it.ethica.esf.service.persistence.ProvincePK;
import it.ethica.esf.service.persistence.RegionPK;
import it.ethica.esf.util.ManageDate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ContactServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFUtentePortlet
 */
public class ESFUserProfilePortlet extends MVCPortlet {

	public void upUser(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		/*Get dell'utente attualmente loggato*/
		ESFUser user =null;
		ThemeDisplay themeDisplay=null;
		long userId = 0;
		long companyId =0;
		String className ="";
		long classPK =0;
		try{
			themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
			userId=themeDisplay.getUserId();
//			System.out.println("Il mio userId e': "+userId
//					+" e sto per gettare l'utente di questo id");
			user = ESFUserLocalServiceUtil.getESFUser(userId);
//			System.out.println("Utente get-tato");
			companyId = themeDisplay.getCompanyId();
//			System.out.println("company id: "+companyId);
			className = ESFUser.class.getName();
//			System.out.println("class name: "+className);
			classPK = user.getPrimaryKey();
//			System.out.println("classPK: "+classPK);
		}
		catch(Exception e){e.printStackTrace();}
		
		/*Getto le credenziali dell'utente*/
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String genderUser = ParamUtil.getString(actionRequest, "genderUser");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String zip = ParamUtil.getString(actionRequest, "zip");
		String countryId=ParamUtil.getString(actionRequest, "country");
		String regionId=ParamUtil.getString(actionRequest, "region");
		String provinceId=ParamUtil.getString(actionRequest, "province");
		long cityId = ParamUtil.getLong(actionRequest, "city");
		/*get della data di nascita e relativo set*/
		String es = ParamUtil.getString(actionRequest, "birthday");
		Date birthday = null;
		try {
			birthday = ManageDate.StringToDate(es);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		int year = ManageDate.getYear(birthday);
		int month = ManageDate.getMonth(birthday);
		int day = ManageDate.getDay(birthday);
		/*get di tutte le nazioni*/
		List<ESFCountry> countries=ESFCountryLocalServiceUtil.getESFCountries(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		
		/*get di tutte le nazioni*/
		List<ESFRegion> regions=ESFRegionLocalServiceUtil.getESFRegions(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		
		/*get di tutte le nazioni*/
		List<ESFProvince> provinces=ESFProvinceLocalServiceUtil.getESFProvinces(
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS,
				com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		/*Get dell'indirizzo e modifica di questo*/
		try {
			user.getOriginalUser().setFirstName(firstName);
			user.getOriginalUser().setLastName(lastName);
//			AddressLocalServiceUtil.addAddress(address);
			List<ESFAddress> addresses = null;
			try {
				addresses = ESFAddressLocalServiceUtil.getESFAddresses(
						companyId, className, classPK);
				for (ESFAddress a : addresses) {
					a.setStreet1(street1);
					a.setZip(zip);
					/*RegionPK regionPK=new RegionPK(regionId,countryId);
					Region region1 = RegionLocalServiceUtil
								.getRegion(regionPK);
					String regionName=region1.getName();
					region1.setName(regionName);
					ProvincePK provincePK=new ProvincePK(
								provinceId,regionId,countryId);
					Province province1=ProvinceLocalServiceUtil
								.getProvince(provincePK);
					String province=province1.getName();
					province1.setName(province);
					CityPK cityPK=new CityPK(cityId,provinceId,regionId,countryId);
					City city1 =CityLocalServiceUtil.getCity(cityPK);
					String city=city1.getName();
					city1.setName(city);*/
				}
			}
			catch(Exception e){e.printStackTrace();}
			Contact c = user.getOriginalUser().getContact();
			if (genderUser.equals("m")) {
				c.setMale(true);
			} else{
				c.setMale(false);}
			ContactLocalServiceUtil.updateContact(c);
			/*Getto e aggiorno Custom Fields dell'utente loggato*/
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					User.class.getName(), actionRequest);
			user.setExpandoBridgeAttributes(serviceContext);}
		finally {
			ESFUser updatedUser=ESFUserLocalServiceUtil.updateESFUser(user);
			if (Validator.isNotNull(updatedUser) &&
					updatedUser.getEsfUserId() > 0)
					SessionMessages.add(actionRequest, "user-success-update");
				else
					SessionErrors.add(actionRequest, "user-error-update");

		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

//		 User user = (User) request.getAttribute(WebKeys.USER);
//		 System.out.println("Utente catturato");
//		
//		 ThemeDisplay themeDisplay = new ThemeDisplay();
//		 System.out.println("Tema catturato");
//		 long currentUserId = ParamUtil.getLong(request, "currentUserId");
//		 System.out.println("Id Utente catturato");
//		 try {
//		 user = (User) UserLocalServiceUtil.getUser(currentUserId);
//		 }
//		 catch (PortalException e) {
//		 e.printStackTrace();
//		 }
//		 catch (SystemException e) {
//		 }
//		 request.setAttribute("themeDisplay", themeDisplay);
//		 request.setAttribute("user", user);
//		 System.out.println("Entro nella render");
		super.render(request, response);

	}
}
