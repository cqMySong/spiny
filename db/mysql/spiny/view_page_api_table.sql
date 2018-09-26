
-- 视图页面关联 API 表
DROP TABLE
IF EXISTS `view_page_api`;

CREATE TABLE `view_page_api` (
  `id` BIGINT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id',
  `page_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '视图页面 id',
  `api_id` BIGINT(20) UNSIGNED NOT NULL COMMENT 'API id',
    PRIMARY KEY `pk_id`(`id`)
)
  ENGINE = INNODB
  DEFAULT CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  AUTO_INCREMENT = 1
  ROW_FORMAT = DYNAMIC
  COMMENT = '视图页面关联 API 表';
