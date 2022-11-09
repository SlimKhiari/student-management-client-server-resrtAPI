package projetarchitecture2022.client.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {

    //connexion à la base de donnés Mysql
    static Connection connection = null;
    static String url = "jdbc:mysql://localhost:3306/group";
    static String username = "root";
    static String password = "Slimetsalambo123&";

    public static Connection getConnection() {
        try {
            //enregistrer le driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //ouvrir la connexion
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connexion à la base de données réussi.");
            } else {
                System.out.println("Echec connexion à la base.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return connection;
    }
}
