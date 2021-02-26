package com.rongsoft.springbootdemo.controller;


import com.rongsoft.springbootdemo.util.JdbcUtils;
import com.rongsoft.springdemo.configuration.entity.Klass;
import com.rongsoft.springdemo.configuration.entity.School;
import com.rongsoft.springdemo.configuration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/student")
public class DemoController {

    @Autowired
    public ApplicationContextManager applicationContextManager;
    @Autowired
    public Environment environment;

    StopWatch stopWatch = new StopWatch("StopWatch");

    @RequestMapping("/getStudent")
    public void getStudent(){
        ApplicationContext applicationContext = applicationContextManager.getApplicationContext();
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanNames) {
            System.out.println("beanName:"+beanName);
        }
        School school = applicationContext.getBean(School.class);
        school.ding();

        Klass klass = applicationContext.getBean(Klass.class);
        klass.dong();

        Student student = applicationContext.getBean(Student.class);
        student.print();

    }

    @RequestMapping("/getdata")
    public void getdbData(){

        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from card_bin");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String bankName = resultSet.getString("bank_name");
                String bankCode = resultSet.getString("bank_code");
                System.out.println(bankName+":"+bankCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/deletedata",method = RequestMethod.GET)
    public void deletedbData(@RequestParam("idString")String idString){

        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from card_bin where card_bin_id = ?");
            preparedStatement.setString(1,idString);
            boolean ret = preparedStatement.execute();
            System.out.println("删除结果:"+ret);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/updatedata",method = RequestMethod.GET)
    public void updatedbData(@RequestParam("idString")String idString){

        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement("update card_bin set bank_name = 'AAAAA' where card_bin_id = ?");
            preparedStatement.setString(1,idString);
            boolean ret = preparedStatement.execute();
            System.out.println("更新结果:"+ret);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insertdata",method = RequestMethod.GET)
    public void INSERTdbData(@RequestParam("begin")int begin){

        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into card_bin values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,String.valueOf(begin));
            preparedStatement.setInt(2,10);
            preparedStatement.setString(3,String.valueOf(begin));
            preparedStatement.setString(4,String.valueOf(begin));
            preparedStatement.setString(5,String.valueOf(begin));
            preparedStatement.setString(6,String.valueOf(begin));
            preparedStatement.setString(7,String.valueOf(begin));
            preparedStatement.setDate(8, new Date(1000));
            boolean ret = preparedStatement.execute();
            System.out.println("插入结果:"+ret);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用for循环 批量插入数据
     * @param begin
     */
    @RequestMapping(value = "/insertforbatch",method = RequestMethod.GET)
    public void insertforbatch(@RequestParam("begin")int begin,@RequestParam("size")int size){

        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into card_bin values (?,?,?,?,?,?,?,?)");

            stopWatch.start("insertforbatch");
            for (int i = 1; i <= size; i++) {
                preparedStatement.setString(1,String.valueOf(begin+i));
                preparedStatement.setInt(2,10);
                preparedStatement.setString(3,String.valueOf(begin+i));
                preparedStatement.setString(4,String.valueOf(begin+i));
                preparedStatement.setString(5,String.valueOf(begin+i));
                preparedStatement.setString(6,String.valueOf(begin+i));
                preparedStatement.setString(7,String.valueOf(begin+i));
                preparedStatement.setDate(8, new Date(1000));
                boolean ret = preparedStatement.execute();
            }
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println("批量插入结果完成");
        } catch (SQLException e) {
            stopWatch.stop();
            e.printStackTrace();
        }
    }

    /**
     * 使用自带得批量操作接口 插入数据
     * @param begin
     * @param size
     */
    @RequestMapping(value = "/insertDataBatch",method = RequestMethod.GET)
    public void insertDataBatch(@RequestParam("begin")int begin,@RequestParam("size")int size){
        System.out.println("开始批量插入---------");
        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into card_bin values (?,?,?,?,?,?,?,?)");
            stopWatch.start("insertDataBatch");

            for (int i = 1; i <= size; i++) {
                preparedStatement.setString(1,String.valueOf(begin+i));
                preparedStatement.setInt(2,10);
                preparedStatement.setString(3,String.valueOf(begin+i));
                preparedStatement.setString(4,String.valueOf(begin+i));
                preparedStatement.setString(5,String.valueOf(begin+i));
                preparedStatement.setString(6,String.valueOf(begin+i));
                preparedStatement.setString(7,String.valueOf(begin+i));
                preparedStatement.setDate(8, new Date(1000));
                //batch 操作
                preparedStatement.addBatch();
                if (i%100 == 0){
                    int[] ret = preparedStatement.executeBatch();
                }
            }
            int[] ret = preparedStatement.executeBatch();
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println("批量插入结果完成-------");
        } catch (SQLException e) {
            stopWatch.stop();
            e.printStackTrace();
        }
    }

    /**
     * 使用事务
     * @param begin
     * @param size
     */
    @RequestMapping(value = "/insertTransactionDataBatch",method = RequestMethod.GET)
    public void insertTransactionDataBatch(@RequestParam("begin")int begin,@RequestParam("size")int size){
        System.out.println("开始批量插入---------");
        try {
            JdbcUtils jdbcUtils = new JdbcUtils(environment);
            Connection connection = jdbcUtils.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into card_bin values (?,?,?,?,?,?,?,?)");
            stopWatch.start("insertTransactionDataBatch");
            for (int i = 1; i <= size; i++) {
                preparedStatement.setString(1,String.valueOf(begin+i));
                preparedStatement.setInt(2,10);
                preparedStatement.setString(3,String.valueOf(begin+i));
                preparedStatement.setString(4,String.valueOf(begin+i));
                preparedStatement.setString(5,String.valueOf(begin+i));
                preparedStatement.setString(6,String.valueOf(begin+i));
                preparedStatement.setString(7,String.valueOf(begin+i));
                preparedStatement.setDate(8, new Date(1000));
                //batch 操作
                preparedStatement.addBatch();
                if (i%100 == 0){
                    int[] ret = preparedStatement.executeBatch();
                }
            }
            int[] ret = preparedStatement.executeBatch();
            connection.commit();

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println("批量插入结果完成-------");
        } catch (SQLException e) {
            stopWatch.stop();
            e.printStackTrace();
        }
    }

    /**
     * 使用HikariCP
     * @param begin
     * @param size
     */
    @RequestMapping(value = "/insertHikariCP",method = RequestMethod.GET)
    public void insertHikariCP(@RequestParam("begin")int begin,@RequestParam("size")int size){
        System.out.println("开始批量插入---------");
        try {
            HikariDataSource ds = (HikariDataSource) applicationContextManager.getApplicationContext().getBean("dataSource");
            stopWatch.start("insertHikariCP");

            PreparedStatement preparedStatement = null;
            Connection connection = null;
            for (int i = 1; i <= size; i++) {
                connection = ds.getConnection();
                connection.setAutoCommit(false);

                preparedStatement = connection.prepareStatement("insert into card_bin values (?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1,String.valueOf(begin+i));
                preparedStatement.setInt(2,10);
                preparedStatement.setString(3,String.valueOf(begin+i));
                preparedStatement.setString(4,String.valueOf(begin+i));
                preparedStatement.setString(5,String.valueOf(begin+i));
                preparedStatement.setString(6,String.valueOf(begin+i));
                preparedStatement.setString(7,String.valueOf(begin+i));
                preparedStatement.setDate(8, new Date(1000));
                //batch 操作
                preparedStatement.addBatch();
                if (i%100 == 0){
                    int[] ret = preparedStatement.executeBatch();
                }
                connection.commit();
                connection.close();
            }
//            int[] ret = preparedStatement.executeBatch();
//            connection.commit();

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println("批量插入结果完成-------");
        } catch (SQLException e) {
            stopWatch.stop();
            e.printStackTrace();
        }
    }

    /**
     * 使用事务HikariCP
     * @param begin
     * @param size
     */
    @RequestMapping(value = "/insertTransactionHikariCP",method = RequestMethod.GET)
    public void insertTransactionHikariCP(@RequestParam("begin")int begin,@RequestParam("size")int size){
        System.out.println("开始批量插入---------");
        try {
            HikariDataSource ds = (HikariDataSource) applicationContextManager.getApplicationContext().getBean("dataSource");

            PreparedStatement preparedStatement = null;
            Connection connection = null;

            stopWatch.start("insertTransactionHikariCP");
            for (int i = 1; i <= size; i++) {

                connection = ds.getConnection();
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement("insert into card_bin values (?,?,?,?,?,?,?,?)");

                preparedStatement.setString(1,String.valueOf(begin+i));
                preparedStatement.setInt(2,10);
                preparedStatement.setString(3,String.valueOf(begin+i));
                preparedStatement.setString(4,String.valueOf(begin+i));
                preparedStatement.setString(5,String.valueOf(begin+i));
                preparedStatement.setString(6,String.valueOf(begin+i));
                preparedStatement.setString(7,String.valueOf(begin+i));
                preparedStatement.setDate(8, new Date(1000));
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

}
