package com.example.lesson_06.spring.mvc.controller.exception.handling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ConcreteExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public String handleIllegalStateException(Exception exc) {
        return "Error occurred: " + exc.getMessage();
    }
}
