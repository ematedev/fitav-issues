create table ESF_ESFCard (
	uuid_ VARCHAR(75) null,
	esfCardId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	esfUserId LONG,
	esfOrganizationId LONG
);