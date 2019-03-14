create index IX_9952815 on ESF_City (idCountry, idRegion, idProvince);

create index IX_8164407F on ESF_Country (uuid_);

create index IX_F7E4D301 on ESF_ESFAddress (groupId);
create index IX_9DCBF9A3 on ESF_ESFAddress (lng, lat);
create index IX_BC50B716 on ESF_ESFAddress (longitude, latitude);
create index IX_746531CB on ESF_ESFAddress (uuid_);
create unique index IX_14A4173F on ESF_ESFAddress (uuid_, groupId);

create index IX_AC3E1FAB on ESF_Province (idRegion, idCountry);

create index IX_B90B236A on ESF_Region (idCountry);