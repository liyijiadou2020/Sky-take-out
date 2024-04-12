# Sky-take-out
本项目是使用 Spring Boot 框架开发的一个在线外卖订购系统。


---
# 苍穹外卖项目介绍

## 项目介绍
本项目（苍穹外卖）是专门为餐饮企业（餐厅、饭店）定制的一款软件产品，包括 系统管理后台 和 小程序端应用 两部分。其中系统管理后台主要提供给餐饮企业内部员工使用，可以对餐厅的分类、菜品、套餐、订单、员工等进行管理维护，对餐厅的各类数据进行统计，同时也可进行来单语音播报功能。小程序端主要提供给消费者使用，可以在线浏览菜品、添加购物车、下单、支付、催单等。

功能架构图：
![20240408170526](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/images/20240408170526.png)


## 功能介绍
### 管理端功能
- 员工登录/退出：内部员工必须登录后才能访问系统管理后台
- 员工管理：包括员工的查询、新增、编辑、禁用等功能
- 分类管理：主要对当前餐厅经营的菜品分类和套餐分类进行管理维护，包括查询、新增、修改、删除等功能



### 用户端功能
TODO


## 技术选型
关于本项目的技术选型, 我们将会从 用户层、网关层、应用层、数据层 这几个方面进行介绍，主要用于展示项目中使用到的技术框架和中间件等。

**1). 用户层**

本项目中在构建系统管理后台的前端页面，我们会用到H5、Vue.js、ElementUI、apache echarts(展示图表)等技术。而在构建移动端应用时，我们会使用到微信小程序。



**2). 网关层**

Nginx是一个服务器，主要用来作为Http服务器，部署静态资源，访问性能高。在Nginx中还有两个比较重要的作用： 反向代理和负载均衡， 在进行项目部署时，要实现Tomcat的负载均衡，就可以通过Nginx来实现。



**3). 应用层**

SpringBoot： 快速构建Spring项目, 采用 "约定优于配置" 的思想, 简化Spring项目的配置开发。

SpringMVC：SpringMVC是spring框架的一个模块，springmvc和spring无需通过中间整合层进行整合，可以无缝集成。

Spring Task:  由Spring提供的定时任务框架。

httpclient:  主要实现了对http请求的发送。

Spring Cache:  由Spring提供的数据缓存框架

JWT:  用于对应用程序上的用户进行身份验证的标记。

阿里云OSS:  对象存储服务，在项目中主要存储文件，如图片等。

Swagger： 可以自动的帮助开发人员生成接口文档，并对接口进行测试。

POI:  封装了对Excel表格的常用操作。

WebSocket: 一种通信网络协议，使客户端和服务器之间的数据交换更加简单，用于项目的来单、催单功能实现。



**4). 数据层**

MySQL： 关系型数据库, 本项目的核心业务数据都会采用MySQL进行存储。

Redis： 基于key-value格式存储的内存数据库, 访问速度快, 经常使用它做缓存。

Mybatis： 本项目持久层将会使用Mybatis开发。

pagehelper:  分页插件。

spring data redis:  简化java代码操作Redis的API。



**5). 工具**

git: 版本控制工具, 在团队协作中, 使用该工具对项目中的代码进行管理。

maven: 项目构建工具。

junit：单元测试工具，开发人员功能实现完毕后，需要通过junit对功能进行单元测试。

postman:  接口测工具，模拟用户发起的各类HTTP请求，获取对应的响应结果。


## 设计文档

### 数据库设计



### 接口设计文档
项目接口设计文档地址：
- 管理端接口设计：https://app.apifox.com/project/4294276
- 用户端接口设计：https://app.apifox.com/project/4294291

开发接口测试文档地址：localhost:80/doc.html



---

# 课程目录：
1. 项目概述、环境搭建
2. 员工管理、分类管理
3. 菜品管理
4. 
5. 店铺营业状态设置
6. 微信登录、商品浏览
7. 缓存商品、购物车
8. 用户下单、订单支付
9. 
10. 订单状态定时处理、来单提醒、用户催单
11. 数据统计（图形报表）
12. 数据统计（Excel报表）

---



