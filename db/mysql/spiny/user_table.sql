
-- 用户表
DROP TABLE
IF EXISTS `user`;

-- 123456
-- $2a$10$tYdoCZPLiG2bMX9Cn09JCOV.g0BZeblQ39Rq0HL.jJy5OtCnUMOmC

CREATE TABLE `user` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `password` VARCHAR(255) NOT NULL COMMENT '用户密码',
  `username` VARCHAR(255) COMMENT '用户名',
  `email` VARCHAR(255) COMMENT '电子邮箱',
  `email_is_verified` TINYINT(1) UNSIGNED DEFAULT NULL COMMENT '电子邮箱是否验证通过（0=未验证，1=已验证，默认=0）',
  `department_id` BIGINT(20) COMMENT '部门 id',
  `remark` VARCHAR(255) DEFAULT '' COMMENT '备注',
-- `is_deleted` TINYINT(1) UNSIGNED DEFAULT NULL COMMENT '是否删除（0=未删除，1=已删除，默认=0）',
  `gmt_deleted` DATETIME DEFAULT NULL COMMENT '删除时间',
  `gmt_modified` DATETIME DEFAULT NOW() COMMENT '更新时间',
  `gmt_created` DATETIME DEFAULT NOW() COMMENT '创建时间',
  PRIMARY KEY `pk_id` (`id`),
  UNIQUE KEY `uk_username` (`username`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '用户表';
