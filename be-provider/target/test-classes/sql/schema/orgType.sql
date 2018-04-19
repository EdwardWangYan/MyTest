CREATE TABLE pat_org_type(id VARCHAR(64) PRIMARY KEY, title VARCHAR(30) DEFAULT NULL, code VARCHAR(64) DEFAULT NULL, short_title VARCHAR(30) DEFAULT NULL, org_logo_file_id VARCHAR(64) DEFAULT NULL, remark VARCHAR(255) DEFAULT NULL, deleted_flag INT DEFAULT 0, created_time DATETIME DEFAULT NULL, created_by VARCHAR(64) DEFAULT NULL, update_time DATETIME DEFAULT NULL, update_by VARCHAR(64) DEFAULT NULL)