DROP TABLE IF EXISTS t_classify;
CREATE TABLE t_classify
(
  c_id CHAR(36) NOT NULL COMMENT '主键',
  c_code VARCHAR(255) NOT NULL COMMENT '编码',
  c_key VARCHAR(255) DEFAULT NULL COMMENT '键',
  c_value VARCHAR(255) NOT NULL COMMENT '值',
  c_name VARCHAR(255) NOT NULL COMMENT '名称',
  c_json TEXT DEFAULT NULL COMMENT 'JSON扩展',
  c_recycle INT DEFAULT 0 COMMENT '回收站；0-否，1-是',

  PRIMARY KEY pk(c_id) USING HASH,
  KEY k_code_value(c_recycle,c_code,c_value) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
