# Sky-take-out
本项目是使用 Spring Boot 框架开发的一个在线外卖订购系统。


---
# 苍穹外卖项目介绍

## 项目介绍
本项目（苍穹外卖）是专门为餐饮企业（餐厅、饭店）定制的一款软件产品，包括 系统管理后台 和 小程序端应用 两部分。其中系统管理后台主要提供给餐饮企业内部员工使用，可以对餐厅的分类、菜品、套餐、订单、员工等进行管理维护，对餐厅的各类数据进行统计，同时也可进行来单语音播报功能。小程序端主要提供给消费者使用，可以在线浏览菜品、添加购物车、下单、支付、催单等。

功能架构图：

![20240408170526](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/images/20240408170526.png)


## 目前已开发的功能
### 管理端功能
- 员工登录/退出：内部员工必须登录后才能访问系统管理后台。
- 员工管理：包括员工的查询、新增、编辑、禁用等。
- 分类管理：主要对当前餐厅经营的菜品分类和套餐分类进行管理维护，包括查询、新增、修改、删除等。
- 菜品管理：维护各个分类下的菜品信息，包含查询、新增、修改、删除、启停售等。
- 套餐管理：维护餐厅中的订餐信息，包含查询、取消、修改、删除、启停售等。
- 订单管理：
- 数据统计：


### 用户端功能
- 微信登录：管理用户的微信授权登录，为小程序点餐做准备。
- 点餐-菜单：在点餐界面显示各分类下的菜品和套餐，根据当前选择的分类加载菜品信息或套餐信息，供用户选择。
- 点餐-购物车：用户选中的菜品会加入到购物车。主要包含 查询购物车、加入购物车、清空购物车等功能。
- 订单支付：用户可以对购物车里的菜品和套餐进行支付结算，本项目实现了微信支付的结算方式。
- 个人信息：


## 技术选型
关于本项目的技术选型, 我们将会从 用户层、网关层、应用层、数据层 这几个方面进行介绍，主要用于展示项目中使用到的技术框架和中间件等。

**1). 用户层**

本项目中在构建系统管理后台的前端页面，我们会用到H5、Vue.js、ElementUI、apache echarts(展示图表)等技术。而在构建移动端应用时，我们会使用到微信小程序。



**2). 网关层**

Nginx是一个服务器，主要用来作为Http服务器，部署静态资源，访问性能高。在Nginx中还有两个比较重要的作用： 反向代理和负载均衡， 在进行项目部署时，要实现Tomcat的负载均衡，就可以通过Nginx来实现。



**3). 应用层**
- SpringBoot： 快速构建Spring项目, 采用 "约定优于配置" 的思想, 简化Spring项目的配置开发。
- SpringMVC：SpringMVC是spring框架的一个模块，springmvc和spring无需通过中间整合层进行整合，可以无缝集成。
- Spring Task:  由Spring提供的定时任务框架。
- httpclient:  主要实现了对http请求的发送。
- Spring Cache:  由Spring提供的数据缓存框架
- JWT:  用于对应用程序上的用户进行身份验证的标记。
- 阿里云OSS:  对象存储服务，在项目中主要存储文件，如图片等。
- Swagger： 可以自动的帮助开发人员生成接口文档，并对接口进行测试。
- POI:  封装了对Excel表格的常用操作。
- WebSocket: 一种通信网络协议，使客户端和服务器之间的数据交换更加简单，用于项目的来单、催单功能实现。



**4). 数据层**
- MySQL： 关系型数据库, 本项目的核心业务数据都会采用MySQL进行存储。
- Redis： 基于key-value格式存储的内存数据库, 访问速度快, 经常使用它做缓存。
- Mybatis： 本项目持久层将会使用Mybatis开发。
- pagehelper:  分页插件。
- Spring data redis:  简化java代码操作Redis的API。



**5). 工具**
- Git: 版本控制工具, 在团队协作中, 使用该工具对项目中的代码进行管理。
- Maven: 项目构建工具。
- Junit：单元测试工具，开发人员功能实现完毕后，需要通过junit对功能进行单元测试。
- Postman:  接口测工具，模拟用户发起的各类HTTP请求，获取对应的响应结果。


## 设计文档

### 数据库设计文档

| 序号 | 数据表名      | 中文名称       |
| ---- | ------------- | -------------- |
| 1    | employee      | 员工表         |
| 2    | category      | 分类表         |
| 3    | dish          | 菜品表         |
| 4    | dish_flavor   | 菜品口味表     |
| 5    | setmeal       | 套餐表         |
| 6    | setmeal_dish  | 套餐菜品关系表 |
| 7    | user          | 用户表         |
| 8    | address_book  | 地址表         |
| 9    | shopping_cart | 购物车表       |
| 10   | orders        | 订单表         |
| 11   | order_detail  | 订单明细表     |

#### 1. employee

employee表为员工表，用于存储商家内部的员工信息。具体表结构如下：

| 字段名      | 数据类型    | 说明         | 备注        |
| ----------- | ----------- | ------------ | ----------- |
| id          | bigint      | 主键         | 自增        |
| name        | varchar(32) | 姓名         |             |
| username    | varchar(32) | 用户名       | 唯一        |
| password    | varchar(64) | 密码         |             |
| phone       | varchar(11) | 手机号       |             |
| sex         | varchar(2)  | 性别         |             |
| id_number   | varchar(18) | 身份证号     |             |
| status      | int         | 账号状态     | 1正常 0锁定 |
| create_time | datetime    | 创建时间     |             |
| update_time | datetime    | 最后修改时间 |             |
| create_user | bigint      | 创建人id     |             |
| update_user | bigint      | 最后修改人id |             |

#### 2. category

category表为分类表，用于存储商品的分类信息。具体表结构如下：

| 字段名      | 数据类型    | 说明         | 备注                 |
| ----------- | ----------- | ------------ | -------------------- |
| id          | bigint      | 主键         | 自增                 |
| name        | varchar(32) | 分类名称     | 唯一                 |
| type        | int         | 分类类型     | 1菜品分类  2套餐分类 |
| sort        | int         | 排序字段     | 用于分类数据的排序   |
| status      | int         | 状态         | 1启用 0禁用          |
| create_time | datetime    | 创建时间     |                      |
| update_time | datetime    | 最后修改时间 |                      |
| create_user | bigint      | 创建人id     |                      |
| update_user | bigint      | 最后修改人id |                      |

#### 3. dish

dish表为菜品表，用于存储菜品的信息。具体表结构如下：

| 字段名      | 数据类型      | 说明         | 备注        |
| ----------- | ------------- | ------------ | ----------- |
| id          | bigint        | 主键         | 自增        |
| name        | varchar(32)   | 菜品名称     | 唯一        |
| category_id | bigint        | 分类id       | 逻辑外键    |
| price       | decimal(10,2) | 菜品价格     |             |
| image       | varchar(255)  | 图片路径     |             |
| description | varchar(255)  | 菜品描述     |             |
| status      | int           | 售卖状态     | 1起售 0停售 |
| create_time | datetime      | 创建时间     |             |
| update_time | datetime      | 最后修改时间 |             |
| create_user | bigint        | 创建人id     |             |
| update_user | bigint        | 最后修改人id |             |

#### 4. dish_flavor

dish_flavor表为菜品口味表，用于存储菜品的口味信息。具体表结构如下：

| 字段名  | 数据类型     | 说明     | 备注     |
| ------- | ------------ | -------- | -------- |
| id      | bigint       | 主键     | 自增     |
| dish_id | bigint       | 菜品id   | 逻辑外键 |
| name    | varchar(32)  | 口味名称 |          |
| value   | varchar(255) | 口味值   |          |

#### 5. setmeal

setmeal表为套餐表，用于存储套餐的信息。具体表结构如下：

| 字段名      | 数据类型      | 说明         | 备注        |
| ----------- | ------------- | ------------ | ----------- |
| id          | bigint        | 主键         | 自增        |
| name        | varchar(32)   | 套餐名称     | 唯一        |
| category_id | bigint        | 分类id       | 逻辑外键    |
| price       | decimal(10,2) | 套餐价格     |             |
| image       | varchar(255)  | 图片路径     |             |
| description | varchar(255)  | 套餐描述     |             |
| status      | int           | 售卖状态     | 1起售 0停售 |
| create_time | datetime      | 创建时间     |             |
| update_time | datetime      | 最后修改时间 |             |
| create_user | bigint        | 创建人id     |             |
| update_user | bigint        | 最后修改人id |             |

#### 6. setmeal_dish

setmeal_dish表为套餐菜品关系表，用于存储套餐和菜品的关联关系。具体表结构如下：

| 字段名     | 数据类型      | 说明     | 备注     |
| ---------- | ------------- | -------- | -------- |
| id         | bigint        | 主键     | 自增     |
| setmeal_id | bigint        | 套餐id   | 逻辑外键 |
| dish_id    | bigint        | 菜品id   | 逻辑外键 |
| name       | varchar(32)   | 菜品名称 | 冗余字段 |
| price      | decimal(10,2) | 菜品单价 | 冗余字段 |
| copies     | int           | 菜品份数 |          |

#### 7. user

user表为用户表，用于存储C端用户的信息。具体表结构如下：

| 字段名      | 数据类型     | 说明               | 备注 |
| ----------- | ------------ | ------------------ | ---- |
| id          | bigint       | 主键               | 自增 |
| openid      | varchar(45)  | 微信用户的唯一标识 |      |
| name        | varchar(32)  | 用户姓名           |      |
| phone       | varchar(11)  | 手机号             |      |
| sex         | varchar(2)   | 性别               |      |
| id_number   | varchar(18)  | 身份证号           |      |
| avatar      | varchar(500) | 微信用户头像路径   |      |
| create_time | datetime     | 注册时间           |      |

#### 8. address_book

address_book表为地址表，用于存储C端用户的收货地址信息。具体表结构如下：

| 字段名        | 数据类型     | 说明         | 备注           |
| ------------- | ------------ | ------------ | -------------- |
| id            | bigint       | 主键         | 自增           |
| user_id       | bigint       | 用户id       | 逻辑外键       |
| consignee     | varchar(50)  | 收货人       |                |
| sex           | varchar(2)   | 性别         |                |
| phone         | varchar(11)  | 手机号       |                |
| province_code | varchar(12)  | 省份编码     |                |
| province_name | varchar(32)  | 省份名称     |                |
| city_code     | varchar(12)  | 城市编码     |                |
| city_name     | varchar(32)  | 城市名称     |                |
| district_code | varchar(12)  | 区县编码     |                |
| district_name | varchar(32)  | 区县名称     |                |
| detail        | varchar(200) | 详细地址信息 | 具体到门牌号   |
| label         | varchar(100) | 标签         | 公司、家、学校 |
| is_default    | tinyint(1)   | 是否默认地址 | 1是 0否        |

#### 9. shopping_cart

shopping_cart表为购物车表，用于存储C端用户的购物车信息。具体表结构如下：

| 字段名      | 数据类型      | 说明         | 备注     |
| ----------- | ------------- | ------------ | -------- |
| id          | bigint        | 主键         | 自增     |
| name        | varchar(32)   | 商品名称     |          |
| image       | varchar(255)  | 商品图片路径 |          |
| user_id     | bigint        | 用户id       | 逻辑外键 |
| dish_id     | bigint        | 菜品id       | 逻辑外键 |
| setmeal_id  | bigint        | 套餐id       | 逻辑外键 |
| dish_flavor | varchar(50)   | 菜品口味     |          |
| number      | int           | 商品数量     |          |
| amount      | decimal(10,2) | 商品单价     |          |
| create_time | datetime      | 创建时间     |          |

#### 10. orders

orders表为订单表，用于存储C端用户的订单数据。具体表结构如下：

| 字段名                  | 数据类型      | 说明         | 备注                                            |
| ----------------------- | ------------- | ------------ | ----------------------------------------------- |
| id                      | bigint        | 主键         | 自增                                            |
| number                  | varchar(50)   | 订单号       |                                                 |
| status                  | int           | 订单状态     | 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 |
| user_id                 | bigint        | 用户id       | 逻辑外键                                        |
| address_book_id         | bigint        | 地址id       | 逻辑外键                                        |
| order_time              | datetime      | 下单时间     |                                                 |
| checkout_time           | datetime      | 付款时间     |                                                 |
| pay_method              | int           | 支付方式     | 1微信支付 2支付宝支付                           |
| pay_status              | tinyint       | 支付状态     | 0未支付 1已支付 2退款                           |
| amount                  | decimal(10,2) | 订单金额     |                                                 |
| remark                  | varchar(100)  | 备注信息     |                                                 |
| phone                   | varchar(11)   | 手机号       |                                                 |
| address                 | varchar(255)  | 详细地址信息 |                                                 |
| user_name               | varchar(32)   | 用户姓名     |                                                 |
| consignee               | varchar(32)   | 收货人       |                                                 |
| cancel_reason           | varchar(255)  | 订单取消原因 |                                                 |
| rejection_reason        | varchar(255)  | 拒单原因     |                                                 |
| cancel_time             | datetime      | 订单取消时间 |                                                 |
| estimated_delivery_time | datetime      | 预计送达时间 |                                                 |
| delivery_status         | tinyint       | 配送状态     | 1立即送出  0选择具体时间                        |
| delivery_time           | datetime      | 送达时间     |                                                 |
| pack_amount             | int           | 打包费       |                                                 |
| tableware_number        | int           | 餐具数量     |                                                 |
| tableware_status        | tinyint       | 餐具数量状态 | 1按餐量提供  0选择具体数量                      |

#### 11. order_detail

order_detail表为订单明细表，用于存储C端用户的订单明细数据。具体表结构如下：

| 字段名      | 数据类型      | 说明         | 备注     |
| ----------- | ------------- | ------------ | -------- |
| id          | bigint        | 主键         | 自增     |
| name        | varchar(32)   | 商品名称     |          |
| image       | varchar(255)  | 商品图片路径 |          |
| order_id    | bigint        | 订单id       | 逻辑外键 |
| dish_id     | bigint        | 菜品id       | 逻辑外键 |
| setmeal_id  | bigint        | 套餐id       | 逻辑外键 |
| dish_flavor | varchar(50)   | 菜品口味     |          |
| number      | int           | 商品数量     |          |
| amount      | decimal(10,2) | 商品单价     |          |




### 接口设计文档

#### 项目接口设计文档地址
- 管理端接口设计：https://app.apifox.com/project/4294276
- 用户端接口设计：https://app.apifox.com/project/4294291

#### 开发接口测试文档地址：localhost:80/doc.html


---




