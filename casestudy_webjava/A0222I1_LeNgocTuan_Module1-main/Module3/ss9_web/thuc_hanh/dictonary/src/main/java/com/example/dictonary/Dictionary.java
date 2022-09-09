package com.example.dictonary;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "translate", value = "/translate")
public class Dictionary extends HttpServlet {
    private Map<String, String> map;

    public void init() {
        map = new TreeMap<>();
        map.put("Hello", "Xin Chao");
        map.put("Dog", "Cho");
        map.put("Cat", "Meo");
        map.put("Fish", "Ca");
        map.put("Bird", "Chim");
        map.put("Whale", "Ca Voi");
        map.put("Pig", "Heo");
    }

    public String searchText(String str, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(str)) return entry.getValue();
        }
        return "Not Found";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String txtSearch = request.getParameter("txtSearch");
        String ans = searchText(txtSearch, map);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Text input " + txtSearch.toUpperCase() + " have mean is " + ans.toUpperCase() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}