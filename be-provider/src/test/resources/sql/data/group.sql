INSERT INTO pat_org_events_info (id, event_title) VALUES ('1','赛事');
INSERT INTO pat_org_events_groups_info(id, group_title) VALUES ('1','组别');
INSERT INTO pat_org_events_groups_fields(id, group_id, parent_key, fields_title, fields_key, fields_value) VALUES ('1','1',NULL ,'个人赛','groupType','1');
INSERT INTO pat_org_events_groups_fields(id, group_id, parent_key, fields_title, fields_key, fields_value) VALUES ('2','1','groupType' ,'个人赛','ageLimit','0');
INSERT INTO pat_org_events_groups_relation(id, event_id, group_id) VALUES ('1','1','1');

INSERT INTO pat_org_events_group_role_info(id, group_id, title, type) VALUES ('group_role_1', 'group_1', '个人赛', 1);
INSERT INTO pat_org_events_group_role_optional_relation(id, group_role_id, optional_id) VALUES ('gro_1', 'group_role_1', 'optional_1');
INSERT INTO pat_org_events_optional(id, optional_type, title, summary) VALUES ('optional_1', 1, '选手个人信息采集表1', '一些提示信息');
