# JOSP-accountManageJava

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-blue.svg)
![MyBatis-Plus](https://img.shields.io/badge/MyBatis--Plus-3.5.7-blue.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange.svg)
![License](https://img.shields.io/badge/License-AGPL--3.0-blue.svg)

> **账户管理系统后端** - 用户、角色、部门管理

## 📖 项目简介

JOSP-accountManageJava 是一个基于 Spring Boot 3 的账户管理系统后端，提供用户管理、角色管理、部门管理等核心功能。

**前端项目**: [JOSP-accountManagerVue3](../JOSP-accountManagerVue3)

## 🚀 技术栈

| 技术 | 版本 | 说明 |
|-----|------|-----|
| Spring Boot | 3.4.0 | 基础框架 |
| Spring Security | - | 安全框架 |
| MyBatis-Plus | 3.5.7 | ORM框架 |
| MySQL | 8.0 | 数据库 |
| Knife4j | 4.4.0 | API文档 |
| JWT | 0.12.5 | Token认证 |
| Hutool | 5.8.26 | 工具库 |

## 📦 核心功能

- ✅ **用户管理** - 用户增删改查、分页查询
- ✅ **角色管理** - 角色权限控制
- ✅ **部门管理** - 部门树形结构
- ✅ **统一返回格式** - ShowResult统一封装
- ✅ **全局异常处理** - 自动捕获异常
- ✅ **自动填充** - createTime/updateTime自动填充
- ✅ **跨域配置** - 支持前端跨域访问
- ✅ **API文档** - Knife4j在线文档

## 🔧 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 安装步骤

1. **克隆项目**
```bash
git clone https://github.com/junwOpenSourceProjects/JOSP-accountManageJava.git
cd JOSP-accountManageJava
```

2. **创建数据库**
```bash
mysql -u root -p < src/main/resources/db_init.sql
```

3. **修改数据库配置**
编辑 `src/main/resources/application.yml`，修改数据库连接信息：
```yaml
spring:
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/account_manage
          username: root
          password: your_password
```

4. **运行项目**
```bash
./mvnw spring-boot:run
```

5. **访问服务**
- 后端地址: http://localhost:8088
- API文档: http://localhost:8088/doc.html

## 📚 API接口

### 用户管理

| 接口 | 方法 | 说明 |
|-----|------|-----|
| /api/user/page | GET | 分页查询用户 |
| /api/user/{id} | GET | 根据ID查询用户 |
| /api/user | POST | 新增用户 |
| /api/user | PUT | 更新用户 |
| /api/user/{id} | DELETE | 删除用户 |
| /api/user/batch | DELETE | 批量删除用户 |

## 🗄️ 数据库设计

### 核心表

- **sys_user** - 用户表
- **sys_role** - 角色表
- **sys_dept** - 部门表
- **sys_user_role** - 用户角色关联表

## 📁 项目结构

```
JOSP-accountManageJava/
├── src/main/java/wo1261931780/JOSPaccountManageJava/
│   ├── config/          # 配置类
│   ├── controller/      # 控制器
│   ├── entity/          # 实体类
│   ├── mapper/          # Mapper接口
│   ├── service/         # 服务层
│   └── AccountManageApplication.java
├── src/main/resources/
│   ├── application.yml  # 配置文件
│   └── db_init.sql      # 数据库初始化
└── pom.xml
```

## 🔐 默认账号

- 用户名: `admin`
- 密码: `123456`

---

**创建时间**: 2026-03-29
**维护者**: junw
