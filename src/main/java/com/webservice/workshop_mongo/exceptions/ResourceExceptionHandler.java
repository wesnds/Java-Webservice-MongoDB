package com.webservice.workshop_mongo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardErr = new StandardError(System.currentTimeMillis(), status.value(), "Object not found!", e.getMessage(), req.getRequestURI());

        return ResponseEntity.status(status).body(standardErr);
    }

//    @ExceptionHandler(DatabaseException.class)
//    public ResponseEntity<StandardError> dbException(DatabaseException e, HttpServletRequest req){
//        String error = "Database error!";
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        StandardError standardErr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
//
//        return ResponseEntity.status(status).body(standardErr);
//    }
}
