package com.klubnikov.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/requests")
public class RequestServlet extends HttpServlet {

    private Request request;

    public Request getRequest() {
        return request;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String service = req.getParameter("service");
        String price = req.getParameter("price");

        int requestId = 0;
        String requestService = null;
        double requestPrice = 0.0;

        Map<String, String> errors = new HashMap<>();

        try {
            requestId = Integer.parseInt(id);
        } catch (NumberFormatException | NullPointerException e) {
            errors.put("id", "Id is not an Integer!!");
        }

        if (service.length() == 0) {
            errors.put("service", "Request shouldn't be empty!!");
        } else {
            requestService = service;
        }

        try {
            requestPrice = Double.parseDouble(price);
        } catch (NumberFormatException | NullPointerException e) {
            errors.put("price", "Price is not a double!!");
        }

        if (errors.size() == 0) {
            Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
            request = new Request(requestId, requestService, requestPrice);
            RequestService.addRequestToDb(request, connection);
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("save-request.jsp").forward(req, resp);
        }

    }
}
