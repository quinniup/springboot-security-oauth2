#**springboot-security-oauth2** 
### 此SpringBoot项目集成Spring Security、OAuth2实现资源访问授权认证。
### 支持client credentials、password、authorization code认证模式。
### 项目默认最为复杂的authorization code授权码认证模式，已经实现自定义登录页、授权页、错误页，以及第三方用户登录。
### 

#### 1.支持/oauth/authorize,/oauth/token,/oauth/refresh_token,/oauth/error；
#### 2.用户认证的accessToken使用RedisTokenStore保存在Redis中（但是代码也已经支持JDBC持久化存储Token，目前处于注释状态）。
#### 注：如果需要使用JDBCTokenStore可以使用一下SQL语句创建响应的数据表：
USE `iot_boss` ;

-- -----------------------------------------------------
-- Table `iot_boss`.`oauth_access_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot_boss`.`oauth_access_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name` VARCHAR(256) NULL DEFAULT NULL,
  `client_id` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL,
  `refresh_token` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iot_boss`.`oauth_approvals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot_boss`.`oauth_approvals` (
  `userId` VARCHAR(256) NULL DEFAULT NULL,
  `clientId` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `status` VARCHAR(10) NULL DEFAULT NULL,
  `expiresAt` DATETIME NULL DEFAULT NULL,
  `lastModifiedAt` DATETIME NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iot_boss`.`oauth_client_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot_boss`.`oauth_client_details` (
  `client_id` VARCHAR(128) NOT NULL,
  `resource_ids` VARCHAR(256) NULL DEFAULT NULL,
  `client_secret` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `authorized_grant_types` VARCHAR(256) NULL DEFAULT NULL,
  `web_server_redirect_uri` VARCHAR(256) NULL DEFAULT NULL,
  `authorities` VARCHAR(256) NULL DEFAULT NULL,
  `access_token_validity` INT(11) NULL DEFAULT NULL,
  `refresh_token_validity` INT(11) NULL DEFAULT NULL,
  `additional_information` VARCHAR(4096) NULL DEFAULT NULL,
  `autoapprove` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iot_boss`.`oauth_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot_boss`.`oauth_code` (
  `code` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iot_boss`.`oauth_refresh_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot_boss`.`oauth_refresh_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
