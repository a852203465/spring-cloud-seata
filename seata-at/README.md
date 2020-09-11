# spring cloud 整合 seata 实现分布式事务 AT模式

##  运行测试
    - 运行 goods-service, order-service 服务
    
    - 将  goods-service, order-service  的@GlobalTransactional 注解注释，先后观察数据库插入情况
    
    - 使用postman 或者浏览器直接调用 localhost:8083/add 即可查看数据库结果

