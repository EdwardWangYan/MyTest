CREATE TABLE pat_org_staff_operator_relation(id VARCHAR(64) PRIMARY KEY, staff_id VARCHAR(64) DEFAULT NULL, operator_id VARCHAR(64) DEFAULT NULL, effective_time DATE DEFAULT NULL, deleted_flag INT DEFAULT 0, created_time DATETIME DEFAULT NULL, created_by VARCHAR(64) DEFAULT NULL, update_time DATETIME DEFAULT NULL, update_by VARCHAR(64) DEFAULT NULL)