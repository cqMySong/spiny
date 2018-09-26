/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : spiny

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 26/09/2018 11:51:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for api
-- ----------------------------
DROP TABLE IF EXISTS `api`;
CREATE TABLE `api` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT 'API 名称',
  `url` text COMMENT '请求地址（url）',
  `authority` varchar(191) NOT NULL COMMENT '权限（authority）',
  `api_category_id` bigint(20) unsigned NOT NULL COMMENT 'API 分类 id',
  `sort` bigint(20) unsigned DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_authority` (`authority`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='API 表';

-- ----------------------------
-- Records of api
-- ----------------------------
BEGIN;
INSERT INTO `api` VALUES (1, '分页获取所有父级 API 分类', '/api/system/api_category/page_all_parent', '/API/SYSTEM/API_CATEGORY/PAGE_ALL_PARENT', 4, 0, '', '2018-06-20 12:56:39', '2018-06-20 12:56:39');
INSERT INTO `api` VALUES (2, '指定父级 API 分类 id ，获取所有 API 分类分类', '/api/system/api_category/list_all_by_parent_id', '/API/SYSTEM/API_CATEGORY/LIST_ALL_BY_PARENT_ID', 4, 0, '', '2018-06-20 12:57:36', '2018-06-20 12:57:36');
INSERT INTO `api` VALUES (3, '新增 API 分类', '/api/system/api_category/add_one', '/API/SYSTEM/API_CATEGORY/ADD_ONE', 4, 0, '', '2018-06-20 12:58:15', '2018-06-20 12:58:15');
INSERT INTO `api` VALUES (4, '保存 API 分类', '/api/system/api_category/save_one', '/API/SYSTEM/API_CATEGORY/SAVE_ONE', 4, 0, '', '2018-06-20 12:58:43', '2018-06-20 12:58:43');
INSERT INTO `api` VALUES (5, '指定 API 分类 id ，批量删除 API 分类', '/api/system/api_category/delete_all', '/API/SYSTEM/API_CATEGORY/DELETE_ALL', 4, 0, '', '2018-06-20 12:59:32', '2018-06-20 12:59:18');
INSERT INTO `api` VALUES (6, '指定 API 分类 id ，获取 API 分类信息', '/api/system/api_category/one', '/API/SYSTEM/API_CATEGORY/ONE', 4, 0, '', '2018-06-20 13:00:35', '2018-06-20 13:00:35');
INSERT INTO `api` VALUES (7, '指定 API 分类 id ，分页获取所有 API', '/api/system/api/page_all_by_api_category_id', '/API/SYSTEM/API/PAGE_ALL_BY_API_CATEGORY_ID', 5, 0, '', '2018-06-20 13:01:16', '2018-06-20 13:01:16');
INSERT INTO `api` VALUES (8, '新增 API', '/api/system/api/add_one', '/API/SYSTEM/API/ADD_ONE', 5, 0, '', '2018-06-20 13:01:45', '2018-06-20 13:01:45');
INSERT INTO `api` VALUES (9, '保存 API', '/api/system/api/save_one', '/API/SYSTEM/API/SAVE_ONE', 5, 0, '', '2018-06-20 13:02:03', '2018-06-20 13:02:03');
INSERT INTO `api` VALUES (10, '指定 API id ，批量删除 API', '/api/system/api/delete_all', '/API/SYSTEM/API/DELETE_ALL', 5, 0, '', '2018-06-20 13:02:22', '2018-06-20 13:02:22');
INSERT INTO `api` VALUES (11, '指定 API id ， 获取 API 信息', '/api/system/api/one', '/API/SYSTEM/API/ONE', 5, 0, '', '2018-06-20 13:02:40', '2018-06-20 13:02:40');
INSERT INTO `api` VALUES (12, '分页获取所有父级数据字典分类', '/api/system/dictionary_category/page_all_parent', '/API/SYSTEM/DICTIONARY_CATEGORY/PAGE_ALL_PARENT', 6, 0, '', '2018-06-20 13:04:25', '2018-06-20 13:04:25');
INSERT INTO `api` VALUES (13, '指定父级数据字典分类 id ，获取所有数据字典分类', '/api/system/dictionary_category/list_all_by_parent_id', '/API/SYSTEM/DICTIONARY_CATEGORY/LIST_ALL_BY_PARENT_ID', 6, 0, '', '2018-06-20 13:04:43', '2018-06-20 13:04:43');
INSERT INTO `api` VALUES (14, '新增数据字典分类', '/api/system/dictionary_category/add_one', '/API/SYSTEM/DICTIONARY_CATEGORY/ADD_ONE', 6, 0, '', '2018-06-20 13:05:26', '2018-06-20 13:05:02');
INSERT INTO `api` VALUES (15, '保存数据字典分类', '/api/system/dictionary_category/save_one', '/API/SYSTEM/DICTIONARY_CATEGORY/SAVE_ONE', 6, 0, '', '2018-06-20 13:05:19', '2018-06-20 13:05:19');
INSERT INTO `api` VALUES (16, '指定数据字典分类 id ，批量删除数据字典分类', '/api/system/dictionary_category/delete_all', '/API/SYSTEM/DICTIONARY_CATEGORY/DELETE_ALL', 6, 0, '', '2018-06-20 13:05:44', '2018-06-20 13:05:44');
INSERT INTO `api` VALUES (17, '指定数据字典分类 id ，获取数据字典分类信息', '/api/system/dictionary_category/one', '/API/SYSTEM/DICTIONARY_CATEGORY/ONE', 6, 0, '', '2018-06-20 13:06:00', '2018-06-20 13:06:00');
INSERT INTO `api` VALUES (18, '指定父级数据字典分类 id ，获取所有数据字典', '/api/system/dictionary/page_all_by_dictionary_category_id', '/API/SYSTEM/DICTIONARY/PAGE_ALL_BY_DICTIONARY_CATEGORY_ID', 7, 0, '', '2018-06-20 13:06:49', '2018-06-20 13:06:49');
INSERT INTO `api` VALUES (19, '新增数据字典', '/api/system/dictionary/add_one', '/API/SYSTEM/DICTIONARY/ADD_ONE', 7, 0, '', '2018-06-20 13:07:27', '2018-06-20 13:07:27');
INSERT INTO `api` VALUES (20, '保存数据字典', '/api/system/dictionary/save_one', '/API/SYSTEM/DICTIONARY/SAVE_ONE', 7, 0, '', '2018-06-20 13:07:45', '2018-06-20 13:07:45');
INSERT INTO `api` VALUES (21, '指定数据字典 id ， 批量删除数据字典', '/api/system/dictionary/delete_all', '/API/SYSTEM/DICTIONARY/DELETE_ALL', 7, 0, '', '2018-06-20 13:08:06', '2018-06-20 13:08:06');
INSERT INTO `api` VALUES (22, '指定数据字典 id ，获取数据字典信息', '/api/system/dictionary/one', '/API/SYSTEM/DICTIONARY/ONE', 7, 0, '', '2018-06-20 13:10:51', '2018-06-20 13:08:54');
INSERT INTO `api` VALUES (23, '获取所有数据字典', '/api/system/dictionary/list_all', '/API/SYSTEM/DICTIONARY/LIST_ALL', 7, 0, '', '2018-06-20 13:11:16', '2018-06-20 13:11:16');
INSERT INTO `api` VALUES (24, '指定数据字典键 ，获取所有数据字典', '/api/system/dictionary/list_all_by_key', '/API/SYSTEM/DICTIONARY/LIST_ALL_BY_KEY', 7, 0, '', '2018-06-20 13:11:55', '2018-06-20 13:11:55');
INSERT INTO `api` VALUES (25, '是否关联 API', '/api/system/view_page_api/is_associated_by_page_id_and_api_id', '/API/SYSTEM/VIEW_PAGE_API/IS_ASSOCIATED_BY_PAGE_ID_AND_API_ID', 8, 0, '', '2018-06-20 14:25:36', '2018-06-20 14:25:36');
INSERT INTO `api` VALUES (26, '批量关联 API', '/api/system/view_page_api/associate_all_by_page_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_API/ASSOCIATE_ALL_BY_PAGE_ID_AND_API_ID_LIST', 8, 0, '', '2018-06-20 14:26:00', '2018-06-20 14:26:00');
INSERT INTO `api` VALUES (27, '指定视图页面 id、API id ，批量撤销关联', '/api/system/view_page_api/revoke_associate_all_by_page_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_API/REVOKE_ASSOCIATE_ALL_BY_PAGE_ID_AND_API_ID_LIST', 8, 0, '', '2018-06-20 14:26:26', '2018-06-20 14:26:26');
INSERT INTO `api` VALUES (28, '分页获取所有父级视图页面分类', '/api/system/view_page_category/page_all_parent', '/API/SYSTEM/VIEW_PAGE_CATEGORY/PAGE_ALL_PARENT', 9, 0, '', '2018-06-20 14:27:26', '2018-06-20 14:27:26');
INSERT INTO `api` VALUES (29, '指定父级视图页面分类 id ，获取所有视图页面分类', '/api/system/view_page_category/list_all_by_parent_id', '/API/SYSTEM/VIEW_PAGE_CATEGORY/LIST_ALL_BY_PARENT_ID', 9, 0, '', '2018-06-20 14:27:45', '2018-06-20 14:27:45');
INSERT INTO `api` VALUES (30, '新增视图页面分类', '/api/system/view_page_category/add_one', '/API/SYSTEM/VIEW_PAGE_CATEGORY/ADD_ONE', 9, 0, '', '2018-06-20 14:28:02', '2018-06-20 14:28:02');
INSERT INTO `api` VALUES (31, '保存视图页面分类', '/api/system/view_page_category/save_one', '/API/SYSTEM/VIEW_PAGE_CATEGORY/SAVE_ONE', 9, 0, '', '2018-06-20 14:28:17', '2018-06-20 14:28:17');
INSERT INTO `api` VALUES (32, '指定视图页面分类 id ，批量删除视图页面分类', '/api/system/view_page_category/delete_all', '/API/SYSTEM/VIEW_PAGE_CATEGORY/DELETE_ALL', 9, 0, '', '2018-06-20 14:28:36', '2018-06-20 14:28:36');
INSERT INTO `api` VALUES (33, '指定视图页面分类 id ，获取视图页面分类信息', '/api/system/view_page_category/one', '/API/SYSTEM/VIEW_PAGE_CATEGORY/ONE', 9, 0, '', '2018-06-20 14:29:04', '2018-06-20 14:29:04');
INSERT INTO `api` VALUES (34, '指定父级视图页面分类 id ，获取所有视图页面', '/api/system/view_page/page_all_by_page_category_id', '/API/SYSTEM/VIEW_PAGE/PAGE_ALL_BY_PAGE_CATEGORY_ID', 10, 0, '', '2018-06-20 14:38:43', '2018-06-20 14:38:43');
INSERT INTO `api` VALUES (35, '新增视图页面', '/api/system/view_page/add_one', '/API/SYSTEM/VIEW_PAGE/ADD_ONE', 10, 0, '', '2018-06-20 14:39:26', '2018-06-20 14:39:26');
INSERT INTO `api` VALUES (36, '保存视图页面', '/api/system/view_page/save_one', '/API/SYSTEM/VIEW_PAGE/SAVE_ONE', 10, 0, '', '2018-06-20 14:39:53', '2018-06-20 14:39:53');
INSERT INTO `api` VALUES (37, '指定视图页面 id ，批量删除视图页面', '/api/system/view_page/delete_all', '/API/SYSTEM/VIEW_PAGE/DELETE_ALL', 10, 0, '', '2018-06-20 14:40:17', '2018-06-20 14:40:17');
INSERT INTO `api` VALUES (38, '指定视图页面 id ，获取视图页面信息', '/api/system/view_page/one', '/API/SYSTEM/VIEW_PAGE/ONE', 10, 0, '', '2018-06-20 14:40:34', '2018-06-20 14:40:34');
INSERT INTO `api` VALUES (39, '分页获取所有视图页面组件', '/api/system/view_page_component/page_all_by_page_id', '/API/SYSTEM/VIEW_PAGE_COMPONENT/PAGE_ALL_BY_PAGE_ID', 11, 0, '', '2018-06-20 14:45:30', '2018-06-20 14:45:30');
INSERT INTO `api` VALUES (40, '新增视图页面组件', '/api/system/view_page_component/add_one', '/API/SYSTEM/VIEW_PAGE_COMPONENT/ADD_ONE', 11, 0, '', '2018-06-20 14:45:45', '2018-06-20 14:45:45');
INSERT INTO `api` VALUES (41, '保存视图页面组件', '/api/system/view_page_component/save_one', '/API/SYSTEM/VIEW_PAGE_COMPONENT/SAVE_ONE', 11, 0, '', '2018-06-20 14:46:03', '2018-06-20 14:46:03');
INSERT INTO `api` VALUES (42, '指定视图页面组件 id ，批量删除视图页面组件', '/api/system/view_page_component/delete_all', '/API/SYSTEM/VIEW_PAGE_COMPONENT/DELETE_ALL', 11, 0, '', '2018-06-20 14:46:22', '2018-06-20 14:46:22');
INSERT INTO `api` VALUES (43, '指定视图组件 id ，获取视图组件信息', '/api/system/view_page_component/one', '/API/SYSTEM/VIEW_PAGE_COMPONENT/ONE', 11, 0, '', '2018-06-20 14:46:40', '2018-06-20 14:46:40');
INSERT INTO `api` VALUES (44, '是否关联 API', '/api/system/view_page_component_api/is_associated_by_page_component_id_and_api_id', '/API/SYSTEM/VIEW_PAGE_COMPONENT_API/IS_ASSOCIATED_BY_PAGE_COMPONENT_ID_AND_API_ID', 12, 0, '', '2018-06-20 14:48:47', '2018-06-20 14:48:47');
INSERT INTO `api` VALUES (45, '批量关联 API', '/api/system/view_page_component_api/associate_all_by_page_component_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_COMPONENT_API/ASSOCIATE_ALL_BY_PAGE_COMPONENT_ID_AND_API_ID_LIST', 12, 0, '', '2018-06-20 14:49:42', '2018-06-20 14:49:42');
INSERT INTO `api` VALUES (46, '指定视图页面组件 id、API id ，批量撤销关联', '/api/system/view_page_component_api/revoke_associate_all_by_page_component_id_and_api_id_list', '/API/SYSTEM/VIEW_PAGE_COMPONENT_API/REVOKE_ASSOCIATE_ALL_BY_PAGE_COMPONENT_ID_AND_API_ID_LIST', 12, 0, '', '2018-06-20 14:50:43', '2018-06-20 14:50:43');
INSERT INTO `api` VALUES (47, '指定角色 id、视图页面权限（authority），批量授权', '/api/user/role_authority/grant_all_by_role_id_and_page_authority_list', '/API/USER/ROLE_AUTHORITY/GRANT_ALL_BY_ROLE_ID_AND_PAGE_AUTHORITY_LIST', 13, 0, '', '2018-07-03 21:24:13', '2018-06-20 15:07:15');
INSERT INTO `api` VALUES (48, '指定角色 id、视图页面权限（authority），批量撤销授权', '/api/user/role_authority/revoke_all_by_role_id_and_page_authority_list', '/API/USER/ROLE_AUTHORITY/REVOKE_ALL_BY_ROLE_ID_AND_PAGE_AUTHORITY_LIST', 13, 0, '', '2018-07-03 21:24:17', '2018-06-20 15:07:39');
INSERT INTO `api` VALUES (49, '指定角色 id、视图页面组件权限（authority），批量授权', '/api/user/role_authority/grant_all_by_role_id_and_page_component_authority_list', '/API/USER/ROLE_AUTHORITY/GRANT_ALL_BY_ROLE_ID_AND_PAGE_COMPONENT_AUTHORITY_LIST', 13, 0, '', '2018-07-03 21:24:20', '2018-06-20 15:08:11');
INSERT INTO `api` VALUES (50, '指定角色 id、视图页面组件权限（authority），批量撤销授权', '/api/user/role_authority/revoke_all_by_role_id_and_page_component_authority_list', '/API/USER/ROLE_AUTHORITY/REVOKE_ALL_BY_ROLE_ID_AND_PAGE_COMPONENT_AUTHORITY_LIST', 13, 0, '', '2018-07-03 21:24:24', '2018-06-20 15:08:27');
INSERT INTO `api` VALUES (51, '指定角色权限 id ，获取角色权限信息', '/api/user/role_authority/one', '/API/USER/ROLE_AUTHORITY/ONE', 13, 0, '', '2018-06-20 15:08:44', '2018-06-20 15:08:44');
INSERT INTO `api` VALUES (52, '指定角色 id、权限（authority）判断是否已授权', '/api/user/role_authority/is_granted_by_role_id_and_authority', '/API/USER/ROLE_AUTHORITY/IS_GRANTED_BY_ROLE_ID_AND_AUTHORITY', 13, 0, '', '2018-06-20 15:10:50', '2018-06-20 15:10:50');
INSERT INTO `api` VALUES (53, '分页获取所有角色', '/api/user/role/page_all', '/API/USER/ROLE/PAGE_ALL', 14, 0, '', '2018-06-20 15:12:12', '2018-06-20 15:12:12');
INSERT INTO `api` VALUES (54, '获取所有角色', '/api/user/role/list_all', '/API/USER/ROLE/LIST_ALL', 14, 0, '', '2018-06-20 15:12:38', '2018-06-20 15:12:38');
INSERT INTO `api` VALUES (55, '新增角色', '/api/user/role/add_one', '/API/USER/ROLE/ADD_ONE', 14, 0, '', '2018-06-20 15:12:53', '2018-06-20 15:12:53');
INSERT INTO `api` VALUES (56, '保存角色', '/api/user/role/save_one', '/API/USER/ROLE/SAVE_ONE', 14, 0, '', '2018-06-20 15:13:14', '2018-06-20 15:13:14');
INSERT INTO `api` VALUES (57, '指定角色 id ，批量删除角色', '/api/user/role/delete_all', '/API/USER/ROLE/DELETE_ALL', 14, 0, '', '2018-06-20 15:13:40', '2018-06-20 15:13:40');
INSERT INTO `api` VALUES (58, '指定角色 id ，获取角色信息', '/api/user/role/one', '/API/USER/ROLE/ONE', 14, 0, '', '2018-06-20 15:13:57', '2018-06-20 15:13:57');
INSERT INTO `api` VALUES (59, '指定用户 id ，获取用户角色', '/api/user/role/list_all_by_user_id', '/API/USER/ROLE/LIST_ALL_BY_USER_ID', 14, 0, '', '2018-06-20 15:14:27', '2018-06-20 15:14:27');
INSERT INTO `api` VALUES (60, '分页获取用户', '/api/user/page_all', '/API/USER/PAGE_ALL', 15, 0, '', '2018-06-20 15:16:24', '2018-06-20 15:16:24');
INSERT INTO `api` VALUES (61, '新增用户', '/api/user/add_one', '/API/USER/ADD_ONE', 15, 0, '', '2018-06-20 15:16:40', '2018-06-20 15:16:40');
INSERT INTO `api` VALUES (62, '保存用户', '/api/user/save_one', '/API/USER/SAVE_ONE', 15, 0, '', '2018-06-20 15:16:55', '2018-06-20 15:16:55');
INSERT INTO `api` VALUES (63, '伪删除用户', '/api/user/sign_all_gmt_deleted', '/API/USER/SIGN_ALL_GMT_DELETED', 15, 0, '', '2018-06-24 21:23:49', '2018-06-24 21:23:49');
INSERT INTO `api` VALUES (64, '撤销伪删除用户', '/api/user/unsign_all_gmt_deleted', '/API/USER/UNSIGN_ALL_GMT_DELETED', 15, 0, '', '2018-06-24 21:24:07', '2018-06-24 21:24:07');
INSERT INTO `api` VALUES (65, '指定用户 id ，批量删除用户', '/api/user/delete_all', '/API/USER/DELETE_ALL', 15, 0, '', '2018-06-24 21:24:54', '2018-06-24 21:24:54');
INSERT INTO `api` VALUES (66, '指定用户 id ，获取用户信息（除密码和角色）', '/api/user/one', '/API/USER/ONE', 15, 0, '', '2018-06-24 21:25:22', '2018-06-24 21:25:22');
INSERT INTO `api` VALUES (67, '分页获取所有用户角色', '/api/user/user_role/page_all', '/API/USER/USER_ROLE/PAGE_ALL', 16, 0, '', '2018-06-24 21:26:34', '2018-06-24 21:26:34');
INSERT INTO `api` VALUES (68, '新增用户角色', '/api/user/user_role/add_one', '/API/USER/USER_ROLE/ADD_ONE', 16, 0, '', '2018-06-24 21:26:53', '2018-06-24 21:26:53');
INSERT INTO `api` VALUES (69, '指定用户角色 id ，批量删除用户角色', '/api/user/user_role/delete_all_by_user_id_and_role_id_list', '/API/USER/USER_ROLE/DELETE_ALL_BY_USER_ID_AND_ROLE_ID_LIST', 16, 0, '', '2018-06-24 21:27:42', '2018-06-24 21:27:42');
INSERT INTO `api` VALUES (70, '指定角色 id ，分页获取所有父级视图菜单分类', '/api/user/view_menu_category/page_all_parent_by_role_id', '/API/USER/VIEW_MENU_CATEGORY/PAGE_ALL_PARENT_BY_ROLE_ID', 17, 0, '', '2018-06-24 21:30:19', '2018-06-24 21:28:38');
INSERT INTO `api` VALUES (71, '指定父级视图菜单分类 id 、角色 id ，获取所有视图菜单分类', '/api/user/view_menu_category/list_all_by_parent_id_and_role_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_BY_PARENT_ID_AND_ROLE_ID', 17, 0, '', '2018-06-24 21:30:36', '2018-06-24 21:29:06');
INSERT INTO `api` VALUES (72, '新增视图菜单分类', '/api/user/view_menu_category/add_one', '/API/USER/VIEW_MENU_CATEGORY/ADD_ONE', 17, 0, '', '2018-06-24 21:30:55', '2018-06-24 21:30:55');
INSERT INTO `api` VALUES (73, '保存视图菜单分类', '/api/user/view_menu_category/save_one', '/API/USER/VIEW_MENU_CATEGORY/SAVE_ONE', 17, 0, '', '2018-06-24 21:31:10', '2018-06-24 21:31:10');
INSERT INTO `api` VALUES (74, '指定视图菜单分类 id ，批量删除视图菜单分类', '/api/user/view_menu_category/delete_all', '/API/USER/VIEW_MENU_CATEGORY/DELETE_ALL', 17, 0, '', '2018-06-24 21:31:30', '2018-06-24 21:31:30');
INSERT INTO `api` VALUES (75, '指定视图菜单分类 id ，获取视图菜单分类信息', '/api/user/view_menu_category/one', '/API/USER/VIEW_MENU_CATEGORY/ONE', 17, 0, '', '2018-06-24 21:31:52', '2018-06-24 21:31:52');
INSERT INTO `api` VALUES (76, '指定角色 id ，获取所有父级视图菜单分类', '/api/user/view_menu_category/list_all_parent_by_role_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_PARENT_BY_ROLE_ID', 17, 0, '', '2018-06-24 21:32:16', '2018-06-24 21:32:16');
INSERT INTO `api` VALUES (77, '指定用户 id ，获取所有父级视图菜单分类', '/api/user/view_menu_category/list_all_parent_by_user_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_PARENT_BY_USER_ID', 17, 0, '首页显示顶部菜单分类', '2018-06-29 12:09:25', '2018-06-24 21:32:36');
INSERT INTO `api` VALUES (78, '指定用户 id 、父级视图菜单分类 id ，获取所有子级视图菜单分类', '/api/user/view_menu_category/list_all_child_by_parent_id_and_user_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_CHILD_BY_PARENT_ID_AND_USER_ID', 17, 0, '首页显示左侧子级菜单分类', '2018-06-29 12:09:11', '2018-06-24 21:33:19');
INSERT INTO `api` VALUES (79, '指定用户 id 、父级视图菜单分类 id ，获取所有子级视图菜单分类和视图菜单', '/api/user/view_menu_category/list_all_child_view_menu_category_and_view_menu_by_parent_id_and_user_id', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_CHILD_VIEW_MENU_CATEGORY_AND_VIEW_MENU_BY_PARENT_ID_AND_USER_ID', 17, 0, '首页显示子级菜单分类及子级菜单', '2018-06-29 12:10:22', '2018-06-24 21:34:15');
INSERT INTO `api` VALUES (80, '获取所有菜单分类', '/api/user/view_menu_category/list_all', '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL', 17, 0, '', '2018-06-24 21:35:24', '2018-06-24 21:35:24');
INSERT INTO `api` VALUES (81, '指定菜单分类名，模糊搜索获取所有菜单分类', '/api/user/view_menu_category/search_all_by_name', '/API/USER/VIEW_MENU_CATEGORY/SEARCH_ALL_BY_NAME', 17, 0, '', '2018-06-24 21:35:49', '2018-06-24 21:35:49');
INSERT INTO `api` VALUES (82, '指定视图菜单分类 id 、角色 id ，分页获取所有视图菜单', '/api/user/view_menu/page_all_by_menu_category_id_and_role_id', '/API/USER/VIEW_MENU/PAGE_ALL_BY_MENU_CATEGORY_ID_AND_ROLE_ID', 18, 0, '', '2018-06-24 21:36:50', '2018-06-24 21:36:50');
INSERT INTO `api` VALUES (83, '新增视图菜单', '/api/user/view_menu/add_one', '/API/USER/VIEW_MENU/ADD_ONE', 18, 0, '', '2018-06-24 21:37:11', '2018-06-24 21:37:11');
INSERT INTO `api` VALUES (84, '保存视图菜单', '/api/user/view_menu/save_one', '/API/USER/VIEW_MENU/SAVE_ONE', 18, 0, '', '2018-06-24 21:37:29', '2018-06-24 21:37:29');
INSERT INTO `api` VALUES (85, '指定视图菜单 id ，批量删除视图菜单', '/api/user/view_menu/delete_all', '/API/USER/VIEW_MENU/DELETE_ALL', 18, 0, '', '2018-06-24 21:37:51', '2018-06-24 21:37:51');
INSERT INTO `api` VALUES (86, '指定视图菜单 id ，获取视图菜单信息', '/api/user/view_menu/one', '/API/USER/VIEW_MENU/ONE', 18, 0, '', '2018-06-24 21:38:11', '2018-06-24 21:38:11');
INSERT INTO `api` VALUES (87, '指定菜单名，模糊搜索获取所有菜单', '/api/user/view_menu/search_all_by_name', '/API/USER/VIEW_MENU/SEARCH_ALL_BY_NAME', 18, 0, '', '2018-06-24 21:38:53', '2018-06-24 21:38:53');
INSERT INTO `api` VALUES (88, '指定角色 id、API 权限（authority），批量授权', '/api/user/role_authority/grant_all_by_role_id_and_api_authority_list', '/API/USER/ROLE_AUTHORITY/GRANT_ALL_BY_ROLE_ID_AND_API_AUTHORITY_LIST', 13, 0, '', '2018-07-03 21:24:04', '2018-07-03 21:24:04');
INSERT INTO `api` VALUES (89, '指定角色 id、API 权限（authority），批量撤销授权', '/api/user/role_authority/revoke_all_by_role_id_and_api_authority_list', '/API/USER/ROLE_AUTHORITY/REVOKE_ALL_BY_ROLE_ID_AND_API_AUTHORITY_LIST', 13, 0, '', '2018-07-03 21:25:13', '2018-07-03 21:25:13');
COMMIT;

-- ----------------------------
-- Table structure for api_category
-- ----------------------------
DROP TABLE IF EXISTS `api_category`;
CREATE TABLE `api_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级分类 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='API 分类表';

-- ----------------------------
-- Records of api_category
-- ----------------------------
BEGIN;
INSERT INTO `api_category` VALUES (1, '系统管理', NULL, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (2, '系统配置', 1, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (3, '用户配置', 1, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (4, 'API 分类', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (5, 'API', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (6, '数据字典分类', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (7, '数据字典', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (8, '视图页面关联 API', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (9, '视图页面分类', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (10, '视图页面', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (11, '视图页面组件', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (12, '视图页面组件关联 API', 2, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (13, '角色关联权限', 3, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (14, '角色', 3, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (15, '用户', 3, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (16, '用户关联角色', 3, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (17, '视图菜单分类', 3, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
INSERT INTO `api_category` VALUES (18, '视图菜单', 3, 0, '', '2018-06-20 14:36:43', '2018-06-20 14:36:43');
COMMIT;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `filename` varchar(255) NOT NULL COMMENT '文件名',
  `file` text COMMENT '文件（路径）',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='附件表';

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `key` varchar(255) NOT NULL COMMENT '字典键',
  `key_name` varchar(255) NOT NULL COMMENT '字典键名',
  `value_name` varchar(255) NOT NULL COMMENT '字典值名',
  `value_slug` varchar(255) NOT NULL COMMENT '字典值别名',
  `value` text COMMENT '字典值',
  `editable` tinyint(1) unsigned DEFAULT NULL COMMENT '是否可编辑（0=不可编辑，1=可编辑，默认=1）',
  `dictionary_category_id` bigint(20) unsigned NOT NULL COMMENT '字典分类 id',
  `sort` bigint(20) unsigned DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='数据字典表';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
BEGIN;
INSERT INTO `dictionary` VALUES (1, 'WEB', '网站字段', '网站名', 'NAME', 'Spiny', 1, 3, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (2, 'WEB', '网站字段', '页脚版权', 'FOOTER', 'Copyright &copy; 2018 Spiny.All rights reserved.', 1, 3, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (3, 'MAIL', '电子邮箱发信配置', '主机', 'HOST', 'smtp.example.com', 1, 4, 0, '腾讯企业邮箱：https://example.com/', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (4, 'MAIL', '电子邮箱发信配置', '协议', 'PROTOCOL', 'smtp', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (5, 'MAIL', '电子邮箱发信配置', '端口号', 'PORT', '25', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (6, 'MAIL', '电子邮箱发信配置', '用户名', 'USERNAME', 'no-reply@example.com', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (7, 'MAIL', '电子邮箱发信配置', '密码', 'PASSWORD', '123456', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (8, 'MAIL', '电子邮箱发信配置', '显示邮箱', 'FROM', 'no-reply@example.com', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (9, 'MAIL', '电子邮箱发信配置', '默认编码', 'DEFAULT_ENCODING', 'UTF-8', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (10, 'MAIL', '电子邮箱发信配置', '测试连接', 'TEST_CONNECTION', 'false', 1, 4, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (11, 'VIEW_PAGE_COMPONENT_TYPE', '视图页面组件类型', '按钮', 'BUTTON', '1', 1, 5, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (12, 'VIEW_PAGE_COMPONENT_TYPE', '视图页面组件类型', '搜索框', 'SEARCH', '2', 1, 5, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (13, 'LOG_LEVEL', '日志级别', '信息', 'INFO', '1', 1, 6, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (14, 'LOG_LEVEL', '日志级别', '警告', 'WARN', '2', 1, 6, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (15, 'LOG_LEVEL', '日志级别', '错误', 'ERROR', '3', 1, 6, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (16, 'SMS_STATUS', '信息状态', '等待', 'WAIT', '1', 1, 7, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (17, 'SMS_STATUS', '信息状态', '成功', 'SUCCESS', '2', 1, 7, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (18, 'SMS_STATUS', '信息状态', '失败', 'FAIL', '3', 1, 7, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (19, 'IS_OR_NOT', '是或否', '否', 'NOT', '0', 1, 8, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (20, 'IS_OR_NOT', '是或否', '是', 'IS', '1', 1, 8, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (21, 'GENDER', '性别', '未知', 'UNKNOWN', '0', 1, 9, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (22, 'GENDER', '性别', '男', 'MALE', '1', 1, 9, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary` VALUES (23, 'GENDER', '性别', '女', 'FEMALE', '2', 1, 9, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
COMMIT;

-- ----------------------------
-- Table structure for dictionary_category
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_category`;
CREATE TABLE `dictionary_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父级分类 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='数据字典分类表';

-- ----------------------------
-- Records of dictionary_category
-- ----------------------------
BEGIN;
INSERT INTO `dictionary_category` VALUES (1, '系统缺省字段', NULL, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (2, '通用缺省字段', NULL, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (3, '网站配置', 1, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (4, '电子邮箱配置', 1, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (5, '视图页面组件类型', 1, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (6, '日志级别', 1, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (7, '信息状态', 1, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (8, '是否可编辑', 2, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (9, '性别', 2, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
INSERT INTO `dictionary_category` VALUES (10, '是否验证', 2, 0, '', '2018-07-08 15:29:33', '2018-07-08 15:29:33');
COMMIT;

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `status` int(1) NOT NULL COMMENT '发信状态',
  `from` varchar(255) DEFAULT NULL COMMENT '发件人',
  `to` varchar(255) DEFAULT NULL COMMENT '收件人',
  `subject` varchar(255) DEFAULT NULL COMMENT '主题',
  `text` text COMMENT '内容',
  `html` int(1) DEFAULT '0' COMMENT '是否为 html，0=否，1=是',
  `error` text COMMENT '发信报错信息',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='电子邮件表';

-- ----------------------------
-- Records of email
-- ----------------------------
BEGIN;
INSERT INTO `email` VALUES (1, 1, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-08 18:15:32', '2018-07-08 18:15:32');
INSERT INTO `email` VALUES (2, 1, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, '', '2018-07-08 18:16:56', '2018-07-08 18:16:56');
INSERT INTO `email` VALUES (3, 2, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, '', '2018-07-08 18:24:18', '2018-07-08 18:23:14');
INSERT INTO `email` VALUES (4, 2, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, '', '2018-07-08 18:33:58', '2018-07-08 18:33:37');
INSERT INTO `email` VALUES (5, 2, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-08 18:36:59', '2018-07-08 18:36:36');
INSERT INTO `email` VALUES (6, 2, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, '', '2018-07-08 18:37:25', '2018-07-08 18:37:03');
INSERT INTO `email` VALUES (7, 3, 'qweqf e', 'qewfqwe f', '', 'wef qwef', NULL, NULL, '', '2018-07-08 22:00:46', '2018-07-08 22:00:46');
INSERT INTO `email` VALUES (8, 3, 'qweqf e', 'qewfqwe f', '', 'wef qwefw', NULL, NULL, '', '2018-07-08 22:00:55', '2018-07-08 22:00:55');
INSERT INTO `email` VALUES (9, 2, 'no-reply@example.com', 'godcheese@example.com', '测试', '测试测试测试测试', 0, NULL, '', '2018-07-08 22:06:47', '2018-07-08 22:06:28');
INSERT INTO `email` VALUES (10, 2, 'no-reply@example.com', 'godcheese@example.com', '测试', '测试哦哦。', 0, NULL, '', '2018-07-08 22:15:27', '2018-07-08 22:15:06');
INSERT INTO `email` VALUES (11, 3, 'fdgff', 'roerfjer', 'ihi', 'wef ewqew', 0, 'Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 501 mail from address must be same as authorization user\n;\n  nested exception is:\n	com.sun.mail.smtp.SMTPSenderFailedException: 501 mail from address must be same as authorization user\n', '', '2018-07-09 21:06:51', '2018-07-09 21:06:51');
INSERT INTO `email` VALUES (12, 3, 'asfwe e', 'wewe', 'ewwe', 'weweew', 0, 'Could not parse mail; nested exception is javax.mail.internet.AddressException: Local address contains control or whitespace in string ``asfwe e\'\'', '', '2018-07-09 21:13:50', '2018-07-09 21:13:50');
INSERT INTO `email` VALUES (13, 3, 'as', 'dwda', '', 'saasdas ', 0, 'Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 501 mail from address must be same as authorization user\n;\n  nested exception is:\n	com.sun.mail.smtp.SMTPSenderFailedException: 501 mail from address must be same as authorization user\n', '', '2018-07-09 21:17:36', '2018-07-09 21:17:36');
INSERT INTO `email` VALUES (14, 3, 'sDvsd', 'ssd', 'sd', 'dsdssd', 0, 'Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 501 mail from address must be same as authorization user\n;\n  nested exception is:\n	com.sun.mail.smtp.SMTPSenderFailedException: 501 mail from address must be same as authorization user\n', '', '2018-07-09 21:21:11', '2018-07-09 21:21:11');
INSERT INTO `email` VALUES (15, 3, 'qw ', 'wew', '', 'wewewe', 0, 'Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 501 mail from address must be same as authorization user\n;\n  nested exception is:\n	com.sun.mail.smtp.SMTPSenderFailedException: 501 mail from address must be same as authorization user\n', '', '2018-07-09 21:21:43', '2018-07-09 21:21:43');
INSERT INTO `email` VALUES (16, 3, 'godcheese@example.com', 'godcheese@example.com', 'ewfwe', 'weewew', 0, 'Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 501 mail from address must be same as authorization user\n;\n  nested exception is:\n	com.sun.mail.smtp.SMTPSenderFailedException: 501 mail from address must be same as authorization user\n', '', '2018-07-09 21:25:47', '2018-07-09 21:25:47');
INSERT INTO `email` VALUES (17, 3, 'no-reply@example.com', 'wef e fwef', 'ef', 'eweww', 0, 'Could not parse mail; nested exception is javax.mail.internet.AddressException: Local address contains control or whitespace in string ``wef e fwef\'\'', '', '2018-07-09 21:26:55', '2018-07-09 21:26:55');
INSERT INTO `email` VALUES (18, 2, 'no-reply@example.com', 'godcheese@example.com', 'ef', 'eweww', 0, NULL, '', '2018-07-09 21:27:35', '2018-07-09 21:27:15');
INSERT INTO `email` VALUES (19, 2, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-11 12:54:46', '2018-07-11 12:54:25');
INSERT INTO `email` VALUES (20, 1, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-11 12:54:26', '2018-07-11 12:54:26');
INSERT INTO `email` VALUES (21, 1, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-11 12:54:45', '2018-07-11 12:54:45');
INSERT INTO `email` VALUES (22, 2, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-11 12:56:54', '2018-07-11 12:56:31');
INSERT INTO `email` VALUES (23, 1, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, NULL, NULL, '2018-07-11 12:56:54', '2018-07-11 12:56:54');
INSERT INTO `email` VALUES (24, 3, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, 'Mail server connection failed; nested exception is com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: smtp.example.com, 25; timeout -1;\n  nested exception is:\n	java.net.UnknownHostException: smtp.example.com. Failed messages: com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: smtp.example.com, 25; timeout -1;\n  nested exception is:\n	java.net.UnknownHostException: smtp.example.com', '', '2018-07-11 19:26:33', '2018-07-11 19:26:33');
INSERT INTO `email` VALUES (26, 3, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, 'Mail server connection failed; nested exception is com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: smtp.example.com, 25; timeout -1;\n  nested exception is:\n	java.net.UnknownHostException: smtp.example.com. Failed messages: com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: smtp.example.com, 25; timeout -1;\n  nested exception is:\n	java.net.UnknownHostException: smtp.example.com', '', '2018-07-16 19:19:14', '2018-07-16 19:19:14');
INSERT INTO `email` VALUES (28, 3, 'no-reply@example.com', 'godcheese@example.com', '2', 'TESTT1111TT', 0, 'Mail server connection failed; nested exception is com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: smtp.example.com, 25; timeout -1;\n  nested exception is:\n	java.net.UnknownHostException: smtp.example.com. Failed messages: com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: smtp.example.com, 25; timeout -1;\n  nested exception is:\n	java.net.UnknownHostException: smtp.example.com', '', '2018-09-04 20:10:30', '2018-09-04 20:10:30');
COMMIT;

-- ----------------------------
-- Table structure for logging_event
-- ----------------------------
DROP TABLE IF EXISTS `logging_event`;
CREATE TABLE `logging_event` (
  `timestmp` bigint(20) NOT NULL,
  `formatted_message` text COLLATE utf8mb4_bin NOT NULL,
  `logger_name` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  `level_string` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  `thread_name` varchar(254) COLLATE utf8mb4_bin DEFAULT NULL,
  `reference_flag` smallint(6) DEFAULT NULL,
  `arg0` varchar(254) COLLATE utf8mb4_bin DEFAULT NULL,
  `arg1` varchar(254) COLLATE utf8mb4_bin DEFAULT NULL,
  `arg2` varchar(254) COLLATE utf8mb4_bin DEFAULT NULL,
  `arg3` varchar(254) COLLATE utf8mb4_bin DEFAULT NULL,
  `caller_filename` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  `caller_class` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  `caller_method` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  `caller_line` char(4) COLLATE utf8mb4_bin NOT NULL,
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`event_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=636 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for logging_event_exception
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_exception`;
CREATE TABLE `logging_event_exception` (
  `event_id` bigint(20) NOT NULL,
  `i` smallint(6) NOT NULL,
  `trace_line` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`event_id`,`i`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for logging_event_property
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_property`;
CREATE TABLE `logging_event_property` (
  `event_id` bigint(20) NOT NULL,
  `mapped_key` varchar(254) COLLATE utf8mb4_bin NOT NULL,
  `mapped_value` text COLLATE utf8mb4_bin,
  PRIMARY KEY (`event_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '操作用户 id',
  `type` tinyint(1) NOT NULL COMMENT '操作类型（0=页面访问，1=API 调用）',
  `method_name` varchar(255) DEFAULT NULL COMMENT '操作方法',
  `operation` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=663 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统操作日志表';

-- ----------------------------
-- Records of operation_log
-- ----------------------------
BEGIN;
INSERT INTO `operation_log` VALUES (1, NULL, 0, 'login', '访问登录页面', '2018-08-06 16:38:26');
INSERT INTO `operation_log` VALUES (2, 3, 0, 'index', '首页', '2018-08-06 16:38:42');
INSERT INTO `operation_log` VALUES (3, 3, 0, 'workbench', '工作台', '2018-08-06 16:38:43');
INSERT INTO `operation_log` VALUES (4, 3, 0, 'pageAll', '操作日志', '2018-08-06 16:47:23');
INSERT INTO `operation_log` VALUES (5, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 16:47:24');
INSERT INTO `operation_log` VALUES (6, 3, 0, 'pageAll', '操作日志', '2018-08-06 16:47:37');
INSERT INTO `operation_log` VALUES (7, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 16:47:37');
INSERT INTO `operation_log` VALUES (8, 3, 0, 'pageAll', '操作日志', '2018-08-06 17:02:18');
INSERT INTO `operation_log` VALUES (9, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 17:02:18');
INSERT INTO `operation_log` VALUES (10, NULL, 0, 'login', '登录页', '2018-08-06 19:58:03');
INSERT INTO `operation_log` VALUES (11, 3, 0, 'index', '首页', '2018-08-06 19:58:19');
INSERT INTO `operation_log` VALUES (12, 3, 0, 'workbench', '工作台', '2018-08-06 19:58:20');
INSERT INTO `operation_log` VALUES (13, 3, 0, 'pageAll', '操作日志', '2018-08-06 19:58:28');
INSERT INTO `operation_log` VALUES (14, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 19:58:29');
INSERT INTO `operation_log` VALUES (15, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 19:58:35');
INSERT INTO `operation_log` VALUES (16, 3, 0, 'pageAll', '操作日志', '2018-08-06 19:59:50');
INSERT INTO `operation_log` VALUES (17, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 19:59:51');
INSERT INTO `operation_log` VALUES (18, 3, 0, 'pageAll', '操作日志', '2018-08-06 20:00:35');
INSERT INTO `operation_log` VALUES (19, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 20:00:36');
INSERT INTO `operation_log` VALUES (20, 3, 0, 'pageAll', '操作日志', '2018-08-06 20:01:07');
INSERT INTO `operation_log` VALUES (21, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 20:01:08');
INSERT INTO `operation_log` VALUES (22, 3, 0, 'pageAll', '操作日志', '2018-08-06 20:02:11');
INSERT INTO `operation_log` VALUES (23, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 20:02:13');
INSERT INTO `operation_log` VALUES (24, 3, 0, 'pageAll', '操作日志', '2018-08-06 20:02:16');
INSERT INTO `operation_log` VALUES (25, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 20:02:18');
INSERT INTO `operation_log` VALUES (26, 3, 0, 'pageAll', '操作日志', '2018-08-06 20:02:46');
INSERT INTO `operation_log` VALUES (27, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-06 20:02:48');
INSERT INTO `operation_log` VALUES (28, NULL, 0, 'login', '登录页', '2018-08-07 08:42:22');
INSERT INTO `operation_log` VALUES (29, 3, 0, 'index', '首页', '2018-08-07 08:42:51');
INSERT INTO `operation_log` VALUES (30, 3, 0, 'workbench', '工作台', '2018-08-07 08:42:51');
INSERT INTO `operation_log` VALUES (31, 3, 0, 'pageAll', '操作日志', '2018-08-07 08:42:55');
INSERT INTO `operation_log` VALUES (32, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 08:42:56');
INSERT INTO `operation_log` VALUES (33, NULL, 0, 'login', '登录页', '2018-08-07 12:31:38');
INSERT INTO `operation_log` VALUES (34, 3, 0, 'index', '首页', '2018-08-07 12:35:44');
INSERT INTO `operation_log` VALUES (35, 3, 0, 'workbench', '工作台', '2018-08-07 12:35:45');
INSERT INTO `operation_log` VALUES (36, NULL, 0, 'login', '登录页', '2018-08-07 20:13:34');
INSERT INTO `operation_log` VALUES (37, 3, 0, 'index', '首页', '2018-08-07 20:17:49');
INSERT INTO `operation_log` VALUES (38, 3, 0, 'workbench', '工作台', '2018-08-07 20:17:50');
INSERT INTO `operation_log` VALUES (39, NULL, 0, 'login', '登录页', '2018-08-07 20:32:27');
INSERT INTO `operation_log` VALUES (40, NULL, 0, 'login', '登录页', '2018-08-07 20:32:32');
INSERT INTO `operation_log` VALUES (41, NULL, 0, 'login', '登录页', '2018-08-07 20:32:37');
INSERT INTO `operation_log` VALUES (42, NULL, 0, 'login', '登录页', '2018-08-07 20:32:42');
INSERT INTO `operation_log` VALUES (43, NULL, 0, 'login', '登录页', '2018-08-07 20:32:47');
INSERT INTO `operation_log` VALUES (44, NULL, 0, 'login', '登录页', '2018-08-07 20:32:52');
INSERT INTO `operation_log` VALUES (45, NULL, 0, 'login', '登录页', '2018-08-07 20:32:57');
INSERT INTO `operation_log` VALUES (46, NULL, 0, 'login', '登录页', '2018-08-07 20:33:02');
INSERT INTO `operation_log` VALUES (47, NULL, 0, 'login', '登录页', '2018-08-07 20:33:07');
INSERT INTO `operation_log` VALUES (48, NULL, 0, 'login', '登录页', '2018-08-07 20:33:12');
INSERT INTO `operation_log` VALUES (49, NULL, 0, 'login', '登录页', '2018-08-07 20:33:17');
INSERT INTO `operation_log` VALUES (50, NULL, 0, 'login', '登录页', '2018-08-07 20:33:22');
INSERT INTO `operation_log` VALUES (51, NULL, 0, 'login', '登录页', '2018-08-07 20:33:27');
INSERT INTO `operation_log` VALUES (52, NULL, 0, 'login', '登录页', '2018-08-07 20:33:32');
INSERT INTO `operation_log` VALUES (53, NULL, 0, 'login', '登录页', '2018-08-07 20:33:37');
INSERT INTO `operation_log` VALUES (54, NULL, 0, 'login', '登录页', '2018-08-07 20:33:42');
INSERT INTO `operation_log` VALUES (55, NULL, 0, 'login', '登录页', '2018-08-07 20:33:47');
INSERT INTO `operation_log` VALUES (56, NULL, 0, 'login', '登录页', '2018-08-07 20:33:52');
INSERT INTO `operation_log` VALUES (57, NULL, 0, 'login', '登录页', '2018-08-07 20:33:57');
INSERT INTO `operation_log` VALUES (58, NULL, 0, 'login', '登录页', '2018-08-07 20:34:02');
INSERT INTO `operation_log` VALUES (59, NULL, 0, 'login', '登录页', '2018-08-07 20:34:07');
INSERT INTO `operation_log` VALUES (60, NULL, 0, 'login', '登录页', '2018-08-07 20:34:12');
INSERT INTO `operation_log` VALUES (61, NULL, 0, 'login', '登录页', '2018-08-07 20:34:18');
INSERT INTO `operation_log` VALUES (62, NULL, 0, 'login', '登录页', '2018-08-07 20:34:22');
INSERT INTO `operation_log` VALUES (63, NULL, 0, 'login', '登录页', '2018-08-07 20:34:27');
INSERT INTO `operation_log` VALUES (64, NULL, 0, 'login', '登录页', '2018-08-07 20:34:32');
INSERT INTO `operation_log` VALUES (65, NULL, 0, 'login', '登录页', '2018-08-07 20:34:38');
INSERT INTO `operation_log` VALUES (66, NULL, 0, 'login', '登录页', '2018-08-07 20:34:42');
INSERT INTO `operation_log` VALUES (67, NULL, 0, 'login', '登录页', '2018-08-07 20:34:47');
INSERT INTO `operation_log` VALUES (68, NULL, 0, 'login', '登录页', '2018-08-07 20:34:52');
INSERT INTO `operation_log` VALUES (69, NULL, 0, 'login', '登录页', '2018-08-07 20:34:57');
INSERT INTO `operation_log` VALUES (70, NULL, 0, 'login', '登录页', '2018-08-07 20:35:02');
INSERT INTO `operation_log` VALUES (71, NULL, 0, 'login', '登录页', '2018-08-07 20:35:07');
INSERT INTO `operation_log` VALUES (72, NULL, 0, 'login', '登录页', '2018-08-07 20:35:12');
INSERT INTO `operation_log` VALUES (73, NULL, 0, 'login', '登录页', '2018-08-07 20:35:17');
INSERT INTO `operation_log` VALUES (74, NULL, 0, 'login', '登录页', '2018-08-07 20:35:22');
INSERT INTO `operation_log` VALUES (75, NULL, 0, 'login', '登录页', '2018-08-07 20:35:27');
INSERT INTO `operation_log` VALUES (76, NULL, 0, 'login', '登录页', '2018-08-07 20:35:32');
INSERT INTO `operation_log` VALUES (77, NULL, 0, 'login', '登录页', '2018-08-07 20:35:37');
INSERT INTO `operation_log` VALUES (78, NULL, 0, 'login', '登录页', '2018-08-07 20:35:42');
INSERT INTO `operation_log` VALUES (79, NULL, 0, 'login', '登录页', '2018-08-07 20:35:47');
INSERT INTO `operation_log` VALUES (80, NULL, 0, 'login', '登录页', '2018-08-07 20:35:52');
INSERT INTO `operation_log` VALUES (81, NULL, 0, 'login', '登录页', '2018-08-07 20:35:57');
INSERT INTO `operation_log` VALUES (82, NULL, 0, 'login', '登录页', '2018-08-07 20:36:02');
INSERT INTO `operation_log` VALUES (83, NULL, 0, 'login', '登录页', '2018-08-07 20:36:07');
INSERT INTO `operation_log` VALUES (84, NULL, 0, 'login', '登录页', '2018-08-07 20:36:12');
INSERT INTO `operation_log` VALUES (85, NULL, 0, 'login', '登录页', '2018-08-07 20:36:17');
INSERT INTO `operation_log` VALUES (86, NULL, 0, 'login', '登录页', '2018-08-07 20:36:22');
INSERT INTO `operation_log` VALUES (87, NULL, 0, 'login', '登录页', '2018-08-07 20:36:27');
INSERT INTO `operation_log` VALUES (88, NULL, 0, 'login', '登录页', '2018-08-07 20:36:32');
INSERT INTO `operation_log` VALUES (89, NULL, 0, 'login', '登录页', '2018-08-07 20:36:37');
INSERT INTO `operation_log` VALUES (90, NULL, 0, 'login', '登录页', '2018-08-07 20:36:42');
INSERT INTO `operation_log` VALUES (91, NULL, 0, 'login', '登录页', '2018-08-07 20:36:47');
INSERT INTO `operation_log` VALUES (92, NULL, 0, 'login', '登录页', '2018-08-07 20:36:52');
INSERT INTO `operation_log` VALUES (93, NULL, 0, 'login', '登录页', '2018-08-07 20:36:57');
INSERT INTO `operation_log` VALUES (94, NULL, 0, 'login', '登录页', '2018-08-07 20:37:02');
INSERT INTO `operation_log` VALUES (95, NULL, 0, 'login', '登录页', '2018-08-07 20:37:07');
INSERT INTO `operation_log` VALUES (96, NULL, 0, 'login', '登录页', '2018-08-07 20:37:12');
INSERT INTO `operation_log` VALUES (97, NULL, 0, 'login', '登录页', '2018-08-07 20:37:17');
INSERT INTO `operation_log` VALUES (98, NULL, 0, 'login', '登录页', '2018-08-07 20:37:22');
INSERT INTO `operation_log` VALUES (99, NULL, 0, 'login', '登录页', '2018-08-07 20:37:27');
INSERT INTO `operation_log` VALUES (100, NULL, 0, 'login', '登录页', '2018-08-07 20:37:32');
INSERT INTO `operation_log` VALUES (101, NULL, 0, 'login', '登录页', '2018-08-07 20:37:37');
INSERT INTO `operation_log` VALUES (102, NULL, 0, 'login', '登录页', '2018-08-07 20:37:42');
INSERT INTO `operation_log` VALUES (103, NULL, 0, 'login', '登录页', '2018-08-07 20:37:47');
INSERT INTO `operation_log` VALUES (104, NULL, 0, 'login', '登录页', '2018-08-07 20:37:52');
INSERT INTO `operation_log` VALUES (105, NULL, 0, 'login', '登录页', '2018-08-07 20:37:57');
INSERT INTO `operation_log` VALUES (106, NULL, 0, 'login', '登录页', '2018-08-07 20:38:02');
INSERT INTO `operation_log` VALUES (107, NULL, 0, 'login', '登录页', '2018-08-07 20:38:07');
INSERT INTO `operation_log` VALUES (108, NULL, 0, 'login', '登录页', '2018-08-07 20:38:12');
INSERT INTO `operation_log` VALUES (109, NULL, 0, 'login', '登录页', '2018-08-07 20:38:17');
INSERT INTO `operation_log` VALUES (110, NULL, 0, 'login', '登录页', '2018-08-07 20:38:22');
INSERT INTO `operation_log` VALUES (111, NULL, 0, 'login', '登录页', '2018-08-07 20:38:27');
INSERT INTO `operation_log` VALUES (112, NULL, 0, 'login', '登录页', '2018-08-07 20:38:32');
INSERT INTO `operation_log` VALUES (113, NULL, 0, 'login', '登录页', '2018-08-07 20:38:37');
INSERT INTO `operation_log` VALUES (114, NULL, 0, 'login', '登录页', '2018-08-07 20:38:42');
INSERT INTO `operation_log` VALUES (115, NULL, 0, 'login', '登录页', '2018-08-07 20:38:47');
INSERT INTO `operation_log` VALUES (116, NULL, 0, 'login', '登录页', '2018-08-07 20:38:52');
INSERT INTO `operation_log` VALUES (117, NULL, 0, 'login', '登录页', '2018-08-07 20:38:57');
INSERT INTO `operation_log` VALUES (118, NULL, 0, 'login', '登录页', '2018-08-07 20:39:02');
INSERT INTO `operation_log` VALUES (119, NULL, 0, 'login', '登录页', '2018-08-07 20:39:07');
INSERT INTO `operation_log` VALUES (120, NULL, 0, 'login', '登录页', '2018-08-07 20:39:12');
INSERT INTO `operation_log` VALUES (121, NULL, 0, 'login', '登录页', '2018-08-07 20:39:17');
INSERT INTO `operation_log` VALUES (122, NULL, 0, 'login', '登录页', '2018-08-07 20:39:22');
INSERT INTO `operation_log` VALUES (123, NULL, 0, 'login', '登录页', '2018-08-07 20:39:27');
INSERT INTO `operation_log` VALUES (124, NULL, 0, 'login', '登录页', '2018-08-07 20:39:32');
INSERT INTO `operation_log` VALUES (125, NULL, 0, 'login', '登录页', '2018-08-07 20:39:37');
INSERT INTO `operation_log` VALUES (126, NULL, 0, 'login', '登录页', '2018-08-07 20:39:42');
INSERT INTO `operation_log` VALUES (127, NULL, 0, 'login', '登录页', '2018-08-07 20:39:47');
INSERT INTO `operation_log` VALUES (128, NULL, 0, 'login', '登录页', '2018-08-07 20:39:52');
INSERT INTO `operation_log` VALUES (129, NULL, 0, 'login', '登录页', '2018-08-07 20:39:57');
INSERT INTO `operation_log` VALUES (130, NULL, 0, 'login', '登录页', '2018-08-07 20:40:02');
INSERT INTO `operation_log` VALUES (131, NULL, 0, 'login', '登录页', '2018-08-07 20:40:07');
INSERT INTO `operation_log` VALUES (132, NULL, 0, 'login', '登录页', '2018-08-07 20:40:12');
INSERT INTO `operation_log` VALUES (133, NULL, 0, 'login', '登录页', '2018-08-07 20:40:17');
INSERT INTO `operation_log` VALUES (134, NULL, 0, 'login', '登录页', '2018-08-07 20:40:22');
INSERT INTO `operation_log` VALUES (135, NULL, 0, 'login', '登录页', '2018-08-07 20:40:27');
INSERT INTO `operation_log` VALUES (136, NULL, 0, 'login', '登录页', '2018-08-07 20:40:32');
INSERT INTO `operation_log` VALUES (137, NULL, 0, 'login', '登录页', '2018-08-07 20:40:37');
INSERT INTO `operation_log` VALUES (138, NULL, 0, 'login', '登录页', '2018-08-07 20:40:42');
INSERT INTO `operation_log` VALUES (139, NULL, 0, 'login', '登录页', '2018-08-07 20:40:47');
INSERT INTO `operation_log` VALUES (140, NULL, 0, 'login', '登录页', '2018-08-07 20:40:52');
INSERT INTO `operation_log` VALUES (141, NULL, 0, 'login', '登录页', '2018-08-07 20:40:57');
INSERT INTO `operation_log` VALUES (142, NULL, 0, 'login', '登录页', '2018-08-07 20:41:02');
INSERT INTO `operation_log` VALUES (143, NULL, 0, 'login', '登录页', '2018-08-07 20:41:07');
INSERT INTO `operation_log` VALUES (144, NULL, 0, 'login', '登录页', '2018-08-07 20:41:12');
INSERT INTO `operation_log` VALUES (145, NULL, 0, 'login', '登录页', '2018-08-07 20:41:17');
INSERT INTO `operation_log` VALUES (146, NULL, 0, 'login', '登录页', '2018-08-07 20:41:22');
INSERT INTO `operation_log` VALUES (147, NULL, 0, 'login', '登录页', '2018-08-07 20:41:27');
INSERT INTO `operation_log` VALUES (148, NULL, 0, 'login', '登录页', '2018-08-07 20:41:32');
INSERT INTO `operation_log` VALUES (149, NULL, 0, 'login', '登录页', '2018-08-07 20:41:37');
INSERT INTO `operation_log` VALUES (150, NULL, 0, 'login', '登录页', '2018-08-07 20:41:42');
INSERT INTO `operation_log` VALUES (151, NULL, 0, 'login', '登录页', '2018-08-07 20:41:47');
INSERT INTO `operation_log` VALUES (152, NULL, 0, 'login', '登录页', '2018-08-07 20:41:52');
INSERT INTO `operation_log` VALUES (153, NULL, 0, 'login', '登录页', '2018-08-07 20:41:57');
INSERT INTO `operation_log` VALUES (154, NULL, 0, 'login', '登录页', '2018-08-07 20:42:02');
INSERT INTO `operation_log` VALUES (155, NULL, 0, 'login', '登录页', '2018-08-07 20:42:07');
INSERT INTO `operation_log` VALUES (156, NULL, 0, 'login', '登录页', '2018-08-07 20:42:12');
INSERT INTO `operation_log` VALUES (157, NULL, 0, 'login', '登录页', '2018-08-07 20:42:17');
INSERT INTO `operation_log` VALUES (158, NULL, 0, 'login', '登录页', '2018-08-07 20:42:22');
INSERT INTO `operation_log` VALUES (159, NULL, 0, 'login', '登录页', '2018-08-07 20:42:27');
INSERT INTO `operation_log` VALUES (160, NULL, 0, 'login', '登录页', '2018-08-07 20:42:32');
INSERT INTO `operation_log` VALUES (161, NULL, 0, 'login', '登录页', '2018-08-07 20:42:37');
INSERT INTO `operation_log` VALUES (162, NULL, 0, 'login', '登录页', '2018-08-07 20:42:42');
INSERT INTO `operation_log` VALUES (163, NULL, 0, 'login', '登录页', '2018-08-07 20:42:47');
INSERT INTO `operation_log` VALUES (164, NULL, 0, 'login', '登录页', '2018-08-07 20:42:52');
INSERT INTO `operation_log` VALUES (165, NULL, 0, 'login', '登录页', '2018-08-07 20:42:57');
INSERT INTO `operation_log` VALUES (166, NULL, 0, 'login', '登录页', '2018-08-07 20:43:02');
INSERT INTO `operation_log` VALUES (167, NULL, 0, 'login', '登录页', '2018-08-07 20:43:07');
INSERT INTO `operation_log` VALUES (168, NULL, 0, 'login', '登录页', '2018-08-07 20:43:12');
INSERT INTO `operation_log` VALUES (169, NULL, 0, 'login', '登录页', '2018-08-07 20:43:17');
INSERT INTO `operation_log` VALUES (170, NULL, 0, 'login', '登录页', '2018-08-07 20:43:22');
INSERT INTO `operation_log` VALUES (171, NULL, 0, 'login', '登录页', '2018-08-07 20:43:27');
INSERT INTO `operation_log` VALUES (172, NULL, 0, 'login', '登录页', '2018-08-07 20:43:32');
INSERT INTO `operation_log` VALUES (173, NULL, 0, 'login', '登录页', '2018-08-07 20:43:37');
INSERT INTO `operation_log` VALUES (174, NULL, 0, 'login', '登录页', '2018-08-07 20:43:42');
INSERT INTO `operation_log` VALUES (175, NULL, 0, 'login', '登录页', '2018-08-07 20:43:47');
INSERT INTO `operation_log` VALUES (176, NULL, 0, 'login', '登录页', '2018-08-07 20:43:52');
INSERT INTO `operation_log` VALUES (177, NULL, 0, 'login', '登录页', '2018-08-07 20:43:57');
INSERT INTO `operation_log` VALUES (178, NULL, 0, 'login', '登录页', '2018-08-07 20:44:02');
INSERT INTO `operation_log` VALUES (179, NULL, 0, 'login', '登录页', '2018-08-07 20:44:07');
INSERT INTO `operation_log` VALUES (180, NULL, 0, 'login', '登录页', '2018-08-07 20:44:12');
INSERT INTO `operation_log` VALUES (181, NULL, 0, 'login', '登录页', '2018-08-07 20:44:17');
INSERT INTO `operation_log` VALUES (182, NULL, 0, 'login', '登录页', '2018-08-07 20:44:22');
INSERT INTO `operation_log` VALUES (183, NULL, 0, 'login', '登录页', '2018-08-07 20:44:27');
INSERT INTO `operation_log` VALUES (184, NULL, 0, 'login', '登录页', '2018-08-07 20:44:29');
INSERT INTO `operation_log` VALUES (185, NULL, 0, 'login', '登录页', '2018-08-07 20:44:29');
INSERT INTO `operation_log` VALUES (186, 3, 0, 'index', '首页', '2018-08-07 20:44:33');
INSERT INTO `operation_log` VALUES (187, 3, 0, 'workbench', '工作台', '2018-08-07 20:44:34');
INSERT INTO `operation_log` VALUES (188, 3, 0, 'pageAll', '操作日志', '2018-08-07 20:44:36');
INSERT INTO `operation_log` VALUES (189, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:36');
INSERT INTO `operation_log` VALUES (190, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:40');
INSERT INTO `operation_log` VALUES (191, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:41');
INSERT INTO `operation_log` VALUES (192, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:42');
INSERT INTO `operation_log` VALUES (193, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:43');
INSERT INTO `operation_log` VALUES (194, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:46');
INSERT INTO `operation_log` VALUES (195, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:51');
INSERT INTO `operation_log` VALUES (196, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:52');
INSERT INTO `operation_log` VALUES (197, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-07 20:44:55');
INSERT INTO `operation_log` VALUES (198, NULL, 0, 'login', '登录页', '2018-08-08 08:49:00');
INSERT INTO `operation_log` VALUES (199, NULL, 0, 'login', '登录页', '2018-08-13 20:50:33');
INSERT INTO `operation_log` VALUES (200, 3, 0, 'index', '首页', '2018-08-13 20:50:36');
INSERT INTO `operation_log` VALUES (201, 3, 0, 'login', '登录页', '2018-08-13 20:50:39');
INSERT INTO `operation_log` VALUES (202, 3, 0, 'index', '首页', '2018-08-13 20:52:16');
INSERT INTO `operation_log` VALUES (203, 3, 0, 'login', '登录页', '2018-08-13 20:52:26');
INSERT INTO `operation_log` VALUES (204, 3, 0, 'login', '登录页', '2018-08-13 20:54:12');
INSERT INTO `operation_log` VALUES (205, 3, 0, 'login', '登录页', '2018-08-13 20:55:54');
INSERT INTO `operation_log` VALUES (206, NULL, 0, 'login', '登录页', '2018-08-14 08:10:31');
INSERT INTO `operation_log` VALUES (207, NULL, 0, 'login', '登录页', '2018-08-15 20:38:00');
INSERT INTO `operation_log` VALUES (208, NULL, 0, 'login', '登录页', '2018-08-15 20:38:03');
INSERT INTO `operation_log` VALUES (209, NULL, 0, 'login', '登录页', '2018-08-15 20:38:04');
INSERT INTO `operation_log` VALUES (210, NULL, 0, 'login', '登录页', '2018-08-15 20:38:06');
INSERT INTO `operation_log` VALUES (211, NULL, 0, 'login', '登录页', '2018-08-15 20:38:06');
INSERT INTO `operation_log` VALUES (212, NULL, 0, 'login', '登录页', '2018-08-15 20:38:15');
INSERT INTO `operation_log` VALUES (213, NULL, 0, 'login', '登录页', '2018-08-15 20:38:15');
INSERT INTO `operation_log` VALUES (214, NULL, 0, 'login', '登录页', '2018-08-15 20:38:16');
INSERT INTO `operation_log` VALUES (215, NULL, 0, 'login', '登录页', '2018-08-15 20:38:16');
INSERT INTO `operation_log` VALUES (216, NULL, 0, 'login', '登录页', '2018-08-15 20:38:31');
INSERT INTO `operation_log` VALUES (217, NULL, 0, 'login', '登录页', '2018-08-15 20:38:31');
INSERT INTO `operation_log` VALUES (218, NULL, 0, 'login', '登录页', '2018-08-15 20:39:36');
INSERT INTO `operation_log` VALUES (219, NULL, 0, 'login', '登录页', '2018-08-15 20:41:58');
INSERT INTO `operation_log` VALUES (220, NULL, 0, 'login', '登录页', '2018-08-15 20:42:16');
INSERT INTO `operation_log` VALUES (221, NULL, 0, 'login', '登录页', '2018-08-15 20:42:19');
INSERT INTO `operation_log` VALUES (222, NULL, 0, 'login', '登录页', '2018-08-15 20:42:19');
INSERT INTO `operation_log` VALUES (223, NULL, 0, 'login', '登录页', '2018-08-15 20:43:22');
INSERT INTO `operation_log` VALUES (224, NULL, 0, 'login', '登录页', '2018-08-15 20:43:36');
INSERT INTO `operation_log` VALUES (225, NULL, 0, 'login', '登录页', '2018-08-15 20:43:51');
INSERT INTO `operation_log` VALUES (226, NULL, 0, 'login', '登录页', '2018-08-15 20:43:53');
INSERT INTO `operation_log` VALUES (227, NULL, 0, 'login', '登录页', '2018-08-15 20:43:56');
INSERT INTO `operation_log` VALUES (228, NULL, 0, 'login', '登录页', '2018-08-15 20:44:20');
INSERT INTO `operation_log` VALUES (229, NULL, 0, 'login', '登录页', '2018-08-15 21:16:33');
INSERT INTO `operation_log` VALUES (230, NULL, 0, 'login', '登录页', '2018-08-15 21:16:42');
INSERT INTO `operation_log` VALUES (231, 3, 0, 'login', '登录页', '2018-08-15 21:18:27');
INSERT INTO `operation_log` VALUES (232, 3, 0, 'login', '登录页', '2018-08-15 21:18:42');
INSERT INTO `operation_log` VALUES (233, 3, 0, 'index', '首页', '2018-08-15 21:18:45');
INSERT INTO `operation_log` VALUES (234, 3, 0, 'index', '首页', '2018-08-15 21:19:03');
INSERT INTO `operation_log` VALUES (235, 3, 0, 'index', '首页', '2018-08-15 21:20:53');
INSERT INTO `operation_log` VALUES (236, 3, 0, 'index', '首页', '2018-08-15 21:20:56');
INSERT INTO `operation_log` VALUES (237, NULL, 0, 'login', '登录页', '2018-08-15 21:27:34');
INSERT INTO `operation_log` VALUES (238, NULL, 0, 'login', '登录页', '2018-08-15 21:27:46');
INSERT INTO `operation_log` VALUES (239, 3, 0, 'index', '首页', '2018-08-15 21:27:49');
INSERT INTO `operation_log` VALUES (240, 3, 0, 'index', '首页', '2018-08-15 21:29:21');
INSERT INTO `operation_log` VALUES (241, 3, 0, 'index', '首页', '2018-08-15 21:29:35');
INSERT INTO `operation_log` VALUES (242, 3, 0, 'index', '首页', '2018-08-15 21:29:51');
INSERT INTO `operation_log` VALUES (243, 3, 0, 'workbench', '工作台', '2018-08-15 21:29:53');
INSERT INTO `operation_log` VALUES (244, 3, 0, 'index', '首页', '2018-08-15 21:30:20');
INSERT INTO `operation_log` VALUES (245, 3, 0, 'workbench', '工作台', '2018-08-15 21:30:21');
INSERT INTO `operation_log` VALUES (246, 3, 0, 'index', '首页', '2018-08-15 21:30:38');
INSERT INTO `operation_log` VALUES (247, 3, 0, 'workbench', '工作台', '2018-08-15 21:30:39');
INSERT INTO `operation_log` VALUES (248, 3, 0, 'index', '首页', '2018-08-15 21:31:21');
INSERT INTO `operation_log` VALUES (249, 3, 0, 'workbench', '工作台', '2018-08-15 21:31:23');
INSERT INTO `operation_log` VALUES (250, 3, 0, 'index', '首页', '2018-08-15 21:31:55');
INSERT INTO `operation_log` VALUES (251, 3, 0, 'workbench', '工作台', '2018-08-15 21:31:56');
INSERT INTO `operation_log` VALUES (252, NULL, 0, 'login', '登录页', '2018-08-16 10:31:32');
INSERT INTO `operation_log` VALUES (253, 3, 0, 'index', '首页', '2018-08-16 10:31:39');
INSERT INTO `operation_log` VALUES (254, 3, 0, 'workbench', '工作台', '2018-08-16 10:31:40');
INSERT INTO `operation_log` VALUES (255, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-16 10:31:51');
INSERT INTO `operation_log` VALUES (256, 3, 0, 'pageAll', '操作日志', '2018-08-16 10:31:57');
INSERT INTO `operation_log` VALUES (257, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-16 10:31:58');
INSERT INTO `operation_log` VALUES (258, NULL, 0, 'login', '登录页', '2018-08-16 10:32:26');
INSERT INTO `operation_log` VALUES (259, NULL, 0, 'index', '首页', '2018-08-27 12:55:34');
INSERT INTO `operation_log` VALUES (260, NULL, 0, 'index', '首页', '2018-08-27 13:02:57');
INSERT INTO `operation_log` VALUES (261, NULL, 0, 'index', '首页', '2018-08-27 15:32:17');
INSERT INTO `operation_log` VALUES (262, NULL, 0, 'index', '首页', '2018-08-27 15:32:18');
INSERT INTO `operation_log` VALUES (263, NULL, 0, 'login', '登录页', '2018-08-27 15:33:25');
INSERT INTO `operation_log` VALUES (264, 3, 0, 'index', '首页', '2018-08-27 15:33:27');
INSERT INTO `operation_log` VALUES (265, 3, 0, 'index', '首页', '2018-08-27 15:34:01');
INSERT INTO `operation_log` VALUES (266, 3, 0, 'login', '登录页', '2018-08-27 15:34:03');
INSERT INTO `operation_log` VALUES (267, 3, 0, 'index', '首页', '2018-08-27 15:34:06');
INSERT INTO `operation_log` VALUES (268, NULL, 0, 'login', '登录控制台', '2018-08-27 16:22:48');
INSERT INTO `operation_log` VALUES (269, NULL, 0, 'login', '登录控制台', '2018-08-27 16:24:11');
INSERT INTO `operation_log` VALUES (270, NULL, 0, 'login', '登录控制台', '2018-08-27 16:24:13');
INSERT INTO `operation_log` VALUES (271, NULL, 0, 'login', '登录控制台', '2018-08-27 16:24:17');
INSERT INTO `operation_log` VALUES (272, NULL, 0, 'login', '登录控制台', '2018-08-27 16:24:45');
INSERT INTO `operation_log` VALUES (273, NULL, 0, 'login', '登录控制台', '2018-08-27 16:24:50');
INSERT INTO `operation_log` VALUES (274, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:11');
INSERT INTO `operation_log` VALUES (275, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:17');
INSERT INTO `operation_log` VALUES (276, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:19');
INSERT INTO `operation_log` VALUES (277, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:30');
INSERT INTO `operation_log` VALUES (278, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:36');
INSERT INTO `operation_log` VALUES (279, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:36');
INSERT INTO `operation_log` VALUES (280, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:38');
INSERT INTO `operation_log` VALUES (281, NULL, 0, 'login', '登录控制台', '2018-08-27 16:25:41');
INSERT INTO `operation_log` VALUES (282, NULL, 0, 'login', '登录控制台', '2018-08-27 16:27:09');
INSERT INTO `operation_log` VALUES (283, NULL, 0, 'login', '登录控制台', '2018-08-27 16:27:55');
INSERT INTO `operation_log` VALUES (284, NULL, 0, 'login', '登录控制台', '2018-08-27 16:29:21');
INSERT INTO `operation_log` VALUES (285, NULL, 0, 'login', '登录控制台', '2018-08-27 16:30:13');
INSERT INTO `operation_log` VALUES (286, NULL, 0, 'login', '登录控制台', '2018-08-27 16:33:00');
INSERT INTO `operation_log` VALUES (287, NULL, 0, 'login', '登录控制台', '2018-08-27 16:33:21');
INSERT INTO `operation_log` VALUES (288, NULL, 0, 'login', '登录控制台', '2018-08-27 16:34:17');
INSERT INTO `operation_log` VALUES (289, NULL, 0, 'login', '登录控制台', '2018-08-27 16:34:22');
INSERT INTO `operation_log` VALUES (290, NULL, 0, 'login', '登录控制台', '2018-08-27 16:34:23');
INSERT INTO `operation_log` VALUES (291, NULL, 0, 'login', '登录控制台', '2018-08-27 16:40:15');
INSERT INTO `operation_log` VALUES (292, NULL, 0, 'login', '登录控制台', '2018-08-27 16:40:58');
INSERT INTO `operation_log` VALUES (293, NULL, 0, 'login', '登录控制台', '2018-08-27 16:46:04');
INSERT INTO `operation_log` VALUES (294, NULL, 0, 'login', '登录控制台', '2018-08-27 16:46:51');
INSERT INTO `operation_log` VALUES (295, NULL, 0, 'login', '登录控制台', '2018-08-27 16:47:48');
INSERT INTO `operation_log` VALUES (296, NULL, 0, 'login', '登录控制台', '2018-08-27 16:47:50');
INSERT INTO `operation_log` VALUES (297, NULL, 0, 'login', '登录控制台', '2018-08-27 17:08:50');
INSERT INTO `operation_log` VALUES (298, NULL, 0, 'login', '登录控制台', '2018-08-27 17:12:16');
INSERT INTO `operation_log` VALUES (299, NULL, 0, 'login', '登录控制台', '2018-08-27 17:12:32');
INSERT INTO `operation_log` VALUES (300, NULL, 0, 'login', '登录控制台', '2018-08-27 17:15:25');
INSERT INTO `operation_log` VALUES (301, NULL, 0, 'login', '登录控制台', '2018-08-27 17:15:33');
INSERT INTO `operation_log` VALUES (302, NULL, 0, 'login', '登录控制台', '2018-08-27 17:15:49');
INSERT INTO `operation_log` VALUES (303, NULL, 0, 'login', '登录控制台', '2018-08-27 17:16:11');
INSERT INTO `operation_log` VALUES (304, NULL, 0, 'login', '登录控制台', '2018-08-27 17:16:16');
INSERT INTO `operation_log` VALUES (305, NULL, 0, 'login', '登录页', '2018-08-30 11:01:48');
INSERT INTO `operation_log` VALUES (306, NULL, 0, 'login', '登录页', '2018-08-30 11:01:49');
INSERT INTO `operation_log` VALUES (307, NULL, 0, 'login', '登录页', '2018-08-30 11:01:53');
INSERT INTO `operation_log` VALUES (308, NULL, 0, 'login', '登录页', '2018-08-30 11:01:53');
INSERT INTO `operation_log` VALUES (309, NULL, 0, 'login', '登录页', '2018-08-30 11:02:36');
INSERT INTO `operation_log` VALUES (310, NULL, 0, 'login', '登录页', '2018-08-30 11:02:36');
INSERT INTO `operation_log` VALUES (311, NULL, 0, 'login', '登录页', '2018-08-30 11:02:39');
INSERT INTO `operation_log` VALUES (312, NULL, 0, 'login', '登录页', '2018-08-30 11:02:39');
INSERT INTO `operation_log` VALUES (313, NULL, 0, 'login', '登录页', '2018-08-30 11:02:41');
INSERT INTO `operation_log` VALUES (314, NULL, 0, 'login', '登录页', '2018-08-30 11:02:41');
INSERT INTO `operation_log` VALUES (315, NULL, 0, 'login', '登录页', '2018-08-30 11:02:42');
INSERT INTO `operation_log` VALUES (316, NULL, 0, 'login', '登录页', '2018-08-30 11:02:42');
INSERT INTO `operation_log` VALUES (317, NULL, 0, 'login', '登录页', '2018-08-30 11:02:43');
INSERT INTO `operation_log` VALUES (318, NULL, 0, 'login', '登录页', '2018-08-30 11:02:43');
INSERT INTO `operation_log` VALUES (319, NULL, 0, 'login', '登录页', '2018-08-30 11:03:50');
INSERT INTO `operation_log` VALUES (320, NULL, 0, 'login', '登录页', '2018-08-30 11:04:16');
INSERT INTO `operation_log` VALUES (321, NULL, 0, 'login', '登录页', '2018-08-30 11:04:43');
INSERT INTO `operation_log` VALUES (322, NULL, 0, 'login', '登录页', '2018-08-30 11:04:53');
INSERT INTO `operation_log` VALUES (323, NULL, 0, 'login', '登录页', '2018-08-30 11:11:59');
INSERT INTO `operation_log` VALUES (324, NULL, 0, 'login', '登录页', '2018-08-30 11:12:03');
INSERT INTO `operation_log` VALUES (325, NULL, 0, 'login', '登录页', '2018-08-30 11:15:18');
INSERT INTO `operation_log` VALUES (326, NULL, 0, 'login', '登录页', '2018-08-30 11:16:34');
INSERT INTO `operation_log` VALUES (327, NULL, 0, 'login', '登录页', '2018-08-30 11:40:43');
INSERT INTO `operation_log` VALUES (328, NULL, 0, 'login', '登录页', '2018-08-30 11:40:44');
INSERT INTO `operation_log` VALUES (329, NULL, 0, 'login', '登录页', '2018-08-30 11:40:50');
INSERT INTO `operation_log` VALUES (330, 3, 0, 'login', '登录页', '2018-08-30 11:42:03');
INSERT INTO `operation_log` VALUES (331, 3, 0, 'login', '登录页', '2018-08-30 11:42:44');
INSERT INTO `operation_log` VALUES (332, 3, 0, 'index', '首页', '2018-08-30 11:42:46');
INSERT INTO `operation_log` VALUES (333, 3, 0, 'workbench', '工作台', '2018-08-30 11:42:48');
INSERT INTO `operation_log` VALUES (334, 3, 0, 'workbench', '工作台', '2018-08-30 11:42:53');
INSERT INTO `operation_log` VALUES (335, 3, 0, 'index', '首页', '2018-08-30 11:42:57');
INSERT INTO `operation_log` VALUES (336, 3, 0, 'index', '首页', '2018-08-30 11:43:04');
INSERT INTO `operation_log` VALUES (337, 3, 0, 'login', '登录页', '2018-08-30 15:04:06');
INSERT INTO `operation_log` VALUES (338, 3, 0, 'index', '首页', '2018-08-30 15:16:55');
INSERT INTO `operation_log` VALUES (339, 3, 0, 'workbench', '工作台', '2018-08-30 15:16:56');
INSERT INTO `operation_log` VALUES (340, 3, 0, 'index', '首页', '2018-08-30 15:16:58');
INSERT INTO `operation_log` VALUES (341, 3, 0, 'index', '首页', '2018-08-30 15:17:01');
INSERT INTO `operation_log` VALUES (342, 3, 0, 'index', '首页', '2018-08-30 15:33:35');
INSERT INTO `operation_log` VALUES (343, 3, 0, 'workbench', '工作台', '2018-08-30 15:33:37');
INSERT INTO `operation_log` VALUES (344, 3, 0, 'test', 'test', '2018-08-30 15:42:00');
INSERT INTO `operation_log` VALUES (345, 3, 0, 'index', '首页', '2018-08-30 15:45:01');
INSERT INTO `operation_log` VALUES (346, 3, 0, 'workbench', '工作台', '2018-08-30 15:45:04');
INSERT INTO `operation_log` VALUES (347, 3, 0, 'index', '首页', '2018-08-30 15:54:01');
INSERT INTO `operation_log` VALUES (348, 3, 0, 'workbench', '工作台', '2018-08-30 15:54:03');
INSERT INTO `operation_log` VALUES (349, 3, 0, 'index', '首页', '2018-08-30 16:01:13');
INSERT INTO `operation_log` VALUES (350, 3, 0, 'index', '首页', '2018-08-30 16:01:13');
INSERT INTO `operation_log` VALUES (351, 3, 0, 'workbench', '工作台', '2018-08-30 16:01:14');
INSERT INTO `operation_log` VALUES (352, 3, 0, 'test', 'test', '2018-08-30 16:01:18');
INSERT INTO `operation_log` VALUES (353, 3, 0, 'test', 'test', '2018-08-30 16:09:12');
INSERT INTO `operation_log` VALUES (354, 3, 0, 'test', 'test', '2018-08-30 16:10:25');
INSERT INTO `operation_log` VALUES (355, 3, 0, 'test', 'test', '2018-08-30 16:17:26');
INSERT INTO `operation_log` VALUES (356, 3, 0, 'index', '首页', '2018-08-30 16:20:38');
INSERT INTO `operation_log` VALUES (357, 3, 0, 'index', '首页', '2018-08-30 16:21:59');
INSERT INTO `operation_log` VALUES (358, 3, 0, 'index', '首页', '2018-08-30 16:22:01');
INSERT INTO `operation_log` VALUES (359, 3, 0, 'workbench', '工作台', '2018-08-30 16:22:01');
INSERT INTO `operation_log` VALUES (360, 3, 0, 'index', '首页', '2018-08-30 16:22:04');
INSERT INTO `operation_log` VALUES (361, 3, 0, 'workbench', '工作台', '2018-08-30 16:22:05');
INSERT INTO `operation_log` VALUES (362, 3, 0, 'test', 'test', '2018-08-30 16:22:09');
INSERT INTO `operation_log` VALUES (363, 3, 0, 'test', 'test', '2018-08-30 16:27:58');
INSERT INTO `operation_log` VALUES (364, 3, 0, 'test', 'test', '2018-08-30 16:33:11');
INSERT INTO `operation_log` VALUES (365, NULL, 0, 'login', '登录页', '2018-08-30 20:33:48');
INSERT INTO `operation_log` VALUES (366, 3, 0, 'index', '首页', '2018-08-30 20:33:53');
INSERT INTO `operation_log` VALUES (367, 3, 0, 'workbench', '工作台', '2018-08-30 20:33:54');
INSERT INTO `operation_log` VALUES (368, NULL, 0, 'login', '登录页', '2018-08-30 20:54:08');
INSERT INTO `operation_log` VALUES (369, 3, 0, 'index', '首页', '2018-08-30 20:54:11');
INSERT INTO `operation_log` VALUES (370, 3, 0, 'workbench', '工作台', '2018-08-30 20:54:12');
INSERT INTO `operation_log` VALUES (371, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-30 20:54:32');
INSERT INTO `operation_log` VALUES (372, 3, 0, 'pageAll', '操作日志', '2018-08-30 20:55:23');
INSERT INTO `operation_log` VALUES (373, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-30 20:55:23');
INSERT INTO `operation_log` VALUES (374, NULL, 0, 'login', '登录页', '2018-08-30 21:01:18');
INSERT INTO `operation_log` VALUES (375, NULL, 0, 'login', '登录页', '2018-08-30 21:01:19');
INSERT INTO `operation_log` VALUES (376, 3, 0, 'index', '首页', '2018-08-30 21:01:22');
INSERT INTO `operation_log` VALUES (377, 3, 0, 'workbench', '工作台', '2018-08-30 21:01:23');
INSERT INTO `operation_log` VALUES (378, 3, 0, 'index', '首页', '2018-08-30 21:01:31');
INSERT INTO `operation_log` VALUES (379, 3, 0, 'workbench', '工作台', '2018-08-30 21:01:31');
INSERT INTO `operation_log` VALUES (380, NULL, 0, 'login', '登录页', '2018-08-31 07:55:06');
INSERT INTO `operation_log` VALUES (381, 3, 0, 'index', '首页', '2018-08-31 07:55:12');
INSERT INTO `operation_log` VALUES (382, 3, 0, 'workbench', '工作台', '2018-08-31 07:55:13');
INSERT INTO `operation_log` VALUES (383, 3, 0, 'index', '首页', '2018-08-31 07:56:43');
INSERT INTO `operation_log` VALUES (384, 3, 0, 'workbench', '工作台', '2018-08-31 07:56:44');
INSERT INTO `operation_log` VALUES (385, 3, 0, 'login', '登录页', '2018-08-31 08:01:34');
INSERT INTO `operation_log` VALUES (386, 3, 0, 'index', '首页', '2018-08-31 08:01:39');
INSERT INTO `operation_log` VALUES (387, 3, 0, 'workbench', '工作台', '2018-08-31 08:01:40');
INSERT INTO `operation_log` VALUES (388, 3, 0, 'index', '首页', '2018-08-31 08:09:29');
INSERT INTO `operation_log` VALUES (389, 3, 0, 'workbench', '工作台', '2018-08-31 08:09:30');
INSERT INTO `operation_log` VALUES (390, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-31 08:09:34');
INSERT INTO `operation_log` VALUES (391, 3, 0, 'index', '首页', '2018-08-31 08:24:18');
INSERT INTO `operation_log` VALUES (392, 3, 0, 'workbench', '工作台', '2018-08-31 08:24:20');
INSERT INTO `operation_log` VALUES (393, 3, 0, 'index', '首页', '2018-08-31 08:26:37');
INSERT INTO `operation_log` VALUES (394, 3, 0, 'workbench', '工作台', '2018-08-31 08:26:38');
INSERT INTO `operation_log` VALUES (395, 3, 0, 'index', '首页', '2018-08-31 08:45:56');
INSERT INTO `operation_log` VALUES (396, 3, 0, 'workbench', '工作台', '2018-08-31 08:45:58');
INSERT INTO `operation_log` VALUES (397, 3, 0, 'index', '首页', '2018-08-31 08:55:39');
INSERT INTO `operation_log` VALUES (398, 3, 0, 'workbench', '工作台', '2018-08-31 08:55:40');
INSERT INTO `operation_log` VALUES (399, 3, 0, 'index', '首页', '2018-08-31 09:36:33');
INSERT INTO `operation_log` VALUES (400, 3, 0, 'workbench', '工作台', '2018-08-31 09:36:34');
INSERT INTO `operation_log` VALUES (401, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-31 09:36:42');
INSERT INTO `operation_log` VALUES (402, NULL, 0, 'login', '登录页', '2018-08-31 09:36:50');
INSERT INTO `operation_log` VALUES (403, 3, 0, 'index', '首页', '2018-08-31 09:36:52');
INSERT INTO `operation_log` VALUES (404, 3, 0, 'workbench', '工作台', '2018-08-31 09:36:52');
INSERT INTO `operation_log` VALUES (405, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-31 09:36:54');
INSERT INTO `operation_log` VALUES (406, 3, 0, 'pageAll', '操作日志', '2018-08-31 09:36:58');
INSERT INTO `operation_log` VALUES (407, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:36:58');
INSERT INTO `operation_log` VALUES (408, 3, 0, 'pageAll', '操作日志', '2018-08-31 09:38:27');
INSERT INTO `operation_log` VALUES (409, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:27');
INSERT INTO `operation_log` VALUES (410, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:36');
INSERT INTO `operation_log` VALUES (411, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:37');
INSERT INTO `operation_log` VALUES (412, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:38');
INSERT INTO `operation_log` VALUES (413, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:39');
INSERT INTO `operation_log` VALUES (414, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:39');
INSERT INTO `operation_log` VALUES (415, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:40');
INSERT INTO `operation_log` VALUES (416, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:46');
INSERT INTO `operation_log` VALUES (417, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:47');
INSERT INTO `operation_log` VALUES (418, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:47');
INSERT INTO `operation_log` VALUES (419, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:48');
INSERT INTO `operation_log` VALUES (420, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:48');
INSERT INTO `operation_log` VALUES (421, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:38:49');
INSERT INTO `operation_log` VALUES (422, NULL, 0, 'login', '登录页', '2018-08-31 09:38:56');
INSERT INTO `operation_log` VALUES (423, NULL, 0, 'login', '登录页', '2018-08-31 09:51:56');
INSERT INTO `operation_log` VALUES (424, 3, 0, 'index', '首页', '2018-08-31 09:51:59');
INSERT INTO `operation_log` VALUES (425, 3, 0, 'workbench', '工作台', '2018-08-31 09:52:00');
INSERT INTO `operation_log` VALUES (426, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-31 09:52:02');
INSERT INTO `operation_log` VALUES (427, 3, 0, 'pageAll', '操作日志', '2018-08-31 09:52:09');
INSERT INTO `operation_log` VALUES (428, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-08-31 09:52:09');
INSERT INTO `operation_log` VALUES (429, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-31 09:52:29');
INSERT INTO `operation_log` VALUES (430, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-08-31 09:52:34');
INSERT INTO `operation_log` VALUES (431, NULL, 0, 'login', '登录页', '2018-08-31 09:53:02');
INSERT INTO `operation_log` VALUES (432, NULL, 0, 'login', '登录页', '2018-08-31 09:54:44');
INSERT INTO `operation_log` VALUES (433, NULL, 0, 'login', '登录页', '2018-08-31 09:59:12');
INSERT INTO `operation_log` VALUES (434, 3, 0, 'index', '首页', '2018-08-31 09:59:14');
INSERT INTO `operation_log` VALUES (435, 3, 0, 'workbench', '工作台', '2018-08-31 09:59:15');
INSERT INTO `operation_log` VALUES (436, NULL, 0, 'login', '登录页', '2018-08-31 09:59:19');
INSERT INTO `operation_log` VALUES (437, NULL, 0, 'login', '登录页', '2018-08-31 10:02:38');
INSERT INTO `operation_log` VALUES (438, 3, 0, 'index', '首页', '2018-08-31 10:02:49');
INSERT INTO `operation_log` VALUES (439, 3, 0, 'workbench', '工作台', '2018-08-31 10:02:49');
INSERT INTO `operation_log` VALUES (440, 3, 0, 'index', '首页', '2018-08-31 10:19:28');
INSERT INTO `operation_log` VALUES (441, 3, 0, 'workbench', '工作台', '2018-08-31 10:19:29');
INSERT INTO `operation_log` VALUES (442, 3, 0, 'index', '首页', '2018-08-31 10:20:16');
INSERT INTO `operation_log` VALUES (443, 3, 0, 'workbench', '工作台', '2018-08-31 10:20:17');
INSERT INTO `operation_log` VALUES (444, 3, 0, 'index', '首页', '2018-08-31 10:20:17');
INSERT INTO `operation_log` VALUES (445, 3, 0, 'workbench', '工作台', '2018-08-31 10:20:18');
INSERT INTO `operation_log` VALUES (446, 3, 0, 'index', '首页', '2018-08-31 10:20:18');
INSERT INTO `operation_log` VALUES (447, 3, 0, 'workbench', '工作台', '2018-08-31 10:20:19');
INSERT INTO `operation_log` VALUES (448, 3, 0, 'index', '首页', '2018-08-31 10:20:21');
INSERT INTO `operation_log` VALUES (449, 3, 0, 'workbench', '工作台', '2018-08-31 10:20:21');
INSERT INTO `operation_log` VALUES (450, 3, 0, 'index', '首页', '2018-08-31 10:20:26');
INSERT INTO `operation_log` VALUES (451, 3, 0, 'workbench', '工作台', '2018-08-31 10:20:26');
INSERT INTO `operation_log` VALUES (452, 3, 0, 'index', '首页', '2018-08-31 10:20:30');
INSERT INTO `operation_log` VALUES (453, 3, 0, 'workbench', '工作台', '2018-08-31 10:20:30');
INSERT INTO `operation_log` VALUES (454, 3, 0, 'index', '首页', '2018-08-31 10:22:04');
INSERT INTO `operation_log` VALUES (455, 3, 0, 'workbench', '工作台', '2018-08-31 10:22:05');
INSERT INTO `operation_log` VALUES (456, 3, 0, 'index', '首页', '2018-08-31 10:22:07');
INSERT INTO `operation_log` VALUES (457, 3, 0, 'workbench', '工作台', '2018-08-31 10:22:08');
INSERT INTO `operation_log` VALUES (458, 3, 0, 'index', '首页', '2018-08-31 10:22:09');
INSERT INTO `operation_log` VALUES (459, 3, 0, 'workbench', '工作台', '2018-08-31 10:22:09');
INSERT INTO `operation_log` VALUES (460, 3, 0, 'index', '首页', '2018-08-31 10:22:33');
INSERT INTO `operation_log` VALUES (461, 3, 0, 'workbench', '工作台', '2018-08-31 10:22:33');
INSERT INTO `operation_log` VALUES (462, 3, 0, 'index', '首页', '2018-08-31 10:23:01');
INSERT INTO `operation_log` VALUES (463, 3, 0, 'workbench', '工作台', '2018-08-31 10:23:02');
INSERT INTO `operation_log` VALUES (464, 3, 0, 'index', '首页', '2018-08-31 10:23:15');
INSERT INTO `operation_log` VALUES (465, 3, 0, 'workbench', '工作台', '2018-08-31 10:23:15');
INSERT INTO `operation_log` VALUES (466, 3, 0, 'index', '首页', '2018-08-31 10:23:16');
INSERT INTO `operation_log` VALUES (467, 3, 0, 'workbench', '工作台', '2018-08-31 10:23:16');
INSERT INTO `operation_log` VALUES (468, NULL, 0, 'login', '登录页', '2018-09-01 13:04:10');
INSERT INTO `operation_log` VALUES (469, NULL, 0, 'login', '登录页', '2018-09-01 13:04:17');
INSERT INTO `operation_log` VALUES (470, 3, 0, 'index', '首页', '2018-09-01 13:04:54');
INSERT INTO `operation_log` VALUES (471, 3, 0, 'workbench', '工作台', '2018-09-01 13:04:55');
INSERT INTO `operation_log` VALUES (472, 3, 0, 'login', '登录页', '2018-09-01 13:04:56');
INSERT INTO `operation_log` VALUES (473, 3, 0, 'login', '登录页', '2018-09-01 13:05:52');
INSERT INTO `operation_log` VALUES (474, 3, 0, 'index', '首页', '2018-09-01 13:05:58');
INSERT INTO `operation_log` VALUES (475, 3, 0, 'workbench', '工作台', '2018-09-01 13:05:58');
INSERT INTO `operation_log` VALUES (476, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-01 13:06:45');
INSERT INTO `operation_log` VALUES (477, NULL, 0, 'login', '登录页', '2018-09-01 13:14:48');
INSERT INTO `operation_log` VALUES (478, 3, 0, 'index', '首页', '2018-09-01 13:14:52');
INSERT INTO `operation_log` VALUES (479, 3, 0, 'workbench', '工作台', '2018-09-01 13:14:53');
INSERT INTO `operation_log` VALUES (480, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-01 13:15:12');
INSERT INTO `operation_log` VALUES (481, NULL, 0, 'login', '登录页', '2018-09-04 19:52:59');
INSERT INTO `operation_log` VALUES (482, 3, 0, 'index', '首页', '2018-09-04 19:53:02');
INSERT INTO `operation_log` VALUES (483, 3, 0, 'workbench', '工作台', '2018-09-04 19:53:02');
INSERT INTO `operation_log` VALUES (484, 3, 0, 'index', '首页', '2018-09-04 19:55:58');
INSERT INTO `operation_log` VALUES (485, 3, 0, 'workbench', '工作台', '2018-09-04 19:55:59');
INSERT INTO `operation_log` VALUES (486, 3, 0, 'index', '首页', '2018-09-04 19:56:06');
INSERT INTO `operation_log` VALUES (487, 3, 0, 'workbench', '工作台', '2018-09-04 19:56:07');
INSERT INTO `operation_log` VALUES (488, 3, 0, 'index', '首页', '2018-09-04 20:09:12');
INSERT INTO `operation_log` VALUES (489, 3, 0, 'workbench', '工作台', '2018-09-04 20:09:14');
INSERT INTO `operation_log` VALUES (490, 3, 0, 'index', '首页', '2018-09-04 20:09:33');
INSERT INTO `operation_log` VALUES (491, 3, 0, 'workbench', '工作台', '2018-09-04 20:09:34');
INSERT INTO `operation_log` VALUES (492, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-04 20:21:35');
INSERT INTO `operation_log` VALUES (493, NULL, 0, 'login', '登录页', '2018-09-17 20:21:56');
INSERT INTO `operation_log` VALUES (494, 3, 0, 'index', '首页', '2018-09-17 20:22:00');
INSERT INTO `operation_log` VALUES (495, 3, 0, 'workbench', '工作台', '2018-09-17 20:22:01');
INSERT INTO `operation_log` VALUES (496, NULL, 0, 'login', '登录页', '2018-09-17 20:25:05');
INSERT INTO `operation_log` VALUES (497, 3, 0, 'index', '首页', '2018-09-17 20:25:08');
INSERT INTO `operation_log` VALUES (498, 3, 0, 'workbench', '工作台', '2018-09-17 20:25:09');
INSERT INTO `operation_log` VALUES (499, NULL, 0, 'login', '登录页', '2018-09-18 11:48:01');
INSERT INTO `operation_log` VALUES (500, 3, 0, 'index', '首页', '2018-09-18 11:48:05');
INSERT INTO `operation_log` VALUES (501, 3, 0, 'workbench', '工作台', '2018-09-18 11:48:06');
INSERT INTO `operation_log` VALUES (502, NULL, 0, 'login', '登录页', '2018-09-18 11:51:00');
INSERT INTO `operation_log` VALUES (503, NULL, 0, 'login', '登录页', '2018-09-18 12:55:13');
INSERT INTO `operation_log` VALUES (504, 3, 0, 'index', '首页', '2018-09-18 12:55:23');
INSERT INTO `operation_log` VALUES (505, 3, 0, 'workbench', '工作台', '2018-09-18 12:55:23');
INSERT INTO `operation_log` VALUES (506, NULL, 0, 'login', '登录页', '2018-09-18 12:59:51');
INSERT INTO `operation_log` VALUES (507, 3, 0, 'index', '首页', '2018-09-18 12:59:55');
INSERT INTO `operation_log` VALUES (508, 3, 0, 'workbench', '工作台', '2018-09-18 12:59:56');
INSERT INTO `operation_log` VALUES (509, NULL, 0, 'login', '登录页', '2018-09-18 13:02:34');
INSERT INTO `operation_log` VALUES (510, 3, 0, 'index', '首页', '2018-09-18 13:02:36');
INSERT INTO `operation_log` VALUES (511, 3, 0, 'workbench', '工作台', '2018-09-18 13:02:37');
INSERT INTO `operation_log` VALUES (512, NULL, 0, 'login', '登录页', '2018-09-18 13:03:54');
INSERT INTO `operation_log` VALUES (513, 3, 0, 'index', '首页', '2018-09-18 13:04:22');
INSERT INTO `operation_log` VALUES (514, 3, 0, 'workbench', '工作台', '2018-09-18 13:04:23');
INSERT INTO `operation_log` VALUES (515, 3, 0, 'index', '首页', '2018-09-18 13:06:30');
INSERT INTO `operation_log` VALUES (516, 3, 0, 'workbench', '工作台', '2018-09-18 13:06:32');
INSERT INTO `operation_log` VALUES (517, 3, 0, 'index', '首页', '2018-09-18 14:07:29');
INSERT INTO `operation_log` VALUES (518, 3, 0, 'workbench', '工作台', '2018-09-18 14:07:31');
INSERT INTO `operation_log` VALUES (519, NULL, 0, 'login', '登录页', '2018-09-18 14:11:22');
INSERT INTO `operation_log` VALUES (520, 3, 0, 'index', '首页', '2018-09-18 14:11:24');
INSERT INTO `operation_log` VALUES (521, 3, 0, 'workbench', '工作台', '2018-09-18 14:11:25');
INSERT INTO `operation_log` VALUES (522, NULL, 0, 'login', '登录页', '2018-09-18 14:17:37');
INSERT INTO `operation_log` VALUES (523, 3, 0, 'index', '首页', '2018-09-18 14:17:40');
INSERT INTO `operation_log` VALUES (524, 3, 0, 'workbench', '工作台', '2018-09-18 14:17:41');
INSERT INTO `operation_log` VALUES (525, NULL, 0, 'login', '登录页', '2018-09-18 14:19:07');
INSERT INTO `operation_log` VALUES (526, 3, 0, 'index', '首页', '2018-09-18 14:19:09');
INSERT INTO `operation_log` VALUES (527, 3, 0, 'workbench', '工作台', '2018-09-18 14:19:10');
INSERT INTO `operation_log` VALUES (528, NULL, 0, 'login', '登录页', '2018-09-18 14:21:17');
INSERT INTO `operation_log` VALUES (529, NULL, 0, 'login', '登录页', '2018-09-18 14:23:05');
INSERT INTO `operation_log` VALUES (530, 3, 0, 'index', '首页', '2018-09-18 14:23:08');
INSERT INTO `operation_log` VALUES (531, 3, 0, 'workbench', '工作台', '2018-09-18 14:23:09');
INSERT INTO `operation_log` VALUES (532, NULL, 0, 'login', '登录页', '2018-09-18 14:31:10');
INSERT INTO `operation_log` VALUES (533, 3, 0, 'index', '首页', '2018-09-18 14:31:19');
INSERT INTO `operation_log` VALUES (534, 3, 0, 'workbench', '工作台', '2018-09-18 14:31:19');
INSERT INTO `operation_log` VALUES (535, NULL, 0, 'login', '登录页', '2018-09-18 14:33:56');
INSERT INTO `operation_log` VALUES (536, 3, 0, 'index', '首页', '2018-09-18 14:33:58');
INSERT INTO `operation_log` VALUES (537, 3, 0, 'workbench', '工作台', '2018-09-18 14:33:58');
INSERT INTO `operation_log` VALUES (538, NULL, 0, 'login', '登录页', '2018-09-18 14:38:15');
INSERT INTO `operation_log` VALUES (539, 3, 0, 'index', '首页', '2018-09-18 14:38:20');
INSERT INTO `operation_log` VALUES (540, 3, 0, 'workbench', '工作台', '2018-09-18 14:38:21');
INSERT INTO `operation_log` VALUES (541, NULL, 0, 'login', '登录页', '2018-09-18 14:40:17');
INSERT INTO `operation_log` VALUES (542, 3, 0, 'index', '首页', '2018-09-18 14:40:21');
INSERT INTO `operation_log` VALUES (543, 3, 0, 'workbench', '工作台', '2018-09-18 14:40:22');
INSERT INTO `operation_log` VALUES (544, NULL, 0, 'login', '登录页', '2018-09-18 14:44:21');
INSERT INTO `operation_log` VALUES (545, 3, 0, 'index', '首页', '2018-09-18 14:44:23');
INSERT INTO `operation_log` VALUES (546, 3, 0, 'workbench', '工作台', '2018-09-18 14:44:24');
INSERT INTO `operation_log` VALUES (547, NULL, 0, 'login', '登录页', '2018-09-18 14:45:51');
INSERT INTO `operation_log` VALUES (548, 3, 0, 'index', '首页', '2018-09-18 14:45:53');
INSERT INTO `operation_log` VALUES (549, 3, 0, 'workbench', '工作台', '2018-09-18 14:45:54');
INSERT INTO `operation_log` VALUES (550, 3, 0, 'index', '首页', '2018-09-18 16:00:09');
INSERT INTO `operation_log` VALUES (551, 3, 0, 'workbench', '工作台', '2018-09-18 16:00:10');
INSERT INTO `operation_log` VALUES (552, 3, 0, 'index', '首页', '2018-09-18 16:00:23');
INSERT INTO `operation_log` VALUES (553, 3, 0, 'workbench', '工作台', '2018-09-18 16:00:24');
INSERT INTO `operation_log` VALUES (554, NULL, 0, 'login', '登录页', '2018-09-18 16:03:28');
INSERT INTO `operation_log` VALUES (555, 3, 0, 'index', '首页', '2018-09-18 16:03:40');
INSERT INTO `operation_log` VALUES (556, 3, 0, 'workbench', '工作台', '2018-09-18 16:03:40');
INSERT INTO `operation_log` VALUES (557, NULL, 0, 'login', '登录页', '2018-09-18 16:08:49');
INSERT INTO `operation_log` VALUES (558, 3, 0, 'index', '首页', '2018-09-18 16:09:03');
INSERT INTO `operation_log` VALUES (559, 3, 0, 'workbench', '工作台', '2018-09-18 16:09:04');
INSERT INTO `operation_log` VALUES (560, NULL, 0, 'login', '登录页', '2018-09-22 09:04:22');
INSERT INTO `operation_log` VALUES (561, 3, 0, 'index', '首页', '2018-09-22 09:04:26');
INSERT INTO `operation_log` VALUES (562, 3, 0, 'workbench', '工作台', '2018-09-22 09:04:27');
INSERT INTO `operation_log` VALUES (563, 3, 0, 'pageAll', '操作日志', '2018-09-22 09:04:31');
INSERT INTO `operation_log` VALUES (564, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:04:32');
INSERT INTO `operation_log` VALUES (565, 3, 0, 'index', '首页', '2018-09-22 09:05:28');
INSERT INTO `operation_log` VALUES (566, 3, 0, 'workbench', '工作台', '2018-09-22 09:05:28');
INSERT INTO `operation_log` VALUES (567, 3, 0, 'pageAll', '操作日志', '2018-09-22 09:06:27');
INSERT INTO `operation_log` VALUES (568, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:28');
INSERT INTO `operation_log` VALUES (569, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:30');
INSERT INTO `operation_log` VALUES (570, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:30');
INSERT INTO `operation_log` VALUES (571, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:31');
INSERT INTO `operation_log` VALUES (572, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:31');
INSERT INTO `operation_log` VALUES (573, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:32');
INSERT INTO `operation_log` VALUES (574, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:32');
INSERT INTO `operation_log` VALUES (575, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:33');
INSERT INTO `operation_log` VALUES (576, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:33');
INSERT INTO `operation_log` VALUES (577, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:34');
INSERT INTO `operation_log` VALUES (578, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-22 09:06:34');
INSERT INTO `operation_log` VALUES (579, NULL, 0, 'login', '登录页', '2018-09-24 18:42:05');
INSERT INTO `operation_log` VALUES (580, 3, 0, 'index', '首页', '2018-09-24 18:42:08');
INSERT INTO `operation_log` VALUES (581, 3, 0, 'workbench', '工作台', '2018-09-24 18:42:09');
INSERT INTO `operation_log` VALUES (582, 3, 0, 'index', '首页', '2018-09-24 19:43:19');
INSERT INTO `operation_log` VALUES (583, 3, 0, 'workbench', '工作台', '2018-09-24 19:43:22');
INSERT INTO `operation_log` VALUES (584, NULL, 0, 'login', '登录页', '2018-09-24 19:43:31');
INSERT INTO `operation_log` VALUES (585, 3, 0, 'index', '首页', '2018-09-24 19:43:42');
INSERT INTO `operation_log` VALUES (586, 3, 0, 'workbench', '工作台', '2018-09-24 19:43:43');
INSERT INTO `operation_log` VALUES (587, NULL, 0, 'login', '登录页', '2018-09-24 19:46:07');
INSERT INTO `operation_log` VALUES (588, 3, 0, 'index', '首页', '2018-09-24 19:46:10');
INSERT INTO `operation_log` VALUES (589, 3, 0, 'workbench', '工作台', '2018-09-24 19:46:11');
INSERT INTO `operation_log` VALUES (590, 3, 0, 'index', '首页', '2018-09-24 19:53:00');
INSERT INTO `operation_log` VALUES (591, 3, 0, 'workbench', '工作台', '2018-09-24 19:53:02');
INSERT INTO `operation_log` VALUES (592, NULL, 0, 'login', '登录页', '2018-09-24 20:12:26');
INSERT INTO `operation_log` VALUES (593, 3, 0, 'index', '首页', '2018-09-24 20:12:29');
INSERT INTO `operation_log` VALUES (594, 3, 0, 'workbench', '工作台', '2018-09-24 20:12:31');
INSERT INTO `operation_log` VALUES (595, 3, 0, 'index', '首页', '2018-09-24 20:21:39');
INSERT INTO `operation_log` VALUES (596, 3, 0, 'workbench', '工作台', '2018-09-24 20:21:41');
INSERT INTO `operation_log` VALUES (597, 3, 0, 'pageAll', '操作日志', '2018-09-24 20:22:00');
INSERT INTO `operation_log` VALUES (598, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-24 20:22:01');
INSERT INTO `operation_log` VALUES (599, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-24 20:22:15');
INSERT INTO `operation_log` VALUES (600, NULL, 0, 'login', '登录页', '2018-09-25 12:00:27');
INSERT INTO `operation_log` VALUES (601, 3, 0, 'index', '首页', '2018-09-25 12:00:32');
INSERT INTO `operation_log` VALUES (602, 3, 0, 'workbench', '工作台', '2018-09-25 12:00:33');
INSERT INTO `operation_log` VALUES (603, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-25 12:00:41');
INSERT INTO `operation_log` VALUES (604, 3, 0, 'pageAll', '操作日志', '2018-09-25 12:00:54');
INSERT INTO `operation_log` VALUES (605, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-25 12:00:55');
INSERT INTO `operation_log` VALUES (606, 3, 0, 'index', '首页', '2018-09-25 12:12:14');
INSERT INTO `operation_log` VALUES (607, 3, 0, 'workbench', '工作台', '2018-09-25 12:12:17');
INSERT INTO `operation_log` VALUES (608, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-25 12:13:07');
INSERT INTO `operation_log` VALUES (609, 3, 0, 'index', '首页', '2018-09-25 12:13:12');
INSERT INTO `operation_log` VALUES (610, 3, 0, 'workbench', '工作台', '2018-09-25 12:13:13');
INSERT INTO `operation_log` VALUES (611, 3, 0, 'index', '首页', '2018-09-25 12:13:15');
INSERT INTO `operation_log` VALUES (612, 3, 0, 'workbench', '工作台', '2018-09-25 12:13:15');
INSERT INTO `operation_log` VALUES (613, 3, 0, 'workbench', '工作台', '2018-09-25 12:13:20');
INSERT INTO `operation_log` VALUES (614, 3, 0, 'index', '首页', '2018-09-25 12:13:23');
INSERT INTO `operation_log` VALUES (615, NULL, 0, 'login', '登录页', '2018-09-25 14:28:30');
INSERT INTO `operation_log` VALUES (616, NULL, 0, 'login', '登录页', '2018-09-25 14:33:37');
INSERT INTO `operation_log` VALUES (617, 3, 0, 'index', '首页', '2018-09-25 14:33:40');
INSERT INTO `operation_log` VALUES (618, 3, 0, 'workbench', '工作台', '2018-09-25 14:33:41');
INSERT INTO `operation_log` VALUES (619, 3, 0, 'index', '首页', '2018-09-25 14:33:45');
INSERT INTO `operation_log` VALUES (620, NULL, 0, 'login', '登录页', '2018-09-25 14:35:13');
INSERT INTO `operation_log` VALUES (621, 3, 0, 'index', '首页', '2018-09-25 14:35:15');
INSERT INTO `operation_log` VALUES (622, 3, 0, 'workbench', '工作台', '2018-09-25 14:35:16');
INSERT INTO `operation_log` VALUES (623, 3, 0, 'index', '首页', '2018-09-25 14:38:29');
INSERT INTO `operation_log` VALUES (624, 3, 0, 'index', '首页', '2018-09-25 14:38:32');
INSERT INTO `operation_log` VALUES (625, 3, 0, 'workbench', '工作台', '2018-09-25 14:38:33');
INSERT INTO `operation_log` VALUES (626, 3, 0, 'index', '首页', '2018-09-25 14:38:36');
INSERT INTO `operation_log` VALUES (627, 3, 0, 'index', '首页', '2018-09-25 14:39:02');
INSERT INTO `operation_log` VALUES (628, 3, 0, 'workbench', '工作台', '2018-09-25 14:39:03');
INSERT INTO `operation_log` VALUES (629, NULL, 0, 'login', '登录页', '2018-09-25 14:46:56');
INSERT INTO `operation_log` VALUES (630, 3, 0, 'index', '首页', '2018-09-25 14:46:59');
INSERT INTO `operation_log` VALUES (631, 3, 0, 'workbench', '工作台', '2018-09-25 14:46:59');
INSERT INTO `operation_log` VALUES (632, 3, 0, 'index', '首页', '2018-09-25 14:47:21');
INSERT INTO `operation_log` VALUES (633, 3, 0, 'login', '登录页', '2018-09-25 14:57:53');
INSERT INTO `operation_log` VALUES (634, NULL, 0, 'login', '登录页', '2018-09-25 19:30:25');
INSERT INTO `operation_log` VALUES (635, 3, 0, 'index', '首页', '2018-09-25 19:30:42');
INSERT INTO `operation_log` VALUES (636, 3, 0, 'workbench', '工作台', '2018-09-25 19:30:43');
INSERT INTO `operation_log` VALUES (637, 3, 0, 'index', '首页', '2018-09-25 19:34:37');
INSERT INTO `operation_log` VALUES (638, 3, 0, 'workbench', '工作台', '2018-09-25 19:34:38');
INSERT INTO `operation_log` VALUES (639, 3, 0, 'index', '首页', '2018-09-25 19:37:00');
INSERT INTO `operation_log` VALUES (640, 3, 0, 'workbench', '工作台', '2018-09-25 19:37:01');
INSERT INTO `operation_log` VALUES (641, NULL, 0, 'login', '登录页', '2018-09-25 19:38:15');
INSERT INTO `operation_log` VALUES (642, NULL, 0, 'login', '登录页', '2018-09-25 19:46:49');
INSERT INTO `operation_log` VALUES (643, NULL, 0, 'login', '登录页', '2018-09-25 19:47:51');
INSERT INTO `operation_log` VALUES (644, NULL, 0, 'login', '登录页', '2018-09-25 19:49:19');
INSERT INTO `operation_log` VALUES (645, NULL, 0, 'login', '登录页', '2018-09-25 20:00:17');
INSERT INTO `operation_log` VALUES (646, 3, 0, 'index', '首页', '2018-09-25 20:00:29');
INSERT INTO `operation_log` VALUES (647, 3, 0, 'workbench', '工作台', '2018-09-25 20:00:30');
INSERT INTO `operation_log` VALUES (648, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-25 20:01:03');
INSERT INTO `operation_log` VALUES (649, 3, 0, 'index', '首页', '2018-09-25 20:11:51');
INSERT INTO `operation_log` VALUES (650, 3, 0, 'workbench', '工作台', '2018-09-25 20:11:54');
INSERT INTO `operation_log` VALUES (651, 3, 0, 'pageAll', '操作日志', '2018-09-25 20:12:03');
INSERT INTO `operation_log` VALUES (652, 3, 1, 'pageAll', '分页获取所有操作日志', '2018-09-25 20:12:04');
INSERT INTO `operation_log` VALUES (653, 3, 1, 'pageAllParent', '分页获取所有父级 API 分类', '2018-09-25 20:12:42');
INSERT INTO `operation_log` VALUES (654, 3, 0, 'index', '首页', '2018-09-25 20:16:07');
INSERT INTO `operation_log` VALUES (655, 3, 0, 'workbench', '工作台', '2018-09-25 20:16:09');
INSERT INTO `operation_log` VALUES (656, NULL, 0, 'login', '登录页', '2018-09-25 20:16:14');
INSERT INTO `operation_log` VALUES (657, 3, 0, 'index', '首页', '2018-09-25 20:16:16');
INSERT INTO `operation_log` VALUES (658, 3, 0, 'workbench', '工作台', '2018-09-25 20:16:18');
INSERT INTO `operation_log` VALUES (659, NULL, 0, 'login', '登录页', '2018-09-26 08:53:32');
INSERT INTO `operation_log` VALUES (660, 3, 0, 'index', '首页', '2018-09-26 08:53:35');
INSERT INTO `operation_log` VALUES (661, 3, 0, 'workbench', '工作台', '2018-09-26 08:53:35');
INSERT INTO `operation_log` VALUES (662, NULL, 0, 'login', '登录页', '2018-09-26 08:53:51');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `value` varchar(191) NOT NULL COMMENT '角色值',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_value` (`value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '普通用户', 'NORMAL_USER', '', '2018-06-27 21:22:40', '2018-06-27 21:22:40');
INSERT INTO `role` VALUES (2, '管理员', 'ADMIN', '', '2018-06-27 21:22:40', '2018-06-27 21:22:40');
INSERT INTO `role` VALUES (3, '系统管理员', 'SYSTEM_ADMIN', '', '2018-06-27 21:22:40', '2018-06-27 21:22:40');
COMMIT;

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色 id',
  `authority` varchar(255) NOT NULL COMMENT '权限（authority）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色关联权限表';

-- ----------------------------
-- Records of role_authority
-- ----------------------------
BEGIN;
INSERT INTO `role_authority` VALUES (1, 2, '/');
INSERT INTO `role_authority` VALUES (2, 2, '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_CHILD_VIEW_MENU_CATEGORY_AND_VIEW_MENU_BY_PARENT_ID_AND_USER_ID');
INSERT INTO `role_authority` VALUES (3, 2, '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_CHILD_BY_PARENT_ID_AND_USER_ID');
INSERT INTO `role_authority` VALUES (4, 2, '/API/USER/VIEW_MENU_CATEGORY/LIST_ALL_PARENT_BY_USER_ID');
INSERT INTO `role_authority` VALUES (5, 2, '/SYSTEM/WORKBENCH');
INSERT INTO `role_authority` VALUES (6, 2, '/SYSTEM/VIEW_PAGE/PAGE_ALL');
INSERT INTO `role_authority` VALUES (7, 2, '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/ADD');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `username` varchar(191) DEFAULT NULL COMMENT '用户名',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `email_is_verified` tinyint(1) unsigned DEFAULT NULL COMMENT '电子邮箱是否验证通过（0=未验证，1=已验证，默认=0）',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门 id',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_deleted` datetime DEFAULT NULL COMMENT '删除时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '$2a$10$2ASJsYX1q5AMjHCji6DkrOt/mmS4D1nCXwnUW4kt.n/FvONR6Kjiq', 'normal_user', 'godcheese@example.com', 1, 1, '测试备注', NULL, '2018-06-27 21:22:40', '2018-06-27 21:22:40');
INSERT INTO `user` VALUES (2, '$2a$10$2ASJsYX1q5AMjHCji6DkrOt/mmS4D1nCXwnUW4kt.n/FvONR6Kjiq', 'admin', '10000@example.com', 1, 1, '测试备注', NULL, '2018-06-27 21:22:40', '2018-06-27 21:22:40');
INSERT INTO `user` VALUES (3, '$2a$10$2ASJsYX1q5AMjHCji6DkrOt/mmS4D1nCXwnUW4kt.n/FvONR6Kjiq', 'system_admin', 'godcheese@example.com', 1, 1, '测试备注', NULL, '2018-06-27 21:22:40', '2018-06-27 21:22:40');
COMMIT;

-- ----------------------------
-- Table structure for user_password_reset
-- ----------------------------
DROP TABLE IF EXISTS `user_password_reset`;
CREATE TABLE `user_password_reset` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户 id',
  `verify_from` varchar(191) NOT NULL COMMENT '用户绑定的电子邮箱或手机号码',
  `verify_code` varchar(191) NOT NULL COMMENT '电子邮箱或手机号码验证码',
  `gmt_expires` datetime NOT NULL COMMENT '过期时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_user_id` (`user_id`) USING BTREE,
  UNIQUE KEY `uk_verify_from` (`verify_from`) USING BTREE,
  UNIQUE KEY `uk_verify_code` (`verify_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户密码重置表';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户 id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色 id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户关联角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 3);
COMMIT;

-- ----------------------------
-- Table structure for view_menu
-- ----------------------------
DROP TABLE IF EXISTS `view_menu`;
CREATE TABLE `view_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图标（icon）',
  `url` text COMMENT '请求地址（url）',
  `menu_category_id` bigint(20) unsigned NOT NULL COMMENT '菜单分类 id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图菜单表';

-- ----------------------------
-- Records of view_menu
-- ----------------------------
BEGIN;
INSERT INTO `view_menu` VALUES (1, 'API 管理', '', '/system/api/page_all', 2, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu` VALUES (2, '数据字典', '', '/system/dictionary/page_all', 2, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu` VALUES (3, '视图页面管理', '', '/system/view_page/page_all', 2, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu` VALUES (4, 'Druid Monitor', '', '/druid', 2, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu` VALUES (5, '用户管理', '', '/user/page_all', 3, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu` VALUES (6, '角色管理', '', '/user/role/page_all', 3, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu` VALUES (7, '发送邮件', '', '/system/email/send', 4, 3, 0, '', '2018-07-08 13:20:28', '2018-07-08 13:20:28');
INSERT INTO `view_menu` VALUES (8, '邮件队列', '', '/system/email/page_all_queue', 4, 3, 0, '', '2018-07-08 14:58:59', '2018-07-08 13:22:30');
INSERT INTO `view_menu` VALUES (9, '操作日志', '', '/system/operation_log/page_all', 2, 3, 0, '', '2018-08-06 16:47:15', '2018-08-06 16:47:15');
COMMIT;

-- ----------------------------
-- Table structure for view_menu_category
-- ----------------------------
DROP TABLE IF EXISTS `view_menu_category`;
CREATE TABLE `view_menu_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图标（icon）',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级分类 id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图菜单分类表';

-- ----------------------------
-- Records of view_menu_category
-- ----------------------------
BEGIN;
INSERT INTO `view_menu_category` VALUES (1, '系统管理', 'fa fa-cog', NULL, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu_category` VALUES (2, '系统配置', 'fa fa-cog', 1, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu_category` VALUES (3, '用户配置', 'fa fa-user', 1, 3, 0, '', '2018-07-01 21:28:04', '2018-07-01 21:28:04');
INSERT INTO `view_menu_category` VALUES (4, '电子邮箱', '', 2, 3, 0, '', '2018-07-08 13:19:57', '2018-07-08 13:19:57');
COMMIT;

-- ----------------------------
-- Table structure for view_page
-- ----------------------------
DROP TABLE IF EXISTS `view_page`;
CREATE TABLE `view_page` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '页面名称',
  `url` text COMMENT '请求地址（url）',
  `authority` varchar(191) NOT NULL COMMENT '权限（authority）',
  `page_category_id` bigint(20) unsigned NOT NULL COMMENT '页面分类 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_authority` (`authority`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图页面表';

-- ----------------------------
-- Records of view_page
-- ----------------------------
BEGIN;
INSERT INTO `view_page` VALUES (1, '系统首页1', '/', '/', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (2, '系统首页2', '/index', '/INDEX', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (3, '系统首页2', '/system', '/SYSTEM', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (4, '系统首页3', '/system/index', '/SYSTEM/INDEX', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (5, '工作台', '/system/workbench', '/SYSTEM/WORKBENCH', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (6, '视图页面管理', '/system/view_page/page_all', '/SYSTEM/VIEW_PAGE/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (7, '视图页面关联 API', '/system/view_page_api/page_all', '/SYSTEM/VIEW_PAGE_API/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (8, '视图页面组件关联 API', '/system/view_page_component_api/page_all', '/SYSTEM/VIEW_PAGE_COMPONENT_API/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (9, 'API 管理', '/system/api/page_all', '/SYSTEM/API/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (10, '数据字典', '/system/dictionary/page_all', '/SYSTEM/DICTIONARY/PAGE_ALL', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (11, 'Druid Monitor', '/druid', '/DRUID', 2, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (12, '用户管理', '/user/page_all', '/USER/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (13, '角色管理', '/user/role/page_all', '/USER/ROLE/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (14, '角色 API 权限管理', '/user/role_authority/api/page_all', '/USER/ROLE_AUTHORITY/API/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (15, '角色视图页面管理', '/user/role_authority/view_page/page_all', '/USER/ROLE_AUTHORITY/VIEW_PAGE/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (16, '用户角色管理', '/user/user_role/page_all', '/USER/USER_ROLE/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (17, '视图菜单管理', '/user/view_menu/page_all', '/USER/VIEW_MENU/PAGE_ALL', 3, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page` VALUES (18, '发送邮件', '/system/email/send', '/SYSTEM/EMAIL/SEND', 4, 0, '', '2018-07-08 13:16:32', '2018-07-08 13:16:32');
INSERT INTO `view_page` VALUES (19, '邮件队列', '/system/email/page_all_queue', '/SYSTEM/EMAIL/PAGE_ALL_QUEUE', 4, 0, '', '2018-07-08 14:59:14', '2018-07-08 13:17:38');
COMMIT;

-- ----------------------------
-- Table structure for view_page_api
-- ----------------------------
DROP TABLE IF EXISTS `view_page_api`;
CREATE TABLE `view_page_api` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `page_id` bigint(20) unsigned NOT NULL COMMENT '视图页面 id',
  `api_id` bigint(20) unsigned NOT NULL COMMENT 'API id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图页面关联 API 表';

-- ----------------------------
-- Records of view_page_api
-- ----------------------------
BEGIN;
INSERT INTO `view_page_api` VALUES (1, 1, 77);
INSERT INTO `view_page_api` VALUES (2, 1, 78);
INSERT INTO `view_page_api` VALUES (3, 1, 79);
INSERT INTO `view_page_api` VALUES (4, 2, 77);
INSERT INTO `view_page_api` VALUES (5, 2, 78);
INSERT INTO `view_page_api` VALUES (6, 2, 79);
INSERT INTO `view_page_api` VALUES (7, 3, 77);
INSERT INTO `view_page_api` VALUES (8, 3, 78);
INSERT INTO `view_page_api` VALUES (9, 3, 79);
INSERT INTO `view_page_api` VALUES (10, 4, 77);
INSERT INTO `view_page_api` VALUES (11, 4, 78);
INSERT INTO `view_page_api` VALUES (12, 4, 79);
INSERT INTO `view_page_api` VALUES (13, 6, 28);
INSERT INTO `view_page_api` VALUES (14, 6, 29);
INSERT INTO `view_page_api` VALUES (15, 6, 34);
INSERT INTO `view_page_api` VALUES (16, 6, 39);
INSERT INTO `view_page_api` VALUES (17, 6, 24);
INSERT INTO `view_page_api` VALUES (18, 7, 1);
INSERT INTO `view_page_api` VALUES (19, 7, 2);
INSERT INTO `view_page_api` VALUES (20, 7, 25);
INSERT INTO `view_page_api` VALUES (21, 8, 1);
INSERT INTO `view_page_api` VALUES (22, 8, 2);
INSERT INTO `view_page_api` VALUES (23, 8, 7);
INSERT INTO `view_page_api` VALUES (24, 8, 44);
INSERT INTO `view_page_api` VALUES (25, 9, 1);
INSERT INTO `view_page_api` VALUES (26, 9, 2);
INSERT INTO `view_page_api` VALUES (27, 9, 7);
INSERT INTO `view_page_api` VALUES (28, 10, 12);
INSERT INTO `view_page_api` VALUES (29, 10, 13);
INSERT INTO `view_page_api` VALUES (30, 10, 18);
INSERT INTO `view_page_api` VALUES (31, 10, 24);
INSERT INTO `view_page_api` VALUES (32, 12, 24);
INSERT INTO `view_page_api` VALUES (33, 12, 60);
INSERT INTO `view_page_api` VALUES (34, 16, 59);
INSERT INTO `view_page_api` VALUES (35, 14, 1);
INSERT INTO `view_page_api` VALUES (36, 14, 2);
INSERT INTO `view_page_api` VALUES (37, 14, 52);
INSERT INTO `view_page_api` VALUES (38, 15, 28);
INSERT INTO `view_page_api` VALUES (39, 15, 29);
INSERT INTO `view_page_api` VALUES (40, 15, 52);
INSERT INTO `view_page_api` VALUES (41, 15, 39);
INSERT INTO `view_page_api` VALUES (42, 17, 70);
INSERT INTO `view_page_api` VALUES (43, 17, 71);
INSERT INTO `view_page_api` VALUES (44, 17, 82);
INSERT INTO `view_page_api` VALUES (45, 17, 81);
INSERT INTO `view_page_api` VALUES (46, 17, 87);
INSERT INTO `view_page_api` VALUES (48, 15, 34);
COMMIT;

-- ----------------------------
-- Table structure for view_page_category
-- ----------------------------
DROP TABLE IF EXISTS `view_page_category`;
CREATE TABLE `view_page_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级分类 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图页面分类表';

-- ----------------------------
-- Records of view_page_category
-- ----------------------------
BEGIN;
INSERT INTO `view_page_category` VALUES (1, '系统管理', NULL, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page_category` VALUES (2, '系统配置', 1, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page_category` VALUES (3, '用户配置', 1, 0, '', '2018-07-01 18:52:40', '2018-07-01 18:52:40');
INSERT INTO `view_page_category` VALUES (4, '电子邮箱', 2, 0, '', '2018-07-08 13:12:23', '2018-07-08 13:12:23');
COMMIT;

-- ----------------------------
-- Table structure for view_page_component
-- ----------------------------
DROP TABLE IF EXISTS `view_page_component`;
CREATE TABLE `view_page_component` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `page_component_type` tinyint(2) NOT NULL COMMENT '组件类型 id',
  `name` varchar(255) NOT NULL COMMENT '组件名称',
  `authority` varchar(191) NOT NULL COMMENT '权限（authority）',
  `page_id` bigint(20) unsigned NOT NULL COMMENT '视图页面 id',
  `sort` bigint(20) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_authority` (`authority`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图页面组件表';

-- ----------------------------
-- Records of view_page_component
-- ----------------------------
BEGIN;
INSERT INTO `view_page_component` VALUES (1, 1, '新增', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_CATEGORY_ADD_DIALOG', 6, 0, '新增视图页面分类', '2018-07-01 19:14:28', '2018-07-01 19:14:28');
INSERT INTO `view_page_component` VALUES (2, 1, '编辑', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_CATEGORY_EDIT_DIALOG', 6, 0, '编辑视图页面分类', '2018-07-01 19:17:39', '2018-07-01 19:17:39');
INSERT INTO `view_page_component` VALUES (3, 1, '删除', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_CATEGORY_DELETE_ALL', 6, 0, '删除视图页面分类', '2018-07-01 19:18:11', '2018-07-01 19:18:11');
INSERT INTO `view_page_component` VALUES (4, 1, '新增', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_ADD_DIALOG', 6, 0, '新增视图页面', '2018-07-01 19:19:40', '2018-07-01 19:19:40');
INSERT INTO `view_page_component` VALUES (5, 1, '复制新增', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_COPY_ADD_DIALOG', 6, 0, '复制新增视图页面', '2018-07-01 19:20:44', '2018-07-01 19:20:44');
INSERT INTO `view_page_component` VALUES (6, 1, '编辑', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_EDIT_DIALOG', 6, 0, '编辑视图页面', '2018-07-01 19:30:34', '2018-07-01 19:30:34');
INSERT INTO `view_page_component` VALUES (7, 1, '删除', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_DELETE_ALL', 6, 0, '删除视图页面', '2018-07-01 19:30:56', '2018-07-01 19:30:56');
INSERT INTO `view_page_component` VALUES (8, 1, '关联 API', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_API_DIALOG', 6, 0, '视图页面关联 API', '2018-07-01 19:32:27', '2018-07-01 19:32:27');
INSERT INTO `view_page_component` VALUES (9, 1, '新增', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_COMPONENT_ADD_DIALOG', 6, 0, '新增视图页面组件', '2018-07-01 19:33:06', '2018-07-01 19:33:06');
INSERT INTO `view_page_component` VALUES (10, 1, '复制新增', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_COMPONENT_COPY_ADD_DIALOG', 6, 0, '复制新增视图页面组件', '2018-07-01 19:33:42', '2018-07-01 19:33:42');
INSERT INTO `view_page_component` VALUES (11, 1, '编辑', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_COMPONENT_EDIT_DIALOG', 6, 0, '编辑视图页面组件', '2018-07-01 19:34:07', '2018-07-01 19:34:07');
INSERT INTO `view_page_component` VALUES (12, 1, '删除', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_COMPONENT_DELETE_ALL', 6, 0, '删除视图页面组件', '2018-07-01 19:35:50', '2018-07-01 19:35:50');
INSERT INTO `view_page_component` VALUES (13, 1, '关联 API', '/COMPONENT/SYSTEM/VIEW_PAGE/PAGE_ALL/VIEW_PAGE_COMPONENT_API_DIALOG', 6, 0, '视图页面组件关联 API', '2018-07-01 19:36:27', '2018-07-01 19:36:27');
INSERT INTO `view_page_component` VALUES (14, 1, '关联', '/COMPONENT/SYSTEM/VIEW_PAGE_API/PAGE_ALL/ASSOCIATE_ALL_VIEW_PAGE_API', 7, 0, '', '2018-07-03 12:59:22', '2018-07-03 12:57:37');
INSERT INTO `view_page_component` VALUES (15, 1, '撤销关联', '/COMPONENT/SYSTEM/VIEW_PAGE_API/PAGE_ALL/REVOKE_ASSOCIATE_ALL_VIEW_PAGE_API', 7, 0, '', '2018-07-03 12:59:16', '2018-07-03 12:59:16');
INSERT INTO `view_page_component` VALUES (16, 1, '关联', '/COMPONENT/SYSTEM/VIEW_PAGE_COMPONENT_API/PAGE_ALL/ASSOCIATE_ALL_VIEW_PAGE_COMPONENT_API', 8, 0, '', '2018-07-03 13:00:28', '2018-07-03 13:00:28');
INSERT INTO `view_page_component` VALUES (17, 1, '撤销关联', '/COMPONENT/SYSTEM/VIEW_PAGE_COMPONENT_API/PAGE_ALL/REVOKE_ASSOCIATE_ALL_VIEW_PAGE_COMPONENT_API', 8, 0, '', '2018-07-03 13:00:42', '2018-07-03 13:00:42');
INSERT INTO `view_page_component` VALUES (18, 1, '新增', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_CATEGORY_ADD_DIALOG', 9, 0, '新增 API 分类', '2018-07-03 13:07:51', '2018-07-03 13:07:51');
INSERT INTO `view_page_component` VALUES (19, 1, '编辑', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_CATEGORY_EDIT_DIALOG', 9, 0, '编辑 API 分类', '2018-07-03 13:08:17', '2018-07-03 13:08:17');
INSERT INTO `view_page_component` VALUES (20, 1, '删除', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_CATEGORY_DELETE_ALL', 9, 0, '删除 API 分类', '2018-07-03 13:08:36', '2018-07-03 13:08:36');
INSERT INTO `view_page_component` VALUES (21, 1, '新增', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_ADD_DIALOG', 9, 0, '新增 API', '2018-07-03 13:09:21', '2018-07-03 13:09:21');
INSERT INTO `view_page_component` VALUES (22, 1, '复制新增', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_COPY_ADD_DIALOG', 9, 0, '复制新增 API', '2018-07-03 13:09:36', '2018-07-03 13:09:36');
INSERT INTO `view_page_component` VALUES (23, 1, '编辑', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_EDIT_DIALOG', 9, 0, '编辑 API', '2018-07-03 13:09:55', '2018-07-03 13:09:55');
INSERT INTO `view_page_component` VALUES (24, 1, '删除', '/COMPONENT/SYSTEM/API/PAGE_ALL/API_DELETE_ALL', 9, 0, '删除 API', '2018-07-03 13:10:08', '2018-07-03 13:10:08');
INSERT INTO `view_page_component` VALUES (25, 1, '新增', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_CATEGORY_ADD_DIALOG', 10, 0, '新增字典分类', '2018-07-03 15:25:33', '2018-07-03 15:25:33');
INSERT INTO `view_page_component` VALUES (26, 1, '编辑', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_CATEGORY_EDIT_DIALOG', 10, 0, '编辑字典分类', '2018-07-03 15:25:58', '2018-07-03 15:25:58');
INSERT INTO `view_page_component` VALUES (27, 1, '删除', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_CATEGORY_DELETE_ALL', 10, 0, '删除字典分类', '2018-07-03 15:26:18', '2018-07-03 15:26:18');
INSERT INTO `view_page_component` VALUES (28, 1, '新增', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_ADD_DIALOG', 10, 0, '新增字典', '2018-07-03 15:26:37', '2018-07-03 15:26:37');
INSERT INTO `view_page_component` VALUES (29, 1, '复制新增', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_COPY_ADD_DIALOG', 10, 0, '复制新增字典', '2018-07-03 15:26:56', '2018-07-03 15:26:56');
INSERT INTO `view_page_component` VALUES (30, 1, '编辑', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_EDIT_DIALOG', 10, 0, '编辑字典', '2018-07-03 15:27:18', '2018-07-03 15:27:18');
INSERT INTO `view_page_component` VALUES (31, 1, '删除', '/COMPONENT/SYSTEM/DICTIONARY/PAGE_ALL/DICTIONARY_DELETE_ALL', 10, 0, '删除字典', '2018-07-03 15:27:32', '2018-07-03 15:27:32');
INSERT INTO `view_page_component` VALUES (32, 1, '新增', '/COMPONENT/USER/PAGE_ALL/USER_ADD_DIALOG', 12, 0, '', '2018-07-03 20:29:52', '2018-07-03 20:29:52');
INSERT INTO `view_page_component` VALUES (33, 1, '编辑', '/COMPONENT/USER/PAGE_ALL/USER_EDIT_DIALOG', 12, 0, '', '2018-07-03 20:30:18', '2018-07-03 20:30:18');
INSERT INTO `view_page_component` VALUES (34, 1, '删除', '/COMPONENT/USER/PAGE_ALL/USER_SIGN_ALL_GMT_DELETED', 12, 0, '标记 gmt_deleted 不为空，可撤销删除', '2018-07-03 20:32:47', '2018-07-03 20:31:36');
INSERT INTO `view_page_component` VALUES (35, 1, '撤销删除', '/COMPONENT/USER/PAGE_ALL/USER_UNSIGN_ALL_GMT_DELETED', 12, 0, '标记 gmt_deleted 为空，撤销删除', '2018-07-03 20:32:32', '2018-07-03 20:32:32');
INSERT INTO `view_page_component` VALUES (36, 1, '永久删除', '/COMPONENT/USER/PAGE_ALL/USER_DELETE_ALL', 12, 0, '永久删除，不可撤销删除', '2018-07-03 20:33:45', '2018-07-03 20:33:45');
INSERT INTO `view_page_component` VALUES (37, 1, '角色管理', '/COMPONENT/USER/PAGE_ALL/USER_ROLE_DIALOG', 12, 0, '角色管理，可为指定用户新增或删除角色', '2018-07-03 20:35:12', '2018-07-03 20:35:12');
INSERT INTO `view_page_component` VALUES (38, 1, '授权用户角色', '/COMPONENT/USER/USER_ROLE/PAGE_ALL/USER_ROLE_ADD_DIALOG', 16, 0, '', '2018-07-03 20:41:51', '2018-07-03 20:41:51');
INSERT INTO `view_page_component` VALUES (39, 1, '撤销授权用户角色', '/COMPONENT/USER/USER_ROLE/PAGE_ALL/USER_ROLE_DELETE_ALL', 16, 0, '', '2018-07-03 20:42:22', '2018-07-03 20:42:22');
INSERT INTO `view_page_component` VALUES (40, 1, '新增', '/COMPONENT/USER/ROLE/PAGE_ALL/ROLE_ADD_DIALOG', 13, 0, '', '2018-07-03 20:45:22', '2018-07-03 20:45:22');
INSERT INTO `view_page_component` VALUES (41, 1, '编辑', '/COMPONENT/USER/ROLE/PAGE_ALL/ROLE_EDIT_DIALOG', 13, 0, '', '2018-07-03 20:45:53', '2018-07-03 20:45:53');
INSERT INTO `view_page_component` VALUES (42, 1, '删除', '/COMPONENT/USER/ROLE/PAGE_ALL/ROLE_DELETE_ALL', 13, 0, '', '2018-07-03 20:46:24', '2018-07-03 20:46:24');
INSERT INTO `view_page_component` VALUES (43, 1, '视图菜单管理', '/COMPONENT/USER/ROLE/PAGE_ALL/VIEW_MENU_DIALOG', 13, 0, '', '2018-07-03 20:46:58', '2018-07-03 20:46:58');
INSERT INTO `view_page_component` VALUES (44, 1, '视图页面权限管理', '/COMPONENT/USER/ROLE/PAGE_ALL/ROLE_AUTHORITY_VIEW_PAGE_DIALOG', 13, 0, '', '2018-07-03 20:47:35', '2018-07-03 20:47:35');
INSERT INTO `view_page_component` VALUES (45, 1, 'API 权限管理', '/COMPONENT/USER/ROLE/PAGE_ALL/ROLE_AUTHORITY_API_DIALOG', 13, 0, '', '2018-07-03 20:48:00', '2018-07-03 20:48:00');
INSERT INTO `view_page_component` VALUES (46, 1, '授权', '/COMPONENT/USER/ROLE_AUTHORITY/API/PAGE_ALL/GRANT_ALL_ROLE_AUTHORITY_API', 14, 0, '', '2018-07-03 20:51:20', '2018-07-03 20:51:20');
INSERT INTO `view_page_component` VALUES (47, 1, '撤销授权', '/COMPONENT/USER/ROLE_AUTHORITY/API/PAGE_ALL/REVOKE_ALL_ROLE_AUTHORITY_API', 14, 0, '', '2018-07-03 20:51:48', '2018-07-03 20:51:48');
INSERT INTO `view_page_component` VALUES (48, 1, '授权', '/COMPONENT/USER/ROLE_AUTHORITY/VIEW_PAGE/PAGE_ALL/GRANT_ALL_ROLE_AUTHORITY_VIEW_PAGE', 15, 0, '授权视图页面权限（authority）', '2018-07-03 21:31:49', '2018-07-03 20:52:32');
INSERT INTO `view_page_component` VALUES (49, 1, '撤销授权', '/COMPONENT/USER/ROLE_AUTHORITY/VIEW_PAGE/PAGE_ALL/REVOKE_ALL_ROLE_AUTHORITY_VIEW_PAGE', 15, 0, '撤销授权视图页面权限（authority）', '2018-07-03 21:31:57', '2018-07-03 20:52:54');
INSERT INTO `view_page_component` VALUES (50, 1, '新增', '/COMPONENT/USER/VIEW_MENU/PAGE_ALL/VIEW_MENU_CATEGORY_ADD_DIALOG', 17, 0, '新增视图菜单分类', '2018-07-03 20:54:19', '2018-07-03 20:54:19');
INSERT INTO `view_page_component` VALUES (51, 1, '编辑', '/COMPONENT/USER/VIEW_MENU/PAGE_ALL/VIEW_MENU_CATEGORY_EDIT_DIALOG', 17, 0, '编辑视图菜单分类', '2018-07-03 20:54:44', '2018-07-03 20:54:44');
INSERT INTO `view_page_component` VALUES (52, 1, '删除', '/COMPONENT/USER/VIEW_MENU/PAGE_ALL/VIEW_MENU_CATEGORY_DELETE_ALL', 17, 0, '删除视图菜单分类', '2018-07-03 20:55:05', '2018-07-03 20:55:05');
INSERT INTO `view_page_component` VALUES (53, 1, '新增', '/COMPONENT/USER/VIEW_MENU/PAGE_ALL/VIEW_MENU_ADD_DIALOG', 17, 0, '新增视图菜单', '2018-07-03 20:55:37', '2018-07-03 20:55:37');
INSERT INTO `view_page_component` VALUES (54, 1, '编辑', '/COMPONENT/USER/VIEW_MENU/PAGE_ALL/VIEW_MENU_EDIT_DIALOG', 17, 0, '编辑视图菜单', '2018-07-03 20:55:52', '2018-07-03 20:55:52');
INSERT INTO `view_page_component` VALUES (55, 1, '删除', '/COMPONENT/USER/VIEW_MENU/PAGE_ALL/VIEW_MENU_DELETE_ALL', 17, 0, '删除视图菜单', '2018-07-03 20:56:08', '2018-07-03 20:56:08');
INSERT INTO `view_page_component` VALUES (56, 1, '授权', '/COMPONENT/USER/ROLE_AUTHORITY/VIEW_PAGE/PAGE_ALL/GRANT_ALL_ROLE_AUTHORITY_VIEW_PAGE_COMPONENT', 15, 0, '授权视图页面组件权限（authority）', '2018-07-03 21:32:25', '2018-07-03 21:32:25');
INSERT INTO `view_page_component` VALUES (57, 1, '撤销授权', '/COMPONENT/USER/ROLE_AUTHORITY/VIEW_PAGE/PAGE_ALL/REVOKE_ALL_ROLE_AUTHORITY_VIEW_PAGE_COMPONENT', 15, 0, '撤销授权视图页面组件权限（authority）', '2018-07-03 21:32:48', '2018-07-03 21:32:48');
COMMIT;

-- ----------------------------
-- Table structure for view_page_component_api
-- ----------------------------
DROP TABLE IF EXISTS `view_page_component_api`;
CREATE TABLE `view_page_component_api` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `page_component_id` bigint(20) unsigned NOT NULL COMMENT '视图页面组件 id',
  `api_id` bigint(20) unsigned NOT NULL COMMENT 'API id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='视图页面组件关联 API 表';

-- ----------------------------
-- Records of view_page_component_api
-- ----------------------------
BEGIN;
INSERT INTO `view_page_component_api` VALUES (1, 1, 30);
INSERT INTO `view_page_component_api` VALUES (2, 2, 33);
INSERT INTO `view_page_component_api` VALUES (3, 2, 31);
INSERT INTO `view_page_component_api` VALUES (4, 3, 32);
INSERT INTO `view_page_component_api` VALUES (5, 4, 35);
INSERT INTO `view_page_component_api` VALUES (6, 5, 38);
INSERT INTO `view_page_component_api` VALUES (7, 5, 35);
INSERT INTO `view_page_component_api` VALUES (8, 6, 36);
INSERT INTO `view_page_component_api` VALUES (9, 6, 38);
INSERT INTO `view_page_component_api` VALUES (10, 7, 37);
INSERT INTO `view_page_component_api` VALUES (11, 9, 40);
INSERT INTO `view_page_component_api` VALUES (12, 10, 40);
INSERT INTO `view_page_component_api` VALUES (13, 10, 43);
INSERT INTO `view_page_component_api` VALUES (14, 11, 41);
INSERT INTO `view_page_component_api` VALUES (15, 11, 43);
INSERT INTO `view_page_component_api` VALUES (16, 12, 42);
INSERT INTO `view_page_component_api` VALUES (17, 14, 26);
INSERT INTO `view_page_component_api` VALUES (18, 15, 27);
INSERT INTO `view_page_component_api` VALUES (19, 16, 45);
INSERT INTO `view_page_component_api` VALUES (20, 17, 46);
INSERT INTO `view_page_component_api` VALUES (21, 18, 3);
INSERT INTO `view_page_component_api` VALUES (22, 19, 4);
INSERT INTO `view_page_component_api` VALUES (23, 19, 6);
INSERT INTO `view_page_component_api` VALUES (24, 20, 5);
INSERT INTO `view_page_component_api` VALUES (25, 21, 8);
INSERT INTO `view_page_component_api` VALUES (26, 22, 8);
INSERT INTO `view_page_component_api` VALUES (27, 22, 11);
INSERT INTO `view_page_component_api` VALUES (28, 23, 9);
INSERT INTO `view_page_component_api` VALUES (29, 23, 11);
INSERT INTO `view_page_component_api` VALUES (30, 24, 10);
INSERT INTO `view_page_component_api` VALUES (31, 32, 61);
INSERT INTO `view_page_component_api` VALUES (32, 33, 62);
INSERT INTO `view_page_component_api` VALUES (33, 33, 66);
INSERT INTO `view_page_component_api` VALUES (34, 34, 63);
INSERT INTO `view_page_component_api` VALUES (35, 35, 64);
INSERT INTO `view_page_component_api` VALUES (36, 36, 65);
INSERT INTO `view_page_component_api` VALUES (37, 38, 68);
INSERT INTO `view_page_component_api` VALUES (38, 39, 69);
INSERT INTO `view_page_component_api` VALUES (39, 40, 55);
INSERT INTO `view_page_component_api` VALUES (40, 41, 56);
INSERT INTO `view_page_component_api` VALUES (41, 41, 58);
INSERT INTO `view_page_component_api` VALUES (42, 42, 57);
INSERT INTO `view_page_component_api` VALUES (43, 46, 88);
INSERT INTO `view_page_component_api` VALUES (44, 47, 89);
INSERT INTO `view_page_component_api` VALUES (45, 48, 47);
INSERT INTO `view_page_component_api` VALUES (46, 49, 48);
INSERT INTO `view_page_component_api` VALUES (47, 56, 49);
INSERT INTO `view_page_component_api` VALUES (48, 57, 50);
INSERT INTO `view_page_component_api` VALUES (49, 50, 72);
INSERT INTO `view_page_component_api` VALUES (50, 51, 73);
INSERT INTO `view_page_component_api` VALUES (51, 51, 75);
INSERT INTO `view_page_component_api` VALUES (52, 52, 74);
INSERT INTO `view_page_component_api` VALUES (53, 53, 83);
INSERT INTO `view_page_component_api` VALUES (54, 54, 84);
INSERT INTO `view_page_component_api` VALUES (55, 54, 86);
INSERT INTO `view_page_component_api` VALUES (56, 55, 85);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
