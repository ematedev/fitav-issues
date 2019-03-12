create index IX_4D50BBE0 on ESF_ESFCard (startDate, endDate);
create index IX_4C98B3AD on ESF_ESFCard (uuid_);
create index IX_AB90325B on ESF_ESFCard (uuid_, companyId);
create unique index IX_70A7939D on ESF_ESFCard (uuid_, groupId);