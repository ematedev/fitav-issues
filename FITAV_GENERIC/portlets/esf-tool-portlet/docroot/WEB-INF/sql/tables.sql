create table ESF_ESFTool (
	uuid_ VARCHAR(75) null,
	esfToolId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table ESF_ESFToolRel (
	uuid_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	assignmentDate DATE null,
	esfToolId LONG not null,
	className VARCHAR(75) not null,
	classPK LONG not null,
	primary key (esfToolId, className, classPK)
);