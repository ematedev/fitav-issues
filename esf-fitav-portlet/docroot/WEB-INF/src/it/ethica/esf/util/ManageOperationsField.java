
package it.ethica.esf.util;

import it.ethica.esf.NoSuchCodeOrgException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.impl.ESFAddressImpl;
import it.ethica.esf.model.impl.ESFFieldESFElectronicImpl;
import it.ethica.esf.model.impl.ESFPhoneImpl;
import it.ethica.esf.portlet.ESFNationalMatchPortlet;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ManageOperationsField {
	private static Log _log = LogFactoryUtil.getLog(ManageOperationsField.class);
	private static String exRegularFiscalCode="^[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$";

	public static List<ESFAddress> getAddresses(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {
		
		List<ESFAddress> addresses = new ArrayList<ESFAddress>();
		
		ESFAddress esfAddressClone = new ESFAddressImpl();
		
		int number = ParamUtil.getInteger(actionRequest, "number");
		boolean isEqual = ParamUtil.getBoolean(actionRequest,"isEqual");
		
		for (int i = 0; i < number; i++) {
			long esfAddressId = ParamUtil.getLong(actionRequest, "esfAddressId"+i);
			double longitude = ParamUtil.getDouble(actionRequest, "longitude"+i);
			double latitude = ParamUtil.getDouble(actionRequest, "latitude"+i);
			String street1 = ParamUtil.getString(actionRequest, "street1"+i);
			String zip = ParamUtil.getString(actionRequest, "zip"+i);
			String esfCountryId = ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY;
			boolean internationalPlace = ParamUtil.getBoolean(actionRequest, "international-place"+i);
			String esfRegionId = "";
			String esfProvinceId = "";
			long esfCityId = 0;

			
			if(!internationalPlace){
			esfRegionId = ParamUtil.getString(actionRequest, "esfRegionId"+i);
			 esfProvinceId =
				ParamUtil.getString(actionRequest, "esfProvinceId"+i);
			esfCityId = ParamUtil.getLong(actionRequest, "esfCityId"+i);
			}else{
			
			esfCountryId = ParamUtil.getString(actionRequest, "countryId"+i);
			esfProvinceId = ParamUtil.getString(actionRequest, "esfProvinceIdNaz"+i);
			esfRegionId= ParamUtil.getString(actionRequest, "esfCityIdNaz"+i);
			
			}
			
			int listTypeId = ParamUtil.getInteger(actionRequest, "listTypeIdAddr"+i);
			
			if(Validator.isBlank(street1))
				street1="vuoto";
			
			if(Validator.isBlank(zip))
				zip="vuoto";
			
			ESFAddress esfAddress = new ESFAddressImpl();
			esfAddress.setWrapper(true);
			esfAddress.setEsfAddressId(esfAddressId);
			esfAddress.setLongitude(longitude);
			esfAddress.setLatitude(latitude);
			esfAddress.setEsfCountryId(esfCountryId);
			esfAddress.setEsfRegionId(esfRegionId);
			esfAddress.setEsfProvinceId(esfProvinceId);
			esfAddress.setEsfCityId(esfCityId);
			esfAddress.setStreet1(street1);
			esfAddress.setStreet2(null);
			esfAddress.setStreet3(null);
			esfAddress.setZip(zip);
			esfAddress.setTypeId(12000);
			esfAddress.setMailing(false);
			esfAddress.setPrimary_(false);
			esfAddress.setListTypeId(listTypeId);
			esfAddress.setIsNotNational(internationalPlace);
			//ESFAddressLocalServiceUtil.updateESFAddress(esfAddress);
			
			
			if(isEqual && i == 0){
				
				esfAddressClone.setWrapper(true);
				esfAddressClone.setEsfAddressId(esfAddressId);
				esfAddressClone.setLongitude(longitude);
				esfAddressClone.setLatitude(latitude);
				esfAddressClone.setEsfCountryId(esfCountryId);
				esfAddressClone.setEsfRegionId(esfRegionId);
				esfAddressClone.setEsfProvinceId(esfProvinceId);
				esfAddressClone.setEsfCityId(esfCityId);
				esfAddressClone.setStreet1(street1);
				esfAddressClone.setStreet2(null);
				esfAddressClone.setStreet3(null);
				esfAddressClone.setZip(zip);
				esfAddressClone.setTypeId(12000);
				esfAddressClone.setMailing(false);
				esfAddressClone.setPrimary_(false);
				esfAddressClone.setListTypeId(listTypeId);
				esfAddressClone.setIsNotNational(internationalPlace);
				//ESFAddressLocalServiceUtil.updateESFAddress(esfAddressClone);
				
			}
			
			if(isEqual && i == 2){
				addresses.add(esfAddressClone);
				
			}
			else{
				addresses.add(esfAddress);
			
			}
		}
		
		return addresses;
	}
	
	public static boolean validate(String fiscalCode){
		 Pattern p = Pattern.compile(exRegularFiscalCode);
		 Matcher m = p.matcher(fiscalCode.toLowerCase());
		 return m.matches();
	}
	
	public static List<ESFPhone> getPhones(ActionRequest actionRequest, ActionResponse actionResponse) {
		int number = ParamUtil.getInteger(actionRequest, "numberOfPhones");
		List<ESFPhone> phones = new ArrayList<ESFPhone>();

		for (int i = 0; i < number; i++) {
			
			int listTypeId = ParamUtil.getInteger(actionRequest, "listTypeIdPhone"+i);
			long phoneNumberId =
				ParamUtil.getLong(actionRequest, "phoneNumberId" + i);
			String phoneNumber =
				ParamUtil.getString(actionRequest, "phoneNumber" + i);
			ESFPhone phone = new ESFPhoneImpl();
		
			phone.setNumber(phoneNumber);
			phone.setListTypeId(listTypeId);
			phone.setEsfPhoneId(phoneNumberId);
			phone.setWrapper(true);
			
			int typeId = 0;
			try {
				List<ListType> phoneListType =
					ListTypeServiceUtil.getListTypes(Organization.class.getName() +
						ListTypeConstants.PHONE);

				typeId = phoneListType.get(1).getListTypeId();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			phone.setTypeId(typeId);
			if (Validator.isNotNull(phoneNumber)) {
				phones.add(phone);
			}
		}
		return phones;

	}
	
	public static List<ESFFieldESFElectronic> getEsfFieldESFElectronics(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		int number = ParamUtil.getInteger(actionRequest, "numberOfMachines");
		
		List<ESFFieldESFElectronic> esfFieldESFElectronics = new ArrayList<ESFFieldESFElectronic>();

		for (int i = 0; i < number; i++) {
			
			long brandId =
				ParamUtil.getLong(actionRequest, "brandId" + i);
			long electronicId =
				ParamUtil.getLong(actionRequest, "electronicId" + i);
			String description = 
				ParamUtil.getString(actionRequest, "description" + i);

			if(brandId != 0 || electronicId != 0){
				
				ESFFieldESFElectronic esfFieldESFElectronic = new ESFFieldESFElectronicImpl();
	
				esfFieldESFElectronic.setBrandId(brandId);
				esfFieldESFElectronic.setElectronicId(electronicId);
				esfFieldESFElectronic.setDescription(description);
			
				esfFieldESFElectronics.add(esfFieldESFElectronic);
				
			}
		}

		return esfFieldESFElectronics;

	}
	
	public static String calculateDelegationCode(int typeOrg, List<ESFAddress> esfAddresses) 
					throws NoSuchCodeOrgException, SystemException {

		String code = "";
		
		if(typeOrg == 0)
		
			return "";
		
		if(esfAddresses.size() == 0)
			
			return null;
		
		ESFAddress esfAddress = esfAddresses.get(0);
		
		if(typeOrg == ESFKeys.ESFOrganizationTypeId.REGION){
			
			if(Validator.isBlank(esfAddress.getEsfRegionId())){
				 
				return null;
			
			}
			else{
				
				code = esfAddress.getEsfRegionId();
				
			}
		}
		else if(typeOrg == ESFKeys.ESFOrganizationTypeId.PROVINCE){
			
			if(Validator.isBlank(esfAddress.getEsfProvinceId())){
				 
				return null;
			
			}
			else{
				
				code = esfAddress.getEsfProvinceId();
				
			}
		}
		else if(typeOrg == ESFKeys.ESFOrganizationTypeId.ASSOCIATION){
			
			return null;
			
		}
		
		return code;
	}
	
	public static String calculateAssociationCode(String provinceId ) 
					throws NoSuchCodeOrgException, SystemException {
		if(Validator.isBlank(provinceId)){
			return null;
		}

		String code = provinceId;
		List<ESFOrganization> esfOrganizzations =
			ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(provinceId);
		long sequence = 0;
		if (Validator.isNotNull(esfOrganizzations)) {
			for (ESFOrganization esfOrganization : esfOrganizzations) {
				String tmpCode = esfOrganization.getCode();
				if (tmpCode.length() > code.length()) {
					try{
						long tmpSequence =
								Long.parseLong(tmpCode.substring(code.length()));
						if (tmpSequence > sequence)
							sequence = tmpSequence;
					}
					catch(Exception e){
						_log.info("Errore nel calcolare il long del codice");
						continue;
					}
				}
			}
			
		}else{
			sequence = -1;
		}
		sequence++;
		code = code + (sequence<10?"0"+sequence:sequence);
		return code;
	}

/*
 	public static String calculateAssociationCode(String provinceId ) 
					throws NoSuchCodeOrgException, SystemException {

		if(Validator.isBlank(provinceId)){
			return null;
		}

		String code = provinceId;
		ESFCodeOrg esfCodeOrg = ESFCodeOrgLocalServiceUtil.findESFCodeOrgByN_C(
			ESFOrganization.class.getName(), code);
		long sequence = 1;
		if(Validator.isNotNull(esfCodeOrg)){
			sequence = esfCodeOrg.getSequence() + 1;
		}

		code = code + sequence;

		return code;
	}
	

	public static boolean updateAssociationCode(String provinceId,String testCode) 
					throws NoSuchCodeOrgException, SystemException {

		if (Validator.isBlank(provinceId)) {
			throw new NoSuchCodeOrgException();
		}

		ESFCodeOrg esfCodeOrg =
			ESFCodeOrgLocalServiceUtil.findESFCodeOrgByN_C(
				ESFOrganization.class.getName(), provinceId);
		long sequence = 1;
		if (Validator.isNotNull(esfCodeOrg)) {
			sequence += esfCodeOrg.getSequence();
		}
		
		String code=provinceId+sequence;
		if(code.equalsIgnoreCase(testCode)){
			if(Validator.isNotNull(esfCodeOrg)){
				ESFCodeOrgLocalServiceUtil.updateESFCode(
					esfCodeOrg.getEsfCodeOrgId(), sequence);
			}
			else {
				ESFCodeOrgLocalServiceUtil.addESFCode(
					ESFOrganization.class.getName(), provinceId, sequence);
			}
			return false;
		}
		
		return true;
		
	}
*/
}
