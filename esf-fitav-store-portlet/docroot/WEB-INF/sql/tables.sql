create table ESFArticle (
	esfArticleId LONG not null primary key,
	code_ VARCHAR(256) null,
	name VARCHAR(256) null,
	description VARCHAR(2000) null,
	esfArticleTypeId LONG,
	xxxlQty LONG,
	xxlQty LONG,
	xlQty LONG,
	lQty LONG,
	mQty LONG,
	sQty LONG,
	xsQty LONG,
	xxsQty LONG,
	otherQty LONG,
	price DOUBLE,
	tax DOUBLE,
	sale_ DOUBLE
);

create table ESFArticleDelivered (
	esfArticleDeliveredId LONG not null primary key,
	data_ DATE null,
	description VARCHAR(2000) null,
	esfArticleId LONG,
	esfShooterId LONG,
	xxxlQty LONG,
	xxlQty LONG,
	xlQty LONG,
	lQty LONG,
	mQty LONG,
	sQty LONG,
	xsQty LONG,
	xxsQty LONG,
	otherQty LONG
);

create table ESFArticleType (
	esfArticleTypeId LONG not null primary key,
	description VARCHAR(256) null,
	department VARCHAR(256) null,
	area VARCHAR(256) null
);

create table ESFOrder (
	esfOrderId LONG not null primary key,
	code_ VARCHAR(256) null,
	data_ DATE null,
	description VARCHAR(2000) null,
	esfStockistId LONG,
	qty LONG,
	esfArticleId LONG
);

create table ESFStockist (
	esfStockistId LONG not null primary key,
	name VARCHAR(256) null,
	email VARCHAR(256) null,
	phone VARCHAR(256) null,
	address VARCHAR(2000) null,
	nameReference VARCHAR(256) null,
	lastNameReference VARCHAR(256) null,
	emailReference VARCHAR(256) null,
	phoneReference VARCHAR(256) null,
	description VARCHAR(2000) null,
	other VARCHAR(2000) null
);