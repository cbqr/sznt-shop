# Spring Cloud Alibaba For sznt-shop

## 个人博客

- **[Java练习生](https://cbqr.github.io)**

## 联系方式
- **email: liusheng_work@163.com**
- **qq: 754581698**

## 概述

利用 Spring Cloud Alibaba 微服务技术栈实现企业商城项目核心模块，以便于我们更好的理解微服务架构，并将知识点运用到实践中。

## 开发环境

- 操作系统：MacBook Pro 2015
- 开发工具：Intellij IDEA
- 数据库：MySQL 5.7.27
- Java SDK：Oracle JDK 1.8.152

## 部署环境

- 操作系统：Linux
- 虚拟化技术：VirtulBox + Docker

## 项目管理工具

- 项目构建：Maven + Nexus
- 代码管理：Git + GitLab
- 镜像管理：Harbor

## 后台主要技术栈

- 核心框架：Spring Boot + Spring Cloud Alibaba
- ORM 框架：MyBatis Plus 简化 MyBatis 开发
- 数据库连接池：Alibaba Druid
- 数据库缓存：Redis Sentinel
- 消息中间件：RocketMQ
- 接口文档引擎：Swagger2 RESTful 风格 API 文档生成
- 全文检索引擎：ElasticSearch
- 分布式链路追踪：SkyWalking
- 分布式文件系统：Alibaba OSS
- 分布式系统网关：Spring Cloud Gateway
- 分布式协调系统：Spring Cloud Alibaba Nacos Server
- 分布式配置中心：Spring Cloud Alibaba Nacos Config
- 分布式熔断降级：Spring Cloud Alibaba Sentinel
- 反向代理负载均衡：Nginx

## 持续集成

- 持续集成：GitLab
- 持续交付：Jenkins

## 服务规划

### Cloud

| 服务名称    | 服务端口         | 服务说明                               |
| --------------- | -------------------- | ------------------------------------------ |
| MySQL           | 192.168.10.150:3306  | MySQL 5.7.x，1G                             |
| GitLab          | 192.168.10.132:8080  | 代码托管/持续集成，2G             |
| Nexus           | 192.168.10.146:8081  | 依赖管理，2G                          |
| Harbor          | 192.168.10.139:8080  | 镜像管理，1G                          |
| Jenkins         | 192.168.10.135:8080  | 持续交付，1G                          |
| SkyWalking      | 192.168.10.148:8080  | 链路追踪，2G                          |
| RocketMQ        | 192.168.10.149:8080  | 消息队列，2G                          |
| Nacos           | 192.168.10.151:8848  | 注册发现/配置中心                  |
| Sentinel        | 192.168.10.151:8080  | 熔断降级                               |
| Redis           | 192.168.10.151:26379 | 数据缓存                               |
| Nginx           | 192.168.10.151:80    | 反向代理/负载均衡                  |

### Services

| 服务名称                             | 服务端口 | 服务说明   |
| ---------------------------------------- | -------- | -------------- |
| sznt-shop-gateway                       | 9000     | 服务网关 |
| sznt-shop-auth                          | 9001     | 认证中心 |
| sznt-shop-coupon                        | 9201     | 优惠券服务|
| sznt-shop-order                         | 9202     | 订单服务 |
| sznt-shop-product                       | 9203     | 商品服务 |
| sznt-shop-user                          | 9204     | 用户服务 |
| sznt-shop-oss                           | 9205     | OSS服务 |
