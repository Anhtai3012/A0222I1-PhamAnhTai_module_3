package controller;

import com.sun.org.apache.regexp.internal.RE;
import model.HouseHold;
import service.IHouseholdService;
import service.IMemberService;
import service.impl.HouseholdService;
import service.impl.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet" , urlPatterns = {"/household"})
public class Servlet extends HttpServlet {
    IHouseholdService service = new HouseholdService();
    IMemberService memberService = new MemberService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                addHousehold(request,response);
                break;
            case "edit":
                updateHousehold(request,response);
                break;
            case "view":
                viewHousehold(request,response);
                break;
        }
    }

    private void viewHousehold(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/household");
    }

    private void updateHousehold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String date = request.getParameter("date");
        String address =request.getParameter("address");
        HouseHold houseHold = new HouseHold(id,name,quantity,date,address);
        request.setAttribute("messenger","successful");
        this.service.updateHousehold(houseHold);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void addHousehold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Map<String,String> listError = new HashMap<>();
        if(name.isEmpty()){
            listError.put("name", "name abc");
            System.out.println(listError.get("name"));
            request.setAttribute("listError", listError);
            request.getRequestDispatcher("/view/create.jsp").forward(request,response);
        }
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        HouseHold houseHold = new HouseHold(id,name,quantity,date,address);
        this.service.insertHousehold(houseHold);
        request.setAttribute("messenger","successful");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateHousehold(request,response);
                break;
            case "edit":
                showEditHousehold(request,response);
                break;
            case"view":
                showViewHousehold(request,response);
                break;
            default:
                showListHousehold(request,response);
                break;
        }
    }

    private void showViewHousehold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
       HouseHold houseHold = this.service.selectById(id);
        //request.setAttribute("houseHold",this.service.selectAll());
        request.setAttribute("houseHold",houseHold);
        request.setAttribute("listMember",this.memberService.selectAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/view.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditHousehold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HouseHold houseHold = this.service.selectById(id);
        request.setAttribute("houseHold",houseHold);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateHousehold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListHousehold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",service.selectAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request,response);
    }
}
