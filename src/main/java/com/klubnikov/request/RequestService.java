package com.klubnikov.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestService {

    public static final String ADD_REQUEST_TO_DB = "insert into requests(id, service, price)\n" +
            "VALUES (?, ?, ?)";


    public static void addRequestToDb(Request request, Connection connection) {

        int requestId = request.getId();
        String requestService = request.getService();
        double requestPrice = request.getPrice();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_REQUEST_TO_DB);
            preparedStatement.setInt(1, requestId);
            preparedStatement.setString(2, requestService);
            preparedStatement.setDouble(3, requestPrice);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

