package com.call_sp;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    static String call_all_user = "{call call_all_user()}";

    static String call_delete_user = "{call call_delete_user(?)}";

    static String search_user = "{call search_user(?)}";

    static String update_user = "{call update_user(?,?,?,?)}";

    public void init() {
    }

    public Connection getConnect() {
        String port = "jdbc:mysql://127.0.0.1/ss12_jdbc_crud";
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
        String action = request.getParameter("action");
        switch (action) {
            case "all": {
                getAll(request, response);
                break;
            }
            case "delete": {
                deleteUserSelect(request, response);
                break;
            }
            case "update": {
                formUpdateUserSelect(request, response);
                break;
            }
        }
    }

    private void formUpdateUserSelect(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        try (Connection connection = getConnect(); CallableStatement statement = connection.prepareCall(search_user)) {
            statement.setInt(1, Integer.parseInt(request.getParameter("id")));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = (resultSet.getString("name"));
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
            request.setAttribute("user", user);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUserSelect(HttpServletRequest request, HttpServletResponse response) {
        try (Connection connection = getConnect(); CallableStatement statement = connection.prepareCall(call_delete_user)) {
            statement.setInt(1, Integer.parseInt(request.getParameter("id")));
            statement.executeUpdate();
            getAll(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnect();
             CallableStatement statement = connection.prepareCall(call_all_user)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = (resultSet.getString("name"));
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                list.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            request.setAttribute("list", list);
            request.getRequestDispatcher("List.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        try (Connection connection = getConnect(); CallableStatement statement = connection.prepareCall(update_user)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, country);
            statement.executeUpdate();
            getAll(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}