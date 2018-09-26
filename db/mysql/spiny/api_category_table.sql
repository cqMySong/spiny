
-- API 分类表
DROP TABLE
IF EXISTS `api_category`;

CREATE TABLE `api_category` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(255) NOT NULL COMMENT '分类名称',
  `parent_id` BIGINT(20) DEFAULT NULL COMMENT '父级分类 id',
  `sort` BIGINT(20) DEFAULT 0 COMMENT '排序',
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
  COMMENT = 'API 分类表';
