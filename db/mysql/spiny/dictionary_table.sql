
-- 数据字典表
DROP TABLE
IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `key` VARCHAR(255) NOT NULL COMMENT '字典键',
  `key_name` VARCHAR(255) NOT NULL COMMENT '字典键名',
  `value_name` VARCHAR(255) NOT NULL COMMENT '字典值名',
  `value_slug` VARCHAR(255) NOT NULL COMMENT '字典值别名',
  `value` TEXT COMMENT '字典值',
  `editable` TINYINT(1) UNSIGNED DEFAULT NULL COMMENT '是否可编辑（0=不可编辑，1=可编辑，默认=1）',
  `dictionary_category_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '字典分类 id',
  `sort` BIGINT(20) UNSIGNED DEFAULT 0 COMMENT '排序',
  `remark` VARCHAR(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` DATETIME DEFAULT NOW() COMMENT '更新时间',
  `gmt_created` DATETIME DEFAULT NOW() COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '数据字典表';