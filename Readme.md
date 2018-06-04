# springboot-security-oauth2
### SpringBoot集成Spring Security、OAuth2实现资源访问授权认证。
### 支持client credentials、password、authorization code模式。
### 默认为最为复杂的authorization code授权码模式。
### 用户认证的token使用RedisTokenStore保存在redis中。
#### 提供/oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access,/oauth/error