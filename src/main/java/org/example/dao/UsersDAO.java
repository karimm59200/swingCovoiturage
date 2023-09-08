package org.example.dao;

import org.example.model.User;
import org.example.utils.ConnexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private Connection connection;

    public UsersDAO() {
        try{
        this.connection = ConnexionDB.getConnection();
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public User getUserById(int id) {

        String query = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Boolean driver = resultSet.getBoolean("driver");

                // Crée et retourne l'objet User
                User user = new User(id, name, email, driver);
                return user;


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addUser(User user) {
        String query = "INSERT INTO users (name, email, driver, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setBoolean(3, user.isDriver());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateUser(User user) {
        String query = "UPDATE users SET name = ?, email = ?, driver = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setBoolean(3, user.isDriver());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteUsers(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<User> getAllUsers()  {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Boolean driver = resultSet.getBoolean("driver");
                User user = new User(id, name, email, driver);
                users.add(user);
            } } catch (SQLException e) {
            e.printStackTrace();
        }
            return users;
        }



    }

