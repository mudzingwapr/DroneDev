package com.enumDemo.enumDemo.exceptions;

import com.enumDemo.enumDemo.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException resourceNotFoundException){
     String message= resourceNotFoundException.getMessage();
     ApiResponse apiResponse= new ApiResponse(message, Boolean.FALSE);
     return  new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

 }
}
