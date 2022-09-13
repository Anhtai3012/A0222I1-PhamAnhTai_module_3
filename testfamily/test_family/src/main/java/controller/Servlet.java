package controller;

import lombok.SneakyThrows;
import models.HouseHold;
import models.People;
import service.IHouseService;
import service.IPeopleService;
import service.impl.HouseHoldService;
import service.impl.PeopleService;
import utils.InputData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "Servlet", urlPatterns = "/household")
public class Servlet extends HttpServlet {
    IHouseService<HouseHold> iHouseService = new HouseHoldService();
    IPeopleService<People> peopleService = new PeopleService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "edit": {
                editHouse(request, response);
                break;
            }
        }
    }

    private void editHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = (request.getParameter("id"));
        Map<String, String> mapError = iHouseService.update(InputData.createHouseHoldByRequest(request), id);
        if (mapError.isEmpty()) {
            request.setAttribute("message", "Edit Success!!!");
            editHouseFrom(request, response);
            return;
        }
        request.setAttribute("message", "Edit Fail !!!");
        request.setAttribute("error", mapError);
        editHouseFrom(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "display": {
                displayHouse(request, response);
                break;
            }
            case "edit": {
                editHouseFrom(request, response);
                break;
            }
            case "info": {
                infoHouseById(request, response);
                break;
            }
        }
    }

    private void infoHouseById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<People> list = peopleService.findAllByIdHouse(id);
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/infoHouse.jsp").forward(request, response);
    }

    private void editHouseFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("produce", iHouseService.findById(id));
        request.getRequestDispatcher("views/form.jsp").forward(request, response);
    }

    private void displayHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int max_page = iHouseService.countAmountFindAll();
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        request.setAttribute("max_page", max_page);
        request.setAttribute("list", iHouseService.findAll(offset));
        request.getRequestDispatcher("views/home.jsp").forward(request, response);
    }
}
