create table ESF_ESFField (
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
	esfAddressId LONG
);

create table ESF_ESFFieldESFSportType (
	uuid_ VARCHAR(75) null,
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

create table ESF_ESFSportType (
	uuid_ VARCHAR(75) null,
	esfSportTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);