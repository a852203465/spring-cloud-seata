# spring cloud 整合 seata 实现分布式事务

## 运行eureka 

##  seata-server 
  
 - 修改 配置文件 registry.conf  
    - registry. type = "eureka"
    
    - eureka.serviceUrl = "http://192.168.205.120:8761/eureka"    // 注册中心地址

## 事务分组

```yaml
seata:
      tx-service-group: my_test_tx_group
     
    spring:
      cloud:
        alibaba:
          seata:
            tx-service-group: my_test_tx_group
```

    优先读取seata.tx-service-group中的值；
    如果没有设置，读取spring.cloud.alibaba.seata.tx-service-group中的值；
    如果没有设置，tx-service-group默认为：applicationId + "-seata-service-group"
    service.vgroupMapping.my_test_tx_group：default，事务群组名称为default，my_test_tx_group为application.yml配置文件中定义的名称
    service.default.grouplist：127.0.0.1:8091，使用文件配置中心时指定seata server地址

## 初始化脚本

在goods-service, order-service 数据库中执行SQL ， 该SQL 需要在每个需要分布式事务的服务执行

```sql
CREATE TABLE `tb_goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `stock_num` bigint(20) NULL DEFAULT NULL COMMENT '商品库存数量',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品金额',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间戳',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间戳',
  `is_deleted` tinyint(4) NULL DEFAULT NULL COMMENT '删除标志 0：未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1300318712630276098 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = DYNAMIC;

```

```sql
CREATE TABLE `tb_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品ID',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除 0：未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1300269275312717827 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = DYNAMIC;

```

```sql
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime(0) NOT NULL,
  `log_modified` datetime(0) NOT NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

##  运行测试
    - 运行 goods-service, order-service 服务
    
    - 将  goods-service, order-service  的@GlobalTransactional 注解注释，先后观察数据库插入情况
    
    - 使用postman 或者浏览器直接调用 localhost:8083/add 即可查看数据库结果
  
 
    

























