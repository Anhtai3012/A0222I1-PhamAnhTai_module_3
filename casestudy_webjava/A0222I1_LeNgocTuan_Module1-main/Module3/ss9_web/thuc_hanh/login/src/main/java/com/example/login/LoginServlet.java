package com.example.login;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/authentication")
public class LoginServlet extends HttpServlet {
        public void init() {
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String use_name = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isAccountValid = use_name.equals("admin") && password.equals("admin");
        String message = isAccountValid ? "Hello User" : "Wrong use name or password";
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}