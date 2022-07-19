package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String HOST = "jdbc:mysql://localhost:3306/userbase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "u6wf4mkdjb";

    private static Connection connection;

    public Util() {
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
