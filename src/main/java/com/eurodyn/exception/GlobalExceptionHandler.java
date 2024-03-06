package com.eurodyn.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NominationException.class)
    public ResponseEntity<String> handleValidationException(NominationException ex) {
        return ResponseEntity.badRequest().body("Nomination controller error: " + ex.getLocalizedMessage());
    }
}
