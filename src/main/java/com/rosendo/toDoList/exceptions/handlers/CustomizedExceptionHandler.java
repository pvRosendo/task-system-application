package com.rosendo.toDoList.exceptions.handlers;

import com.rosendo.toDoList.exceptions.ExceptionsResponse;
import com.rosendo.toDoList.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionsResponse> handleNotFoundExceptions(Exception exception, WebRequest request){
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionsResponse, HttpStatus.NOT_FOUND);
    }

}
