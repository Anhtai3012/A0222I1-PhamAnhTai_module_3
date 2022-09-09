package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet" ,urlPatterns = {"/display"})
//quadratic equation
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int c  = Integer.parseInt(request.getParameter("c"));
        float deta = b*b-4*a*c;
        String messenger;
        double result;
        double result1;
        double result2;
        if (a==0) {
            messenger="not found ...";
            request.setAttribute("messenger",messenger);
        }
        else if (deta<0){
            messenger="phuong trinh vo nghiem";
            request.setAttribute("messenger",messenger);
        }else if (deta==0){
            result =-(2*b)/a;
            request.setAttribute("result",result);
        }else if (deta>0){
            result1= -b+Math.sqrt(deta)/2*a;
            result2 = -b-Math.sqrt(deta)/2*a;
            request.setAttribute("result1",result1);
            request.setAttribute("result2",result2);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/display.jsp");
        requestDispatcher.forward(request,response);
    }
}
