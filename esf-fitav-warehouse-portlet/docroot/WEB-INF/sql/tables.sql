create table ESFArticle (
	esfArticleId LONG not null primary key,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	xxxlQty LONG,
	xxlQty LONG,
	xlQty LONG,
	lQty LONG,
	mQty LONG,
	sQty LONG,
	xsQty LONG,
	xxsQty LONG,
	otherQty LONG,
	totalQty LONG,
	disabled BOOLEAN,
	esfArticleTypeId LONG
);

create table ESFArticleType (
	esfArticleTypeId LONG not null primary key,
	description VARCHAR(75) null,
	department VARCHAR(75) null,
	area VARCHAR(75) null
);

create table ESFArticle_ESFOrder (
	esfArticleId LONG not null,
	esfOrderId LONG not null,
	xxxlQty LONG,
	xxlQty LONG,
	xlQty LONG,
	lQty LONG,
	mQty LONG,
	sQty LONG,
	xsQty LONG,
	xxsQty LONG,
	otherQty LONG,
	totalQty LONG,
	price DOUBLE,
	vat DOUBLE,
	sale_ DOUBLE,
	primary key (esfArticleId, esfOrderId)
);

create table ESFArticle_ESFUser (
	esfArticleId LONG not null,
	esfUserId LONG not null,
	xxxlQty LONG,
	xxlQty LONG,
	xlQty LONG,
	lQty LONG,
	mQty LONG,
	sQty LONG,
	xsQty LONG,
	xxsQty LONG,
	otherQty LONG,
	totalQty LONG,
	description VARCHAR(75) null,
	deliveryDate DATE null,
	primary key (esfArticleId, esfUserId)
);

create table ESFBill (
	esfBillId LONG not null primary key,
	esfArticleId LONG,
	esfOrderId LONG,
	billNumber VARCHAR(75) null,
	xxxlQty LONG,
	xxlQty LONG,
	xlQty LONG,
	lQty LONG,
	mQty LONG,
	sQty LONG,
	xsQty LONG,
	xxsQty LONG,
	otherQty LONG,
	totalQty LONG
);

create table ESFOrder (
	esfOrderId LONG not null primary key,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	date_ DATE null,
	note STRING null,
	protocolCode VARCHAR(75) null,
	attachment VARCHAR(75) null,
	state_ INTEGER,
	esfStockistId LONG
);

create table ESFStockist (
	esfStockistId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	address VARCHAR(75) null,
	description VARCHAR(75) null,
	other VARCHAR(75) null,
	nameReference VARCHAR(75) null,
	lastNameReference VARCHAR(75) null,
	emailReference VARCHAR(75) null,
	phoneReference VARCHAR(75) null,
	vatNumber VARCHAR(75) null,
	iban VARCHAR(75) null
);