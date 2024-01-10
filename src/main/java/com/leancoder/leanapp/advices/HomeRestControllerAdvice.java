package com.leancoder.leanapp.advices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class HomeRestControllerAdvice {
    /* @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMissingRequestBody(HttpMessageNotReadableException ex) {
        System.out.println(ex.getMessage().split(":")[0]);
        if (ex.getMessage().split(":")[0].equals("Required request body is missing")) {
            Map<String, Object> body = new HashMap<>();
            body.put("status", 400);
            body.put("message", ex.getMessage());
            return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    } */
}
