create index IX_C85F3F3 on ESF_ESFEntityState (classPk, className);
create index IX_38D3A011 on ESF_ESFEntityState (uuid_);
create index IX_7CEE5F77 on ESF_ESFEntityState (uuid_, companyId);
create unique index IX_C6A657B9 on ESF_ESFEntityState (uuid_, groupId);

create index IX_EF443A0E on ESF_ESFState (uuid_);
create index IX_26E4955A on ESF_ESFState (uuid_, companyId);
create unique index IX_9F66AA5C on ESF_ESFState (uuid_, groupId);