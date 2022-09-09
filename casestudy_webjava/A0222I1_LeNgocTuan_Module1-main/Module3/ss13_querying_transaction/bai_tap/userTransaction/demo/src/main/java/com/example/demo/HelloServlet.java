package com.example.demo;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public Connection getConnect() {
        String port = "jdbc:mysql://127.0.0.1/ss13";
        Connection connection = null;
        String username = "";
        String password = "";
        boolean flag = true;
        String path = "D:\\CODEGYM\\user.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (flag) {
                    username = line;
                    flag = false;
                }
                password = line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(port, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (Connection connection = getConnect(); Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            try {
                statement.executeUpdate("insert into user_permision values(1,12)"); // true
                statement.executeUpdate("insert into user_permision values(1,1)"); // error
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}