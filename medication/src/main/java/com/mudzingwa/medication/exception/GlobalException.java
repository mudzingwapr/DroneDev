package com.mudzingwa.medication.exception;

import com.mudzingwa.medication.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resource(ResourceNotFoundException re){
        String message= re.getMessage();
        ApiResponse apiResponse= new ApiResponse(message,Boolean.FALSE);
        return  new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
