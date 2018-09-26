
-- 附件表
DROP TABLE
IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `filename` VARCHAR(255) NOT NULL COMMENT '文件名',
  `file` TEXT COMMENT '文件（路径）',
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
  COMMENT = '附件表';
