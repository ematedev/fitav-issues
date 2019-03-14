create table ESFCard (
	uuid_ VARCHAR(75) null,
	esfCardId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfUserId LONG,
	esfOrganizationId LONG
);

create table ESFDocument (
	uuid_ VARCHAR(75) null,
	esfDocumentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ownerId LONG,
	ownerType VARCHAR(75) null,
	name VARCHAR(75) null,
	number_ LONG,
	releaseDate DATE null,
	expireDate DATE null,
	issuer VARCHAR(75) null,
	contents VARCHAR(75) null,
	locationReference VARCHAR(75) null
);

create table ESFDocumentType (
	esfDocumentTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfDocumentId LONG,
	esfTypeId LONG
);

create table ESFOrganization (
	uuid_ VARCHAR(75) null,
	esfOrganizationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	portalOrganizationId LONG
);

create table ESFOrganizationType (
	esfOrganizationTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfOrganizationId LONG,
	esfTypeId LONG
);

create table ESFType (
	esfTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	className VARCHAR(75) null,
	status VARCHAR(75) null,
	typeParentId LONG
);

create table ESFUser (
	uuid_ VARCHAR(75) null,
	esfUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	portalUserId LONG,
	code_ VARCHAR(75) null
);