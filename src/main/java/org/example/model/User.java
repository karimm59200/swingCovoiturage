package org.example.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;

    private String email;

    private boolean driver = false;
    private String password;

    public User() {
    }

    public User(int id, String name, String email, boolean driver, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.driver = driver;
        this.password = password;
    }

    public User(String name, String email, boolean driver) {
        this.name = name;
        this.email = email;
        this.driver = driver;
    }

    public User(int id, String name, String email, Boolean driver) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
