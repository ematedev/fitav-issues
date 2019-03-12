create index IX_F1FA4E7B on ESF_ESFField (groupId);
create index IX_95E32F8E on ESF_ESFField (name);
create index IX_951BFD82 on ESF_ESFField (ownerOrganizationId);
create index IX_BAB743C5 on ESF_ESFField (uuid_);
create index IX_845F2343 on ESF_ESFField (uuid_, companyId);
create unique index IX_3ACD9E85 on ESF_ESFField (uuid_, groupId);

create index IX_9A71E536 on ESF_ESFFieldESFSportType (esfFieldId);
create index IX_28C2B8A on ESF_ESFFieldESFSportType (esfSportTypeId);
create index IX_EBF3AF on ESF_ESFFieldESFSportType (uuid_);
create index IX_8E183D19 on ESF_ESFFieldESFSportType (uuid_, companyId);
create unique index IX_2E8F35DB on ESF_ESFFieldESFSportType (uuid_, groupId);

create index IX_4589C1A7 on ESF_ESFSportType (groupId);
create index IX_8A06BE2 on ESF_ESFSportType (name);
create index IX_9FA191F1 on ESF_ESFSportType (uuid_);
create index IX_BC208197 on ESF_ESFSportType (uuid_, companyId);
create unique index IX_9A3A81D9 on ESF_ESFSportType (uuid_, groupId);