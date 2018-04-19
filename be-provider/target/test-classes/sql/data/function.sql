INSERT INTO pat_org_operator (id, login_name) VALUES ('1', 'lisi');
INSERT INTO pat_system_role_info (id, role_name) VALUES ('1', 'role');
INSERT INTO pat_system_function (id,parent_id, function_title, permission_value,org_type) VALUES ('1', NULL ,'function01', 'permission01','platform');
INSERT INTO pat_system_function (id,parent_id, function_title, permission_value,org_type) VALUES ('2', '1','function02', 'permission02','platform');
INSERT INTO pat_org_operator_role_relation (id, operator_id, role_id) VALUES ('1', '1', '1');
INSERT INTO pat_system_role_permission (id, role_id, permission_id) VALUES ('1', '1', '1');
INSERT INTO pat_system_role_permission (id, role_id, permission_id) VALUES ('2', '1', '2');
INSERT INTO pat_org_type(id, title, code) VALUES ('1','平台','platform');