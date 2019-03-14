create index IX_AFED5EB3 on ESF_ESFTool (code_);
create index IX_FC4810DD on ESF_ESFTool (description);
create index IX_56F538DE on ESF_ESFTool (eSFToolId, groupId);
create index IX_9E7DB4DE on ESF_ESFTool (esfToolId, groupId);
create index IX_54F690DB on ESF_ESFTool (groupId);
create index IX_2835092E on ESF_ESFTool (name);
create index IX_44F0DE46 on ESF_ESFTool (type_);
create index IX_72A09E25 on ESF_ESFTool (uuid_);
create index IX_47978CE3 on ESF_ESFTool (uuid_, companyId);
create unique index IX_C653F025 on ESF_ESFTool (uuid_, groupId);

create index IX_B638F745 on ESF_ESFToolRel (assignmentDate);
create index IX_474C3BA6 on ESF_ESFToolRel (className, classPK);
create index IX_8F3A1B25 on ESF_ESFToolRel (esfToolId);
create index IX_C768987E on ESF_ESFToolRel (uuid_);
create index IX_28B1D0EA on ESF_ESFToolRel (uuid_, companyId);
create unique index IX_876D89EC on ESF_ESFToolRel (uuid_, groupId);