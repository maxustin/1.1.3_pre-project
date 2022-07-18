package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String HOST = "jdbc:mysql://localhost:3306/userbase";
    private final String USERNAME = "root";
    private final String PASSWORD = "u6wf4mkdjb";

    private Connection connection;

    public Util() {
        try{
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch(SQLException sqlExn) {
            sqlExn.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
