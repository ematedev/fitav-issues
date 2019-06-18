create index IX_6D2E96A8 on ESFAddress (groupId);
create index IX_F187383D on ESFAddress (longitude, latitude);
create index IX_70C9B332 on ESFAddress (uuid_);
create unique index IX_144D39B8 on ESFAddress (uuid_, groupId);

create index IX_37C1C6E5 on ESFAnnualConiReport (assId, year);

create index IX_27FDCB09 on ESFAnnualFreeCard (code_);

create index IX_5ED26A4F on ESFCane (code_);
create index IX_FCF8E21E on ESFCane (esfGunKindId);
create index IX_C2EDBE03 on ESFCane (esfOrganizationId);
create index IX_B0D5039B on ESFCane (esfUserId);
create index IX_2185A9C1 on ESFCane (uuid_);

create index IX_F1C920B5 on ESFCard (codeAlfa);
create index IX_BE1BC434 on ESFCard (code_);
create index IX_652E6868 on ESFCard (esfOrganizationId);
create index IX_3664E300 on ESFCard (esfUserId);
create index IX_28C55C56 on ESFCard (oldCode);
create index IX_80CF03A6 on ESFCard (uuid_);
create index IX_276C5CC2 on ESFCard (uuid_, companyId);
create unique index IX_DE892BC4 on ESFCard (uuid_, groupId);

create index IX_25A7A8C4 on ESFCatridge (esfGunTypeId);
create index IX_8A980D9B on ESFCatridge (esfUserId);
create index IX_9A5DB3C1 on ESFCatridge (uuid_);

create index IX_799F0FA4 on ESFCity (idCountry, idRegion, idProvince);
create index IX_872902E8 on ESFCity (name);

create index IX_A3F45DD4 on ESFCodeOrg (className, code_);
create index IX_421974CF on ESFCodeOrg (uuid_);

create index IX_A389EE66 on ESFConfiguration (groupId);
create index IX_38B1C198 on ESFConfiguration (key_);

create index IX_580728C0 on ESFDeparture (code_);
create index IX_1C46A5DE on ESFDeparture (esfMatchId);
create index IX_A9ED1C50 on ESFDeparture (esfMatchId, code_, leaveDate, leaveHour, companyName, departureFrom);
create index IX_45D9F570 on ESFDeparture (esfMatchId, esfUserId);

create index IX_3591F322 on ESFDescription (description);
create index IX_BC099BBA on ESFDescription (isNational);
create index IX_D87ED82A on ESFDescription (uuid_);

create index IX_50A20689 on ESFDocument (code_);
create index IX_39A403FF on ESFDocument (esfDocumentTypeId);
create index IX_782F548A on ESFDocument (esfPublicAuthorityId);
create index IX_BCA7F2D5 on ESFDocument (esfUserId);
create index IX_6613DE06 on ESFDocument (esfUserId, expirationDate);
create index IX_E3752272 on ESFDocument (type_, esfUserId);

create index IX_AB9E7157 on ESFEntityState (className);
create index IX_F05EF46C on ESFEntityState (className, classPK);
create index IX_8ECDDCD4 on ESFEntityState (className, classPK, esfStateId);
create index IX_CCFA513F on ESFEntityState (className, esfStateId);

create index IX_D70439E1 on ESFFederalRole (code_);
create index IX_C65F1040 on ESFFederalRole (name);
create index IX_99B77953 on ESFFederalRole (uuid_);
create index IX_512588F5 on ESFFederalRole (uuid_, companyId);
create unique index IX_F0F5C8B7 on ESFFederalRole (uuid_, groupId);

create index IX_9FD3AA5F on ESFFederalRoleESFSpecific (esfFederalRoleId);
create index IX_E4A2A4C0 on ESFFederalRoleESFSpecific (esfSpecificId);
create index IX_ED05807F on ESFFederalRoleESFSpecific (uuid_);

create index IX_EE5ECFE2 on ESFField (groupId);
create index IX_CA197F87 on ESFField (name);
create index IX_187E9C69 on ESFField (ownerOrganizationId);
create index IX_D4AF2EC on ESFField (uuid_);
create index IX_840845BC on ESFField (uuid_, companyId);
create unique index IX_891F0B3E on ESFField (uuid_, groupId);

create index IX_37EEC6BA on ESFFieldESFElectronic (brandId);
create index IX_8198E8E3 on ESFFieldESFElectronic (electronicId);
create index IX_B2452AAD on ESFFieldESFElectronic (fieldId);
create index IX_296C8DD0 on ESFFieldESFElectronic (fieldId, brandId, electronicId);

create index IX_C0B88EF on ESFFieldESFSportType (esfFieldId);
create index IX_2CB4AC3 on ESFFieldESFSportType (esfSportTypeId);

create index IX_F4D9364A on ESFFlight (esfMatchId);
create index IX_E9FF2984 on ESFFlight (esfMatchId, esfUserId);
create index IX_1B25AED2 on ESFFlight (esfMatchId, flightCode, leaveDate, leaveHour, companyName, departureAirport);
create index IX_7715A65F on ESFFlight (flightCode);

create index IX_6A49A37C on ESFForniture (code_);
create index IX_3225DAE6 on ESFForniture (description);
create index IX_2890D435 on ESFForniture (esfFornitureId, groupId);
create index IX_E954C764 on ESFForniture (groupId);
create index IX_C88269C1 on ESFForniture (insertDate);
create index IX_70488745 on ESFForniture (name);
create index IX_9D7FAB5E on ESFForniture (numberFornitures);
create index IX_FF4D230F on ESFForniture (type_);
create index IX_2CFCE2EE on ESFForniture (uuid_);
create index IX_F623A07A on ESFForniture (uuid_, companyId);
create unique index IX_432DFD7C on ESFForniture (uuid_, groupId);

create index IX_D92F568E on ESFFornitureRel (assignmentDate);
create index IX_3DFFCE6F on ESFFornitureRel (className, classPK);
create index IX_1515923C on ESFFornitureRel (esfToolId);

create index IX_444D984C on ESFFornitureType (description);
create index IX_9A0F27CA on ESFFornitureType (groupId);
create index IX_F18024D4 on ESFFornitureType (uuid_);
create index IX_565852D4 on ESFFornitureType (uuid_, companyId);
create unique index IX_1BF7E56 on ESFFornitureType (uuid_, groupId);

create index IX_CD192FF4 on ESFGun (code_);
create index IX_4F9C68D9 on ESFGun (esfGunKindId);
create index IX_86A83428 on ESFGun (esfOrganizationId);
create index IX_6D466EC0 on ESFGun (esfUserId);
create index IX_8FCC6F66 on ESFGun (uuid_);
create index IX_CDAA1902 on ESFGun (uuid_, companyId);
create unique index IX_4588F804 on ESFGun (uuid_, groupId);

create index IX_4668C8D on ESFGunKind (esfGunKindId);
create index IX_FD2C9D33 on ESFGunKind (esfGunTypeId);
create index IX_A94CA381 on ESFGunKind (name);
create index IX_147C4E32 on ESFGunKind (uuid_);
create index IX_49342B6 on ESFGunKind (uuid_, companyId);
create unique index IX_F058FEB8 on ESFGunKind (uuid_, groupId);

create index IX_380AE4FB on ESFGunType (isCatridgeProductor);
create index IX_B9ADF127 on ESFGunType (name);
create index IX_1044B54C on ESFGunType (uuid_);
create index IX_9D5F475C on ESFGunType (uuid_, companyId);
create unique index IX_1189F4DE on ESFGunType (uuid_, groupId);

create index IX_274F5087 on ESFHistoricalAssociation (organizationId);

create index IX_E0024C5F on ESFLentField (esfFieldId, esfEntityStateId);

create unique index IX_C142F0F on ESFMatch (code_);
create index IX_36D02C39 on ESFMatch (description);
create index IX_99B28E49 on ESFMatch (esfMatchTypeId);
create index IX_3013E9F1 on ESFMatch (eventType);
create index IX_6DA4124A on ESFMatch (isChangeCategoryMatch);
create index IX_C1A2041 on ESFMatch (startDate, esfMatchTypeId, esfAssociationId, description, isNational);
create index IX_DD551185 on ESFMatch (startDate, isNational, code_);
create index IX_9C1A31FD on ESFMatch (userId, isNational);
create index IX_C4756806 on ESFMatch (userId, isNational, esfAssociationId, startDate, description, esfSportTypeId);
create index IX_CEC76E81 on ESFMatch (uuid_);
create index IX_11E62B07 on ESFMatch (uuid_, companyId);
create unique index IX_2B3BC749 on ESFMatch (uuid_, groupId);

create index IX_BFFCE0AC on ESFMatchResult (esfMatchId);
create index IX_E6D51096 on ESFMatchResult (esfPartecipantId);
create index IX_9B666532 on ESFMatchResult (esfPartecipantId, esfMatchId);

create unique index IX_8A716F75 on ESFMatchType (code_);
create index IX_5DF9081F on ESFMatchType (description);
create index IX_D61D731D on ESFMatchType (isNational);
create index IX_D46AD82C on ESFMatchType (name);

create index IX_943E6DA9 on ESFNational (endDate);
create index IX_26C7E6CE on ESFNational (endDate, esfSportTypeId);
create index IX_2EEDF0C5 on ESFNational (endDate, esfUserId);
create index IX_8B9F8ACE on ESFNational (startDate, endDate, esfSportTypeId);
create index IX_3586AB44 on ESFNational (uuid_);
create index IX_CCDA6664 on ESFNational (uuid_, companyId);
create unique index IX_35D135E6 on ESFNational (uuid_, groupId);

create index IX_1ED69CD4 on ESFNationalDelegation (esfMatchId);
create index IX_D856F934 on ESFNationalDelegation (esfMatchId, esfPartecipantTypeId);
create index IX_E53246ED on ESFNationalDelegation (esfMatchId, esfSportTypeId, esfShooterQualificationId);
create index IX_88DD8747 on ESFNationalDelegation (esfMatchId, esfUserId, esfSportTypeId, esfShooterQualificationId);
create index IX_99E6B19 on ESFNationalDelegation (esfSportTypeId, esfMatchId, esfPartecipantTypeId);
create index IX_58914474 on ESFNationalDelegation (esfTournamentId);
create index IX_C49A721F on ESFNationalDelegation (esfTournamentId, className);
create index IX_C4354A4 on ESFNationalDelegation (esfTournamentId, className, classPK);
create index IX_6D73D6 on ESFNationalDelegation (esfUserId);
create index IX_5D43E872 on ESFNationalDelegation (esfUserId, esfMatchId);
create index IX_29869A52 on ESFNationalDelegation (esfUserId, esfMatchId, esfPartecipantTypeId);
create index IX_185C2B6 on ESFNationalDelegation (esfUserId, esfPartecipantTypeId);
create index IX_3AA363DF on ESFNationalDelegation (esfUserId, leaveDate);
create index IX_C23D6F7C on ESFNationalDelegation (uuid_);
create index IX_3DD4F2C on ESFNationalDelegation (uuid_, companyId);
create unique index IX_4087B0AE on ESFNationalDelegation (uuid_, groupId);

create index IX_BA1CFF1A on ESFNationalMatchResult (esfMatchId);
create index IX_A25F763F on ESFNationalMatchResult (esfMatchId, esfSportTypeId);
create index IX_5664BEB4 on ESFNationalMatchResult (esfMatchId, esfUserId);
create index IX_58EE24FF on ESFNationalMatchResult (esfMatchId, esfUserQualification, esfSportTypeId);
create index IX_912AEBD7 on ESFNationalMatchResult (esfMatchId, externalShooter);
create index IX_E57E48FC on ESFNationalMatchResult (esfMatchId, externalShooter, esfSportTypeId);
create index IX_814EB0D0 on ESFNationalMatchResult (esfUserId);

create index IX_9EE76E3 on ESFOrganization (category);
create index IX_5A6A0171 on ESFOrganization (code_);
create index IX_7D378259 on ESFOrganization (code_, groupId);
create index IX_8AF586B0 on ESFOrganization (fiscalCode);
create index IX_FEE473FA on ESFOrganization (fiscalCode, groupId);
create index IX_52D57C19 on ESFOrganization (groupId);
create index IX_C6CEDD2A on ESFOrganization (isMultiSport);
create index IX_DC6E1B3C on ESFOrganization (legalForm);
create index IX_EF6D8104 on ESFOrganization (type_);
create index IX_1D1D40E3 on ESFOrganization (uuid_);
create unique index IX_EF6F8327 on ESFOrganization (uuid_, groupId);
create index IX_EDEF9608 on ESFOrganization (vat);
create index IX_9C0A27A2 on ESFOrganization (vat, groupId);

create index IX_51888EAA on ESFOrganizationUnitservice (esfOrganizationId);
create index IX_3BCF0354 on ESFOrganizationUnitservice (esfUnitserviceId);
create index IX_44C84ADE on ESFOrganizationUnitservice (groupId);
create index IX_248EFCE8 on ESFOrganizationUnitservice (uuid_);
create index IX_CBF36640 on ESFOrganizationUnitservice (uuid_, companyId);
create unique index IX_6BA07CC2 on ESFOrganizationUnitservice (uuid_, groupId);

create index IX_41D299D9 on ESFPartecipant (esfMatchId);
create index IX_347F3479 on ESFPartecipant (esfMatchId, esfPartecipantTypeId);
create index IX_285D11ED on ESFPartecipant (esfUserId, esfMatchId, esfPartecipantTypeId);
create index IX_A33212F7 on ESFPartecipant (userId);
create index IX_84BEA357 on ESFPartecipant (uuid_);
create index IX_4FA6B471 on ESFPartecipant (uuid_, companyId);
create unique index IX_5B83A333 on ESFPartecipant (uuid_, groupId);

create index IX_87429A21 on ESFPartecipantInfo (firstName, lastName, protocol);

create index IX_182988BD on ESFPartecipantType (uuid_);

create index IX_1021F1BC on ESFProvince (idCountry, name);
create index IX_CD7C5E8D on ESFProvince (idProvince);
create index IX_B354063A on ESFProvince (idRegion, idCountry);

create index IX_63532879 on ESFRegion (idCountry);

create index IX_38BBCB82 on ESFRenewal (organizationId, isTotal);
create index IX_B71F280F on ESFRenewal (organizationId, paymentReceived);
create index IX_C3086613 on ESFRenewal (organizationId, reportingYear);
create index IX_219DA4D6 on ESFRenewal (paymentReason, isTotal);
create index IX_DDBCEE36 on ESFRenewal (paymentReason, organizationId);
create index IX_6B89E771 on ESFRenewal (paymentReceived);
create index IX_1ADFDE99 on ESFRenewal (renewalFatherId);
create index IX_A8297500 on ESFRenewal (userId);

create index IX_CE0B0737 on ESFResult (esfMatchId);
create index IX_42A62564 on ESFResult (esfMatchId, esfMatchTypeId, shooterQualification);
create index IX_652D60ED on ESFResult (esfMatchId, esfUserId, esfMatchTypeId);
create index IX_2D3A9E3B on ESFResult (esfMatchId, esfUserId, esfMatchTypeId, resultClassTeam);
create index IX_37A0B113 on ESFResult (esfUserId);

create index IX_F4AD789 on ESFShooterAffiliationChrono (affiliationDate);
create index IX_4C0C14FA on ESFShooterAffiliationChrono (card, year);
create index IX_C59E4B7A on ESFShooterAffiliationChrono (esfuserId, year);

create index IX_ECD25A4A on ESFShooterCategory (code_);
create index IX_AF8599BC on ESFShooterCategory (uuid_);
create index IX_8B203CEC on ESFShooterCategory (uuid_, companyId);
create unique index IX_E32B0E6E on ESFShooterCategory (uuid_, groupId);

create index IX_9B30B121 on ESFShooterCategoryESFMatch (esfMatchId);
create index IX_F0B11F0F on ESFShooterCategoryESFMatch (uuid_);
create index IX_3A9835B9 on ESFShooterCategoryESFMatch (uuid_, companyId);
create unique index IX_1DF4D67B on ESFShooterCategoryESFMatch (uuid_, groupId);

create index IX_CE28E057 on ESFShooterCategoryESFTournament (esfTournamentId);
create index IX_D6E8FB1F on ESFShooterCategoryESFTournament (uuid_);
create unique index IX_A76B8C6B on ESFShooterCategoryESFTournament (uuid_, groupId);

create index IX_1EF67C61 on ESFShooterQualification (code_);
create index IX_E1A9BBD3 on ESFShooterQualification (uuid_);
create index IX_A368B675 on ESFShooterQualification (uuid_, companyId);
create unique index IX_8D265637 on ESFShooterQualification (uuid_, groupId);

create index IX_C340EC6A on ESFShooterQualificationESFMatch (esfMatchId);
create index IX_27B93A26 on ESFShooterQualificationESFMatch (uuid_);
create index IX_3BF71642 on ESFShooterQualificationESFMatch (uuid_, companyId);
create unique index IX_1744544 on ESFShooterQualificationESFMatch (uuid_, groupId);

create index IX_4CA25460 on ESFShooterQualificationESFTournament (esfTournamentId);
create index IX_FEF93668 on ESFShooterQualificationESFTournament (uuid_);
create unique index IX_275EF342 on ESFShooterQualificationESFTournament (uuid_, groupId);

create index IX_C73B5861 on ESFShootingDirector (esfUserId);
create index IX_D02BBF2F on ESFShootingDirector (esfUserId, shootingDirectorQualificationId, sportTypeId);
create index IX_4887302C on ESFShootingDirector (provinceId);
create index IX_38F9B1B0 on ESFShootingDirector (regionId);
create index IX_369CAFDE on ESFShootingDirector (shootingDirectorQualificationId);
create index IX_257E9E0C on ESFShootingDirector (sportTypeId);

create index IX_EA941852 on ESFSpecific (code_);
create index IX_AD4757C4 on ESFSpecific (uuid_);
create index IX_3108E9E4 on ESFSpecific (uuid_, companyId);
create unique index IX_F2CA9966 on ESFSpecific (uuid_, groupId);

create index IX_52381626 on ESFSportType (code_);
create index IX_8F71378E on ESFSportType (groupId);
create index IX_32859373 on ESFSportType (isOlimpic);
create index IX_98CC175B on ESFSportType (name);
create index IX_C11BB5C2 on ESFSportType (national);
create index IX_500F768D on ESFSportType (national, isOlimpic);
create index IX_14EB5598 on ESFSportType (uuid_);
create index IX_A511BF90 on ESFSportType (uuid_, companyId);
create unique index IX_5424EA12 on ESFSportType (uuid_, groupId);

create index IX_1E601C1E on ESFState (name);

create index IX_81AAA5C2 on ESFStateAssEntity (className);
create index IX_8716A199 on ESFStateAssEntity (esfStateId);
create index IX_CD5037E3 on ESFStateAssEntity (uuid_);

create index IX_9F16B53 on ESFSuspensiveShootingDirector (esfEndData, esfUserId);
create index IX_FC5768B4 on ESFSuspensiveShootingDirector (esfUserId);

create index IX_D0A97FB1 on ESFTeam (esfTournamentId);

create index IX_E7F482ED on ESFTournament (uuid_);
create index IX_8A765B1B on ESFTournament (uuid_, companyId);
create unique index IX_E080EC5D on ESFTournament (uuid_, groupId);

create index IX_1891E5CD on ESFUnitservice (description);
create index IX_3DD05DCB on ESFUnitservice (groupId);
create index IX_AC68E715 on ESFUnitservice (uuid_);
create index IX_CDDD4DF3 on ESFUnitservice (uuid_, companyId);
create unique index IX_BA36B535 on ESFUnitservice (uuid_, groupId);

create index IX_D4E2AD55 on ESFUser (codeUser);
create index IX_DA36F5D9 on ESFUser (code_);
create index IX_8894BA25 on ESFUser (esfUserId);
create index IX_1A991348 on ESFUser (fiscalCode);
create index IX_9CEA354B on ESFUser (uuid_);

create index IX_307DECFA on ESFUserCategory (esfCategoryId);
create index IX_1780DA3F on ESFUserCategory (esfUserId, esfCategoryId, esfSportTypeId);

create index IX_773E3305 on ESFUserESFFederalRole (active_);
create index IX_2C40958E on ESFUserESFFederalRole (esfFederalRoleId);
create index IX_61BA070A on ESFUserESFFederalRole (esfUserId);
create index IX_839BB33F on ESFUserESFFederalRole (esfUserId, active_);
create index IX_C9B6B694 on ESFUserESFFederalRole (esfUserId, esfFederalRoleId);
create index IX_3B0ADEF5 on ESFUserESFFederalRole (esfUserId, esfFederalRoleId, active_);

create index IX_C62ECE7A on ESFUserESFUserRole (esfOrganizationId);
create index IX_1E3E216A on ESFUserESFUserRole (esfOrganizationId, esfUserRoleId);
create index IX_50AD7B12 on ESFUserESFUserRole (esfUserId);
create index IX_5A0BFA28 on ESFUserESFUserRole (esfUserRoleId);
create index IX_AE91EEE6 on ESFUserESFUserRole (esfUserRoleId, esfUserId);
create index IX_25EB83F3 on ESFUserESFUserRole (esfUserRoleId, esfUserId, endDate);
create index IX_3C66D4D0 on ESFUserESFUserRole (esfUserRoleId, esfUserId, esfOrganizationId);

create index IX_5A6DB1AB on ESFUserRole (groupId);
create index IX_2DA0DE14 on ESFUserRole (isBDO);
create index IX_2E2E08EF on ESFUserRole (isLEA);
create index IX_8059F316 on ESFUserRole (type_);
create index IX_AE09B2F5 on ESFUserRole (uuid_);
create index IX_21D05613 on ESFUserRole (uuid_, companyId);
create unique index IX_898D4555 on ESFUserRole (uuid_, groupId);

create index IX_EC911CAF on ESFUserRoleESFFederalRole (active_);
create index IX_A3E8EB24 on ESFUserRoleESFFederalRole (esfFederalRoleId);
create index IX_CDF92E34 on ESFUserRoleESFFederalRole (esfUserId);

create index IX_420D6849 on ESFgunUser (code_);
create index IX_96059AB0 on ESFgunUser (esfGunId);
create index IX_FF5C6925 on ESFgunUser (esfGunId, type_);
create index IX_620C7495 on ESFgunUser (esfUserId);
create index IX_F709140D on ESFgunUser (esfUserId, code_);
create index IX_8C0C93A0 on ESFgunUser (esfUserId, type_);
create index IX_10328453 on ESFgunUser (idUser);
create index IX_7CE3728F on ESFgunUser (idUser, code_);
create index IX_D710E7DC on ESFgunUser (type_);

create index IX_AA078FA7 on VW_ESFIncarichiFederali (active_, esfUserId);

create index IX_ED8BB4AF on VW_ESFListaIncarichi (esfOrganizationId);

create index IX_19A88904 on esforganization (type_);

create index IX_7ED85A60 on vw_datidirettoretiro (esfShootingDirectorId);

create index IX_73E8B564 on vw_tiratoritesserati (UserId);