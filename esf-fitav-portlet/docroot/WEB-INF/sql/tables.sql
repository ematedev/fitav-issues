create table ESFAddress (
	uuid_ VARCHAR(75) null,
	esfAddressId LONG not null primary key,
	longitude DOUBLE,
	latitude DOUBLE,
	esfCountryId VARCHAR(75) null,
	esfRegionId VARCHAR(75) null,
	esfProvinceId VARCHAR(75) null,
	esfCityId LONG,
	groupId LONG,
	type_ VARCHAR(75) null,
	isNotNational BOOLEAN,
	listTypeId INTEGER
);

create table ESFAirport (
	esfAirportId LONG not null primary key,
	name VARCHAR(75) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null
);

create table ESFAnnualConiReport (
	annualConiReportId LONG not null primary key,
	assId LONG,
	year INTEGER
);

create table ESFAnnualFreeCard (
	annualFreeCardId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	assId LONG,
	code_ VARCHAR(75) null,
	cardCode VARCHAR(75) null,
	assCode VARCHAR(75) null,
	assName VARCHAR(75) null
);

create table ESFBrand (
	brandId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table ESFCane (
	uuid_ VARCHAR(75) null,
	esfCaneId LONG not null primary key,
	esfUserId LONG,
	code_ VARCHAR(75) null,
	esfGunKindId LONG,
	esfOrganizationId LONG,
	caneCaliber LONG,
	isFavoriteGun BOOLEAN,
	typeId INTEGER,
	measures VARCHAR(75) null,
	shooterId LONG,
	esfGunTypeId LONG
);

create table ESFCard (
	uuid_ VARCHAR(75) null,
	esfCardId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	codeAlfa VARCHAR(75) null,
	codeNum LONG,
	esfUserId LONG,
	esfOrganizationId LONG,
	code_ VARCHAR(75) null,
	oldCode VARCHAR(75) null
);

create table ESFCategory (
	esfCategoryId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table ESFCatridge (
	uuid_ VARCHAR(75) null,
	esfCatridgeId LONG not null primary key,
	esfUserId LONG,
	esfGunTypeId LONG,
	catridgeModel VARCHAR(75) null,
	catridgeCaliber LONG,
	note VARCHAR(75) null
);

create table ESFCity (
	idCity LONG not null,
	idProvince VARCHAR(75) not null,
	idRegion VARCHAR(75) not null,
	idCountry VARCHAR(75) not null,
	zip LONG,
	name VARCHAR(75) null,
	latitude DOUBLE,
	longitude DOUBLE,
	altitude DOUBLE,
	website VARCHAR(75) null,
	primary key (idCity, idProvince, idRegion, idCountry)
);

create table ESFCodeOrg (
	esfCodeOrgId LONG not null primary key,
	className VARCHAR(75) null,
	code_ VARCHAR(75) null,
	sequence LONG
);

create table ESFConfiguration (
	esfConfigurationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	key_ VARCHAR(75) null,
	value VARCHAR(75) null
);

create table ESFCountry (
	idCountry VARCHAR(75) not null primary key,
	name VARCHAR(75) null
);

create table ESFDeparture (
	esfDepartureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	leaveDate DATE null,
	leaveHour VARCHAR(75) null,
	arriveDate DATE null,
	arriveHour VARCHAR(75) null,
	code_ VARCHAR(75) null,
	companyName VARCHAR(75) null,
	departureFrom VARCHAR(75) null,
	arrivalTo VARCHAR(75) null,
	esfMatchId LONG,
	esfUserId LONG,
	isReturn BOOLEAN,
	meetingPlace VARCHAR(75) null,
	typeTravel VARCHAR(75) null,
	stopoverId VARCHAR(75) null
);

create table ESFDescription (
	esfDescriptionId LONG not null primary key,
	isNational BOOLEAN,
	name VARCHAR(75) null
);

create table ESFDocument (
	esfDocumentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	releasedBy VARCHAR(75) null,
	releaseDate DATE null,
	expirationDate DATE null,
	esfUserId LONG,
	type_ VARCHAR(75) null,
	esfDocumentTypeId LONG,
	esfPublicAuthorityId LONG,
	path_ VARCHAR(255) null
);

create table ESFDocumentType (
	esfDocumentTypeId LONG not null primary key IDENTITY,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	expirationMonthsNotice INTEGER
);

create table ESFElectronic (
	electronicId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table ESFEntityState (
	esfEntityStateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	className VARCHAR(75) null,
	classPK LONG,
	startDate DATE null,
	endDate DATE null,
	esfStateId LONG
);

create table ESFEventType (
	esfEventTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	macrocategory VARCHAR(75) null,
	eventType VARCHAR(75) null
);

create table ESFFederalRole (
	uuid_ VARCHAR(75) null,
	esfFederalRoleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	regional BOOLEAN,
	provincial BOOLEAN
);

create table ESFFederalRoleESFSpecific (
	uuid_ VARCHAR(75) null,
	esfSpecificId LONG not null,
	esfFederalRoleId LONG not null,
	primary key (esfSpecificId, esfFederalRoleId)
);

create table ESFField (
	uuid_ VARCHAR(75) null,
	esfFieldId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	ownerOrganizationId LONG,
	esfAddressId LONG,
	billboard LONG,
	billboardStations BOOLEAN,
	backgroundRampart BOOLEAN,
	backgroundNet BOOLEAN,
	backgroundLeadRecovery BOOLEAN,
	disabledAccess BOOLEAN,
	note VARCHAR(75) null
);

create table ESFFieldESFElectronic (
	id_ LONG not null primary key,
	brandId LONG,
	electronicId LONG,
	fieldId LONG,
	description VARCHAR(75) null
);

create table ESFFieldESFSportType (
	esfFieldId LONG not null,
	esfSportTypeId LONG not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	primary key (esfFieldId, esfSportTypeId)
);

create table ESFFlight (
	esfFlightId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	leaveDate DATE null,
	leaveHour VARCHAR(75) null,
	arriveDate DATE null,
	arriveHour VARCHAR(75) null,
	flightCode VARCHAR(75) null,
	companyName VARCHAR(75) null,
	departureAirport VARCHAR(75) null,
	arrivalAirport VARCHAR(75) null,
	esfMatchId LONG,
	esfUserId LONG
);

create table ESFForniture (
	uuid_ VARCHAR(75) null,
	esfFornitureId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ LONG,
	insertDate DATE null,
	numberFornitures LONG,
	size_ VARCHAR(75) null
);

create table ESFFornitureRel (
	esfToolId LONG not null,
	className VARCHAR(75) not null,
	classPK LONG not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	assignmentDate DATE null,
	primary key (esfToolId, className, classPK)
);

create table ESFFornitureType (
	uuid_ VARCHAR(75) null,
	esfFornitureTypeId LONG not null primary key,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table ESFFornitureUser (
	esfIDForniture LONG,
	esfIdUser LONG,
	esfQuantity LONG,
	esfDateAssign DATE null,
	esfFornitureUserID LONG not null primary key
);

create table ESFGun (
	uuid_ VARCHAR(75) null,
	esfGunId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfUserId LONG,
	code_ VARCHAR(75) null,
	esfGunKindId LONG,
	esfOrganizationId LONG,
	registrationNumber VARCHAR(75) null,
	catridgeCaliber LONG,
	isFavoriteGun BOOLEAN,
	typeId INTEGER,
	measures VARCHAR(75) null,
	note VARCHAR(75) null,
	name VARCHAR(75) null
);

create table ESFGunKind (
	uuid_ VARCHAR(75) null,
	esfGunKindId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(500) null,
	esfGunTypeId LONG
);

create table ESFGunType (
	uuid_ VARCHAR(75) null,
	esfGunTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(500) null,
	isCatridgeProductor BOOLEAN
);

create table ESFHistoricalAssociation (
	idHistoricalAssociation LONG not null primary key,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	dateChange DATE null,
	endDate DATE null,
	organizationId LONG,
	stateId LONG,
	variationId LONG
);

create table ESFInstructsShootingDirector (
	esfInstructsShootingDirectorId LONG not null primary key,
	esfInstructsShootingDirectorCode VARCHAR(75) null,
	esfInstructsShootingDirectorDesc VARCHAR(75) null
);

create table ESFJob (
	esfJobId LONG not null primary key,
	esfName VARCHAR(75) null
);

create table ESFJuniores (
	ESFUserId LONG not null primary key,
	startDate DATE null,
	endDate DATE null
);

create table ESFLentField (
	lentFieldId LONG not null primary key,
	esfEntityStateId LONG,
	esfFieldId LONG,
	realOwnerId LONG,
	actualOwnerId LONG
);

create table ESFMatch (
	uuid_ VARCHAR(75) null,
	esfMatchId LONG not null primary key,
	startDate DATE null,
	startHour VARCHAR(75) null,
	esfSportTypeId LONG,
	esfMatchTypeId LONG,
	isDraft BOOLEAN,
	isTeamMatch BOOLEAN,
	isIndividualMatch BOOLEAN,
	isJuniorMatch BOOLEAN,
	numDisk INTEGER,
	numDiskTeam INTEGER,
	esfAssociationId LONG,
	notes VARCHAR(75) null,
	description LONG,
	endDate DATE null,
	numFields INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	isSingleMatch BOOLEAN,
	site VARCHAR(75) null,
	countryId LONG,
	code_ VARCHAR(75) null,
	isNational BOOLEAN,
	HasPenality BOOLEAN,
	isOlimpicQualificationMatch BOOLEAN,
	eventType VARCHAR(75) null,
	notNationalAssotiation VARCHAR(75) null,
	isChangeCategoryMatch BOOLEAN,
	esfNationalSportTypeId VARCHAR(75) null,
	oldCode VARCHAR(75) null
);

create table ESFMatchResult (
	esfMatchResultId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfMatchId LONG,
	esfPartecipantId LONG,
	cardCode VARCHAR(75) null,
	generalClassPosition INTEGER,
	categoryClassPosition INTEGER,
	categoryName VARCHAR(75) null,
	qualification VARCHAR(75) null,
	first INTEGER,
	second INTEGER,
	third INTEGER,
	fourth INTEGER,
	fifth INTEGER,
	total INTEGER,
	firstPlayOff INTEGER,
	secondPlayOff INTEGER,
	thirdPlayOff INTEGER,
	totalAfterPlayOff INTEGER,
	nextFirstPlayOff INTEGER,
	nextSecondPlayOff INTEGER,
	nextTotalPlayOff INTEGER,
	fiscalCode VARCHAR(75) null
);

create table ESFMatchType (
	esfMatchTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	isCategoryQualification BOOLEAN,
	isNational BOOLEAN,
	code_ VARCHAR(75) null
);

create table ESFNational (
	esfNationalId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfUserId LONG,
	esfSportTypeId LONG,
	startDate DATE null,
	endDate DATE null,
	BDODate DATE null,
	idInternational VARCHAR(75) null,
	isUniversity BOOLEAN,
	isNational BOOLEAN,
	deliberate VARCHAR(75) null,
	deliberateDate DATE null
);

create table ESFNationalDelegation (
	esfUserId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	leaveDate DATE null,
	returnDate DATE null,
	esfMatchId LONG,
	esfSportTypeId LONG,
	esfShooterQualificationId LONG,
	esfGunId1 LONG,
	esfGunId2 LONG,
	esfNationalDelgationId LONG not null primary key,
	esfPartecipantTypeId LONG,
	nominationDate DATE null,
	refusalDate DATE null,
	taskId LONG,
	refusal VARCHAR(75) null
);

create table ESFNationalMatchResult (
	esfNationalMatchResultId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfMatchId LONG,
	esfUserId LONG,
	position INTEGER,
	qualification INTEGER,
	shootOff INTEGER,
	clayPigeonTotal INTEGER,
	finalResult INTEGER,
	shootOffFinal INTEGER,
	externalShooter BOOLEAN,
	externalName VARCHAR(75) null,
	esfSportTypeId LONG,
	userNationality VARCHAR(75) null,
	esfUserQualification LONG
);

create table ESFOrganization (
	uuid_ VARCHAR(75) null,
	esfOrganizationId LONG not null primary key,
	groupId LONG,
	code_ VARCHAR(75) null,
	vat VARCHAR(75) null,
	fiscalCode VARCHAR(75) null,
	ibanCode VARCHAR(75) null,
	isMultiSport BOOLEAN,
	legalForm VARCHAR(75) null,
	category VARCHAR(75) null,
	establishmentDate DATE null,
	closureDate DATE null,
	type_ INTEGER,
	insertDate DATE null,
	coniDate DATE null,
	coniCode VARCHAR(75) null,
	description VARCHAR(255) null,
	isYouthActive BOOLEAN,
	firstAffiliationDate DATE null,
	variations LONG,
	regionCode LONG,
	idFatherAssociation LONG,
	constitutiveAct BOOLEAN,
	registeredStatus BOOLEAN,
	planimetrySportsStand BOOLEAN,
	certificateFITAV BOOLEAN,
	note VARCHAR(75) null,
	isSimplyOrganizzation BOOLEAN,
	webSite VARCHAR(75) null,
	includeConiReport BOOLEAN,
	organizzationCategory VARCHAR(75) null
);

create table ESFOrganizationUnitservice (
	uuid_ VARCHAR(75) null,
	esfOrganizationUnitserviceId LONG not null primary key,
	esfOrganizationId LONG,
	esfUnitserviceId LONG,
	numberUnitservices LONG,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table ESFPartecipant (
	uuid_ VARCHAR(75) null,
	esfPartecipantId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfUserId LONG,
	esfMatchId LONG,
	esfTeamId LONG,
	ct LONG,
	esfPartecipantTypeId LONG,
	result LONG
);

create table ESFPartecipantInfo (
	esfPartecipantInfoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	isPortalUser BOOLEAN,
	esfUserId LONG,
	protocol LONG,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	placeOfBirth VARCHAR(75) null,
	dateOfBirth DATE null,
	residenceCity VARCHAR(75) null,
	province VARCHAR(75) null,
	zip INTEGER,
	address VARCHAR(75) null,
	phonNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	maritialStatus VARCHAR(75) null,
	fiscalCode VARCHAR(75) null,
	passport VARCHAR(75) null,
	releasedBy VARCHAR(75) null,
	passportReleaseDate DATE null,
	passportExpirationDate DATE null,
	europeanCardNumber VARCHAR(75) null,
	europeanCardReleaseDate DATE null,
	europeanCardExpirationDate DATE null,
	gunLicenceNumber VARCHAR(75) null,
	gunLicenceReleaseDate DATE null,
	gunLicenceExpirationDate DATE null,
	firstGunType VARCHAR(75) null,
	firstGunKind VARCHAR(75) null,
	firstGunCaliber DOUBLE,
	firstGunCode VARCHAR(75) null,
	firstGunExtraCanes VARCHAR(75) null,
	secondGunType VARCHAR(75) null,
	secondGunKind VARCHAR(75) null,
	secondGunCaliber DOUBLE,
	secondGunCode VARCHAR(75) null,
	secondGunExtraCanes VARCHAR(75) null,
	gunCartridgeType VARCHAR(75) null,
	gunCartridgeKind VARCHAR(75) null,
	cartridgeCaliber VARCHAR(75) null,
	esfMatchId LONG,
	esfGunTypeIdOne LONG,
	esfGunKindIdOne LONG,
	esfGunTypeIdTwo LONG,
	esfGunKindIdTwo LONG
);

create table ESFPartecipantType (
	esfPartecipantTypeId LONG not null primary key,
	name VARCHAR(75) null
);

create table ESFPhone (
	esfPhoneId LONG not null primary key,
	listTypeId INTEGER
);

create table ESFProvince (
	idProvince VARCHAR(75) not null,
	idRegion VARCHAR(75) not null,
	idCountry VARCHAR(75) not null,
	name VARCHAR(75) null,
	primary key (idProvince, idRegion, idCountry)
);

create table ESFPublicAuthority (
	esfPublicAuthorityId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null
);

create table ESFRaduno (
	id_esf_raduno LONG not null primary key IDENTITY,
	codice VARCHAR(75) null,
	data_inizio DATE null,
	data_fine DATE null,
	tipo_raduno LONG,
	id_sottotipo_raduno LONG,
	note VARCHAR(75) null,
	id_associazione_ospitante LONG,
	altra_sede_ospitante VARCHAR(75) null
);

create table ESFRadunoFiles (
	id_esf_raduno_files LONG not null primary key IDENTITY,
	id_esf_raduno LONG,
	nome VARCHAR(75) null,
	path_ VARCHAR(75) null
);

create table ESFRadunoSottotipiRaduno (
	id_esf_raduno_sottotipi_raduno LONG not null primary key IDENTITY,
	id_esf_raduno LONG,
	id_esf_raduno_sottotipo LONG
);

create table ESFRadunoSottotipo (
	id_esf_raduno_sottotipo LONG not null primary key IDENTITY,
	descrizione VARCHAR(75) null
);

create table ESFRadunoTipo (
	id_esf_raduno_tipo LONG not null primary key IDENTITY,
	descrizione VARCHAR(75) null
);

create table ESFRegion (
	idRegion VARCHAR(75) not null,
	idCountry VARCHAR(75) not null,
	name VARCHAR(75) null,
	primary key (idRegion, idCountry)
);

create table ESFRenewal (
	esfRenewalId LONG not null primary key,
	companyId LONG,
	userId LONG,
	modifiedDate DATE null,
	quantity LONG,
	paymentReason VARCHAR(75) null,
	paymentType VARCHAR(75) null,
	paymentDate DATE null,
	paymentReceived BOOLEAN,
	createDate DATE null,
	groupId LONG,
	info VARCHAR(75) null,
	madeBy VARCHAR(75) null,
	amount DOUBLE,
	organizationId LONG,
	reportingYear INTEGER,
	amountTotal DOUBLE,
	isTotal BOOLEAN,
	renewalFatherId LONG,
	affiliates BOOLEAN
);

create table ESFResult (
	esfResultId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	matchYear INTEGER,
	numberMatch INTEGER,
	esfMatchId LONG,
	name VARCHAR(75) null,
	name2 VARCHAR(75) null,
	esfAssociationId LONG,
	sportTypeCode VARCHAR(75) null,
	startdDate DATE null,
	endDate DATE null,
	groupRanking VARCHAR(75) null,
	descGroupRanking VARCHAR(75) null,
	position INTEGER,
	cardNumber VARCHAR(75) null,
	shooterName VARCHAR(75) null,
	nationCode VARCHAR(75) null,
	category VARCHAR(75) null,
	qualificationCode VARCHAR(75) null,
	resultS1 INTEGER,
	resultS2 INTEGER,
	resultS3 INTEGER,
	resultS4 INTEGER,
	resultS5 INTEGER,
	resultS6 INTEGER,
	resultS7 INTEGER,
	resultS8 INTEGER,
	totalS INTEGER,
	barrage INTEGER,
	finalS INTEGER,
	finalTotal INTEGER,
	american1 INTEGER,
	american2 INTEGER,
	american3 INTEGER,
	rifle VARCHAR(75) null,
	caliber VARCHAR(75) null,
	catridge VARCHAR(75) null,
	finalType VARCHAR(75) null,
	semifinalResult INTEGER,
	shootOff1s INTEGER,
	shootOff2s INTEGER,
	shootOff3s INTEGER,
	bronzeResult INTEGER,
	shootOffBronze INTEGER,
	goldResult INTEGER,
	shootOffGold INTEGER,
	teamCategory VARCHAR(75) null,
	teamName VARCHAR(75) null,
	naz_int VARCHAR(75) null,
	showTypeCode INTEGER,
	showType VARCHAR(75) null,
	esfUserId LONG,
	variationDate DATE null,
	sent INTEGER,
	youthQualification VARCHAR(75) null,
	esfMatchTypeId LONG,
	resultClassTeam INTEGER,
	spare1 INTEGER,
	spare2 INTEGER,
	shooterCode LONG,
	shooterQualification LONG
);

create table ESFShooterAffiliationChrono (
	esfShooterAffiliationChronoId LONG not null primary key,
	esfuserId LONG,
	affiliationDate DATE null,
	year INTEGER,
	Vcampo VARCHAR(75) null,
	paymentDate DATE null,
	payment VARCHAR(75) null,
	card VARCHAR(75) null,
	esfOrganization VARCHAR(75) null,
	note VARCHAR(75) null
);

create table ESFShooterCategory (
	uuid_ VARCHAR(75) null,
	esfShooterCategoryId LONG not null primary key,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null
);

create table ESFShooterCategoryESFMatch (
	uuid_ VARCHAR(75) null,
	esfShooterCategoryId LONG not null,
	esfMatchId LONG not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	primary key (esfShooterCategoryId, esfMatchId)
);

create table ESFShooterCategoryESFTournament (
	uuid_ VARCHAR(75) null,
	esfShooterCategoryId LONG not null,
	esfTournamentId LONG not null,
	groupId LONG,
	primary key (esfShooterCategoryId, esfTournamentId)
);

create table ESFShooterQualification (
	uuid_ VARCHAR(75) null,
	esfShooterQualificationId LONG not null primary key,
	name VARCHAR(75) null,
	isJunior BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	code_ VARCHAR(75) null
);

create table ESFShooterQualificationESFMatch (
	uuid_ VARCHAR(75) null,
	esfShooterQualificationId LONG not null,
	esfMatchId LONG not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	primary key (esfShooterQualificationId, esfMatchId)
);

create table ESFShooterQualificationESFTournament (
	uuid_ VARCHAR(75) null,
	esfShooterQualificationId LONG not null,
	esfTournamentId LONG not null,
	groupId LONG,
	primary key (esfShooterQualificationId, esfTournamentId)
);

create table ESFShootingDirector (
	esfShootingDirectorId LONG not null primary key,
	esfCodeData VARCHAR(75) null,
	esfStartData DATE null,
	esfEndData DATE null,
	esfUserId LONG,
	codeUser LONG,
	shootingDirectorQualificationId LONG,
	sportTypeId LONG,
	regionId VARCHAR(75) null,
	provinceId VARCHAR(75) null,
	flagCrea VARCHAR(75) null,
	DateVar DATE null
);

create table ESFShootingDirectorQualification (
	esfShootingDirectorQualificationId LONG not null primary key,
	esfShootingDirectorQualificationDesc VARCHAR(75) null
);

create table ESFSpecific (
	uuid_ VARCHAR(75) null,
	esfSpecificId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null
);

create table ESFSportType (
	uuid_ VARCHAR(75) null,
	esfSportTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	national BOOLEAN,
	code_ VARCHAR(75) null,
	isChangeCategory BOOLEAN,
	isOlimpic BOOLEAN
);

create table ESFState (
	esfStateId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table ESFStateAssEntity (
	esfStateId LONG not null,
	className VARCHAR(75) not null,
	primary key (esfStateId, className)
);

create table ESFSuspensiveCode (
	esfSuspensiveCodeId LONG not null primary key,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null
);

create table ESFSuspensiveShootingDirector (
	esfSuspensiveShooingDirectorId LONG not null primary key,
	esfData DATE null,
	esfCodeData VARCHAR(75) null,
	esfStartData DATE null,
	esfEndData DATE null,
	esfUserId LONG,
	codeUser LONG,
	Codice_Sosp LONG,
	note VARCHAR(75) null,
	Qualif1_Utiliz LONG,
	Qualif2_Utiliz LONG,
	Qualif3_Utiliz LONG,
	Tipo_Gara1_noUtil LONG,
	Tipo_Gara2_noUtil LONG,
	Tipo_Gara3_noUtil LONG,
	Tipo_Gara4_noUtil LONG,
	Tipo_Gara5_noUtil LONG,
	Tipo_Gara6_noUtil LONG,
	Tipo_Gara7_noUtil LONG,
	Tipo_Gara8_noUtil LONG,
	Tipo_Gara9_noUtil LONG,
	Tipo_Gara10_noUtil LONG,
	esfVariationData DATE null
);

create table ESFTeam (
	esfTeamId LONG not null primary key,
	esfTournamentId LONG,
	name VARCHAR(75) null
);

create table ESFTournament (
	uuid_ VARCHAR(75) null,
	esfTournamentId LONG not null primary key,
	esfOrganizationId LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	maxnum LONG,
	minnum LONG,
	isSingleMatch BOOLEAN,
	isTeamMatch BOOLEAN,
	isIndividualMatch BOOLEAN,
	isJuniorMatch BOOLEAN,
	isNationalMatch BOOLEAN,
	isFinal BOOLEAN,
	startDate DATE null,
	endDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table ESFTransition (
	esfTransitionId LONG not null primary key,
	esfUserId LONG,
	esfCategoryId LONG,
	season VARCHAR(75) null
);

create table ESFUnitservice (
	uuid_ VARCHAR(75) null,
	esfUnitserviceId LONG not null primary key,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table ESFUser (
	uuid_ VARCHAR(75) null,
	esfUserId LONG not null primary key,
	code_ VARCHAR(75) null,
	typearmy LONG,
	fiscalCode VARCHAR(75) null,
	birthcity VARCHAR(75) null,
	nationality VARCHAR(75) null,
	isSportsGroups BOOLEAN,
	job VARCHAR(75) null,
	issfIdNumber VARCHAR(75) null,
	categoryId LONG,
	pin LONG,
	codeUser LONG,
	DateOfDeath DATE null,
	privacy1 BOOLEAN,
	privacy2 BOOLEAN,
	privacy3 BOOLEAN,
	datePrivacy1 DATE null,
	datePrivacy2 DATE null,
	datePrivacy3 DATE null,
	validateCF BOOLEAN
);

create table ESFUserCategory (
	esfUserCategoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfUserId LONG,
	startDate DATE null,
	endDate DATE null,
	esfCategoryId LONG,
	esfSportTypeId LONG
);

create table ESFUserESFFederalRole (
	esfUserId LONG not null,
	esfFederalRoleId LONG not null,
	startDate LONG not null,
	endDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	esfSpecificId LONG,
	regionId VARCHAR(75) null,
	provinceId VARCHAR(75) null,
	notes VARCHAR(75) null,
	primary key (esfUserId, esfFederalRoleId, startDate)
);

create table ESFUserESFUserRole (
	esfUserRoleId LONG not null,
	esfUserId LONG not null,
	esfOrganizationId LONG not null,
	startDate DATE not null,
	endDate DATE null,
	primary key (esfUserRoleId, esfUserId, esfOrganizationId, startDate)
);

create table ESFUserRole (
	uuid_ VARCHAR(75) null,
	esfUserRoleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	isBDO BOOLEAN,
	isLEA BOOLEAN,
	type_ INTEGER,
	maxUser INTEGER,
	isOrgAdmin BOOLEAN,
	isEditable BOOLEAN
);

create table ESFUserRoleESFFederalRole (
	esfUserId LONG not null,
	esfFederalRoleId LONG not null,
	startDate DATE null,
	endDate DATE null,
	active_ BOOLEAN,
	primary key (esfUserId, esfFederalRoleId)
);

create table ESFgunUser (
	esfGunUserId LONG not null primary key,
	esfGunId LONG,
	esfUserId LONG,
	code_ VARCHAR(75) null,
	isFavorite BOOLEAN,
	type_ INTEGER,
	note VARCHAR(75) null,
	esfGunnTypeId LONG,
	esfGunKindId LONG,
	typeId LONG,
	esfMeasures VARCHAR(75) null,
	esfCaliber VARCHAR(75) null
);

create table VW_ESFListaIncarichi (
	AnniPrecedenti INTEGER not null,
	AnnoFineIncarico INTEGER not null,
	AnnoInizioIncarico INTEGER not null,
	AnnoCorrente INTEGER not null,
	NomeRuolo VARCHAR(75) not null,
	endDate DATE null,
	startDate DATE not null,
	esfUserId LONG not null,
	esfOrganizationId LONG not null,
	lastName VARCHAR(75) not null,
	firstName VARCHAR(75) not null,
	primary key (AnniPrecedenti, AnnoFineIncarico, AnnoInizioIncarico, AnnoCorrente, NomeRuolo, startDate, esfUserId, esfOrganizationId, lastName, firstName)
);

create table VW_ESFlistaincarichi (
	AnniPrecedenti INTEGER not null,
	AnnoFineIncarico INTEGER not null,
	AnnoInizioIncarico INTEGER not null,
	AnnoCorrente INTEGER not null,
	NomeRuolo VARCHAR(75) not null,
	endDate DATE not null,
	startDate DATE not null,
	esfUserId LONG not null,
	esfOrganizationId LONG not null,
	lastName VARCHAR(75) not null,
	firstName VARCHAR(75) not null,
	primary key (AnniPrecedenti, AnnoFineIncarico, AnnoInizioIncarico, AnnoCorrente, NomeRuolo, endDate, startDate, esfUserId, esfOrganizationId, lastName, firstName)
);

create table esforganization (
	esfOrganizationId LONG not null primary key,
	code_ VARCHAR(75) null,
	vat VARCHAR(75) null,
	fiscalCode VARCHAR(75) null,
	ibanCode VARCHAR(75) null,
	isMultiSport BOOLEAN,
	legalForm VARCHAR(75) null,
	category VARCHAR(75) null,
	establishmentDate DATE null,
	closureDate DATE null,
	type_ INTEGER,
	insertDate DATE null,
	coniDate DATE null,
	coniCode VARCHAR(75) null,
	description VARCHAR(75) null,
	isYouthActive BOOLEAN,
	firstAffiliationDate DATE null,
	variations LONG,
	regionCode LONG,
	idFatherAssociation LONG,
	constitutiveAct BOOLEAN,
	registeredStatus BOOLEAN,
	planimetrySportsStand BOOLEAN,
	certificateFITAV BOOLEAN,
	note VARCHAR(75) null,
	isSimplyOrganizzation BOOLEAN,
	webSite VARCHAR(75) null,
	includeConiReport BOOLEAN,
	organizzationCategory VARCHAR(75) null,
	type_ INTEGER
);

create table vw_datidirettoretiro (
	esfShootingDirectorId LONG not null,
	Nome VARCHAR(75) not null,
	Cognome VARCHAR(75) not null,
	CodiceRegione VARCHAR(75) not null,
	primary key (esfShootingDirectorId, Nome, Cognome, CodiceRegione)
);

create table vw_esflistaincarichi (
	AnniPrecedenti INTEGER not null,
	AnnoInizioIncarico INTEGER not null,
	AnnoCorrente INTEGER not null,
	NomeRuolo VARCHAR(75) not null,
	endDate DATE not null,
	startDate DATE not null,
	esfUserId LONG not null,
	esfOrganizationId LONG not null,
	lastName VARCHAR(75) not null,
	firstName VARCHAR(75) not null,
	primary key (AnniPrecedenti, AnnoInizioIncarico, AnnoCorrente, NomeRuolo, endDate, startDate, esfUserId, esfOrganizationId, lastName, firstName)
);