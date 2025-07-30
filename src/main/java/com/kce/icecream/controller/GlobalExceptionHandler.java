package com.kce.icecream.controller;

import com.kce.icecream.entity.Flavor;
import com.kce.icecream.model.ErrorDetails;
import com.kce.icecream.utils.FlavorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(new Date(), request.getDescription(false), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlavorNotFoundException.class)
    public ResponseEntity<?> handleFlavorNotFoundException(Exception ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(new Date(), request.getDescription(false), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }
}