create index IX_80CF03A6 on ESFCard (uuid_);
create index IX_276C5CC2 on ESFCard (uuid_, companyId);
create unique index IX_DE892BC4 on ESFCard (uuid_, groupId);

create index IX_20FCB886 on ESFDocument (issuer);
create index IX_81CA610D on ESFDocument (locationReference);
create index IX_A1010E98 on ESFDocument (name);
create index IX_55E22E6D on ESFDocument (number_);
create index IX_5D6ADE78 on ESFDocument (ownerId, ownerType);
create index IX_CF0218C2 on ESFDocument (typeId);
create index IX_E5A5861C on ESFDocument (type_);
create index IX_135545FB on ESFDocument (uuid_);
create index IX_3FC4C34D on ESFDocument (uuid_, companyId);
create unique index IX_CE4FB90F on ESFDocument (uuid_, groupId);

create index IX_1D1D40E3 on ESFOrganization (uuid_);
create index IX_981A6765 on ESFOrganization (uuid_, companyId);
create unique index IX_EF6F8327 on ESFOrganization (uuid_, groupId);

create index IX_AC19088B on ESFOrganizationType (esfOrganizationId);
create index IX_33A9AA12 on ESFOrganizationType (esfTypeId);

create index IX_2CA3581B on ESFType (className);
create index IX_913CE856 on ESFType (classNameId);
create index IX_17F6BF4A on ESFType (code_);
create index IX_F1C1B9B7 on ESFType (name);
create index IX_69330ADE on ESFType (status);
create index IX_ED22D0EB on ESFType (typeParentId);

create index IX_DA36F5D9 on ESFUser (code_);
create index IX_41C4EBCF on ESFUser (portalUserId);
create index IX_9CEA354B on ESFUser (uuid_);
create index IX_F29821FD on ESFUser (uuid_, companyId);
create unique index IX_B2CB03BF on ESFUser (uuid_, groupId);