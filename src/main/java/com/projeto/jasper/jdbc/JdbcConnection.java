package com.projeto.jasper.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/jaspercurso?serverTimezone=America/Sao_Paulo";
    private static final String USER = "root";
    private static final String PASS = "88484803";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection connection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
