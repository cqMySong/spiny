
-- 部门表
DROP TABLE
IF EXISTS `department`;

CREATE TABLE `department` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(255) NOT NULL COMMENT '部门名称',
  `parent_id` BIGINT(20) DEFAULT NULL COMMENT '父部门 id',
  PRIMARY KEY `pk_id` (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '部门表';
