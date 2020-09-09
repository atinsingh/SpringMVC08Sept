package io.pragra.learning.mvc.controllers;

import io.pragra.learning.mvc.domain.ErrorResponse;
import io.pragra.learning.mvc.exceptions.StudentNotFoundExceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleBadRequest( MethodArgumentTypeMismatchException ex) {
          return ResponseEntity.status(
                  HttpStatus.BAD_REQUEST)
                  .body(new ErrorResponse("PR002", ex.getMessage(), "AP02"));
    }

    @ExceptionHandler(StudentNotFoundExceptions.class)
    public ResponseEntity<?> handleNotFound(StudentNotFoundExceptions ex){
        return  ResponseEntity.status(404).body(new ErrorResponse("PR002", ex.getMessage(), "AP02"));
    }

}
