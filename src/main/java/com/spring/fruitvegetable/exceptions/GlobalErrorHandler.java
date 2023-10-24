package com.spring.fruitvegetable.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException studentException) {
        FruitErrorResponse studentErrorResponse = new FruitErrorResponse(studentException.getMessage());
        return new ResponseEntity<>(studentErrorResponse, studentException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception) {
        List errorList = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    Map<String, String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorList);
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(Exception exception) {
        FruitErrorResponse studentErrorResponse = new FruitErrorResponse(exception.getMessage());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
