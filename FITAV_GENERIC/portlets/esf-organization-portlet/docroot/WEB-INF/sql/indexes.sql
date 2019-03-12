create index IX_F7E4D301 on ESF_ESFAddress (groupId);
create index IX_BC50B716 on ESF_ESFAddress (longitude, latitude);
create index IX_746531CB on ESF_ESFAddress (uuid_);
create unique index IX_14A4173F on ESF_ESFAddress (uuid_, groupId);

create index IX_F1FA4E7B on ESF_ESFField (groupId);
create index IX_598F7196 on ESF_ESFField (groupId, ownerOrganizationId);
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

create index IX_6762BA78 on ESF_ESFOrganization (code_);
create index IX_957A5A09 on ESF_ESFOrganization (fiscalCode);
create index IX_4840F60 on ESF_ESFOrganization (groupId);
create index IX_2A15F9EA on ESF_ESFOrganization (uuid_);
create unique index IX_BA390200 on ESF_ESFOrganization (uuid_, groupId);
create index IX_BA00E4CF on ESF_ESFOrganization (vat);

create index IX_4589C1A7 on ESF_ESFSportType (groupId);
create index IX_8A06BE2 on ESF_ESFSportType (name);
create index IX_9FA191F1 on ESF_ESFSportType (uuid_);
create index IX_BC208197 on ESF_ESFSportType (uuid_, companyId);
create unique index IX_9A3A81D9 on ESF_ESFSportType (uuid_, groupId);