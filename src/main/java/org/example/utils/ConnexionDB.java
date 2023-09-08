package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/covoiturage_db";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "test";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
    }
}

