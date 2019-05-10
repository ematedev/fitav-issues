create table ESFRenewalCompany (
	esfRenewalCompanyId LONG not null primary key,
	userId LONG,
	esfOrganizationId LONG,
	cardsNumber INTEGER,
	year INTEGER,
	date_ DATE null,
	paymentType INTEGER,
	status INTEGER,
	amount DOUBLE,
	info STRING null,
	accountholder VARCHAR(75) null,
	paymentDate DATE null,
	integrationAmount DOUBLE,
	integrationDate DATE null,
	integrationType INTEGER,
	integrationAccountholder VARCHAR(75) null,
	join_ BOOLEAN
);



--create table vw_listaincarichitessera (
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
	CodiceTessera VARCHAR(75) null,
	DataTesseramento DATE null,
<<<<<<< HEAD
	CodiceFiscale VARCHAR(75) null,
=======
>>>>>>> origin/master
	primary key (AnniPrecedenti, AnnoFineIncarico, AnnoInizioIncarico, AnnoCorrente, NomeRuolo, startDate, esfUserId, esfOrganizationId, lastName, firstName)
);