CREATE TABLE comm_cn_area (id VARCHAR(64) PRIMARY KEY,parent_id VARCHAR(64) DEFAULT NULL,area_level INT DEFAULT NULL,area_code VARCHAR(12) DEFAULT NULL,zip_code VARCHAR(6) DEFAULT NULL,city_code VARCHAR(12) DEFAULT NULL,area_name VARCHAR(30) DEFAULT NULL,short_name VARCHAR(30) DEFAULT NULL,merger_name VARCHAR(50) DEFAULT NULL,pinyin VARCHAR(50) DEFAULT NULL,gps_lng DOUBLE DEFAULT NULL,gps_lat DOUBLE DEFAULT NULL,map_type INT DEFAULT NULL,map_lng DOUBLE DEFAULT NULL,map_lat DOUBLE DEFAULT NULL,deleted_flag INT DEFAULT NULL,created_time DATETIME DEFAULT NULL,created_by VARCHAR(64) DEFAULT NULL,update_time DATETIME DEFAULT NULL,update_by VARCHAR(64) DEFAULT NULL)