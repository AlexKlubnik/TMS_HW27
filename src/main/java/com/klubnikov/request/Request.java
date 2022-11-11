package com.klubnikov.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private int id;
    private String service;
    private double price;

}
