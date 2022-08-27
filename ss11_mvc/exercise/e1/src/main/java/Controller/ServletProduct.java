package Controller;

import Model.Product;
import Service.IProductService;
import Service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProduct", urlPatterns = {"/products"})
public class ServletProduct extends HttpServlet {
    private IProductService productService = new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "search":
                SearchName(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
        }
    }

    private void SearchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("search");
    List<Product> products = this.productService.searchName(name);
        RequestDispatcher requestDispatcher;
        if (products == null){
            requestDispatcher = request.getRequestDispatcher("view/error.jsp");}
        else {
            requestDispatcher = request.getRequestDispatcher("view/list.jsp");
            request.setAttribute("products",products);
        }
        requestDispatcher.forward(request,response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=  Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String brand = request.getParameter("brand");
        Product product = this.productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("view/error.jsp");
        }else {
            product.setName(name);
            product.setPrice(price);
            product.setDescribe(describe);
            product.setBrand(brand);
            this.productService.update(id,product);
            response.sendRedirect("products");
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String brand = request.getParameter("brand");
        this.productService.save(new Product(id,name,price,describe,brand));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        request.setAttribute("message","Create was Product");
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
                showCreateProduct(request,response);
                break;
            case "delete":
                showDeleteProduct(request,response);
                break;
            case "edit":
                showEditProduct(request,response);
                break;
            case "view":
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher =request.getRequestDispatcher("view/error.jsp");
        }else {
            this.productService.remove(id);
        }
        response.sendRedirect("/products");
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher = request.getRequestDispatcher("view/error.jsp");
        }else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
