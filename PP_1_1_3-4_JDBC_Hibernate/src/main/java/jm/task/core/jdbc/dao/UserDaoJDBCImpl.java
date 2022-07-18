package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util util = new Util();
        try(Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("create table if not exists users (id int not null auto_increment, firstName varchar(255), lastName varchar(255), age int, primary key (id))");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection();
        }
    }

    public void dropUsersTable() {
        Util util = new Util();
        try(Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("drop table if exists users");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();
        try(Statement statement = util.getConnection().createStatement()){
            statement.executeUpdate(String.format("insert into users (firstName, lastName, age) value('%s', '%s' , %d)", name, lastName, age));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection();
        }
    }

    public void removeUserById(long id) {
        Util util = new Util();
        try(Statement statement = util.getConnection().createStatement()){
            statement.executeUpdate(String.format("delete from users where id=%d", id));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection();
        }
    }

    public List<User> getAllUsers() {
        Util util = new Util();
        List<User> userList = new LinkedList<>();
        try(Statement statement = util.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge((byte) resultSet.getInt(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection();
        }
        return userList;
    }

    public void cleanUsersTable() {
        Util util = new Util();
        try(Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("truncate table users");
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection();
        }
    }
}
