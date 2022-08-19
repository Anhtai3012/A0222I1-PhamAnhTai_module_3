package servlet;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCustomer",value = "/customer")
public class ServletCustomer extends HttpServlet {
    private static ArrayList<Customer> listCustomer = new ArrayList<>();
    static {
        listCustomer.add(new Customer("Mai van hoan","1983-08-20","Ha noi","ss10_jsp_and_jstl/exercise/e1/feed-image-1.png"));
        listCustomer.add(new Customer("nguyen van nam","1983-08-20","bac giang","D:\\CODEGYM\\A0222I1-PhamAnhTai_module_3\\ss10_jsp_and_jstl\\exercise\\e1\\feed-image-2.png"));
        listCustomer.add(new Customer("nguyen thai hoa","1983-08-20","Nam dinh","ss10_jsp_and_jstl/exercise/e1/feed-image-3.png"));
        listCustomer.add(new Customer("tran dang khoa","1983-08-20","Da Nang","ss10_jsp_and_jstl/exercise/e1/feed-image-4.png"));
        listCustomer.add(new Customer("Nguyen dinh thi","1983-08-20","Quang Nam","ss10_jsp_and_jstl/exercise/e1/feed-image-5.png"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
        request.setAttribute("customerlist",listCustomer);
        requestDispatcher.forward(request,response);
    }
}
