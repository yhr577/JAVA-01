学习笔记:

## 分库分表 使用db.sql

配置是：

config-sharding.txt
server.txt


事务：先插入order表数据，成功5条，然后插入十条数据，应该是失败5条
http://127.0.0.1:8099/demo/insertOnlyOrder?id=1&begin=30&size=5
http://127.0.0.1:8099/demo/insertXAOrder?id=1&begin=30&size=10