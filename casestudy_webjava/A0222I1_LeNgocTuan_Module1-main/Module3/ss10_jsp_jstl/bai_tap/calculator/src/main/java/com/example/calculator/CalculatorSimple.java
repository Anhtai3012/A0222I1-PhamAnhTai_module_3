package com.example.calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "calculator", value = "/calculator")
public class CalculatorSimple extends HttpServlet {

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        double value1 = Double.parseDouble(request.getParameter("value1"));
        double value2 = Double.parseDouble(request.getParameter("value2"));
        String calculator = request.getParameter("selectCalculator");
        double result;
        try {
            result = (NotZeroException.calculator(value1, value2, calculator));
        } catch (NotZeroException e) {
            request.setAttribute("value2", value2);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        request.setAttribute("value1", value1);
        request.setAttribute("value2", value2);
        request.setAttribute("calculator", calculator);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    public void destroy() {
    }
}