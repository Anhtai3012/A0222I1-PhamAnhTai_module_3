package controller;

import models.User;
import service.UserDTOImpl;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "servlet", value = "/list")
public class Servlet extends HttpServlet {
    static UserDTOImpl userDTO = new UserDTOImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) action = "display";
        switch (action) {
            case "insert": {
                formInsertUserIntoSQL(request, response);
                break;
            }
            case "update": {
                formUpdateUserSQL(request, response);
                break;
            }
            case "showInfo": {
                formShowInfo(request, response);
                break;
            }
            case "delete": {
                formDeleteSQL(request, response);
                break;
            }
            case "searchByCountry": {
                searchByCountry(request, response);
                break;
            }
            case "orderByName": {
                orderByName(request, response);
                break;
            }
            default:
                displayDTOUser(request, response);
                break;
        }
    }

    private void formShowInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDTO.searchUserById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("form/Info.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void orderByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userDTO.getListUser(UserDTOImpl.ORDER_NAME);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("form/FormShowList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> list = userDTO.searchUserByCountry(country);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("form/FormShowList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void formDeleteSQL(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userDTO.searchUserById(id));
        try {
            request.getRequestDispatcher("form/Delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void formUpdateUserSQL(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDTO.searchUserById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("form/UpdateData.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void formInsertUserIntoSQL(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("message", null);
            request.getRequestDispatcher("form/InsertInto.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void displayDTOUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userDTO.getListUser(UserDTOImpl.SELECT_ALL_USERS);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("form/FormShowList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insert": {
                insertUserIntoSQL(request, response);
                break;
            }
            case "update": {
                updateUserSQL(request, response);
                break;
            }
            case "delete": {
                deleteSQL(request, response);
                break;
            }
        }
    }

    private void insertUserIntoSQL(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country").toUpperCase();
        userDTO.insertUser(name, email, country);
        try {
            request.setAttribute("message", "Create Successfully!!!");
            request.getRequestDispatcher("form/InsertInto.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void updateUserSQL(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userDTO.updateUser(user);
        try {
            request.setAttribute("message", "Update Complete!!!");
            request.setAttribute("user", user);
            request.getRequestDispatcher("form/UpdateData.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    private void deleteSQL(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String choice = request.getParameter("choice");

        if (choice.equalsIgnoreCase("yes")) {
            userDTO.deleteUser(id);
            System.out.println("complete");
        }

        try {
            List<User> list = userDTO.getListUser(UserDTOImpl.SELECT_ALL_USERS);
            request.setAttribute("list", list);
            request.getRequestDispatcher("form/FormShowList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.getRequestDispatcher("form/Error.jsp");
        }
    }

    public void destroy() {
    }
}