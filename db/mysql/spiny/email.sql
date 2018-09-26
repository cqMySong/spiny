
-- 电子邮件表
DROP TABLE
IF EXISTS `email`;

CREATE TABLE `email` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `status` INT(1) NOT NULL COMMENT '发信状态',
  `from` VARCHAR(255) DEFAULT NULL COMMENT '发件人',
  `to` VARCHAR(255) DEFAULT NULL COMMENT '收件人',
  `subject` VARCHAR(255) DEFAULT NULL COMMENT '主题',
  `text` TEXT COMMENT '内容',
  `html` INT(1) DEFAULT 0 COMMENT '是否为 html，0=否，1=是',
  `error` TEXT COMMENT '发信报错信息',
  `remark` VARCHAR(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` DATETIME DEFAULT NOW() COMMENT '更新时间',
  `gmt_created` DATETIME DEFAULT NOW() COMMENT '创建时间',
  PRIMARY KEY `pk_id`(`id`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '电子邮件表';
