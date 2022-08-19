package servlet;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "discount" , urlPatterns = {"/result"})
public class discount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String describe = request.getParameter("describe");
        double listPrice = Double.parseDouble(request.getParameter("listprice"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discountAmount = listPrice*(discount/100)*0.01;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        request.setAttribute("result",discountAmount);
        requestDispatcher.forward(request,response);
    }
}
