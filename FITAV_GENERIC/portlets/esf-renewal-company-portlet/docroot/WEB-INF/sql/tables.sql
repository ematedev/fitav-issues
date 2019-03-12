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