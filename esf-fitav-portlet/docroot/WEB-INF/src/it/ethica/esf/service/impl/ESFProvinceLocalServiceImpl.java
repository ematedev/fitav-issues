package it.ethica.esf.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.service.base.ESFProvinceLocalServiceBaseImpl;

/**
 * The implementation of the e s f province local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFProvinceLocalService} interface. <p> This is
 * a local service. Methods of this service will not have security checks based
 * on the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFProvinceLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFProvinceLocalServiceUtil
 */
public class ESFProvinceLocalServiceImpl
	extends ESFProvinceLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFProvinceLocalServiceUtil} to access the e
	 * s f province local service.
	 */

	public List<ESFProvince> findByCountry_Name(String idCountry, String name)
		throws SystemException, NoSuchUserESFUserRoleException {

		return esfProvincePersistence.findByCountryProvinceName(idCountry, name);

	}
	public List<ESFProvince> getByRegionCode(String id) throws SystemException, NoSuchUserESFUserRoleException{
		return esfProvincePersistence.findByC_R(id, "IT");
		
	}
	public List<ESFProvince> findByProvinceId(String id)
		throws SystemException, NoSuchUserESFUserRoleException {

	 return esfProvincePersistence.findByProvinceId(id);
	}

}
