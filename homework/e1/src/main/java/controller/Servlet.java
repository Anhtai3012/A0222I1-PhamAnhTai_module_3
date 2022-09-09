package controller;

import model.Product;
import service.ICategory;
import service.IProduct;
import service.impl.CategoryService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "Servlet" , urlPatterns = {"/products"})
public class Servlet extends HttpServlet {
    IProduct product = new ProductService();
    ICategory category = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                updateProduct(request,response);
                break;
            case "search":
                showSearchName(request,response);
                break;
            case "edit":
                saveProduct(request,response);
            default:
                break;
        }
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id,name,price,color,quantity,category);
        this.product.saveEditProduct(product);
       // RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        response.sendRedirect("/products");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,price,color,quantity,category);
        this.product.insertProduct(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        request.setAttribute("create","successful");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "search":
               // showSearchName(request,response);
                break;
            case "edit":
                showEditProduct(request,response);
                break;
            default:
                showProduct(request,response);
                break;
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("listEdit",this.product.selectProduct(id));
        request.setAttribute("category",this.category.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showSearchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchName");
        request.setAttribute("list",this.product.SearchName(name));
        request.setAttribute("category",this.category.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("category",category.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.product.delete(id);
        response.sendRedirect("/products");
//        List<Product> list = this.product.SelectAll();
//        request.setAttribute("list",list);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
//        requestDispatcher.forward(request,response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = this.product.SelectAll();
        request.setAttribute("list",list);
        request.setAttribute("category",this.category.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request,response);
    }
}
