package com.example.demo.Advice;

import com.example.demo.Exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataMejaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String DataMejaNotFoundHandler(IdNotFoundException ex) {
        return ex.getMessage();
    }
}