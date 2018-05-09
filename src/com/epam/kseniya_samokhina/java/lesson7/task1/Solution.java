package com.epam.kseniya_samokhina.java.lesson7.task1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String query = "select * from students";

        try {
            Connection connection = ConnectionFactory.getConnection();
            process(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<String> firstNames = new ArrayList<>();
            ArrayList<String> secondNames = new ArrayList<>();
            ArrayList<Integer> groups = new ArrayList<>();
            while (resultSet.next()) {
                firstNames.add(resultSet.getString(1));
                secondNames.add(resultSet.getString(2));
                groups.add(resultSet.getInt(3));
            }
            for (int i = 0; i < groups.size(); i++) {
                for (int j = 0; j < 10; j++) {
                    String queryInsert = "insert into students(`firstname`, `secondname`, `group`) " +
                            "values ('" + firstNames.get(i) + "','" + secondNames.get(i) + "', " + groups.get(i) + ");";

                    statement.executeUpdate(queryInsert);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void process(Connection connection) {
        System.out.println("Connection success");
    }
}
