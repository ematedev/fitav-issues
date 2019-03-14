
package it.ethica.esf.util;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

public class ESFOrganizationUtil {

	public static List<ESFAddress> getESFAddresses(ActionRequest actionRequest) {
		
		String esfAddressesIndexesString =
			actionRequest.getParameter("addressesIndexes");

		if (esfAddressesIndexesString == null) {
			return null;
		}

		List<ESFAddress> esfAddresses = new ArrayList<ESFAddress>();

		int[] esfAddressesIndexes = StringUtil.split(esfAddressesIndexesString, 0);

		int addressPrimary =
			ParamUtil.getInteger(actionRequest, "addressPrimary");

		for (int addressesIndex : esfAddressesIndexes) {
			long addressId =
				ParamUtil.getLong(actionRequest, "addressId" + addressesIndex);

			String street1 =
				ParamUtil.getString(actionRequest, "addressStreet1_" +
					addressesIndex);
			String street2 =
				ParamUtil.getString(actionRequest, "addressStreet2_" +
					addressesIndex);
			String street3 =
				ParamUtil.getString(actionRequest, "addressStreet3_" +
					addressesIndex);
			String zip =
				ParamUtil.getString(actionRequest, "addressZip" +
					addressesIndex);
			double latitude =
							ParamUtil.getDouble(actionRequest, "latitude" +
								addressesIndex);
			double longitude =
							ParamUtil.getDouble(actionRequest, "longitude" +
								addressesIndex);

//			if (Validator.isNull(street1) && Validator.isNull(street2) &&
//				Validator.isNull(street3) && Validator.isNull(city) &&
//				Validator.isNull(zip) && (countryId == 0)) {
//
//				continue;
//			}

			boolean mailing =
				ParamUtil.getBoolean(actionRequest, "addressMailing" +
					addressesIndex);

			boolean primary = false;

			if (addressesIndex == addressPrimary) {
				primary = true;
			}

			ESFAddress esfAddress =
				ESFAddressLocalServiceUtil.createESFAddress(addressId);

			try {
				esfAddress.setStreet1(street1);
				esfAddress.setStreet2(street2);
				esfAddress.setStreet3(street3);
				esfAddress.setZip(zip);
				esfAddress.setMailing(mailing);
				esfAddress.setPrimary_(primary);
				esfAddress.setLatitude(latitude);
				esfAddress.setLongitude(longitude);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}

			esfAddresses.add(esfAddress);
		}

		return esfAddresses;
	}
	
	private static Log _log =
					LogFactoryUtil.getLog(ESFOrganizationUtil.class);
}
