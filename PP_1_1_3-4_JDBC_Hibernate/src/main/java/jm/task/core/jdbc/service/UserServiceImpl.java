package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.*;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.*;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.dropUsersTable();
    }

    public void saveUser(String firstName, String lastName, byte age) {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.saveUser(firstName, lastName, age);
        System.out.println("User c именем - " + firstName + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDao userDao = new UserDaoJDBCImpl();
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.cleanUsersTable();
    }
}
