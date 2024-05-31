/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : mild

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 27/05/2024 22:18:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mild_organization
-- ----------------------------
DROP TABLE IF EXISTS mild_organization;
CREATE TABLE mild_organization
(
    id          varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
    parent_id   varchar(19)                                                   DEFAULT NULL COMMENT '父组织Id',
    name        varchar(255)                                                  DEFAULT NULL COMMENT '组织名称',
    code        varchar(255)                                                  DEFAULT NULL COMMENT '编码',
    type        tinyint                                                       DEFAULT NULL COMMENT '类型 0:公司、1:部门',
    revision    int                                                           DEFAULT NULL COMMENT '版本号（乐观锁）',
    deleted     tinyint                                                       DEFAULT NULL COMMENT '软删标识',
    create_by   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    create_time datetime                                                      DEFAULT NULL COMMENT '创建时间',
    update_by   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
    update_time datetime                                                      DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='组织部门表';

-- ----------------------------
-- Table structure for mild_position
-- ----------------------------
DROP TABLE IF EXISTS mild_position;
CREATE TABLE mild_position
(
    id          varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
    name        varchar(255)                                                  DEFAULT NULL COMMENT '职位名称',
    code        varchar(255)                                                  DEFAULT NULL COMMENT '职位编码',
    type        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职位类型',
    revision    int                                                           DEFAULT NULL COMMENT '版本号（乐观锁）',
    deleted     tinyint                                                       DEFAULT NULL COMMENT '软删标识',
    create_by   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    create_time datetime                                                      DEFAULT NULL COMMENT '创建时间',
    update_by   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
    update_time datetime                                                      DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='职位表';

-- ----------------------------
-- Table structure for mild_staff
-- ----------------------------
DROP TABLE IF EXISTS mild_staff;
CREATE TABLE mild_staff
(

    id          varchar(19) NOT NULL COMMENT
        '主键',
    name        varchar(255) DEFAULT NULL COMMENT
        '员工名称',
    account_id  varchar(19)  DEFAULT NULL COMMENT
        '账户Id',
    phone       varchar(19)  DEFAULT NULL COMMENT
        '手机号',
    email       varchar(255) DEFAULT NULL COMMENT
        '电子邮箱',
    gender      tinyint      DEFAULT NULL COMMENT
        '性别 0:男、1:女',
    revision    int          DEFAULT NULL COMMENT
        '版本号（乐观锁）',
    deleted     tinyint      DEFAULT NULL COMMENT
        '软删标识',
    create_by   varchar(255) DEFAULT NULL COMMENT
        '创建人',
    create_time datetime     DEFAULT NULL COMMENT
        '创建时间',
    update_by   varchar(255) DEFAULT NULL COMMENT
        '修改人',
    update_time datetime     DEFAULT NULL COMMENT
        '修改时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='职员表';

-- ----------------------------
-- Table structure for mild_sys_account
-- ----------------------------
DROP TABLE IF EXISTS mild_sys_account;
CREATE TABLE mild_sys_account
(
    id              varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '主键',
    user_name       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
    password        varchar(255)                                                  NOT NULL COMMENT '密码',
    status          tinyint                                                       DEFAULT '0' COMMENT '账号状态 0:正常、1:停用',
    type            tinyint                                                       DEFAULT NULL COMMENT '账户类型 0:内部账户、1:客户账户、2:供应商账户',
    account_lock    tinyint                                                       DEFAULT '0' COMMENT '账号锁定状态 0:锁定、1:未锁定',
    account_expired tinyint                                                       DEFAULT '0' COMMENT '账号过期状态  0:过期、1:未过期',
    revision        int                                                           DEFAULT NULL COMMENT '版本号（乐观锁）',
    deleted         tinyint                                                       DEFAULT NULL COMMENT '软删标识',
    create_by       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
    create_time     datetime                                                      DEFAULT NULL COMMENT '创建时间',
    update_by       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
    update_time     datetime                                                      DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统账户表';

-- ----------------------------
-- Table structure for mild_sys_account_role
-- ----------------------------
DROP TABLE IF EXISTS mild_sys_account_role;
CREATE TABLE mild_sys_account_role
(

    id      varchar(19) NOT NULL COMMENT
        '主键',
    user_id varchar(19) DEFAULT NULL COMMENT
        '用户Id',
    role_id varchar(19) DEFAULT NULL COMMENT
        '角色Id',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户角色关联表';

-- ----------------------------
-- Table structure for mild_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS mild_sys_menu;
CREATE TABLE mild_sys_menu
(

    id          varchar(19) NOT NULL COMMENT
        '主键',
    name        varchar(255) DEFAULT NULL COMMENT
        '名称',
    parent_id   varchar(19)  DEFAULT NULL COMMENT
        '父Id',
    icon        varchar(255) DEFAULT NULL COMMENT
        '菜单图标',
    component   varchar(255) DEFAULT NULL COMMENT
        '组件',
    path        text COMMENT
        '菜单路径',
    type        tinyint      DEFAULT NULL COMMENT
        '类型 0:菜单、1:按钮',
    permission  varchar(255) DEFAULT NULL COMMENT
        '权限标识',
    sorted      int          DEFAULT NULL COMMENT
        '菜单排序',
    revision    int          DEFAULT NULL COMMENT
        '版本号（乐观锁）',
    deleted     tinyint      DEFAULT NULL COMMENT
        '软删标识',
    create_by   varchar(255) DEFAULT NULL COMMENT
        '创建人',
    create_time datetime     DEFAULT NULL COMMENT
        '创建时间',
    update_by   varchar(255) DEFAULT NULL COMMENT
        '修改人',
    update_time datetime     DEFAULT NULL COMMENT
        '修改时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统菜单表';

-- ----------------------------
-- Table structure for mild_sys_role
-- ----------------------------
DROP TABLE IF EXISTS mild_sys_role;
CREATE TABLE mild_sys_role
(

    id          varchar(19) NOT NULL COMMENT
        '主键',
    name        varchar(255)         DEFAULT NULL COMMENT
        '角色',
    admin_flag  tinyint     NOT NULL DEFAULT '0' COMMENT
        '是否是管理员 0:否、1：是',
    revision    int                  DEFAULT NULL COMMENT
        '版本号（乐观锁）',
    deleted     tinyint              DEFAULT '0' COMMENT
        '软删标识',
    create_by   varchar(255)         DEFAULT NULL COMMENT
        '创建人',
    create_time datetime             DEFAULT NULL COMMENT
        '创建时间',
    update_by   varchar(255)         DEFAULT NULL COMMENT
        '修改人',
    update_time datetime             DEFAULT NULL COMMENT
        '修改时间',
    status      tinyint              DEFAULT '1' COMMENT
        '状态 0:停用、1:启用',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统角色表';

-- ----------------------------
-- Table structure for mild_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS mild_sys_role_menu;
CREATE TABLE mild_sys_role_menu
(

    id      varchar(19) NOT NULL COMMENT
        '主键',
    role_id varchar(19) DEFAULT NULL COMMENT
        '角色Id',
    menu_id varchar(19) DEFAULT NULL COMMENT
        '菜单Id',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色权限关系表';

SET FOREIGN_KEY_CHECKS = 1;
