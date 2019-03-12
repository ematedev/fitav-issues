
package it.ethica.esf.hook;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ESFFitavStartUp extends SimpleAction {

	private Log _log=LogFactoryUtil.getLog(ESFFitavStartUp.class);
	
	public ESFFitavStartUp() {

		super();
	}

	public void run(String[] ids)
		throws ActionException {

		_log.info("Start up event's running...");

		List<ESFUserRole> esfUserRolesCT =
			ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
				ESFKeys.ESFUserRoleDefault.COACH,
				ESFKeys.ESFUserRoleDefault.COACH, ESFKeys.ESFStateType.ENABLE);

		List<ESFUserRole> esfUserRolesReferee =
			ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
				ESFKeys.ESFUserRoleDefault.REFEREE,
				ESFKeys.ESFUserRoleDefault.REFEREE, ESFKeys.ESFStateType.ENABLE);

		List<ESFUserRole> esfUserRolesDoctor =
			ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
				ESFKeys.ESFUserRoleDefault.DOCTOR,
				ESFKeys.ESFUserRoleDefault.DOCTOR, ESFKeys.ESFStateType.ENABLE);

		List<ESFUserRole> esfUserRolesFitavManager =
			ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
				ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
				ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
				ESFKeys.ESFStateType.ENABLE);

		try {
			Company company =
				CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));

			User user =
				UserLocalServiceUtil.getDefaultUser(company.getCompanyId());

			long globalGroupId = company.getGroup().getGroupId();

			if (esfUserRolesReferee.size() == 0) {
				Map<Locale, String> descriptionMap =
					new HashMap<Locale, String>();
				descriptionMap.put(
					LocaleUtil.getDefault(), ESFKeys.ESFUserRoleDefault.REFEREE);

				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(
					LocaleUtil.getDefault(), ESFKeys.ESFUserRoleDefault.REFEREE);

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

				ESFUserRoleLocalServiceUtil.addESFUserRole(
					user.getUserId(), globalGroupId, company.getCompanyId(),
					ESFKeys.ESFUserRoleDefault.REFEREE,
					ESFKeys.ESFUserRoleDefault.REFEREE, descriptionMap,
					titleMap, ESFKeys.ESFUserRoleType.REGULAR,
					StringPool.BLANK, false, false, false, false, 0,
					esfEntityState);
			}
			if (esfUserRolesCT.size() == 0) {
				Map<Locale, String> descriptionMap =
					new HashMap<Locale, String>();
				descriptionMap.put(
					LocaleUtil.getDefault(), ESFKeys.ESFUserRoleDefault.COACH);

				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(
					LocaleUtil.getDefault(), ESFKeys.ESFUserRoleDefault.COACH);

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

				ESFUserRoleLocalServiceUtil.addESFUserRole(
					user.getUserId(), globalGroupId, company.getCompanyId(),
					ESFKeys.ESFUserRoleDefault.COACH,
					ESFKeys.ESFUserRoleDefault.COACH, descriptionMap, titleMap,
					ESFKeys.ESFUserRoleType.REGULAR, StringPool.BLANK, false,
					false, false, false, 0, esfEntityState);
			}
			 if (esfUserRolesDoctor.size() == 0) {
				Map<Locale, String> descriptionMap =
					new HashMap<Locale, String>();
				descriptionMap.put(
					LocaleUtil.getDefault(), ESFKeys.ESFUserRoleDefault.DOCTOR);

				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(
					LocaleUtil.getDefault(), ESFKeys.ESFUserRoleDefault.DOCTOR);

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

				ESFUserRoleLocalServiceUtil.addESFUserRole(
					user.getUserId(), globalGroupId, company.getCompanyId(),
					ESFKeys.ESFUserRoleDefault.DOCTOR,
					ESFKeys.ESFUserRoleDefault.DOCTOR, descriptionMap,
					titleMap, ESFKeys.ESFUserRoleType.REGULAR,
					StringPool.BLANK, false, false, false, false, 0,
					esfEntityState);
			}
			 if (esfUserRolesFitavManager.size() == 0) {
				Map<Locale, String> descriptionMap =
					new HashMap<Locale, String>();
				descriptionMap.put(
					LocaleUtil.getDefault(),
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR);

				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(
					LocaleUtil.getDefault(),
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR);

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);

				ESFUserRoleLocalServiceUtil.addESFUserRole(
					user.getUserId(), globalGroupId, company.getCompanyId(),
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
					ESFKeys.ESFUserRoleDefault.FITAVMANGAR, descriptionMap,
					titleMap, ESFKeys.ESFUserRoleType.REGULAR,
					StringPool.BLANK, false, false, false, false, 0,
					esfEntityState);
			}
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
