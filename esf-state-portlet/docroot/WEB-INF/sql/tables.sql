create table ESF_ESFEntityState (
	uuid_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	className VARCHAR(75) not null,
	classPk LONG not null,
	stateId LONG not null,
	startDate DATE null,
	endDate DATE null,
	primary key (className, classPk, stateId)
);

create table ESF_ESFState (
	uuid_ VARCHAR(75) null,
	esfStateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	esfName VARCHAR(75) null,
	esfDescription VARCHAR(75) null
);