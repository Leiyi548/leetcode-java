package com.leetcode.test.jdbc;

import java.sql.*;

public class Test {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    static final String USERNAME = "root";
    static final String PASSWORD = "4399lwt666";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册jdbc驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("链接数据库");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // 执行查询
            System.out.println("实例化Statement对象...");
            statement = connection.createStatement();
            String sql;
            sql = "select * from test.student";
            ResultSet resultSet = statement.executeQuery(sql);
            // 输出结果数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int genderFlag = resultSet.getInt("gender");
                String gender = genderFlag == 0 ? "男" : "女";

                System.out.println("学生id: " + id);
                System.out.println("学生name: " + name);
                System.out.println("学生age: " + age);
                System.out.println("学生gender: " + gender);
            }
            // 关闭资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Over !!!");
    }
}