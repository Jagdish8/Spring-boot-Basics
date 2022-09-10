package com.Jagdish.error;

import com.Jagdish.enitity.errorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

// this is the class that handles what response has to be sent when exception occurs
@ControllerAdvice
@ResponseStatus
public class restResponseEntityExceptionHandler extends ResponseStatusExceptionHandler {

    @ExceptionHandler(departmentNotFoundException.class)
    public ResponseEntity<errorMessage> departmentNotFountException(departmentNotFoundException exception, WebRequest request){
        errorMessage message = new errorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
