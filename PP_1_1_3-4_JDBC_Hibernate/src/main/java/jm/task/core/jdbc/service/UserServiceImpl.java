package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.*;
import jm.task.core.jdbc.model.User;

import java.util.*;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String firstName, String lastName, byte age) {
        userDaoJDBC.saveUser(firstName, lastName, age);
        System.out.println("User c именем - " + firstName + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
