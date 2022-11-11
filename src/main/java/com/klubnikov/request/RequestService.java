package com.klubnikov.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestService {

    public static final String ADD_REQUEST_TO_DB = "insert into requests(id, service, price)\n" +
            "VALUES (?, ?, ?)";


    public static void addRequestToDb(Request request, Connection connection) {

        int id = request.getId();
        String service = request.getService();
        double price = request.getPrice();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_REQUEST_TO_DB);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, service);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

