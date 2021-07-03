package com.example.spring.rest.exception.handling;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<StockError> handleException(IllegalStateException exception) {
        //return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(new StockError("00102", exception.getMessage()));
        return ResponseEntity.badRequest().body(new StockError("00102", exception.getMessage()));
    }
}
