package com.klubnikov.request;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCListener implements ServletContextListener {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test_db";
    public static final String USER = "****";
    public static final String PASSWORD = "****";


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {

            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            sce.getServletContext().setAttribute("dbConnection", connection);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {

            Connection connection = (Connection) sce.getServletContext().getAttribute("dbConnection");
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
