package org.example.controller;
import org.example.dao.UsersDAO;
import org.example.model.User;

import java.util.List;

public class UsersController {

    private UsersDAO usersDAO;

    public UsersController() {this.usersDAO = new UsersDAO();}

    public List<User> getAllUsers() {return usersDAO.getAllUsers();}

    public User getUsersById(int id) {return usersDAO.getUserById(id);}

    public void addUsers(User user) {usersDAO.addUser(user);}

    public void updateUsers(User user) {usersDAO.updateUser(user);}

    public void deleteUsers(int id) {usersDAO.deleteUsers(id);}


}
