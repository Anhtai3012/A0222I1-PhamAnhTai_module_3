package com.example.produce;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "bill", value = "/display-discount")
public class CalculatorBill extends HttpServlet {
    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        double discountAmount = price * discount * 0.01;
        double discountPrice = price * discount - discountAmount;

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h6>Description " + description + "</h1>");
        out.println("<h6>Price " + price + "</h1>");
        out.println("<h6>Discount " + discount + "</h1>");
        out.println("<h2>Discount Amount " + discountAmount + "</h1>");
        out.println("<h2>Discount Price " + discountPrice + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}