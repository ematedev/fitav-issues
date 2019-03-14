create unique index IX_D5AF44FE on ESFArticle (code_);
create index IX_D8EB03EB on ESFArticle (esfArticleTypeId);
create index IX_94C7AD83 on ESFArticle (name);

create index IX_1D95E4B9 on ESFArticleDelivered (esfArticleId);
create index IX_CCC21CF on ESFArticleDelivered (esfShooterId);

create unique index IX_E600BF4E on ESFArticleType (description);
create index IX_AB04E745 on ESFArticleType (esfArticleTypeId);

create unique index IX_E010ABA6 on ESFOrder (code_);
create index IX_BEEA1BE9 on ESFOrder (esfArticleId);
create index IX_4E23ADDB on ESFOrder (esfStockistId);

create index IX_5EDB2A45 on ESFStockist (esfStockistId);
create unique index IX_74A3D631 on ESFStockist (name);