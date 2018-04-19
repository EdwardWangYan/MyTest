CREATE TABLE pat_system_role_info(id VARCHAR(64) PRIMARY KEY, org_id VARCHAR(64) DEFAULT NULL, role_name VARCHAR(30) DEFAULT NULL, code VARCHAR(50) DEFAULT NULL, type_id VARCHAR(64) DEFAULT NULL, remark VARCHAR(255) DEFAULT NULL, deleted_flag INT DEFAULT NULL, created_time DATETIME DEFAULT NULL, created_by VARCHAR(64) DEFAULT NULL, update_time DATETIME DEFAULT NULL, update_by VARCHAR(64) DEFAULT NULL)