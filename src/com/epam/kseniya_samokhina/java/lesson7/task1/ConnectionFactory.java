package com.epam.kseniya_samokhina.java.lesson7.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        final String url = "jdbc:mysql://localhost:3306/student";
        final String user = "root";
        final String password = "mysql";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
