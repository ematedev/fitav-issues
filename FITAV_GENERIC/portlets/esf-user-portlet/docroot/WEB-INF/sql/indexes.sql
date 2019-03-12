create index IX_DA36F5D9 on ESFUser (code_);
create index IX_9CEA354B on ESFUser (uuid_);

create index IX_50AD7B12 on ESFUserESFUserRole (esfUserId);
create index IX_5A0BFA28 on ESFUserESFUserRole (esfUserRoleId);

create index IX_5A6DB1AB on ESFUserRole (groupId);
create index IX_2DA0DE14 on ESFUserRole (isBDO);
create index IX_2E2E08EF on ESFUserRole (isLEA);
create index IX_63EE1A5E on ESFUserRole (name);
create index IX_AE09B2F5 on ESFUserRole (uuid_);
create index IX_21D05613 on ESFUserRole (uuid_, companyId);
create unique index IX_898D4555 on ESFUserRole (uuid_, groupId);