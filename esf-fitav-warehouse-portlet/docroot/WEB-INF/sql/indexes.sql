create unique index IX_D5AF44FE on ESFArticle (code_);
create index IX_65F8D2E8 on ESFArticle (description);
create index IX_7D788234 on ESFArticle (disabled);
create index IX_94C7AD83 on ESFArticle (name);

create index IX_E600BF4E on ESFArticleType (description);

create index IX_C1AD50A2 on ESFArticle_ESFOrder (esfOrderId);

create index IX_32259195 on ESFArticle_ESFUser (esfArticleId);

create index IX_5B49BE37 on ESFBill (esfArticleId, esfOrderId);

create unique index IX_E010ABA6 on ESFOrder (code_);
create index IX_D64C9B90 on ESFOrder (description);
create index IX_4E23ADDB on ESFOrder (esfStockistId);
create index IX_4ACAD1DB on ESFOrder (name);

create index IX_AC2A7A on ESFStockist (description);
create index IX_5792B31A on ESFStockist (email);
create index IX_74A3D631 on ESFStockist (name);