package com.example.spring.rest.exception.handling;

import lombok.Value;

@Value
public class StockError {
    String code;
    String message;

}
