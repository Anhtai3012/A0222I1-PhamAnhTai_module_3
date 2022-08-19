package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Calculator",urlPatterns = {"/calculator"})
public class CalculatorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double first = Double.parseDouble(request.getParameter("first"));
        double second = Double.parseDouble(request.getParameter("second"));
        String operator = request.getParameter("operator");
//        calculator(first,second,operator);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("model/result.jsp");
        request.setAttribute("answer",calculator(first,second,operator));
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sa");
    }
    private double calculator(Double firstNum, Double secondNum, String operator){
        double res = 0.0;

        switch (operator){
            case "Addition":
                res = firstNum + secondNum;
                        break;
            case "Subtraction":
                res = firstNum - secondNum;
                break;
            case "Multiplication":
                res = firstNum * secondNum;
                break;
            case "Division":
                    try{
                        res = firstNum / secondNum;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                break;
        }
        return res;
    }
}
