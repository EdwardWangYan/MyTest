INSERT INTO pat_org_events_info (id, event_title, details, area_id1, area_id2, poster_file_id, status, deleted_flag) VALUES ('1', '测试赛事1', 'aabbcc', '1', '2', 'image1', 3, 0);
INSERT INTO pat_org_events_info (id, event_title, details, poster_file_id, status, deleted_flag) VALUES ('2', '测试赛事2', 'ae2d1f', 'image2', 3, 0);
INSERT INTO pat_org_events_info (id, event_title, details, poster_file_id, status, deleted_flag) VALUES ('3', '测试赛事3', 'eb231a', 'image3', 3, 1);

INSERT INTO comm_image_record (id, store_key, hash_code, store_bucket) VALUES ('image1', 'key1', 'hash1', 'bucket1');
INSERT INTO comm_cn_area (id, area_level, area_name, short_name, pinyin) VALUES ('1', 0, '北京市', '北京市', 'BeiJing');
INSERT INTO comm_cn_area (id, area_level, area_name, short_name, pinyin) VALUES ('2', 1, '北京（直辖区）', '北京', 'BeiJing');
