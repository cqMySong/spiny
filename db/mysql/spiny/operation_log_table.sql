
-- 系统操作日志表
DROP TABLE
IF EXISTS `operation_log`;

CREATE TABLE `operation_log` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '操作用户 id',
  `type` TINYINT(1) NOT NULL COMMENT '操作类型（0=页面访问，1=API 调用）',
  `method_name` VARCHAR(255) DEFAULT NULL COMMENT '操作方法',
  `operation` VARCHAR(255) DEFAULT NULL COMMENT '操作内容',
  `gmt_created` DATETIME DEFAULT NOW() COMMENT '创建时间',
  PRIMARY KEY `pk_id`(`id`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '系统操作日志表';
