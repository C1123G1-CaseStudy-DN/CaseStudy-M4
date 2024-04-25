package com.example.blog.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CusExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String showErrorPage() {
        return "errorPage";
    }
}
