create table ESF_City (
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

create table ESF_Country (
	idCountry VARCHAR(75) not null primary key,
	name VARCHAR(75) null
);

create table ESF_ESFAddress (
	uuid_ VARCHAR(75) null,
	esfAddressId LONG not null primary key,
	latitude DOUBLE,
	longitude DOUBLE,
	esfCountryId VARCHAR(75) null,
	esfRegionId VARCHAR(75) null,
	esfProvinceId VARCHAR(75) null,
	esfCityId LONG,
	groupId LONG
);

create table ESF_Province (
	idProvince VARCHAR(75) not null,
	idRegion VARCHAR(75) not null,
	idCountry VARCHAR(75) not null,
	name VARCHAR(75) null,
	primary key (idProvince, idRegion, idCountry)
);

create table ESF_Region (
	idRegion VARCHAR(75) not null,
	idCountry VARCHAR(75) not null,
	name VARCHAR(75) null,
	primary key (idRegion, idCountry)
);