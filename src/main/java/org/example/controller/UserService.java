package org.example.controller;
import org.example.dao.UsersDAO;
import org.example.model.User;

import java.util.List;

public class UserService {

    private UsersDAO usersDAO;

    public UserService() {this.usersDAO = new UsersDAO();}

    public List<User> getAllUsers() {return usersDAO.getAllUsers();}

    public User getUserById(int id) {return usersDAO.getUserById(id);}

    public int addUser(User user) {return usersDAO.addUser(user);}

    public int updateUser(User user) {return usersDAO.updateUser(user);}

    public int deleteUser(int id) {return usersDAO.deleteUsers(id);}


}
