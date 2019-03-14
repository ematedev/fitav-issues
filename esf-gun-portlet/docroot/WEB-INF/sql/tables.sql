create table ESF_ESFGun (
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
	esfOrganizationId LONG
);

create table ESF_ESFGunKind (
	uuid_ VARCHAR(75) null,
	esfGunKindId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	esfGunTypeId LONG
);

create table ESF_ESFGunType (
	uuid_ VARCHAR(75) null,
	esfGunTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);