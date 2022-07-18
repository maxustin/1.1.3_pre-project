package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String HOST = "jdbc:mysql://localhost:3306/userbase";
    private final String USERNAME = "root";
    private final String PASSWORD = "u6wf4mkdjb";

    private Connection connection;

    public Util() {
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
