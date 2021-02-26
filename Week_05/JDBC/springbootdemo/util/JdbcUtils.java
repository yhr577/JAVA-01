package com.rongsoft.springbootdemo.util;

import org.springframework.core.env.Environment;

import java.sql.*;

public class JdbcUtils {



    private Connection connection;
    private Environment environment;

    public JdbcUtils(Environment environment) {
        this.environment = environment;
    }

    public Connection getConnection(){
        if (connection != null) return connection;

        String url = environment.getProperty("spring.datasource.url");
        String driveclass = environment.getProperty("spring.datasource.driver-class-name");
        String pwd = environment.getProperty("spring.datasource.data-password");
        String username = environment.getProperty("spring.datasource.data-username");

        try {
            Class.forName(driveclass);
            this.connection = DriverManager.getConnection(url,username,pwd);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet executeQuery(String sql){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
