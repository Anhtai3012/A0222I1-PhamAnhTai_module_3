package product.mvc.controller;

import product.mvc.models.Produce;
import product.mvc.service.impl.ProduceService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/list")
public class HelloServlet extends HttpServlet {
    private static final ProduceService produceService = new ProduceService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayList";
        }
        switch (action) {
            case "create":
                displayCreateForm(request, response);
                break;
            case "edit":
                displayEditForm(request, response);
                break;
            case "delete":
                displayDeleteForm(request, response);
                break;
            case "search":
                displaySearchForm(request, response);
                break;
            case "view":
                displayProduceSelect(request, response);
                break;
            default:
                displayListProduce(request, response);
                break;
        }
    }

    private void displaySearchForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("produce/Search.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayListProduce(HttpServletRequest request, HttpServletResponse response) {
        List<Produce> list = produceService.mapToList();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("produce/ShowList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayProduceSelect(HttpServletRequest request, HttpServletResponse response) {
        int idProduce = Integer.parseInt(request.getParameter("id"));
        Produce produce = produceService.searchById(idProduce);
        try {
            request.setAttribute("produce", produce);
            request.getRequestDispatcher("produce/DisplayInfoById.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idProduce = Integer.parseInt(request.getParameter("id"));
        Produce produce = produceService.searchById(idProduce);
        try {
            request.setAttribute("produce", produce);
            request.getRequestDispatcher("produce/Delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        int idProduce = Integer.parseInt(request.getParameter("id"));
        Produce produce = produceService.searchById(idProduce);
        try {
            request.setAttribute("produce", produce);
            request.getRequestDispatcher("produce/Edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("produce/AddNew.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayList";
        }
        switch (action) {
            case "create":
                createProduce(request, response);
                break;
            case "edit":
                editProduce(request, response);
                break;
            case "delete":
                deleteProduce(request, response);
                break;
            case "search":
                searchProduce(request, response);
                break;
        }
    }

    private void createProduce(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String nameProduce = request.getParameter("nameProduce");
        String price = request.getParameter("price");
        String other = request.getParameter("other");
        String manufacturer = request.getParameter("manufacturer");

        produceService.addNew(new Produce(Integer.parseInt(id), nameProduce, Integer.parseInt(price), other, manufacturer));
        RequestDispatcher dispatcher = request.getRequestDispatcher("produce/AddNew.jsp");
        request.setAttribute("message", "New produce was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editProduce(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameProduce");
        int price = Integer.parseInt(request.getParameter("price"));
        String other = request.getParameter("other");
        String manufacturer = request.getParameter("manufacturer");
        Produce produce = produceService.editProduceById(id, name, price, other, manufacturer);

        try {
            request.setAttribute("produce", produce);
            request.setAttribute("message", "accept");
            request.getRequestDispatcher("produce/Edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteProduce(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            produceService.removeProduceById(id);
            List<Produce> list = produceService.mapToList();
            try {
                request.setAttribute("list", list);
                request.getRequestDispatcher("produce/ShowList.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void searchProduce(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameSearch");
        Produce produce = produceService.searchByName(name);
        request.setAttribute("result", produce);
        request.setAttribute("name", name);
        request.setAttribute("find", "true");
        RequestDispatcher dispatcher = request.getRequestDispatcher("produce/Search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void destroy() {
    }
}