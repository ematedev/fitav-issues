/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.ethica.esf.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFAirportLocalServiceUtil;
import it.ethica.esf.service.ESFAnnualConiReportLocalServiceUtil;
import it.ethica.esf.service.ESFAnnualFreeCardLocalServiceUtil;
import it.ethica.esf.service.ESFBrandLocalServiceUtil;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFCodeOrgLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFCountryLocalServiceUtil;
import it.ethica.esf.service.ESFDepartureLocalServiceUtil;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil;
import it.ethica.esf.service.ESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFEventTypeLocalServiceUtil;
import it.ethica.esf.service.ESFFederalRoleESFSpecificLocalServiceUtil;
import it.ethica.esf.service.ESFFederalRoleESFSpecificServiceUtil;
import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFFederalRoleServiceUtil;
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFFieldESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureRelLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureUserLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil;
import it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFJobLocalServiceUtil;
import it.ethica.esf.service.ESFJunioresLocalServiceUtil;
import it.ethica.esf.service.ESFLentFieldLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFProvinceLocalServiceUtil;
import it.ethica.esf.service.ESFPublicAuthorityLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoFilesLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoSottotipiRadunoLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoSottotipoLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoStaffLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoTipoLocalServiceUtil;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.ESFRenewalLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;
import it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFShooterCategoryESFTournamentLocalServiceUtil;
import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationESFTournamentLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFSpecificLocalServiceUtil;
import it.ethica.esf.service.ESFSpecificServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFStateAssEntityLocalServiceUtil;
import it.ethica.esf.service.ESFStateLocalServiceUtil;
import it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil;
import it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFTeamLocalServiceUtil;
import it.ethica.esf.service.ESFTournamentLocalServiceUtil;
import it.ethica.esf.service.ESFTransitionLocalServiceUtil;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.EsfRadunoShootersLocalServiceUtil;
import it.ethica.esf.service.VW_AzzurriLocalServiceUtil;
import it.ethica.esf.service.VW_DatiDrettoreTiroLocalServiceUtil;
import it.ethica.esf.service.VW_ESFIncarichiFederaliLocalServiceUtil;
import it.ethica.esf.service.VW_ESFListaIncarichiLocalServiceUtil;
import it.ethica.esf.service.VW_ShootersLocalServiceUtil;
import it.ethica.esf.service.VW_StaffLocalServiceUtil;

/**
 * @author Ethica
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ESFAddressLocalServiceUtil.clearService();

			ESFAirportLocalServiceUtil.clearService();

			ESFAnnualConiReportLocalServiceUtil.clearService();

			ESFAnnualFreeCardLocalServiceUtil.clearService();

			ESFBrandLocalServiceUtil.clearService();

			ESFCaneLocalServiceUtil.clearService();

			ESFCardLocalServiceUtil.clearService();

			ESFCategoryLocalServiceUtil.clearService();

			ESFCatridgeLocalServiceUtil.clearService();

			ESFCityLocalServiceUtil.clearService();

			ESFCodeOrgLocalServiceUtil.clearService();

			ESFConfigurationLocalServiceUtil.clearService();

			ESFCountryLocalServiceUtil.clearService();

			ESFDepartureLocalServiceUtil.clearService();

			ESFDescriptionLocalServiceUtil.clearService();

			ESFDocumentLocalServiceUtil.clearService();

			ESFDocumentTypeLocalServiceUtil.clearService();

			ESFElectronicLocalServiceUtil.clearService();

			ESFEntityStateLocalServiceUtil.clearService();

			ESFEventTypeLocalServiceUtil.clearService();

			ESFFederalRoleLocalServiceUtil.clearService();

			ESFFederalRoleServiceUtil.clearService();
			ESFFederalRoleESFSpecificLocalServiceUtil.clearService();

			ESFFederalRoleESFSpecificServiceUtil.clearService();
			ESFFieldLocalServiceUtil.clearService();

			ESFFieldESFElectronicLocalServiceUtil.clearService();

			ESFFieldESFSportTypeLocalServiceUtil.clearService();

			ESFFornitureLocalServiceUtil.clearService();

			ESFFornitureRelLocalServiceUtil.clearService();

			ESFFornitureTypeLocalServiceUtil.clearService();

			ESFFornitureUserLocalServiceUtil.clearService();

			ESFGunLocalServiceUtil.clearService();

			ESFGunKindLocalServiceUtil.clearService();

			ESFGunTypeLocalServiceUtil.clearService();

			ESFgunUserLocalServiceUtil.clearService();

			ESFHistoricalAssociationLocalServiceUtil.clearService();

			ESFInstructsShootingDirectorLocalServiceUtil.clearService();

			ESFJobLocalServiceUtil.clearService();

			ESFJunioresLocalServiceUtil.clearService();

			ESFLentFieldLocalServiceUtil.clearService();

			ESFMatchLocalServiceUtil.clearService();

			ESFMatchResultLocalServiceUtil.clearService();

			ESFMatchTypeLocalServiceUtil.clearService();

			ESFNationalLocalServiceUtil.clearService();

			ESFNationalDelegationLocalServiceUtil.clearService();

			ESFNationalMatchResultLocalServiceUtil.clearService();

			ESFOrganizationLocalServiceUtil.clearService();

			ESFOrganizationUnitserviceLocalServiceUtil.clearService();

			ESFPartecipantLocalServiceUtil.clearService();

			ESFPartecipantInfoLocalServiceUtil.clearService();

			ESFPartecipantTypeLocalServiceUtil.clearService();

			ESFPhoneLocalServiceUtil.clearService();

			ESFProvinceLocalServiceUtil.clearService();

			ESFPublicAuthorityLocalServiceUtil.clearService();

			ESFRadunoLocalServiceUtil.clearService();

			ESFRadunoAzzurriLocalServiceUtil.clearService();

			ESFRadunoFilesLocalServiceUtil.clearService();

			EsfRadunoShootersLocalServiceUtil.clearService();

			ESFRadunoSottotipiRadunoLocalServiceUtil.clearService();

			ESFRadunoSottotipoLocalServiceUtil.clearService();

			ESFRadunoStaffLocalServiceUtil.clearService();

			ESFRadunoTipoLocalServiceUtil.clearService();

			ESFRegionLocalServiceUtil.clearService();

			ESFRenewalLocalServiceUtil.clearService();

			ESFResultLocalServiceUtil.clearService();

			ESFShooterAffiliationChronoLocalServiceUtil.clearService();

			ESFShooterCategoryLocalServiceUtil.clearService();

			ESFShooterCategoryESFMatchLocalServiceUtil.clearService();

			ESFShooterCategoryESFTournamentLocalServiceUtil.clearService();

			ESFShooterQualificationLocalServiceUtil.clearService();

			ESFShooterQualificationESFMatchLocalServiceUtil.clearService();

			ESFShooterQualificationESFTournamentLocalServiceUtil.clearService();

			ESFShootingDirectorLocalServiceUtil.clearService();

			ESFShootingDirectorQualificationLocalServiceUtil.clearService();

			ESFSpecificLocalServiceUtil.clearService();

			ESFSpecificServiceUtil.clearService();
			ESFSportTypeLocalServiceUtil.clearService();

			ESFStateLocalServiceUtil.clearService();

			ESFStateAssEntityLocalServiceUtil.clearService();

			ESFSuspensiveCodeLocalServiceUtil.clearService();

			ESFSuspensiveShootingDirectorLocalServiceUtil.clearService();

			ESFTeamLocalServiceUtil.clearService();

			ESFTournamentLocalServiceUtil.clearService();

			ESFTransitionLocalServiceUtil.clearService();

			ESFUnitserviceLocalServiceUtil.clearService();

			ESFUserLocalServiceUtil.clearService();

			ESFUserServiceUtil.clearService();
			ESFUserCategoryLocalServiceUtil.clearService();

			ESFUserESFFederalRoleLocalServiceUtil.clearService();

			ESFUserESFUserRoleLocalServiceUtil.clearService();

			ESFUserRoleLocalServiceUtil.clearService();

			VW_AzzurriLocalServiceUtil.clearService();

			VW_DatiDrettoreTiroLocalServiceUtil.clearService();

			VW_ESFIncarichiFederaliLocalServiceUtil.clearService();

			VW_ESFListaIncarichiLocalServiceUtil.clearService();

			VW_ShootersLocalServiceUtil.clearService();

			VW_StaffLocalServiceUtil.clearService();
		}
	}
}