package com.estafet.exceptions;

import org.springframework.stereotype.Component;

@Component
public class TaskProceedingGenericException extends Exception{
    public TaskProceedingGenericException(){
    }

    public TaskProceedingGenericException(String message){
        super(message);
    }
}
