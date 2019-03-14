create table ESFUser (
	uuid_ VARCHAR(75) null,
	esfUserId LONG not null primary key,
	code_ VARCHAR(75) null
);

create table ESFUserESFUserRole (
	esfUserRoleId LONG not null,
	esfUserId LONG not null,
	esfOrganizationId LONG,
	startDate DATE null,
	endDate DATE null,
	primary key (esfUserRoleId, esfUserId)
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
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	isBDO BOOLEAN,
	isLEA BOOLEAN
);