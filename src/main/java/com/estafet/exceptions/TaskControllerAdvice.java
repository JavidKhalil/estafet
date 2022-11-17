package com.estafet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TaskControllerAdvice {

    @ResponseBody
    @ExceptionHandler(TaskProceedingGenericException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String defaultHandler(Exception exception){
      return exception.getMessage();
    }
}
