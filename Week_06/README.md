学习笔记:
三个表数据结构如下:

CREATE TABLE `goods` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `amount` decimal(50,0) DEFAULT NULL COMMENT '商品金额',
  `detail` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '商品详情',
  `type` varchar(20) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '类别',
  `belong` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '商品归属用户id',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `id_index` (`belong`,`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `goods_id` bigint NOT NULL COMMENT '商品id',
  `amount` decimal(50,0) DEFAULT NULL COMMENT '订单金额,2位有效数字',
  `user_id` bigint DEFAULT NULL COMMENT '下单用户',
  `address` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '邮寄地址',
  `phone` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '收货人电话号码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `id_index` (`user_id`,`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2042 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL COMMENT '用户姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL COMMENT '用户密码',
  `id_card` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '身份证号',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `id_startdate` date DEFAULT NULL COMMENT '身份证有效期 起始日期',
  `id_enddate` date DEFAULT NULL COMMENT '身份证有效期 结束日期',
  `amount` decimal(50,0) DEFAULT NULL COMMENT '用户余额',
  `phone` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '联系电话号码',
  `address` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL COMMENT '邮寄地址',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `id_index` (`id`,`id_card`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

插入数据库代码:

/**
     * 插入order表
     * @param begin
     * @param size
     */
    @RequestMapping(value = "/insertOrder",method = RequestMethod.GET)
    public void insertOrder(@RequestParam("begin")int begin,@RequestParam("size")int size){
        System.out.println("开始批量插入---------");
        try {
            HikariDataSource ds = (HikariDataSource) applicationContextManager.getApplicationContext().getBean("dataSource");

            PreparedStatement preparedStatement = null;
            Connection connection = null;

            stopWatch.start("insertUser");
            for (int i = 1; i <= size; i++) {

                connection = ds.getConnection();
                connection.setAutoCommit(false);

                // user 表 INSERT INTO `test`.`user`(`id`, `user_name`, `password`, `id_card`, `status`, `id_startdate`, `id_enddate`, `amount`, `phone`, `address`, `update_time`, `create_time`) VALUES (1, '1', '111', '1111', 1, '2021-02-26', '2021-02-26', 111, '18018754180', '广州市天河区', '2021-02-26 16:51:09', '2021-02-26 16:51:11');
                preparedStatement = connection.prepareStatement("INSERT INTO `test`.`user`(`id`, `user_name`, `password`, `id_card`, `status`, `id_startdate`, `id_enddate`, `amount`, `phone`, `address`, `update_time`, `create_time`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

                preparedStatement.setInt(1,begin+i);
                preparedStatement.setString(2,"杨先生"+String.valueOf(begin+i));
                preparedStatement.setString(3,"abcdefg");
                preparedStatement.setString(4,"3607812020"+begin+i);
                preparedStatement.setInt(5,1);
                Date date = new java.sql.Date(new java.util.Date().getTime());
                preparedStatement.setDate(6,date);
                preparedStatement.setDate(7,date);
                preparedStatement.setBigDecimal(8,new BigDecimal(10.00));
                preparedStatement.setString(9,"1801875"+String.valueOf(begin+i));
                preparedStatement.setString(10,"广东省广州市天河区"+String.valueOf(begin+i));
                Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
                preparedStatement.setTimestamp(11, timestamp);
                preparedStatement.setTimestamp(12, timestamp);
                boolean ret = preparedStatement.execute();
                connection.commit();
                connection.close();
            }

            stopWatch.stop();

            stopWatch.start("insertGoods");
            for (int i = 1; i <= size; i++) {

                connection = ds.getConnection();
                connection.setAutoCommit(false);

                // goods 表 INSERT INTO `test`.`goods`(`id`, `amount`, `detail`, `type`, `belong`, `status`, `update_time`,`create_time`) VALUES (1, 10, '的说法', '1', '1', 1, '2021-02-26 17:02:51','2021-02-26 17:02:51');
                preparedStatement = connection.prepareStatement("INSERT INTO `test`.`goods`(`id`, `amount`, `detail`, `type`, `belong`, `status`, `update_time`,`create_time`) VALUES(?,?,?,?,?,?,?,?)");

                preparedStatement.setInt(1,begin+i);
                preparedStatement.setBigDecimal(2,new BigDecimal(begin+i));
                preparedStatement.setString(3,"哈哈哈");
                preparedStatement.setInt(4,1);
                preparedStatement.setInt(5,1);
                preparedStatement.setInt(6,1);
                Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                preparedStatement.setTimestamp(7, date);
                preparedStatement.setTimestamp(8, date);
                boolean ret = preparedStatement.execute();
                connection.commit();
                connection.close();
            }

            stopWatch.stop();

            stopWatch.start("insertOrder");
            for (int i = 1; i <= size; i++) {

                connection = ds.getConnection();
                connection.setAutoCommit(false);

                // order 表 INSERT INTO `test`.`order`(`id`, `goods_id`, `amount`, `user_id`, `address`, `phone`, `update_time`, `create_time`) VALUES (1, 1, 11, 1, '广州市天河区', '18018754278', '2021-02-26 16:18:11', '2021-02-26 16:18:13');
                preparedStatement = connection.prepareStatement("INSERT INTO `test`.`order`(`id`,`goods_id`, `amount`, `user_id`, `address`, `phone`, `update_time`, `create_time`) VALUES(?,?,?,?,?,?,?,?)");

                preparedStatement.setInt(1,begin+i);
                preparedStatement.setInt(2,1001);
                preparedStatement.setBigDecimal(3,new BigDecimal(50.00));
                preparedStatement.setInt(4,1);
                preparedStatement.setString(5,"广东省广州市天河区"+String.valueOf(begin+i));
                preparedStatement.setString(6,"1801875"+String.valueOf(begin+i));
                Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                preparedStatement.setTimestamp(7, date);
                preparedStatement.setTimestamp(8, date);
                boolean ret = preparedStatement.execute();
                connection.commit();
                connection.close();
            }

            stopWatch.stop();

            System.out.println(stopWatch.prettyPrint());
            System.out.println("批量插入结果完成-------");
        } catch (SQLException e) {
            stopWatch.stop();
            e.printStackTrace();
        }
    }
