create index IX_1BADB7A0 on ESF_ESFGun (esfGunKindId);
create index IX_ACC09C1 on ESF_ESFGun (esfOrganizationId);
create index IX_70E1ED59 on ESF_ESFGun (esfUserId);
create index IX_7D99227F on ESF_ESFGun (uuid_);
create index IX_7F58AC49 on ESF_ESFGun (uuid_, companyId);
create unique index IX_5281B10B on ESF_ESFGun (uuid_, groupId);

create index IX_AEDB307A on ESF_ESFGunKind (esfGunTypeId);
create index IX_1817CCCB on ESF_ESFGunKind (uuid_);
create index IX_4AA8DA7D on ESF_ESFGunKind (uuid_, companyId);
create unique index IX_F0AFDC3F on ESF_ESFGunKind (uuid_, groupId);

create index IX_13E033E5 on ESF_ESFGunType (uuid_);
create index IX_E374DF23 on ESF_ESFGunType (uuid_, companyId);
create unique index IX_11E0D265 on ESF_ESFGunType (uuid_, groupId);